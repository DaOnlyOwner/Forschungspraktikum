// Generated from c:\Users\Niiko\Desktop\Forschungspraktikum\generators\ANTLR4\grammar\expressions\expressions.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class expressionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, Number=23, Word=24, 
		Whitespace=25;
	public static final int
		RULE_start = 0, RULE_exprs = 1, RULE_expr_list = 2, RULE_expr = 3, RULE_primary = 4;
	public static final String[] ruleNames = {
		"start", "exprs", "expr_list", "expr", "primary"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "';'", "','", "'::'", "'+'", "'-'", "'('", "')'", "'['", "']'", 
		"'~'", "'!'", "'*'", "'&'", "'/'", "'%'", "'<'", "'>'", "'^'", "'|'", 
		"'='", "'?'", "':'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "Number", 
		"Word", "Whitespace"
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
	public String getGrammarFileName() { return "expressions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public expressionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public ExprsContext exprs() {
			return getRuleContext(ExprsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(expressionsParser.EOF, 0); }
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
			setState(10);
			exprs();
			setState(11);
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

	public static class ExprsContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exprs; }
	}

	public final ExprsContext exprs() throws RecognitionException {
		ExprsContext _localctx = new ExprsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_exprs);
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
				setState(13);
				expr(0);
				setState(14);
				match(T__0);
				}
				}
				setState(18); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Number) | (1L << Word))) != 0) );
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

	public static class Expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_list; }
	}

	public final Expr_listContext expr_list() throws RecognitionException {
		Expr_listContext _localctx = new Expr_listContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << T__9) | (1L << T__10) | (1L << T__11) | (1L << T__12) | (1L << Number) | (1L << Word))) != 0)) {
				{
				setState(20);
				expr(0);
				setState(25);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(21);
					match(T__1);
					setState(22);
					expr(0);
					}
					}
					setState(27);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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

	public static class ExprContext extends ParserRuleContext {
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Comp_lesser_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_lesser_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Add_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Add_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Postfix_incr_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Postfix_incr_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Bit_xor_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Bit_xor_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Bit_and_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Bit_and_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Comp_not_equal_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_not_equal_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Comp_greater_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_greater_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_lshift_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_lshift_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Prefix_incr_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Prefix_incr_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Pointer__exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Pointer__exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Div_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Div_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_diff_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_diff_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Mod_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Mod_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Right_shift_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Right_shift_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Sub_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Sub_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Logical_or_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Logical_or_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Array_index_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Array_index_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Unary_plus_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_plus_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Scope_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Scope_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Unary_minus_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Unary_minus_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Bit_or_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Bit_or_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Logical_neg_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Logical_neg_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Primary_exprContext extends ExprContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Primary_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_sum_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_sum_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Mul_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Mul_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Pointer_deref_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Pointer_deref_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_mod_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_mod_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Logical_and_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Logical_and_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_flip_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_flip_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_rshift_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_rshift_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_and_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_and_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_or_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_or_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Left_shift_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Left_shift_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Prefix_decr_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Prefix_decr_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Postfix_decr_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Postfix_decr_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_mul_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_mul_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Bit_flip_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Bit_flip_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ternary_if_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ternary_if_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Comp_lesser_equal_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_lesser_equal_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Ass_div_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Ass_div_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Comp_greater_equal_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_greater_equal_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Function_call_exprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_listContext expr_list() {
			return getRuleContext(Expr_listContext.class,0);
		}
		public Function_call_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}
	public static class Comp_equal_exprContext extends ExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Comp_equal_exprContext(ExprContext ctx) { copyFrom(ctx); }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(50);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				_localctx = new Prefix_incr_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(31);
				match(T__3);
				setState(32);
				match(T__3);
				setState(33);
				expr(39);
				}
				break;
			case 2:
				{
				_localctx = new Prefix_decr_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(34);
				match(T__4);
				setState(35);
				match(T__4);
				setState(36);
				expr(38);
				}
				break;
			case 3:
				{
				_localctx = new Unary_plus_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(T__3);
				setState(38);
				expr(37);
				}
				break;
			case 4:
				{
				_localctx = new Unary_minus_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(39);
				match(T__4);
				setState(40);
				expr(36);
				}
				break;
			case 5:
				{
				_localctx = new Bit_flip_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(41);
				match(T__9);
				setState(42);
				expr(35);
				}
				break;
			case 6:
				{
				_localctx = new Logical_neg_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(43);
				match(T__10);
				setState(44);
				expr(34);
				}
				break;
			case 7:
				{
				_localctx = new Pointer_deref_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(45);
				match(T__11);
				setState(46);
				expr(33);
				}
				break;
			case 8:
				{
				_localctx = new Pointer__exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(T__12);
				setState(48);
				expr(32);
				}
				break;
			case 9:
				{
				_localctx = new Primary_exprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(49);
				primary();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(186);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(184);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new Scope_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(52);
						if (!(precpred(_ctx, 44))) throw new FailedPredicateException(this, "precpred(_ctx, 44)");
						setState(53);
						match(T__2);
						setState(54);
						expr(45);
						}
						break;
					case 2:
						{
						_localctx = new Mul_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(55);
						if (!(precpred(_ctx, 31))) throw new FailedPredicateException(this, "precpred(_ctx, 31)");
						setState(56);
						match(T__11);
						setState(57);
						expr(32);
						}
						break;
					case 3:
						{
						_localctx = new Div_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(58);
						if (!(precpred(_ctx, 30))) throw new FailedPredicateException(this, "precpred(_ctx, 30)");
						setState(59);
						match(T__13);
						setState(60);
						expr(31);
						}
						break;
					case 4:
						{
						_localctx = new Mod_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(61);
						if (!(precpred(_ctx, 29))) throw new FailedPredicateException(this, "precpred(_ctx, 29)");
						setState(62);
						match(T__14);
						setState(63);
						expr(30);
						}
						break;
					case 5:
						{
						_localctx = new Sub_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(64);
						if (!(precpred(_ctx, 28))) throw new FailedPredicateException(this, "precpred(_ctx, 28)");
						setState(65);
						match(T__4);
						setState(66);
						expr(29);
						}
						break;
					case 6:
						{
						_localctx = new Add_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(67);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(68);
						match(T__3);
						setState(69);
						expr(28);
						}
						break;
					case 7:
						{
						_localctx = new Left_shift_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(70);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(71);
						match(T__15);
						setState(72);
						match(T__15);
						setState(73);
						expr(27);
						}
						break;
					case 8:
						{
						_localctx = new Right_shift_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(74);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(75);
						match(T__16);
						setState(76);
						match(T__16);
						setState(77);
						expr(26);
						}
						break;
					case 9:
						{
						_localctx = new Bit_xor_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(78);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(79);
						match(T__17);
						setState(80);
						expr(25);
						}
						break;
					case 10:
						{
						_localctx = new Bit_and_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(81);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(82);
						match(T__12);
						setState(83);
						expr(24);
						}
						break;
					case 11:
						{
						_localctx = new Bit_or_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(84);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(85);
						match(T__18);
						setState(86);
						expr(23);
						}
						break;
					case 12:
						{
						_localctx = new Comp_lesser_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(87);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(88);
						match(T__15);
						setState(89);
						expr(22);
						}
						break;
					case 13:
						{
						_localctx = new Comp_lesser_equal_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(90);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(91);
						match(T__15);
						setState(92);
						match(T__19);
						setState(93);
						expr(21);
						}
						break;
					case 14:
						{
						_localctx = new Comp_greater_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(94);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(95);
						match(T__16);
						setState(96);
						expr(20);
						}
						break;
					case 15:
						{
						_localctx = new Comp_greater_equal_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(97);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(98);
						match(T__16);
						setState(99);
						match(T__19);
						setState(100);
						expr(19);
						}
						break;
					case 16:
						{
						_localctx = new Comp_equal_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(101);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(102);
						match(T__19);
						setState(103);
						match(T__19);
						setState(104);
						expr(18);
						}
						break;
					case 17:
						{
						_localctx = new Comp_not_equal_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(105);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(106);
						match(T__10);
						setState(107);
						match(T__19);
						setState(108);
						expr(17);
						}
						break;
					case 18:
						{
						_localctx = new Logical_and_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(109);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(110);
						match(T__12);
						setState(111);
						match(T__12);
						setState(112);
						expr(16);
						}
						break;
					case 19:
						{
						_localctx = new Logical_or_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(113);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(114);
						match(T__18);
						setState(115);
						match(T__18);
						setState(116);
						expr(15);
						}
						break;
					case 20:
						{
						_localctx = new Ternary_if_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(117);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(118);
						match(T__20);
						setState(119);
						expr(0);
						setState(120);
						match(T__21);
						setState(121);
						expr(13);
						}
						break;
					case 21:
						{
						_localctx = new Ass_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(123);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(124);
						match(T__19);
						setState(125);
						expr(12);
						}
						break;
					case 22:
						{
						_localctx = new Ass_sum_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(126);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(127);
						match(T__3);
						setState(128);
						match(T__19);
						setState(129);
						expr(11);
						}
						break;
					case 23:
						{
						_localctx = new Ass_diff_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(130);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(131);
						match(T__4);
						setState(132);
						match(T__19);
						setState(133);
						expr(10);
						}
						break;
					case 24:
						{
						_localctx = new Ass_mul_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(134);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(135);
						match(T__11);
						setState(136);
						match(T__19);
						setState(137);
						expr(9);
						}
						break;
					case 25:
						{
						_localctx = new Ass_div_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(138);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(139);
						match(T__13);
						setState(140);
						match(T__19);
						setState(141);
						expr(8);
						}
						break;
					case 26:
						{
						_localctx = new Ass_mod_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(142);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(143);
						match(T__14);
						setState(144);
						match(T__19);
						setState(145);
						expr(7);
						}
						break;
					case 27:
						{
						_localctx = new Ass_rshift_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(146);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(147);
						match(T__15);
						setState(148);
						match(T__15);
						setState(149);
						match(T__19);
						setState(150);
						expr(6);
						}
						break;
					case 28:
						{
						_localctx = new Ass_lshift_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(151);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(152);
						match(T__16);
						setState(153);
						match(T__16);
						setState(154);
						match(T__19);
						setState(155);
						expr(5);
						}
						break;
					case 29:
						{
						_localctx = new Ass_and_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(156);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(157);
						match(T__12);
						setState(158);
						match(T__19);
						setState(159);
						expr(4);
						}
						break;
					case 30:
						{
						_localctx = new Ass_flip_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(160);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(161);
						match(T__17);
						setState(162);
						match(T__19);
						setState(163);
						expr(3);
						}
						break;
					case 31:
						{
						_localctx = new Ass_or_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(164);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(165);
						match(T__18);
						setState(166);
						match(T__19);
						setState(167);
						expr(2);
						}
						break;
					case 32:
						{
						_localctx = new Postfix_incr_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(168);
						if (!(precpred(_ctx, 43))) throw new FailedPredicateException(this, "precpred(_ctx, 43)");
						setState(169);
						match(T__3);
						setState(170);
						match(T__3);
						}
						break;
					case 33:
						{
						_localctx = new Postfix_decr_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(171);
						if (!(precpred(_ctx, 42))) throw new FailedPredicateException(this, "precpred(_ctx, 42)");
						setState(172);
						match(T__4);
						setState(173);
						match(T__4);
						}
						break;
					case 34:
						{
						_localctx = new Function_call_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(174);
						if (!(precpred(_ctx, 41))) throw new FailedPredicateException(this, "precpred(_ctx, 41)");
						setState(175);
						match(T__5);
						setState(176);
						expr_list();
						setState(177);
						match(T__6);
						}
						break;
					case 35:
						{
						_localctx = new Array_index_exprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(179);
						if (!(precpred(_ctx, 40))) throw new FailedPredicateException(this, "precpred(_ctx, 40)");
						setState(180);
						match(T__7);
						setState(181);
						expr_list();
						setState(182);
						match(T__8);
						}
						break;
					}
					} 
				}
				setState(188);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode Word() { return getToken(expressionsParser.Word, 0); }
		public TerminalNode Number() { return getToken(expressionsParser.Number, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_primary);
		try {
			setState(195);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Word:
				enterOuterAlt(_localctx, 1);
				{
				setState(189);
				match(Word);
				}
				break;
			case Number:
				enterOuterAlt(_localctx, 2);
				{
				setState(190);
				match(Number);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 3);
				{
				setState(191);
				match(T__5);
				setState(192);
				expr(0);
				setState(193);
				match(T__6);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 3:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 44);
		case 1:
			return precpred(_ctx, 31);
		case 2:
			return precpred(_ctx, 30);
		case 3:
			return precpred(_ctx, 29);
		case 4:
			return precpred(_ctx, 28);
		case 5:
			return precpred(_ctx, 27);
		case 6:
			return precpred(_ctx, 26);
		case 7:
			return precpred(_ctx, 25);
		case 8:
			return precpred(_ctx, 24);
		case 9:
			return precpred(_ctx, 23);
		case 10:
			return precpred(_ctx, 22);
		case 11:
			return precpred(_ctx, 21);
		case 12:
			return precpred(_ctx, 20);
		case 13:
			return precpred(_ctx, 19);
		case 14:
			return precpred(_ctx, 18);
		case 15:
			return precpred(_ctx, 17);
		case 16:
			return precpred(_ctx, 16);
		case 17:
			return precpred(_ctx, 15);
		case 18:
			return precpred(_ctx, 14);
		case 19:
			return precpred(_ctx, 13);
		case 20:
			return precpred(_ctx, 12);
		case 21:
			return precpred(_ctx, 11);
		case 22:
			return precpred(_ctx, 10);
		case 23:
			return precpred(_ctx, 9);
		case 24:
			return precpred(_ctx, 8);
		case 25:
			return precpred(_ctx, 7);
		case 26:
			return precpred(_ctx, 6);
		case 27:
			return precpred(_ctx, 5);
		case 28:
			return precpred(_ctx, 4);
		case 29:
			return precpred(_ctx, 3);
		case 30:
			return precpred(_ctx, 2);
		case 31:
			return precpred(_ctx, 43);
		case 32:
			return precpred(_ctx, 42);
		case 33:
			return precpred(_ctx, 41);
		case 34:
			return precpred(_ctx, 40);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\33\u00c8\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\3\2\3\2\3\2\3\3\3\3\3\3\6\3\23\n\3\r"+
		"\3\16\3\24\3\4\3\4\3\4\7\4\32\n\4\f\4\16\4\35\13\4\5\4\37\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\5\5\65\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u00bb\n\5\f\5"+
		"\16\5\u00be\13\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u00c6\n\6\3\6\2\3\b\7\2\4"+
		"\6\b\n\2\2\2\u00f2\2\f\3\2\2\2\4\22\3\2\2\2\6\36\3\2\2\2\b\64\3\2\2\2"+
		"\n\u00c5\3\2\2\2\f\r\5\4\3\2\r\16\7\2\2\3\16\3\3\2\2\2\17\20\5\b\5\2\20"+
		"\21\7\3\2\2\21\23\3\2\2\2\22\17\3\2\2\2\23\24\3\2\2\2\24\22\3\2\2\2\24"+
		"\25\3\2\2\2\25\5\3\2\2\2\26\33\5\b\5\2\27\30\7\4\2\2\30\32\5\b\5\2\31"+
		"\27\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3\2\2\2\34\37\3\2\2\2\35"+
		"\33\3\2\2\2\36\26\3\2\2\2\36\37\3\2\2\2\37\7\3\2\2\2 !\b\5\1\2!\"\7\6"+
		"\2\2\"#\7\6\2\2#\65\5\b\5)$%\7\7\2\2%&\7\7\2\2&\65\5\b\5(\'(\7\6\2\2("+
		"\65\5\b\5\')*\7\7\2\2*\65\5\b\5&+,\7\f\2\2,\65\5\b\5%-.\7\r\2\2.\65\5"+
		"\b\5$/\60\7\16\2\2\60\65\5\b\5#\61\62\7\17\2\2\62\65\5\b\5\"\63\65\5\n"+
		"\6\2\64 \3\2\2\2\64$\3\2\2\2\64\'\3\2\2\2\64)\3\2\2\2\64+\3\2\2\2\64-"+
		"\3\2\2\2\64/\3\2\2\2\64\61\3\2\2\2\64\63\3\2\2\2\65\u00bc\3\2\2\2\66\67"+
		"\f.\2\2\678\7\5\2\28\u00bb\5\b\5/9:\f!\2\2:;\7\16\2\2;\u00bb\5\b\5\"<"+
		"=\f \2\2=>\7\20\2\2>\u00bb\5\b\5!?@\f\37\2\2@A\7\21\2\2A\u00bb\5\b\5 "+
		"BC\f\36\2\2CD\7\7\2\2D\u00bb\5\b\5\37EF\f\35\2\2FG\7\6\2\2G\u00bb\5\b"+
		"\5\36HI\f\34\2\2IJ\7\22\2\2JK\7\22\2\2K\u00bb\5\b\5\35LM\f\33\2\2MN\7"+
		"\23\2\2NO\7\23\2\2O\u00bb\5\b\5\34PQ\f\32\2\2QR\7\24\2\2R\u00bb\5\b\5"+
		"\33ST\f\31\2\2TU\7\17\2\2U\u00bb\5\b\5\32VW\f\30\2\2WX\7\25\2\2X\u00bb"+
		"\5\b\5\31YZ\f\27\2\2Z[\7\22\2\2[\u00bb\5\b\5\30\\]\f\26\2\2]^\7\22\2\2"+
		"^_\7\26\2\2_\u00bb\5\b\5\27`a\f\25\2\2ab\7\23\2\2b\u00bb\5\b\5\26cd\f"+
		"\24\2\2de\7\23\2\2ef\7\26\2\2f\u00bb\5\b\5\25gh\f\23\2\2hi\7\26\2\2ij"+
		"\7\26\2\2j\u00bb\5\b\5\24kl\f\22\2\2lm\7\r\2\2mn\7\26\2\2n\u00bb\5\b\5"+
		"\23op\f\21\2\2pq\7\17\2\2qr\7\17\2\2r\u00bb\5\b\5\22st\f\20\2\2tu\7\25"+
		"\2\2uv\7\25\2\2v\u00bb\5\b\5\21wx\f\17\2\2xy\7\27\2\2yz\5\b\5\2z{\7\30"+
		"\2\2{|\5\b\5\17|\u00bb\3\2\2\2}~\f\16\2\2~\177\7\26\2\2\177\u00bb\5\b"+
		"\5\16\u0080\u0081\f\r\2\2\u0081\u0082\7\6\2\2\u0082\u0083\7\26\2\2\u0083"+
		"\u00bb\5\b\5\r\u0084\u0085\f\f\2\2\u0085\u0086\7\7\2\2\u0086\u0087\7\26"+
		"\2\2\u0087\u00bb\5\b\5\f\u0088\u0089\f\13\2\2\u0089\u008a\7\16\2\2\u008a"+
		"\u008b\7\26\2\2\u008b\u00bb\5\b\5\13\u008c\u008d\f\n\2\2\u008d\u008e\7"+
		"\20\2\2\u008e\u008f\7\26\2\2\u008f\u00bb\5\b\5\n\u0090\u0091\f\t\2\2\u0091"+
		"\u0092\7\21\2\2\u0092\u0093\7\26\2\2\u0093\u00bb\5\b\5\t\u0094\u0095\f"+
		"\b\2\2\u0095\u0096\7\22\2\2\u0096\u0097\7\22\2\2\u0097\u0098\7\26\2\2"+
		"\u0098\u00bb\5\b\5\b\u0099\u009a\f\7\2\2\u009a\u009b\7\23\2\2\u009b\u009c"+
		"\7\23\2\2\u009c\u009d\7\26\2\2\u009d\u00bb\5\b\5\7\u009e\u009f\f\6\2\2"+
		"\u009f\u00a0\7\17\2\2\u00a0\u00a1\7\26\2\2\u00a1\u00bb\5\b\5\6\u00a2\u00a3"+
		"\f\5\2\2\u00a3\u00a4\7\24\2\2\u00a4\u00a5\7\26\2\2\u00a5\u00bb\5\b\5\5"+
		"\u00a6\u00a7\f\4\2\2\u00a7\u00a8\7\25\2\2\u00a8\u00a9\7\26\2\2\u00a9\u00bb"+
		"\5\b\5\4\u00aa\u00ab\f-\2\2\u00ab\u00ac\7\6\2\2\u00ac\u00bb\7\6\2\2\u00ad"+
		"\u00ae\f,\2\2\u00ae\u00af\7\7\2\2\u00af\u00bb\7\7\2\2\u00b0\u00b1\f+\2"+
		"\2\u00b1\u00b2\7\b\2\2\u00b2\u00b3\5\6\4\2\u00b3\u00b4\7\t\2\2\u00b4\u00bb"+
		"\3\2\2\2\u00b5\u00b6\f*\2\2\u00b6\u00b7\7\n\2\2\u00b7\u00b8\5\6\4\2\u00b8"+
		"\u00b9\7\13\2\2\u00b9\u00bb\3\2\2\2\u00ba\66\3\2\2\2\u00ba9\3\2\2\2\u00ba"+
		"<\3\2\2\2\u00ba?\3\2\2\2\u00baB\3\2\2\2\u00baE\3\2\2\2\u00baH\3\2\2\2"+
		"\u00baL\3\2\2\2\u00baP\3\2\2\2\u00baS\3\2\2\2\u00baV\3\2\2\2\u00baY\3"+
		"\2\2\2\u00ba\\\3\2\2\2\u00ba`\3\2\2\2\u00bac\3\2\2\2\u00bag\3\2\2\2\u00ba"+
		"k\3\2\2\2\u00bao\3\2\2\2\u00bas\3\2\2\2\u00baw\3\2\2\2\u00ba}\3\2\2\2"+
		"\u00ba\u0080\3\2\2\2\u00ba\u0084\3\2\2\2\u00ba\u0088\3\2\2\2\u00ba\u008c"+
		"\3\2\2\2\u00ba\u0090\3\2\2\2\u00ba\u0094\3\2\2\2\u00ba\u0099\3\2\2\2\u00ba"+
		"\u009e\3\2\2\2\u00ba\u00a2\3\2\2\2\u00ba\u00a6\3\2\2\2\u00ba\u00aa\3\2"+
		"\2\2\u00ba\u00ad\3\2\2\2\u00ba\u00b0\3\2\2\2\u00ba\u00b5\3\2\2\2\u00bb"+
		"\u00be\3\2\2\2\u00bc\u00ba\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bd\t\3\2\2\2"+
		"\u00be\u00bc\3\2\2\2\u00bf\u00c6\7\32\2\2\u00c0\u00c6\7\31\2\2\u00c1\u00c2"+
		"\7\b\2\2\u00c2\u00c3\5\b\5\2\u00c3\u00c4\7\t\2\2\u00c4\u00c6\3\2\2\2\u00c5"+
		"\u00bf\3\2\2\2\u00c5\u00c0\3\2\2\2\u00c5\u00c1\3\2\2\2\u00c6\13\3\2\2"+
		"\2\t\24\33\36\64\u00ba\u00bc\u00c5";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}