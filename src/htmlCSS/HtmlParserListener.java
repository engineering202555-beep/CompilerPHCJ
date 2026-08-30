// Generated from C:/HTMLCSSJINJA2FLASK/compilerproject-main/src/htmlCSS/HtmlParser.g4 by ANTLR 4.13.2
package htmlCSS;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link HtmlParser}.
 */
public interface HtmlParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link HtmlParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void enterHtmlDocument(HtmlParser.HtmlDocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#htmlDocument}.
	 * @param ctx the parse tree
	 */
	void exitHtmlDocument(HtmlParser.HtmlDocumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PairedTag}
	 * labeled alternative in {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterPairedTag(HtmlParser.PairedTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PairedTag}
	 * labeled alternative in {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitPairedTag(HtmlParser.PairedTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Closing}
	 * labeled alternative in {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void enterClosing(HtmlParser.ClosingContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Closing}
	 * labeled alternative in {@link HtmlParser#htmlElement}.
	 * @param ctx the parse tree
	 */
	void exitClosing(HtmlParser.ClosingContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagStart}
	 * labeled alternative in {@link HtmlParser#tagOpen}.
	 * @param ctx the parse tree
	 */
	void enterTagStart(HtmlParser.TagStartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagStart}
	 * labeled alternative in {@link HtmlParser#tagOpen}.
	 * @param ctx the parse tree
	 */
	void exitTagStart(HtmlParser.TagStartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TagEnd}
	 * labeled alternative in {@link HtmlParser#tagClose}.
	 * @param ctx the parse tree
	 */
	void enterTagEnd(HtmlParser.TagEndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TagEnd}
	 * labeled alternative in {@link HtmlParser#tagClose}.
	 * @param ctx the parse tree
	 */
	void exitTagEnd(HtmlParser.TagEndContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#self_closing_tag}.
	 * @param ctx the parse tree
	 */
	void enterSelf_closing_tag(HtmlParser.Self_closing_tagContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#self_closing_tag}.
	 * @param ctx the parse tree
	 */
	void exitSelf_closing_tag(HtmlParser.Self_closing_tagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrNameOnly}
	 * labeled alternative in {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterAttrNameOnly(HtmlParser.AttrNameOnlyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrNameOnly}
	 * labeled alternative in {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitAttrNameOnly(HtmlParser.AttrNameOnlyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrWithValue}
	 * labeled alternative in {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void enterAttrWithValue(HtmlParser.AttrWithValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrWithValue}
	 * labeled alternative in {@link HtmlParser#htmlAttribute}.
	 * @param ctx the parse tree
	 */
	void exitAttrWithValue(HtmlParser.AttrWithValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrValueComposite}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrValueComposite(HtmlParser.AttrValueCompositeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrValueComposite}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrValueComposite(HtmlParser.AttrValueCompositeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrValueSingleQuoted}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrValueSingleQuoted(HtmlParser.AttrValueSingleQuotedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrValueSingleQuoted}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrValueSingleQuoted(HtmlParser.AttrValueSingleQuotedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrValueJinjaVar}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrValueJinjaVar(HtmlParser.AttrValueJinjaVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrValueJinjaVar}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrValueJinjaVar(HtmlParser.AttrValueJinjaVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrUnquoted}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void enterAttrUnquoted(HtmlParser.AttrUnquotedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrUnquoted}
	 * labeled alternative in {@link HtmlParser#attrValue}.
	 * @param ctx the parse tree
	 */
	void exitAttrUnquoted(HtmlParser.AttrUnquotedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrTextPart}
	 * labeled alternative in {@link HtmlParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrTextPart(HtmlParser.AttrTextPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrTextPart}
	 * labeled alternative in {@link HtmlParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrTextPart(HtmlParser.AttrTextPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrJinjaPart}
	 * labeled alternative in {@link HtmlParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void enterAttrJinjaPart(HtmlParser.AttrJinjaPartContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrJinjaPart}
	 * labeled alternative in {@link HtmlParser#attrValuePart}.
	 * @param ctx the parse tree
	 */
	void exitAttrJinjaPart(HtmlParser.AttrJinjaPartContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterTextContent(HtmlParser.TextContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TextContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitTextContent(HtmlParser.TextContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NestedElement}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterNestedElement(HtmlParser.NestedElementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NestedElement}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitNestedElement(HtmlParser.NestedElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaVarContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaVarContent(HtmlParser.JinjaVarContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaVarContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaVarContent(HtmlParser.JinjaVarContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaIfBlocks}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfBlocks(HtmlParser.JinjaIfBlocksContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaIfBlocks}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfBlocks(HtmlParser.JinjaIfBlocksContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaForBlocks}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForBlocks(HtmlParser.JinjaForBlocksContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaForBlocks}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForBlocks(HtmlParser.JinjaForBlocksContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaTagContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaTagContent(HtmlParser.JinjaTagContentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaTagContent}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaTagContent(HtmlParser.JinjaTagContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StyleBlock}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void enterStyleBlock(HtmlParser.StyleBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StyleBlock}
	 * labeled alternative in {@link HtmlParser#htmlContent}.
	 * @param ctx the parse tree
	 */
	void exitStyleBlock(HtmlParser.StyleBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void enterCssContent(HtmlParser.CssContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssContent}.
	 * @param ctx the parse tree
	 */
	void exitCssContent(HtmlParser.CssContentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssRuleBlock}
	 * labeled alternative in {@link HtmlParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void enterCssRuleBlock(HtmlParser.CssRuleBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssRuleBlock}
	 * labeled alternative in {@link HtmlParser#cssRule}.
	 * @param ctx the parse tree
	 */
	void exitCssRuleBlock(HtmlParser.CssRuleBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void enterCssSelector(HtmlParser.CssSelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssSelector}.
	 * @param ctx the parse tree
	 */
	void exitCssSelector(HtmlParser.CssSelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterCssDeclaration(HtmlParser.CssDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#cssDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitCssDeclaration(HtmlParser.CssDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CssPropertyValue}
	 * labeled alternative in {@link HtmlParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void enterCssPropertyValue(HtmlParser.CssPropertyValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CssPropertyValue}
	 * labeled alternative in {@link HtmlParser#cssValue}.
	 * @param ctx the parse tree
	 */
	void exitCssPropertyValue(HtmlParser.CssPropertyValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaVariableExpr}
	 * labeled alternative in {@link HtmlParser#jinjaVariable}.
	 * @param ctx the parse tree
	 */
	void enterJinjaVariableExpr(HtmlParser.JinjaVariableExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaVariableExpr}
	 * labeled alternative in {@link HtmlParser#jinjaVariable}.
	 * @param ctx the parse tree
	 */
	void exitJinjaVariableExpr(HtmlParser.JinjaVariableExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaFunctionCall}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaFunctionCall(HtmlParser.JinjaFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaFunctionCall}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaFunctionCall(HtmlParser.JinjaFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaDotAccess}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaDotAccess(HtmlParser.JinjaDotAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaDotAccess}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaDotAccess(HtmlParser.JinjaDotAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaSimpleExpr}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void enterJinjaSimpleExpr(HtmlParser.JinjaSimpleExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaSimpleExpr}
	 * labeled alternative in {@link HtmlParser#jinjaExpr}.
	 * @param ctx the parse tree
	 */
	void exitJinjaSimpleExpr(HtmlParser.JinjaSimpleExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaApplyFilter}
	 * labeled alternative in {@link HtmlParser#jinjaFilter}.
	 * @param ctx the parse tree
	 */
	void enterJinjaApplyFilter(HtmlParser.JinjaApplyFilterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaApplyFilter}
	 * labeled alternative in {@link HtmlParser#jinjaFilter}.
	 * @param ctx the parse tree
	 */
	void exitJinjaApplyFilter(HtmlParser.JinjaApplyFilterContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#jinjaArgument}.
	 * @param ctx the parse tree
	 */
	void enterJinjaArgument(HtmlParser.JinjaArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#jinjaArgument}.
	 * @param ctx the parse tree
	 */
	void exitJinjaArgument(HtmlParser.JinjaArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#jinjaKeywordArgument}.
	 * @param ctx the parse tree
	 */
	void enterJinjaKeywordArgument(HtmlParser.JinjaKeywordArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#jinjaKeywordArgument}.
	 * @param ctx the parse tree
	 */
	void exitJinjaKeywordArgument(HtmlParser.JinjaKeywordArgumentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaArgList}
	 * labeled alternative in {@link HtmlParser#jinjaArgs}.
	 * @param ctx the parse tree
	 */
	void enterJinjaArgList(HtmlParser.JinjaArgListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaArgList}
	 * labeled alternative in {@link HtmlParser#jinjaArgs}.
	 * @param ctx the parse tree
	 */
	void exitJinjaArgList(HtmlParser.JinjaArgListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaIdentifier}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIdentifier(HtmlParser.JinjaIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaIdentifier}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIdentifier(HtmlParser.JinjaIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaIndexAccess}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIndexAccess(HtmlParser.JinjaIndexAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaIndexAccess}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIndexAccess(HtmlParser.JinjaIndexAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaStringLiteral}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStringLiteral(HtmlParser.JinjaStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaStringLiteral}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStringLiteral(HtmlParser.JinjaStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaNumberLiteral}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void enterJinjaNumberLiteral(HtmlParser.JinjaNumberLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaNumberLiteral}
	 * labeled alternative in {@link HtmlParser#jinjaAtom}.
	 * @param ctx the parse tree
	 */
	void exitJinjaNumberLiteral(HtmlParser.JinjaNumberLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaStatementTag}
	 * labeled alternative in {@link HtmlParser#jinjaTag}.
	 * @param ctx the parse tree
	 */
	void enterJinjaStatementTag(HtmlParser.JinjaStatementTagContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaStatementTag}
	 * labeled alternative in {@link HtmlParser#jinjaTag}.
	 * @param ctx the parse tree
	 */
	void exitJinjaStatementTag(HtmlParser.JinjaStatementTagContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaForStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForStmt(HtmlParser.JinjaForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaForStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForStmt(HtmlParser.JinjaForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaIfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfStmt(HtmlParser.JinjaIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaIfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfStmt(HtmlParser.JinjaIfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaElseStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaElseStmt(HtmlParser.JinjaElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaElseStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaElseStmt(HtmlParser.JinjaElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaEndForStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaEndForStmt(HtmlParser.JinjaEndForStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaEndForStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaEndForStmt(HtmlParser.JinjaEndForStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code JinjaEndIfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void enterJinjaEndIfStmt(HtmlParser.JinjaEndIfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code JinjaEndIfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaStatement}.
	 * @param ctx the parse tree
	 */
	void exitJinjaEndIfStmt(HtmlParser.JinjaEndIfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link HtmlParser#jinjaFor}.
	 * @param ctx the parse tree
	 */
	void enterForLoop(HtmlParser.ForLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForLoop}
	 * labeled alternative in {@link HtmlParser#jinjaFor}.
	 * @param ctx the parse tree
	 */
	void exitForLoop(HtmlParser.ForLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LoopVars}
	 * labeled alternative in {@link HtmlParser#loopVariables}.
	 * @param ctx the parse tree
	 */
	void enterLoopVars(HtmlParser.LoopVarsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LoopVars}
	 * labeled alternative in {@link HtmlParser#loopVariables}.
	 * @param ctx the parse tree
	 */
	void exitLoopVars(HtmlParser.LoopVarsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndFor}
	 * labeled alternative in {@link HtmlParser#jinjaEndFor}.
	 * @param ctx the parse tree
	 */
	void enterEndFor(HtmlParser.EndForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndFor}
	 * labeled alternative in {@link HtmlParser#jinjaEndFor}.
	 * @param ctx the parse tree
	 */
	void exitEndFor(HtmlParser.EndForContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaIfBlock(HtmlParser.JinjaIfBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#jinjaIfBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaIfBlock(HtmlParser.JinjaIfBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaIf}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(HtmlParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStmt}
	 * labeled alternative in {@link HtmlParser#jinjaIf}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(HtmlParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EndIf}
	 * labeled alternative in {@link HtmlParser#jinjaEndIf}.
	 * @param ctx the parse tree
	 */
	void enterEndIf(HtmlParser.EndIfContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EndIf}
	 * labeled alternative in {@link HtmlParser#jinjaEndIf}.
	 * @param ctx the parse tree
	 */
	void exitEndIf(HtmlParser.EndIfContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElseStmt}
	 * labeled alternative in {@link HtmlParser#jinjaElse}.
	 * @param ctx the parse tree
	 */
	void enterElseStmt(HtmlParser.ElseStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElseStmt}
	 * labeled alternative in {@link HtmlParser#jinjaElse}.
	 * @param ctx the parse tree
	 */
	void exitElseStmt(HtmlParser.ElseStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ElifStmt}
	 * labeled alternative in {@link HtmlParser#jinjaElif}.
	 * @param ctx the parse tree
	 */
	void enterElifStmt(HtmlParser.ElifStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ElifStmt}
	 * labeled alternative in {@link HtmlParser#jinjaElif}.
	 * @param ctx the parse tree
	 */
	void exitElifStmt(HtmlParser.ElifStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#jinjaForBlock}.
	 * @param ctx the parse tree
	 */
	void enterJinjaForBlock(HtmlParser.JinjaForBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#jinjaForBlock}.
	 * @param ctx the parse tree
	 */
	void exitJinjaForBlock(HtmlParser.JinjaForBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link HtmlParser#jinjaContent}.
	 * @param ctx the parse tree
	 */
	void enterJinjaContent(HtmlParser.JinjaContentContext ctx);
	/**
	 * Exit a parse tree produced by {@link HtmlParser#jinjaContent}.
	 * @param ctx the parse tree
	 */
	void exitJinjaContent(HtmlParser.JinjaContentContext ctx);
}