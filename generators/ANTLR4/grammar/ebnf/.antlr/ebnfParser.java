// Generated from c:\Users\Niiko\Desktop\Forschungspraktikum\generators\ANTLR4\grammar\ebnf\ebnf.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ebnfParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, INTEGER=12, DECIMAL=13, IDENT=14, QUOTED_STRING=15, 
		WS=16;
	public static final int
		RULE_start = 0, RULE_production_list = 1, RULE_production = 2, RULE_rhs = 3, 
		RULE_weight_bin = 4, RULE_weight_post = 5;
	public static final String[] ruleNames = {
		"start", "production_list", "production", "rhs", "weight_bin", "weight_post"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "':'", "';'", "'|'", "'*'", "'+'", "'?'", "'('", "')'", "'#'", "','", 
		"'##'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"INTEGER", "DECIMAL", "IDENT", "QUOTED_STRING", "WS"
	};
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
	public String getGrammarFileName() { return "ebnf.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ebnfParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public Production_listContext production_list() {
			return getRuleContext(Production_listContext.class,0);
		}
		public TerminalNode EOF() { return getToken(ebnfParser.EOF, 0); }
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(12);
			production_list();
			setState(13);
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

	public static class Production_listContext extends ParserRuleContext {
		public List<ProductionContext> production() {
			return getRuleContexts(ProductionContext.class);
		}
		public ProductionContext production(int i) {
			return getRuleContext(ProductionContext.class,i);
		}
		public Production_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_production_list; }
	}

	public final Production_listContext production_list() throws RecognitionException {
		Production_listContext _localctx = new Production_listContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_production_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(16); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(15);
				production();
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==IDENT );
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

	public static class ProductionContext extends ParserRuleContext {
		public TerminalNode IDENT() { return getToken(ebnfParser.IDENT, 0); }
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public ProductionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_production; }
	}

	public final ProductionContext production() throws RecognitionException {
		ProductionContext _localctx = new ProductionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_production);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(20);
			match(IDENT);
			setState(21);
			match(T__0);
			setState(22);
			rhs(0);
			setState(23);
			match(T__1);
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

	public static class RhsContext extends ParserRuleContext {
		public RhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rhs; }
	 
		public RhsContext() { }
		public void copyFrom(RhsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Paren_exprContext extends RhsContext {
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public Paren_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class Zero_list_exprContext extends RhsContext {
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public Weight_postContext weight_post() {
			return getRuleContext(Weight_postContext.class,0);
		}
		public Zero_list_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class Alt_exprContext extends RhsContext {
		public RhsContext expr_right;
		public Weight_binContext weights_right;
		public RhsContext expr_left;
		public Weight_binContext weights_left;
		public List<RhsContext> rhs() {
			return getRuleContexts(RhsContext.class);
		}
		public RhsContext rhs(int i) {
			return getRuleContext(RhsContext.class,i);
		}
		public List<Weight_binContext> weight_bin() {
			return getRuleContexts(Weight_binContext.class);
		}
		public Weight_binContext weight_bin(int i) {
			return getRuleContext(Weight_binContext.class,i);
		}
		public Alt_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class Maybe_exprContext extends RhsContext {
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public Weight_postContext weight_post() {
			return getRuleContext(Weight_postContext.class,0);
		}
		public Maybe_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class Concat_exprContext extends RhsContext {
		public RhsContext expr_right;
		public Weight_binContext weights_right;
		public RhsContext expr_left;
		public Weight_binContext weights_left;
		public List<RhsContext> rhs() {
			return getRuleContexts(RhsContext.class);
		}
		public RhsContext rhs(int i) {
			return getRuleContext(RhsContext.class,i);
		}
		public List<Weight_binContext> weight_bin() {
			return getRuleContexts(Weight_binContext.class);
		}
		public Weight_binContext weight_bin(int i) {
			return getRuleContext(Weight_binContext.class,i);
		}
		public Concat_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class One_list_exprContext extends RhsContext {
		public RhsContext rhs() {
			return getRuleContext(RhsContext.class,0);
		}
		public Weight_postContext weight_post() {
			return getRuleContext(Weight_postContext.class,0);
		}
		public One_list_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class Terminal_exprContext extends RhsContext {
		public TerminalNode QUOTED_STRING() { return getToken(ebnfParser.QUOTED_STRING, 0); }
		public Terminal_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}
	public static class Nonterminal_exprContext extends RhsContext {
		public TerminalNode IDENT() { return getToken(ebnfParser.IDENT, 0); }
		public Nonterminal_exprContext(RhsContext ctx) { copyFrom(ctx); }
	}

	public final RhsContext rhs() throws RecognitionException {
		return rhs(0);
	}

	private RhsContext rhs(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		RhsContext _localctx = new RhsContext(_ctx, _parentState);
		RhsContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_rhs, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__6:
				{
				_localctx = new Paren_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(26);
				match(T__6);
				setState(27);
				rhs(0);
				setState(28);
				match(T__7);
				}
				break;
			case QUOTED_STRING:
				{
				_localctx = new Terminal_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(QUOTED_STRING);
				}
				break;
			case IDENT:
				{
				_localctx = new Nonterminal_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(31);
				match(IDENT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(68);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(66);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
					case 1:
						{
						_localctx = new Alt_exprContext(new RhsContext(_parentctx, _parentState));
						((Alt_exprContext)_localctx).expr_right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rhs);
						setState(34);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(36);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__8) {
							{
							setState(35);
							((Alt_exprContext)_localctx).weights_right = weight_bin();
							}
						}

						setState(38);
						match(T__2);
						setState(39);
						((Alt_exprContext)_localctx).expr_left = rhs(0);
						setState(41);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
						case 1:
							{
							setState(40);
							((Alt_exprContext)_localctx).weights_left = weight_bin();
							}
							break;
						}
						}
						break;
					case 2:
						{
						_localctx = new Concat_exprContext(new RhsContext(_parentctx, _parentState));
						((Concat_exprContext)_localctx).expr_right = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_rhs);
						setState(43);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(45);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==T__8) {
							{
							setState(44);
							((Concat_exprContext)_localctx).weights_right = weight_bin();
							}
						}

						setState(47);
						((Concat_exprContext)_localctx).expr_left = rhs(0);
						setState(49);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
						case 1:
							{
							setState(48);
							((Concat_exprContext)_localctx).weights_left = weight_bin();
							}
							break;
						}
						}
						break;
					case 3:
						{
						_localctx = new Zero_list_exprContext(new RhsContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rhs);
						setState(51);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(52);
						match(T__3);
						setState(54);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
						case 1:
							{
							setState(53);
							weight_post();
							}
							break;
						}
						}
						break;
					case 4:
						{
						_localctx = new One_list_exprContext(new RhsContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rhs);
						setState(56);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(57);
						match(T__4);
						setState(59);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
						case 1:
							{
							setState(58);
							weight_post();
							}
							break;
						}
						}
						break;
					case 5:
						{
						_localctx = new Maybe_exprContext(new RhsContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_rhs);
						setState(61);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(62);
						match(T__5);
						setState(64);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
						case 1:
							{
							setState(63);
							weight_post();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(70);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Weight_binContext extends ParserRuleContext {
		public Token weight;
		public Token decrease;
		public List<TerminalNode> DECIMAL() { return getTokens(ebnfParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(ebnfParser.DECIMAL, i);
		}
		public Weight_binContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weight_bin; }
	}

	public final Weight_binContext weight_bin() throws RecognitionException {
		Weight_binContext _localctx = new Weight_binContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_weight_bin);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(T__8);
			setState(72);
			((Weight_binContext)_localctx).weight = match(DECIMAL);
			setState(75);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(73);
				match(T__9);
				setState(74);
				((Weight_binContext)_localctx).decrease = match(DECIMAL);
				}
				break;
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

	public static class Weight_postContext extends ParserRuleContext {
		public Token weight;
		public Token decrease;
		public List<TerminalNode> DECIMAL() { return getTokens(ebnfParser.DECIMAL); }
		public TerminalNode DECIMAL(int i) {
			return getToken(ebnfParser.DECIMAL, i);
		}
		public Weight_postContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_weight_post; }
	}

	public final Weight_postContext weight_post() throws RecognitionException {
		Weight_postContext _localctx = new Weight_postContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_weight_post);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__10);
			setState(78);
			((Weight_postContext)_localctx).weight = match(DECIMAL);
			setState(81);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(79);
				match(T__9);
				setState(80);
				((Weight_postContext)_localctx).decrease = match(DECIMAL);
				}
				break;
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return rhs_sempred((RhsContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean rhs_sempred(RhsContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 8);
		case 1:
			return precpred(_ctx, 7);
		case 2:
			return precpred(_ctx, 6);
		case 3:
			return precpred(_ctx, 5);
		case 4:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\22V\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\3\2\3\2\3\2\3\3\6\3\23\n\3\r\3\16\3"+
		"\24\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5#\n\5\3\5\3\5\5"+
		"\5\'\n\5\3\5\3\5\3\5\5\5,\n\5\3\5\3\5\5\5\60\n\5\3\5\3\5\5\5\64\n\5\3"+
		"\5\3\5\3\5\5\59\n\5\3\5\3\5\3\5\5\5>\n\5\3\5\3\5\3\5\5\5C\n\5\7\5E\n\5"+
		"\f\5\16\5H\13\5\3\6\3\6\3\6\3\6\5\6N\n\6\3\7\3\7\3\7\3\7\5\7T\n\7\3\7"+
		"\2\3\b\b\2\4\6\b\n\f\2\2\2`\2\16\3\2\2\2\4\22\3\2\2\2\6\26\3\2\2\2\b\""+
		"\3\2\2\2\nI\3\2\2\2\fO\3\2\2\2\16\17\5\4\3\2\17\20\7\2\2\3\20\3\3\2\2"+
		"\2\21\23\5\6\4\2\22\21\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24\25\3\2\2"+
		"\2\25\5\3\2\2\2\26\27\7\20\2\2\27\30\7\3\2\2\30\31\5\b\5\2\31\32\7\4\2"+
		"\2\32\7\3\2\2\2\33\34\b\5\1\2\34\35\7\t\2\2\35\36\5\b\5\2\36\37\7\n\2"+
		"\2\37#\3\2\2\2 #\7\21\2\2!#\7\20\2\2\"\33\3\2\2\2\" \3\2\2\2\"!\3\2\2"+
		"\2#F\3\2\2\2$&\f\n\2\2%\'\5\n\6\2&%\3\2\2\2&\'\3\2\2\2\'(\3\2\2\2()\7"+
		"\5\2\2)+\5\b\5\2*,\5\n\6\2+*\3\2\2\2+,\3\2\2\2,E\3\2\2\2-/\f\t\2\2.\60"+
		"\5\n\6\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2\2\61\63\5\b\5\2\62\64\5\n\6"+
		"\2\63\62\3\2\2\2\63\64\3\2\2\2\64E\3\2\2\2\65\66\f\b\2\2\668\7\6\2\2\67"+
		"9\5\f\7\28\67\3\2\2\289\3\2\2\29E\3\2\2\2:;\f\7\2\2;=\7\7\2\2<>\5\f\7"+
		"\2=<\3\2\2\2=>\3\2\2\2>E\3\2\2\2?@\f\6\2\2@B\7\b\2\2AC\5\f\7\2BA\3\2\2"+
		"\2BC\3\2\2\2CE\3\2\2\2D$\3\2\2\2D-\3\2\2\2D\65\3\2\2\2D:\3\2\2\2D?\3\2"+
		"\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2G\t\3\2\2\2HF\3\2\2\2IJ\7\13\2\2JM\7"+
		"\17\2\2KL\7\f\2\2LN\7\17\2\2MK\3\2\2\2MN\3\2\2\2N\13\3\2\2\2OP\7\r\2\2"+
		"PS\7\17\2\2QR\7\f\2\2RT\7\17\2\2SQ\3\2\2\2ST\3\2\2\2T\r\3\2\2\2\17\24"+
		"\"&+/\638=BDFMS";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}