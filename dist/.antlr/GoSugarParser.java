// Generated from /home/carlos/outros-projetos/gosugar/GoSugar.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class GoSugarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, T__47=48, T__48=49, T__49=50, T__50=51, T__51=52, 
		T__52=53, T__53=54, T__54=55, T__55=56, T__56=57, T__57=58, T__58=59, 
		T__59=60, T__60=61, ELLIPSIS=62, STAR=63, AMPERSAND=64, CREATE=65, STATIC=66, 
		IDENTIFIER=67, NUMBER=68, POSITIVE_INTEGER=69, DOT=70, STRING=71, NIL=72, 
		WS=73, BlockComment=74, LineComment=75, NEWLINE=76, STRING_TAG=77, ANGLE_TAG=78;
	public static final int
		RULE_program = 0, RULE_programDeclaration = 1, RULE_globalVarStatement = 2, 
		RULE_interfaceDeclaration = 3, RULE_interfaceBody = 4, RULE_interfaceMethod = 5, 
		RULE_classDeclaration = 6, RULE_packageDeclaration = 7, RULE_importsDeclaration = 8, 
		RULE_createObjectDeclaration = 9, RULE_sliceDeclaration = 10, RULE_sliceOrArrayLiteral = 11, 
		RULE_listAccess = 12, RULE_aliasType = 13, RULE_compositionList = 14, 
		RULE_mustInterfaceList = 15, RULE_classBody = 16, RULE_classMember = 17, 
		RULE_varType = 18, RULE_fieldDeclaration = 19, RULE_structTag = 20, RULE_methodDeclaration = 21, 
		RULE_anonimousFunctionDeclaration = 22, RULE_returnType = 23, RULE_returnTypeList = 24, 
		RULE_returnTypeSingle = 25, RULE_parameterList = 26, RULE_methodBody = 27, 
		RULE_parameter = 28, RULE_block = 29, RULE_statement = 30, RULE_switchStatement = 31, 
		RULE_caseBlock = 32, RULE_defaultBlock = 33, RULE_negationExpression = 34, 
		RULE_assignment = 35, RULE_assignmentLeftHandSide = 36, RULE_leftHandSide = 37, 
		RULE_assignmentOperator = 38, RULE_comparisonOperator = 39, RULE_methodCall = 40, 
		RULE_argumentList = 41, RULE_expression = 42, RULE_concatenatedString = 43, 
		RULE_interfaceTypeVerification = 44, RULE_primaryExpression = 45, RULE_directCreateInstance = 46, 
		RULE_mapKeyValue = 47, RULE_listLiteral = 48, RULE_operatorExpression = 49, 
		RULE_comparison = 50, RULE_returnOperation = 51, RULE_continueOperation = 52, 
		RULE_breakOperation = 53, RULE_varValue = 54, RULE_varStatement = 55, 
		RULE_ifStatement = 56, RULE_elseStatement = 57, RULE_incrementOrDecrementStatement = 58, 
		RULE_forStatement = 59, RULE_classicForLoop = 60, RULE_rangeForLoop = 61, 
		RULE_conditionForLoop = 62, RULE_infiniteForLoop = 63, RULE_simpleStatement = 64, 
		RULE_expressionList = 65, RULE_mapInitialization = 66, RULE_foreachStatement = 67, 
		RULE_typeConversion = 68;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "programDeclaration", "globalVarStatement", "interfaceDeclaration", 
			"interfaceBody", "interfaceMethod", "classDeclaration", "packageDeclaration", 
			"importsDeclaration", "createObjectDeclaration", "sliceDeclaration", 
			"sliceOrArrayLiteral", "listAccess", "aliasType", "compositionList", 
			"mustInterfaceList", "classBody", "classMember", "varType", "fieldDeclaration", 
			"structTag", "methodDeclaration", "anonimousFunctionDeclaration", "returnType", 
			"returnTypeList", "returnTypeSingle", "parameterList", "methodBody", 
			"parameter", "block", "statement", "switchStatement", "caseBlock", "defaultBlock", 
			"negationExpression", "assignment", "assignmentLeftHandSide", "leftHandSide", 
			"assignmentOperator", "comparisonOperator", "methodCall", "argumentList", 
			"expression", "concatenatedString", "interfaceTypeVerification", "primaryExpression", 
			"directCreateInstance", "mapKeyValue", "listLiteral", "operatorExpression", 
			"comparison", "returnOperation", "continueOperation", "breakOperation", 
			"varValue", "varStatement", "ifStatement", "elseStatement", "incrementOrDecrementStatement", 
			"forStatement", "classicForLoop", "rangeForLoop", "conditionForLoop", 
			"infiniteForLoop", "simpleStatement", "expressionList", "mapInitialization", 
			"foreachStatement", "typeConversion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'interface'", "'{'", "'}'", "'('", "')'", "'class'", "'as'", "'use'", 
			"'must'", "'package'", "'import'", "'[]'", "','", "'['", "']'", "'map'", 
			"'func'", "':'", "'->'", "'switch'", "'case'", "'default'", "'!'", "'{}'", 
			"'='", "':='", "'*='", "'/='", "'%='", "'+='", "'-='", "'<<='", "'>>='", 
			"'&='", "'^='", "'|='", "'=='", "'!='", "'>'", "'<'", "'>='", "'<='", 
			"'||'", "'&&'", "'+'", "'interface{}'", "'/'", "'%'", "'-'", "'return'", 
			"'continue'", "'break'", "'var'", "'if'", "';'", "'else'", "'++'", "'--'", 
			"'for'", "'range'", "'foreach'", "'...'", "'*'", "'&'", "'create'", "'static'", 
			null, null, null, "'.'", null, "'nil'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "ELLIPSIS", "STAR", "AMPERSAND", "CREATE", "STATIC", "IDENTIFIER", 
			"NUMBER", "POSITIVE_INTEGER", "DOT", "STRING", "NIL", "WS", "BlockComment", 
			"LineComment", "NEWLINE", "STRING_TAG", "ANGLE_TAG"
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
	public String getGrammarFileName() { return "GoSugar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GoSugarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GoSugarParser.EOF, 0); }
		public List<ProgramDeclarationContext> programDeclaration() {
			return getRuleContexts(ProgramDeclarationContext.class);
		}
		public ProgramDeclarationContext programDeclaration(int i) {
			return getRuleContext(ProgramDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9007199254875202L) != 0) || _la==STATIC) {
				{
				{
				setState(138);
				programDeclaration();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
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
	public static class ProgramDeclarationContext extends ParserRuleContext {
		public ImportsDeclarationContext importsDeclaration() {
			return getRuleContext(ImportsDeclarationContext.class,0);
		}
		public GlobalVarStatementContext globalVarStatement() {
			return getRuleContext(GlobalVarStatementContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ProgramDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_programDeclaration; }
	}

	public final ProgramDeclarationContext programDeclaration() throws RecognitionException {
		ProgramDeclarationContext _localctx = new ProgramDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_programDeclaration);
		try {
			setState(152);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(146);
				importsDeclaration();
				}
				break;
			case T__52:
				enterOuterAlt(_localctx, 2);
				{
				setState(147);
				globalVarStatement();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 3);
				{
				setState(148);
				interfaceDeclaration();
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 4);
				{
				setState(149);
				classDeclaration();
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 5);
				{
				setState(150);
				packageDeclaration();
				}
				break;
			case T__16:
			case STATIC:
				enterOuterAlt(_localctx, 6);
				{
				setState(151);
				methodDeclaration();
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
	public static class GlobalVarStatementContext extends ParserRuleContext {
		public VarStatementContext varStatement() {
			return getRuleContext(VarStatementContext.class,0);
		}
		public GlobalVarStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVarStatement; }
	}

	public final GlobalVarStatementContext globalVarStatement() throws RecognitionException {
		GlobalVarStatementContext _localctx = new GlobalVarStatementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_globalVarStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			varStatement();
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
	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_interfaceDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			match(T__0);
			setState(157);
			match(IDENTIFIER);
			setState(158);
			interfaceBody();
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
	public static class InterfaceBodyContext extends ParserRuleContext {
		public List<InterfaceMethodContext> interfaceMethod() {
			return getRuleContexts(InterfaceMethodContext.class);
		}
		public InterfaceMethodContext interfaceMethod(int i) {
			return getRuleContext(InterfaceMethodContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160);
			match(T__1);
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IDENTIFIER) {
				{
				{
				setState(161);
				interfaceMethod();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(167);
			match(T__2);
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
	public static class InterfaceMethodContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public InterfaceMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethod; }
	}

	public final InterfaceMethodContext interfaceMethod() throws RecognitionException {
		InterfaceMethodContext _localctx = new InterfaceMethodContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_interfaceMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(IDENTIFIER);
			setState(170);
			match(T__3);
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(171);
				parameterList();
				}
			}

			setState(174);
			match(T__4);
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(175);
				returnType();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public AliasTypeContext aliasType() {
			return getRuleContext(AliasTypeContext.class,0);
		}
		public CompositionListContext compositionList() {
			return getRuleContext(CompositionListContext.class,0);
		}
		public MustInterfaceListContext mustInterfaceList() {
			return getRuleContext(MustInterfaceListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			match(T__5);
			setState(179);
			match(IDENTIFIER);
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(180);
				match(T__6);
				setState(181);
				aliasType();
				}
			}

			setState(186);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__7) {
				{
				setState(184);
				match(T__7);
				setState(185);
				compositionList();
				}
			}

			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__8) {
				{
				setState(188);
				match(T__8);
				setState(189);
				mustInterfaceList();
				}
			}

			setState(192);
			classBody();
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
	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(194);
			match(T__9);
			setState(195);
			match(IDENTIFIER);
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
	public static class ImportsDeclarationContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(GoSugarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GoSugarParser.STRING, i);
		}
		public List<TerminalNode> WS() { return getTokens(GoSugarParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(GoSugarParser.WS, i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(GoSugarParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(GoSugarParser.NEWLINE, i);
		}
		public ImportsDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importsDeclaration; }
	}

	public final ImportsDeclarationContext importsDeclaration() throws RecognitionException {
		ImportsDeclarationContext _localctx = new ImportsDeclarationContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_importsDeclaration);
		int _la;
		try {
			int _alt;
			setState(233);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197);
				match(T__10);
				setState(198);
				match(STRING);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				match(T__10);
				setState(200);
				match(T__3);
				setState(204);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==WS) {
					{
					{
					setState(201);
					match(WS);
					}
					}
					setState(206);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(207);
				match(STRING);
				setState(229);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 37L) != 0)) {
					{
					{
					setState(211);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(208);
							match(WS);
							}
							} 
						}
						setState(213);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
					}
					setState(217);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NEWLINE) {
						{
						{
						setState(214);
						match(NEWLINE);
						}
						}
						setState(219);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==WS) {
						{
						{
						setState(220);
						match(WS);
						}
						}
						setState(225);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(226);
					match(STRING);
					}
					}
					setState(231);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(232);
				match(T__4);
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
	public static class CreateObjectDeclarationContext extends ParserRuleContext {
		public TerminalNode CREATE() { return getToken(GoSugarParser.CREATE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public CreateObjectDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createObjectDeclaration; }
	}

	public final CreateObjectDeclarationContext createObjectDeclaration() throws RecognitionException {
		CreateObjectDeclarationContext _localctx = new CreateObjectDeclarationContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_createObjectDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(235);
			match(CREATE);
			setState(236);
			match(IDENTIFIER);
			setState(237);
			match(T__3);
			setState(239);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
				{
				setState(238);
				argumentList();
				}
			}

			setState(241);
			match(T__4);
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
	public static class SliceDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public SliceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceDeclaration; }
	}

	public final SliceDeclarationContext sliceDeclaration() throws RecognitionException {
		SliceDeclarationContext _localctx = new SliceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_sliceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			match(T__11);
			setState(244);
			match(IDENTIFIER);
			setState(245);
			match(T__1);
			setState(254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
				{
				setState(246);
				primaryExpression();
				setState(251);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(247);
					match(T__12);
					setState(248);
					primaryExpression();
					}
					}
					setState(253);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(256);
			match(T__2);
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
	public static class SliceOrArrayLiteralContext extends ParserRuleContext {
		public List<PrimaryExpressionContext> primaryExpression() {
			return getRuleContexts(PrimaryExpressionContext.class);
		}
		public PrimaryExpressionContext primaryExpression(int i) {
			return getRuleContext(PrimaryExpressionContext.class,i);
		}
		public SliceOrArrayLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sliceOrArrayLiteral; }
	}

	public final SliceOrArrayLiteralContext sliceOrArrayLiteral() throws RecognitionException {
		SliceOrArrayLiteralContext _localctx = new SliceOrArrayLiteralContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_sliceOrArrayLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(T__13);
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
				{
				setState(259);
				primaryExpression();
				setState(264);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__12) {
					{
					{
					setState(260);
					match(T__12);
					setState(261);
					primaryExpression();
					}
					}
					setState(266);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(269);
			match(T__14);
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
	public static class ListAccessContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ListAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listAccess; }
	}

	public final ListAccessContext listAccess() throws RecognitionException {
		ListAccessContext _localctx = new ListAccessContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_listAccess);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(271);
			leftHandSide();
			setState(278);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(272);
					match(T__13);
					setState(273);
					expression();
					setState(274);
					match(T__14);
					}
					} 
				}
				setState(280);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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
	public static class AliasTypeContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public AliasTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aliasType; }
	}

	public final AliasTypeContext aliasType() throws RecognitionException {
		AliasTypeContext _localctx = new AliasTypeContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_aliasType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(281);
			varType();
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
	public static class CompositionListContext extends ParserRuleContext {
		public List<LeftHandSideContext> leftHandSide() {
			return getRuleContexts(LeftHandSideContext.class);
		}
		public LeftHandSideContext leftHandSide(int i) {
			return getRuleContext(LeftHandSideContext.class,i);
		}
		public CompositionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compositionList; }
	}

	public final CompositionListContext compositionList() throws RecognitionException {
		CompositionListContext _localctx = new CompositionListContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_compositionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(283);
			leftHandSide();
			setState(288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(284);
				match(T__12);
				setState(285);
				leftHandSide();
				}
				}
				setState(290);
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
	public static class MustInterfaceListContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GoSugarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GoSugarParser.IDENTIFIER, i);
		}
		public MustInterfaceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mustInterfaceList; }
	}

	public final MustInterfaceListContext mustInterfaceList() throws RecognitionException {
		MustInterfaceListContext _localctx = new MustInterfaceListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mustInterfaceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(291);
			match(IDENTIFIER);
			setState(296);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(292);
				match(T__12);
				setState(293);
				match(IDENTIFIER);
				}
				}
				setState(298);
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
	public static class ClassBodyContext extends ParserRuleContext {
		public List<ClassMemberContext> classMember() {
			return getRuleContexts(ClassMemberContext.class);
		}
		public ClassMemberContext classMember(int i) {
			return getRuleContext(ClassMemberContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			match(T__1);
			setState(303);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 17)) & ~0x3f) == 0 && ((1L << (_la - 17)) & 1688849860263937L) != 0)) {
				{
				{
				setState(300);
				classMember();
				}
				}
				setState(305);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(306);
			match(T__2);
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
	public static class ClassMemberContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassMemberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMember; }
	}

	public final ClassMemberContext classMember() throws RecognitionException {
		ClassMemberContext _localctx = new ClassMemberContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_classMember);
		try {
			setState(310);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(308);
				fieldDeclaration();
				}
				break;
			case T__16:
			case STATIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(309);
				methodDeclaration();
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
	public static class VarTypeContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public TerminalNode STAR() { return getToken(GoSugarParser.STAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoSugarParser.AMPERSAND, 0); }
		public List<VarTypeContext> varType() {
			return getRuleContexts(VarTypeContext.class);
		}
		public VarTypeContext varType(int i) {
			return getRuleContext(VarTypeContext.class,i);
		}
		public TerminalNode NUMBER() { return getToken(GoSugarParser.NUMBER, 0); }
		public TerminalNode DOT() { return getToken(GoSugarParser.DOT, 0); }
		public VarTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varType; }
	}

	public final VarTypeContext varType() throws RecognitionException {
		VarTypeContext _localctx = new VarTypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_varType);
		int _la;
		try {
			setState(360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(313);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(312);
					match(STAR);
					}
				}

				setState(316);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(315);
					match(AMPERSAND);
					}
				}

				setState(318);
				match(IDENTIFIER);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(319);
					match(STAR);
					}
				}

				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(322);
					match(AMPERSAND);
					}
				}

				setState(325);
				match(T__11);
				setState(326);
				varType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(328);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(327);
					match(STAR);
					}
				}

				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(330);
					match(AMPERSAND);
					}
				}

				setState(333);
				match(T__13);
				setState(335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(334);
					match(NUMBER);
					}
				}

				setState(337);
				match(T__14);
				setState(338);
				varType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(339);
					match(STAR);
					}
				}

				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(342);
					match(AMPERSAND);
					}
				}

				setState(345);
				match(T__15);
				setState(346);
				match(T__13);
				setState(347);
				varType();
				setState(348);
				match(T__14);
				setState(349);
				varType();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(352);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(351);
					match(STAR);
					}
				}

				setState(355);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(354);
					match(AMPERSAND);
					}
				}

				setState(357);
				match(IDENTIFIER);
				setState(358);
				match(DOT);
				setState(359);
				varType();
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
	public static class FieldDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public StructTagContext structTag() {
			return getRuleContext(StructTagContext.class,0);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(362);
			match(IDENTIFIER);
			setState(363);
			varType();
			setState(365);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STRING_TAG || _la==ANGLE_TAG) {
				{
				setState(364);
				structTag();
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
	public static class StructTagContext extends ParserRuleContext {
		public TerminalNode STRING_TAG() { return getToken(GoSugarParser.STRING_TAG, 0); }
		public TerminalNode ANGLE_TAG() { return getToken(GoSugarParser.ANGLE_TAG, 0); }
		public StructTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_structTag; }
	}

	public final StructTagContext structTag() throws RecognitionException {
		StructTagContext _localctx = new StructTagContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_structTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(367);
			_la = _input.LA(1);
			if ( !(_la==STRING_TAG || _la==ANGLE_TAG) ) {
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
	public static class MethodDeclarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(GoSugarParser.STATIC, 0); }
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(370);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(369);
				match(STATIC);
				}
			}

			setState(372);
			match(T__16);
			setState(373);
			match(IDENTIFIER);
			setState(374);
			match(T__3);
			setState(376);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(375);
				parameterList();
				}
			}

			setState(378);
			match(T__4);
			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 4)) & ~0x3f) == 0 && ((1L << (_la - 4)) & -7493989779944499967L) != 0)) {
				{
				setState(379);
				returnType();
				}
			}

			setState(382);
			methodBody();
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
	public static class AnonimousFunctionDeclarationContext extends ParserRuleContext {
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public ReturnTypeContext returnType() {
			return getRuleContext(ReturnTypeContext.class,0);
		}
		public AnonimousFunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonimousFunctionDeclaration; }
	}

	public final AnonimousFunctionDeclarationContext anonimousFunctionDeclaration() throws RecognitionException {
		AnonimousFunctionDeclarationContext _localctx = new AnonimousFunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_anonimousFunctionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(384);
			match(T__3);
			setState(386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(385);
				parameterList();
				}
			}

			setState(388);
			match(T__4);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__17) {
				{
				setState(389);
				match(T__17);
				setState(390);
				returnType();
				}
			}

			setState(393);
			match(T__18);
			setState(394);
			methodBody();
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
	public static class ReturnTypeContext extends ParserRuleContext {
		public ReturnTypeListContext returnTypeList() {
			return getRuleContext(ReturnTypeListContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ReturnTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnType; }
	}

	public final ReturnTypeContext returnType() throws RecognitionException {
		ReturnTypeContext _localctx = new ReturnTypeContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_returnType);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__3:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				match(T__3);
				setState(397);
				returnTypeList();
				setState(398);
				match(T__4);
				}
				break;
			case T__11:
			case T__13:
			case T__15:
			case STAR:
			case AMPERSAND:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(400);
				varType();
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
	public static class ReturnTypeListContext extends ParserRuleContext {
		public List<ReturnTypeSingleContext> returnTypeSingle() {
			return getRuleContexts(ReturnTypeSingleContext.class);
		}
		public ReturnTypeSingleContext returnTypeSingle(int i) {
			return getRuleContext(ReturnTypeSingleContext.class,i);
		}
		public ReturnTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnTypeList; }
	}

	public final ReturnTypeListContext returnTypeList() throws RecognitionException {
		ReturnTypeListContext _localctx = new ReturnTypeListContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_returnTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			returnTypeSingle();
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(404);
				match(T__12);
				setState(405);
				returnTypeSingle();
				}
				}
				setState(410);
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
	public static class ReturnTypeSingleContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public ReturnTypeSingleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnTypeSingle; }
	}

	public final ReturnTypeSingleContext returnTypeSingle() throws RecognitionException {
		ReturnTypeSingleContext _localctx = new ReturnTypeSingleContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_returnTypeSingle);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(411);
			varType();
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
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(413);
			parameter();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(414);
				match(T__12);
				setState(415);
				parameter();
				}
				}
				setState(420);
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
	public static class MethodBodyContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_methodBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(421);
			match(T__1);
			setState(425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6234107784186474492L) != 0) || _la==AMPERSAND || _la==IDENTIFIER) {
				{
				{
				setState(422);
				statement();
				}
				}
				setState(427);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(428);
			match(T__2);
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
	public static class ParameterContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(GoSugarParser.ELLIPSIS, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_parameter);
		int _la;
		try {
			setState(437);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(IDENTIFIER);
				setState(432);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & 42784196460019733L) != 0)) {
					{
					setState(431);
					varType();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(434);
				match(IDENTIFIER);
				setState(435);
				match(ELLIPSIS);
				setState(436);
				varType();
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
	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(T__1);
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6234107784186474492L) != 0) || _la==AMPERSAND || _la==IDENTIFIER) {
				{
				{
				setState(440);
				statement();
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
			match(T__2);
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
	public static class StatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public ReturnOperationContext returnOperation() {
			return getRuleContext(ReturnOperationContext.class,0);
		}
		public ContinueOperationContext continueOperation() {
			return getRuleContext(ContinueOperationContext.class,0);
		}
		public BreakOperationContext breakOperation() {
			return getRuleContext(BreakOperationContext.class,0);
		}
		public VarStatementContext varStatement() {
			return getRuleContext(VarStatementContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public IncrementOrDecrementStatementContext incrementOrDecrementStatement() {
			return getRuleContext(IncrementOrDecrementStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_statement);
		try {
			setState(461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(449);
				methodCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(450);
				returnOperation();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(451);
				continueOperation();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(452);
				breakOperation();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(453);
				varStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(454);
				listLiteral();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(455);
				ifStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(456);
				elseStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(457);
				forStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(458);
				foreachStatement();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(459);
				incrementOrDecrementStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(460);
				switchStatement();
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
	public static class SwitchStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<CaseBlockContext> caseBlock() {
			return getRuleContexts(CaseBlockContext.class);
		}
		public CaseBlockContext caseBlock(int i) {
			return getRuleContext(CaseBlockContext.class,i);
		}
		public DefaultBlockContext defaultBlock() {
			return getRuleContext(DefaultBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(463);
			match(T__19);
			setState(464);
			expression();
			setState(465);
			match(T__1);
			setState(469);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__20) {
				{
				{
				setState(466);
				caseBlock();
				}
				}
				setState(471);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(473);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__21) {
				{
				setState(472);
				defaultBlock();
				}
			}

			setState(475);
			match(T__2);
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
	public static class CaseBlockContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public CaseBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseBlock; }
	}

	public final CaseBlockContext caseBlock() throws RecognitionException {
		CaseBlockContext _localctx = new CaseBlockContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_caseBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(T__20);
			setState(478);
			expressionList();
			setState(479);
			match(T__17);
			setState(483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6234107784186474492L) != 0) || _la==AMPERSAND || _la==IDENTIFIER) {
				{
				{
				setState(480);
				statement();
				}
				}
				setState(485);
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
	public static class DefaultBlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public DefaultBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultBlock; }
	}

	public final DefaultBlockContext defaultBlock() throws RecognitionException {
		DefaultBlockContext _localctx = new DefaultBlockContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_defaultBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(486);
			match(T__21);
			setState(487);
			match(T__17);
			setState(491);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -6234107784186474492L) != 0) || _la==AMPERSAND || _la==IDENTIFIER) {
				{
				{
				setState(488);
				statement();
				}
				}
				setState(493);
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
	public static class NegationExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STAR() { return getToken(GoSugarParser.STAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoSugarParser.AMPERSAND, 0); }
		public NegationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_negationExpression; }
	}

	public final NegationExpressionContext negationExpression() throws RecognitionException {
		NegationExpressionContext _localctx = new NegationExpressionContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_negationExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(494);
			match(T__22);
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				{
				setState(495);
				match(STAR);
				}
				break;
			}
			setState(499);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,55,_ctx) ) {
			case 1:
				{
				setState(498);
				match(AMPERSAND);
				}
				break;
			}
			setState(501);
			expression();
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
	public static class AssignmentContext extends ParserRuleContext {
		public List<AssignmentLeftHandSideContext> assignmentLeftHandSide() {
			return getRuleContexts(AssignmentLeftHandSideContext.class);
		}
		public AssignmentLeftHandSideContext assignmentLeftHandSide(int i) {
			return getRuleContext(AssignmentLeftHandSideContext.class,i);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			assignmentLeftHandSide();
			setState(506);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(504);
				match(T__12);
				setState(505);
				assignmentLeftHandSide();
				}
			}

			setState(508);
			assignmentOperator();
			setState(509);
			expression();
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
	public static class AssignmentLeftHandSideContext extends ParserRuleContext {
		public List<LeftHandSideContext> leftHandSide() {
			return getRuleContexts(LeftHandSideContext.class);
		}
		public LeftHandSideContext leftHandSide(int i) {
			return getRuleContext(LeftHandSideContext.class,i);
		}
		public ListAccessContext listAccess() {
			return getRuleContext(ListAccessContext.class,0);
		}
		public AssignmentLeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentLeftHandSide; }
	}

	public final AssignmentLeftHandSideContext assignmentLeftHandSide() throws RecognitionException {
		AssignmentLeftHandSideContext _localctx = new AssignmentLeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_assignmentLeftHandSide);
		try {
			setState(516);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,57,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(511);
				leftHandSide();
				{
				setState(512);
				match(T__12);
				setState(513);
				leftHandSide();
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(515);
				listAccess();
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
	public static class LeftHandSideContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GoSugarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GoSugarParser.IDENTIFIER, i);
		}
		public TerminalNode STAR() { return getToken(GoSugarParser.STAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoSugarParser.AMPERSAND, 0); }
		public List<TerminalNode> DOT() { return getTokens(GoSugarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GoSugarParser.DOT, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_leftHandSide);
		int _la;
		try {
			int _alt;
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,67,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(518);
					match(STAR);
					}
				}

				setState(522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(521);
					match(AMPERSAND);
					}
				}

				setState(524);
				match(IDENTIFIER);
				setState(528);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__23) {
					{
					{
					setState(525);
					match(T__23);
					}
					}
					setState(530);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(531);
					match(DOT);
					setState(532);
					match(IDENTIFIER);
					}
					}
					setState(537);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(539);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(538);
					match(STAR);
					}
				}

				setState(542);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(541);
					match(AMPERSAND);
					}
				}

				setState(544);
				match(IDENTIFIER);
				setState(551);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(545);
						match(T__13);
						setState(546);
						expression();
						setState(547);
						match(T__14);
						}
						} 
					}
					setState(553);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,64,_ctx);
				}
				setState(567);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(554);
					match(DOT);
					setState(555);
					match(IDENTIFIER);
					setState(562);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(556);
							match(T__13);
							setState(557);
							expression();
							setState(558);
							match(T__14);
							}
							} 
						}
						setState(564);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
					}
					}
					}
					setState(569);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
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
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 137405399040L) != 0)) ) {
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
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(574);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 35046933135360L) != 0)) ) {
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
	public static class MethodCallContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode DOT() { return getToken(GoSugarParser.DOT, 0); }
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_methodCall);
		int _la;
		try {
			setState(599);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(576);
				match(IDENTIFIER);
				setState(577);
				match(T__3);
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
					{
					setState(578);
					argumentList();
					}
				}

				setState(581);
				match(T__4);
				setState(584);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
				case 1:
					{
					setState(582);
					match(DOT);
					setState(583);
					methodCall();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(586);
				leftHandSide();
				setState(587);
				match(T__3);
				setState(589);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
					{
					setState(588);
					argumentList();
					}
				}

				setState(591);
				match(T__4);
				setState(593);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,71,_ctx) ) {
				case 1:
					{
					setState(592);
					match(T__12);
					}
					break;
				}
				setState(597);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,72,_ctx) ) {
				case 1:
					{
					setState(595);
					match(DOT);
					setState(596);
					methodCall();
					}
					break;
				}
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
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(601);
			expression();
			setState(606);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(602);
				match(T__12);
				setState(603);
				expression();
				}
				}
				setState(608);
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
	public static class ExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public List<OperatorExpressionContext> operatorExpression() {
			return getRuleContexts(OperatorExpressionContext.class);
		}
		public OperatorExpressionContext operatorExpression(int i) {
			return getRuleContext(OperatorExpressionContext.class,i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_expression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(609);
			primaryExpression();
			setState(613);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(610);
					operatorExpression();
					}
					} 
				}
				setState(615);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,75,_ctx);
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
	public static class ConcatenatedStringContext extends ParserRuleContext {
		public List<TerminalNode> STRING() { return getTokens(GoSugarParser.STRING); }
		public TerminalNode STRING(int i) {
			return getToken(GoSugarParser.STRING, i);
		}
		public ConcatenatedStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concatenatedString; }
	}

	public final ConcatenatedStringContext concatenatedString() throws RecognitionException {
		ConcatenatedStringContext _localctx = new ConcatenatedStringContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_concatenatedString);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(STRING);
			setState(619); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(617);
					match(T__44);
					setState(618);
					match(STRING);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(621); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
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
	public static class InterfaceTypeVerificationContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GoSugarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GoSugarParser.IDENTIFIER, i);
		}
		public List<TerminalNode> DOT() { return getTokens(GoSugarParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(GoSugarParser.DOT, i);
		}
		public List<TerminalNode> STAR() { return getTokens(GoSugarParser.STAR); }
		public TerminalNode STAR(int i) {
			return getToken(GoSugarParser.STAR, i);
		}
		public List<MethodCallContext> methodCall() {
			return getRuleContexts(MethodCallContext.class);
		}
		public MethodCallContext methodCall(int i) {
			return getRuleContext(MethodCallContext.class,i);
		}
		public InterfaceTypeVerificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypeVerification; }
	}

	public final InterfaceTypeVerificationContext interfaceTypeVerification() throws RecognitionException {
		InterfaceTypeVerificationContext _localctx = new InterfaceTypeVerificationContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_interfaceTypeVerification);
		int _la;
		try {
			setState(689);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(624);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(623);
					match(STAR);
					}
				}

				setState(626);
				match(IDENTIFIER);
				setState(627);
				match(DOT);
				setState(628);
				match(T__3);
				setState(630);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(629);
					match(STAR);
					}
				}

				setState(632);
				match(IDENTIFIER);
				setState(635);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(633);
					match(DOT);
					setState(634);
					match(IDENTIFIER);
					}
				}

				setState(637);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(638);
				methodCall();
				setState(639);
				match(DOT);
				setState(640);
				match(T__3);
				setState(642);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(641);
					match(STAR);
					}
				}

				setState(644);
				match(IDENTIFIER);
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(645);
					match(DOT);
					setState(646);
					match(IDENTIFIER);
					}
				}

				setState(649);
				match(T__4);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(651);
				match(T__45);
				setState(652);
				match(T__3);
				setState(653);
				match(IDENTIFIER);
				setState(657);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(654);
					match(DOT);
					setState(655);
					match(IDENTIFIER);
					}
					break;
				case STAR:
				case AMPERSAND:
				case IDENTIFIER:
					{
					setState(656);
					methodCall();
					}
					break;
				case T__4:
					break;
				default:
					break;
				}
				setState(659);
				match(T__4);
				setState(664);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(660);
					match(DOT);
					setState(661);
					match(T__3);
					setState(662);
					match(IDENTIFIER);
					setState(663);
					match(T__4);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(667);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(666);
					match(STAR);
					}
				}

				setState(669);
				match(IDENTIFIER);
				setState(670);
				match(DOT);
				setState(673);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
				case 1:
					{
					setState(671);
					match(IDENTIFIER);
					setState(672);
					match(DOT);
					}
					break;
				}
				setState(683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__3) {
					{
					setState(675);
					match(T__3);
					setState(676);
					match(IDENTIFIER);
					setState(680);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case DOT:
						{
						setState(677);
						match(DOT);
						setState(678);
						match(IDENTIFIER);
						}
						break;
					case STAR:
					case AMPERSAND:
					case IDENTIFIER:
						{
						setState(679);
						methodCall();
						}
						break;
					case T__4:
						break;
					default:
						break;
					}
					setState(682);
					match(T__4);
					}
				}

				setState(687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(685);
					match(DOT);
					setState(686);
					methodCall();
					}
				}

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
	public static class PrimaryExpressionContext extends ParserRuleContext {
		public CreateObjectDeclarationContext createObjectDeclaration() {
			return getRuleContext(CreateObjectDeclarationContext.class,0);
		}
		public SliceDeclarationContext sliceDeclaration() {
			return getRuleContext(SliceDeclarationContext.class,0);
		}
		public MapInitializationContext mapInitialization() {
			return getRuleContext(MapInitializationContext.class,0);
		}
		public SliceOrArrayLiteralContext sliceOrArrayLiteral() {
			return getRuleContext(SliceOrArrayLiteralContext.class,0);
		}
		public List<MethodCallContext> methodCall() {
			return getRuleContexts(MethodCallContext.class);
		}
		public MethodCallContext methodCall(int i) {
			return getRuleContext(MethodCallContext.class,i);
		}
		public TerminalNode DOT() { return getToken(GoSugarParser.DOT, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public TerminalNode STAR() { return getToken(GoSugarParser.STAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoSugarParser.AMPERSAND, 0); }
		public ConcatenatedStringContext concatenatedString() {
			return getRuleContext(ConcatenatedStringContext.class,0);
		}
		public TerminalNode NIL() { return getToken(GoSugarParser.NIL, 0); }
		public TerminalNode STRING() { return getToken(GoSugarParser.STRING, 0); }
		public TerminalNode NUMBER() { return getToken(GoSugarParser.NUMBER, 0); }
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public NegationExpressionContext negationExpression() {
			return getRuleContext(NegationExpressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ListAccessContext listAccess() {
			return getRuleContext(ListAccessContext.class,0);
		}
		public AnonimousFunctionDeclarationContext anonimousFunctionDeclaration() {
			return getRuleContext(AnonimousFunctionDeclarationContext.class,0);
		}
		public IncrementOrDecrementStatementContext incrementOrDecrementStatement() {
			return getRuleContext(IncrementOrDecrementStatementContext.class,0);
		}
		public TypeConversionContext typeConversion() {
			return getRuleContext(TypeConversionContext.class,0);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public InterfaceTypeVerificationContext interfaceTypeVerification() {
			return getRuleContext(InterfaceTypeVerificationContext.class,0);
		}
		public DirectCreateInstanceContext directCreateInstance() {
			return getRuleContext(DirectCreateInstanceContext.class,0);
		}
		public PrimaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpression; }
	}

	public final PrimaryExpressionContext primaryExpression() throws RecognitionException {
		PrimaryExpressionContext _localctx = new PrimaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_primaryExpression);
		int _la;
		try {
			setState(726);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,93,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(691);
				createObjectDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(692);
				sliceDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(693);
				mapInitialization();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(694);
				sliceOrArrayLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(695);
				methodCall();
				setState(698);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOT) {
					{
					setState(696);
					match(DOT);
					setState(697);
					methodCall();
					}
				}

				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR) {
					{
					setState(700);
					match(STAR);
					}
				}

				setState(703);
				match(IDENTIFIER);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AMPERSAND) {
					{
					setState(704);
					match(AMPERSAND);
					}
				}

				setState(707);
				match(IDENTIFIER);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(708);
				concatenatedString();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(709);
				match(NIL);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(710);
				match(STRING);
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(711);
				match(NUMBER);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(712);
				leftHandSide();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(713);
				listLiteral();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(714);
				negationExpression();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(715);
				match(T__3);
				setState(716);
				expression();
				setState(717);
				match(T__4);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(719);
				listAccess();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(720);
				anonimousFunctionDeclaration();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(721);
				incrementOrDecrementStatement();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(722);
				typeConversion();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(723);
				varType();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(724);
				interfaceTypeVerification();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(725);
				directCreateInstance();
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
	public static class DirectCreateInstanceContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode AMPERSAND() { return getToken(GoSugarParser.AMPERSAND, 0); }
		public List<MapKeyValueContext> mapKeyValue() {
			return getRuleContexts(MapKeyValueContext.class);
		}
		public MapKeyValueContext mapKeyValue(int i) {
			return getRuleContext(MapKeyValueContext.class,i);
		}
		public DirectCreateInstanceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directCreateInstance; }
	}

	public final DirectCreateInstanceContext directCreateInstance() throws RecognitionException {
		DirectCreateInstanceContext _localctx = new DirectCreateInstanceContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_directCreateInstance);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(729);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(728);
				match(AMPERSAND);
				}
				break;
			}
			setState(731);
			varType();
			setState(732);
			match(T__1);
			setState(744);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING) {
				{
				setState(733);
				mapKeyValue();
				setState(738);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(734);
						match(T__12);
						setState(735);
						mapKeyValue();
						}
						} 
					}
					setState(740);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,95,_ctx);
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(741);
					match(T__12);
					}
				}

				}
			}

			setState(746);
			match(T__2);
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
	public static class MapKeyValueContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode STRING() { return getToken(GoSugarParser.STRING, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public MapKeyValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapKeyValue; }
	}

	public final MapKeyValueContext mapKeyValue() throws RecognitionException {
		MapKeyValueContext _localctx = new MapKeyValueContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_mapKeyValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			_la = _input.LA(1);
			if ( !(_la==IDENTIFIER || _la==STRING) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(749);
			match(T__17);
			setState(750);
			expression();
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
	public static class ListLiteralContext extends ParserRuleContext {
		public List<MapKeyValueContext> mapKeyValue() {
			return getRuleContexts(MapKeyValueContext.class);
		}
		public MapKeyValueContext mapKeyValue(int i) {
			return getRuleContext(MapKeyValueContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(GoSugarParser.NUMBER, 0); }
		public ListLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listLiteral; }
	}

	public final ListLiteralContext listLiteral() throws RecognitionException {
		ListLiteralContext _localctx = new ListLiteralContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_listLiteral);
		int _la;
		try {
			int _alt;
			setState(824);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,111,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(752);
				match(T__1);
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER || _la==STRING) {
					{
					setState(753);
					mapKeyValue();
					setState(758);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(754);
							match(T__12);
							setState(755);
							mapKeyValue();
							}
							} 
						}
						setState(760);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
					}
					setState(762);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__12) {
						{
						setState(761);
						match(T__12);
						}
					}

					}
				}

				setState(766);
				match(T__2);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(767);
				match(T__1);
				setState(779);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
					{
					setState(768);
					expression();
					setState(773);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(769);
							match(T__12);
							setState(770);
							expression();
							}
							} 
						}
						setState(775);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,101,_ctx);
					}
					setState(777);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__12) {
						{
						setState(776);
						match(T__12);
						}
					}

					}
				}

				setState(781);
				match(T__2);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(782);
				varType();
				setState(783);
				match(T__1);
				setState(795);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
					{
					setState(784);
					expression();
					setState(789);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(785);
							match(T__12);
							setState(786);
							expression();
							}
							} 
						}
						setState(791);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
					}
					setState(793);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__12) {
						{
						setState(792);
						match(T__12);
						}
					}

					}
				}

				setState(797);
				match(T__2);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(799);
				varType();
				setState(800);
				match(T__13);
				setState(802);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NUMBER) {
					{
					setState(801);
					match(NUMBER);
					}
				}

				setState(804);
				match(T__14);
				setState(805);
				match(T__1);
				setState(817);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
					{
					setState(806);
					expression();
					setState(811);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(807);
							match(T__12);
							setState(808);
							expression();
							}
							} 
						}
						setState(813);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,108,_ctx);
					}
					setState(815);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==T__12) {
						{
						setState(814);
						match(T__12);
						}
					}

					}
				}

				setState(819);
				match(T__2);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(821);
				varType();
				setState(822);
				match(T__23);
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
	public static class OperatorExpressionContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public TerminalNode STAR() { return getToken(GoSugarParser.STAR, 0); }
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public OperatorExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_operatorExpression; }
	}

	public final OperatorExpressionContext operatorExpression() throws RecognitionException {
		OperatorExpressionContext _localctx = new OperatorExpressionContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_operatorExpression);
		int _la;
		try {
			setState(833);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__46:
			case T__47:
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(826);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -9222949824389709824L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(827);
				primaryExpression();
				}
				break;
			case T__44:
			case T__48:
				enterOuterAlt(_localctx, 2);
				{
				setState(828);
				_la = _input.LA(1);
				if ( !(_la==T__44 || _la==T__48) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(829);
				primaryExpression();
				}
				break;
			case T__36:
			case T__37:
			case T__38:
			case T__39:
			case T__40:
			case T__41:
			case T__42:
			case T__43:
				enterOuterAlt(_localctx, 3);
				{
				setState(830);
				comparisonOperator();
				setState(831);
				primaryExpression();
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
	public static class ComparisonContext extends ParserRuleContext {
		public PrimaryExpressionContext primaryExpression() {
			return getRuleContext(PrimaryExpressionContext.class,0);
		}
		public ComparisonOperatorContext comparisonOperator() {
			return getRuleContext(ComparisonOperatorContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(835);
			primaryExpression();
			setState(839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 35046933135360L) != 0)) {
				{
				setState(836);
				comparisonOperator();
				setState(837);
				comparison();
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
	public static class ReturnOperationContext extends ParserRuleContext {
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ReturnOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnOperation; }
	}

	public final ReturnOperationContext returnOperation() throws RecognitionException {
		ReturnOperationContext _localctx = new ReturnOperationContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_returnOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(841);
			match(T__49);
			setState(843);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(842);
				argumentList();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueOperationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public ContinueOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueOperation; }
	}

	public final ContinueOperationContext continueOperation() throws RecognitionException {
		ContinueOperationContext _localctx = new ContinueOperationContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_continueOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			match(T__50);
			setState(847);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(846);
				match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class BreakOperationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public BreakOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakOperation; }
	}

	public final BreakOperationContext breakOperation() throws RecognitionException {
		BreakOperationContext _localctx = new BreakOperationContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_breakOperation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(849);
			match(T__51);
			setState(851);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				{
				setState(850);
				match(IDENTIFIER);
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

	@SuppressWarnings("CheckReturnValue")
	public static class VarValueContext extends ParserRuleContext {
		public ListLiteralContext listLiteral() {
			return getRuleContext(ListLiteralContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public MapInitializationContext mapInitialization() {
			return getRuleContext(MapInitializationContext.class,0);
		}
		public VarValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varValue; }
	}

	public final VarValueContext varValue() throws RecognitionException {
		VarValueContext _localctx = new VarValueContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_varValue);
		try {
			setState(856);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(853);
				listLiteral();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(854);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(855);
				mapInitialization();
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
	public static class VarStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public VarValueContext varValue() {
			return getRuleContext(VarValueContext.class,0);
		}
		public VarStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varStatement; }
	}

	public final VarStatementContext varStatement() throws RecognitionException {
		VarStatementContext _localctx = new VarStatementContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_varStatement);
		int _la;
		try {
			setState(871);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(858);
				match(T__52);
				setState(859);
				match(IDENTIFIER);
				setState(860);
				varType();
				setState(864);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 137405399040L) != 0)) {
					{
					setState(861);
					assignmentOperator();
					setState(862);
					varValue();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(866);
				match(T__52);
				setState(867);
				match(IDENTIFIER);
				setState(868);
				assignmentOperator();
				setState(869);
				varValue();
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
	public static class IfStatementContext extends ParserRuleContext {
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_ifStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			match(T__53);
			setState(877);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				{
				setState(874);
				assignment();
				setState(875);
				match(T__54);
				}
				break;
			}
			setState(879);
			comparison();
			setState(880);
			block();
			setState(882);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				{
				setState(881);
				elseStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContext extends ParserRuleContext {
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(T__55);
			setState(887);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__53:
				{
				setState(885);
				ifStatement();
				}
				break;
			case T__1:
				{
				setState(886);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
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
	public static class IncrementOrDecrementStatementContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public TerminalNode STAR() { return getToken(GoSugarParser.STAR, 0); }
		public TerminalNode AMPERSAND() { return getToken(GoSugarParser.AMPERSAND, 0); }
		public IncrementOrDecrementStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_incrementOrDecrementStatement; }
	}

	public final IncrementOrDecrementStatementContext incrementOrDecrementStatement() throws RecognitionException {
		IncrementOrDecrementStatementContext _localctx = new IncrementOrDecrementStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_incrementOrDecrementStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR) {
				{
				setState(889);
				match(STAR);
				}
			}

			setState(893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AMPERSAND) {
				{
				setState(892);
				match(AMPERSAND);
				}
			}

			setState(895);
			match(IDENTIFIER);
			setState(896);
			_la = _input.LA(1);
			if ( !(_la==T__56 || _la==T__57) ) {
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
	public static class ForStatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ClassicForLoopContext classicForLoop() {
			return getRuleContext(ClassicForLoopContext.class,0);
		}
		public RangeForLoopContext rangeForLoop() {
			return getRuleContext(RangeForLoopContext.class,0);
		}
		public ConditionForLoopContext conditionForLoop() {
			return getRuleContext(ConditionForLoopContext.class,0);
		}
		public InfiniteForLoopContext infiniteForLoop() {
			return getRuleContext(InfiniteForLoopContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_forStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(898);
			match(T__58);
			setState(903);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,125,_ctx) ) {
			case 1:
				{
				setState(899);
				classicForLoop();
				}
				break;
			case 2:
				{
				setState(900);
				rangeForLoop();
				}
				break;
			case 3:
				{
				setState(901);
				conditionForLoop();
				}
				break;
			case 4:
				{
				setState(902);
				infiniteForLoop();
				}
				break;
			}
			setState(905);
			block();
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
	public static class ClassicForLoopContext extends ParserRuleContext {
		public List<SimpleStatementContext> simpleStatement() {
			return getRuleContexts(SimpleStatementContext.class);
		}
		public SimpleStatementContext simpleStatement(int i) {
			return getRuleContext(SimpleStatementContext.class,i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassicForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classicForLoop; }
	}

	public final ClassicForLoopContext classicForLoop() throws RecognitionException {
		ClassicForLoopContext _localctx = new ClassicForLoopContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_classicForLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
				{
				setState(907);
				simpleStatement();
				}
			}

			setState(910);
			match(T__54);
			setState(912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
				{
				setState(911);
				expression();
				}
			}

			setState(914);
			match(T__54);
			setState(916);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,128,_ctx) ) {
			case 1:
				{
				setState(915);
				simpleStatement();
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

	@SuppressWarnings("CheckReturnValue")
	public static class RangeForLoopContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public RangeForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rangeForLoop; }
	}

	public final RangeForLoopContext rangeForLoop() throws RecognitionException {
		RangeForLoopContext _localctx = new RangeForLoopContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_rangeForLoop);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -9223301668102123500L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 411L) != 0)) {
				{
				setState(918);
				expressionList();
				setState(919);
				match(T__25);
				}
			}

			setState(923);
			match(T__59);
			setState(924);
			expression();
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
	public static class ConditionForLoopContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ConditionForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionForLoop; }
	}

	public final ConditionForLoopContext conditionForLoop() throws RecognitionException {
		ConditionForLoopContext _localctx = new ConditionForLoopContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_conditionForLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(926);
			expression();
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
	public static class InfiniteForLoopContext extends ParserRuleContext {
		public InfiniteForLoopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_infiniteForLoop; }
	}

	public final InfiniteForLoopContext infiniteForLoop() throws RecognitionException {
		InfiniteForLoopContext _localctx = new InfiniteForLoopContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_infiniteForLoop);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
	public static class SimpleStatementContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public IncrementOrDecrementStatementContext incrementOrDecrementStatement() {
			return getRuleContext(IncrementOrDecrementStatementContext.class,0);
		}
		public SimpleStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleStatement; }
	}

	public final SimpleStatementContext simpleStatement() throws RecognitionException {
		SimpleStatementContext _localctx = new SimpleStatementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_simpleStatement);
		try {
			setState(933);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(930);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(931);
				expression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(932);
				incrementOrDecrementStatement();
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
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(935);
			expression();
			setState(940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__12) {
				{
				{
				setState(936);
				match(T__12);
				setState(937);
				expression();
				}
				}
				setState(942);
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
	public static class MapInitializationContext extends ParserRuleContext {
		public VarTypeContext varType() {
			return getRuleContext(VarTypeContext.class,0);
		}
		public List<MapKeyValueContext> mapKeyValue() {
			return getRuleContexts(MapKeyValueContext.class);
		}
		public MapKeyValueContext mapKeyValue(int i) {
			return getRuleContext(MapKeyValueContext.class,i);
		}
		public MapInitializationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapInitialization; }
	}

	public final MapInitializationContext mapInitialization() throws RecognitionException {
		MapInitializationContext _localctx = new MapInitializationContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_mapInitialization);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			varType();
			setState(944);
			match(T__1);
			setState(956);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER || _la==STRING) {
				{
				setState(945);
				mapKeyValue();
				setState(950);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(946);
						match(T__12);
						setState(947);
						mapKeyValue();
						}
						} 
					}
					setState(952);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
				}
				setState(954);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__12) {
					{
					setState(953);
					match(T__12);
					}
				}

				}
			}

			setState(958);
			match(T__2);
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
	public static class ForeachStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(GoSugarParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GoSugarParser.IDENTIFIER, i);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_foreachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(960);
			match(T__60);
			setState(961);
			expression();
			setState(962);
			match(T__6);
			setState(963);
			match(IDENTIFIER);
			setState(966);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(964);
				match(T__12);
				setState(965);
				match(IDENTIFIER);
				}
			}

			setState(968);
			block();
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
	public static class TypeConversionContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GoSugarParser.IDENTIFIER, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeConversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeConversion; }
	}

	public final TypeConversionContext typeConversion() throws RecognitionException {
		TypeConversionContext _localctx = new TypeConversionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_typeConversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(970);
			match(IDENTIFIER);
			setState(971);
			match(T__3);
			setState(972);
			expression();
			setState(973);
			match(T__4);
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
		"\u0004\u0001N\u03d0\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0001\u0000\u0005\u0000"+
		"\u008c\b\u0000\n\u0000\f\u0000\u008f\t\u0000\u0001\u0000\u0001\u0000\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u0099\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0005\u0004\u00a3\b\u0004\n"+
		"\u0004\f\u0004\u00a6\t\u0004\u0001\u0004\u0001\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0003\u0005\u00ad\b\u0005\u0001\u0005\u0001\u0005\u0003"+
		"\u0005\u00b1\b\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u00b7\b\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00bb\b\u0006"+
		"\u0001\u0006\u0001\u0006\u0003\u0006\u00bf\b\u0006\u0001\u0006\u0001\u0006"+
		"\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0005\b\u00cb\b\b\n\b\f\b\u00ce\t\b\u0001\b\u0001\b\u0005\b\u00d2\b"+
		"\b\n\b\f\b\u00d5\t\b\u0001\b\u0005\b\u00d8\b\b\n\b\f\b\u00db\t\b\u0001"+
		"\b\u0005\b\u00de\b\b\n\b\f\b\u00e1\t\b\u0001\b\u0005\b\u00e4\b\b\n\b\f"+
		"\b\u00e7\t\b\u0001\b\u0003\b\u00ea\b\b\u0001\t\u0001\t\u0001\t\u0001\t"+
		"\u0003\t\u00f0\b\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\n\u0001\n\u0005\n\u00fa\b\n\n\n\f\n\u00fd\t\n\u0003\n\u00ff\b\n\u0001"+
		"\n\u0001\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b"+
		"\u0107\b\u000b\n\u000b\f\u000b\u010a\t\u000b\u0003\u000b\u010c\b\u000b"+
		"\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0005"+
		"\f\u0115\b\f\n\f\f\f\u0118\t\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0005\u000e\u011f\b\u000e\n\u000e\f\u000e\u0122\t\u000e\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0127\b\u000f\n\u000f\f\u000f"+
		"\u012a\t\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u012e\b\u0010\n\u0010"+
		"\f\u0010\u0131\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0003\u0011\u0137\b\u0011\u0001\u0012\u0003\u0012\u013a\b\u0012\u0001"+
		"\u0012\u0003\u0012\u013d\b\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0141"+
		"\b\u0012\u0001\u0012\u0003\u0012\u0144\b\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u0149\b\u0012\u0001\u0012\u0003\u0012\u014c\b"+
		"\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0150\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0155\b\u0012\u0001\u0012\u0003\u0012\u0158"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001"+
		"\u0012\u0001\u0012\u0003\u0012\u0161\b\u0012\u0001\u0012\u0003\u0012\u0164"+
		"\b\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0003\u0012\u0169\b\u0012"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u016e\b\u0013\u0001\u0014"+
		"\u0001\u0014\u0001\u0015\u0003\u0015\u0173\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0003\u0015\u0179\b\u0015\u0001\u0015\u0001\u0015"+
		"\u0003\u0015\u017d\b\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0003\u0016\u0183\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0003\u0016"+
		"\u0188\b\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0192\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0197\b\u0018\n\u0018\f\u0018\u019a"+
		"\t\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005"+
		"\u001a\u01a1\b\u001a\n\u001a\f\u001a\u01a4\t\u001a\u0001\u001b\u0001\u001b"+
		"\u0005\u001b\u01a8\b\u001b\n\u001b\f\u001b\u01ab\t\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001c\u0001\u001c\u0003\u001c\u01b1\b\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u01b6\b\u001c\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u01ba\b\u001d\n\u001d\f\u001d\u01bd\t\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0003\u001e\u01ce\b\u001e\u0001\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u01d4\b\u001f\n\u001f\f\u001f\u01d7\t\u001f\u0001"+
		"\u001f\u0003\u001f\u01da\b\u001f\u0001\u001f\u0001\u001f\u0001 \u0001"+
		" \u0001 \u0001 \u0005 \u01e2\b \n \f \u01e5\t \u0001!\u0001!\u0001!\u0005"+
		"!\u01ea\b!\n!\f!\u01ed\t!\u0001\"\u0001\"\u0003\"\u01f1\b\"\u0001\"\u0003"+
		"\"\u01f4\b\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0003#\u01fb\b#\u0001"+
		"#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001$\u0001$\u0003$\u0205\b$\u0001"+
		"%\u0003%\u0208\b%\u0001%\u0003%\u020b\b%\u0001%\u0001%\u0005%\u020f\b"+
		"%\n%\f%\u0212\t%\u0001%\u0001%\u0005%\u0216\b%\n%\f%\u0219\t%\u0001%\u0003"+
		"%\u021c\b%\u0001%\u0003%\u021f\b%\u0001%\u0001%\u0001%\u0001%\u0001%\u0005"+
		"%\u0226\b%\n%\f%\u0229\t%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0005"+
		"%\u0231\b%\n%\f%\u0234\t%\u0005%\u0236\b%\n%\f%\u0239\t%\u0003%\u023b"+
		"\b%\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0003(\u0244\b"+
		"(\u0001(\u0001(\u0001(\u0003(\u0249\b(\u0001(\u0001(\u0001(\u0003(\u024e"+
		"\b(\u0001(\u0001(\u0003(\u0252\b(\u0001(\u0001(\u0003(\u0256\b(\u0003"+
		"(\u0258\b(\u0001)\u0001)\u0001)\u0005)\u025d\b)\n)\f)\u0260\t)\u0001*"+
		"\u0001*\u0005*\u0264\b*\n*\f*\u0267\t*\u0001+\u0001+\u0001+\u0004+\u026c"+
		"\b+\u000b+\f+\u026d\u0001,\u0003,\u0271\b,\u0001,\u0001,\u0001,\u0001"+
		",\u0003,\u0277\b,\u0001,\u0001,\u0001,\u0003,\u027c\b,\u0001,\u0001,\u0001"+
		",\u0001,\u0001,\u0003,\u0283\b,\u0001,\u0001,\u0001,\u0003,\u0288\b,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0001,\u0003,\u0292\b,\u0001"+
		",\u0001,\u0001,\u0001,\u0001,\u0003,\u0299\b,\u0001,\u0003,\u029c\b,\u0001"+
		",\u0001,\u0001,\u0001,\u0003,\u02a2\b,\u0001,\u0001,\u0001,\u0001,\u0001"+
		",\u0003,\u02a9\b,\u0001,\u0003,\u02ac\b,\u0001,\u0001,\u0003,\u02b0\b"+
		",\u0003,\u02b2\b,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003"+
		"-\u02bb\b-\u0001-\u0003-\u02be\b-\u0001-\u0001-\u0003-\u02c2\b-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001"+
		"-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003-\u02d7"+
		"\b-\u0001.\u0003.\u02da\b.\u0001.\u0001.\u0001.\u0001.\u0001.\u0005.\u02e1"+
		"\b.\n.\f.\u02e4\t.\u0001.\u0003.\u02e7\b.\u0003.\u02e9\b.\u0001.\u0001"+
		".\u0001/\u0001/\u0001/\u0001/\u00010\u00010\u00010\u00010\u00050\u02f5"+
		"\b0\n0\f0\u02f8\t0\u00010\u00030\u02fb\b0\u00030\u02fd\b0\u00010\u0001"+
		"0\u00010\u00010\u00010\u00050\u0304\b0\n0\f0\u0307\t0\u00010\u00030\u030a"+
		"\b0\u00030\u030c\b0\u00010\u00010\u00010\u00010\u00010\u00010\u00050\u0314"+
		"\b0\n0\f0\u0317\t0\u00010\u00030\u031a\b0\u00030\u031c\b0\u00010\u0001"+
		"0\u00010\u00010\u00010\u00030\u0323\b0\u00010\u00010\u00010\u00010\u0001"+
		"0\u00050\u032a\b0\n0\f0\u032d\t0\u00010\u00030\u0330\b0\u00030\u0332\b"+
		"0\u00010\u00010\u00010\u00010\u00010\u00030\u0339\b0\u00011\u00011\u0001"+
		"1\u00011\u00011\u00011\u00011\u00031\u0342\b1\u00012\u00012\u00012\u0001"+
		"2\u00032\u0348\b2\u00013\u00013\u00033\u034c\b3\u00014\u00014\u00034\u0350"+
		"\b4\u00015\u00015\u00035\u0354\b5\u00016\u00016\u00016\u00036\u0359\b"+
		"6\u00017\u00017\u00017\u00017\u00017\u00017\u00037\u0361\b7\u00017\u0001"+
		"7\u00017\u00017\u00017\u00037\u0368\b7\u00018\u00018\u00018\u00018\u0003"+
		"8\u036e\b8\u00018\u00018\u00018\u00038\u0373\b8\u00019\u00019\u00019\u0003"+
		"9\u0378\b9\u0001:\u0003:\u037b\b:\u0001:\u0003:\u037e\b:\u0001:\u0001"+
		":\u0001:\u0001;\u0001;\u0001;\u0001;\u0001;\u0003;\u0388\b;\u0001;\u0001"+
		";\u0001<\u0003<\u038d\b<\u0001<\u0001<\u0003<\u0391\b<\u0001<\u0001<\u0003"+
		"<\u0395\b<\u0001=\u0001=\u0001=\u0003=\u039a\b=\u0001=\u0001=\u0001=\u0001"+
		">\u0001>\u0001?\u0001?\u0001@\u0001@\u0001@\u0003@\u03a6\b@\u0001A\u0001"+
		"A\u0001A\u0005A\u03ab\bA\nA\fA\u03ae\tA\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0005B\u03b5\bB\nB\fB\u03b8\tB\u0001B\u0003B\u03bb\bB\u0003B\u03bd\b"+
		"B\u0001B\u0001B\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0003C\u03c7"+
		"\bC\u0001C\u0001C\u0001D\u0001D\u0001D\u0001D\u0001D\u0001D\u0000\u0000"+
		"E\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a"+
		"\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082"+
		"\u0084\u0086\u0088\u0000\u0007\u0001\u0000MN\u0001\u0000\u0019$\u0001"+
		"\u0000%,\u0002\u0000CCGG\u0002\u0000/0??\u0002\u0000--11\u0001\u00009"+
		":\u0444\u0000\u008d\u0001\u0000\u0000\u0000\u0002\u0098\u0001\u0000\u0000"+
		"\u0000\u0004\u009a\u0001\u0000\u0000\u0000\u0006\u009c\u0001\u0000\u0000"+
		"\u0000\b\u00a0\u0001\u0000\u0000\u0000\n\u00a9\u0001\u0000\u0000\u0000"+
		"\f\u00b2\u0001\u0000\u0000\u0000\u000e\u00c2\u0001\u0000\u0000\u0000\u0010"+
		"\u00e9\u0001\u0000\u0000\u0000\u0012\u00eb\u0001\u0000\u0000\u0000\u0014"+
		"\u00f3\u0001\u0000\u0000\u0000\u0016\u0102\u0001\u0000\u0000\u0000\u0018"+
		"\u010f\u0001\u0000\u0000\u0000\u001a\u0119\u0001\u0000\u0000\u0000\u001c"+
		"\u011b\u0001\u0000\u0000\u0000\u001e\u0123\u0001\u0000\u0000\u0000 \u012b"+
		"\u0001\u0000\u0000\u0000\"\u0136\u0001\u0000\u0000\u0000$\u0168\u0001"+
		"\u0000\u0000\u0000&\u016a\u0001\u0000\u0000\u0000(\u016f\u0001\u0000\u0000"+
		"\u0000*\u0172\u0001\u0000\u0000\u0000,\u0180\u0001\u0000\u0000\u0000."+
		"\u0191\u0001\u0000\u0000\u00000\u0193\u0001\u0000\u0000\u00002\u019b\u0001"+
		"\u0000\u0000\u00004\u019d\u0001\u0000\u0000\u00006\u01a5\u0001\u0000\u0000"+
		"\u00008\u01b5\u0001\u0000\u0000\u0000:\u01b7\u0001\u0000\u0000\u0000<"+
		"\u01cd\u0001\u0000\u0000\u0000>\u01cf\u0001\u0000\u0000\u0000@\u01dd\u0001"+
		"\u0000\u0000\u0000B\u01e6\u0001\u0000\u0000\u0000D\u01ee\u0001\u0000\u0000"+
		"\u0000F\u01f7\u0001\u0000\u0000\u0000H\u0204\u0001\u0000\u0000\u0000J"+
		"\u023a\u0001\u0000\u0000\u0000L\u023c\u0001\u0000\u0000\u0000N\u023e\u0001"+
		"\u0000\u0000\u0000P\u0257\u0001\u0000\u0000\u0000R\u0259\u0001\u0000\u0000"+
		"\u0000T\u0261\u0001\u0000\u0000\u0000V\u0268\u0001\u0000\u0000\u0000X"+
		"\u02b1\u0001\u0000\u0000\u0000Z\u02d6\u0001\u0000\u0000\u0000\\\u02d9"+
		"\u0001\u0000\u0000\u0000^\u02ec\u0001\u0000\u0000\u0000`\u0338\u0001\u0000"+
		"\u0000\u0000b\u0341\u0001\u0000\u0000\u0000d\u0343\u0001\u0000\u0000\u0000"+
		"f\u0349\u0001\u0000\u0000\u0000h\u034d\u0001\u0000\u0000\u0000j\u0351"+
		"\u0001\u0000\u0000\u0000l\u0358\u0001\u0000\u0000\u0000n\u0367\u0001\u0000"+
		"\u0000\u0000p\u0369\u0001\u0000\u0000\u0000r\u0374\u0001\u0000\u0000\u0000"+
		"t\u037a\u0001\u0000\u0000\u0000v\u0382\u0001\u0000\u0000\u0000x\u038c"+
		"\u0001\u0000\u0000\u0000z\u0399\u0001\u0000\u0000\u0000|\u039e\u0001\u0000"+
		"\u0000\u0000~\u03a0\u0001\u0000\u0000\u0000\u0080\u03a5\u0001\u0000\u0000"+
		"\u0000\u0082\u03a7\u0001\u0000\u0000\u0000\u0084\u03af\u0001\u0000\u0000"+
		"\u0000\u0086\u03c0\u0001\u0000\u0000\u0000\u0088\u03ca\u0001\u0000\u0000"+
		"\u0000\u008a\u008c\u0003\u0002\u0001\u0000\u008b\u008a\u0001\u0000\u0000"+
		"\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b\u0001\u0000\u0000"+
		"\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090\u0001\u0000\u0000"+
		"\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091\u0005\u0000\u0000"+
		"\u0001\u0091\u0001\u0001\u0000\u0000\u0000\u0092\u0099\u0003\u0010\b\u0000"+
		"\u0093\u0099\u0003\u0004\u0002\u0000\u0094\u0099\u0003\u0006\u0003\u0000"+
		"\u0095\u0099\u0003\f\u0006\u0000\u0096\u0099\u0003\u000e\u0007\u0000\u0097"+
		"\u0099\u0003*\u0015\u0000\u0098\u0092\u0001\u0000\u0000\u0000\u0098\u0093"+
		"\u0001\u0000\u0000\u0000\u0098\u0094\u0001\u0000\u0000\u0000\u0098\u0095"+
		"\u0001\u0000\u0000\u0000\u0098\u0096\u0001\u0000\u0000\u0000\u0098\u0097"+
		"\u0001\u0000\u0000\u0000\u0099\u0003\u0001\u0000\u0000\u0000\u009a\u009b"+
		"\u0003n7\u0000\u009b\u0005\u0001\u0000\u0000\u0000\u009c\u009d\u0005\u0001"+
		"\u0000\u0000\u009d\u009e\u0005C\u0000\u0000\u009e\u009f\u0003\b\u0004"+
		"\u0000\u009f\u0007\u0001\u0000\u0000\u0000\u00a0\u00a4\u0005\u0002\u0000"+
		"\u0000\u00a1\u00a3\u0003\n\u0005\u0000\u00a2\u00a1\u0001\u0000\u0000\u0000"+
		"\u00a3\u00a6\u0001\u0000\u0000\u0000\u00a4\u00a2\u0001\u0000\u0000\u0000"+
		"\u00a4\u00a5\u0001\u0000\u0000\u0000\u00a5\u00a7\u0001\u0000\u0000\u0000"+
		"\u00a6\u00a4\u0001\u0000\u0000\u0000\u00a7\u00a8\u0005\u0003\u0000\u0000"+
		"\u00a8\t\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005C\u0000\u0000\u00aa"+
		"\u00ac\u0005\u0004\u0000\u0000\u00ab\u00ad\u00034\u001a\u0000\u00ac\u00ab"+
		"\u0001\u0000\u0000\u0000\u00ac\u00ad\u0001\u0000\u0000\u0000\u00ad\u00ae"+
		"\u0001\u0000\u0000\u0000\u00ae\u00b0\u0005\u0005\u0000\u0000\u00af\u00b1"+
		"\u0003.\u0017\u0000\u00b0\u00af\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u00b1\u000b\u0001\u0000\u0000\u0000\u00b2\u00b3\u0005"+
		"\u0006\u0000\u0000\u00b3\u00b6\u0005C\u0000\u0000\u00b4\u00b5\u0005\u0007"+
		"\u0000\u0000\u00b5\u00b7\u0003\u001a\r\u0000\u00b6\u00b4\u0001\u0000\u0000"+
		"\u0000\u00b6\u00b7\u0001\u0000\u0000\u0000\u00b7\u00ba\u0001\u0000\u0000"+
		"\u0000\u00b8\u00b9\u0005\b\u0000\u0000\u00b9\u00bb\u0003\u001c\u000e\u0000"+
		"\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001\u0000\u0000\u0000"+
		"\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00bd\u0005\t\u0000\u0000\u00bd"+
		"\u00bf\u0003\u001e\u000f\u0000\u00be\u00bc\u0001\u0000\u0000\u0000\u00be"+
		"\u00bf\u0001\u0000\u0000\u0000\u00bf\u00c0\u0001\u0000\u0000\u0000\u00c0"+
		"\u00c1\u0003 \u0010\u0000\u00c1\r\u0001\u0000\u0000\u0000\u00c2\u00c3"+
		"\u0005\n\u0000\u0000\u00c3\u00c4\u0005C\u0000\u0000\u00c4\u000f\u0001"+
		"\u0000\u0000\u0000\u00c5\u00c6\u0005\u000b\u0000\u0000\u00c6\u00ea\u0005"+
		"G\u0000\u0000\u00c7\u00c8\u0005\u000b\u0000\u0000\u00c8\u00cc\u0005\u0004"+
		"\u0000\u0000\u00c9\u00cb\u0005I\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000"+
		"\u0000\u00cb\u00ce\u0001\u0000\u0000\u0000\u00cc\u00ca\u0001\u0000\u0000"+
		"\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00cf\u0001\u0000\u0000"+
		"\u0000\u00ce\u00cc\u0001\u0000\u0000\u0000\u00cf\u00e5\u0005G\u0000\u0000"+
		"\u00d0\u00d2\u0005I\u0000\u0000\u00d1\u00d0\u0001\u0000\u0000\u0000\u00d2"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d3\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u00d4\u0001\u0000\u0000\u0000\u00d4\u00d9\u0001\u0000\u0000\u0000\u00d5"+
		"\u00d3\u0001\u0000\u0000\u0000\u00d6\u00d8\u0005L\u0000\u0000\u00d7\u00d6"+
		"\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7"+
		"\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u00df"+
		"\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00de"+
		"\u0005I\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00de\u00e1\u0001"+
		"\u0000\u0000\u0000\u00df\u00dd\u0001\u0000\u0000\u0000\u00df\u00e0\u0001"+
		"\u0000\u0000\u0000\u00e0\u00e2\u0001\u0000\u0000\u0000\u00e1\u00df\u0001"+
		"\u0000\u0000\u0000\u00e2\u00e4\u0005G\u0000\u0000\u00e3\u00d3\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e7\u0001\u0000\u0000\u0000\u00e5\u00e3\u0001\u0000"+
		"\u0000\u0000\u00e5\u00e6\u0001\u0000\u0000\u0000\u00e6\u00e8\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e5\u0001\u0000\u0000\u0000\u00e8\u00ea\u0005\u0005"+
		"\u0000\u0000\u00e9\u00c5\u0001\u0000\u0000\u0000\u00e9\u00c7\u0001\u0000"+
		"\u0000\u0000\u00ea\u0011\u0001\u0000\u0000\u0000\u00eb\u00ec\u0005A\u0000"+
		"\u0000\u00ec\u00ed\u0005C\u0000\u0000\u00ed\u00ef\u0005\u0004\u0000\u0000"+
		"\u00ee\u00f0\u0003R)\u0000\u00ef\u00ee\u0001\u0000\u0000\u0000\u00ef\u00f0"+
		"\u0001\u0000\u0000\u0000\u00f0\u00f1\u0001\u0000\u0000\u0000\u00f1\u00f2"+
		"\u0005\u0005\u0000\u0000\u00f2\u0013\u0001\u0000\u0000\u0000\u00f3\u00f4"+
		"\u0005\f\u0000\u0000\u00f4\u00f5\u0005C\u0000\u0000\u00f5\u00fe\u0005"+
		"\u0002\u0000\u0000\u00f6\u00fb\u0003Z-\u0000\u00f7\u00f8\u0005\r\u0000"+
		"\u0000\u00f8\u00fa\u0003Z-\u0000\u00f9\u00f7\u0001\u0000\u0000\u0000\u00fa"+
		"\u00fd\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fc\u0001\u0000\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd"+
		"\u00fb\u0001\u0000\u0000\u0000\u00fe\u00f6\u0001\u0000\u0000\u0000\u00fe"+
		"\u00ff\u0001\u0000\u0000\u0000\u00ff\u0100\u0001\u0000\u0000\u0000\u0100"+
		"\u0101\u0005\u0003\u0000\u0000\u0101\u0015\u0001\u0000\u0000\u0000\u0102"+
		"\u010b\u0005\u000e\u0000\u0000\u0103\u0108\u0003Z-\u0000\u0104\u0105\u0005"+
		"\r\u0000\u0000\u0105\u0107\u0003Z-\u0000\u0106\u0104\u0001\u0000\u0000"+
		"\u0000\u0107\u010a\u0001\u0000\u0000\u0000\u0108\u0106\u0001\u0000\u0000"+
		"\u0000\u0108\u0109\u0001\u0000\u0000\u0000\u0109\u010c\u0001\u0000\u0000"+
		"\u0000\u010a\u0108\u0001\u0000\u0000\u0000\u010b\u0103\u0001\u0000\u0000"+
		"\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010d\u0001\u0000\u0000"+
		"\u0000\u010d\u010e\u0005\u000f\u0000\u0000\u010e\u0017\u0001\u0000\u0000"+
		"\u0000\u010f\u0116\u0003J%\u0000\u0110\u0111\u0005\u000e\u0000\u0000\u0111"+
		"\u0112\u0003T*\u0000\u0112\u0113\u0005\u000f\u0000\u0000\u0113\u0115\u0001"+
		"\u0000\u0000\u0000\u0114\u0110\u0001\u0000\u0000\u0000\u0115\u0118\u0001"+
		"\u0000\u0000\u0000\u0116\u0114\u0001\u0000\u0000\u0000\u0116\u0117\u0001"+
		"\u0000\u0000\u0000\u0117\u0019\u0001\u0000\u0000\u0000\u0118\u0116\u0001"+
		"\u0000\u0000\u0000\u0119\u011a\u0003$\u0012\u0000\u011a\u001b\u0001\u0000"+
		"\u0000\u0000\u011b\u0120\u0003J%\u0000\u011c\u011d\u0005\r\u0000\u0000"+
		"\u011d\u011f\u0003J%\u0000\u011e\u011c\u0001\u0000\u0000\u0000\u011f\u0122"+
		"\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000\u0000\u0000\u0120\u0121"+
		"\u0001\u0000\u0000\u0000\u0121\u001d\u0001\u0000\u0000\u0000\u0122\u0120"+
		"\u0001\u0000\u0000\u0000\u0123\u0128\u0005C\u0000\u0000\u0124\u0125\u0005"+
		"\r\u0000\u0000\u0125\u0127\u0005C\u0000\u0000\u0126\u0124\u0001\u0000"+
		"\u0000\u0000\u0127\u012a\u0001\u0000\u0000\u0000\u0128\u0126\u0001\u0000"+
		"\u0000\u0000\u0128\u0129\u0001\u0000\u0000\u0000\u0129\u001f\u0001\u0000"+
		"\u0000\u0000\u012a\u0128\u0001\u0000\u0000\u0000\u012b\u012f\u0005\u0002"+
		"\u0000\u0000\u012c\u012e\u0003\"\u0011\u0000\u012d\u012c\u0001\u0000\u0000"+
		"\u0000\u012e\u0131\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000"+
		"\u0000\u012f\u0130\u0001\u0000\u0000\u0000\u0130\u0132\u0001\u0000\u0000"+
		"\u0000\u0131\u012f\u0001\u0000\u0000\u0000\u0132\u0133\u0005\u0003\u0000"+
		"\u0000\u0133!\u0001\u0000\u0000\u0000\u0134\u0137\u0003&\u0013\u0000\u0135"+
		"\u0137\u0003*\u0015\u0000\u0136\u0134\u0001\u0000\u0000\u0000\u0136\u0135"+
		"\u0001\u0000\u0000\u0000\u0137#\u0001\u0000\u0000\u0000\u0138\u013a\u0005"+
		"?\u0000\u0000\u0139\u0138\u0001\u0000\u0000\u0000\u0139\u013a\u0001\u0000"+
		"\u0000\u0000\u013a\u013c\u0001\u0000\u0000\u0000\u013b\u013d\u0005@\u0000"+
		"\u0000\u013c\u013b\u0001\u0000\u0000\u0000\u013c\u013d\u0001\u0000\u0000"+
		"\u0000\u013d\u013e\u0001\u0000\u0000\u0000\u013e\u0169\u0005C\u0000\u0000"+
		"\u013f\u0141\u0005?\u0000\u0000\u0140\u013f\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0001\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142"+
		"\u0144\u0005@\u0000\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0143\u0144"+
		"\u0001\u0000\u0000\u0000\u0144\u0145\u0001\u0000\u0000\u0000\u0145\u0146"+
		"\u0005\f\u0000\u0000\u0146\u0169\u0003$\u0012\u0000\u0147\u0149\u0005"+
		"?\u0000\u0000\u0148\u0147\u0001\u0000\u0000\u0000\u0148\u0149\u0001\u0000"+
		"\u0000\u0000\u0149\u014b\u0001\u0000\u0000\u0000\u014a\u014c\u0005@\u0000"+
		"\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000\u0000"+
		"\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014f\u0005\u000e\u0000"+
		"\u0000\u014e\u0150\u0005D\u0000\u0000\u014f\u014e\u0001\u0000\u0000\u0000"+
		"\u014f\u0150\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000\u0000\u0000"+
		"\u0151\u0152\u0005\u000f\u0000\u0000\u0152\u0169\u0003$\u0012\u0000\u0153"+
		"\u0155\u0005?\u0000\u0000\u0154\u0153\u0001\u0000\u0000\u0000\u0154\u0155"+
		"\u0001\u0000\u0000\u0000\u0155\u0157\u0001\u0000\u0000\u0000\u0156\u0158"+
		"\u0005@\u0000\u0000\u0157\u0156\u0001\u0000\u0000\u0000\u0157\u0158\u0001"+
		"\u0000\u0000\u0000\u0158\u0159\u0001\u0000\u0000\u0000\u0159\u015a\u0005"+
		"\u0010\u0000\u0000\u015a\u015b\u0005\u000e\u0000\u0000\u015b\u015c\u0003"+
		"$\u0012\u0000\u015c\u015d\u0005\u000f\u0000\u0000\u015d\u015e\u0003$\u0012"+
		"\u0000\u015e\u0169\u0001\u0000\u0000\u0000\u015f\u0161\u0005?\u0000\u0000"+
		"\u0160\u015f\u0001\u0000\u0000\u0000\u0160\u0161\u0001\u0000\u0000\u0000"+
		"\u0161\u0163\u0001\u0000\u0000\u0000\u0162\u0164\u0005@\u0000\u0000\u0163"+
		"\u0162\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164"+
		"\u0165\u0001\u0000\u0000\u0000\u0165\u0166\u0005C\u0000\u0000\u0166\u0167"+
		"\u0005F\u0000\u0000\u0167\u0169\u0003$\u0012\u0000\u0168\u0139\u0001\u0000"+
		"\u0000\u0000\u0168\u0140\u0001\u0000\u0000\u0000\u0168\u0148\u0001\u0000"+
		"\u0000\u0000\u0168\u0154\u0001\u0000\u0000\u0000\u0168\u0160\u0001\u0000"+
		"\u0000\u0000\u0169%\u0001\u0000\u0000\u0000\u016a\u016b\u0005C\u0000\u0000"+
		"\u016b\u016d\u0003$\u0012\u0000\u016c\u016e\u0003(\u0014\u0000\u016d\u016c"+
		"\u0001\u0000\u0000\u0000\u016d\u016e\u0001\u0000\u0000\u0000\u016e\'\u0001"+
		"\u0000\u0000\u0000\u016f\u0170\u0007\u0000\u0000\u0000\u0170)\u0001\u0000"+
		"\u0000\u0000\u0171\u0173\u0005B\u0000\u0000\u0172\u0171\u0001\u0000\u0000"+
		"\u0000\u0172\u0173\u0001\u0000\u0000\u0000\u0173\u0174\u0001\u0000\u0000"+
		"\u0000\u0174\u0175\u0005\u0011\u0000\u0000\u0175\u0176\u0005C\u0000\u0000"+
		"\u0176\u0178\u0005\u0004\u0000\u0000\u0177\u0179\u00034\u001a\u0000\u0178"+
		"\u0177\u0001\u0000\u0000\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179"+
		"\u017a\u0001\u0000\u0000\u0000\u017a\u017c\u0005\u0005\u0000\u0000\u017b"+
		"\u017d\u0003.\u0017\u0000\u017c\u017b\u0001\u0000\u0000\u0000\u017c\u017d"+
		"\u0001\u0000\u0000\u0000\u017d\u017e\u0001\u0000\u0000\u0000\u017e\u017f"+
		"\u00036\u001b\u0000\u017f+\u0001\u0000\u0000\u0000\u0180\u0182\u0005\u0004"+
		"\u0000\u0000\u0181\u0183\u00034\u001a\u0000\u0182\u0181\u0001\u0000\u0000"+
		"\u0000\u0182\u0183\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000"+
		"\u0000\u0184\u0187\u0005\u0005\u0000\u0000\u0185\u0186\u0005\u0012\u0000"+
		"\u0000\u0186\u0188\u0003.\u0017\u0000\u0187\u0185\u0001\u0000\u0000\u0000"+
		"\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000"+
		"\u0189\u018a\u0005\u0013\u0000\u0000\u018a\u018b\u00036\u001b\u0000\u018b"+
		"-\u0001\u0000\u0000\u0000\u018c\u018d\u0005\u0004\u0000\u0000\u018d\u018e"+
		"\u00030\u0018\u0000\u018e\u018f\u0005\u0005\u0000\u0000\u018f\u0192\u0001"+
		"\u0000\u0000\u0000\u0190\u0192\u0003$\u0012\u0000\u0191\u018c\u0001\u0000"+
		"\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000\u0192/\u0001\u0000\u0000"+
		"\u0000\u0193\u0198\u00032\u0019\u0000\u0194\u0195\u0005\r\u0000\u0000"+
		"\u0195\u0197\u00032\u0019\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197"+
		"\u019a\u0001\u0000\u0000\u0000\u0198\u0196\u0001\u0000\u0000\u0000\u0198"+
		"\u0199\u0001\u0000\u0000\u0000\u01991\u0001\u0000\u0000\u0000\u019a\u0198"+
		"\u0001\u0000\u0000\u0000\u019b\u019c\u0003$\u0012\u0000\u019c3\u0001\u0000"+
		"\u0000\u0000\u019d\u01a2\u00038\u001c\u0000\u019e\u019f\u0005\r\u0000"+
		"\u0000\u019f\u01a1\u00038\u001c\u0000\u01a0\u019e\u0001\u0000\u0000\u0000"+
		"\u01a1\u01a4\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000\u0000"+
		"\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a35\u0001\u0000\u0000\u0000\u01a4"+
		"\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a9\u0005\u0002\u0000\u0000\u01a6"+
		"\u01a8\u0003<\u001e\u0000\u01a7\u01a6\u0001\u0000\u0000\u0000\u01a8\u01ab"+
		"\u0001\u0000\u0000\u0000\u01a9\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa"+
		"\u0001\u0000\u0000\u0000\u01aa\u01ac\u0001\u0000\u0000\u0000\u01ab\u01a9"+
		"\u0001\u0000\u0000\u0000\u01ac\u01ad\u0005\u0003\u0000\u0000\u01ad7\u0001"+
		"\u0000\u0000\u0000\u01ae\u01b0\u0005C\u0000\u0000\u01af\u01b1\u0003$\u0012"+
		"\u0000\u01b0\u01af\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000"+
		"\u0000\u01b1\u01b6\u0001\u0000\u0000\u0000\u01b2\u01b3\u0005C\u0000\u0000"+
		"\u01b3\u01b4\u0005>\u0000\u0000\u01b4\u01b6\u0003$\u0012\u0000\u01b5\u01ae"+
		"\u0001\u0000\u0000\u0000\u01b5\u01b2\u0001\u0000\u0000\u0000\u01b69\u0001"+
		"\u0000\u0000\u0000\u01b7\u01bb\u0005\u0002\u0000\u0000\u01b8\u01ba\u0003"+
		"<\u001e\u0000\u01b9\u01b8\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000"+
		"\u0000\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000"+
		"\u0000\u0000\u01bc\u01be\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000"+
		"\u0000\u0000\u01be\u01bf\u0005\u0003\u0000\u0000\u01bf;\u0001\u0000\u0000"+
		"\u0000\u01c0\u01ce\u0003F#\u0000\u01c1\u01ce\u0003P(\u0000\u01c2\u01ce"+
		"\u0003f3\u0000\u01c3\u01ce\u0003h4\u0000\u01c4\u01ce\u0003j5\u0000\u01c5"+
		"\u01ce\u0003n7\u0000\u01c6\u01ce\u0003`0\u0000\u01c7\u01ce\u0003p8\u0000"+
		"\u01c8\u01ce\u0003r9\u0000\u01c9\u01ce\u0003v;\u0000\u01ca\u01ce\u0003"+
		"\u0086C\u0000\u01cb\u01ce\u0003t:\u0000\u01cc\u01ce\u0003>\u001f\u0000"+
		"\u01cd\u01c0\u0001\u0000\u0000\u0000\u01cd\u01c1\u0001\u0000\u0000\u0000"+
		"\u01cd\u01c2\u0001\u0000\u0000\u0000\u01cd\u01c3\u0001\u0000\u0000\u0000"+
		"\u01cd\u01c4\u0001\u0000\u0000\u0000\u01cd\u01c5\u0001\u0000\u0000\u0000"+
		"\u01cd\u01c6\u0001\u0000\u0000\u0000\u01cd\u01c7\u0001\u0000\u0000\u0000"+
		"\u01cd\u01c8\u0001\u0000\u0000\u0000\u01cd\u01c9\u0001\u0000\u0000\u0000"+
		"\u01cd\u01ca\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000\u0000\u0000"+
		"\u01cd\u01cc\u0001\u0000\u0000\u0000\u01ce=\u0001\u0000\u0000\u0000\u01cf"+
		"\u01d0\u0005\u0014\u0000\u0000\u01d0\u01d1\u0003T*\u0000\u01d1\u01d5\u0005"+
		"\u0002\u0000\u0000\u01d2\u01d4\u0003@ \u0000\u01d3\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d7\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d5\u01d6\u0001\u0000\u0000\u0000\u01d6\u01d9\u0001\u0000\u0000"+
		"\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d8\u01da\u0003B!\u0000\u01d9"+
		"\u01d8\u0001\u0000\u0000\u0000\u01d9\u01da\u0001\u0000\u0000\u0000\u01da"+
		"\u01db\u0001\u0000\u0000\u0000\u01db\u01dc\u0005\u0003\u0000\u0000\u01dc"+
		"?\u0001\u0000\u0000\u0000\u01dd\u01de\u0005\u0015\u0000\u0000\u01de\u01df"+
		"\u0003\u0082A\u0000\u01df\u01e3\u0005\u0012\u0000\u0000\u01e0\u01e2\u0003"+
		"<\u001e\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000\u01e2\u01e5\u0001\u0000"+
		"\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000\u0000\u01e3\u01e4\u0001\u0000"+
		"\u0000\u0000\u01e4A\u0001\u0000\u0000\u0000\u01e5\u01e3\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0005\u0016\u0000\u0000\u01e7\u01eb\u0005\u0012\u0000"+
		"\u0000\u01e8\u01ea\u0003<\u001e\u0000\u01e9\u01e8\u0001\u0000\u0000\u0000"+
		"\u01ea\u01ed\u0001\u0000\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ec\u0001\u0000\u0000\u0000\u01ecC\u0001\u0000\u0000\u0000\u01ed"+
		"\u01eb\u0001\u0000\u0000\u0000\u01ee\u01f0\u0005\u0017\u0000\u0000\u01ef"+
		"\u01f1\u0005?\u0000\u0000\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f0\u01f1"+
		"\u0001\u0000\u0000\u0000\u01f1\u01f3\u0001\u0000\u0000\u0000\u01f2\u01f4"+
		"\u0005@\u0000\u0000\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f3\u01f4\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f5\u0001\u0000\u0000\u0000\u01f5\u01f6\u0003"+
		"T*\u0000\u01f6E\u0001\u0000\u0000\u0000\u01f7\u01fa\u0003H$\u0000\u01f8"+
		"\u01f9\u0005\r\u0000\u0000\u01f9\u01fb\u0003H$\u0000\u01fa\u01f8\u0001"+
		"\u0000\u0000\u0000\u01fa\u01fb\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fd\u0003L&\u0000\u01fd\u01fe\u0003T*\u0000"+
		"\u01feG\u0001\u0000\u0000\u0000\u01ff\u0200\u0003J%\u0000\u0200\u0201"+
		"\u0005\r\u0000\u0000\u0201\u0202\u0003J%\u0000\u0202\u0205\u0001\u0000"+
		"\u0000\u0000\u0203\u0205\u0003\u0018\f\u0000\u0204\u01ff\u0001\u0000\u0000"+
		"\u0000\u0204\u0203\u0001\u0000\u0000\u0000\u0205I\u0001\u0000\u0000\u0000"+
		"\u0206\u0208\u0005?\u0000\u0000\u0207\u0206\u0001\u0000\u0000\u0000\u0207"+
		"\u0208\u0001\u0000\u0000\u0000\u0208\u020a\u0001\u0000\u0000\u0000\u0209"+
		"\u020b\u0005@\u0000\u0000\u020a\u0209\u0001\u0000\u0000\u0000\u020a\u020b"+
		"\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000\u0000\u020c\u0210"+
		"\u0005C\u0000\u0000\u020d\u020f\u0005\u0018\u0000\u0000\u020e\u020d\u0001"+
		"\u0000\u0000\u0000\u020f\u0212\u0001\u0000\u0000\u0000\u0210\u020e\u0001"+
		"\u0000\u0000\u0000\u0210\u0211\u0001\u0000\u0000\u0000\u0211\u0217\u0001"+
		"\u0000\u0000\u0000\u0212\u0210\u0001\u0000\u0000\u0000\u0213\u0214\u0005"+
		"F\u0000\u0000\u0214\u0216\u0005C\u0000\u0000\u0215\u0213\u0001\u0000\u0000"+
		"\u0000\u0216\u0219\u0001\u0000\u0000\u0000\u0217\u0215\u0001\u0000\u0000"+
		"\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u023b\u0001\u0000\u0000"+
		"\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u021a\u021c\u0005?\u0000\u0000"+
		"\u021b\u021a\u0001\u0000\u0000\u0000\u021b\u021c\u0001\u0000\u0000\u0000"+
		"\u021c\u021e\u0001\u0000\u0000\u0000\u021d\u021f\u0005@\u0000\u0000\u021e"+
		"\u021d\u0001\u0000\u0000\u0000\u021e\u021f\u0001\u0000\u0000\u0000\u021f"+
		"\u0220\u0001\u0000\u0000\u0000\u0220\u0227\u0005C\u0000\u0000\u0221\u0222"+
		"\u0005\u000e\u0000\u0000\u0222\u0223\u0003T*\u0000\u0223\u0224\u0005\u000f"+
		"\u0000\u0000\u0224\u0226\u0001\u0000\u0000\u0000\u0225\u0221\u0001\u0000"+
		"\u0000\u0000\u0226\u0229\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000"+
		"\u0000\u0000\u0227\u0228\u0001\u0000\u0000\u0000\u0228\u0237\u0001\u0000"+
		"\u0000\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u022a\u022b\u0005F\u0000"+
		"\u0000\u022b\u0232\u0005C\u0000\u0000\u022c\u022d\u0005\u000e\u0000\u0000"+
		"\u022d\u022e\u0003T*\u0000\u022e\u022f\u0005\u000f\u0000\u0000\u022f\u0231"+
		"\u0001\u0000\u0000\u0000\u0230\u022c\u0001\u0000\u0000\u0000\u0231\u0234"+
		"\u0001\u0000\u0000\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0232\u0233"+
		"\u0001\u0000\u0000\u0000\u0233\u0236\u0001\u0000\u0000\u0000\u0234\u0232"+
		"\u0001\u0000\u0000\u0000\u0235\u022a\u0001\u0000\u0000\u0000\u0236\u0239"+
		"\u0001\u0000\u0000\u0000\u0237\u0235\u0001\u0000\u0000\u0000\u0237\u0238"+
		"\u0001\u0000\u0000\u0000\u0238\u023b\u0001\u0000\u0000\u0000\u0239\u0237"+
		"\u0001\u0000\u0000\u0000\u023a\u0207\u0001\u0000\u0000\u0000\u023a\u021b"+
		"\u0001\u0000\u0000\u0000\u023bK\u0001\u0000\u0000\u0000\u023c\u023d\u0007"+
		"\u0001\u0000\u0000\u023dM\u0001\u0000\u0000\u0000\u023e\u023f\u0007\u0002"+
		"\u0000\u0000\u023fO\u0001\u0000\u0000\u0000\u0240\u0241\u0005C\u0000\u0000"+
		"\u0241\u0243\u0005\u0004\u0000\u0000\u0242\u0244\u0003R)\u0000\u0243\u0242"+
		"\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000\u0000\u0244\u0245"+
		"\u0001\u0000\u0000\u0000\u0245\u0248\u0005\u0005\u0000\u0000\u0246\u0247"+
		"\u0005F\u0000\u0000\u0247\u0249\u0003P(\u0000\u0248\u0246\u0001\u0000"+
		"\u0000\u0000\u0248\u0249\u0001\u0000\u0000\u0000\u0249\u0258\u0001\u0000"+
		"\u0000\u0000\u024a\u024b\u0003J%\u0000\u024b\u024d\u0005\u0004\u0000\u0000"+
		"\u024c\u024e\u0003R)\u0000\u024d\u024c\u0001\u0000\u0000\u0000\u024d\u024e"+
		"\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f\u0251"+
		"\u0005\u0005\u0000\u0000\u0250\u0252\u0005\r\u0000\u0000\u0251\u0250\u0001"+
		"\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0255\u0001"+
		"\u0000\u0000\u0000\u0253\u0254\u0005F\u0000\u0000\u0254\u0256\u0003P("+
		"\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0255\u0256\u0001\u0000\u0000"+
		"\u0000\u0256\u0258\u0001\u0000\u0000\u0000\u0257\u0240\u0001\u0000\u0000"+
		"\u0000\u0257\u024a\u0001\u0000\u0000\u0000\u0258Q\u0001\u0000\u0000\u0000"+
		"\u0259\u025e\u0003T*\u0000\u025a\u025b\u0005\r\u0000\u0000\u025b\u025d"+
		"\u0003T*\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025d\u0260\u0001\u0000"+
		"\u0000\u0000\u025e\u025c\u0001\u0000\u0000\u0000\u025e\u025f\u0001\u0000"+
		"\u0000\u0000\u025fS\u0001\u0000\u0000\u0000\u0260\u025e\u0001\u0000\u0000"+
		"\u0000\u0261\u0265\u0003Z-\u0000\u0262\u0264\u0003b1\u0000\u0263\u0262"+
		"\u0001\u0000\u0000\u0000\u0264\u0267\u0001\u0000\u0000\u0000\u0265\u0263"+
		"\u0001\u0000\u0000\u0000\u0265\u0266\u0001\u0000\u0000\u0000\u0266U\u0001"+
		"\u0000\u0000\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0268\u026b\u0005"+
		"G\u0000\u0000\u0269\u026a\u0005-\u0000\u0000\u026a\u026c\u0005G\u0000"+
		"\u0000\u026b\u0269\u0001\u0000\u0000\u0000\u026c\u026d\u0001\u0000\u0000"+
		"\u0000\u026d\u026b\u0001\u0000\u0000\u0000\u026d\u026e\u0001\u0000\u0000"+
		"\u0000\u026eW\u0001\u0000\u0000\u0000\u026f\u0271\u0005?\u0000\u0000\u0270"+
		"\u026f\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000\u0000\u0000\u0271"+
		"\u0272\u0001\u0000\u0000\u0000\u0272\u0273\u0005C\u0000\u0000\u0273\u0274"+
		"\u0005F\u0000\u0000\u0274\u0276\u0005\u0004\u0000\u0000\u0275\u0277\u0005"+
		"?\u0000\u0000\u0276\u0275\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000"+
		"\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278\u027b\u0005C\u0000"+
		"\u0000\u0279\u027a\u0005F\u0000\u0000\u027a\u027c\u0005C\u0000\u0000\u027b"+
		"\u0279\u0001\u0000\u0000\u0000\u027b\u027c\u0001\u0000\u0000\u0000\u027c"+
		"\u027d\u0001\u0000\u0000\u0000\u027d\u02b2\u0005\u0005\u0000\u0000\u027e"+
		"\u027f\u0003P(\u0000\u027f\u0280\u0005F\u0000\u0000\u0280\u0282\u0005"+
		"\u0004\u0000\u0000\u0281\u0283\u0005?\u0000\u0000\u0282\u0281\u0001\u0000"+
		"\u0000\u0000\u0282\u0283\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000"+
		"\u0000\u0000\u0284\u0287\u0005C\u0000\u0000\u0285\u0286\u0005F\u0000\u0000"+
		"\u0286\u0288\u0005C\u0000\u0000\u0287\u0285\u0001\u0000\u0000\u0000\u0287"+
		"\u0288\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000\u0000\u0289"+
		"\u028a\u0005\u0005\u0000\u0000\u028a\u02b2\u0001\u0000\u0000\u0000\u028b"+
		"\u028c\u0005.\u0000\u0000\u028c\u028d\u0005\u0004\u0000\u0000\u028d\u0291"+
		"\u0005C\u0000\u0000\u028e\u028f\u0005F\u0000\u0000\u028f\u0292\u0005C"+
		"\u0000\u0000\u0290\u0292\u0003P(\u0000\u0291\u028e\u0001\u0000\u0000\u0000"+
		"\u0291\u0290\u0001\u0000\u0000\u0000\u0291\u0292\u0001\u0000\u0000\u0000"+
		"\u0292\u0293\u0001\u0000\u0000\u0000\u0293\u0298\u0005\u0005\u0000\u0000"+
		"\u0294\u0295\u0005F\u0000\u0000\u0295\u0296\u0005\u0004\u0000\u0000\u0296"+
		"\u0297\u0005C\u0000\u0000\u0297\u0299\u0005\u0005\u0000\u0000\u0298\u0294"+
		"\u0001\u0000\u0000\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299\u02b2"+
		"\u0001\u0000\u0000\u0000\u029a\u029c\u0005?\u0000\u0000\u029b\u029a\u0001"+
		"\u0000\u0000\u0000\u029b\u029c\u0001\u0000\u0000\u0000\u029c\u029d\u0001"+
		"\u0000\u0000\u0000\u029d\u029e\u0005C\u0000\u0000\u029e\u02a1\u0005F\u0000"+
		"\u0000\u029f\u02a0\u0005C\u0000\u0000\u02a0\u02a2\u0005F\u0000\u0000\u02a1"+
		"\u029f\u0001\u0000\u0000\u0000\u02a1\u02a2\u0001\u0000\u0000\u0000\u02a2"+
		"\u02ab\u0001\u0000\u0000\u0000\u02a3\u02a4\u0005\u0004\u0000\u0000\u02a4"+
		"\u02a8\u0005C\u0000\u0000\u02a5\u02a6\u0005F\u0000\u0000\u02a6\u02a9\u0005"+
		"C\u0000\u0000\u02a7\u02a9\u0003P(\u0000\u02a8\u02a5\u0001\u0000\u0000"+
		"\u0000\u02a8\u02a7\u0001\u0000\u0000\u0000\u02a8\u02a9\u0001\u0000\u0000"+
		"\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ac\u0005\u0005\u0000"+
		"\u0000\u02ab\u02a3\u0001\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000\u0000"+
		"\u0000\u02ac\u02af\u0001\u0000\u0000\u0000\u02ad\u02ae\u0005F\u0000\u0000"+
		"\u02ae\u02b0\u0003P(\u0000\u02af\u02ad\u0001\u0000\u0000\u0000\u02af\u02b0"+
		"\u0001\u0000\u0000\u0000\u02b0\u02b2\u0001\u0000\u0000\u0000\u02b1\u0270"+
		"\u0001\u0000\u0000\u0000\u02b1\u027e\u0001\u0000\u0000\u0000\u02b1\u028b"+
		"\u0001\u0000\u0000\u0000\u02b1\u029b\u0001\u0000\u0000\u0000\u02b2Y\u0001"+
		"\u0000\u0000\u0000\u02b3\u02d7\u0003\u0012\t\u0000\u02b4\u02d7\u0003\u0014"+
		"\n\u0000\u02b5\u02d7\u0003\u0084B\u0000\u02b6\u02d7\u0003\u0016\u000b"+
		"\u0000\u02b7\u02ba\u0003P(\u0000\u02b8\u02b9\u0005F\u0000\u0000\u02b9"+
		"\u02bb\u0003P(\u0000\u02ba\u02b8\u0001\u0000\u0000\u0000\u02ba\u02bb\u0001"+
		"\u0000\u0000\u0000\u02bb\u02d7\u0001\u0000\u0000\u0000\u02bc\u02be\u0005"+
		"?\u0000\u0000\u02bd\u02bc\u0001\u0000\u0000\u0000\u02bd\u02be\u0001\u0000"+
		"\u0000\u0000\u02be\u02bf\u0001\u0000\u0000\u0000\u02bf\u02d7\u0005C\u0000"+
		"\u0000\u02c0\u02c2\u0005@\u0000\u0000\u02c1\u02c0\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c3\u0001\u0000\u0000\u0000"+
		"\u02c3\u02d7\u0005C\u0000\u0000\u02c4\u02d7\u0003V+\u0000\u02c5\u02d7"+
		"\u0005H\u0000\u0000\u02c6\u02d7\u0005G\u0000\u0000\u02c7\u02d7\u0005D"+
		"\u0000\u0000\u02c8\u02d7\u0003J%\u0000\u02c9\u02d7\u0003`0\u0000\u02ca"+
		"\u02d7\u0003D\"\u0000\u02cb\u02cc\u0005\u0004\u0000\u0000\u02cc\u02cd"+
		"\u0003T*\u0000\u02cd\u02ce\u0005\u0005\u0000\u0000\u02ce\u02d7\u0001\u0000"+
		"\u0000\u0000\u02cf\u02d7\u0003\u0018\f\u0000\u02d0\u02d7\u0003,\u0016"+
		"\u0000\u02d1\u02d7\u0003t:\u0000\u02d2\u02d7\u0003\u0088D\u0000\u02d3"+
		"\u02d7\u0003$\u0012\u0000\u02d4\u02d7\u0003X,\u0000\u02d5\u02d7\u0003"+
		"\\.\u0000\u02d6\u02b3\u0001\u0000\u0000\u0000\u02d6\u02b4\u0001\u0000"+
		"\u0000\u0000\u02d6\u02b5\u0001\u0000\u0000\u0000\u02d6\u02b6\u0001\u0000"+
		"\u0000\u0000\u02d6\u02b7\u0001\u0000\u0000\u0000\u02d6\u02bd\u0001\u0000"+
		"\u0000\u0000\u02d6\u02c1\u0001\u0000\u0000\u0000\u02d6\u02c4\u0001\u0000"+
		"\u0000\u0000\u02d6\u02c5\u0001\u0000\u0000\u0000\u02d6\u02c6\u0001\u0000"+
		"\u0000\u0000\u02d6\u02c7\u0001\u0000\u0000\u0000\u02d6\u02c8\u0001\u0000"+
		"\u0000\u0000\u02d6\u02c9\u0001\u0000\u0000\u0000\u02d6\u02ca\u0001\u0000"+
		"\u0000\u0000\u02d6\u02cb\u0001\u0000\u0000\u0000\u02d6\u02cf\u0001\u0000"+
		"\u0000\u0000\u02d6\u02d0\u0001\u0000\u0000\u0000\u02d6\u02d1\u0001\u0000"+
		"\u0000\u0000\u02d6\u02d2\u0001\u0000\u0000\u0000\u02d6\u02d3\u0001\u0000"+
		"\u0000\u0000\u02d6\u02d4\u0001\u0000\u0000\u0000\u02d6\u02d5\u0001\u0000"+
		"\u0000\u0000\u02d7[\u0001\u0000\u0000\u0000\u02d8\u02da\u0005@\u0000\u0000"+
		"\u02d9\u02d8\u0001\u0000\u0000\u0000\u02d9\u02da\u0001\u0000\u0000\u0000"+
		"\u02da\u02db\u0001\u0000\u0000\u0000\u02db\u02dc\u0003$\u0012\u0000\u02dc"+
		"\u02e8\u0005\u0002\u0000\u0000\u02dd\u02e2\u0003^/\u0000\u02de\u02df\u0005"+
		"\r\u0000\u0000\u02df\u02e1\u0003^/\u0000\u02e0\u02de\u0001\u0000\u0000"+
		"\u0000\u02e1\u02e4\u0001\u0000\u0000\u0000\u02e2\u02e0\u0001\u0000\u0000"+
		"\u0000\u02e2\u02e3\u0001\u0000\u0000\u0000\u02e3\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e4\u02e2\u0001\u0000\u0000\u0000\u02e5\u02e7\u0005\r\u0000\u0000"+
		"\u02e6\u02e5\u0001\u0000\u0000\u0000\u02e6\u02e7\u0001\u0000\u0000\u0000"+
		"\u02e7\u02e9\u0001\u0000\u0000\u0000\u02e8\u02dd\u0001\u0000\u0000\u0000"+
		"\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000"+
		"\u02ea\u02eb\u0005\u0003\u0000\u0000\u02eb]\u0001\u0000\u0000\u0000\u02ec"+
		"\u02ed\u0007\u0003\u0000\u0000\u02ed\u02ee\u0005\u0012\u0000\u0000\u02ee"+
		"\u02ef\u0003T*\u0000\u02ef_\u0001\u0000\u0000\u0000\u02f0\u02fc\u0005"+
		"\u0002\u0000\u0000\u02f1\u02f6\u0003^/\u0000\u02f2\u02f3\u0005\r\u0000"+
		"\u0000\u02f3\u02f5\u0003^/\u0000\u02f4\u02f2\u0001\u0000\u0000\u0000\u02f5"+
		"\u02f8\u0001\u0000\u0000\u0000\u02f6\u02f4\u0001\u0000\u0000\u0000\u02f6"+
		"\u02f7\u0001\u0000\u0000\u0000\u02f7\u02fa\u0001\u0000\u0000\u0000\u02f8"+
		"\u02f6\u0001\u0000\u0000\u0000\u02f9\u02fb\u0005\r\u0000\u0000\u02fa\u02f9"+
		"\u0001\u0000\u0000\u0000\u02fa\u02fb\u0001\u0000\u0000\u0000\u02fb\u02fd"+
		"\u0001\u0000\u0000\u0000\u02fc\u02f1\u0001\u0000\u0000\u0000\u02fc\u02fd"+
		"\u0001\u0000\u0000\u0000\u02fd\u02fe\u0001\u0000\u0000\u0000\u02fe\u0339"+
		"\u0005\u0003\u0000\u0000\u02ff\u030b\u0005\u0002\u0000\u0000\u0300\u0305"+
		"\u0003T*\u0000\u0301\u0302\u0005\r\u0000\u0000\u0302\u0304\u0003T*\u0000"+
		"\u0303\u0301\u0001\u0000\u0000\u0000\u0304\u0307\u0001\u0000\u0000\u0000"+
		"\u0305\u0303\u0001\u0000\u0000\u0000\u0305\u0306\u0001\u0000\u0000\u0000"+
		"\u0306\u0309\u0001\u0000\u0000\u0000\u0307\u0305\u0001\u0000\u0000\u0000"+
		"\u0308\u030a\u0005\r\u0000\u0000\u0309\u0308\u0001\u0000\u0000\u0000\u0309"+
		"\u030a\u0001\u0000\u0000\u0000\u030a\u030c\u0001\u0000\u0000\u0000\u030b"+
		"\u0300\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000\u0000\u030c"+
		"\u030d\u0001\u0000\u0000\u0000\u030d\u0339\u0005\u0003\u0000\u0000\u030e"+
		"\u030f\u0003$\u0012\u0000\u030f\u031b\u0005\u0002\u0000\u0000\u0310\u0315"+
		"\u0003T*\u0000\u0311\u0312\u0005\r\u0000\u0000\u0312\u0314\u0003T*\u0000"+
		"\u0313\u0311\u0001\u0000\u0000\u0000\u0314\u0317\u0001\u0000\u0000\u0000"+
		"\u0315\u0313\u0001\u0000\u0000\u0000\u0315\u0316\u0001\u0000\u0000\u0000"+
		"\u0316\u0319\u0001\u0000\u0000\u0000\u0317\u0315\u0001\u0000\u0000\u0000"+
		"\u0318\u031a\u0005\r\u0000\u0000\u0319\u0318\u0001\u0000\u0000\u0000\u0319"+
		"\u031a\u0001\u0000\u0000\u0000\u031a\u031c\u0001\u0000\u0000\u0000\u031b"+
		"\u0310\u0001\u0000\u0000\u0000\u031b\u031c\u0001\u0000\u0000\u0000\u031c"+
		"\u031d\u0001\u0000\u0000\u0000\u031d\u031e\u0005\u0003\u0000\u0000\u031e"+
		"\u0339\u0001\u0000\u0000\u0000\u031f\u0320\u0003$\u0012\u0000\u0320\u0322"+
		"\u0005\u000e\u0000\u0000\u0321\u0323\u0005D\u0000\u0000\u0322\u0321\u0001"+
		"\u0000\u0000\u0000\u0322\u0323\u0001\u0000\u0000\u0000\u0323\u0324\u0001"+
		"\u0000\u0000\u0000\u0324\u0325\u0005\u000f\u0000\u0000\u0325\u0331\u0005"+
		"\u0002\u0000\u0000\u0326\u032b\u0003T*\u0000\u0327\u0328\u0005\r\u0000"+
		"\u0000\u0328\u032a\u0003T*\u0000\u0329\u0327\u0001\u0000\u0000\u0000\u032a"+
		"\u032d\u0001\u0000\u0000\u0000\u032b\u0329\u0001\u0000\u0000\u0000\u032b"+
		"\u032c\u0001\u0000\u0000\u0000\u032c\u032f\u0001\u0000\u0000\u0000\u032d"+
		"\u032b\u0001\u0000\u0000\u0000\u032e\u0330\u0005\r\u0000\u0000\u032f\u032e"+
		"\u0001\u0000\u0000\u0000\u032f\u0330\u0001\u0000\u0000\u0000\u0330\u0332"+
		"\u0001\u0000\u0000\u0000\u0331\u0326\u0001\u0000\u0000\u0000\u0331\u0332"+
		"\u0001\u0000\u0000\u0000\u0332\u0333\u0001\u0000\u0000\u0000\u0333\u0334"+
		"\u0005\u0003\u0000\u0000\u0334\u0339\u0001\u0000\u0000\u0000\u0335\u0336"+
		"\u0003$\u0012\u0000\u0336\u0337\u0005\u0018\u0000\u0000\u0337\u0339\u0001"+
		"\u0000\u0000\u0000\u0338\u02f0\u0001\u0000\u0000\u0000\u0338\u02ff\u0001"+
		"\u0000\u0000\u0000\u0338\u030e\u0001\u0000\u0000\u0000\u0338\u031f\u0001"+
		"\u0000\u0000\u0000\u0338\u0335\u0001\u0000\u0000\u0000\u0339a\u0001\u0000"+
		"\u0000\u0000\u033a\u033b\u0007\u0004\u0000\u0000\u033b\u0342\u0003Z-\u0000"+
		"\u033c\u033d\u0007\u0005\u0000\u0000\u033d\u0342\u0003Z-\u0000\u033e\u033f"+
		"\u0003N\'\u0000\u033f\u0340\u0003Z-\u0000\u0340\u0342\u0001\u0000\u0000"+
		"\u0000\u0341\u033a\u0001\u0000\u0000\u0000\u0341\u033c\u0001\u0000\u0000"+
		"\u0000\u0341\u033e\u0001\u0000\u0000\u0000\u0342c\u0001\u0000\u0000\u0000"+
		"\u0343\u0347\u0003Z-\u0000\u0344\u0345\u0003N\'\u0000\u0345\u0346\u0003"+
		"d2\u0000\u0346\u0348\u0001\u0000\u0000\u0000\u0347\u0344\u0001\u0000\u0000"+
		"\u0000\u0347\u0348\u0001\u0000\u0000\u0000\u0348e\u0001\u0000\u0000\u0000"+
		"\u0349\u034b\u00052\u0000\u0000\u034a\u034c\u0003R)\u0000\u034b\u034a"+
		"\u0001\u0000\u0000\u0000\u034b\u034c\u0001\u0000\u0000\u0000\u034cg\u0001"+
		"\u0000\u0000\u0000\u034d\u034f\u00053\u0000\u0000\u034e\u0350\u0005C\u0000"+
		"\u0000\u034f\u034e\u0001\u0000\u0000\u0000\u034f\u0350\u0001\u0000\u0000"+
		"\u0000\u0350i\u0001\u0000\u0000\u0000\u0351\u0353\u00054\u0000\u0000\u0352"+
		"\u0354\u0005C\u0000\u0000\u0353\u0352\u0001\u0000\u0000\u0000\u0353\u0354"+
		"\u0001\u0000\u0000\u0000\u0354k\u0001\u0000\u0000\u0000\u0355\u0359\u0003"+
		"`0\u0000\u0356\u0359\u0003T*\u0000\u0357\u0359\u0003\u0084B\u0000\u0358"+
		"\u0355\u0001\u0000\u0000\u0000\u0358\u0356\u0001\u0000\u0000\u0000\u0358"+
		"\u0357\u0001\u0000\u0000\u0000\u0359m\u0001\u0000\u0000\u0000\u035a\u035b"+
		"\u00055\u0000\u0000\u035b\u035c\u0005C\u0000\u0000\u035c\u0360\u0003$"+
		"\u0012\u0000\u035d\u035e\u0003L&\u0000\u035e\u035f\u0003l6\u0000\u035f"+
		"\u0361\u0001\u0000\u0000\u0000\u0360\u035d\u0001\u0000\u0000\u0000\u0360"+
		"\u0361\u0001\u0000\u0000\u0000\u0361\u0368\u0001\u0000\u0000\u0000\u0362"+
		"\u0363\u00055\u0000\u0000\u0363\u0364\u0005C\u0000\u0000\u0364\u0365\u0003"+
		"L&\u0000\u0365\u0366\u0003l6\u0000\u0366\u0368\u0001\u0000\u0000\u0000"+
		"\u0367\u035a\u0001\u0000\u0000\u0000\u0367\u0362\u0001\u0000\u0000\u0000"+
		"\u0368o\u0001\u0000\u0000\u0000\u0369\u036d\u00056\u0000\u0000\u036a\u036b"+
		"\u0003F#\u0000\u036b\u036c\u00057\u0000\u0000\u036c\u036e\u0001\u0000"+
		"\u0000\u0000\u036d\u036a\u0001\u0000\u0000\u0000\u036d\u036e\u0001\u0000"+
		"\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u0370\u0003d2\u0000"+
		"\u0370\u0372\u0003:\u001d\u0000\u0371\u0373\u0003r9\u0000\u0372\u0371"+
		"\u0001\u0000\u0000\u0000\u0372\u0373\u0001\u0000\u0000\u0000\u0373q\u0001"+
		"\u0000\u0000\u0000\u0374\u0377\u00058\u0000\u0000\u0375\u0378\u0003p8"+
		"\u0000\u0376\u0378\u0003:\u001d\u0000\u0377\u0375\u0001\u0000\u0000\u0000"+
		"\u0377\u0376\u0001\u0000\u0000\u0000\u0378s\u0001\u0000\u0000\u0000\u0379"+
		"\u037b\u0005?\u0000\u0000\u037a\u0379\u0001\u0000\u0000\u0000\u037a\u037b"+
		"\u0001\u0000\u0000\u0000\u037b\u037d\u0001\u0000\u0000\u0000\u037c\u037e"+
		"\u0005@\u0000\u0000\u037d\u037c\u0001\u0000\u0000\u0000\u037d\u037e\u0001"+
		"\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037f\u0380\u0005"+
		"C\u0000\u0000\u0380\u0381\u0007\u0006\u0000\u0000\u0381u\u0001\u0000\u0000"+
		"\u0000\u0382\u0387\u0005;\u0000\u0000\u0383\u0388\u0003x<\u0000\u0384"+
		"\u0388\u0003z=\u0000\u0385\u0388\u0003|>\u0000\u0386\u0388\u0003~?\u0000"+
		"\u0387\u0383\u0001\u0000\u0000\u0000\u0387\u0384\u0001\u0000\u0000\u0000"+
		"\u0387\u0385\u0001\u0000\u0000\u0000\u0387\u0386\u0001\u0000\u0000\u0000"+
		"\u0388\u0389\u0001\u0000\u0000\u0000\u0389\u038a\u0003:\u001d\u0000\u038a"+
		"w\u0001\u0000\u0000\u0000\u038b\u038d\u0003\u0080@\u0000\u038c\u038b\u0001"+
		"\u0000\u0000\u0000\u038c\u038d\u0001\u0000\u0000\u0000\u038d\u038e\u0001"+
		"\u0000\u0000\u0000\u038e\u0390\u00057\u0000\u0000\u038f\u0391\u0003T*"+
		"\u0000\u0390\u038f\u0001\u0000\u0000\u0000\u0390\u0391\u0001\u0000\u0000"+
		"\u0000\u0391\u0392\u0001\u0000\u0000\u0000\u0392\u0394\u00057\u0000\u0000"+
		"\u0393\u0395\u0003\u0080@\u0000\u0394\u0393\u0001\u0000\u0000\u0000\u0394"+
		"\u0395\u0001\u0000\u0000\u0000\u0395y\u0001\u0000\u0000\u0000\u0396\u0397"+
		"\u0003\u0082A\u0000\u0397\u0398\u0005\u001a\u0000\u0000\u0398\u039a\u0001"+
		"\u0000\u0000\u0000\u0399\u0396\u0001\u0000\u0000\u0000\u0399\u039a\u0001"+
		"\u0000\u0000\u0000\u039a\u039b\u0001\u0000\u0000\u0000\u039b\u039c\u0005"+
		"<\u0000\u0000\u039c\u039d\u0003T*\u0000\u039d{\u0001\u0000\u0000\u0000"+
		"\u039e\u039f\u0003T*\u0000\u039f}\u0001\u0000\u0000\u0000\u03a0\u03a1"+
		"\u0001\u0000\u0000\u0000\u03a1\u007f\u0001\u0000\u0000\u0000\u03a2\u03a6"+
		"\u0003F#\u0000\u03a3\u03a6\u0003T*\u0000\u03a4\u03a6\u0003t:\u0000\u03a5"+
		"\u03a2\u0001\u0000\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a5"+
		"\u03a4\u0001\u0000\u0000\u0000\u03a6\u0081\u0001\u0000\u0000\u0000\u03a7"+
		"\u03ac\u0003T*\u0000\u03a8\u03a9\u0005\r\u0000\u0000\u03a9\u03ab\u0003"+
		"T*\u0000\u03aa\u03a8\u0001\u0000\u0000\u0000\u03ab\u03ae\u0001\u0000\u0000"+
		"\u0000\u03ac\u03aa\u0001\u0000\u0000\u0000\u03ac\u03ad\u0001\u0000\u0000"+
		"\u0000\u03ad\u0083\u0001\u0000\u0000\u0000\u03ae\u03ac\u0001\u0000\u0000"+
		"\u0000\u03af\u03b0\u0003$\u0012\u0000\u03b0\u03bc\u0005\u0002\u0000\u0000"+
		"\u03b1\u03b6\u0003^/\u0000\u03b2\u03b3\u0005\r\u0000\u0000\u03b3\u03b5"+
		"\u0003^/\u0000\u03b4\u03b2\u0001\u0000\u0000\u0000\u03b5\u03b8\u0001\u0000"+
		"\u0000\u0000\u03b6\u03b4\u0001\u0000\u0000\u0000\u03b6\u03b7\u0001\u0000"+
		"\u0000\u0000\u03b7\u03ba\u0001\u0000\u0000\u0000\u03b8\u03b6\u0001\u0000"+
		"\u0000\u0000\u03b9\u03bb\u0005\r\u0000\u0000\u03ba\u03b9\u0001\u0000\u0000"+
		"\u0000\u03ba\u03bb\u0001\u0000\u0000\u0000\u03bb\u03bd\u0001\u0000\u0000"+
		"\u0000\u03bc\u03b1\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001\u0000\u0000"+
		"\u0000\u03bd\u03be\u0001\u0000\u0000\u0000\u03be\u03bf\u0005\u0003\u0000"+
		"\u0000\u03bf\u0085\u0001\u0000\u0000\u0000\u03c0\u03c1\u0005=\u0000\u0000"+
		"\u03c1\u03c2\u0003T*\u0000\u03c2\u03c3\u0005\u0007\u0000\u0000\u03c3\u03c6"+
		"\u0005C\u0000\u0000\u03c4\u03c5\u0005\r\u0000\u0000\u03c5\u03c7\u0005"+
		"C\u0000\u0000\u03c6\u03c4\u0001\u0000\u0000\u0000\u03c6\u03c7\u0001\u0000"+
		"\u0000\u0000\u03c7\u03c8\u0001\u0000\u0000\u0000\u03c8\u03c9\u0003:\u001d"+
		"\u0000\u03c9\u0087\u0001\u0000\u0000\u0000\u03ca\u03cb\u0005C\u0000\u0000"+
		"\u03cb\u03cc\u0005\u0004\u0000\u0000\u03cc\u03cd\u0003T*\u0000\u03cd\u03ce"+
		"\u0005\u0005\u0000\u0000\u03ce\u0089\u0001\u0000\u0000\u0000\u0088\u008d"+
		"\u0098\u00a4\u00ac\u00b0\u00b6\u00ba\u00be\u00cc\u00d3\u00d9\u00df\u00e5"+
		"\u00e9\u00ef\u00fb\u00fe\u0108\u010b\u0116\u0120\u0128\u012f\u0136\u0139"+
		"\u013c\u0140\u0143\u0148\u014b\u014f\u0154\u0157\u0160\u0163\u0168\u016d"+
		"\u0172\u0178\u017c\u0182\u0187\u0191\u0198\u01a2\u01a9\u01b0\u01b5\u01bb"+
		"\u01cd\u01d5\u01d9\u01e3\u01eb\u01f0\u01f3\u01fa\u0204\u0207\u020a\u0210"+
		"\u0217\u021b\u021e\u0227\u0232\u0237\u023a\u0243\u0248\u024d\u0251\u0255"+
		"\u0257\u025e\u0265\u026d\u0270\u0276\u027b\u0282\u0287\u0291\u0298\u029b"+
		"\u02a1\u02a8\u02ab\u02af\u02b1\u02ba\u02bd\u02c1\u02d6\u02d9\u02e2\u02e6"+
		"\u02e8\u02f6\u02fa\u02fc\u0305\u0309\u030b\u0315\u0319\u031b\u0322\u032b"+
		"\u032f\u0331\u0338\u0341\u0347\u034b\u034f\u0353\u0358\u0360\u0367\u036d"+
		"\u0372\u0377\u037a\u037d\u0387\u038c\u0390\u0394\u0399\u03a5\u03ac\u03b6"+
		"\u03ba\u03bc\u03c6";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}