


    parser grammar HtmlParser;

    options {
        tokenVocab = HtmlLexer;
    }


    htmlDocument
        :   DTD? htmlElement* EOF
        ;

    htmlElement
        :   tagOpen htmlContent* tagClose          # PairedTag
        |    self_closing_tag                      #Closing
        ;
    tagOpen
    : TAG_OPEN TAG_NAME htmlAttribute* (TAG_CLOSE | TAG_SLASH_CLOSE)  # TagStart
    ;

    tagClose
    : TAG_CLOSE_IDENT     # TagEnd
    ;

    self_closing_tag
    : TAG_OPEN CLOSING_TAG_NAME htmlAttribute* TAG_CLOSE
    ;



    htmlAttribute
    : TAG_NAME                                    # AttrNameOnly
    | TAG_NAME TAG_EQUALS attrValue                 # AttrWithValue
    ;

    attrValue
    :   ATTR_DBL_QUOTE_OPEN attrValuePart* ATTR_DQ_END   # AttrValueComposite
    |   ATTR_STRING_SGL                        # AttrValueSingleQuoted
    |   jinjaVariable   # AttrValueJinjaVar
    |   (HTML_ID | HTML_STRING)+               # AttrUnquoted
    ;

     attrValuePart
    : ATTR_DQ_TEXT              # AttrTextPart
    | jinjaVariable             # AttrJinjaPart
    ;


    htmlContent
    :   HTML_TEXT                              # TextContent
    |   htmlElement                            # NestedElement
    |   jinjaVariable                          # JinjaVarContent
    |   jinjaIfBlock                           #JinjaIfBlocks
    |   jinjaForBlock                          # JinjaForBlocks

    |   OPEN_STYLE cssContent STYLE_CLOSE      # StyleBlock
    ;



    cssContent
    : (cssRule | CSS_WS)*
    ;

    cssRule
    : cssSelector CSS_LBRACE cssDeclaration* CSS_RBRACE          # CssRuleBlock
    ;

    cssSelector
    : (CSS_IDENTIFIER | CSS_DOT | CSS_HASH)+
    (CSS_COMMA (CSS_IDENTIFIER | CSS_DOT | CSS_HASH)+)*
    ;

    cssDeclaration
    : CSS_IDENTIFIER CSS_COLON cssValue CSS_SEMICOLON?
    ;

    cssValue
    : (CSS_IDENTIFIER
    | CSS_NUMBER
    | CSS_UNIT
    | CSS_COLOR
    | CSS_KEYWORD
    | CSS_LPAREN .*? CSS_RPAREN)+     # CssPropertyValue
    ;



    jinjaVariable
    : (JINJA_VAR_OPEN| ATTR_DQ_JINJA_OPEN |ATTR_JINJA)jinjaExpr JINJA_VAR_CLOSE    # JinjaVariableExpr
    ;



        jinjaExpr
    :   jinjaAtom J_LPAREN jinjaArgs? J_RPAREN       # JinjaFunctionCall
    |   jinjaAtom (J_DOT jinjaAtom)* jinjaFilter?    # JinjaDotAccess
    |   jinjaAtom                                    # JinjaSimpleExpr
    ;

    jinjaFilter
    :   J_LINE J_IDENT                                  # JinjaApplyFilter
    ;

     jinjaArgument
    : jinjaKeywordArgument
    | jinjaExpr
    ;

    jinjaKeywordArgument
    : J_IDENT J_ASSIGN jinjaExpr
    ;

    jinjaArgs
    : jinjaArgument (J_COMMA jinjaArgument)*   # JinjaArgList
    ;

    jinjaAtom
    :   J_IDENT                                      # JinjaIdentifier
    |   J_IDENT J_LBRACK jinjaExpr J_RBRACK           # JinjaIndexAccess
    |   J_STRING                                     # JinjaStringLiteral
    |   J_NUMBER                                     # JinjaNumberLiteral
    ;





    jinjaFor
    :   J_FOR loopVariables J_IN jinjaExpr           # ForLoop
    ;

    loopVariables
    : J_IDENT (J_COMMA J_IDENT)?    # LoopVars
    ;
    jinjaEndFor
    :   J_ENDFOR    # EndFor
    ;


    jinjaIfBlock
        : JINJA_TAG_OPEN jinjaIf JINJA_TAG_CLOSE
          htmlContent*
          JINJA_TAG_OPEN jinjaEndIf JINJA_TAG_CLOSE
        ;

    jinjaIf
        : J_IF jinjaExpr     # IfStmt
        ;

    jinjaEndIf
        : J_ENDIF            # EndIf
        ;

    jinjaElse
        : J_ELSE             # ElseStmt
        ;

    jinjaElif
        : J_ELIF jinjaExpr   # ElifStmt
        ;

      jinjaForBlock
    : JINJA_TAG_OPEN jinjaFor JINJA_TAG_CLOSE
      htmlContent*
      JINJA_TAG_OPEN jinjaEndFor JINJA_TAG_CLOSE
    ;
    jinjaContent
    : htmlContent
    ;