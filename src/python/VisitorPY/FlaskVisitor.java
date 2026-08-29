package python.VisitorPY;

import python.ASTpy.*;
import python.FlaskParser;
import python.FlaskParserBaseVisitor;
import python.SymbolTable.Symbol;
import python.SymbolTable.SymbolTable;

import java.util.ArrayList;
import java.util.List;

public class FlaskVisitor extends FlaskParserBaseVisitor<PYASTNode> {

    private SymbolTable symbolTable = new SymbolTable();
    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    @Override //SYMBOL TABLE:
    public PYASTNode visitProgram(FlaskParser.ProgramContext ctx) {
        symbolTable.pushScope(Symbol.ScopeType.GLOBAL);
        PYProgramNode programNode = new PYProgramNode(ctx.getStart().getLine());

        for (FlaskParser.StmtContext stmtCtx : ctx.stmt()) {
            PYASTNode node = visit(stmtCtx);
            if (node instanceof PYStatementNode) {
                programNode.addStatement((PYStatementNode) node);
            }
        }
        symbolTable.popScope();
        return programNode;
    }

    @Override//دالة وسيطة
    public PYASTNode visitIfStatement(FlaskParser.IfStatementContext ctx) {
        return visit(ctx.ifStmt());
    }

    @Override//دالة وسيطة
    public PYASTNode visitForStatement(FlaskParser.ForStatementContext ctx) {
        return visit(ctx.forStmt());
    }

    @Override//دالة وسيطة
    public PYASTNode visitFunctionDefinition(FlaskParser.FunctionDefinitionContext ctx) {
        return visit(ctx.funcDef());
    }

    @Override//دالة وسيطة
    public PYASTNode visitDecoratedDefinition(FlaskParser.DecoratedDefinitionContext ctx) {
        return visit(ctx.decorated());
    }

    @Override//دالة وسيطة
    public PYASTNode visitSimpleStatement(FlaskParser.SimpleStatementContext ctx) {
        return visit(ctx.simpleStmt());
    }

    @Override
    public PYASTNode visitSimpleStmt(FlaskParser.SimpleStmtContext ctx) {
        return visit(ctx.smallStmt());
    }

    @Override//دالة وسيطة
    public PYASTNode visitAssignStmt(FlaskParser.AssignStmtContext ctx) {
        return visit(ctx.assignmentStmt());
    }

    @Override//دالة وسيطة
    public PYASTNode visitReturnStatement(FlaskParser.ReturnStatementContext ctx) {
        return visit(ctx.returnStmt());
    }

    @Override//دالة وسيطة
    public PYASTNode visitGlobalStatement(FlaskParser.GlobalStatementContext ctx) {
        return visit(ctx.globalStmt());
    }

    @Override//دالة وسيطة
    public PYASTNode visitFromImportStatement(FlaskParser.FromImportStatementContext ctx) {
        return visit(ctx.fromImportStmt());
    }

    @Override //دالة وسيطة
    public PYASTNode visitBreakStatement(FlaskParser.BreakStatementContext ctx) {
        return visit(ctx.breakStmt());
    }

    @Override //دالة وسيطة
    public PYASTNode visitExpressionStmt(FlaskParser.ExpressionStmtContext ctx) {
        return visit(ctx.exprStmt());
    }

    @Override//SYMBOL TABLE:
    public PYASTNode visitForStmt(FlaskParser.ForStmtContext ctx) {
        String iteratorName = ctx.PY_IDENTIFIER().getText();
        symbolTable.pushScope(Symbol.ScopeType.LOCAL);
        PYIdentifierNode targetVar = new PYIdentifierNode(ctx.getStart().getLine(), iteratorName);

        symbolTable.addSymbol(
                iteratorName,
                Symbol.SymbolKind.ITERATOR,
                ctx.getStart().getLine(),
                "From: " + ctx.expr().getText()
        );

        PYExpressionNode iterableExpr = (PYExpressionNode) visit(ctx.expr());
        PYForNode forNode = new PYForNode(ctx.getStart().getLine(), targetVar, iterableExpr);

        forNode.setBody((PYBlockSuiteNode) visit(ctx.suite()));
        symbolTable.popScope();
        return forNode;
    }

    @Override
    public PYASTNode visitBreakStmt(FlaskParser.BreakStmtContext ctx) {
        return new PYBreakNode(ctx.getStart().getLine());
    }

    @Override//SYMBOL TABLE:
    public PYASTNode visitFromImportStmt(FlaskParser.FromImportStmtContext ctx) {
        String moduleName = ctx.dottedName().getText();
        PYIdentifierNode module = new PYIdentifierNode(ctx.getStart().getLine(), moduleName);

        List<PYIdentifierNode> items = new ArrayList<>();

        for (FlaskParser.ImportedNameContext nameCtx : ctx.importList().importedName()) {
            String importedName = nameCtx.PY_IDENTIFIER().getText();
            PYIdentifierNode paramNode = new PYIdentifierNode(nameCtx.getStart().getLine(), importedName);
            items.add(paramNode);
            symbolTable.addSymbol(
                    importedName,
                    Symbol.SymbolKind.IMPORT,
                    nameCtx.getStart().getLine(),
                    moduleName
            );
        }

        return new PYImportNode(ctx.getStart().getLine(), module, items);
    }

    @Override//SYMBOL TABLE:
    public PYASTNode visitFuncDef(FlaskParser.FuncDefContext ctx) {
        String funcName = ctx.PY_IDENTIFIER().getText();

        symbolTable.addSymbol(
                funcName,
                Symbol.SymbolKind.FUNCTION,
                ctx.getStart().getLine(),
                null
        );

        symbolTable.pushScope(Symbol.ScopeType.LOCAL);
        if (ctx.parameters() != null) {
            visit(ctx.parameters());
        }

        PYFunctionNode funcNode = new PYFunctionNode(ctx.getStart().getLine(), funcName);

        if (ctx.parameters() != null && ctx.parameters().typedargslist() != null) {
            for (var paramToken : ctx.parameters().typedargslist().PY_IDENTIFIER()) {
                PYIdentifierNode paramNode = new PYIdentifierNode(paramToken.getSymbol().getLine(), paramToken.getText());
                funcNode.addParameter(paramNode);
            }
        }

        funcNode.setBody((PYBlockSuiteNode) visit(ctx.suite()));
        symbolTable.popScope();
        return funcNode;
    }

    @Override //تابع وسيط
    public PYASTNode visitParameters(FlaskParser.ParametersContext ctx) {
        if (ctx.typedargslist() != null) {
            for (var idToken : ctx.typedargslist().PY_IDENTIFIER()) {
                String paramName = idToken.getText();
                int line = idToken.getSymbol().getLine();

                symbolTable.addSymbol(
                        paramName,
                        Symbol.SymbolKind.PARAMETER,
                        line,
                        null
                );
            }
            return visit(ctx.typedargslist());
        }
        return null;
    }

    @Override
    public PYASTNode visitSingleLineSuite(FlaskParser.SingleLineSuiteContext ctx) {
        PYBlockSuiteNode blockNode = new PYBlockSuiteNode(ctx.getStart().getLine());
        PYASTNode node = visit(ctx.simpleStmt());

        if (node instanceof PYStatementNode) {
            blockNode.addStatement((PYStatementNode) node);
        }

        return blockNode;
    }

    @Override
    public PYASTNode visitBlockSuite(FlaskParser.BlockSuiteContext ctx) {
        PYBlockSuiteNode blockNode = new PYBlockSuiteNode(ctx.getStart().getLine());

        for (FlaskParser.StmtContext stmtCtx : ctx.stmt()) {
            PYASTNode node = visit(stmtCtx);

            if (node instanceof PYStatementNode) {
                blockNode.addStatement((PYStatementNode) node);
            }
        }

        return blockNode;
    }

    @Override //تابع تجميع
    public PYASTNode visitDecorators(FlaskParser.DecoratorsContext ctx) {
        PYDecoratorsNode node = new PYDecoratorsNode(ctx.getStart().getLine());

        for (FlaskParser.DecoratorContext decCtx : ctx.decorator()) {
            node.addDecorator((PYDecoratorNode) visit(decCtx));
        }

        return node;
    }

    @Override
    public PYASTNode visitDecorator(FlaskParser.DecoratorContext ctx) {
        PYExpressionNode callee = (PYExpressionNode) visit(ctx.dottedName());
        PYDecoratorNode decoratorNode = new PYDecoratorNode(ctx.getStart().getLine(), callee);

        if (ctx.arglist() != null) {
            for (FlaskParser.ArgumentContext argCtx : ctx.arglist().argument()) {
                PYArgumentNode arg = (PYArgumentNode) visit(argCtx);
                decoratorNode.addArgument(arg);
            }
        }
        return decoratorNode;
    }

    @Override
    public PYASTNode visitDecorated(FlaskParser.DecoratedContext ctx) {
        PYDecoratorsNode decorators = (PYDecoratorsNode) visit(ctx.decorators());
        PYFunctionNode function = (PYFunctionNode) visit(ctx.funcDef());

        for (PYDecoratorNode dec : decorators.getDecorators()) {
            function.addDecorator(dec);
        }

        return function;
    }

    @Override
    public PYASTNode visitDottedName(FlaskParser.DottedNameContext ctx) {
        PYExpressionNode expr = new PYIdentifierNode(ctx.getStart().getLine(), ctx.PY_IDENTIFIER(0).getText());

        for (int i = 1; i < ctx.PY_IDENTIFIER().size(); i++) {
            expr = new PYAttributeExprNode(ctx.getStart().getLine(), expr, ctx.PY_IDENTIFIER(i).getText());
        }

        return expr;
    }

    @Override
    public PYASTNode visitIfStmt(FlaskParser.IfStmtContext ctx) {
        PYExpressionNode ifCondition = (PYExpressionNode) visit(ctx.expr(0));
        PYIfNode ifNode = new PYIfNode(ctx.getStart().getLine(), ifCondition);

        PYBlockSuiteNode ifBody = (PYBlockSuiteNode) visit(ctx.suite(0));
        ifNode.setIfBody(ifBody);

        int elifCount = ctx.PY_ELIF().size();
        for (int i = 0; i < elifCount; i++) {
            PYExpressionNode elifCond = (PYExpressionNode) visit(ctx.expr(i + 1));
            PYBlockSuiteNode elifBody = (PYBlockSuiteNode) visit(ctx.suite(i + 1));
            ifNode.addElif(elifCond, elifBody);
        }

        if (ctx.PY_ELSE() != null) {
            PYBlockSuiteNode elseBody = (PYBlockSuiteNode) visit(ctx.suite(ctx.suite().size() - 1));
            ifNode.setElseBody(elseBody);
        }

        return ifNode;
    }

    @Override
    public PYASTNode visitGlobalStmt(FlaskParser.GlobalStmtContext ctx) {
        PYGlobalNode globalNode = new PYGlobalNode(ctx.getStart().getLine());

        if (ctx.PY_IDENTIFIER() != null) {
            String varName = ctx.PY_IDENTIFIER().getText();
            PYIdentifierNode name = new PYIdentifierNode(ctx.getStart().getLine(), varName);
            globalNode.addVariable(name);
        }

        return globalNode;
    }

    @Override//SYMBOL TABLE:
    public PYASTNode visitAssignmentStmt(FlaskParser.AssignmentStmtContext ctx) {
        String name = ctx.PY_IDENTIFIER().getText();
        PYIdentifierNode target = new PYIdentifierNode(ctx.getStart().getLine(), name);
        PYExpressionNode value = (PYExpressionNode) visit(ctx.expr());
        String valueText = ctx.expr().getText();

        Symbol existing = symbolTable.lookup(name);
        if (existing == null) {
            symbolTable.addSymbol(
                    name,
                    Symbol.SymbolKind.VARIABLE,
                    ctx.getStart().getLine(),
                    valueText
            );
        }
        return new PYAssignmentNode(ctx.getStart().getLine(), target, value);
    }

    @Override
    public PYASTNode visitExprStmt(FlaskParser.ExprStmtContext ctx) {
        PYExpressionNode expr = (PYExpressionNode) visit(ctx.expr());
        return new PYExprStmtNode(ctx.getStart().getLine(), expr);
    }

    @Override
    public PYASTNode visitReturnStmt(FlaskParser.ReturnStmtContext ctx) {
        PYExpressionNode returnValue = null;
        if (ctx.expr() != null) {
            returnValue = (PYExpressionNode) visit(ctx.expr());
        }
        return new PYReturnNode(ctx.getStart().getLine(), returnValue);
    }

    @Override
    public PYASTNode visitComparisonExpression(FlaskParser.ComparisonExpressionContext ctx) {
        PYExpressionNode left = (PYExpressionNode) visit(ctx.arithExpr(0));

        for (int i = 1; i < ctx.arithExpr().size(); i++) {
            // هنا جلب رمز المقارنة مباشرة من التوكن الأصلي في الترتيب
            String op = ctx.comparisonOp(i - 1).getText();
            PYExpressionNode right = (PYExpressionNode) visit(ctx.arithExpr(i));

            left = new PYBinaryExprNode(ctx.getStart().getLine(), left, op, right);
        }
        return left;
    }

    @Override
    public PYASTNode visitAddSubExpression(FlaskParser.AddSubExpressionContext ctx) {
        PYExpressionNode left = (PYExpressionNode) visit(ctx.term(0));

        for (int i = 1; i < ctx.term().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            PYExpressionNode right = (PYExpressionNode) visit(ctx.term(i));

            left = new PYBinaryExprNode(ctx.getStart().getLine(), left, op, right);
        }
        return left;
    }

    @Override
    public PYASTNode visitMulDivExpression(FlaskParser.MulDivExpressionContext ctx) {
        PYExpressionNode left = (PYExpressionNode) visit(ctx.atom(0));
        for (int i = 1; i < ctx.atom().size(); i++) {
            String op = ctx.getChild(2 * i - 1).getText();
            PYExpressionNode right = (PYExpressionNode) visit(ctx.atom(i));
            left = new PYBinaryExprNode(ctx.getStart().getLine(), left, op, right);
        }
        return left;
    }

    @Override
    public PYASTNode visitAtom(FlaskParser.AtomContext ctx) {
        PYExpressionNode current = (PYExpressionNode) visit(ctx.primary());

        for (FlaskParser.TrailerContext tCtx : ctx.trailer()) {
            PYASTNode trailerNode = visit(tCtx);
            if (trailerNode instanceof PYCallExprNode call) {
                call.setCallee(current);
                current = call;
            } else if (trailerNode instanceof PYAttributeExprNode attr) {
                attr.setObject(current);
                current = attr;
            } else if (trailerNode instanceof PYIndexExprNode idx) {
                idx.setContainer(current);
                current = idx;
            }
        }
        return current;
    }

    @Override
    public PYASTNode visitIdAtom(FlaskParser.IdAtomContext ctx) {
        return new PYIdentifierNode(ctx.getStart().getLine(), ctx.PY_IDENTIFIER().getText());
    }

    @Override
    public PYASTNode visitStringAtom(FlaskParser.StringAtomContext ctx) {
        return new PYStringNode(ctx.getStart().getLine(), ctx.PY_STRING().getText());
    }

    @Override
    public PYASTNode visitNumberAtom(FlaskParser.NumberAtomContext ctx) {
        String text = ctx.getText();
        int line = ctx.getStart().getLine();

        if (text.contains(".")) {
            return new PYFloatNode(line, Double.parseDouble(text));
        } else {
            return new PYIntegerNode(line, Integer.parseInt(text));
        }
    }

    @Override
    public PYASTNode visitBoolAtom(FlaskParser.BoolAtomContext ctx) {
        boolean value = ctx.PY_BOOLEAN().getText().equals("True");
        return new PYBooleanNode(ctx.getStart().getLine(), value);
    }

    @Override
    public PYASTNode visitNoneAtom(FlaskParser.NoneAtomContext ctx) {
        return new PYNoneNode(ctx.getStart().getLine());
    }

    @Override
    public PYASTNode visitParenExpression(FlaskParser.ParenExpressionContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public PYASTNode visitListAtom(FlaskParser.ListAtomContext ctx) {
        return visit(ctx.list());
    }

    @Override
    public PYASTNode visitDictAtom(FlaskParser.DictAtomContext ctx) {
        return visit(ctx.dict());
    }

    @Override
    public PYASTNode visitCallTrailer(FlaskParser.CallTrailerContext ctx) {
        PYCallExprNode callNode = new PYCallExprNode(ctx.getStart().getLine(), null);

        if (ctx.arglist() != null) {
            for (FlaskParser.ArgumentContext argCtx : ctx.arglist().argument()) {
                PYArgumentNode argNode = (PYArgumentNode) visit(argCtx);
                callNode.addArgument(argNode);
            }
        }
        return callNode;
    }

    @Override
    public PYASTNode visitIndexTrailer(FlaskParser.IndexTrailerContext ctx) {
        PYExpressionNode index = (PYExpressionNode) visit(ctx.expr());
        return new PYIndexExprNode(ctx.getStart().getLine(), null, index);
    }

    @Override
    public PYASTNode visitAttrTrailer(FlaskParser.AttrTrailerContext ctx) {
        return new PYAttributeExprNode(ctx.getStart().getLine(), null, ctx.PY_IDENTIFIER().getText());
    }

    @Override // تم التعديل للاسم الجديد المولد من الـ Label (# CompOp)
    public PYASTNode visitCompOp(FlaskParser.CompOpContext ctx) {
        return null; // لا نمرر شيء لأننا نقرأ الرموز مباشرة بالصيغة النصية في الأعلى
    }

    @Override
    public PYASTNode visitComparisonOp(FlaskParser.ComparisonOpContext ctx) {
        return null;
    }

    @Override
    public PYASTNode visitPositionalArg(FlaskParser.PositionalArgContext ctx) {
        return new PYPositionalArgNode(ctx.getStart().getLine(), (PYExpressionNode) visit(ctx.expr()));
    }

    @Override
    public PYASTNode visitKeywordArg(FlaskParser.KeywordArgContext ctx) {
        String key = ctx.PY_IDENTIFIER().getText();
        PYIdentifierNode keyNode = new PYIdentifierNode(ctx.getStart().getLine(), key);
        PYExpressionNode value = (PYExpressionNode) visit(ctx.expr());
        return new PYKeyWordArgNode(ctx.getStart().getLine(), keyNode, value);
    }

    @Override // تم التعديل للاسم الجديد المولد من الـ Label (# ListExpr)
    public PYASTNode visitListExpr(FlaskParser.ListExprContext ctx) {
        PYListNode listNode = new PYListNode(ctx.getStart().getLine());

        if (ctx.exprList() != null && ctx.exprList().expr() != null) {
            for (FlaskParser.ExprContext exprCtx : ctx.exprList().expr()) {
                PYExpressionNode element = (PYExpressionNode) visit(exprCtx);
                listNode.addElement(element);
            }
        }
        return listNode;
    }

    @Override
    public PYASTNode visitList(FlaskParser.ListContext ctx) {
        return null;
    }

    @Override // تم التعديل للاسم الجديد المولد من الـ Label (# DictExpr)
    public PYASTNode visitDictExpr(FlaskParser.DictExprContext ctx) {
        PYDictNode dictNode = new PYDictNode(ctx.getStart().getLine());

        if (ctx.keyValueList() != null && ctx.keyValueList().keyValuePair() != null) {
            for (FlaskParser.KeyValuePairContext kvCtx : ctx.keyValueList().keyValuePair()) {
                PYKeyValueNode entry = (PYKeyValueNode) visit(kvCtx);
                dictNode.addEntry(entry);
            }
        }
        return dictNode;
    }

    @Override
    public PYASTNode visitDict(FlaskParser.DictContext ctx) {
        return null;
    }

    @Override
    public PYASTNode visitKeyValue(FlaskParser.KeyValueContext ctx) {
        PYExpressionNode key = (PYExpressionNode) visit(ctx.expr(0));
        PYExpressionNode value = (PYExpressionNode) visit(ctx.expr(1));
        return new PYKeyValueNode(ctx.getStart().getLine(), key, value);
    }
}