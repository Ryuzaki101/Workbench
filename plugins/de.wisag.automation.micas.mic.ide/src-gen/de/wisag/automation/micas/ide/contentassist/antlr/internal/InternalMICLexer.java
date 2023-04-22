package de.wisag.automation.micas.ide.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMICLexer extends Lexer {
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

    public InternalMICLexer() {;} 
    public InternalMICLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalMICLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalMIC.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:11:7: ( 'cycl' )
            // InternalMIC.g:11:9: 'cycl'
            {
            match("cycl"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:12:7: ( 'back' )
            // InternalMIC.g:12:9: 'back'
            {
            match("back"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:13:7: ( 'init' )
            // InternalMIC.g:13:9: 'init'
            {
            match("init"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:14:7: ( 'cycls' )
            // InternalMIC.g:14:9: 'cycls'
            {
            match("cycls"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:15:7: ( 'evnts' )
            // InternalMIC.g:15:9: 'evnts'
            {
            match("evnts"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:16:7: ( 'backs' )
            // InternalMIC.g:16:9: 'backs'
            {
            match("backs"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:17:7: ( 'inits' )
            // InternalMIC.g:17:9: 'inits'
            {
            match("inits"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:18:7: ( 'CYCL' )
            // InternalMIC.g:18:9: 'CYCL'
            {
            match("CYCL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:19:7: ( 'BACK' )
            // InternalMIC.g:19:9: 'BACK'
            {
            match("BACK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:20:7: ( 'INIT' )
            // InternalMIC.g:20:9: 'INIT'
            {
            match("INIT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:21:7: ( 'CYCLS' )
            // InternalMIC.g:21:9: 'CYCLS'
            {
            match("CYCLS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:22:7: ( 'EVNTS' )
            // InternalMIC.g:22:9: 'EVNTS'
            {
            match("EVNTS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:23:7: ( 'BACKS' )
            // InternalMIC.g:23:9: 'BACKS'
            {
            match("BACKS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:24:7: ( 'INITS' )
            // InternalMIC.g:24:9: 'INITS'
            {
            match("INITS"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:25:7: ( 'MODUL' )
            // InternalMIC.g:25:9: 'MODUL'
            {
            match("MODUL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:26:7: ( '(' )
            // InternalMIC.g:26:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:27:7: ( ',' )
            // InternalMIC.g:27:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:28:7: ( ')' )
            // InternalMIC.g:28:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:29:7: ( 'ENDMODUL' )
            // InternalMIC.g:29:9: 'ENDMODUL'
            {
            match("ENDMODUL"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "T__29"
    public final void mT__29() throws RecognitionException {
        try {
            int _type = T__29;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:30:7: ( 'WordV' )
            // InternalMIC.g:30:9: 'WordV'
            {
            match("WordV"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__29"

    // $ANTLR start "T__30"
    public final void mT__30() throws RecognitionException {
        try {
            int _type = T__30;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:31:7: ( 'WordK' )
            // InternalMIC.g:31:9: 'WordK'
            {
            match("WordK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__30"

    // $ANTLR start "T__31"
    public final void mT__31() throws RecognitionException {
        try {
            int _type = T__31;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:32:7: ( 'FloatV' )
            // InternalMIC.g:32:9: 'FloatV'
            {
            match("FloatV"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__31"

    // $ANTLR start "T__32"
    public final void mT__32() throws RecognitionException {
        try {
            int _type = T__32;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:33:7: ( 'FloatK' )
            // InternalMIC.g:33:9: 'FloatK'
            {
            match("FloatK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__32"

    // $ANTLR start "T__33"
    public final void mT__33() throws RecognitionException {
        try {
            int _type = T__33;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:34:7: ( 'IPAMB' )
            // InternalMIC.g:34:9: 'IPAMB'
            {
            match("IPAMB"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__33"

    // $ANTLR start "T__34"
    public final void mT__34() throws RecognitionException {
        try {
            int _type = T__34;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:35:7: ( 'IPAAW' )
            // InternalMIC.g:35:9: 'IPAAW'
            {
            match("IPAAW"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__34"

    // $ANTLR start "T__35"
    public final void mT__35() throws RecognitionException {
        try {
            int _type = T__35;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:36:7: ( 'IPAZW' )
            // InternalMIC.g:36:9: 'IPAZW'
            {
            match("IPAZW"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__35"

    // $ANTLR start "T__36"
    public final void mT__36() throws RecognitionException {
        try {
            int _type = T__36;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:37:7: ( 'IPAMW' )
            // InternalMIC.g:37:9: 'IPAMW'
            {
            match("IPAMW"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__36"

    // $ANTLR start "T__37"
    public final void mT__37() throws RecognitionException {
        try {
            int _type = T__37;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:38:7: ( 'TASK' )
            // InternalMIC.g:38:9: 'TASK'
            {
            match("TASK"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__37"

    // $ANTLR start "T__38"
    public final void mT__38() throws RecognitionException {
        try {
            int _type = T__38;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:39:7: ( 'ENDE' )
            // InternalMIC.g:39:9: 'ENDE'
            {
            match("ENDE"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__38"

    // $ANTLR start "T__39"
    public final void mT__39() throws RecognitionException {
        try {
            int _type = T__39;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:40:7: ( 'writeaccess=' )
            // InternalMIC.g:40:9: 'writeaccess='
            {
            match("writeaccess="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__39"

    // $ANTLR start "T__40"
    public final void mT__40() throws RecognitionException {
        try {
            int _type = T__40;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:41:7: ( '\\u00B0nothing' )
            // InternalMIC.g:41:9: '\\u00B0nothing'
            {
            match("\u00B0nothing"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__40"

    // $ANTLR start "T__41"
    public final void mT__41() throws RecognitionException {
        try {
            int _type = T__41;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:42:7: ( 'true' )
            // InternalMIC.g:42:9: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__41"

    // $ANTLR start "RULE_RAW_METADATE"
    public final void mRULE_RAW_METADATE() throws RecognitionException {
        try {
            int _type = RULE_RAW_METADATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:3296:19: ( ';' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalMIC.g:3296:21: ';' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match(';'); 
            // InternalMIC.g:3296:25: (~ ( ( '\\n' | '\\r' ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFF')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMIC.g:3296:25: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // InternalMIC.g:3296:41: ( ( '\\r' )? '\\n' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='\n'||LA3_0=='\r') ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalMIC.g:3296:42: ( '\\r' )? '\\n'
                    {
                    // InternalMIC.g:3296:42: ( '\\r' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='\r') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalMIC.g:3296:42: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_RAW_METADATE"

    // $ANTLR start "RULE_XFLOAT"
    public final void mRULE_XFLOAT() throws RecognitionException {
        try {
            int _type = RULE_XFLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:3298:13: ( ( '-' | '+' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+ )
            // InternalMIC.g:3298:15: ( '-' | '+' )? ( '0' .. '9' )+ '.' ( '0' .. '9' )+
            {
            // InternalMIC.g:3298:15: ( '-' | '+' )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='+'||LA4_0=='-') ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMIC.g:
                    {
                    if ( input.LA(1)=='+'||input.LA(1)=='-' ) {
                        input.consume();

                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        recover(mse);
                        throw mse;}


                    }
                    break;

            }

            // InternalMIC.g:3298:26: ( '0' .. '9' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='0' && LA5_0<='9')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMIC.g:3298:27: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);

            match('.'); 
            // InternalMIC.g:3298:42: ( '0' .. '9' )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalMIC.g:3298:43: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_XFLOAT"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:3300:10: ( ( '-' )? ( '0' .. '9' )+ )
            // InternalMIC.g:3300:12: ( '-' )? ( '0' .. '9' )+
            {
            // InternalMIC.g:3300:12: ( '-' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0=='-') ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMIC.g:3300:12: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // InternalMIC.g:3300:17: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalMIC.g:3300:18: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:3302:9: ( ( '$' | '&' | 'A' .. 'Z' | 'a' .. 'z' | '_' | '/' | '0' .. '9' | '\\\\' ) ( '&' | 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '@' | '\\u00C4' | '\\u00DC' | '\\u00D6' | '\\u00E4' | '\\u00FC' | '\\u00F6' | '\\u00DF' | '<' | '>' | '.' | '_' | '/' | '+' | '-' | '~' | '=' | '?' )+ )
            // InternalMIC.g:3302:11: ( '$' | '&' | 'A' .. 'Z' | 'a' .. 'z' | '_' | '/' | '0' .. '9' | '\\\\' ) ( '&' | 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '@' | '\\u00C4' | '\\u00DC' | '\\u00D6' | '\\u00E4' | '\\u00FC' | '\\u00F6' | '\\u00DF' | '<' | '>' | '.' | '_' | '/' | '+' | '-' | '~' | '=' | '?' )+
            {
            if ( input.LA(1)=='$'||input.LA(1)=='&'||(input.LA(1)>='/' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='\\'||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalMIC.g:3302:61: ( '&' | 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '@' | '\\u00C4' | '\\u00DC' | '\\u00D6' | '\\u00E4' | '\\u00FC' | '\\u00F6' | '\\u00DF' | '<' | '>' | '.' | '_' | '/' | '+' | '-' | '~' | '=' | '?' )+
            int cnt9=0;
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0=='&'||LA9_0=='+'||(LA9_0>='-' && LA9_0<='9')||(LA9_0>='<' && LA9_0<='Z')||LA9_0=='_'||(LA9_0>='a' && LA9_0<='z')||LA9_0=='~'||LA9_0=='\u00C4'||LA9_0=='\u00D6'||LA9_0=='\u00DC'||LA9_0=='\u00DF'||LA9_0=='\u00E4'||LA9_0=='\u00F6'||LA9_0=='\u00FC') ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // InternalMIC.g:
            	    {
            	    if ( input.LA(1)=='&'||input.LA(1)=='+'||(input.LA(1)>='-' && input.LA(1)<='9')||(input.LA(1)>='<' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z')||input.LA(1)=='~'||input.LA(1)=='\u00C4'||input.LA(1)=='\u00D6'||input.LA(1)=='\u00DC'||input.LA(1)=='\u00DF'||input.LA(1)=='\u00E4'||input.LA(1)=='\u00F6'||input.LA(1)=='\u00FC' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt9 >= 1 ) break loop9;
                        EarlyExitException eee =
                            new EarlyExitException(9, input);
                        throw eee;
                }
                cnt9++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_SPACE"
    public final void mRULE_SPACE() throws RecognitionException {
        try {
            int _type = RULE_SPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:3304:12: ( ( ' ' | '\\t' ) )
            // InternalMIC.g:3304:14: ( ' ' | '\\t' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SPACE"

    // $ANTLR start "RULE_EOL"
    public final void mRULE_EOL() throws RecognitionException {
        try {
            int _type = RULE_EOL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalMIC.g:3306:10: ( ( '\\r' | '\\n' )+ )
            // InternalMIC.g:3306:12: ( '\\r' | '\\n' )+
            {
            // InternalMIC.g:3306:12: ( '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalMIC.g:
            	    {
            	    if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_EOL"

    public void mTokens() throws RecognitionException {
        // InternalMIC.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | RULE_RAW_METADATE | RULE_XFLOAT | RULE_INT | RULE_ID | RULE_SPACE | RULE_EOL )
        int alt11=38;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // InternalMIC.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // InternalMIC.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // InternalMIC.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // InternalMIC.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // InternalMIC.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // InternalMIC.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // InternalMIC.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // InternalMIC.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // InternalMIC.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // InternalMIC.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // InternalMIC.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // InternalMIC.g:1:76: T__21
                {
                mT__21(); 

                }
                break;
            case 13 :
                // InternalMIC.g:1:82: T__22
                {
                mT__22(); 

                }
                break;
            case 14 :
                // InternalMIC.g:1:88: T__23
                {
                mT__23(); 

                }
                break;
            case 15 :
                // InternalMIC.g:1:94: T__24
                {
                mT__24(); 

                }
                break;
            case 16 :
                // InternalMIC.g:1:100: T__25
                {
                mT__25(); 

                }
                break;
            case 17 :
                // InternalMIC.g:1:106: T__26
                {
                mT__26(); 

                }
                break;
            case 18 :
                // InternalMIC.g:1:112: T__27
                {
                mT__27(); 

                }
                break;
            case 19 :
                // InternalMIC.g:1:118: T__28
                {
                mT__28(); 

                }
                break;
            case 20 :
                // InternalMIC.g:1:124: T__29
                {
                mT__29(); 

                }
                break;
            case 21 :
                // InternalMIC.g:1:130: T__30
                {
                mT__30(); 

                }
                break;
            case 22 :
                // InternalMIC.g:1:136: T__31
                {
                mT__31(); 

                }
                break;
            case 23 :
                // InternalMIC.g:1:142: T__32
                {
                mT__32(); 

                }
                break;
            case 24 :
                // InternalMIC.g:1:148: T__33
                {
                mT__33(); 

                }
                break;
            case 25 :
                // InternalMIC.g:1:154: T__34
                {
                mT__34(); 

                }
                break;
            case 26 :
                // InternalMIC.g:1:160: T__35
                {
                mT__35(); 

                }
                break;
            case 27 :
                // InternalMIC.g:1:166: T__36
                {
                mT__36(); 

                }
                break;
            case 28 :
                // InternalMIC.g:1:172: T__37
                {
                mT__37(); 

                }
                break;
            case 29 :
                // InternalMIC.g:1:178: T__38
                {
                mT__38(); 

                }
                break;
            case 30 :
                // InternalMIC.g:1:184: T__39
                {
                mT__39(); 

                }
                break;
            case 31 :
                // InternalMIC.g:1:190: T__40
                {
                mT__40(); 

                }
                break;
            case 32 :
                // InternalMIC.g:1:196: T__41
                {
                mT__41(); 

                }
                break;
            case 33 :
                // InternalMIC.g:1:202: RULE_RAW_METADATE
                {
                mRULE_RAW_METADATE(); 

                }
                break;
            case 34 :
                // InternalMIC.g:1:220: RULE_XFLOAT
                {
                mRULE_XFLOAT(); 

                }
                break;
            case 35 :
                // InternalMIC.g:1:232: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 36 :
                // InternalMIC.g:1:241: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 37 :
                // InternalMIC.g:1:249: RULE_SPACE
                {
                mRULE_SPACE(); 

                }
                break;
            case 38 :
                // InternalMIC.g:1:260: RULE_EOL
                {
                mRULE_EOL(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\25\uffff\1\55\4\uffff\20\27\1\55\1\27\1\55\1\uffff\20\27\1\26\1\123\1\125\1\127\1\27\1\132\1\134\1\136\5\27\1\145\3\27\1\152\1\27\1\154\1\155\1\uffff\1\156\1\uffff\1\157\1\uffff\1\160\1\161\1\uffff\1\162\1\uffff\1\163\1\uffff\1\164\1\165\1\166\1\167\1\170\1\27\1\uffff\1\172\1\173\1\174\1\27\1\uffff\1\27\15\uffff\1\27\3\uffff\1\u0081\1\u0082\2\27\2\uffff\1\27\1\u0086\1\27\1\uffff\3\27\1\u008b\1\uffff";
    static final String DFA11_eofS =
        "\u008c\uffff";
    static final String DFA11_minS =
        "\1\11\11\46\3\uffff\4\46\1\uffff\1\46\1\uffff\1\60\1\46\4\uffff\2\143\1\151\1\156\2\103\1\111\1\101\1\116\2\104\1\162\1\157\1\123\1\151\1\165\1\56\1\60\1\46\1\uffff\1\154\1\153\2\164\1\114\1\113\1\124\1\101\1\124\1\105\1\125\1\144\1\141\1\113\1\164\1\145\4\46\1\163\3\46\1\102\2\127\1\123\1\117\1\46\1\114\1\113\1\164\1\46\1\145\2\46\1\uffff\1\46\1\uffff\1\46\1\uffff\2\46\1\uffff\1\46\1\uffff\1\46\1\uffff\5\46\1\104\1\uffff\3\46\1\113\1\uffff\1\141\15\uffff\1\125\3\uffff\2\46\1\143\1\114\2\uffff\1\143\1\46\1\145\1\uffff\2\163\1\75\1\46\1\uffff";
    static final String DFA11_maxS =
        "\1\u00b0\11\u00fc\3\uffff\4\u00fc\1\uffff\1\u00fc\1\uffff\1\71\1\u00fc\4\uffff\2\143\1\151\1\156\2\103\1\111\1\101\1\116\2\104\1\162\1\157\1\123\1\151\1\165\2\71\1\u00fc\1\uffff\1\154\1\153\2\164\1\114\1\113\1\124\1\132\1\124\1\115\1\125\1\144\1\141\1\113\1\164\1\145\4\u00fc\1\163\3\u00fc\3\127\1\123\1\117\1\u00fc\1\114\1\126\1\164\1\u00fc\1\145\2\u00fc\1\uffff\1\u00fc\1\uffff\1\u00fc\1\uffff\2\u00fc\1\uffff\1\u00fc\1\uffff\1\u00fc\1\uffff\5\u00fc\1\104\1\uffff\3\u00fc\1\126\1\uffff\1\141\15\uffff\1\125\3\uffff\2\u00fc\1\143\1\114\2\uffff\1\143\1\u00fc\1\145\1\uffff\2\163\1\75\1\u00fc\1\uffff";
    static final String DFA11_acceptS =
        "\12\uffff\1\20\1\21\1\22\4\uffff\1\37\1\uffff\1\41\2\uffff\1\42\1\44\1\45\1\46\23\uffff\1\43\45\uffff\1\1\1\uffff\1\2\1\uffff\1\3\2\uffff\1\10\1\uffff\1\11\1\uffff\1\12\6\uffff\1\35\4\uffff\1\34\1\uffff\1\40\1\4\1\6\1\7\1\5\1\13\1\15\1\16\1\30\1\33\1\31\1\32\1\14\1\uffff\1\17\1\24\1\25\4\uffff\1\26\1\27\3\uffff\1\23\4\uffff\1\36";
    static final String DFA11_specialS =
        "\u008c\uffff}>";
    static final String[] DFA11_transitionS = {
            "\1\30\1\31\2\uffff\1\31\22\uffff\1\30\3\uffff\1\27\1\uffff\1\27\1\uffff\1\12\1\14\1\uffff\1\26\1\13\1\24\1\uffff\1\27\12\25\1\uffff\1\23\5\uffff\1\27\1\6\1\5\1\27\1\10\1\16\2\27\1\7\3\27\1\11\6\27\1\17\2\27\1\15\3\27\1\uffff\1\27\2\uffff\1\27\1\uffff\1\27\1\2\1\1\1\27\1\4\3\27\1\3\12\27\1\22\2\27\1\20\3\27\65\uffff\1\21",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\30\27\1\32\1\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\1\33\31\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\15\27\1\34\14\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\25\27\1\35\4\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\35\27\1\36\1\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\5\27\1\37\31\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\22\27\1\40\1\27\1\41\12\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\22\27\1\43\7\27\1\42\4\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\23\27\1\44\13\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\16\27\1\45\13\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\13\27\1\46\16\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\5\27\1\47\31\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\21\27\1\50\10\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\21\27\1\51\10\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\12\52",
            "\1\27\4\uffff\1\27\1\uffff\1\27\1\53\1\27\12\54\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "",
            "",
            "",
            "\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\62",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "\1\74",
            "\1\75",
            "\1\26\1\uffff\12\52",
            "\12\76",
            "\1\27\4\uffff\1\27\1\uffff\1\27\1\53\1\27\12\54\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\77",
            "\1\100",
            "\1\101",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\107\13\uffff\1\106\14\uffff\1\110",
            "\1\111",
            "\1\113\7\uffff\1\112",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\117",
            "\1\120",
            "\1\121",
            "\1\27\4\uffff\1\27\1\uffff\3\27\12\76\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\22\27\1\122\7\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\22\27\1\124\7\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\22\27\1\126\7\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\130",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\27\27\1\131\7\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\27\27\1\133\7\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\27\27\1\135\7\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\137\24\uffff\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\146",
            "\1\150\12\uffff\1\147",
            "\1\151",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\153",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\171",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\176\12\uffff\1\175",
            "",
            "\1\177",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\u0080",
            "",
            "",
            "",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\u0083",
            "\1\u0084",
            "",
            "",
            "\1\u0085",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            "\1\u0087",
            "",
            "\1\u0088",
            "\1\u0089",
            "\1\u008a",
            "\1\27\4\uffff\1\27\1\uffff\15\27\2\uffff\37\27\4\uffff\1\27\1\uffff\32\27\3\uffff\1\27\105\uffff\1\27\21\uffff\1\27\5\uffff\1\27\2\uffff\1\27\4\uffff\1\27\21\uffff\1\27\5\uffff\1\27",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | T__29 | T__30 | T__31 | T__32 | T__33 | T__34 | T__35 | T__36 | T__37 | T__38 | T__39 | T__40 | T__41 | RULE_RAW_METADATE | RULE_XFLOAT | RULE_INT | RULE_ID | RULE_SPACE | RULE_EOL );";
        }
    }
 

}