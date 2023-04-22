/*
 **	Modul Name....: MIC.C
 **
 **	Funktion......: Uebersetzer fuer dezentrale Micsas Programme
 **
 **	Erstelldatum..: 20.09.1989
 **
 **	Versionsdatum.: 31.10.1997
 **
 **	Autor.........: Stahl - GAT/T
 **
 */

/*H
 ** Diese Modul wandelt ein Quellfile mit dem Namen "Name".MIC in ein
 ** H86-File gleichen Namens um, das mit dem MICAS-Monitor geladen
 ** werden kann. Ausserdem wird ein List-File "Name".LST erzeugt, in
 ** dem alle Daten mit Adressen enthalten sind. Aufgerufen wird der
 ** MICAS-Assembler mit MICON "Name" <cr>.
 */

/*D
 ** Eingangsdaten
 ** -------------
 ** -	Programmname des Quellfiles ohne Extention
 ** -	Optionen
 ** -	Daten in Quellfile
 ** Ausgangsdaten
 ** -------------
 ** -	H86-, KUZ und LST-File gleichen Namens
 ** Steuerdaten
 ** -------------
 ** -	Anweisungen in Quelldatei und Komandozeile
 */

//#include	<redef.h>
#include	<stdio.h>
#include	<string.h>
#include	<ctype.h>
#include	<stdlib.h>
#include	<memory.h>
#include	<fcntl.h>
#include	<time.h>
#include <sys/types.h>
#include <unistd.h>
// #include	<io.h>

#define		_MICAS_

//#pragma	hdrstop

#include	"gatmod.h"
#include	"version.h"
#include	"redef1.h"

const char *Version = "";
char *ARV1 = "V4";
char *ARV2 = "V5";

/************************************************************************/
/*  		S t r u k t u r d e f i n i t i o n e n			*/
/************************************************************************/

typedef word Typ;

typedef struct GTypS {
	long Lfz; /* laufzeit pro Gruppenparameter		*/
	Typ T; /* Typinformation pro Gruppenparameter		*/
} GTyp;

typedef struct SymDS {
	char *SN;
	Typ T;
	word Off;
	word Wk;
	struct SymDS *Next;
} SymDef;

typedef struct SortPmS {
	SymDef *Sym;
} SortPm;

typedef struct BstDefS {
	word BNr; /* Bausteinnummer			*/
	char BName[8]; /* Bausteinname				*/
	byte EA, /* Zahl der Eingaenge und Ausgaenge	*/
	Vw; /* Zahl der Vergangenheitswerte		*/
	long Lfz; /* Laufzeit in us- Einheiten		*/
	char *ModZul, /* zul�ssige module			*/

	Gla; /* Zahl der Gruppenlaengenang.		*/
	Typ *Tp; /* Pointer auf Typarray von Ein- und	*/
	/* Ausgaengen				*/
	GTyp *GTp; /* Pointer auf Typarray von Gruppenl.	*/
} BstDef;

struct TxtbS {
	word Tnum;
	word Tlen;
	long FOff;
};

/************************************************************************/
/* Definitionen fuer Float-Funktionen					*/
/************************************************************************/

struct fwS {
	word w0;
	word w1;
};

struct wdS {
	word lo;
	word hi;
};

#define	    Bias	127

union flpU {
	struct fwS W;
	long L;
};

union wdlU {
	struct wdS W;
	long L;
};

typedef struct flpiS {
	short ex;
	short sn;
	union wdlU mt;
} flpi;

#define	    plus_unendlich	0x7fffffff
#define	    minus_unendlich	0xffffffff
#define	    MantMSB		0x00800000L
#define	    MantMSBi		0x20000000L
#define	    MantMax		0x00ffffffL
#define	    MantMaxi		0x3fffffffL
#define	    MantMini		0x80000001L
#define	    ExpMax		255
#define	    ExpMin		0
#define	    Minlong		(0x80000000)
#define	    Maxlong		0x7fffffff
#define	    Minshort		0x8000
#define	    Maxshort		0x7fff
#define	    Maxdigit		8
#define	    FakMax		33
#define	    Pot10Max		38

#define	    getSign(s,w)    if (w<0) {s=1; w= -w;} else s=0
#define	    putSign(s,w)    if (s) w= -w

typedef long real;
#define	    k0	    0l

static real
const Fakul[FakMax + 1] = { 0x3F800000L, /*   0!	    */
0x3F800000L, /*   1!	    */
0x40000000L, /*   2!	    */
0x40C00000L, /*   3!	    */
0x41C00000L, /*   4!	    */
0x42F00000L, /*   5!	    */
0x44340000L, /*   6!	    */
0x459D8000L, /*   7!	    */
0x471D8000L, /*   8!	    */
0x48B13000L, /*   9!	    */
0x4A5D7C00L, /*   10!    */
0x4C184540L, /*   11!    */
0x4DE467E0L, /*   12!    */
0x4FB99466L, /*   13!    */
0x51A261D9L, /*   14!    */
0x53983BBBL, /*   15!    */
0x55983BBBL, /*   16!    */
0x57A1BF77L, /*   17!    */
0x59B5F766L, /*   18!    */
0x5BD815C9L, /*   19!    */
0x5E070D9EL, /*   20!    */
0x603141DFL, /*   21!    */
0x6273BA93L, /*   22!    */
0x64AF2E1AL, /*   23!    */
0x67036294L, /*   24!    */
0x694D4A07L, /*   25!    */
0x6BA6CC26L, /*   26!    */
0x6E0CBC40L, /*   27!    */
0x70764970L, /*   28!    */
0x72DF328EL, /*   29!    */
0x75513F65L, /*   30!    */
0x77CAB56AL, /*   31!    */
0x7A4AB56AL, /*   32!    */
0x7CD10B15L }; /*   33!    */

static real Pot10[Pot10Max + 1] = { 0x3F800000, /*   10 hoch 0	    */
0x41200000, /*   10 hoch 1	    */
0x42C80000, /*   10 hoch 2	    */
0x447A0000, /*   10 hoch 3	    */
0x461C4000, /*   10 hoch 4	    */
0x47C35000, /*   10 hoch 5	    */
0x49742400, /*   10 hoch 6	    */
0x4B189680, /*   10 hoch 7	    */
0x4CBEBC20, /*   10 hoch 8	    */
0x4E6E6B28, /*   10 hoch 9	    */
0x501502F9, /*   10 hoch 10	    */
0x51BA43B7, /*   10 hoch 11	    */
0x5368D4A5, /*   10 hoch 12	    */
0x551184E7, /*   10 hoch 13	    */
0x56B5E621, /*   10 hoch 14	    */
0x58635FA9, /*   10 hoch 15	    */
0x5A0E1BCA, /*   10 hoch 16	    */
0x5BB1A2BC, /*   10 hoch 17	    */
0x5D5E0B6B, /*   10 hoch 18	    */
0x5F0AC723, /*   10 hoch 19	    */
0x60AD78EC, /*   10 hoch 20	    */
0x6258D727, /*   10 hoch 21	    */
0x64078678, /*   10 hoch 22	    */
0x65A96816, /*   10 hoch 23	    */
0x6753C21C, /*   10 hoch 24	    */
0x69045951, /*   10 hoch 25	    */
0x6AA56FA6, /*   10 hoch 26	    */
0x6C4ECB8F, /*   10 hoch 27	    */
0x6E013F39, /*   10 hoch 28	    */
0x6FA18F08, /*   10 hoch 29	    */
0x7149F2CA, /*   10 hoch 30	    */
0x72FC6F7C, /*   10 hoch 31	    */
0x749DC5AE, /*   10 hoch 32	    */
0x76453719, /*   10 hoch 33	    */
0x77F684DF, /*   10 hoch 34	    */
0x799A130C, /*   10 hoch 35	    */
0x7B4097CE, /*   10 hoch 36	    */
0x7CF0BDC2, /*   10 hoch 37	    */
0x7E967699 }; /*   10 hoch 38	    */

static ulong MulWord(word, word);
static ulong DivLong(ulong, ulong);
static word LowWord(union flpU *);
static word HighWord(union flpU *);
static void getExpoMant(real, short *, long *);
static real putExpoMant(short, long);
static void Convflpi(real, flpi *);
static void fi_add(flpi *, flpi *, flpi *);
static void fi_sub(flpi *, flpi *, flpi *);
static real Convflpe(flpi *);
static real E_overflow(flpi *);
static real E_underflow(void);
static real E_negsqrt(void);
static real E_negln(void);
static real E_negbasis(void);
static word LastDezi(ulong);
static void Hexcb(char *, byte);
static char Hexcw(char *, word);
static char Hexcwi(char *, word);
static void HexIntel(FILE *, word, word, word *, word);
static void FreeMem(void);
static void GetText(char *, word);
static void AppendText(char *, word);
static void inAfz(char *, char *);
static void fi_mul(flpi *, flpi *, flpi *);
static real E_divbyzero(short);
static void fi_div(flpi *, flpi *, flpi *);
static void fi_frac(flpi *, flpi *);
static void fi_2log(flpi *, flpi *);
static void fi_epot(flpi *, flpi *);
static short f_leq(real, real);
static real f_mul(real, real);
static real f_div(real, real);
static real f_add(real, real);
static short f_geq(real, real);
static short f_leq(real, real);
static short f_gre(real, real);
static short f_low(real, real);
static real f_stof(short);
static real f_neg(real);
static short f_nan(real);
static long f_ftol(real);
static real f_ltof(long);
static real f_atof(char*);
static short f_ftoa(real, short, char *);
static char* Norm_Disp(short, short, char *, char *);
static char* Expo_Disp(short, short, char *, char *);
static void DispSyntax(void);
static void SysExit(void);
static void detab(char*);
static void Dezcb(char *, byte);
static void RunError(word, char *);
static void AsmError(word, char *);
static void AsmWarning(word, char *);
static short notHexW(char *);
static short notZifW(char *);
static char *GetMemory(void);
static void MovTyp(Typ *, short);
static word GetTypSInd(Typ *);
static void GetModTyp(char *);
static FILE *OpenFile(char *, char*, char*, short);
static void ListCr(char *);
static BstDef *GetBstNum(word);
static char *GetSymbol(word);
static void KonZwiCr(char *);
static char *strmov(char *, char *, short, short);
static char *GetStr(char **, char *, char *);
static void GetDatum(char *);
static void firstTask(void);
static word SegAddi(word, word);
static void GenKopfbs(void);
static void GenH86File(void);
static void GenKuzFile(void);
static void GenDebFile(void);
static void GenLstFile(void);
static short GetTypInd(char *);
static short Symbol_known(char *);
static void AddParam(char *, short);
static word WdVal(char *);
static void AddWKon(word);
static void AddFKon(long);
static word FgVal(char *);
static long FlVal(char *);
static void CheckIPAdr(word);
static BstDef *GetBstNam(char *);
static void InTask_F(char *);
static void InModul_F(char *);
static void gblWDef_F(char *);
static void locWDef_F(char *);
static short GetAbsInd(char *);
static void bBauDef_F(char *);
static SymDef *GetParaDes(char *);
static void AddudfPara(char *, Typ *);
static void BauDef_F(char *);
static void ModDefi_F(char *);
static void TskDef_F(char *);
static void Init_F(char *);
static void gblDef_F(char *);
static void locDef_F(char *);
static void bggwDef_F(char *);
static void bglwDef_F(char *);
static void bModDef_F(char *);
static void bTskDef_F(char *);
static void bTskDef_F(char *);
static void Klz_Check(char *);
static void EndgDef_F(char *);
static void EndlDef_F(char *);
static void EndMDef_F(char *);
static void EndTDef_F(char *);
static void OutModul_F(char *);
static char *GetSName(char **, char *);
static char *NextToken(void);
static short GetSwInd(char *);
static void ModulInit(char *);
static void TaskInit(char *);
static void ModulEnd(char *);
static void DefToken(char *);
static short GetTypes(char *, Typ *);
void decode(char *, char *, word);
static int OpenTextFile(char *);
static void LogonMessage(void);
static void GetOptions(char *);
static void GlobalInit(char *);
static void Compile(void);
static void LastOutput(void);

/*		M a k r o d e f i n i t i o n e n			*/

#define	 OVersatz(W)	W = W & 0xFFF0; W += 0x0010

/*			D e f i n e s					*/

#define	 KonOff		0	/* Konstantenoffset			*/
#define	 Tabchr		9	/* Tabulator				*/
#define	 LZeilMax	63	/* Maximale Zeilenzahl fuer Listing	*/
#define	 TaskMax	15	/* Maximale Taskanzahl			*/
#define	 ModMax		31	/* maximale ModulAnzahl			*/
#define  ModMinNr	2	/* minimale Modulnummer			*/
#define	 ModMaxNr	32	/* maximale Modulnummer			*/
#define	 TaNumMin	1	/* min. Tasknummer          		*/
#define	 TaNumMax	TaskMax	/* max. Tasknummer       	  	*/
#define	 MemPtrMax	30	/* max. allocierte Pointer		*/
#define	 WKMax		0x200	/* Anzahl WortKonstanten maximal	*/
#define	 FKMax		0x400	/* Anzahl WortKonstanten maximal	*/
#define	 TaskStack	0x20	/* Task-Stackbedarf in Paragraphen	*/
#define	 Offsets	24	/* Anzahl Bereichsgrenzen der		*/
/* Konstanten und Zwischenwerte		*/
#define	 TskPSum    Offsets-2	/* Offset-Positionn der Taskpruefsumme	*/
/* innerhalb des speziellen Konstanten-	*/
/* bereiches				*/
#define	 SymBlockSize	0x2000	/* Groesse eines Symbol-Speicherblocks	*/
#define  Zaus		13	/* Differenz zwischen zwei Zeilenausg.	*/
#define	 MaxZLen	100

/*	Z u s t a n d s d e f i n i t i o n e n				*/

#define	 STATE_INITIAL		10	/* Zustand bei Uebersetzungsbeginn	*/
#define	 gblDef		11	/* Parameterdefinition global		*/
#define	 locDef		12	/* Parameterdefinition local 		*/
#define	 bggwDef	13	/* Beginn globale Wertdefinition	*/
#define	 bglwDef	14	/* Beginn lokale  Wertdefinition	*/
#define	 bModDef	15	/* Beginn Moduldefinition		*/
#define  bTskDef	16	/* Beginn Task-Definition		*/
#define	 bBauDef	17	/* Beginn Baustein-Definition		*/
#define	 gblWDef	18	/* Wertdefinition global		*/
#define	 locWDef	19	/* Wertdefinition local 		*/
#define	 gblWKlz	20	/* Check auf Klammer zu globel		*/
#define	 locWKlz	21	/* Check auf Klammer zu local 		*/
#define	 EndgDef	22	/* Wertdefinition global beendet	*/
#define	 EndlkDef	23	/* Wertdefinition local beendet 	*/
#define	 EndlzDef	24	/* Definition lokaler Zw beendet 	*/
#define	 EndMDef	25	/* Wertdefinition Modul beendet		*/
#define	 EndTDef	26	/* Wertdefinition Task  beendet 	*/
#define	 IgnModul 	27	/* Modul ignorieren 			*/
#define	 InModul 	28	/* Moduluebersetzung			*/
#define	 ModDefi 	29	/* ModulParameter-Definition		*/
#define	 OutModul 	30	/* Modulende    			*/
#define	 TskDef  	31	/* Task-Definition			*/
#define	 InTask  	32	/* Task-Uebersetzung			*/
#define	 BauDef		33	/* Bausteindefinition			*/

/*	    T y p -   u n d   S c h l u e s s e l w o r t -		*/
/*			D e f i n i t i o n e n				*/

/* jedes der folgenden Bitdefinitionen representiert einen moeglichen	*/
/* Typ eines Baustein Ein- bzw. Ausgangs.				*/

#define	 PRORT_TYPE_WORD_VAL		0x0001	/* Wortzwischenwert			*/
#define	 PRORT_TYPE_WORD_CONST		0x0002	/* Wortkonstante			*/
#define	 PRORT_TYPE_FLOAT_VAL		0x0004	/* Floatzwischenwert			*/
#define	 PRORT_TYPE_FLOAT_CONST		0x0008	/* Floatkonstante			*/
#define	 FGZW_b		0x0010	/* FGA- Zaehlwertkonstante		*/
#define	 FGML_b		0x0020	/* FGA- Meldungskonstante		*/
#define	 FGAW_b		0x0040	/* FGA- Analogwertkonstante		*/
#define	 FGMW_b		0x0080	/* FGA- Messwertkonstante		*/
#define	 GRPL_b		0x0100	/* Gruppenlaenge			*/
#define	 ZALK_b		0x0200	/* Zahlenkonstante			*/

/* Maske fuer Attribut Konstant		*/
#define	 KonstMsk	(PRORT_TYPE_WORD_CONST | PRORT_TYPE_FLOAT_CONST | FGZW_b | FGML_b | FGAW_b | FGMW_b)
/* Maske fuer Attribut Float		*/
#define	 FloatMsk	(PRORT_TYPE_FLOAT_VAL | PRORT_TYPE_FLOAT_CONST)
#define	 WortMsk	(PRORT_TYPE_WORD_VAL | PRORT_TYPE_WORD_CONST | FGZW_b | FGML_b | FGAW_b | FGMW_b)
#define	 IpaMsk		(FGZW_b | FGML_b | FGAW_b | FGMW_b)
#define	 ZalkMsk	(GRPL_b | ZALK_b)

#define	 gbl_b		0x8000	/* Bit... Parameter global		*/
#define	 use_b		0x4000	/* Bit... Parameter benutzt		*/
#define	 Aus_b		0x2000	/* Maske fuer Attribut Ausgang (nur	*/
/* fuer Bausteintabelle			*/

#define	 AWMW_b		(FGMW_b | FGAW_b)

/* Wort-Eingang (fuer Bausteintabelle)	*/
#define	 WORD_INPUT		PRORT_TYPE_WORD_VAL | PRORT_TYPE_WORD_CONST
/* Wort-Ausgang (fuer Bausteintabelle)	*/
#define	 WORD_OUTPUT		Aus_b | WORD_INPUT
/* Float-Eingang (fuer Bausteintabelle)	*/
#define	 REAL_INPUT		PRORT_TYPE_FLOAT_VAL | PRORT_TYPE_FLOAT_CONST
/* Float-Ausgang (fuer Bausteintabelle)	*/
#define	 REAL_OUTPUT		Aus_b | REAL_INPUT

/*  Achtung! diese Definitionen gelten gleichzeitig auch als Index	*/
/*  auf das Typen-Array							*/

#define	 WortZ		0	/* Typ Wort-Zwischenwert		*/
#define	 WortK		1	/* Typ Wort-Konstante			*/
#define	 RealZ		2	/* Typ Float-Zwischenwert		*/
#define	 RealK		3	/* Typ Float-Konstante			*/
#define	 IpaZw		4	/* FGA-Typen				*/
#define	 IpaMl		5
#define	 IpaAw		6
#define	 IpaMw		7
#define	 Grupl		8	/* Gruppenlaenge			*/
#define	 Zahlk		9	/* Zahlenkonstante (z.B. Reglernummer)	*/

static
char *Typen[] = {
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
char *UdfTp[] = { "WORD_", "WORD_", "FLOAT_", "FLOAT_", "IPAZW", "IPAMB",
		"IPAAW", "IPAMW", "????_", "????_" };

/* moegliche Abarbeitungsstrategien (gleichzeitig Index auf Array)  */

#define	Abs_zyk	    0
#define	Abs_int	    1
#define	Abs_bck	    2
#define	Abs_ini	    3
#define	Abs_zyks    4
#define	Abs_ints    5
#define	Abs_bcks    6
#define	Abs_inis    7

static
char *Abstrg[] = {
		"CYCL", //
		"EVNT", //
		"BACK", //
		"INIT", //
		"CYCLS", //
		"EVNTS", //
		"BACKS",
		"INITS" };
static byte Abstrgv[] = { 0x01, 0x02, 0x03, 0x04, 0x81, 0x82, 0x83, 0x84 };
#define	AbsMax	    (sizeof(Abstrg)/sizeof(char*))

static
short Typa = -1; /* aktueller Typindex				*/
Typ *aTyp; /*    "      Typ				*/

#define	TypMax	    (sizeof(Typen)/sizeof(char*))
#define	Typmsk	    ((1 << TypMax) - 1)

static
char *Sword[] = { //
		"MODUL", //
		"TASK", //
		"ENDMODUL" };

#define	SwMax	    (sizeof(Sword)/sizeof(char*))

#define	Swlen	    6

char StartMessage[] = { 'K', 'w', 'S', 'm', 's', 'g', 0x0B, 0x9A, 0x2B, 0x0B,
		0x02, 0x11, 0x93, 0x7B, 0xBB, 0x73, 0x02, 0x11, 0x7B, 0xB3, 0x2B, 0x93,
		0x48, 0x03, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00,
		0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00 };

#define	Meslen	(sizeof (StartMessage) - Swlen)

/*	    S t a t u s d e f i n i t i o n e n				*/
/* Die folgenden Statusdefinitionen sind gleichzeitig der Index		*/
/* auf die Schuesselwortabelle						*/

#define	 ModDef		0	/* Moduldefinition			*/
#define	 TaskDef	1	/* Taskdefinition			*/
#define	 ModEnd		2	/* Modulende erreicht			*/

static char lastByte; /* Inhalt von letzetm Null-Byte fuer		*/
/* Scan-Routinen				*/

/*									*/
/* Adresslage:								*/
/* KopfSeg								*/
/* +---------------------+						*/
/* | Kopfbaustein	 |						*/
/* +---------------------+						*/
/*									*/
/*									*/
/* DataSeg								*/
/* +---------------------+						*/
/* |   WortKonstanten    |						*/
/* +---------------------+		    				*/
/* |   FloatKonstanten 	 |						*/
/* +---------------------+						*/
/* |  Wortzwischenwerte  |						*/
/* +---------------------+						*/
/* | Floatzwischenwerte  |						*/
/* +---------------------+						*/
/* | Vergangenheitswerte |						*/
/* +---------------------+						*/
/* +---------------------+						*/
/* | Task 1		 |						*/
/* +---------------------+						*/
/* | Task 2		 |						*/
/* +---------------------+						*/
/* "    "    "    "    "						*/
/* "    "    "    "    "						*/
/* +---------------------+						*/
/* | Task n		 |						*/
/* +---------------------+						*/
/* "    "    "    "    "						*/
/* "    "    "    "    "						*/
/* StackSeg								*/
/*									*/

/*		  g l o b a l e   P o i n t e r   u n d			*/
/*	    S p e i c h e r v e r w a l t u n g s v a r i a b l e n	*/

word *Word, /* Pointer auf Integerfeld des MICAS-Pr.	*/
*KpfBst, /* Pointer auf Kopfbaustein			*/
*WKonst, /* Pointer auf Konstanten insgesamt		*/
*WGKon, /* Pointer auf letzte globale Wortkonstante+1	*/
*WKon; /* Pointer auf letzte Wortkonstante+1		*/

long *FKonst, /* Pointer auf erste Floatkonstante		*/
*FGKon, /* Pointer auf letzte globale Floatkonstante+1	*/
*FKon; /* Pointer auf letzte Floatkonstante+1		*/

word ModHnd, // Handle f�r aktuelles Modul
		WGKanz, /* Anzahl globale Wortkonstanten		*/
		WKanz, /* Anzahl insgesamt				*/
		FGKanz, /* Anzahl globale Floatkonstanten		*/
		FKanz, /* Anzahl insgesamt				*/
		WZanz, /* Anzahl Wortzwischenwerte			*/
		FZanz, /* Anzahl Floatzwischenwerte			*/
		VwOff, /* aktueller Vergangenheitswert-Offset		*/
		WKOff, /* Wortkonstanten-Offset			*/
		FKOff, /* Floatkonstanten-Offset			*/
		WZOff, /* Wort-Zwischenwertoffset			*/
		FZOff, /* Float-Zwischenwertoffset			*/
		FinOff, /* Ende der Floatzwischenwerte			*/
		KonSize, // L�nge aller Konstanten in Byte's
		PSize; // berechnete Programmgr��e

static char *MemPtr[MemPtrMax]; /* PointerArray auf allocierten Speicher	*/

static word MemPtri, /* Index auf naechsten wiederverwendbaren Pointer*/
MemPtrAnz, /* Anzahl der bereits allocierten Pointer	*/
MemPtrIni, /* Anzahl Pointer vor Uebersetzung		*/
SymSize, /* Groesse des benutzten Speichers im aktuellen	*/
/* Speicherblock der Groesse SymBlockSize	*/
GblSymSize, /* dito fuer globale Symbole			*/
udfSymSize, /* dito fuer undefinierte Symbole		*/
ParamAnz, /* Anzahl der definierten Parameter		*/
udfParaAnz, /* Anzahl der undefinierten Parameter		*/
GParaAnz; /* Anzahl der globalen Parameter		*/

SymDef *Params, /* Pointer auf verkettete Symbolliste		*/
*lGblParam, /* Pointer auf letztes globales Symbol		*/
*lastParam, /* dito. Arbeitspointer				*/
*lastudfPara, /* dito. Arbeitspointer				*/
*udfParams; /* Pointer auf undefinierte Symbole		*/
SortPm *SortParam; /* Pointer auf sortierte Parameter		*/

/*  g l o b a l e   U e b e r s e t z u n g s p a r a m e t e r		*/

/*		F l a g s						*/

static word firstMod, // Merker 1. Modul noch nicht erreicht
		udfFlag, // Flag fuer udf-Option
		Nowflag, // Flag fuer NOW-Option
		Incflag, // Flag fuer Include-File lesen
		Tflag, // Flag fuer Taskanweisung erfolgt
		Lflag, // Flag fuer Erzeugung des Listings
		Gflag, // Gruppenl.-flag =1 innerhalb v. Gruppe
		Bflag, // Baustein -flag =1 innerhalb B. Parametern
		Dirflag, // Flag fuer aktuelle Directory Option
		OneDir, // Flag fuer One Directory Option
		ExtAdress, // erweiterter Programm Adressbereich
		UppCase; // keine Unterscheidung zw. Gro� und Kleinschr.
short AR20Mode = -1, // Modul f�r Adresslage 0 = alt, 1 = neu
		AR20Konst = 0; // Konstanten in RAM-Bereich = default

/*		A r r a y s						*/

static word *TaBeg[TaskMax], /* Pointer auf 1. Wort der jeweiligen Task	*/
TaAbs[TaskMax], /* Task-Abarbeitungsstrategie[i]		*/
TaNum[TaskMax], /* Tasknummer					*/
TaVwAnz[TaskMax], /* Vergangenheitswert-Wortanzahl[i]		*/
TaWAnz[TaskMax], /* TaskWortanzahl[i]				*/
TaZyk[TaskMax], /* Taskzykluszeit[i]				*/
TaLfz[TaskMax], /* Tasklaufzeit  [i]				*/
TaSeg[TaskMax], /* Taskanfangssegment[i]			*/
TaVwo[TaskMax], /* Task-Vergangeheitswert-Offsets		*/
ModNra[ModMax], /* angegebene Modulnummern			*/
ModulNr[ModMax]; /* Modulnummern in Quellfile			*/

/*		S o n s t i g e s					*/

static FILE *Input, /* fuer Eingabedatei "Name".MIC		*/
*Listing, /* fuer Ausgabedatei "Name".LST		*/
*OutH86, /* fuer Ausgabedatei "Name".H86		*/
*Errorfile, /* fuer Fehlerdatei  "Name".ERR		*/
*DebugInfo, /* fuer Fehlerdatei  "Name".DEB		*/
*KonZwi, /* fuer Kon. u. Zwiad.- Datei "Name".KUZ*/
*udfFile; /* fuer Listing undefinierte Parameter  */

static int fht; // Filehandle Textfile

static
char Dir[60], /* String Directory			*/
PName[14], /* String Dateiname			*/
BauNam[10], /* letzter Baustein			*/
Datum[30], /* Datum				*/
Zeilio[MaxZLen], ModTyp[10], // aktuelles Modul
		ListZl[300], FName[80];

static word QZeile, /* Zeilenzaehler Quellfile			*/
QInc, /* Increment-Zaehler fuer Zeilenausgabe		*/
Zeile, /* Zeilezaehler Ausgabefile			*/
LZAbs, Seite, /* Seitenzaehler Ausgabefile			*/
Error, /* Fehlerzaehler				*/
Warning, /* Warnungs-Zaehler				*/
Tanz, /* Taskzaehler					*/
BauNum, /* Bausteinnummer				*/
TWanz, /* Taskwortzaehler				*/
TVwAnz, /* Anzahl Vergangenheitswerte pro Task	    	*/
TskId, /* Task-Id					*/
TskAbs, /* Abarbeitungsstrategie			*/
TskZyk, /* Taskzykluszeit				*/
Tlaufz, /* Laufzeit in ms				*/
VwAnz, /* Anzahl Vergangenheitswerte			*/
Wanz, /* Wortzaehler					*/
Panz, /* Parameterzaehler				*/
PSoll, /* Parameterzahl laut Verzeichnis		*/
GlSoll, /* Gruppenlaengenzahl laut Verzeichnis		*/
GlAnz, /* Gruppenlaengenzaehler			*/
GlAng, /* Groesse der Gruppenlaenge laut Angabe	*/
ZGPanz, /* Zaehler fuer Gruppenlaengenparameter		*/
Zykst, /* Zykluszeit schnellste Task			*/
Kpflen, /* Laenge des Kopfbausteins			*/
ModAnz, /* Zaehler fuer Module in Quellfile		*/
ModNr, /* aktuelle Modulnummer                   	*/
ModNri, /* Anzahl der in Aufruf angegebenen Module	*/
State; /* Zustandsvariable fuer Uebersetzungsvorgang	*/

long TskLfz; /* Laufzeit der aktuellen Task in us		*/

BstDef *aBSS; /* Pointer auf aktuelle Bausteinstruktur	*/
Typ *aBST; /* Pointer auf aktuellen Parametertyp    	*/
GTyp *aBSG; /* Pointer auf aktuellen Gruppenlaengentyp  	*/

static struct SymDS GrplTyp = { NULL, ZalkMsk, 0, 0, NULL };

/*
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

/* 	B a u s t e i n d e f i n i t i o n e n		*/
/*	Eingangs-Parameterdefinitionen			*/

static Typ ADSU_PTyp[] = { GRPL_b, GRPL_b, REAL_OUTPUT };
static GTyp ADSU_GTyp[] = { { 500, REAL_INPUT }, { 500, REAL_INPUT } };
static Typ ADD2_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ SUB2_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ CHS_PTyp[] = { REAL_INPUT, REAL_OUTPUT };
static Typ MULDI_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ MULT_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ ABSWER_PTyp[] = { REAL_INPUT, REAL_OUTPUT };
static Typ MAX_PTyp[] = { GRPL_b, REAL_OUTPUT };
static GTyp MAX_GTyp[] = { { 100, REAL_INPUT } };
static Typ MIN_PTyp[] = { GRPL_b, REAL_OUTPUT };
static GTyp MIN_GTyp[] = { { 100, REAL_INPUT } };
static Typ LIMIT_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ VGLOH_PTyp[] = { REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ VGLEH_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ VGLUH_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ VGL3P_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT };
static Typ INTE_PTyp[] = { REAL_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ VRZ_PTyp[] = { WORD_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT,
		REAL_OUTPUT };
static Typ UHR_PTyp[] = { WORD_INPUT, WORD_INPUT, REAL_OUTPUT };
static Typ AWT_PTyp[] = { WORD_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ UST_PTyp[] = { WORD_INPUT, REAL_INPUT, REAL_OUTPUT, REAL_OUTPUT };
static Typ AWM_PTyp[] = { WORD_INPUT, WORD_INPUT };
static Typ USM_PTyp[] = { WORD_INPUT, WORD_INPUT };
static Typ FKG_PTyp[] = { REAL_INPUT, GRPL_b, REAL_OUTPUT };
static GTyp FKG_GTyp[] = { { 400, REAL_INPUT } };
static Typ PT1_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ UND2_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ UND11_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ UND21_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ UNDMN_PTyp[] = { GRPL_b, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
static GTyp UNDMN_GTyp[] = { { 100, WORD_INPUT }, { 100, WORD_INPUT } };
static Typ NAND2_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ ODR2_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ ODRMN_PTyp[] = { GRPL_b, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
static GTyp ODRMN_GTyp[] = { { 100, WORD_INPUT }, { 100, WORD_INPUT } };
static Typ NOR2_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ XOR2_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ NICHT_PTyp[] = { WORD_INPUT, WORD_OUTPUT };
static Typ UVO_PTyp[] = { WORD_INPUT, GRPL_b, GRPL_b, GRPL_b, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
static GTyp UVO_GTyp[] = { { 200, WORD_INPUT }, { 200, WORD_INPUT }, { 200, WORD_INPUT }, {
		200, WORD_INPUT } };
static Typ AEQ_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ MOKS_PTyp[] = { WORD_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ MOKY_PTyp[] = { WORD_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ VVZ_PTyp[] = { WORD_INPUT, REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ PDM_PTyp[] = { REAL_INPUT, REAL_INPUT, WORD_OUTPUT };
static Typ RSS_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT, WORD_OUTPUT };
static Typ TFF_PTyp[] = { WORD_INPUT, WORD_OUTPUT, WORD_OUTPUT };
static Typ PACK_PTyp[] = { GRPL_b, WORD_OUTPUT };
static GTyp PACK_GTyp[] = { { 200, WORD_INPUT } };
static Typ UNPAC_PTyp[] = { WORD_INPUT, GRPL_b };
static GTyp UNPAC_GTyp[] = { { 200, WORD_OUTPUT } };
static Typ WAEQ_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ WDEC_PTyp[] = { WORD_INPUT, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
static GTyp WDEC_GTyp[] = { { 200, WORD_INPUT } };
static Typ WUMC_PTyp[] = { WORD_INPUT, GRPL_b, WORD_OUTPUT, WORD_OUTPUT };
static GTyp WUMC_GTyp[] = { { 200, WORD_INPUT } };
static Typ BBAC_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT };
static Typ REME_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT };
static Typ MAZ_PTyp[] = { REAL_INPUT, WORD_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ ATRAS_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT };
static Typ SCHR_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, GRPL_b, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT,
		GRPL_b };
static GTyp SCHR_GTyp[] = { { 2000, REAL_INPUT }, { 2000, REAL_OUTPUT } };
static Typ BTRA_PTyp[] = { WORD_INPUT, WORD_OUTPUT };
static Typ ATRA_PTyp[] = { REAL_INPUT, REAL_OUTPUT };
static Typ SETMEL_PTyp[] = { WORD_INPUT, GRPL_b, FGML_b, WORD_OUTPUT };
static GTyp SETMEL_GTyp[] = { { 100, WORD_INPUT } };
static Typ ZWAUS_PTyp[] = { WORD_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT, FGZW_b, WORD_OUTPUT };
static Typ REGLER_PTyp[] = { ZALK_b, WORD_INPUT, WORD_INPUT, REAL_INPUT, REAL_OUTPUT, WORD_OUTPUT };
static Typ UREG_PTyp[] = { ZALK_b, AWMW_b, AWMW_b, WORD_INPUT, WORD_INPUT, REAL_INPUT, WORD_INPUT,
		WORD_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT,
		REAL_INPUT, FGAW_b, FGML_b, REAL_OUTPUT, WORD_OUTPUT };
static Typ LREG_PTyp[] = { REAL_INPUT, REAL_INPUT, WORD_INPUT, WORD_INPUT, REAL_INPUT, WORD_INPUT, REAL_INPUT,
		REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT, WORD_OUTPUT };
static Typ ZEGE_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_OUTPUT };
static Typ MELEIN_PTyp[] = { FGML_b, GRPL_b, WORD_OUTPUT };
static GTyp MELEIN_GTyp[] = { { 100, WORD_OUTPUT } };
static Typ ANEIN_PTyp[] = { AWMW_b, REAL_OUTPUT, WORD_OUTPUT };
static Typ ZWEIN_PTyp[] = { FGZW_b, REAL_OUTPUT, WORD_OUTPUT };
static Typ BEFAUS_PTyp[] =
		{ ZALK_b, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, FGML_b, WORD_OUTPUT };
static Typ DSTAUS_PTyp[] = { REAL_INPUT, WORD_INPUT, REAL_INPUT, FGMW_b, FGML_b, WORD_OUTPUT };
static Typ ANAUS_PTyp[] = { REAL_INPUT, WORD_INPUT, AWMW_b, WORD_OUTPUT };
static Typ SOLKEN_PTyp[] = { ZALK_b, WORD_INPUT, REAL_OUTPUT, WORD_OUTPUT };
static Typ ABSFEU_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ ENTHA_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ ABFEUG_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ ENTHAG_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ SEQ2_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_OUTPUT, REAL_OUTPUT, WORD_OUTPUT };
static Typ SEQ3_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT,
		REAL_INPUT, WORD_INPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, WORD_OUTPUT, WORD_OUTPUT };
static Typ TTZEIT_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ BENDE_PTyp[] = { WORD_INPUT };
static Typ REALF_PTyp[] = { REAL_INPUT, REAL_OUTPUT };
static Typ XHOY_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_OUTPUT };
static Typ OPORTB_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT };
static Typ IPORTB_PTyp[] = { WORD_INPUT, WORD_OUTPUT }; // input: port, output: portvalue
static Typ MSET_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT };
static Typ MCPY_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT };
static Typ HLG_PTyp[] = { WORD_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, WORD_INPUT, WORD_INPUT,
		REAL_INPUT, REAL_OUTPUT };
static Typ KALUHR_PTyp[] = { REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT, REAL_INPUT,
		REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT, WORD_OUTPUT };
static Typ TMESS_PTyp[] = { WORD_INPUT, REAL_OUTPUT, REAL_OUTPUT, REAL_OUTPUT };
static Typ TSTART_PTyp[] = { WORD_OUTPUT };
static Typ TSTOP_PTyp[] = { WORD_INPUT, WORD_OUTPUT, WORD_OUTPUT };

/*
 * #06au09# Sche: OTRS T2009071310000017
 * Add these types to MIC, need it for error tracking
 * (Lanxess: plants shut unexpectedly down)
 * There are existing macros, which may be added by editing the MIC-file:
 * FTOB -> FLOAT to Binary
 * BTOF -> Binary to FLOAT
 */
static Typ FTOB_PTyp[] = { REAL_INPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT,
		WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT, WORD_OUTPUT };
static Typ BTOF_PTyp[] = { WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT,
		WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, WORD_INPUT, REAL_OUTPUT };

#define	BNrEnd	0x3000	/* Nummer des Endebausteins	*/

static BstDef BS[] = {
/* Typ   Name  Anzahl EA's  Vergangenheitsw.  unz. Mark.  Gl Offsets	*/

{ BNrEnd, "ENDE", 0, 0, 100, NULL, 0, NULL, NULL },

{ 0X3002, "ADSU", sizeof(ADSU_PTyp) / sizeof(Typ), 0, 100, NULL,
		sizeof(ADSU_GTyp) / sizeof(GTyp), ADSU_PTyp, ADSU_GTyp },

{ 0X3003, "ADD2", sizeof(ADD2_PTyp) / sizeof(Typ), 0, 700, NULL, 0, ADD2_PTyp,
		NULL },

{ 0X3004, "SUB2", sizeof(SUB2_PTyp) / sizeof(Typ), 0, 700, NULL, 0, SUB2_PTyp,
		NULL },

{ 0X3005, "CHS", sizeof(CHS_PTyp) / sizeof(Typ), 0, 100, NULL, 0, CHS_PTyp,
		NULL },

{ 0X3006, "MULDI", sizeof(MULDI_PTyp) / sizeof(Typ), 0, 2200, NULL, 0,
		MULDI_PTyp, NULL },

{ 0X3007, "MULT", sizeof(MULT_PTyp) / sizeof(Typ), 0, 700, NULL, 0, MULT_PTyp,
		NULL },

{ 0X3008, "ABSWER", sizeof(ABSWER_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
		ABSWER_PTyp, NULL },

{ 0X3009, "MAX", sizeof(MAX_PTyp) / sizeof(Typ), 0, 50, NULL, sizeof(MAX_GTyp)
		/ sizeof(GTyp), MAX_PTyp, MAX_GTyp },

{ 0X300A, "MIN", sizeof(MIN_PTyp) / sizeof(Typ), 0, 50, NULL, sizeof(MIN_GTyp)
		/ sizeof(GTyp), MIN_PTyp, MIN_GTyp },

{ 0X300B, "LIMIT", sizeof(LIMIT_PTyp) / sizeof(Typ), 0, 250, NULL, 0,
		LIMIT_PTyp, NULL },

{ 0X300C, "ABSFEU", sizeof(ABSFEU_PTyp) / sizeof(Typ), 28, 55000, NULL, 0,
		ABSFEU_PTyp, NULL },

{ 0X300D, "ENTHA", sizeof(ENTHA_PTyp) / sizeof(Typ), 12, 4000, NULL, 0,
		ENTHA_PTyp, NULL },

{ 0X300E, "UND2", sizeof(UND2_PTyp) / sizeof(Typ), 0, 50, NULL, 0, UND2_PTyp,
		NULL },

{ 0X300F, "UND11", sizeof(UND11_PTyp) / sizeof(Typ), 0, 50, NULL, 0,
		UND11_PTyp, NULL },

{ 0X3010, "UND21", sizeof(UND21_PTyp) / sizeof(Typ), 0, 50, NULL, 0,
		UND21_PTyp, NULL },

{ 0X3011, "UNDMN", sizeof(UNDMN_PTyp) / sizeof(Typ), 0, 50, NULL,
		sizeof(UNDMN_GTyp) / sizeof(GTyp), UNDMN_PTyp, UNDMN_GTyp },

{ 0X3012, "NAND2", sizeof(NAND2_PTyp) / sizeof(Typ), 0, 50, NULL, 0,
		NAND2_PTyp, NULL },

{ 0X3013, "ODR2", sizeof(ODR2_PTyp) / sizeof(Typ), 0, 50, NULL, 0, ODR2_PTyp,
		NULL },

{ 0X3014, "ODRMN", sizeof(ODRMN_PTyp) / sizeof(Typ), 0, 50, NULL,
		sizeof(ODRMN_GTyp) / sizeof(GTyp), ODRMN_PTyp, ODRMN_GTyp },

{ 0X3015, "NOR2", sizeof(NOR2_PTyp) / sizeof(Typ), 0, 50, NULL, 0, NOR2_PTyp,
		NULL },

{ 0X3016, "XOR2", sizeof(XOR2_PTyp) / sizeof(Typ), 0, 50, NULL, 0, XOR2_PTyp,
		NULL },

{ 0X3017, "NICHT", sizeof(NICHT_PTyp) / sizeof(Typ), 0, 50, NULL, 0,
		NICHT_PTyp, NULL },

{ 0X3018, "UVO", sizeof(UVO_PTyp) / sizeof(Typ), 0, 100, NULL, sizeof(UVO_GTyp)
		/ sizeof(GTyp), UVO_PTyp, UVO_GTyp },

		{ 0X3019, "AEQ", sizeof(AEQ_PTyp) / sizeof(Typ), 0, 50, NULL, 0,
				AEQ_PTyp, NULL },

		{ 0X301A, "RSS", sizeof(RSS_PTyp) / sizeof(Typ), 2, 100, NULL, 0,
				RSS_PTyp, NULL },

		{ 0X301B, "TFF", sizeof(TFF_PTyp) / sizeof(Typ), 4, 100, NULL, 0,
				TFF_PTyp, NULL },

		{ 0X301C, "INTE", sizeof(INTE_PTyp) / sizeof(Typ), 16, 1000, NULL, 0,
				INTE_PTyp, NULL },

		{ 0X301D, "PT1", sizeof(PT1_PTyp) / sizeof(Typ), 22, 1000, NULL, 0,
				PT1_PTyp, NULL },

		{ 0X301E, "VRZ", sizeof(VRZ_PTyp) / sizeof(Typ), 8, 1000, NULL, 0,
				VRZ_PTyp, NULL },

		{ 0X301F, "AWT", sizeof(AWT_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				AWT_PTyp, NULL },

		{ 0X3020, "UST", sizeof(UST_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				UST_PTyp, NULL },

		{ 0X3021, "SCHR", sizeof(SCHR_PTyp) / sizeof(Typ), 4, 200, NULL,
				sizeof(SCHR_GTyp) / sizeof(GTyp), SCHR_PTyp, SCHR_GTyp },

		{ 0X3022, "FKG", sizeof(FKG_PTyp) / sizeof(Typ), 0, 4800, NULL,
				sizeof(FKG_GTyp) / sizeof(GTyp), FKG_PTyp, FKG_GTyp },

		{ 0X3023, "MAZ", sizeof(MAZ_PTyp) / sizeof(Typ), 6, 300, NULL, 0,
				MAZ_PTyp, NULL },

		{ 0X3024, "SEQ2", sizeof(SEQ2_PTyp) / sizeof(Typ), 30, 10000, NULL, 0,
				SEQ2_PTyp, NULL },

		{ 0X3025, "SEQ3", sizeof(SEQ3_PTyp) / sizeof(Typ), 64, 18000, NULL, 0,
				SEQ3_PTyp, NULL },

		{ 0X3026, "VGLOH", sizeof(VGLOH_PTyp) / sizeof(Typ), 0, 150, NULL, 0,
				VGLOH_PTyp, NULL },

		{ 0X3027, "VGLEH", sizeof(VGLEH_PTyp) / sizeof(Typ), 2, 250, NULL, 0,
				VGLEH_PTyp, NULL },

		{ 0X3028, "VGLUH", sizeof(VGLUH_PTyp) / sizeof(Typ), 2, 350, NULL, 0,
				VGLUH_PTyp, NULL },

		{ 0X3029, "VGL3P", sizeof(VGL3P_PTyp) / sizeof(Typ), 0, 550, NULL, 0,
				VGL3P_PTyp, NULL },

		{ 0X302A, "UHR", sizeof(UHR_PTyp) / sizeof(Typ), 4, 300, NULL, 0,
				UHR_PTyp, NULL },

		{ 0X302B, "VVZ", sizeof(VVZ_PTyp) / sizeof(Typ), 26, 4000, NULL, 0,
				VVZ_PTyp, NULL },

		{ 0X302C, "MOKY", sizeof(MOKY_PTyp) / sizeof(Typ), 16, 100, NULL, 0,
				MOKY_PTyp, NULL },

		{ 0X302D, "MOKS", sizeof(MOKS_PTyp) / sizeof(Typ), 16, 100, NULL, 0,
				MOKS_PTyp, NULL },

		{ 0X302E, "PDM", sizeof(PDM_PTyp) / sizeof(Typ), 26, 10000, NULL, 0,
				PDM_PTyp, NULL },

		{ 0X302F, "ANEIN", sizeof(ANEIN_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				ANEIN_PTyp, NULL },

		{ 0X3030, "ZWEIN", sizeof(ZWEIN_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				ZWEIN_PTyp, NULL },

		{ 0X3031, "MELEIN", sizeof(MELEIN_PTyp) / sizeof(Typ), 2, 100, NULL,
				sizeof(MELEIN_GTyp) / sizeof(GTyp), MELEIN_PTyp, MELEIN_GTyp },

		{ 0X3032, "ANAUS", sizeof(ANAUS_PTyp) / sizeof(Typ), 6, 100, NULL, 0,
				ANAUS_PTyp, NULL },

		{ 0X3033, "BEFAUS", sizeof(BEFAUS_PTyp) / sizeof(Typ), 4, 100, NULL, 0,
				BEFAUS_PTyp, NULL },

		{ 0X3034, "SETMEL", sizeof(SETMEL_PTyp) / sizeof(Typ), 4, 100, NULL,
				sizeof(SETMEL_GTyp) / sizeof(GTyp), SETMEL_PTyp, SETMEL_GTyp },

		{ 0X3035, "ZWAUS", sizeof(ZWAUS_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				ZWAUS_PTyp, NULL },

		{ 0X3036, "DSTAUS", sizeof(DSTAUS_PTyp) / sizeof(Typ), 16, 100, NULL,
				0, DSTAUS_PTyp, NULL },

		{ 0X3037, "REGLER", sizeof(REGLER_PTyp) / sizeof(Typ), 38, 50000, NULL,
				0, REGLER_PTyp, NULL },

		{ 0X3038, "SOLKEN", sizeof(SOLKEN_PTyp) / sizeof(Typ), 8, 10000, NULL,
				0, SOLKEN_PTyp, NULL },

		{ 0X3039, "UREG", sizeof(UREG_PTyp) / sizeof(Typ), 38, 50000, NULL, 0,
				UREG_PTyp, NULL },

		{ 0X303A, "ATRA", sizeof(ATRA_PTyp) / sizeof(Typ), 0, 200, NULL, 0,
				ATRA_PTyp, NULL },

		{ 0X303B, "BTRA", sizeof(BTRA_PTyp) / sizeof(Typ), 0, 200, NULL, 0,
				BTRA_PTyp, NULL },

		{ 0X303C, "TTZEIT", sizeof(TTZEIT_PTyp) / sizeof(Typ), 84, 500, NULL,
				0, TTZEIT_PTyp, NULL },

		{ 0X303D, "BENDE", sizeof(BENDE_PTyp) / sizeof(Typ), 0, 150, NULL, 0,
				BENDE_PTyp, NULL },

		{ 0X303E, "SIN", sizeof(REALF_PTyp) / sizeof(Typ), 0, 25000, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X303F, "COS", sizeof(REALF_PTyp) / sizeof(Typ), 0, 25000, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3040, "EHOX", sizeof(REALF_PTyp) / sizeof(Typ), 0, 40000, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3041, "LN", sizeof(REALF_PTyp) / sizeof(Typ), 0, 15000, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3042, "LOG", sizeof(REALF_PTyp) / sizeof(Typ), 0, 15000, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3043, "XHOY", sizeof(XHOY_PTyp) / sizeof(Typ), 0, 45000, NULL, 0,
				XHOY_PTyp, NULL },

		{ 0X3044, "RAD", sizeof(REALF_PTyp) / sizeof(Typ), 0, 1500, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3045, "DEG", sizeof(REALF_PTyp) / sizeof(Typ), 0, 700, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3046, "SQRT", sizeof(REALF_PTyp) / sizeof(Typ), 0, 11000, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3047, "QUAD", sizeof(REALF_PTyp) / sizeof(Typ), 0, 700, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3048, "REZI", sizeof(REALF_PTyp) / sizeof(Typ), 0, 1500, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X3049, "MULK2", sizeof(REALF_PTyp) / sizeof(Typ), 0, 250, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X304A, "DIVK2", sizeof(REALF_PTyp) / sizeof(Typ), 0, 250, NULL, 0,
				REALF_PTyp, NULL },

		{ 0X304B, "OPORTB", sizeof(OPORTB_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				OPORTB_PTyp, NULL },

		{ 0X304C, "IPORTB", sizeof(IPORTB_PTyp) / sizeof(Typ), 0, 100, NULL, 0,
				IPORTB_PTyp, NULL },

		{ 0X304D, "MSET", sizeof(MSET_PTyp) / sizeof(Typ), 0, 1000, NULL, 0,
				MSET_PTyp, NULL },

		{ 0X304E, "MCPY", sizeof(MSET_PTyp) / sizeof(Typ), 0, 1000, NULL, 0,
				MCPY_PTyp, NULL },

		{ 0X304F, "HLG", sizeof(HLG_PTyp) / sizeof(Typ), 16, 500, NULL, 0,
				HLG_PTyp, NULL },
#define	UnZul1	"ZP03,ZP10,ZP12,ZP13,ZM12,ZM13,ZM14,ZP20,AC40"
		{ 0X3050, "TSTART", sizeof(TSTART_PTyp) / sizeof(Typ), 0, 200, UnZul1,
				0, TSTART_PTyp, NULL },

		{ 0X3051, "TMESS", sizeof(TMESS_PTyp) / sizeof(Typ), 10, 200, UnZul1,
				0, TMESS_PTyp, NULL },

		{ 0X3052, "LREG", sizeof(LREG_PTyp) / sizeof(Typ), 38, 50000, NULL, 0,
				LREG_PTyp, NULL },

		{ 0X3053, "KALUHR", sizeof(KALUHR_PTyp) / sizeof(Typ), 0, 500, UnZul1,
				0, KALUHR_PTyp, NULL },

		{ 0X3054, "ABFEUG", sizeof(ABFEUG_PTyp) / sizeof(Typ), 28, 50000, NULL,
				0, ABFEUG_PTyp, NULL },

		{ 0X3055, "ENTHAG", sizeof(ENTHAG_PTyp) / sizeof(Typ), 12, 5500, NULL,
				0, ENTHAG_PTyp, NULL },

		{ 0X3056, "FTOB", sizeof(FTOB_PTyp) / sizeof(Typ), 0, 500, UnZul1, 0,
				FTOB_PTyp, NULL },

		{ 0X3057, "BTOF", sizeof(BTOF_PTyp) / sizeof(Typ), 0, 500, UnZul1, 0,
				BTOF_PTyp, NULL },

};
#define	    BanzMax	(sizeof(BS)/sizeof(BstDef))

int strcmpi(char *s1, char *s2);
void strout(char *s);
char * strupr(char *a);
/******************************************************************************/

static char *strmov(Des, Src, left, max)
	char *Des, *Src;short left, max;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion kopiert Scr nach Des, wobei zuvor Des mit left Blanks
 **	aufgefuellt wird. Ausserdem wird Des auf die Laenge max begrenzt
 **	und mit Blanks aufgefuellt.
 **
 **.* Funktionswerte :
 **	Pointer Ende von Des (NULL-Byte)
 **
 */

{

	while (left && max) {
		*Des++ = ' ';
		left--;
		max--;
	}

	while (*Src && max) {
		*Des++ = *Src++;
		max--;
	}

	while (max) {
		*Des++ = ' ';
		max--;
	}

	*Des = 0;
	return (Des);

}

/******************************************************************************/

static void MovTyp(Tp, Tind)
	Typ *Tp;short Tind;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion uebertraegt den Typindex Tind sinngemaess in die
 **	Struktur Typ.
 **
 **.* Funktionswerte :
 **
 */

{

	*Tp = 1 << Tind;

}

/******************************************************************************/

static short GetTypes(Str, Tp)
	char *Str;Typ *Tp;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion traegt die in Typ enthaltenen Parametertypen in Str
 **	ein.
 **
 **.* Funktionswerte :
 **	Laenge der Strings
 */

{
	short i;
	word msk;

	msk = 1;
	for (i = 0; i < TypMax; i++) {
		if (*Tp & msk) {
			strcpy(Str, UdfTp[i]);
			return (strlen(Str));
		}
		msk <<= 1;
	}
	return (0);

}

/******************************************************************************/

static word GetTypSInd(Tp)
	Typ *Tp;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert einen Typindex entsprechend dem Inhalt
 **	der Struktur Typ.
 **
 **.* Funktionswerte :
 **
 */

{
	short i;
	word msk;

	msk = 1;
	for (i = 0; i < TypMax; i++) {
		if (*Tp & msk) {
			return (i);
		}
		msk <<= 1;
	}
	return (-1);

}

/******************************************************************************/

static short GetTypInd(Tp)
	char *Tp;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert einen Typindex entsprechend dem String Tp
 **	der Struktur Typ.
 **
 **.* Funktionswerte :
 **
 */

{
	register
	short i;

	for (i = 0; i < TypMax; i++) {
		if (strcmpi(Tp, Typen[i]) == 0) {
			return (i);
		}
	}
	return (-1);

}

/******************************************************************************/

static short GetAbsInd(Tp)
	char *Tp;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert einen Index auf das Textarray der Ab-
 **	arbeitungsstrategien.
 **
 **.* Funktionswerte :
 **
 */

{
	register
	short i;

	for (i = 0; i < AbsMax; i++) {
		if (strcmpi(Tp, Abstrg[i]) == 0) {
			return (i);
		}
	}
	return (-1);

}

/******************************************************************************/

static short GetSwInd(Sw)
	char *Sw;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert einen Schuesselwortindex entsprechend
 **	dem String Sw.
 **
 **.* Funktionswerte :
 **	Index oder -1
 **
 */

{
	register
	short i;

	for (i = 0; i < SwMax; i++) {
		if (strcmpi(Sw, Sword[i]) == 0) {
			return (i);
		}
	}
	return (-1);

}

/******************************************************************************/

static short Symbol_known(S)
	char *S;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion untersucht, ob das uebergebene Symbol bereits
 **	definiert ist.
 **
 **.* Funktionswerte :
 **	1 wenn Symbol bekannt,
 **	sonst 0
 **
 */

{
	short i;
	SymDef *Sym;

	Sym = Params;
	for (i = 0; i < ParamAnz; i++) {
		if (strcmp(S, Sym->SN) == 0) {
			return (1);
		}
		Sym = Sym->Next;
	}
	return (0);

}

/**************************************************************************/

static ulong MulWord(W1, W2)
	word W1, W2;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion multipliziert die zwei uebergebenen Woerter
 **	vorzeichenlos miteinander und liefert den entsprechenden
 **	Longwert zurueck. Dies entspricht dem MUL-Befehl auf
 **	Unterstation.
 **
 **.* Funktionswerte :
 **
 **	Longwert
 **
 */

{

	return ((long) W1 * (long) W2);

}

/**************************************************************************/

static ulong DivLong(L1, L2)
	ulong L1, L2;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion dividiert die beiden Longwerte durcheinander
 **	und liefert den ganzzahligen Anteil der Division.
 **
 **.* Funktionswerte :
 **
 **	Longwert
 **
 */

{
	short d = 1;
	ulong erg;

	if (L1 < L2) {
		return (k0);
	}

	if (L2 == k0) {
		return (Maxlong);
	}

	erg = L1;
	if (erg > Minlong) {
		erg = Minlong;
	}

	while (erg > L2) {
		L2 <<= 1;
		d++;
	}

	erg = k0;
	while (d) {
		erg <<= 1;
		if (L1 >= L2) {
			erg = erg | 1;
			L1 = L1 - L2;
		}
		L1 <<= 1;
		d--;
	}

	return (erg);

}

/**************************************************************************/

static word LastDezi(L1)
	ulong L1;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert die letzte Dezimalstelle von L1
 **
 **.* Funktionswerte :
 **
 **	Restwert
 **
 */

{
	long X, X2, h;

	X = DivLong(L1, 10l);
	h = X << 1;
	X2 = h << 2;
	X2 += h;
	return ((word) (L1 - X2));

}

/**************************************************************************/

static word LowWord(fw)
	union flpU *fw;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert das Low-Word des Floatwertes fw
 **
 **.* Funktionswerte :
 **
 **
 */

{

	return (fw->W.w0);

}

/**************************************************************************/

static word HighWord(fw)
	union flpU *fw;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert das High-Word des Floatwertes fw
 **
 **.* Funktionswerte :
 **
 **
 */

{

	return (fw->W.w1);

}

/**************************************************************************/

static short f_nan(fw)
	real fw;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion testet ob fw eine ungueltige Float-Zahl darstellt.
 **
 **.* Funktionswerte :
 **
 **	true: Wert <> 0
 **	oder 0
 **
 */

{
	word e, hw;

	hw = HighWord((union flpU *) &fw);
	e = hw & 0x7f80;
	if (e) {
		return (0);
	} else {
		e = hw & 0x007f;
		return (e | LowWord((union flpU *) &fw));
	}

}

/**************************************************************************/

static void Convflpi(flt, fi)
	real flt;flpi *fi;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion traegt die Werte von Exponent und Mantisse
 **	der Float-Zahl fw in die Struktur fi ein.
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 */

{
	union flpU fw;
	union wdlU m;
	short e;

	fw.L = flt;
	m.W.hi = fw.W.w1 & 0x7f;
	m.W.lo = fw.W.w0;
	e = fw.W.w1 & 0x7f80;
	e >>= 7;
	if (e) {
		m.W.hi = m.W.hi | 0x80;
	}

	fi->ex = e;
	if (fw.W.w1 & 0x8000) {
		fi->sn = 1;
	} else {
		fi->sn = 0;
	}

	m.L <<= 6;
	fi->mt.L = m.L;

}

/**************************************************************************/

static void getExpoMant(flw, exp, mant)
	real flw;short *exp;long *mant;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion traegt die Werte von Exponent und Mantisse
 **	der Float-Zahl fw in die Adresse, die durch exp und mant
 **	gegeben sind.
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 */

{
	union wdlU m;
	union flpU fw;
	short e;

	fw.L = flw;
	m.W.hi = fw.W.w1 & 0x7f;
	m.W.lo = fw.W.w0;
	e = fw.W.w1 & 0x7f80;
	e >>= 7;
	if (e) {
		m.W.hi = m.W.hi | 0x80;
	}

	if (fw.W.w1 & 0x8000) {
		m.L = -m.L;
	}

	*mant = m.L;
	*exp = e;

}

/**************************************************************************/

static real Convflpe(fi)
	flpi *fi;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion konvertiert die FLP-Zahl im internen Format ins
 **	externe.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{
	word w, stick;
	union wdlU fr;
	union flpU fw;

	if (fi->sn) {
		w = 0x8000;
	} else {
		w = 0;
	}

	fr.L = fi->mt.L;
	if (fr.W.lo & 0x001f) {
		stick = 1;
	} else {
		stick = 0;
	}

	fr.L >>= 5;
	fr.L++;
	fr.L >>= 1;
	if (fr.L > MantMax) {
		fr.L >>= 1;
		fi->ex++;
	}
	fr.W.lo = fr.W.lo | stick;
	w = w | (fi->ex << 7);

	fw.W.w1 = fr.W.hi & 0x007f;
	fw.W.w1 = fw.W.w1 | w;
	fw.W.w0 = fr.W.lo;
	return (fw.L);

}

/**************************************************************************/

static real putExpoMant(exp, mts)
	short exp;long mts;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet aus den Werten von Exponent und Mantisse
 **	die Float-Zahl.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{
	word w = 0;
	union flpU fw;
	union wdlU mant;

	mant.L = mts;
	if (mant.L < 0) {
		mant.L = -mant.L;
		w = w | 0x8000;
	}
	w = w | (exp << 7);
	mant.W.hi = mant.W.hi & 0x007f;
	w = w | mant.W.hi;
	fw.W.w1 = w;
	fw.W.w0 = mant.W.lo;
	return (fw.L);

}

/**************************************************************************/

static real E_overflow(erg)
	flpi *erg;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ruft die entsprechende Fehlerroutine auf und
 **	liefert die groesste bzw. kleinste darstellbare Zahl zurueck.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{

	if (erg->sn) {
		/* Fehlermeldung overflow	*/
		return (minus_unendlich);
	} else {
		/* Fehlermeldung overflow	*/
		return (plus_unendlich);
	}

}

/**************************************************************************/

static real E_underflow()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ruft die entsprechende Fehlerroutine auf und
 **	liefert die kleinste darstellbare Zahl zurueck.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{

	/* Fehlermeldung underflow	*/
	return (k0);

}

/**************************************************************************/

static real E_divbyzero(sign)
	short sign;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ruft die entsprechende Fehlerroutine auf und
 **	liefert die groesste darstellbare Zahl zurueck.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{

	/* Fehlermeldung Division by Zero	*/
	if (sign) {
		return (minus_unendlich);
	} else {
		return (plus_unendlich);
	}

}

/**************************************************************************/

static real E_negsqrt()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ruft die entsprechende Fehlerroutine auf und
 **	liefert 0 zurueck.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{

	/* Fehlermeldung negative Sqrt    */
	return (k0);

}

/**************************************************************************/

static real E_negln()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ruft die entsprechende Fehlerroutine auf und
 **	liefert 1 zurueck.
 **
 **.* Funktionswerte :	1
 */

{

	/* Fehlermeldung negativer Logarithmus    */
	return (Fakul[0]);

}

static real E_negbasis()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ruft die entsprechende Fehlerroutine auf und
 **	liefert 1 zurueck.
 **
 **.* Funktionswerte :	1
 */

{

	/* Fehlermeldung negative Basis    */
	return (Fakul[0]);

}

static real f_neg(a)
	real a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion negiert die Float-Zahl a.
 **
 **.* Funktionswerte :
 **	-a
 */

{

	if (a != k0) {
		a = a ^ 0x80000000;
	}
	return (a);

}

/**************************************************************************/

static void fi_add(e, a, b)
	flpi *e, *a, *b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion addiert die beiden Float-Zahlen a und b im internen
 **	Format
 **
 **.* Funktionswerte :
 **
 **	a+b
 **
 */

{
	flpi *h;
	short de;
	long lw;
	long m1, m2;

	if (a->ex < b->ex) {
		h = a;
		a = b;
		b = h;
	}

	de = a->ex - b->ex;
	m1 = a->mt.L;
	m2 = b->mt.L;

	if (de < 30) {
		m2 = m2 >> de;
	} else {
		m2 = 0;
	}

	putSign (a->sn, m1);
	putSign (b->sn, m2);
	de = a->ex;
	lw = m1 + m2;
	getSign (e->sn, lw)
		;

	if (lw) {
		if (lw > MantMaxi) {
			de++;
			lw >>= 1;
		} else {
			while ((lw & MantMSBi) == 0) {
				de--;
				lw = lw << 1;
			}
		}
	} else {
		de = 0;
	}

	e->ex = de;
	e->mt.L = lw;

}

/**************************************************************************/

/*T*/
static
void fi_sub(e, a, b)
	flpi *e, *a, *b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion subtrahiert die beiden Float-Zahlen a und b im internen
 **	Format
 **
 **.* Funktionswerte :
 **
 **	a-b
 **
 */

{
	flpi *h;
	short de;
	long lw;
	long m1, m2;
	short exf;

	exf = 0;
	if (a->ex < b->ex) {
		h = a;
		a = b;
		b = h;
		exf++;
	}

	de = a->ex - b->ex;
	m1 = a->mt.L;
	m2 = b->mt.L;

	if (de < 30) {
		m2 = m2 >> de;
	} else {
		m2 = 0;
	}

	putSign ((a->sn ^
					exf), m1);
	putSign ((b->sn ^
					1 ^
					exf), m2);
	de = a->ex;
	lw = m1 + m2;
	getSign (e->sn, lw)
		;

	if (lw) {
		if (lw > MantMaxi) {
			de++;
			lw >>= 1;
		} else {
			while ((lw & MantMSBi) == 0) {
				de--;
				lw = lw << 1;
			}
		}
	} else {
		de = 0;
	}

	e->ex = de;
	e->mt.L = lw;

}

/**************************************************************************/

static void fi_mul(e, a, b)
	flpi *e, *a, *b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion multipliziert die beiden Float-Zahlen a und b im
 **	internen Format.
 **
 **.* Funktionswerte :
 **
 **	a*b
 **
 */

{
	union wdlU m1, m2, me, h1, h2;
	short ex;

	e->sn = a->sn ^ b->sn;
	ex = a->ex + b->ex - Bias + 1;

	m1.L = a->mt.L << 1;
	m2.L = b->mt.L << 1;
	me.L = MulWord(m1.W.hi, m2.W.hi);
	h1.L = MulWord(m1.W.hi, m2.W.lo);
	h1.L = (ulong) h1.L + MulWord(m1.W.lo, m2.W.hi);
	h2.L = MulWord(m1.W.lo, m2.W.lo);
	h1.L = (ulong) h1.L + h2.W.hi;
	me.L = (ulong) me.L + h1.W.hi;

	if (me.L) {
		if ((ulong) me.L > MantMaxi) {
			while ((ulong) me.L > MantMaxi) {
				me.L = (ulong) me.L >> 1;
				ex++;
			}
		} else {
			while ((me.L & MantMSBi) == 0) {
				ex--;
				me.L = (ulong) me.L << 1;
			}
		}
	} else {
		ex = 0;
		e->sn = 0;
	}

	e->ex = ex;
	e->mt.L = me.L;

}

/**************************************************************************/

static void fi_div(e, a, b)
	flpi *e, *a, *b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion dividiert die beiden Float-Zahlen a und b im
 **	internen Format.
 **
 **.* Funktionswerte :
 **
 **	a/b
 **
 */

{
	ulong m1, m2, me;
	int i;
	short ex;

	e->sn = a->sn ^ b->sn;
	ex = a->ex - b->ex + Bias;
	me = 0;
	m1 = a->mt.L;
	m2 = b->mt.L;

	for (i = 0; i < 31; i++) {
		me <<= 1;
		if (m1 >= m2) {
			me = me | 1;
			m1 = m1 - m2;
		}
		m1 <<= 1;
	}

	if (me > MantMaxi) {
		me >>= 1;
	} else {
		ex--;
	}

	e->ex = ex;
	e->mt.L = me;

}

/**************************************************************************/

static real f_add(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion addiert die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	a+b
 **
 */

{
	real erg;
	flpi fia, fib, fie;

	Convflpi(a, &fia);
	Convflpi(b, &fib);

	fi_add(&fie, &fia, &fib);

	erg = Convflpe(&fie);

	if (fie.ex > ExpMax) {
		return E_overflow(&fie);
	}

	if (fie.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

/*T*/
real f_sub(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion subtrahiert die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	a-b
 **
 */

{
	real erg;
	flpi fia, fib, fie;

	Convflpi(a, &fia);
	Convflpi(b, &fib);

	fi_sub(&fie, &fia, &fib);

	erg = Convflpe(&fie);

	if (fie.ex > ExpMax) {
		return E_overflow(&fie);
	}

	if (fie.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

real f_mul(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion multipliziert die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	a*b
 **
 */

{
	real erg;
	flpi fia, fib, fie;

	Convflpi(a, &fia);
	Convflpi(b, &fib);

	fi_mul(&fie, &fia, &fib);

	erg = Convflpe(&fie);

	if (fie.ex > ExpMax) {
		return E_overflow(&fie);
	}

	if (fie.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

real f_div(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion dividiert die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	a/b
 **
 */

{
	real erg;
	flpi fia, fib, fie;

	Convflpi(a, &fia);
	Convflpi(b, &fib);

	if (b == k0) {
		return E_divbyzero(fia.sn ^ fib.sn);
	}

	fi_div(&fie, &fia, &fib);

	erg = Convflpe(&fie);

	if (fie.ex > ExpMax) {
		return E_overflow(&fie);
	}

	if (fie.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

short f_eql(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion vergleicht die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	1 wenn a=b
 **	sonst 0
 **
 */

{

	if (a == b) {
		return (1);
	} else {
		return (0);
	}

}

/**************************************************************************/

static short f_geq(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion vergleicht die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	1 wenn a >= b
 **	sonst 0
 **
 */

{
	union wdlU la, lb;
	word hw, lw;

	lw = LowWord((union flpU *) &a);
	hw = HighWord((union flpU *) &a);
	la.W.lo = lw;
	la.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		la.L = -la.L;
	}
	lw = LowWord((union flpU *) &b);
	hw = HighWord((union flpU *) &b);
	lb.W.lo = lw;
	lb.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		lb.L = -lb.L;
	}

	if (la.L >= lb.L) {
		return (1);
	} else {
		return (0);
	}

}

/**************************************************************************/

static short f_leq(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion vergleicht die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	1 wenn a <= b
 **	sonst 0
 **
 */

{
	union wdlU la, lb;
	word hw, lw;

	lw = LowWord((union flpU *) &a);
	hw = HighWord((union flpU *) &a);
	la.W.lo = lw;
	la.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		la.L = -la.L;
	}
	lw = LowWord((union flpU *) &b);
	hw = HighWord((union flpU *) &b);
	lb.W.lo = lw;
	lb.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		lb.L = -lb.L;
	}

	if (la.L <= lb.L) {
		return (1);
	} else {
		return (0);
	}

}

/**************************************************************************/

static short f_gre(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion vergleicht die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	1 wenn a > b
 **	sonst 0
 **
 */

{
	union wdlU la, lb;
	word hw, lw;

	lw = LowWord((union flpU *) &a);
	hw = HighWord((union flpU *) &a);
	la.W.lo = lw;
	la.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		la.L = -la.L;
	}
	lw = LowWord((union flpU *) &b);
	hw = HighWord((union flpU *) &b);
	lb.W.lo = lw;
	lb.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		lb.L = -lb.L;
	}

	if (la.L > lb.L) {
		return (1);
	} else {
		return (0);
	}

}

/**************************************************************************/

static short f_low(a, b)
	real a, b;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion vergleicht die beiden Float-Zahlen a und b.
 **
 **.* Funktionswerte :
 **
 **	1 wenn a < b
 **	sonst 0
 **
 */

{
	union wdlU la, lb;
	word hw, lw;

	lw = LowWord((union flpU *) &a);
	hw = HighWord((union flpU *) &a);
	la.W.lo = lw;
	la.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		la.L = -la.L;
	}
	lw = LowWord((union flpU *) &b);
	hw = HighWord((union flpU *) &b);
	lb.W.lo = lw;
	lb.W.hi = hw & 0x7fff;
	if (hw & 0x8000) {
		lb.L = -lb.L;
	}

	if (la.L < lb.L) {
		return (1);
	} else {
		return (0);
	}

}

/************************************************************************/
/*	K o n v e r t i e r u n g s f u n k t i o n e n			*/
/************************************************************************/

static long f_ftol(fw)
	real fw;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt die Float-Zahl fw, in den entsprechenden
 **	long-Wert um.
 **
 **.* Funktionswerte :
 **
 **	long-Wert
 **
 */

/*P
 ** long	f_ftol (fw)
 **
 ** {
 ** Exponent und Mantisse aus fw bilden
 ** Exponent = Exponent - Bias
 ** if (Exponent < 0  )
 ** {
 **   return (0)
 ** }
 ** if (Exponent >= 31 )
 ** {
 **   if (Vozeichen negativ)
 ** {
 **     return (minimaler Longwert)
 ** } else {
 **     return (maximaler Longwert)
 ** }
 ** }
 **
 ** Mantisse in richtige Position schieben
 ** und Vorzeichen entsprechend setzen
 **
 ** }
 */

{
	long m1;
	long L;
	short sign, e1;

	getExpoMant(fw, &e1, &L);
	m1 = L;
	getSign (sign, m1)
		;
	e1 = e1 - Bias;

	if (e1 < ExpMin) {
		return (k0);
	}

	if (e1 >= 31) {
		if (sign) {
			return (Minlong);
		} else {
			return (Maxlong);
		}
	}

	e1 = 23 - e1;
	if (e1 == 0) {
		goto ftolexit;
	}

	if (e1 > 0) {
		do {
			m1 >>= 1;
			e1--;
		} while (e1 != 0);
	} else {
		e1 = -e1;
		do {
			m1 <<= 1;
			e1--;
		} while (e1 != 0);
	}

	ftolexit: putSign (sign, m1);
	return (m1);

}

/**************************************************************************/

/*T*/
short f_ftos(fw)
	real fw;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt die Float-Zahl fw, in den entsprechenden
 **	short-Wert um.
 **
 **.* Funktionswerte :
 **
 **	short-Wert
 **
 */

/*P
 ** short    f_ftos (fw)
 **
 ** {
 ** Exponent und Mantisse aus fw bilden
 ** Exponent = Exponent - Bias
 ** if (Exponent < 0  )
 ** {
 **   return (0)
 ** }
 ** if (Exponent >= 15 )
 ** {
 **   if (Vozeichen negativ)
 ** {
 **     return (minimaler Shortwert)
 ** } else {
 **     return (maximaler Shortwert)
 ** }
 ** }
 **
 ** Mantisse in richtige Position schieben
 ** und Vorzeichen entsprechend setzen
 **
 ** }
 */

{
	union wdlU m1;
	short sign, e1;

	getExpoMant(fw, &e1, &m1.L);
	getSign (sign, m1.L)
		;
	e1 = e1 - Bias;

	if (e1 < ExpMin) {
		return (0);
	}

	if (e1 >= 15) {
		if (sign) {
			return (Minshort);
		} else {
			return (Maxshort);
		}
	}

	e1 = 23 - e1;
	if (e1 == 0) {
		goto ftolexit;
	}

	if (e1 > 0) {
		do {
			m1.L >>= 1;
			e1--;
		} while (e1 != 0);
	} else {
		e1 = -e1;
		do {
			m1.L <<= 1;
			e1--;
		} while (e1 != 0);
	}

	ftolexit: putSign (sign, m1.W.lo);
	return (m1.W.lo);

}

/**************************************************************************/

static real f_ltof(L)
	long L;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den long-Wert L in die entsprechende float-Zahl um.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

/*P
 ** real	f_ltof (L )
 **
 ** {
 **
 ** if (L ==
 0)
 ** {
 **   return (0)
 ** }
 **
 ** Exponent = Bias + 23
 ** Mantisse normieren, Exponent korrigieren
 ** Vorzeichen entsprechend setzen
 **
 ** }
 */

{
	long m1;
	short sign, e1;

	m1 = L;
	if (m1 == 0) {
		e1 = 0;
		goto ltofexit;
	}
	getSign (sign, m1)
		;
	e1 = Bias + 23;
	if (m1 > MantMax) {
		do {
			m1 >>= 1;
			e1++;
		} while (m1 > MantMax);
	} else {
		while ((m1 & MantMSB) == 0) {
			m1 <<= 1;
			e1--;
		}
	}

	putSign(sign, m1);
	ltofexit: return (putExpoMant(e1, m1));

}

/**************************************************************************/

static real f_stof(S)
	short S;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den short-Wert S in die entsprechende
 **	float-Zahl um.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

/*P
 ** real	f_stof (S)
 **
 ** {
 **
 ** if (S ==
 0)
 ** {
 **   return (0)
 ** }
 **
 ** Exponent = Bias + 23
 ** Mantisse normieren, Exponent korrigieren
 ** Vorzeichen entsprechend setzen
 **
 ** }
 */

{
	long m1;
	short sign, e1;

	if (S == 0) {
		e1 = 0;
		goto ltofexit;
	}
	getSign (sign, S)
		;
	m1 = S & 0xffff;
	e1 = Bias + 23;
	while ((m1 & MantMSB) == 0) {
		m1 <<= 1;
		e1--;
	}

	putSign(sign, m1);
	ltofexit: return (putExpoMant(e1, m1));

}

/**************************************************************************/

/*T*/
real f_lwtf(L)
	ulong L;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den unsigned long-Wert L in die
 **	entsprechende float-Zahl um.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

/*P
 ** real	f_lwtf (L )
 **
 ** {
 **
 ** if (L ==
 0)
 ** {
 **   return (0)
 ** }
 **
 ** Exponent = Bias + 23
 ** Mantisse normieren, Exponent korrigieren
 ** Vorzeichen entsprechend setzen
 **
 ** }
 */

{
	ulong m1;
	short e1;

	m1 = L;
	if (m1 == 0) {
		e1 = 0;
		goto ltofexit;
	}
	e1 = Bias + 23;
	if (m1 > MantMax) {
		do {
			m1 >>= 1;
			e1++;
		} while (m1 > MantMax);
	} else {
		while ((m1 & MantMSB) == 0) {
			m1 <<= 1;
			e1--;
		}
	}

	ltofexit: return (putExpoMant(e1, m1));

}

/**************************************************************************/

/*T*/
real f_wtof(S)
	word S;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den unsigned short-Wert S in die entsprechende
 **	float-Zahl um.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

/*P
 ** real	f_wtof (S)
 **
 ** {
 **
 ** if (S ==
 0)
 ** {
 **   return (0)
 ** }
 **
 ** Exponent = Bias + 23
 ** Mantisse normieren, Exponent korrigieren
 ** Vorzeichen entsprechend setzen
 **
 ** }
 */

{
	long m1;
	short e1;

	if (S == 0) {
		e1 = 0;
		goto ltofexit;
	}
	m1 = S & 0xffff;
	e1 = Bias + 23;
	while ((m1 & MantMSB) == 0) {
		m1 <<= 1;
		e1--;
	}

	ltofexit: return (putExpoMant(e1, m1));

}

/**************************************************************************/

/*T*/
real f_deg(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den im Bogenmass vorliegenden X-Wert in
 **	das entsprechende Gradmass um.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{
	flpi fix, k180dpi;

	if (X == k0)
		return (X);
	Convflpi(X, &fix);
	k180dpi.ex = Bias + 5;
	k180dpi.sn = 0;
	k180dpi.mt.L = 0x394BB834L;
	fi_mul(&fix, &fix, &k180dpi);

	return Convflpe(&fix);

}

/**************************************************************************/

/*T*/
real f_rad(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den im Grad-mass vorliegenden X-Wert in
 **	das entsprechende Bogenmass um.
 **
 **.* Funktionswerte :
 **
 **	float-Wert
 **
 */

{
	flpi fix, k180dpi;

	if (X == k0)
		return (X);
	Convflpi(X, &fix);
	k180dpi.ex = Bias + 5;
	k180dpi.sn = 0;
	k180dpi.mt.L = 0x394BB834L;
	fi_div(&fix, &fix, &k180dpi);

	return Convflpe(&fix);

}

/**************************************************************************/

/*T*/
real f_int(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Integerwert von X.
 **
 **.* Funktionswerte :
 **
 **	INT (X)
 **
 */

{
	long m1;
	long msk;
	short sign, e1, ei;

	getExpoMant(X, &ei, &m1);
	getSign (sign, m1)
		;
	e1 = ei - Bias;

	if (e1 <= ExpMin) {
		return (k0);
	}

	if (e1 >= 23) {
		return (X);
	}

	if (e1 > 11) {
		msk = 1;
		e1 = 23 - e1;
		do {
			msk <<= 1;
			e1--;
		} while (e1 != 0);
	} else {
		msk = MantMSB;
		while (e1) {
			msk >>= 1;
			e1--;
		}
	}

	msk--;
	msk = bnot(msk);
	m1 = m1 & msk;
	putSign (sign, m1);
	return (putExpoMant(ei, m1));

}

/**************************************************************************/

static void fi_frac(e, a)
	flpi *e, *a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Nachkomma-Anteil von a im internen Format.
 **	Dies entspricht X - INT(X).
 **.* Funktionswerte :
 **
 **	FRAC (X)
 **
 */

{
	long msk, m1;
	short ex;

	ex = a->ex - Bias;

	if (ex < 0) {
		e->ex = a->ex;
		e->sn = a->sn;
		e->mt.L = a->mt.L;
		return;
	}

	if (ex >= 29) {
		e->ex = 0;
		e->sn = 0;
		e->mt.L = 0;
		return;
	}

	if (ex > 14) {
		msk = 1;
		ex = 29 - ex;
		do {
			msk <<= 1;
			ex--;
		} while (ex != 0);
	} else {
		msk = MantMSBi;
		while (ex) {
			msk >>= 1;
			ex--;
		}
	}

	msk--;
	m1 = a->mt.L & msk;
	if (m1) {
		ex = a->ex;
		while ((m1 & MantMSBi) == 0) {
			ex--;
			m1 = m1 << 1;
		}
		e->sn = a->sn;
	} else {
		e->sn = 0;
	}

	e->ex = ex;
	e->mt.L = m1;

}

/**************************************************************************/

/*T*/
real f_frac(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Nachkomma-Anteil von X.
 **	Dies entspricht X - INT(X).
 **.* Funktionswerte :
 **
 **	FRAC (X)
 **
 */

{
	flpi fix, fie;

	Convflpi(X, &fix);
	fi_frac(&fie, &fix);
	return Convflpe(&fie);

}

/**************************************************************************/

/*T*/
real f_abs(a)
	real a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Betrag der Float-Zahl a.
 **
 **.* Funktionswerte :
 **
 **	a Betrag
 **
 */

{

	a = a & 0x7fffffff;
	return (a);

}

/**************************************************************************/
/*  h o e h e r e   m a t h e m a t i s c h e   F u n k t i o n e n	  */
/**************************************************************************/

/*T*/
real f_pot2(a)
	real a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion quadriert die Float-Zahl a.
 **
 **.* Funktionswerte :
 **
 **	a hoch 2
 **
 */

{

	return (f_mul(a, a));

}

/**************************************************************************/

/*T*/
real f_rezi(a)
	real a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Kehrwert der Float-Zahl a.
 **
 **.* Funktionswerte :
 **
 **	1 / a
 **
 */

{

	return (f_div(Fakul[0], a));

}

/**************************************************************************/

/*T*/
real f_sqrt(a)
	real a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet die Quadratwurzel der Float-Zahl a.
 **
 **.* Funktionswerte :
 **
 **	Wurzel a
 **
 */

/*P
 ** real	f_sqrt (a)
 **
 ** {
 **
 ** if ( a < 0)
 ** {
 **   Fehlermeldung
 **   return (0)
 ** }
 **
 ** if ( a = 0)
 ** {
 **   return (0)
 ** }
 **
 ** Anfangswert Xn aus Mantisse und Exponent/2 biden
 ** X = 0
 ** while
 (X <> Xn)
 ** {
 **   Xn = (X + a/X)/2
 ** }
 **
 ** return (Xn)
 **
 ** }
 */

{
	flpi fia, X, Xn;
	short ex, sign;

	if (f_low(a, k0)) {
		return E_negsqrt();
	}

	if (a == k0) {
		return (k0);
	}

	X.ex = 0; //sign = 0;
	X.sn = 0;
	X.mt.L = 0;
	Convflpi(a, &fia);
	ex = fia.ex - Bias;
	getSign (sign, ex)
		;
	ex = ex >> 1;
	putSign (sign, ex);
	Xn.ex = ex + Bias;
	Xn.sn = 0;
	Xn.mt.L = fia.mt.L;

	while (X.ex != Xn.ex || X.mt.L != Xn.mt.L) {
		X.ex = Xn.ex;
		X.mt.L = Xn.mt.L;
		fi_div(&Xn, &fia, &X);
		fi_add(&Xn, &Xn, &X);
		Xn.ex--;
	}

	return Convflpe(&Xn);

}

/**************************************************************************/

static void fi_epot(e, x)
	flpi *e, *x;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Wert e hoch x im internen Format.
 **
 **.* Funktionswerte :
 **
 **	e hoch x
 **
 */

/*P
 ** real	fi_epot (X)
 **
 ** {
 **
 ** Vorzeichen = 0
 ** if ( X = 0)
 ** {
 **   return (1)
 ** }
 **
 ** Exponent = Exponent - Bias
 ** if (Exponent > 6)
 ** {
 **   Error Overflow
 ** }
 **
 ** if (Exponent > -1)
 ** {
 **   K = Exponent + 1
 **   Exponent = Bias -1
 **   X aus Exponent und Mantisse zusammensetzen
 ** }
 **
 ** 3. Reihenglied der Exponentialreihe berechnen
 ** do  {
 **   naechtes Reihenglied berechnen und zur
 **   Gesamtsumme addieren
 ** Until (Differenz zwischen Exponent (Summe) -
 **	  Exponent (Reihenglied) >= 23 oder n > Fakultaetstabelle)
 **
 ** Ergebnis K mal quadrieren
 ** if (Vorzeichen negativ)
 ** {
 **   Kehrwert bilden
 ** }
 **
 ** return (Ergebnis)
 ** }
 */

{
	flpi k1i, fak, Sum, /* Reihensumme		*/
	xpot, /* potenzwert von x	*/
	ele; /* Reihenelement	*/
	int n;
	short K, sign, ex, dex;

	if (x->ex == k0 && x->mt.L == k0) {
		e->ex = Bias;
		e->sn = 0;
		e->mt.L = MantMSBi;
		return;
	}

	sign = x->sn;
	e->sn = 0;
	e->mt.L = x->mt.L;
	e->ex = x->ex;
	ex = x->ex - Bias;

	if (ex > -1) {
		K = ex + 1;
		ex = Bias - 1;
		e->ex = ex;
	} else {
		K = 0;
	}

	k1i.ex = Bias;
	k1i.sn = 0;
	k1i.mt.L = MantMSBi;
	fi_add(&Sum, e, &k1i);
	fi_mul(&xpot, e, e);
	xpot.ex--;
	fi_add(&Sum, &Sum, &xpot);
	xpot.ex++;
	n = 3;

	do {
		fi_mul(&xpot, &xpot, e);
		Convflpi(Fakul[n++], &fak);
		fi_div(&ele, &xpot, &fak);
		fi_add(&Sum, &Sum, &ele);
		dex = Sum.ex - ele.ex;
	} while (!(dex >= 29 || n > FakMax));

	while (K) {
		fi_mul(&Sum, &Sum, &Sum);
		K--;
	}

	if (sign) {
		fi_div(&Sum, &k1i, &Sum);
	}

	e->ex = Sum.ex;
	e->mt.L = Sum.mt.L;

}

/**************************************************************************/

/*T*/
real f_epot(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Wert e hoch x.
 **
 **.* Funktionswerte :
 **
 **	e hoch x
 **
 */

{
	real erg;
	flpi fiX;

	Convflpi(X, &fiX);
	if (fiX.ex - Bias > 6) {
		return E_overflow(&fiX);
	}

	fi_epot(&fiX, &fiX);

	erg = Convflpe(&fiX);

	if (fiX.ex > ExpMax) {
		return E_overflow(&fiX);
	}

	if (fiX.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

static void fi_2log(e, x)
	flpi *e, *x;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den 2-er Logarithmus von x.
 **
 **.* Funktionswerte :
 **
 **
 */

/*P
 ** real	fi_2log   (e, x)
 **
 ** {
 **
 ** if ( X <= 0)
 ** {
 **   Fehlermeldung absetzen
 **   return (1)
 ** }
 **
 ** K = Expopnent - Bias
 ** Exponent = Bias
 ** X aus Exponent und Mantisse zusammensetzen
 **
 ** 2-er Logarithmus aus X bilden
 ** Mantisse normieren Exponent korrigieren
 ** X = X + K
 **
 ** return ( X * ln2)
 **
 ** }
 */

{
	flpi k1i, Kfi;
	real h;
	long mz, mb;
	short ez, K, sign;

	k1i.ex = Bias;
	k1i.sn = 0;
	k1i.mt.L = MantMSBi;
	if (x->ex < Bias) {
		fi_div(e, &k1i, x);
		sign = 1;
	} else {
		e->ex = x->ex;
		e->sn = 0;
		e->mt.L = x->mt.L;
		sign = 0;
	}
	K = e->ex - Bias;
	e->ex = Bias;
	ez = 0;
	mz = 0;
	mb = MantMSBi;

	do {
		if (e->ex == Bias && e->mt.L == MantMSBi) {
			goto lnexit;
		}

		fi_mul(e, e, e);
		if (e->ex >= Bias + 1) {
			mz = mz | mb;
			e->ex--;
		}

		mb = mb >> 1;
	} while (mb != 0);

	ez = Bias - 1;
	while ((mz & MantMSBi) == 0) {
		ez--;
		mz <<= 1;
	}

	lnexit: e->ex = ez;
	e->mt.L = mz;
	if (K) {
		h = f_stof(K);
		Convflpi(h, &Kfi);
		fi_add(e, e, &Kfi);
	}
	e->sn = sign;

}

/**************************************************************************/

/*T*/
real f_ln(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den natuerlichen Logarithmus von x.
 **
 **.* Funktionswerte :
 **
 **	ln (x)
 **
 */

/*P
 ** real	f_ln   (X)
 **
 ** {
 **
 ** if ( X <= 0)
 ** {
 **   Fehlermeldung absetzen
 **   return (1)
 ** }
 **
 ** X = 2log(X)
 ** return ( X * ln2)
 **
 ** }
 */

{
	flpi fiX, ln2i;

	if (f_leq(X, k0)) {
		return E_negln();
	}

	Convflpi(X, &fiX);
	fi_2log(&fiX, &fiX);
	ln2i.ex = Bias - 1;
	ln2i.sn = 0;
	ln2i.mt.L = 0x2C5C85FDL; /* intern ln2	*/
	fi_mul(&fiX, &fiX, &ln2i);
	return Convflpe(&fiX);

}

/**************************************************************************/

/*T*/
real f_log(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den 10er Logarithmus von x.
 **
 **.* Funktionswerte :
 **
 **	log (x)
 **
 */

/*P
 ** real	f_log  (X)
 **
 ** {
 **
 ** if ( X <= 0)
 ** {
 **   Fehlermeldung absetzen
 **   return (1)
 ** }
 **
 ** X = 2log(X)
 ** return ( X * log2)
 **
 ** }
 */

{
	flpi fiX, ln2i;

	if (f_leq(X, k0)) {
		return E_negln();
	}

	Convflpi(X, &fiX);
	fi_2log(&fiX, &fiX);
	ln2i.ex = Bias - 2;
	ln2i.sn = 0;
	ln2i.mt.L = 0x268826A1L; /* intern log2	*/
	fi_mul(&fiX, &fiX, &ln2i);
	return Convflpe(&fiX);

}

/**************************************************************************/

/*T*/
real f_xpota(x, a)
	real x, a;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Wert von x hoch a fuer reele Werte von a.
 **
 **.* Funktionswerte :
 **
 **	X^a
 **
 */

{
	flpi fia, fix;
	real erg;

	if (f_leq(x, k0)) {
		return E_negbasis();
	}

	Convflpi(a, &fia);
	Convflpi(x, &fix);
	fi_2log(&fix, &fix);
	fi_mul(&fix, &fix, &fia);
	fia.ex = Bias - 1;
	fia.sn = 0;
	fia.mt.L = 0x2C5C85FDL; /* intern ln2	*/
	fi_mul(&fix, &fix, &fia); /* a * ln(x)	*/
	fi_epot(&fix, &fix);

	erg = Convflpe(&fix);

	if (fix.ex > ExpMax) {
		return E_overflow(&fix);
	}

	if (fix.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

/*T*/
real f_xpotn(x, n)
	real x;short n;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Wert von x hoch n fuer ganzzahlige
 **	Werte von n.
 **
 **.* Funktionswerte :
 **
 **	X^n
 **
 */

{
	flpi fix, pot2, k1i, ergi;
	real erg;
	word potmsk, ninit;

	if (n == 0) {
		return (Fakul[0]);
	}

	if (n == 1) {
		return (x);
	}

	Convflpi(x, &fix);
	if (n < 0) {
		k1i.ex = Bias;
		k1i.sn = 0;
		k1i.mt.L = MantMSBi;
		fi_div(&fix, &k1i, &fix);
		n = -n;
	}

	ninit = 0;
	potmsk = 1;
	while (n) {
		if (n & potmsk) {
			if (potmsk == 1) {
				pot2.ex = fix.ex;
				pot2.sn = fix.sn;
				pot2.mt.L = fix.mt.L;
				ergi.ex = fix.ex;
				ergi.sn = fix.sn;
				ergi.mt.L = fix.mt.L;
			} else {
				fi_mul(&pot2, &pot2, &pot2);
			}
			if (ninit) {
				fi_mul(&ergi, &ergi, &pot2);
			} else {
				ergi.ex = pot2.ex;
				ergi.sn = pot2.sn;
				ergi.mt.L = pot2.mt.L;
				ninit++;
			}
			n = n - potmsk;
		} else {
			if (potmsk == 1) {
				pot2.ex = fix.ex;
				pot2.sn = fix.sn;
				pot2.mt.L = fix.mt.L;
			} else {
				fi_mul(&pot2, &pot2, &pot2);
			}
		}
		potmsk <<= 1;
	}

	erg = Convflpe(&ergi);

	if (ergi.ex > ExpMax) {
		return E_overflow(&ergi);
	}

	if (ergi.ex <= ExpMin) {
		return E_underflow();
	}

	return (erg);

}

/**************************************************************************/

/*T*/
real f_sin(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Wert Sinus x.
 **
 **.* Funktionswerte :
 **
 **	sin (x)
 **
 */

{
	flpi Sum, /* Reihensumme		*/
	xpot, /* potenzwert von x	*/
	xpot2, fak, kpi, ele; /* Reihenelement	*/
	int n;
	short sign, signl, dex;

	if (X == k0) {
		return (X);
	}

	Convflpi(X, &Sum);
	sign = Sum.sn;
	if (sign) {
		Sum.sn = 0;
	}

	kpi.ex = Bias + 2;
	kpi.sn = 0;
	kpi.mt.L = 0x3243F6A8L; /* kpi = 2*pi				*/
	if (Sum.ex > kpi.ex || (Sum.ex == kpi.ex && Sum.mt.L > kpi.mt.L)) {
		fi_div(&Sum, &Sum, &kpi);
		fi_frac(&Sum, &Sum);
		fi_mul(&Sum, &Sum, &kpi);
	}

	if (sign) {
		fi_sub(&Sum, &kpi, &Sum);
		sign = 0;
	}

	kpi.ex--; /* kpi = pi		    */
	if (Sum.ex > kpi.ex || (Sum.ex == kpi.ex && Sum.mt.L > kpi.mt.L)) {
		fi_sub(&Sum, &Sum, &kpi);
		sign = 1;
	}

	kpi.ex--; /* kpi = pi/2		    */
	if (Sum.ex > kpi.ex || (Sum.ex == kpi.ex && Sum.mt.L > kpi.mt.L)) {
		kpi.ex++;
		fi_sub(&Sum, &kpi, &Sum);
	}

	xpot.ex = Sum.ex;
	xpot.sn = Sum.sn;
	xpot.mt.L = Sum.mt.L;
	fi_mul(&xpot2, &Sum, &Sum);
	n = 3;
	signl = 1;

	do {
		fi_mul(&xpot, &xpot, &xpot2);
		Convflpi(Fakul[n], &fak);
		fi_div(&ele, &xpot, &fak);
		n++;
		n++;
		if (signl) {
			fi_sub(&Sum, &Sum, &ele);
		} else {
			fi_add(&Sum, &Sum, &ele);
		}
		signl = signl ^ 1;
		dex = Sum.ex - ele.ex;
	} while (!(dex >= 29 || n > FakMax));

	Sum.sn = sign;

	return Convflpe(&Sum);

}

/**************************************************************************/

/*T*/
real f_cos(X)
	real X;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet den Wert Cosinus x.
 **
 **.* Funktionswerte :
 **
 **	cos (x)
 **
 */

{
	flpi Sum, /* Reihensumme		*/
	xpot, /* potenzwert von x	*/
	xpot2, fak, kpi, ele; /* Reihenelement	*/
	int n;
	short sign = 0, signl, dex;

	if (X == k0) {
		return (Fakul[0]);
	}

	Convflpi(X, &Sum);
	Sum.sn = 0;
	kpi.ex = Bias + 2;
	kpi.sn = 0;
	kpi.mt.L = 0x3243F6A8L; /* kpi = 2*pi				*/

	if (Sum.ex > kpi.ex || (Sum.ex == kpi.ex && Sum.mt.L > kpi.mt.L)) {
		fi_div(&Sum, &Sum, &kpi);
		fi_frac(&Sum, &Sum);
		fi_mul(&Sum, &Sum, &kpi);
	}

	kpi.ex--; /* kpi = pi		*/
	if (Sum.ex > kpi.ex || (Sum.ex == kpi.ex && Sum.mt.L > kpi.mt.L)) {
		kpi.ex++; /* kpi = 2*pi		*/
		fi_sub(&Sum, &kpi, &Sum);
		kpi.ex--; /* kpi = pi		*/
		sign = 1;
	}

	kpi.ex--; /* kpi = pi/2		*/
	if (Sum.ex > kpi.ex || (Sum.ex == kpi.ex && Sum.mt.L > kpi.mt.L)) {
		kpi.ex++; /* kpi = pi		*/
		sign = 1;
		fi_sub(&Sum, &kpi, &Sum);
	}

	fi_mul(&xpot2, &Sum, &Sum);
	xpot.ex = xpot2.ex;
	xpot.sn = 0;
	xpot.mt.L = xpot2.mt.L;
	ele.ex = xpot.ex - 1;
	ele.sn = 0;
	ele.mt.L = xpot.mt.L;
	kpi.ex = Bias;
	kpi.sn = 0;
	kpi.mt.L = MantMSBi;
	fi_sub(&Sum, &kpi, &ele);
	n = 4;
	signl = 0;

	do {
		fi_mul(&xpot, &xpot, &xpot2);
		Convflpi(Fakul[n], &fak);
		fi_div(&ele, &xpot, &fak);
		n++;
		n++;
		if (signl) {
			fi_sub(&Sum, &Sum, &ele);
		} else {
			fi_add(&Sum, &Sum, &ele);
		}
		signl = signl ^ 1;
		dex = Sum.ex - ele.ex;
	} while (!(dex >= 29 || n > FakMax));

	Sum.sn = sign;

	return Convflpe(&Sum);

}

/**************************************************************************/

static char* Norm_Disp(exp, st, zifa, buf)
	short exp, st;char *zifa, *buf;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet aus der Ziffernfolge in 'zifa', dem Ex-
 **	ponenten 'exp' und den signifikanten Stellen 'st' die Normal-
 **	darstellung in 'buf'.
 **
 **.* Funktionswerte :
 **
 **	Pointer auf zu schreibendes Nullbyte.
 **
 */

{

	if (exp >= 0) {
		while (st) {
			*buf++ = *zifa++;
			st--;
			if (exp == 0 && st) {
				*buf++ = '.';
			}
			exp--;
		}
		while (exp >= 0) {
			*buf++ = '0';
			exp--;
		}
	} else {
		*buf++ = '0';
		*buf++ = '.';
		exp++;
		while (exp) {
			*buf++ = '0';
			exp++;
		}
		while (st) {
			*buf++ = *zifa++;
			st--;
		}
	}

	return (buf);

}

/**************************************************************************/

static char* Expo_Disp(exp, st, zifa, buf)
	short exp, st;char *zifa, *buf;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion bildet aus der Ziffernfolge in 'zifa', dem Ex-
 **	ponenten 'exp' und den signifikanten Stellen 'st' die Expo-
 **	nentialdarstellung in 'buf'.
 **
 **.* Funktionswerte :
 **
 **	Pointer auf zu schreibendes Nullbyte.
 **
 */

{
	short flag1;

	flag1 = 1;
	while (st) {
		*buf++ = *zifa++;
		st--;
		if (flag1 && st) {
			*buf++ = '.';
			flag1 = 0;
		}
	}
	*buf++ = ' ';
	*buf++ = 'E';
	if (exp < 0) {
		*buf++ = '-';
		exp = -exp;
	} else {
		*buf++ = ' ';
	}
	*buf++ = (byte) DivLong((long) exp, 10l) + '0';
	*buf++ = LastDezi((long) exp) + '0';

	return (buf);

}

/**************************************************************************/

static short f_ftoa(X, Sz, buf)
	real X;short Sz;char *buf;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt die Float-Zahl X in die Dezimaldarstellung
 **	wobei auf Sz Stellen gerundet wird. Ist die Zahl in normaler
 **	Form nicht mehr darstellbar wird automatisch die Exponential-
 **	Darstellung verwendet.
 **
 **.* Funktionswerte :
 **
 **	Laenge des Ausgabestrings
 **
 */

/*P
 ** short    f_ftoa (X, Sz, Buf, form)
 **
 ** {
 ** if (X < 0)
 ** {
 **   Vorzeichen in Buf schreiben
 ** } else {
 **   Blank in Buf schreiben
 ** }
 **
 ** if (X = 0)
 ** {
 **   0 in Buf schreiben
 **   goto Exit
 ** }
 **
 ** Zehnerexponent bestimmen und dabei X in
 ** Wertebereich 10^7 < X < 10^8 transformieren
 ** X in Longwert wandeln
 ** Dezimalziffern aus Longwert bestimmen
 ** auf angegebene Stellenzahl runden und
 ** signifikante Stellen ermitteln
 **
 ** if (Zehnerexponent <= Stellenzahl und Zehnerexponent >=0 oder
 **     (signifikante Stellen - Zehnerexponent) <= Stellenzahl und
 **      Zehnerexponent < 0)
 ** {
 **   Ziffernfolge in Normaldarstellung in Buf aufbauen
 ** } else {
 **   Ziffernfolge in Exponentialdarstellung in Buf aufbauen
 ** }
 **
 ** return (Bufferlaenge)
 **
 ** }
 */

{
	short exp10, exS2, i, flag1;
	short SigSt, len;
	char *cp, Zif[10];
	long fint;
	flpi fix, pt78, pt10;

	len = 1;
	flag1 = 0;
	if (f_low(X, k0)) {
		X = f_neg(X);
		*buf++ = '-';
	} else {
		*buf++ = ' ';
	}

	if (f_nan(X)) {
		*buf++ = '*';
		*buf++ = '.';
		*buf++ = '*';
		len += 3;
		goto ftoa2;
	}

	if (X == k0) {
		*buf++ = '0';
		len++;
		goto ftoa2;
	}

	Convflpi(X, &fix);
	exS2 = Bias + 23 - fix.ex;
	exp10 = 7;
	if (exS2 == 0)
		goto ftoa1;

	if (exS2 > 0) {
		i = (Pot10Max * exS2) / (256 - Bias) + 1;
		if (i > Pot10Max) {
			i = Pot10Max;
			flag1++;
		}
		exp10 -= i;
		Convflpi(Pot10[i], &pt10);
		fi_mul(&fix, &fix, &pt10);
		if (flag1) {
			exS2 = Bias + 23 - fix.ex;
			i = (Pot10Max * exS2) / (256 - Bias) + 1;
			exp10 -= i;
			Convflpi(Pot10[i], &pt10);
			fi_mul(&fix, &fix, &pt10);
		}
		Convflpi(Pot10[7], &pt78);
		Convflpi(Pot10[1], &pt10);
	} else {
		exS2 = -exS2;
		i = (Pot10Max * exS2) / (256 - Bias);
		exp10 += i;
		Convflpi(Pot10[i], &pt10);
		fi_div(&fix, &fix, &pt10);
		Convflpi(Pot10[8], &pt78);
		Convflpi(Pot10[1], &pt10);
	}
	while (fix.ex > pt78.ex || (fix.ex == pt78.ex && fix.mt.L >= pt78.mt.L)) {
		exp10++;
		fi_div(&fix, &fix, &pt10);
	}

	ftoa1: i = 8;
	cp = &Zif[9];
	*cp-- = 0;
	*cp = '0';
	X = Convflpe(&fix);
	fint = f_ftol(X);

	while (i) {
		cp--;
		*cp = LastDezi(fint) + '0';
		fint = DivLong(fint, 10L);
		i--;
	}

	if (*cp == '0') {
		cp++;
		exp10--;
	}

	/* runden auf Sz. Stelle	    */
	if (Sz < 1) {
		Sz = 1;
	}
	if (Sz > 7) {
		Sz = 7;
	}

	cp += Sz;
	flag1 = 0;
	if (*cp >= '5') {
		flag1++;
	}
	SigSt = 0;
	i = Sz;
	while (i) {
		cp--;
		if (flag1) {
			(*cp)++;
			if (*cp <= '9') {
				flag1 = 0;
			} else {
				*cp = '0';
			}
		}

		if (SigSt) {
			SigSt++;
		} else {
			if (*cp != '0') {
				SigSt++;
			}
		}
		i--;
	}

	if (flag1) {
		/* Rundungsueberlauf beruecksichtigen	*/
		*cp = '1';
		exp10++;
		SigSt++;
	}

	if ((exp10 <= Sz && exp10 >= 0) || (exp10 < 0 && (SigSt - exp10) <= Sz)) {
		/* Normaldarstellung		*/
		cp = Norm_Disp(exp10, SigSt, cp, buf);
	} else {
		/* Exponentialdarstellung	*/
		cp = Expo_Disp(exp10, SigSt, cp, buf);
	}
	len += cp - buf;
	buf = cp;

	ftoa2: *buf = 0;
	return (len);

}

/**************************************************************************/

real f_atof(buf)
	char *buf;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt die Float-Zahl X, die in ASCII-Format vorliegt
 **	in die interne Darstellung. Dabei ist sowohl die Normaldarstellung,
 **	als auch die Exponentialdarstellung zulaessig.
 **
 **.* Funktionswerte :
 **
 **	gewandelte Zahl oder 1l im Fehlerfall
 **	Achtung weiterrechnen mit Fehlercode fuehrt zu unvorhersehbaren
 **	Ergebnissen.
 **
 */

{
	char c;
	short n, sign, Esign, Komflag, Expflag;
	short digits, exp, Vorkomma, NullnKomma;
	long fint, h1, h2;

	exp = 0;
	n = 0;
	sign = 0;
	Esign = 0;
	Vorkomma = 0;
	Komflag = 1;
	Expflag = 0;
	fint = 0;
	NullnKomma = 0;
	digits = 0;
	while ((c = *buf++) != 0) {
		if (c >= '0' && c <= '9') {
			if (Expflag) {
				exp = exp * 10 + c - '0';
				if (exp >= 99) {
					if (Esign) {
						return (0);
					} else {
						if (sign) {
							return (minus_unendlich);
						} else {
							return (plus_unendlich);
						}
					}
				}
				continue;
			}

			if (digits < Maxdigit) {
				h1 = fint << 1;
				h2 = h1 << 2;
				fint = h1 + h2 + c - '0';
				if (fint) {
					digits++;
				} else {
					if (Komflag == 0) {
						NullnKomma++;
					}
				}
			}
			n++;
			if (n > 99) {
				break;
			}
			if (Komflag && fint) {
				Vorkomma++;
			}
		} else {
			/* keine Ziffer	    */
			if (c <= 0x20 || c > 0x7e) {
				continue;
			}
			n++;
			if (n == 1) {
				if (c == '-') {
					sign = 1;
					continue;
				}
				if (c == '+') {
					continue;
				}
				if (c == '.') {
					if (Expflag) {
						break;
					}
					Komflag = 0;
					continue;
				}
				if (c == 'E' || c == 'e') {
					fint = 1;
					Expflag++;
					continue;
				}
				break;
			} else {
				/* nicht 1. Zeichenstelle	*/
				if (c == '.') {
					if (Komflag) {
						Komflag = 0;
						continue;
					} else {
						break;
					}
				}

				if (c == 'E' || c == 'e') {
					if (Expflag == 0) {
						Expflag++;
						continue;
					} else {
						break;
					}
				}

				if (Expflag) {
					if (c == '-') {
						Esign = 1;
						continue;
					}
					if (c == '+') {
						continue;
					}
				}
				break;
			}
		}
	}

	if (Esign) {
		exp = -exp;
	}
	exp = exp + Vorkomma - digits - NullnKomma;

	if (exp > Pot10Max) {
		if (sign) {
			return (minus_unendlich);
		} else {
			return (plus_unendlich);
		}
	}

	if (sign) {
		fint = -fint;
	}
	fint = f_ltof(fint);

	if (exp == 0) {
		goto atofex;;
	}

	if (exp > 0) {
		fint = f_mul(fint, Pot10[exp]);
	} else {
		if (exp < -Pot10Max) {
			fint = f_div(fint, Pot10[Pot10Max]);
			exp += Pot10Max;
		}
		fint = f_div(fint, Pot10[-exp]);
	}

	atofex: return (fint);

}

/******************************************************************************/

void decode(Sc, Sd, len)
	char *Sc, *Sd;word len;

/*F
 ** *	Beschreibung :
 **
 **	Die Funktion decodiert den in Sc enthaltenen Text
 **
 ** *	Funktionswerte :
 **
 */

{
	word *wd, *wc;
	register word hw, i;

	len = len >> 1;
	wd = (word*) Sd;
	wc = (word*) Sc;

	while (len) {
		*wd = *wc;
		for (i = 0; i < 3; i++) {
			hw = *wd >> 1;
			if (*wd & 0x0001) {
				hw = hw | 0x8000;
			}
			*wd = hw;
		}
		wd++;
		wc++;
		len--;
	}
}

/******************************************************************************/

static void Hexcb(String, Byte)
	char *String;unsigned char Byte;

/*F
 ** * Beschreibung :
 **
 **   Die Funktion wandelt den in Byte stehenden Wert in einen
 **   Hexadezimalwert mit fuehrender Null um und legt ihn in String ab.
 **
 ** * Funktionswerte :
 **
 **   Keine
 **
 ** * Besondere Hinweise :
 **
 **   Keine.
 */

/*P
 **
 ** Hexcb (String,Byte)
 ** {
 **   Byte wandeln;
 **   if Byte < 16   haenge fuehrende Null an;
 ** }
 */

{

	sprintf(String, "%2X", Byte);
	if (Byte < 16)
		String[0] |= '0';

}

/******************************************************************************/

static void Dezcb(String, Byte)
	char *String;byte Byte;

/*F
 ** * Beschreibung :
 **
 **   Die Funktion wandelt den in Byte stehenden Wert in einen
 **   Dezimalwert mit fuehrender Null um und legt ihn in String ab.
 **
 ** * Funktionswerte :
 **
 **   Keine
 **
 ** * Besondere Hinweise :
 **
 **   Keine.
 */

/*P
 **
 ** Dezcb (String,Byte)
 ** {
 **   Byte wandeln;
 **   if Byte < 10   haenge fuehrende Null an;
 ** }
 */

{

	sprintf(String, "%2d", Byte);
	if (Byte < 10)
		String[0] |= '0';

}

/******************************************************************************/

static char Hexcwi(String, Word)
	char *String;word Word;

/*F
 ** * Beschreibung :
 **   Die Funktion wandelt den in Word stehenden Wert in einen
 **   Hexadezimalwert mit fuehrender Null um und legt ihn in String ab.
 **   Dabei wird zusaetzlich Die Pruefsumme des High und Low-bytes gebildet.
 **
 ** * Funktionswerte :
 **
 **   Pruefsumme
 **
 ** * Besondere Hinweise :
 **
 **   Keine.
 */

/*P
 ** Hexcwi (String,Word)
 ** {
 **   Low-Byte wandeln;
 **   Pruefsumme = Low-Byte;
 **   Pruefsumme = Pruefsumme + High-Byte
 **   gewandelter Low-Byte-String und High-Byte-String
 **   zusammensetzen;
 **   return(Pruefsumme);
 **  }
 */

{
	char H, Sum;
	char Hex[3];

	H = Word;
	Sum = H;
	Hexcb(String, H);
	H = Word >> 8;
	Sum = Sum + H;
	Hexcb(Hex, H);
	strcat(String, Hex);
	return (Sum);

}

/******************************************************************************/

static char Hexcw(String, Word)
	char *String;unsigned short Word;

/*F
 ** * Beschreibung :
 **   Wie Hexcw(String,Word) nur High- und Low-Byte vertauscht.
 **
 ** * Funktionswerte :
 **
 **
 ** * Besondere Hinweise :
 **
 ** Keine.
 */

/*P
 ** Hexcw (String,Word)
 ** {
 **   High-Byte wandeln;
 **   Pruefsumme = High-Byte;
 **   Pruefsumme = Pruefsumme + Low-Byte
 **   gewandelter High-Byte-String und Low-Byte-String
 **   zusammensetzen;
 **   return(Pruefsumme);
 **  }
 */

{
	char H, Sum;
	char Hex[3];

	H = Word >> 8;
	Sum = H;
	Hexcb(String, H);
	H = Word;
	Sum = Sum + H;
	Hexcb(Hex, H);
	strcat(String, Hex);
	return (Sum);
}

/******************************************************************************/

static void HexIntel(Ausgabe, Seg, Off, FAdr, N)
	FILE *Ausgabe; /* Pointer Ausgabedatei				*/
	word *FAdr; /* Pointer auf Integerfeld			*/
	word Seg, /* Anfangs-Segmentadresse des Datenblocks	*/
	Off, /* Anfangs-Offset des Datenblocks		*/
	N; /* Anzahl der zu schreibenden Worte		*/

/*F
 ** * Beschreibung :
 **
 ** Die Funktion schreibt N Worte des Integer-Arrays FAdr im Hex-Intel
 ** Format in die Datei Ausgabe, wobei Seg und Off die Anfangsadresse des
 ** Datenblocks ist an die die im Feld FAdr enthaltenen Worte spaeter
 ** geladen werden sollen.
 **
 ** * Funktionswerte :
 **
 ** Die Funktion liefert keinen Rueckgabewert
 **
 ** * Besondere Hinweise :
 **
 **   Keine.
 */

/*P
 **
 ** HexIntel	(Ausgabe, Seg, Off, FAdr, N)
 ** {
 **   Adressblock aus Seg bilden und schreiben;
 **   for (i=0; i<N; i+=8)
 **   {
 **   ByteAnzahl des folgenden Blocks ermitteln
 **   String mit ByteAnzahl und Offset bilden
 **   8 Worte wandeln und an String anhaengen
 **   Pruefsumme wandeln und anhaengen
 **   String auf Datei schreiben
 **   Offset + 16
 **   }
 **}
 */

{
	word i, j, Ba;
	byte H, Sum;
	byte Hex[5];
	byte HSum[3];
	byte local[50];
	static word lastSeg;

	if (Seg != lastSeg) {
		Sum = 4;
		Sum = Sum + Hexcw(Hex, Seg);
		Hexcb(HSum, -Sum);
		sprintf(local, ":02000002%s%s", Hex, HSum);
		fprintf(Ausgabe, "%s\015\012", local);
		lastSeg = Seg;
	}

	for (i = 0; i < N; i += 8) {
		Ba = (N - i) << 1;
		if (Ba > 16)
			Ba = 16;
		Sum = Ba;
		Hexcb(HSum, Sum);
		Sum = Sum + Hexcw(Hex, Off);
		sprintf(local, ":%s%s00", HSum, Hex);

		for (j = i; j < i + (Ba >> 1); j++) {
			Sum = Sum + Hexcwi(Hex, FAdr[j]);
			strcat(local, Hex);
		}
		Hexcb(HSum, -Sum);
		strcat(local, HSum);
		fprintf(Ausgabe, "%s\015\012", local);
		Off += 16;
	}

}

/*---------------------------------------------------------------------------*/
static int OpenTextFile2(char *path) {
	if (access(path, R_OK) == 0) {
		fht = open(path, O_RDONLY);
		return 0;
	}

	return -1;

}
static int OpenTextFile(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **      Die Funktion �ffnet die bin�re Textdatei.
 **
 **.* Funktionswerte :
 **
 */

{
	char work[150], *P;
	char work2[50];

	strcpy(work2, Str);
	if (access(work2, 0) == 0)
		goto ok;
	if ((P = getenv("PATH")) != NULL) {
		strcpy(work, P);
	} else {
		work[0] = 0;
	}
	P = strtok(work, ";");
	while (P) {
		strcpy(work2, P);
		strcat(work2, "\\");
		strcat(work2, Str);
		if (access(work2, 0) == 0)
			goto ok;
		P = strtok(NULL, ";");
	}
	return (1); // Datei existiert nicht!

	ok: fht = open(work2, O_RDONLY);
	if (fht == -1)
		return (1);
	return (0);

}
/***************************************************************************/

static
void readFile(int, char*, long, word);

static
void readFile(fh, buf, Off, len)
	int fh;char *buf;long Off;word len;

/*
 **	Die Funktion liest len Bytes in buf ab File-Offset Off.
 **
 */

{

	lseek(fh, Off, SEEK_SET);
	read(fh, buf, len);

}

/*---------------------------------------------------------------------------*/

static int GetTextVW(word, struct TxtbS *);

static int GetTextVW(Num, Vw)
	word Num;struct TxtbS *Vw;

/*F
 **.* Beschreibung :
 **
 **      Die Funktion l�dt die angegebene Textnummer.
 **
 **.* Funktionswerte :
 **
 */

{
	long Off;
	int len, Anz, Ve;
	word A, B, i, ia;

	Off = 0;
	len = sizeof(struct TxtbS);
	readFile(fht, (char*) Vw, Off, len);
	Anz = Vw->Tnum;
	if (Anz == 1) {
		Off = len;
		readFile(fht, (char*) Vw, Off, len);
		if (Vw->Tnum == Num) {
			return (1);
		} else {
			return (0);
		}
	}
	A = 0;
	B = Anz;
	ia = 0;
	i = (A + B) >> 1;

	while (i != ia) {
		Off = len * (i + 1);
		readFile(fht, (char*) Vw, Off, len);
		Ve = Num - Vw->Tnum;
		if (Ve == 0) {
			return (1);
		}
		if (Ve > 0) {
			A = i;
		} else {
			B = i;
		}
		ia = i;
		i = (A + B) >> 1;
	}
	return (0);

}

/*---------------------------------------------------------------------------*/

static void GetText(Ps, Num)
	char *Ps;word Num;

/*F
 **.* Beschreibung :
 **
 **      Die Funktion l�dt die angegebene Textnummer.
 **
 **.* Funktionswerte :
 **
 */

{
	struct TxtbS Vw;

	if (GetTextVW(Num, &Vw)) {
		readFile(fht, Ps, Vw.FOff, Vw.Tlen);
		*(Ps + Vw.Tlen) = 0;
	} else {
		*Ps = 0;
	}

}

/*---------------------------------------------------------------------------*/

static void AppendText(Ps, Num)
	char *Ps;word Num;

/*F
 **.* Beschreibung :
 **
 **      Die Funktion l�dt die angegebene Textnummer.
 **
 **.* Funktionswerte :
 **
 */

{
	struct TxtbS Vw;

	Ps = Ps + strlen(Ps);
	if (GetTextVW(Num, &Vw)) {
		readFile(fht, Ps, Vw.FOff, Vw.Tlen);
		*(Ps + Vw.Tlen) = 0;
	} else {
		*Ps = 0;
	}

}

/******************************************************************************/

static void FreeMem()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion gibt alle allocierten Pointer frei, die im Laufe
 **	der Uebersetzung angefordert wurden.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (SortParam) {
		free(SortParam);
	}

	if (KpfBst) {
		free(KpfBst);
	}

	while (MemPtrAnz) {
		MemPtrAnz--;
		free(MemPtr[MemPtrAnz]);
	}

}

/******************************************************************************/

static void SysExit()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion beendet das laufende Programm
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{

	FreeMem();
	fcloseall();
	close(fht);
	exit(1);

}

/******************************************************************************/

static word SegAddi(Seg, Off)
	word Seg, Off;

{

	if (Off) {
		if (Off & 0x000F) {
			Off = Off & 0xFFF0;
			Off = Off + 0x0010;
		}
		Off = Off >> 4; /* Segmentoffset		*/
		Seg = Seg + Off; /* addieren			*/
	}
	return (Seg);

}

/******************************************************************************/

static void inAfz(AfStr, String)
	char *AfStr; /* String, der in Anfuehrungszeichen gesetzt	*/
	char *String; /* wird und an String angehaengt wird		*/

/*F
 **.* Beschreibung :
 **
 **	Die Funktion haengt den String 'AfStr' an 'String' an und
 **	setzt ihn in Anfuehrungszeichen.
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{

	strcat(String, "\042");
	strcat(String, AfStr);
	strcat(String, "\042");

}

/******************************************************************************/

static word GetModInf3(word MHd, word item)

{
	char *P;
	word ret;

	P = "V0";
	switch (MHd) {
	case AR20i:
	case SP20i:
		switch (AR20Mode) {
		case 0:
			P = "V4";
			break;
		case 1:
			P = "V5";
			break;
		default:
			RunError(4, NULL);
		}
		break;

	case AR11i:
		if (ExtAdress)
			P = "V38";
		break;
	case MB11i:
		if (ExtAdress)
			P = "V33";
		break;
	case SP11i:
		if (ExtAdress)
			P = "V35";
		break;
	}
	ret = GetModInf2(MHd, P, item);
	return (ret);

}

/******************************************************************************/

static
char *LanFiles[] = { "fmicger", "fmiceng" };
//	"fmicfra", "fmicfin","fmicnld", "fmicita",
//	"fmicnor", "fmicesp","fmicesn", "fmicsve"};
#define	LanFanz	(sizeof(LanFiles)/sizeof(char*))

static void DispSyntax()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion gibt die moeglichen Switches aus.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char **Nam;
	word i, n;
	char HStr[80];

	GetText(HStr, 101);
	sprintf(ListZl, "\015\012%s\015\012", HStr);
	strout(ListZl);
	GetText(ListZl, 102);
	strcat(ListZl, "\015\012\012");
	strout(ListZl);
	GetText(ListZl, 103);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 104);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 105);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 106);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 107);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 108);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 109);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 110);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 112);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 113);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 114);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 115);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 116);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	GetText(ListZl, 118);
	strcat(ListZl, "\015\012");
	strout(ListZl);
	Nam = LanFiles;
	for (i = 1; i <= LanFanz; i++, Nam++) {
		strcpy(HStr, *Nam);
		strcat(HStr, ".txb");
		if (i != LanFanz)
			strcat(HStr, ", ");
		if (i % 5 == 0)
			strcat(HStr, "\015\012");
		strout(HStr);
	}

}

/******************************************************************************/

static void RunError(Nr, ZStr)
	word Nr;char *ZStr;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion gibt eien der uebergebenen Nummer entsprechende
 **	Fehlermeldung aus und beendet das Programm.
 **
 **.* Funktionswerte :
 **
 **	keine
 */

{
	char HStr[200];
	char FStr[20];

	sprintf(ListZl, "\007");
	strout(ListZl);
	switch (Nr) {
	case 1:
		GetText(HStr, 120);
		strcat(HStr, "\015\012");
		DispSyntax();
		strcpy(ListZl, HStr);
		break;
	case 2:
		GetText(HStr, 121);
		strcat(HStr, ZStr);
		AppendText(HStr, 119);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 3:
		GetText(HStr, 122);
		sprintf(FStr, "%3d: ", QZeile);
		strcat(HStr, FStr);
		AppendText(HStr, 123);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 4:
		GetText(HStr, 230);
		sprintf(ListZl, "%s %s, %s\015\012", HStr, ARV1, ARV2);
		break;
	case 5:
		GetText(HStr, 124);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 6:
		GetText(HStr, 121);
		strcat(HStr, ZStr);
		AppendText(HStr, 125);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 7:
		GetText(HStr, 126);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 9:
		GetText(HStr, 128);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 11:
		GetText(ListZl, 228);
		sprintf(FStr, "%d", ModMax);
		strcat(ListZl, FStr);
		AppendText(ListZl, 129);
		break;
	case 12:
		GetText(HStr, 130);
		sprintf(FStr, "%d", WKMax);
		strcat(HStr, FStr);
		sprintf(ListZl, "%s)\015\012", HStr);
		break;
	case 13:
		sprintf(HStr, "\042%s\042", ZStr);
		AppendText(HStr, 131);
		strcat(HStr, "\015\012");
		DispSyntax();
		strcpy(ListZl, HStr);
		break;
	case 14:
		GetText(HStr, 122);
		sprintf(FStr, "%3d: ", QZeile);
		strcat(HStr, FStr);
		sprintf(FStr, "\042%s\042", ZStr);
		strcat(HStr, FStr);
		AppendText(HStr, 133);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	case 15:
		GetText(HStr, 134);
		sprintf(FStr, "%d", FKMax);
		strcat(HStr, FStr);
		sprintf(ListZl, "%s)\015\012", HStr);
		break;
	case 16:
		GetText(HStr, 122);
		sprintf(FStr, "%3d: ", QZeile);
		strcat(HStr, FStr);
		AppendText(HStr, 135);
		sprintf(FStr, "%d", MaxZLen - 1);
		strcat(HStr, FStr);
		AppendText(HStr, 132);
		sprintf(ListZl, "%s\015\012", HStr);
		break;
	default:
		return;

	}
	strout(ListZl);
	if (Errorfile)
		fprintf(Errorfile, "%s\015\012", ListZl);
	SysExit();

}

/******************************************************************************/

static void AsmError(Nr, ZStr)
	word Nr;char *ZStr;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion gibt eine der 'Nr' entsprechende Fehlermeldung
 **	aus und zaehl eine Fehlervariable hoch.
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	char local[250];
	char FStr[20];
	Typ Tp;
	word msk, hw;
	short i, f1;

	GetText(local, 140);
	sprintf(FStr, "%2d", Nr);
	strcat(local, FStr);
	AppendText(local, 136);
	sprintf(FStr, "%3d:\t", QZeile);
	strcat(local, FStr);
	switch (Nr) {

	case 1:
		inAfz(ZStr, local);
		AppendText(local, 141);
		break;
	case 2:
		inAfz(ZStr, local);
		AppendText(local, 142);
		for (i = 0; i < AbsMax; i++) {
			if (i == (AbsMax - 1)) {
				AppendText(local, 144);
			} else {
				if ((i & 3) == 3) {
					AppendText(local, 222);
				}
			}
			inAfz(Abstrg[i], local);
			if (i < (AbsMax - 2)) {
				strcat(local, ",");
			}
		}
		strcat(local, ")");
		break;
	case 3:
		AppendText(local, 145);
		break;
	case 4:
		AppendText(local, 146);
		break;
	case 5:
		AppendText(local, 147);
		break;
	case 6:
		inAfz(ZStr, local);
		AppendText(local, 148);
		break;
	case 7:
		inAfz(ZStr, local);
		AppendText(local, 150);
		break;
	case 8:
		inAfz(ZStr, local);
		AppendText(local, 151);
		break;
	case 9:
		AppendText(local, 152);
		break;
	case 10:
		AppendText(local, 153);
		sprintf(FStr, "%d", ModNr);
		strcat(local, FStr);
		AppendText(local, 154);
		break;
	case 11:
		AppendText(local, 155);
		break;
	case 12:
		AppendText(local, 156);
		break;
	case 13:
		AppendText(local, 157);
		sprintf(FStr, "(%d ms)!", Zykst);
		strcat(local, FStr);
		break;
	case 14:
		inAfz(ZStr, local);
		AppendText(local, 160);
		break;
	case 15:
		inAfz(ZStr, local);
		AppendText(local, 161);
		break;
	case 16:
		AppendText(local, 162);
		inAfz(BauNam, local);
		AppendText(local, 163);
		break;
	case 17:
		inAfz(ZStr, local);
		AppendText(local, 164);
		break;
	case 18:
		AppendText(local, 162);
		inAfz(BauNam, local);
		AppendText(local, 165);
		break;
	case 19:
		AppendText(local, 166);
		hw = GetModInfo(ModHnd, MOD_zykhg, NULL);
		sprintf(FStr, "%d", hw);
		strcat(local, FStr);
		AppendText(local, 169);
		break;
	case 20:
		inAfz(ZStr, local);
		AppendText(local, 167);
		break;
	case 21:
		inAfz(ZStr, local);
		AppendText(local, 168);
		break;
	case 22:
		AppendText(local, 170);
		break;
	case 23:
		inAfz(ZStr, local);
		AppendText(local, 171);
		break;
	case 24:
		inAfz(ZStr, local);
		AppendText(local, 172);
		break;
	case 25:
		inAfz(ZStr, local);
		AppendText(local, 173);
		break;
	case 26:
		AppendText(local, 174);
		sprintf(FStr, "%d", ModMinNr);
		strcat(local, FStr);
		AppendText(local, 178);
		sprintf(FStr, "%d", ModMaxNr);
		strcat(local, FStr), AppendText(local, 175);
		break;
	case 27:
		inAfz(ZStr, local);
		AppendText(local, 176);
		break;
	case 28:
		AppendText(local, 162);
		inAfz(BauNam, local);
		AppendText(local, 177);
		sprintf(FStr, "%d", GlAnz);
		strcat(local, FStr);
		AppendText(local, 179);
		sprintf(FStr, "%d)!", GlSoll);
		strcat(local, FStr);
		break;
	case 29:
		AppendText(local, 180);
		break;
	case 30:
		AppendText(local, 181);
		break;
	case 31:
		AppendText(local, 182);
		break;
	case 32:
		AppendText(local, 183);
		break;
	case 33:
		inAfz(ZStr, local);
		AppendText(local, 184);
		break;
	case 34:
		AppendText(local, 185);
		break;
	case 35:
		AppendText(local, 186);
		break;
	case 36:
		AppendText(local, 187);
		break;

	case 37:
		AppendText(local, 162);
		strcat(local, ZStr);
		AppendText(local, 188);
		strcat(local, ModTyp);
		AppendText(local, 189);
		break;

	case 38:
		AppendText(local, 190);
		break;
	case 39:
		AppendText(local, 191);
		break;
	case 40:
		inAfz(ZStr, local);
		AppendText(local, 192);
		break;
	case 41:
		AppendText(local, 193);
		break;
	case 42:
		inAfz(ZStr, local);
		AppendText(local, 194);
		break;
	case 43:
		inAfz(ZStr, local);
		AppendText(local, 195);
		break;
	case 44:
		inAfz(ZStr, local);
		AppendText(local, 196);
		break;
	case 45:
		inAfz(ZStr, local);
		AppendText(local, 197);
		break;
	case 46:
		inAfz(ZStr, local);
		AppendText(local, 198);
		break;
	case 47:
		AppendText(local, 199);
		strcat(local, ModTyp);
		AppendText(local, 200);
		hw = GetModInfo(ModHnd, MOD_tsmax, NULL);
		sprintf(FStr, "%d", hw);
		strcat(local, FStr);
		AppendText(local, 201);
		break;
	case 48:
		AppendText(local, 202);
		break;
	case 49:
		AppendText(local, 203);
		break;
	case 50:
		AppendText(local, 211);
		inAfz(ZStr, local);
		AppendText(local, 212);
		msk = 1;
		f1 = 0;
		for (i = 0; i < TypMax; i++) {
			if (*aTyp & msk) {
				if (f1) {
					strcat(local, ", ");
				}
				if (i != (TypMax - 1) && (f1 & 3) == 3) {
					AppendText(local, 222);
				}
				strcat(local, Typen[i]);
				f1++;
			}
			msk <<= 1;
		}
		break;
	case 51:
		AppendText(local, 220);
		break;
	case 52:
		AppendText(local, 127);
		strcat(local, ModTyp);
		hw = GetModInf3(ModHnd, MOD_clmax);
		sprintf(FStr, "! (%u byte)\015\012", hw);
		strcat(local, FStr);
		break;
	case 53:
		AppendText(local, 205);
		strcat(local, ModTyp);
		AppendText(local, 189);
		break;
	case 54:
		AppendText(local, 231);
		strcat(local, ModTyp);
		break;
	case 55:
		AppendText(local, 232);
		AppendText(local, 233);
		AppendText(local, 234);
		strcat(local, ModTyp);
		break;
	case 56:
		AppendText(local, 232);
		AppendText(local, 234);
		strcat(local, ModTyp);
		break;
	default:
		return;

	}

	sprintf(ListZl, "%s\015\012", local);
	strout(ListZl);
	fprintf(Errorfile, "%s\015\012", local);
	Error++;

}

/******************************************************************************/

static void AsmWarning(Nr, ZStr)
	word Nr;char *ZStr;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion gibt eine der 'Nr' entsprechende Warnung
 **	aus und zaehl eine Warnvariable hoch.
 **
 */

{
	char local[250];
	char HStr[20], FStr[20];
	word msk, hw;
	short i, f1;

	if (Nowflag)
		return;

	GetText(local, 210);
	sprintf(FStr, "%1d", Nr);
	strcat(local, FStr);
	AppendText(local, 136);
	sprintf(FStr, "%3d:\t", QZeile);
	strcat(local, FStr);
	switch (Nr) {

	case 1:
		AppendText(local, 211);
		inAfz(ZStr, local);
		AppendText(local, 212);
		msk = 1;
		f1 = 0;
		for (i = 0; i < TypMax; i++) {
			if (*aTyp & msk) {
				if (f1) {
					strcat(local, ", ");
				}
				if (i != (TypMax - 1) && (f1 & 3) == 3) {
					AppendText(local, 222);
				}
				strcat(local, Typen[i]);
				f1++;
			}
			msk <<= 1;
		}
		break;
	case 2:
		AppendText(local, 213);
		inAfz(ZStr, local);
		AppendText(local, 214);
		break;
	case 3:
		AppendText(local, 211);
		inAfz(ZStr, local);
		AppendText(local, 215);
		break;
	case 4:
		AppendText(local, 216);
		sprintf(FStr, "%d ms", Tlaufz);
		strcat(local, FStr);
		AppendText(local, 221);
		sprintf(FStr, "%d ms)!", TskZyk);
		strcat(local, FStr);
		break;
	case 5:
		AppendText(local, 217);
		sprintf(FStr, "%s%%!", ZStr);
		strcat(local, FStr);
		break;
	case 6:
		AppendText(local, 218);
		strcat(local, ModTyp);
		AppendText(local, 219);
		break;
	default:
		return;

	}

	sprintf(ListZl, "%s\015\012", local);
	strout(ListZl);
	fprintf(Errorfile, "%s\015\012", local);
	Warning++;

}

/******************************************************************************/

static void detab(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ersetzt alle Tabs in Str durch die entsprechende
 **	Anzahl von Blanks.
 **
 */

{
	char local[100], *P;
	register
	short i, j;
	short k, l, n;
	char c;

	strcpy(local, Str);
	l = strlen(Str);
	j = 0;
	P = local;

	for (i = 0; i < l; i++) {
		c = *P++;
		if (c == Tabchr) {
			n = 8 - (j % 8);
			for (k = 0; k < n; k++) {
				*Str++ = ' ';
				j++;
			}
		} else {
			*Str++ = c;
			j++;
		}
	}

	*Str = 0;

}

/******************************************************************************/

static void ListCr(String)
	char *String;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion schreibt den uebergebenen String ins Listing-File,
 **	zaehlt die Zeilen mit und gibt bei Bedarf einen neuen Kopf aus.
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	char HStr[50];

	if (Zeile >= LZeilMax || Seite == 0) {
		if (Seite)
			fprintf(Listing, "\014");
		Seite++;
		GetText(HStr, 100);
		strcat(HStr, Version);
		fprintf(Listing, "\t\t\t\t\t- %d -\015\012\015\012", Seite);
		fprintf(Listing, "%s      %s.LST\015\012", HStr, PName);
		fprintf(Listing, "Hardware: %s, Modul %2d\t\t\t  %s\015\012\015\012",
				ModTyp, ModNr, Datum);
		Zeile = 5;
	}

	Zeile++;
	detab(String);
	fprintf(Listing, "%s\015\012", String);

}

/******************************************************************************/

static void KonZwiCr(String)
	char *String;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion schreibt den uebergebenen String ins KUZ-File,
 **	zaehlt die Zeilen mit und gibt bei Bedarf einen neuen Kopf aus.
 **
 **.* Funktionswerte :
 **
 **	keine
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	char HStr[50];
	word dseg;

	if (Seite == 0) {
		dseg = GetModInf3(ModHnd, MOD_dtseg);
		Seite++;
		GetText(HStr, 100);
		strcat(HStr, Version);
		fprintf(KonZwi, "\t\t\t\t\t- %d -\015\012\015\012", Seite);
		fprintf(KonZwi, "%s      %s.KUZ\015\012", HStr, PName);
		fprintf(KonZwi,
				"Hardware: %s, Modul %2d   Segment: %04X\t  %s\015\012",
				ModTyp, ModNr, dseg, Datum);
		fprintf(KonZwi,
				"\015\012  Parameter-Typ   Adresse 1.Wert   Anzahl\015\012");
		fprintf(KonZwi, "---------------------------------------------\015\012");
		fprintf(KonZwi, "      %s          %04X:%04X       %d\015\012",
				Typen[WortK], dseg, WKOff, WKanz);
		fprintf(KonZwi, "      %s         %04X:%04X       %d\015\012",
				Typen[RealK], dseg, FKOff, FKanz);
		fprintf(KonZwi, "      %s          %04X:%04X       %d\015\012",
				Typen[WortZ], dseg, WZOff, WZanz);
		fprintf(KonZwi, "      %s         %04X:%04X       %d\015\012",
				Typen[RealZ], dseg, FZOff, FZanz);
		fprintf(KonZwi, "\015\012Vergangenheitswerte von ");
		fprintf(KonZwi, "%04X:%04X bis %04X:%04X\015\012", dseg, FinOff, dseg,
				VwOff);
		fprintf(KonZwi, "\015\012\015\012  S y m b o l\t\t\tT y p");
		fprintf(KonZwi, "     Offset        W e r t         \015\012");
		fprintf(KonZwi, "------------------------------------");
		fprintf(KonZwi, "-----------------------------------\015\012");
		Zeile = 16;
	}

	Zeile++;
	detab(String);
	fprintf(KonZwi, "%s\015\012", String);

	if (Zeile >= LZeilMax) {
		fprintf(KonZwi, "\014");
		Seite++;
		fprintf(KonZwi, "\t\t\t\t\t- %d -\015\012\015\012", Seite);
		fprintf(KonZwi, "  S y m b o l\t\t\tT y p");
		fprintf(KonZwi, "     Offset        W e r t         \015\012");
		fprintf(KonZwi, "------------------------------------");
		fprintf(KonZwi, "-----------------------------------\015\012");
		Zeile = 4;
	}

}

/******************************************************************************/

static FILE *OpenFile(GNam, Exs, Opt, Eflag)
	char *GNam, *Exs, *Opt;short Eflag;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion eroeffnet eine Datei, die sich aus dem Quellfile-
 **	namen und der angegebenen Extention 'Exs' ergibt mit der Option
 **	'Opt'. Falls 'Eflag' ungleich 0 ist wird die Modulnummer in die
 **	letzten 2 Zeichen der Extention eingetragen.
 **
 **.* Funktionswerte :
 **
 **	FILE Pointer, generierten Namen in GNam
 **
 */

{
	char Ext[6];
	char Mod[4];
	FILE *fp;
	char Z;

	Z = toupper(*Opt);
	strcpy(GNam, Dir);
	strcpy(Ext, Exs);
	Dezcb(Mod, ModNr);

	if (strcmp(Ext, ".ERR") && strcmp(Ext, ".UDF") && ModNr) {
		if (Z == 'W') {
			if (Eflag) {
				strcpy(&Ext[2], Mod);
			} else {
				strcat(GNam, "29");
				strcat(GNam, ModTyp);
				strcat(GNam, Mod);
				strcat(GNam, "\\");
			}
		}
	}

	strcat(GNam, PName);
	strcat(GNam, Ext);
	fp = fopen(GNam, Opt);
	if (fp == NULL) {
		if (Z == 'R') {
			RunError(2, GNam);
		} else {
			RunError(6, GNam);
		}
	}

	return (fp);

}

/******************************************************************************/

static void GetOptions(Opt)
	char *Opt;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion scannt die Optionsangaben und aktualisiert die
 **	entsprechenden Flags.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *S, *P, *token;

#ifdef	VAX
	OneDir++; /* auf VAX keine Modconf-Struktur!	*/
#endif

	UppCase++;
	if (Opt == NULL) {
		return;
	}

	strupr(Opt);
	S = Opt;

	for (;;) {
		token = strtok(S, " -\011");
		if (token == NULL)
			break;
		S = NULL;

		if (*token == 'M') {
			if (ModNri >= ModMax) {
				RunError(11, NULL);
			}
			ModNra[ModNri++] = atoi(token + 1);
			continue;
		}

		if ((P = strstr(token, "I=")) == token) {
			Incflag++;
			strcpy(ListZl, P + 2);
			if (strchr(ListZl, '.') == NULL) {
				strcat(ListZl, ".INC");
			}
			Input = fopen(ListZl, "rt");
			if (Input == NULL) {
				RunError(2, ListZl);
			}
			continue;
		}

		if (strcmpi(token, "NOW") == 0) {
			Nowflag++;
			continue;
		}

		if (strcmpi(token, "UDF") == 0) {
			udfFlag++;
			continue;
		}

		if (strcmpi(token, "LIS") == 0) {
			Lflag++;
			continue;
		}

		if (strcmpi(token, "OD") == 0) {
			OneDir++;
			continue;
		}

		if (strcmpi(token, "CS") == 0) {
			UppCase = 0;
			continue;
		}

		if (strcmpi(token, ARV1) == 0) {
			AR20Mode = 0;
			continue;
		}

		if (strcmpi(token, ARV2) == 0) {
			AR20Mode = 1;
			continue;
		}

		if (strcmpi(token, "KROM") == 0) {
			AR20Konst = 1;
			continue;
		}

		if (strcmpi(token, "EA") == 0) {
			ExtAdress = 1;
			continue;
		}

		RunError(13, token); /* unbekannter Switch			*/
	}

}

/******************************************************************************/

static void GetModTyp(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion wandelt den in Str enthaltenen Typ in einen
 **	Index um, der sich auf die ModulTypen-Tabelle bezieht.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char HStr[20];

	strcpy(HStr, Str);
	strupr(HStr);
	ModHnd = GetModHandle(HStr);
	HStr[0] = ModTyp[0] = 0;
	if (ModHnd)
		GetModInfo(ModHnd, MOD_modul, HStr);
	else
		RunError(14, Str);
	if (HStr[0])
		strcpy(ModTyp, &HStr[2]);

}

/******************************************************************************/

static short notZifW(String)
	char *String;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ueberprueft, ob der String nur Ziffern enthaelt.
 **
 **.* Funktionswerte :
 **
 **	0 nur Ziffern, 1 auch andere Zeichen.
 */

{

	while (*String) {
		if (not(isdigit(*String++))) {
			return (1);
		}
	}

	return (0);

}

/******************************************************************************/

static short notHexW(String)
	char *String;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ueberprueft, ob der String nur Hez-Ziffern enthaelt.
 **
 **.* Funktionswerte :
 **
 **	0 nur Ziffern, 1 auch andere Zeichen.
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{

	while (*String) {
		if (not(isxdigit(*String++))) {
			return (1);
		}
	}

	return (0);

}

/******************************************************************************/

static long FlVal(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert den in 'Str' enthaltenen Float-Wert
 **
 **.* Funktionswerte :
 **
 **	gewandelter Wert
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	long Wert;

	Wert = f_atof(Str);
	if (f_nan(Wert)) {
		AsmError(21, Str);
	}
	return (Wert);

}

/******************************************************************************/

static word WdVal(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert den in 'Str' enthaltenen Wert
 **	(sowohl hexa- als auch dezimal).
 **
 **.* Funktionswerte :
 **
 **	gewandelter Wert
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	short l;
	word Wert;

	l = strlen(Str) - 1;
	if (Str[l] == 'H') {
		Str[l] = 0;
		Wert = 0;
		if (notHexW(Str)) {
			AsmError(33, Str);
		}
		sscanf(Str, "%x", &Wert);
	} else {
		if (notZifW(Str)) {
			AsmError(8, Str);
		}
		Wert = atoi(Str);
	}

	return (Wert);

}

/******************************************************************************/

static word FgVal(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert den in 'Str' enthaltenen Wert von Zeile
 **	und Spalte.
 **
 **.* Funktionswerte :
 **
 **	gewandelter Wert
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	char *token;
	word Wert;
	word Zeil, Spalt;

	token = strtok(Str, " ,\011");
	if (notZifW(token)) {
		AsmError(8, Str);
	}

	Zeil = atoi(token);
	if (Zeil > 255) {
		AsmError(29, NULL);
	}

	token = strtok(NULL, " ,\011");
	if (token) {
		if (notZifW(token)) {
			AsmError(8, Str);
		}

		Spalt = atoi(token);
		if (Spalt > 15) {
			AsmError(22, NULL);
		}
	} else {
		Spalt = 0;
	}

	Wert = Zeil + (Spalt << 8);
	return (Wert);

}

/******************************************************************************/

static void GetDatum(String)
	char *String;

{

#ifdef	VAX

	strcpy (String, "Freitag    11.11.88  11:11");

#else

	time_t ltime;
	struct tm *ntime;
	unsigned char c;
	char Zeit[6];
	char Datm[10];

	time(&ltime);
	ntime = localtime(&ltime);

	switch (ntime->tm_wday) {

	case 0:
		strcpy(String, "Sonntag   ");
		break;
	case 1:
		strcpy(String, "Montag    ");
		break;
	case 2:
		strcpy(String, "Dienstag  ");
		break;
	case 3:
		strcpy(String, "Mittwoch  ");
		break;
	case 4:
		strcpy(String, "Donnerstag");
		break;
	case 5:
		strcpy(String, "Freitag   ");
		break;
	case 6:
		strcpy(String, "Samstag   ");
		break;
	}

	c = ntime->tm_mday;
	Dezcb(&Datm[0], c);
	Datm[2] = '.';
	c = ntime->tm_mon + 1;
	Dezcb(&Datm[3], c);
	Datm[5] = '.';
	c = ntime->tm_year;
	Dezcb(&Datm[6], c);
	c = ntime->tm_hour;
	Dezcb(&Zeit[0], c);
	Zeit[2] = ':';
	c = ntime->tm_min;
	Dezcb(&Zeit[3], c);

	sprintf(String + strlen(String), " %s  %s", Datm, Zeit);
#endif

}

/******************************************************************************/

static char *GetMemory()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert den naechsten Pointer auf einen
 **	Speicherbereich der Groesse SymBlockSize. Falls dies
 **	nicht mehr moeglich ist, aufgrund von Speicheplatzmangel
 **	oder erschoepfter Pointertabelle, so wird das Programm
 **	abgebrochen.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *P;

	SymSize = 0;
	if (MemPtri < MemPtrAnz) {
		P = MemPtr[MemPtri++];
	} else {
		if (MemPtrAnz >= MemPtrMax) {
			RunError(7, NULL);
		}
		if ((P = malloc(SymBlockSize + 128)) == NULL) {
			RunError(5, NULL);
		}
		MemPtr[MemPtrAnz++] = P;
		MemPtri = MemPtrAnz;
	}
	return (P);

}

/******************************************************************************/

static BstDef *GetBstNum(BNum)
	word BNum;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert eien Pointer auf die Bausteinbeschreibung des
 **	angegebenen BausteinTyps.
 **
 **.* Funktionswerte :
 **
 **	Pointer, oder NULL
 **
 */

{
	BstDef *B;
	word i;

	B = BS;
	for (i = 0; i < BanzMax; i++) {
		if (B->BNr == BNum) {
			return (B);
		}
		B++;
	}

	return (NULL);

}

/******************************************************************************/

static BstDef *GetBstNam(Baustein)
	char *Baustein;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert den Index auf die Bausteintabelle des
 **	angegebenen Bausteinnamens.
 **
 **.* Funktionswerte :
 **
 **	Index oder -1 wenn nicht gefunden.
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	BstDef *B;
	register
	short i;

	B = BS;
	for (i = 0; i < BanzMax; i++) {
		if (strcmpi(Baustein, B->BName) == 0) {
			return (B);
		}
		B++;
	}

	return (NULL);

}

/******************************************************************************/

static char *GetSymbol(Offset)
	word Offset;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert zu dem uebergebenen Offset das entsprechende
 **	Symbol. Falls der Wert nicht gefunden wird NULL zurueckgegeben.
 **
 **.* Funktionswerte :
 **
 **	Pointer auf Symbol, oder NULL
 **
 */

{
	SortPm *SortSym;
	short Ve;
	word A, B, i, ia;

	SortSym = SortParam;
	if (ParamAnz == 1) {
		return (SortSym->Sym->SN);
	}
	A = 0;
	B = ParamAnz;
	ia = 0;
	i = (A + B) >> 1;

	while (i != ia) {
		SortSym = SortParam + i;
		Ve = Offset - SortSym->Sym->Off;
		if (Ve == 0) {
			return (SortSym->Sym->SN);
		}
		if (Ve > 0) {
			A = i;
		} else {
			B = i;
		}
		ia = i;
		i = (A + B) >> 1;
	}

	return (NULL);

}

/******************************************************************************/

static SymDef *GetParaDes(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert zu dem uebergebenen Symbol den Pointer auf
 **	die Parameterbeschreibung. Falls der Wert nicht gefunden wird
 **	NULL zurueckgegeben.
 **
 **.* Funktionswerte :
 **
 **	Pointer oder NULL
 **
 */

{
	SortPm *SortSym;
	short Ve;
	word A, B, i, ia;

	SortSym = SortParam;
	if (ParamAnz == 1) {
		return (SortSym->Sym);
	}
	A = 0;
	B = ParamAnz;
	ia = 0;
	i = (A + B) >> 1;

	while (i != ia) {
		SortSym = SortParam + i;
		Ve = strcmp(Str, SortSym->Sym->SN);
		if (Ve == 0) {
			SortSym->Sym->T = SortSym->Sym->T | use_b;
			return (SortSym->Sym);
		}
		if (Ve > 0) {
			A = i;
		} else {
			B = i;
		}
		ia = i;
		i = (A + B) >> 1;
	}

	return (NULL);

}

/******************************************************************************/

static void AddudfPara(Sym, Tp)
	char *Sym;Typ *Tp;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion traegt das angegebene Symbol mit Typenbeschreibung
 **	in die verpointerte Liste ein.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *P;
	short dSym, lastSize;
	int i;
	SymDef *udfSym;

	if (udfFlag == 0)
		return;

	udfSym = udfParams;
	for (i = 0; i < udfParaAnz; i++) {
		if (strcmp(udfSym->SN, Sym) == 0)
			return;
		udfSym = udfSym->Next;
	}
	dSym = strlen(Sym) + 1;
	udfSymSize += sizeof(SymDef) + dSym;
	if (udfParaAnz) {
		lastSize = sizeof(SymDef) + 1 + strlen(lastudfPara->SN);
	} else {
		lastSize = 0;
	}
	if (udfSymSize > (SymBlockSize - lastSize) || udfParams == NULL) {
		P = GetMemory();
		if (udfParams == NULL) {
			udfParams = (SymDef*) P;
			lastudfPara = udfParams;
		}
	} else {
		P = (char*) lastudfPara;
		if (udfParaAnz) {
			P += lastSize;
		}
	}
	lastudfPara->Next = (SymDef*) P;
	lastudfPara = (SymDef*) P;
	udfParaAnz++;

	P += sizeof(SymDef);
	lastudfPara->SN = P;
	strcpy(P, Sym);
	lastudfPara->T = *Tp;

}

/******************************************************************************/

static void AddParam(Sym, Typi)
	char *Sym;short Typi;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion traegt das angegebene Symbol mit Typenbeschreibung
 **	in die verpointerte Liste ein.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *P;
	short dSym, lastSize;

	dSym = strlen(Sym) + 1;
	SymSize += sizeof(SymDef) + dSym;
	if (ParamAnz) {
		lastSize = sizeof(SymDef) + 1 + strlen(lastParam->SN);
	} else {
		lastSize = 0;
	}

	// Change 18.12
	//if (SymSize > (SymBlockSize - lastSize))
	if (SymSize > SymBlockSize) {
		P = GetMemory();
	} else {
		P = (char*) lastParam;
		if (ParamAnz) {
			P += lastSize;
		}
	}
	lastParam->Next = (SymDef*) P;
	lastParam = (SymDef*) P;
	ParamAnz++;

	P += sizeof(SymDef);
	lastParam->SN = P;
	strcpy(P, Sym);
	MovTyp(&lastParam->T, Typi);
	if (firstMod) {
		lastParam->T = lastParam->T | gbl_b;
	}

	switch (Typa) {

	case WortZ:
		WZanz++;
		break;
	case RealZ:
		FZanz++;
		break;
	}

}

/******************************************************************************/

/*T*/
static int VglSym(El1, El2)
	SortPm *El1, *El2;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion dient zum Vergleich der beiden Symbole, die durch
 **	El1 und El2 referenziert werden koennen.
 **
 **.* Funktionswerte :
 **
 **	0 bei Gleichheit, > oder < 0 bei Ungleichheit
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	return (strcmp(El1->Sym->SN, El2->Sym->SN));
}

/******************************************************************************/

/*T*/
static int VglOff(El1, El2)
	SortPm *El1, *El2;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion dient zum Vergleich der beiden Offsets, die durch
 **	El1 und El2 referenziert werden koennen.
 **
 **.* Funktionswerte :
 **
 **	0 bei Gleichheit, > oder < 0 bei Ungleichheit
 **
 **.* Besondere Hinweise :
 **
 **	keine
 **
 */

{
	return (El1->Sym->Off - El2->Sym->Off);
}

/******************************************************************************/

static void firstTask()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion fuehrt alle Aktivitaeten aus, die nach Erscheinen
 **	der 1. Taskanweisung notwendig sind. Dies sind:
 **	1. Festlegung der Offsetgrenzen fuer Parametertypen
 **	2. Vergabe des Offsets fuer jeden Parameter
 **	3. Sortierung der Parametersymbole in extra Array, fuer
 **	schnelleren Zugriff bei Uebersetzung und fuer Ausgabe
 **	der Debug-Informationen.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word WKOffa, WZOffa, kflag;
	word FKOffa, FZOffa, i, hw;
	SortPm *SortSym;
	SymDef *ParaDes;
	short PTyp;

	/*	Festlegung der Offsetgrenzen fuer Parametertypen	*/
	kflag = 0;
	if ((ModHnd == AR20i || ModHnd == SP20i) && AR20Mode == 1 && AR20Konst)
		kflag++;

	WKOff = KonSize = Offsets * sizeof(word);
	if (kflag) {
		hw = GetModInf3(ModHnd, MOD_dtseg);
		i = GetModInf3(ModHnd, MOD_stseg);
		WKOff = WKOff + ((i - hw) << 4);
	}
	hw = WKanz * sizeof(word);
	KonSize = KonSize + hw;
	FKOff = WKOff + hw;
	OVersatz (FKOff);
	OVersatz (KonSize);

	if (kflag)
		WZOff = Offsets * sizeof(word);
	else
		WZOff = FKOff + FKanz * sizeof(long);
	OVersatz (WZOff);
	KonSize = KonSize + FKanz * sizeof(long);
	OVersatz (KonSize);

	FZOff = WZOff + WZanz * sizeof(word);
	OVersatz (FZOff);

	FinOff = FZOff + FZanz * sizeof(long);
	OVersatz (FinOff);
	VwOff = FinOff + GetModInfo(ModHnd, MOD_offt1, NULL);

	/*  Eintragen der Offsetgrenzen in Wort-Array			*/
	*(WKonst + 0) = WKOff;
	*(WKonst + 1) = FKOff;
	*(WKonst + 2) = WZOff;
	*(WKonst + 3) = FZOff;
	*(WKonst + 4) = FinOff;
	WZOffa = WZOff;
	FZOffa = FZOff;
	WKOffa = WKOff;
	FKOffa = FKOff;

	SortParam = (SortPm*) malloc(ParamAnz * sizeof(SortPm));
	if (SortParam == NULL) {
		RunError(5, NULL);
	}

	ParaDes = Params;
	SortSym = SortParam;
	for (i = 0; i < ParamAnz; i++) {
		PTyp = GetTypSInd(&ParaDes->T);
		switch (PTyp) {
		case WortZ:
			ParaDes->Off = WZOffa;
			WZOffa += sizeof(word);
			break;
		case WortK:
		case IpaZw:
		case IpaMl:
		case IpaAw:
		case IpaMw:
			ParaDes->Off = WKOffa;
			WKOffa += sizeof(word);
			break;
		case RealZ:
			ParaDes->Off = FZOffa;
			FZOffa += sizeof(long);
			break;
		case RealK:
			ParaDes->Off = FKOffa;
			FKOffa += sizeof(long);
			break;
		default:
			RunError(9, NULL);

		}
		SortSym->Sym = ParaDes;
		ParaDes = ParaDes->Next;
		SortSym++;
	}
	qsort(SortParam, ParamAnz, sizeof(SortPm), VglSym);

	/*
	 SortSym = SortParam;
	 for
	 ( i=0; i<ParamAnz; i++ )
	 {
	 SortSym->Ind = i;
	 SortSym++;
	 }
	 */
}

/******************************************************************************/

static void GenH86File()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion generiert das ladbare Hex-Intel-File aus den
 **	gesammelten Uebersetzungsdaten. (Konstanten, Kopfbaustein und
 **	Micas-Zwischencode)
 **
 **.* Funktionswerte :
 **
 **
 */

{
	register
	short i, j, n;
	word *wp, Sum;
	word hw, oseg, dseg;

	OutH86 = OpenFile(FName, ".H86", "wb", Dirflag);
	strout(FName);
	/* Pruefsumme ueber Taskzwischencode ...		*/
	Sum = 0;
	for (i = 0; i < Tanz; i++) {
		wp = TaBeg[i];
		n = TaWAnz[i];
		for (j = 0; j < n; j++) {
			Sum = Sum + *wp++;
		}
	}

	// ... und Kopfbaustein bilden
	/*
	 wp = KpfBst;
	 for
	 ( j=0; j<Kpflen; j++ )
	 {
	 Sum = Sum + *wp++;
	 }
	 */

	dseg = GetModInf3(ModHnd, MOD_dtseg);
	oseg = GetModInf3(ModHnd, MOD_ofseg);
	wp = WKonst;
	// ... und eintragen
	*(wp + TskPSum) = Sum;
	*(wp + 5) = VwOff;
	*(wp + 6) = dseg;

	Sum = 0;
	// Pruefsumme ueber Bereichsgrenzen bilden
	for (i = 0; i < Offsets - 1; i++) {
		Sum = Sum + *wp++;
	}
	*wp = Sum;

	HexIntel(OutH86, oseg, 0, WKonst, Offsets);
	HexIntel(OutH86, dseg, WKOff, WKonst + Offsets, WKanz);
	HexIntel(OutH86, dseg, FKOff, (word*) FKonst, FKanz << 1);
	hw = GetModInf3(ModHnd, MOD_kbseg);
	HexIntel(OutH86, hw, 0, KpfBst, Kpflen);

	for (i = 0; i < Tanz; i++) {
		HexIntel(OutH86, TaSeg[i], 0, TaBeg[i], TaWAnz[i]);
	}

	fprintf(OutH86, ":00000001FF\015\012");
	fclose(OutH86);
	sprintf(ListZl, " erstellt\015\012");
	strout(ListZl);

}

/******************************************************************************/

static void GenDebFile()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion generiert das Debug- Infofile auf das das Programm
 **	WTH86 zugreift. In Ihm sind alle Symbole mit Adressen enthalten.
 ***
 **.* Funktionswerte :
 **
 **
 */

{
	word i, hw;
	SortPm *SortSym;
	char Tc;

	DebugInfo = OpenFile(FName, ".DEB", "wb", Dirflag);
	strout(FName);
	for (i = 0; i < Tanz; i++) {
		fprintf(DebugInfo, "%d ", TaNum[i]);
	}
	hw = GetModInf3(ModHnd, MOD_dtseg);
	fprintf(DebugInfo, "\015\012%X %d\015\012", hw, ParamAnz);
	fprintf(DebugInfo, "SORTSYM\015\012");

	SortSym = SortParam;
	for (i = 0; i < ParamAnz; i++) {
		if (SortSym->Sym->T & FloatMsk) {
			Tc = 'F';
		} else {
			Tc = 'W';
		}
		fprintf(DebugInfo, "%X %c %s\015\012", SortSym->Sym->Off, Tc,
				SortSym->Sym->SN);
		SortSym++;
	}
	fprintf(DebugInfo, "SORTOFF\015\012");
	SortSym = SortParam;

	/* Achtung! dieser Sortiervorgang ist auch fuer die Erzeugung des	    */
	/* Listings erforderlich, da die Referenzierung der Symbole ueber die	    */
	/* Offsetwerte ueber Intervallhalbierung erfolgt.			    */

	qsort(SortParam, ParamAnz, sizeof(SortPm), VglOff);
	for (i = 0; i < ParamAnz; i++) {
		if (SortSym->Sym->T & FloatMsk) {
			Tc = 'F';
		} else {
			Tc = 'W';
		}
		fprintf(DebugInfo, "%X %c %s\015\012", SortSym->Sym->Off, Tc,
				SortSym->Sym->SN);
		SortSym++;
	}
	fclose(DebugInfo);
	sprintf(ListZl, " erstellt\015\012");
	strout(ListZl);

}

/******************************************************************************/

static void GenLstFile()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion generiert das Programmlisting aus den
 **	gesammelten Uebersetzungsdaten. (Konstanten, Kopfbaustein und
 **	Micas-Zwischencode)
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word hw, Off, Anz, Wert;
	char Sseg[6], Soff[6], Swert[6];
	BstDef *BST;
	short i, j;
	word *wp;
	char *P;

	Listing = OpenFile(FName, ".LST", "wb", Dirflag);
	strout(FName);
	Zeile = 0;
	Seite = 0;
	ListCr("");
	ListCr("");

	sprintf(ListZl, "\tK o p f b a u s t e i n:");
	ListCr(ListZl);
	sprintf(ListZl, "\t------------------------");
	ListCr(ListZl);

	wp = KpfBst;
	hw = GetModInf3(ModHnd, MOD_kbseg);
	Hexcw(Sseg, hw);
	Off = 0; // Listing von Kopfbaustein
	Hexcw(Soff, Off);
	Off++;
	Off++;
	Hexcw(Swert, *wp++);
	sprintf(ListZl, "\t%s:%s\t%s", Sseg, Soff, Swert);
	ListCr(ListZl);

	Hexcw(Soff, Off);
	Off++;
	Off++;
	Hexcw(Swert, *wp++);
	sprintf(ListZl, "\t%s:%s\t%s", Sseg, Soff, Swert);
	ListCr(ListZl);

	Hexcw(Soff, Off);
	Off++;
	Off++;
	Hexcw(Swert, *wp++);
	sprintf(ListZl, "\t%s:%s\t%s", Sseg, Soff, Swert);
	ListCr(ListZl);

	for (i = 0; i < Tanz; i++) {
		Hexcw(Soff, Off);
		Off++;
		Off++;
		Hexcw(Swert, *wp);
		j = *wp++ >> 8;
		sprintf(ListZl, "\t%s:%s\t%s\t;Task %d", Sseg, Soff, Swert, j);
		ListCr(ListZl);

		Hexcw(Soff, Off);
		Off++;
		Off++;
		Hexcw(Swert, *wp++);
		sprintf(ListZl, "\t%s:%s\t%s\t;Zykluszeit", Sseg, Soff, Swert);
		ListCr(ListZl);

		Hexcw(Soff, Off);
		Off++;
		Off++;
		Hexcw(Swert, *wp++);
		sprintf(ListZl, "\t%s:%s\t%s\t;Segmentadresse", Sseg, Soff, Swert);
		ListCr(ListZl);

		Hexcw(Soff, Off);
		Off++;
		Off++;
		Hexcw(Swert, *wp++);
		sprintf(ListZl, "\t%s:%s\t%s\t;Vergangenheitswerte", Sseg, Soff, Swert);
		ListCr(ListZl);
	}

	ListCr("");
	for (i = 0; i < Tanz; i++) {
		Off = 0;
		Hexcw(Sseg, TaSeg[i]);
		ListCr("");
		wp = TaBeg[i];
		Bflag = 0;
		Anz = TaWAnz[i];
		j = (*wp >> 8) & 0x000f;
		sprintf(ListZl, "\tTask %d:\t Zykluszeit %d ms  Laufzeit ca. %u ms", j,
				TaZyk[i], (word) TaLfz[i]);
		ListCr(ListZl);
		ListCr("");
		ListCr("");

		for (j = 0; j < Anz; j++) {
			Hexcw(Soff, Off);
			Off++;
			Off++;
			Wert = *wp++;
			Hexcw(Swert, Wert);
			sprintf(ListZl, "\t%s:%s\t%s", Sseg, Soff, Swert);
			if (Wert >= 0xf000) {
				Bflag++;
			} else {
				if (Bflag) {
					Bflag = 0;
					BST = GetBstNum(Wert);
					if (BST) {
						strcat(ListZl, "\t;");
						strcat(ListZl, BST->BName);
					}
				} else {
					if ((P = GetSymbol(Wert)) != NULL) {
						strcat(ListZl, "\t;");
						strcat(ListZl, P);
					}
				}
			}
			ListCr(ListZl);
		}
	}

	fprintf(Listing, "\015\014");
	fclose(Listing);
	sprintf(ListZl, " erstellt\015\012");
	strout(ListZl);

}

/******************************************************************************/

/*T*/
static void GenKuzFile()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion generiert die Konstanten- und Zwischenwertliste
 **	mit zugehoehrigen Offsets und Typen aus den gesammelten
 **	Uebersetzungsdaten.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short i, l, bl, Typi;
	long *fp;
	word *wp;
	char *P, *cp;
	SortPm *SortSym;
	char Soff[6];
	char fWert[20];

	KonZwi = OpenFile(FName, ".KUZ", "wb", Dirflag);
	strout(FName);
	Zeile = 0;
	Seite = 0;
	KonZwiCr("");
	SortSym = SortParam;

	for (i = 0; i < ParamAnz; i++) {
		P = strmov(ListZl, SortSym->Sym->SN, 2, 30);
		Typi = GetTypSInd(&SortSym->Sym->T);
		P = strmov(P, Typen[Typi], 2, 8);
		Hexcw(Soff, SortSym->Sym->Off);
		P = strmov(P, Soff, 5, 10);
		switch (Typi) {
		case RealZ:
		case WortZ:
			strmov(P, "? ? ?", 6, 20);
			break;

		case WortK:
			cp = (char*) WKonst + SortSym->Sym->Off;
			wp = (word*) cp;
			sprintf(P, "      %5d   (%04XH)", *wp, *wp);
			break;

		case RealK:
			cp = (char*) FKonst + SortSym->Sym->Off - FKOff;
			fp = (long*) cp;
			l = f_ftoa(*fp, 6, fWert);
			bl = 11 - l;
			if (bl < 0)
				bl = 0;
			if ((cp = strchr(fWert, '.')) != NULL && strchr(fWert, 'E') == NULL) {
				bl = bl + (l - (cp - fWert));
			}
			strmov(P, fWert, bl, 21);
			break;

		default:
			cp = (char*) WKonst + SortSym->Sym->Off;
			sprintf(P, "        %3d,%2d", *(cp + 0), *(cp + 1));
			break;

		}
		KonZwiCr(ListZl);
		SortSym++;
	}

	fprintf(KonZwi, "\015\014");
	fclose(KonZwi);
	sprintf(ListZl, " erstellt\015\012");
	strout(ListZl);

}

/******************************************************************************/

static void AddWKon(W)
	word W;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion fuegt das uebergebene Wort in die Wortkonstanten-
 **	liste ein.
 **
 **.* Funktionswerte :
 **
 **
 **
 */

{

	*WKon++ = W;
	lastParam->Wk = W;
	WKanz++;
	if (WKanz > WKMax) {
		RunError(12, NULL);
	}

}

/******************************************************************************/

static void CheckIPAdr(w)
	word w;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion ueberprueft, ob das Wort w bereits zuvor definiert
 **	wurde un gibt eine Warung aus falls dies zutrifft.
 **
 **.* Funktionswerte :
 **
 **
 **
 */

{
	short i;
	SymDef *Sym;

	Sym = Params;
	for (i = 1; i < ParamAnz; i++) {
		if (Sym->T & IpaMsk && w == Sym->Wk) {
			AsmError(51, NULL);
			return;
		}
		Sym = Sym->Next;
	}

}

/******************************************************************************/

static void AddFKon(W)
	long W;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion fuegt den uebergebenen Floatwert in die Float-
 **	konstantenliste ein.
 **
 **.* Funktionswerte :
 **
 **
 **
 */

{

	*FKon++ = W;
	FKanz++;
	if (FKanz > FKMax) {
		RunError(15, NULL);
	}

}

/******************************************************************************/

static char *GetStr(Str, Send, Begz)
	char **Str;char *Send;char *Begz;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert einen Pointer auf die naechste Zeichen-
 **	folge, die durch ein Zeichen von 'Begz' begrenzt wird. Dabei
 **	wird die Adresse des Stringpointers uebergeben, der zu durch-
 **	suchen ist und dessen Ende.
 **
 **.* Funktionswerte :
 **
 **	Pointer auf naechten Text,
 **	oder NULL-Pointer
 **
 */

{
	char *P, *PE, *PH;

	P = *Str;
	*P = lastByte;
	while (not(isgraph(*P))) {
		if (P == Send) {
			return (NULL);
		}
		P++;
	}

	PE = P;
	while (strchr(Begz, *PE) == NULL) {
		if (P == Send) {
			break;
		}
		PE++;
	}

	if (P == PE) {
		PE++;
	} else {
		PH = PE - 1;
		while (not(isgraph(*PH))) {
			PH--;
		}
		PE = PH + 1;
	}

	lastByte = *PE;
	*PE = 0;
	*Str = PE;
	return (P);

}

/******************************************************************************/

static char *GetSName(Str, Send)
	char **Str;char *Send;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert den symbolischen Namen eines Parameters.
 **	Abhaengig von aktuellen Typ werden verschiedene Scan-Routinen
 **	benutzt.
 **
 **.* Funktionswerte :
 **
 **	Pointer auf Symbol,
 **	oder NULL-Pointer
 **
 */

{

	switch (Typa) {

	case WortZ:
	case RealZ:
		return (GetStr(Str, Send, " ,\011"));

	default:
		return (GetStr(Str, Send, " (\011"));
	}

}

/******************************************************************************/

static void GenKopfbs() {
	short i;
	word *wp;

	wp = KpfBst;
	Kpflen = 3;
	*wp++ = 0xf000;
	*wp++ = 0x2000;
	*wp++ = Tanz;

	for (i = 0; i < Tanz; i++) {
		*wp++ = TaAbs[i];
		*wp++ = TaZyk[i];
		*wp++ = TaSeg[i];
		*wp++ = TaVwo[i];
		Kpflen += 4;
	}

}

/************************************************************************/
/*  F u n k t i o n e n   m i t   S t a t e - S w i t c h e s		*/
/************************************************************************/

static void GlobalInit(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion enthaelt alle Anweisungen, die zur Initialisierung
 **	des gesamten Uebersetzungsvorganges notwendig sind.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *P, P2;
	word len;

	P = strrchr(Str, '\\');
	if (P) {
		P2 = P + 1 - Str;
		memcpy(Dir, Str, P2);
	} else {
		P = Str - 1;
	}
	P++;
	strcpy(PName, P);
	P = strchr(PName, '.');
	if (P) {
		*P = 0;
	}

	len = WKMax * sizeof(short) + Offsets * sizeof(short);
	if ((P = malloc(len)) == NULL) {
		RunError(5, NULL);
	}
	memset(P, 0, len);
	MemPtr[MemPtrAnz++] = P;
	WKonst = (word*) P;
	//memset (WKonst, 0, Offsets<<1);
	WGKon = WKonst + Offsets;
	WKon = WGKon;

	len = FKMax * sizeof(long);
	if ((P = malloc(len)) == NULL) {
		RunError(5, NULL);
	}
	memset(P, 0, len);
	MemPtr[MemPtrAnz++] = P;
	FKonst = (long*) P;
	FGKon = FKonst;
	FKon = FKonst;

	MemPtri = MemPtrAnz;
	MemPtrIni = MemPtrAnz;

	Params = (SymDef*) GetMemory();
	lastParam = Params;
	firstMod = 1;
	aBSS = BS;
	aBST = aBSS->Tp;
	aBSG = aBSS->GTp;
	GetDatum(Datum);
	State = STATE_INITIAL;

	if (Input == NULL) {
		strcpy(FName, PName);
		strcat(FName, ".INC");
		if ((Input = fopen(FName, "rt")) != NULL) {
			Incflag++;
		} else {
			Input = OpenFile(FName, ".MIC", "rt", 0);
		}
	}
	Errorfile = OpenFile(FName, ".ERR", "wb", 0);

}

/******************************************************************************/

static void TaskInit(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion enthaelt alle Anweisungen, die zur Initialisierung
 **	des taskspezifischen Uebersetzungsvorganges notwendig sind.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short ok = 0;

	switch (State) {
	case OutModul:
	case EndgDef:
	case STATE_INITIAL:
		AsmError(6, Str);
		break;
	case gblDef:
	case locDef:
		AsmError(7, Str);
		break;
	case gblWDef:
		AsmError(23, Str);
		State = gblWKlz;
		break;
	case locWDef:
		AsmError(23, Str);
		State = locWKlz;
		break;
	case InTask:
		if (Tflag) {
			AsmError(11, NULL);
			ok++;
		} else {
			AsmError(27, Str);
		}
		break;
	case BauDef:
		AsmError(25, Str);
		break;
	case ModDefi:
		AsmError(42, Str);
		break;
	case TskDef:
		AsmError(45, Str);
		break;
	case EndlzDef:
	case EndlkDef:
	case InModul:
		ok++;
		break;
	}

	if (ok) {
		if (Tanz == 0) {
			firstTask();
		}
		TaBeg[Tanz] = Word;
		TaVwo[Tanz] = VwOff;
		TVwAnz = 0;
		TskLfz = 0;
		TWanz = 0; // #7.5.96  4*TaskMax + 4;
		State = bTskDef;
		Tflag++;
	}

}

/******************************************************************************/

static void ModulInit(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion enthaelt alle Anweisungen, die zur Initialisierung
 **	des modulspezifischen Uebersetzungsvorganges notwendig sind.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short ok = 0;

	switch (State) {
	case InModul:
		AsmError(27, Str);
		break;
	case gblDef:
	case locDef:
		AsmError(7, Str);
		break;
	case gblWDef:
		AsmError(23, Str);
		State = gblWKlz;
		break;
	case locWDef:
		AsmError(23, Str);
		State = locWKlz;
		break;
	case InTask:
		AsmError(24, Str);
		break;
	case BauDef:
		AsmError(25, Str);
		break;
	case ModDefi:
		AsmError(42, Str);
		break;
	case EndlkDef:
	case EndlzDef:
		AsmError(27, Str);
		break;
	case TskDef:
		AsmError(45, Str);
		break;
	case OutModul:
	case EndgDef:
	case STATE_INITIAL:
		ok++;
		break;
	}

	if (ok) {
		if (firstMod) {
			lGblParam = lastParam;
			GblSymSize = SymSize;
			MemPtrIni = MemPtrAnz;
			GParaAnz = ParamAnz;
			FGKon = FKon;
			FGKanz = FKanz;
			WGKon = WKon;
			WGKanz = WKanz;
			firstMod = 0;
		}

		lastParam = lGblParam;
		SymSize = GblSymSize;
		MemPtri = MemPtrIni;
		ParamAnz = GParaAnz;

		FKon = FGKon;
		FKanz = FGKanz;
		WKon = WGKon;
		WKanz = WGKanz;

		WZanz = 0;
		FZanz = 0;
		Tanz = 0;
		Zykst = 0;
		State = bModDef;
	}

}

/******************************************************************************/

static void ModulEnd(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion enthaelt alle Anweisungen, die zum Abschluss des
 **	uebersetzten Moduls notwendig sind.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word TanfSeg, tseg;
	word dseg, sseg, hw, i;
	SortPm *SortSym;
	short ok = 0;
	char Proz[10];
	long Zykl;

	switch (State) {
	case STATE_INITIAL:
		AsmError(6, Str);
		break;
	case gblDef:
	case locDef:
		AsmError(7, Str);
		break;
	case gblWDef:
		AsmError(23, Str);
		State = gblWKlz;
		break;
	case locWDef:
		AsmError(23, Str);
		State = locWKlz;
		break;
	case IgnModul:
		State = OutModul;
		return;
	case InModul:
		State = OutModul;
		ok++;
		break;
	case ModDefi:
		AsmError(42, Str);
		break;
	case OutModul:
		AsmError(27, Str);
		break;
	case TskDef:
		AsmError(45, Str);
		break;
	case InTask:
		AsmError(11, NULL);
		break;
	case BauDef:
		AsmError(25, Str);
		break;
	default:
		State = OutModul;
		ok++;
		break;
	}

	if (ok) {
		TskLfz = 0;
		dseg = GetModInf3(ModHnd, MOD_dtseg);
		if (AR20Mode == 1 && (ModHnd == AR20i || ModHnd == SP20i)) {
			tseg = GetModInf3(ModHnd, MOD_stseg);
			if (AR20Konst)
				tseg = tseg + (KonSize >> 4);
			//    else	   tseg = SegAddi (tseg, Offsets*2);
			TanfSeg = tseg;
			hw = 0;
		} else {
			TanfSeg = tseg = dseg;
			hw = VwOff;
		}

		for (i = 0; i < Tanz; i++) {
			TanfSeg = SegAddi(TanfSeg, hw);
			TaSeg[i] = TanfSeg;
			hw = TaWAnz[i] << 1;
			if ((Zykl = TaZyk[i]) != 0) {
				TskLfz += (long) TaLfz[i] * 100l / Zykl;
			}
		}

		PSize = ((TanfSeg - tseg) << 4) + (TWanz << 1);
		sseg = GetModInf3(ModHnd, MOD_stseg);

		if (AR20Mode == 1 && (ModHnd == AR20i || ModHnd == SP20i)) {
			if (AR20Konst)
				PSize = PSize + KonSize;
			i = GetModInf3(ModHnd, MOD_clmax);
			if (PSize > i)
				AsmError(54, NULL);
			i = SegAddi(dseg, VwOff);
			hw = 55;
			if (AR20Konst)
				hw = 56;
			if (i > (sseg - Tanz * TaskStack))
				AsmError(hw, NULL);
		} else {
			hw = SegAddi(dseg, PSize);
			if (hw > (sseg - Tanz * TaskStack))
				AsmError(52, NULL);
		}

		if (Error == 0 && SortParam) {
			SortSym = SortParam;
			for (i = 0; i < ParamAnz; i++) {
				if ((SortSym->Sym->T & gbl_b) == 0 && (SortSym->Sym->T & use_b)
						== 0) {
					AsmWarning(3, SortSym->Sym->SN);
				}
				SortSym++;
			}

			if ((word) TskLfz >= 90) {
				sprintf(Proz, "%d", (word) TskLfz);
				AsmWarning(5, Proz);
			}

			GenKopfbs();
			GenH86File();
			GenKuzFile();
			GenDebFile();
			if (Lflag) {
				GenLstFile();
			}
		}
		GetText(ListZl, 117);
		hw = GetModInf3(ModHnd, MOD_clmax);
		sprintf(&ListZl[strlen(ListZl)], "%u byte's  max. %u\015\012", PSize,
				hw);
		strout(ListZl);

		State = OutModul;
		free(SortParam);
		free(KpfBst);
		SortParam = NULL;
		KpfBst = NULL;
	}

}

/******************************************************************************/

static void Init_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short T;

	T = GetTypInd(Str);
	if (T < 0) {
		AsmError(44, Str);
	} else {
		Typa = T;
		if (Typa == WortZ || Typa == RealZ) {
			AsmError(38, NULL);
		}
	}
	State = gblDef;

}

/******************************************************************************/

static void gblDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short T;

	T = GetTypInd(Str);
	if (T >= 0) {
		AsmError(7, Str);
		Typa = T;
		return;
	}

	if (Symbol_known(Str)) {
		AsmError(43, Str);
	} else {
		AddParam(Str, Typa);
	}
	switch (Typa) {
	case WortK:
	case RealK:
		State = bggwDef;
		break;
	case IpaZw:
	case IpaMl:
	case IpaAw:
	case IpaMw:
		if (*Str != '&') {
			AsmError(49, NULL);
		}
		State = bggwDef;
		break;
	case WortZ:
	case RealZ:
		State = EndgDef;
		break;
	}

}

/******************************************************************************/

static void locDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short T;

	T = GetTypInd(Str);
	if (T >= 0) {
		AsmError(7, Str);
		Typa = T;
		return;
	}

	if (Symbol_known(Str)) {
		AsmError(43, Str);
	} else {
		AddParam(Str, Typa);
	}
	switch (Typa) {
	case WortK:
	case RealK:
		State = bglwDef;
		break;
	case IpaZw:
	case IpaMl:
	case IpaAw:
	case IpaMw:
		if (*Str != '&') {
			AsmError(49, NULL);
		}
		State = bglwDef;
		break;
	case WortZ:
	case RealZ:
		State = EndlzDef;
		break;
	}

}

/******************************************************************************/

static void gblWDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word w;

	switch (Typa) {
	case WortK:
		AddWKon(WdVal(Str));
		break;

	case RealK:
		AddFKon(FlVal(Str));
		break;
	case IpaZw:
	case IpaMl:
	case IpaAw:
	case IpaMw:
		w = FgVal(Str);
		AddWKon(w);
		CheckIPAdr(w);
		break;
	}
	State = gblWKlz;

}

/******************************************************************************/

static void locWDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word w;

	switch (Typa) {
	case WortK:
		AddWKon(WdVal(Str));
		break;

	case RealK:
		AddFKon(FlVal(Str));
		break;
	case IpaZw:
	case IpaMl:
	case IpaAw:
	case IpaMw:
		w = FgVal(Str);
		AddWKon(w);
		CheckIPAdr(w);
		break;
	}
	State = locWKlz;

}

/******************************************************************************/

static void InTask_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short T;
	word hw;
	char *P;

	aBSS = GetBstNam(Str);
	if (aBSS == NULL) {
		T = GetTypInd(Str);
		if (T >= 0 && Tflag) {
			AsmError(32, NULL);
		} else {
			AsmError(1, Str);
		}
	} else {
		strcpy(BauNam, aBSS->BName);
		P = aBSS->ModZul;
		if (P && strstr(P, ModTyp) == NULL)
			AsmError(37, BauNam);
		aBST = aBSS->Tp;
		aBSG = aBSS->GTp;
		TWanz++;
		TWanz++;
		//  if ((TWanz<<1) >= CodLenMax[Usv])  RunError(8, NULL);
		*Word++ = BauNum++;
		*Word++ = aBSS->BNr;
		TVwAnz += aBSS->Vw;
		TskLfz += aBSS->Lfz;
		GlSoll = aBSS->Gla;
		PSoll = aBSS->EA;
		GlAnz = 0;
		Gflag = 0;
		Panz = 0;
		if (PSoll) {
			State = bBauDef;
		}

		if (aBSS->BNr == BNrEnd) /* bei Ende-Baustein Task abschiessen	    */
		{
			TaWAnz[Tanz] = TWanz;
			TaVwAnz[Tanz] = TVwAnz;
			hw = GetModInfo(ModHnd, MOD_lfakt, NULL);
			TskLfz = (TskLfz + (hw >> 1)) / hw;
			Tlaufz = TskLfz;
			TaLfz[Tanz] = Tlaufz;
			VwOff = VwOff + TVwAnz; /* Vergangenheitsw. */
			if (Tlaufz >= (TskZyk - TskZyk / 10) && TskZyk) {
				AsmWarning(4, NULL);
			}
			OVersatz(VwOff);
			Tanz++;
			Tflag = 0;
			State = InModul;
		}
	}

}

/******************************************************************************/

static void InModul_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	short T;

	aBSS = GetBstNam(Str);
	if (aBSS) {
		AsmError(9, NULL);
		firstTask();
		InTask_F(Str);
		return;
	}

	T = GetTypInd(Str);
	if (T < 0) {
		AsmError(44, Str);
	} else {
		Typa = T;
		if (Tflag) {
			AsmError(32, NULL);
		}
	}
	State = locDef;

}

/******************************************************************************/

static void EndlDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, ",")) {
		InModul_F(Str);
	} else {
		State = locDef;
	}

}

/******************************************************************************/

static void EndgDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, ",")) {
		Init_F(Str);
	} else {
		State = gblDef;
	}

}

/******************************************************************************/

static void Klz_Check(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	int nok = 0;

	if (strcmp(Str, ")")) {
		AsmError(4, NULL);
		nok++;
	}

	switch (State) {
	case gblWKlz:
		if (nok) {
			State = STATE_INITIAL;
		} else {
			State = EndgDef;
		}
		break;
	case locWKlz:
		if (nok) {
			State = InModul;
		} else {
			State = EndlkDef;
		}
		break;
	}

}

/******************************************************************************/

static void EndMDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, ")")) {
		AsmError(4, NULL);
		InModul_F(Str);
	} else {
		State = InModul;
	}

}

/******************************************************************************/

static void bggwDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, "(")) {
		AsmError(3, NULL);
		gblWDef_F(Str);
	} else {
		State = gblWDef;
	}

}

/******************************************************************************/

static void bglwDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, "(")) {
		AsmError(3, NULL);
		locWDef_F(Str);
	} else {
		State = locWDef;
	}

}

/******************************************************************************/

static void ModDefi_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word i, len;
	char *P;

	P = strtok(Str, ", \011");
	Dirflag = OneDir;

	GetModTyp(P);
	len = GetModInf3(ModHnd, MOD_clmax);
	if ((KpfBst = (word*) malloc(len)) == NULL) {
		RunError(5, NULL);
	}
	if (GetModInfo(ModHnd, MOD_mimod, NULL) == 0)
		AsmError(53, NULL);
	memset(KpfBst, 0, len);

	Word = KpfBst + 4 * TaskMax + 3;
	P = strtok(NULL, ", \011");

	if (GetModInfo(ModHnd, MOD_mumod, NULL)) {
		Dirflag++;
		ModNr = 0;
		if (P) {
			AsmWarning(6, NULL); /* Adressangabe bei Zp02/03 unzulaessig	*/
		}
		State = EndMDef;
	} else {
		if (P == NULL) {
			RunError(3, NULL);
		}
		ModNr = atoi(P);
		if (ModNr < ModMinNr || ModNr > ModMaxNr) {
			AsmError(26, NULL);
		}

		if (ModNri) {
			State = IgnModul;
			for (i = 0; i < ModNri; i++) {
				if (ModNra[i] == ModNr) {
					State = EndMDef;
				}
			}
		} else {
			State = EndMDef;
		}

		if (State == EndMDef) {
			for (i = 0; i < ModAnz; i++) {
				if (ModulNr[i] == ModNr) {
					AsmError(10, NULL);
				}
			}
			ModulNr[ModAnz++] = ModNr;
		}

	}

}

/******************************************************************************/

static void OutModul_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	BstDef *BST;

	Typa = GetTypInd(Str);
	if (Typa >= 0) {
		switch (Typa) {
		case WortK:
		case RealK:
		case IpaZw:
		case IpaMl:
		case IpaAw:
		case IpaMw:
			AsmError(39, NULL);
			break;
		case WortZ:
		case RealZ:
			AsmError(38, NULL);
			break;
		}
		return;
	}

	BST = GetBstNam(Str);
	if (BST) {
		AsmError(41, NULL);
		return;
	}

	AsmError(40, Str);

}

/******************************************************************************/

static void TskDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *P;
	word i, Id, hw, ZykHg;

	P = strtok(Str, ", \011");
	if (notZifW(P)) {
		AsmError(8, P);
	} else {
		TskId = WdVal(P);
		hw = GetModInfo(ModHnd, MOD_tsmax, NULL);
		if (TskId < 1 || TskId > hw) {
			AsmError(47, NULL);
		} else {
			for (i = 0; i < Tanz; i++) {
				Id = TaAbs[i] >> 8;
				if (Id == TskId) {
					AsmError(12, NULL);
				}
			}
		}
	}
	P = strtok(NULL, ", \011");
	TskAbs = GetAbsInd(P);
	ZykHg = GetModInfo(ModHnd, MOD_zykhg, NULL);

	switch (TskAbs) {

	case Abs_zyk:
	case Abs_zyks:
		P = strtok(NULL, ", \011");
		if (P) {
			TskZyk = WdVal(P);
			if (TskZyk == 0) {
				AsmError(35, NULL);
				break;
			}
		} else {
			AsmError(5, NULL);
			break;
		}

		if (Zykst) {
			if (TskZyk % Zykst)
				AsmError(13, NULL);
		} else {
			if (TskZyk >= ZykHg) {
				Zykst = ZykHg;
				if (TskZyk % Zykst)
					AsmError(13, NULL);
			} else {
				Zykst = TskZyk;
				if (ZykHg % Zykst)
					AsmError(19, NULL);
			}
		}
		break;

	case Abs_int:
	case Abs_ints:
	case Abs_bcks:
	case Abs_bck:
		P = strtok(NULL, ", \011");
		if (P) {
			TskZyk = WdVal(P);
			if (TskZyk)
				AsmError(36, NULL);
		}
		break;

	case Abs_ini:
	case Abs_inis:
		P = strtok(NULL, ", \011");
		if (P) {
			TskZyk = WdVal(P);
			if (TskZyk)
				AsmError(34, NULL);
		}
		break;

	default:
		AsmError(2, P);
		break;
	}

	TaNum[Tanz] = TskId;
	TaZyk[Tanz] = TskZyk;
	TaAbs[Tanz] = Abstrgv[TskAbs] + (TskId << 8);
	BauNum = 0xf000 + (TskId << 8);
	State = EndTDef;

}

/******************************************************************************/

static void BauDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	word Wert;
	SymDef *Sym;
	short lE;

	if (strcmp(Str, ",") == 0) {
		return;
	}

	if (strcmp(Str, ")") == 0) {
		if (GlAnz < GlSoll)
			AsmError(28, NULL);
		if (GlAnz == GlSoll && GlSoll) {
			if (Panz < PSoll)
				AsmError(18, NULL);
			if (Panz > PSoll)
				AsmError(16, NULL);
		} else {
			if (Panz < PSoll)
				AsmError(30, NULL);
		}
		State = InTask;
		return;
	}

	lE = Error;
	if (GlSoll) {
		if (Gflag) {
			ZGPanz++;
			aTyp = &aBSG->T;
			TskLfz += aBSG->Lfz;
			if (ZGPanz == GlAng) {
				Gflag = 0;
				aBSG++;
			}
		} else {
			aTyp = aBST++;
			if (GlAnz < GlSoll && *aTyp & GRPL_b) {
				if (notZifW(Str)) {
					if (GlAnz) {
						AsmError(14, Str);
					} else {
						AsmError(15, Str);
					}
				}
				if (lE == Error) {
					GlAng = WdVal(Str);
				}
				PSoll += GlAng;
				if (GlAng) {
					Gflag++;
				}
				GlAnz++;
				ZGPanz = 0;
			}
		}
	} else {
		aTyp = aBST++;
	}

	if (notZifW(Str)) {
		Sym = GetParaDes(Str);
		if (Sym) {
			Wert = Sym->Off;
		} else {
			if (lE == Error) {
				AsmError(20, Str);
				AddudfPara(Str, aTyp);
			}
			Wert = 0;
		}
	} else {
		Sym = &GrplTyp;
		Wert = WdVal(Str);
	}

	lE = Error;
	if (Sym) {
		if ((*aTyp & FloatMsk) && (Sym->T & FloatMsk) == 0) {
			AsmError(17, Str);
		}
		if ((*aTyp & WortMsk) && (Sym->T & WortMsk) == 0) {
			AsmError(46, Str);
		}
		if ((*aTyp & ZalkMsk) && (Sym->T & ZalkMsk) == 0) {
			AsmError(50, Str);
		}
		if (Sym->T & KonstMsk) {
			if (*aTyp & Aus_b) {
				AsmWarning(2, Str);
			}
		}
		if ((*aTyp & Sym->T & Typmsk) == 0 && lE == Error) {
			AsmWarning(1, Str);
		}
	}

	TWanz++;
	Panz++;
	//if ((TWanz<<1) >= CodLenMax[Usv])  RunError(8, NULL);
	*Word++ = Wert;

	if (GlSoll == 0 && Panz > PSoll) {
		AsmError(31, NULL);
	}

}

/******************************************************************************/

static void bBauDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, "(")) {
		AsmError(3, NULL);
		BauDef_F(Str);
	} else {
		State = BauDef;
	}

}

/******************************************************************************/

static void EndTDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, ")")) {
		AsmError(4, NULL);
		InTask_F(Str);
	} else {
		State = InTask;
	}

}

/******************************************************************************/

static void bModDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, "(")) {
		AsmError(3, NULL);
		ModDefi_F(Str);
	} else {
		State = ModDefi;
	}

}

/******************************************************************************/

static void bTskDef_F(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion verarbeitet den ihr uebergebenen Text in dem
 **	entsprechenden Zustand und fuehrt gegebenenfalls State-
 **	Switches durch.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	if (strcmp(Str, "(")) {
		AsmError(3, NULL);
		TskDef_F(Str);
	} else {
		State = TskDef;
	}

}

/******************************************************************************/

static void DefToken(Str)
	char *Str;

/*F
 **.* Beschreibung :
 **
 **	Die Funktion entspricht einer Zustandsmaschiene, die immer
 **	eine Zeichenfolge aus der Input-Datei liest, in Abhaengigkeit
 **	des Zustands diese verarbeitet und in Abhaengigkeit des
 **	Inhalts den Zustand wechsel, oder auch nicht.
 **
 **.* Funktionswerte :
 **
 **
 */

{

	switch (State) {
	case STATE_INITIAL:
		Init_F(Str);
		break;

	case gblDef:
		gblDef_F(Str);
		break;

	case locDef:
		locDef_F(Str);
		break;

	case bggwDef:
		bggwDef_F(Str);
		break;

	case bglwDef:
		bglwDef_F(Str);
		break;

	case bModDef:
		bModDef_F(Str);
		break;

	case bTskDef:
		bTskDef_F(Str);
		break;

	case bBauDef:
		bBauDef_F(Str);
		break;

	case gblWDef:
		gblWDef_F(Str);
		break;

	case locWDef:
		locWDef_F(Str);
		break;
	case gblWKlz:
	case locWKlz:
		Klz_Check(Str);
		break;

	case EndgDef:
		EndgDef_F(Str);
		break;

	case EndlkDef:
	case EndlzDef:
		EndlDef_F(Str);
		break;

	case EndMDef:
		EndMDef_F(Str);
		break;

	case EndTDef:
		EndTDef_F(Str);
		break;

	case InModul:
		InModul_F(Str);
		break;

	case ModDefi:
		ModDefi_F(Str);
		break;

	case OutModul:
		OutModul_F(Str);
		break;

	case TskDef:
		TskDef_F(Str);
		break;

	case InTask:
		InTask_F(Str);
		break;

	case BauDef:
		BauDef_F(Str);
		break;
	}

}

/******************************************************************************/

static char *NextToken()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion liefert einen Pointer auf die naechste Zeichenfolge,
 **	die von der aufrufenden Funktion zu verarbeiten ist. Die Art und
 **	Weise wie gescannt wird haengt dabei vom aktuellen Zustand in
 **	State ab, da z.B. bei FG-Adressangaben auch Sonderzeichen
 **	wie Komma moeglich sind.
 **
 **.* Funktionswerte :
 **
 **	Pointer auf naechste Zeichenfolge,
 **	oder NULL-Pointer bei Dateiende
 **
 */

{
	static
	char *Str, *Send, *token;
	char *P;
	short l;

	for (;;) {

		if (token == NULL) {
			do {
				fgets(Zeilio, MaxZLen, Input);
				P = &Zeilio[strlen(Zeilio) - 1];
				*P++ = 13;
				*P++ = 10;
				*P = 0;
				fputs(Zeilio, Errorfile);
				QZeile++;
				if (feof(Input)) {
					fclose(Input);
					if (Incflag) {
						Incflag = 0;
						Input = OpenFile(FName, ".MIC", "rt", 0);
						QZeile = 0;
						continue;
					}
					return (NULL);
				}
				P = strchr(Zeilio, ';');
				if (P) {
					*P = 0;
				}
			} while ((l != strlen(Zeilio)));
			if (l >= (MaxZLen - 1))
				RunError(16, NULL);
			QInc++;
			if (State != OutModul && QInc >= Zaus) {
				sprintf(ListZl, "%d\015", QZeile);
				strout(ListZl);
				QInc = 0;
			}
			Send = Zeilio + l;
			Str = Zeilio;
			if (UppCase)
				strupr(Str);
			lastByte = *Str;
		}

		switch (State) {

		case BauDef:
			token = GetStr(&Str, Send, ",)");
			break;
		case bggwDef:
		case bglwDef:
		case bTskDef:
		case bModDef:
		case bBauDef:
			token = GetStr(&Str, Send, "(");
			break;
		case EndgDef:
		case EndlkDef:
		case EndlzDef:
			token = GetStr(&Str, Send, ", \011");
			break;
		case gblWKlz:
		case locWKlz:
		case EndMDef:
		case EndTDef:
		case locWDef:
		case gblWDef:
		case ModDefi:
		case TskDef:
			token = GetStr(&Str, Send, ")");
			break;
		case STATE_INITIAL:
		case InModul:
		case IgnModul:
		case OutModul:
		case InTask:
			token = GetStr(&Str, Send, " \011");
			break;
		case gblDef:
		case locDef:
			token = GetSName(&Str, Send);
			break;
		}
		if (token) {
			return (token);
		}

	}

}

/******************************************************************************/

static void Compile()

/*F
 **.* Beschreibung :
 **
 **	Die Funktion entspricht einer Zustandsmaschiene, die immer
 **	eine Zeichenfolge aus der Input-Datei liest, in Abhaengigkeit
 **	des Zustands diese verarbeitet und in Abhaengigkeit des
 **	Inhalts den Zustand wechsel, oder auch nicht.
 **
 **.* Funktionswerte :
 **
 **
 */

{
	char *Str;
	short Tok;

	while ((Str = NextToken()) != NULL) {
		Tok = GetSwInd(Str);
		switch (Tok) {
		case ModDef:
			ModulInit(Str);
			break;

		case TaskDef:
			TaskInit(Str);
			break;

		case ModEnd:
			ModulEnd(Str);
			break;

		default:
			DefToken(Str);
			break;
		}
	}

	if (State != OutModul) {
		AsmError(48, NULL);
	}

}

/******************************************************************************/

static void LastOutput()

{
	word i, l;
	SymDef *Sym;

	Sym = Params;
	for (i = 0; i < ParamAnz; i++) {
		aTyp = &Sym->T;
		if ((*aTyp & gbl_b) && (*aTyp & use_b) == 0) {
			AsmWarning(3, Sym->SN);
		}
		Sym = Sym->Next;
	}

	Sym = udfParams;
	for (i = 0; i < udfParaAnz; i++) {
		aTyp = &Sym->T;
		if (udfFile == NULL) {
			udfFile = OpenFile(FName, ".UDF", "wt", 0);
			strout(FName);
		}
		// l =
		GetTypes(ListZl, aTyp);
		strcat(ListZl, "\t");
		if (*aTyp & IpaMsk) {
			if (*Sym->SN != '&') {
				strcat(ListZl, "&");
			}
		}
		strcat(ListZl, Sym->SN);
		detab(ListZl);
		l = strlen(ListZl);
		if (l <= 24)
			strcat(ListZl, "\t");
		if (*aTyp & KonstMsk) {
			if (*aTyp & (PRORT_TYPE_WORD_CONST | PRORT_TYPE_FLOAT_CONST)) {
				strcat(ListZl, "\t(?)");
			} else {
				strcat(ListZl, "\t(?,?)");
			}
		}
		fprintf(udfFile, "%s\n", ListZl);
		Sym = Sym->Next;
	}

	if (udfFile) {
		fclose(udfFile);
		sprintf(ListZl, " erstellt\n");
		strout(ListZl);
	}

	if (Error == 0 && Warning == 0) {
		strcpy(ListZl, PName);
		strcat(ListZl, ".ERR");
		if (access(ListZl, 0) != -1) {
			sprintf(ListZl, "del %s.e*", PName);
#ifdef	VAX
			strcat (ListZl, ";*/noco/nolo");
#endif
			system(ListZl);
		}

		strcpy(ListZl, PName);
		strcat(ListZl, ".UDF");
		if (access(ListZl, 0) != -1) {
			sprintf(ListZl, "del %s.udf", PName);
#ifdef	VAX
			strcat (ListZl, ";*/noco/nolo");
#endif
			system(ListZl);
		}
	} else {
		fclose(Errorfile);
	}
	close(fht);

}

/******************************************************************************/

static void LogonMessage()

{
	char Datum[12];
	char Zeit[10];
	char Text[60];

	decode(&StartMessage[Swlen], Text, Meslen);
	sprintf(ListZl, "%s\n", Text);
	strout(ListZl);
	GetText(Text, 100);
	strcat(Text, Version);
	AppendText(Text, 111);
	strout(Text);
	strncpy(Datum, __DATE__, 11);
	Datum[3] = 0;
	Datum[6] = 0;
	Datum[11] = 0;
	strcpy(Zeit, __TIME__);
	Zeit[5] = 0;
	sprintf(Text, "  vom %s.%s.%s  %s\n", &Datum[4], &Datum[0], &Datum[7], Zeit);
	strout(Text);
	sprintf(ListZl, "Copyright 1997 by Asea Brown Boveri\n");
	strout(ListZl);

}

/******************************************************************************/

int main(int argc, char *argv[])

/*F
 ** * Beschreibung :
 **
 ** Die Funktion dient der uebergeordneten Steuerung
 **
 ** * Funktionswerte :
 **
 **
 */

{
	char **Nam, *P;
	word i;

	Nam = LanFiles;
	for (i = 0; i < LanFanz; i++, Nam++) {
		strcpy(FName, argv[0]);
		//strupr(FName);
		P = strstr(FName, ".mic");
		if (P == NULL)
			P = FName;
		strcpy(P, *Nam);
		strcat(P, ".txb");
		if (OpenTextFile2(FName) == 0)
			goto Ok;
	}
	sprintf(ListZl, "\007textfile not found!");
	strout(ListZl);
	exit(1);

	Ok: LogonMessage();

	if (argc < 2) {
		RunError(1, NULL);
	}
	GetOptions(argv[2]);
	GlobalInit(argv[1]);
	Compile();
	LastOutput();
	FreeMem();
	return 0;
}

/** extras */
int strcmpi(char *s1, char *s2) {
	for (; *s1 && *s2 && (toupper(*s1) == toupper(*s2)); ++s1, ++s2)
		;
	return *s1 - *s2;
}

void strout(char *s) {
	printf("strout: %s\n", s);
}

char * strupr(char *a) {
	char *ret = a;

	while (*a != '\0') {
		if (islower (*a))
			*a = toupper(*a);
		++a;
	}

	return ret;
}

int GetModHandle(char* str) {
	printf("GetModHandle->%s\n", str);
	return -1;
}

int GetModInfo(long modHnd, long modParam, LPSTR str) {
	printf("GetModInfo-> %ld,%ld,%s\n", modHnd, modParam, str);
	return -1;
}
int GetModInf2(long modHnd, LPSTR str, long modParam) {
	printf("GetModInfo->%ld,%s,%ld \n", modHnd, str, modParam);
	return -1;
}
