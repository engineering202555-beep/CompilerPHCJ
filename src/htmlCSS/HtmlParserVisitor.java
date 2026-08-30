// Generated from C:/HTMLCSSJINJA2FLASK/compilerproject-main/src/htmlCSS/HtmlParser.g4 by ANTLR 4.13.2
package htmlCSS;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link HtmlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface HtmlParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link HtmlParser#htmlDocument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtmlDocument(HtmlParser.HtmlDocumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PairedTag}
	 * labeled alternative in {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPairedTag(HtmlParser.PairedTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Closing}
	 * labeled alternative in {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClosing(HtmlParser.ClosingContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagStart}
	 * labeled alternative in {@link HtmlParser#tagOpen}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagStart(HtmlParser.TagStartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TagEnd}
	 * labeled alternative in {@link HtmlParser#tagClose}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagEnd(HtmlParser.TagEndContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#self_closing_tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelf_closing_tag(HtmlParser.Self_closing_tagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrNameOnly}
	 * labeled alternative in {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrNameOnly(HtmlParser.AttrNameOnlyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrWithValue}
	 * labeled alternative in {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrWithValue(HtmlParser.AttrWithValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrValueComposite}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrValueComposite(HtmlParser.AttrValueCompositeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrValueSingleQuoted}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrValueSingleQuoted(HtmlParser.AttrValueSingleQuotedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrValueJinjaVar}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrValueJinjaVar(HtmlParser.AttrValueJinjaVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrUnquoted}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrUnquoted(HtmlParser.AttrUnquotedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrTextPart}
	 * labeled alternative in {@link HtmlParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrTextPart(HtmlParser.AttrTextPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrJinjaPart}
	 * labeled alternative in {@link HtmlParser#attrValuePart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrJinjaPart(HtmlParser.AttrJinjaPartContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTextContent(HtmlParser.TextContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NestedElement}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNestedElement(HtmlParser.NestedElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaVarContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaVarContent(HtmlParser.JinjaVarContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIfBlocks}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfBlocks(HtmlParser.JinjaIfBlocksContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaForBlocks}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForBlocks(HtmlParser.JinjaForBlocksContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaTagContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaTagContent(HtmlParser.JinjaTagContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StyleBlock}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStyleBlock(HtmlParser.StyleBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssContent(HtmlParser.CssContentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssRuleBlock}
	 * labeled alternative in {@link HtmlParser#cssRule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssRuleBlock(HtmlParser.CssRuleBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssSelector(HtmlParser.CssSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#cssDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssDeclaration(HtmlParser.CssDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CssPropertyValue}
	 * labeled alternative in {@link HtmlParser#cssValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCssPropertyValue(HtmlParser.CssPropertyValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaVariableExpr}
	 * labeled alternative in {@link HtmlParser#jinjaVariable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaVariableExpr(HtmlParser.JinjaVariableExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaFunctionCall}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaFunctionCall(HtmlParser.JinjaFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaDotAccess}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaDotAccess(HtmlParser.JinjaDotAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaSimpleExpr}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaSimpleExpr(HtmlParser.JinjaSimpleExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaApplyFilter}
	 * labeled alternative in {@link HtmlParser#jinjaFilter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaApplyFilter(HtmlParser.JinjaApplyFilterContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#jinjaArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaArgument(HtmlParser.JinjaArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#jinjaKeywordArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaKeywordArgument(HtmlParser.JinjaKeywordArgumentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaArgList}
	 * labeled alternative in {@link HtmlParser#jinjaArgs}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaArgList(HtmlParser.JinjaArgListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIdentifier}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIdentifier(HtmlParser.JinjaIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIndexAccess}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIndexAccess(HtmlParser.JinjaIndexAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaStringLiteral}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStringLiteral(HtmlParser.JinjaStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaNumberLiteral}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaNumberLiteral(HtmlParser.JinjaNumberLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaStatementTag}
	 * labeled alternative in {@link HtmlParser#jinjaTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaStatementTag(HtmlParser.JinjaStatementTagContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaForStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForStmt(HtmlParser.JinjaForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaIfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfStmt(HtmlParser.JinjaIfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaElseStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaElseStmt(HtmlParser.JinjaElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaEndForStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaEndForStmt(HtmlParser.JinjaEndForStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code JinjaEndIfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaEndIfStmt(HtmlParser.JinjaEndIfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link HtmlParser#jinjaFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoop(HtmlParser.ForLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LoopVars}
	 * labeled alternative in {@link HtmlParser#loopVariables}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopVars(HtmlParser.LoopVarsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndFor}
	 * labeled alternative in {@link HtmlParser#jinjaEndFor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndFor(HtmlParser.EndForContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaIfBlock(HtmlParser.JinjaIfBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(HtmlParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EndIf}
	 * labeled alternative in {@link HtmlParser#jinjaEndIf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEndIf(HtmlParser.EndIfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElseStmt}
	 * labeled alternative in {@link HtmlParser#jinjaElse}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseStmt(HtmlParser.ElseStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ElifStmt}
	 * labeled alternative in {@link HtmlParser#jinjaElif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElifStmt(HtmlParser.ElifStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#jinjaForBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaForBlock(HtmlParser.JinjaForBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link HtmlParser#jinjaContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJinjaContent(HtmlParser.JinjaContentContext ctx);
}