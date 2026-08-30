package VisitorHCJ;

import ASTHCJ.*;
import SymbolTableHCJ.*;
import java.util.*;

public class SemanticAnalyzerVisitor implements AstVisitor<Void> {

    @FunctionalInterface
    public interface JinjaFunctionValidator {
        void validate(J_JinjaFunctionCall node);
    }

    private final Map<String, JinjaFunctionValidator> functionRegistry = new HashMap<>();
    private List<String> flaskFunctions;
    private SymbolTable currentScope = new SymbolTable();
    private final List<String> semanticErrors = new ArrayList<>();
    private final List<String> pythonFlaskVariables;
    private final Set<String> htmlUsedIds = new HashSet<>();

    private final Map<String, String> variableTypes = new HashMap<>();
    private final Map<String, List<String>> classProperties = new HashMap<>();
    private final Map<String, List<String>> flaskRoutes = new HashMap<>();
    // أضيفي هذه الدالة داخل كلاس SemanticAnalyzerVisitor
    public int getErrorCount() {
        // إذا كانت الأخطاء مخزنة في List اسمه errors
        return this.semanticErrors.size();

        // ملاحظة: إذا كان اسم القائمة لديكِ مختلفاً (مثلاً errorList)، غيريها إلى:
        // return this.errorList.size();
    }

    // إضافة ضرورية لكتابة محتوى semantic_report.txt الفعلي (وليس العدد فقط):
    // getErrorCount() و printErrors() لا يكفيان لأن الأول يعيد عدداً فقط والثاني
    // يطبع في الـ console فقط وليس نصاً قابلاً للكتابة في ملف. لا تغيير على أي
    // منطق موجود - فقط كشف القائمة الموجودة أصلاً.
    public List<String> getErrors() {
        return this.semanticErrors;
    }

    public SemanticAnalyzerVisitor(List<String> pythonFlaskVariables, List<String> flaskFunctions) {
        this.pythonFlaskVariables = pythonFlaskVariables != null ? pythonFlaskVariables : new ArrayList<>();
        this.flaskFunctions = flaskFunctions != null ? flaskFunctions : new ArrayList<>();
        initializeTypeSystem();
        setupRegistry();
    }

    public void setupRegistry() {
        functionRegistry.put("url_for", this::validateUrlFor);


        if (flaskFunctions != null) {
            for (String funcName : flaskFunctions) {
                // 🎯 إضافة أي دالة تم استخراجها ديناميكياً من البايثون إلى قائمة المسارات تلقائياً
                if (!flaskRoutes.containsKey(funcName)) {
                    flaskRoutes.put(funcName, Collections.emptyList());
                }

                if (!functionRegistry.containsKey(funcName)) {
                    functionRegistry.put(funcName, (node) -> {
                        System.out.println("ℹ️ [تحليل دلالي] تم التعرف ديناميكياً على دالة: " + funcName);
                    });
                }
            }
        }
    }

    private void initializeTypeSystem() {
        for (String var : pythonFlaskVariables) {
            if (var.equals("products") || var.equals("items") || var.equals("items_list")) {
                variableTypes.put(var, "List<Product>");
            } else if (var.equals("product")) {
                variableTypes.put(var, "Product");
            } else {
                variableTypes.put(var, "String");
            }
        }
        classProperties.put("Product", Arrays.asList("id", "name", "price", "image", "details"));

        // إعداد المسارات المدعومة في الباك إيند لربطها بـ url_for
        flaskRoutes.put("product_details", Arrays.asList("product_id"));
        flaskRoutes.put("delete_product", Arrays.asList("product_id"));
        flaskRoutes.put("add_product_page", Collections.emptyList());
    }

    // =========================================================================
    // 💡 ذكاء المترجم: دالة استنتاج الأنواع (Type Inference) تدعم الفلاتر الآن
    // =========================================================================
    private String inferType(AstNode node) {
        if (node == null) return "unknown";

        if (node instanceof J_JinjaNumberLiteral) return "int";
        if (node instanceof J_JinjaStringLiteral) return "string";

        if (node instanceof J_JinjaIdentifier) {
            String name = ((J_JinjaIdentifier) node).getName();
            // أولاً نتحقق من جدول الأنواع العام
            if (variableTypes.containsKey(name)) {
                return variableTypes.get(name);
            }
            String lowerName = name.toLowerCase();
            if (lowerName.contains("price") || lowerName.contains("id") || lowerName.contains("count")) return "int";
            if (lowerName.contains("name") || lowerName.contains("image") || lowerName.contains("title")) return "string";
            return "string";
        }

        if (node instanceof J_JinjaDotAccess) {
            J_JinjaDotAccess dot = (J_JinjaDotAccess) node;
            if (dot.getProperty() != null) {
                String fieldName = dot.getProperty().getName().toLowerCase();
                if (fieldName.contains("price") || fieldName.contains("id") || fieldName.contains("count")) return "int";
                if (fieldName.contains("name") || fieldName.contains("image") || fieldName.contains("title")) return "string";
            } else if (dot.getBase() != null) {
                return inferType(dot.getBase());
            }
        }

        // إذا كانت العقدة فلتراً، نستنتج النوع بناءً على وظيفة الفلتر
        if (node instanceof J_JinjaFilterNode) {
            String filterName = ((J_JinjaFilterNode) node).getFilterName();
            if (filterName.equals("upper") || filterName.equals("lower") || filterName.equals("title")) return "string";
            if (filterName.equals("abs") || filterName.equals("round")) return "int";
            return inferType(((J_JinjaFilterNode) node).getExpression());
        }

        return "unknown";
    }

    private void reportError(int line, String message) {
        String formatted = "❌ Semantic Error [Line " + line + "]: " + message;
        if (!semanticErrors.contains(formatted)) {
            semanticErrors.add(formatted);
        }
    }

    @Override
    public Void visitJinjaIdentifier(J_JinjaIdentifier node) {
        String varName = node.getName();
        int line = node.getLineNumber();

        Symbol sym = currentScope.lookup(varName);

        if (sym == null) {
            if (!pythonFlaskVariables.contains(varName)) {
                if (varName.equals("p") || varName.equals("item") || varName.equals("product")) {
                    reportError(line, "Scope Error: Local loop variable '" + varName + "' is used outside its scope.");
                } else {
                    reportError(line, "Missing/Undefined Flask Variable: '" + varName + "' is never passed from Flask or local scope.");
                }
            }
        }
        return null;
    }

    // =========================================================================
    // 🎨 فحص الـ Dot Access والـ Filters مدمجين بناءً على قواعد البارسر الشجرية
    // =========================================================================
    @Override
    public Void visitJinjaDotAccess(J_JinjaDotAccess node) {
        if (node.getBase() != null) {
            node.getBase().accept(this);
        }

        // التحقق من صحة الخاصية (Property) الملحقة بالكلاس
        if (node.getBase() instanceof J_JinjaIdentifier && node.getProperty() != null) {
            String objName = ((J_JinjaIdentifier) node.getBase()).getName();
            String fieldName = node.getProperty().getName();
            String objType = variableTypes.getOrDefault(objName, "Unknown");

            if (classProperties.containsKey(objType)) {
                List<String> allowedFields = classProperties.get(objType);
                if (!allowedFields.contains(fieldName)) {
                    reportError(node.getLineNumber(), "Type Mismatch Error: Property '" + fieldName
                            + "' does not exist in class structure '" + objType + "'.");
                }
            }
        }

        return null;
    }

    @Override
    public Void visitJinjaFilterNode(J_JinjaFilterNode node) {
        if (node.getExpression() != null) {
            node.getExpression().accept(this);
        }

        String filter = node.getFilterName();
        int line = node.getLineNumber();
        String inferredType = inferType(node.getExpression());

        // فحص الفلاتر النصية
        if (filter.equals("upper") || filter.equals("lower") || filter.equals("title")) {
            if (inferredType.equals("int") || inferredType.equals("float")) {
                reportError(line, "Type Mismatch: Filter '" + filter + "' is a String filter but applied to Numeric type (" + inferredType + ").");
            }
        }

        // فحص الفلاتر الرقمية
        if (filter.equals("abs") || filter.equals("round")) {
            if (inferredType.equals("string")) {
                reportError(line, "Type Mismatch: Filter '" + filter + "' is a Numeric filter but applied to String type.");
            }
        }
        return null;
    }

    @Override
    public Void visitJinjaForNode(J_JinjaForNode node) {
        if (node.getIterable() != null) {
            node.getIterable().accept(this);
            if (node.getIterable() instanceof J_JinjaIdentifier) {
                String iterName = ((J_JinjaIdentifier) node.getIterable()).getName();
                if (!pythonFlaskVariables.contains(iterName)) {
                    reportError(node.getLineNumber(), "Loop Error: Collection '" + iterName + "' is undefined in Flask context.");
                }
            }
        }

        // فتح نطاق محلي للحلقة
        currentScope = new SymbolTable(currentScope, Symbol.ScopeType.JINJA);

        if (node.getVariable() != null) {
            for (J_JinjaLoopVariable loopVar : node.getVariable()) {
                String varName = loopVar.getName();
                currentScope.addSymbol(varName, Symbol.SymbolKind.JINJA_ITERATOR, node.getLineNumber(), "Loop Iterator");
                variableTypes.put(varName, "Product"); // ربط المتغير المحلي بالكلاس المقابل له
                loopVar.accept(this);
            }
        }

        if (node.getBody() != null) {
            for (AstNode bodyNode : node.getBody()) {
                if (bodyNode != null) bodyNode.accept(this);
            }
        }

        // إغلاق النطاق لحماية وتدمير المتغيرات المحلية ومنع استخدامها في الخارج
        currentScope = currentScope.getParent();
        return null;
    }

    @Override
    public Void visitJinjaFunctionCall(J_JinjaFunctionCall node) {
        if (node.getFunctionName() != null) {
            String funcName = node.getFunctionName().getName();
            JinjaFunctionValidator validator = functionRegistry.get(funcName);

            if (validator != null) {
                validator.validate(node);
            } else {
                reportError(node.getLineNumber(), "Function Error: Unknown function '" + funcName + "' is not defined in Flask/Jinja.");
            }
        }
        return null;
    }

    private void validateUrlFor(J_JinjaFunctionCall node) {
        String routeName = "Unknown";
        if (node.getArguments() != null && !node.getArguments().isEmpty()) {
            J_JinjaExpression firstArg = node.getArguments().get(0);
            if (firstArg instanceof J_JinjaStringLiteral) {
                routeName = ((J_JinjaStringLiteral) firstArg).getValue().replace("'", "").replace("\"", "");
            }
        }

        if (!routeName.equals("Unknown") && !flaskRoutes.containsKey(routeName)) {
            reportError(node.getLineNumber(), "Route Error: Backend maps no route named '" + routeName + "'.");
        } else if (!routeName.equals("Unknown")) {
            List<String> requiredParams = flaskRoutes.get(routeName);
            List<J_JinjaKeywordArgument> passedKeywordArgs = node.getKeywordArguments();
            Set<String> passedNames = new HashSet<>();

            if (passedKeywordArgs != null) {
                for (J_JinjaKeywordArgument kw : passedKeywordArgs) {
                    if (kw.getName() != null) passedNames.add(kw.getName().getName());
                    kw.accept(this);
                }
            }

            for (String req : requiredParams) {
                if (!passedNames.contains(req)) {
                    reportError(node.getLineNumber(), "Route Param Error: Missing required parameter '" + req + "' for endpoint '" + routeName + "'.");
                }
            }
        }
    }



    @Override
    public Void visitAttributeWithValue(AttributeWithValue node) {
        if (node.getName() != null && node.getName().equalsIgnoreCase("id") && node.getValue() != null) {
            String idValue = node.getValue().toString();
            if (htmlUsedIds.contains(idValue)) {
                reportError(node.getLineNumber(), "HTML Duplicate ID Error: ID '" + idValue + "' is already defined.");
            } else {
                htmlUsedIds.add(idValue);
            }
        }
        if (node.getValue() != null) node.getValue().accept(this);
        return null;
    }

    @Override
    public Void visitHtmlDocument(HtmlDocument node) {
        if (node.getNodes() != null) {
            for (HtmlNode child : node.getNodes()) { if (child != null) child.accept(this); }
        }
        return null;
    }

    @Override
    public Void visitPairedTag(PairedTag node) {
        if (node.getAttributes() != null) {
            for (AstNode attr : node.getAttributes()) { if (attr != null) attr.accept(this); }
        }
        if (node.getChildren() != null) {
            for (AstNode child : node.getChildren()) { if (child != null) child.accept(this); }
        }
        return null;
    }

    @Override
    public Void visitSelfClosingTag(SelfClosingTag node) {
        if (node.getAttributes() != null) {
            for (AstNode attr : node.getAttributes()) { if (attr != null) attr.accept(this); }
        }
        return null;
    }

    @Override
    public Void visitCompositeAttributeValue(J_CompositeAttributeValue node) {
        if (node.getParts() != null) {
            for (AstNode part : node.getParts()) { if (part != null) part.accept(this); }
        }
        return null;
    }

    @Override
    public Void visitJinjaVariable(J_JinjaVariableNode node) {
        if (node.getExpression() != null) node.getExpression().accept(this);
        return null;
    }

    public void printErrors() {
        System.out.println("\n==================================================");
        System.out.println("🔍 STAGE 3: RUNNING PROGRAMMATIC SEMANTIC ANALYSIS");
        System.out.println("==================================================");
        if (semanticErrors.isEmpty()) {
            System.out.println("✅ Semantic Analysis completed successfully! No errors found.");
        } else {
            System.err.println("⚠️ Semantic Analysis failed with " + semanticErrors.size() + " error(s):");
            for (String err : semanticErrors) { System.err.println(err); }
        }
    }

    // =========================================================================
    // 🔩 استيفاء باقي توابع الواجهة الأساسية لمنع أخطاء الـ Compile
    // =========================================================================
    @Override public Void visitDoctype(DoctypeNode node) { return null; }
    @Override public Void visitTextContent(TextContent node) { return null; }
    @Override public Void visitBooleanAttribute(BooleanAttribute node) { return null; }
    @Override public Void visitStringValue(StringValue node) { return null; }

    // =========================================================================
    // 🎨 CSS Semantic Analysis
    // =========================================================================

    // نقطة الدخول الحقيقية لشجرة CSS - كانت مقطوعة بالكامل (stub فارغ) قبل هذا التعديل
    @Override
    public Void visitStyleContent(StyleContent node) {
        if (node.getCss() != null) node.getCss().accept(this);
        return null;
    }

    @Override
    public Void visitCssStyleSheet(CssStyleSheetNode node) {
        if (node.getRules() != null) {
            for (CssRuleNode rule : node.getRules()) {
                if (rule != null) rule.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visitCssRule(CssRuleNode node) {
        if (node.getDeclarations() != null) {
            for (CssDeclarationNode decl : node.getDeclarations()) {
                if (decl != null) decl.accept(this);
            }
        }
        return null;
    }

    @Override
    public Void visitCssDeclaration(CssDeclarationNode node) {
        checkCssDeclarationType(node);
        return null;
    }

    // أسماء properties معروفة، مبنية من الاستخدام الفعلي في ملفات المشروع + امتداد
    // معقول لأشكالها الطبيعية (نفس نمط KNOWN_BUILTINS في PythonSemanticAnalyzer)
    private static final Set<String> KNOWN_CSS_PROPERTIES = new HashSet<>(Arrays.asList(
            "font-family", "background", "background-color",
            "padding", "padding-top", "padding-bottom", "padding-left", "padding-right",
            "margin", "margin-top", "margin-bottom", "margin-left", "margin-right",
            "border-radius", "display", "gap", "width", "height",
            "text-decoration", "color", "border",
            "border-top", "border-bottom", "border-left", "border-right", "border-color",
            "cursor", "position", "top", "left", "right", "bottom",
            "font-size", "font-weight", "text-align", "text-transform", "overflow"
    ));

    // شوردهاند حقيقية تمزج أنواع قيم مختلفة معاً بشكل صحيح دلالياً (مثل border: 1px solid black)
    // لا نفرض عليها نوعاً واحداً - بناءً على ملاحظتك مباشرة
    private static final Set<String> CSS_SHORTHAND_PROPERTIES = new HashSet<>(Arrays.asList(
            "border", "border-top", "border-bottom", "border-left", "border-right", "background"
    ));

    // properties تقبل قيم "طول" (رقم/وحدة/auto) - auto تصل كـ CssKeywordValueNode
    private static final Set<String> CSS_LENGTH_PROPERTIES = new HashSet<>(Arrays.asList(
            "padding", "padding-top", "padding-bottom", "padding-left", "padding-right",
            "margin", "margin-top", "margin-bottom", "margin-left", "margin-right",
            "border-radius", "gap", "width", "height", "font-size",
            "top", "left", "right", "bottom"
    ));

    // properties تقبل قيم "لون"
    private static final Set<String> CSS_COLOR_PROPERTIES = new HashSet<>(Arrays.asList(
            "color", "background-color", "border-color"
    ));

    // properties تقبل قيماً وصفية (identifier/keyword) وليست أرقاماً أو ألواناً
    private static final Set<String> CSS_KEYWORD_LIKE_PROPERTIES = new HashSet<>(Arrays.asList(
            "font-family", "display", "text-decoration", "cursor",
            "position", "text-align", "text-transform", "overflow", "font-weight"
    ));

    private void checkCssDeclarationType(CssDeclarationNode node) {
        String property = node.getProperty();
        if (property == null) return;
        String normalized = property.trim().toLowerCase();

        if (!KNOWN_CSS_PROPERTIES.contains(normalized)) {
            reportError(node.getLineNumber(),
                    "Unknown Property: '" + property + "' is not a recognized CSS property.");
            return; // لا داعي لفحص نوع القيمة لخاصية غير معروفة أصلاً
        }

        if (CSS_SHORTHAND_PROPERTIES.contains(normalized)) {
            return; // شوردهاند: يسمح بمزيج من الأنواع، لا نفرض قيداً هنا عمداً
        }

        if (!(node.getValue() instanceof CssCompositeValueNode composite)) return;

        for (CssValueNode part : composite.getParts()) {
            if (!isAllowedPartForProperty(normalized, part)) {
                reportError(part.getLineNumber(),
                        "Type Mismatch: Property '" + property + "' does not accept a value of type "
                                + describeCssPartType(part) + ".");
            }
        }
    }

    private boolean isAllowedPartForProperty(String property, CssValueNode part) {
        if (CSS_LENGTH_PROPERTIES.contains(property)) {
            return part instanceof CssUnitValueNode
                    || part instanceof CssNumberValueNode
                    || part instanceof CssKeywordValueNode; // يغطي "auto"
        }
        if (CSS_COLOR_PROPERTIES.contains(property)) {
            return part instanceof CssColorValueNode || part instanceof CssIdentifierValueNode;
        }
        if (CSS_KEYWORD_LIKE_PROPERTIES.contains(property)) {
            return part instanceof CssIdentifierValueNode || part instanceof CssKeywordValueNode;
        }
        // property معروف لكن غير مصنَّف ضمن أي فئة أعلاه: لا نفرض قيداً (تفادياً لِـ false positives)
        return true;
    }

    private String describeCssPartType(CssValueNode part) {
        if (part instanceof CssColorValueNode) return "Color";
        if (part instanceof CssUnitValueNode) return "Unit/Length";
        if (part instanceof CssNumberValueNode) return "Number";
        if (part instanceof CssIdentifierValueNode) return "Identifier";
        if (part instanceof CssKeywordValueNode) return "Keyword";
        if (part instanceof CssFunctionValueNode) return "Function";
        return "Unknown";
    }

    // باقي عقد CSS: لا فحص إضافي مطلوب فيها حالياً (الفحص الفعلي يتم في
    // checkCssDeclarationType مباشرة عبر فحص نوع كل جزء)
    @Override public Void visitCssSelector(CssSelectorNode node) { return null; }
    @Override public Void visitCssCompositeValue(CssCompositeValueNode node) { return null; }
    @Override public Void visitCssNumberValue(CssNumberValueNode node) { return null; }
    @Override public Void visitCssUnitValue(CssUnitValueNode node) { return null; }
    @Override public Void visitCssIdentifierValue(CssIdentifierValueNode node) { return null; }
    @Override public Void visitCssKeywordValue(CssKeywordValueNode node) { return null; }
    @Override public Void visitCssColorValue(CssColorValueNode node) { return null; }
    @Override public Void visitCssFunctionValue(CssFunctionValueNode node) { return null; }
    @Override public Void visitJinjaStringLiteral(J_JinjaStringLiteral node) { return null; }
    @Override public Void visitJinjaNumberLiteral(J_JinjaNumberLiteral node) { return null; }
    @Override public Void visitJinjaKeywordArgument(J_JinjaKeywordArgument node) { if (node.getValue() != null) node.getValue().accept(this); return null; }
    @Override public Void visitJinjaIndexAccessNode(J_JinjaIndexAccessNode node) { if (node.getTarget() != null) node.getTarget().accept(this); return null; }
    @Override public Void visitJinjaLoopVariable(J_JinjaLoopVariable node) { return null; }
}
