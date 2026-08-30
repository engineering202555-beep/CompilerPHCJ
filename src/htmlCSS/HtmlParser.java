// Generated from C:/HTMLCSSJINJA2FLASK/compilerproject-main/src/htmlCSS/HtmlParser.g4 by ANTLR 4.13.2
package htmlCSS;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class HtmlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DTD=1, HTML_COMMENT=2, OPEN_STYLE=3, JINJA_VAR_OPEN=4, JINJA_TAG_OPEN=5, 
		SEA_WS=6, TAG_OPEN=7, TAG_CLOSE_IDENT=8, HTML_TEXT=9, TAG_CLOSE=10, TAG_SLASH_CLOSE=11, 
		TAG_EQUALS=12, CLOSING_TAG_NAME=13, TAG_NAME=14, TAG_SLASH=15, TAG_WS=16, 
		HTML_ID=17, HTML_STRING=18, ATTR_JINJA=19, ATTR_STRING_SGL=20, ATTR_DBL_QUOTE_OPEN=21, 
		ATTR_WS=22, ATTR_DQ_JINJA_OPEN=23, ATTR_DQ_TEXT=24, ATTR_DQ_END=25, STYLE_CLOSE=26, 
		CSS_COLON=27, CSS_SEMICOLON=28, CSS_LBRACE=29, CSS_RBRACE=30, CSS_DOT=31, 
		CSS_HASH=32, CSS_LPAREN=33, CSS_RPAREN=34, CSS_COMMA=35, CSS_NUMBER=36, 
		CSS_UNIT=37, CSS_COLOR=38, CSS_KEYWORD=39, CSS_IDENTIFIER=40, CSS_WS=41, 
		J_COMMENT=42, JINJA_VAR_CLOSE=43, JINJA_TAG_CLOSE=44, J_IF=45, J_ELSE=46, 
		J_FOR=47, J_IN=48, J_ENDIF=49, J_ENDFOR=50, J_SET=51, J_ELIF=52, J_LINE=53, 
		J_DOT=54, J_LPAREN=55, J_RPAREN=56, J_LBRACK=57, J_RBRACK=58, J_COMMA=59, 
		J_ASSIGN=60, J_COLON=61, J_IDENT=62, J_STRING=63, J_NUMBER=64, J_WS=65;
	public static final int
		RULE_htmlDocument = 0, RULE_htmlElement = 1, RULE_tagOpen = 2, RULE_tagClose = 3, 
		RULE_self_closing_tag = 4, RULE_htmlAttribute = 5, RULE_attrValue = 6, 
		RULE_attrValuePart = 7, RULE_htmlContent = 8, RULE_cssContent = 9, RULE_cssRule = 10, 
		RULE_cssSelector = 11, RULE_cssDeclaration = 12, RULE_cssValue = 13, RULE_jinjaVariable = 14, 
		RULE_jinjaExpr = 15, RULE_jinjaFilter = 16, RULE_jinjaArgument = 17, RULE_jinjaKeywordArgument = 18, 
		RULE_jinjaArgs = 19, RULE_jinjaAtom = 20, RULE_jinjaTag = 21, RULE_jinjaStatement = 22, 
		RULE_jinjaFor = 23, RULE_loopVariables = 24, RULE_jinjaEndFor = 25, RULE_jinjaIfBlock = 26, 
		RULE_jinjaIf = 27, RULE_jinjaEndIf = 28, RULE_jinjaElse = 29, RULE_jinjaElif = 30, 
		RULE_jinjaForBlock = 31, RULE_jinjaContent = 32;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "htmlElement", "tagOpen", "tagClose", "self_closing_tag", 
			"htmlAttribute", "attrValue", "attrValuePart", "htmlContent", "cssContent", 
			"cssRule", "cssSelector", "cssDeclaration", "cssValue", "jinjaVariable", 
			"jinjaExpr", "jinjaFilter", "jinjaArgument", "jinjaKeywordArgument", 
			"jinjaArgs", "jinjaAtom", "jinjaTag", "jinjaStatement", "jinjaFor", "loopVariables", 
			"jinjaEndFor", "jinjaIfBlock", "jinjaIf", "jinjaEndIf", "jinjaElse", 
			"jinjaElif", "jinjaForBlock", "jinjaContent"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<style>'", null, "'{%'", null, "'<'", null, null, 
			"'>'", "'/>'", null, null, null, "'/'", null, null, null, null, null, 
			null, null, null, null, null, "'</style>'", null, "';'", "'{'", "'}'", 
			null, "'#'", null, null, null, null, null, null, null, null, null, null, 
			"'}}'", "'%}'", "'if'", "'else'", "'for'", "'in'", "'endif'", "'endfor'", 
			"'set'", "'elif'", "'|'", null, null, null, "'['", "']'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DTD", "HTML_COMMENT", "OPEN_STYLE", "JINJA_VAR_OPEN", "JINJA_TAG_OPEN", 
			"SEA_WS", "TAG_OPEN", "TAG_CLOSE_IDENT", "HTML_TEXT", "TAG_CLOSE", "TAG_SLASH_CLOSE", 
			"TAG_EQUALS", "CLOSING_TAG_NAME", "TAG_NAME", "TAG_SLASH", "TAG_WS", 
			"HTML_ID", "HTML_STRING", "ATTR_JINJA", "ATTR_STRING_SGL", "ATTR_DBL_QUOTE_OPEN", 
			"ATTR_WS", "ATTR_DQ_JINJA_OPEN", "ATTR_DQ_TEXT", "ATTR_DQ_END", "STYLE_CLOSE", 
			"CSS_COLON", "CSS_SEMICOLON", "CSS_LBRACE", "CSS_RBRACE", "CSS_DOT", 
			"CSS_HASH", "CSS_LPAREN", "CSS_RPAREN", "CSS_COMMA", "CSS_NUMBER", "CSS_UNIT", 
			"CSS_COLOR", "CSS_KEYWORD", "CSS_IDENTIFIER", "CSS_WS", "J_COMMENT", 
			"JINJA_VAR_CLOSE", "JINJA_TAG_CLOSE", "J_IF", "J_ELSE", "J_FOR", "J_IN", 
			"J_ENDIF", "J_ENDFOR", "J_SET", "J_ELIF", "J_LINE", "J_DOT", "J_LPAREN", 
			"J_RPAREN", "J_LBRACK", "J_RBRACK", "J_COMMA", "J_ASSIGN", "J_COLON", 
			"J_IDENT", "J_STRING", "J_NUMBER", "J_WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "HtmlParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public HtmlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(HtmlParser.EOF, 0); }
		public TerminalNode DTD() { return getToken(HtmlParser.DTD, 0); }
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitHtmlDocument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitHtmlDocument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DTD) {
				{
				setState(66);
				match(DTD);
				}
			}

			setState(72);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_OPEN) {
				{
				{
				setState(69);
				htmlElement();
				}
				}
				setState(74);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(75);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
	 
		public HtmlElementContext() { }
		public void copyFrom(HtmlElementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PairedTagContext extends HtmlElementContext {
		public TagOpenContext tagOpen() {
			return getRuleContext(TagOpenContext.class,0);
		}
		public TagCloseContext tagClose() {
			return getRuleContext(TagCloseContext.class,0);
		}
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public PairedTagContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterPairedTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitPairedTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitPairedTag(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClosingContext extends HtmlElementContext {
		public Self_closing_tagContext self_closing_tag() {
			return getRuleContext(Self_closing_tagContext.class,0);
		}
		public ClosingContext(HtmlElementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterClosing(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitClosing(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitClosing(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_htmlElement);
		int _la;
		try {
			setState(87);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new PairedTagContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(77);
				tagOpen();
				setState(81);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8913592L) != 0)) {
					{
					{
					setState(78);
					htmlContent();
					}
					}
					setState(83);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(84);
				tagClose();
				}
				break;
			case 2:
				_localctx = new ClosingContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				self_closing_tag();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagOpenContext extends ParserRuleContext {
		public TagOpenContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagOpen; }
	 
		public TagOpenContext() { }
		public void copyFrom(TagOpenContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagStartContext extends TagOpenContext {
		public TerminalNode TAG_OPEN() { return getToken(HtmlParser.TAG_OPEN, 0); }
		public TerminalNode TAG_NAME() { return getToken(HtmlParser.TAG_NAME, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(HtmlParser.TAG_CLOSE, 0); }
		public TerminalNode TAG_SLASH_CLOSE() { return getToken(HtmlParser.TAG_SLASH_CLOSE, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public TagStartContext(TagOpenContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterTagStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitTagStart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitTagStart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagOpenContext tagOpen() throws RecognitionException {
		TagOpenContext _localctx = new TagOpenContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tagOpen);
		int _la;
		try {
			_localctx = new TagStartContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			match(TAG_OPEN);
			setState(90);
			match(TAG_NAME);
			setState(94);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(91);
				htmlAttribute();
				}
				}
				setState(96);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(97);
			_la = _input.LA(1);
			if ( !(_la==TAG_CLOSE || _la==TAG_SLASH_CLOSE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TagCloseContext extends ParserRuleContext {
		public TagCloseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagClose; }
	 
		public TagCloseContext() { }
		public void copyFrom(TagCloseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TagEndContext extends TagCloseContext {
		public TerminalNode TAG_CLOSE_IDENT() { return getToken(HtmlParser.TAG_CLOSE_IDENT, 0); }
		public TagEndContext(TagCloseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterTagEnd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitTagEnd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitTagEnd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TagCloseContext tagClose() throws RecognitionException {
		TagCloseContext _localctx = new TagCloseContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tagClose);
		try {
			_localctx = new TagEndContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			match(TAG_CLOSE_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Self_closing_tagContext extends ParserRuleContext {
		public TerminalNode TAG_OPEN() { return getToken(HtmlParser.TAG_OPEN, 0); }
		public TerminalNode CLOSING_TAG_NAME() { return getToken(HtmlParser.CLOSING_TAG_NAME, 0); }
		public TerminalNode TAG_CLOSE() { return getToken(HtmlParser.TAG_CLOSE, 0); }
		public List<HtmlAttributeContext> htmlAttribute() {
			return getRuleContexts(HtmlAttributeContext.class);
		}
		public HtmlAttributeContext htmlAttribute(int i) {
			return getRuleContext(HtmlAttributeContext.class,i);
		}
		public Self_closing_tagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_self_closing_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterSelf_closing_tag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitSelf_closing_tag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitSelf_closing_tag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Self_closing_tagContext self_closing_tag() throws RecognitionException {
		Self_closing_tagContext _localctx = new Self_closing_tagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_self_closing_tag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			match(TAG_OPEN);
			setState(102);
			match(CLOSING_TAG_NAME);
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TAG_NAME) {
				{
				{
				setState(103);
				htmlAttribute();
				}
				}
				setState(108);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(109);
			match(TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlAttributeContext extends ParserRuleContext {
		public HtmlAttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlAttribute; }
	 
		public HtmlAttributeContext() { }
		public void copyFrom(HtmlAttributeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrWithValueContext extends HtmlAttributeContext {
		public TerminalNode TAG_NAME() { return getToken(HtmlParser.TAG_NAME, 0); }
		public TerminalNode TAG_EQUALS() { return getToken(HtmlParser.TAG_EQUALS, 0); }
		public AttrValueContext attrValue() {
			return getRuleContext(AttrValueContext.class,0);
		}
		public AttrWithValueContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrWithValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrWithValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrWithValue(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrNameOnlyContext extends HtmlAttributeContext {
		public TerminalNode TAG_NAME() { return getToken(HtmlParser.TAG_NAME, 0); }
		public AttrNameOnlyContext(HtmlAttributeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrNameOnly(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrNameOnly(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrNameOnly(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlAttributeContext htmlAttribute() throws RecognitionException {
		HtmlAttributeContext _localctx = new HtmlAttributeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_htmlAttribute);
		try {
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				_localctx = new AttrNameOnlyContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(TAG_NAME);
				}
				break;
			case 2:
				_localctx = new AttrWithValueContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				match(TAG_NAME);
				setState(113);
				match(TAG_EQUALS);
				setState(114);
				attrValue();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueContext extends ParserRuleContext {
		public AttrValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValue; }
	 
		public AttrValueContext() { }
		public void copyFrom(AttrValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrUnquotedContext extends AttrValueContext {
		public List<TerminalNode> HTML_ID() { return getTokens(HtmlParser.HTML_ID); }
		public TerminalNode HTML_ID(int i) {
			return getToken(HtmlParser.HTML_ID, i);
		}
		public List<TerminalNode> HTML_STRING() { return getTokens(HtmlParser.HTML_STRING); }
		public TerminalNode HTML_STRING(int i) {
			return getToken(HtmlParser.HTML_STRING, i);
		}
		public AttrUnquotedContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrUnquoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrUnquoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrUnquoted(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueJinjaVarContext extends AttrValueContext {
		public JinjaVariableContext jinjaVariable() {
			return getRuleContext(JinjaVariableContext.class,0);
		}
		public AttrValueJinjaVarContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrValueJinjaVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrValueJinjaVar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrValueJinjaVar(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueSingleQuotedContext extends AttrValueContext {
		public TerminalNode ATTR_STRING_SGL() { return getToken(HtmlParser.ATTR_STRING_SGL, 0); }
		public AttrValueSingleQuotedContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrValueSingleQuoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrValueSingleQuoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrValueSingleQuoted(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrValueCompositeContext extends AttrValueContext {
		public TerminalNode ATTR_DBL_QUOTE_OPEN() { return getToken(HtmlParser.ATTR_DBL_QUOTE_OPEN, 0); }
		public TerminalNode ATTR_DQ_END() { return getToken(HtmlParser.ATTR_DQ_END, 0); }
		public List<AttrValuePartContext> attrValuePart() {
			return getRuleContexts(AttrValuePartContext.class);
		}
		public AttrValuePartContext attrValuePart(int i) {
			return getRuleContext(AttrValuePartContext.class,i);
		}
		public AttrValueCompositeContext(AttrValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrValueComposite(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrValueComposite(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrValueComposite(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValueContext attrValue() throws RecognitionException {
		AttrValueContext _localctx = new AttrValueContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_attrValue);
		int _la;
		try {
			setState(132);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_DBL_QUOTE_OPEN:
				_localctx = new AttrValueCompositeContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(117);
				match(ATTR_DBL_QUOTE_OPEN);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 25690128L) != 0)) {
					{
					{
					setState(118);
					attrValuePart();
					}
					}
					setState(123);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(124);
				match(ATTR_DQ_END);
				}
				break;
			case ATTR_STRING_SGL:
				_localctx = new AttrValueSingleQuotedContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(125);
				match(ATTR_STRING_SGL);
				}
				break;
			case JINJA_VAR_OPEN:
			case ATTR_JINJA:
			case ATTR_DQ_JINJA_OPEN:
				_localctx = new AttrValueJinjaVarContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				jinjaVariable();
				}
				break;
			case HTML_ID:
			case HTML_STRING:
				_localctx = new AttrUnquotedContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(128); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(127);
					_la = _input.LA(1);
					if ( !(_la==HTML_ID || _la==HTML_STRING) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(130); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==HTML_ID || _la==HTML_STRING );
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrValuePartContext extends ParserRuleContext {
		public AttrValuePartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attrValuePart; }
	 
		public AttrValuePartContext() { }
		public void copyFrom(AttrValuePartContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrJinjaPartContext extends AttrValuePartContext {
		public JinjaVariableContext jinjaVariable() {
			return getRuleContext(JinjaVariableContext.class,0);
		}
		public AttrJinjaPartContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrJinjaPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrJinjaPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrJinjaPart(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AttrTextPartContext extends AttrValuePartContext {
		public TerminalNode ATTR_DQ_TEXT() { return getToken(HtmlParser.ATTR_DQ_TEXT, 0); }
		public AttrTextPartContext(AttrValuePartContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterAttrTextPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitAttrTextPart(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitAttrTextPart(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrValuePartContext attrValuePart() throws RecognitionException {
		AttrValuePartContext _localctx = new AttrValuePartContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_attrValuePart);
		try {
			setState(136);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTR_DQ_TEXT:
				_localctx = new AttrTextPartContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(134);
				match(ATTR_DQ_TEXT);
				}
				break;
			case JINJA_VAR_OPEN:
			case ATTR_JINJA:
			case ATTR_DQ_JINJA_OPEN:
				_localctx = new AttrJinjaPartContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				jinjaVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlContentContext extends ParserRuleContext {
		public HtmlContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlContent; }
	 
		public HtmlContentContext() { }
		public void copyFrom(HtmlContentContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForBlocksContext extends HtmlContentContext {
		public JinjaForBlockContext jinjaForBlock() {
			return getRuleContext(JinjaForBlockContext.class,0);
		}
		public JinjaForBlocksContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaForBlocks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaForBlocks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaForBlocks(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaTagContentContext extends HtmlContentContext {
		public JinjaTagContext jinjaTag() {
			return getRuleContext(JinjaTagContext.class,0);
		}
		public JinjaTagContentContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaTagContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaTagContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaTagContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NestedElementContext extends HtmlContentContext {
		public HtmlElementContext htmlElement() {
			return getRuleContext(HtmlElementContext.class,0);
		}
		public NestedElementContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterNestedElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitNestedElement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitNestedElement(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StyleBlockContext extends HtmlContentContext {
		public TerminalNode OPEN_STYLE() { return getToken(HtmlParser.OPEN_STYLE, 0); }
		public CssContentContext cssContent() {
			return getRuleContext(CssContentContext.class,0);
		}
		public TerminalNode STYLE_CLOSE() { return getToken(HtmlParser.STYLE_CLOSE, 0); }
		public StyleBlockContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterStyleBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitStyleBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitStyleBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfBlocksContext extends HtmlContentContext {
		public JinjaIfBlockContext jinjaIfBlock() {
			return getRuleContext(JinjaIfBlockContext.class,0);
		}
		public JinjaIfBlocksContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaIfBlocks(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaIfBlocks(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaIfBlocks(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TextContentContext extends HtmlContentContext {
		public TerminalNode HTML_TEXT() { return getToken(HtmlParser.HTML_TEXT, 0); }
		public TextContentContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterTextContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitTextContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitTextContent(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaVarContentContext extends HtmlContentContext {
		public JinjaVariableContext jinjaVariable() {
			return getRuleContext(JinjaVariableContext.class,0);
		}
		public JinjaVarContentContext(HtmlContentContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaVarContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaVarContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaVarContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HtmlContentContext htmlContent() throws RecognitionException {
		HtmlContentContext _localctx = new HtmlContentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_htmlContent);
		try {
			setState(148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new TextContentContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(HTML_TEXT);
				}
				break;
			case 2:
				_localctx = new NestedElementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(139);
				htmlElement();
				}
				break;
			case 3:
				_localctx = new JinjaVarContentContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(140);
				jinjaVariable();
				}
				break;
			case 4:
				_localctx = new JinjaIfBlocksContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(141);
				jinjaIfBlock();
				}
				break;
			case 5:
				_localctx = new JinjaForBlocksContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(142);
				jinjaForBlock();
				}
				break;
			case 6:
				_localctx = new JinjaTagContentContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(143);
				jinjaTag();
				}
				break;
			case 7:
				_localctx = new StyleBlockContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(144);
				match(OPEN_STYLE);
				setState(145);
				cssContent();
				setState(146);
				match(STYLE_CLOSE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssContentContext extends ParserRuleContext {
		public List<CssRuleContext> cssRule() {
			return getRuleContexts(CssRuleContext.class);
		}
		public CssRuleContext cssRule(int i) {
			return getRuleContext(CssRuleContext.class,i);
		}
		public List<TerminalNode> CSS_WS() { return getTokens(HtmlParser.CSS_WS); }
		public TerminalNode CSS_WS(int i) {
			return getToken(HtmlParser.CSS_WS, i);
		}
		public CssContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssContentContext cssContent() throws RecognitionException {
		CssContentContext _localctx = new CssContentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_cssContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 3304977334272L) != 0)) {
				{
				setState(152);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CSS_DOT:
				case CSS_HASH:
				case CSS_IDENTIFIER:
					{
					setState(150);
					cssRule();
					}
					break;
				case CSS_WS:
					{
					setState(151);
					match(CSS_WS);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(156);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleContext extends ParserRuleContext {
		public CssRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssRule; }
	 
		public CssRuleContext() { }
		public void copyFrom(CssRuleContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssRuleBlockContext extends CssRuleContext {
		public CssSelectorContext cssSelector() {
			return getRuleContext(CssSelectorContext.class,0);
		}
		public TerminalNode CSS_LBRACE() { return getToken(HtmlParser.CSS_LBRACE, 0); }
		public TerminalNode CSS_RBRACE() { return getToken(HtmlParser.CSS_RBRACE, 0); }
		public List<CssDeclarationContext> cssDeclaration() {
			return getRuleContexts(CssDeclarationContext.class);
		}
		public CssDeclarationContext cssDeclaration(int i) {
			return getRuleContext(CssDeclarationContext.class,i);
		}
		public CssRuleBlockContext(CssRuleContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssRuleBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssRuleBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssRuleBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssRuleContext cssRule() throws RecognitionException {
		CssRuleContext _localctx = new CssRuleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_cssRule);
		int _la;
		try {
			_localctx = new CssRuleBlockContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(157);
			cssSelector();
			setState(158);
			match(CSS_LBRACE);
			setState(162);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_IDENTIFIER) {
				{
				{
				setState(159);
				cssDeclaration();
				}
				}
				setState(164);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(165);
			match(CSS_RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssSelectorContext extends ParserRuleContext {
		public List<TerminalNode> CSS_COMMA() { return getTokens(HtmlParser.CSS_COMMA); }
		public TerminalNode CSS_COMMA(int i) {
			return getToken(HtmlParser.CSS_COMMA, i);
		}
		public List<TerminalNode> CSS_IDENTIFIER() { return getTokens(HtmlParser.CSS_IDENTIFIER); }
		public TerminalNode CSS_IDENTIFIER(int i) {
			return getToken(HtmlParser.CSS_IDENTIFIER, i);
		}
		public List<TerminalNode> CSS_DOT() { return getTokens(HtmlParser.CSS_DOT); }
		public TerminalNode CSS_DOT(int i) {
			return getToken(HtmlParser.CSS_DOT, i);
		}
		public List<TerminalNode> CSS_HASH() { return getTokens(HtmlParser.CSS_HASH); }
		public TerminalNode CSS_HASH(int i) {
			return getToken(HtmlParser.CSS_HASH, i);
		}
		public CssSelectorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssSelector; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssSelector(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssSelector(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssSelector(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssSelectorContext cssSelector() throws RecognitionException {
		CssSelectorContext _localctx = new CssSelectorContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_cssSelector);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(167);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1105954078720L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(170); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1105954078720L) != 0) );
			setState(180);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CSS_COMMA) {
				{
				{
				setState(172);
				match(CSS_COMMA);
				setState(174); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(173);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1105954078720L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(176); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 1105954078720L) != 0) );
				}
				}
				setState(182);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssDeclarationContext extends ParserRuleContext {
		public TerminalNode CSS_IDENTIFIER() { return getToken(HtmlParser.CSS_IDENTIFIER, 0); }
		public TerminalNode CSS_COLON() { return getToken(HtmlParser.CSS_COLON, 0); }
		public CssValueContext cssValue() {
			return getRuleContext(CssValueContext.class,0);
		}
		public TerminalNode CSS_SEMICOLON() { return getToken(HtmlParser.CSS_SEMICOLON, 0); }
		public CssDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssDeclarationContext cssDeclaration() throws RecognitionException {
		CssDeclarationContext _localctx = new CssDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_cssDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(183);
			match(CSS_IDENTIFIER);
			setState(184);
			match(CSS_COLON);
			setState(185);
			cssValue();
			setState(187);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CSS_SEMICOLON) {
				{
				setState(186);
				match(CSS_SEMICOLON);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CssValueContext extends ParserRuleContext {
		public CssValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cssValue; }
	 
		public CssValueContext() { }
		public void copyFrom(CssValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CssPropertyValueContext extends CssValueContext {
		public List<TerminalNode> CSS_IDENTIFIER() { return getTokens(HtmlParser.CSS_IDENTIFIER); }
		public TerminalNode CSS_IDENTIFIER(int i) {
			return getToken(HtmlParser.CSS_IDENTIFIER, i);
		}
		public List<TerminalNode> CSS_NUMBER() { return getTokens(HtmlParser.CSS_NUMBER); }
		public TerminalNode CSS_NUMBER(int i) {
			return getToken(HtmlParser.CSS_NUMBER, i);
		}
		public List<TerminalNode> CSS_UNIT() { return getTokens(HtmlParser.CSS_UNIT); }
		public TerminalNode CSS_UNIT(int i) {
			return getToken(HtmlParser.CSS_UNIT, i);
		}
		public List<TerminalNode> CSS_COLOR() { return getTokens(HtmlParser.CSS_COLOR); }
		public TerminalNode CSS_COLOR(int i) {
			return getToken(HtmlParser.CSS_COLOR, i);
		}
		public List<TerminalNode> CSS_KEYWORD() { return getTokens(HtmlParser.CSS_KEYWORD); }
		public TerminalNode CSS_KEYWORD(int i) {
			return getToken(HtmlParser.CSS_KEYWORD, i);
		}
		public List<TerminalNode> CSS_LPAREN() { return getTokens(HtmlParser.CSS_LPAREN); }
		public TerminalNode CSS_LPAREN(int i) {
			return getToken(HtmlParser.CSS_LPAREN, i);
		}
		public List<TerminalNode> CSS_RPAREN() { return getTokens(HtmlParser.CSS_RPAREN); }
		public TerminalNode CSS_RPAREN(int i) {
			return getToken(HtmlParser.CSS_RPAREN, i);
		}
		public CssPropertyValueContext(CssValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterCssPropertyValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitCssPropertyValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitCssPropertyValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CssValueContext cssValue() throws RecognitionException {
		CssValueContext _localctx = new CssValueContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_cssValue);
		try {
			int _alt;
			_localctx = new CssPropertyValueContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(202); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(202);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case CSS_IDENTIFIER:
						{
						setState(189);
						match(CSS_IDENTIFIER);
						}
						break;
					case CSS_NUMBER:
						{
						setState(190);
						match(CSS_NUMBER);
						}
						break;
					case CSS_UNIT:
						{
						setState(191);
						match(CSS_UNIT);
						}
						break;
					case CSS_COLOR:
						{
						setState(192);
						match(CSS_COLOR);
						}
						break;
					case CSS_KEYWORD:
						{
						setState(193);
						match(CSS_KEYWORD);
						}
						break;
					case CSS_LPAREN:
						{
						setState(194);
						match(CSS_LPAREN);
						setState(198);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1+1 ) {
								{
								{
								setState(195);
								matchWildcard();
								}
								} 
							}
							setState(200);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
						}
						setState(201);
						match(CSS_RPAREN);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(204); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaVariableContext extends ParserRuleContext {
		public JinjaVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaVariable; }
	 
		public JinjaVariableContext() { }
		public void copyFrom(JinjaVariableContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaVariableExprContext extends JinjaVariableContext {
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode JINJA_VAR_CLOSE() { return getToken(HtmlParser.JINJA_VAR_CLOSE, 0); }
		public TerminalNode JINJA_VAR_OPEN() { return getToken(HtmlParser.JINJA_VAR_OPEN, 0); }
		public TerminalNode ATTR_DQ_JINJA_OPEN() { return getToken(HtmlParser.ATTR_DQ_JINJA_OPEN, 0); }
		public TerminalNode ATTR_JINJA() { return getToken(HtmlParser.ATTR_JINJA, 0); }
		public JinjaVariableExprContext(JinjaVariableContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaVariableExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaVariableExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaVariableExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaVariableContext jinjaVariable() throws RecognitionException {
		JinjaVariableContext _localctx = new JinjaVariableContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_jinjaVariable);
		int _la;
		try {
			_localctx = new JinjaVariableExprContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8912912L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(207);
			jinjaExpr();
			setState(208);
			match(JINJA_VAR_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaExprContext extends ParserRuleContext {
		public JinjaExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaExpr; }
	 
		public JinjaExprContext() { }
		public void copyFrom(JinjaExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaFunctionCallContext extends JinjaExprContext {
		public JinjaAtomContext jinjaAtom() {
			return getRuleContext(JinjaAtomContext.class,0);
		}
		public TerminalNode J_LPAREN() { return getToken(HtmlParser.J_LPAREN, 0); }
		public TerminalNode J_RPAREN() { return getToken(HtmlParser.J_RPAREN, 0); }
		public JinjaArgsContext jinjaArgs() {
			return getRuleContext(JinjaArgsContext.class,0);
		}
		public JinjaFunctionCallContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaDotAccessContext extends JinjaExprContext {
		public List<JinjaAtomContext> jinjaAtom() {
			return getRuleContexts(JinjaAtomContext.class);
		}
		public JinjaAtomContext jinjaAtom(int i) {
			return getRuleContext(JinjaAtomContext.class,i);
		}
		public List<TerminalNode> J_DOT() { return getTokens(HtmlParser.J_DOT); }
		public TerminalNode J_DOT(int i) {
			return getToken(HtmlParser.J_DOT, i);
		}
		public JinjaFilterContext jinjaFilter() {
			return getRuleContext(JinjaFilterContext.class,0);
		}
		public JinjaDotAccessContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaDotAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaDotAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaDotAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaSimpleExprContext extends JinjaExprContext {
		public JinjaAtomContext jinjaAtom() {
			return getRuleContext(JinjaAtomContext.class,0);
		}
		public JinjaSimpleExprContext(JinjaExprContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaSimpleExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaSimpleExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaSimpleExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaExprContext jinjaExpr() throws RecognitionException {
		JinjaExprContext _localctx = new JinjaExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_jinjaExpr);
		int _la;
		try {
			setState(229);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				_localctx = new JinjaFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(210);
				jinjaAtom();
				setState(211);
				match(J_LPAREN);
				setState(213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 62)) & ~0x3f) == 0 && ((1L << (_la - 62)) & 7L) != 0)) {
					{
					setState(212);
					jinjaArgs();
					}
				}

				setState(215);
				match(J_RPAREN);
				}
				break;
			case 2:
				_localctx = new JinjaDotAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(217);
				jinjaAtom();
				setState(222);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==J_DOT) {
					{
					{
					setState(218);
					match(J_DOT);
					setState(219);
					jinjaAtom();
					}
					}
					setState(224);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(226);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==J_LINE) {
					{
					setState(225);
					jinjaFilter();
					}
				}

				}
				break;
			case 3:
				_localctx = new JinjaSimpleExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(228);
				jinjaAtom();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaFilterContext extends ParserRuleContext {
		public JinjaFilterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaFilter; }
	 
		public JinjaFilterContext() { }
		public void copyFrom(JinjaFilterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaApplyFilterContext extends JinjaFilterContext {
		public TerminalNode J_LINE() { return getToken(HtmlParser.J_LINE, 0); }
		public TerminalNode J_IDENT() { return getToken(HtmlParser.J_IDENT, 0); }
		public JinjaApplyFilterContext(JinjaFilterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaApplyFilter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaApplyFilter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaApplyFilter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaFilterContext jinjaFilter() throws RecognitionException {
		JinjaFilterContext _localctx = new JinjaFilterContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_jinjaFilter);
		try {
			_localctx = new JinjaApplyFilterContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(J_LINE);
			setState(232);
			match(J_IDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaArgumentContext extends ParserRuleContext {
		public JinjaKeywordArgumentContext jinjaKeywordArgument() {
			return getRuleContext(JinjaKeywordArgumentContext.class,0);
		}
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public JinjaArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaArgumentContext jinjaArgument() throws RecognitionException {
		JinjaArgumentContext _localctx = new JinjaArgumentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_jinjaArgument);
		try {
			setState(236);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(234);
				jinjaKeywordArgument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				jinjaExpr();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaKeywordArgumentContext extends ParserRuleContext {
		public TerminalNode J_IDENT() { return getToken(HtmlParser.J_IDENT, 0); }
		public TerminalNode J_ASSIGN() { return getToken(HtmlParser.J_ASSIGN, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public JinjaKeywordArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaKeywordArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaKeywordArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaKeywordArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaKeywordArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaKeywordArgumentContext jinjaKeywordArgument() throws RecognitionException {
		JinjaKeywordArgumentContext _localctx = new JinjaKeywordArgumentContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_jinjaKeywordArgument);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(J_IDENT);
			setState(239);
			match(J_ASSIGN);
			setState(240);
			jinjaExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaArgsContext extends ParserRuleContext {
		public JinjaArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaArgs; }
	 
		public JinjaArgsContext() { }
		public void copyFrom(JinjaArgsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaArgListContext extends JinjaArgsContext {
		public List<JinjaArgumentContext> jinjaArgument() {
			return getRuleContexts(JinjaArgumentContext.class);
		}
		public JinjaArgumentContext jinjaArgument(int i) {
			return getRuleContext(JinjaArgumentContext.class,i);
		}
		public List<TerminalNode> J_COMMA() { return getTokens(HtmlParser.J_COMMA); }
		public TerminalNode J_COMMA(int i) {
			return getToken(HtmlParser.J_COMMA, i);
		}
		public JinjaArgListContext(JinjaArgsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaArgList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaArgList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaArgList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaArgsContext jinjaArgs() throws RecognitionException {
		JinjaArgsContext _localctx = new JinjaArgsContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_jinjaArgs);
		int _la;
		try {
			_localctx = new JinjaArgListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			jinjaArgument();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==J_COMMA) {
				{
				{
				setState(243);
				match(J_COMMA);
				setState(244);
				jinjaArgument();
				}
				}
				setState(249);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaAtomContext extends ParserRuleContext {
		public JinjaAtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaAtom; }
	 
		public JinjaAtomContext() { }
		public void copyFrom(JinjaAtomContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaNumberLiteralContext extends JinjaAtomContext {
		public TerminalNode J_NUMBER() { return getToken(HtmlParser.J_NUMBER, 0); }
		public JinjaNumberLiteralContext(JinjaAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaNumberLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaNumberLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIndexAccessContext extends JinjaAtomContext {
		public TerminalNode J_IDENT() { return getToken(HtmlParser.J_IDENT, 0); }
		public TerminalNode J_LBRACK() { return getToken(HtmlParser.J_LBRACK, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public TerminalNode J_RBRACK() { return getToken(HtmlParser.J_RBRACK, 0); }
		public JinjaIndexAccessContext(JinjaAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaIndexAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaIndexAccess(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaIndexAccess(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStringLiteralContext extends JinjaAtomContext {
		public TerminalNode J_STRING() { return getToken(HtmlParser.J_STRING, 0); }
		public JinjaStringLiteralContext(JinjaAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaStringLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIdentifierContext extends JinjaAtomContext {
		public TerminalNode J_IDENT() { return getToken(HtmlParser.J_IDENT, 0); }
		public JinjaIdentifierContext(JinjaAtomContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaAtomContext jinjaAtom() throws RecognitionException {
		JinjaAtomContext _localctx = new JinjaAtomContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_jinjaAtom);
		try {
			setState(258);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				_localctx = new JinjaIdentifierContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				match(J_IDENT);
				}
				break;
			case 2:
				_localctx = new JinjaIndexAccessContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(J_IDENT);
				setState(252);
				match(J_LBRACK);
				setState(253);
				jinjaExpr();
				setState(254);
				match(J_RBRACK);
				}
				break;
			case 3:
				_localctx = new JinjaStringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(256);
				match(J_STRING);
				}
				break;
			case 4:
				_localctx = new JinjaNumberLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(257);
				match(J_NUMBER);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaTagContext extends ParserRuleContext {
		public JinjaTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaTag; }
	 
		public JinjaTagContext() { }
		public void copyFrom(JinjaTagContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementTagContext extends JinjaTagContext {
		public TerminalNode JINJA_TAG_OPEN() { return getToken(HtmlParser.JINJA_TAG_OPEN, 0); }
		public JinjaStatementContext jinjaStatement() {
			return getRuleContext(JinjaStatementContext.class,0);
		}
		public TerminalNode JINJA_TAG_CLOSE() { return getToken(HtmlParser.JINJA_TAG_CLOSE, 0); }
		public JinjaStatementTagContext(JinjaTagContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaStatementTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaStatementTag(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaStatementTag(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaTagContext jinjaTag() throws RecognitionException {
		JinjaTagContext _localctx = new JinjaTagContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_jinjaTag);
		try {
			_localctx = new JinjaStatementTagContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(JINJA_TAG_OPEN);
			setState(261);
			jinjaStatement();
			setState(262);
			match(JINJA_TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaStatementContext extends ParserRuleContext {
		public JinjaStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaStatement; }
	 
		public JinjaStatementContext() { }
		public void copyFrom(JinjaStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaEndForStmtContext extends JinjaStatementContext {
		public JinjaEndForContext jinjaEndFor() {
			return getRuleContext(JinjaEndForContext.class,0);
		}
		public JinjaEndForStmtContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaEndForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaEndForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaEndForStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForStmtContext extends JinjaStatementContext {
		public JinjaForContext jinjaFor() {
			return getRuleContext(JinjaForContext.class,0);
		}
		public JinjaForStmtContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaForStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaForStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaForStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaEndIfStmtContext extends JinjaStatementContext {
		public JinjaEndIfContext jinjaEndIf() {
			return getRuleContext(JinjaEndIfContext.class,0);
		}
		public JinjaEndIfStmtContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaEndIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaEndIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaEndIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfStmtContext extends JinjaStatementContext {
		public JinjaIfContext jinjaIf() {
			return getRuleContext(JinjaIfContext.class,0);
		}
		public JinjaIfStmtContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElseStmtContext extends JinjaStatementContext {
		public JinjaElseContext jinjaElse() {
			return getRuleContext(JinjaElseContext.class,0);
		}
		public JinjaElseStmtContext(JinjaStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaStatementContext jinjaStatement() throws RecognitionException {
		JinjaStatementContext _localctx = new JinjaStatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_jinjaStatement);
		try {
			setState(269);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case J_FOR:
				_localctx = new JinjaForStmtContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(264);
				jinjaFor();
				}
				break;
			case J_IF:
				_localctx = new JinjaIfStmtContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(265);
				jinjaIf();
				}
				break;
			case J_ELSE:
				_localctx = new JinjaElseStmtContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(266);
				jinjaElse();
				}
				break;
			case J_ENDFOR:
				_localctx = new JinjaEndForStmtContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(267);
				jinjaEndFor();
				}
				break;
			case J_ENDIF:
				_localctx = new JinjaEndIfStmtContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(268);
				jinjaEndIf();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForContext extends ParserRuleContext {
		public JinjaForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaFor; }
	 
		public JinjaForContext() { }
		public void copyFrom(JinjaForContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ForLoopContext extends JinjaForContext {
		public TerminalNode J_FOR() { return getToken(HtmlParser.J_FOR, 0); }
		public LoopVariablesContext loopVariables() {
			return getRuleContext(LoopVariablesContext.class,0);
		}
		public TerminalNode J_IN() { return getToken(HtmlParser.J_IN, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public ForLoopContext(JinjaForContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterForLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitForLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitForLoop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForContext jinjaFor() throws RecognitionException {
		JinjaForContext _localctx = new JinjaForContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_jinjaFor);
		try {
			_localctx = new ForLoopContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			match(J_FOR);
			setState(272);
			loopVariables();
			setState(273);
			match(J_IN);
			setState(274);
			jinjaExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopVariablesContext extends ParserRuleContext {
		public LoopVariablesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopVariables; }
	 
		public LoopVariablesContext() { }
		public void copyFrom(LoopVariablesContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LoopVarsContext extends LoopVariablesContext {
		public List<TerminalNode> J_IDENT() { return getTokens(HtmlParser.J_IDENT); }
		public TerminalNode J_IDENT(int i) {
			return getToken(HtmlParser.J_IDENT, i);
		}
		public TerminalNode J_COMMA() { return getToken(HtmlParser.J_COMMA, 0); }
		public LoopVarsContext(LoopVariablesContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterLoopVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitLoopVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitLoopVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopVariablesContext loopVariables() throws RecognitionException {
		LoopVariablesContext _localctx = new LoopVariablesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_loopVariables);
		int _la;
		try {
			_localctx = new LoopVarsContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			match(J_IDENT);
			setState(279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==J_COMMA) {
				{
				setState(277);
				match(J_COMMA);
				setState(278);
				match(J_IDENT);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaEndForContext extends ParserRuleContext {
		public JinjaEndForContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaEndFor; }
	 
		public JinjaEndForContext() { }
		public void copyFrom(JinjaEndForContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndForContext extends JinjaEndForContext {
		public TerminalNode J_ENDFOR() { return getToken(HtmlParser.J_ENDFOR, 0); }
		public EndForContext(JinjaEndForContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterEndFor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitEndFor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitEndFor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaEndForContext jinjaEndFor() throws RecognitionException {
		JinjaEndForContext _localctx = new JinjaEndForContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_jinjaEndFor);
		try {
			_localctx = new EndForContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			match(J_ENDFOR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfBlockContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_TAG_OPEN() { return getTokens(HtmlParser.JINJA_TAG_OPEN); }
		public TerminalNode JINJA_TAG_OPEN(int i) {
			return getToken(HtmlParser.JINJA_TAG_OPEN, i);
		}
		public JinjaIfContext jinjaIf() {
			return getRuleContext(JinjaIfContext.class,0);
		}
		public List<TerminalNode> JINJA_TAG_CLOSE() { return getTokens(HtmlParser.JINJA_TAG_CLOSE); }
		public TerminalNode JINJA_TAG_CLOSE(int i) {
			return getToken(HtmlParser.JINJA_TAG_CLOSE, i);
		}
		public JinjaEndIfContext jinjaEndIf() {
			return getRuleContext(JinjaEndIfContext.class,0);
		}
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public JinjaIfBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIfBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaIfBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaIfBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaIfBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfBlockContext jinjaIfBlock() throws RecognitionException {
		JinjaIfBlockContext _localctx = new JinjaIfBlockContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_jinjaIfBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			match(JINJA_TAG_OPEN);
			setState(284);
			jinjaIf();
			setState(285);
			match(JINJA_TAG_CLOSE);
			setState(289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(286);
					htmlContent();
					}
					} 
				}
				setState(291);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,31,_ctx);
			}
			setState(292);
			match(JINJA_TAG_OPEN);
			setState(293);
			jinjaEndIf();
			setState(294);
			match(JINJA_TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaIfContext extends ParserRuleContext {
		public JinjaIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaIf; }
	 
		public JinjaIfContext() { }
		public void copyFrom(JinjaIfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IfStmtContext extends JinjaIfContext {
		public TerminalNode J_IF() { return getToken(HtmlParser.J_IF, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public IfStmtContext(JinjaIfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterIfStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitIfStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitIfStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaIfContext jinjaIf() throws RecognitionException {
		JinjaIfContext _localctx = new JinjaIfContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_jinjaIf);
		try {
			_localctx = new IfStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(296);
			match(J_IF);
			setState(297);
			jinjaExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaEndIfContext extends ParserRuleContext {
		public JinjaEndIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaEndIf; }
	 
		public JinjaEndIfContext() { }
		public void copyFrom(JinjaEndIfContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EndIfContext extends JinjaEndIfContext {
		public TerminalNode J_ENDIF() { return getToken(HtmlParser.J_ENDIF, 0); }
		public EndIfContext(JinjaEndIfContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterEndIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitEndIf(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitEndIf(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaEndIfContext jinjaEndIf() throws RecognitionException {
		JinjaEndIfContext _localctx = new JinjaEndIfContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_jinjaEndIf);
		try {
			_localctx = new EndIfContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(J_ENDIF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElseContext extends ParserRuleContext {
		public JinjaElseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElse; }
	 
		public JinjaElseContext() { }
		public void copyFrom(JinjaElseContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElseStmtContext extends JinjaElseContext {
		public TerminalNode J_ELSE() { return getToken(HtmlParser.J_ELSE, 0); }
		public ElseStmtContext(JinjaElseContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterElseStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitElseStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitElseStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElseContext jinjaElse() throws RecognitionException {
		JinjaElseContext _localctx = new JinjaElseContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_jinjaElse);
		try {
			_localctx = new ElseStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			match(J_ELSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaElifContext extends ParserRuleContext {
		public JinjaElifContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaElif; }
	 
		public JinjaElifContext() { }
		public void copyFrom(JinjaElifContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElifStmtContext extends JinjaElifContext {
		public TerminalNode J_ELIF() { return getToken(HtmlParser.J_ELIF, 0); }
		public JinjaExprContext jinjaExpr() {
			return getRuleContext(JinjaExprContext.class,0);
		}
		public ElifStmtContext(JinjaElifContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterElifStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitElifStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitElifStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaElifContext jinjaElif() throws RecognitionException {
		JinjaElifContext _localctx = new JinjaElifContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_jinjaElif);
		try {
			_localctx = new ElifStmtContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(303);
			match(J_ELIF);
			setState(304);
			jinjaExpr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaForBlockContext extends ParserRuleContext {
		public List<TerminalNode> JINJA_TAG_OPEN() { return getTokens(HtmlParser.JINJA_TAG_OPEN); }
		public TerminalNode JINJA_TAG_OPEN(int i) {
			return getToken(HtmlParser.JINJA_TAG_OPEN, i);
		}
		public JinjaForContext jinjaFor() {
			return getRuleContext(JinjaForContext.class,0);
		}
		public List<TerminalNode> JINJA_TAG_CLOSE() { return getTokens(HtmlParser.JINJA_TAG_CLOSE); }
		public TerminalNode JINJA_TAG_CLOSE(int i) {
			return getToken(HtmlParser.JINJA_TAG_CLOSE, i);
		}
		public JinjaEndForContext jinjaEndFor() {
			return getRuleContext(JinjaEndForContext.class,0);
		}
		public List<HtmlContentContext> htmlContent() {
			return getRuleContexts(HtmlContentContext.class);
		}
		public HtmlContentContext htmlContent(int i) {
			return getRuleContext(HtmlContentContext.class,i);
		}
		public JinjaForBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaForBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaForBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaForBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaForBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaForBlockContext jinjaForBlock() throws RecognitionException {
		JinjaForBlockContext _localctx = new JinjaForBlockContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_jinjaForBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(306);
			match(JINJA_TAG_OPEN);
			setState(307);
			jinjaFor();
			setState(308);
			match(JINJA_TAG_CLOSE);
			setState(312);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(309);
					htmlContent();
					}
					} 
				}
				setState(314);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			}
			setState(315);
			match(JINJA_TAG_OPEN);
			setState(316);
			jinjaEndFor();
			setState(317);
			match(JINJA_TAG_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JinjaContentContext extends ParserRuleContext {
		public HtmlContentContext htmlContent() {
			return getRuleContext(HtmlContentContext.class,0);
		}
		public JinjaContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jinjaContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).enterJinjaContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof HtmlParserListener ) ((HtmlParserListener)listener).exitJinjaContent(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof HtmlParserVisitor ) return ((HtmlParserVisitor<? extends T>)visitor).visitJinjaContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JinjaContentContext jinjaContent() throws RecognitionException {
		JinjaContentContext _localctx = new JinjaContentContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_jinjaContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319);
			htmlContent();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\u0004\u0001A\u0142\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0001\u0000\u0003\u0000D\b\u0000"+
		"\u0001\u0000\u0005\u0000G\b\u0000\n\u0000\f\u0000J\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0005\u0001P\b\u0001\n\u0001\f\u0001"+
		"S\t\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001X\b\u0001\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0005\u0002]\b\u0002\n\u0002\f\u0002`\t"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0005\u0004i\b\u0004\n\u0004\f\u0004l\t\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005t\b\u0005\u0001\u0006\u0001\u0006\u0005\u0006x\b\u0006\n\u0006\f"+
		"\u0006{\t\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0004"+
		"\u0006\u0081\b\u0006\u000b\u0006\f\u0006\u0082\u0003\u0006\u0085\b\u0006"+
		"\u0001\u0007\u0001\u0007\u0003\u0007\u0089\b\u0007\u0001\b\u0001\b\u0001"+
		"\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0003\b\u0095"+
		"\b\b\u0001\t\u0001\t\u0005\t\u0099\b\t\n\t\f\t\u009c\t\t\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u00a1\b\n\n\n\f\n\u00a4\t\n\u0001\n\u0001\n\u0001\u000b"+
		"\u0004\u000b\u00a9\b\u000b\u000b\u000b\f\u000b\u00aa\u0001\u000b\u0001"+
		"\u000b\u0004\u000b\u00af\b\u000b\u000b\u000b\f\u000b\u00b0\u0005\u000b"+
		"\u00b3\b\u000b\n\u000b\f\u000b\u00b6\t\u000b\u0001\f\u0001\f\u0001\f\u0001"+
		"\f\u0003\f\u00bc\b\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u00c5\b\r\n\r\f\r\u00c8\t\r\u0001\r\u0004\r\u00cb\b\r\u000b"+
		"\r\f\r\u00cc\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0003\u000f\u00d6\b\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u00dd\b\u000f\n\u000f"+
		"\f\u000f\u00e0\t\u000f\u0001\u000f\u0003\u000f\u00e3\b\u000f\u0001\u000f"+
		"\u0003\u000f\u00e6\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0001\u0011\u0003\u0011\u00ed\b\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0005\u0013\u00f6\b\u0013"+
		"\n\u0013\f\u0013\u00f9\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001"+
		"\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u0103"+
		"\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001"+
		"\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u010e\b\u0016\u0001"+
		"\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u0118\b\u0018\u0001\u0019\u0001\u0019\u0001"+
		"\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0120\b\u001a\n"+
		"\u001a\f\u001a\u0123\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001"+
		"\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0137\b\u001f\n\u001f\f\u001f"+
		"\u013a\t\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 "+
		"\u0001 \u0001 \u0001\u00c6\u0000!\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@\u0000"+
		"\u0004\u0001\u0000\n\u000b\u0001\u0000\u0011\u0012\u0002\u0000\u001f "+
		"((\u0003\u0000\u0004\u0004\u0013\u0013\u0017\u0017\u0152\u0000C\u0001"+
		"\u0000\u0000\u0000\u0002W\u0001\u0000\u0000\u0000\u0004Y\u0001\u0000\u0000"+
		"\u0000\u0006c\u0001\u0000\u0000\u0000\be\u0001\u0000\u0000\u0000\ns\u0001"+
		"\u0000\u0000\u0000\f\u0084\u0001\u0000\u0000\u0000\u000e\u0088\u0001\u0000"+
		"\u0000\u0000\u0010\u0094\u0001\u0000\u0000\u0000\u0012\u009a\u0001\u0000"+
		"\u0000\u0000\u0014\u009d\u0001\u0000\u0000\u0000\u0016\u00a8\u0001\u0000"+
		"\u0000\u0000\u0018\u00b7\u0001\u0000\u0000\u0000\u001a\u00ca\u0001\u0000"+
		"\u0000\u0000\u001c\u00ce\u0001\u0000\u0000\u0000\u001e\u00e5\u0001\u0000"+
		"\u0000\u0000 \u00e7\u0001\u0000\u0000\u0000\"\u00ec\u0001\u0000\u0000"+
		"\u0000$\u00ee\u0001\u0000\u0000\u0000&\u00f2\u0001\u0000\u0000\u0000("+
		"\u0102\u0001\u0000\u0000\u0000*\u0104\u0001\u0000\u0000\u0000,\u010d\u0001"+
		"\u0000\u0000\u0000.\u010f\u0001\u0000\u0000\u00000\u0114\u0001\u0000\u0000"+
		"\u00002\u0119\u0001\u0000\u0000\u00004\u011b\u0001\u0000\u0000\u00006"+
		"\u0128\u0001\u0000\u0000\u00008\u012b\u0001\u0000\u0000\u0000:\u012d\u0001"+
		"\u0000\u0000\u0000<\u012f\u0001\u0000\u0000\u0000>\u0132\u0001\u0000\u0000"+
		"\u0000@\u013f\u0001\u0000\u0000\u0000BD\u0005\u0001\u0000\u0000CB\u0001"+
		"\u0000\u0000\u0000CD\u0001\u0000\u0000\u0000DH\u0001\u0000\u0000\u0000"+
		"EG\u0003\u0002\u0001\u0000FE\u0001\u0000\u0000\u0000GJ\u0001\u0000\u0000"+
		"\u0000HF\u0001\u0000\u0000\u0000HI\u0001\u0000\u0000\u0000IK\u0001\u0000"+
		"\u0000\u0000JH\u0001\u0000\u0000\u0000KL\u0005\u0000\u0000\u0001L\u0001"+
		"\u0001\u0000\u0000\u0000MQ\u0003\u0004\u0002\u0000NP\u0003\u0010\b\u0000"+
		"ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QO\u0001\u0000\u0000"+
		"\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000TU\u0003\u0006\u0003\u0000UX\u0001\u0000\u0000\u0000VX\u0003"+
		"\b\u0004\u0000WM\u0001\u0000\u0000\u0000WV\u0001\u0000\u0000\u0000X\u0003"+
		"\u0001\u0000\u0000\u0000YZ\u0005\u0007\u0000\u0000Z^\u0005\u000e\u0000"+
		"\u0000[]\u0003\n\u0005\u0000\\[\u0001\u0000\u0000\u0000]`\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_a\u0001"+
		"\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000ab\u0007\u0000\u0000\u0000"+
		"b\u0005\u0001\u0000\u0000\u0000cd\u0005\b\u0000\u0000d\u0007\u0001\u0000"+
		"\u0000\u0000ef\u0005\u0007\u0000\u0000fj\u0005\r\u0000\u0000gi\u0003\n"+
		"\u0005\u0000hg\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000km\u0001\u0000\u0000\u0000"+
		"lj\u0001\u0000\u0000\u0000mn\u0005\n\u0000\u0000n\t\u0001\u0000\u0000"+
		"\u0000ot\u0005\u000e\u0000\u0000pq\u0005\u000e\u0000\u0000qr\u0005\f\u0000"+
		"\u0000rt\u0003\f\u0006\u0000so\u0001\u0000\u0000\u0000sp\u0001\u0000\u0000"+
		"\u0000t\u000b\u0001\u0000\u0000\u0000uy\u0005\u0015\u0000\u0000vx\u0003"+
		"\u000e\u0007\u0000wv\u0001\u0000\u0000\u0000x{\u0001\u0000\u0000\u0000"+
		"yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z|\u0001\u0000\u0000"+
		"\u0000{y\u0001\u0000\u0000\u0000|\u0085\u0005\u0019\u0000\u0000}\u0085"+
		"\u0005\u0014\u0000\u0000~\u0085\u0003\u001c\u000e\u0000\u007f\u0081\u0007"+
		"\u0001\u0000\u0000\u0080\u007f\u0001\u0000\u0000\u0000\u0081\u0082\u0001"+
		"\u0000\u0000\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001"+
		"\u0000\u0000\u0000\u0083\u0085\u0001\u0000\u0000\u0000\u0084u\u0001\u0000"+
		"\u0000\u0000\u0084}\u0001\u0000\u0000\u0000\u0084~\u0001\u0000\u0000\u0000"+
		"\u0084\u0080\u0001\u0000\u0000\u0000\u0085\r\u0001\u0000\u0000\u0000\u0086"+
		"\u0089\u0005\u0018\u0000\u0000\u0087\u0089\u0003\u001c\u000e\u0000\u0088"+
		"\u0086\u0001\u0000\u0000\u0000\u0088\u0087\u0001\u0000\u0000\u0000\u0089"+
		"\u000f\u0001\u0000\u0000\u0000\u008a\u0095\u0005\t\u0000\u0000\u008b\u0095"+
		"\u0003\u0002\u0001\u0000\u008c\u0095\u0003\u001c\u000e\u0000\u008d\u0095"+
		"\u00034\u001a\u0000\u008e\u0095\u0003>\u001f\u0000\u008f\u0095\u0003*"+
		"\u0015\u0000\u0090\u0091\u0005\u0003\u0000\u0000\u0091\u0092\u0003\u0012"+
		"\t\u0000\u0092\u0093\u0005\u001a\u0000\u0000\u0093\u0095\u0001\u0000\u0000"+
		"\u0000\u0094\u008a\u0001\u0000\u0000\u0000\u0094\u008b\u0001\u0000\u0000"+
		"\u0000\u0094\u008c\u0001\u0000\u0000\u0000\u0094\u008d\u0001\u0000\u0000"+
		"\u0000\u0094\u008e\u0001\u0000\u0000\u0000\u0094\u008f\u0001\u0000\u0000"+
		"\u0000\u0094\u0090\u0001\u0000\u0000\u0000\u0095\u0011\u0001\u0000\u0000"+
		"\u0000\u0096\u0099\u0003\u0014\n\u0000\u0097\u0099\u0005)\u0000\u0000"+
		"\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0097\u0001\u0000\u0000\u0000"+
		"\u0099\u009c\u0001\u0000\u0000\u0000\u009a\u0098\u0001\u0000\u0000\u0000"+
		"\u009a\u009b\u0001\u0000\u0000\u0000\u009b\u0013\u0001\u0000\u0000\u0000"+
		"\u009c\u009a\u0001\u0000\u0000\u0000\u009d\u009e\u0003\u0016\u000b\u0000"+
		"\u009e\u00a2\u0005\u001d\u0000\u0000\u009f\u00a1\u0003\u0018\f\u0000\u00a0"+
		"\u009f\u0001\u0000\u0000\u0000\u00a1\u00a4\u0001\u0000\u0000\u0000\u00a2"+
		"\u00a0\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3"+
		"\u00a5\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000\u00a5"+
		"\u00a6\u0005\u001e\u0000\u0000\u00a6\u0015\u0001\u0000\u0000\u0000\u00a7"+
		"\u00a9\u0007\u0002\u0000\u0000\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0001\u0000\u0000\u0000\u00aa\u00a8\u0001\u0000\u0000\u0000\u00aa"+
		"\u00ab\u0001\u0000\u0000\u0000\u00ab\u00b4\u0001\u0000\u0000\u0000\u00ac"+
		"\u00ae\u0005#\u0000\u0000\u00ad\u00af\u0007\u0002\u0000\u0000\u00ae\u00ad"+
		"\u0001\u0000\u0000\u0000\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00ae"+
		"\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b2\u00ac\u0001\u0000\u0000\u0000\u00b3\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b4\u00b2\u0001\u0000\u0000\u0000\u00b4\u00b5"+
		"\u0001\u0000\u0000\u0000\u00b5\u0017\u0001\u0000\u0000\u0000\u00b6\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b8\u0005(\u0000\u0000\u00b8\u00b9\u0005"+
		"\u001b\u0000\u0000\u00b9\u00bb\u0003\u001a\r\u0000\u00ba\u00bc\u0005\u001c"+
		"\u0000\u0000\u00bb\u00ba\u0001\u0000\u0000\u0000\u00bb\u00bc\u0001\u0000"+
		"\u0000\u0000\u00bc\u0019\u0001\u0000\u0000\u0000\u00bd\u00cb\u0005(\u0000"+
		"\u0000\u00be\u00cb\u0005$\u0000\u0000\u00bf\u00cb\u0005%\u0000\u0000\u00c0"+
		"\u00cb\u0005&\u0000\u0000\u00c1\u00cb\u0005\'\u0000\u0000\u00c2\u00c6"+
		"\u0005!\u0000\u0000\u00c3\u00c5\t\u0000\u0000\u0000\u00c4\u00c3\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c8\u0001\u0000\u0000\u0000\u00c6\u00c7\u0001"+
		"\u0000\u0000\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000\u00c7\u00c9\u0001"+
		"\u0000\u0000\u0000\u00c8\u00c6\u0001\u0000\u0000\u0000\u00c9\u00cb\u0005"+
		"\"\u0000\u0000\u00ca\u00bd\u0001\u0000\u0000\u0000\u00ca\u00be\u0001\u0000"+
		"\u0000\u0000\u00ca\u00bf\u0001\u0000\u0000\u0000\u00ca\u00c0\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c1\u0001\u0000\u0000\u0000\u00ca\u00c2\u0001\u0000"+
		"\u0000\u0000\u00cb\u00cc\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u001b\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0007\u0003\u0000\u0000\u00cf\u00d0\u0003\u001e"+
		"\u000f\u0000\u00d0\u00d1\u0005+\u0000\u0000\u00d1\u001d\u0001\u0000\u0000"+
		"\u0000\u00d2\u00d3\u0003(\u0014\u0000\u00d3\u00d5\u00057\u0000\u0000\u00d4"+
		"\u00d6\u0003&\u0013\u0000\u00d5\u00d4\u0001\u0000\u0000\u0000\u00d5\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d6\u00d7\u0001\u0000\u0000\u0000\u00d7\u00d8"+
		"\u00058\u0000\u0000\u00d8\u00e6\u0001\u0000\u0000\u0000\u00d9\u00de\u0003"+
		"(\u0014\u0000\u00da\u00db\u00056\u0000\u0000\u00db\u00dd\u0003(\u0014"+
		"\u0000\u00dc\u00da\u0001\u0000\u0000\u0000\u00dd\u00e0\u0001\u0000\u0000"+
		"\u0000\u00de\u00dc\u0001\u0000\u0000\u0000\u00de\u00df\u0001\u0000\u0000"+
		"\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000\u0000"+
		"\u0000\u00e1\u00e3\u0003 \u0010\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000"+
		"\u00e2\u00e3\u0001\u0000\u0000\u0000\u00e3\u00e6\u0001\u0000\u0000\u0000"+
		"\u00e4\u00e6\u0003(\u0014\u0000\u00e5\u00d2\u0001\u0000\u0000\u0000\u00e5"+
		"\u00d9\u0001\u0000\u0000\u0000\u00e5\u00e4\u0001\u0000\u0000\u0000\u00e6"+
		"\u001f\u0001\u0000\u0000\u0000\u00e7\u00e8\u00055\u0000\u0000\u00e8\u00e9"+
		"\u0005>\u0000\u0000\u00e9!\u0001\u0000\u0000\u0000\u00ea\u00ed\u0003$"+
		"\u0012\u0000\u00eb\u00ed\u0003\u001e\u000f\u0000\u00ec\u00ea\u0001\u0000"+
		"\u0000\u0000\u00ec\u00eb\u0001\u0000\u0000\u0000\u00ed#\u0001\u0000\u0000"+
		"\u0000\u00ee\u00ef\u0005>\u0000\u0000\u00ef\u00f0\u0005<\u0000\u0000\u00f0"+
		"\u00f1\u0003\u001e\u000f\u0000\u00f1%\u0001\u0000\u0000\u0000\u00f2\u00f7"+
		"\u0003\"\u0011\u0000\u00f3\u00f4\u0005;\u0000\u0000\u00f4\u00f6\u0003"+
		"\"\u0011\u0000\u00f5\u00f3\u0001\u0000\u0000\u0000\u00f6\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f8\u0001\u0000"+
		"\u0000\u0000\u00f8\'\u0001\u0000\u0000\u0000\u00f9\u00f7\u0001\u0000\u0000"+
		"\u0000\u00fa\u0103\u0005>\u0000\u0000\u00fb\u00fc\u0005>\u0000\u0000\u00fc"+
		"\u00fd\u00059\u0000\u0000\u00fd\u00fe\u0003\u001e\u000f\u0000\u00fe\u00ff"+
		"\u0005:\u0000\u0000\u00ff\u0103\u0001\u0000\u0000\u0000\u0100\u0103\u0005"+
		"?\u0000\u0000\u0101\u0103\u0005@\u0000\u0000\u0102\u00fa\u0001\u0000\u0000"+
		"\u0000\u0102\u00fb\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000\u0000"+
		"\u0000\u0102\u0101\u0001\u0000\u0000\u0000\u0103)\u0001\u0000\u0000\u0000"+
		"\u0104\u0105\u0005\u0005\u0000\u0000\u0105\u0106\u0003,\u0016\u0000\u0106"+
		"\u0107\u0005,\u0000\u0000\u0107+\u0001\u0000\u0000\u0000\u0108\u010e\u0003"+
		".\u0017\u0000\u0109\u010e\u00036\u001b\u0000\u010a\u010e\u0003:\u001d"+
		"\u0000\u010b\u010e\u00032\u0019\u0000\u010c\u010e\u00038\u001c\u0000\u010d"+
		"\u0108\u0001\u0000\u0000\u0000\u010d\u0109\u0001\u0000\u0000\u0000\u010d"+
		"\u010a\u0001\u0000\u0000\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010d"+
		"\u010c\u0001\u0000\u0000\u0000\u010e-\u0001\u0000\u0000\u0000\u010f\u0110"+
		"\u0005/\u0000\u0000\u0110\u0111\u00030\u0018\u0000\u0111\u0112\u00050"+
		"\u0000\u0000\u0112\u0113\u0003\u001e\u000f\u0000\u0113/\u0001\u0000\u0000"+
		"\u0000\u0114\u0117\u0005>\u0000\u0000\u0115\u0116\u0005;\u0000\u0000\u0116"+
		"\u0118\u0005>\u0000\u0000\u0117\u0115\u0001\u0000\u0000\u0000\u0117\u0118"+
		"\u0001\u0000\u0000\u0000\u01181\u0001\u0000\u0000\u0000\u0119\u011a\u0005"+
		"2\u0000\u0000\u011a3\u0001\u0000\u0000\u0000\u011b\u011c\u0005\u0005\u0000"+
		"\u0000\u011c\u011d\u00036\u001b\u0000\u011d\u0121\u0005,\u0000\u0000\u011e"+
		"\u0120\u0003\u0010\b\u0000\u011f\u011e\u0001\u0000\u0000\u0000\u0120\u0123"+
		"\u0001\u0000\u0000\u0000\u0121\u011f\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0124\u0001\u0000\u0000\u0000\u0123\u0121"+
		"\u0001\u0000\u0000\u0000\u0124\u0125\u0005\u0005\u0000\u0000\u0125\u0126"+
		"\u00038\u001c\u0000\u0126\u0127\u0005,\u0000\u0000\u01275\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0005-\u0000\u0000\u0129\u012a\u0003\u001e\u000f"+
		"\u0000\u012a7\u0001\u0000\u0000\u0000\u012b\u012c\u00051\u0000\u0000\u012c"+
		"9\u0001\u0000\u0000\u0000\u012d\u012e\u0005.\u0000\u0000\u012e;\u0001"+
		"\u0000\u0000\u0000\u012f\u0130\u00054\u0000\u0000\u0130\u0131\u0003\u001e"+
		"\u000f\u0000\u0131=\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u0005\u0000"+
		"\u0000\u0133\u0134\u0003.\u0017\u0000\u0134\u0138\u0005,\u0000\u0000\u0135"+
		"\u0137\u0003\u0010\b\u0000\u0136\u0135\u0001\u0000\u0000\u0000\u0137\u013a"+
		"\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000\u0000\u0000\u0138\u0139"+
		"\u0001\u0000\u0000\u0000\u0139\u013b\u0001\u0000\u0000\u0000\u013a\u0138"+
		"\u0001\u0000\u0000\u0000\u013b\u013c\u0005\u0005\u0000\u0000\u013c\u013d"+
		"\u00032\u0019\u0000\u013d\u013e\u0005,\u0000\u0000\u013e?\u0001\u0000"+
		"\u0000\u0000\u013f\u0140\u0003\u0010\b\u0000\u0140A\u0001\u0000\u0000"+
		"\u0000!CHQW^jsy\u0082\u0084\u0088\u0094\u0098\u009a\u00a2\u00aa\u00b0"+
		"\u00b4\u00bb\u00c6\u00ca\u00cc\u00d5\u00de\u00e2\u00e5\u00ec\u00f7\u0102"+
		"\u010d\u0117\u0121\u0138";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}