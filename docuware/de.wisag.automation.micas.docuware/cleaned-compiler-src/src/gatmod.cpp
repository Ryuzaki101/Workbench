/*K
**      Modul Name....: INSMOD.C
**
**      Funktion......: GAT Moduldaten
**
**      Versionsdatum.: 15.12.2002
**
**      Autor.........: U. Stahl   - ABB GAT/T
**
*/

#ifndef		_MICAS_
#include	<windows.h>
#endif
#include	<stdlib.h>
#include	<string.h>
#include	<ctype.h>
#include	<wredef.h>
#ifdef	_MICAS_
#include	"..\AWD406_X\gatmod.h"
#else
#include	"gatmod.h"
#endif

#pragma	hdrstop

//--------------------------------------------------------------------------
//	S t r u k t u r e n
//--------------------------------------------------------------------------

typedef	struct	VAdrsS	{
	LPSTR	Version;
        WORD    Seg_DB;
        WORD    Cks_DB;
	WORD	SegBukl;
	WORD	EEOff;
	WORD	KBSeg;
	WORD	EndBst;
	WORD	DataSeg;
	WORD	StackSeg;
	WORD	OffsSeg;
	WORD	CLenMax;
}VADRS;

typedef	struct	{
	WORD	EFZeil;		// erste fiktive Zeile
	WORD	EMZeil;		// erste Messwertzeile
	WORD	MWZAnz;		// Anzahl Messwertzeilen
	WORD	SZWMax;		// Max. Anzahl Softwarez„hler
	}ZLINF,*PZLINF;

typedef	struct	{
	LPSTR	ModNam;
	LPSTR	Alias;		// Alias bez. Stammdaten
	LPSTR	DefGeh;
	LPSTR	DefStk;
	BYTE	Zeilen;
	LPBYTE	TypIds;
	PZLINF	PZI;
	WORD	Flags;
	BYTE	TskMax;
	BYTE	ModInd;
	BYTE	binTyp;
	WORD	VwOffT1;
	WORD	ZyklHgt;
	WORD	LFaktor;
	VADRS   *Versio;
	LPBYTE	CSExcl;		// Ausgespaarte CW's
	BYTE	impSio;		// Impulsdauer bzw. Baudrate Bediener
}MODTBS,*PMDTAB;

#define	ZEILEN(x) sizeof(x),x
#define	NULL_ZEILEN 0,NULL


BYTE	ZP20_Excl[] = {119,120,121,122,123,124,125,126,127,0};
BYTE	AR20_Excl[] = {47,48,49,50,55,56,57,58,0};

static	BYTE	ZP10_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik};
static	ZLINF	ZP10_Inf = { 0, 0, 0, 0};

static	BYTE	AR10_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mb01,ZL_mb01,ZL_IRZ,	ZL_HWZ,	ZL_aMW,	ZL_aMW,	ZL_aMW,	ZL_aMW,
	ZL_aMW,	ZL_aMW,	ZL_pMW,	ZL_pMW,	ZL_pMW,	ZL_pMW,	ZL_aa,	ZL_aa,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_aa,	ZL_aa,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik};
static	ZLINF	AR10_Inf = {18, 4,10,12};

static	BYTE	AR11_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mb01,ZL_mb01,ZL_IRZ,	ZL_HWZ,	ZL_aMW,	ZL_aMW,	ZL_aMW,	ZL_aMW,
	ZL_aMW,	ZL_aMW,	ZL_pMW,	ZL_pMW,	ZL_pMW,	ZL_pMW,	ZL_aa,	ZL_aa,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_aa,	ZL_aa,	ZL_aa, 	ZL_aa, 	ZL_aa, 	ZL_aa, 	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik};
static	ZLINF	AR11_Inf = {22, 4,10,12};

static	BYTE	AR20_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mb01,ZL_mb01,ZL_IRZ,	ZL_HWZ,	ZL_aMW,	ZL_pMW,	ZL_pMW,	ZL_pMW,
	ZL_aMW,	ZL_pMW,	ZL_pMW,	ZL_pMW,	ZL_aa, 	ZL_aa, 	ZL_aa,	ZL_aa,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_aa,	ZL_aa,	ZL_aa, 	ZL_aa, 	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik};
static	ZLINF	AR20_Inf = {20, 4, 8,12};

static	BYTE	AC40_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mb01,ZL_mb01,ZL_mb23,ZL_mb23,ZL_IRZ,	ZL_HWZ,	ZL_aMW,	ZL_aMW,
	ZL_aMW,	ZL_aMW,	ZL_aMW,	ZL_aMW,	ZL_pMW,	ZL_pMW,	ZL_pMW, ZL_pMW,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_aa,	ZL_aa,	ZL_aa, 	ZL_aa, 	ZL_aa, 	ZL_aa, 	ZL_aa, 	ZL_aa,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik, ZL_fik};
static	ZLINF	AC40_Inf = {24, 6,10,24};

static	BYTE	SP10_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mb01,ZL_mb01,ZL_mb23,ZL_mb23,ZL_IRZ,	ZL_HWZ,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik, ZL_fik,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_fik, ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik};
static	ZLINF	SP10_Inf = { 6, 0, 0,24};

static	BYTE	MB10_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mb,  ZL_mb,  ZL_mb,  ZL_mb,  ZL_mb,  ZL_mb, 	ZL_mb, 	ZL_mb,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik, ZL_fik,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_fik, ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik};
static	ZLINF	MB10_Inf = { 8, 0, 0, 0};

//static	BYTE	ER10_Ids[] = {
////	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
//	ZL_mbER,ZL_mbER,ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW,	ZL_aMW,	ZL_aMW,
//	ZL_aMW,	ZL_aMW, ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,  ZL_fik, ZL_fik,
////	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
//	ZL_fik, ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik};
//static	ZLINF	ER10_Inf = {14, 2, 8, 0};

static	BYTE	ER11_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mbER,ZL_mbER,ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW,
	ZL_aMW, ZL_aMW, ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_aa,  ZL_aa,  ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik};
static	ZLINF	ER11_Inf = {18, 2, 8, 0};

static	BYTE	ER12_Ids[] = {
//	0/8	1/9	2/10	3/11	4/12	5/13	6/14	7/15
	ZL_mbER,ZL_mbER,ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW, ZL_aMW,
	ZL_aMW, ZL_aMW, ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,  ZL_aa,
//	16/24	17/25	18/26	19/27	20/28	21/29	22/30	23/31
	ZL_aa,  ZL_aa,  ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
//	32/40	33/41	34/42	35/43	36/44	37/45	38/46	39/47
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,	ZL_fik,
	ZL_fik,	ZL_fik};
static	ZLINF	ER12_Inf = {18, 2, 8, 0};

static	BYTE	ER30_Ids[] = {
//	0	1	2	3	4	5	6	7
	ZL_pMW,	ZL_pMW,	ZL_aa ,	ZL_aMW,	ZL_aMW,	ZL_aMW,	ZL_aMW,	ZL_mb };
static	ZLINF	ER30_Inf = { 8, 0, 6, 0};

static	BYTE	Er30_Ids[] = {
//	0	1	2	3	4	5	6	7
	ZL_pMW,	ZL_pMW,	ZL_aa ,	ZL_mb };
static	ZLINF	Er30_Inf = { 4, 0, 2, 0};

/*--------------------------------------------------------------------------*/

static	VADRS	AC40Vs[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V10",	0x5200, 0x52F0, 0x7CA0, 4, 0x7C80, 0x3000, 0x7700, 0x7C00, 0x7700, 0x5000},
{"V11",	0x5200, 0x52F0, 0x7CA0, 4, 0x7C80, 0x3000, 0x7700, 0x7C00, 0x7700, 0x5000},
{"V12",	0x5200, 0x52F0, 0x7CA0, 4, 0x7C80, 0x3000, 0x7700, 0x7C00, 0x7700, 0x5000},
{"V0",  0x5200, 0x52F0, 0x7CA0, 4, 0x7C80, 0x3000, 0x7700, 0x7C00, 0x7700, 0x5000},
{NULL,	0x0000, 0}};

static	VADRS	ZPVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V12",	0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V11",	0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V10",	0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V9",  0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V8",  0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V7",  0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
// modular
//{"V5",  0x1200, 0x12F0,0x2000, 0, 0x2C80, 0x20FD, 0x2400, 0x2BE0, 0x2400, 0x5000},
// nicht modular
{"V5",  0x1200, 0x12F0,SegBkV5, 0, 0x3280, 0x20FD, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V0",  0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{NULL,	0x0000, 0}};

static	VADRS	ZP03Vs[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V0",	0x1200, 0x12F0, 0x2000, 0, 0x2C80, 0x20FD, 0x2400, 0x2BE0, 0x2400, 0x7E00},
{NULL,  0x0000, 0}};

static	VADRS	GWVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V3",	0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V2",	0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{"V0",	0x1200, 0x12F0,SegBkV7, 4, 0x3C80, 0x3000, 0x3700, 0x3C00, 0x3700, 0x5000},
{NULL,	0x0000, 0}};

static	VADRS	BDVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V3",	0x1200, 0x12F0, 0x0000, 4, 0x3C80, 0x3000, 0x0000, 0x0000, 0x0000, 0x0001},
{"V2",	0x1200, 0x12F0, 0x0000, 4, 0x3C80, 0x3000, 0x0000, 0x0000, 0x0000, 0x0001},
{"V1",	0x1200, 0x12F0, 0x0000, 4, 0x3C80, 0x3000, 0x0000, 0x0000, 0x0000, 0x0001},
{"V0",	0x1200, 0x12F0, 0x0000, 4, 0x3C80, 0x3000, 0x0000, 0x0000, 0x0000, 0x0001},
{NULL,	0x0000, 0}};

static	VADRS	ERVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V12",	0x5200, 0x52F0, 0x7CA0, 4, 0x7C80, 0x3000, 0x7700, 0x7C00, 0x7700, 0x5000},
{"V3",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V2",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V1",	0x1200, 0x12F0, 0x0000, 0, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V0",	0x5200, 0x52F0, 0x7CA0, 4, 0x7C80, 0x3000, 0x7700, 0x7C00, 0x7700, 0x5000},
{NULL,	0x0000, 0}};

static	VADRS	MBVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V33",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x07E0, 0x0510, 0x2D00},
{"V3",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V2",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V1",	0x1200, 0x12F0, 0x0000, 0, 0x0500, 0x20FD, 0x0510, 0x0740, 0x0510, 0x2300},
{"V0",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{NULL,	0x0000, 0}};

static	VADRS	ARVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V38",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x07E0, 0x0510, 0x2D00},
{"V3",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V2",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V1",	0x1200, 0x12F0, 0x0000, 0, 0x05A0, 0x20FD, 0x0620, 0x0740, 0x0620, 0x2300},
{"V0",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{NULL,	0x0000, 0}};

static	VADRS	SPVers[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V35",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x07E0, 0x0510, 0x2D00},
{"V3",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V2",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V1",	0x1200, 0x12F0, 0x0000, 0, 0x0500, 0x20FD, 0x0510, 0x0740, 0x0510, 0x2300},
{"V0",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{NULL,	0x0000, 0}};

static	VADRS	AR20Vs[] = {
//	DBSeg   Chks_DB   Bukl     Kopfbs  EndeBst DatSeg  StSeg   OfSeg   ClMax
{"V5",	0x1200, 0x12F0, 0x0000, 4, 0x1FD0, 0x3000, 0x0A00, 0x1000, 0x1FC0, 0x6000},
{"V4",	0x1200, 0x12F0, 0x0000, 4, 0x0500, 0x3000, 0x0510, 0x0740, 0x0510, 0x2300},
{"V0",	0x1200, 0x12F0, 0x0000, 4, 0x1FD0, 0x3000, 0x0A00, 0x1000, 0x1FC0, 0x6000},
{NULL,	0x0000, 0}};

#define	MF_MICMODUL	0x0001
#define	MF_MUSMODUL	0x0002
#define	MF_DBMODUL	0x0004
#define	MF_SKMODUL	0x0008	// Modul mit Dreipunkt-Stellbefehlen
#define	MF_FBMODUL	0x0010
#define	MF_BKMODUL	0x0020
#define	MF_WDMODUL	0x0040	// Module fr WD-Konfigurator
#define	MF_KOPPMOD	0x0080	// Module fr Fremaankopplungen
#define	MF_CANMODUL	0x0100	// Can-Modul

static	MODTBS	ModTab[] = {
//Modul     Alias     Geh„use Stecker iZl efZ Fl Tsk MI
//Data  Stck   Kbst   CLen   OffT1 ZHgt LFakt Vers
{"29ZP03", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0007,
15, 9,ZP03k,0x0050, 20, 1000, ZP03Vs, NULL, Def_STBaud},

{"29ZP10", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0045,
10, 9,ZP10k,0x0000, 50, 1000, ZPVers, NULL, Def_STBaud},

{"29ZP12", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0045,
10, 9,ZP12k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{"29ZP13", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0045,
10, 9,ZP13k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{"29ZM12", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0045,
10, 9,ZM12k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{"29ZM13", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0045,
10, 9,ZM13k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{"29ZM14", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0005,
10, 9,ZM14k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{"29ZM15", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x0005,
10, 9,ZM15k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{"29ZP20", "29ZP20", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x00C5,
10,15,ZP20k,0x0000, 50, 1700, ZPVers, ZP20_Excl, Def_STBaud},

{"29EI12", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x00C5,
10, 9,EI12k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},	// EIB

{"29GW12", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x00C5,
10, 9,GW12k,0x0000, 50, 1700, GWVers, NULL, Def_STBaud},	// Kiback & Peter

{"29GW13", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x00C5,
10, 9,GW13k,0x0000, 50, 1700, GWVers, NULL, Def_STBaud},	// Insum

{"29GW14", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),  &ZP10_Inf, 0x00C5,
10, 9,GW14k,0x0000, 50, 1700, GWVers, NULL, Def_STBaud},	// Sauter

{"29AR20", "29AR20", "29KG10", "",    ZEILEN(AR20_Ids),  &AR20_Inf, 0x0059,
10,11,AR20k,0x0000, 50,  500, AR20Vs, AR20_Excl, Def_ImpTime},

{"29SP20", "29SP20", "29KG10", "",    ZEILEN(SP10_Ids),  &SP10_Inf, 0x0059,
10,12,SP20k,0x0000, 50,  500, AR20Vs, NULL, Def_ImpTime},

{"29AC40", "29AC40", "29KG10", "",    ZEILEN(AC40_Ids),  &AC40_Inf, 0x01DD,
10,14,AC40k,0x0000, 50, 1700, AC40Vs, NULL, GABd19200},

{"29AR11", "29AR11", "29KG10", "",    ZEILEN(AR11_Ids),  &AR11_Inf, 0x0059,
10, 2,AR11k,0x0000, 50,  500, ARVers, AR20_Excl, Def_ImpTime},

{"29SP11", "29SP10", "29KG10", "",    ZEILEN(SP10_Ids),  &SP10_Inf, 0x0059,
10, 8,SP11k,0x0000, 50,  500, SPVers, NULL, Def_ImpTime},

{"29MB11", "29MB10", "29KG10", "X7",  ZEILEN(MB10_Ids),  &MB10_Inf, 0x0051,
10, 7,MB11k,0x0000, 50,  500, MBVers, NULL, Def_ImpTime},

{"29AR10", "29AR10", "29KG10", "",    ZEILEN(AR10_Ids),  &AR10_Inf, 0x0059,
10, 1,AR10k,0x0000, 50,  500, ARVers, NULL, Def_ImpTime},

{"29SP10", "29SP10", "29KG10", "",    ZEILEN(SP10_Ids),  &SP10_Inf, 0x0059,
10, 8,SP10k,0x0000, 50,  500, SPVers, NULL, Def_ImpTime},

{"29MB10", "29MB10", "29KG10", "X7",  ZEILEN(MB10_Ids),  &MB10_Inf, 0x0051,
10, 7,MB10k,0x0000, 50,  500, MBVers, NULL, Def_ImpTime},

//{"29ER10", "29ER11", "29FG10", "",	ZEILEN(ER10_Ids),  &ER10_Inf, 0x0059,
//10, 5,ER10k,0x0000, 50,  500, ARVers, NULL, Def_ImpTime},

{"29ER11", "29ER11", "29FG10", "",	ZEILEN(ER11_Ids),  &ER11_Inf, 0x0059,
10, 5,ER11k,0x0000, 50,  500, ARVers, NULL, Def_ImpTime},

{"ccER12", "29ER11", "29FG10", "",	ZEILEN(ER12_Ids),  &ER12_Inf, 0x00DD,
10, 5,ER12k,0x0000, 50,  500, ERVers, NULL, GABd19200},

{"29ER30", "29ER30", "29ER30", "",    ZEILEN(ER30_Ids),  &ER30_Inf, 0x0051,
0, 6,ER30k,0x0000, 50,  500, ARVers, NULL, Def_ImpTime},

{"29Er30", "29Er30", "29Er30", "",    ZEILEN(Er30_Ids),  &Er30_Inf, 0x51,
0, 6,ER30k,0x0000, 50,  500, ARVers},

{"29BK10", "29BK10", "29KG10", "",    	NULL_ZEILEN,	      NULL, 0x0060,
10, 3,BK10k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BK11", "29BK10", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0060,
10, 3,BK10k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BK12", "29BK10", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0060,
10, 4,BK10k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BK13", "29BK13", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0060,
10,10,BK13k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BK15", "29BK15", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0060,
10,10,BK15k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BK30", "29BK30", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0060,
10,13,BK30k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BK31", "29BK31", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0060,
10,13,BK31k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BD11", "29ZP10", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0040,
10, 9,BD11k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BD20", "29ZP10", "29KG10", "",   	NULL_ZEILEN, 	      NULL, 0x0040,
10, 9,BD11k,0x0000, 50, 1000, BDVers, NULL, Def_STBaud},

{"29BG11", "29ZP10", "29KG10", "",    ZEILEN(ZP10_Ids),       NULL, 0x0005,
10, 9,BG11k,0x0000, 50, 1700, ZPVers, NULL, Def_STBaud},

{NULL, NULL, NULL, NULL}};

static	LPSTR Items[MD_MAXINX+1] = {
	"Mod_Typ","Alias_Typ","Def_Gehause","Def_Stecker",
	 "Zeilen","EF_Zeil","DB_Modul","MUS_Modul","MIC_Modul",
	 "SK_Modul","FB_Modul","BK_Modul","Task_Max","Mod_Index",
	 "VwOff_Tsk1","Zykl_Hgt","LFaktor","Versionen","SteckPlatz",
	 "Bin_Typ","Anzahl",NULL};


/*--------------------------------------------------------------------------*/

WORD	WINAPI GetModHandle (LPSTR Modul)

Begin
WORD	ret,l,mk;
MODTBS	*MD;

MD = ModTab; ret = mk = 0;
if (Modul eq NULL)  goto Exit;
if (HIWORD(Modul)) l = strlen(Modul);
else		   mk = LOWORD(Modul);

While(MD->ModNam)
Begin
  ret++;
  if (mk)
  Then
    if (mk eq MD->binTyp)  goto Exit;
  Else
    if (l < 6)
    Then
      if (strstr(MD->ModNam, Modul)) goto Exit;
    Else
      if (strstr(Modul, MD->ModNam+2)) goto Exit;
    Endif
  Endif
  MD++;
Endwhile
ret = 0;

Exit:
return (ret);

End

/*--------------------------------------------------------------------------*/


LPSTR	WINAPI GetNextModul (LPLONG PTab, LPWORD pMi)

Begin
LPSTR	Nam;
MODTBS	*MD;

MD = (PMDTAB) *PTab;
if (MD eq NULL) MD = ModTab;

While(MD->ModNam)
Begin
  if (MD->Flags band MF_WDMODUL) break;
  MD++;
Endwhile
Nam = MD->ModNam;
*PTab = (LONG) (MD+1);
*pMi = MD - ModTab + 1;

return (Nam);

End


/*--------------------------------------------------------------------------*/

LPSTR	WINAPI GetNAliModul (LPSTR ModAli, LPLONG PTab)

Begin
LPSTR	Nam;
MODTBS	*MD;

MD = (PMDTAB) *PTab;
if (MD eq NULL)
Then
  MD = ModTab-1; Nam = NULL;
  While((++MD)->ModNam)
  Begin
    if ((MD->Flags band MF_WDMODUL) eq 0)  continue; 
    if ( strcmp(MD->ModNam, ModAli) eq 0)  break;
  Endwhile
  if (MD->ModNam eq NULL)  goto Exit;
  strcpy (ModAli, MD->Alias); MD = ModTab-1;
Endif


While((++MD)->ModNam)
Begin
  if ((MD->Flags band MF_WDMODUL) eq 0)  continue; 
  if ( strcmp(MD->Alias, ModAli)  eq 0)	 break;
Endwhile
Nam = MD->ModNam;
*PTab = (LONG) MD;

Exit:
return (Nam);

End


/*--------------------------------------------------------------------------*/

static	WORD	_pascal GetItmIndex (LPSTR Item)

Begin
WORD	ret;
char	**PP;

PP = Items; ret = 1;
While(*PP)
Begin
  if (strstr(*PP, Item)) goto Exit;
  ret++; PP++;
Endwhile
ret = 0;

Exit:
return (ret);

End

/*--------------------------------------------------------------------------*/

DWORD	WINAPI GetModInfo (long Modul, long Item, LPSTR Str)

Begin
PZLINF	PZI;
MODTBS	*MD;
VADRS	*VS;
WORD	mi,it,hw;
DWORD	ret;

ret = 0;
if (HIWORD(Modul)) mi = GetModHandle((LPSTR) Modul);
else		   mi = LOWORD(Modul);
if (HIWORD(Item))  it = GetItmIndex((LPSTR) Item);
else		   it = LOWORD(Item);
if (it eq 0) goto Exit;
if (mi eq 0 and it ne MOD_count) goto Exit;
MD = &ModTab[mi-1];
if (it ne MOD_vsinx and Str) *Str = 0;

Switch (it)
  case  MOD_modul:	if (Str) strcpy(Str, MD->ModNam);
  			else	 ret = mi;
  			break;

  case	MOD_alias:	if (Str) strcpy(Str, MD->Alias);
  			else	 ret = mi;
  			break;
  case	MOD_dgehs:	if (Str) strcpy(Str, MD->DefGeh);
  			else	 ret = mi;
  			break;
  case	MOD_dstck:	if (Str) strcpy(Str, MD->DefStk);
  			else	 ret = mi;
  			break;
  case	MOD_zeil:	if (Str) itoa (MD->Zeilen, Str, 10);
  			else	 ret = MD->Zeilen;
  			break;
  case	MOD_efzl:	PZI = MD->PZI;
			if (PZI eq NULL)  goto Exit;
  			if (Str) itoa (PZI->EFZeil, Str, 10);
  			else	 ret = PZI->EFZeil;
  			break;
  case	MOD_emwzl:	PZI = MD->PZI;
			if (PZI eq NULL)  goto Exit;
  			if (Str) itoa (PZI->EMZeil, Str, 10);
  			else	 ret = PZI->EMZeil;
  			break;
  case	MOD_mzanz:	PZI = MD->PZI;
			if (PZI eq NULL)  goto Exit;
  			if (Str) itoa (PZI->MWZAnz, Str, 10);
  			else	 ret = PZI->MWZAnz;
  			break;
  case	MOD_szmax:	PZI = MD->PZI;
			if (PZI eq NULL)  goto Exit;
  			if (Str) itoa (PZI->SZWMax, Str, 10);
  			else	 ret = PZI->SZWMax;
  			break;
  case	MOD_dbmod:	ret = MD->Flags band MF_DBMODUL;
			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
			break;
  case	MOD_canmd:	ret = MD->Flags band MF_CANMODUL;
			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
			break;
  case	MOD_mumod:	ret = MD->Flags band MF_MUSMODUL;
			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
  			break;
  case	MOD_mimod:	ret = MD->Flags band MF_MICMODUL;
  			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
  			break;
  case	MOD_skmod:	ret = MD->Flags band MF_SKMODUL;
  			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
  			break;
  case	MOD_fbmod:	ret = MD->Flags band MF_FBMODUL;
  			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
  			break;
  case	MOD_bkmod:	ret = MD->Flags band MF_BKMODUL;
  			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
  			break;
  case	MOD_kopmd:	ret = MD->Flags band MF_KOPPMOD;
  			if (Str)
			Then
			  if (ret) strcpy (Str, "J");
			  else	   strcpy (Str, "N");
			Endif
  			break;
  case	MOD_tsmax:	if (Str) itoa (MD->TskMax, Str, 10);
  			else	 ret = MD->TskMax;
  			break;
  case	MOD_modi:	if (Str) itoa (MD->ModInd, Str, 10);
  			else	 ret = MD->ModInd;
  			break;
  case	MOD_offt1:	if (Str) itoa (MD->VwOffT1, Str, 10);
  			else	 ret = MD->VwOffT1;
  			break;
  case	MOD_zykhg:	if (Str) itoa (MD->ZyklHgt, Str, 10);
  			else	 ret = MD->ZyklHgt;
  			break;
  case	MOD_lfakt:	if (Str) itoa (MD->LFaktor, Str, 10);
  			else	 ret = MD->LFaktor;
			break;
  case	MOD_versi:	VS = MD->Versio;
  			While (VS->Version)
			Begin
			  if (Str)
			  Then
			    if (*Str) strcat (Str, ",");
			    strcat (Str, VS->Version);
			  Endif
			  ret++; VS++;
			Endwhile
			break;
  case  MOD_vsinx:      VS = MD->Versio;
                        VS = VS + atoi(Str);
                        strcpy (Str, VS->Version);
                        break;
  case	MOD_dstkv:	if (Str)
  			Then
			  strcpy (Str, MD->DefGeh);
			  strcat (Str, ".");
			  if (strlen(MD->DefStk)) strcat (Str, MD->DefStk);
			  else			  *Str = 0;
			  ret = strlen(Str);
			Endif
  			break;
  case	MOD_bintp:	if (Str) itoa (MD->binTyp, Str, 10);
  			else	 ret = MD->binTyp;
			break;
  case	MOD_count:	hw = sizeof(ModTab)/sizeof(MODTBS)-1;
  			if (Str) itoa (hw, Str, 10);
  			else	 ret = hw;
  			break;
  case  MOD_cexcl:	ret = (DWORD) MD->CSExcl;
			break;
  case	MOD_eesiz:   	Switch (mi)
			  case AC40i:
			  case ER12i:
			  case ZP20i:	hw = 256;
					break;
			  default:	hw = 128;
			Endswitch
  			if (Str) itoa (hw, Str, 10);
  			else	 ret = hw;
  			break;
  case	MOD_impsio:	if (Str) itoa (MD->impSio, Str, 10);
			else	 ret = MD->impSio;
			break;
Endswitch

Exit:
return (ret);

End

/*--------------------------------------------------------------------------*/

WORD	WINAPI GetModInf2 (long Modul, LPSTR Vers, long Item)

Begin
char    HStr[10];
MODTBS	*MD;
VADRS	*VS;
WORD	mi,ret,it,len;

ret = 0;
if (HIWORD(Modul)) mi = GetModHandle((LPSTR) Modul);
else		   mi = LOWORD(Modul);
if (mi eq 0) goto Exit;
if (HIWORD(Item))  it = GetItmIndex((LPSTR) Item);
else		   it = LOWORD(Item);
if (it eq 0) goto Exit;
MD = &ModTab[mi-1];

VS = MD->Versio;
While (VS->Version)
Begin
  len = strlen(VS->Version);
  if (memcmp(Vers, VS->Version, len) eq 0)
  Then
    Switch (it)
      case MOD_bkseg:	ret = VS->SegBukl;
			break;
      case MOD_eeoff:	ret = VS->EEOff;
      			break;
      case MOD_kbseg:	ret = VS->KBSeg;
      			break;
      case MOD_endbs:	ret = VS->EndBst;
      			break;
      case MOD_dtseg:	ret = VS->DataSeg;
  			break;
      case MOD_stseg:	ret = VS->StackSeg;
  			break;
      case MOD_ofseg:	ret = VS->OffsSeg;
  			break;
      case MOD_clmax:	ret = VS->CLenMax;
  			break;
      case MOD_dbseg:   ret = VS->Seg_DB;
                        break;
      case MOD_dbcks:   ret = VS->Cks_DB;
                        break;
      case MOD_eecmd:   ret = 1;
			if (mi eq AC40i or mi eq ER12i)		   break;
			strcpy (HStr, Vers); HStr[2] = 0;
			// bei ZP20 und Version > 10 oder 0 ... CDE möglich
			if (mi eq ZP20i and strstr("V0,V1", HStr)) break;
			ret = 0;
			break;
    Endswitch
    goto Exit;
  Endif
  VS++;
Endwhile

Exit:
return (ret);

End

/*--------------------------------------------------------------------------*/

#ifndef	_MICAS_

int WINAPI GetTypId (long Modul, WORD iZ)

Begin
MODTBS	*MD;
WORD	mi;
int	ret;
LPBYTE	ZID;

ret = NoTyp_Id;
if (HIWORD(Modul)) mi = GetModHandle((LPSTR) Modul);
else		   mi = LOWORD(Modul);
if (mi eq 0) goto Exit;
MD = &ModTab[mi-1];
ZID = MD->TypIds;
if (ZID eq NULL or iZ >= MD->Zeilen) goto Exit;
ret = *(ZID+iZ);

Exit:
return (ret);

End

#endif
/*--------------------------------------------------------------------------*/

#ifndef	_MICAS_

ZLKls	WINAPI GetTypKls (long Modul, WORD iZ, WORD KV)

Begin
MODTBS	*MD;
WORD	mi;
int	hi;
ZLKls	ret;
LPBYTE	ZID;

ret = KLNone;
if (HIWORD(Modul)) mi = GetModHandle((LPSTR) Modul);
else		   mi = LOWORD(Modul);
if (mi eq 0) goto Exit;
MD = &ModTab[mi-1];
ZID = MD->TypIds;
if (ZID eq NULL) goto Exit;
if (iZ < MD->Zeilen)
Then
  hi = *(ZID+iZ);
  Switch (hi)
    case ZL_mb:
    case ZL_mb01:
    case ZL_mb23:
    case ZL_mbER:	ret = KL_MBZ;
			break;
    case ZL_IRZ:
    case ZL_HWZ:	ret = KL_HZL;
			break;

    case ZL_aMW:	ret = KL_aMW;
			break;
    case ZL_pMW:
    case ZL_EMW:	ret = KL_pMW;
			break;
    case ZL_aa:		ret = KL_aST;
			break;
    case ZL_fik:	ret = KL_fik;
			break;
  Endswitch
Else
  if ((MD->Flags band MF_KOPPMOD) eq 0) goto Exit;
  Switch (mi)
    case EI12i:	ret = KL_EIB;
		break;
    case GW12i:	ret = KL_KIP;
		break;
    case GW13i:	ret = KL_INS;
		break;
    case GW14i:	ret = KL_SAU;
		break;
    case ZP20i:
    case ER12i:
    case AC40i:
	Switch(KV)
	  case KV_EIB:	ret = KL_EIB;
			break;
	  case KV_KIP:	ret = KL_KIP;
			break;
	  case KV_SAU:	ret = KL_SAU;
			break;
	  case KV_LON:	ret = KL_LON;
			break;
	  case KV_MBU:	ret = KL_MBU;
			break;
	  case KV_MOD:	ret = KL_MOD;
			break;
	  case KV_CAN:	ret = KL_CAN;
			break;
	  default:	ret = KLNone;
	Endswitch
	break;
  Endswitch
Endif

Exit:
return (ret);

End

#endif
/*--------------------------------------------------------------------------*/

#ifndef	_MICAS_

ZLKls	WINAPI GetTypKls2(long Modul, WORD iZ, WORD ZG, WORD KV)

Begin
MODTBS	*MD;
WORD	mi;
int	hi;
ZLKls	ret;
LPBYTE	ZID;

ret = KLNone;
if (HIWORD(Modul)) mi = GetModHandle((LPSTR) Modul);
else		   mi = LOWORD(Modul);
if (mi eq 0) goto Exit;
MD = &ModTab[mi-1];
ZID = MD->TypIds;
if (ZID eq NULL) goto Exit;
if (iZ < MD->Zeilen)
Then
  hi = *(ZID+iZ);
  Switch (hi)
    case ZL_mb:
    case ZL_mb01:
    case ZL_mb23:
    case ZL_mbER:	ret = KL_MBZ;
			break;
    case ZL_IRZ:
    case ZL_HWZ:	ret = KL_HZL;
			break;

    case ZL_aMW:	ret = KL_aMW;
			break;
    case ZL_pMW:
    case ZL_EMW:	ret = KL_pMW;
			break;
    case ZL_aa:		ret = KL_aST;
			break;
    case ZL_fik:	ret = KL_fik;
			break;
  Endswitch
Else
  if ((MD->Flags band MF_KOPPMOD) eq 0) goto Exit;
  if (iZ < ZG)
  Then
     ret = KL_fMB;  goto Exit;
  Endif
  Switch (mi)
    case EI12i:	ret = KL_EIB;
		break;
    case GW12i:	ret = KL_KIP;
		break;
    case GW13i:	ret = KL_INS;
		break;
    case GW14i:	ret = KL_SAU;
		break;
    case ZP20i:
    case ER12i:
    case AC40i:
	Switch(KV)
	  case KV_EIB:	ret = KL_EIB;
			break;
	  case KV_KIP:	ret = KL_KIP;
			break;
	  case KV_SAU:	ret = KL_SAU;
			break;
	  case KV_LON:	ret = KL_LON;
			break;
	  case KV_MBU:	ret = KL_MBU;
			break;
	  case KV_MOD:	ret = KL_MOD;
			break;
	  case KV_CAN:	ret = KL_CAN;
			break;
	  default:	ret = KLNone;
	Endswitch
	break;
  Endswitch
Endif

Exit:
return (ret);

End

#endif
/*---------------------------------------------------------------------------*/
#ifndef	_MICAS_

LPSTR	WINAPI	DusTyp2Name (LPVOID EEDat)

Begin
PEDATA	Cfg;
LPSTR	ret;
MODTBS	*MD;
WORD	HWTyp;

MD = ModTab;
ret = "29????";
if (HIWORD(EEDat))
Then
  Cfg = (PEDATA) EEDat;
  HWTyp = Cfg->HW_Typ;
Else
  HWTyp = LOWORD(EEDat);
Endif

While(MD->ModNam)
Begin
  if (MD->binTyp eq HWTyp)
  Then
    ret = MD->ModNam; break;
  Endif
  MD++;
Endwhile
return (ret);

End

#endif
/*---------------------------------------------------------------------------*/
#ifndef	_MICAS_

int	WINAPI	IsSTused (LPVOID EEDat, WORD iZ)

Begin
PEDATA	Cfg;
int	ret;
WORD	Inf0,Inf1;

//	eine interne Messwert-Zeile, die als ST fuer 1F oder OE/ST fuer SA
//	verwendet wird, ist fuer die Konfiguration nicht mehr vorhanden.
Cfg = (PEDATA) EEDat; ret = 0;
Inf0 = Cfg->KW[0].V1.Info;
Inf1 = Cfg->KW[1].V1.Info;

if (Cfg->HW_Typ ne ER10k or Cfg->HW_Typ ne ER11k) goto Exit;

if (Cfg->KW[1].V1.Used)
Then
  Switch (iZ)	// nur fuer die folgenden Faelle ist 
		// Dat.config[i].TypeId == ZEILEmw
    case 2:	// E1 
		if (Inf0 band 1) ret++;
		break;
    case 3:	// E2 
		if (Inf0 band 2) ret++;
		break;
    case 4:	// E3 
		if (Inf0 band 4) ret++;
		break;
    case 5:	// E4
		if (Inf0 band 8) ret++;
		break;
    case 6:	// E5
		if (Inf1 band 1) ret++;
		break;
    case 7:	// E6
		if (Inf1 band 2) ret++;
		break;
    case 8:	// E7
		if (Inf1 band 4) ret++;
		break;
    case 9:	// E8
		if (Inf1 band 8) ret++;
		break;
  Endswitch
Endif

Exit:
return (ret);

End

#endif
/*---------------------------------------------------------------------------*/
#ifndef	_MICAS_

int	WINAPI	IsSAMess (LPVOID EEDat, WORD iZ)

/*F
**.* Beschreibung :
**
**	Aktuellen Pfad aufsetzen.
**
**	Anmerkung:
**	Ein Messwert darf nur einen 3-Pkt.Stell-Bef. zugeordnet sein.
**	Die Funktion gibt daher nur den ersten (und einzigen) Messwert
**	zurueck, fuer den IS_BELEGT_EQU() wahr ist.
**
**.* Funktionswerte :
**
**	Falls die interne Zeile einem 3-Pkt.Stell-Bef. zugeornet ist:
**	    den Index des Stell-Bef.Kontrollwortes (0...7),
**	sonst MaxSK (8).
**
*/

Begin
int	i;
PEDATA	Cfg;

Cfg = (PEDATA) EEDat;

for (i=0; i<MaxSK; i++)
Begin
  if (Cfg->SKW.SK[i].SB.MwZeil eq iZ and IsSTValid(EEDat, i)) break;
Endfor
return (i);

End


#endif

//-----------------------------------------------------------------------------

#ifndef	_MICAS_

#define SK_INDEX_2_SPALTE(i)		(((i)%4)*4+3)
#define SK_INDEX_2_FKT_INFO(i)		((i)/2)
#define SK_INDEX_2_BELEGT(i)		(((i)/4)*2+1)

int	WINAPI	IsSTValid (LPVOID EEDat, WORD si)

/*F
**.* Beschreibung :
**
**	Test ob Stellbef.Kontrollwort gueltig.
**
**.* Funktionswerte :
**
**	TRUE  = Stellbef.Kontrollwort gueltig
**	FALSE = Stellbef.Kontrollwort nicht gueltig
**
*/

Begin
LPSTR	Modul;
int	ret,bZ,kZ;
WORD	Fkt,Info,TId;
PEDATA	Cfg;

Cfg = (PEDATA) EEDat;
Modul = DusTyp2Name (EEDat); ret = 0;
if (Modul eq NULL) goto Exit;
bZ = SK_INDEX_2_BELEGT (si);
kZ = SK_INDEX_2_FKT_INFO (si);

if (Cfg->KW[bZ].V1.Used)
Then
  TId = GetTypId ((long) Modul, bZ);
  Info = Cfg->KW[kZ].V1.Info;
  Fkt  = Cfg->KW[kZ].V1.Fkt;
  Switch (TId)
   case ZL_mb01:
	/*
	 * nur 29MB10, 29MB11 haben ZEILEmb, aber keinen 3-Pkt-Stell-Bef.
	 * case ZEILEmb:
	 */
   case ZL_mb23:	if (Info eq 3 or Info eq 4) ret++;
			break;

   case ZL_mbER:	if (Fkt band 4 and ((Fkt band 1 and
			   ((si eq 0) or (si eq 2))) or
			   (Fkt band 2 and ((si eq 1) or (si eq 3))))) ret++;
			break;

  Endswitch
Endif

Exit:
return (ret);

End

#endif
/*---------------------------------------------------------------------------*/
#ifndef	_MICAS_

static	DWORD	GABaud[] = {GABd__150, 150,
			    GABd__300, 300,
			    GABd__600, 600,
			    GABd_1200,1200,
			    GABd_2400,2400,
			    GABd_4800,4800,
			    GABd_9600,9600,
			    GABd19200,19200,
			    GABd38400,38400,
			    GABd57600,57600,
			    GABd115_k,115200};

static	DWORD	CANBit[] = {CAN___10k,  10,
			    CAN___20k,  20,
			    CAN___50k,  50,
			    CAN__125k, 125,
			    CAN__250k, 250,
			    CAN__500k, 500,
			    CAN_1000k,1000};

//----------------------------------------------------------------------------

static	char	AC40Mods[] = {AC40k,ER12k,0};

DWORD	WINAPI	GetMMKBaud (LPVOID EEDat)

Begin
DWORD	ret;
PEDATA	Cfg;

Cfg = (PEDATA) EEDat;
if (strchr(AC40Mods, Cfg->HW_Typ))
Then
  ret = Cfg->EE.AC40.SioCtrl.Bit.Baud;
Else
  ret = Cfg->Imp_Sio;
Endif
ret = GABdi2ext(ret);
return (ret);

End

//----------------------------------------------------------------------------


VOID	WINAPI	SetMMKBaud (LPVOID EEDat, WORD iVal)

Begin
PEDATA	Cfg;

Cfg = (PEDATA) EEDat;
if (strchr(AC40Mods, Cfg->HW_Typ))
Then
  Cfg->EE.AC40.SioCtrl.Bit.Baud = iVal;
Else
  Cfg->Imp_Sio = iVal;
Endif

End

//----------------------------------------------------------------------------


WORD	WINAPI	IsMMKProto (LPVOID EEDat)

Begin
WORD	ret,hw;
PEDATA	Cfg;

Cfg = (PEDATA) EEDat; ret = 0;
if (strchr(AC40Mods, Cfg->HW_Typ))
Then
  ret = 1;
  hw = Cfg->EE.AC40.TCPCtrl band 0x007C;
  if (hw)  goto Exit;
  //hw = Cfg->EE.AC40.GWMode;
  hw = Cfg->EE.AC40.GWType;
  if (hw)  goto Exit;
  //hw = Cfg->EE.AC40.LONMode;
  //if (hw and strchr("\122\123\126", hw))  goto Exit;
  ret = 0;
Endif

Exit:
return (ret);


End

/*---------------------------------------------------------------------------*/

DWORD	WINAPI	CNInx2Baud (WORD Inx, WORD Ext)

Begin
DWORD	ret;
WORD	n;
LPDWORD	wp;

ret = n = sizeof(CANBit)>>3;
if (Inx eq 0) goto Exit;
ret = 0;
if (Inx > n) goto Exit;
Inx--;  wp = CANBit;
n = Inx<<1; if (Ext) n++;
ret = *(wp+n);

Exit:
return(ret);

End

/*---------------------------------------------------------------------------*/

DWORD	WINAPI	CNBaud2Inx (DWORD Bd, WORD Ext)

Begin
DWORD	hw;
DWORD	ret,i,n;
LPDWORD	wp;

// 125 ist Default
wp = CANBit; ret = CAN__125k;
n =  sizeof(CANBit)>>3;
for (i=1;i<=n; i++)
Begin
  hw = *wp++;
  if (Ext) hw = *wp;
  wp++;
  if (Bd eq hw)
  Then
    ret = i; break;
  Endif
Endfor
return (ret);

End

/*---------------------------------------------------------------------------*/

DWORD	WINAPI	GABdi2ext (DWORD baudrate)

Begin
LPDWORD	wp;
DWORD	i,hw,n;
DWORD	ret,bd;

wp = GABaud; ret = 9600;
n =  sizeof(GABaud)>>3;
for (i=0;i<n; i++)
Begin
  hw = *wp++; bd = *wp++;
  if (baudrate eq hw)
  Then
    ret = bd; break;
  Endif
Endfor
return (ret);

End

/*---------------------------------------------------------------------------*/

DWORD	WINAPI	GAInx2Baud (WORD Inx, WORD Ext)

Begin
DWORD	ret;
WORD	n;
LPDWORD	wp;

ret = n = sizeof(GABaud)>>3;
if (Inx eq 0) goto Exit;
ret = 0;
if (Inx > n) goto Exit;
Inx--;  wp = GABaud;
n = Inx<<1; if (Ext) n++;
ret = *(wp+n);

Exit:
return(ret);

End

/*---------------------------------------------------------------------------*/

DWORD	WINAPI	GABaud2Inx (DWORD Bd, WORD Ext)

Begin
DWORD	hw;
DWORD	ret,i,n;
LPDWORD	wp;

// 9600 ist Default
wp = GABaud; ret = GABd_9600;
n =  sizeof(GABaud)>>3;
for (i=1;i<=n; i++)
Begin
  hw = *wp++;
  if (Ext) hw = *wp;
  wp++;
  if (Bd eq hw)
  Then
    ret = i; break;
  Endif
Endfor
return (ret);

End

#endif
/*---------------------------------------------------------------------------*/
#ifndef	_MICAS_

static	WORD	PBBaud[] = {RSBd_1200,1200,
			    RSBd_2400,2400,
			    RSBd_4800,4800,
			    RSBd_9600,9600,
			    RSBd19200,19200};

/*---------------------------------------------------------------------------*/

WORD	WINAPI	PBBdi2ext (WORD baudrate)

Begin
LPWORD	wp;
WORD	i,ret,n;
WORD	hw,bd;

wp = PBBaud; ret = 0;
n =  sizeof(PBBaud)>>2;
for (i=0;i<n; i++)
Begin
  hw = *wp++; bd = *wp++;
  if (baudrate eq hw)
  Then
    ret = bd; break;
  Endif
Endfor
return (ret);

End

/*---------------------------------------------------------------------------*/

WORD	WINAPI	PBInx2Baud (WORD Inx, WORD Ext)

Begin
WORD	ret,n;
LPWORD	wp;

ret = n = sizeof(PBBaud)>>2;
if (Inx eq 0) goto Exit;
ret = 0;
if (Inx > n) goto Exit;
Inx--;  wp = PBBaud;
n = Inx<<1; if (Ext) n++;
ret = *(wp+n);

Exit:
return(ret);

End

/*---------------------------------------------------------------------------*/

WORD	WINAPI	PBBaud2Inx (WORD Bd, WORD Ext)

Begin
WORD	ret,hw,i,n;
LPWORD	wp;

wp = PBBaud; ret = 0;
n =  sizeof(PBBaud)>>2;
for (i=1;i<=n; i++)
Begin
  hw = *wp++;
  if (Ext) hw = *wp;
  wp++;
  if (Bd eq hw)
  Then
    ret = i; break;
  Endif
Endfor
return (ret);

End

#endif
/*---------------------------------------------------------------------------*/
#ifndef	_MICAS_

WORD	WINAPI	GetEEDat (LPVOID EEDat, WORD Id)

Begin
LPBYTE  LP;
WORD	ret;
BYTE	hb;
PEDATA	Cfg;

Cfg = (PEDATA) EEDat;
Switch (Id)
  case EEgwErsteZeile:	ret = Cfg->SKW.GW.EZeile;
			break;
  case EEpclsInterface:	ret = Cfg->SKW.PC.LS.Bit.DIf;
			break;
  case EEpclsSio:	ret = Cfg->SKW.PC.LS.Bit.Sio;
			break;
  case EEpclsModem:	ret = Cfg->SKW.PC.LS.Bit.Modem;
			break;
  case EEpclsTurbo:	ret = Cfg->SKW.PC.LS.Bit.Turbo;
			break;
  case EEpclsTyp:	hb = Cfg->SKW.PC.LS.B0; ret = 0;
			Switch (hb)
			  case 0x13:	ret = 1;
					break;
			  case 0x1B:	ret = 2;
					break;
			Endswitch
			break;
  case EEpclsMinPrio:	ret = Cfg->SKW.PC.LS.Bit.MPrio;
			break;
  case EEpclsErrZlt:	ret = Cfg->SKW.PC.LS.Bit.EMZlt ? 0 : 1;
			break;
  case EEpclsMsgSio:	ret = Cfg->SKW.PC.LS.Bit.MSio ? 0 : 1;
			break;
  case EEpclsValid:	ret = Cfg->SKW.PC.LS.Bit.Valid;
			break;
  case EEpclsTranspose:	ret = Cfg->SKW.PC.LS.Bit.UseTrs;
			break;
  case EEgwUsed:	ret = Cfg->SKW.PC.LS.Bit.UseTrs;
			break;
  case EEgwProGeraet:	ret = Cfg->SKW.GW.ProGeraet;
			break;
  case EEpclsHostL:	ret = Cfg->SKW.PC.Host.LW;
			break;
  case EEpclsHostH:	ret = Cfg->SKW.PC.Host.HW;
			break;
  case EEgwZeilenZahl:	ret = Cfg->SKW.GW.Zeilen;
			break;
  case EEpclsNetmskL:	ret = Cfg->SKW.PC.NMsk.LW;
			break;
  case EEpclsNetmskH:	ret = Cfg->SKW.PC.NMsk.HW;
			break;
  case EEpclsGlobZeil:	ret = Cfg->SKW.PC.GlobZeil;
			break;
  case EEpclsBaudSio2:	ret = Cfg->SKW.PC.BaudSio2;
			break;
  case EEpclsBaudPB:	ret = Cfg->SKW.PC.PVB.Baud;
			break;
  case EEpclsStoerZyk:	ret = Cfg->SKW.PC.PVB.SZyk;
			break;
  case EEpclsGerAdr:	ret = Cfg->SKW.PC.GerAdr;
			break;
  case EEpclsMaxAdr:	ret = Cfg->SKW.PC.maxAdr;
			break;
  case EEpclsMaxTel:	ret = Cfg->SKW.PC.maxTel;
			break;
  case EEBaudBedSt:	ret = Cfg->Imp_Sio;
			break;
  case EEpclsMdBaud:	ret = Cfg->SKW.PC.BaudSio2;
			break;
  case EEGABdFern:	ret = Cfg->GA.BaudGA;
			break;
  case EEGABaud:	ret = Cfg->GA.GAB.Baud;
			break;
  case EEGASZykl:	ret = Cfg->GA.GAB.SZyk;
			break;
  case EESoftType:	ret = Cfg->SW.B;
			break;
  case ZP20IP_INNetL:	ret = Cfg->SKW.PC.Host.LW;
			break;
  case ZP20IP_INNetH:	ret = Cfg->SKW.PC.Host.HW;
			break;
  case ZP20IP_ETNetL:	ret = LOWORD(Cfg->EE.ZP20.IP_ETNet);
			break;
  case ZP20IP_ETNetH:	ret = HIWORD(Cfg->EE.ZP20.IP_ETNet);
			break;
  case ZP20IP_ModemL:	ret = LOWORD(Cfg->EE.ZP20.IP_Modem);
			break;
  case ZP20IP_ModemH:	ret = HIWORD(Cfg->EE.ZP20.IP_Modem);
  			break;
  case ZP20IP_PHBusL:	ret = LOWORD(Cfg->EE.ZP20.IP_PHBus);
  			break;
  case ZP20IP_PHBusH:	ret = HIWORD(Cfg->EE.ZP20.IP_PHBus);
  			break;
  case ZP20IP_BedienL:	ret = LOWORD(Cfg->EE.ZP20.IP_Bedien);
  			break;
  case ZP20IP_BedienH:	ret = HIWORD(Cfg->EE.ZP20.IP_Bedien);
  			break;
  case ZP20MS_ETNet:	ret = LOWORD(Cfg->EE.ZP20.MS_ETNet);
  			break;
  case ZP20MS_Modem:	ret = LOWORD(Cfg->EE.ZP20.MS_Modem);
  			break;
  case ZP20MS_PHBus:	ret = LOWORD(Cfg->EE.ZP20.MS_PHBus);
  			break;
  case ZP20MS_Bedien:	ret = LOWORD(Cfg->EE.ZP20.MS_Bedien);
  			break;
  case ZP20NetModus:	ret = Cfg->EE.ZP20.EthCtrl >> 8;
			break;
  case ZP20Coax:	ret = Cfg->EE.ZP20.EthCtrl band 0x00ff;
  			break;
  case ZP20Gway1L:	ret = LOWORD(Cfg->EE.ZP20.Gatway1);
  			break;
  case ZP20Gway1H:	ret = HIWORD(Cfg->EE.ZP20.Gatway1);
			break;
  case ZP20Host1L:	ret = LOWORD(Cfg->EE.ZP20.HostAd1);
  			break;
  case ZP20Host1H:	ret = HIWORD(Cfg->EE.ZP20.HostAd1);
			break;
  case ZP20Gway2L:	ret = LOWORD(Cfg->EE.ZP20.Gatway2);
			break;
  case ZP20Gway2H:	ret = HIWORD(Cfg->EE.ZP20.Gatway2);
			break;
  case ZP20Host2L:	ret = LOWORD(Cfg->EE.ZP20.HostAd2);
			break;
  case ZP20Host2H:	ret = HIWORD(Cfg->EE.ZP20.HostAd2);
			break;
  case ZP20GWType:	ret = Cfg->EE.ZP20.GWType;
  			break;
  case ZP20GW_RW:	ret = Cfg->EE.ZP20.GW_RW;
  			break;
  case ZP20LONMode:	ret = Cfg->EE.ZP20.LONMode;
  			break;
  case ZP20GWZeil1:	ret = Cfg->EE.ZP20.GWZeil1;
  			break;
  case ZP20GWZeilen:	ret = Cfg->EE.ZP20.GWZeilen;
  			break;
  case ZP20WDInfo:	ret = Cfg->EE.ZP20.WDInfo;
  			break;
  case ZP20TimSvrL:     LP = (LPBYTE) &ret;
                        memcpy (LP, Cfg->EE.ZP20.TimeSvr, 2);
                        break;
  case ZP20TimSvrH:     ret = Cfg->EE.ZP20.TimeSvr[2];
                        break;
  default:		ret = 0;
Endswitch
return (ret);

End

/*---------------------------------------------------------------------------*/

void	WINAPI	PutEEDat (LPVOID EEDat, WORD Id, WORD Val)

Begin
LPBYTE  LP;
PEDATA	Cfg;
LONG	hl;
BYTE	hb;

Cfg = (PEDATA) EEDat;
Switch (Id)
  case EEgwErsteZeile:	Cfg->SKW.GW.EZeile = Val;
			break;
  case EEpclsInterface:	Cfg->SKW.PC.LS.Bit.DIf = Val;
			break;
  case EEpclsSio:	Cfg->SKW.PC.LS.Bit.Sio = Val;
			break;
  case EEpclsTyp:	Switch (Val)
			  case 0:  hb = 0x00;
				   break;
			  case 1:  hb = hb bor 0x13;
				   break;
			  case 2:  hb = hb bor 0x1B;
				   break;
			  default: hb = Cfg->SKW.PC.LS.B0;
			Endswitch
			Cfg->SKW.PC.LS.B0 = hb;
			break;
  case EEpclsModem:	Cfg->SKW.PC.LS.Bit.Modem = Val;
			break;
  case EEpclsTurbo:	Cfg->SKW.PC.LS.Bit.Turbo = Val;
			break;
  case EEpclsMinPrio:	Cfg->SKW.PC.LS.Bit.MPrio = Val;
			break;
  case EEpclsErrZlt:	Cfg->SKW.PC.LS.Bit.EMZlt = Val ? 0 : 1;
			break;
  case EEpclsMsgSio:	Cfg->SKW.PC.LS.Bit.MSio = Val ? 0 : 1;
			break;
  case EEpclsValid:	Cfg->SKW.PC.LS.Bit.Valid = Val;
			break;
  case EEpclsTranspose:	Cfg->SKW.PC.LS.Bit.UseTrs = Val;
			break;
  case EEgwUsed:	Cfg->SKW.PC.LS.Bit.UseTrs = Val;
			break;
  case EEgwProGeraet:	Cfg->SKW.GW.ProGeraet = Val;
			break;
  case EEpclsHostL:	Cfg->SKW.PC.Host.LW = Val;
			break;
  case EEpclsHostH:	Cfg->SKW.PC.Host.HW = Val;
			break;
  case EEgwZeilenZahl:	Cfg->SKW.GW.Zeilen = Val;
			break;
  case EEpclsNetmskL:	Cfg->SKW.PC.NMsk.LW = Val;
			break;
  case EEpclsNetmskH:	Cfg->SKW.PC.NMsk.HW = Val;
			break;
  case EEpclsGlobZeil:	Cfg->SKW.PC.GlobZeil = Val;
			break;
  case EEpclsBaudSio2:	Cfg->SKW.PC.BaudSio2 = Val;
			break;
  case EEpclsBaudPB:	Cfg->SKW.PC.PVB.Baud = Val;
			break;
  case EEpclsStoerZyk:	Cfg->SKW.PC.PVB.SZyk = Val;
			break;
  case EEpclsGerAdr:	Cfg->SKW.PC.GerAdr = Val;
			break;
  case EEpclsMaxAdr:	Cfg->SKW.PC.maxAdr = Val;
			break;
  case EEpclsMaxTel:	Cfg->SKW.PC.maxTel = Val;
			break;
  case EEBaudBedSt:	Cfg->Imp_Sio = Val;
			break;
  case EEpclsMdBaud:	Cfg->SKW.PC.BaudSio2 = Val;
			break;
  case EEGABdFern:	Cfg->GA.BaudGA = Val;
  			break;
  case EEGABaud:	Cfg->GA.GAB.Baud = Val;
  			break;
  case EEGASZykl:	Cfg->GA.GAB.SZyk = Val;
  			break;
  case EESoftType:	Cfg->SW.B = Val;
  			break;
  case ZP20IP_INNetL:	Cfg->SKW.PC.Host.LW = Val;
			break;
  case ZP20IP_INNetH:	Cfg->SKW.PC.Host.HW = Val;
			break;
  case ZP20IP_ETNetL:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.IP_ETNet));
  			Cfg->EE.ZP20.IP_ETNet = hl;
  			break;
  case ZP20IP_ETNetH:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.IP_ETNet),Val);
  			Cfg->EE.ZP20.IP_ETNet = hl;
  			break;
  case ZP20IP_ModemL:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.IP_Modem));
  			Cfg->EE.ZP20.IP_Modem = hl;
  			break;
  case ZP20IP_ModemH:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.IP_Modem),Val);
  			Cfg->EE.ZP20.IP_Modem = hl;
  			break;
  case ZP20IP_PHBusL:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.IP_PHBus));
  			Cfg->EE.ZP20.IP_PHBus = hl;
  			break;
  case ZP20IP_PHBusH:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.IP_PHBus),Val);
  			Cfg->EE.ZP20.IP_PHBus = hl;
  			break;
  case ZP20IP_BedienL:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.IP_Bedien));
  			Cfg->EE.ZP20.IP_Bedien = hl;
  			break;
  case ZP20IP_BedienH:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.IP_Bedien),Val);
  			Cfg->EE.ZP20.IP_Bedien = hl;
  			break;
  case ZP20MS_ETNet:	Cfg->EE.ZP20.MS_ETNet = Val;
  			break;
  case ZP20MS_Modem:	Cfg->EE.ZP20.MS_Modem = Val;
  			break;
  case ZP20MS_PHBus:	Cfg->EE.ZP20.MS_PHBus = Val;
  			break;
  case ZP20MS_Bedien:	Cfg->EE.ZP20.MS_Bedien = Val;
  			break;
  case ZP20NetModus:	Val = Val << 8;
			Cfg->EE.ZP20.EthCtrl = Cfg->EE.ZP20.EthCtrl bor Val;
			break;
  case ZP20Coax:	Val = Val band 0x00ff;
			Cfg->EE.ZP20.EthCtrl = Cfg->EE.ZP20.EthCtrl bor Val;
  			break;
  case ZP20Gway1L:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.Gatway1));
  			Cfg->EE.ZP20.Gatway1 = hl;
  			break;
  case ZP20Gway1H:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.Gatway1),Val);
  			Cfg->EE.ZP20.Gatway1 = hl;
  			break;
  case ZP20Host1L:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.HostAd1));
  			Cfg->EE.ZP20.HostAd1 = hl;
  			break;
  case ZP20Host1H:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.HostAd1),Val);
  			Cfg->EE.ZP20.HostAd1 = hl;
  			break;
  case ZP20Gway2L:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.Gatway2));
  			Cfg->EE.ZP20.Gatway2 = hl;
  			break;
  case ZP20Gway2H:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.Gatway2),Val);
  			Cfg->EE.ZP20.Gatway2 = hl;
  			break;
  case ZP20Host2L:	hl = MAKELONG(Val,HIWORD(Cfg->EE.ZP20.HostAd2));
  			Cfg->EE.ZP20.HostAd2 = hl;
  			break;
  case ZP20Host2H:	hl = MAKELONG(LOWORD(Cfg->EE.ZP20.HostAd2),Val);
  			Cfg->EE.ZP20.HostAd2 = hl;
  			break;
  case ZP20GWType:	Cfg->EE.ZP20.GWType = Val;
  			break;
  case ZP20GW_RW:	Cfg->EE.ZP20.GW_RW = Val;
  			break;
  case ZP20LONMode:	Cfg->EE.ZP20.LONMode = Val;
  			break;
  case ZP20GWZeil1:	Cfg->EE.ZP20.GWZeil1 = Val;
  			break;
  case ZP20GWZeilen:	Cfg->EE.ZP20.GWZeilen = Val;
  			break;
  case ZP20WDInfo:	Cfg->EE.ZP20.WDInfo = Val;
  			break;
  case ZP20TimSvrL:     LP = (LPBYTE) &Val;
                        memcpy (Cfg->EE.ZP20.TimeSvr, LP, 2);
                        break;
  case ZP20TimSvrH:     Cfg->EE.ZP20.TimeSvr[2] = LOBYTE(Val);
                        break;
Endswitch

End

#endif
