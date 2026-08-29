// Generated from C:/Project 1/CompilerProject5678/src/python/FlaskLexer.g4 by ANTLR 4.13.2
package python;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class FlaskLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		INDENT=1, DEDENT=2, LINE_JOIN=3, PY_FROM=4, PY_IMPORT=5, PY_RETURN=6, 
		PY_FUNCTION=7, PY_GLOBAL=8, PY_IF=9, PY_ELIF=10, PY_ELSE=11, PY_FOR=12, 
		PY_BREAK=13, PY_CONTINUE=14, PY_IN=15, PY_WHILE=16, PY_SELF=17, PY_CLASS=18, 
		PY_BOOLEAN=19, PY_NONE=20, PY_COLON=21, PY_AT=22, PY_LCURLY=23, PY_RCURLY=24, 
		PY_LBRACK=25, PY_RBRACK=26, PY_LPAREN=27, PY_RPAREN=28, PY_COMMA=29, PY_ASSIGN=30, 
		PY_DOT=31, PY_PLUS=32, PY_MINUS=33, PY_STAR=34, PY_DIV=35, PY_COMPARISON_OPERATOR=36, 
		PY_LOGICAL_OPERATOR=37, NEWLINE=38, WS=39, PY_COMMENT=40, PY_IDENTIFIER=41, 
		PY_STRING=42, PY_NUMBER=43;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LINE_JOIN", "PY_FROM", "PY_IMPORT", "PY_RETURN", "PY_FUNCTION", "PY_GLOBAL", 
			"PY_IF", "PY_ELIF", "PY_ELSE", "PY_FOR", "PY_BREAK", "PY_CONTINUE", "PY_IN", 
			"PY_WHILE", "PY_SELF", "PY_CLASS", "PY_BOOLEAN", "PY_NONE", "PY_COLON", 
			"PY_AT", "PY_LCURLY", "PY_RCURLY", "PY_LBRACK", "PY_RBRACK", "PY_LPAREN", 
			"PY_RPAREN", "PY_COMMA", "PY_ASSIGN", "PY_DOT", "PY_PLUS", "PY_MINUS", 
			"PY_STAR", "PY_DIV", "PY_COMPARISON_OPERATOR", "PY_LOGICAL_OPERATOR", 
			"NEWLINE", "WS", "PY_COMMENT", "PY_IDENTIFIER", "PY_STRING", "PY_NUMBER", 
			"INT", "FLOAT", "PY_DIGIT", "PY_LETTER"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'from'", "'import'", "'return'", "'def'", "'global'", 
			"'if'", "'elif'", "'else'", "'for'", "'break'", "'continue'", "'in'", 
			"'while'", "'self'", "'class'", null, "'None'", "':'", "'@'", "'{'", 
			"'}'", "'['", "']'", "'('", "')'", "','", "'='", "'.'", "'+'", "'-'", 
			"'*'", "'/'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "INDENT", "DEDENT", "LINE_JOIN", "PY_FROM", "PY_IMPORT", "PY_RETURN", 
			"PY_FUNCTION", "PY_GLOBAL", "PY_IF", "PY_ELIF", "PY_ELSE", "PY_FOR", 
			"PY_BREAK", "PY_CONTINUE", "PY_IN", "PY_WHILE", "PY_SELF", "PY_CLASS", 
			"PY_BOOLEAN", "PY_NONE", "PY_COLON", "PY_AT", "PY_LCURLY", "PY_RCURLY", 
			"PY_LBRACK", "PY_RBRACK", "PY_LPAREN", "PY_RPAREN", "PY_COMMA", "PY_ASSIGN", 
			"PY_DOT", "PY_PLUS", "PY_MINUS", "PY_STAR", "PY_DIV", "PY_COMPARISON_OPERATOR", 
			"PY_LOGICAL_OPERATOR", "NEWLINE", "WS", "PY_COMMENT", "PY_IDENTIFIER", 
			"PY_STRING", "PY_NUMBER"
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


	public FlaskLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FlaskLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 20:
			PY_LCURLY_action((RuleContext)_localctx, actionIndex);
			break;
		case 21:
			PY_RCURLY_action((RuleContext)_localctx, actionIndex);
			break;
		case 22:
			PY_LBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 23:
			PY_RBRACK_action((RuleContext)_localctx, actionIndex);
			break;
		case 24:
			PY_LPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 25:
			PY_RPAREN_action((RuleContext)_localctx, actionIndex);
			break;
		case 35:
			NEWLINE_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void PY_LCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 opened++; 
			break;
		}
	}
	private void PY_RCURLY_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 1:
			 opened--; 
			break;
		}
	}
	private void PY_LBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 2:
			 opened++; 
			break;
		}
	}
	private void PY_RBRACK_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 3:
			 opened--; 
			break;
		}
	}
	private void PY_LPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 4:
			 opened++; 
			break;
		}
	}
	private void PY_RPAREN_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 5:
			 opened--; 
			break;
		}
	}
	private void NEWLINE_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 6:

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
			    
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 35:
			return NEWLINE_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean NEWLINE_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return atStartOfInput();
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0000+\u019c\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"+
		"\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"+
		"\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"+
		"\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"+
		"\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"+
		"\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"+
		"!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"+
		"&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"+
		"+\u0002,\u0007,\u0001\u0000\u0001\u0000\u0005\u0000^\b\u0000\n\u0000\f"+
		"\u0000a\t\u0000\u0001\u0000\u0003\u0000d\b\u0000\u0001\u0000\u0001\u0000"+
		"\u0003\u0000h\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004"+
		"\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001\u0005\u0001\u0005"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u00c7\b\u0010\u0001\u0011"+
		"\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0019"+
		"\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0003!\u00fb\b!\u0001\"\u0001\"\u0001\""+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u0105\b\"\u0001#\u0001"+
		"#\u0004#\u0109\b#\u000b#\f#\u010a\u0001#\u0003#\u010e\b#\u0001#\u0001"+
		"#\u0003#\u0112\b#\u0001#\u0005#\u0115\b#\n#\f#\u0118\t#\u0003#\u011a\b"+
		"#\u0001#\u0001#\u0001$\u0004$\u011f\b$\u000b$\f$\u0120\u0001$\u0001$\u0001"+
		"%\u0001%\u0005%\u0127\b%\n%\f%\u012a\t%\u0001%\u0001%\u0001&\u0001&\u0003"+
		"&\u0130\b&\u0001&\u0001&\u0001&\u0005&\u0135\b&\n&\f&\u0138\t&\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u0141\b\'\n\'"+
		"\f\'\u0144\t\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0005\'\u0150\b\'\n\'\f\'\u0153\t\'\u0001\'\u0001"+
		"\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u015c\b\'\n\'\f\'\u015f"+
		"\t\'\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'\u0005\'\u0166\b\'\n\'\f\'"+
		"\u0169\t\'\u0001\'\u0003\'\u016c\b\'\u0001(\u0001(\u0003(\u0170\b(\u0001"+
		")\u0003)\u0173\b)\u0001)\u0001)\u0001)\u0005)\u0178\b)\n)\f)\u017b\t)"+
		"\u0003)\u017d\b)\u0001*\u0003*\u0180\b*\u0001*\u0005*\u0183\b*\n*\f*\u0186"+
		"\t*\u0001*\u0001*\u0004*\u018a\b*\u000b*\f*\u018b\u0001*\u0001*\u0003"+
		"*\u0190\b*\u0001*\u0004*\u0193\b*\u000b*\f*\u0194\u0003*\u0197\b*\u0001"+
		"+\u0001+\u0001,\u0001,\u0002\u0142\u0151\u0000-\u0001\u0003\u0003\u0004"+
		"\u0005\u0005\u0007\u0006\t\u0007\u000b\b\r\t\u000f\n\u0011\u000b\u0013"+
		"\f\u0015\r\u0017\u000e\u0019\u000f\u001b\u0010\u001d\u0011\u001f\u0012"+
		"!\u0013#\u0014%\u0015\'\u0016)\u0017+\u0018-\u0019/\u001a1\u001b3\u001c"+
		"5\u001d7\u001e9\u001f; =!?\"A#C$E%G&I\'K(M)O*Q+S\u0000U\u0000W\u0000Y"+
		"\u0000\u0001\u0000\n\u0002\u0000\t\t  \u0002\u0000<<>>\u0002\u0000\n\n"+
		"\r\r\u0001\u0000\"\"\u0001\u0000\'\'\u0001\u000019\u0001\u000009\u0002"+
		"\u0000EEee\u0002\u0000++--\u0002\u0000AZaz\u01c1\u0000\u0001\u0001\u0000"+
		"\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000"+
		"\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000"+
		"\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000"+
		"\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000"+
		"\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000"+
		"\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000"+
		"\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000"+
		"#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001"+
		"\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000"+
		"\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u0000"+
		"1\u0001\u0000\u0000\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001"+
		"\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000\u00009\u0001\u0000\u0000"+
		"\u0000\u0000;\u0001\u0000\u0000\u0000\u0000=\u0001\u0000\u0000\u0000\u0000"+
		"?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000\u0000\u0000\u0000C\u0001"+
		"\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000\u0000G\u0001\u0000\u0000"+
		"\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K\u0001\u0000\u0000\u0000\u0000"+
		"M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000\u0000\u0000\u0000Q\u0001"+
		"\u0000\u0000\u0000\u0001[\u0001\u0000\u0000\u0000\u0003k\u0001\u0000\u0000"+
		"\u0000\u0005p\u0001\u0000\u0000\u0000\u0007w\u0001\u0000\u0000\u0000\t"+
		"~\u0001\u0000\u0000\u0000\u000b\u0082\u0001\u0000\u0000\u0000\r\u0089"+
		"\u0001\u0000\u0000\u0000\u000f\u008c\u0001\u0000\u0000\u0000\u0011\u0091"+
		"\u0001\u0000\u0000\u0000\u0013\u0096\u0001\u0000\u0000\u0000\u0015\u009a"+
		"\u0001\u0000\u0000\u0000\u0017\u00a0\u0001\u0000\u0000\u0000\u0019\u00a9"+
		"\u0001\u0000\u0000\u0000\u001b\u00ac\u0001\u0000\u0000\u0000\u001d\u00b2"+
		"\u0001\u0000\u0000\u0000\u001f\u00b7\u0001\u0000\u0000\u0000!\u00c6\u0001"+
		"\u0000\u0000\u0000#\u00c8\u0001\u0000\u0000\u0000%\u00cd\u0001\u0000\u0000"+
		"\u0000\'\u00cf\u0001\u0000\u0000\u0000)\u00d1\u0001\u0000\u0000\u0000"+
		"+\u00d4\u0001\u0000\u0000\u0000-\u00d7\u0001\u0000\u0000\u0000/\u00da"+
		"\u0001\u0000\u0000\u00001\u00dd\u0001\u0000\u0000\u00003\u00e0\u0001\u0000"+
		"\u0000\u00005\u00e3\u0001\u0000\u0000\u00007\u00e5\u0001\u0000\u0000\u0000"+
		"9\u00e7\u0001\u0000\u0000\u0000;\u00e9\u0001\u0000\u0000\u0000=\u00eb"+
		"\u0001\u0000\u0000\u0000?\u00ed\u0001\u0000\u0000\u0000A\u00ef\u0001\u0000"+
		"\u0000\u0000C\u00fa\u0001\u0000\u0000\u0000E\u0104\u0001\u0000\u0000\u0000"+
		"G\u0119\u0001\u0000\u0000\u0000I\u011e\u0001\u0000\u0000\u0000K\u0124"+
		"\u0001\u0000\u0000\u0000M\u012f\u0001\u0000\u0000\u0000O\u016b\u0001\u0000"+
		"\u0000\u0000Q\u016f\u0001\u0000\u0000\u0000S\u017c\u0001\u0000\u0000\u0000"+
		"U\u017f\u0001\u0000\u0000\u0000W\u0198\u0001\u0000\u0000\u0000Y\u019a"+
		"\u0001\u0000\u0000\u0000[_\u0005\\\u0000\u0000\\^\u0007\u0000\u0000\u0000"+
		"]\\\u0001\u0000\u0000\u0000^a\u0001\u0000\u0000\u0000_]\u0001\u0000\u0000"+
		"\u0000_`\u0001\u0000\u0000\u0000`g\u0001\u0000\u0000\u0000a_\u0001\u0000"+
		"\u0000\u0000bd\u0005\r\u0000\u0000cb\u0001\u0000\u0000\u0000cd\u0001\u0000"+
		"\u0000\u0000de\u0001\u0000\u0000\u0000eh\u0005\n\u0000\u0000fh\u0002\f"+
		"\r\u0000gc\u0001\u0000\u0000\u0000gf\u0001\u0000\u0000\u0000hi\u0001\u0000"+
		"\u0000\u0000ij\u0006\u0000\u0000\u0000j\u0002\u0001\u0000\u0000\u0000"+
		"kl\u0005f\u0000\u0000lm\u0005r\u0000\u0000mn\u0005o\u0000\u0000no\u0005"+
		"m\u0000\u0000o\u0004\u0001\u0000\u0000\u0000pq\u0005i\u0000\u0000qr\u0005"+
		"m\u0000\u0000rs\u0005p\u0000\u0000st\u0005o\u0000\u0000tu\u0005r\u0000"+
		"\u0000uv\u0005t\u0000\u0000v\u0006\u0001\u0000\u0000\u0000wx\u0005r\u0000"+
		"\u0000xy\u0005e\u0000\u0000yz\u0005t\u0000\u0000z{\u0005u\u0000\u0000"+
		"{|\u0005r\u0000\u0000|}\u0005n\u0000\u0000}\b\u0001\u0000\u0000\u0000"+
		"~\u007f\u0005d\u0000\u0000\u007f\u0080\u0005e\u0000\u0000\u0080\u0081"+
		"\u0005f\u0000\u0000\u0081\n\u0001\u0000\u0000\u0000\u0082\u0083\u0005"+
		"g\u0000\u0000\u0083\u0084\u0005l\u0000\u0000\u0084\u0085\u0005o\u0000"+
		"\u0000\u0085\u0086\u0005b\u0000\u0000\u0086\u0087\u0005a\u0000\u0000\u0087"+
		"\u0088\u0005l\u0000\u0000\u0088\f\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005i\u0000\u0000\u008a\u008b\u0005f\u0000\u0000\u008b\u000e\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0005e\u0000\u0000\u008d\u008e\u0005l\u0000\u0000"+
		"\u008e\u008f\u0005i\u0000\u0000\u008f\u0090\u0005f\u0000\u0000\u0090\u0010"+
		"\u0001\u0000\u0000\u0000\u0091\u0092\u0005e\u0000\u0000\u0092\u0093\u0005"+
		"l\u0000\u0000\u0093\u0094\u0005s\u0000\u0000\u0094\u0095\u0005e\u0000"+
		"\u0000\u0095\u0012\u0001\u0000\u0000\u0000\u0096\u0097\u0005f\u0000\u0000"+
		"\u0097\u0098\u0005o\u0000\u0000\u0098\u0099\u0005r\u0000\u0000\u0099\u0014"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005b\u0000\u0000\u009b\u009c\u0005"+
		"r\u0000\u0000\u009c\u009d\u0005e\u0000\u0000\u009d\u009e\u0005a\u0000"+
		"\u0000\u009e\u009f\u0005k\u0000\u0000\u009f\u0016\u0001\u0000\u0000\u0000"+
		"\u00a0\u00a1\u0005c\u0000\u0000\u00a1\u00a2\u0005o\u0000\u0000\u00a2\u00a3"+
		"\u0005n\u0000\u0000\u00a3\u00a4\u0005t\u0000\u0000\u00a4\u00a5\u0005i"+
		"\u0000\u0000\u00a5\u00a6\u0005n\u0000\u0000\u00a6\u00a7\u0005u\u0000\u0000"+
		"\u00a7\u00a8\u0005e\u0000\u0000\u00a8\u0018\u0001\u0000\u0000\u0000\u00a9"+
		"\u00aa\u0005i\u0000\u0000\u00aa\u00ab\u0005n\u0000\u0000\u00ab\u001a\u0001"+
		"\u0000\u0000\u0000\u00ac\u00ad\u0005w\u0000\u0000\u00ad\u00ae\u0005h\u0000"+
		"\u0000\u00ae\u00af\u0005i\u0000\u0000\u00af\u00b0\u0005l\u0000\u0000\u00b0"+
		"\u00b1\u0005e\u0000\u0000\u00b1\u001c\u0001\u0000\u0000\u0000\u00b2\u00b3"+
		"\u0005s\u0000\u0000\u00b3\u00b4\u0005e\u0000\u0000\u00b4\u00b5\u0005l"+
		"\u0000\u0000\u00b5\u00b6\u0005f\u0000\u0000\u00b6\u001e\u0001\u0000\u0000"+
		"\u0000\u00b7\u00b8\u0005c\u0000\u0000\u00b8\u00b9\u0005l\u0000\u0000\u00b9"+
		"\u00ba\u0005a\u0000\u0000\u00ba\u00bb\u0005s\u0000\u0000\u00bb\u00bc\u0005"+
		"s\u0000\u0000\u00bc \u0001\u0000\u0000\u0000\u00bd\u00be\u0005T\u0000"+
		"\u0000\u00be\u00bf\u0005r\u0000\u0000\u00bf\u00c0\u0005u\u0000\u0000\u00c0"+
		"\u00c7\u0005e\u0000\u0000\u00c1\u00c2\u0005F\u0000\u0000\u00c2\u00c3\u0005"+
		"a\u0000\u0000\u00c3\u00c4\u0005l\u0000\u0000\u00c4\u00c5\u0005s\u0000"+
		"\u0000\u00c5\u00c7\u0005e\u0000\u0000\u00c6\u00bd\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c1\u0001\u0000\u0000\u0000\u00c7\"\u0001\u0000\u0000\u0000\u00c8"+
		"\u00c9\u0005N\u0000\u0000\u00c9\u00ca\u0005o\u0000\u0000\u00ca\u00cb\u0005"+
		"n\u0000\u0000\u00cb\u00cc\u0005e\u0000\u0000\u00cc$\u0001\u0000\u0000"+
		"\u0000\u00cd\u00ce\u0005:\u0000\u0000\u00ce&\u0001\u0000\u0000\u0000\u00cf"+
		"\u00d0\u0005@\u0000\u0000\u00d0(\u0001\u0000\u0000\u0000\u00d1\u00d2\u0005"+
		"{\u0000\u0000\u00d2\u00d3\u0006\u0014\u0001\u0000\u00d3*\u0001\u0000\u0000"+
		"\u0000\u00d4\u00d5\u0005}\u0000\u0000\u00d5\u00d6\u0006\u0015\u0002\u0000"+
		"\u00d6,\u0001\u0000\u0000\u0000\u00d7\u00d8\u0005[\u0000\u0000\u00d8\u00d9"+
		"\u0006\u0016\u0003\u0000\u00d9.\u0001\u0000\u0000\u0000\u00da\u00db\u0005"+
		"]\u0000\u0000\u00db\u00dc\u0006\u0017\u0004\u0000\u00dc0\u0001\u0000\u0000"+
		"\u0000\u00dd\u00de\u0005(\u0000\u0000\u00de\u00df\u0006\u0018\u0005\u0000"+
		"\u00df2\u0001\u0000\u0000\u0000\u00e0\u00e1\u0005)\u0000\u0000\u00e1\u00e2"+
		"\u0006\u0019\u0006\u0000\u00e24\u0001\u0000\u0000\u0000\u00e3\u00e4\u0005"+
		",\u0000\u0000\u00e46\u0001\u0000\u0000\u0000\u00e5\u00e6\u0005=\u0000"+
		"\u0000\u00e68\u0001\u0000\u0000\u0000\u00e7\u00e8\u0005.\u0000\u0000\u00e8"+
		":\u0001\u0000\u0000\u0000\u00e9\u00ea\u0005+\u0000\u0000\u00ea<\u0001"+
		"\u0000\u0000\u0000\u00eb\u00ec\u0005-\u0000\u0000\u00ec>\u0001\u0000\u0000"+
		"\u0000\u00ed\u00ee\u0005*\u0000\u0000\u00ee@\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0005/\u0000\u0000\u00f0B\u0001\u0000\u0000\u0000\u00f1\u00fb\u0007"+
		"\u0001\u0000\u0000\u00f2\u00f3\u0005>\u0000\u0000\u00f3\u00fb\u0005=\u0000"+
		"\u0000\u00f4\u00f5\u0005<\u0000\u0000\u00f5\u00fb\u0005=\u0000\u0000\u00f6"+
		"\u00f7\u0005=\u0000\u0000\u00f7\u00fb\u0005=\u0000\u0000\u00f8\u00f9\u0005"+
		"!\u0000\u0000\u00f9\u00fb\u0005=\u0000\u0000\u00fa\u00f1\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f2\u0001\u0000\u0000\u0000\u00fa\u00f4\u0001\u0000\u0000"+
		"\u0000\u00fa\u00f6\u0001\u0000\u0000\u0000\u00fa\u00f8\u0001\u0000\u0000"+
		"\u0000\u00fbD\u0001\u0000\u0000\u0000\u00fc\u00fd\u0005a\u0000\u0000\u00fd"+
		"\u00fe\u0005n\u0000\u0000\u00fe\u0105\u0005d\u0000\u0000\u00ff\u0100\u0005"+
		"o\u0000\u0000\u0100\u0105\u0005r\u0000\u0000\u0101\u0102\u0005n\u0000"+
		"\u0000\u0102\u0103\u0005o\u0000\u0000\u0103\u0105\u0005t\u0000\u0000\u0104"+
		"\u00fc\u0001\u0000\u0000\u0000\u0104\u00ff\u0001\u0000\u0000\u0000\u0104"+
		"\u0101\u0001\u0000\u0000\u0000\u0105F\u0001\u0000\u0000\u0000\u0106\u0108"+
		"\u0004#\u0000\u0000\u0107\u0109\u0007\u0000\u0000\u0000\u0108\u0107\u0001"+
		"\u0000\u0000\u0000\u0109\u010a\u0001\u0000\u0000\u0000\u010a\u0108\u0001"+
		"\u0000\u0000\u0000\u010a\u010b\u0001\u0000\u0000\u0000\u010b\u011a\u0001"+
		"\u0000\u0000\u0000\u010c\u010e\u0005\r\u0000\u0000\u010d\u010c\u0001\u0000"+
		"\u0000\u0000\u010d\u010e\u0001\u0000\u0000\u0000\u010e\u010f\u0001\u0000"+
		"\u0000\u0000\u010f\u0112\u0005\n\u0000\u0000\u0110\u0112\u0002\f\r\u0000"+
		"\u0111\u010d\u0001\u0000\u0000\u0000\u0111\u0110\u0001\u0000\u0000\u0000"+
		"\u0112\u0116\u0001\u0000\u0000\u0000\u0113\u0115\u0007\u0000\u0000\u0000"+
		"\u0114\u0113\u0001\u0000\u0000\u0000\u0115\u0118\u0001\u0000\u0000\u0000"+
		"\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001\u0000\u0000\u0000"+
		"\u0117\u011a\u0001\u0000\u0000\u0000\u0118\u0116\u0001\u0000\u0000\u0000"+
		"\u0119\u0106\u0001\u0000\u0000\u0000\u0119\u0111\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u011c\u0006#\u0007\u0000\u011c"+
		"H\u0001\u0000\u0000\u0000\u011d\u011f\u0007\u0000\u0000\u0000\u011e\u011d"+
		"\u0001\u0000\u0000\u0000\u011f\u0120\u0001\u0000\u0000\u0000\u0120\u011e"+
		"\u0001\u0000\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0122"+
		"\u0001\u0000\u0000\u0000\u0122\u0123\u0006$\b\u0000\u0123J\u0001\u0000"+
		"\u0000\u0000\u0124\u0128\u0005#\u0000\u0000\u0125\u0127\b\u0002\u0000"+
		"\u0000\u0126\u0125\u0001\u0000\u0000\u0000\u0127\u012a\u0001\u0000\u0000"+
		"\u0000\u0128\u0126\u0001\u0000\u0000\u0000\u0128\u0129\u0001\u0000\u0000"+
		"\u0000\u0129\u012b\u0001\u0000\u0000\u0000\u012a\u0128\u0001\u0000\u0000"+
		"\u0000\u012b\u012c\u0006%\u0000\u0000\u012cL\u0001\u0000\u0000\u0000\u012d"+
		"\u0130\u0003Y,\u0000\u012e\u0130\u0005_\u0000\u0000\u012f\u012d\u0001"+
		"\u0000\u0000\u0000\u012f\u012e\u0001\u0000\u0000\u0000\u0130\u0136\u0001"+
		"\u0000\u0000\u0000\u0131\u0135\u0003Y,\u0000\u0132\u0135\u0003W+\u0000"+
		"\u0133\u0135\u0005_\u0000\u0000\u0134\u0131\u0001\u0000\u0000\u0000\u0134"+
		"\u0132\u0001\u0000\u0000\u0000\u0134\u0133\u0001\u0000\u0000\u0000\u0135"+
		"\u0138\u0001\u0000\u0000\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136"+
		"\u0137\u0001\u0000\u0000\u0000\u0137N\u0001\u0000\u0000\u0000\u0138\u0136"+
		"\u0001\u0000\u0000\u0000\u0139\u013a\u0005\"\u0000\u0000\u013a\u013b\u0005"+
		"\"\u0000\u0000\u013b\u013c\u0005\"\u0000\u0000\u013c\u0142\u0001\u0000"+
		"\u0000\u0000\u013d\u013e\u0005\\\u0000\u0000\u013e\u0141\u0005\"\u0000"+
		"\u0000\u013f\u0141\t\u0000\u0000\u0000\u0140\u013d\u0001\u0000\u0000\u0000"+
		"\u0140\u013f\u0001\u0000\u0000\u0000\u0141\u0144\u0001\u0000\u0000\u0000"+
		"\u0142\u0143\u0001\u0000\u0000\u0000\u0142\u0140\u0001\u0000\u0000\u0000"+
		"\u0143\u0145\u0001\u0000\u0000\u0000\u0144\u0142\u0001\u0000\u0000\u0000"+
		"\u0145\u0146\u0005\"\u0000\u0000\u0146\u0147\u0005\"\u0000\u0000\u0147"+
		"\u016c\u0005\"\u0000\u0000\u0148\u0149\u0005\'\u0000\u0000\u0149\u014a"+
		"\u0005\'\u0000\u0000\u014a\u014b\u0005\'\u0000\u0000\u014b\u0151\u0001"+
		"\u0000\u0000\u0000\u014c\u014d\u0005\\\u0000\u0000\u014d\u0150\u0005\'"+
		"\u0000\u0000\u014e\u0150\t\u0000\u0000\u0000\u014f\u014c\u0001\u0000\u0000"+
		"\u0000\u014f\u014e\u0001\u0000\u0000\u0000\u0150\u0153\u0001\u0000\u0000"+
		"\u0000\u0151\u0152\u0001\u0000\u0000\u0000\u0151\u014f\u0001\u0000\u0000"+
		"\u0000\u0152\u0154\u0001\u0000\u0000\u0000\u0153\u0151\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0005\'\u0000\u0000\u0155\u0156\u0005\'\u0000\u0000"+
		"\u0156\u016c\u0005\'\u0000\u0000\u0157\u015d\u0005\"\u0000\u0000\u0158"+
		"\u0159\u0005\\\u0000\u0000\u0159\u015c\u0005\"\u0000\u0000\u015a\u015c"+
		"\b\u0003\u0000\u0000\u015b\u0158\u0001\u0000\u0000\u0000\u015b\u015a\u0001"+
		"\u0000\u0000\u0000\u015c\u015f\u0001\u0000\u0000\u0000\u015d\u015b\u0001"+
		"\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u0160\u0001"+
		"\u0000\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u0160\u016c\u0005"+
		"\"\u0000\u0000\u0161\u0167\u0005\'\u0000\u0000\u0162\u0163\u0005\\\u0000"+
		"\u0000\u0163\u0166\u0005\'\u0000\u0000\u0164\u0166\b\u0004\u0000\u0000"+
		"\u0165\u0162\u0001\u0000\u0000\u0000\u0165\u0164\u0001\u0000\u0000\u0000"+
		"\u0166\u0169\u0001\u0000\u0000\u0000\u0167\u0165\u0001\u0000\u0000\u0000"+
		"\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u016a\u0001\u0000\u0000\u0000"+
		"\u0169\u0167\u0001\u0000\u0000\u0000\u016a\u016c\u0005\'\u0000\u0000\u016b"+
		"\u0139\u0001\u0000\u0000\u0000\u016b\u0148\u0001\u0000\u0000\u0000\u016b"+
		"\u0157\u0001\u0000\u0000\u0000\u016b\u0161\u0001\u0000\u0000\u0000\u016c"+
		"P\u0001\u0000\u0000\u0000\u016d\u0170\u0003S)\u0000\u016e\u0170\u0003"+
		"U*\u0000\u016f\u016d\u0001\u0000\u0000\u0000\u016f\u016e\u0001\u0000\u0000"+
		"\u0000\u0170R\u0001\u0000\u0000\u0000\u0171\u0173\u0005-\u0000\u0000\u0172"+
		"\u0171\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173"+
		"\u0174\u0001\u0000\u0000\u0000\u0174\u017d\u00050\u0000\u0000\u0175\u0179"+
		"\u0007\u0005\u0000\u0000\u0176\u0178\u0007\u0006\u0000\u0000\u0177\u0176"+
		"\u0001\u0000\u0000\u0000\u0178\u017b\u0001\u0000\u0000\u0000\u0179\u0177"+
		"\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017d"+
		"\u0001\u0000\u0000\u0000\u017b\u0179\u0001\u0000\u0000\u0000\u017c\u0172"+
		"\u0001\u0000\u0000\u0000\u017c\u0175\u0001\u0000\u0000\u0000\u017dT\u0001"+
		"\u0000\u0000\u0000\u017e\u0180\u0005-\u0000\u0000\u017f\u017e\u0001\u0000"+
		"\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0184\u0001\u0000"+
		"\u0000\u0000\u0181\u0183\u0007\u0006\u0000\u0000\u0182\u0181\u0001\u0000"+
		"\u0000\u0000\u0183\u0186\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000"+
		"\u0000\u0000\u0184\u0185\u0001\u0000\u0000\u0000\u0185\u0187\u0001\u0000"+
		"\u0000\u0000\u0186\u0184\u0001\u0000\u0000\u0000\u0187\u0189\u0005.\u0000"+
		"\u0000\u0188\u018a\u0007\u0006\u0000\u0000\u0189\u0188\u0001\u0000\u0000"+
		"\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u0189\u0001\u0000\u0000"+
		"\u0000\u018b\u018c\u0001\u0000\u0000\u0000\u018c\u0196\u0001\u0000\u0000"+
		"\u0000\u018d\u018f\u0007\u0007\u0000\u0000\u018e\u0190\u0007\b\u0000\u0000"+
		"\u018f\u018e\u0001\u0000\u0000\u0000\u018f\u0190\u0001\u0000\u0000\u0000"+
		"\u0190\u0192\u0001\u0000\u0000\u0000\u0191\u0193\u0007\u0006\u0000\u0000"+
		"\u0192\u0191\u0001\u0000\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000"+
		"\u0194\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000"+
		"\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u018d\u0001\u0000\u0000\u0000"+
		"\u0196\u0197\u0001\u0000\u0000\u0000\u0197V\u0001\u0000\u0000\u0000\u0198"+
		"\u0199\u0007\u0006\u0000\u0000\u0199X\u0001\u0000\u0000\u0000\u019a\u019b"+
		"\u0007\t\u0000\u0000\u019bZ\u0001\u0000\u0000\u0000$\u0000_cg\u00c6\u00fa"+
		"\u0104\u010a\u010d\u0111\u0116\u0119\u0120\u0128\u012f\u0134\u0136\u0140"+
		"\u0142\u014f\u0151\u015b\u015d\u0165\u0167\u016b\u016f\u0172\u0179\u017c"+
		"\u017f\u0184\u018b\u018f\u0194\u0196\t\u0006\u0000\u0000\u0001\u0014\u0000"+
		"\u0001\u0015\u0001\u0001\u0016\u0002\u0001\u0017\u0003\u0001\u0018\u0004"+
		"\u0001\u0019\u0005\u0001#\u0006\u0000\u0001\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}