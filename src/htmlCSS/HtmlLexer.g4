lexer grammar HtmlLexer;


DTD            : '<!' .*? '>' ;
HTML_COMMENT   : '<!--' .*? '-->' -> skip;

OPEN_STYLE     : '<style>' -> pushMode(CSS_MODE);
JINJA_VAR_OPEN : '{{'     -> pushMode(JINJA_MODE);
JINJA_TAG_OPEN : '{%'     -> pushMode(JINJA_MODE);

SEA_WS : [ \t\r\n]+ -> skip ;

TAG_OPEN   : '<' -> pushMode(TAG_MODE);
TAG_CLOSE_IDENT : '</' [a-zA-Z0-9:-]+ '>' ;

HTML_TEXT  : ~[<{]+|'{' ~[%{]+ ;

mode TAG_MODE;
    TAG_CLOSE       : '>'  -> popMode;
    TAG_SLASH_CLOSE : '/>' -> popMode;
    TAG_EQUALS      : '='  -> pushMode(ATTR_VALUE_MODE);
    CLOSING_TAG_NAME: 'br' | 'img' | 'meta' | 'input'|'hr'|'link' ;
    TAG_NAME        : [a-zA-Z0-9:-]+ ;
    TAG_SLASH       : '/' ;
    TAG_WS          : [ \t\r\n]+ -> skip;


HTML_ID         : [a-zA-Z][a-zA-Z0-9_-]* ;
HTML_STRING     : '"' ~["]* '"' | '\'' ~[']* '\'' ;

mode ATTR_VALUE_MODE;
    ATTR_JINJA : '{{' -> pushMode(JINJA_MODE);

   ATTR_STRING_SGL : '\'' ~[']* '\'' -> popMode;
   ATTR_DBL_QUOTE_OPEN : '"'  -> pushMode(ATTR_DQ_MODE);
    ATTR_WS     : [ \t\r\n]+ -> skip;

mode ATTR_DQ_MODE;


ATTR_DQ_JINJA_OPEN : '{{' -> pushMode(JINJA_MODE);


ATTR_DQ_TEXT : ~["{]+ ;


ATTR_DQ_END : '"' -> popMode, popMode;

mode CSS_MODE;
    STYLE_CLOSE : '</style>' -> popMode;


    CSS_COLON: ':';
    CSS_SEMICOLON: ';';
    CSS_LBRACE: '{';
    CSS_RBRACE: '}';
    CSS_DOT: '.';
    CSS_HASH: '#';
    CSS_LPAREN: '(';
    CSS_RPAREN: ')';
    CSS_COMMA: ',';


    CSS_NUMBER: [0-9]+('.'[0-9]+)?;
    CSS_UNIT: [0-9]+('.'[0-9]+)? ( 'px' | 'em' | '%' | 'vh' | 'vw' | 'fr' );



  CSS_COLOR
      : '#' [a-fA-F0-9]+
      | 'white'
      | 'black'
      | 'red'
      | 'green'
      | 'blue'
      ;


    CSS_KEYWORD: 'solid' | 'dashed' | 'none' | 'auto' | 'ease-in-out' | 'ease' | 'linear';


    CSS_IDENTIFIER: [a-zA-Z_][a-zA-Z0-9_-]*;


    CSS_WS: [ \t\r\n]+ -> skip;


mode JINJA_MODE;
    J_COMMENT   : '{#' .*? '#}'-> skip;
    JINJA_VAR_CLOSE : '}}' -> popMode;
    JINJA_TAG_CLOSE : '%}' -> popMode;


    J_IF       : 'if' ;
    J_ELSE      :'else';
    J_FOR      : 'for' ;
    J_IN       : 'in' ;
    J_ENDIF    : 'endif' ;
    J_ENDFOR   : 'endfor' ;
    J_SET      : 'set' ;
     J_ELIF     : 'elif';

    J_LINE:'|';
    J_DOT      : '.' ;
    J_LPAREN   : '(' ;
    J_RPAREN   : ')' ;
    J_LBRACK   : '[' ;
    J_RBRACK   : ']' ;
    J_COMMA    : ',' ;
    J_ASSIGN   : '=' ;
    J_COLON    : ':' ;


    J_IDENT    : [a-zA-Z_][a-zA-Z0-9_]* ;
    J_STRING   : '"' ~["]* '"' | '\'' ~[']* '\'' ;
    J_NUMBER   : [0-9]+ ;

    J_WS       : [ \t\r\n]+ -> skip;