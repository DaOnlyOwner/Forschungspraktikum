// Generated from c:\Users\Niiko\Desktop\Forschungspraktikum\generators\ANTLR4\grammar\semantic_actions\semantic_actions.g4 by ANTLR 4.7.1

    #include "../src/stack_collection.h"

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class semantic_actionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, IDENT=12, INTEGER=13, WS=14;
	public static final int
		RULE_start = 0, RULE_stmt = 1, RULE_decl_stmt = 2, RULE_atomic_stmt = 3, 
		RULE_new_stack_stmt = 4, RULE_expr = 5, RULE_paren_expr = 6, RULE_function_call_expr = 7, 
		RULE_call_expr_list = 8;
	public static final String[] ruleNames = {
		"start", "stmt", "decl_stmt", "atomic_stmt", "new_stack_stmt", "expr", 
		"paren_expr", "function_call_expr", "call_expr_list"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'='", "';'", "'{'", "'}'", "'*'", "'/'", "'+'", "'-'", "'('", "')'", 
		"','"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"IDENT", "INTEGER", "WS"
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
	public String getGrammarFileName() { return "semantic_actions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	    stack_collection stacks;

	public semantic_actionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class StartContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(semantic_actionsParser.EOF, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public StartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_start; }
	}

	public final StartContext start() throws RecognitionException {
		StartContext _localctx = new StartContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_start);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
				{
				{
				setState(18);
				stmt();
				}
				}
				setState(23);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(24);
			match(EOF);
			stacks.print_error_counts();
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

	public static class StmtContext extends ParserRuleContext {
		public New_stack_stmtContext new_stack_stmt() {
			return getRuleContext(New_stack_stmtContext.class,0);
		}
		public Decl_stmtContext decl_stmt() {
			return getRuleContext(Decl_stmtContext.class,0);
		}
		public Atomic_stmtContext atomic_stmt() {
			return getRuleContext(Atomic_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stmt);
		try {
			setState(30);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(27);
				new_stack_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(28);
				decl_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(29);
				atomic_stmt();
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

	public static class Decl_stmtContext extends ParserRuleContext {
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(semantic_actionsParser.IDENT, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Decl_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_stmt; }
	}

	public final Decl_stmtContext decl_stmt() throws RecognitionException {
		Decl_stmtContext _localctx = new Decl_stmtContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_decl_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			((Decl_stmtContext)_localctx).IDENT = match(IDENT);
			setState(33);
			match(T__0);
			setState(34);
			expr(0);
			stacks.check_decl((((Decl_stmtContext)_localctx).IDENT!=null?((Decl_stmtContext)_localctx).IDENT.getText():null));
			setState(36);
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

	public static class Atomic_stmtContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Atomic_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomic_stmt; }
	}

	public final Atomic_stmtContext atomic_stmt() throws RecognitionException {
		Atomic_stmtContext _localctx = new Atomic_stmtContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_atomic_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			expr(0);
			setState(39);
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

	public static class New_stack_stmtContext extends ParserRuleContext {
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public New_stack_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_new_stack_stmt; }
	}

	public final New_stack_stmtContext new_stack_stmt() throws RecognitionException {
		New_stack_stmtContext _localctx = new New_stack_stmtContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_new_stack_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(T__2);
			stacks.push();
			setState(44); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(43);
				stmt();
				}
				}
				setState(46); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__8) | (1L << IDENT) | (1L << INTEGER))) != 0) );
			setState(48);
			match(T__3);
			stacks.pop();
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
		public Token IDENT;
		public Paren_exprContext paren_expr() {
			return getRuleContext(Paren_exprContext.class,0);
		}
		public Function_call_exprContext function_call_expr() {
			return getRuleContext(Function_call_exprContext.class,0);
		}
		public TerminalNode IDENT() { return getToken(semantic_actionsParser.IDENT, 0); }
		public TerminalNode INTEGER() { return getToken(semantic_actionsParser.INTEGER, 0); }
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 10;
		enterRecursionRule(_localctx, 10, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(52);
				paren_expr();
				}
				break;
			case 2:
				{
				setState(53);
				function_call_expr();
				}
				break;
			case 3:
				{
				setState(54);
				((ExprContext)_localctx).IDENT = match(IDENT);
				stacks.check_use((((ExprContext)_localctx).IDENT!=null?((ExprContext)_localctx).IDENT.getText():null));
				}
				break;
			case 4:
				{
				setState(56);
				match(INTEGER);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(65);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(59);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(60);
						_la = _input.LA(1);
						if ( !(_la==T__4 || _la==T__5) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(61);
						expr(6);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(62);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(63);
						_la = _input.LA(1);
						if ( !(_la==T__6 || _la==T__7) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(64);
						expr(5);
						}
						break;
					}
					} 
				}
				setState(69);
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

	public static class Paren_exprContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Paren_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_paren_expr; }
	}

	public final Paren_exprContext paren_expr() throws RecognitionException {
		Paren_exprContext _localctx = new Paren_exprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_paren_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(70);
			match(T__8);
			setState(71);
			expr(0);
			setState(72);
			match(T__9);
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

	public static class Function_call_exprContext extends ParserRuleContext {
		public Token IDENT;
		public TerminalNode IDENT() { return getToken(semantic_actionsParser.IDENT, 0); }
		public Call_expr_listContext call_expr_list() {
			return getRuleContext(Call_expr_listContext.class,0);
		}
		public Function_call_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_expr; }
	}

	public final Function_call_exprContext function_call_expr() throws RecognitionException {
		Function_call_exprContext _localctx = new Function_call_exprContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_call_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			((Function_call_exprContext)_localctx).IDENT = match(IDENT);
			stacks.check_function_name((((Function_call_exprContext)_localctx).IDENT!=null?((Function_call_exprContext)_localctx).IDENT.getText():null));
			setState(76);
			match(T__8);
			setState(77);
			call_expr_list();
			setState(78);
			match(T__9);
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

	public static class Call_expr_listContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public Call_expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_expr_list; }
	}

	public final Call_expr_listContext call_expr_list() throws RecognitionException {
		Call_expr_listContext _localctx = new Call_expr_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__8) | (1L << IDENT) | (1L << INTEGER))) != 0)) {
				{
				setState(80);
				expr(0);
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__10) {
					{
					{
					setState(81);
					match(T__10);
					setState(82);
					expr(0);
					}
					}
					setState(87);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 5:
			return expr_sempred((ExprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 5);
		case 1:
			return precpred(_ctx, 4);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\20]\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7\2\26"+
		"\n\2\f\2\16\2\31\13\2\3\2\3\2\3\2\3\3\3\3\3\3\5\3!\n\3\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\6\6/\n\6\r\6\16\6\60\3\6\3\6\3\6\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\5\7<\n\7\3\7\3\7\3\7\3\7\3\7\3\7\7\7D\n\7\f\7\16"+
		"\7G\13\7\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\nV\n\n"+
		"\f\n\16\nY\13\n\5\n[\n\n\3\n\2\3\f\13\2\4\6\b\n\f\16\20\22\2\4\3\2\7\b"+
		"\3\2\t\n\2^\2\27\3\2\2\2\4 \3\2\2\2\6\"\3\2\2\2\b(\3\2\2\2\n+\3\2\2\2"+
		"\f;\3\2\2\2\16H\3\2\2\2\20L\3\2\2\2\22Z\3\2\2\2\24\26\5\4\3\2\25\24\3"+
		"\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30\3\2\2\2\30\32\3\2\2\2\31\27\3"+
		"\2\2\2\32\33\7\2\2\3\33\34\b\2\1\2\34\3\3\2\2\2\35!\5\n\6\2\36!\5\6\4"+
		"\2\37!\5\b\5\2 \35\3\2\2\2 \36\3\2\2\2 \37\3\2\2\2!\5\3\2\2\2\"#\7\16"+
		"\2\2#$\7\3\2\2$%\5\f\7\2%&\b\4\1\2&\'\7\4\2\2\'\7\3\2\2\2()\5\f\7\2)*"+
		"\7\4\2\2*\t\3\2\2\2+,\7\5\2\2,.\b\6\1\2-/\5\4\3\2.-\3\2\2\2/\60\3\2\2"+
		"\2\60.\3\2\2\2\60\61\3\2\2\2\61\62\3\2\2\2\62\63\7\6\2\2\63\64\b\6\1\2"+
		"\64\13\3\2\2\2\65\66\b\7\1\2\66<\5\16\b\2\67<\5\20\t\289\7\16\2\29<\b"+
		"\7\1\2:<\7\17\2\2;\65\3\2\2\2;\67\3\2\2\2;8\3\2\2\2;:\3\2\2\2<E\3\2\2"+
		"\2=>\f\7\2\2>?\t\2\2\2?D\5\f\7\b@A\f\6\2\2AB\t\3\2\2BD\5\f\7\7C=\3\2\2"+
		"\2C@\3\2\2\2DG\3\2\2\2EC\3\2\2\2EF\3\2\2\2F\r\3\2\2\2GE\3\2\2\2HI\7\13"+
		"\2\2IJ\5\f\7\2JK\7\f\2\2K\17\3\2\2\2LM\7\16\2\2MN\b\t\1\2NO\7\13\2\2O"+
		"P\5\22\n\2PQ\7\f\2\2Q\21\3\2\2\2RW\5\f\7\2ST\7\r\2\2TV\5\f\7\2US\3\2\2"+
		"\2VY\3\2\2\2WU\3\2\2\2WX\3\2\2\2X[\3\2\2\2YW\3\2\2\2ZR\3\2\2\2Z[\3\2\2"+
		"\2[\23\3\2\2\2\n\27 \60;CEWZ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}