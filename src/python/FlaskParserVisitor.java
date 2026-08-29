// Generated from C:/Project 1/CompilerProject5678/src/python/FlaskParser.g4 by ANTLR 4.13.2
package python;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FlaskParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FlaskParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FlaskParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(FlaskParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(FlaskParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(FlaskParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDefinition}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDefinition(FlaskParser.FunctionDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DecoratedDefinition}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecoratedDefinition(FlaskParser.DecoratedDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SimpleStatement}
	 * labeled alternative in {@link FlaskParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStatement(FlaskParser.SimpleStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#simpleStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleStmt(FlaskParser.SimpleStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignStmt}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignStmt(FlaskParser.AssignStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ReturnStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(FlaskParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStatement(FlaskParser.GlobalStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FromImportStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromImportStatement(FlaskParser.FromImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BreakStatement}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(FlaskParser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionStmt}
	 * labeled alternative in {@link FlaskParser#smallStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStmt(FlaskParser.ExpressionStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#forStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStmt(FlaskParser.ForStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#breakStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStmt(FlaskParser.BreakStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#fromImportStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFromImportStmt(FlaskParser.FromImportStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(FlaskParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#importedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportedName(FlaskParser.ImportedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#funcDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDef(FlaskParser.FuncDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(FlaskParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#typedargslist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedargslist(FlaskParser.TypedargslistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SingleLineSuite}
	 * labeled alternative in {@link FlaskParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleLineSuite(FlaskParser.SingleLineSuiteContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BlockSuite}
	 * labeled alternative in {@link FlaskParser#suite}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockSuite(FlaskParser.BlockSuiteContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#decorators}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorators(FlaskParser.DecoratorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#decorator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorator(FlaskParser.DecoratorContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#decorated}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecorated(FlaskParser.DecoratedContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#dottedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedName(FlaskParser.DottedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(FlaskParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#globalStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalStmt(FlaskParser.GlobalStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#assignmentStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentStmt(FlaskParser.AssignmentStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(FlaskParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(FlaskParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComparisonExpression}
	 * labeled alternative in {@link FlaskParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonExpression(FlaskParser.ComparisonExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSubExpression}
	 * labeled alternative in {@link FlaskParser#arithExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpression(FlaskParser.AddSubExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivExpression}
	 * labeled alternative in {@link FlaskParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivExpression(FlaskParser.MulDivExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(FlaskParser.AtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdAtom(FlaskParser.IdAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code StringAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringAtom(FlaskParser.StringAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NumberAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumberAtom(FlaskParser.NumberAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BoolAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolAtom(FlaskParser.BoolAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NoneAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoneAtom(FlaskParser.NoneAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenExpression}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpression(FlaskParser.ParenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListAtom(FlaskParser.ListAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictAtom}
	 * labeled alternative in {@link FlaskParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictAtom(FlaskParser.DictAtomContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallTrailer(FlaskParser.CallTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IndexTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexTrailer(FlaskParser.IndexTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AttrTrailer}
	 * labeled alternative in {@link FlaskParser#trailer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrTrailer(FlaskParser.AttrTrailerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CompOp}
	 * labeled alternative in {@link FlaskParser#comparisonOp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompOp(FlaskParser.CompOpContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#arglist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArglist(FlaskParser.ArglistContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PositionalArg}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPositionalArg(FlaskParser.PositionalArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeywordArg}
	 * labeled alternative in {@link FlaskParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeywordArg(FlaskParser.KeywordArgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ListExpr}
	 * labeled alternative in {@link FlaskParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListExpr(FlaskParser.ListExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprList(FlaskParser.ExprListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DictExpr}
	 * labeled alternative in {@link FlaskParser#dict}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDictExpr(FlaskParser.DictExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link FlaskParser#keyValueList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValueList(FlaskParser.KeyValueListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code KeyValue}
	 * labeled alternative in {@link FlaskParser#keyValuePair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyValue(FlaskParser.KeyValueContext ctx);
}