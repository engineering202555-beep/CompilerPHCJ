lexer grammar FlaskLexer;

tokens { INDENT, DEDENT }

@members {
  private java.util.LinkedList<Token> tokens = new java.util.LinkedList<>();
  private java.util.Stack<Integer> indents = new java.util.Stack<>();
  private int opened = 0;
  private Token lastToken = null;

  @Override
  public void emit(Token t) {
    super.setToken(t);
    tokens.offer(t);
  }

  @Override
  public Token nextToken() {
    if (_input.LA(1) == EOF && !indents.isEmpty()) {
      for (int i = tokens.size() - 1; i >= 0; i--) {
        if (tokens.get(i).getType() == EOF) {
          tokens.remove(i);
        }
      }
      emit(commonToken(NEWLINE, "\n"));
      while (!indents.isEmpty()) {
        emit(createDedent());
        indents.pop();
      }
      //emit(commonToken(EOF, "<EOF>"));
      CommonToken eof = new CommonToken(_tokenFactorySourcePair, EOF, DEFAULT_TOKEN_CHANNEL, getCharIndex(), getCharIndex());
          eof.setText("<EOF>");
          emit(eof);
    }

    Token next = super.nextToken();
    if (next.getChannel() == Token.DEFAULT_CHANNEL) {
      lastToken = next;
    }
    return tokens.isEmpty() ? next : tokens.poll();

  }

  private Token createDedent() {
    CommonToken dedent = new CommonToken(_tokenFactorySourcePair, DEDENT, DEFAULT_TOKEN_CHANNEL, getCharIndex(), getCharIndex());
    dedent.setText("");
    return dedent;
  }

  private CommonToken commonToken(int type, String text) {
    int stop = getCharIndex() - 1;
    int start = text.isEmpty() ? stop : stop - text.length() + 1;
    return new CommonToken(_tokenFactorySourcePair, type, DEFAULT_TOKEN_CHANNEL, start, stop);
  }

  private int getIndentationCount(String spaces) {
    int count = 0;
    for (char ch : spaces.toCharArray()) {
      if (ch == '\t') {
        count += 8 - (count % 8);
      } else {
        count++;
      }
    }
    return count;
  }

  private boolean atStartOfInput() {
    return super.getCharPositionInLine() == 0 && super.getLine() == 1;
  }
}

/* ======================
       Python
====================== */

LINE_JOIN : '\\' ( ' ' | '\t' )* ( '\r'? '\n' | '\r' | '\f' ) -> skip ;

//KEYWORDS:
PY_FROM:'from';
PY_IMPORT:'import';
PY_RETURN:'return';
PY_FUNCTION:'def';
PY_GLOBAL:'global';
PY_IF:'if';
PY_ELIF:'elif';
PY_ELSE:'else';
PY_FOR:'for';
PY_BREAK:'break';
PY_CONTINUE: 'continue';
PY_IN:'in';
PY_WHILE:'while';
PY_SELF:'self';
PY_CLASS:'class';

PY_BOOLEAN: 'True' | 'False';
PY_NONE:'None';

///SAMPLES:
PY_COLON:':';
PY_AT:'@';
PY_LCURLY: '{' { opened++; } ;
PY_RCURLY: '}' { opened--; } ;
PY_LBRACK: '[' { opened++; } ;
PY_RBRACK: ']' { opened--; } ;
PY_LPAREN: '(' { opened++; } ;
PY_RPAREN: ')' { opened--; } ;
PY_COMMA: ',';
PY_ASSIGN: '=';
PY_DOT: '.';

////EXPRESSION
PY_PLUS:'+' ;
PY_MINUS:'-';
PY_STAR:'*';
PY_DIV:'/';
PY_COMPARISON_OPERATOR: '>' | '<' | '>=' | '<=' | '==' | '!=';
PY_LOGICAL_OPERATOR: 'and' | 'or' | 'not';

NEWLINE
  : ( {atStartOfInput()}? [ \t]+
   | ( '\r'? '\n' | '\r' | '\f' ) [ \t]*
    )
    {
      String spaces = getText().replaceAll("[\\r\\n\\f]+", "");
      int next = _input.LA(1);

      if (opened > 0 || next == '\r' || next == '\n' || next == '\f' || next == '#') {
          skip();
      } else {
          emit(commonToken(NEWLINE, "\n"));

          int indent = getIndentationCount(spaces);
          int previous = indents.isEmpty() ? 0 : indents.peek();


          if (indent > previous) {
              indents.push(indent);
              emit(commonToken(INDENT, spaces));
          } else{

              while (!indents.isEmpty() && indents.peek() > indent) {
                  emit(createDedent());
                  indents.pop();
                 }
              }

      }
    }
  ;
WS : [ \t]+ -> channel(HIDDEN);
PY_COMMENT: '#' ~[\r\n]*  -> skip;

////IDENTIFIER AND VALUES
PY_IDENTIFIER: (PY_LETTER | '_') (PY_LETTER | PY_DIGIT | '_')*;
PY_STRING: '"""' ( '\\"' | . )*? '"""'
             | '\'\'\'' ( '\\\'' | . )*? '\'\'\''
             | '"' ( '\\"' | ~["] )* '"'
             | '\'' ( '\\\'' | ~['] )* '\''
             ;
PY_NUMBER
    : INT
    | FLOAT
    ;

fragment INT : '-'? '0' | [1-9] [0-9]*;
fragment FLOAT :'-'? [0-9]* '.' [0-9]+ ([eE] [+-]? [0-9]+)?;
fragment PY_DIGIT: [0-9];
fragment PY_LETTER: [a-zA-Z];

