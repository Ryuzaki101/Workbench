/*K
**      Modul Name....: TH_DDE.C
**
**      Funktion......: DDE Funktionen WTH86
**
**      Versionsdatum.: 08.05.1996
**
**      Autor.........: U. Stahl   - ABB GAT/T
**
*/

#include        <windows.h>
#include        <wredef.h>
#include        <stdio.h>
#include	<stdlib.h>
#include        <string.h>
#include        <ctype.h>
#include	"..\gat\gatfnk.h"

#pragma	hdrstop

#include	"gatmod.h"
#include	"wth86.h"
#include	<ddeml.h>

//#define DEBUG_DDE


/*  STRUCTURES  */
typedef BOOL        (PASCAL *CBFNIN)(HDDEDATA);
typedef HDDEDATA    (PASCAL *CBFNOUT)(HDDEDATA);

typedef struct _DDEFORMATTBL {
    WORD            wFmt;
    CBFNIN	    lpfnPoke;
    CBFNOUT         lpfnRequest;
} DDEFORMATTBL;
typedef DDEFORMATTBL *PDDEFORMATTBL;
typedef DDEFORMATTBL FAR *LPDDEFORMATTBL;

typedef struct _DDEITEMTBL {
    LPSTR           pszItem;
    HSZ             hszItem;
    CBFNIN          lpfnExecute;
    WORD            cFormats;
    LPDDEFORMATTBL  fmt;
} DDEITEMTBL;
typedef DDEITEMTBL FAR *PDDEITEMTBL;
typedef DDEITEMTBL FAR *LPDDEITEMTBL;


typedef struct _DDETOPICTBL {
    LPSTR           pszTopic;
    HSZ             hszTopic;
    WORD            cItems;
    LPDDEITEMTBL     item;
} DDETOPICTBL;
typedef DDETOPICTBL *PDDETOPICTBL;
typedef DDETOPICTBL FAR *LPDDETOPICTBL;

typedef struct _DDESERVICETBL {
    LPSTR           pszService;
    HSZ             hszService;
    WORD            cTopics;
    LPDDETOPICTBL    topic;
} DDESERVICETBL;
typedef DDESERVICETBL FAR *PDDESERVICETBL;
typedef DDESERVICETBL FAR *LPDDESERVICETBL;

typedef BOOL        (PASCAL *CBFNIN)(HDDEDATA);
typedef HDDEDATA    (PASCAL *CBFNOUT)(HDDEDATA);



//***************************************************************************

extern	HANDLE	hWndWTH86;
extern	WORD	State,EEDatReady,EEDump,STrace,MonError;
extern	WORD	DDEMReady,DDECommand,DDEActive,DDECmdOk,AsyncMode;
extern	char	Work[],EEData[],IniFile[];
extern	LPCSTR	AppName;

extern	VOID	PASCAL	DumpEEData (LPSTR, LPVOID);


HDDEDATA EXPENTRY WrapperCallback(WORD wType, WORD wFmt, HCONV hConv, HSZ hsz1,
	HSZ hsz2, HDDEDATA hData, DWORD dwData1, DWORD dwData2);
BOOL	DoCallback(HSZ hszTopic, HSZ hszItem, WORD wFmt, WORD wType,
	HDDEDATA hDataIn, LPDDESERVICETBL psi, HDDEDATA *phDataRet);
HDDEDATA ReqItems(HDDEDATA hDataOut, LPDDETOPICTBL ptpc);
HDDEDATA DoWildConnect(HSZ hszTopic);

PFNCALLBACK	lpfnWrapperCallback;
DWORD 		idInst;
LPDDESERVICETBL pasi;
HSZ		hszSystem;

#ifdef DEBUG_DDE
#define LenTmpDebug		80
static	char tmpDebug[LenTmpDebug];
static	char tmpDebug2[LenTmpDebug];
static	char tmpDebug3[LenTmpDebug];
#endif

#define FOR_EACH_TOPIC(psvc, ptpc, i)  for (i = 0, ptpc=(psvc)->topic; i < (int)(psvc)->cTopics; i++, ptpc++)
#define FOR_EACH_ITEM(ptpc, pitm, i)   for (i = 0, pitm=(ptpc)->item;  i < (int)(ptpc)->cItems;  i++, pitm++)
#define FOR_EACH_FORMAT(pitm, pfmt, i) for (i = 0, pfmt=(pitm)->fmt;   i < (int)(pitm)->cFormats;i++, pfmt++)


/***************************************************************************
 *                                                                         *
 *  PURPOSE  : Callback for Poke DDE message.				   *
 *                                                                         *
 ***************************************************************************/

#define	DSize	1024

BOOL 	PASCAL 	MCF_Poke(HDDEDATA hData)

Begin
LPSEGHD	SP;
char	HStr[80];
WORD	l,hw;
BOOL	ret;
LPSTR	LP,P2,P3,CfgH86;
HANDLE	Hd,Hdd;

ret = FALSE;
Hd = GlobalAlloc (GHND, DSize);
if (Hd eq 0) goto Exit;;
CfgH86 = (LPSTR) GlobalLock (Hd);
DdeGetData (hData, (LPBYTE) CfgH86, DSize, 0L);

LP = strchr(CfgH86, '\015');
if (LP eq NULL) goto Exit;
*LP++ = 0; strcpy (HStr, CfgH86);
strcat (HStr, "\015");
l =  (WORD) (LP - CfgH86);
memmove (CfgH86, LP, DSize-l);
if (EEDump)
Then
  Hdd = ReadHIntel((DWORD) CfgH86);
  if (Hdd eq 0) goto Exit;
  strcpy (HStr, "notepad.exe "); P2 = HStr + strlen(HStr);
  strcpy (P2, IniFile); P3 = strstr(P2, AppName);
  if (P3 eq NULL) {FreeMem(&Hdd); goto Exit;}
  strcpy (P3, "lastseed.txt");
  LP = (LPSTR) GlobalLock (Hdd); hw = *((LPWORD) LP);
  if (hw ne 1) {FreeMem(&Hdd); goto Exit;}
  SP = (LPSEGHD) (LP+2); LP = LP + SP->ROff;
  DumpEEData (P2, LP);
  WinExec (HStr, SW_SHOWNORMAL);
  ret = TRUE;  goto Exit;
Endif

AddNextState (CheckCid, NULL);
AddNextState (SendString, "\015");
AddNextState (WaitForPrompt, NULL);
AddNextState (SendString, HStr);
AddNextState (WaitForPrompt, NULL);
AddNextState (TransCfgData, CfgH86);
AddNextState (TransFin, NULL);
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif
ret = TRUE;

Exit:
FreeMem (&Hd);
return(ret);

End

/***************************************************************************
 *                                                                         *
 *  PURPOSE  : Callback for Peek DDE message.				   *
 *                                                                         *
 ***************************************************************************/

HDDEDATA PASCAL MCF_Peek(HDDEDATA hDataOut)

Begin
HDDEDATA  hData;

hData = 0;
if (EEDatReady eq 2)
Then
  hData = DdeAddData (hDataOut, (LPBYTE) EEData, EESize, 0L);
  EEDatReady = 0;
Endif
InitState (0);
return (hData);


End

/*---------------------------------------------------------------------------*/

static  char    DDEStates[] = {GetModule,GetModTyp,GetModulNr,SetModulNr,
				TransCfgData,ReadEEData,GetLineUsMod,0};

VOID	PASCAL  Inc_DDECmd (BYTE Sta)

Begin

if (Sta and strchr(DDEStates, Sta))
Then
  DDECommand++;
Endif

End


/*---------------------------------------------------------------------------*/

VOID	PASCAL  Dec_DDECmd (BYTE Sta)

Begin

if (Sta and strchr(DDEStates, Sta))
Then
  if (DDECommand) DDECommand--;
  if (DDECommand eq 0) DDECmdOk = 1;
Endif

End


/*---------------------------------------------------------------------------*/

VOID	PASCAL  WaitDDE_Ready (VOID)

Begin
WORD	Cnt;

Cnt = DDE_TIMEOUT / PollDelay;
While (DDECommand and Cnt)
Begin
  if (STrace)  DbgStr ("wait for DDEReady...");
  Sleep (PollDelay);
  CheckMessage();
  // bei Zeitüberschreitung Abbruch
  Cnt--;
Endwhile

End

//***************************************************************************

HDDEDATA PASCAL MNR_Peek(HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
LPSTR	LP;

DDECommand = DDEMReady = MonError = 0; hData = 0;
if (STrace)  OutputDebugString ("GetRemote:    MODNR\r\n");
if (EEDump eq 0 and IsAnyConnection() eq 0) goto Exit;

if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
AddNextState (GetModulNr, NULL);
// solange noch was läuft ... warten
While (LOBYTE((WORD)State) ne Display)
Begin
  if (STrace)  DbgStr ("wait for State Display...");
  Sleep (PollDelay);
  CheckMessage();
Endwhile
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

if (AsyncMode and EEDump eq 0)
Then
  hData = DdeAddData (hDataOut, "", 1, 0L);
Else
  WaitDDE_Ready();
  if (MonError) goto Exit;

  LP = DDEValP;
  hData = DdeAddData (hDataOut, LP, strlen(LP)+1, 0L);
  if (STrace)
  Then
    wsprintf (Work, "GetRemote:     MODNR= %s\r\n", LP);
    DbgStr(Work);
  Endif
Endif

Exit:
return (hData);

End

//***************************************************************************

HDDEDATA PASCAL MDL_Peek(HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
LPSTR	LP;

DDECommand = DDEMReady = MonError = 0; hData = 0;
if (STrace)  OutputDebugString ("GetRemote:    MODULEr\n");
if (EEDump eq 0 and IsAnyConnection() eq 0) goto Exit;

if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
AddNextState (GetModule, NULL);
// solange noch was läuft ... warten
While (LOBYTE((WORD)State) ne Display)
Begin
  if (STrace)  DbgStr ("wait for State Display...");
  Sleep (PollDelay);
  CheckMessage();
Endwhile
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

if (AsyncMode and EEDump eq 0)
Then
  hData = DdeAddData (hDataOut, "", 1, 0L);
Else
  WaitDDE_Ready();
  if (MonError) goto Exit;

  LP = DDEValP;
  hData = DdeAddData (hDataOut, LP, strlen(LP)+1, 0L);
  if (STrace)
  Then
    wsprintf (Work, "GetRemote:     MODULE= %s\r\n", LP);
    DbgStr(Work);
  Endif
Endif

Exit:
return (hData);

End

//***************************************************************************

HDDEDATA PASCAL LUM_Peek(HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
LPSTR	LP;

DDECommand = DDEMReady = MonError = 0; hData = 0;
if (STrace)  OutputDebugString ("GetRemote:    LineUsMod\r\n");
if (EEDump eq 0 and IsAnyConnection() eq 0) goto Exit;

if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
AddNextState (GetLineUsMod, NULL);
// solange noch was läuft ... warten
While (LOBYTE((WORD)State) ne Display)
Begin
  if (STrace)  DbgStr ("wait for State Display...");
  Sleep (PollDelay);
  CheckMessage();
Endwhile
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

if (AsyncMode and EEDump eq 0)
Then
  hData = DdeAddData (hDataOut, "", 1, 0L);
Else
  WaitDDE_Ready();
  if (MonError) goto Exit;

  LP = DDEValP;
  hData = DdeAddData (hDataOut, LP, strlen(LP)+1, 0L);
  if (STrace)
  Then
    wsprintf (Work, "GetRemote:     LineUsMod= %s\r\n", LP);
    DbgStr(Work);
  Endif
Endif

Exit:
return (hData);

End

//***************************************************************************

HDDEDATA PASCAL MTP_Peek(HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
LPSTR	LP;

DDECommand = DDEMReady = MonError = 0; hData = 0;
if (STrace)  OutputDebugString ("GetRemote:    MODTYP\r\n");
if (EEDump eq 0 and IsAnyConnection() eq 0) goto Exit;

if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
AddNextState (GetModTyp, NULL);
// solange noch was läuft ... warten
While (LOBYTE((WORD)State) ne Display)
Begin
  if (STrace)  DbgStr ("wait for State Display...");
  Sleep (PollDelay);
  CheckMessage();
Endwhile
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

if (AsyncMode and EEDump eq 0)
Then
  hData = DdeAddData (hDataOut, "", 1, 0L);
Else
  WaitDDE_Ready();
  if (MonError) goto Exit;

  LP = DDEValP;
  hData = DdeAddData (hDataOut, LP, strlen(LP)+1, 0L);
  if (STrace)
  Then
    wsprintf (Work, "GetRemote:     MODTYP= %s\r\n", LP);
    DbgStr(Work);
  Endif
Endif

Exit:
return (hData);

End

//***************************************************************************

BOOL 	PASCAL 	MNR_Poke (HDDEDATA hData)

Begin
char	HStr[20];
WORD	mnr;
BOOL	ret;

MonError = 0;
DdeGetData (hData, HStr, 20, 0L);
mnr = atoi(HStr); ret = FALSE;
if (mnr eq 0 or mnr > MaxModn_L) goto Exit;

if (STrace)
Then
  wsprintf (Work, "SetRemote:     MOD_NR= %s\r\n", HStr);
  DbgStr(Work);
Endif

if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
DDECommand = DDEMReady = 0;
itoa (mnr, HStr, 10);
AddNextState (SetModulNr, HStr);
// solange noch was läuft ... warten
While (LOBYTE((WORD)State) ne Display)
Begin
  if (STrace)  DbgStr ("wait for State Display...");
  Sleep (PollDelay);
  CheckMessage();
Endwhile
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

if (AsyncMode and EEDump eq 0)
Then
  DDECmdOk = 1;
Else
  DDECmdOk = 0;
  WaitDDE_Ready();
Endif

if (STrace)  OutputDebugString ("SetRemote (MOD_NR) ...ready!\r\n");
if (MonError)
Then
  goto Exit;
Endif
ret = DDECmdOk;

Exit:
return (ret);

End

/*********************************************************************/

extern	WORD	Baudrate;

BOOL 	PASCAL 	EED_Poke(HDDEDATA hData)

Begin
EEDATA	Cfg;
LPSEGHD	SP;
char	HStr[80];
WORD	hw,ret;
DWORD	hdw;
LPSTR	LP,P2,P3,CfgH86;
HANDLE	Hd,Hdd;

ret = FALSE;  MonError = 0;
DdeGetData (hData, (LPBYTE) &Cfg, sizeof(EEDATA), 0);
Hd = GlobalAlloc (GHND, 1024);
if (Hd eq 0)  goto Exit;
LP = DusTyp2Name(&Cfg);
hw = GetModInfo((LONG) LP, MOD_eesiz, NULL);
hw = HexIntel ((int)Hd, 0, 0, (LPSTR) &Cfg, hw);
HexIntel2 ((int)Hd, 0, 0, NULL, 0, hw);
CfgH86 = (LPSTR) GlobalLock (Hd);

if (EEDump)
Then
  Hdd = ReadHIntel((DWORD) CfgH86);
  if (Hdd eq 0) goto Exit;
  strcpy (HStr, "notepad.exe "); P2 = HStr + strlen(HStr);
  strcpy (P2, IniFile); P3 = strstr(P2, AppName);
  if (P3 eq NULL) {FreeMem(&Hdd); goto Exit;}
  strcpy (P3, "lastseed.txt");
  LP = (LPSTR) GlobalLock (Hdd); hw = *((LPWORD) LP);
  if (hw ne 1) {FreeMem(&Hdd); goto Exit;}
  SP = (LPSEGHD) (LP+2); LP = LP + SP->ROff;
  DumpEEData (P2, LP);
  WinExec (HStr, SW_SHOWNORMAL);
  ret = TRUE;  goto Exit;
Endif

if (STrace)
Then
  OutputDebugString ("SetRemote:     EEDATA\r\n");
Endif

hw = Cfg.rs_485.V1.GerAdr;
if (hw eq 0 or hw > MaxModn_L) goto Exit;

DDECommand = DDEMReady = 0;
if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
AddNextState (TransCfgData, CfgH86);
if (IsTCPConnection() eq 0)
Then
  // Zeichen / Sec
  hdw = Baudrate / 10;
  // Sendezeit in ms
  hdw = strlen(CfgH86) * 1000 / hdw;
  // ... in Delays
  hdw = hdw / PollDelay + 1;
  AddNextStat2 (WaitDelay, NULL, hdw);

  if (IsCBd_possible(&Cfg))
  Then
    AddNextStat2 (WaitDelay, NULL, hdw);
  //  AddNextStat2 (WaitDelay, NULL, 70);
    hdw = GetMMKBaud (&Cfg);  itoa (hdw, HStr, 10);
    AddNextState (SetNewBaud, HStr);
    AddNextState (WaitForPrompt, NULL);
  Endif
Endif

// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

if (AsyncMode and EEDump eq 0)
Then
  DDECmdOk = 1;
Else
  DDECmdOk = 0;
  WaitDDE_Ready();
Endif

if (STrace)  OutputDebugString ("SetRemote EEDATA ...ready!\r\n");
if (MonError) goto Exit;

ret = DDECmdOk;

Exit:
FreeMem (&Hd);
return(ret);

End

//***************************************************************************

HDDEDATA PASCAL EED_Peek(HDDEDATA hDataOut)

Begin
HDDEDATA  hData;

hData = 0;
if (STrace)
Then
  OutputDebugString ("GetRemote:     EEDATA\r\n");
Endif
if (EEDump eq 0 and IsAnyConnection() eq 0) goto Exit;

DDECommand = DDEMReady = DDECmdOk = 0;
if (DDEActive eq 0 and EEDump eq 0)
Then
  AddNextState (CheckCid, NULL);
  AddNextState (CheckMoni, NULL);
Endif
AddNextState (ReadEEData, NULL);
// solange noch was läuft ... warten
While (LOBYTE((WORD)State) ne Display)
Begin
  if (STrace)  DbgStr ("wait for State Display...");
  Sleep (PollDelay);
  CheckMessage();
Endwhile
// laufenden State nicht umsetzten!!
if (State <= Display)
Then
  State = GetNextState();
Endif

WaitDDE_Ready();
if (STrace)  OutputDebugString ("GetRemote EEDATA ...ready!\r\n");

if (EEDatReady eq 2)
Then
  hData = DdeAddData (hDataOut, (LPBYTE) EEData, EESize<<1, 0L);
  EEDatReady = 0;
Endif

Exit:
return (hData);

End

//***************************************************************************

BOOL 	PASCAL 	PutAsyMode (HDDEDATA hData)

Begin
char	HStr[20];
BOOL	ret;

DdeGetData (hData, HStr, sizeof(HStr), 0L);
AsyncMode = atoi(HStr); ret = TRUE;

if (STrace)
Then
  wsprintf (Work, "SetRemote:     AsyncMode= %s\r\n", HStr);
  DbgStr (Work);
Endif

return (ret);

End

//***************************************************************************

BOOL 	PASCAL 	PutBaudrate (HDDEDATA hData)

Begin
char	HStr[20];
BOOL	ret;

DdeGetData (hData, HStr, sizeof(HStr), 0L);
ChangeBdMenu (atoi(HStr), 0);   ret = TRUE;

if (STrace)
Then
  wsprintf (Work, "SetRemote:     Baudrate= %s\r\n", HStr);
  DbgStr (Work);
Endif

return (ret);

End

//***************************************************************************

HDDEDATA PASCAL GetMonRdy (HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
char	HStr[20];

if (EEDump and IsAnyConnection() eq 0) DDEMReady = 1;
itoa (DDEMReady, HStr, 10);
hData = DdeAddData (hDataOut, HStr, strlen(HStr)+1, 0L);
if (STrace)
Then
  OutputDebugString ("GetRemote:     Monitor ready=");
  OutputDebugString (HStr);
  OutputDebugString ("\r\n");
Endif

return (hData);

End

//***************************************************************************

HDDEDATA PASCAL GetIsTCP (HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
char	HStr[20];

itoa (IsTCPConnection(), HStr, 10);
hData = DdeAddData (hDataOut, HStr, strlen(HStr)+1, 0L);
if (STrace)
Then
  wsprintf (Work, "GetRemote:     TCPConnection = %s\r\n", HStr);
  DbgStr (Work);
Endif

return (hData);

End

//***************************************************************************

HDDEDATA PASCAL GetIsEEDump (HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
char	HStr[20];

itoa (EEDump, HStr, 10);
hData = DdeAddData (hDataOut, HStr, strlen(HStr)+1, 0L);
if (STrace)
Then
  wsprintf (Work, "GetRemote:     EEDump = %s\r\n", HStr);
  DbgStr (Work);
Endif

return (hData);

End

//***************************************************************************

HDDEDATA PASCAL GetResult (HDDEDATA hDataOut)

Begin
HDDEDATA  hData;
LPSTR	LP;

LP = DDEValP;
hData = DdeAddData (hDataOut, LP, strlen(LP)+1, 0L);
if (STrace)
Then
  wsprintf (Work, "GetRemote:     Result = %s\r\n", LP);
  DbgStr (Work);
Endif

return (hData);

End

/*********************************************************************/

DDEFORMATTBL EEP_Fmt = {CF_TEXT, MCF_Poke,	MCF_Peek};
DDEFORMATTBL EED_Fmt = {CF_TEXT, EED_Poke,	EED_Peek};
DDEFORMATTBL MNR_Fmt = {CF_TEXT, MNR_Poke,	MNR_Peek};
DDEFORMATTBL MTP_Fmt = {CF_TEXT, NULL,	  	MTP_Peek};
DDEFORMATTBL LUM_Fmt = {CF_TEXT, NULL,		LUM_Peek};
DDEFORMATTBL MDL_Fmt = {CF_TEXT, NULL,		MDL_Peek};
DDEFORMATTBL AsyMode = {CF_TEXT, PutAsyMode,	NULL};
DDEFORMATTBL BaudFmt = {CF_TEXT, PutBaudrate,	NULL};
DDEFORMATTBL Mon_Rdy = {CF_TEXT, NULL,		GetMonRdy};
DDEFORMATTBL Is__TCP = {CF_TEXT, NULL,		GetIsTCP};
DDEFORMATTBL IsEEDmp = {CF_TEXT, NULL,		GetIsEEDump};
DDEFORMATTBL Res_Fmt = {CF_TEXT, NULL,		GetResult};

DDEITEMTBL WTHItms[] = {
{"EEPROM",	0, NULL, 1, &EEP_Fmt},
{"EEDATA",	0, NULL, 1, &EED_Fmt},
{"MOD_NR",	0, NULL, 1, &MNR_Fmt},
{"MODTYP",	0, NULL, 1, &MTP_Fmt},
{"LUSMOD",	0, NULL, 1, &LUM_Fmt},
{"MODULE",	0, NULL, 1, &MDL_Fmt},
{"ASYNCMODE",	0, NULL, 1, &AsyMode},
{"BAUDRATE",	0, NULL, 1, &BaudFmt},
{"MON_READY",	0, NULL, 1, &Mon_Rdy},
{"IS_TCP",	0, NULL, 1, &Is__TCP},
{"IS_EEDUMP",	0, NULL, 1, &IsEEDmp},
{"RESULT",	0, NULL, 1, &Res_Fmt}
};

DDETOPICTBL WTHTopi[] = {
{ SZDDESYS_TOPIC, 0, sizeof(WTHItms)/sizeof(DDEITEMTBL), WTHItms},
};

DDESERVICETBL MyServiceInfo[] = {
{"WTH86", 0, sizeof(WTHTopi)/sizeof(DDETOPICTBL), WTHTopi},
};


/*********************************************************************/


VOID	InitHszs (LPDDESERVICETBL psi)

Begin
int	iTopic, iItem;
LPDDETOPICTBL ptpc;
LPDDEITEMTBL pitm;

hszSystem = DdeCreateStringHandle(idInst, SZDDESYS_TOPIC, 0);
if (psi->pszService)
    psi->hszService = DdeCreateStringHandle(idInst, psi->pszService, 0);

FOR_EACH_TOPIC(psi, ptpc, iTopic)
Begin
  ptpc->hszTopic = DdeCreateStringHandle(idInst, ptpc->pszTopic, 0);
  FOR_EACH_ITEM(ptpc, pitm, iItem)
  Begin
    pitm->hszItem = DdeCreateStringHandle(idInst, pitm->pszItem, 0);
  Endfor
Endfor

End

/*********************************************************************/

BOOL InitializeDDE (HANDLE hInst)

Begin

lpfnWrapperCallback = (PFNCALLBACK)MakePrgInst((FARPROC)WrapperCallback, hInst);
if (DdeInitialize(&idInst, lpfnWrapperCallback, APPCLASS_STANDARD, 0))
Then
  FreePrgInst((FARPROC)lpfnWrapperCallback);
  return(FALSE);
Endif
InitHszs(MyServiceInfo);
pasi = MyServiceInfo;
DdeNameService(idInst, pasi->hszService, 0, DNS_REGISTER);
return(TRUE);

End


/*********************************************************************/


VOID	FreeHszs (LPDDESERVICETBL psi)

Begin
int	iTopic, iItem;
LPDDETOPICTBL ptpc;
LPDDEITEMTBL pitm;

DdeFreeStringHandle(idInst, psi->hszService);
DdeFreeStringHandle(idInst, hszSystem);
FOR_EACH_TOPIC(psi, ptpc, iTopic)
Begin
  DdeFreeStringHandle(idInst, ptpc->hszTopic);
  FOR_EACH_ITEM(ptpc, pitm, iItem)
  Begin
    DdeFreeStringHandle(idInst, pitm->hszItem);
  Endfor
Endfor

End

/*********************************************************************/

VOID	UninitializeDDE()

Begin

DdeNameService(idInst, pasi->hszService, 0, DNS_UNREGISTER);
FreeHszs(pasi);
DdeUninitialize(idInst);
FreePrgInst((FARPROC)lpfnWrapperCallback);

End

/*********************************************************************/

#ifdef	DEBUG_DDE

typedef	struct {
	WORD	binFmt;
	LPSTR	sz_Fmt;
	}ASCDES;
typedef	ASCDES _far *PASCDS;

static	ASCDES	FmtDes[] = {
{CF_TEXT        , "TEXT"          },
{CF_BITMAP      , "BITMAP"        },
{CF_METAFILEPICT, "METAFILEPICT"  },
{CF_SYLK        , "SYLK"          },
{CF_DIF         , "DIF"           },
{CF_TIFF        , "TIFF"          },
{CF_OEMTEXT     , "OEMTEXT"       },
{CF_DIB         , "DIB"           },
{CF_PALETTE     , "PALETTE"       },
{0		,  NULL	          }
};

static	ASCDES	TypDes[] = {
{XTYP_ADVDATA		, "XTYP_ADVDATA" 	  },
{XTYP_ADVREQ		, "XTYP_ADVREQ"  	  },
{XTYP_ADVSTART		, "XTYP_ADVSTART" 	  },
{XTYP_ADVSTOP		, "XTYP_ADVSTART"	  },
{XTYP_CONNECT		, "XTYP_CONNECT"	  },
{XTYP_CONNECT_CONFIRM	, "XTYP_CONNECT_CONFIRM"  },
{XTYP_DISCONNECT	, "XTYP_DISCONNECT"  	  },
{XTYP_ERROR		, "XTYP_ERROR"		  },
{XTYP_EXECUTE		, "XTYP_EXECUTE"	  },
{XTYP_MONITOR		, "XTYP_MONITOR"	  },
{XTYP_POKE		, "XTYP_POKE"   	  },
{XTYP_REGISTER		, "XTYP_REGISTER"	  },
{XTYP_REQUEST		, "XTYP_REQUEST"	  },
{XTYP_UNREGISTER	, "XTYP_UNREGISTER"	  },
{XTYP_WILDCONNECT	, "XTYP_WILDCONNECT"	  },
{XTYP_XACT_COMPLETE	, "XTYP_XACT_COMPLETE"	  },
{0			,  NULL	        	  }
};

/*********************************************************************/

static	VOID	GetAscDes (WORD Fmt, PASCDS DP, LPSTR Str)

Begin

While (DP->sz_Fmt)
Begin
  if (Fmt eq DP->binFmt) break;
  DP++;
Endwhile
if (DP->sz_Fmt)
Then
  strcpy (Str, DP->sz_Fmt);
Else
  if (Fmt)  strcpy (Str, "???");
  else	    *Str = 0;
Endif

End

#endif

/*********************************************************************/

HDDEDATA EXPENTRY _export WrapperCallback(
WORD wType,
WORD wFmt,
HCONV hConv,
HSZ hsz1,
HSZ hsz2,
HDDEDATA hData,
DWORD dwData1,
DWORD dwData2)

Begin
static	HDDEDATA hDataRet;

DdeKeepStringHandle (idInst, hsz1);
DdeKeepStringHandle (idInst, hsz2);

#ifdef	DEBUG_DDE
  LP = tmpDebug;  GetAscDes (wType, TypDes, LP);
  LP = LP + strlen(LP);  *LP++ = ':'; *LP++ = ' ';
  GetAscDes (wFmt, FmtDes, LP);
  strcat (LP, "\r\n");
  OutputDebugString (tmpDebug);
  if (hsz1)
  Then
    LP = tmpDebug; strcpy (LP, "    hsz1:\t");
    LP = LP + strlen(LP);
    DdeQueryString (idInst, hsz1, LP, LenTmpDebug, CP_WINANSI);
    strcat (LP, "\r\n");   OutputDebugString (tmpDebug);
  Endif
  if (hsz2)
  Then
	 LP = tmpDebug; strcpy (LP, "    hsz2:\t");
    LP = LP + strlen(LP);
    DdeQueryString (idInst, hsz2, LP, LenTmpDebug, CP_WINANSI);
    strcat (LP, "\r\n");   OutputDebugString (tmpDebug);
  Endif
#endif


Switch (wType)

    case XTYP_WILDCONNECT:
	if (!hsz2 || !DdeCmpStringHandles(hsz2, pasi->hszService))
	Then
	  return (DoWildConnect(hsz1));
	Endif
        break;

    case XTYP_ADVSTART:
    case XTYP_CONNECT:
    case XTYP_EXECUTE:
    case XTYP_REQUEST:
    case XTYP_ADVREQ:
    case XTYP_ADVDATA:
    case XTYP_POKE:

		if (DoCallback(hsz1, hsz2, wFmt, wType, hData,
		pasi, &hDataRet))
				return(hDataRet);

Endswitch
return(0);

End

/*********************************************************************/


BOOL	DoCallback(
HSZ hszTopic,
HSZ hszItem,
WORD wFmt,
WORD wType,
HDDEDATA hDataIn,
LPDDESERVICETBL psi,
HDDEDATA *phDataRet)

Begin
int	iTopic, iItem, iFmt;
LPDDEFORMATTBL pfmt;
LPDDEITEMTBL pitm;
LPDDETOPICTBL ptpc;

    FOR_EACH_TOPIC(psi, ptpc, iTopic)
    Begin

#ifdef	DEBUG_DDE
	DdeQueryString (idInst, ptpc->hszTopic, 
			&tmpDebug[0], LenTmpDebug, CP_WINANSI);
	DdeQueryString (idInst, hszTopic, 
			&tmpDebug2[0], LenTmpDebug, CP_WINANSI);
	wsprintf (&tmpDebug3[0],
	"tbl.hszTopic=[%s] input.hszTopic=[%s]\r\n",
	(LPSTR) &tmpDebug[0], (LPSTR) &tmpDebug2[0]);
	OutputDebugString (&tmpDebug3[0]);
#endif
        if (DdeCmpStringHandles(ptpc->hszTopic, hszTopic))
            continue;

        if (wType == XTYP_CONNECT)
	Then
            *phDataRet = (HDDEDATA)TRUE;
            return(TRUE);
        Endif

        FOR_EACH_ITEM(ptpc, pitm, iItem)
	Begin
#ifdef DEBUG_DDE
	    DdeQueryString (idInst, pitm->hszItem, 
				&tmpDebug[0], LenTmpDebug, CP_WINANSI);
	    DdeQueryString (idInst, hszItem, 
				&tmpDebug2[0], LenTmpDebug, CP_WINANSI);
	    wsprintf (&tmpDebug3[0],
	    "tbl.hszItem=0x%lx=[%s] input.hszItem=0x%lx=[%s]\r\n",
	    (long) pitm->hszItem, (LPSTR) &tmpDebug[0], 
	    (long) hszItem, (LPSTR) &tmpDebug2[0]);
	    OutputDebugString (&tmpDebug3[0]);
#endif
            if (DdeCmpStringHandles(pitm->hszItem, hszItem))
                continue;

            if (wType == XTYP_EXECUTE)
	    Then
                if (pitm->lpfnExecute)
		Then
                    if ((*pitm->lpfnExecute)(hDataIn))
                        *phDataRet = (HDDEDATA)DDE_FACK;
                Else
                    *phDataRet = (HDDEDATA)DDE_FNOTPROCESSED;
                Endif
                return(TRUE);
            Endif

            FOR_EACH_FORMAT(pitm, pfmt, iFmt)
	    Then
#ifdef DEBUG_DDE
		wsprintf (&tmpDebug3[0],
		"tbl.wFmt=0x%x input.wFmt=0x%x\r\n",
                pfmt->wFmt, wFmt);
		OutputDebugString (&tmpDebug3[0]);
#endif
                if (pfmt->wFmt != wFmt)
                    continue;

                Switch (wType)
                case XTYP_ADVSTART:
                    *phDataRet = (HDDEDATA)TRUE;
                    break;

                case XTYP_ADVDATA:
                case XTYP_POKE:
                    if (pfmt->lpfnPoke)
		    Then
                        if ((*pfmt->lpfnPoke)(hDataIn))
			Then
                            *phDataRet = (HDDEDATA)DDE_FACK;
                            DdePostAdvise(idInst, hszTopic, hszItem);
                        Endif
                    Else
                        *phDataRet = (HDDEDATA)DDE_FNOTPROCESSED;
                    Endif
                    break;

                case XTYP_REQUEST:
                case XTYP_ADVREQ:
                    if (pfmt->lpfnRequest)
		    Then
                        HDDEDATA hDataOut;

                        hDataOut = DdeCreateDataHandle(idInst, NULL, 0, 0, pitm->hszItem,
                                pfmt->wFmt, 0);
                        *phDataRet = (HDDEDATA)(*pfmt->lpfnRequest)(hDataOut);
                        if (!*phDataRet) {
                            DdeFreeDataHandle(hDataOut);
                        }
            		DdeFreeStringHandle(idInst, hszItem);
            		DdeFreeStringHandle(idInst, hszTopic);
                    Else
                        *phDataRet = 0;
                    Endif
                    break;
                Endswitch
                return(TRUE);
            Endfor
        Endfor

    }

    /* no topics fit */

    return(FALSE);
End


/*********************************************************************/


HDDEDATA DoWildConnect(
HSZ hszTopic)
{
    LPDDETOPICTBL ptpc;
    HDDEDATA hData;
    PHSZPAIR pHszPair;
    int iTopic, cTopics = 2;

    if (!hszTopic) {
        cTopics += pasi->cTopics;
    }

    hData = DdeCreateDataHandle(idInst, NULL, cTopics * sizeof(HSZPAIR), 0, NULL, 0, 0);
    pHszPair = (HSZPAIR FAR *)DdeAccessData(hData, NULL);
    pHszPair->hszSvc = pasi->hszService;
    pHszPair->hszTopic = hszSystem;  // always support systopic.
    pHszPair++;
//    ptpc = &pasi->topic[0];
    FOR_EACH_TOPIC(pasi, ptpc, iTopic) {
        if (hszTopic && DdeCmpStringHandles(hszTopic, ptpc->hszTopic)) {
            continue;
        }
        if (!DdeCmpStringHandles(ptpc->hszTopic, hszSystem)) {
            continue;       // don't enter systopic twice.
        }
        pHszPair->hszSvc = pasi->hszService;
        pHszPair->hszTopic = ptpc->hszTopic;
        pHszPair++;
    }
    pHszPair->hszSvc = 0;
    pHszPair->hszTopic = 0;
    DdeUnaccessData(hData);
    return(hData);
}
