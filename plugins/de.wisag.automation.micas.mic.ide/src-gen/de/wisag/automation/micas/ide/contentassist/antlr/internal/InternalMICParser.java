package de.wisag.automation.micas.ide.contentassist.antlr.internal;

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.DFA;
import de.wisag.automation.micas.services.MICGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMICParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_XFLOAT", "RULE_ID", "RULE_INT", "RULE_RAW_METADATE", "RULE_SPACE", "RULE_EOL", "'cycl'", "'back'", "'init'", "'cycls'", "'evnts'", "'backs'", "'inits'", "'CYCL'", "'BACK'", "'INIT'", "'CYCLS'", "'EVNTS'", "'BACKS'", "'INITS'", "'MODUL'", "'('", "','", "')'", "'ENDMODUL'", "'WordV'", "'WordK'", "'FloatV'", "'FloatK'", "'IPAMB'", "'IPAAW'", "'IPAZW'", "'IPAMW'", "'TASK'", "'ENDE'", "'writeaccess='", "'\\u00B0nothing'", "'true'"
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
    public static final int RULE_ID=5;
    public static final int RULE_RAW_METADATE=7;
    public static final int RULE_EOL=9;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int RULE_XFLOAT=4;
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

    	public void setGrammarAccess(MICGrammarAccess grammarAccess) {
    		this.grammarAccess = grammarAccess;
    	}

    	@Override
    	protected Grammar getGrammar() {
    		return grammarAccess.getGrammar();
    	}

    	@Override
    	protected String getValueForTokenName(String tokenName) {
    		return tokenName;
    	}



    // $ANTLR start "entryRuleModel"
    // InternalMIC.g:53:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // InternalMIC.g:54:1: ( ruleModel EOF )
            // InternalMIC.g:55:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            ruleModel();

            state._fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMIC.g:62:1: ruleModel : ( ruleModule ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:66:2: ( ( ruleModule ) )
            // InternalMIC.g:67:2: ( ruleModule )
            {
            // InternalMIC.g:67:2: ( ruleModule )
            // InternalMIC.g:68:3: ruleModule
            {
             before(grammarAccess.getModelAccess().getModuleParserRuleCall()); 
            pushFollow(FOLLOW_2);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModelAccess().getModuleParserRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleModule"
    // InternalMIC.g:78:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // InternalMIC.g:79:1: ( ruleModule EOF )
            // InternalMIC.g:80:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_1);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // InternalMIC.g:87:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:91:2: ( ( ( rule__Module__Group__0 ) ) )
            // InternalMIC.g:92:2: ( ( rule__Module__Group__0 ) )
            {
            // InternalMIC.g:92:2: ( ( rule__Module__Group__0 ) )
            // InternalMIC.g:93:3: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // InternalMIC.g:94:3: ( rule__Module__Group__0 )
            // InternalMIC.g:94:4: rule__Module__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleSymbol"
    // InternalMIC.g:103:1: entryRuleSymbol : ruleSymbol EOF ;
    public final void entryRuleSymbol() throws RecognitionException {
        try {
            // InternalMIC.g:104:1: ( ruleSymbol EOF )
            // InternalMIC.g:105:1: ruleSymbol EOF
            {
             before(grammarAccess.getSymbolRule()); 
            pushFollow(FOLLOW_1);
            ruleSymbol();

            state._fsp--;

             after(grammarAccess.getSymbolRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSymbol"


    // $ANTLR start "ruleSymbol"
    // InternalMIC.g:112:1: ruleSymbol : ( ( rule__Symbol__Alternatives ) ) ;
    public final void ruleSymbol() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:116:2: ( ( ( rule__Symbol__Alternatives ) ) )
            // InternalMIC.g:117:2: ( ( rule__Symbol__Alternatives ) )
            {
            // InternalMIC.g:117:2: ( ( rule__Symbol__Alternatives ) )
            // InternalMIC.g:118:3: ( rule__Symbol__Alternatives )
            {
             before(grammarAccess.getSymbolAccess().getAlternatives()); 
            // InternalMIC.g:119:3: ( rule__Symbol__Alternatives )
            // InternalMIC.g:119:4: rule__Symbol__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Symbol__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSymbolAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSymbol"


    // $ANTLR start "entryRuleMetaData"
    // InternalMIC.g:128:1: entryRuleMetaData : ruleMetaData EOF ;
    public final void entryRuleMetaData() throws RecognitionException {
        try {
            // InternalMIC.g:129:1: ( ruleMetaData EOF )
            // InternalMIC.g:130:1: ruleMetaData EOF
            {
             before(grammarAccess.getMetaDataRule()); 
            pushFollow(FOLLOW_1);
            ruleMetaData();

            state._fsp--;

             after(grammarAccess.getMetaDataRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleMetaData"


    // $ANTLR start "ruleMetaData"
    // InternalMIC.g:137:1: ruleMetaData : ( ( rule__MetaData__Group__0 ) ) ;
    public final void ruleMetaData() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:141:2: ( ( ( rule__MetaData__Group__0 ) ) )
            // InternalMIC.g:142:2: ( ( rule__MetaData__Group__0 ) )
            {
            // InternalMIC.g:142:2: ( ( rule__MetaData__Group__0 ) )
            // InternalMIC.g:143:3: ( rule__MetaData__Group__0 )
            {
             before(grammarAccess.getMetaDataAccess().getGroup()); 
            // InternalMIC.g:144:3: ( rule__MetaData__Group__0 )
            // InternalMIC.g:144:4: rule__MetaData__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__MetaData__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getMetaDataAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleMetaData"


    // $ANTLR start "entryRuleWordValue"
    // InternalMIC.g:153:1: entryRuleWordValue : ruleWordValue EOF ;
    public final void entryRuleWordValue() throws RecognitionException {
        try {
            // InternalMIC.g:154:1: ( ruleWordValue EOF )
            // InternalMIC.g:155:1: ruleWordValue EOF
            {
             before(grammarAccess.getWordValueRule()); 
            pushFollow(FOLLOW_1);
            ruleWordValue();

            state._fsp--;

             after(grammarAccess.getWordValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWordValue"


    // $ANTLR start "ruleWordValue"
    // InternalMIC.g:162:1: ruleWordValue : ( ( rule__WordValue__Alternatives ) ) ;
    public final void ruleWordValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:166:2: ( ( ( rule__WordValue__Alternatives ) ) )
            // InternalMIC.g:167:2: ( ( rule__WordValue__Alternatives ) )
            {
            // InternalMIC.g:167:2: ( ( rule__WordValue__Alternatives ) )
            // InternalMIC.g:168:3: ( rule__WordValue__Alternatives )
            {
             before(grammarAccess.getWordValueAccess().getAlternatives()); 
            // InternalMIC.g:169:3: ( rule__WordValue__Alternatives )
            // InternalMIC.g:169:4: rule__WordValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__WordValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getWordValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWordValue"


    // $ANTLR start "entryRuleWordVar"
    // InternalMIC.g:178:1: entryRuleWordVar : ruleWordVar EOF ;
    public final void entryRuleWordVar() throws RecognitionException {
        try {
            // InternalMIC.g:179:1: ( ruleWordVar EOF )
            // InternalMIC.g:180:1: ruleWordVar EOF
            {
             before(grammarAccess.getWordVarRule()); 
            pushFollow(FOLLOW_1);
            ruleWordVar();

            state._fsp--;

             after(grammarAccess.getWordVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWordVar"


    // $ANTLR start "ruleWordVar"
    // InternalMIC.g:187:1: ruleWordVar : ( ( rule__WordVar__Group__0 ) ) ;
    public final void ruleWordVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:191:2: ( ( ( rule__WordVar__Group__0 ) ) )
            // InternalMIC.g:192:2: ( ( rule__WordVar__Group__0 ) )
            {
            // InternalMIC.g:192:2: ( ( rule__WordVar__Group__0 ) )
            // InternalMIC.g:193:3: ( rule__WordVar__Group__0 )
            {
             before(grammarAccess.getWordVarAccess().getGroup()); 
            // InternalMIC.g:194:3: ( rule__WordVar__Group__0 )
            // InternalMIC.g:194:4: rule__WordVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WordVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWordVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWordVar"


    // $ANTLR start "entryRuleWordConst"
    // InternalMIC.g:203:1: entryRuleWordConst : ruleWordConst EOF ;
    public final void entryRuleWordConst() throws RecognitionException {
        try {
            // InternalMIC.g:204:1: ( ruleWordConst EOF )
            // InternalMIC.g:205:1: ruleWordConst EOF
            {
             before(grammarAccess.getWordConstRule()); 
            pushFollow(FOLLOW_1);
            ruleWordConst();

            state._fsp--;

             after(grammarAccess.getWordConstRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleWordConst"


    // $ANTLR start "ruleWordConst"
    // InternalMIC.g:212:1: ruleWordConst : ( ( rule__WordConst__Group__0 ) ) ;
    public final void ruleWordConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:216:2: ( ( ( rule__WordConst__Group__0 ) ) )
            // InternalMIC.g:217:2: ( ( rule__WordConst__Group__0 ) )
            {
            // InternalMIC.g:217:2: ( ( rule__WordConst__Group__0 ) )
            // InternalMIC.g:218:3: ( rule__WordConst__Group__0 )
            {
             before(grammarAccess.getWordConstAccess().getGroup()); 
            // InternalMIC.g:219:3: ( rule__WordConst__Group__0 )
            // InternalMIC.g:219:4: rule__WordConst__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__WordConst__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getWordConstAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleWordConst"


    // $ANTLR start "entryRuleFloatValue"
    // InternalMIC.g:228:1: entryRuleFloatValue : ruleFloatValue EOF ;
    public final void entryRuleFloatValue() throws RecognitionException {
        try {
            // InternalMIC.g:229:1: ( ruleFloatValue EOF )
            // InternalMIC.g:230:1: ruleFloatValue EOF
            {
             before(grammarAccess.getFloatValueRule()); 
            pushFollow(FOLLOW_1);
            ruleFloatValue();

            state._fsp--;

             after(grammarAccess.getFloatValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFloatValue"


    // $ANTLR start "ruleFloatValue"
    // InternalMIC.g:237:1: ruleFloatValue : ( ( rule__FloatValue__Alternatives ) ) ;
    public final void ruleFloatValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:241:2: ( ( ( rule__FloatValue__Alternatives ) ) )
            // InternalMIC.g:242:2: ( ( rule__FloatValue__Alternatives ) )
            {
            // InternalMIC.g:242:2: ( ( rule__FloatValue__Alternatives ) )
            // InternalMIC.g:243:3: ( rule__FloatValue__Alternatives )
            {
             before(grammarAccess.getFloatValueAccess().getAlternatives()); 
            // InternalMIC.g:244:3: ( rule__FloatValue__Alternatives )
            // InternalMIC.g:244:4: rule__FloatValue__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__FloatValue__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getFloatValueAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloatValue"


    // $ANTLR start "entryRuleFloatVar"
    // InternalMIC.g:253:1: entryRuleFloatVar : ruleFloatVar EOF ;
    public final void entryRuleFloatVar() throws RecognitionException {
        try {
            // InternalMIC.g:254:1: ( ruleFloatVar EOF )
            // InternalMIC.g:255:1: ruleFloatVar EOF
            {
             before(grammarAccess.getFloatVarRule()); 
            pushFollow(FOLLOW_1);
            ruleFloatVar();

            state._fsp--;

             after(grammarAccess.getFloatVarRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFloatVar"


    // $ANTLR start "ruleFloatVar"
    // InternalMIC.g:262:1: ruleFloatVar : ( ( rule__FloatVar__Group__0 ) ) ;
    public final void ruleFloatVar() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:266:2: ( ( ( rule__FloatVar__Group__0 ) ) )
            // InternalMIC.g:267:2: ( ( rule__FloatVar__Group__0 ) )
            {
            // InternalMIC.g:267:2: ( ( rule__FloatVar__Group__0 ) )
            // InternalMIC.g:268:3: ( rule__FloatVar__Group__0 )
            {
             before(grammarAccess.getFloatVarAccess().getGroup()); 
            // InternalMIC.g:269:3: ( rule__FloatVar__Group__0 )
            // InternalMIC.g:269:4: rule__FloatVar__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FloatVar__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloatVarAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloatVar"


    // $ANTLR start "entryRuleFloatConst"
    // InternalMIC.g:278:1: entryRuleFloatConst : ruleFloatConst EOF ;
    public final void entryRuleFloatConst() throws RecognitionException {
        try {
            // InternalMIC.g:279:1: ( ruleFloatConst EOF )
            // InternalMIC.g:280:1: ruleFloatConst EOF
            {
             before(grammarAccess.getFloatConstRule()); 
            pushFollow(FOLLOW_1);
            ruleFloatConst();

            state._fsp--;

             after(grammarAccess.getFloatConstRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFloatConst"


    // $ANTLR start "ruleFloatConst"
    // InternalMIC.g:287:1: ruleFloatConst : ( ( rule__FloatConst__Group__0 ) ) ;
    public final void ruleFloatConst() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:291:2: ( ( ( rule__FloatConst__Group__0 ) ) )
            // InternalMIC.g:292:2: ( ( rule__FloatConst__Group__0 ) )
            {
            // InternalMIC.g:292:2: ( ( rule__FloatConst__Group__0 ) )
            // InternalMIC.g:293:3: ( rule__FloatConst__Group__0 )
            {
             before(grammarAccess.getFloatConstAccess().getGroup()); 
            // InternalMIC.g:294:3: ( rule__FloatConst__Group__0 )
            // InternalMIC.g:294:4: rule__FloatConst__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FloatConst__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFloatConstAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloatConst"


    // $ANTLR start "entryRuleDirectValue"
    // InternalMIC.g:303:1: entryRuleDirectValue : ruleDirectValue EOF ;
    public final void entryRuleDirectValue() throws RecognitionException {
        try {
            // InternalMIC.g:304:1: ( ruleDirectValue EOF )
            // InternalMIC.g:305:1: ruleDirectValue EOF
            {
             before(grammarAccess.getDirectValueRule()); 
            pushFollow(FOLLOW_1);
            ruleDirectValue();

            state._fsp--;

             after(grammarAccess.getDirectValueRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleDirectValue"


    // $ANTLR start "ruleDirectValue"
    // InternalMIC.g:312:1: ruleDirectValue : ( ( rule__DirectValue__ValueAssignment ) ) ;
    public final void ruleDirectValue() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:316:2: ( ( ( rule__DirectValue__ValueAssignment ) ) )
            // InternalMIC.g:317:2: ( ( rule__DirectValue__ValueAssignment ) )
            {
            // InternalMIC.g:317:2: ( ( rule__DirectValue__ValueAssignment ) )
            // InternalMIC.g:318:3: ( rule__DirectValue__ValueAssignment )
            {
             before(grammarAccess.getDirectValueAccess().getValueAssignment()); 
            // InternalMIC.g:319:3: ( rule__DirectValue__ValueAssignment )
            // InternalMIC.g:319:4: rule__DirectValue__ValueAssignment
            {
            pushFollow(FOLLOW_2);
            rule__DirectValue__ValueAssignment();

            state._fsp--;


            }

             after(grammarAccess.getDirectValueAccess().getValueAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleDirectValue"


    // $ANTLR start "entryRuleReference"
    // InternalMIC.g:328:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // InternalMIC.g:329:1: ( ruleReference EOF )
            // InternalMIC.g:330:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleReference();

            state._fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleReference"


    // $ANTLR start "ruleReference"
    // InternalMIC.g:337:1: ruleReference : ( ( rule__Reference__Alternatives ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:341:2: ( ( ( rule__Reference__Alternatives ) ) )
            // InternalMIC.g:342:2: ( ( rule__Reference__Alternatives ) )
            {
            // InternalMIC.g:342:2: ( ( rule__Reference__Alternatives ) )
            // InternalMIC.g:343:3: ( rule__Reference__Alternatives )
            {
             before(grammarAccess.getReferenceAccess().getAlternatives()); 
            // InternalMIC.g:344:3: ( rule__Reference__Alternatives )
            // InternalMIC.g:344:4: rule__Reference__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Reference__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getReferenceAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleReference"


    // $ANTLR start "entryRuleFGAMessageConstantReference"
    // InternalMIC.g:353:1: entryRuleFGAMessageConstantReference : ruleFGAMessageConstantReference EOF ;
    public final void entryRuleFGAMessageConstantReference() throws RecognitionException {
        try {
            // InternalMIC.g:354:1: ( ruleFGAMessageConstantReference EOF )
            // InternalMIC.g:355:1: ruleFGAMessageConstantReference EOF
            {
             before(grammarAccess.getFGAMessageConstantReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleFGAMessageConstantReference();

            state._fsp--;

             after(grammarAccess.getFGAMessageConstantReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFGAMessageConstantReference"


    // $ANTLR start "ruleFGAMessageConstantReference"
    // InternalMIC.g:362:1: ruleFGAMessageConstantReference : ( ( rule__FGAMessageConstantReference__Group__0 ) ) ;
    public final void ruleFGAMessageConstantReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:366:2: ( ( ( rule__FGAMessageConstantReference__Group__0 ) ) )
            // InternalMIC.g:367:2: ( ( rule__FGAMessageConstantReference__Group__0 ) )
            {
            // InternalMIC.g:367:2: ( ( rule__FGAMessageConstantReference__Group__0 ) )
            // InternalMIC.g:368:3: ( rule__FGAMessageConstantReference__Group__0 )
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getGroup()); 
            // InternalMIC.g:369:3: ( rule__FGAMessageConstantReference__Group__0 )
            // InternalMIC.g:369:4: rule__FGAMessageConstantReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFGAMessageConstantReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFGAMessageConstantReference"


    // $ANTLR start "entryRuleFGAAnalogValueReference"
    // InternalMIC.g:378:1: entryRuleFGAAnalogValueReference : ruleFGAAnalogValueReference EOF ;
    public final void entryRuleFGAAnalogValueReference() throws RecognitionException {
        try {
            // InternalMIC.g:379:1: ( ruleFGAAnalogValueReference EOF )
            // InternalMIC.g:380:1: ruleFGAAnalogValueReference EOF
            {
             before(grammarAccess.getFGAAnalogValueReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleFGAAnalogValueReference();

            state._fsp--;

             after(grammarAccess.getFGAAnalogValueReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFGAAnalogValueReference"


    // $ANTLR start "ruleFGAAnalogValueReference"
    // InternalMIC.g:387:1: ruleFGAAnalogValueReference : ( ( rule__FGAAnalogValueReference__Group__0 ) ) ;
    public final void ruleFGAAnalogValueReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:391:2: ( ( ( rule__FGAAnalogValueReference__Group__0 ) ) )
            // InternalMIC.g:392:2: ( ( rule__FGAAnalogValueReference__Group__0 ) )
            {
            // InternalMIC.g:392:2: ( ( rule__FGAAnalogValueReference__Group__0 ) )
            // InternalMIC.g:393:3: ( rule__FGAAnalogValueReference__Group__0 )
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getGroup()); 
            // InternalMIC.g:394:3: ( rule__FGAAnalogValueReference__Group__0 )
            // InternalMIC.g:394:4: rule__FGAAnalogValueReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFGAAnalogValueReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFGAAnalogValueReference"


    // $ANTLR start "entryRuleFGAValueReference"
    // InternalMIC.g:403:1: entryRuleFGAValueReference : ruleFGAValueReference EOF ;
    public final void entryRuleFGAValueReference() throws RecognitionException {
        try {
            // InternalMIC.g:404:1: ( ruleFGAValueReference EOF )
            // InternalMIC.g:405:1: ruleFGAValueReference EOF
            {
             before(grammarAccess.getFGAValueReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleFGAValueReference();

            state._fsp--;

             after(grammarAccess.getFGAValueReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFGAValueReference"


    // $ANTLR start "ruleFGAValueReference"
    // InternalMIC.g:412:1: ruleFGAValueReference : ( ( rule__FGAValueReference__Group__0 ) ) ;
    public final void ruleFGAValueReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:416:2: ( ( ( rule__FGAValueReference__Group__0 ) ) )
            // InternalMIC.g:417:2: ( ( rule__FGAValueReference__Group__0 ) )
            {
            // InternalMIC.g:417:2: ( ( rule__FGAValueReference__Group__0 ) )
            // InternalMIC.g:418:3: ( rule__FGAValueReference__Group__0 )
            {
             before(grammarAccess.getFGAValueReferenceAccess().getGroup()); 
            // InternalMIC.g:419:3: ( rule__FGAValueReference__Group__0 )
            // InternalMIC.g:419:4: rule__FGAValueReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FGAValueReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFGAValueReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFGAValueReference"


    // $ANTLR start "entryRuleFGAMeasuredValueReference"
    // InternalMIC.g:428:1: entryRuleFGAMeasuredValueReference : ruleFGAMeasuredValueReference EOF ;
    public final void entryRuleFGAMeasuredValueReference() throws RecognitionException {
        try {
            // InternalMIC.g:429:1: ( ruleFGAMeasuredValueReference EOF )
            // InternalMIC.g:430:1: ruleFGAMeasuredValueReference EOF
            {
             before(grammarAccess.getFGAMeasuredValueReferenceRule()); 
            pushFollow(FOLLOW_1);
            ruleFGAMeasuredValueReference();

            state._fsp--;

             after(grammarAccess.getFGAMeasuredValueReferenceRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFGAMeasuredValueReference"


    // $ANTLR start "ruleFGAMeasuredValueReference"
    // InternalMIC.g:437:1: ruleFGAMeasuredValueReference : ( ( rule__FGAMeasuredValueReference__Group__0 ) ) ;
    public final void ruleFGAMeasuredValueReference() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:441:2: ( ( ( rule__FGAMeasuredValueReference__Group__0 ) ) )
            // InternalMIC.g:442:2: ( ( rule__FGAMeasuredValueReference__Group__0 ) )
            {
            // InternalMIC.g:442:2: ( ( rule__FGAMeasuredValueReference__Group__0 ) )
            // InternalMIC.g:443:3: ( rule__FGAMeasuredValueReference__Group__0 )
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getGroup()); 
            // InternalMIC.g:444:3: ( rule__FGAMeasuredValueReference__Group__0 )
            // InternalMIC.g:444:4: rule__FGAMeasuredValueReference__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFGAMeasuredValueReference"


    // $ANTLR start "entryRuleTask"
    // InternalMIC.g:453:1: entryRuleTask : ruleTask EOF ;
    public final void entryRuleTask() throws RecognitionException {
        try {
            // InternalMIC.g:454:1: ( ruleTask EOF )
            // InternalMIC.g:455:1: ruleTask EOF
            {
             before(grammarAccess.getTaskRule()); 
            pushFollow(FOLLOW_1);
            ruleTask();

            state._fsp--;

             after(grammarAccess.getTaskRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTask"


    // $ANTLR start "ruleTask"
    // InternalMIC.g:462:1: ruleTask : ( ( rule__Task__Group__0 ) ) ;
    public final void ruleTask() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:466:2: ( ( ( rule__Task__Group__0 ) ) )
            // InternalMIC.g:467:2: ( ( rule__Task__Group__0 ) )
            {
            // InternalMIC.g:467:2: ( ( rule__Task__Group__0 ) )
            // InternalMIC.g:468:3: ( rule__Task__Group__0 )
            {
             before(grammarAccess.getTaskAccess().getGroup()); 
            // InternalMIC.g:469:3: ( rule__Task__Group__0 )
            // InternalMIC.g:469:4: rule__Task__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__Task__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTaskAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTask"


    // $ANTLR start "entryRuleInstruction"
    // InternalMIC.g:478:1: entryRuleInstruction : ruleInstruction EOF ;
    public final void entryRuleInstruction() throws RecognitionException {
        try {
            // InternalMIC.g:479:1: ( ruleInstruction EOF )
            // InternalMIC.g:480:1: ruleInstruction EOF
            {
             before(grammarAccess.getInstructionRule()); 
            pushFollow(FOLLOW_1);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getInstructionRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleInstruction"


    // $ANTLR start "ruleInstruction"
    // InternalMIC.g:487:1: ruleInstruction : ( ( rule__Instruction__Alternatives ) ) ;
    public final void ruleInstruction() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:491:2: ( ( ( rule__Instruction__Alternatives ) ) )
            // InternalMIC.g:492:2: ( ( rule__Instruction__Alternatives ) )
            {
            // InternalMIC.g:492:2: ( ( rule__Instruction__Alternatives ) )
            // InternalMIC.g:493:3: ( rule__Instruction__Alternatives )
            {
             before(grammarAccess.getInstructionAccess().getAlternatives()); 
            // InternalMIC.g:494:3: ( rule__Instruction__Alternatives )
            // InternalMIC.g:494:4: rule__Instruction__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__Instruction__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getInstructionAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleInstruction"


    // $ANTLR start "entryRuleModuleInvokation"
    // InternalMIC.g:503:1: entryRuleModuleInvokation : ruleModuleInvokation EOF ;
    public final void entryRuleModuleInvokation() throws RecognitionException {
        try {
            // InternalMIC.g:504:1: ( ruleModuleInvokation EOF )
            // InternalMIC.g:505:1: ruleModuleInvokation EOF
            {
             before(grammarAccess.getModuleInvokationRule()); 
            pushFollow(FOLLOW_1);
            ruleModuleInvokation();

            state._fsp--;

             after(grammarAccess.getModuleInvokationRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModuleInvokation"


    // $ANTLR start "ruleModuleInvokation"
    // InternalMIC.g:512:1: ruleModuleInvokation : ( ( rule__ModuleInvokation__Group__0 ) ) ;
    public final void ruleModuleInvokation() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:516:2: ( ( ( rule__ModuleInvokation__Group__0 ) ) )
            // InternalMIC.g:517:2: ( ( rule__ModuleInvokation__Group__0 ) )
            {
            // InternalMIC.g:517:2: ( ( rule__ModuleInvokation__Group__0 ) )
            // InternalMIC.g:518:3: ( rule__ModuleInvokation__Group__0 )
            {
             before(grammarAccess.getModuleInvokationAccess().getGroup()); 
            // InternalMIC.g:519:3: ( rule__ModuleInvokation__Group__0 )
            // InternalMIC.g:519:4: rule__ModuleInvokation__Group__0
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleInvokationAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModuleInvokation"


    // $ANTLR start "entryRuleSymbolAccessor"
    // InternalMIC.g:528:1: entryRuleSymbolAccessor : ruleSymbolAccessor EOF ;
    public final void entryRuleSymbolAccessor() throws RecognitionException {
        try {
            // InternalMIC.g:529:1: ( ruleSymbolAccessor EOF )
            // InternalMIC.g:530:1: ruleSymbolAccessor EOF
            {
             before(grammarAccess.getSymbolAccessorRule()); 
            pushFollow(FOLLOW_1);
            ruleSymbolAccessor();

            state._fsp--;

             after(grammarAccess.getSymbolAccessorRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleSymbolAccessor"


    // $ANTLR start "ruleSymbolAccessor"
    // InternalMIC.g:537:1: ruleSymbolAccessor : ( ( rule__SymbolAccessor__Alternatives ) ) ;
    public final void ruleSymbolAccessor() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:541:2: ( ( ( rule__SymbolAccessor__Alternatives ) ) )
            // InternalMIC.g:542:2: ( ( rule__SymbolAccessor__Alternatives ) )
            {
            // InternalMIC.g:542:2: ( ( rule__SymbolAccessor__Alternatives ) )
            // InternalMIC.g:543:3: ( rule__SymbolAccessor__Alternatives )
            {
             before(grammarAccess.getSymbolAccessorAccess().getAlternatives()); 
            // InternalMIC.g:544:3: ( rule__SymbolAccessor__Alternatives )
            // InternalMIC.g:544:4: rule__SymbolAccessor__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getSymbolAccessorAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleSymbolAccessor"


    // $ANTLR start "entryRuleFloat"
    // InternalMIC.g:553:1: entryRuleFloat : ruleFloat EOF ;
    public final void entryRuleFloat() throws RecognitionException {
        try {
            // InternalMIC.g:554:1: ( ruleFloat EOF )
            // InternalMIC.g:555:1: ruleFloat EOF
            {
             before(grammarAccess.getFloatRule()); 
            pushFollow(FOLLOW_1);
            ruleFloat();

            state._fsp--;

             after(grammarAccess.getFloatRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleFloat"


    // $ANTLR start "ruleFloat"
    // InternalMIC.g:562:1: ruleFloat : ( RULE_XFLOAT ) ;
    public final void ruleFloat() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:566:2: ( ( RULE_XFLOAT ) )
            // InternalMIC.g:567:2: ( RULE_XFLOAT )
            {
            // InternalMIC.g:567:2: ( RULE_XFLOAT )
            // InternalMIC.g:568:3: RULE_XFLOAT
            {
             before(grammarAccess.getFloatAccess().getXFLOATTerminalRuleCall()); 
            match(input,RULE_XFLOAT,FOLLOW_2); 
             after(grammarAccess.getFloatAccess().getXFLOATTerminalRuleCall()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleFloat"


    // $ANTLR start "entryRuleTaskStrategy"
    // InternalMIC.g:578:1: entryRuleTaskStrategy : ruleTaskStrategy EOF ;
    public final void entryRuleTaskStrategy() throws RecognitionException {
        try {
            // InternalMIC.g:579:1: ( ruleTaskStrategy EOF )
            // InternalMIC.g:580:1: ruleTaskStrategy EOF
            {
             before(grammarAccess.getTaskStrategyRule()); 
            pushFollow(FOLLOW_1);
            ruleTaskStrategy();

            state._fsp--;

             after(grammarAccess.getTaskStrategyRule()); 
            match(input,EOF,FOLLOW_2); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTaskStrategy"


    // $ANTLR start "ruleTaskStrategy"
    // InternalMIC.g:587:1: ruleTaskStrategy : ( ( rule__TaskStrategy__Alternatives ) ) ;
    public final void ruleTaskStrategy() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:591:2: ( ( ( rule__TaskStrategy__Alternatives ) ) )
            // InternalMIC.g:592:2: ( ( rule__TaskStrategy__Alternatives ) )
            {
            // InternalMIC.g:592:2: ( ( rule__TaskStrategy__Alternatives ) )
            // InternalMIC.g:593:3: ( rule__TaskStrategy__Alternatives )
            {
             before(grammarAccess.getTaskStrategyAccess().getAlternatives()); 
            // InternalMIC.g:594:3: ( rule__TaskStrategy__Alternatives )
            // InternalMIC.g:594:4: rule__TaskStrategy__Alternatives
            {
            pushFollow(FOLLOW_2);
            rule__TaskStrategy__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getTaskStrategyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTaskStrategy"


    // $ANTLR start "rule__Symbol__Alternatives"
    // InternalMIC.g:602:1: rule__Symbol__Alternatives : ( ( ruleWordValue ) | ( ruleFloatValue ) | ( ruleReference ) | ( ruleMetaData ) );
    public final void rule__Symbol__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:606:1: ( ( ruleWordValue ) | ( ruleFloatValue ) | ( ruleReference ) | ( ruleMetaData ) )
            int alt1=4;
            switch ( input.LA(1) ) {
            case 29:
            case 30:
                {
                alt1=1;
                }
                break;
            case 31:
            case 32:
                {
                alt1=2;
                }
                break;
            case 33:
            case 34:
            case 35:
            case 36:
                {
                alt1=3;
                }
                break;
            case RULE_RAW_METADATE:
            case 40:
                {
                alt1=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }

            switch (alt1) {
                case 1 :
                    // InternalMIC.g:607:2: ( ruleWordValue )
                    {
                    // InternalMIC.g:607:2: ( ruleWordValue )
                    // InternalMIC.g:608:3: ruleWordValue
                    {
                     before(grammarAccess.getSymbolAccess().getWordValueParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleWordValue();

                    state._fsp--;

                     after(grammarAccess.getSymbolAccess().getWordValueParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:613:2: ( ruleFloatValue )
                    {
                    // InternalMIC.g:613:2: ( ruleFloatValue )
                    // InternalMIC.g:614:3: ruleFloatValue
                    {
                     before(grammarAccess.getSymbolAccess().getFloatValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFloatValue();

                    state._fsp--;

                     after(grammarAccess.getSymbolAccess().getFloatValueParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMIC.g:619:2: ( ruleReference )
                    {
                    // InternalMIC.g:619:2: ( ruleReference )
                    // InternalMIC.g:620:3: ruleReference
                    {
                     before(grammarAccess.getSymbolAccess().getReferenceParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleReference();

                    state._fsp--;

                     after(grammarAccess.getSymbolAccess().getReferenceParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMIC.g:625:2: ( ruleMetaData )
                    {
                    // InternalMIC.g:625:2: ( ruleMetaData )
                    // InternalMIC.g:626:3: ruleMetaData
                    {
                     before(grammarAccess.getSymbolAccess().getMetaDataParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleMetaData();

                    state._fsp--;

                     after(grammarAccess.getSymbolAccess().getMetaDataParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Symbol__Alternatives"


    // $ANTLR start "rule__WordValue__Alternatives"
    // InternalMIC.g:635:1: rule__WordValue__Alternatives : ( ( ruleWordVar ) | ( ruleWordConst ) );
    public final void rule__WordValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:639:1: ( ( ruleWordVar ) | ( ruleWordConst ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==29) ) {
                alt2=1;
            }
            else if ( (LA2_0==30) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // InternalMIC.g:640:2: ( ruleWordVar )
                    {
                    // InternalMIC.g:640:2: ( ruleWordVar )
                    // InternalMIC.g:641:3: ruleWordVar
                    {
                     before(grammarAccess.getWordValueAccess().getWordVarParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleWordVar();

                    state._fsp--;

                     after(grammarAccess.getWordValueAccess().getWordVarParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:646:2: ( ruleWordConst )
                    {
                    // InternalMIC.g:646:2: ( ruleWordConst )
                    // InternalMIC.g:647:3: ruleWordConst
                    {
                     before(grammarAccess.getWordValueAccess().getWordConstParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleWordConst();

                    state._fsp--;

                     after(grammarAccess.getWordValueAccess().getWordConstParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordValue__Alternatives"


    // $ANTLR start "rule__FloatValue__Alternatives"
    // InternalMIC.g:656:1: rule__FloatValue__Alternatives : ( ( ruleFloatVar ) | ( ruleFloatConst ) );
    public final void rule__FloatValue__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:660:1: ( ( ruleFloatVar ) | ( ruleFloatConst ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==31) ) {
                alt3=1;
            }
            else if ( (LA3_0==32) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalMIC.g:661:2: ( ruleFloatVar )
                    {
                    // InternalMIC.g:661:2: ( ruleFloatVar )
                    // InternalMIC.g:662:3: ruleFloatVar
                    {
                     before(grammarAccess.getFloatValueAccess().getFloatVarParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFloatVar();

                    state._fsp--;

                     after(grammarAccess.getFloatValueAccess().getFloatVarParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:667:2: ( ruleFloatConst )
                    {
                    // InternalMIC.g:667:2: ( ruleFloatConst )
                    // InternalMIC.g:668:3: ruleFloatConst
                    {
                     before(grammarAccess.getFloatValueAccess().getFloatConstParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFloatConst();

                    state._fsp--;

                     after(grammarAccess.getFloatValueAccess().getFloatConstParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatValue__Alternatives"


    // $ANTLR start "rule__Reference__Alternatives"
    // InternalMIC.g:677:1: rule__Reference__Alternatives : ( ( ruleFGAMessageConstantReference ) | ( ruleFGAAnalogValueReference ) | ( ruleFGAValueReference ) | ( ruleFGAMeasuredValueReference ) );
    public final void rule__Reference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:681:1: ( ( ruleFGAMessageConstantReference ) | ( ruleFGAAnalogValueReference ) | ( ruleFGAValueReference ) | ( ruleFGAMeasuredValueReference ) )
            int alt4=4;
            switch ( input.LA(1) ) {
            case 33:
                {
                alt4=1;
                }
                break;
            case 34:
                {
                alt4=2;
                }
                break;
            case 35:
                {
                alt4=3;
                }
                break;
            case 36:
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
                    // InternalMIC.g:682:2: ( ruleFGAMessageConstantReference )
                    {
                    // InternalMIC.g:682:2: ( ruleFGAMessageConstantReference )
                    // InternalMIC.g:683:3: ruleFGAMessageConstantReference
                    {
                     before(grammarAccess.getReferenceAccess().getFGAMessageConstantReferenceParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleFGAMessageConstantReference();

                    state._fsp--;

                     after(grammarAccess.getReferenceAccess().getFGAMessageConstantReferenceParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:688:2: ( ruleFGAAnalogValueReference )
                    {
                    // InternalMIC.g:688:2: ( ruleFGAAnalogValueReference )
                    // InternalMIC.g:689:3: ruleFGAAnalogValueReference
                    {
                     before(grammarAccess.getReferenceAccess().getFGAAnalogValueReferenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleFGAAnalogValueReference();

                    state._fsp--;

                     after(grammarAccess.getReferenceAccess().getFGAAnalogValueReferenceParserRuleCall_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMIC.g:694:2: ( ruleFGAValueReference )
                    {
                    // InternalMIC.g:694:2: ( ruleFGAValueReference )
                    // InternalMIC.g:695:3: ruleFGAValueReference
                    {
                     before(grammarAccess.getReferenceAccess().getFGAValueReferenceParserRuleCall_2()); 
                    pushFollow(FOLLOW_2);
                    ruleFGAValueReference();

                    state._fsp--;

                     after(grammarAccess.getReferenceAccess().getFGAValueReferenceParserRuleCall_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMIC.g:700:2: ( ruleFGAMeasuredValueReference )
                    {
                    // InternalMIC.g:700:2: ( ruleFGAMeasuredValueReference )
                    // InternalMIC.g:701:3: ruleFGAMeasuredValueReference
                    {
                     before(grammarAccess.getReferenceAccess().getFGAMeasuredValueReferenceParserRuleCall_3()); 
                    pushFollow(FOLLOW_2);
                    ruleFGAMeasuredValueReference();

                    state._fsp--;

                     after(grammarAccess.getReferenceAccess().getFGAMeasuredValueReferenceParserRuleCall_3()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Reference__Alternatives"


    // $ANTLR start "rule__Instruction__Alternatives"
    // InternalMIC.g:710:1: rule__Instruction__Alternatives : ( ( ruleModuleInvokation ) | ( ruleMetaData ) );
    public final void rule__Instruction__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:714:1: ( ( ruleModuleInvokation ) | ( ruleMetaData ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_ID) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_RAW_METADATE||LA5_0==40) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // InternalMIC.g:715:2: ( ruleModuleInvokation )
                    {
                    // InternalMIC.g:715:2: ( ruleModuleInvokation )
                    // InternalMIC.g:716:3: ruleModuleInvokation
                    {
                     before(grammarAccess.getInstructionAccess().getModuleInvokationParserRuleCall_0()); 
                    pushFollow(FOLLOW_2);
                    ruleModuleInvokation();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getModuleInvokationParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:721:2: ( ruleMetaData )
                    {
                    // InternalMIC.g:721:2: ( ruleMetaData )
                    // InternalMIC.g:722:3: ruleMetaData
                    {
                     before(grammarAccess.getInstructionAccess().getMetaDataParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleMetaData();

                    state._fsp--;

                     after(grammarAccess.getInstructionAccess().getMetaDataParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Instruction__Alternatives"


    // $ANTLR start "rule__SymbolAccessor__Alternatives"
    // InternalMIC.g:731:1: rule__SymbolAccessor__Alternatives : ( ( ( rule__SymbolAccessor__Group_0__0 ) ) | ( ruleDirectValue ) );
    public final void rule__SymbolAccessor__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:735:1: ( ( ( rule__SymbolAccessor__Group_0__0 ) ) | ( ruleDirectValue ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RULE_ID||LA6_0==39) ) {
                alt6=1;
            }
            else if ( (LA6_0==RULE_INT) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalMIC.g:736:2: ( ( rule__SymbolAccessor__Group_0__0 ) )
                    {
                    // InternalMIC.g:736:2: ( ( rule__SymbolAccessor__Group_0__0 ) )
                    // InternalMIC.g:737:3: ( rule__SymbolAccessor__Group_0__0 )
                    {
                     before(grammarAccess.getSymbolAccessorAccess().getGroup_0()); 
                    // InternalMIC.g:738:3: ( rule__SymbolAccessor__Group_0__0 )
                    // InternalMIC.g:738:4: rule__SymbolAccessor__Group_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SymbolAccessor__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getSymbolAccessorAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:742:2: ( ruleDirectValue )
                    {
                    // InternalMIC.g:742:2: ( ruleDirectValue )
                    // InternalMIC.g:743:3: ruleDirectValue
                    {
                     before(grammarAccess.getSymbolAccessorAccess().getDirectValueParserRuleCall_1()); 
                    pushFollow(FOLLOW_2);
                    ruleDirectValue();

                    state._fsp--;

                     after(grammarAccess.getSymbolAccessorAccess().getDirectValueParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Alternatives"


    // $ANTLR start "rule__TaskStrategy__Alternatives"
    // InternalMIC.g:752:1: rule__TaskStrategy__Alternatives : ( ( 'cycl' ) | ( 'back' ) | ( 'init' ) | ( 'cycls' ) | ( 'evnts' ) | ( 'backs' ) | ( 'inits' ) | ( 'CYCL' ) | ( 'BACK' ) | ( 'INIT' ) | ( 'CYCLS' ) | ( 'EVNTS' ) | ( 'BACKS' ) | ( 'INITS' ) );
    public final void rule__TaskStrategy__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:756:1: ( ( 'cycl' ) | ( 'back' ) | ( 'init' ) | ( 'cycls' ) | ( 'evnts' ) | ( 'backs' ) | ( 'inits' ) | ( 'CYCL' ) | ( 'BACK' ) | ( 'INIT' ) | ( 'CYCLS' ) | ( 'EVNTS' ) | ( 'BACKS' ) | ( 'INITS' ) )
            int alt7=14;
            switch ( input.LA(1) ) {
            case 10:
                {
                alt7=1;
                }
                break;
            case 11:
                {
                alt7=2;
                }
                break;
            case 12:
                {
                alt7=3;
                }
                break;
            case 13:
                {
                alt7=4;
                }
                break;
            case 14:
                {
                alt7=5;
                }
                break;
            case 15:
                {
                alt7=6;
                }
                break;
            case 16:
                {
                alt7=7;
                }
                break;
            case 17:
                {
                alt7=8;
                }
                break;
            case 18:
                {
                alt7=9;
                }
                break;
            case 19:
                {
                alt7=10;
                }
                break;
            case 20:
                {
                alt7=11;
                }
                break;
            case 21:
                {
                alt7=12;
                }
                break;
            case 22:
                {
                alt7=13;
                }
                break;
            case 23:
                {
                alt7=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalMIC.g:757:2: ( 'cycl' )
                    {
                    // InternalMIC.g:757:2: ( 'cycl' )
                    // InternalMIC.g:758:3: 'cycl'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getCyclKeyword_0()); 
                    match(input,10,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getCyclKeyword_0()); 

                    }


                    }
                    break;
                case 2 :
                    // InternalMIC.g:763:2: ( 'back' )
                    {
                    // InternalMIC.g:763:2: ( 'back' )
                    // InternalMIC.g:764:3: 'back'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getBackKeyword_1()); 
                    match(input,11,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getBackKeyword_1()); 

                    }


                    }
                    break;
                case 3 :
                    // InternalMIC.g:769:2: ( 'init' )
                    {
                    // InternalMIC.g:769:2: ( 'init' )
                    // InternalMIC.g:770:3: 'init'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getInitKeyword_2()); 
                    match(input,12,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getInitKeyword_2()); 

                    }


                    }
                    break;
                case 4 :
                    // InternalMIC.g:775:2: ( 'cycls' )
                    {
                    // InternalMIC.g:775:2: ( 'cycls' )
                    // InternalMIC.g:776:3: 'cycls'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getCyclsKeyword_3()); 
                    match(input,13,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getCyclsKeyword_3()); 

                    }


                    }
                    break;
                case 5 :
                    // InternalMIC.g:781:2: ( 'evnts' )
                    {
                    // InternalMIC.g:781:2: ( 'evnts' )
                    // InternalMIC.g:782:3: 'evnts'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getEvntsKeyword_4()); 
                    match(input,14,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getEvntsKeyword_4()); 

                    }


                    }
                    break;
                case 6 :
                    // InternalMIC.g:787:2: ( 'backs' )
                    {
                    // InternalMIC.g:787:2: ( 'backs' )
                    // InternalMIC.g:788:3: 'backs'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getBacksKeyword_5()); 
                    match(input,15,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getBacksKeyword_5()); 

                    }


                    }
                    break;
                case 7 :
                    // InternalMIC.g:793:2: ( 'inits' )
                    {
                    // InternalMIC.g:793:2: ( 'inits' )
                    // InternalMIC.g:794:3: 'inits'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getInitsKeyword_6()); 
                    match(input,16,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getInitsKeyword_6()); 

                    }


                    }
                    break;
                case 8 :
                    // InternalMIC.g:799:2: ( 'CYCL' )
                    {
                    // InternalMIC.g:799:2: ( 'CYCL' )
                    // InternalMIC.g:800:3: 'CYCL'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getCYCLKeyword_7()); 
                    match(input,17,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getCYCLKeyword_7()); 

                    }


                    }
                    break;
                case 9 :
                    // InternalMIC.g:805:2: ( 'BACK' )
                    {
                    // InternalMIC.g:805:2: ( 'BACK' )
                    // InternalMIC.g:806:3: 'BACK'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getBACKKeyword_8()); 
                    match(input,18,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getBACKKeyword_8()); 

                    }


                    }
                    break;
                case 10 :
                    // InternalMIC.g:811:2: ( 'INIT' )
                    {
                    // InternalMIC.g:811:2: ( 'INIT' )
                    // InternalMIC.g:812:3: 'INIT'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getINITKeyword_9()); 
                    match(input,19,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getINITKeyword_9()); 

                    }


                    }
                    break;
                case 11 :
                    // InternalMIC.g:817:2: ( 'CYCLS' )
                    {
                    // InternalMIC.g:817:2: ( 'CYCLS' )
                    // InternalMIC.g:818:3: 'CYCLS'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getCYCLSKeyword_10()); 
                    match(input,20,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getCYCLSKeyword_10()); 

                    }


                    }
                    break;
                case 12 :
                    // InternalMIC.g:823:2: ( 'EVNTS' )
                    {
                    // InternalMIC.g:823:2: ( 'EVNTS' )
                    // InternalMIC.g:824:3: 'EVNTS'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getEVNTSKeyword_11()); 
                    match(input,21,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getEVNTSKeyword_11()); 

                    }


                    }
                    break;
                case 13 :
                    // InternalMIC.g:829:2: ( 'BACKS' )
                    {
                    // InternalMIC.g:829:2: ( 'BACKS' )
                    // InternalMIC.g:830:3: 'BACKS'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getBACKSKeyword_12()); 
                    match(input,22,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getBACKSKeyword_12()); 

                    }


                    }
                    break;
                case 14 :
                    // InternalMIC.g:835:2: ( 'INITS' )
                    {
                    // InternalMIC.g:835:2: ( 'INITS' )
                    // InternalMIC.g:836:3: 'INITS'
                    {
                     before(grammarAccess.getTaskStrategyAccess().getINITSKeyword_13()); 
                    match(input,23,FOLLOW_2); 
                     after(grammarAccess.getTaskStrategyAccess().getINITSKeyword_13()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TaskStrategy__Alternatives"


    // $ANTLR start "rule__Module__Group__0"
    // InternalMIC.g:845:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:849:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // InternalMIC.g:850:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_3);
            rule__Module__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // InternalMIC.g:857:1: rule__Module__Group__0__Impl : ( ( rule__Module__ModulePrologAssignment_0 )* ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:861:1: ( ( ( rule__Module__ModulePrologAssignment_0 )* ) )
            // InternalMIC.g:862:1: ( ( rule__Module__ModulePrologAssignment_0 )* )
            {
            // InternalMIC.g:862:1: ( ( rule__Module__ModulePrologAssignment_0 )* )
            // InternalMIC.g:863:2: ( rule__Module__ModulePrologAssignment_0 )*
            {
             before(grammarAccess.getModuleAccess().getModulePrologAssignment_0()); 
            // InternalMIC.g:864:2: ( rule__Module__ModulePrologAssignment_0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_RAW_METADATE||LA8_0==40) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMIC.g:864:3: rule__Module__ModulePrologAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Module__ModulePrologAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getModulePrologAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // InternalMIC.g:872:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:876:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // InternalMIC.g:877:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Module__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // InternalMIC.g:884:1: rule__Module__Group__1__Impl : ( 'MODUL' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:888:1: ( ( 'MODUL' ) )
            // InternalMIC.g:889:1: ( 'MODUL' )
            {
            // InternalMIC.g:889:1: ( 'MODUL' )
            // InternalMIC.g:890:2: 'MODUL'
            {
             before(grammarAccess.getModuleAccess().getMODULKeyword_1()); 
            match(input,24,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getMODULKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // InternalMIC.g:899:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:903:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // InternalMIC.g:904:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_6);
            rule__Module__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2"


    // $ANTLR start "rule__Module__Group__2__Impl"
    // InternalMIC.g:911:1: rule__Module__Group__2__Impl : ( '(' ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:915:1: ( ( '(' ) )
            // InternalMIC.g:916:1: ( '(' )
            {
            // InternalMIC.g:916:1: ( '(' )
            // InternalMIC.g:917:2: '('
            {
             before(grammarAccess.getModuleAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Module__Group__3"
    // InternalMIC.g:926:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:930:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // InternalMIC.g:931:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Module__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3"


    // $ANTLR start "rule__Module__Group__3__Impl"
    // InternalMIC.g:938:1: rule__Module__Group__3__Impl : ( ( rule__Module__TypeAssignment_3 ) ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:942:1: ( ( ( rule__Module__TypeAssignment_3 ) ) )
            // InternalMIC.g:943:1: ( ( rule__Module__TypeAssignment_3 ) )
            {
            // InternalMIC.g:943:1: ( ( rule__Module__TypeAssignment_3 ) )
            // InternalMIC.g:944:2: ( rule__Module__TypeAssignment_3 )
            {
             before(grammarAccess.getModuleAccess().getTypeAssignment_3()); 
            // InternalMIC.g:945:2: ( rule__Module__TypeAssignment_3 )
            // InternalMIC.g:945:3: rule__Module__TypeAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Module__TypeAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getTypeAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3__Impl"


    // $ANTLR start "rule__Module__Group__4"
    // InternalMIC.g:953:1: rule__Module__Group__4 : rule__Module__Group__4__Impl rule__Module__Group__5 ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:957:1: ( rule__Module__Group__4__Impl rule__Module__Group__5 )
            // InternalMIC.g:958:2: rule__Module__Group__4__Impl rule__Module__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__Module__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4"


    // $ANTLR start "rule__Module__Group__4__Impl"
    // InternalMIC.g:965:1: rule__Module__Group__4__Impl : ( ',' ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:969:1: ( ( ',' ) )
            // InternalMIC.g:970:1: ( ',' )
            {
            // InternalMIC.g:970:1: ( ',' )
            // InternalMIC.g:971:2: ','
            {
             before(grammarAccess.getModuleAccess().getCommaKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4__Impl"


    // $ANTLR start "rule__Module__Group__5"
    // InternalMIC.g:980:1: rule__Module__Group__5 : rule__Module__Group__5__Impl rule__Module__Group__6 ;
    public final void rule__Module__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:984:1: ( rule__Module__Group__5__Impl rule__Module__Group__6 )
            // InternalMIC.g:985:2: rule__Module__Group__5__Impl rule__Module__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__Module__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__5"


    // $ANTLR start "rule__Module__Group__5__Impl"
    // InternalMIC.g:992:1: rule__Module__Group__5__Impl : ( ( rule__Module__ValueAssignment_5 ) ) ;
    public final void rule__Module__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:996:1: ( ( ( rule__Module__ValueAssignment_5 ) ) )
            // InternalMIC.g:997:1: ( ( rule__Module__ValueAssignment_5 ) )
            {
            // InternalMIC.g:997:1: ( ( rule__Module__ValueAssignment_5 ) )
            // InternalMIC.g:998:2: ( rule__Module__ValueAssignment_5 )
            {
             before(grammarAccess.getModuleAccess().getValueAssignment_5()); 
            // InternalMIC.g:999:2: ( rule__Module__ValueAssignment_5 )
            // InternalMIC.g:999:3: rule__Module__ValueAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Module__ValueAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getValueAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__5__Impl"


    // $ANTLR start "rule__Module__Group__6"
    // InternalMIC.g:1007:1: rule__Module__Group__6 : rule__Module__Group__6__Impl rule__Module__Group__7 ;
    public final void rule__Module__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1011:1: ( rule__Module__Group__6__Impl rule__Module__Group__7 )
            // InternalMIC.g:1012:2: rule__Module__Group__6__Impl rule__Module__Group__7
            {
            pushFollow(FOLLOW_10);
            rule__Module__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__6"


    // $ANTLR start "rule__Module__Group__6__Impl"
    // InternalMIC.g:1019:1: rule__Module__Group__6__Impl : ( ')' ) ;
    public final void rule__Module__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1023:1: ( ( ')' ) )
            // InternalMIC.g:1024:1: ( ')' )
            {
            // InternalMIC.g:1024:1: ( ')' )
            // InternalMIC.g:1025:2: ')'
            {
             before(grammarAccess.getModuleAccess().getRightParenthesisKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__6__Impl"


    // $ANTLR start "rule__Module__Group__7"
    // InternalMIC.g:1034:1: rule__Module__Group__7 : rule__Module__Group__7__Impl rule__Module__Group__8 ;
    public final void rule__Module__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1038:1: ( rule__Module__Group__7__Impl rule__Module__Group__8 )
            // InternalMIC.g:1039:2: rule__Module__Group__7__Impl rule__Module__Group__8
            {
            pushFollow(FOLLOW_10);
            rule__Module__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__7"


    // $ANTLR start "rule__Module__Group__7__Impl"
    // InternalMIC.g:1046:1: rule__Module__Group__7__Impl : ( ( rule__Module__DecalarationsAssignment_7 )* ) ;
    public final void rule__Module__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1050:1: ( ( ( rule__Module__DecalarationsAssignment_7 )* ) )
            // InternalMIC.g:1051:1: ( ( rule__Module__DecalarationsAssignment_7 )* )
            {
            // InternalMIC.g:1051:1: ( ( rule__Module__DecalarationsAssignment_7 )* )
            // InternalMIC.g:1052:2: ( rule__Module__DecalarationsAssignment_7 )*
            {
             before(grammarAccess.getModuleAccess().getDecalarationsAssignment_7()); 
            // InternalMIC.g:1053:2: ( rule__Module__DecalarationsAssignment_7 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==40) ) {
                    int LA9_1 = input.LA(2);

                    if ( (LA9_1==RULE_RAW_METADATE) ) {
                        alt9=1;
                    }


                }
                else if ( (LA9_0==RULE_RAW_METADATE||(LA9_0>=29 && LA9_0<=36)) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMIC.g:1053:3: rule__Module__DecalarationsAssignment_7
            	    {
            	    pushFollow(FOLLOW_11);
            	    rule__Module__DecalarationsAssignment_7();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getDecalarationsAssignment_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__7__Impl"


    // $ANTLR start "rule__Module__Group__8"
    // InternalMIC.g:1061:1: rule__Module__Group__8 : rule__Module__Group__8__Impl rule__Module__Group__9 ;
    public final void rule__Module__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1065:1: ( rule__Module__Group__8__Impl rule__Module__Group__9 )
            // InternalMIC.g:1066:2: rule__Module__Group__8__Impl rule__Module__Group__9
            {
            pushFollow(FOLLOW_10);
            rule__Module__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Module__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__8"


    // $ANTLR start "rule__Module__Group__8__Impl"
    // InternalMIC.g:1073:1: rule__Module__Group__8__Impl : ( ( rule__Module__TasksAssignment_8 )* ) ;
    public final void rule__Module__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1077:1: ( ( ( rule__Module__TasksAssignment_8 )* ) )
            // InternalMIC.g:1078:1: ( ( rule__Module__TasksAssignment_8 )* )
            {
            // InternalMIC.g:1078:1: ( ( rule__Module__TasksAssignment_8 )* )
            // InternalMIC.g:1079:2: ( rule__Module__TasksAssignment_8 )*
            {
             before(grammarAccess.getModuleAccess().getTasksAssignment_8()); 
            // InternalMIC.g:1080:2: ( rule__Module__TasksAssignment_8 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==RULE_RAW_METADATE||LA10_0==37||LA10_0==40) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMIC.g:1080:3: rule__Module__TasksAssignment_8
            	    {
            	    pushFollow(FOLLOW_12);
            	    rule__Module__TasksAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getTasksAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__8__Impl"


    // $ANTLR start "rule__Module__Group__9"
    // InternalMIC.g:1088:1: rule__Module__Group__9 : rule__Module__Group__9__Impl ;
    public final void rule__Module__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1092:1: ( rule__Module__Group__9__Impl )
            // InternalMIC.g:1093:2: rule__Module__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Module__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__9"


    // $ANTLR start "rule__Module__Group__9__Impl"
    // InternalMIC.g:1099:1: rule__Module__Group__9__Impl : ( 'ENDMODUL' ) ;
    public final void rule__Module__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1103:1: ( ( 'ENDMODUL' ) )
            // InternalMIC.g:1104:1: ( 'ENDMODUL' )
            {
            // InternalMIC.g:1104:1: ( 'ENDMODUL' )
            // InternalMIC.g:1105:2: 'ENDMODUL'
            {
             before(grammarAccess.getModuleAccess().getENDMODULKeyword_9()); 
            match(input,28,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getENDMODULKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__9__Impl"


    // $ANTLR start "rule__MetaData__Group__0"
    // InternalMIC.g:1115:1: rule__MetaData__Group__0 : rule__MetaData__Group__0__Impl rule__MetaData__Group__1 ;
    public final void rule__MetaData__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1119:1: ( rule__MetaData__Group__0__Impl rule__MetaData__Group__1 )
            // InternalMIC.g:1120:2: rule__MetaData__Group__0__Impl rule__MetaData__Group__1
            {
            pushFollow(FOLLOW_13);
            rule__MetaData__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__MetaData__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaData__Group__0"


    // $ANTLR start "rule__MetaData__Group__0__Impl"
    // InternalMIC.g:1127:1: rule__MetaData__Group__0__Impl : ( ( rule__MetaData__NameAssignment_0 )? ) ;
    public final void rule__MetaData__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1131:1: ( ( ( rule__MetaData__NameAssignment_0 )? ) )
            // InternalMIC.g:1132:1: ( ( rule__MetaData__NameAssignment_0 )? )
            {
            // InternalMIC.g:1132:1: ( ( rule__MetaData__NameAssignment_0 )? )
            // InternalMIC.g:1133:2: ( rule__MetaData__NameAssignment_0 )?
            {
             before(grammarAccess.getMetaDataAccess().getNameAssignment_0()); 
            // InternalMIC.g:1134:2: ( rule__MetaData__NameAssignment_0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==40) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMIC.g:1134:3: rule__MetaData__NameAssignment_0
                    {
                    pushFollow(FOLLOW_2);
                    rule__MetaData__NameAssignment_0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getMetaDataAccess().getNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaData__Group__0__Impl"


    // $ANTLR start "rule__MetaData__Group__1"
    // InternalMIC.g:1142:1: rule__MetaData__Group__1 : rule__MetaData__Group__1__Impl ;
    public final void rule__MetaData__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1146:1: ( rule__MetaData__Group__1__Impl )
            // InternalMIC.g:1147:2: rule__MetaData__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__MetaData__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaData__Group__1"


    // $ANTLR start "rule__MetaData__Group__1__Impl"
    // InternalMIC.g:1153:1: rule__MetaData__Group__1__Impl : ( ( rule__MetaData__ValueAssignment_1 ) ) ;
    public final void rule__MetaData__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1157:1: ( ( ( rule__MetaData__ValueAssignment_1 ) ) )
            // InternalMIC.g:1158:1: ( ( rule__MetaData__ValueAssignment_1 ) )
            {
            // InternalMIC.g:1158:1: ( ( rule__MetaData__ValueAssignment_1 ) )
            // InternalMIC.g:1159:2: ( rule__MetaData__ValueAssignment_1 )
            {
             before(grammarAccess.getMetaDataAccess().getValueAssignment_1()); 
            // InternalMIC.g:1160:2: ( rule__MetaData__ValueAssignment_1 )
            // InternalMIC.g:1160:3: rule__MetaData__ValueAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__MetaData__ValueAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getMetaDataAccess().getValueAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaData__Group__1__Impl"


    // $ANTLR start "rule__WordVar__Group__0"
    // InternalMIC.g:1169:1: rule__WordVar__Group__0 : rule__WordVar__Group__0__Impl rule__WordVar__Group__1 ;
    public final void rule__WordVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1173:1: ( rule__WordVar__Group__0__Impl rule__WordVar__Group__1 )
            // InternalMIC.g:1174:2: rule__WordVar__Group__0__Impl rule__WordVar__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__WordVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WordVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordVar__Group__0"


    // $ANTLR start "rule__WordVar__Group__0__Impl"
    // InternalMIC.g:1181:1: rule__WordVar__Group__0__Impl : ( 'WordV' ) ;
    public final void rule__WordVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1185:1: ( ( 'WordV' ) )
            // InternalMIC.g:1186:1: ( 'WordV' )
            {
            // InternalMIC.g:1186:1: ( 'WordV' )
            // InternalMIC.g:1187:2: 'WordV'
            {
             before(grammarAccess.getWordVarAccess().getWordVKeyword_0()); 
            match(input,29,FOLLOW_2); 
             after(grammarAccess.getWordVarAccess().getWordVKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordVar__Group__0__Impl"


    // $ANTLR start "rule__WordVar__Group__1"
    // InternalMIC.g:1196:1: rule__WordVar__Group__1 : rule__WordVar__Group__1__Impl ;
    public final void rule__WordVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1200:1: ( rule__WordVar__Group__1__Impl )
            // InternalMIC.g:1201:2: rule__WordVar__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WordVar__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordVar__Group__1"


    // $ANTLR start "rule__WordVar__Group__1__Impl"
    // InternalMIC.g:1207:1: rule__WordVar__Group__1__Impl : ( ( rule__WordVar__NameAssignment_1 ) ) ;
    public final void rule__WordVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1211:1: ( ( ( rule__WordVar__NameAssignment_1 ) ) )
            // InternalMIC.g:1212:1: ( ( rule__WordVar__NameAssignment_1 ) )
            {
            // InternalMIC.g:1212:1: ( ( rule__WordVar__NameAssignment_1 ) )
            // InternalMIC.g:1213:2: ( rule__WordVar__NameAssignment_1 )
            {
             before(grammarAccess.getWordVarAccess().getNameAssignment_1()); 
            // InternalMIC.g:1214:2: ( rule__WordVar__NameAssignment_1 )
            // InternalMIC.g:1214:3: rule__WordVar__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WordVar__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWordVarAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordVar__Group__1__Impl"


    // $ANTLR start "rule__WordConst__Group__0"
    // InternalMIC.g:1223:1: rule__WordConst__Group__0 : rule__WordConst__Group__0__Impl rule__WordConst__Group__1 ;
    public final void rule__WordConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1227:1: ( rule__WordConst__Group__0__Impl rule__WordConst__Group__1 )
            // InternalMIC.g:1228:2: rule__WordConst__Group__0__Impl rule__WordConst__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__WordConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WordConst__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__0"


    // $ANTLR start "rule__WordConst__Group__0__Impl"
    // InternalMIC.g:1235:1: rule__WordConst__Group__0__Impl : ( 'WordK' ) ;
    public final void rule__WordConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1239:1: ( ( 'WordK' ) )
            // InternalMIC.g:1240:1: ( 'WordK' )
            {
            // InternalMIC.g:1240:1: ( 'WordK' )
            // InternalMIC.g:1241:2: 'WordK'
            {
             before(grammarAccess.getWordConstAccess().getWordKKeyword_0()); 
            match(input,30,FOLLOW_2); 
             after(grammarAccess.getWordConstAccess().getWordKKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__0__Impl"


    // $ANTLR start "rule__WordConst__Group__1"
    // InternalMIC.g:1250:1: rule__WordConst__Group__1 : rule__WordConst__Group__1__Impl rule__WordConst__Group__2 ;
    public final void rule__WordConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1254:1: ( rule__WordConst__Group__1__Impl rule__WordConst__Group__2 )
            // InternalMIC.g:1255:2: rule__WordConst__Group__1__Impl rule__WordConst__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__WordConst__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WordConst__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__1"


    // $ANTLR start "rule__WordConst__Group__1__Impl"
    // InternalMIC.g:1262:1: rule__WordConst__Group__1__Impl : ( ( rule__WordConst__NameAssignment_1 ) ) ;
    public final void rule__WordConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1266:1: ( ( ( rule__WordConst__NameAssignment_1 ) ) )
            // InternalMIC.g:1267:1: ( ( rule__WordConst__NameAssignment_1 ) )
            {
            // InternalMIC.g:1267:1: ( ( rule__WordConst__NameAssignment_1 ) )
            // InternalMIC.g:1268:2: ( rule__WordConst__NameAssignment_1 )
            {
             before(grammarAccess.getWordConstAccess().getNameAssignment_1()); 
            // InternalMIC.g:1269:2: ( rule__WordConst__NameAssignment_1 )
            // InternalMIC.g:1269:3: rule__WordConst__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__WordConst__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getWordConstAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__1__Impl"


    // $ANTLR start "rule__WordConst__Group__2"
    // InternalMIC.g:1277:1: rule__WordConst__Group__2 : rule__WordConst__Group__2__Impl rule__WordConst__Group__3 ;
    public final void rule__WordConst__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1281:1: ( rule__WordConst__Group__2__Impl rule__WordConst__Group__3 )
            // InternalMIC.g:1282:2: rule__WordConst__Group__2__Impl rule__WordConst__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__WordConst__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WordConst__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__2"


    // $ANTLR start "rule__WordConst__Group__2__Impl"
    // InternalMIC.g:1289:1: rule__WordConst__Group__2__Impl : ( '(' ) ;
    public final void rule__WordConst__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1293:1: ( ( '(' ) )
            // InternalMIC.g:1294:1: ( '(' )
            {
            // InternalMIC.g:1294:1: ( '(' )
            // InternalMIC.g:1295:2: '('
            {
             before(grammarAccess.getWordConstAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getWordConstAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__2__Impl"


    // $ANTLR start "rule__WordConst__Group__3"
    // InternalMIC.g:1304:1: rule__WordConst__Group__3 : rule__WordConst__Group__3__Impl rule__WordConst__Group__4 ;
    public final void rule__WordConst__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1308:1: ( rule__WordConst__Group__3__Impl rule__WordConst__Group__4 )
            // InternalMIC.g:1309:2: rule__WordConst__Group__3__Impl rule__WordConst__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__WordConst__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__WordConst__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__3"


    // $ANTLR start "rule__WordConst__Group__3__Impl"
    // InternalMIC.g:1316:1: rule__WordConst__Group__3__Impl : ( ( rule__WordConst__ValueAssignment_3 ) ) ;
    public final void rule__WordConst__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1320:1: ( ( ( rule__WordConst__ValueAssignment_3 ) ) )
            // InternalMIC.g:1321:1: ( ( rule__WordConst__ValueAssignment_3 ) )
            {
            // InternalMIC.g:1321:1: ( ( rule__WordConst__ValueAssignment_3 ) )
            // InternalMIC.g:1322:2: ( rule__WordConst__ValueAssignment_3 )
            {
             before(grammarAccess.getWordConstAccess().getValueAssignment_3()); 
            // InternalMIC.g:1323:2: ( rule__WordConst__ValueAssignment_3 )
            // InternalMIC.g:1323:3: rule__WordConst__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__WordConst__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getWordConstAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__3__Impl"


    // $ANTLR start "rule__WordConst__Group__4"
    // InternalMIC.g:1331:1: rule__WordConst__Group__4 : rule__WordConst__Group__4__Impl ;
    public final void rule__WordConst__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1335:1: ( rule__WordConst__Group__4__Impl )
            // InternalMIC.g:1336:2: rule__WordConst__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__WordConst__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__4"


    // $ANTLR start "rule__WordConst__Group__4__Impl"
    // InternalMIC.g:1342:1: rule__WordConst__Group__4__Impl : ( ')' ) ;
    public final void rule__WordConst__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1346:1: ( ( ')' ) )
            // InternalMIC.g:1347:1: ( ')' )
            {
            // InternalMIC.g:1347:1: ( ')' )
            // InternalMIC.g:1348:2: ')'
            {
             before(grammarAccess.getWordConstAccess().getRightParenthesisKeyword_4()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getWordConstAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__Group__4__Impl"


    // $ANTLR start "rule__FloatVar__Group__0"
    // InternalMIC.g:1358:1: rule__FloatVar__Group__0 : rule__FloatVar__Group__0__Impl rule__FloatVar__Group__1 ;
    public final void rule__FloatVar__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1362:1: ( rule__FloatVar__Group__0__Impl rule__FloatVar__Group__1 )
            // InternalMIC.g:1363:2: rule__FloatVar__Group__0__Impl rule__FloatVar__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FloatVar__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FloatVar__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatVar__Group__0"


    // $ANTLR start "rule__FloatVar__Group__0__Impl"
    // InternalMIC.g:1370:1: rule__FloatVar__Group__0__Impl : ( 'FloatV' ) ;
    public final void rule__FloatVar__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1374:1: ( ( 'FloatV' ) )
            // InternalMIC.g:1375:1: ( 'FloatV' )
            {
            // InternalMIC.g:1375:1: ( 'FloatV' )
            // InternalMIC.g:1376:2: 'FloatV'
            {
             before(grammarAccess.getFloatVarAccess().getFloatVKeyword_0()); 
            match(input,31,FOLLOW_2); 
             after(grammarAccess.getFloatVarAccess().getFloatVKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatVar__Group__0__Impl"


    // $ANTLR start "rule__FloatVar__Group__1"
    // InternalMIC.g:1385:1: rule__FloatVar__Group__1 : rule__FloatVar__Group__1__Impl ;
    public final void rule__FloatVar__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1389:1: ( rule__FloatVar__Group__1__Impl )
            // InternalMIC.g:1390:2: rule__FloatVar__Group__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FloatVar__Group__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatVar__Group__1"


    // $ANTLR start "rule__FloatVar__Group__1__Impl"
    // InternalMIC.g:1396:1: rule__FloatVar__Group__1__Impl : ( ( rule__FloatVar__NameAssignment_1 ) ) ;
    public final void rule__FloatVar__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1400:1: ( ( ( rule__FloatVar__NameAssignment_1 ) ) )
            // InternalMIC.g:1401:1: ( ( rule__FloatVar__NameAssignment_1 ) )
            {
            // InternalMIC.g:1401:1: ( ( rule__FloatVar__NameAssignment_1 ) )
            // InternalMIC.g:1402:2: ( rule__FloatVar__NameAssignment_1 )
            {
             before(grammarAccess.getFloatVarAccess().getNameAssignment_1()); 
            // InternalMIC.g:1403:2: ( rule__FloatVar__NameAssignment_1 )
            // InternalMIC.g:1403:3: rule__FloatVar__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FloatVar__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFloatVarAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatVar__Group__1__Impl"


    // $ANTLR start "rule__FloatConst__Group__0"
    // InternalMIC.g:1412:1: rule__FloatConst__Group__0 : rule__FloatConst__Group__0__Impl rule__FloatConst__Group__1 ;
    public final void rule__FloatConst__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1416:1: ( rule__FloatConst__Group__0__Impl rule__FloatConst__Group__1 )
            // InternalMIC.g:1417:2: rule__FloatConst__Group__0__Impl rule__FloatConst__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FloatConst__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FloatConst__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__0"


    // $ANTLR start "rule__FloatConst__Group__0__Impl"
    // InternalMIC.g:1424:1: rule__FloatConst__Group__0__Impl : ( 'FloatK' ) ;
    public final void rule__FloatConst__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1428:1: ( ( 'FloatK' ) )
            // InternalMIC.g:1429:1: ( 'FloatK' )
            {
            // InternalMIC.g:1429:1: ( 'FloatK' )
            // InternalMIC.g:1430:2: 'FloatK'
            {
             before(grammarAccess.getFloatConstAccess().getFloatKKeyword_0()); 
            match(input,32,FOLLOW_2); 
             after(grammarAccess.getFloatConstAccess().getFloatKKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__0__Impl"


    // $ANTLR start "rule__FloatConst__Group__1"
    // InternalMIC.g:1439:1: rule__FloatConst__Group__1 : rule__FloatConst__Group__1__Impl rule__FloatConst__Group__2 ;
    public final void rule__FloatConst__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1443:1: ( rule__FloatConst__Group__1__Impl rule__FloatConst__Group__2 )
            // InternalMIC.g:1444:2: rule__FloatConst__Group__1__Impl rule__FloatConst__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FloatConst__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FloatConst__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__1"


    // $ANTLR start "rule__FloatConst__Group__1__Impl"
    // InternalMIC.g:1451:1: rule__FloatConst__Group__1__Impl : ( ( rule__FloatConst__NameAssignment_1 ) ) ;
    public final void rule__FloatConst__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1455:1: ( ( ( rule__FloatConst__NameAssignment_1 ) ) )
            // InternalMIC.g:1456:1: ( ( rule__FloatConst__NameAssignment_1 ) )
            {
            // InternalMIC.g:1456:1: ( ( rule__FloatConst__NameAssignment_1 ) )
            // InternalMIC.g:1457:2: ( rule__FloatConst__NameAssignment_1 )
            {
             before(grammarAccess.getFloatConstAccess().getNameAssignment_1()); 
            // InternalMIC.g:1458:2: ( rule__FloatConst__NameAssignment_1 )
            // InternalMIC.g:1458:3: rule__FloatConst__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FloatConst__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFloatConstAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__1__Impl"


    // $ANTLR start "rule__FloatConst__Group__2"
    // InternalMIC.g:1466:1: rule__FloatConst__Group__2 : rule__FloatConst__Group__2__Impl rule__FloatConst__Group__3 ;
    public final void rule__FloatConst__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1470:1: ( rule__FloatConst__Group__2__Impl rule__FloatConst__Group__3 )
            // InternalMIC.g:1471:2: rule__FloatConst__Group__2__Impl rule__FloatConst__Group__3
            {
            pushFollow(FOLLOW_14);
            rule__FloatConst__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FloatConst__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__2"


    // $ANTLR start "rule__FloatConst__Group__2__Impl"
    // InternalMIC.g:1478:1: rule__FloatConst__Group__2__Impl : ( '(' ) ;
    public final void rule__FloatConst__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1482:1: ( ( '(' ) )
            // InternalMIC.g:1483:1: ( '(' )
            {
            // InternalMIC.g:1483:1: ( '(' )
            // InternalMIC.g:1484:2: '('
            {
             before(grammarAccess.getFloatConstAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getFloatConstAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__2__Impl"


    // $ANTLR start "rule__FloatConst__Group__3"
    // InternalMIC.g:1493:1: rule__FloatConst__Group__3 : rule__FloatConst__Group__3__Impl rule__FloatConst__Group__4 ;
    public final void rule__FloatConst__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1497:1: ( rule__FloatConst__Group__3__Impl rule__FloatConst__Group__4 )
            // InternalMIC.g:1498:2: rule__FloatConst__Group__3__Impl rule__FloatConst__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__FloatConst__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FloatConst__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__3"


    // $ANTLR start "rule__FloatConst__Group__3__Impl"
    // InternalMIC.g:1505:1: rule__FloatConst__Group__3__Impl : ( ( rule__FloatConst__ValueAssignment_3 ) ) ;
    public final void rule__FloatConst__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1509:1: ( ( ( rule__FloatConst__ValueAssignment_3 ) ) )
            // InternalMIC.g:1510:1: ( ( rule__FloatConst__ValueAssignment_3 ) )
            {
            // InternalMIC.g:1510:1: ( ( rule__FloatConst__ValueAssignment_3 ) )
            // InternalMIC.g:1511:2: ( rule__FloatConst__ValueAssignment_3 )
            {
             before(grammarAccess.getFloatConstAccess().getValueAssignment_3()); 
            // InternalMIC.g:1512:2: ( rule__FloatConst__ValueAssignment_3 )
            // InternalMIC.g:1512:3: rule__FloatConst__ValueAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FloatConst__ValueAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFloatConstAccess().getValueAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__3__Impl"


    // $ANTLR start "rule__FloatConst__Group__4"
    // InternalMIC.g:1520:1: rule__FloatConst__Group__4 : rule__FloatConst__Group__4__Impl ;
    public final void rule__FloatConst__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1524:1: ( rule__FloatConst__Group__4__Impl )
            // InternalMIC.g:1525:2: rule__FloatConst__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FloatConst__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__4"


    // $ANTLR start "rule__FloatConst__Group__4__Impl"
    // InternalMIC.g:1531:1: rule__FloatConst__Group__4__Impl : ( ')' ) ;
    public final void rule__FloatConst__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1535:1: ( ( ')' ) )
            // InternalMIC.g:1536:1: ( ')' )
            {
            // InternalMIC.g:1536:1: ( ')' )
            // InternalMIC.g:1537:2: ')'
            {
             before(grammarAccess.getFloatConstAccess().getRightParenthesisKeyword_4()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getFloatConstAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__Group__4__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__0"
    // InternalMIC.g:1547:1: rule__FGAMessageConstantReference__Group__0 : rule__FGAMessageConstantReference__Group__0__Impl rule__FGAMessageConstantReference__Group__1 ;
    public final void rule__FGAMessageConstantReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1551:1: ( rule__FGAMessageConstantReference__Group__0__Impl rule__FGAMessageConstantReference__Group__1 )
            // InternalMIC.g:1552:2: rule__FGAMessageConstantReference__Group__0__Impl rule__FGAMessageConstantReference__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FGAMessageConstantReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__0"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__0__Impl"
    // InternalMIC.g:1559:1: rule__FGAMessageConstantReference__Group__0__Impl : ( 'IPAMB' ) ;
    public final void rule__FGAMessageConstantReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1563:1: ( ( 'IPAMB' ) )
            // InternalMIC.g:1564:1: ( 'IPAMB' )
            {
            // InternalMIC.g:1564:1: ( 'IPAMB' )
            // InternalMIC.g:1565:2: 'IPAMB'
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getIPAMBKeyword_0()); 
            match(input,33,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getIPAMBKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__0__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__1"
    // InternalMIC.g:1574:1: rule__FGAMessageConstantReference__Group__1 : rule__FGAMessageConstantReference__Group__1__Impl rule__FGAMessageConstantReference__Group__2 ;
    public final void rule__FGAMessageConstantReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1578:1: ( rule__FGAMessageConstantReference__Group__1__Impl rule__FGAMessageConstantReference__Group__2 )
            // InternalMIC.g:1579:2: rule__FGAMessageConstantReference__Group__1__Impl rule__FGAMessageConstantReference__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FGAMessageConstantReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__1"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__1__Impl"
    // InternalMIC.g:1586:1: rule__FGAMessageConstantReference__Group__1__Impl : ( ( rule__FGAMessageConstantReference__NameAssignment_1 ) ) ;
    public final void rule__FGAMessageConstantReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1590:1: ( ( ( rule__FGAMessageConstantReference__NameAssignment_1 ) ) )
            // InternalMIC.g:1591:1: ( ( rule__FGAMessageConstantReference__NameAssignment_1 ) )
            {
            // InternalMIC.g:1591:1: ( ( rule__FGAMessageConstantReference__NameAssignment_1 ) )
            // InternalMIC.g:1592:2: ( rule__FGAMessageConstantReference__NameAssignment_1 )
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getNameAssignment_1()); 
            // InternalMIC.g:1593:2: ( rule__FGAMessageConstantReference__NameAssignment_1 )
            // InternalMIC.g:1593:3: rule__FGAMessageConstantReference__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFGAMessageConstantReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__1__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__2"
    // InternalMIC.g:1601:1: rule__FGAMessageConstantReference__Group__2 : rule__FGAMessageConstantReference__Group__2__Impl rule__FGAMessageConstantReference__Group__3 ;
    public final void rule__FGAMessageConstantReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1605:1: ( rule__FGAMessageConstantReference__Group__2__Impl rule__FGAMessageConstantReference__Group__3 )
            // InternalMIC.g:1606:2: rule__FGAMessageConstantReference__Group__2__Impl rule__FGAMessageConstantReference__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__FGAMessageConstantReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__2"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__2__Impl"
    // InternalMIC.g:1613:1: rule__FGAMessageConstantReference__Group__2__Impl : ( '(' ) ;
    public final void rule__FGAMessageConstantReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1617:1: ( ( '(' ) )
            // InternalMIC.g:1618:1: ( '(' )
            {
            // InternalMIC.g:1618:1: ( '(' )
            // InternalMIC.g:1619:2: '('
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__2__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__3"
    // InternalMIC.g:1628:1: rule__FGAMessageConstantReference__Group__3 : rule__FGAMessageConstantReference__Group__3__Impl rule__FGAMessageConstantReference__Group__4 ;
    public final void rule__FGAMessageConstantReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1632:1: ( rule__FGAMessageConstantReference__Group__3__Impl rule__FGAMessageConstantReference__Group__4 )
            // InternalMIC.g:1633:2: rule__FGAMessageConstantReference__Group__3__Impl rule__FGAMessageConstantReference__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__FGAMessageConstantReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__3"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__3__Impl"
    // InternalMIC.g:1640:1: rule__FGAMessageConstantReference__Group__3__Impl : ( ( rule__FGAMessageConstantReference__RowAssignment_3 ) ) ;
    public final void rule__FGAMessageConstantReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1644:1: ( ( ( rule__FGAMessageConstantReference__RowAssignment_3 ) ) )
            // InternalMIC.g:1645:1: ( ( rule__FGAMessageConstantReference__RowAssignment_3 ) )
            {
            // InternalMIC.g:1645:1: ( ( rule__FGAMessageConstantReference__RowAssignment_3 ) )
            // InternalMIC.g:1646:2: ( rule__FGAMessageConstantReference__RowAssignment_3 )
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getRowAssignment_3()); 
            // InternalMIC.g:1647:2: ( rule__FGAMessageConstantReference__RowAssignment_3 )
            // InternalMIC.g:1647:3: rule__FGAMessageConstantReference__RowAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__RowAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFGAMessageConstantReferenceAccess().getRowAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__3__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__4"
    // InternalMIC.g:1655:1: rule__FGAMessageConstantReference__Group__4 : rule__FGAMessageConstantReference__Group__4__Impl rule__FGAMessageConstantReference__Group__5 ;
    public final void rule__FGAMessageConstantReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1659:1: ( rule__FGAMessageConstantReference__Group__4__Impl rule__FGAMessageConstantReference__Group__5 )
            // InternalMIC.g:1660:2: rule__FGAMessageConstantReference__Group__4__Impl rule__FGAMessageConstantReference__Group__5
            {
            pushFollow(FOLLOW_8);
            rule__FGAMessageConstantReference__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__4"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__4__Impl"
    // InternalMIC.g:1667:1: rule__FGAMessageConstantReference__Group__4__Impl : ( ',' ) ;
    public final void rule__FGAMessageConstantReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1671:1: ( ( ',' ) )
            // InternalMIC.g:1672:1: ( ',' )
            {
            // InternalMIC.g:1672:1: ( ',' )
            // InternalMIC.g:1673:2: ','
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getCommaKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__4__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__5"
    // InternalMIC.g:1682:1: rule__FGAMessageConstantReference__Group__5 : rule__FGAMessageConstantReference__Group__5__Impl rule__FGAMessageConstantReference__Group__6 ;
    public final void rule__FGAMessageConstantReference__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1686:1: ( rule__FGAMessageConstantReference__Group__5__Impl rule__FGAMessageConstantReference__Group__6 )
            // InternalMIC.g:1687:2: rule__FGAMessageConstantReference__Group__5__Impl rule__FGAMessageConstantReference__Group__6
            {
            pushFollow(FOLLOW_9);
            rule__FGAMessageConstantReference__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__5"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__5__Impl"
    // InternalMIC.g:1694:1: rule__FGAMessageConstantReference__Group__5__Impl : ( ( rule__FGAMessageConstantReference__ColumnAssignment_5 ) ) ;
    public final void rule__FGAMessageConstantReference__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1698:1: ( ( ( rule__FGAMessageConstantReference__ColumnAssignment_5 ) ) )
            // InternalMIC.g:1699:1: ( ( rule__FGAMessageConstantReference__ColumnAssignment_5 ) )
            {
            // InternalMIC.g:1699:1: ( ( rule__FGAMessageConstantReference__ColumnAssignment_5 ) )
            // InternalMIC.g:1700:2: ( rule__FGAMessageConstantReference__ColumnAssignment_5 )
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getColumnAssignment_5()); 
            // InternalMIC.g:1701:2: ( rule__FGAMessageConstantReference__ColumnAssignment_5 )
            // InternalMIC.g:1701:3: rule__FGAMessageConstantReference__ColumnAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__ColumnAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getFGAMessageConstantReferenceAccess().getColumnAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__5__Impl"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__6"
    // InternalMIC.g:1709:1: rule__FGAMessageConstantReference__Group__6 : rule__FGAMessageConstantReference__Group__6__Impl ;
    public final void rule__FGAMessageConstantReference__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1713:1: ( rule__FGAMessageConstantReference__Group__6__Impl )
            // InternalMIC.g:1714:2: rule__FGAMessageConstantReference__Group__6__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FGAMessageConstantReference__Group__6__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__6"


    // $ANTLR start "rule__FGAMessageConstantReference__Group__6__Impl"
    // InternalMIC.g:1720:1: rule__FGAMessageConstantReference__Group__6__Impl : ( ')' ) ;
    public final void rule__FGAMessageConstantReference__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1724:1: ( ( ')' ) )
            // InternalMIC.g:1725:1: ( ')' )
            {
            // InternalMIC.g:1725:1: ( ')' )
            // InternalMIC.g:1726:2: ')'
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getRightParenthesisKeyword_6()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getRightParenthesisKeyword_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__Group__6__Impl"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__0"
    // InternalMIC.g:1736:1: rule__FGAAnalogValueReference__Group__0 : rule__FGAAnalogValueReference__Group__0__Impl rule__FGAAnalogValueReference__Group__1 ;
    public final void rule__FGAAnalogValueReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1740:1: ( rule__FGAAnalogValueReference__Group__0__Impl rule__FGAAnalogValueReference__Group__1 )
            // InternalMIC.g:1741:2: rule__FGAAnalogValueReference__Group__0__Impl rule__FGAAnalogValueReference__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FGAAnalogValueReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__0"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__0__Impl"
    // InternalMIC.g:1748:1: rule__FGAAnalogValueReference__Group__0__Impl : ( 'IPAAW' ) ;
    public final void rule__FGAAnalogValueReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1752:1: ( ( 'IPAAW' ) )
            // InternalMIC.g:1753:1: ( 'IPAAW' )
            {
            // InternalMIC.g:1753:1: ( 'IPAAW' )
            // InternalMIC.g:1754:2: 'IPAAW'
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getIPAAWKeyword_0()); 
            match(input,34,FOLLOW_2); 
             after(grammarAccess.getFGAAnalogValueReferenceAccess().getIPAAWKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__0__Impl"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__1"
    // InternalMIC.g:1763:1: rule__FGAAnalogValueReference__Group__1 : rule__FGAAnalogValueReference__Group__1__Impl rule__FGAAnalogValueReference__Group__2 ;
    public final void rule__FGAAnalogValueReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1767:1: ( rule__FGAAnalogValueReference__Group__1__Impl rule__FGAAnalogValueReference__Group__2 )
            // InternalMIC.g:1768:2: rule__FGAAnalogValueReference__Group__1__Impl rule__FGAAnalogValueReference__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FGAAnalogValueReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__1"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__1__Impl"
    // InternalMIC.g:1775:1: rule__FGAAnalogValueReference__Group__1__Impl : ( ( rule__FGAAnalogValueReference__NameAssignment_1 ) ) ;
    public final void rule__FGAAnalogValueReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1779:1: ( ( ( rule__FGAAnalogValueReference__NameAssignment_1 ) ) )
            // InternalMIC.g:1780:1: ( ( rule__FGAAnalogValueReference__NameAssignment_1 ) )
            {
            // InternalMIC.g:1780:1: ( ( rule__FGAAnalogValueReference__NameAssignment_1 ) )
            // InternalMIC.g:1781:2: ( rule__FGAAnalogValueReference__NameAssignment_1 )
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getNameAssignment_1()); 
            // InternalMIC.g:1782:2: ( rule__FGAAnalogValueReference__NameAssignment_1 )
            // InternalMIC.g:1782:3: rule__FGAAnalogValueReference__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFGAAnalogValueReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__1__Impl"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__2"
    // InternalMIC.g:1790:1: rule__FGAAnalogValueReference__Group__2 : rule__FGAAnalogValueReference__Group__2__Impl rule__FGAAnalogValueReference__Group__3 ;
    public final void rule__FGAAnalogValueReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1794:1: ( rule__FGAAnalogValueReference__Group__2__Impl rule__FGAAnalogValueReference__Group__3 )
            // InternalMIC.g:1795:2: rule__FGAAnalogValueReference__Group__2__Impl rule__FGAAnalogValueReference__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__FGAAnalogValueReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__2"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__2__Impl"
    // InternalMIC.g:1802:1: rule__FGAAnalogValueReference__Group__2__Impl : ( '(' ) ;
    public final void rule__FGAAnalogValueReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1806:1: ( ( '(' ) )
            // InternalMIC.g:1807:1: ( '(' )
            {
            // InternalMIC.g:1807:1: ( '(' )
            // InternalMIC.g:1808:2: '('
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getFGAAnalogValueReferenceAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__2__Impl"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__3"
    // InternalMIC.g:1817:1: rule__FGAAnalogValueReference__Group__3 : rule__FGAAnalogValueReference__Group__3__Impl rule__FGAAnalogValueReference__Group__4 ;
    public final void rule__FGAAnalogValueReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1821:1: ( rule__FGAAnalogValueReference__Group__3__Impl rule__FGAAnalogValueReference__Group__4 )
            // InternalMIC.g:1822:2: rule__FGAAnalogValueReference__Group__3__Impl rule__FGAAnalogValueReference__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__FGAAnalogValueReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__3"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__3__Impl"
    // InternalMIC.g:1829:1: rule__FGAAnalogValueReference__Group__3__Impl : ( ( rule__FGAAnalogValueReference__RowAssignment_3 ) ) ;
    public final void rule__FGAAnalogValueReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1833:1: ( ( ( rule__FGAAnalogValueReference__RowAssignment_3 ) ) )
            // InternalMIC.g:1834:1: ( ( rule__FGAAnalogValueReference__RowAssignment_3 ) )
            {
            // InternalMIC.g:1834:1: ( ( rule__FGAAnalogValueReference__RowAssignment_3 ) )
            // InternalMIC.g:1835:2: ( rule__FGAAnalogValueReference__RowAssignment_3 )
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getRowAssignment_3()); 
            // InternalMIC.g:1836:2: ( rule__FGAAnalogValueReference__RowAssignment_3 )
            // InternalMIC.g:1836:3: rule__FGAAnalogValueReference__RowAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__RowAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFGAAnalogValueReferenceAccess().getRowAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__3__Impl"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__4"
    // InternalMIC.g:1844:1: rule__FGAAnalogValueReference__Group__4 : rule__FGAAnalogValueReference__Group__4__Impl ;
    public final void rule__FGAAnalogValueReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1848:1: ( rule__FGAAnalogValueReference__Group__4__Impl )
            // InternalMIC.g:1849:2: rule__FGAAnalogValueReference__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FGAAnalogValueReference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__4"


    // $ANTLR start "rule__FGAAnalogValueReference__Group__4__Impl"
    // InternalMIC.g:1855:1: rule__FGAAnalogValueReference__Group__4__Impl : ( ')' ) ;
    public final void rule__FGAAnalogValueReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1859:1: ( ( ')' ) )
            // InternalMIC.g:1860:1: ( ')' )
            {
            // InternalMIC.g:1860:1: ( ')' )
            // InternalMIC.g:1861:2: ')'
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getRightParenthesisKeyword_4()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getFGAAnalogValueReferenceAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__Group__4__Impl"


    // $ANTLR start "rule__FGAValueReference__Group__0"
    // InternalMIC.g:1871:1: rule__FGAValueReference__Group__0 : rule__FGAValueReference__Group__0__Impl rule__FGAValueReference__Group__1 ;
    public final void rule__FGAValueReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1875:1: ( rule__FGAValueReference__Group__0__Impl rule__FGAValueReference__Group__1 )
            // InternalMIC.g:1876:2: rule__FGAValueReference__Group__0__Impl rule__FGAValueReference__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FGAValueReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAValueReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__0"


    // $ANTLR start "rule__FGAValueReference__Group__0__Impl"
    // InternalMIC.g:1883:1: rule__FGAValueReference__Group__0__Impl : ( 'IPAZW' ) ;
    public final void rule__FGAValueReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1887:1: ( ( 'IPAZW' ) )
            // InternalMIC.g:1888:1: ( 'IPAZW' )
            {
            // InternalMIC.g:1888:1: ( 'IPAZW' )
            // InternalMIC.g:1889:2: 'IPAZW'
            {
             before(grammarAccess.getFGAValueReferenceAccess().getIPAZWKeyword_0()); 
            match(input,35,FOLLOW_2); 
             after(grammarAccess.getFGAValueReferenceAccess().getIPAZWKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__0__Impl"


    // $ANTLR start "rule__FGAValueReference__Group__1"
    // InternalMIC.g:1898:1: rule__FGAValueReference__Group__1 : rule__FGAValueReference__Group__1__Impl rule__FGAValueReference__Group__2 ;
    public final void rule__FGAValueReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1902:1: ( rule__FGAValueReference__Group__1__Impl rule__FGAValueReference__Group__2 )
            // InternalMIC.g:1903:2: rule__FGAValueReference__Group__1__Impl rule__FGAValueReference__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FGAValueReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAValueReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__1"


    // $ANTLR start "rule__FGAValueReference__Group__1__Impl"
    // InternalMIC.g:1910:1: rule__FGAValueReference__Group__1__Impl : ( ( rule__FGAValueReference__NameAssignment_1 ) ) ;
    public final void rule__FGAValueReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1914:1: ( ( ( rule__FGAValueReference__NameAssignment_1 ) ) )
            // InternalMIC.g:1915:1: ( ( rule__FGAValueReference__NameAssignment_1 ) )
            {
            // InternalMIC.g:1915:1: ( ( rule__FGAValueReference__NameAssignment_1 ) )
            // InternalMIC.g:1916:2: ( rule__FGAValueReference__NameAssignment_1 )
            {
             before(grammarAccess.getFGAValueReferenceAccess().getNameAssignment_1()); 
            // InternalMIC.g:1917:2: ( rule__FGAValueReference__NameAssignment_1 )
            // InternalMIC.g:1917:3: rule__FGAValueReference__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FGAValueReference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFGAValueReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__1__Impl"


    // $ANTLR start "rule__FGAValueReference__Group__2"
    // InternalMIC.g:1925:1: rule__FGAValueReference__Group__2 : rule__FGAValueReference__Group__2__Impl rule__FGAValueReference__Group__3 ;
    public final void rule__FGAValueReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1929:1: ( rule__FGAValueReference__Group__2__Impl rule__FGAValueReference__Group__3 )
            // InternalMIC.g:1930:2: rule__FGAValueReference__Group__2__Impl rule__FGAValueReference__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__FGAValueReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAValueReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__2"


    // $ANTLR start "rule__FGAValueReference__Group__2__Impl"
    // InternalMIC.g:1937:1: rule__FGAValueReference__Group__2__Impl : ( '(' ) ;
    public final void rule__FGAValueReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1941:1: ( ( '(' ) )
            // InternalMIC.g:1942:1: ( '(' )
            {
            // InternalMIC.g:1942:1: ( '(' )
            // InternalMIC.g:1943:2: '('
            {
             before(grammarAccess.getFGAValueReferenceAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getFGAValueReferenceAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__2__Impl"


    // $ANTLR start "rule__FGAValueReference__Group__3"
    // InternalMIC.g:1952:1: rule__FGAValueReference__Group__3 : rule__FGAValueReference__Group__3__Impl rule__FGAValueReference__Group__4 ;
    public final void rule__FGAValueReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1956:1: ( rule__FGAValueReference__Group__3__Impl rule__FGAValueReference__Group__4 )
            // InternalMIC.g:1957:2: rule__FGAValueReference__Group__3__Impl rule__FGAValueReference__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__FGAValueReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAValueReference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__3"


    // $ANTLR start "rule__FGAValueReference__Group__3__Impl"
    // InternalMIC.g:1964:1: rule__FGAValueReference__Group__3__Impl : ( ( rule__FGAValueReference__RowAssignment_3 ) ) ;
    public final void rule__FGAValueReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1968:1: ( ( ( rule__FGAValueReference__RowAssignment_3 ) ) )
            // InternalMIC.g:1969:1: ( ( rule__FGAValueReference__RowAssignment_3 ) )
            {
            // InternalMIC.g:1969:1: ( ( rule__FGAValueReference__RowAssignment_3 ) )
            // InternalMIC.g:1970:2: ( rule__FGAValueReference__RowAssignment_3 )
            {
             before(grammarAccess.getFGAValueReferenceAccess().getRowAssignment_3()); 
            // InternalMIC.g:1971:2: ( rule__FGAValueReference__RowAssignment_3 )
            // InternalMIC.g:1971:3: rule__FGAValueReference__RowAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FGAValueReference__RowAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFGAValueReferenceAccess().getRowAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__3__Impl"


    // $ANTLR start "rule__FGAValueReference__Group__4"
    // InternalMIC.g:1979:1: rule__FGAValueReference__Group__4 : rule__FGAValueReference__Group__4__Impl ;
    public final void rule__FGAValueReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1983:1: ( rule__FGAValueReference__Group__4__Impl )
            // InternalMIC.g:1984:2: rule__FGAValueReference__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FGAValueReference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__4"


    // $ANTLR start "rule__FGAValueReference__Group__4__Impl"
    // InternalMIC.g:1990:1: rule__FGAValueReference__Group__4__Impl : ( ')' ) ;
    public final void rule__FGAValueReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:1994:1: ( ( ')' ) )
            // InternalMIC.g:1995:1: ( ')' )
            {
            // InternalMIC.g:1995:1: ( ')' )
            // InternalMIC.g:1996:2: ')'
            {
             before(grammarAccess.getFGAValueReferenceAccess().getRightParenthesisKeyword_4()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getFGAValueReferenceAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__Group__4__Impl"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__0"
    // InternalMIC.g:2006:1: rule__FGAMeasuredValueReference__Group__0 : rule__FGAMeasuredValueReference__Group__0__Impl rule__FGAMeasuredValueReference__Group__1 ;
    public final void rule__FGAMeasuredValueReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2010:1: ( rule__FGAMeasuredValueReference__Group__0__Impl rule__FGAMeasuredValueReference__Group__1 )
            // InternalMIC.g:2011:2: rule__FGAMeasuredValueReference__Group__0__Impl rule__FGAMeasuredValueReference__Group__1
            {
            pushFollow(FOLLOW_6);
            rule__FGAMeasuredValueReference__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__0"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__0__Impl"
    // InternalMIC.g:2018:1: rule__FGAMeasuredValueReference__Group__0__Impl : ( 'IPAMW' ) ;
    public final void rule__FGAMeasuredValueReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2022:1: ( ( 'IPAMW' ) )
            // InternalMIC.g:2023:1: ( 'IPAMW' )
            {
            // InternalMIC.g:2023:1: ( 'IPAMW' )
            // InternalMIC.g:2024:2: 'IPAMW'
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getIPAMWKeyword_0()); 
            match(input,36,FOLLOW_2); 
             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getIPAMWKeyword_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__0__Impl"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__1"
    // InternalMIC.g:2033:1: rule__FGAMeasuredValueReference__Group__1 : rule__FGAMeasuredValueReference__Group__1__Impl rule__FGAMeasuredValueReference__Group__2 ;
    public final void rule__FGAMeasuredValueReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2037:1: ( rule__FGAMeasuredValueReference__Group__1__Impl rule__FGAMeasuredValueReference__Group__2 )
            // InternalMIC.g:2038:2: rule__FGAMeasuredValueReference__Group__1__Impl rule__FGAMeasuredValueReference__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__FGAMeasuredValueReference__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__1"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__1__Impl"
    // InternalMIC.g:2045:1: rule__FGAMeasuredValueReference__Group__1__Impl : ( ( rule__FGAMeasuredValueReference__NameAssignment_1 ) ) ;
    public final void rule__FGAMeasuredValueReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2049:1: ( ( ( rule__FGAMeasuredValueReference__NameAssignment_1 ) ) )
            // InternalMIC.g:2050:1: ( ( rule__FGAMeasuredValueReference__NameAssignment_1 ) )
            {
            // InternalMIC.g:2050:1: ( ( rule__FGAMeasuredValueReference__NameAssignment_1 ) )
            // InternalMIC.g:2051:2: ( rule__FGAMeasuredValueReference__NameAssignment_1 )
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getNameAssignment_1()); 
            // InternalMIC.g:2052:2: ( rule__FGAMeasuredValueReference__NameAssignment_1 )
            // InternalMIC.g:2052:3: rule__FGAMeasuredValueReference__NameAssignment_1
            {
            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__NameAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__1__Impl"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__2"
    // InternalMIC.g:2060:1: rule__FGAMeasuredValueReference__Group__2 : rule__FGAMeasuredValueReference__Group__2__Impl rule__FGAMeasuredValueReference__Group__3 ;
    public final void rule__FGAMeasuredValueReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2064:1: ( rule__FGAMeasuredValueReference__Group__2__Impl rule__FGAMeasuredValueReference__Group__3 )
            // InternalMIC.g:2065:2: rule__FGAMeasuredValueReference__Group__2__Impl rule__FGAMeasuredValueReference__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__FGAMeasuredValueReference__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__2"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__2__Impl"
    // InternalMIC.g:2072:1: rule__FGAMeasuredValueReference__Group__2__Impl : ( '(' ) ;
    public final void rule__FGAMeasuredValueReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2076:1: ( ( '(' ) )
            // InternalMIC.g:2077:1: ( '(' )
            {
            // InternalMIC.g:2077:1: ( '(' )
            // InternalMIC.g:2078:2: '('
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__2__Impl"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__3"
    // InternalMIC.g:2087:1: rule__FGAMeasuredValueReference__Group__3 : rule__FGAMeasuredValueReference__Group__3__Impl rule__FGAMeasuredValueReference__Group__4 ;
    public final void rule__FGAMeasuredValueReference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2091:1: ( rule__FGAMeasuredValueReference__Group__3__Impl rule__FGAMeasuredValueReference__Group__4 )
            // InternalMIC.g:2092:2: rule__FGAMeasuredValueReference__Group__3__Impl rule__FGAMeasuredValueReference__Group__4
            {
            pushFollow(FOLLOW_9);
            rule__FGAMeasuredValueReference__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__3"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__3__Impl"
    // InternalMIC.g:2099:1: rule__FGAMeasuredValueReference__Group__3__Impl : ( ( rule__FGAMeasuredValueReference__RowAssignment_3 ) ) ;
    public final void rule__FGAMeasuredValueReference__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2103:1: ( ( ( rule__FGAMeasuredValueReference__RowAssignment_3 ) ) )
            // InternalMIC.g:2104:1: ( ( rule__FGAMeasuredValueReference__RowAssignment_3 ) )
            {
            // InternalMIC.g:2104:1: ( ( rule__FGAMeasuredValueReference__RowAssignment_3 ) )
            // InternalMIC.g:2105:2: ( rule__FGAMeasuredValueReference__RowAssignment_3 )
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getRowAssignment_3()); 
            // InternalMIC.g:2106:2: ( rule__FGAMeasuredValueReference__RowAssignment_3 )
            // InternalMIC.g:2106:3: rule__FGAMeasuredValueReference__RowAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__RowAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getRowAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__3__Impl"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__4"
    // InternalMIC.g:2114:1: rule__FGAMeasuredValueReference__Group__4 : rule__FGAMeasuredValueReference__Group__4__Impl ;
    public final void rule__FGAMeasuredValueReference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2118:1: ( rule__FGAMeasuredValueReference__Group__4__Impl )
            // InternalMIC.g:2119:2: rule__FGAMeasuredValueReference__Group__4__Impl
            {
            pushFollow(FOLLOW_2);
            rule__FGAMeasuredValueReference__Group__4__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__4"


    // $ANTLR start "rule__FGAMeasuredValueReference__Group__4__Impl"
    // InternalMIC.g:2125:1: rule__FGAMeasuredValueReference__Group__4__Impl : ( ')' ) ;
    public final void rule__FGAMeasuredValueReference__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2129:1: ( ( ')' ) )
            // InternalMIC.g:2130:1: ( ')' )
            {
            // InternalMIC.g:2130:1: ( ')' )
            // InternalMIC.g:2131:2: ')'
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getRightParenthesisKeyword_4()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getRightParenthesisKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__Group__4__Impl"


    // $ANTLR start "rule__Task__Group__0"
    // InternalMIC.g:2141:1: rule__Task__Group__0 : rule__Task__Group__0__Impl rule__Task__Group__1 ;
    public final void rule__Task__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2145:1: ( rule__Task__Group__0__Impl rule__Task__Group__1 )
            // InternalMIC.g:2146:2: rule__Task__Group__0__Impl rule__Task__Group__1
            {
            pushFollow(FOLLOW_15);
            rule__Task__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__0"


    // $ANTLR start "rule__Task__Group__0__Impl"
    // InternalMIC.g:2153:1: rule__Task__Group__0__Impl : ( ( rule__Task__TaskPrologAssignment_0 )* ) ;
    public final void rule__Task__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2157:1: ( ( ( rule__Task__TaskPrologAssignment_0 )* ) )
            // InternalMIC.g:2158:1: ( ( rule__Task__TaskPrologAssignment_0 )* )
            {
            // InternalMIC.g:2158:1: ( ( rule__Task__TaskPrologAssignment_0 )* )
            // InternalMIC.g:2159:2: ( rule__Task__TaskPrologAssignment_0 )*
            {
             before(grammarAccess.getTaskAccess().getTaskPrologAssignment_0()); 
            // InternalMIC.g:2160:2: ( rule__Task__TaskPrologAssignment_0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==RULE_RAW_METADATE||LA12_0==40) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // InternalMIC.g:2160:3: rule__Task__TaskPrologAssignment_0
            	    {
            	    pushFollow(FOLLOW_4);
            	    rule__Task__TaskPrologAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

             after(grammarAccess.getTaskAccess().getTaskPrologAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__0__Impl"


    // $ANTLR start "rule__Task__Group__1"
    // InternalMIC.g:2168:1: rule__Task__Group__1 : rule__Task__Group__1__Impl rule__Task__Group__2 ;
    public final void rule__Task__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2172:1: ( rule__Task__Group__1__Impl rule__Task__Group__2 )
            // InternalMIC.g:2173:2: rule__Task__Group__1__Impl rule__Task__Group__2
            {
            pushFollow(FOLLOW_5);
            rule__Task__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__1"


    // $ANTLR start "rule__Task__Group__1__Impl"
    // InternalMIC.g:2180:1: rule__Task__Group__1__Impl : ( 'TASK' ) ;
    public final void rule__Task__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2184:1: ( ( 'TASK' ) )
            // InternalMIC.g:2185:1: ( 'TASK' )
            {
            // InternalMIC.g:2185:1: ( 'TASK' )
            // InternalMIC.g:2186:2: 'TASK'
            {
             before(grammarAccess.getTaskAccess().getTASKKeyword_1()); 
            match(input,37,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getTASKKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__1__Impl"


    // $ANTLR start "rule__Task__Group__2"
    // InternalMIC.g:2195:1: rule__Task__Group__2 : rule__Task__Group__2__Impl rule__Task__Group__3 ;
    public final void rule__Task__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2199:1: ( rule__Task__Group__2__Impl rule__Task__Group__3 )
            // InternalMIC.g:2200:2: rule__Task__Group__2__Impl rule__Task__Group__3
            {
            pushFollow(FOLLOW_8);
            rule__Task__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__2"


    // $ANTLR start "rule__Task__Group__2__Impl"
    // InternalMIC.g:2207:1: rule__Task__Group__2__Impl : ( '(' ) ;
    public final void rule__Task__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2211:1: ( ( '(' ) )
            // InternalMIC.g:2212:1: ( '(' )
            {
            // InternalMIC.g:2212:1: ( '(' )
            // InternalMIC.g:2213:2: '('
            {
             before(grammarAccess.getTaskAccess().getLeftParenthesisKeyword_2()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getLeftParenthesisKeyword_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__2__Impl"


    // $ANTLR start "rule__Task__Group__3"
    // InternalMIC.g:2222:1: rule__Task__Group__3 : rule__Task__Group__3__Impl rule__Task__Group__4 ;
    public final void rule__Task__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2226:1: ( rule__Task__Group__3__Impl rule__Task__Group__4 )
            // InternalMIC.g:2227:2: rule__Task__Group__3__Impl rule__Task__Group__4
            {
            pushFollow(FOLLOW_7);
            rule__Task__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__3"


    // $ANTLR start "rule__Task__Group__3__Impl"
    // InternalMIC.g:2234:1: rule__Task__Group__3__Impl : ( ( rule__Task__IndexAssignment_3 ) ) ;
    public final void rule__Task__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2238:1: ( ( ( rule__Task__IndexAssignment_3 ) ) )
            // InternalMIC.g:2239:1: ( ( rule__Task__IndexAssignment_3 ) )
            {
            // InternalMIC.g:2239:1: ( ( rule__Task__IndexAssignment_3 ) )
            // InternalMIC.g:2240:2: ( rule__Task__IndexAssignment_3 )
            {
             before(grammarAccess.getTaskAccess().getIndexAssignment_3()); 
            // InternalMIC.g:2241:2: ( rule__Task__IndexAssignment_3 )
            // InternalMIC.g:2241:3: rule__Task__IndexAssignment_3
            {
            pushFollow(FOLLOW_2);
            rule__Task__IndexAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTaskAccess().getIndexAssignment_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__3__Impl"


    // $ANTLR start "rule__Task__Group__4"
    // InternalMIC.g:2249:1: rule__Task__Group__4 : rule__Task__Group__4__Impl rule__Task__Group__5 ;
    public final void rule__Task__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2253:1: ( rule__Task__Group__4__Impl rule__Task__Group__5 )
            // InternalMIC.g:2254:2: rule__Task__Group__4__Impl rule__Task__Group__5
            {
            pushFollow(FOLLOW_16);
            rule__Task__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__4"


    // $ANTLR start "rule__Task__Group__4__Impl"
    // InternalMIC.g:2261:1: rule__Task__Group__4__Impl : ( ',' ) ;
    public final void rule__Task__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2265:1: ( ( ',' ) )
            // InternalMIC.g:2266:1: ( ',' )
            {
            // InternalMIC.g:2266:1: ( ',' )
            // InternalMIC.g:2267:2: ','
            {
             before(grammarAccess.getTaskAccess().getCommaKeyword_4()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getCommaKeyword_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__4__Impl"


    // $ANTLR start "rule__Task__Group__5"
    // InternalMIC.g:2276:1: rule__Task__Group__5 : rule__Task__Group__5__Impl rule__Task__Group__6 ;
    public final void rule__Task__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2280:1: ( rule__Task__Group__5__Impl rule__Task__Group__6 )
            // InternalMIC.g:2281:2: rule__Task__Group__5__Impl rule__Task__Group__6
            {
            pushFollow(FOLLOW_17);
            rule__Task__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__5"


    // $ANTLR start "rule__Task__Group__5__Impl"
    // InternalMIC.g:2288:1: rule__Task__Group__5__Impl : ( ( rule__Task__TypeAssignment_5 ) ) ;
    public final void rule__Task__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2292:1: ( ( ( rule__Task__TypeAssignment_5 ) ) )
            // InternalMIC.g:2293:1: ( ( rule__Task__TypeAssignment_5 ) )
            {
            // InternalMIC.g:2293:1: ( ( rule__Task__TypeAssignment_5 ) )
            // InternalMIC.g:2294:2: ( rule__Task__TypeAssignment_5 )
            {
             before(grammarAccess.getTaskAccess().getTypeAssignment_5()); 
            // InternalMIC.g:2295:2: ( rule__Task__TypeAssignment_5 )
            // InternalMIC.g:2295:3: rule__Task__TypeAssignment_5
            {
            pushFollow(FOLLOW_2);
            rule__Task__TypeAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getTaskAccess().getTypeAssignment_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__5__Impl"


    // $ANTLR start "rule__Task__Group__6"
    // InternalMIC.g:2303:1: rule__Task__Group__6 : rule__Task__Group__6__Impl rule__Task__Group__7 ;
    public final void rule__Task__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2307:1: ( rule__Task__Group__6__Impl rule__Task__Group__7 )
            // InternalMIC.g:2308:2: rule__Task__Group__6__Impl rule__Task__Group__7
            {
            pushFollow(FOLLOW_17);
            rule__Task__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__6"


    // $ANTLR start "rule__Task__Group__6__Impl"
    // InternalMIC.g:2315:1: rule__Task__Group__6__Impl : ( ( rule__Task__Group_6__0 )? ) ;
    public final void rule__Task__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2319:1: ( ( ( rule__Task__Group_6__0 )? ) )
            // InternalMIC.g:2320:1: ( ( rule__Task__Group_6__0 )? )
            {
            // InternalMIC.g:2320:1: ( ( rule__Task__Group_6__0 )? )
            // InternalMIC.g:2321:2: ( rule__Task__Group_6__0 )?
            {
             before(grammarAccess.getTaskAccess().getGroup_6()); 
            // InternalMIC.g:2322:2: ( rule__Task__Group_6__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==26) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMIC.g:2322:3: rule__Task__Group_6__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__Task__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTaskAccess().getGroup_6()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__6__Impl"


    // $ANTLR start "rule__Task__Group__7"
    // InternalMIC.g:2330:1: rule__Task__Group__7 : rule__Task__Group__7__Impl rule__Task__Group__8 ;
    public final void rule__Task__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2334:1: ( rule__Task__Group__7__Impl rule__Task__Group__8 )
            // InternalMIC.g:2335:2: rule__Task__Group__7__Impl rule__Task__Group__8
            {
            pushFollow(FOLLOW_18);
            rule__Task__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__7"


    // $ANTLR start "rule__Task__Group__7__Impl"
    // InternalMIC.g:2342:1: rule__Task__Group__7__Impl : ( ')' ) ;
    public final void rule__Task__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2346:1: ( ( ')' ) )
            // InternalMIC.g:2347:1: ( ')' )
            {
            // InternalMIC.g:2347:1: ( ')' )
            // InternalMIC.g:2348:2: ')'
            {
             before(grammarAccess.getTaskAccess().getRightParenthesisKeyword_7()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getRightParenthesisKeyword_7()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__7__Impl"


    // $ANTLR start "rule__Task__Group__8"
    // InternalMIC.g:2357:1: rule__Task__Group__8 : rule__Task__Group__8__Impl rule__Task__Group__9 ;
    public final void rule__Task__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2361:1: ( rule__Task__Group__8__Impl rule__Task__Group__9 )
            // InternalMIC.g:2362:2: rule__Task__Group__8__Impl rule__Task__Group__9
            {
            pushFollow(FOLLOW_18);
            rule__Task__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group__9();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__8"


    // $ANTLR start "rule__Task__Group__8__Impl"
    // InternalMIC.g:2369:1: rule__Task__Group__8__Impl : ( ( rule__Task__InstructionsAssignment_8 )* ) ;
    public final void rule__Task__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2373:1: ( ( ( rule__Task__InstructionsAssignment_8 )* ) )
            // InternalMIC.g:2374:1: ( ( rule__Task__InstructionsAssignment_8 )* )
            {
            // InternalMIC.g:2374:1: ( ( rule__Task__InstructionsAssignment_8 )* )
            // InternalMIC.g:2375:2: ( rule__Task__InstructionsAssignment_8 )*
            {
             before(grammarAccess.getTaskAccess().getInstructionsAssignment_8()); 
            // InternalMIC.g:2376:2: ( rule__Task__InstructionsAssignment_8 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==RULE_ID||LA14_0==RULE_RAW_METADATE||LA14_0==40) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMIC.g:2376:3: rule__Task__InstructionsAssignment_8
            	    {
            	    pushFollow(FOLLOW_19);
            	    rule__Task__InstructionsAssignment_8();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

             after(grammarAccess.getTaskAccess().getInstructionsAssignment_8()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__8__Impl"


    // $ANTLR start "rule__Task__Group__9"
    // InternalMIC.g:2384:1: rule__Task__Group__9 : rule__Task__Group__9__Impl ;
    public final void rule__Task__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2388:1: ( rule__Task__Group__9__Impl )
            // InternalMIC.g:2389:2: rule__Task__Group__9__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Task__Group__9__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__9"


    // $ANTLR start "rule__Task__Group__9__Impl"
    // InternalMIC.g:2395:1: rule__Task__Group__9__Impl : ( 'ENDE' ) ;
    public final void rule__Task__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2399:1: ( ( 'ENDE' ) )
            // InternalMIC.g:2400:1: ( 'ENDE' )
            {
            // InternalMIC.g:2400:1: ( 'ENDE' )
            // InternalMIC.g:2401:2: 'ENDE'
            {
             before(grammarAccess.getTaskAccess().getENDEKeyword_9()); 
            match(input,38,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getENDEKeyword_9()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group__9__Impl"


    // $ANTLR start "rule__Task__Group_6__0"
    // InternalMIC.g:2411:1: rule__Task__Group_6__0 : rule__Task__Group_6__0__Impl rule__Task__Group_6__1 ;
    public final void rule__Task__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2415:1: ( rule__Task__Group_6__0__Impl rule__Task__Group_6__1 )
            // InternalMIC.g:2416:2: rule__Task__Group_6__0__Impl rule__Task__Group_6__1
            {
            pushFollow(FOLLOW_8);
            rule__Task__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__Task__Group_6__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group_6__0"


    // $ANTLR start "rule__Task__Group_6__0__Impl"
    // InternalMIC.g:2423:1: rule__Task__Group_6__0__Impl : ( ',' ) ;
    public final void rule__Task__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2427:1: ( ( ',' ) )
            // InternalMIC.g:2428:1: ( ',' )
            {
            // InternalMIC.g:2428:1: ( ',' )
            // InternalMIC.g:2429:2: ','
            {
             before(grammarAccess.getTaskAccess().getCommaKeyword_6_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getCommaKeyword_6_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group_6__0__Impl"


    // $ANTLR start "rule__Task__Group_6__1"
    // InternalMIC.g:2438:1: rule__Task__Group_6__1 : rule__Task__Group_6__1__Impl ;
    public final void rule__Task__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2442:1: ( rule__Task__Group_6__1__Impl )
            // InternalMIC.g:2443:2: rule__Task__Group_6__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__Task__Group_6__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group_6__1"


    // $ANTLR start "rule__Task__Group_6__1__Impl"
    // InternalMIC.g:2449:1: rule__Task__Group_6__1__Impl : ( ( rule__Task__CycleTimeAssignment_6_1 ) ) ;
    public final void rule__Task__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2453:1: ( ( ( rule__Task__CycleTimeAssignment_6_1 ) ) )
            // InternalMIC.g:2454:1: ( ( rule__Task__CycleTimeAssignment_6_1 ) )
            {
            // InternalMIC.g:2454:1: ( ( rule__Task__CycleTimeAssignment_6_1 ) )
            // InternalMIC.g:2455:2: ( rule__Task__CycleTimeAssignment_6_1 )
            {
             before(grammarAccess.getTaskAccess().getCycleTimeAssignment_6_1()); 
            // InternalMIC.g:2456:2: ( rule__Task__CycleTimeAssignment_6_1 )
            // InternalMIC.g:2456:3: rule__Task__CycleTimeAssignment_6_1
            {
            pushFollow(FOLLOW_2);
            rule__Task__CycleTimeAssignment_6_1();

            state._fsp--;


            }

             after(grammarAccess.getTaskAccess().getCycleTimeAssignment_6_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__Group_6__1__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group__0"
    // InternalMIC.g:2465:1: rule__ModuleInvokation__Group__0 : rule__ModuleInvokation__Group__0__Impl rule__ModuleInvokation__Group__1 ;
    public final void rule__ModuleInvokation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2469:1: ( rule__ModuleInvokation__Group__0__Impl rule__ModuleInvokation__Group__1 )
            // InternalMIC.g:2470:2: rule__ModuleInvokation__Group__0__Impl rule__ModuleInvokation__Group__1
            {
            pushFollow(FOLLOW_5);
            rule__ModuleInvokation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__0"


    // $ANTLR start "rule__ModuleInvokation__Group__0__Impl"
    // InternalMIC.g:2477:1: rule__ModuleInvokation__Group__0__Impl : ( ( rule__ModuleInvokation__ModuleNameAssignment_0 ) ) ;
    public final void rule__ModuleInvokation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2481:1: ( ( ( rule__ModuleInvokation__ModuleNameAssignment_0 ) ) )
            // InternalMIC.g:2482:1: ( ( rule__ModuleInvokation__ModuleNameAssignment_0 ) )
            {
            // InternalMIC.g:2482:1: ( ( rule__ModuleInvokation__ModuleNameAssignment_0 ) )
            // InternalMIC.g:2483:2: ( rule__ModuleInvokation__ModuleNameAssignment_0 )
            {
             before(grammarAccess.getModuleInvokationAccess().getModuleNameAssignment_0()); 
            // InternalMIC.g:2484:2: ( rule__ModuleInvokation__ModuleNameAssignment_0 )
            // InternalMIC.g:2484:3: rule__ModuleInvokation__ModuleNameAssignment_0
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__ModuleNameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleInvokationAccess().getModuleNameAssignment_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__0__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group__1"
    // InternalMIC.g:2492:1: rule__ModuleInvokation__Group__1 : rule__ModuleInvokation__Group__1__Impl rule__ModuleInvokation__Group__2 ;
    public final void rule__ModuleInvokation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2496:1: ( rule__ModuleInvokation__Group__1__Impl rule__ModuleInvokation__Group__2 )
            // InternalMIC.g:2497:2: rule__ModuleInvokation__Group__1__Impl rule__ModuleInvokation__Group__2
            {
            pushFollow(FOLLOW_20);
            rule__ModuleInvokation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__1"


    // $ANTLR start "rule__ModuleInvokation__Group__1__Impl"
    // InternalMIC.g:2504:1: rule__ModuleInvokation__Group__1__Impl : ( '(' ) ;
    public final void rule__ModuleInvokation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2508:1: ( ( '(' ) )
            // InternalMIC.g:2509:1: ( '(' )
            {
            // InternalMIC.g:2509:1: ( '(' )
            // InternalMIC.g:2510:2: '('
            {
             before(grammarAccess.getModuleInvokationAccess().getLeftParenthesisKeyword_1()); 
            match(input,25,FOLLOW_2); 
             after(grammarAccess.getModuleInvokationAccess().getLeftParenthesisKeyword_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__1__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group__2"
    // InternalMIC.g:2519:1: rule__ModuleInvokation__Group__2 : rule__ModuleInvokation__Group__2__Impl rule__ModuleInvokation__Group__3 ;
    public final void rule__ModuleInvokation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2523:1: ( rule__ModuleInvokation__Group__2__Impl rule__ModuleInvokation__Group__3 )
            // InternalMIC.g:2524:2: rule__ModuleInvokation__Group__2__Impl rule__ModuleInvokation__Group__3
            {
            pushFollow(FOLLOW_20);
            rule__ModuleInvokation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__2"


    // $ANTLR start "rule__ModuleInvokation__Group__2__Impl"
    // InternalMIC.g:2531:1: rule__ModuleInvokation__Group__2__Impl : ( ( rule__ModuleInvokation__Group_2__0 )? ) ;
    public final void rule__ModuleInvokation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2535:1: ( ( ( rule__ModuleInvokation__Group_2__0 )? ) )
            // InternalMIC.g:2536:1: ( ( rule__ModuleInvokation__Group_2__0 )? )
            {
            // InternalMIC.g:2536:1: ( ( rule__ModuleInvokation__Group_2__0 )? )
            // InternalMIC.g:2537:2: ( rule__ModuleInvokation__Group_2__0 )?
            {
             before(grammarAccess.getModuleInvokationAccess().getGroup_2()); 
            // InternalMIC.g:2538:2: ( rule__ModuleInvokation__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( ((LA15_0>=RULE_ID && LA15_0<=RULE_INT)||LA15_0==39) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalMIC.g:2538:3: rule__ModuleInvokation__Group_2__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__ModuleInvokation__Group_2__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModuleInvokationAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__2__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group__3"
    // InternalMIC.g:2546:1: rule__ModuleInvokation__Group__3 : rule__ModuleInvokation__Group__3__Impl ;
    public final void rule__ModuleInvokation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2550:1: ( rule__ModuleInvokation__Group__3__Impl )
            // InternalMIC.g:2551:2: rule__ModuleInvokation__Group__3__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__3"


    // $ANTLR start "rule__ModuleInvokation__Group__3__Impl"
    // InternalMIC.g:2557:1: rule__ModuleInvokation__Group__3__Impl : ( ')' ) ;
    public final void rule__ModuleInvokation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2561:1: ( ( ')' ) )
            // InternalMIC.g:2562:1: ( ')' )
            {
            // InternalMIC.g:2562:1: ( ')' )
            // InternalMIC.g:2563:2: ')'
            {
             before(grammarAccess.getModuleInvokationAccess().getRightParenthesisKeyword_3()); 
            match(input,27,FOLLOW_2); 
             after(grammarAccess.getModuleInvokationAccess().getRightParenthesisKeyword_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group__3__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group_2__0"
    // InternalMIC.g:2573:1: rule__ModuleInvokation__Group_2__0 : rule__ModuleInvokation__Group_2__0__Impl rule__ModuleInvokation__Group_2__1 ;
    public final void rule__ModuleInvokation__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2577:1: ( rule__ModuleInvokation__Group_2__0__Impl rule__ModuleInvokation__Group_2__1 )
            // InternalMIC.g:2578:2: rule__ModuleInvokation__Group_2__0__Impl rule__ModuleInvokation__Group_2__1
            {
            pushFollow(FOLLOW_7);
            rule__ModuleInvokation__Group_2__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group_2__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2__0"


    // $ANTLR start "rule__ModuleInvokation__Group_2__0__Impl"
    // InternalMIC.g:2585:1: rule__ModuleInvokation__Group_2__0__Impl : ( ( rule__ModuleInvokation__ArgumentsAssignment_2_0 ) ) ;
    public final void rule__ModuleInvokation__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2589:1: ( ( ( rule__ModuleInvokation__ArgumentsAssignment_2_0 ) ) )
            // InternalMIC.g:2590:1: ( ( rule__ModuleInvokation__ArgumentsAssignment_2_0 ) )
            {
            // InternalMIC.g:2590:1: ( ( rule__ModuleInvokation__ArgumentsAssignment_2_0 ) )
            // InternalMIC.g:2591:2: ( rule__ModuleInvokation__ArgumentsAssignment_2_0 )
            {
             before(grammarAccess.getModuleInvokationAccess().getArgumentsAssignment_2_0()); 
            // InternalMIC.g:2592:2: ( rule__ModuleInvokation__ArgumentsAssignment_2_0 )
            // InternalMIC.g:2592:3: rule__ModuleInvokation__ArgumentsAssignment_2_0
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__ArgumentsAssignment_2_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleInvokationAccess().getArgumentsAssignment_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2__0__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group_2__1"
    // InternalMIC.g:2600:1: rule__ModuleInvokation__Group_2__1 : rule__ModuleInvokation__Group_2__1__Impl ;
    public final void rule__ModuleInvokation__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2604:1: ( rule__ModuleInvokation__Group_2__1__Impl )
            // InternalMIC.g:2605:2: rule__ModuleInvokation__Group_2__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group_2__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2__1"


    // $ANTLR start "rule__ModuleInvokation__Group_2__1__Impl"
    // InternalMIC.g:2611:1: rule__ModuleInvokation__Group_2__1__Impl : ( ( rule__ModuleInvokation__Group_2_1__0 )* ) ;
    public final void rule__ModuleInvokation__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2615:1: ( ( ( rule__ModuleInvokation__Group_2_1__0 )* ) )
            // InternalMIC.g:2616:1: ( ( rule__ModuleInvokation__Group_2_1__0 )* )
            {
            // InternalMIC.g:2616:1: ( ( rule__ModuleInvokation__Group_2_1__0 )* )
            // InternalMIC.g:2617:2: ( rule__ModuleInvokation__Group_2_1__0 )*
            {
             before(grammarAccess.getModuleInvokationAccess().getGroup_2_1()); 
            // InternalMIC.g:2618:2: ( rule__ModuleInvokation__Group_2_1__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==26) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalMIC.g:2618:3: rule__ModuleInvokation__Group_2_1__0
            	    {
            	    pushFollow(FOLLOW_21);
            	    rule__ModuleInvokation__Group_2_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getModuleInvokationAccess().getGroup_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2__1__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group_2_1__0"
    // InternalMIC.g:2627:1: rule__ModuleInvokation__Group_2_1__0 : rule__ModuleInvokation__Group_2_1__0__Impl rule__ModuleInvokation__Group_2_1__1 ;
    public final void rule__ModuleInvokation__Group_2_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2631:1: ( rule__ModuleInvokation__Group_2_1__0__Impl rule__ModuleInvokation__Group_2_1__1 )
            // InternalMIC.g:2632:2: rule__ModuleInvokation__Group_2_1__0__Impl rule__ModuleInvokation__Group_2_1__1
            {
            pushFollow(FOLLOW_22);
            rule__ModuleInvokation__Group_2_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group_2_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2_1__0"


    // $ANTLR start "rule__ModuleInvokation__Group_2_1__0__Impl"
    // InternalMIC.g:2639:1: rule__ModuleInvokation__Group_2_1__0__Impl : ( ',' ) ;
    public final void rule__ModuleInvokation__Group_2_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2643:1: ( ( ',' ) )
            // InternalMIC.g:2644:1: ( ',' )
            {
            // InternalMIC.g:2644:1: ( ',' )
            // InternalMIC.g:2645:2: ','
            {
             before(grammarAccess.getModuleInvokationAccess().getCommaKeyword_2_1_0()); 
            match(input,26,FOLLOW_2); 
             after(grammarAccess.getModuleInvokationAccess().getCommaKeyword_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2_1__0__Impl"


    // $ANTLR start "rule__ModuleInvokation__Group_2_1__1"
    // InternalMIC.g:2654:1: rule__ModuleInvokation__Group_2_1__1 : rule__ModuleInvokation__Group_2_1__1__Impl ;
    public final void rule__ModuleInvokation__Group_2_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2658:1: ( rule__ModuleInvokation__Group_2_1__1__Impl )
            // InternalMIC.g:2659:2: rule__ModuleInvokation__Group_2_1__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__Group_2_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2_1__1"


    // $ANTLR start "rule__ModuleInvokation__Group_2_1__1__Impl"
    // InternalMIC.g:2665:1: rule__ModuleInvokation__Group_2_1__1__Impl : ( ( rule__ModuleInvokation__ArgumentsAssignment_2_1_1 ) ) ;
    public final void rule__ModuleInvokation__Group_2_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2669:1: ( ( ( rule__ModuleInvokation__ArgumentsAssignment_2_1_1 ) ) )
            // InternalMIC.g:2670:1: ( ( rule__ModuleInvokation__ArgumentsAssignment_2_1_1 ) )
            {
            // InternalMIC.g:2670:1: ( ( rule__ModuleInvokation__ArgumentsAssignment_2_1_1 ) )
            // InternalMIC.g:2671:2: ( rule__ModuleInvokation__ArgumentsAssignment_2_1_1 )
            {
             before(grammarAccess.getModuleInvokationAccess().getArgumentsAssignment_2_1_1()); 
            // InternalMIC.g:2672:2: ( rule__ModuleInvokation__ArgumentsAssignment_2_1_1 )
            // InternalMIC.g:2672:3: rule__ModuleInvokation__ArgumentsAssignment_2_1_1
            {
            pushFollow(FOLLOW_2);
            rule__ModuleInvokation__ArgumentsAssignment_2_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModuleInvokationAccess().getArgumentsAssignment_2_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__Group_2_1__1__Impl"


    // $ANTLR start "rule__SymbolAccessor__Group_0__0"
    // InternalMIC.g:2681:1: rule__SymbolAccessor__Group_0__0 : rule__SymbolAccessor__Group_0__0__Impl rule__SymbolAccessor__Group_0__1 ;
    public final void rule__SymbolAccessor__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2685:1: ( rule__SymbolAccessor__Group_0__0__Impl rule__SymbolAccessor__Group_0__1 )
            // InternalMIC.g:2686:2: rule__SymbolAccessor__Group_0__0__Impl rule__SymbolAccessor__Group_0__1
            {
            pushFollow(FOLLOW_23);
            rule__SymbolAccessor__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0__0"


    // $ANTLR start "rule__SymbolAccessor__Group_0__0__Impl"
    // InternalMIC.g:2693:1: rule__SymbolAccessor__Group_0__0__Impl : ( ( rule__SymbolAccessor__Group_0_0__0 )? ) ;
    public final void rule__SymbolAccessor__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2697:1: ( ( ( rule__SymbolAccessor__Group_0_0__0 )? ) )
            // InternalMIC.g:2698:1: ( ( rule__SymbolAccessor__Group_0_0__0 )? )
            {
            // InternalMIC.g:2698:1: ( ( rule__SymbolAccessor__Group_0_0__0 )? )
            // InternalMIC.g:2699:2: ( rule__SymbolAccessor__Group_0_0__0 )?
            {
             before(grammarAccess.getSymbolAccessorAccess().getGroup_0_0()); 
            // InternalMIC.g:2700:2: ( rule__SymbolAccessor__Group_0_0__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==39) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMIC.g:2700:3: rule__SymbolAccessor__Group_0_0__0
                    {
                    pushFollow(FOLLOW_2);
                    rule__SymbolAccessor__Group_0_0__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSymbolAccessorAccess().getGroup_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0__0__Impl"


    // $ANTLR start "rule__SymbolAccessor__Group_0__1"
    // InternalMIC.g:2708:1: rule__SymbolAccessor__Group_0__1 : rule__SymbolAccessor__Group_0__1__Impl ;
    public final void rule__SymbolAccessor__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2712:1: ( rule__SymbolAccessor__Group_0__1__Impl )
            // InternalMIC.g:2713:2: rule__SymbolAccessor__Group_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__Group_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0__1"


    // $ANTLR start "rule__SymbolAccessor__Group_0__1__Impl"
    // InternalMIC.g:2719:1: rule__SymbolAccessor__Group_0__1__Impl : ( ( rule__SymbolAccessor__SymbolAssignment_0_1 ) ) ;
    public final void rule__SymbolAccessor__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2723:1: ( ( ( rule__SymbolAccessor__SymbolAssignment_0_1 ) ) )
            // InternalMIC.g:2724:1: ( ( rule__SymbolAccessor__SymbolAssignment_0_1 ) )
            {
            // InternalMIC.g:2724:1: ( ( rule__SymbolAccessor__SymbolAssignment_0_1 ) )
            // InternalMIC.g:2725:2: ( rule__SymbolAccessor__SymbolAssignment_0_1 )
            {
             before(grammarAccess.getSymbolAccessorAccess().getSymbolAssignment_0_1()); 
            // InternalMIC.g:2726:2: ( rule__SymbolAccessor__SymbolAssignment_0_1 )
            // InternalMIC.g:2726:3: rule__SymbolAccessor__SymbolAssignment_0_1
            {
            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__SymbolAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getSymbolAccessorAccess().getSymbolAssignment_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0__1__Impl"


    // $ANTLR start "rule__SymbolAccessor__Group_0_0__0"
    // InternalMIC.g:2735:1: rule__SymbolAccessor__Group_0_0__0 : rule__SymbolAccessor__Group_0_0__0__Impl rule__SymbolAccessor__Group_0_0__1 ;
    public final void rule__SymbolAccessor__Group_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2739:1: ( rule__SymbolAccessor__Group_0_0__0__Impl rule__SymbolAccessor__Group_0_0__1 )
            // InternalMIC.g:2740:2: rule__SymbolAccessor__Group_0_0__0__Impl rule__SymbolAccessor__Group_0_0__1
            {
            pushFollow(FOLLOW_24);
            rule__SymbolAccessor__Group_0_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__Group_0_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0_0__0"


    // $ANTLR start "rule__SymbolAccessor__Group_0_0__0__Impl"
    // InternalMIC.g:2747:1: rule__SymbolAccessor__Group_0_0__0__Impl : ( 'writeaccess=' ) ;
    public final void rule__SymbolAccessor__Group_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2751:1: ( ( 'writeaccess=' ) )
            // InternalMIC.g:2752:1: ( 'writeaccess=' )
            {
            // InternalMIC.g:2752:1: ( 'writeaccess=' )
            // InternalMIC.g:2753:2: 'writeaccess='
            {
             before(grammarAccess.getSymbolAccessorAccess().getWriteaccessKeyword_0_0_0()); 
            match(input,39,FOLLOW_2); 
             after(grammarAccess.getSymbolAccessorAccess().getWriteaccessKeyword_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0_0__0__Impl"


    // $ANTLR start "rule__SymbolAccessor__Group_0_0__1"
    // InternalMIC.g:2762:1: rule__SymbolAccessor__Group_0_0__1 : rule__SymbolAccessor__Group_0_0__1__Impl ;
    public final void rule__SymbolAccessor__Group_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2766:1: ( rule__SymbolAccessor__Group_0_0__1__Impl )
            // InternalMIC.g:2767:2: rule__SymbolAccessor__Group_0_0__1__Impl
            {
            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__Group_0_0__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0_0__1"


    // $ANTLR start "rule__SymbolAccessor__Group_0_0__1__Impl"
    // InternalMIC.g:2773:1: rule__SymbolAccessor__Group_0_0__1__Impl : ( ( rule__SymbolAccessor__WritingAssignment_0_0_1 ) ) ;
    public final void rule__SymbolAccessor__Group_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2777:1: ( ( ( rule__SymbolAccessor__WritingAssignment_0_0_1 ) ) )
            // InternalMIC.g:2778:1: ( ( rule__SymbolAccessor__WritingAssignment_0_0_1 ) )
            {
            // InternalMIC.g:2778:1: ( ( rule__SymbolAccessor__WritingAssignment_0_0_1 ) )
            // InternalMIC.g:2779:2: ( rule__SymbolAccessor__WritingAssignment_0_0_1 )
            {
             before(grammarAccess.getSymbolAccessorAccess().getWritingAssignment_0_0_1()); 
            // InternalMIC.g:2780:2: ( rule__SymbolAccessor__WritingAssignment_0_0_1 )
            // InternalMIC.g:2780:3: rule__SymbolAccessor__WritingAssignment_0_0_1
            {
            pushFollow(FOLLOW_2);
            rule__SymbolAccessor__WritingAssignment_0_0_1();

            state._fsp--;


            }

             after(grammarAccess.getSymbolAccessorAccess().getWritingAssignment_0_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__Group_0_0__1__Impl"


    // $ANTLR start "rule__Module__ModulePrologAssignment_0"
    // InternalMIC.g:2789:1: rule__Module__ModulePrologAssignment_0 : ( ruleMetaData ) ;
    public final void rule__Module__ModulePrologAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2793:1: ( ( ruleMetaData ) )
            // InternalMIC.g:2794:2: ( ruleMetaData )
            {
            // InternalMIC.g:2794:2: ( ruleMetaData )
            // InternalMIC.g:2795:3: ruleMetaData
            {
             before(grammarAccess.getModuleAccess().getModulePrologMetaDataParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMetaData();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getModulePrologMetaDataParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__ModulePrologAssignment_0"


    // $ANTLR start "rule__Module__TypeAssignment_3"
    // InternalMIC.g:2804:1: rule__Module__TypeAssignment_3 : ( RULE_ID ) ;
    public final void rule__Module__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2808:1: ( ( RULE_ID ) )
            // InternalMIC.g:2809:2: ( RULE_ID )
            {
            // InternalMIC.g:2809:2: ( RULE_ID )
            // InternalMIC.g:2810:3: RULE_ID
            {
             before(grammarAccess.getModuleAccess().getTypeIDTerminalRuleCall_3_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getTypeIDTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__TypeAssignment_3"


    // $ANTLR start "rule__Module__ValueAssignment_5"
    // InternalMIC.g:2819:1: rule__Module__ValueAssignment_5 : ( RULE_INT ) ;
    public final void rule__Module__ValueAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2823:1: ( ( RULE_INT ) )
            // InternalMIC.g:2824:2: ( RULE_INT )
            {
            // InternalMIC.g:2824:2: ( RULE_INT )
            // InternalMIC.g:2825:3: RULE_INT
            {
             before(grammarAccess.getModuleAccess().getValueINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getModuleAccess().getValueINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__ValueAssignment_5"


    // $ANTLR start "rule__Module__DecalarationsAssignment_7"
    // InternalMIC.g:2834:1: rule__Module__DecalarationsAssignment_7 : ( ruleSymbol ) ;
    public final void rule__Module__DecalarationsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2838:1: ( ( ruleSymbol ) )
            // InternalMIC.g:2839:2: ( ruleSymbol )
            {
            // InternalMIC.g:2839:2: ( ruleSymbol )
            // InternalMIC.g:2840:3: ruleSymbol
            {
             before(grammarAccess.getModuleAccess().getDecalarationsSymbolParserRuleCall_7_0()); 
            pushFollow(FOLLOW_2);
            ruleSymbol();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getDecalarationsSymbolParserRuleCall_7_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__DecalarationsAssignment_7"


    // $ANTLR start "rule__Module__TasksAssignment_8"
    // InternalMIC.g:2849:1: rule__Module__TasksAssignment_8 : ( ruleTask ) ;
    public final void rule__Module__TasksAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2853:1: ( ( ruleTask ) )
            // InternalMIC.g:2854:2: ( ruleTask )
            {
            // InternalMIC.g:2854:2: ( ruleTask )
            // InternalMIC.g:2855:3: ruleTask
            {
             before(grammarAccess.getModuleAccess().getTasksTaskParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleTask();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getTasksTaskParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__TasksAssignment_8"


    // $ANTLR start "rule__MetaData__NameAssignment_0"
    // InternalMIC.g:2864:1: rule__MetaData__NameAssignment_0 : ( ( '\\u00B0nothing' ) ) ;
    public final void rule__MetaData__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2868:1: ( ( ( '\\u00B0nothing' ) ) )
            // InternalMIC.g:2869:2: ( ( '\\u00B0nothing' ) )
            {
            // InternalMIC.g:2869:2: ( ( '\\u00B0nothing' ) )
            // InternalMIC.g:2870:3: ( '\\u00B0nothing' )
            {
             before(grammarAccess.getMetaDataAccess().getNameNothingKeyword_0_0()); 
            // InternalMIC.g:2871:3: ( '\\u00B0nothing' )
            // InternalMIC.g:2872:4: '\\u00B0nothing'
            {
             before(grammarAccess.getMetaDataAccess().getNameNothingKeyword_0_0()); 
            match(input,40,FOLLOW_2); 
             after(grammarAccess.getMetaDataAccess().getNameNothingKeyword_0_0()); 

            }

             after(grammarAccess.getMetaDataAccess().getNameNothingKeyword_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaData__NameAssignment_0"


    // $ANTLR start "rule__MetaData__ValueAssignment_1"
    // InternalMIC.g:2883:1: rule__MetaData__ValueAssignment_1 : ( RULE_RAW_METADATE ) ;
    public final void rule__MetaData__ValueAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2887:1: ( ( RULE_RAW_METADATE ) )
            // InternalMIC.g:2888:2: ( RULE_RAW_METADATE )
            {
            // InternalMIC.g:2888:2: ( RULE_RAW_METADATE )
            // InternalMIC.g:2889:3: RULE_RAW_METADATE
            {
             before(grammarAccess.getMetaDataAccess().getValueRAW_METADATETerminalRuleCall_1_0()); 
            match(input,RULE_RAW_METADATE,FOLLOW_2); 
             after(grammarAccess.getMetaDataAccess().getValueRAW_METADATETerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__MetaData__ValueAssignment_1"


    // $ANTLR start "rule__WordVar__NameAssignment_1"
    // InternalMIC.g:2898:1: rule__WordVar__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__WordVar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2902:1: ( ( RULE_ID ) )
            // InternalMIC.g:2903:2: ( RULE_ID )
            {
            // InternalMIC.g:2903:2: ( RULE_ID )
            // InternalMIC.g:2904:3: RULE_ID
            {
             before(grammarAccess.getWordVarAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWordVarAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordVar__NameAssignment_1"


    // $ANTLR start "rule__WordConst__NameAssignment_1"
    // InternalMIC.g:2913:1: rule__WordConst__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__WordConst__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2917:1: ( ( RULE_ID ) )
            // InternalMIC.g:2918:2: ( RULE_ID )
            {
            // InternalMIC.g:2918:2: ( RULE_ID )
            // InternalMIC.g:2919:3: RULE_ID
            {
             before(grammarAccess.getWordConstAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getWordConstAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__NameAssignment_1"


    // $ANTLR start "rule__WordConst__ValueAssignment_3"
    // InternalMIC.g:2928:1: rule__WordConst__ValueAssignment_3 : ( RULE_INT ) ;
    public final void rule__WordConst__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2932:1: ( ( RULE_INT ) )
            // InternalMIC.g:2933:2: ( RULE_INT )
            {
            // InternalMIC.g:2933:2: ( RULE_INT )
            // InternalMIC.g:2934:3: RULE_INT
            {
             before(grammarAccess.getWordConstAccess().getValueINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getWordConstAccess().getValueINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__WordConst__ValueAssignment_3"


    // $ANTLR start "rule__FloatVar__NameAssignment_1"
    // InternalMIC.g:2943:1: rule__FloatVar__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FloatVar__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2947:1: ( ( RULE_ID ) )
            // InternalMIC.g:2948:2: ( RULE_ID )
            {
            // InternalMIC.g:2948:2: ( RULE_ID )
            // InternalMIC.g:2949:3: RULE_ID
            {
             before(grammarAccess.getFloatVarAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFloatVarAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatVar__NameAssignment_1"


    // $ANTLR start "rule__FloatConst__NameAssignment_1"
    // InternalMIC.g:2958:1: rule__FloatConst__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FloatConst__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2962:1: ( ( RULE_ID ) )
            // InternalMIC.g:2963:2: ( RULE_ID )
            {
            // InternalMIC.g:2963:2: ( RULE_ID )
            // InternalMIC.g:2964:3: RULE_ID
            {
             before(grammarAccess.getFloatConstAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFloatConstAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__NameAssignment_1"


    // $ANTLR start "rule__FloatConst__ValueAssignment_3"
    // InternalMIC.g:2973:1: rule__FloatConst__ValueAssignment_3 : ( ruleFloat ) ;
    public final void rule__FloatConst__ValueAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2977:1: ( ( ruleFloat ) )
            // InternalMIC.g:2978:2: ( ruleFloat )
            {
            // InternalMIC.g:2978:2: ( ruleFloat )
            // InternalMIC.g:2979:3: ruleFloat
            {
             before(grammarAccess.getFloatConstAccess().getValueFloatParserRuleCall_3_0()); 
            pushFollow(FOLLOW_2);
            ruleFloat();

            state._fsp--;

             after(grammarAccess.getFloatConstAccess().getValueFloatParserRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FloatConst__ValueAssignment_3"


    // $ANTLR start "rule__DirectValue__ValueAssignment"
    // InternalMIC.g:2988:1: rule__DirectValue__ValueAssignment : ( RULE_INT ) ;
    public final void rule__DirectValue__ValueAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:2992:1: ( ( RULE_INT ) )
            // InternalMIC.g:2993:2: ( RULE_INT )
            {
            // InternalMIC.g:2993:2: ( RULE_INT )
            // InternalMIC.g:2994:3: RULE_INT
            {
             before(grammarAccess.getDirectValueAccess().getValueINTTerminalRuleCall_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getDirectValueAccess().getValueINTTerminalRuleCall_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__DirectValue__ValueAssignment"


    // $ANTLR start "rule__FGAMessageConstantReference__NameAssignment_1"
    // InternalMIC.g:3003:1: rule__FGAMessageConstantReference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FGAMessageConstantReference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3007:1: ( ( RULE_ID ) )
            // InternalMIC.g:3008:2: ( RULE_ID )
            {
            // InternalMIC.g:3008:2: ( RULE_ID )
            // InternalMIC.g:3009:3: RULE_ID
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__NameAssignment_1"


    // $ANTLR start "rule__FGAMessageConstantReference__RowAssignment_3"
    // InternalMIC.g:3018:1: rule__FGAMessageConstantReference__RowAssignment_3 : ( RULE_INT ) ;
    public final void rule__FGAMessageConstantReference__RowAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3022:1: ( ( RULE_INT ) )
            // InternalMIC.g:3023:2: ( RULE_INT )
            {
            // InternalMIC.g:3023:2: ( RULE_INT )
            // InternalMIC.g:3024:3: RULE_INT
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getRowINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getRowINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__RowAssignment_3"


    // $ANTLR start "rule__FGAMessageConstantReference__ColumnAssignment_5"
    // InternalMIC.g:3033:1: rule__FGAMessageConstantReference__ColumnAssignment_5 : ( RULE_INT ) ;
    public final void rule__FGAMessageConstantReference__ColumnAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3037:1: ( ( RULE_INT ) )
            // InternalMIC.g:3038:2: ( RULE_INT )
            {
            // InternalMIC.g:3038:2: ( RULE_INT )
            // InternalMIC.g:3039:3: RULE_INT
            {
             before(grammarAccess.getFGAMessageConstantReferenceAccess().getColumnINTTerminalRuleCall_5_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFGAMessageConstantReferenceAccess().getColumnINTTerminalRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMessageConstantReference__ColumnAssignment_5"


    // $ANTLR start "rule__FGAAnalogValueReference__NameAssignment_1"
    // InternalMIC.g:3048:1: rule__FGAAnalogValueReference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FGAAnalogValueReference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3052:1: ( ( RULE_ID ) )
            // InternalMIC.g:3053:2: ( RULE_ID )
            {
            // InternalMIC.g:3053:2: ( RULE_ID )
            // InternalMIC.g:3054:3: RULE_ID
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFGAAnalogValueReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__NameAssignment_1"


    // $ANTLR start "rule__FGAAnalogValueReference__RowAssignment_3"
    // InternalMIC.g:3063:1: rule__FGAAnalogValueReference__RowAssignment_3 : ( RULE_INT ) ;
    public final void rule__FGAAnalogValueReference__RowAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3067:1: ( ( RULE_INT ) )
            // InternalMIC.g:3068:2: ( RULE_INT )
            {
            // InternalMIC.g:3068:2: ( RULE_INT )
            // InternalMIC.g:3069:3: RULE_INT
            {
             before(grammarAccess.getFGAAnalogValueReferenceAccess().getRowINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFGAAnalogValueReferenceAccess().getRowINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAAnalogValueReference__RowAssignment_3"


    // $ANTLR start "rule__FGAValueReference__NameAssignment_1"
    // InternalMIC.g:3078:1: rule__FGAValueReference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FGAValueReference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3082:1: ( ( RULE_ID ) )
            // InternalMIC.g:3083:2: ( RULE_ID )
            {
            // InternalMIC.g:3083:2: ( RULE_ID )
            // InternalMIC.g:3084:3: RULE_ID
            {
             before(grammarAccess.getFGAValueReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFGAValueReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__NameAssignment_1"


    // $ANTLR start "rule__FGAValueReference__RowAssignment_3"
    // InternalMIC.g:3093:1: rule__FGAValueReference__RowAssignment_3 : ( RULE_INT ) ;
    public final void rule__FGAValueReference__RowAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3097:1: ( ( RULE_INT ) )
            // InternalMIC.g:3098:2: ( RULE_INT )
            {
            // InternalMIC.g:3098:2: ( RULE_INT )
            // InternalMIC.g:3099:3: RULE_INT
            {
             before(grammarAccess.getFGAValueReferenceAccess().getRowINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFGAValueReferenceAccess().getRowINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAValueReference__RowAssignment_3"


    // $ANTLR start "rule__FGAMeasuredValueReference__NameAssignment_1"
    // InternalMIC.g:3108:1: rule__FGAMeasuredValueReference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__FGAMeasuredValueReference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3112:1: ( ( RULE_ID ) )
            // InternalMIC.g:3113:2: ( RULE_ID )
            {
            // InternalMIC.g:3113:2: ( RULE_ID )
            // InternalMIC.g:3114:3: RULE_ID
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__NameAssignment_1"


    // $ANTLR start "rule__FGAMeasuredValueReference__RowAssignment_3"
    // InternalMIC.g:3123:1: rule__FGAMeasuredValueReference__RowAssignment_3 : ( RULE_INT ) ;
    public final void rule__FGAMeasuredValueReference__RowAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3127:1: ( ( RULE_INT ) )
            // InternalMIC.g:3128:2: ( RULE_INT )
            {
            // InternalMIC.g:3128:2: ( RULE_INT )
            // InternalMIC.g:3129:3: RULE_INT
            {
             before(grammarAccess.getFGAMeasuredValueReferenceAccess().getRowINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getFGAMeasuredValueReferenceAccess().getRowINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__FGAMeasuredValueReference__RowAssignment_3"


    // $ANTLR start "rule__Task__TaskPrologAssignment_0"
    // InternalMIC.g:3138:1: rule__Task__TaskPrologAssignment_0 : ( ruleMetaData ) ;
    public final void rule__Task__TaskPrologAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3142:1: ( ( ruleMetaData ) )
            // InternalMIC.g:3143:2: ( ruleMetaData )
            {
            // InternalMIC.g:3143:2: ( ruleMetaData )
            // InternalMIC.g:3144:3: ruleMetaData
            {
             before(grammarAccess.getTaskAccess().getTaskPrologMetaDataParserRuleCall_0_0()); 
            pushFollow(FOLLOW_2);
            ruleMetaData();

            state._fsp--;

             after(grammarAccess.getTaskAccess().getTaskPrologMetaDataParserRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__TaskPrologAssignment_0"


    // $ANTLR start "rule__Task__IndexAssignment_3"
    // InternalMIC.g:3153:1: rule__Task__IndexAssignment_3 : ( RULE_INT ) ;
    public final void rule__Task__IndexAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3157:1: ( ( RULE_INT ) )
            // InternalMIC.g:3158:2: ( RULE_INT )
            {
            // InternalMIC.g:3158:2: ( RULE_INT )
            // InternalMIC.g:3159:3: RULE_INT
            {
             before(grammarAccess.getTaskAccess().getIndexINTTerminalRuleCall_3_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getIndexINTTerminalRuleCall_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__IndexAssignment_3"


    // $ANTLR start "rule__Task__TypeAssignment_5"
    // InternalMIC.g:3168:1: rule__Task__TypeAssignment_5 : ( ruleTaskStrategy ) ;
    public final void rule__Task__TypeAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3172:1: ( ( ruleTaskStrategy ) )
            // InternalMIC.g:3173:2: ( ruleTaskStrategy )
            {
            // InternalMIC.g:3173:2: ( ruleTaskStrategy )
            // InternalMIC.g:3174:3: ruleTaskStrategy
            {
             before(grammarAccess.getTaskAccess().getTypeTaskStrategyParserRuleCall_5_0()); 
            pushFollow(FOLLOW_2);
            ruleTaskStrategy();

            state._fsp--;

             after(grammarAccess.getTaskAccess().getTypeTaskStrategyParserRuleCall_5_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__TypeAssignment_5"


    // $ANTLR start "rule__Task__CycleTimeAssignment_6_1"
    // InternalMIC.g:3183:1: rule__Task__CycleTimeAssignment_6_1 : ( RULE_INT ) ;
    public final void rule__Task__CycleTimeAssignment_6_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3187:1: ( ( RULE_INT ) )
            // InternalMIC.g:3188:2: ( RULE_INT )
            {
            // InternalMIC.g:3188:2: ( RULE_INT )
            // InternalMIC.g:3189:3: RULE_INT
            {
             before(grammarAccess.getTaskAccess().getCycleTimeINTTerminalRuleCall_6_1_0()); 
            match(input,RULE_INT,FOLLOW_2); 
             after(grammarAccess.getTaskAccess().getCycleTimeINTTerminalRuleCall_6_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__CycleTimeAssignment_6_1"


    // $ANTLR start "rule__Task__InstructionsAssignment_8"
    // InternalMIC.g:3198:1: rule__Task__InstructionsAssignment_8 : ( ruleInstruction ) ;
    public final void rule__Task__InstructionsAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3202:1: ( ( ruleInstruction ) )
            // InternalMIC.g:3203:2: ( ruleInstruction )
            {
            // InternalMIC.g:3203:2: ( ruleInstruction )
            // InternalMIC.g:3204:3: ruleInstruction
            {
             before(grammarAccess.getTaskAccess().getInstructionsInstructionParserRuleCall_8_0()); 
            pushFollow(FOLLOW_2);
            ruleInstruction();

            state._fsp--;

             after(grammarAccess.getTaskAccess().getInstructionsInstructionParserRuleCall_8_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Task__InstructionsAssignment_8"


    // $ANTLR start "rule__ModuleInvokation__ModuleNameAssignment_0"
    // InternalMIC.g:3213:1: rule__ModuleInvokation__ModuleNameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ModuleInvokation__ModuleNameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3217:1: ( ( RULE_ID ) )
            // InternalMIC.g:3218:2: ( RULE_ID )
            {
            // InternalMIC.g:3218:2: ( RULE_ID )
            // InternalMIC.g:3219:3: RULE_ID
            {
             before(grammarAccess.getModuleInvokationAccess().getModuleNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getModuleInvokationAccess().getModuleNameIDTerminalRuleCall_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__ModuleNameAssignment_0"


    // $ANTLR start "rule__ModuleInvokation__ArgumentsAssignment_2_0"
    // InternalMIC.g:3228:1: rule__ModuleInvokation__ArgumentsAssignment_2_0 : ( ruleSymbolAccessor ) ;
    public final void rule__ModuleInvokation__ArgumentsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3232:1: ( ( ruleSymbolAccessor ) )
            // InternalMIC.g:3233:2: ( ruleSymbolAccessor )
            {
            // InternalMIC.g:3233:2: ( ruleSymbolAccessor )
            // InternalMIC.g:3234:3: ruleSymbolAccessor
            {
             before(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_0_0()); 
            pushFollow(FOLLOW_2);
            ruleSymbolAccessor();

            state._fsp--;

             after(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__ArgumentsAssignment_2_0"


    // $ANTLR start "rule__ModuleInvokation__ArgumentsAssignment_2_1_1"
    // InternalMIC.g:3243:1: rule__ModuleInvokation__ArgumentsAssignment_2_1_1 : ( ruleSymbolAccessor ) ;
    public final void rule__ModuleInvokation__ArgumentsAssignment_2_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3247:1: ( ( ruleSymbolAccessor ) )
            // InternalMIC.g:3248:2: ( ruleSymbolAccessor )
            {
            // InternalMIC.g:3248:2: ( ruleSymbolAccessor )
            // InternalMIC.g:3249:3: ruleSymbolAccessor
            {
             before(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_1_1_0()); 
            pushFollow(FOLLOW_2);
            ruleSymbolAccessor();

            state._fsp--;

             after(grammarAccess.getModuleInvokationAccess().getArgumentsSymbolAccessorParserRuleCall_2_1_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleInvokation__ArgumentsAssignment_2_1_1"


    // $ANTLR start "rule__SymbolAccessor__WritingAssignment_0_0_1"
    // InternalMIC.g:3258:1: rule__SymbolAccessor__WritingAssignment_0_0_1 : ( ( 'true' ) ) ;
    public final void rule__SymbolAccessor__WritingAssignment_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3262:1: ( ( ( 'true' ) ) )
            // InternalMIC.g:3263:2: ( ( 'true' ) )
            {
            // InternalMIC.g:3263:2: ( ( 'true' ) )
            // InternalMIC.g:3264:3: ( 'true' )
            {
             before(grammarAccess.getSymbolAccessorAccess().getWritingTrueKeyword_0_0_1_0()); 
            // InternalMIC.g:3265:3: ( 'true' )
            // InternalMIC.g:3266:4: 'true'
            {
             before(grammarAccess.getSymbolAccessorAccess().getWritingTrueKeyword_0_0_1_0()); 
            match(input,41,FOLLOW_2); 
             after(grammarAccess.getSymbolAccessorAccess().getWritingTrueKeyword_0_0_1_0()); 

            }

             after(grammarAccess.getSymbolAccessorAccess().getWritingTrueKeyword_0_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__WritingAssignment_0_0_1"


    // $ANTLR start "rule__SymbolAccessor__SymbolAssignment_0_1"
    // InternalMIC.g:3277:1: rule__SymbolAccessor__SymbolAssignment_0_1 : ( ( RULE_ID ) ) ;
    public final void rule__SymbolAccessor__SymbolAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
        	
        try {
            // InternalMIC.g:3281:1: ( ( ( RULE_ID ) ) )
            // InternalMIC.g:3282:2: ( ( RULE_ID ) )
            {
            // InternalMIC.g:3282:2: ( ( RULE_ID ) )
            // InternalMIC.g:3283:3: ( RULE_ID )
            {
             before(grammarAccess.getSymbolAccessorAccess().getSymbolSymbolCrossReference_0_1_0()); 
            // InternalMIC.g:3284:3: ( RULE_ID )
            // InternalMIC.g:3285:4: RULE_ID
            {
             before(grammarAccess.getSymbolAccessorAccess().getSymbolSymbolIDTerminalRuleCall_0_1_0_1()); 
            match(input,RULE_ID,FOLLOW_2); 
             after(grammarAccess.getSymbolAccessorAccess().getSymbolSymbolIDTerminalRuleCall_0_1_0_1()); 

            }

             after(grammarAccess.getSymbolAccessorAccess().getSymbolSymbolCrossReference_0_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__SymbolAccessor__SymbolAssignment_0_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000010000000082L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000013FF0000080L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000011FE0000082L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000012000000082L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000010000000080L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000012000000080L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000FFFC00L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x00000140000000A0L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x00000100000000A2L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000008008000060L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000008000000060L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000008000000020L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000020000000000L});

}