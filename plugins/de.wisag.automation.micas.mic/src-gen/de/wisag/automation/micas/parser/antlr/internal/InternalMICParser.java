package de.wisag.automation.micas.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.wisag.automation.micas.services.MICGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMICParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_RAW_METADATE", "RULE_XFLOAT", "RULE_SPACE", "RULE_EOL", "'MODUL'", "'('", "','", "')'", "'ENDMODUL'", "'\\u00B0nothing'", "'WordV'", "'WordK'", "'FloatV'", "'FloatK'", "'IPAMB'", "'IPAAW'", "'IPAZW'", "'IPAMW'", "'TASK'", "'ENDE'", "'writeaccess='", "'true'", "'cycl'", "'back'", "'init'", "'cycls'", "'evnts'", "'backs'", "'inits'", "'CYCL'", "'BACK'", "'INIT'", "'CYCLS'", "'EVNTS'", "'BACKS'", "'INITS'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__37=37;
    public static final int T__16=16;
    public static final int T__38=38;
    public static final int T__17=17;
    public static final int T__39=39;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__33=33;
    public static final int T__12=12;
    public static final int T__34=34;
    public static final int T__13=13;
    public static final int T__35=35;
    public static final int RULE_SPACE=8;
    public static final int T__14=14;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__10=10;
    public static final int T__32=32;
    public static final int RULE_ID=4;
    public static final int RULE_RAW_METADATE=6;
    public static final int RULE_EOL=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=5;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int RULE_XFLOAT=7;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__20=20;
    public static final int T__21=21;

    // delegates
    // delegators


        public InternalMICParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMICParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMICParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMIC.g"; }



     	private MICGrammarAccess grammarAccess;

        public InternalMICParser(TokenStream input, MICGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MICGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMIC.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMIC.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalMIC.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMIC.g:71:1: ruleModel returns [EObject current=null] : this_Module_0= ruleModule ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject this_Module_0 = null;



        	enterRule();

        try {
            // InternalMIC.g:77:2: (this_Module_0= ruleModule )
            // InternalMIC.g:78:2: this_Module_0= ruleModule
            {

            		newCompositeNode(grammarAccess.getModelAccess().getModuleParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_Module_0=ruleModule();

            state._fsp--;


            		current = this_Module_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModule"
    // InternalMIC.g:89:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // InternalMIC.g:89:47: (iv_ruleModule= ruleModule EOF )
            // InternalMIC.g:90:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalMIC.g:96:1: ruleModule returns [EObject current=null] : ( ( (lv_moduleProlog_0_0= ruleMetaData ) )* otherlv_1= 'MODUL' otherlv_2= '(' ( (lv_type_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_value_5_0= RULE_INT ) ) otherlv_6= ')' ( (lv_decalarations_7_0= ruleSymbol ) )* ( (lv_tasks_8_0= ruleTask ) )* otherlv_9= 'ENDMODUL' ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_type_3_0=null;
        Token otherlv_4=null;
        Token lv_value_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_moduleProlog_0_0 = null;

        EObject lv_decalarations_7_0 = null;

        EObject lv_tasks_8_0 = null;



        	enterRule();

        try {
            // InternalMIC.g:102:2: ( ( ( (lv_moduleProlog_0_0= ruleMetaData ) )* otherlv_1= 'MODUL' otherlv_2= '(' ( (lv_type_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_value_5_0= RULE_INT ) ) otherlv_6= ')' ( (lv_decalarations_7_0= ruleSymbol ) )* ( (lv_tasks_8_0= ruleTask ) )* otherlv_9= 'ENDMODUL' ) )
            // InternalMIC.g:103:2: ( ( (lv_moduleProlog_0_0= ruleMetaData ) )* otherlv_1= 'MODUL' otherlv_2= '(' ( (lv_type_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_value_5_0= RULE_INT ) ) otherlv_6= ')' ( (lv_decalarations_7_0= ruleSymbol ) )* ( (lv_tasks_8_0= ruleTask ) )* otherlv_9= 'ENDMODUL' )
            {
            // InternalMIC.g:103:2: ( ( (lv_moduleProlog_0_0= ruleMetaData ) )* otherlv_1= 'MODUL' otherlv_2= '(' ( (lv_type_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_value_5_0= RULE_INT ) ) otherlv_6= ')' ( (lv_decalarations_7_0= ruleSymbol ) )* ( (lv_tasks_8_0= ruleTask ) )* otherlv_9= 'ENDMODUL' )
            // InternalMIC.g:104:3: ( (lv_moduleProlog_0_0= ruleMetaData ) )* otherlv_1= 'MODUL' otherlv_2= '(' ( (lv_type_3_0= RULE_ID ) ) otherlv_4= ',' ( (lv_value_5_0= RULE_INT ) ) otherlv_6= ')' ( (lv_decalarations_7_0= ruleSymbol ) )* ( (lv_tasks_8_0= ruleTask ) )* otherlv_9= 'ENDMODUL'
            {
            // InternalMIC.g:104:3: ( (lv_moduleProlog_0_0= ruleMetaData ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==RULE_RAW_METADATE||LA1_0==15) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMIC.g:105:4: (lv_moduleProlog_0_0= ruleMetaData )
            	    {
            	    // InternalMIC.g:105:4: (lv_moduleProlog_0_0= ruleMetaData )
            	    // InternalMIC.g:106:5: lv_moduleProlog_0_0= ruleMetaData
            	    {

            	    					newCompositeNode(grammarAccess.getModuleAccess().getModulePrologMetaDataParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_3);
            	    lv_moduleProlog_0_0=ruleMetaData();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"moduleProlog",
            	    						lv_moduleProlog_0_0,
            	    						"de.wisag.automation.micas.MIC.MetaData");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_1=(Token)match(input,10,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getMODULKeyword_1());
            		
            otherlv_2=(Token)match(input,11,FOLLOW_5); 

            			newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:131:3: ( (lv_type_3_0= RULE_ID ) )
            // InternalMIC.g:132:4: (lv_type_3_0= RULE_ID )
            {
            // InternalMIC.g:132:4: (lv_type_3_0= RULE_ID )
            // InternalMIC.g:133:5: lv_type_3_0= RULE_ID
            {
            lv_type_3_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_type_3_0, grammarAccess.getModuleAccess().getTypeIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"type",
            						lv_type_3_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getModuleAccess().getCommaKeyword_4());
            		
            // InternalMIC.g:153:3: ( (lv_value_5_0= RULE_INT ) )
            // InternalMIC.g:154:4: (lv_value_5_0= RULE_INT )
            {
            // InternalMIC.g:154:4: (lv_value_5_0= RULE_INT )
            // InternalMIC.g:155:5: lv_value_5_0= RULE_INT
            {
            lv_value_5_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_value_5_0, grammarAccess.getModuleAccess().getValueINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_5_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_9); 

            			newLeafNode(otherlv_6, grammarAccess.getModuleAccess().getRightParenthesisKeyword_6());
            		
            // InternalMIC.g:175:3: ( (lv_decalarations_7_0= ruleSymbol ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==15) ) {
                    int LA2_1 = input.LA(2);

                    if ( (LA2_1==RULE_RAW_METADATE) ) {
                        alt2=1;
                    }


                }
                else if ( (LA2_0==RULE_RAW_METADATE||(LA2_0>=16 && LA2_0<=23)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMIC.g:176:4: (lv_decalarations_7_0= ruleSymbol )
            	    {
            	    // InternalMIC.g:176:4: (lv_decalarations_7_0= ruleSymbol )
            	    // InternalMIC.g:177:5: lv_decalarations_7_0= ruleSymbol
            	    {

            	    					newCompositeNode(grammarAccess.getModuleAccess().getDecalarationsSymbolParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_9);
            	    lv_decalarations_7_0=ruleSymbol();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"decalarations",
            	    						lv_decalarations_7_0,
            	    						"de.wisag.automation.micas.MIC.Symbol");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMIC.g:194:3: ( (lv_tasks_8_0= ruleTask ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_RAW_METADATE||LA3_0==15||LA3_0==24) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMIC.g:195:4: (lv_tasks_8_0= ruleTask )
            	    {
            	    // InternalMIC.g:195:4: (lv_tasks_8_0= ruleTask )
            	    // InternalMIC.g:196:5: lv_tasks_8_0= ruleTask
            	    {

            	    					newCompositeNode(grammarAccess.getModuleAccess().getTasksTaskParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_10);
            	    lv_tasks_8_0=ruleTask();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getModuleRule());
            	    					}
            	    					add(
            	    						current,
            	    						"tasks",
            	    						lv_tasks_8_0,
            	    						"de.wisag.automation.micas.MIC.Task");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            otherlv_9=(Token)match(input,14,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getModuleAccess().getENDMODULKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleSymbol"
    // InternalMIC.g:221:1: entryRuleSymbol returns [EObject current=null] : iv_ruleSymbol= ruleSymbol EOF ;
    public final EObject entryRuleSymbol() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbol = null;


        try {
            // InternalMIC.g:221:47: (iv_ruleSymbol= ruleSymbol EOF )
            // InternalMIC.g:222:2: iv_ruleSymbol= ruleSymbol EOF
            {
             newCompositeNode(grammarAccess.getSymbolRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSymbol=ruleSymbol();

            state._fsp--;

             current =iv_ruleSymbol; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSymbol"


    // $ANTLR start "ruleSymbol"
    // InternalMIC.g:228:1: ruleSymbol returns [EObject current=null] : (this_WordValue_0= ruleWordValue | this_FloatValue_1= ruleFloatValue | this_Reference_2= ruleReference | this_MetaData_3= ruleMetaData ) ;
    public final EObject ruleSymbol() throws RecognitionException {
        EObject current = null;

        EObject this_WordValue_0 = null;

        EObject this_FloatValue_1 = null;

        EObject this_Reference_2 = null;

        EObject this_MetaData_3 = null;



        	enterRule();

        try {
            // InternalMIC.g:234:2: ( (this_WordValue_0= ruleWordValue | this_FloatValue_1= ruleFloatValue | this_Reference_2= ruleReference | this_MetaData_3= ruleMetaData ) )
            // InternalMIC.g:235:2: (this_WordValue_0= ruleWordValue | this_FloatValue_1= ruleFloatValue | this_Reference_2= ruleReference | this_MetaData_3= ruleMetaData )
            {
            // InternalMIC.g:235:2: (this_WordValue_0= ruleWordValue | this_FloatValue_1= ruleFloatValue | this_Reference_2= ruleReference | this_MetaData_3= ruleMetaData )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 16:
            case 17:
                {
                alt4=1;
                }
                break;
            case 18:
            case 19:
                {
                alt4=2;
                }
                break;
            case 20:
            case 21:
            case 22:
            case 23:
                {
                alt4=3;
                }
                break;
            case RULE_RAW_METADATE:
            case 15:
                {
                alt4=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // InternalMIC.g:236:3: this_WordValue_0= ruleWordValue
                    {

                    			newCompositeNode(grammarAccess.getSymbolAccess().getWordValueParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_WordValue_0=ruleWordValue();

                    state._fsp--;


                    			current = this_WordValue_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIC.g:245:3: this_FloatValue_1= ruleFloatValue
                    {

                    			newCompositeNode(grammarAccess.getSymbolAccess().getFloatValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatValue_1=ruleFloatValue();

                    state._fsp--;


                    			current = this_FloatValue_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIC.g:254:3: this_Reference_2= ruleReference
                    {

                    			newCompositeNode(grammarAccess.getSymbolAccess().getReferenceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Reference_2=ruleReference();

                    state._fsp--;


                    			current = this_Reference_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIC.g:263:3: this_MetaData_3= ruleMetaData
                    {

                    			newCompositeNode(grammarAccess.getSymbolAccess().getMetaDataParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_MetaData_3=ruleMetaData();

                    state._fsp--;


                    			current = this_MetaData_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSymbol"


    // $ANTLR start "entryRuleMetaData"
    // InternalMIC.g:275:1: entryRuleMetaData returns [EObject current=null] : iv_ruleMetaData= ruleMetaData EOF ;
    public final EObject entryRuleMetaData() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetaData = null;


        try {
            // InternalMIC.g:275:49: (iv_ruleMetaData= ruleMetaData EOF )
            // InternalMIC.g:276:2: iv_ruleMetaData= ruleMetaData EOF
            {
             newCompositeNode(grammarAccess.getMetaDataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetaData=ruleMetaData();

            state._fsp--;

             current =iv_ruleMetaData; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetaData"


    // $ANTLR start "ruleMetaData"
    // InternalMIC.g:282:1: ruleMetaData returns [EObject current=null] : ( ( (lv_name_0_0= '\\u00B0nothing' ) )? ( (lv_value_1_0= RULE_RAW_METADATE ) ) ) ;
    public final EObject ruleMetaData() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalMIC.g:288:2: ( ( ( (lv_name_0_0= '\\u00B0nothing' ) )? ( (lv_value_1_0= RULE_RAW_METADATE ) ) ) )
            // InternalMIC.g:289:2: ( ( (lv_name_0_0= '\\u00B0nothing' ) )? ( (lv_value_1_0= RULE_RAW_METADATE ) ) )
            {
            // InternalMIC.g:289:2: ( ( (lv_name_0_0= '\\u00B0nothing' ) )? ( (lv_value_1_0= RULE_RAW_METADATE ) ) )
            // InternalMIC.g:290:3: ( (lv_name_0_0= '\\u00B0nothing' ) )? ( (lv_value_1_0= RULE_RAW_METADATE ) )
            {
            // InternalMIC.g:290:3: ( (lv_name_0_0= '\\u00B0nothing' ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==15) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMIC.g:291:4: (lv_name_0_0= '\\u00B0nothing' )
                    {
                    // InternalMIC.g:291:4: (lv_name_0_0= '\\u00B0nothing' )
                    // InternalMIC.g:292:5: lv_name_0_0= '\\u00B0nothing'
                    {
                    lv_name_0_0=(Token)match(input,15,FOLLOW_11); 

                    					newLeafNode(lv_name_0_0, grammarAccess.getMetaDataAccess().getNameNothingKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getMetaDataRule());
                    					}
                    					setWithLastConsumed(current, "name", lv_name_0_0, "\u00B0nothing");
                    				

                    }


                    }
                    break;

            }

            // InternalMIC.g:304:3: ( (lv_value_1_0= RULE_RAW_METADATE ) )
            // InternalMIC.g:305:4: (lv_value_1_0= RULE_RAW_METADATE )
            {
            // InternalMIC.g:305:4: (lv_value_1_0= RULE_RAW_METADATE )
            // InternalMIC.g:306:5: lv_value_1_0= RULE_RAW_METADATE
            {
            lv_value_1_0=(Token)match(input,RULE_RAW_METADATE,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getMetaDataAccess().getValueRAW_METADATETerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetaDataRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"de.wisag.automation.micas.MIC.RAW_METADATE");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetaData"


    // $ANTLR start "entryRuleWordValue"
    // InternalMIC.g:326:1: entryRuleWordValue returns [EObject current=null] : iv_ruleWordValue= ruleWordValue EOF ;
    public final EObject entryRuleWordValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWordValue = null;


        try {
            // InternalMIC.g:326:50: (iv_ruleWordValue= ruleWordValue EOF )
            // InternalMIC.g:327:2: iv_ruleWordValue= ruleWordValue EOF
            {
             newCompositeNode(grammarAccess.getWordValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWordValue=ruleWordValue();

            state._fsp--;

             current =iv_ruleWordValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWordValue"


    // $ANTLR start "ruleWordValue"
    // InternalMIC.g:333:1: ruleWordValue returns [EObject current=null] : (this_WordVar_0= ruleWordVar | this_WordConst_1= ruleWordConst ) ;
    public final EObject ruleWordValue() throws RecognitionException {
        EObject current = null;

        EObject this_WordVar_0 = null;

        EObject this_WordConst_1 = null;



        	enterRule();

        try {
            // InternalMIC.g:339:2: ( (this_WordVar_0= ruleWordVar | this_WordConst_1= ruleWordConst ) )
            // InternalMIC.g:340:2: (this_WordVar_0= ruleWordVar | this_WordConst_1= ruleWordConst )
            {
            // InternalMIC.g:340:2: (this_WordVar_0= ruleWordVar | this_WordConst_1= ruleWordConst )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==16) ) {
                alt6=1;
            }
            else if ( (LA6_0==17) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMIC.g:341:3: this_WordVar_0= ruleWordVar
                    {

                    			newCompositeNode(grammarAccess.getWordValueAccess().getWordVarParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_WordVar_0=ruleWordVar();

                    state._fsp--;


                    			current = this_WordVar_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIC.g:350:3: this_WordConst_1= ruleWordConst
                    {

                    			newCompositeNode(grammarAccess.getWordValueAccess().getWordConstParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_WordConst_1=ruleWordConst();

                    state._fsp--;


                    			current = this_WordConst_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWordValue"


    // $ANTLR start "entryRuleWordVar"
    // InternalMIC.g:362:1: entryRuleWordVar returns [EObject current=null] : iv_ruleWordVar= ruleWordVar EOF ;
    public final EObject entryRuleWordVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWordVar = null;


        try {
            // InternalMIC.g:362:48: (iv_ruleWordVar= ruleWordVar EOF )
            // InternalMIC.g:363:2: iv_ruleWordVar= ruleWordVar EOF
            {
             newCompositeNode(grammarAccess.getWordVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWordVar=ruleWordVar();

            state._fsp--;

             current =iv_ruleWordVar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWordVar"


    // $ANTLR start "ruleWordVar"
    // InternalMIC.g:369:1: ruleWordVar returns [EObject current=null] : (otherlv_0= 'WordV' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleWordVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMIC.g:375:2: ( (otherlv_0= 'WordV' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMIC.g:376:2: (otherlv_0= 'WordV' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMIC.g:376:2: (otherlv_0= 'WordV' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMIC.g:377:3: otherlv_0= 'WordV' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getWordVarAccess().getWordVKeyword_0());
            		
            // InternalMIC.g:381:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:382:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:382:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:383:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWordVarAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWordVarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWordVar"


    // $ANTLR start "entryRuleWordConst"
    // InternalMIC.g:403:1: entryRuleWordConst returns [EObject current=null] : iv_ruleWordConst= ruleWordConst EOF ;
    public final EObject entryRuleWordConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWordConst = null;


        try {
            // InternalMIC.g:403:50: (iv_ruleWordConst= ruleWordConst EOF )
            // InternalMIC.g:404:2: iv_ruleWordConst= ruleWordConst EOF
            {
             newCompositeNode(grammarAccess.getWordConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWordConst=ruleWordConst();

            state._fsp--;

             current =iv_ruleWordConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWordConst"


    // $ANTLR start "ruleWordConst"
    // InternalMIC.g:410:1: ruleWordConst returns [EObject current=null] : (otherlv_0= 'WordK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleWordConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_value_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIC.g:416:2: ( (otherlv_0= 'WordK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalMIC.g:417:2: (otherlv_0= 'WordK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalMIC.g:417:2: (otherlv_0= 'WordK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalMIC.g:418:3: otherlv_0= 'WordK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,17,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getWordConstAccess().getWordKKeyword_0());
            		
            // InternalMIC.g:422:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:423:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:423:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:424:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getWordConstAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWordConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getWordConstAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:444:3: ( (lv_value_3_0= RULE_INT ) )
            // InternalMIC.g:445:4: (lv_value_3_0= RULE_INT )
            {
            // InternalMIC.g:445:4: (lv_value_3_0= RULE_INT )
            // InternalMIC.g:446:5: lv_value_3_0= RULE_INT
            {
            lv_value_3_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_value_3_0, grammarAccess.getWordConstAccess().getValueINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWordConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_3_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getWordConstAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWordConst"


    // $ANTLR start "entryRuleFloatValue"
    // InternalMIC.g:470:1: entryRuleFloatValue returns [EObject current=null] : iv_ruleFloatValue= ruleFloatValue EOF ;
    public final EObject entryRuleFloatValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatValue = null;


        try {
            // InternalMIC.g:470:51: (iv_ruleFloatValue= ruleFloatValue EOF )
            // InternalMIC.g:471:2: iv_ruleFloatValue= ruleFloatValue EOF
            {
             newCompositeNode(grammarAccess.getFloatValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatValue=ruleFloatValue();

            state._fsp--;

             current =iv_ruleFloatValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatValue"


    // $ANTLR start "ruleFloatValue"
    // InternalMIC.g:477:1: ruleFloatValue returns [EObject current=null] : (this_FloatVar_0= ruleFloatVar | this_FloatConst_1= ruleFloatConst ) ;
    public final EObject ruleFloatValue() throws RecognitionException {
        EObject current = null;

        EObject this_FloatVar_0 = null;

        EObject this_FloatConst_1 = null;



        	enterRule();

        try {
            // InternalMIC.g:483:2: ( (this_FloatVar_0= ruleFloatVar | this_FloatConst_1= ruleFloatConst ) )
            // InternalMIC.g:484:2: (this_FloatVar_0= ruleFloatVar | this_FloatConst_1= ruleFloatConst )
            {
            // InternalMIC.g:484:2: (this_FloatVar_0= ruleFloatVar | this_FloatConst_1= ruleFloatConst )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            else if ( (LA7_0==19) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalMIC.g:485:3: this_FloatVar_0= ruleFloatVar
                    {

                    			newCompositeNode(grammarAccess.getFloatValueAccess().getFloatVarParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatVar_0=ruleFloatVar();

                    state._fsp--;


                    			current = this_FloatVar_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIC.g:494:3: this_FloatConst_1= ruleFloatConst
                    {

                    			newCompositeNode(grammarAccess.getFloatValueAccess().getFloatConstParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatConst_1=ruleFloatConst();

                    state._fsp--;


                    			current = this_FloatConst_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatValue"


    // $ANTLR start "entryRuleFloatVar"
    // InternalMIC.g:506:1: entryRuleFloatVar returns [EObject current=null] : iv_ruleFloatVar= ruleFloatVar EOF ;
    public final EObject entryRuleFloatVar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatVar = null;


        try {
            // InternalMIC.g:506:49: (iv_ruleFloatVar= ruleFloatVar EOF )
            // InternalMIC.g:507:2: iv_ruleFloatVar= ruleFloatVar EOF
            {
             newCompositeNode(grammarAccess.getFloatVarRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatVar=ruleFloatVar();

            state._fsp--;

             current =iv_ruleFloatVar; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatVar"


    // $ANTLR start "ruleFloatVar"
    // InternalMIC.g:513:1: ruleFloatVar returns [EObject current=null] : (otherlv_0= 'FloatV' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFloatVar() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;


        	enterRule();

        try {
            // InternalMIC.g:519:2: ( (otherlv_0= 'FloatV' ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalMIC.g:520:2: (otherlv_0= 'FloatV' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalMIC.g:520:2: (otherlv_0= 'FloatV' ( (lv_name_1_0= RULE_ID ) ) )
            // InternalMIC.g:521:3: otherlv_0= 'FloatV' ( (lv_name_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFloatVarAccess().getFloatVKeyword_0());
            		
            // InternalMIC.g:525:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:526:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:526:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:527:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFloatVarAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFloatVarRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatVar"


    // $ANTLR start "entryRuleFloatConst"
    // InternalMIC.g:547:1: entryRuleFloatConst returns [EObject current=null] : iv_ruleFloatConst= ruleFloatConst EOF ;
    public final EObject entryRuleFloatConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatConst = null;


        try {
            // InternalMIC.g:547:51: (iv_ruleFloatConst= ruleFloatConst EOF )
            // InternalMIC.g:548:2: iv_ruleFloatConst= ruleFloatConst EOF
            {
             newCompositeNode(grammarAccess.getFloatConstRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatConst=ruleFloatConst();

            state._fsp--;

             current =iv_ruleFloatConst; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatConst"


    // $ANTLR start "ruleFloatConst"
    // InternalMIC.g:554:1: ruleFloatConst returns [EObject current=null] : (otherlv_0= 'FloatK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= ruleFloat ) ) otherlv_4= ')' ) ;
    public final EObject ruleFloatConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalMIC.g:560:2: ( (otherlv_0= 'FloatK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= ruleFloat ) ) otherlv_4= ')' ) )
            // InternalMIC.g:561:2: (otherlv_0= 'FloatK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= ruleFloat ) ) otherlv_4= ')' )
            {
            // InternalMIC.g:561:2: (otherlv_0= 'FloatK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= ruleFloat ) ) otherlv_4= ')' )
            // InternalMIC.g:562:3: otherlv_0= 'FloatK' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_value_3_0= ruleFloat ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFloatConstAccess().getFloatKKeyword_0());
            		
            // InternalMIC.g:566:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:567:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:567:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:568:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFloatConstAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFloatConstRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_12); 

            			newLeafNode(otherlv_2, grammarAccess.getFloatConstAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:588:3: ( (lv_value_3_0= ruleFloat ) )
            // InternalMIC.g:589:4: (lv_value_3_0= ruleFloat )
            {
            // InternalMIC.g:589:4: (lv_value_3_0= ruleFloat )
            // InternalMIC.g:590:5: lv_value_3_0= ruleFloat
            {

            					newCompositeNode(grammarAccess.getFloatConstAccess().getValueFloatParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_8);
            lv_value_3_0=ruleFloat();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getFloatConstRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"de.wisag.automation.micas.MIC.Float");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFloatConstAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatConst"


    // $ANTLR start "entryRuleDirectValue"
    // InternalMIC.g:615:1: entryRuleDirectValue returns [EObject current=null] : iv_ruleDirectValue= ruleDirectValue EOF ;
    public final EObject entryRuleDirectValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDirectValue = null;


        try {
            // InternalMIC.g:615:52: (iv_ruleDirectValue= ruleDirectValue EOF )
            // InternalMIC.g:616:2: iv_ruleDirectValue= ruleDirectValue EOF
            {
             newCompositeNode(grammarAccess.getDirectValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDirectValue=ruleDirectValue();

            state._fsp--;

             current =iv_ruleDirectValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDirectValue"


    // $ANTLR start "ruleDirectValue"
    // InternalMIC.g:622:1: ruleDirectValue returns [EObject current=null] : ( (lv_value_0_0= RULE_INT ) ) ;
    public final EObject ruleDirectValue() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalMIC.g:628:2: ( ( (lv_value_0_0= RULE_INT ) ) )
            // InternalMIC.g:629:2: ( (lv_value_0_0= RULE_INT ) )
            {
            // InternalMIC.g:629:2: ( (lv_value_0_0= RULE_INT ) )
            // InternalMIC.g:630:3: (lv_value_0_0= RULE_INT )
            {
            // InternalMIC.g:630:3: (lv_value_0_0= RULE_INT )
            // InternalMIC.g:631:4: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getDirectValueAccess().getValueINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getDirectValueRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"de.wisag.automation.micas.MIC.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDirectValue"


    // $ANTLR start "entryRuleReference"
    // InternalMIC.g:650:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // InternalMIC.g:650:50: (iv_ruleReference= ruleReference EOF )
            // InternalMIC.g:651:2: iv_ruleReference= ruleReference EOF
            {
             newCompositeNode(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReference=ruleReference();

            state._fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalMIC.g:657:1: ruleReference returns [EObject current=null] : (this_FGAMessageConstantReference_0= ruleFGAMessageConstantReference | this_FGAAnalogValueReference_1= ruleFGAAnalogValueReference | this_FGAValueReference_2= ruleFGAValueReference | this_FGAMeasuredValueReference_3= ruleFGAMeasuredValueReference ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        EObject this_FGAMessageConstantReference_0 = null;

        EObject this_FGAAnalogValueReference_1 = null;

        EObject this_FGAValueReference_2 = null;

        EObject this_FGAMeasuredValueReference_3 = null;



        	enterRule();

        try {
            // InternalMIC.g:663:2: ( (this_FGAMessageConstantReference_0= ruleFGAMessageConstantReference | this_FGAAnalogValueReference_1= ruleFGAAnalogValueReference | this_FGAValueReference_2= ruleFGAValueReference | this_FGAMeasuredValueReference_3= ruleFGAMeasuredValueReference ) )
            // InternalMIC.g:664:2: (this_FGAMessageConstantReference_0= ruleFGAMessageConstantReference | this_FGAAnalogValueReference_1= ruleFGAAnalogValueReference | this_FGAValueReference_2= ruleFGAValueReference | this_FGAMeasuredValueReference_3= ruleFGAMeasuredValueReference )
            {
            // InternalMIC.g:664:2: (this_FGAMessageConstantReference_0= ruleFGAMessageConstantReference | this_FGAAnalogValueReference_1= ruleFGAAnalogValueReference | this_FGAValueReference_2= ruleFGAValueReference | this_FGAMeasuredValueReference_3= ruleFGAMeasuredValueReference )
            int alt8=4;
            switch ( input.LA(1) ) {
            case 20:
                {
                alt8=1;
                }
                break;
            case 21:
                {
                alt8=2;
                }
                break;
            case 22:
                {
                alt8=3;
                }
                break;
            case 23:
                {
                alt8=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalMIC.g:665:3: this_FGAMessageConstantReference_0= ruleFGAMessageConstantReference
                    {

                    			newCompositeNode(grammarAccess.getReferenceAccess().getFGAMessageConstantReferenceParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_FGAMessageConstantReference_0=ruleFGAMessageConstantReference();

                    state._fsp--;


                    			current = this_FGAMessageConstantReference_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIC.g:674:3: this_FGAAnalogValueReference_1= ruleFGAAnalogValueReference
                    {

                    			newCompositeNode(grammarAccess.getReferenceAccess().getFGAAnalogValueReferenceParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_FGAAnalogValueReference_1=ruleFGAAnalogValueReference();

                    state._fsp--;


                    			current = this_FGAAnalogValueReference_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMIC.g:683:3: this_FGAValueReference_2= ruleFGAValueReference
                    {

                    			newCompositeNode(grammarAccess.getReferenceAccess().getFGAValueReferenceParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_FGAValueReference_2=ruleFGAValueReference();

                    state._fsp--;


                    			current = this_FGAValueReference_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMIC.g:692:3: this_FGAMeasuredValueReference_3= ruleFGAMeasuredValueReference
                    {

                    			newCompositeNode(grammarAccess.getReferenceAccess().getFGAMeasuredValueReferenceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_FGAMeasuredValueReference_3=ruleFGAMeasuredValueReference();

                    state._fsp--;


                    			current = this_FGAMeasuredValueReference_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleFGAMessageConstantReference"
    // InternalMIC.g:704:1: entryRuleFGAMessageConstantReference returns [EObject current=null] : iv_ruleFGAMessageConstantReference= ruleFGAMessageConstantReference EOF ;
    public final EObject entryRuleFGAMessageConstantReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFGAMessageConstantReference = null;


        try {
            // InternalMIC.g:704:68: (iv_ruleFGAMessageConstantReference= ruleFGAMessageConstantReference EOF )
            // InternalMIC.g:705:2: iv_ruleFGAMessageConstantReference= ruleFGAMessageConstantReference EOF
            {
             newCompositeNode(grammarAccess.getFGAMessageConstantReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFGAMessageConstantReference=ruleFGAMessageConstantReference();

            state._fsp--;

             current =iv_ruleFGAMessageConstantReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFGAMessageConstantReference"


    // $ANTLR start "ruleFGAMessageConstantReference"
    // InternalMIC.g:711:1: ruleFGAMessageConstantReference returns [EObject current=null] : (otherlv_0= 'IPAMB' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ')' ) ;
    public final EObject ruleFGAMessageConstantReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_row_3_0=null;
        Token otherlv_4=null;
        Token lv_column_5_0=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalMIC.g:717:2: ( (otherlv_0= 'IPAMB' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ')' ) )
            // InternalMIC.g:718:2: (otherlv_0= 'IPAMB' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ')' )
            {
            // InternalMIC.g:718:2: (otherlv_0= 'IPAMB' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ')' )
            // InternalMIC.g:719:3: otherlv_0= 'IPAMB' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_column_5_0= RULE_INT ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFGAMessageConstantReferenceAccess().getIPAMBKeyword_0());
            		
            // InternalMIC.g:723:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:724:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:724:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:725:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFGAMessageConstantReferenceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAMessageConstantReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getFGAMessageConstantReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:745:3: ( (lv_row_3_0= RULE_INT ) )
            // InternalMIC.g:746:4: (lv_row_3_0= RULE_INT )
            {
            // InternalMIC.g:746:4: (lv_row_3_0= RULE_INT )
            // InternalMIC.g:747:5: lv_row_3_0= RULE_INT
            {
            lv_row_3_0=(Token)match(input,RULE_INT,FOLLOW_6); 

            					newLeafNode(lv_row_3_0, grammarAccess.getFGAMessageConstantReferenceAccess().getRowINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAMessageConstantReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"row",
            						lv_row_3_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_7); 

            			newLeafNode(otherlv_4, grammarAccess.getFGAMessageConstantReferenceAccess().getCommaKeyword_4());
            		
            // InternalMIC.g:767:3: ( (lv_column_5_0= RULE_INT ) )
            // InternalMIC.g:768:4: (lv_column_5_0= RULE_INT )
            {
            // InternalMIC.g:768:4: (lv_column_5_0= RULE_INT )
            // InternalMIC.g:769:5: lv_column_5_0= RULE_INT
            {
            lv_column_5_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_column_5_0, grammarAccess.getFGAMessageConstantReferenceAccess().getColumnINTTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAMessageConstantReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"column",
            						lv_column_5_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_6=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getFGAMessageConstantReferenceAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFGAMessageConstantReference"


    // $ANTLR start "entryRuleFGAAnalogValueReference"
    // InternalMIC.g:793:1: entryRuleFGAAnalogValueReference returns [EObject current=null] : iv_ruleFGAAnalogValueReference= ruleFGAAnalogValueReference EOF ;
    public final EObject entryRuleFGAAnalogValueReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFGAAnalogValueReference = null;


        try {
            // InternalMIC.g:793:64: (iv_ruleFGAAnalogValueReference= ruleFGAAnalogValueReference EOF )
            // InternalMIC.g:794:2: iv_ruleFGAAnalogValueReference= ruleFGAAnalogValueReference EOF
            {
             newCompositeNode(grammarAccess.getFGAAnalogValueReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFGAAnalogValueReference=ruleFGAAnalogValueReference();

            state._fsp--;

             current =iv_ruleFGAAnalogValueReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFGAAnalogValueReference"


    // $ANTLR start "ruleFGAAnalogValueReference"
    // InternalMIC.g:800:1: ruleFGAAnalogValueReference returns [EObject current=null] : (otherlv_0= 'IPAAW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleFGAAnalogValueReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_row_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIC.g:806:2: ( (otherlv_0= 'IPAAW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalMIC.g:807:2: (otherlv_0= 'IPAAW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalMIC.g:807:2: (otherlv_0= 'IPAAW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalMIC.g:808:3: otherlv_0= 'IPAAW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFGAAnalogValueReferenceAccess().getIPAAWKeyword_0());
            		
            // InternalMIC.g:812:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:813:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:813:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:814:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFGAAnalogValueReferenceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAAnalogValueReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getFGAAnalogValueReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:834:3: ( (lv_row_3_0= RULE_INT ) )
            // InternalMIC.g:835:4: (lv_row_3_0= RULE_INT )
            {
            // InternalMIC.g:835:4: (lv_row_3_0= RULE_INT )
            // InternalMIC.g:836:5: lv_row_3_0= RULE_INT
            {
            lv_row_3_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_row_3_0, grammarAccess.getFGAAnalogValueReferenceAccess().getRowINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAAnalogValueReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"row",
            						lv_row_3_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFGAAnalogValueReferenceAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFGAAnalogValueReference"


    // $ANTLR start "entryRuleFGAValueReference"
    // InternalMIC.g:860:1: entryRuleFGAValueReference returns [EObject current=null] : iv_ruleFGAValueReference= ruleFGAValueReference EOF ;
    public final EObject entryRuleFGAValueReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFGAValueReference = null;


        try {
            // InternalMIC.g:860:58: (iv_ruleFGAValueReference= ruleFGAValueReference EOF )
            // InternalMIC.g:861:2: iv_ruleFGAValueReference= ruleFGAValueReference EOF
            {
             newCompositeNode(grammarAccess.getFGAValueReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFGAValueReference=ruleFGAValueReference();

            state._fsp--;

             current =iv_ruleFGAValueReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFGAValueReference"


    // $ANTLR start "ruleFGAValueReference"
    // InternalMIC.g:867:1: ruleFGAValueReference returns [EObject current=null] : (otherlv_0= 'IPAZW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleFGAValueReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_row_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIC.g:873:2: ( (otherlv_0= 'IPAZW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalMIC.g:874:2: (otherlv_0= 'IPAZW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalMIC.g:874:2: (otherlv_0= 'IPAZW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalMIC.g:875:3: otherlv_0= 'IPAZW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFGAValueReferenceAccess().getIPAZWKeyword_0());
            		
            // InternalMIC.g:879:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:880:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:880:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:881:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFGAValueReferenceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAValueReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getFGAValueReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:901:3: ( (lv_row_3_0= RULE_INT ) )
            // InternalMIC.g:902:4: (lv_row_3_0= RULE_INT )
            {
            // InternalMIC.g:902:4: (lv_row_3_0= RULE_INT )
            // InternalMIC.g:903:5: lv_row_3_0= RULE_INT
            {
            lv_row_3_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_row_3_0, grammarAccess.getFGAValueReferenceAccess().getRowINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAValueReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"row",
            						lv_row_3_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFGAValueReferenceAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFGAValueReference"


    // $ANTLR start "entryRuleFGAMeasuredValueReference"
    // InternalMIC.g:927:1: entryRuleFGAMeasuredValueReference returns [EObject current=null] : iv_ruleFGAMeasuredValueReference= ruleFGAMeasuredValueReference EOF ;
    public final EObject entryRuleFGAMeasuredValueReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFGAMeasuredValueReference = null;


        try {
            // InternalMIC.g:927:66: (iv_ruleFGAMeasuredValueReference= ruleFGAMeasuredValueReference EOF )
            // InternalMIC.g:928:2: iv_ruleFGAMeasuredValueReference= ruleFGAMeasuredValueReference EOF
            {
             newCompositeNode(grammarAccess.getFGAMeasuredValueReferenceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFGAMeasuredValueReference=ruleFGAMeasuredValueReference();

            state._fsp--;

             current =iv_ruleFGAMeasuredValueReference; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFGAMeasuredValueReference"


    // $ANTLR start "ruleFGAMeasuredValueReference"
    // InternalMIC.g:934:1: ruleFGAMeasuredValueReference returns [EObject current=null] : (otherlv_0= 'IPAMW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) ;
    public final EObject ruleFGAMeasuredValueReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_row_3_0=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalMIC.g:940:2: ( (otherlv_0= 'IPAMW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' ) )
            // InternalMIC.g:941:2: (otherlv_0= 'IPAMW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
            {
            // InternalMIC.g:941:2: (otherlv_0= 'IPAMW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')' )
            // InternalMIC.g:942:3: otherlv_0= 'IPAMW' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_row_3_0= RULE_INT ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getFGAMeasuredValueReferenceAccess().getIPAMWKeyword_0());
            		
            // InternalMIC.g:946:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMIC.g:947:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMIC.g:947:4: (lv_name_1_0= RULE_ID )
            // InternalMIC.g:948:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_name_1_0, grammarAccess.getFGAMeasuredValueReferenceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAMeasuredValueReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,11,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getFGAMeasuredValueReferenceAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:968:3: ( (lv_row_3_0= RULE_INT ) )
            // InternalMIC.g:969:4: (lv_row_3_0= RULE_INT )
            {
            // InternalMIC.g:969:4: (lv_row_3_0= RULE_INT )
            // InternalMIC.g:970:5: lv_row_3_0= RULE_INT
            {
            lv_row_3_0=(Token)match(input,RULE_INT,FOLLOW_8); 

            					newLeafNode(lv_row_3_0, grammarAccess.getFGAMeasuredValueReferenceAccess().getRowINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFGAMeasuredValueReferenceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"row",
            						lv_row_3_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getFGAMeasuredValueReferenceAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFGAMeasuredValueReference"


    // $ANTLR start "entryRuleTask"
    // InternalMIC.g:994:1: entryRuleTask returns [EObject current=null] : iv_ruleTask= ruleTask EOF ;
    public final EObject entryRuleTask() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTask = null;


        try {
            // InternalMIC.g:994:45: (iv_ruleTask= ruleTask EOF )
            // InternalMIC.g:995:2: iv_ruleTask= ruleTask EOF
            {
             newCompositeNode(grammarAccess.getTaskRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTask=ruleTask();

            state._fsp--;

             current =iv_ruleTask; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTask"


    // $ANTLR start "ruleTask"
    // InternalMIC.g:1001:1: ruleTask returns [EObject current=null] : ( ( (lv_taskProlog_0_0= ruleMetaData ) )* otherlv_1= 'TASK' otherlv_2= '(' ( (lv_index_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_type_5_0= ruleTaskStrategy ) ) (otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) ) )? otherlv_8= ')' ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= 'ENDE' ) ;
    public final EObject ruleTask() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_index_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token lv_cycleTime_7_0=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_taskProlog_0_0 = null;

        AntlrDatatypeRuleToken lv_type_5_0 = null;

        EObject lv_instructions_9_0 = null;



        	enterRule();

        try {
            // InternalMIC.g:1007:2: ( ( ( (lv_taskProlog_0_0= ruleMetaData ) )* otherlv_1= 'TASK' otherlv_2= '(' ( (lv_index_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_type_5_0= ruleTaskStrategy ) ) (otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) ) )? otherlv_8= ')' ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= 'ENDE' ) )
            // InternalMIC.g:1008:2: ( ( (lv_taskProlog_0_0= ruleMetaData ) )* otherlv_1= 'TASK' otherlv_2= '(' ( (lv_index_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_type_5_0= ruleTaskStrategy ) ) (otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) ) )? otherlv_8= ')' ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= 'ENDE' )
            {
            // InternalMIC.g:1008:2: ( ( (lv_taskProlog_0_0= ruleMetaData ) )* otherlv_1= 'TASK' otherlv_2= '(' ( (lv_index_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_type_5_0= ruleTaskStrategy ) ) (otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) ) )? otherlv_8= ')' ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= 'ENDE' )
            // InternalMIC.g:1009:3: ( (lv_taskProlog_0_0= ruleMetaData ) )* otherlv_1= 'TASK' otherlv_2= '(' ( (lv_index_3_0= RULE_INT ) ) otherlv_4= ',' ( (lv_type_5_0= ruleTaskStrategy ) ) (otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) ) )? otherlv_8= ')' ( (lv_instructions_9_0= ruleInstruction ) )* otherlv_10= 'ENDE'
            {
            // InternalMIC.g:1009:3: ( (lv_taskProlog_0_0= ruleMetaData ) )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==RULE_RAW_METADATE||LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMIC.g:1010:4: (lv_taskProlog_0_0= ruleMetaData )
            	    {
            	    // InternalMIC.g:1010:4: (lv_taskProlog_0_0= ruleMetaData )
            	    // InternalMIC.g:1011:5: lv_taskProlog_0_0= ruleMetaData
            	    {

            	    					newCompositeNode(grammarAccess.getTaskAccess().getTaskPrologMetaDataParserRuleCall_0_0());
            	    				
            	    pushFollow(FOLLOW_13);
            	    lv_taskProlog_0_0=ruleMetaData();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTaskRule());
            	    					}
            	    					add(
            	    						current,
            	    						"taskProlog",
            	    						lv_taskProlog_0_0,
            	    						"de.wisag.automation.micas.MIC.MetaData");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            otherlv_1=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_1, grammarAccess.getTaskAccess().getTASKKeyword_1());
            		
            otherlv_2=(Token)match(input,11,FOLLOW_7); 

            			newLeafNode(otherlv_2, grammarAccess.getTaskAccess().getLeftParenthesisKeyword_2());
            		
            // InternalMIC.g:1036:3: ( (lv_index_3_0= RULE_INT ) )
            // InternalMIC.g:1037:4: (lv_index_3_0= RULE_INT )
            {
            // InternalMIC.g:1037:4: (lv_index_3_0= RULE_INT )
            // InternalMIC.g:1038:5: lv_index_3_0= RULE_INT
            {
            lv_index_3_0=(Token)match(input,RULE_INT,FOLLOW_6); 

            					newLeafNode(lv_index_3_0, grammarAccess.getTaskAccess().getIndexINTTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTaskRule());
            					}
            					setWithLastConsumed(
            						current,
            						"index",
            						lv_index_3_0,
            						"de.wisag.automation.micas.MIC.INT");
            				

            }


            }

            otherlv_4=(Token)match(input,12,FOLLOW_14); 

            			newLeafNode(otherlv_4, grammarAccess.getTaskAccess().getCommaKeyword_4());
            		
            // InternalMIC.g:1058:3: ( (lv_type_5_0= ruleTaskStrategy ) )
            // InternalMIC.g:1059:4: (lv_type_5_0= ruleTaskStrategy )
            {
            // InternalMIC.g:1059:4: (lv_type_5_0= ruleTaskStrategy )
            // InternalMIC.g:1060:5: lv_type_5_0= ruleTaskStrategy
            {

            					newCompositeNode(grammarAccess.getTaskAccess().getTypeTaskStrategyParserRuleCall_5_0());
            				
            pushFollow(FOLLOW_15);
            lv_type_5_0=ruleTaskStrategy();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTaskRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_5_0,
            						"de.wisag.automation.micas.MIC.TaskStrategy");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMIC.g:1077:3: (otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==12) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMIC.g:1078:4: otherlv_6= ',' ( (lv_cycleTime_7_0= RULE_INT ) )
                    {
                    otherlv_6=(Token)match(input,12,FOLLOW_7); 

                    				newLeafNode(otherlv_6, grammarAccess.getTaskAccess().getCommaKeyword_6_0());
                    			
                    // InternalMIC.g:1082:4: ( (lv_cycleTime_7_0= RULE_INT ) )
                    // InternalMIC.g:1083:5: (lv_cycleTime_7_0= RULE_INT )
                    {
                    // InternalMIC.g:1083:5: (lv_cycleTime_7_0= RULE_INT )
                    // InternalMIC.g:1084:6: lv_cycleTime_7_0= RULE_INT
                    {
                    lv_cycleTime_7_0=(Token)match(input,RULE_INT,FOLLOW_8); 

                    						newLeafNode(lv_cycleTime_7_0, grammarAccess.getTaskAccess().getCycleTimeINTTerminalRuleCall_6_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTaskRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"cycleTime",
                    							lv_cycleTime_7_0,
                    							"de.wisag.automation.micas.MIC.INT");
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_8=(Token)match(input,13,FOLLOW_16); 

            			newLeafNode(otherlv_8, grammarAccess.getTaskAccess().getRightParenthesisKeyword_7());
            		
            // InternalMIC.g:1105:3: ( (lv_instructions_9_0= ruleInstruction ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==RULE_ID||LA11_0==RULE_RAW_METADATE||LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalMIC.g:1106:4: (lv_instructions_9_0= ruleInstruction )
            	    {
            	    // InternalMIC.g:1106:4: (lv_instructions_9_0= ruleInstruction )
            	    // InternalMIC.g:1107:5: lv_instructions_9_0= ruleInstruction
            	    {

            	    					newCompositeNode(grammarAccess.getTaskAccess().getInstructionsInstructionParserRuleCall_8_0());
            	    				
            	    pushFollow(FOLLOW_16);
            	    lv_instructions_9_0=ruleInstruction();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTaskRule());
            	    					}
            	    					add(
            	    						current,
            	    						"instructions",
            	    						lv_instructions_9_0,
            	    						"de.wisag.automation.micas.MIC.Instruction");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_10=(Token)match(input,25,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getTaskAccess().getENDEKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTask"


    // $ANTLR start "entryRuleInstruction"
    // InternalMIC.g:1132:1: entryRuleInstruction returns [EObject current=null] : iv_ruleInstruction= ruleInstruction EOF ;
    public final EObject entryRuleInstruction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInstruction = null;


        try {
            // InternalMIC.g:1132:52: (iv_ruleInstruction= ruleInstruction EOF )
            // InternalMIC.g:1133:2: iv_ruleInstruction= ruleInstruction EOF
            {
             newCompositeNode(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInstruction=ruleInstruction();

            state._fsp--;

             current =iv_ruleInstruction; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalMIC.g:1139:1: ruleInstruction returns [EObject current=null] : (this_ModuleInvokation_0= ruleModuleInvokation | this_MetaData_1= ruleMetaData ) ;
    public final EObject ruleInstruction() throws RecognitionException {
        EObject current = null;

        EObject this_ModuleInvokation_0 = null;

        EObject this_MetaData_1 = null;



        	enterRule();

        try {
            // InternalMIC.g:1145:2: ( (this_ModuleInvokation_0= ruleModuleInvokation | this_MetaData_1= ruleMetaData ) )
            // InternalMIC.g:1146:2: (this_ModuleInvokation_0= ruleModuleInvokation | this_MetaData_1= ruleMetaData )
            {
            // InternalMIC.g:1146:2: (this_ModuleInvokation_0= ruleModuleInvokation | this_MetaData_1= ruleMetaData )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                alt12=1;
            }
            else if ( (LA12_0==RULE_RAW_METADATE||LA12_0==15) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalMIC.g:1147:3: this_ModuleInvokation_0= ruleModuleInvokation
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getModuleInvokationParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ModuleInvokation_0=ruleModuleInvokation();

                    state._fsp--;


                    			current = this_ModuleInvokation_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMIC.g:1156:3: this_MetaData_1= ruleMetaData
                    {

                    			newCompositeNode(grammarAccess.getInstructionAccess().getMetaDataParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_MetaData_1=ruleMetaData();

                    state._fsp--;


                    			current = this_MetaData_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleModuleInvokation"
    // InternalMIC.g:1168:1: entryRuleModuleInvokation returns [EObject current=null] : iv_ruleModuleInvokation= ruleModuleInvokation EOF ;
    public final EObject entryRuleModuleInvokation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleInvokation = null;


        try {
            // InternalMIC.g:1168:57: (iv_ruleModuleInvokation= ruleModuleInvokation EOF )
            // InternalMIC.g:1169:2: iv_ruleModuleInvokation= ruleModuleInvokation EOF
            {
             newCompositeNode(grammarAccess.getModuleInvokationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModuleInvokation=ruleModuleInvokation();

            state._fsp--;

             current =iv_ruleModuleInvokation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleInvokation"


    // $ANTLR start "ruleModuleInvokation"
    // InternalMIC.g:1175:1: ruleModuleInvokation returns [EObject current=null] : ( ( (lv_moduleName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleModuleInvokation() throws RecognitionException {
        EObject current = null;

        Token lv_moduleName_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;



        	enterRule();

        try {
            // InternalMIC.g:1181:2: ( ( ( (lv_moduleName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )* )? otherlv_5= ')' ) )
            // InternalMIC.g:1182:2: ( ( (lv_moduleName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )* )? otherlv_5= ')' )
            {
            // InternalMIC.g:1182:2: ( ( (lv_moduleName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )* )? otherlv_5= ')' )
            // InternalMIC.g:1183:3: ( (lv_moduleName_0_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )* )? otherlv_5= ')'
            {
            // InternalMIC.g:1183:3: ( (lv_moduleName_0_0= RULE_ID ) )
            // InternalMIC.g:1184:4: (lv_moduleName_0_0= RULE_ID )
            {
            // InternalMIC.g:1184:4: (lv_moduleName_0_0= RULE_ID )
            // InternalMIC.g:1185:5: lv_moduleName_0_0= RULE_ID
            {
            lv_moduleName_0_0=(Token)match(input,RULE_ID,FOLLOW_4); 

            					newLeafNode(lv_moduleName_0_0, grammarAccess.getModuleInvokationAccess().getModuleNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModuleInvokationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"moduleName",
            						lv_moduleName_0_0,
            						"de.wisag.automation.micas.MIC.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,11,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getModuleInvokationAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMIC.g:1205:3: ( ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_ID && LA14_0<=RULE_INT)||LA14_0==26) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMIC.g:1206:4: ( (lv_arguments_2_0= ruleSymbolAccessor ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )*
                    {
                    // InternalMIC.g:1206:4: ( (lv_arguments_2_0= ruleSymbolAccessor ) )
                    // InternalMIC.g:1207:5: (lv_arguments_2_0= ruleSymbolAccessor )
                    {
                    // InternalMIC.g:1207:5: (lv_arguments_2_0= ruleSymbolAccessor )
                    // InternalMIC.g:1208:6: lv_arguments_2_0= ruleSymbolAccessor
                    {

                    						newCompositeNode(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_15);
                    lv_arguments_2_0=ruleSymbolAccessor();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getModuleInvokationRule());
                    						}
                    						add(
                    							current,
                    							"arguments",
                    							lv_arguments_2_0,
                    							"de.wisag.automation.micas.MIC.SymbolAccessor");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalMIC.g:1225:4: (otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==12) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMIC.g:1226:5: otherlv_3= ',' ( (lv_arguments_4_0= ruleSymbolAccessor ) )
                    	    {
                    	    otherlv_3=(Token)match(input,12,FOLLOW_18); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getModuleInvokationAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMIC.g:1230:5: ( (lv_arguments_4_0= ruleSymbolAccessor ) )
                    	    // InternalMIC.g:1231:6: (lv_arguments_4_0= ruleSymbolAccessor )
                    	    {
                    	    // InternalMIC.g:1231:6: (lv_arguments_4_0= ruleSymbolAccessor )
                    	    // InternalMIC.g:1232:7: lv_arguments_4_0= ruleSymbolAccessor
                    	    {

                    	    							newCompositeNode(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_1_1_0());
                    	    						
                    	    pushFollow(FOLLOW_15);
                    	    lv_arguments_4_0=ruleSymbolAccessor();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getModuleInvokationRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"arguments",
                    	    								lv_arguments_4_0,
                    	    								"de.wisag.automation.micas.MIC.SymbolAccessor");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,13,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getModuleInvokationAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleInvokation"


    // $ANTLR start "entryRuleSymbolAccessor"
    // InternalMIC.g:1259:1: entryRuleSymbolAccessor returns [EObject current=null] : iv_ruleSymbolAccessor= ruleSymbolAccessor EOF ;
    public final EObject entryRuleSymbolAccessor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolAccessor = null;


        try {
            // InternalMIC.g:1259:55: (iv_ruleSymbolAccessor= ruleSymbolAccessor EOF )
            // InternalMIC.g:1260:2: iv_ruleSymbolAccessor= ruleSymbolAccessor EOF
            {
             newCompositeNode(grammarAccess.getSymbolAccessorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSymbolAccessor=ruleSymbolAccessor();

            state._fsp--;

             current =iv_ruleSymbolAccessor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSymbolAccessor"


    // $ANTLR start "ruleSymbolAccessor"
    // InternalMIC.g:1266:1: ruleSymbolAccessor returns [EObject current=null] : ( ( (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) ) ) | this_DirectValue_3= ruleDirectValue ) ;
    public final EObject ruleSymbolAccessor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_writing_1_0=null;
        Token otherlv_2=null;
        EObject this_DirectValue_3 = null;



        	enterRule();

        try {
            // InternalMIC.g:1272:2: ( ( ( (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) ) ) | this_DirectValue_3= ruleDirectValue ) )
            // InternalMIC.g:1273:2: ( ( (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) ) ) | this_DirectValue_3= ruleDirectValue )
            {
            // InternalMIC.g:1273:2: ( ( (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) ) ) | this_DirectValue_3= ruleDirectValue )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID||LA16_0==26) ) {
                alt16=1;
            }
            else if ( (LA16_0==RULE_INT) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // InternalMIC.g:1274:3: ( (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) ) )
                    {
                    // InternalMIC.g:1274:3: ( (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) ) )
                    // InternalMIC.g:1275:4: (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )? ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalMIC.g:1275:4: (otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) ) )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==26) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalMIC.g:1276:5: otherlv_0= 'writeaccess=' ( (lv_writing_1_0= 'true' ) )
                            {
                            otherlv_0=(Token)match(input,26,FOLLOW_19); 

                            					newLeafNode(otherlv_0, grammarAccess.getSymbolAccessorAccess().getWriteaccessKeyword_0_0_0());
                            				
                            // InternalMIC.g:1280:5: ( (lv_writing_1_0= 'true' ) )
                            // InternalMIC.g:1281:6: (lv_writing_1_0= 'true' )
                            {
                            // InternalMIC.g:1281:6: (lv_writing_1_0= 'true' )
                            // InternalMIC.g:1282:7: lv_writing_1_0= 'true'
                            {
                            lv_writing_1_0=(Token)match(input,27,FOLLOW_5); 

                            							newLeafNode(lv_writing_1_0, grammarAccess.getSymbolAccessorAccess().getWritingTrueKeyword_0_0_1_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getSymbolAccessorRule());
                            							}
                            							setWithLastConsumed(current, "writing", true, "true");
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalMIC.g:1295:4: ( (otherlv_2= RULE_ID ) )
                    // InternalMIC.g:1296:5: (otherlv_2= RULE_ID )
                    {
                    // InternalMIC.g:1296:5: (otherlv_2= RULE_ID )
                    // InternalMIC.g:1297:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSymbolAccessorRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getSymbolAccessorAccess().getSymbolSymbolCrossReference_0_1_0());
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:1310:3: this_DirectValue_3= ruleDirectValue
                    {

                    			newCompositeNode(grammarAccess.getSymbolAccessorAccess().getDirectValueParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_DirectValue_3=ruleDirectValue();

                    state._fsp--;


                    			current = this_DirectValue_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSymbolAccessor"


    // $ANTLR start "entryRuleFloat"
    // InternalMIC.g:1322:1: entryRuleFloat returns [String current=null] : iv_ruleFloat= ruleFloat EOF ;
    public final String entryRuleFloat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFloat = null;


        try {
            // InternalMIC.g:1322:45: (iv_ruleFloat= ruleFloat EOF )
            // InternalMIC.g:1323:2: iv_ruleFloat= ruleFloat EOF
            {
             newCompositeNode(grammarAccess.getFloatRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloat=ruleFloat();

            state._fsp--;

             current =iv_ruleFloat.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalMIC.g:1329:1: ruleFloat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_XFLOAT_0= RULE_XFLOAT ;
    public final AntlrDatatypeRuleToken ruleFloat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_XFLOAT_0=null;


        	enterRule();

        try {
            // InternalMIC.g:1335:2: (this_XFLOAT_0= RULE_XFLOAT )
            // InternalMIC.g:1336:2: this_XFLOAT_0= RULE_XFLOAT
            {
            this_XFLOAT_0=(Token)match(input,RULE_XFLOAT,FOLLOW_2); 

            		current.merge(this_XFLOAT_0);
            	

            		newLeafNode(this_XFLOAT_0, grammarAccess.getFloatAccess().getXFLOATTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleTaskStrategy"
    // InternalMIC.g:1346:1: entryRuleTaskStrategy returns [String current=null] : iv_ruleTaskStrategy= ruleTaskStrategy EOF ;
    public final String entryRuleTaskStrategy() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTaskStrategy = null;


        try {
            // InternalMIC.g:1346:52: (iv_ruleTaskStrategy= ruleTaskStrategy EOF )
            // InternalMIC.g:1347:2: iv_ruleTaskStrategy= ruleTaskStrategy EOF
            {
             newCompositeNode(grammarAccess.getTaskStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTaskStrategy=ruleTaskStrategy();

            state._fsp--;

             current =iv_ruleTaskStrategy.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTaskStrategy"


    // $ANTLR start "ruleTaskStrategy"
    // InternalMIC.g:1353:1: ruleTaskStrategy returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'cycl' | kw= 'back' | kw= 'init' | kw= 'cycls' | kw= 'evnts' | kw= 'backs' | kw= 'inits' | kw= 'CYCL' | kw= 'BACK' | kw= 'INIT' | kw= 'CYCLS' | kw= 'EVNTS' | kw= 'BACKS' | kw= 'INITS' ) ;
    public final AntlrDatatypeRuleToken ruleTaskStrategy() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMIC.g:1359:2: ( (kw= 'cycl' | kw= 'back' | kw= 'init' | kw= 'cycls' | kw= 'evnts' | kw= 'backs' | kw= 'inits' | kw= 'CYCL' | kw= 'BACK' | kw= 'INIT' | kw= 'CYCLS' | kw= 'EVNTS' | kw= 'BACKS' | kw= 'INITS' ) )
            // InternalMIC.g:1360:2: (kw= 'cycl' | kw= 'back' | kw= 'init' | kw= 'cycls' | kw= 'evnts' | kw= 'backs' | kw= 'inits' | kw= 'CYCL' | kw= 'BACK' | kw= 'INIT' | kw= 'CYCLS' | kw= 'EVNTS' | kw= 'BACKS' | kw= 'INITS' )
            {
            // InternalMIC.g:1360:2: (kw= 'cycl' | kw= 'back' | kw= 'init' | kw= 'cycls' | kw= 'evnts' | kw= 'backs' | kw= 'inits' | kw= 'CYCL' | kw= 'BACK' | kw= 'INIT' | kw= 'CYCLS' | kw= 'EVNTS' | kw= 'BACKS' | kw= 'INITS' )
            int alt17=14;
            switch ( input.LA(1) ) {
            case 28:
                {
                alt17=1;
                }
                break;
            case 29:
                {
                alt17=2;
                }
                break;
            case 30:
                {
                alt17=3;
                }
                break;
            case 31:
                {
                alt17=4;
                }
                break;
            case 32:
                {
                alt17=5;
                }
                break;
            case 33:
                {
                alt17=6;
                }
                break;
            case 34:
                {
                alt17=7;
                }
                break;
            case 35:
                {
                alt17=8;
                }
                break;
            case 36:
                {
                alt17=9;
                }
                break;
            case 37:
                {
                alt17=10;
                }
                break;
            case 38:
                {
                alt17=11;
                }
                break;
            case 39:
                {
                alt17=12;
                }
                break;
            case 40:
                {
                alt17=13;
                }
                break;
            case 41:
                {
                alt17=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }

            switch (alt17) {
                case 1 :
                    // InternalMIC.g:1361:3: kw= 'cycl'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCyclKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalMIC.g:1367:3: kw= 'back'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBackKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalMIC.g:1373:3: kw= 'init'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getInitKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalMIC.g:1379:3: kw= 'cycls'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCyclsKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalMIC.g:1385:3: kw= 'evnts'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getEvntsKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalMIC.g:1391:3: kw= 'backs'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBacksKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalMIC.g:1397:3: kw= 'inits'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getInitsKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalMIC.g:1403:3: kw= 'CYCL'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCYCLKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalMIC.g:1409:3: kw= 'BACK'
                    {
                    kw=(Token)match(input,36,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBACKKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalMIC.g:1415:3: kw= 'INIT'
                    {
                    kw=(Token)match(input,37,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getINITKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalMIC.g:1421:3: kw= 'CYCLS'
                    {
                    kw=(Token)match(input,38,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getCYCLSKeyword_10());
                    		

                    }
                    break;
                case 12 :
                    // InternalMIC.g:1427:3: kw= 'EVNTS'
                    {
                    kw=(Token)match(input,39,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getEVNTSKeyword_11());
                    		

                    }
                    break;
                case 13 :
                    // InternalMIC.g:1433:3: kw= 'BACKS'
                    {
                    kw=(Token)match(input,40,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getBACKSKeyword_12());
                    		

                    }
                    break;
                case 14 :
                    // InternalMIC.g:1439:3: kw= 'INITS'
                    {
                    kw=(Token)match(input,41,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTaskStrategyAccess().getINITSKeyword_13());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTaskStrategy"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000008440L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000001FFC440L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000000100C440L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001008440L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x000003FFF0000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000002008450L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000004002030L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000004000030L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000008000000L});

}