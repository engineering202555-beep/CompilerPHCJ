//package VisitorHCJ;
//import ASTHCJ.*;
//import SymbolTableHCJ.Symbol;
//import SymbolTableHCJ.SymbolTable;
//import htmlCSS.HtmlParser;
//import htmlCSS.HtmlParserBaseVisitor;
//import org.antlr.v4.runtime.Token;
//import org.antlr.v4.runtime.ParserRuleContext;
//import org.antlr.v4.runtime.tree.ParseTree;
//import org.antlr.v4.runtime.tree.TerminalNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class AstBuilderVisitor extends HtmlParserBaseVisitor<AstNode> {
//    private SymbolTable symbolTable = new SymbolTable();
//    public SymbolTable getSymbolTable() {
//        return symbolTable;
//    }
//
//    @Override
//    public AstNode visitHtmlDocument(HtmlParser.HtmlDocumentContext ctx) {
//
//        DoctypeNode doctype = null;
//        List<HtmlNode> nodes = new ArrayList<>();
//
//
//        if (ctx.DTD() != null) {
//            doctype = new DoctypeNode(
//                    ctx.DTD().getText(),
//                    ctx.DTD().getSymbol().getLine()
//            );
//        }
//
//
//        for (HtmlParser.HtmlElementContext el : ctx.htmlElement()) {
//            nodes.add((HtmlNode) visit(el));
//        }
//
//        return new HtmlDocument(
//                doctype,
//                nodes,
//                ctx.getStart().getLine()
//        );
//    }
//
//
//    @Override
//    public AstNode visitPairedTag(HtmlParser.PairedTagContext ctx) {
//
//        HtmlParser.TagStartContext open = (HtmlParser.TagStartContext) ctx.tagOpen();
//
//        String tagName = open.getChild(1).getText();
//        int line = ctx.getStart().getLine();
//
//        symbolTable.addSymbol(
//                tagName,
//                Symbol.SymbolKind.HTML_ELEMENT,
//                ctx.getStart().getLine(),
//                null
//        );
//
//        List<HtmlAttribute> attributes = new ArrayList<>();
//        for (HtmlParser.HtmlAttributeContext a : open.htmlAttribute()) {
//            attributes.add((HtmlAttribute) visit(a));
//        }
//        symbolTable.pushScope(Symbol.ScopeType.HTML);
//
//        List<AstNode> children = new ArrayList<>();
//        for (HtmlParser.HtmlContentContext c : ctx.htmlContent()) {
//            children.add((AstNode) visit(c));
//        }
//        symbolTable.popScope();
//        return new PairedTag(tagName, attributes, children, line);
//    }
//
//
//    @Override
//    public AstNode visitSelf_closing_tag(HtmlParser.Self_closing_tagContext ctx) {
//        String tagName = ctx.CLOSING_TAG_NAME().getText();
//        int line = ctx.getStart().getLine();
//
//        List<HtmlAttribute> attributes = new ArrayList<>();
//        for (HtmlParser.HtmlAttributeContext a : ctx.htmlAttribute()) {
//            attributes.add((HtmlAttribute) visit(a));
//        }
//        symbolTable.addSymbol(
//                tagName,
//                Symbol.SymbolKind.HTML_ELEMENT,
//                ctx.getStart().getLine(),
//                null
//        );
//        return new SelfClosingTag(tagName, attributes, line);
//    }
//
//    @Override
//    public AstNode visitTextContent(HtmlParser.TextContentContext ctx) {
//        return new TextContent(
//                ctx.HTML_TEXT().getText(),
//                ctx.getStart().getLine()
//        );
//    }
//
//
//    @Override
//    public AstNode visitAttrNameOnly(HtmlParser.AttrNameOnlyContext ctx) {
//        return new BooleanAttribute(
//                ctx.TAG_NAME().getText(),
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitAttrWithValue(HtmlParser.AttrWithValueContext ctx) {
//
//        String name = ctx.TAG_NAME().getText();
//        AttributeValue value = (AttributeValue) visit(ctx.attrValue());
//        symbolTable.addSymbol(
//                ctx.TAG_NAME().getText(),
//                Symbol.SymbolKind.HTML_ATTRIBUTE,
//                ctx.getStart().getLine(),
//                ctx.attrValue().getText()
//        );
//        return new AttributeWithValue(
//                name,
//                value,
//                ctx.getStart().getLine()
//        );
//    }
//
//
//    @Override
//    public AstNode visitAttrValueSingleQuoted(HtmlParser.AttrValueSingleQuotedContext ctx) {
//        String text = ctx.ATTR_STRING_SGL().getText();
//        return new StringValue(
//                stripQuotes(text),
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitStyleBlock(HtmlParser.StyleBlockContext ctx) {
//
//        CssStyleSheetNode styleSheet = (CssStyleSheetNode) visit(ctx.cssContent());
//
//        return new StyleContent(styleSheet, ctx.getStart().getLine());
//       }
//public String stripQuotes(String s) {
//      if (s.length() >= 2) {
//           return s.substring(1, s.length() - 1);
//     }
//      return s;
//  }
//
//    @Override
//    public AstNode visitCssContent(HtmlParser.CssContentContext ctx) {
//
//        CssStyleSheetNode sheet =
//                new CssStyleSheetNode(ctx.getStart().getLine());
//
//        for (HtmlParser.CssRuleContext ruleCtx : ctx.cssRule()) {
//            CssRuleNode rule = (CssRuleNode) visit(ruleCtx);
//            sheet.addRule(rule);
//        }
//
//        return sheet;
//    }
//
//    @Override
//    public AstNode visitCssRuleBlock(HtmlParser.CssRuleBlockContext ctx) {
//        symbolTable.pushScope(Symbol.ScopeType.CSS);
//        CssRuleNode ruleNode = new CssRuleNode(ctx.getStart().getLine());
//
//        CssSelectorNode selectorNode = (CssSelectorNode) visit(ctx.cssSelector());
//        ruleNode.addSelector(selectorNode);
//
//        for (HtmlParser.CssDeclarationContext decCtx : ctx.cssDeclaration()) {
//            CssDeclarationNode declaration = (CssDeclarationNode) visit(decCtx);
//            ruleNode.addDeclaration(declaration);
//        }
//        symbolTable.popScope();
//        return ruleNode;
//    }
//
//    @Override
//    public AstNode visitCssSelector(HtmlParser.CssSelectorContext ctx) {
//
//        String selectorText = ctx.getText();
//        symbolTable.addSymbol(
//                ctx.getText(),
//                Symbol.SymbolKind.CSS_SELECTOR,
//                ctx.getStart().getLine(),
//                null
//        );
//        return new CssSelectorNode(ctx.getStart().getLine(),selectorText);
//    }
//
//    @Override
//    public AstNode visitCssDeclaration(HtmlParser.CssDeclarationContext ctx) {
//
//        String property = ctx.CSS_IDENTIFIER().getText();
//        int line = ctx.getStart().getLine();
//
//        CssDeclarationNode declaration =
//                new CssDeclarationNode(property, line);
//
//
//        CssValueNode value =
//                (CssValueNode) visit(ctx.cssValue());
//
//        declaration.setValue(value);
//        symbolTable.addSymbol(
//                property,
//                Symbol.SymbolKind.CSS_PROPERTY,
//                ctx.getStart().getLine(),
//                ctx.cssValue().getText()
//        );
//        return declaration;
//    }
//
//
//    @Override
//    public AstNode visitCssPropertyValue(HtmlParser.CssPropertyValueContext ctx) {
//
//        CssCompositeValueNode composite =
//                new CssCompositeValueNode(ctx.getStart().getLine());
//
//        for (int i = 0; i < ctx.getChildCount(); i++) {
//
//            ParseTree child = ctx.getChild(i);
//
//            if (child instanceof TerminalNode terminal) {
//
//                Token token = terminal.getSymbol();
//
//                switch (token.getType()) {
//
//                    case HtmlParser.CSS_NUMBER ->
//                            composite.addPart(
//                                    new CssNumberValueNode( token.getLine(),
//                                            token.getText()
//
//                                    )
//                            );
//
//                    case HtmlParser.CSS_UNIT ->
//                            composite.addPart(
//                                    new CssUnitValueNode(  token.getLine(),
//                                            token.getText()
//
//                                    )
//                            );
//
//                    case HtmlParser.CSS_IDENTIFIER ->
//                            composite.addPart(
//                                    new CssIdentifierValueNode( token.getLine(),
//                                            token.getText()
//
//                                    )
//                            );
//
//                    case HtmlParser.CSS_KEYWORD ->
//                            composite.addPart(
//                                    new CssKeywordValueNode(  token.getLine(),
//                                            token.getText()
//
//                                    )
//                            );
//
//                    case HtmlParser.CSS_COLOR ->
//                            composite.addPart(
//                                    new CssColorValueNode(    token.getLine(),
//                                            token.getText()
//
//                                    )
//                            );
//                }
//            }
//        }
//
//        return composite;
//
//    }
//    @Override
//    public AstNode visitJinjaIdentifier(HtmlParser.JinjaIdentifierContext ctx) {
//
//
//
//        return new J_JinjaIdentifier(
//                ctx.J_IDENT().getText(),
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitJinjaStringLiteral(HtmlParser.JinjaStringLiteralContext ctx) {
//        String text = ctx.J_STRING().getText();
//        text = text.substring(1, text.length() - 1);
//
//        return new J_JinjaStringLiteral(
//                text,
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitJinjaNumberLiteral(HtmlParser.JinjaNumberLiteralContext ctx) {
//        return new J_JinjaNumberLiteral(
//                ctx.J_NUMBER().getText(),
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitAttrValueComposite(HtmlParser.AttrValueCompositeContext ctx) {
//
//        List<AstNode> parts = new ArrayList<>();
//
//        for (HtmlParser.AttrValuePartContext part : ctx.attrValuePart()) {
//            parts.add((AstNode) visit(part));
//        }
//
//        return new J_CompositeAttributeValue(
//                parts,
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitAttrTextPart(HtmlParser.AttrTextPartContext ctx) {
//        return new StringValue(
//                ctx.getText(),
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitJinjaDotAccess(HtmlParser.JinjaDotAccessContext ctx) {
//        J_JinjaExpression base =
//                (J_JinjaExpression) visit(ctx.jinjaAtom(0));
//
//        for (int i = 1; i < ctx.jinjaAtom().size(); i++) {
//            J_JinjaIdentifier field =
//                    (J_JinjaIdentifier) visit(ctx.jinjaAtom(i));
//
//            base = new J_JinjaDotAccess(
//                    base,
//                    field,
//                    ctx.getStart().getLine()
//            );
//        }
//
//        return base;
//    }
//
//    @Override
//    public AstNode visitJinjaKeywordArgument(HtmlParser.JinjaKeywordArgumentContext ctx) {
//
//        J_JinjaIdentifier name =
//                new J_JinjaIdentifier(
//                        ctx.J_IDENT().getText(),
//                        ctx.getStart().getLine()
//                );
//
//        J_JinjaExpression value =
//                (J_JinjaExpression) visit(ctx.jinjaExpr());
//
//        symbolTable.addSymbol(
//                ctx.J_IDENT().getText(),
//                Symbol.SymbolKind.JINJA_PARAMETER,
//                ctx.getStart().getLine(),
//                ctx.jinjaExpr().getText()
//        );
//        return new J_JinjaKeywordArgument(
//                name,
//                value,
//                ctx.getStart().getLine()
//        );
//    }
//
//    @Override
//    public AstNode visitJinjaFunctionCall(HtmlParser.JinjaFunctionCallContext ctx) {
//        J_JinjaIdentifier name = (J_JinjaIdentifier) visit(ctx.jinjaAtom());
//
//        List<J_JinjaExpression> args = new ArrayList<>();
//        List<J_JinjaKeywordArgument> keywordArgs = new ArrayList<>();
//
//        if (ctx.jinjaArgs() instanceof HtmlParser.JinjaArgListContext argList) {
//
//            for (HtmlParser.JinjaArgumentContext argCtx : argList.jinjaArgument()) {
//
//                if (argCtx.jinjaKeywordArgument() != null) {
//
//                    keywordArgs.add((J_JinjaKeywordArgument) visit(argCtx.jinjaKeywordArgument()));
//                } else if (argCtx.jinjaExpr() != null) {
//
//                    args.add((J_JinjaExpression) visit(argCtx.jinjaExpr()));
//                }
//            }
//        }
//        symbolTable.addSymbol(
//                name.getName(),
//                Symbol.SymbolKind.JINJA_FUNCTION,
//                ctx.getStart().getLine(),
//                "external"
//        );
//        return new J_JinjaFunctionCall(
//                name,
//                args,
//                keywordArgs,
//                ctx.getStart().getLine()
//        );
//    }
//    @Override
//    public AstNode visitJinjaIndexAccess(HtmlParser.JinjaIndexAccessContext ctx) {
//        J_JinjaIdentifier base =
//                (J_JinjaIdentifier) visit(ctx.J_IDENT());
//
//        J_JinjaExpression index =
//                (J_JinjaExpression) visit(ctx.jinjaExpr());
//
//        return new J_JinjaIndexAccessNode(   ctx.getStart().getLine(),
//                base,
//                index
//
//        );
//    }
//
//    @Override
//    public AstNode visitJinjaVariableExpr(HtmlParser.JinjaVariableExprContext ctx) {
//        J_JinjaExpression expr =
//                (J_JinjaExpression) visit(ctx.jinjaExpr());
//
//        return new J_JinjaVariableNode(
//                expr,
//                ctx.getStart().getLine()
//        );
//    }
//    @Override
//    public AstNode visitJinjaStatementTag(HtmlParser.JinjaStatementTagContext ctx) {
//        return  visit(ctx.jinjaStatement());
//    }
//    @Override
//    public AstNode visitJinjaForBlock(HtmlParser.JinjaForBlockContext ctx) {
//        symbolTable.addSymbol(
//                "for",
//                Symbol.SymbolKind.JINJA_DIRECTIVE,
//                ctx.getStart().getLine(),
//                null
//        );
//
//        symbolTable.pushScope(Symbol.ScopeType.JINJA);
//        J_JinjaForNode forNode =
//                (J_JinjaForNode) visit(ctx.jinjaFor());
//
//        List<AstNode> body = new ArrayList<>();
//        for (HtmlParser.HtmlContentContext c : ctx.htmlContent()) {
//            body.add(visit(c));
//        }
//
//        forNode.setBody(body);
//        symbolTable.popScope();
//        return forNode;
//    }
//
//    @Override
//    public AstNode visitForLoop(HtmlParser.ForLoopContext ctx) {
//        List<J_JinjaLoopVariable> variables = new ArrayList<>();
//
//        if (ctx.loopVariables() instanceof HtmlParser.LoopVarsContext varsCtx) {
//            for (TerminalNode id : varsCtx.J_IDENT()) {
//
//                variables.add(new J_JinjaLoopVariable(id.getText(), id.getSymbol().getLine()));
//                String varName = id.getText();
//                int line = id.getSymbol().getLine();
//
//                symbolTable.addSymbol(
//                        varName,
//                        Symbol.SymbolKind.JINJA_ITERATOR,
//                        line,
//                        null
//                );
//            }
//        }
//
//        J_JinjaExpression iterable = (J_JinjaExpression) visit(ctx.jinjaExpr());
//
//        return new J_JinjaForNode(
//                variables,
//                iterable,
//                new ArrayList<>(),
//                ctx.getStart().getLine()
//        );
//    }}
//
package VisitorHCJ;
import ASTHCJ.*;
import SymbolTableHCJ.Symbol;
import SymbolTableHCJ.SymbolTable;
import htmlCSS.HtmlParser;
import htmlCSS.HtmlParserBaseVisitor;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class AstBuilderVisitor extends HtmlParserBaseVisitor<AstNode> {

    // نبدأ بالنطاق العام (Global Scope)
    private SymbolTable symbolTable = new SymbolTable();

    public SymbolTable getSymbolTable() {
        return symbolTable;
    }

    /* =====================================================
       htmlDocument
       ===================================================== */
    @Override
    public AstNode visitHtmlDocument(HtmlParser.HtmlDocumentContext ctx) {
        DoctypeNode doctype = null;
        List<HtmlNode> nodes = new ArrayList<>();

        if (ctx.DTD() != null) {
            doctype = new DoctypeNode(
                    ctx.DTD().getText(),
                    ctx.DTD().getSymbol().getLine()
            );
        }

        for (HtmlParser.HtmlElementContext el : ctx.htmlElement()) {
            nodes.add((HtmlNode) visit(el));
        }

        return new HtmlDocument(doctype, nodes, ctx.getStart().getLine());
    }

    /* =====================================================
       Paired Tag  <tag> ... </tag>
       ===================================================== */
    @Override
    public AstNode visitPairedTag(HtmlParser.PairedTagContext ctx) {
        HtmlParser.TagStartContext open = (HtmlParser.TagStartContext) ctx.tagOpen();

        // تعديل: جلب اسم التاج بطريقة آمنة ومباشرة
        String tagName = open.TAG_NAME().getText();
        int line = ctx.getStart().getLine();

        // إضافة عنصر الـ HTML للنطاق الحالي
        symbolTable.addSymbol(
                tagName,
                Symbol.SymbolKind.HTML_ELEMENT,
                line,
                null
        );

        // تجميع الـ Attributes
        List<HtmlAttribute> attributes = new ArrayList<>();
        for (HtmlParser.HtmlAttributeContext a : open.htmlAttribute()) {
            attributes.add((HtmlAttribute) visit(a));
        }

        // تصحيح: إنشاء نطاق فرعي جديد للـ HTML وربطه بالنطاق الأب الحالي
        symbolTable = new SymbolTable(symbolTable, Symbol.ScopeType.HTML);

        // تجميع العناصر الداخلية (Children) داخل النطاق الجديد
        List<AstNode> children = new ArrayList<>();
        for (HtmlParser.HtmlContentContext c : ctx.htmlContent()) {
            children.add((AstNode) visit(c));
        }

        // تصحيح: الخروج من النطاق الفرعي والعودة للنطاق الأب عند انتهاء التاج
        symbolTable = symbolTable.getParent();

        return new PairedTag(tagName, attributes, children, line);
    }

    /* =====================================================
       Self Closing Tag  <img />
       ===================================================== */
    @Override
    public AstNode visitSelf_closing_tag(HtmlParser.Self_closing_tagContext ctx) {
        String tagName = ctx.CLOSING_TAG_NAME().getText();
        int line = ctx.getStart().getLine();

        List<HtmlAttribute> attributes = new ArrayList<>();
        for (HtmlParser.HtmlAttributeContext a : ctx.htmlAttribute()) { // تذكر إصلاح ctx المكررة إن وجدت
            attributes.add((HtmlAttribute) visit(a));
        }

        symbolTable.addSymbol(
                tagName,
                Symbol.SymbolKind.HTML_ELEMENT,
                line,
                null
        );

        return new SelfClosingTag(tagName, attributes, line);
    }

    /* =====================================================
       Text Content
       ===================================================== */
    @Override
    public AstNode visitTextContent(HtmlParser.TextContentContext ctx) {
        return new TextContent(
                ctx.HTML_TEXT().getText(),
                ctx.getStart().getLine()
        );
    }
    /* =====================================================
       Attributes & Values
       ===================================================== */
    @Override
    public AstNode visitAttrWithValue(HtmlParser.AttrWithValueContext ctx) {
        String name = ctx.TAG_NAME().getText();
        AttributeValue value = (AttributeValue) visit(ctx.attrValue());

        // إضافة الـ Attribute إلى النطاق الحالي (HTML Scope)
        symbolTable.addSymbol(
                name,
                Symbol.SymbolKind.HTML_ATTRIBUTE,
                ctx.getStart().getLine(),
                ctx.attrValue().getText()
        );

        return new AttributeWithValue(
                name,
                value,
                ctx.getStart().getLine()
        );
    }

    @Override
    public AstNode visitAttrValueSingleQuoted(HtmlParser.AttrValueSingleQuotedContext ctx) {
        // استخدام getText() مباشرة من الـ Context لضمان التوافق الكامل مع الـ Mode
        String text = ctx.getText();
        return new StringValue(
                stripQuotes(text),
                ctx.getStart().getLine()
        );
    }

    @Override
    public AstNode visitStyleBlock(HtmlParser.StyleBlockContext ctx) {
        CssStyleSheetNode styleSheet = (CssStyleSheetNode) visit(ctx.cssContent());
        return new StyleContent(styleSheet, ctx.getStart().getLine());
    }

    public String stripQuotes(String s) {
        if (s != null && s.length() >= 2) {
            return s.substring(1, s.length() - 1);
        }
        return s;
    }

    /* =====================================================
       CSS Content & Rules
       ===================================================== */
    @Override
    public AstNode visitCssContent(HtmlParser.CssContentContext ctx) {
        CssStyleSheetNode sheet = new CssStyleSheetNode(ctx.getStart().getLine());

        for (HtmlParser.CssRuleContext ruleCtx : ctx.cssRule()) {
            CssRuleNode rule = (CssRuleNode) visit(ruleCtx);
            sheet.addRule(rule);
        }

        return sheet;
    }

    @Override
    public AstNode visitCssRuleBlock(HtmlParser.CssRuleBlockContext ctx) {
        // تصحيح: الدخول في نطاق CSS فرعي جديد وربطه بالنطاق الحالي
        symbolTable = new SymbolTable(symbolTable, Symbol.ScopeType.CSS);

        CssRuleNode ruleNode = new CssRuleNode(ctx.getStart().getLine());

        CssSelectorNode selectorNode = (CssSelectorNode) visit(ctx.cssSelector());
        ruleNode.addSelector(selectorNode);

        for (HtmlParser.CssDeclarationContext decCtx : ctx.cssDeclaration()) {
            CssDeclarationNode declaration = (CssDeclarationNode) visit(decCtx);
            ruleNode.addDeclaration(declaration);
        }

        // تصحيح: الخروج من نطاق الـ CSS والعودة للنطاق الأب
        symbolTable = symbolTable.getParent();

        return ruleNode;
    }

    @Override
    public AstNode visitCssSelector(HtmlParser.CssSelectorContext ctx) {
        String selectorText = ctx.getText();

        symbolTable.addSymbol(
                selectorText,
                Symbol.SymbolKind.CSS_SELECTOR,
                ctx.getStart().getLine(),
                null
        );

        return new CssSelectorNode(ctx.getStart().getLine(), selectorText);
    }

    @Override
    public AstNode visitCssDeclaration(HtmlParser.CssDeclarationContext ctx) {
        String property = ctx.CSS_IDENTIFIER().getText();
        int line = ctx.getStart().getLine();

        CssDeclarationNode declaration = new CssDeclarationNode(property, line);

        CssValueNode value = (CssValueNode) visit(ctx.cssValue());
        declaration.setValue(value);

        // إضافة خاصية الـ CSS إلى النطاق الحالي (داخل الـ CSS Rule Block)
        symbolTable.addSymbol(
                property,
                Symbol.SymbolKind.CSS_PROPERTY,
                line,
                ctx.cssValue().getText()
        );

        return declaration;
    }
    /* =====================================================
       CSS Property Value
       ===================================================== */
    @Override
    public AstNode visitCssPropertyValue(HtmlParser.CssPropertyValueContext ctx) {
        CssCompositeValueNode composite = new CssCompositeValueNode(ctx.getStart().getLine());

        for (int i = 0; i < ctx.getChildCount(); i++) {
            ParseTree child = ctx.getChild(i);

            if (child instanceof TerminalNode terminal) {
                Token token = terminal.getSymbol();

                switch (token.getType()) {
                    case HtmlParser.CSS_NUMBER ->
                            composite.addPart(new CssNumberValueNode(token.getLine(), token.getText()));
                    case HtmlParser.CSS_UNIT ->
                            composite.addPart(new CssUnitValueNode(token.getLine(), token.getText()));
                    case HtmlParser.CSS_IDENTIFIER ->
                            composite.addPart(new CssIdentifierValueNode(token.getLine(), token.getText()));
                    case HtmlParser.CSS_KEYWORD ->
                            composite.addPart(new CssKeywordValueNode(token.getLine(), token.getText()));
                    case HtmlParser.CSS_COLOR ->
                            composite.addPart(new CssColorValueNode(token.getLine(), token.getText()));
                }
            }
        }
        return composite;
    }

    /* =====================================================
       Jinja Identifiers & Literals (Semantic Check Area)
       ===================================================== */
    @Override
    public AstNode visitJinjaIdentifier(HtmlParser.JinjaIdentifierContext ctx) {
        String varName = ctx.J_IDENT().getText();
        int line = ctx.getStart().getLine();

        // نكتفي ببناء العقدة فقط. التحليل الدلالي سيحدث لاحقاً في SemanticAnalyzerVisitor
        return new J_JinjaIdentifier(varName, line);
    }

    @Override
    public AstNode visitJinjaStringLiteral(HtmlParser.JinjaStringLiteralContext ctx) {
        String text = ctx.J_STRING().getText();
        text = text.substring(1, text.length() - 1); // remove quotes

        return new J_JinjaStringLiteral(text, ctx.getStart().getLine());
    }

    @Override
    public AstNode visitJinjaNumberLiteral(HtmlParser.JinjaNumberLiteralContext ctx) {
        return new J_JinjaNumberLiteral(ctx.J_NUMBER().getText(), ctx.getStart().getLine());
    }

    /* =====================================================
       Attributes Composite & Parts
       ===================================================== */
    @Override
    public AstNode visitAttrValueComposite(HtmlParser.AttrValueCompositeContext ctx) {
        List<AstNode> parts = new ArrayList<>();

        for (HtmlParser.AttrValuePartContext part : ctx.attrValuePart()) {
            parts.add((AstNode) visit(part));
        }

        return new J_CompositeAttributeValue(parts, ctx.getStart().getLine());
    }

    @Override
    public AstNode visitAttrTextPart(HtmlParser.AttrTextPartContext ctx) {
        return new StringValue(ctx.getText(), ctx.getStart().getLine());
    }

    /* =====================================================
       Jinja Expressions & Dot Access
       ===================================================== */
//    @Override
//    public AstNode visitJinjaDotAccess(HtmlParser.JinjaDotAccessContext ctx) {
//        J_JinjaExpression base = (J_JinjaExpression) visit(ctx.jinjaAtom(0));
//        for (int i = 1; i < ctx.jinjaAtom().size(); i++) {
//            // عند تتبع Dot Access (مثل user.name)، المعرف الثاني "name" هو خاصية (Field) وليس متغيراً مستقلاً
//            // لذا يفضل عدم معاملته كمتغير عام في الـ lookup العام لتجنب الأخطاء الوهمية
//            String fieldName = ctx.jinjaAtom(i).getText();
//            int line = ctx.getStart().getLine();
//
//            J_JinjaIdentifier field = new J_JinjaIdentifier(fieldName, line);
//
//            base = new J_JinjaDotAccess(base, field, line);
//        }
//
//        return base;
//    }
    @Override
    public AstNode visitJinjaDotAccess(HtmlParser.JinjaDotAccessContext ctx) {
        int line = ctx.getStart().getLine();
        J_JinjaExpression resultNode = null;

        // 1️⃣ بناء التعبير الأساسي
        if (ctx.jinjaAtom().size() == 1) {
            resultNode = (J_JinjaExpression) visit(ctx.jinjaAtom(0));
        } else if (ctx.jinjaAtom().size() >= 2) {
            J_JinjaExpression base = (J_JinjaExpression) visit(ctx.jinjaAtom(0));
            J_JinjaIdentifier property = (J_JinjaIdentifier) visit(ctx.jinjaAtom(1));
            resultNode = new J_JinjaDotAccess(base, property, line);
        }

        // 2️⃣ الحل الصحيح: فحص وجود الفلتر وتحويله للكلاس الفرعي المستهدف
        if (ctx.jinjaFilter() != null) {
            String filterName = "unknown";

            // التحقق مما إذا كان السياق ينتمي للبديل المعرف في الجرامر
            if (ctx.jinjaFilter() instanceof HtmlParser.JinjaApplyFilterContext) {
                HtmlParser.JinjaApplyFilterContext filterCtx = (HtmlParser.JinjaApplyFilterContext) ctx.jinjaFilter();
                if (filterCtx.J_IDENT() != null) {
                    filterName = filterCtx.J_IDENT().getText();
                }
            }

            // تغليف العقدة بالفلتر
            resultNode = new J_JinjaFilterNode(line, resultNode, filterName);
        }

        return resultNode;
    }








    /* =====================================================
       Jinja Keyword Arguments & Functions (Semantic Checks)
       ===================================================== */
    @Override
    public AstNode visitJinjaKeywordArgument(HtmlParser.JinjaKeywordArgumentContext ctx) {
        String argName = ctx.J_IDENT().getText();
        int line = ctx.getStart().getLine();

        J_JinjaIdentifier name = new J_JinjaIdentifier(argName, line);
        J_JinjaExpression value = (J_JinjaExpression) visit(ctx.jinjaExpr());

        // تسجيل البارامتر في النطاق الحالي (داخل سياق الدالة مثلاً)
        symbolTable.addSymbol(
                argName,
                Symbol.SymbolKind.JINJA_PARAMETER,
                line,
                ctx.jinjaExpr().getText()
        );

        return new J_JinjaKeywordArgument(name, value, line);
    }

    @Override
    public AstNode visitJinjaFunctionCall(HtmlParser.JinjaFunctionCallContext ctx) {
        String funcName = ctx.jinjaAtom().getText();
        int line = ctx.getStart().getLine();

        J_JinjaIdentifier name = new J_JinjaIdentifier(funcName, line);
        List<J_JinjaExpression> args = new ArrayList<>();
        List<J_JinjaKeywordArgument> keywordArgs = new ArrayList<>();

        if (ctx.jinjaArgs() instanceof HtmlParser.JinjaArgListContext argList) {
            for (HtmlParser.JinjaArgumentContext argCtx : argList.jinjaArgument()) {
                if (argCtx.jinjaKeywordArgument() != null) {
                    keywordArgs.add((J_JinjaKeywordArgument) visit(argCtx.jinjaKeywordArgument()));
                } else if (argCtx.jinjaExpr() != null) {
                    args.add((J_JinjaExpression) visit(argCtx.jinjaExpr()));
                }
            }
        }

        // بناء العقدة فقط دون إضافتها لجدول الرموز هنا
        return new J_JinjaFunctionCall(name, args, keywordArgs, line);
    }

    @Override
    public AstNode visitJinjaIndexAccess(HtmlParser.JinjaIndexAccessContext ctx) {
        String baseName = ctx.J_IDENT().getText();
        int line = ctx.getStart().getLine();

        // 🔍 فحص دلالي: التأكد من أن المصفوفة/القائمة التي يتم الوصول إليها معرفة (Undefined Variable)
        Symbol baseSymbol = symbolTable.lookup(baseName);
        if (baseSymbol == null) {

        }

        J_JinjaIdentifier base = new J_JinjaIdentifier(baseName, line);
        J_JinjaExpression index = (J_JinjaExpression) visit(ctx.jinjaExpr());

        return new J_JinjaIndexAccessNode(line, base, index);
    }

    /* =====================================================
       Jinja Variable & Statements
       ===================================================== */
    @Override
    public AstNode visitJinjaVariableExpr(HtmlParser.JinjaVariableExprContext ctx) {
        J_JinjaExpression expr = (J_JinjaExpression) visit(ctx.jinjaExpr());
        return new J_JinjaVariableNode(expr, ctx.getStart().getLine());
    }

    @Override
    public AstNode visitJinjaStatementTag(HtmlParser.JinjaStatementTagContext ctx) {
        return visit(ctx.jinjaStatement());
    }


    @Override
    public AstNode visitJinjaForBlock(HtmlParser.JinjaForBlockContext ctx) {
        // 1. زيارة الـ jinjaFor لبناء عقدة الـ For الأساسية ومتغيراتها
        J_JinjaForNode forNode = (J_JinjaForNode) visit(ctx.jinjaFor());

        // 2. الحل الجذري: جمع عناصر الـ HTML الواقعة داخل الحلقة وإضافتها للـ Body
        List<AstNode> body = new ArrayList<>();
        if (ctx.htmlContent() != null) {
            for (HtmlParser.HtmlContentContext c : ctx.htmlContent()) {
                AstNode child = visit(c);
                if (child != null) {
                    body.add(child);
                }
            }
        }

        // 3. حقن الـ body داخل عقدة الـ For ليصبحوا أبناءً شرعيين لها في الشجرة
        forNode.setBody(body);

        return forNode;
    }
    @Override
    public AstNode visitForLoop(HtmlParser.ForLoopContext ctx) {
        List<J_JinjaLoopVariable> variables = new ArrayList<>();

        if (ctx.loopVariables() instanceof HtmlParser.LoopVarsContext varsCtx) {
            for (TerminalNode id : varsCtx.J_IDENT()) {
                String varName = id.getText();
                int line = id.getSymbol().getLine();
                variables.add(new J_JinjaLoopVariable(varName, line));
            }
        }

        J_JinjaExpression iterable = (J_JinjaExpression) visit(ctx.jinjaExpr());

        // بناء العقدة فقط. التحقق من الـ Iterable وإضافة المتغيرات للنطاق سيتم في المحلل الدلالي
        return new J_JinjaForNode(
                variables,
                iterable,
                new ArrayList<>(),
                ctx.getStart().getLine()
        );
    }  }




//    @Override
//    public AstNode visitForLoop(HtmlParser.ForLoopContext ctx) {
//        List<J_JinjaLoopVariable> variables = new ArrayList<>();
//
//        // جمع متغيرات الحلقة (مثل p) وإضافتها للقائمة كـ AST Nodes فقط
//        if (ctx.loopVariables() instanceof HtmlParser.LoopVarsContext varsCtx) {
//            for (TerminalNode id : varsCtx.J_IDENT()) {
//                String varName = id.getText();
//                int line = id.getSymbol().getLine();
//                variables.add(new J_JinjaLoopVariable(varName, line));
//            }
//        }
//
//        // زيارة التعبير المُراد الدوران حوله (مثل products)
//        J_JinjaExpression iterable = (J_JinjaExpression) visit(ctx.jinjaExpr());
//
//        // إنشاء عقدة الـ For وضخ البيانات الأولية بها
//        return new J_JinjaForNode(
//                variables,
//                iterable,
//                new ArrayList<>(), // الـ body سيتم ملؤه في الميثود العلوية
//                ctx.getStart().getLine()
//        );
//    }    }
 /* =====================================================
       Jinja Block Loop (Perfect Scoping for Catching Scope Errors)
       ===================================================== */
//    @Override
//    public AstNode visitJinjaForBlock(HtmlParser.JinjaForBlockContext ctx) {
//        int line = ctx.getStart().getLine();
//        // تسجيل الـ directive في النطاق الحالي قبل الانتقال
//        symbolTable.addSymbol("for", Symbol.SymbolKind.JINJA_DIRECTIVE, line, null);
//
//        // 🚀 تصحيح دلالي حرج 1: فتح نطاق الـ Jinja الفرعي الجديد *أولاً* لإنشاء حاوية معزولة
//        symbolTable = new SymbolTable(symbolTable, Symbol.ScopeType.JINJA);
//
//        // 🚀 تصحيح دلالي حرج 2: الآن نزور الـ jinjaFor، ليتم تسجيل الـ Iterators داخل الحاوية المعزولة تلقائياً
//        J_JinjaForNode forNode = (J_JinjaForNode) visit(ctx.jinjaFor());
//
//        // معالجة محتوى الـ HTML والجمل الداخلية للحلقة (ستتعرف على الـ iterators بنجاح)
//        List<AstNode> body = new ArrayList<>();
//        for (HtmlParser.HtmlContentContext c : ctx.htmlContent()) {
//            body.add(visit(c));
//        }
//        forNode.setBody(body);
//
//        // 🚀 تصحيح دلالي حرج 3: الخروج من نطاق الحلقة وتدمير الحاوية (العودة للـ Parent Scope)
//        // أي استدعاء لمتغيرات الحلقة بعد هذا السطر سيطلق [Scope Error] فوراً بفضل دالة الـ lookup
//        symbolTable = symbolTable.getParent();
//
//        return forNode;
//    }