package de.wisag.automation.micas.h86;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import de.wisag.automation.micas.h86.internal.ModulesPersistentHelper;
import de.wisag.automation.micas.h86.modules.MicasModules;
import de.wisag.automation.micas.h86.modules.Module;
import de.wisag.automation.micas.h86.modules.ModulesFactory;
import de.wisag.automation.micas.h86.modules.Port;
import de.wisag.automation.micas.h86.modules.PortDataType;
import de.wisag.automation.micas.h86.modules.PortGroup;

public class BlockDef {
	class Typ {

	}
	/*** GroupType */
	class GTyp {
		/*** laufzeit pro Gruppenparameter		*/
		long Lfz;
		/*** Typinformation pro Gruppenparameter		*/
		Typ T;
	}
	/** jedes der folgenden Bitdefinitionen representiert einen moeglichen	*/
	/** Typ eines Baustein Ein- bzw. Ausgangs.				*/
	/** Wortzwischenwert			*/
	private final static int	 PRORT_TYPE_WORD_VAL		= 0x0001;
	/** Wortkonstante			*/
	private final static int  PRORT_TYPE_WORD_CONST		= 0x0002;
	/** Floatzwischenwert			*/
	private final static int 	 PRORT_TYPE_FLOAT_VAL	=	0x0004;
	/** Floatkonstante			*/
	private final static int 	 PRORT_TYPE_FLOAT_CONST	=	0x0008;
	/** FGA- Zaehlwertkonstante		*/
	private final static int 	 FGZW_b		= 0x0010;
	/** FGA- Meldungskonstante		*/
	private final static int 	 FGML_b		= 0x0020;
	/** FGA- Analogwertkonstante		*/
	private final static int 	 FGAW_b		= 0x0040;
	/** FGA- Messwertkonstante		*/
	private final static int 	 FGMW_b		= 0x0080;
	/*** Gruppenlaenge			*/
	private final static int 	 GRPL_b		= 0x0100;
	/** Zahlenkonstante			*/
	private final static int 	 ZALK_b		= 0x0200;

	/** Maske fuer Attribut Konstant		*/
	private final static int 	 KonstMsk	=  (PRORT_TYPE_WORD_CONST | PRORT_TYPE_FLOAT_CONST | FGZW_b | FGML_b | FGAW_b | FGMW_b);
	/** Maske fuer Attribut Float		*/
	private final static int 	 FloatMsk	=  (PRORT_TYPE_FLOAT_VAL | PRORT_TYPE_FLOAT_CONST);
	private final static int 	 WortMsk	= (PRORT_TYPE_WORD_VAL | PRORT_TYPE_WORD_CONST | FGZW_b | FGML_b | FGAW_b | FGMW_b);
	private final static int 	 IpaMsk		= (FGZW_b | FGML_b | FGAW_b | FGMW_b);
	private final static int 	 ZalkMsk	= (GRPL_b | ZALK_b);

	private final static int 	 gbl_b		= 0x8000;	/** Bit... Parameter global		*/
	private final static int 	 use_b		= 0x4000;	/** Bit... Parameter benutzt		*/
	/** Maske fuer Attribut Ausgang (nur	fuer Bausteintabelle )*/
	private final static int 	 Aus_b		= 0x2000;
	/** Analog oder Me�wertkonstante */
	private final static int 	 AWMW_b		= (FGMW_b | FGAW_b);

	/** Wort-Eingang (fuer Bausteintabelle)	*/
	private final static int 	 WORD_INPUT		= PRORT_TYPE_WORD_VAL | PRORT_TYPE_WORD_CONST;
	/** Wort-Ausgang (fuer Bausteintabelle)	*/
	private final static int 	 WORD_OUTPUT		= Aus_b | WORD_INPUT;
	/** Float-Eingang (fuer Bausteintabelle)	*/
	private final static int 	 REAL_INPUT		= PRORT_TYPE_FLOAT_VAL | PRORT_TYPE_FLOAT_CONST;
	/** Float-Ausgang (fuer Bausteintabelle)	*/
	private final static int 	 REAL_OUTPUT		= Aus_b | REAL_INPUT;

	/**  Achtung! diese Definitionen gelten gleichzeitig auch als Index	*/
	/**  auf das Typen-Array							*/

	private final static int 	 WortZ		= 0;	/** Typ Wort-Zwischenwert		*/
	private final static int 	 WortK		= 1;	/** Typ Wort-Konstante			*/
	private final static int 	 RealZ		= 2;	/** Typ Float-Zwischenwert		*/
	private final static int 	 RealK		= 3;	/** Typ Float-Konstante			*/
	private final static int 	 IpaZw		= 4;	/** FGA-Typen				*/
	private final static int 	 IpaMl		= 5;
	private final static int 	 IpaAw		= 6;
	private final static int 	 IpaMw		= 7;
	private final static int 	 Grupl		= 8;	/** Gruppenlaenge			*/
	private final static int 	 Zahlk		= 9;	/** Zahlenkonstante (z.B. Reglernummer)	*/

	static
	String[] Typen = new String[]{
			"WORDV", //
			"WORDK", //
			"FLOATV", //
			"FLOATK", //
			"IPAZW", //
			"IPAMB",//
			"IPAAW", //
			"IPAMW", //
			"Gruppenlaenge", //
			"Zahlenkonstante" };
	static
	String[] UdfTp = new String[] { "WORD_", "WORD_", "FLOAT_", "FLOAT_", "IPAZW", "IPAMB",
			"IPAAW", "IPAMW", "????_", "????_" };

	/** moegliche Abarbeitungsstrategien (gleichzeitig Index auf Array)  */

	public final static int 	Abs_zyk	 =   0;
	public final static int 	Abs_int	 =   1;
	public final static int 	Abs_bck	 =   2;
	public final static int 	Abs_ini	  =  3;
	public final static int 	Abs_zyks  =  4;
	public final static int 	Abs_ints  =  5;
	public final static int 	Abs_bcks  =  6;
	public final static int 	Abs_inis  =  7;

	public static
	String[] Abstrg = new String[]{
			"CYCL", //
			"EVNT", //
			"BACK", //
			"INIT", //
			"CYCLS", //
			"EVNTS", //
			"BACKS",
			"INITS" };
	public static int[] Abstrgv = new int[]{ 0x01, 0x02, 0x03, 0x04, 0x81, 0x82, 0x83, 0x84 };
	//private final static int 	AbsMax	    (sizeof(Abstrg)/sizeof(char*))


	Typ aTyp; /**    "      Typ				*/

	private final static int 	TypMax	    =0;//(sizeof(Typen)/sizeof(char*))
	private final static int 	Typmsk	    =0;//((1 << TypMax) - 1)

	static
	String[] Sword = new String[]{ //
			"MODUL", //
			"TASK", //
			"ENDMODUL" };

	private final static int 	SwMax	    = 0;//(sizeof(Sword)/sizeof(char*))

	private final static int 	Swlen	    = 0;

	static char[] StartMessage = { 'K', 'w', 'S', 'm', 's', 'g', 0x0B, 0x9A, 0x2B, 0x0B,
			0x02, 0x11, 0x93, 0x7B, 0xBB, 0x73, 0x02, 0x11, 0x7B, 0xB3, 0x2B, 0x93,
			0x48, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
			0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

	private final static int 	Meslen	= StartMessage.length;//StartMessage.length;

	/**	    S t a t u s d e f i n i t i o n e n				*/
	/** Die folgenden Statusdefinitionen sind gleichzeitig der Index		*/
	/** auf die Schuesselwortabelle						*/

	private final static int 	 ModDef		=0;	/** Moduldefinition			*/
	private final static int 	 TaskDef	=1;	/** Taskdefinition			*/
	private final static int 	 ModEnd		=2;	/** Modulende erreicht			*/

	/**
	 ** Hier stehen die Daten aller MICAS-Bausteine; und zwar jeweils die
	 ** Bausteinnummer, Bausteinname, Zahl der Ein- und Ausgaenge (ausgenommen
	 ** die Ein- und Ausgaenge, die zu einer Gruppenlaenge gehoeren), Zahl der
	 ** Gruppenlaengenangaben, Zahl der Vergangenheitswerte und pro Gruppen
	 ** laengenangabe ein "Parameteroffset" der die Anzahl der Parameter angibt,
	 ** die vor der betreffenden Gruppenlaengenangabe steht. Als Parameter
	 ** zaehlen dabei nur solche, die nicht selbst zu einer Gruppenlaenge
	 ** gehoeren.
	 **
	 ** Sowohl fuer die Gruppenlaengen, als auch fuer alle Ein- und Ausgaenge
	 ** werden die Typen beschrieben mit denen sie versorgt werden koennen.
	 **
	 ** Beispiel:
	 ** Baustein  XYZ
	 ** Adresse		Eingang 1
	 ** Adresse		Eingang 2
	 ** Gruppenlaenge	N
	 ** Adresse		Eingang 3
	 ** Adresse		Eingang 4
	 **    "			   "
	 **    "			   "
	 ** Adresse		Eingang N+2
	 ** Adresse		Ausgang 1
	 ** Gruppenlaenge	X
	 ** Adresse		Ausgang 2
	 ** Adresse		Ausgang 3
	 **    "			   "
	 **    "			   "
	 ** Adresse		Ausgang X+1
	 ** Adresse		Steuereingang
	 **
	 ** Somit ergibt sich:
	 ** Eingaenge:		3
	 ** Ausgaenge:		1
	 ** Gruppenlaengen:	2
	 ** Parameteroffsets:	2,1
	 **
	 **
	 **
	 */

	/** 	B a u s t e i n d e f i n i t i o n e n		*/
	/**	Eingangs-Parameterdefinitionen			*/

	       int[] ADSU_PTyp = new int[]{ GRPL_b, GRPL_b, REAL_OUTPUT };
	       int[][] ADSU_GTyp = new int[][]{ { 500, REAL_INPUT }, { 500, REAL_INPUT } };
	       int[] ADD2_PTyp 	= new int[]{ REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] SUB2_PTyp 	=  new int[] { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] CHS_PTyp 	=  new int[] { REAL_INPUT, REAL_OUTPUT };
	       int[] MULDI_PTyp = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] MULT_PTyp = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] ABSWER_PTyp = { REAL_INPUT, REAL_OUTPUT };
	       int[] MAX_PTyp = { GRPL_b, REAL_OUTPUT };
	       int[][] MAX_GTyp = { { 100, REAL_INPUT } };
	       int[] MIN_PTyp = { GRPL_b, REAL_OUTPUT };
	       int[][] MIN_GTyp = { { 100, REAL_INPUT } };
	       int[] LIMIT_PTyp = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] VGLOH_PTyp = { REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] VGLEH_PTyp = { REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] VGLUH_PTyp = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] VGL3P_PTyp = { REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT };
	       int[] INTE_PTyp = { REAL_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] VRZ_PTyp = { WORD_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT,
			REAL_OUTPUT };
	       int[] UHR_PTyp = { WORD_INPUT, WORD_INPUT, REAL_OUTPUT };
	       int[] AWT_PTyp = { WORD_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] UST_PTyp = { WORD_INPUT, REAL_INPUT, REAL_OUTPUT, REAL_OUTPUT };
	       int[] AWM_PTyp = { WORD_INPUT, WORD_INPUT };
	       int[] USM_PTyp = { WORD_INPUT, WORD_INPUT };
	       int[] FKG_PTyp = { REAL_INPUT, GRPL_b, REAL_OUTPUT };
	       int[][] FKG_GTyp = { { 400, REAL_INPUT } };
	       int[] PT1_PTyp = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] UND2_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] UND11_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] UND21_PTyp = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] UNDMN_PTyp = { GRPL_b, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
	       int[][] UNDMN_GTyp = { { 100, WORD_INPUT }, { 100, WORD_INPUT } };
	       int[] NAND2_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] ODR2_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] ODRMN_PTyp = { GRPL_b, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
	       int[][] ODRMN_GTyp = { { 100, WORD_INPUT }, { 100, WORD_INPUT } };
	       int[] NOR2_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] XOR2_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] NICHT_PTyp = { WORD_INPUT, WORD_OUTPUT };
	       int[] UVO_PTyp = { WORD_INPUT, GRPL_b, GRPL_b, GRPL_b, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
	       int[][] UVO_GTyp = { { 200, WORD_INPUT }, { 200, WORD_INPUT }, { 200, WORD_INPUT }, {
			200, WORD_INPUT } };
	       int[] AEQ_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] MOKS_PTyp = { WORD_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] MOKY_PTyp = { WORD_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] VVZ_PTyp = { WORD_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] PDM_PTyp = { REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
	       int[] RSS_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT, WORD_OUTPUT };
	       int[] TFF_PTyp = { WORD_INPUT, WORD_OUTPUT, WORD_OUTPUT };
	       int[] PACK_PTyp = { GRPL_b, WORD_OUTPUT };
	       int[][] PACK_GTyp = { { 200, WORD_INPUT } };
	       int[] UNPAC_PTyp = { WORD_INPUT, GRPL_b };
	       int[][] UNPAC_GTyp = { { 200, WORD_OUTPUT } };
	       int[] WAEQ_PTyp = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] WDEC_PTyp = { WORD_INPUT, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
	       int[][] WDEC_GTyp = { { 200, WORD_INPUT } };
	       int[] WUMC_PTyp = { WORD_INPUT, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
	       int[][] WUMC_GTyp = { { 200, WORD_INPUT } };
	       int[] BBAC_PTyp = { WORD_INPUT, WORD_INPUT, WORD_INPUT };
	       int[] REME_PTyp = { WORD_INPUT, WORD_INPUT, WORD_INPUT };
	       int[] MAZ_PTyp = { REAL_INPUT, WORD_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] ATRAS_PTyp = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT };
	       int[] SCHR_PTyp = { WORD_INPUT, WORD_INPUT, WORD_INPUT, GRPL_b, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT,
			GRPL_b };
	       int[][] SCHR_GTyp = { { 2000, REAL_INPUT }, { 2000, REAL_OUTPUT } };
	       int[] BTRA_PTyp = { WORD_INPUT, WORD_OUTPUT };
	       int[] ATRA_PTyp = { REAL_INPUT, REAL_OUTPUT };
	       int[] SETMEL_PTyp = { WORD_INPUT, GRPL_b, FGML_b, WORD_OUTPUT };
	       int[][] SETMEL_GTyp = { { 100, WORD_INPUT } };
	       int[] ZWAUS_PTyp = { WORD_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT, FGZW_b, WORD_OUTPUT };
	       int[] REGLER_PTyp = { ZALK_b, WORD_INPUT, WORD_INPUT, REAL_INPUT, REAL_OUTPUT, WORD_OUTPUT };
	       int[] UREG_PTyp = {
	    		   ZALK_b,
	    		   AWMW_b,
	    		   AWMW_b,
	    		   WORD_INPUT,
	    		   WORD_INPUT,
	    		   REAL_INPUT,
	    		   WORD_INPUT,
	    		   WORD_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   WORD_INPUT,
	    		   REAL_INPUT,
	    		   REAL_INPUT,
	    		   FGAW_b,
	    		   FGML_b,
	    		   REAL_OUTPUT,
	    		   WORD_OUTPUT
	    		   };
	       int[] LREG_PTyp = { REAL_INPUT, REAL_INPUT, WORD_INPUT, WORD_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT,
			REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT, WORD_OUTPUT };
	       int[] ZEGE_PTyp = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
	       int[] MELEIN_PTyp = { FGML_b, GRPL_b, WORD_OUTPUT };
	       int[][] MELEIN_GTyp = { { 100, WORD_OUTPUT } };
	       int[] ANEIN_PTyp = { AWMW_b, REAL_OUTPUT, WORD_OUTPUT };
	       int[] ZWEIN_PTyp = { FGZW_b, REAL_OUTPUT, WORD_OUTPUT };
	       int[] BEFAUS_PTyp =
			{ ZALK_b, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, FGML_b, WORD_OUTPUT };
	       int[] DSTAUS_PTyp = { REAL_INPUT, WORD_INPUT, REAL_INPUT, FGMW_b, FGML_b, WORD_OUTPUT };
	       int[] ANAUS_PTyp=  { REAL_INPUT, WORD_INPUT, AWMW_b, WORD_OUTPUT };
	       int[] SOLKEN_PTyp=  { ZALK_b, WORD_INPUT, REAL_OUTPUT, WORD_OUTPUT };
	       int[] ABSFEU_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] ENTHA_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] ABFEUG_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] ENTHAG_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] SEQ2_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT, REAL_OUTPUT, WORD_OUTPUT };
	       int[] SEQ3_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT,
			REAL_INPUT, WORD_INPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, WORD_OUTPUT, WORD_OUTPUT };
	       int[] TTZEIT_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] BENDE_PTyp=  { WORD_INPUT };
	       int[] REALF_PTyp=  { REAL_INPUT, REAL_OUTPUT };
	       int[] XHOY_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
	       int[] OPORTB_PTyp=  { WORD_INPUT, WORD_INPUT, WORD_INPUT };
	       int[] IPORTB_PTyp=  { WORD_INPUT, WORD_OUTPUT }; // input: port, output: portvalue
	       int[] MSET_PTyp=  { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT };
	       int[] MCPY_PTyp=  { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT };
	       int[] HLG_PTyp=  { WORD_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_INPUT, WORD_INPUT,
			REAL_INPUT, REAL_OUTPUT };
	       int[] KALUHR_PTyp=  { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT,
			REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, WORD_OUTPUT };
	       int[] TMESS_PTyp=  { WORD_INPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT };
	       int[] TSTART_PTyp=  { WORD_OUTPUT };
	       int[] TSTOP_PTyp=  { WORD_INPUT, WORD_OUTPUT, WORD_OUTPUT };

	/**
	 * #06au09# Sche: OTRS T2009071310000017
	 * Add these types to MIC, need it for error tracking
	 * (Lanxess: plants shut unexpectedly down)
	 * There are existing macros, which may be added by editing the MIC-file:
	 * FTOB -> FLOAT to Binary
	 * BTOF -> Binary to FLOAT
	 */
	       int[] FTOB_PTyp=  { REAL_INPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT,
			WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT };
	       int[] BTOF_PTyp=  { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT,
			WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, REAL_OUTPUT };

	private final static int 	BNrEnd	= 0x3000;	/** Nummer des Endebausteins	*/
	class BstDef {
		/**
		 * @param bNr Bausteinnummer
		 * @param bName Bausteinname
		 * @param eA Zahl der Eingaenge und Ausgaenge
		 * @param vw Zahl der Vergangenheitswerte
		 * @param lfz Laufzeit in us- Einheiten
		 * @param modZul  zul�ssige module
		 * @param gla Zahl der Gruppenlaengenang
		 * @param tp Pointer auf Typarray von Ein- und	Ausgaengen
		 * @param gTp Pointer auf Typarray von Gruppenl
		 */
		public BstDef(int bNr, String bName, int eA, int vw, long lfz,String modZul, int gla, int[] tp, int[][] gTp) {
			super();
			BNr = bNr;
			BName = bName;
			EA = eA;
			Vw = vw;
			Lfz = lfz;
			ModZul = modZul;
			Gla = gla;
			Tp = tp;
			GTp = gTp;
		}
		/** Bausteinnummer			*/
		final int BNr;
		/** Bausteinname				*/
		final String BName;
		/** Zahl der Eingaenge und Ausgaenge	*/
		final int EA;
		/** Zahl der Vergangenheitswerte		*/
		final int Vw;
		/** Laufzeit in us- Einheiten		*/
		final long Lfz;
		final String ModZul; /** zul�ssige module			*/
		/** Zahl der Gruppenlaengenang.		*/
		final int Gla;
		/** Pointer auf Typarray von Ein- und	Ausgaengen */
		final int[] Tp;
		/** Pointer auf Typarray von Gruppenl.	*/
		final int[][] GTp;
	};
	 String	UnZul1	= "ZP03,ZP10,ZP12,ZP13,ZM12,ZM13,ZM14,ZP20,AC40";
	       BstDef[] BS=  new BstDef[]{
	/** Typ   Name  Anzahl EA's  Vergangenheitsw.  unz. Mark.  Gl Offsets	*/


	new BstDef( BNrEnd, "ENDE", 0, 0, 100, null, 0, null, null ),
	// BstDef(int bNr, String bName, int eA, int vw, long lfz,String modZul, String gla, int[] tp, int[][] gTp)
	// .BstDef(int, String, int, int, int, null, int, int[], int[][])
	new BstDef( 0x3002, "ADSU", ADSU_PTyp.length, 0, 100, null,ADSU_GTyp.length, ADSU_PTyp, ADSU_GTyp ),

	new BstDef( 0X3003, "ADD2", ADD2_PTyp.length, 0, 700, null, 0, ADD2_PTyp,null ),

	new BstDef( 0X3004, "SUB2", SUB2_PTyp.length, 0, 700, null, 0, SUB2_PTyp,null ),

	new BstDef( 0X3005, "CHS", CHS_PTyp.length, 0, 100, null, 0, CHS_PTyp,null ),

	new BstDef( 0X3006, "MULDI", MULDI_PTyp.length, 0, 2200, null, 0,
			MULDI_PTyp, null ),

	new BstDef( 0X3007, "MULT", MULT_PTyp.length, 0, 700, null, 0, MULT_PTyp,
			null ),

	new BstDef( 0X3008, "ABSWER", ABSWER_PTyp.length, 0, 100, null, 0,
			ABSWER_PTyp, null ),

	new BstDef( 0X3009, "MAX", MAX_PTyp.length, 0, 50, null, MAX_GTyp.length, MAX_PTyp, MAX_GTyp ),

	new BstDef( 0X300A, "MIN", MIN_PTyp.length, 0, 50, null, MIN_GTyp.length, MIN_PTyp, MIN_GTyp ),

	new BstDef( 0X300B, "LIMIT", LIMIT_PTyp.length, 0, 250, null, 0,
			LIMIT_PTyp, null ),

	new BstDef( 0X300C, "ABSFEU", ABSFEU_PTyp.length, 28, 55000, null, 0,
			ABSFEU_PTyp, null ),

	new BstDef( 0X300D, "ENTHA", ENTHA_PTyp.length, 12, 4000, null, 0,
			ENTHA_PTyp, null ),

	new BstDef( 0X300E, "UND2", UND2_PTyp.length, 0, 50, null, 0, UND2_PTyp,
			null ),

	new BstDef( 0X300F, "UND11", UND11_PTyp.length, 0, 50, null, 0,
			UND11_PTyp, null ),

	new BstDef( 0X3010, "UND21", UND21_PTyp.length, 0, 50, null, 0,
			UND21_PTyp, null ),

	new BstDef( 0X3011, "UNDMN", UNDMN_PTyp.length, 0, 50, null,UNDMN_GTyp.length, UNDMN_PTyp, UNDMN_GTyp ),

	new BstDef( 0X3012, "NAND2", NAND2_PTyp.length, 0, 50, null, 0,
			NAND2_PTyp, null ),

	new BstDef( 0X3013, "ODR2", ODR2_PTyp.length, 0, 50, null, 0, ODR2_PTyp,
			null ),

	new BstDef( 0X3014, "ODRMN", ODRMN_PTyp.length, 0, 50, null,ODRMN_GTyp.length, ODRMN_PTyp, ODRMN_GTyp ),

	new BstDef( 0X3015, "NOR2", NOR2_PTyp.length, 0, 50, null, 0, NOR2_PTyp,
			null ),

	new BstDef( 0X3016, "XOR2", XOR2_PTyp.length, 0, 50, null, 0, XOR2_PTyp,
			null ),

	new BstDef( 0X3017, "NICHT", NICHT_PTyp.length, 0, 50, null, 0,
			NICHT_PTyp, null ),

	new BstDef( 0X3018, "UVO", UVO_PTyp.length, 0, 100, null, UVO_GTyp.length, UVO_PTyp, UVO_GTyp ),

			new BstDef( 0X3019, "AEQ", AEQ_PTyp.length, 0, 50, null, 0,
					AEQ_PTyp, null ),

			new BstDef( 0X301A, "RSS", RSS_PTyp.length, 2, 100, null, 0,
					RSS_PTyp, null ),

			new BstDef( 0X301B, "TFF", TFF_PTyp.length, 4, 100, null, 0,
					TFF_PTyp, null ),

			new BstDef( 0X301C, "INTE", INTE_PTyp.length, 16, 1000, null, 0,
					INTE_PTyp, null ),

			new BstDef( 0X301D, "PT1", PT1_PTyp.length, 22, 1000, null, 0,
					PT1_PTyp, null ),

			new BstDef( 0X301E, "VRZ", VRZ_PTyp.length, 8, 1000, null, 0,
					VRZ_PTyp, null ),

			new BstDef( 0X301F, "AWT", AWT_PTyp.length, 0, 100, null, 0,
					AWT_PTyp, null ),

			new BstDef( 0X3020, "UST", UST_PTyp.length, 0, 100, null, 0,
					UST_PTyp, null ),

			new BstDef( 0X3021, "SCHR", SCHR_PTyp.length, 4, 200, null,SCHR_GTyp.length, SCHR_PTyp, SCHR_GTyp ),

			new BstDef( 0X3022, "FKG", FKG_PTyp.length, 0, 4800, null,FKG_GTyp.length, FKG_PTyp, FKG_GTyp ),

			new BstDef( 0X3023, "MAZ", MAZ_PTyp.length, 6, 300, null, 0,
					MAZ_PTyp, null ),

			new BstDef( 0X3024, "SEQ2", SEQ2_PTyp.length, 30, 10000, null, 0,
					SEQ2_PTyp, null ),

			new BstDef( 0X3025, "SEQ3", SEQ3_PTyp.length, 64, 18000, null, 0,
					SEQ3_PTyp, null ),

			new BstDef( 0X3026, "VGLOH", VGLOH_PTyp.length, 0, 150, null, 0,
					VGLOH_PTyp, null ),

			new BstDef( 0X3027, "VGLEH", VGLEH_PTyp.length, 2, 250, null, 0,
					VGLEH_PTyp, null ),

			new BstDef( 0X3028, "VGLUH", VGLUH_PTyp.length, 2, 350, null, 0,
					VGLUH_PTyp, null ),

			new BstDef( 0X3029, "VGL3P", VGL3P_PTyp.length, 0, 550, null, 0,
					VGL3P_PTyp, null ),

			new BstDef( 0X302A, "UHR", UHR_PTyp.length, 4, 300, null, 0,
					UHR_PTyp, null ),

			new BstDef( 0X302B, "VVZ", VVZ_PTyp.length, 26, 4000, null, 0,
					VVZ_PTyp, null ),

			new BstDef( 0X302C, "MOKY", MOKY_PTyp.length, 16, 100, null, 0,
					MOKY_PTyp, null ),

			new BstDef( 0X302D, "MOKS", MOKS_PTyp.length, 16, 100, null, 0,
					MOKS_PTyp, null ),

			new BstDef( 0X302E, "PDM", PDM_PTyp.length, 26, 10000, null, 0,
					PDM_PTyp, null ),

			new BstDef( 0X302F, "ANEIN", ANEIN_PTyp.length, 0, 100, null, 0,ANEIN_PTyp, null ),

			new BstDef( 0X3030, "ZWEIN", ZWEIN_PTyp.length, 0, 100, null, 0,ZWEIN_PTyp, null ),

			new BstDef( 0X3031, "MELEIN", MELEIN_PTyp.length, 2, 100, null,MELEIN_GTyp.length, MELEIN_PTyp, MELEIN_GTyp ),

			new BstDef( 0X3032, "ANAUS", ANAUS_PTyp.length, 6, 100, null, 0,ANAUS_PTyp, null ),

			new BstDef( 0X3033, "BEFAUS", BEFAUS_PTyp.length, 4, 100, null, 0,BEFAUS_PTyp, null ),

			new BstDef( 0X3034, "SETMEL", SETMEL_PTyp.length, 4, 100, null,SETMEL_GTyp.length, SETMEL_PTyp, SETMEL_GTyp ),

			new BstDef( 0X3035, "ZWAUS", ZWAUS_PTyp.length, 0, 100, null, 0,ZWAUS_PTyp, null ),

			new BstDef( 0X3036, "DSTAUS", DSTAUS_PTyp.length, 16, 100, null,
					0, DSTAUS_PTyp, null ),

			new BstDef( 0X3037, "REGLER", REGLER_PTyp.length, 38, 50000, null,
					0, REGLER_PTyp, null ),

			new BstDef( 0X3038, "SOLKEN", SOLKEN_PTyp.length, 8, 10000, null,
					0, SOLKEN_PTyp, null ),

			new BstDef( 0X3039, "UREG", UREG_PTyp.length, 38, 50000, null, 0,
					UREG_PTyp, null ),

			new BstDef( 0X303A, "ATRA", ATRA_PTyp.length, 0, 200, null, 0,
					ATRA_PTyp, null ),

			new BstDef( 0X303B, "BTRA", BTRA_PTyp.length, 0, 200, null, 0,
					BTRA_PTyp, null ),

			new BstDef( 0X303C, "TTZEIT", TTZEIT_PTyp.length, 84, 500, null,
					0, TTZEIT_PTyp, null ),

			new BstDef( 0X303D, "BENDE", BENDE_PTyp.length, 0, 150, null, 0,
					BENDE_PTyp, null ),

			new BstDef( 0X303E, "SIN", REALF_PTyp.length, 0, 25000, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X303F, "COS", REALF_PTyp.length, 0, 25000, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3040, "EHOX", REALF_PTyp.length, 0, 40000, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3041, "LN", REALF_PTyp.length, 0, 15000, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3042, "LOG", REALF_PTyp.length, 0, 15000, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3043, "XHOY", XHOY_PTyp.length, 0, 45000, null, 0,
					XHOY_PTyp, null ),

			new BstDef( 0X3044, "RAD", REALF_PTyp.length, 0, 1500, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3045, "DEG", REALF_PTyp.length, 0, 700, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3046, "SQRT", REALF_PTyp.length, 0, 11000, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3047, "QUAD", REALF_PTyp.length, 0, 700, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3048, "REZI", REALF_PTyp.length, 0, 1500, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X3049, "MULK2", REALF_PTyp.length, 0, 250, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X304A, "DIVK2", REALF_PTyp.length, 0, 250, null, 0,
					REALF_PTyp, null ),

			new BstDef( 0X304B, "OPORTB", OPORTB_PTyp.length, 0, 100, null, 0,
					OPORTB_PTyp, null ),

			new BstDef( 0X304C, "IPORTB", IPORTB_PTyp.length, 0, 100, null, 0,
					IPORTB_PTyp, null ),

			new BstDef( 0X304D, "MSET", MSET_PTyp.length, 0, 1000, null, 0,
					MSET_PTyp, null ),

			new BstDef( 0X304E, "MCPY", MSET_PTyp.length, 0, 1000, null, 0,
					MCPY_PTyp, null ),

			new BstDef( 0X304F, "HLG", HLG_PTyp.length, 16, 500, null, 0,
					HLG_PTyp, null ),

			new BstDef( 0X3050, "TSTART", TSTART_PTyp.length, 0, 200, UnZul1,
					0, TSTART_PTyp, null ),

			new BstDef( 0X3051, "TMESS", TMESS_PTyp.length, 10, 200, UnZul1,
					0, TMESS_PTyp, null ),

			new BstDef( 0X3052, "LREG", LREG_PTyp.length, 38, 50000, null, 0,
					LREG_PTyp, null ),

			new BstDef( 0X3053, "KALUHR", KALUHR_PTyp.length, 0, 500, UnZul1,
					0, KALUHR_PTyp, null ),

			new BstDef( 0X3054, "ABFEUG", ABFEUG_PTyp.length, 28, 50000, null,
					0, ABFEUG_PTyp, null ),

			new BstDef( 0X3055, "ENTHAG", ENTHAG_PTyp.length, 12, 5500, null,
					0, ENTHAG_PTyp, null ),

			new BstDef( 0X3056, "FTOB", FTOB_PTyp.length, 0, 500, UnZul1, 0,
					FTOB_PTyp, null ),

			new BstDef( 0X3057, "BTOF", BTOF_PTyp.length, 0, 500, UnZul1, 0,
					BTOF_PTyp, null ),

	};
	       public static void main(String[] args) throws IOException {
			BlockDef def = new BlockDef();
			;
			ModulesPersistentHelper.saveModules(def.createModules(), new FileOutputStream("modules.xmi"));
		}
	public MicasModules createModules() {
			BstDef[] x = BS;
			ModulesFactory factory = ModulesFactory.eINSTANCE;
			MicasModules modules = factory.createMicasModules();
			for (int i = 0; i < x.length; i++) {
				BstDef bstDef = x[i];
				int id = bstDef.BNr;
				String name=bstDef.BName;
				int[] ports = bstDef.Tp;
				int[][] grpPorts = bstDef.GTp;
				Module module = factory.createModule();
				modules.getModules().add(module);
				module.setId(id);
				module.setName(name);
				module.setPastValueCount(bstDef.Vw);
				module.setRuntime(bstDef.Lfz);

				int groupPortIndex=0;
				if (ports==null) {
					System.out.println("No ports for " + name);
					continue;
				}
				boolean onOutputSide = false;
				for (int portIndex = 0; portIndex < ports.length; portIndex++) {
					Port currentPort =  null;
					int portType = ports[portIndex];
					if (portType==GRPL_b) {
						PortGroup groupPort = createPortGroup(factory,grpPorts, groupPortIndex, portIndex);
						currentPort=groupPort;
						groupPortIndex++;
					} else {
						currentPort = createPort(factory, name, portIndex, portType, onOutputSide);
					}
					if (currentPort.isInputPort()) {
						module.getInputs().add(currentPort);
					} else {
						onOutputSide=true;
						module.getOutputs().add(currentPort);
					}

				}
			}
			System.out.println("All:" + x.length);
			return modules;
		}
		private Port createPort(ModulesFactory factory, String name, int portIndex, int portType, boolean onOutputSide) {
			Port port2 = factory.createPort();
			switch (portType) {
			case WORD_INPUT:
				port2.getAllowedPortDataTypes().add(PortDataType.WORD_VAR);
				port2.getAllowedPortDataTypes().add(PortDataType.WORD_CONST);
				port2.setIndex(portIndex);
				port2.setInputPort(true);
				break;
			case WORD_OUTPUT:
				port2.getAllowedPortDataTypes().add(PortDataType.WORD_VAR);
				port2.getAllowedPortDataTypes().add(PortDataType.WORD_CONST);
				port2.setIndex(portIndex);
				port2.setInputPort(false);
				break;
			case REAL_INPUT:
				port2.getAllowedPortDataTypes().add(PortDataType.FLOAT_VAR);
				port2.getAllowedPortDataTypes().add(PortDataType.FLOAT_CONST);
				port2.setIndex(portIndex);
				port2.setInputPort(true);
				break;
			case REAL_OUTPUT:
				port2.getAllowedPortDataTypes().add(PortDataType.FLOAT_VAR);
				port2.getAllowedPortDataTypes().add(PortDataType.FLOAT_CONST);
				port2.setIndex(portIndex);
				port2.setInputPort(false);
				break;

			case ZALK_b:
				port2.getAllowedPortDataTypes().add(PortDataType.DIRECT_VALUE);
				port2.setIndex(portIndex);
				port2.setInputPort(true);
				break;

			case AWMW_b:
				// FGMW_b | FGAW_b
				port2.getAllowedPortDataTypes().add(PortDataType.FGA_ANALOG_VALUE);
				port2.getAllowedPortDataTypes().add(PortDataType.FGA_MEASURED_VALUE);
				port2.setIndex(portIndex);
				port2.setInputPort(!onOutputSide);
				break;
			case FGZW_b:
				// Vermutlich kann das an input + output auftauchen
				port2.getAllowedPortDataTypes().add(PortDataType.FGA_VALUE);
				port2.setIndex(portIndex);
				port2.setInputPort(!onOutputSide);
				break;
			case FGML_b:
				port2.getAllowedPortDataTypes().add(PortDataType.FGA_MESSAGE_CONST);
				port2.setIndex(portIndex);
				port2.setInputPort(!onOutputSide);
				break;
			case FGMW_b:
				port2.getAllowedPortDataTypes().add(PortDataType.FGA_MEASURED_VALUE);
				port2.setIndex(portIndex);
				port2.setInputPort(!onOutputSide);
				break;
			case FGAW_b:
				port2.getAllowedPortDataTypes().add(PortDataType.FGA_ANALOG_VALUE);
				port2.setIndex(portIndex);
				port2.setInputPort(!onOutputSide);
				break;
			default:
				System.out.println("Unknown port " + portIndex + " for " + name);
				break;
			}
			return port2;
		}
	private PortGroup createPortGroup(ModulesFactory factory,
			int[][] grpPorts,
			int groupPortIndex,
			int portIndex) {
		int[] groupDef = grpPorts[groupPortIndex];
		int runtime = groupDef[0];
		int portDef = groupDef[1];
		PortGroup groupPort = factory.createPortGroup();
		groupPort.setIndex(portIndex);
		groupPort.setRuntime(runtime);
		if (portDef==WORD_INPUT) {
			groupPort.setInputPort(true);
			groupPort.getAllowedPortDataTypes().add(PortDataType.WORD_CONST);
			groupPort.getAllowedPortDataTypes().add(PortDataType.WORD_VAR);
		}else if (portDef==REAL_INPUT) {
			groupPort.setInputPort(true);
			groupPort.getAllowedPortDataTypes().add(PortDataType.FLOAT_CONST);
			groupPort.getAllowedPortDataTypes().add(PortDataType.FLOAT_VAR);
		} else if (portDef==WORD_OUTPUT) {
			// anscheinen konstanten auch am Ausgang!
			groupPort.setInputPort(false);
			groupPort.getAllowedPortDataTypes().add(PortDataType.WORD_CONST);
			groupPort.getAllowedPortDataTypes().add(PortDataType.WORD_VAR);
		} else if (portDef==REAL_OUTPUT) {
			groupPort.setInputPort(false);
			groupPort.getAllowedPortDataTypes().add(PortDataType.FLOAT_CONST);
			groupPort.getAllowedPortDataTypes().add(PortDataType.FLOAT_VAR);
		} else {
			System.out.println(String.format("\t grplen  direct(%d)", portIndex));
		}

		return groupPort;
	}

}
