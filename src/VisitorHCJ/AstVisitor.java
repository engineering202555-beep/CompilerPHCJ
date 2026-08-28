package VisitorHCJ;

import ASTHCJ.*;

public interface AstVisitor<T> {

    T visitHtmlDocument(HtmlDocument node);
    T visitDoctype(DoctypeNode node);


    T visitPairedTag(PairedTag node);

    T visitStyleContent(StyleContent node);

    T visitTextContent(TextContent node);

    T visitSelfClosingTag(SelfClosingTag node);

    T visitBooleanAttribute(BooleanAttribute node);

    T visitAttributeWithValue(AttributeWithValue node);

    T visitStringValue(StringValue node);

    T visitCssStyleSheet(CssStyleSheetNode node);
    T visitCssRule(CssRuleNode node);
    T visitCssSelector(CssSelectorNode node);
    T visitCssDeclaration(CssDeclarationNode node);
    T visitCssCompositeValue(CssCompositeValueNode node);
    T visitCssNumberValue(CssNumberValueNode node);
    T visitCssUnitValue(CssUnitValueNode node);
    T visitCssIdentifierValue(CssIdentifierValueNode node);
    T visitCssKeywordValue(CssKeywordValueNode node);
    T visitCssColorValue(CssColorValueNode node);
    T visitCssFunctionValue(CssFunctionValueNode node);


    T visitJinjaIdentifier(J_JinjaIdentifier node);
    T visitJinjaStringLiteral(J_JinjaStringLiteral node);
    T visitJinjaNumberLiteral(J_JinjaNumberLiteral node);
    T visitJinjaDotAccess(J_JinjaDotAccess node);
    T visitJinjaFunctionCall(J_JinjaFunctionCall node);

    T visitJinjaForNode(J_JinjaForNode node);




    T visitJinjaVariable(J_JinjaVariableNode node);
    T visitJinjaIndexAccessNode(J_JinjaIndexAccessNode node);
    T visitJinjaFilterNode(J_JinjaFilterNode node);

    T visitJinjaLoopVariable(J_JinjaLoopVariable node);

    T visitJinjaKeywordArgument(J_JinjaKeywordArgument node);

    T visitCompositeAttributeValue(J_CompositeAttributeValue node);
}
























