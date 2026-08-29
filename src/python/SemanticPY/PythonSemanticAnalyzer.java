package python.SemanticPY;

import python.ASTpy.*;
import python.SemanticPY.PythonScope.SymbolKind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * محلل دلالي مستقل لشجرة AST الخاصة ببايثون (PYProgramNode).
 *
 * قيود مقصودة (المرحلة 1 فقط، بالاتفاق):
 * - لا يعدّل python.SymbolTable.SymbolTable ولا FlaskVisitor إطلاقاً.
 * - يعمل بعد اكتمال بناء AST بالكامل (يُستدعى عبر analyze(PYProgramNode))،
 *   وليس أثناء البناء.
 * - لا يوجد accept()/Visitor interface جاهز على PYASTNode (خلافاً لـ ASTHCJ)،
 *   لذلك التنقل هنا يدوي عبر instanceof، بنفس نمط FlaskContextExtractor
 *   الموجود مسبقاً في المشروع - وليس نمطاً جديداً مخترعاً.
 * - Type Error / Type Mismatch محدودان جداً وواضحان بنيوياً فقط (بدون Type System
 *   كامل)، بالاتفاق الصريح على عدم اختراع فحوصات غير مطلوبة لبايثون.
 */
public class PythonSemanticAnalyzer {

    public static class PythonSemanticError {
        private final String errorType;
        private final String message;
        private final String variableName;
        private final int line;

        public PythonSemanticError(String errorType, String message, String variableName, int line) {
            this.errorType = errorType;
            this.message = message;
            this.variableName = variableName;
            this.line = line;
        }

        public String getErrorType() { return errorType; }
        public String getMessage() { return message; }
        public String getVariableName() { return variableName; }
        public int getLine() { return line; }

        @Override
        public String toString() {
            return "[" + errorType + "] Line " + line +
                    (variableName != null ? " - variable: " + variableName : "") +
                    " -> " + message;
        }
    }

    // أسماء بايثون المعروفة (builtins / dunders شائعة) التي لا تُعتبر Undefined
    // حتى لو لم تُعرَّف أو تُستورد صراحة داخل الملف نفسه.
    private static final Set<String> KNOWN_BUILTINS = new HashSet<>(Arrays.asList(
            "__name__", "__file__", "__doc__",
            "len", "print", "str", "int", "float", "bool",
            "list", "dict", "tuple", "set", "range",
            "enumerate", "zip", "min", "max", "sum", "sorted",
            "isinstance", "type", "open", "input", "id", "dir", "super", "object"
    ));

    private final List<PythonSemanticError> errors = new ArrayList<>();

    // سجل عام: كل اسم أُسنِد/أُعلن محلياً داخل أي دالة في الملف، يُستخدم فقط
    // لتمييز "Scope Error" (المتغير موجود لكن خارج نطاقه) عن "Undefined Variable"
    // (المتغير غير موجود إطلاقاً في أي مكان).
    private final Set<String> namesDeclaredInsideSomeFunction = new HashSet<>();

    // سجل الدوال المعرَّفة محلياً في نفس الملف، يُستخدم فقط لفحص Type Mismatch
    // المحدود (عدد المعاملات الموجبة).
    private final Map<String, PYFunctionNode> localFunctions = new HashMap<>();

    public List<PythonSemanticError> getErrors() {
        return errors;
    }

    public int getErrorCount() {
        return errors.size();
    }

    public void analyze(PYProgramNode program) {
        errors.clear();
        namesDeclaredInsideSomeFunction.clear();
        localFunctions.clear();

        if (program == null || program.getStatements() == null) {
            return;
        }

        // تمريرة تحضيرية: لا تُنتج أخطاء، فقط تبني سجل الدوال المحلية + الأسماء
        // المُعلنة داخل أي دالة، حتى يعمل تمييز Scope Error بشكل صحيح بغض النظر
        // عن ترتيب الدوال نصياً في الملف.
        collectFunctionsAndLocalNames(program.getStatements());

        PythonScope globalScope = new PythonScope();
        for (PYStatementNode stmt : program.getStatements()) {
            visitStatement(stmt, globalScope);
        }
    }

    // ============================================================
    // تمريرة تحضيرية
    // ============================================================

    private void collectFunctionsAndLocalNames(List<PYStatementNode> statements) {
        if (statements == null) return;
        for (PYStatementNode stmt : statements) {
            if (stmt instanceof PYFunctionNode func) {
                localFunctions.put(func.getFunctionName(), func);
                collectLocalNamesInFunction(func);
            }
        }
    }

    private void collectLocalNamesInFunction(PYFunctionNode func) {
        if (func.getParameters() != null) {
            for (PYIdentifierNode p : func.getParameters()) {
                namesDeclaredInsideSomeFunction.add(p.getName());
            }
        }
        collectFromBlock(func.getBody());
    }

    private void collectFromBlock(PYBlockSuiteNode block) {
        if (block == null || block.getStatements() == null) return;
        for (PYStatementNode s : block.getStatements()) {
            collectLocalNamesInStatement(s);
        }
    }

    private void collectLocalNamesInStatement(PYStatementNode stmt) {
        if (stmt == null) return;

        if (stmt instanceof PYAssignmentNode assign) {
            if (assign.getTarget() instanceof PYIdentifierNode id) {
                namesDeclaredInsideSomeFunction.add(id.getName());
            }

        } else if (stmt instanceof PYForNode forNode) {
            if (forNode.getTarget() != null) {
                namesDeclaredInsideSomeFunction.add(forNode.getTarget().getName());
            }
            collectFromBlock(forNode.getBody());

        } else if (stmt instanceof PYIfNode ifNode) {
            collectFromBlock(ifNode.getIfBody());
            List<PYBlockSuiteNode> elifBodies = ifNode.getElifBodies();
            if (elifBodies != null) {
                for (PYBlockSuiteNode b : elifBodies) collectFromBlock(b);
            }
            collectFromBlock(ifNode.getElseBody());

        } else if (stmt instanceof PYFunctionNode nested) {
            // دالة متداخلة: نتابع تجميع أسمائها المحلية أيضاً بشكل متكرر.
            // ملاحظة: لا نُسجّلها في localFunctions (تلك مخصصة للدوال على
            // المستوى الأعلى فقط لفحص Type Mismatch البسيط).
            collectLocalNamesInFunction(nested);
        }
        // PYReturnNode / PYExprStmtNode / PYBreakNode / PYGlobalNode / PYImportNode:
        // لا تُعرِّف أسماء "محلية داخل دالة" بالمعنى المقصود هنا.
    }

    // ============================================================
    // زيارة الجمل (Statements)
    // ============================================================

    private void visitStatement(PYStatementNode stmt, PythonScope scope) {
        if (stmt == null) return;

        if (stmt instanceof PYAssignmentNode assign) {
            visitExpression(assign.getValue(), scope);
            boolean isLiteral = isLiteralExpression(assign.getValue());
            if (assign.getTarget() instanceof PYIdentifierNode id) {
                scope.declare(id.getName(), SymbolKind.VARIABLE, assign.getLine(), isLiteral);
            } else if (assign.getTarget() != null) {
                visitExpression(assign.getTarget(), scope);
            }

        } else if (stmt instanceof PYFunctionNode func) {
            // تسجيل اسم الدالة نفسها في النطاق المحيط (وليس نطاقها الخاص)،
            // حتى يمكن حلّه لاحقاً عند استدعائها بالاسم من مكان آخر في الملف.
            // (فجوة اكتُشفت أثناء تحضير اختبارات Type Mismatch: test1.txt لم يكن
            // يستدعي أياً من دواله بالاسم مباشرة، لذلك لم تظهر هذه الفجوة سابقاً)
            scope.declare(func.getFunctionName(), SymbolKind.FUNCTION, func.getLine(), false);

            // الديكوريتورز تُفحص ضمن النطاق المحيط (وليس نطاق الدالة نفسها)،
            // لأنها تُقيَّم فعلياً في السياق الذي عُرِّفت فيه الدالة.
            if (func.getDecorators() != null) {
                for (PYDecoratorNode dec : func.getDecorators()) {
                    visitExpression(dec.getCallee(), scope);
                    if (dec.getArguments() != null) {
                        for (PYArgumentNode arg : dec.getArguments()) {
                            visitArgument(arg, scope);
                        }
                    }
                }
            }

            PythonScope functionScope = new PythonScope(scope, func.getFunctionName());
            if (func.getParameters() != null) {
                for (PYIdentifierNode param : func.getParameters()) {
                    functionScope.declare(param.getName(), SymbolKind.PARAMETER, param.getLine(), false);
                }
            }
            visitBlockInSameScope(func.getBody(), functionScope);

        } else if (stmt instanceof PYForNode forNode) {
            visitExpression(forNode.getIterable(), scope);
            if (forNode.getTarget() != null) {
                scope.declare(forNode.getTarget().getName(), SymbolKind.ITERATOR, forNode.getTarget().getLine(), false);
            }
            // نفس النطاق: for لا تفتح نطاقاً جديداً في بايثون
            visitBlockInSameScope(forNode.getBody(), scope);

        } else if (stmt instanceof PYIfNode ifNode) {
            visitExpression(ifNode.getIfCondition(), scope);
            visitBlockInSameScope(ifNode.getIfBody(), scope);

            List<PYExpressionNode> elifConds = ifNode.getElifConditions();
            List<PYBlockSuiteNode> elifBodies = ifNode.getElifBodies();
            if (elifConds != null) {
                for (int i = 0; i < elifConds.size(); i++) {
                    visitExpression(elifConds.get(i), scope);
                    visitBlockInSameScope(elifBodies.get(i), scope);
                }
            }
            visitBlockInSameScope(ifNode.getElseBody(), scope);

        } else if (stmt instanceof PYReturnNode ret) {
            if (ret.getValue() != null) visitExpression(ret.getValue(), scope);

        } else if (stmt instanceof PYExprStmtNode exprStmt) {
            visitExpression(exprStmt.getExpression(), scope);

        } else if (stmt instanceof PYBlockSuiteNode block) {
            visitBlockInSameScope(block, scope);

        } else if (stmt instanceof PYImportNode imp) {
            if (imp.isFromImport() && imp.getImportedItems() != null) {
                for (PYIdentifierNode item : imp.getImportedItems()) {
                    scope.declare(item.getName(), SymbolKind.IMPORT, item.getLine(), false);
                }
            } else if (imp.getModuleName() != null) {
                scope.declare(imp.getModuleName().getName(), SymbolKind.IMPORT, imp.getModuleName().getLine(), false);
            }

        } else if (stmt instanceof PYGlobalNode globalNode) {
            // تبسيط مقصود: "global x" تُعلن الاسم في أعلى نطاق (Global) مباشرة
            // إن لم يكن معرَّفاً هناك أصلاً، لضمان عدم ظهور Undefined/Scope Error
            // زائفة لهذه الحالة. لا يوجد اختبار حالي يعتمد على دقة هذا السلوك أكثر
            // من ذلك.
            PythonScope root = scope;
            while (root.getParent() != null) root = root.getParent();
            if (globalNode.getVariableNames() != null) {
                for (PYIdentifierNode id : globalNode.getVariableNames()) {
                    if (root.resolve(id.getName()) == null) {
                        root.declare(id.getName(), SymbolKind.VARIABLE, id.getLine(), false);
                    }
                }
            }
        }
        // PYBreakNode: لا شيء لفحصه
    }

    private void visitBlockInSameScope(PYBlockSuiteNode block, PythonScope scope) {
        if (block == null || block.getStatements() == null) return;
        for (PYStatementNode s : block.getStatements()) {
            visitStatement(s, scope);
        }
    }

    private boolean isLiteralExpression(PYExpressionNode expr) {
        return expr instanceof PYLiteralNode || expr instanceof PYListNode || expr instanceof PYDictNode;
    }

    // ============================================================
    // زيارة التعبيرات (Expressions)
    // ============================================================

    private void visitExpression(PYExpressionNode expr, PythonScope scope) {
        if (expr == null) return;

        if (expr instanceof PYIdentifierNode id) {
            checkIdentifierUsage(id, scope);

        } else if (expr instanceof PYAttributeExprNode attr) {
            visitExpression(attr.getObject(), scope);

        } else if (expr instanceof PYIndexExprNode idx) {
            visitExpression(idx.getTarget(), scope);
            visitExpression(idx.getIndex(), scope);

        } else if (expr instanceof PYCallExprNode call) {
            visitExpression(call.getCallee(), scope);
            if (call.getArguments() != null) {
                for (PYArgumentNode arg : call.getArguments()) {
                    visitArgument(arg, scope);
                }
            }
            checkCallableAndArity(call, scope);

        } else if (expr instanceof PYBinaryExprNode bin) {
            visitExpression(bin.getLeft(), scope);
            visitExpression(bin.getRight(), scope);

        } else if (expr instanceof PYListNode list) {
            if (list.getElements() != null) {
                for (PYExpressionNode e : list.getElements()) {
                    visitExpression(e, scope);
                }
            }
        }
        // PYDictNode: ملاحظة معروفة - PYDictNode لا يوفر حالياً getter لقائمة
        // entries (فقط addEntry أثناء البناء)، لذلك لا يمكن لهذا الـ Visitor
        // المنفصل (حزمة مختلفة) الوصول لمحتوى القاموس للتحقق من المتغيرات بداخله.
        // هذا لا يسبب false positives، فقط يعني أن أي متغير غير معرَّف داخل
        // قيمة ضمن dict literal لن يُكتشف حالياً. أحتاج موافقتك لإضافة getter
        // بسيط (سطر واحد) إلى PYDictNode.java إن أردنا تغطية هذه الحالة لاحقاً.
        // PYLiteralNode (String/Integer/Float/Boolean/None): لا شيء لفحصه.
    }

    private void visitArgument(PYArgumentNode arg, PythonScope scope) {
        if (arg instanceof PYPositionalArgNode pos) {
            visitExpression(pos.getValue(), scope);
        } else if (arg instanceof PYKeyWordArgNode kw) {
            // المفتاح اسم معامل (وليس مرجع متغير) فلا يُفحص، فقط القيمة
            visitExpression(kw.getValue(), scope);
        }
    }

    private void checkIdentifierUsage(PYIdentifierNode id, PythonScope scope) {
        String name = id.getName();
        int line = id.getLine();

        if (KNOWN_BUILTINS.contains(name)) return;

        PythonScope.PythonSymbol found = scope.resolve(name);
        if (found != null) return;

        if (namesDeclaredInsideSomeFunction.contains(name)) {
            errors.add(new PythonSemanticError(
                    "Scope Error",
                    "المتغير '" + name + "' معرَّف داخل دالة أخرى ولا يمكن استخدامه هنا (خارج نطاقه).",
                    name, line
            ));
        } else {
            errors.add(new PythonSemanticError(
                    "Undefined Variable",
                    "المتغير '" + name + "' غير معرَّف في أي نطاق متاح.",
                    name, line
            ));
        }
    }

    // فحوصات محدودة جداً وواضحة بنيوياً فقط - بدون Type System كامل
    private void checkCallableAndArity(PYCallExprNode call, PythonScope scope) {
        if (!(call.getCallee() instanceof PYIdentifierNode calleeId)) return;

        String name = calleeId.getName();
        PythonScope.PythonSymbol sym = scope.resolve(name);

        // Type Error محدود: استدعاء متغير نعرف أنه أُسنِد إليه قيمة حرفية
        // (وليس دالة) كأنه دالة.
        if (sym != null && sym.getKind() == SymbolKind.VARIABLE && sym.isLiteralValue()) {
            errors.add(new PythonSemanticError(
                    "Type Error",
                    "المتغير '" + name + "' تم استدعاؤه كدالة، لكنه أُسنِد إليه قيمة غير قابلة للاستدعاء.",
                    name, call.getLine()
            ));
            return;
        }

        // Type Mismatch محدود: عدد المعاملات الموجبة لا يطابق عدد المعاملات
        // المُعلَنة لدالة معرَّفة محلياً في نفس الملف (فقط عند عدم وجود
        // keyword arguments لتفادي false positives).
        PYFunctionNode localFunc = localFunctions.get(name);
        if (localFunc != null && call.getArguments() != null) {
            boolean hasKeywordArgs = false;
            for (PYArgumentNode a : call.getArguments()) {
                if (a instanceof PYKeyWordArgNode) { hasKeywordArgs = true; break; }
            }
            if (!hasKeywordArgs) {
                int given = call.getArguments().size();
                int expected = localFunc.getParameters() != null ? localFunc.getParameters().size() : 0;
                if (given != expected) {
                    errors.add(new PythonSemanticError(
                            "Type Mismatch",
                            "الدالة '" + name + "' تتوقع " + expected + " معامل/معاملات، لكن تم تمرير " + given + ".",
                            name, call.getLine()
                    ));
                }
            }
        }
    }

    public void printReport() {
        System.out.println("\n==================================================");
        System.out.println("PYTHON SEMANTIC ANALYSIS REPORT");
        System.out.println("==================================================");
        if (errors.isEmpty()) {
            System.out.println("No semantic errors found.");
        } else {
            System.out.println(errors.size() + " semantic error(s) found:");
            for (PythonSemanticError e : errors) {
                System.out.println("  " + e);
            }
        }
    }
}
