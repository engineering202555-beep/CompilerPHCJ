// Generated from C:/Project 1/CompilerProject5678/src/python/FlaskParser.g4 by ANTLR 4.13.2
package python;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FlaskParser}.
 */
public interface FlaskParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(FlaskParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(FlaskParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(FlaskParser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(FlaskParser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDefinition}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDefinition(FlaskParser.FunctionDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDefinition}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDefinition(FlaskParser.FunctionDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DecoratedDefinition}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterDecoratedDefinition(FlaskParser.DecoratedDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DecoratedDefinition}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitDecoratedDefinition(FlaskParser.DecoratedDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SimpleStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStatement(FlaskParser.SimpleStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SimpleStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStatement(FlaskParser.SimpleStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void enterSimpleStmt(FlaskParser.SimpleStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#simpleStmt}.
	 * @param ctx the parse tree
	 */
	void exitSimpleStmt(FlaskParser.SimpleStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignStmt(FlaskParser.AssignStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignStmt(FlaskParser.AssignStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(FlaskParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(FlaskParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStatement(FlaskParser.GlobalStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStatement(FlaskParser.GlobalStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FromImportStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void enterFromImportStatement(FlaskParser.FromImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FromImportStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void exitFromImportStatement(FlaskParser.FromImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BreakStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(FlaskParser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BreakStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(FlaskParser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStmt(FlaskParser.ExpressionStmtContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStmt(FlaskParser.ExpressionStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void enterForStmt(FlaskParser.ForStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#forStmt}.
	 * @param ctx the parse tree
	 */
	void exitForStmt(FlaskParser.ForStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void enterBreakStmt(FlaskParser.BreakStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#breakStmt}.
	 * @param ctx the parse tree
	 */
	void exitBreakStmt(FlaskParser.BreakStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#fromImportStmt}.
	 * @param ctx the parse tree
	 */
	void enterFromImportStmt(FlaskParser.FromImportStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#fromImportStmt}.
	 * @param ctx the parse tree
	 */
	void exitFromImportStmt(FlaskParser.FromImportStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#importList}.
	 * @param ctx the parse tree
	 */
	void enterImportList(FlaskParser.ImportListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#importList}.
	 * @param ctx the parse tree
	 */
	void exitImportList(FlaskParser.ImportListContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#importedName}.
	 * @param ctx the parse tree
	 */
	void enterImportedName(FlaskParser.ImportedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#importedName}.
	 * @param ctx the parse tree
	 */
	void exitImportedName(FlaskParser.ImportedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void enterFuncDef(FlaskParser.FuncDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#funcDef}.
	 * @param ctx the parse tree
	 */
	void exitFuncDef(FlaskParser.FuncDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(FlaskParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(FlaskParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#typedargslist}.
	 * @param ctx the parse tree
	 */
	void enterTypedargslist(FlaskParser.TypedargslistContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#typedargslist}.
	 * @param ctx the parse tree
	 */
	void exitTypedargslist(FlaskParser.TypedargslistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SingleLineSuite}
	 * labeled alternative in {@link FlaskParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterSingleLineSuite(FlaskParser.SingleLineSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SingleLineSuite}
	 * labeled alternative in {@link FlaskParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitSingleLineSuite(FlaskParser.SingleLineSuiteContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BlockSuite}
	 * labeled alternative in {@link FlaskParser#suite}.
	 * @param ctx the parse tree
	 */
	void enterBlockSuite(FlaskParser.BlockSuiteContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BlockSuite}
	 * labeled alternative in {@link FlaskParser#suite}.
	 * @param ctx the parse tree
	 */
	void exitBlockSuite(FlaskParser.BlockSuiteContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#decorators}.
	 * @param ctx the parse tree
	 */
	void enterDecorators(FlaskParser.DecoratorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#decorators}.
	 * @param ctx the parse tree
	 */
	void exitDecorators(FlaskParser.DecoratorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#decorator}.
	 * @param ctx the parse tree
	 */
	void enterDecorator(FlaskParser.DecoratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#decorator}.
	 * @param ctx the parse tree
	 */
	void exitDecorator(FlaskParser.DecoratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#decorated}.
	 * @param ctx the parse tree
	 */
	void enterDecorated(FlaskParser.DecoratedContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#decorated}.
	 * @param ctx the parse tree
	 */
	void exitDecorated(FlaskParser.DecoratedContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void enterDottedName(FlaskParser.DottedNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#dottedName}.
	 * @param ctx the parse tree
	 */
	void exitDottedName(FlaskParser.DottedNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(FlaskParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(FlaskParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#globalStmt}.
	 * @param ctx the parse tree
	 */
	void enterGlobalStmt(FlaskParser.GlobalStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#globalStmt}.
	 * @param ctx the parse tree
	 */
	void exitGlobalStmt(FlaskParser.GlobalStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentStmt(FlaskParser.AssignmentStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#assignmentStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentStmt(FlaskParser.AssignmentStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(FlaskParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(FlaskParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(FlaskParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(FlaskParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link FlaskParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparisonExpression(FlaskParser.ComparisonExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link FlaskParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparisonExpression(FlaskParser.ComparisonExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSubExpression}
	 * labeled alternative in {@link FlaskParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpression(FlaskParser.AddSubExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSubExpression}
	 * labeled alternative in {@link FlaskParser#arithExpr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpression(FlaskParser.AddSubExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivExpression}
	 * labeled alternative in {@link FlaskParser#term}.
	 * @param ctx the parse tree
	 */
	void enterMulDivExpression(FlaskParser.MulDivExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivExpression}
	 * labeled alternative in {@link FlaskParser#term}.
	 * @param ctx the parse tree
	 */
	void exitMulDivExpression(FlaskParser.MulDivExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(FlaskParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(FlaskParser.AtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterIdAtom(FlaskParser.IdAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitIdAtom(FlaskParser.IdAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterStringAtom(FlaskParser.StringAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitStringAtom(FlaskParser.StringAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNumberAtom(FlaskParser.NumberAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNumberAtom(FlaskParser.NumberAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BoolAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterBoolAtom(FlaskParser.BoolAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BoolAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitBoolAtom(FlaskParser.BoolAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterNoneAtom(FlaskParser.NoneAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitNoneAtom(FlaskParser.NoneAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterParenExpression(FlaskParser.ParenExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitParenExpression(FlaskParser.ParenExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterListAtom(FlaskParser.ListAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitListAtom(FlaskParser.ListAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterDictAtom(FlaskParser.DictAtomContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitDictAtom(FlaskParser.DictAtomContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterCallTrailer(FlaskParser.CallTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitCallTrailer(FlaskParser.CallTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IndexTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterIndexTrailer(FlaskParser.IndexTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IndexTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitIndexTrailer(FlaskParser.IndexTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AttrTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void enterAttrTrailer(FlaskParser.AttrTrailerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AttrTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 */
	void exitAttrTrailer(FlaskParser.AttrTrailerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CompOp}
	 * labeled alternative in {@link FlaskParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void enterCompOp(FlaskParser.CompOpContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CompOp}
	 * labeled alternative in {@link FlaskParser#comparisonOp}.
	 * @param ctx the parse tree
	 */
	void exitCompOp(FlaskParser.CompOpContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#arglist}.
	 * @param ctx the parse tree
	 */
	void enterArglist(FlaskParser.ArglistContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#arglist}.
	 * @param ctx the parse tree
	 */
	void exitArglist(FlaskParser.ArglistContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PositionalArg}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterPositionalArg(FlaskParser.PositionalArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PositionalArg}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitPositionalArg(FlaskParser.PositionalArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeywordArg}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterKeywordArg(FlaskParser.KeywordArgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeywordArg}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitKeywordArg(FlaskParser.KeywordArgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link FlaskParser#list}.
	 * @param ctx the parse tree
	 */
	void enterListExpr(FlaskParser.ListExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link FlaskParser#list}.
	 * @param ctx the parse tree
	 */
	void exitListExpr(FlaskParser.ListExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExprList(FlaskParser.ExprListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExprList(FlaskParser.ExprListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DictExpr}
	 * labeled alternative in {@link FlaskParser#dict}.
	 * @param ctx the parse tree
	 */
	void enterDictExpr(FlaskParser.DictExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DictExpr}
	 * labeled alternative in {@link FlaskParser#dict}.
	 * @param ctx the parse tree
	 */
	void exitDictExpr(FlaskParser.DictExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link FlaskParser#keyValueList}.
	 * @param ctx the parse tree
	 */
	void enterKeyValueList(FlaskParser.KeyValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link FlaskParser#keyValueList}.
	 * @param ctx the parse tree
	 */
	void exitKeyValueList(FlaskParser.KeyValueListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link FlaskParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void enterKeyValue(FlaskParser.KeyValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link FlaskParser#keyValuePair}.
	 * @param ctx the parse tree
	 */
	void exitKeyValue(FlaskParser.KeyValueContext ctx);
}