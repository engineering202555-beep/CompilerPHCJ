parser grammar FlaskParser;

options { tokenVocab = FlaskLexer; }

program
    : (stmt | NEWLINE)* EOF
    ;

stmt
    :ifStmt            # IfStatement
    | forStmt           # ForStatement
    | funcDef            # FunctionDefinition
    | decorated          # DecoratedDefinition
    | simpleStmt        # SimpleStatement
    ;

simpleStmt
    : smallStmt NEWLINE?
    ;

smallStmt
    : assignmentStmt        # AssignStmt
        | returnStmt        # ReturnStatement
        | globalStmt        # GlobalStatement
        | fromImportStmt   # FromImportStatement
        | breakStmt         # BreakStatement
        | exprStmt          # ExpressionStmt
    ;

// --- Loops ---
forStmt
    : PY_FOR PY_IDENTIFIER PY_IN expr PY_COLON suite
    ;

breakStmt
    : PY_BREAK
    ;

// --- Imports ---
fromImportStmt
    : PY_FROM dottedName PY_IMPORT importList
    ;

importList
    : importedName ( PY_COMMA importedName )*
    ;

importedName
    : PY_IDENTIFIER
    ;

// --- Functions ---
funcDef
    : PY_FUNCTION PY_IDENTIFIER parameters PY_COLON suite
    ;

parameters
    : PY_LPAREN typedargslist? PY_RPAREN
    ;

typedargslist
    : PY_IDENTIFIER ( PY_COMMA PY_IDENTIFIER )*
    ;

suite
   : simpleStmt                                      # SingleLineSuite
   | NEWLINE INDENT stmt+ DEDENT                   # BlockSuite
   ;

// --- Decorators ---
decorators
    : decorator+
    ;

decorator
    : PY_AT dottedName ( PY_LPAREN arglist? PY_RPAREN )? NEWLINE
    ;

decorated
    : decorators funcDef
    ;

dottedName
    : PY_IDENTIFIER ( PY_DOT PY_IDENTIFIER )*
    ;

// --- If ---
ifStmt
    : PY_IF expr PY_COLON suite
    ( PY_ELIF expr PY_COLON suite )*
    ( PY_ELSE PY_COLON suite )?
    ;

// --- Assignments & Others ---
globalStmt
    : PY_GLOBAL PY_IDENTIFIER
    ;

assignmentStmt
    : PY_IDENTIFIER PY_ASSIGN expr
    ;

exprStmt
    : expr
    ;

returnStmt
    : PY_RETURN expr?
    ;

// --- Expressions ---
expr
    : arithExpr (comparisonOp arithExpr)*    # ComparisonExpression
    ;

arithExpr
    : term ((PY_PLUS | PY_MINUS) term)*          # AddSubExpression
    ;

term
    : atom ((PY_STAR | PY_DIV) atom)*           # MulDivExpression
    ;

atom
    : primary trailer*
    ;

primary:
                 PY_IDENTIFIER                        # IdAtom
                 | PY_STRING                          # StringAtom
                 | PY_NUMBER                          # NumberAtom
                 | PY_BOOLEAN                         # BoolAtom
                 | PY_NONE                            # NoneAtom
                 | PY_LPAREN expr PY_RPAREN           # ParenExpression
                 | list                               # ListAtom
                 | dict                               # DictAtom
    ;

trailer
        : PY_LPAREN arglist? PY_RPAREN                  # CallTrailer          // render_template(...)
        | PY_LBRACK expr PY_RBRACK                      # IndexTrailer         // request.form["name"]
        | PY_DOT PY_IDENTIFIER                          # AttrTrailer          // request.method
    ;

comparisonOp
    : PY_COMPARISON_OPERATOR                          # CompOp
    ;

arglist
    : argument ( PY_COMMA argument )*
    ;

argument
   : expr                                          # PositionalArg
   | PY_IDENTIFIER PY_ASSIGN expr                  # KeywordArg           // debug=True
   ;

// --- Collections ---
list
    : PY_LBRACK NEWLINE? exprList? NEWLINE? PY_RBRACK                    # ListExpr
    ;

exprList
    : expr ( (PY_COMMA | NEWLINE) expr )* (PY_COMMA | NEWLINE)?
    ;

dict
    : PY_LCURLY NEWLINE? keyValueList? NEWLINE? PY_RCURLY                  # DictExpr
    ;

keyValueList
    : keyValuePair ( (PY_COMMA | NEWLINE) keyValuePair )* (PY_COMMA | NEWLINE)?
    ;

keyValuePair
    : expr PY_COLON NEWLINE? expr           # KeyValue
    ;

