/*
**      Modul Name....: TH_MONI.C
**
**      Funktion......: Ubertragungs-Funktionen des MICAS-Monitors
**
**      Versionsdatum.: 18.06.1996
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

#pragma hdrstop

#include        <ctype.h>
#include        "gatmod.h"
#include        "wth86.h"
#include        "th_dlg.h"

//      E x t e r n a l s

#define TaskMax 10

extern  VOID    PASCAL  DumpEEData (LPSTR, LPVOID);

extern  HWND    hWndWTH86;
extern  int	fht;
extern  char    Work[];
extern  short   Cid;
extern  WORD    State,TmpState,Hibus,MoniReady,MonError,EEDump,DDEMReady;
extern  int     Datptr;
extern  char    FileName[],IniFile[],FilePath[];
extern  LPCSTR  AppName;
extern  BYTE    EEData[];
extern  WORD    EEDatReady;

static  LPSTR   EchoPtr;
static  WORD    Cnt,Off;        // noch zusendende Zeichen, Offset
static  WORD    ModHnd,FTskSeg,LTskSeg,DispOnWait;
static	WORD	CDE_allowed;
static	short	aLine=-1,aUsNr=-1;

	LPSTR   DDEValP,MrDataP;
	char    EchoBuf[70];    // Buffer fuer Echofilter

typedef struct {
	char    ModTyp[10];
	char    Version[7];
	BYTE	Mod;
	WORD	FKMic;
	WORD	EESeg;
	WORD	EEOff;
	WORD    EECmd;
	WORD	BukSeg;
	WORD	KbsSeg;
	WORD	EndBst;
	WORD	DatSeg;
	WORD	OffSeg;
	WORD	CLMax;
	WORD	KonLen;
	WORD	KonOff;
	}MODDATA;

static  MODDATA Sel_Mod,MoniMod;
	WORD    MDvalid;

/*---------------------------------------------------------------------------*/

static	VOID    DumpModInfo (LPSTR Info)

Begin

if (LTrace)
Then
  DbgStr(Info);
  wsprintf (Work, "MoniMod.Mod  Sel_Mod.Mod");
  DbgStr(Work);
  wsprintf (Work, "%3d          %3d", MoniMod.Mod, Sel_Mod.Mod);
  DbgStr(Work);
Endif

End

/*---------------------------------------------------------------------------*/

VOID    ClearUSInfo (VOID)

Begin

aLine = aUsNr = -1;

End

/*---------------------------------------------------------------------------*/

VOID    ClearCInfo (VOID)

Begin

memset (&MoniMod, 0, sizeof(MODDATA));
memset (&Sel_Mod, 0, sizeof(MODDATA));
CDE_allowed = 0;
ClearUSInfo ();

End

/*---------------------------------------------------------------------------*/

VOID    FlushOQue ()

Begin

if (IsTCPConnection() eq 0)
Then
  Sio_FlushO (Cid);
Endif
Cnt = 0; Off = 0;

End

/*---------------------------------------------------------------------------*/

static  int     SendBuffer (char *Str, WORD Len, WORD Add)

/*F
**.* Beschreibung :
**
**      Die Funktion trÑgt den angegebenen Puffer in die SendeQue
**      und handelt den Fall wenn die Daten nicht komplett eingetragen werden.
**
**.* Funktionswerte :
**
**      1 wenn Puffer gesendet, sonst 0
**
*/
 
Begin
WORD    ret,hw;

ret = 1;
if (Cnt)
Then
  hw = Off;
  Off = SendChars(Str+Off, Cnt, 0);
  if (Off < Cnt)
  Then
    ret = 0; Cnt = Cnt - Off; Off = Off + hw;
  Else
    Cnt = 0;
  Endif
Else
  Off = SendChars(Str, Len, Add);
  if (Off < Len)
  Then
    ret = 0; Cnt = Len - Off;
  Endif
Endif

return (ret);

End


/*---------------------------------------------------------------------------*/


static  int     isEmpty (char *Str)

Begin
int     ret;

ret = 1;
While (*Str)
Begin
  if (isgraph(*Str))
  Then
    ret = 0; break;
  Endif
  Str++;
Endwhile
return (ret);

End


/*---------------------------------------------------------------------------*/


VOID    TransAscFile_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion sendet die zuvor eroeffnete Datei zum
**      Monitor und ueberprueft die Empfangs-Que auf Bel-Character.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
static  BufSend=1;
int     len;

TmpState = State;
State = NoAction;
if (BufSend eq 0)  BufSend = SendBuffer(Work, 0, 0);

While(BufSend)
Begin
  if (CheckMonErr())
  Then
    TmpState = InitState(0); goto Exit;
  Endif

  if (_Ffeof(Datptr))
  Then
    TmpState = GetNextState();
    break;
  Endif

  Work[0] = 0;
  _Ffgets (Work, WorkSize, Datptr);
  if (isEmpty(Work))  continue;
  len = strlen(Work);  Work[len-1] = Cr;
  BufSend = SendBuffer(Work, len, 1);
Endwhile

Exit:
State = TmpState;

End


/*---------------------------------------------------------------------------*/

extern  LPSTR   aktBPath;
extern  WORD    CntBFile;
extern  LPPSTR  BinFiles;
extern  DWORD   Baudrate;
extern  DWORD   oldBaud;

VOID    ChkNextFFile_F ()

Begin
LPSTR   LP;
DWORD   Siz;
BOOL	ret;

TmpState = State;  State = NoAction;
if (BinFiles eq NULL)
Then
  FreePtr(BinFiles);  BinFiles = NULL;
  TmpState = InitState(0);  goto Exit;
Endif

LP = *(BinFiles+CntBFile); CntBFile++;
if (LP)
Then
  CloseFile (Datptr);
/*
  oldBaud = Baudrate;
  if (Baudrate ne 115200)
  Then
    Baudrate = 115200; SetComPara();
  Endif
*/
  strcpy (FilePath, aktBPath); strcpy (FileName, LP);
  ret = openFile ("rt", NULL);  Siz = _FSize(Datptr);
  if (ret eq FALSE)
  Then
    if (Baudrate ne oldBaud)
    Then
      Baudrate = oldBaud;  SetComPara();
    Endif
    TmpState = InitState(0); goto Exit;
  Endif
  strcpy (Work, FilePath);
  dircat (Work, FileName);
  CreateDspWin (Work, Siz);
  AddNextState (TransBinFile, NULL);
  LP = *(BinFiles+CntBFile);
  if (LP)  AddNextState (WaitForString, "LOADING DONE!");
  AddNextState (ChkNextFFile, NULL);

  TmpState = GetNextState ();
Else
  if (Baudrate ne oldBaud)
  Then
    Baudrate = oldBaud;  SetComPara();
  Endif
  FreePtr(BinFiles);  BinFiles = NULL;
  TmpState = InitState(0);
Endif

Exit:
State = TmpState;

End

/*---------------------------------------------------------------------------*/

VOID    CreateDWin_F ()

Begin
DWORD   Siz;
LPSTR   LP;

TmpState = State;
State = NoAction;
Siz = _FSize(Datptr);
LP = GetStateStr (TmpState);
CreateDspWin (LP, Siz);
TmpState = GetNextState ();

State = TmpState;

End

/*---------------------------------------------------------------------------*/

VOID    TransBinFile_F ()

Begin
static  BufSend=1;
WORD    len;

TmpState = State;  State = NoAction;
if (BufSend eq 0)  BufSend = SendBuffer(Work, 0, 0);

While(BufSend)
Begin

/*
  While ((c = GetCharComm()) ne EOF)
  Begin
    if (c eq Bel)
    Then
      hw = MB_BEEP | MB_ICONINFORMATION | MB_OKCANCEL;
      hw = UserMessage (fht, hWndWTH86, 268, hw, "");
      if (hw eq IDOK)
      Then
	hw = GetNextState ();
	if (hw eq ChkNextFFile) AddNextState (ChkNextFFile, NULL);
	if (CntBFile) CntBFile--;
	TmpState = GetNextState ();
      Else
	if (Baudrate ne oldBaud)
	Then
	  Baudrate = oldBaud;  SetComPara();
	Endif
	FreePtr(BinFiles);  BinFiles = NULL;
	TmpState = InitState(0);
      Endif
      goto Exit;
    Endif
    DisplayBuf ((BYTE*) &c, 1);
  Endwhile
*/

  if (_Ffeof(Datptr))
  Then
    TmpState = GetNextState();
    DispOnWait = 1;  break;
  Endif

  len = _FRead (Datptr, Work, WorkSize);
  if (len eq 0)  continue;
  BufSend = SendBuffer(Work, len, 1);
Endwhile

State = TmpState;

End


/*---------------------------------------------------------------------------*/


VOID    TransCfgData_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion sendet die zuvor von Modconf empfangenen Daten.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char    c;
LPSTR   LP,P2,CfgH86,P3;
WORD    n,cnt,hw;
DWORD   NState;
char    HStr[80];
LPSEGHD SP;
HANDLE  Hd;

NState = State;
State = NoAction;
if (GetStateCnt(NState))
Then
  While ( (c = GetCharComm()) ne EOF)
  Begin
    if (c eq Bel)
    Then
      PriErr (ErrTRS); NState = InitState(0); goto Exit;
    Endif
  Endwhile

  cnt = 0; CfgH86 = GetStateStr(NState);
  While (*CfgH86)
  Begin
    LP = strchr (CfgH86, '\015');
    if (LP)
    Then
      LP++; n = (WORD) (LP - CfgH86);
      if (*LP eq Lf) LP++;
    Else
      n = 0;
    Endif
    SendChars (CfgH86, n, 0);
    P2 = strstr(CfgH86, EndBlock);
    CfgH86 = LP; cnt++;
    if (P2 < LP or cnt > 16) break;
  Endwhile
Else
  CfgH86 = GetStateStr(NState);
  if (EEDump)
  Then
    Hd = ReadHIntel((DWORD) CfgH86);
    if (Hd eq 0) goto DumpExit;
    strcpy (HStr, "notepad.exe "); P2 = HStr + strlen(HStr);
    strcpy (P2, IniFile); P3 = strstr(P2, AppName);
    if (P3 eq NULL) goto DumpExit;
    strcpy (P3, "lastseed.txt");
    LP = (LPSTR) GlobalLock (Hd); hw = *((LPWORD) LP);
    if (hw ne 1) goto DumpExit;
    SP = (LPSEGHD) (LP+2); LP = LP + SP->ROff;
    DumpEEData (P2, LP);
    WinExec (HStr, SW_SHOWNORMAL);

DumpExit:
    FreeMem (&Hd);
    NState = InitState (0); DDEMReady = 1;
    goto Exit;
  Endif

  InsertState (TransCfgData, CfgH86, 1);
//  if (IsTCPConnection() eq 0)  InsertState (WaitForEcho, "SEP");
  InsertState (SendString, "SEP\015", 0);
Endif
NState = GetNextState();


Exit:
State = NState;

End


/*---------------------------------------------------------------------------*/

VOID    DiaPSLFile_F (HWND hWnd)

/*F
**.* Beschreibung :
**
**      Die Funktion fuehrt den Dialog fuer PSL-Dateien
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin

State = NoAction;
if (SelectFile(hWnd, fht, "*.PSL", (LPSTR) 477, FileName, NULL) eq FALSE)  goto Err;

if (openFile ("rt", NULL) eq FALSE)  goto Err;
AddNextState (SendString, "\015");
AddNextState (WaitForPrompt, NULL);
CreateDspWin (FileName, _FSize(Datptr));
TmpState = GetNextState();
goto Exit;

Err:
TmpState = InitState(0);

Exit:
State = TmpState;

End


/*---------------------------------------------------------------------------*/

VOID    SendString_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion sendet den dem State entsprechenden Text.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
LPSTR   LP,P2;

TmpState = State;
State = NoAction;
LP = GetStateStr (TmpState);
FlushIQue();   SendStr (LP);
if (IsTCPConnection() eq 0)
Then
  P2 = LP + strlen(LP);
  while (P2 > LP and iscntrl(*(P2-1))) P2--;
  *P2 = 0; strupr(LP);
  if (P2 ne LP) InsertState (WaitForEcho, LP, 0);
Endif
State = GetNextState ();

End

/*---------------------------------------------------------------------------*/

VOID    SendQBef_F ()

Begin

State = NoAction;
FlushIQue();
SendStr ("Q\015\015");
if (IsTCPConnection())
Then
  //CloseSDevice ();
  PostMsg (hWndWTH86, WM_COMMAND, IDMCLOSE, 0);
Endif
State = GetNextState ();

End

/*---------------------------------------------------------------------------*/


VOID    SendCHDBef_F ()

Begin
LPSTR   P,SStr;
char    HStr[10];

TmpState = State;
State = NoAction;
InsertState (WaitForPrompt, NULL, 0);
// "Own Device" kommt bei Version 5 nicht!!
// wenn keine Version 5 des angeschlossenen ZP --> warten auf "Device"
if (strstr(MoniMod.Version, "V5") eq NULL)
Then
  InsertState (WaitForString, "DEVICE", 0);
Endif

SStr = GetStateStr (TmpState);
FlushIQue(); P = HStr;
P = P + wsprintf (P, "CHD");
if (Hibus) *P++ = 'H';
if (SStr) P = P + wsprintf (P, "%s", SStr);
*P++ = Cr; *P = 0; MDvalid = 0;
SendStr (HStr);
DumpModInfo ("Send CHD");
State = GetNextState ();

End

/*---------------------------------------------------------------------------*/


VOID    WaitForString_F ()

Begin
static
LPSTR   SStr_P,Timo_P;
LPSTR	SStr;
char    c;

TmpState = State; State = NoAction;
SStr = GetStateStr (TmpState);
While ((c = GetCharComm()) ne EOF)
Begin
//  if (c eq Sync)  continue;
  if (c eq Bel)
  Then
    PriErr (ErrTRS);
    TmpState = InitState(0); break;
  Endif
  if (DispOnWait)  DisplayBuf ((BYTE*) &c, 1);
  if (CheckStream (toupper(c), "TIMEOUT!", &Timo_P))
  Then
    TmpState = InitState(0);  break;
  Endif
  if (CheckStream (toupper(c), SStr, &SStr_P))
  Then
    DispOnWait = 0;
    TmpState = GetNextState();  break;
  Endif
Endwhile

State = TmpState;

End

/*---------------------------------------------------------------------------*/


VOID    WaitForPrompt_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion wartet auf einen Monitor-Prompt, auch nach
**      Bootvorgang
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
static
LPSTR   Code_P,ReadyP,B_EscP;
static  int NoBCheck;
LPSTR	SStr;
char    c;

TmpState = State;
State = NoAction;  SStr = NULL;
While ((c = toupper(GetCharComm())) ne EOF)
Begin
  if (c eq Bel)
  Then
    if (NoBCheck) continue;
    PriErr (ErrTRS);
    TmpState = InitState(0); goto Exit;
  Endif
  if (CheckStream (c, "CODE: ", &Code_P))
  Then
    SStr = "@3*8=24\r";
  Endif
  if (CheckStream (c, "READY ...", &ReadyP)) NoBCheck++;
  if (CheckStream (c, " \033[", &B_EscP))    SStr = "\032";
Endwhile

if (SStr)
Then
  FlushIQue();  SendStr(SStr);
Endif

if (MoniReady)
Then
 TmpState = GetNextState(); NoBCheck = 0;
Endif

Exit:
State = TmpState;

End

/*---------------------------------------------------------------------------*/

VOID    WaitForEcho_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion wartet auf einen definiertes Echo
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
static  LPSTR   YesP;
char    c;
int     trigger;

TmpState = State;
State = NoAction;
trigger = 0;
While ( (c = toupper(GetCharComm())) ne EOF)
Begin
//  if (c eq Sync)  continue;
  if (c eq Bel)
  Then
    PriErr (ErrTRS); TmpState = InitState(0);
    break;
  Endif
  trigger = CheckStream (c, EchoBuf, &EchoPtr);
  if (trigger)  break;
  if (CheckStream (c, "[Y]", &YesP))   PutChrComm (Cr);
Endwhile
if (trigger)  TmpState = GetNextState();

State = TmpState;

End

/*---------------------------------------------------------------------------*/

VOID    CalcModNr_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ermittelt aus dem Dateinamen das noch anzuwÑhlende
**      Modul
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
WORD    Num;
char	HStr[10];
char    *P;

State = NoAction;
strupr (FileName); Num = 0;
P = strchr(FileName, '.');
if (P eq NULL) P = FileName + strlen(FileName);
if (memcmp(FileName, "MIC", 3) and memcmp(FileName, "CFG", 3) and memcmp(FileName, "CAN", 3))
Then
  // Modulnummer aus Extention
  if (*(P+1) eq 'H') Num = atoi (P+2);
Else
  Num = atoi(P-2);
Endif
itoa (Num, HStr, 10);

if (Num >= ModNrMin and Num <= ModNrMax)
Then
//  InsertState (WaitForPrompt, NULL, 0);
  InsertState (SendCHDBef, HStr, 0);
Endif
State = GetNextState();

End

/*---------------------------------------------------------------------------*/


VOID    WaitForPDP_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion wartet auf einen PDP-Prompt
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char    c,lc=0;

While ( (c = toupper(GetCharComm())) ne EOF)
Begin
  lc = c;
Endwhile

if (lc eq '>')
Then
  State = GetNextState ();
Endif

End

/*--------------------------------------------------------------------------*/

short   PriErr(short Nr)

/*F
**.* Beschreibung :
**
**      Die Funktion eroeffnet eine Message-Box mit einem der
**      Fehlernummer entsprechenden Text.
**
**.* Funktionswerte :
**
**      Fehlernummer
**
*/

Begin

State = NoAction;
Switch  (Nr)

case    ErrNHV: OkMessage (401, NULL);
		break;
case    ErrCHS: OkMessage (402, NULL);
		break;
case    ErrTRS: OkMessage (403, NULL);
                MonError = 1;
		break;
case    ErrTMO: OkMessage (404, NULL);
		break;
case    ErrECS: OkMessage (340, NULL);
		break;
Endswitch

return (Nr);

End


/*---------------------------------------------------------------------------*/


static  WORD    wi;
static  BYTE    Nibble1,Sum,PSum;

static  int     GetH86Zl(VOID)

/*F
**.* Beschreibung :
**
**      Die Funktion liest eine Hex-Intel Formatzeile in Work
**      ein und ueberprueft dabei Einhaltung der Formatregeln.
**      Ausserdem wird vor und nach jeder Zeile Xon/Xoff gesendet.
**      und der Empfangs-Timeout ueberwacht.
**      
**.* Funktionswerte :
**
**      0          :    eine Zeile wurde korrect gelesen
**      <0 bzw. EOF:    kei Zeichen in EmpfangsQue
**      >0         :    Fehlernummer entsprechend dem auf
**                      getretenen Fehler
**
**
*/


Begin
char    c;
int     ret;

While ( (c = toupper(GetCharComm())) ne EOF )
Begin
  if (wi)
  Then
    if  (isxdigit(c))
    Then
      if  (Nibble1)
      Then
	PSum = PSum + HZif(c);
	Nibble1 = 0;
      Else
	Sum += PSum;
	PSum = HZif(c) << 4;
	Nibble1++;
      Endif
      Work[wi++] = c;
    Else
      if  (iscntrl(c))
      Then
	Switch (c)
	  case Lf:      Work[wi++] = c; Work[wi] = 0;
			Sum = -Sum;
			if (Sum != PSum)
			Then
			  ret = ErrCHS;         // checksum-Error
			Else
			  ret = 0;
			Endif
			goto Clear;
		
	  case Cr:      Work[wi++] = c;
			break;
		
	  default:      continue;
	Endswitch
      Else
	Work[wi++] = c; // keine Hex-Ziffer
	Work[wi] = 0;
	ret = ErrNHV; goto Clear;
      Endif
    Endif
  Else
    //  auf ':' warten
    if (c eq ':')  Work[wi++] = c;
  Endif
Endwhile
ret = EOF;
goto Exit;

Clear:
PSum = 0;  Nibble1 = 0;
Sum = 0; wi = 0;

Exit:
return (ret);

End


/*---------------------------------------------------------------------------*/


VOID    RecivH86File_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion liest Zeile fuer Zeile und schreibt sie
**      in die zuvor eroeffnete Datei. Tritt beim lesen ein
**      Fehler auf so wird dieser auf dem Bildschrim ausgegeben
**      und die Uebertragung abgebrochen.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
OFSTRUCT  OF;
short   cc,len;

TmpState = State;
State = NoAction;
While ( (cc = GetH86Zl()) ne EOF)
Begin
  if (cc)
  Then
    PriErr (cc);
    TmpState = InitState(0);
    break;
  Endif
  len = strlen(Work);
  cc = _FWrite (Datptr, Work, len);
  if (cc ne len)
  Then
    if (Datptr > 0)  OkMessage (483, NULL);
    strcat (FilePath, "\\"); strcat (FilePath, FileName);
    OpenFile (FilePath, &OF, OF_DELETE);
    TmpState = InitState(0);
    break;
  Endif
  IncCount (Work);
  if (strstr(Work, EndBlock))
  Then
    TmpState = GetNextState();
    break;
  Endif
Endwhile
State = TmpState;

End
  
  
/*---------------------------------------------------------------------------*/


VOID    RecivH86Blck_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion liest Zeile fuer Zeile und schreibt sie
**      in die zuvor eroeffnete Datei. Tritt beim lesen ein
**      Fehler auf so wird dieser auf dem Bildschrim ausgegeben
**      und die Uebertragung abgebrochen.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
OFSTRUCT  OF;
short   cc,len;

TmpState = State;
State = NoAction;
While ( (cc = GetH86Zl()) ne EOF)
Begin
  if (cc)
  Then
    PriErr (cc);
    TmpState = InitState(0);
    break;
  Endif
  if (strstr(Work, EndBlock))
  Then
    TmpState = GetNextState();
    break;
  Endif
  len = strlen(Work);
  cc = _FWrite(Datptr, Work, len);
  if (cc ne len)
  Then
    if (Datptr > 0)  OkMessage (483, NULL);
    strcat (FilePath, "\\"); strcat (FilePath, FileName);
    OpenFile (FilePath, &OF, OF_DELETE);
    TmpState = InitState(0);
    break;
  Endif
  IncCount (Work);
Endwhile
State = TmpState;

End
  
/*---------------------------------------------------------------------------*/

static  int     GetDMPZl(VOID)

Begin
static
BYTE	sum;
char    c;
LPSTR	P;
int     ret,cs;

ret = EOF;
While ( (c = toupper(GetCharComm())) ne EOF )
Begin
  Work[wi++] = c;
  if (c eq Lf)
  Then
    Work[wi] = 0;  goto Check;
  Endif
Endwhile
goto Exit;

Check:
ret = cs = wi = 0; P = Work;
if (strstr(P, "FLOAD") or strstr(P, EndDump))
Then
  sum = 0; goto Exit;
Endif

While (P)
Begin
  if (cs)
  Then
    cs = atoh(P); sum = -sum;
    if (sum ne cs)
    Then
      ret = ErrCHS;         // checksum-Error
    Endif
    sum = 0;
    break;
  Else
    sum = sum + atoh(P);
  Endif
  
  P = strpbrk(P, ",;");
  if (P)
  Then
    if (*P eq ';') cs++;
    P++;
  Endif
Endwhile

Exit:
return (ret);

End

/*---------------------------------------------------------------------------*/


VOID    RecivDmpFile_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion liest Zeile fuer Zeile und schreibt sie
**      in die zuvor eroeffnete Datei. Tritt beim lesen ein
**      Fehler auf so wird dieser auf dem Bildschrim ausgegeben
**      und die Uebertragung abgebrochen.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
OFSTRUCT  OF;
short   cc,len;

TmpState = State;
State = NoAction;
While ( (cc = GetDMPZl()) ne EOF)
Begin
  if (cc)
  Then
    PriErr (cc);  goto Err;
  Else
    len = strlen(Work);
    cc = _FWrite(Datptr, Work, len);
    if (cc ne len)
    Then
      if (Datptr > 0)  OkMessage (483, NULL);
      strcat (FilePath, "\\"); strcat (FilePath, FileName);
      OpenFile (FilePath, &OF, OF_DELETE);  goto Err;
    Endif
    wi = 0;  IncCount (Work);
    if (strstr(Work, EndDump))
    Then
      TmpState = GetNextState();
      CloseFile (Datptr); goto Exit;
    Endif
  Endif
Endwhile
goto Exit;

Err:
TmpState = InitState(0);

Exit:
State = TmpState;

End
  
/*---------------------------------------------------------------------------*/


static  int     GetAscZl(VOID)
 
/*F
**.* Beschreibung :
**
**      Die Funktion liest eine spezial Dump Formatzeile in Work
**      ein.
**      Ausserdem wird vor und nach jeder Zeile Xon/Xoff gesendet.
**      und der Empfangs-Timeout ueberwacht.
**
**.* Funktionswerte :
**
**      0          :    eine Zeile wurde korrect gelesen
**      <0 bzw. EOF:    kei Zeichen in EmpfangsQue
**      >0         :    Fehlernummer entsprechend dem auf
**                      getretenen Fehler
**      
**
*/


Begin
char    c;

While ( (c = toupper(GetCharComm())) ne EOF )
Begin
  if (iscntrl(c))
  Then
    Switch (c)
      case Lf:  Work[wi++] = c;
		Work[wi] = 0;
		return (0);
		
      case Cr:  Work[wi++] = c;
		break;
		
      default:  continue;
    Endswitch
  Else
    Work[wi++] = c;
  Endif
Endwhile
return (EOF);

End

/*---------------------------------------------------------------------------*/


VOID    RecivAscFile_F ()

Begin
OFSTRUCT  OF;
short   cc,len;

TmpState = State;
State = NoAction;
While ( (cc = GetAscZl()) ne EOF)
Begin
  if (cc)
  Then
    if (cc < 0) {PriErr (cc); goto Err;}
    TmpState = GetNextState(); wi = 0; goto Exit;
  Else
    len = strlen(Work);
    cc = _FWrite(Datptr, Work, len);
    if (cc ne len)
    Then
      OkMessage (483, NULL);
      strcat (FilePath, "\\"); strcat (FilePath, FileName);
      OpenFile (FilePath, &OF, OF_DELETE);  goto Err;
    Endif
    wi = 0;  IncCount (Work);
  Endif
Endwhile
if (MoniReady) TmpState = GetNextState();
goto Exit;

Err:
TmpState = InitState(0);

Exit:
State = TmpState;

End
  

/*---------------------------------------------------------------------------*/


VOID    WaitForCr_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion wartet auf Cr des gesendeten Befehls
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
char    c;

TmpState = State;
State = NoAction;
While ( (c = toupper(GetCharComm())) ne EOF)
Begin
//  if (c eq Sync) continue;
  if (c eq Bel)
  Then
    PriErr (ErrTRS); TmpState = InitState(0);
    break;
  Endif
  if (c eq Cr)
  Then
    TmpState = GetNextState ();
    break;
  Endif
Endwhile
State = TmpState;

End


/*---------------------------------------------------------------------------*/

static  WORD    DOff;

VOID    WINAPI	InitRecvBuf (WORD Init)

Begin

if (Init) *MrDataP = 0;
DOff = 0;

End

/*---------------------------------------------------------------------------*/


VOID    StoreUntilP_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion speichert empfagene Daten in hRData zwischen
**      bis der Monitor-Prompt erscheint.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
static  WORD    ignCnt;
static  LPSTR   YesP,CrLS_P,CrLD_P;
char    HStr[10],*P;
WORD    hw,lVal;
char    c;
LPSTR   LP,LPi;

TmpState = State;
State = NoAction;
LPi = MrDataP; LP = LPi + DOff;
While ((c = toupper(GetCharComm())) ne EOF)
Begin
//  if (c eq Sync or c eq 0)  continue;
  if (c eq Bel)
  Then
    TmpState = GetNextState ();
    // Daten als ung¸ltig markieren
    InitRecvBuf (1);     break;
  Endif
  if (c eq '\r')
  Then
    IncCount((LPSTR) 16);  ignCnt = 0;
  Endif

  hw = GetStateCnt(TmpState);
  if (CheckStream (c, "[Y]", &YesP))
  Then
    P = HStr;  ignCnt++;
    if (hw)  *P++ = 'N';
    *P++ = Cr;   *P = 0;
    SendStr (HStr);
  Endif
/*
  if (DOff >= Size)
  Then
    TmpState = GetNextState ();
    *LP = 0;   break;
  Endif
*/
  *LP++ = c; DOff++;
  if (CheckStream (c, "\r\n*", &CrLS_P) or
      CheckStream (c, "\r\n$", &CrLD_P))
  Then
    TmpState = GetNextState ();
    *LP = 0;  InitRecvBuf (0);
    DbgStr("MrDataP:");
    DbgStr(MrDataP);
    break;
  Endif
Endwhile
State = TmpState;

End

/*---------------------------------------------------------------------------*/

static  WORD    GetNextVal (LPSTR * LPP)

Begin
WORD    ret;
LPSTR   LP;

ret = 0;
*LPP = strtok (NULL, " .\015\012");
if (*LPP eq 0)  goto Exit;
LP = strchr(*LPP, ':');
if (LP)
Then
  *LPP = strtok (NULL, " \015\012");
  if (*LPP eq 0)  goto Exit;
Endif
ret = atoh (*LPP);

Exit:
return (ret);

End

/*---------------------------------------------------------------------------*/

VOID    CheckBukl_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ermittelt aus dem empfangen Daten des DW-Befehls
**      die Grî·e des Bukl und generiert de Befehl zum empfang desselben.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD    NState;

State = NoAction;
InsertState (StoreUntilP, NULL, 0);
wsprintf (Work, "DW%X:0L20\015", Sel_Mod.BukSeg);
//if (IsTCPConnection() eq 0) InsertState (WaitForEcho, Work);
InsertState (SendString, Work, 0);

NState = GetNextState();
State = NState;

End

/*---------------------------------------------------------------------------*/


VOID    CalcBuklSize_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ermittelt aus dem empfangen Daten des DW-Befehls
**      die Grî·e des Bukl und generiert de Befehl zum empfang desselben.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD   NState;
WORD    hw,i,BukAnz,Len,Off;
LPSTR   LP;

State = NoAction;
LP = MrDataP;
LP = strtok(LP, " \015\012");
if (LP eq NULL)  goto Err;
for (i=0; i<FGeMax; i++)
Begin
  hw = GetNextVal (&LP);
  if (LP eq NULL)  goto Err;
  if (hw eq 0 or hw > 5) goto Err;
Endfor
BukAnz = 0; Len = 0;
for (i=0; i<FGiMax; i++)
Begin
  hw = GetNextVal (&LP);
  if (LP eq NULL)  goto Err;
  if (hw)
  Then
    BukAnz++; Len = Len + hw + 1;
  Endif
Endfor
hw = GetNextVal (&LP);  GetNextVal (&LP);
if (hw > FGiMax)  goto Err;
hw = GetNextVal (&LP);
Off = ((FGeMax + FGiMax + 2) << 1) + (BukAnz << 6);
// steht 1. Zeichen hinter Pointerarray?
if (hw ne Off)  goto Err;
Off = Off + (Len << 4);
wsprintf (Work, "W%X:0L%X\015", Sel_Mod.BukSeg, Off);
//if (IsTCPConnection() eq 0) InsertState (WaitForEcho, Work);
InsertState (SendString, Work, 0);
NState = GetNextState();
goto Exit;

Err:
OkMessage (335, NULL);
NState = InitState(0);

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/


VOID    CheckDBModul_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ÅberprÅft, ob das angewÑhlte modul ein ZP... ist.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD    NState;
char    HStr[20];
LPSTR   LP;

NState = State;
State = NoAction;
LP = GetStateStr (NState);
if (strcmp(LP, "Check"))
Then
  InsertState (CheckDBModul, "Check", 0);
  InsertState (GetModTyp, NULL, 0);
  NState = GetNextState ();
Else
  if (GetModInfo(ModHnd, MOD_dbmod, NULL) eq 0)
  Then
    GetModInfo (ModHnd, MOD_modul, HStr);
    OkMessage (334, HStr);
    NState = InitState(0);
  Else
    NState = GetNextState();
  Endif
Endif

State = NState;

End

/*---------------------------------------------------------------------------*/


VOID    CheckCANMd_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ¸berprÅft, ob das angew‰hlte modul ein CAN-Modul ist.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD    NState;
char    HStr[20];
LPSTR   LP;

NState = State;
State = NoAction;
LP = GetStateStr (NState);
if (strcmp(LP, "Check"))
Then
  InsertState (CheckCANMd, "Check", 0);
  InsertState (GetModTyp, NULL, 0);
  NState = GetNextState ();
Else
  if (GetModInfo(ModHnd, MOD_canmd, NULL) eq 0)
  Then
    GetModInfo (ModHnd, MOD_modul, HStr);
    OkMessage (334, HStr);
    NState = InitState(0);
  Else
    NState = GetNextState();
  Endif
Endif

State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    CheckCANLUM_F ()

//**.* Beschreibung :
//**
//**      Die Funktion ¸berpr¸ft, ob die Moduladresse passt
//**
//**.* Funktionswerte :
//**
//**      keine
//**

Begin
DWORD    NState;
char    HStr[20];
char	MAdr[10];
LPSTR   LP,P2;
LONG	hdw,hl[2];
WORD    hw;

NState = State;
State = NoAction;
LP = GetStateStr (NState);
if (strcmp(LP, "Check"))
Then
  InsertState (CheckCANLUM, "Check", 0);
  InsertState (GetLineUsMod, NULL, 0);
  NState = GetNextState ();
Else
  strcpy (MAdr, DDEValP);
  LP = FileName+3; P2 = HStr;
  *P2++ = *LP++; *P2++ = '.';
  *P2++ = *LP++; *P2++ = *LP++; *P2++ = '.';
  *P2++ = *LP++; *P2++ = *LP; *P2 = 0;
  if (strcmp(MAdr, HStr))
  Then
    hl[0] = (LONG) MAdr; hl[1] = (LONG) HStr;
//    hdw = MB_ICONHAND | MB_USERICON | MB_YESNO | MB_BEEP;
    hdw = MB_ICONWARNING | MB_YESNO | MB_BEEP;
    hw = LIMessage (fht, hWndWTH86, 337, hdw, hl, "");
    if (hw eq IDNO)
    Then
      NState = InitState(0);  goto Exit;
    Endif
  Endif
  NState = GetNextState();
Endif

Exit:
State = NState;

End


/*---------------------------------------------------------------------------*/

VOID    InsNetOnZP12_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion fÅgt das Komando "net -in" ein, wenn das Modul >= ZP12 ist
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD    NState;
char    HStr[20];

State = NoAction;
GetModInfo (ModHnd, MOD_modul, HStr);
if (latoi(&HStr[4]) >= 12)
Then
  InsertState (RecivAscFile, NULL, 0);
//  if (IsTCPConnection() eq 0) InsertState (WaitForCr, NULL);
  InsertState (SendString, "NET -IN\015", 0);
Else
  GetText (fht, Work, 486);  MessageBeep(0);
  MessageBox(hWndWTH86, Work, HStr, MB_OK | MB_ICONINFORMATION);
Endif
NState = GetNextState ();
State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    CalcMKonst_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ermittelt die Adresse der MICAS-Konstanten und sichert sie
**
*/

Begin
DWORD   NState;
WORD    hw;
WORD	Off1,Off2;
LPSTR   LP;

TmpState = State; State = NoAction;
hw = GetStateCnt (TmpState);
if (hw eq 0)
Then
  // wenn Festkomma-Micas... keine Konstanten abziehen
  if (Sel_Mod.FKMic)
  Then
    Sel_Mod.KonLen = 0x2000;  LP = Sel_Mod.ModTyp;
    if (strstr(LP, "AR") or strstr(LP, "MB") or strstr(LP, "SP"))
    Then
      Sel_Mod.KonLen = 0x0400;
    Endif
    goto Next;
  Endif

  wsprintf (Work, "DW%X:0L8\015", Sel_Mod.OffSeg);
  InsertState (CalcMKonst, NULL, 1);
  InsertState (StoreUntilP, NULL, 0);
  InsertState (SendString, Work, 0);
  NState = GetNextState ();
  goto Exit;
Endif

LP = MrDataP;
strtok(LP, " \015\012");
LP = strtok(NULL, " \015\012");
if (Sel_Mod.FKMic)
Then
  Off1 = 0;
Else
  Off1 = atoh (LP);
Endif
//if (hw ne 0xF000) goto Err;
LP = strtok(NULL, " \015\012");
if (LP eq NULL)  goto Err;
LP = strtok(NULL, " \015\012");
if (LP eq NULL)  goto Err;
Off2 = atoh(LP);

Sel_Mod.KonOff = Off1;
Sel_Mod.KonLen = Off2 - Off1;

Next:
AddNextState (CalcLTask, NULL);
NState = GetNextState();
goto Exit;

Err:
OkMessage (333, NULL);
NState = InitState(0);

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    CalcLTask_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ermittelt die Segmentadresse der letzten Task
**      und generiert daraus einen Suchbefehl fÅr den Endebaustein.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char	HStr[30];
DWORD   NState;
WORD    hw,Tanz,i,j;
LPSTR   LP;

NState = State; State = NoAction;
hw = GetStateCnt (NState);
if (hw eq 0)
Then
  wsprintf (HStr, "DW%X:0L%X\015", Sel_Mod.KbsSeg, 2+(TaskMax<<2));
  InsertState (CalcLTask, NULL, 1);
  InsertState (StoreUntilP, NULL, 0);
  InsertState (SendString, HStr, 0);
  NState = GetNextState ();
  FTskSeg = LTskSeg = 0;
  goto Exit;
Endif

LP = MrDataP;
LP = strstr(LP, "\015\012");
if (LP eq NULL)  goto Err;
strtok(LP, " \015\012");
LP = strtok(NULL, " \015\012");
hw = atoh (LP);
if (hw ne 0xF000) goto Err;
LP = strtok(NULL, " \015\012");
if (LP eq NULL)  goto Err;
hw = atoh(LP);
if (hw ne 0x2000) goto Err;
LP = strtok(NULL, " \015\012");
if (LP eq NULL)  goto Err;
Tanz = atoh(LP);
if (Tanz > TaskMax) goto Err;
j = Tanz << 2; i=0;
While (i<j)
Begin
  LP = strtok(NULL, " \015\012");
  if (LP eq NULL)  goto Err;
  if (strchr(LP, ':')) continue;
  if ((i mod 4) eq 2)
  Then
    hw = atoh(LP);
    if (FTskSeg eq 0) FTskSeg = hw;
    LTskSeg = hw;
  Endif
  i++;
Endwhile
hw = Sel_Mod.CLMax >> 1;
wsprintf (Work, "FW%X:0L%X=%X\015", LTskSeg, hw, Sel_Mod.EndBst);
InsertState (CalcLTask2, NULL, 0);
InsertState (StoreUntilP, NULL, 0);
InsertState (SendString, Work, 0);
NState = GetNextState();
goto Exit;

Err:
OkMessage (333, NULL);
NState = InitState(0);

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

static  WORD    GenDWBef (LPSTR Bef, LPSTR Data, WORD lOff)

/*F
**.* Beschreibung :
**
**      Die Funktion generiert aus den Empgangsdaten des FW-Befehls
**      fÅr den Endebaustein einen DW-Befehl fÅr das vorherige Wort.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char    HStr[20],*P;
WORD    ret;
LPSTR   LP;

ret = 0;
Hexcw (HStr, LTskSeg);
P = HStr + strlen(HStr);
*P++ = ':'; *P = 0;
if (lOff)
Then
  Hexcw (P, lOff);
  LP = strstr (Data, HStr);
  if (LP eq 0) goto Exit;
  Hexcw (HStr, LTskSeg);
  LP = strstr (LP+5, HStr);
  if (LP eq 0) goto Exit;
Else
  LP = strstr (Data, HStr);
  if (LP eq 0) goto Exit;
Endif

LP = strchr(LP, ':')+1;
ret = atoh (LP);
wsprintf (Bef, "DW%X:%X\015", LTskSeg, ret-2);

Exit:
return (ret);

End

//---------------------------------------------------------------------------


VOID    CalcLTask2_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ermittelt die Segmentadresse der letzten Task
**      und generiert daraus einen Suchbefehl fÅr den Endebaustein.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
static
WORD    lastOff;
DWORD   NState;
WORD    hw,Seg;
LPSTR   LP;

NState = State; State = NoAction;
hw = GetStateCnt (NState);
if (hw eq 0)
Then
  LP = MrDataP;
  LP = strstr(LP, "\015\012");
  if (LP)
  Then
    lastOff = GenDWBef (Work, LP+2, lastOff);
  Else
    goto Err;
  Endif
Else
  // Wert von letztem DW-Befehl untersuchen
  // und im Ok-Fall W-Befehl aufsetzen
  LP = MrDataP;
  LP = strchr (LP, ':');
  if (LP eq NULL)  goto Err;
  LP = strtok (LP, " \015\012");
  if (LP eq NULL)  goto Err;
  LP = strtok (NULL, " \015\012");
  if (LP eq NULL or *LP ne 'F')  goto Err;

  //
  if (Sel_Mod.FKMic eq 0)
  Then
    wsprintf (Work, "W%X:0L30\015", Sel_Mod.OffSeg);
    AddNextState (SendString, Work);
    AddNextState (RecivH86Blck, NULL);
  Endif

  // Konstanten
  if (Sel_Mod.KonLen)
  Then
    wsprintf (Work, "W%X:%XL%X\015", Sel_Mod.DatSeg, Sel_Mod.KonOff, Sel_Mod.KonLen);
    AddNextState (SendString, Work);
    AddNextState (RecivH86Blck, NULL);
  Endif

  // Kopfbaustein
  wsprintf (Work, "W%X:0L%X\015", Sel_Mod.KbsSeg, 4+(TaskMax<<3));
  AddNextState (SendString, Work);
  AddNextState (RecivH86Blck, NULL);

  // Programmcode
  Seg = FTskSeg; hw = ((LTskSeg - FTskSeg) << 4) + lastOff + 2;
  wsprintf (Work, "W%X:0L%X\015", Seg, hw);
  AddNextState (SendString, Work);
  AddNextState (RecivH86File, NULL);

  AddNextState (TransFin, NULL);
  NState = GetNextState(); goto Ready;
Endif
InitState (IS_NOCLOSE | IS_NODSWIN);
AddNextState (SendString, Work);
AddNextState (StoreUntilP, NULL);
AddNextStat2 (CalcLTask2, NULL, 1);
NState = GetNextState();
goto Exit;

Err:
OkMessage (333, NULL);
NState = InitState(0);

Ready:
lastOff = 0;

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

	MODULE	Module[33] = {
	{"29ZP20",  2, "V0"},
	{"29AC40",  3, "V10"},
	{"29ZP10", 10, "V8"},
	{"29BK12", 20, "V3"},
	{"29AR10", 29, "V3"},
	{"29SP10", 30, "V3"},
	{"29MB10", 31, "V3"},
	{NULL, NULL, NULL}};
static	PMODULE	ModP = Module;	// aktuelles Modul

VOID    GetModule_F ()

Begin
DWORD   NState;
WORD    hw;
PMODULE	MP;
LPSTR   LP,PD,PDi;                                      
char	HStr[10];

NState = State; State = NoAction;
hw = GetStateCnt (NState);
if (EEDump and IsAnyConnection() eq 0)
Then
  PD = DDEValP;
  MP = Module-1; hw = 0;
  While((++MP)->Num)
  Begin
    if (hw) *PD++ = ',';
    Dezcb (PD, MP->Num, 2);
    if (hw eq 0) strcat(PD, "!");
    if (MP->Num eq ModP->Num) strcat(PD, "*");
    PD = PD + strlen(PD); hw++;
  Endwhile
  goto Next;
Endif

if (hw)
Then
  PDi = PD = DDEValP;
  LP = MrDataP;

//  DbgStr ("GetModule:  1");
//  DbgStr(LP);
//
  LP = strchr (LP, ':');
  if (LP eq NULL)   goto Next;
  LP = strtok (LP+1, " ");
  MoniMod.Mod = atoi(LP);
  PD = PD + wsprintf (PD, "%02u!", MoniMod.Mod);
  LP = LP + strlen(LP);
  LP = strchr (LP+1, ':');
  if (LP eq NULL)    goto Next;
  LP++; Sel_Mod.Mod = atoi(LP);
  strtok(LP, "\r\n");
  LP = strtok(NULL, "\r\n");
/*
  if (OwnMod ne MoniMod.Mod)
  Then
    MoniMod.Mod = OwnMod;  strcpy (MoniMod.Version, "V5");
    InsertState (GetModData, NULL, 0);
    if (OwnMod ne SelMod)
    Then
      itoa (OwnMod, HStr, 10);
      InsertState (SetModulNr, HStr, 0);
    Endif
  Endif
*/
  DumpModInfo ("GetModule");


//.... Schleife fÅr Modulnummern!
  While (LP)
  Begin
    if (IsNumeric(LP))
    Then
      wsprintf (HStr, "%02u", atoi(LP));
      if (strstr(PDi, HStr) eq NULL)
      Then
	PD = PD + wsprintf (PD, ",%s", HStr);
      Endif
    Endif
    LP = strtok(NULL, " *\015\012");
  Endwhile
  hw = wsprintf (HStr, "%02u", Sel_Mod.Mod);
  LP = strstr(PDi, HStr);
  if (LP)
  Then
    LP = LP + hw;
    if (*LP eq '!') LP++;
    hw = strlen(LP) + 1;
    memmove (LP+1, LP, hw);
    *LP = '*';
    PD = LP + hw;
  Endif
  *PD = 0;  //MessageBox (hWndWTH86, PDi, "Module", 0);
Else
  InsertState (GetModule, NULL, 1);
  InsertState (StoreUntilP, NULL, 0);
  InsertState (SendString, "CHD\015", 0);
Endif

Next:
NState = GetNextState();
State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    GetModTyp_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion ÅberprÅft ermittelt den Modul-Typ mittels des CD-Befehls
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD    NState;

State = NoAction;
if (MDvalid)
Then
  strcpy (DDEValP, Sel_Mod.ModTyp);
  //DDECommand = 0;
Else
  InsertState (GetModTyp, NULL, 0);
  InsertState (GetModData, NULL, 0);
Endif
NState = GetNextState ();

State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    GetModulNr_F ()

Begin
DWORD   NState;
WORD    hw;
LPSTR   LP,PD;

NState = State; State = NoAction;
hw = GetStateCnt (NState);
if (hw)
Then
  LP = MrDataP; hw = 0;
  LP = strtok(LP, " \015\012");
  While (LP)
  Begin
    LP = strtok(NULL, " \015\012");
    if (LP eq NULL)  goto Err;
    if (strstr(LP, ")"))
    Then
      if (hw ne 0) hw = 0;
      else         hw++;
    Endif
    if (*LP eq ':')
    Then
      if (hw ne 1) hw = 0;
      else         hw++;
    Endif
    if (hw eq 2) break;
  Endwhile
  if (LP eq NULL)  goto Err;
  LP = strtok(NULL, " \015\012");
  if (LP eq NULL)  goto Err;

  DumpModInfo ("GetModulNr");

  PD = DDEValP;
  wsprintf (PD, "%02d", atoi(LP));
Else
  if (EEDump)
  Then
    PD = DDEValP;
    wsprintf (PD, "%02d", 2);
  Else
    InsertState (GetModulNr, NULL, 1);
    InsertState (StoreUntilP, NULL, 0);
    InsertState (SendString, "CHD\015", 0);
  Endif
Endif
NState = GetNextState();
goto Exit;

Err:
OkMessage (403, NULL);
NState = InitState(0);

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

static	WORD	LeftValue (LPSTR Str, char Ch)

Begin
LPSTR	P;
WORD	ret;

P = strchr(Str, Ch); ret = 0;
if (P eq NULL) goto Exit;
while (isdigit(*P) eq 0) P--;
While (1)
Begin
  if (P eq Str)
  Then
    P--; break;
  Endif
  if (isdigit(*P) eq 0) break;
  P--;
Endwhile
ret = atoi(P+1);

Exit:
return (ret);

End

/*---------------------------------------------------------------------------*/

VOID    GetLineUsMod_F ()

Begin
DWORD   NState;
WORD    TState,hw;
LPSTR   LP;
char	HStr[20],Str2[10];

NState = State; State = NoAction;
if (EEDump and IsAnyConnection() eq 0)
Then
  aLine = 0; aUsNr = 1;
  TState = 1;
Else
  TState = GetStateCnt(NState);
Endif

Switch (TState)
  case 0:	InsertState (GetLineUsMod, NULL, 1);
		// damit SelMod aktuell ist!
//		if (aLine < 0 or aUsNr < 0)
//		Then
		  InsertState (GetLUSMod, NULL, 0);
//		Endif
		break;

  case 1:       LP = DDEValP; *LP = 0;
  		if (aLine < 0 or aUsNr < 0)  break;
		*LP++ = aLine + '0';
		*LP++ = '.';
		Dezcb (LP, aUsNr, 2);
		*(LP+2) = '.';  Dezcb (LP+3, Sel_Mod.Mod, 2);

		DumpModInfo ("GetLineUsMod 1");
		break;
Endswitch
NState = GetNextState();
State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    GetLUSMod_F ()

Begin
static
WORD	Mod;
DWORD   NState;
WORD    TState,hw,i;
LPSTR   LP;
char	HStr[20],Str2[10];

NState = State; State = NoAction;
if (EEDump and IsAnyConnection() eq 0)
Then
  aLine = 0; aUsNr = 1;
  NState = GetNextState();
  goto Exit;
Endif

TState = GetStateCnt(NState);
Switch (TState)
  case 0:	InsertState (GetLUSMod, NULL, 1);
		// muss immer aufgerufen werden, da Bediener
		// evtl. Modul gewechselt hat
		InsertState (GetModule, NULL, 0);
//		if (MoniMod.Mod eq 0 or Sel_Mod.Mod eq 0)
//		Then
//		  InsertState (GetModule, NULL, 0);
//		Endif
		break;

  case 1:       InsertState (GetLUSMod, NULL, 2);
		// Modulnummer
		InsertState (StoreUntilP, NULL, 0);
		strcpy(HStr, "GET FGLIST;#1\015");
		InsertState (SendString, HStr, 0);
		Mod = Sel_Mod.Mod;
		if (MoniMod.Mod ne Mod)
		Then
		  itoa (MoniMod.Mod, Str2, 10);
		  InsertState (SetModulNr, Str2, 1);
		Endif
		break;

  case 2:	if (Mod ne Sel_Mod.Mod)
		Then
		  // damit Rest durchlaufen wird !!
		  InsertState (GetLUSMod, NULL, 2);
		  itoa (Mod, Str2, 10);
		  InsertState (SetModulNr, Str2, 1);
		  break;
		Endif
		LP = MrDataP;  aLine = aUsNr = 0;
		LP = strtok(LP, "<,\015\012");
		if (LP eq NULL)  break;
		for (i=0; i<11; i++)
		Begin
		  LP = strtok(NULL, "<,\015\012");
		  if (LP eq NULL)  break;
		Endfor
		if (LP eq NULL)  break;
		aLine = atoh(LP) band 7;
		LP = strtok(NULL, "<,\015\012");
		if (LP eq NULL)  break;
		LP = strtok(NULL, "<,\015\012");
		if (LP eq NULL)  break;
		aUsNr = atoh(LP) >> 4;
		break;
Endswitch
NState = GetNextState();
goto Exit;

NoDB:
OkMessage (398, NULL);
NState = InitState(0);
goto Exit;

ErrFmt:
OkMessage (399, NULL);
NState = InitState(0);

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    SetModulNr_F ()

Begin
DWORD   NState;
WORD    n,SCnt;
LPSTR	SStr;
char    HStr[20];

NState = State;
State = NoAction;
SStr = GetStateStr(NState);
Sel_Mod.Mod = atoi(SStr);
MDvalid = 0;  n = atoi(SStr);
SCnt = GetStateCnt(NState);

if (EEDump and IsAnyConnection() eq 0)
Then
  ModP = Module-1;
  While((++ModP)->Mod)
  Begin
    if (ModP->Num eq n) goto Exit;
  Endwhile
  ModP = Module;
  goto Exit;
Endif

if (MoniMod.Mod and MoniMod.Mod eq n)
Then
  if (aLine < 0 or aUsNr < 0)
  Then
    if (SCnt eq 0) InsertState (GetLUSMod, NULL, 0);
  Endif
Endif

DumpModInfo ("SetModulNr 0");
InsertState (SendCHDBef, SStr, 0);

Exit:
NState = GetNextState();
State = NState;

End

/*---------------------------------------------------------------------------*/

WORD	ModulNameValid (LPSTR Mod)

Begin
WORD	ret,len;

ret = 0;
len = strlen(Mod); Mod--;
if (len ne 6)  goto Exit;
While (*(++Mod))
Begin
  if (isalnum(*Mod) eq 0)  goto Exit;
Endwhile
ret++;

Exit:
return (ret);

End

/*---------------------------------------------------------------------------*/

VOID    GetModData_F ()

Begin
static	LPSTR VS;
DWORD   NState;
WORD    TState,Modi;
WORD	hw,Off;
LPSTR   LP,MD,Ph;
char    HStr[20];

NState = State; State = NoAction;
if (EEDump and IsAnyConnection() eq 0)
Then
  MD = ModP->Mod; VS = ModP->Vers;
  goto Ok;
Endif

TState = GetStateCnt(NState);
Switch (TState)
  case 0:	InsertState (GetModData, NULL, 1);
		InsertState (StoreUntilP, NULL, 1);
		InsertState (SendString, "CD\015", 0);
		break;

  case 1:	LP = MrDataP;
//		DbgStr("GetModData:");
//		DbgStr(LP);

		LP = strtok(LP, " \015\012");
		While (LP and strchr(LP, ':') eq NULL)
		Begin
		  LP = strtok(NULL, " \015\012");
		Endwhile
		if (LP eq NULL)  goto Err;
		strtok(NULL, " \015\012");
		// erste Zeile, zweites Wort
		LP = strtok(NULL, " \015\012");
		if (LP eq NULL)  goto Err;
		Sel_Mod.EESeg = atoh(LP);

		// letztes Wort = Modul-Typ
		Ph = LP + strlen(LP) + 1;
		Ph = strchr(Ph, '\015');
		if (Ph eq NULL)  goto Err;
		Modi = atoh(Ph-4);

		// nÑchste Zeile
		strtok(NULL, "\015\012");
		strtok(NULL, " \015\012");
		LP = strtok(NULL, " \015\012");
		if (LP eq NULL)  goto Err;
		Off = atoh(LP);
		LP = strtok(NULL, " \015\012");
		if (LP eq NULL)  goto Err;
		Sel_Mod.EEOff = Off = Off + atoh(LP);
		LP = LP + strlen(LP) + 1;

		GetText (fht, HStr, 110);
		MD = strstr (LP, "MODUL ");
		VS = strstr (LP, "VERSION");
		if (VS)
		Then
		  VS = strtok (VS+7, " :\015\012");
		  if (VS eq NULL)  goto Err;
		  strcpy (Sel_Mod.Version, VS);
		  LP = strchr(VS, '.'); hw = 2;
		  if (LP)
		  Then
		    hw = LP - VS;
		  Else
		    if (strstr(VS, "V1")) hw++;
		  Endif
		  *(VS+hw) = 0;
		Else
		  VS = "V0";
		Endif
		if (MD)
		Then
		  MD = strtok (MD+5, " :\015\012");
		  if (MD eq 0)  goto Err;
		Else
		  MD = "29ZP03"; VS = "V0";
		Endif
Ok:
		if (ModulNameValid(MD))
		Then
		  ModHnd = GetModHandle(MD);
		Else
		  ModHnd = GetModHandle((LPSTR) Modi);
		  GetModInfo (ModHnd, MOD_modul, HStr);
		  MD = HStr;
		Endif
		if (ModHnd eq 0) goto Err;

		Sel_Mod.FKMic = 0;  strcpy (Sel_Mod.ModTyp, MD);
		if (strstr(MD, "ZP") and strstr(Sel_Mod.Version, "V5."))
		Then
		  Sel_Mod.FKMic++;
		Endif
		if (strstr(Sel_Mod.Version, "V1."))
		Then
		  if (strstr(MD, "AR") or strstr(MD, "MB") or strstr(MD, "SP"))
		  Then
		    Sel_Mod.FKMic++;
		  Endif
		Endif

		Off = Sel_Mod.EEOff;
		Off = Off + GetModInf2 (ModHnd, VS, MOD_eeoff);
		Sel_Mod.EEOff = Off;
		Sel_Mod.BukSeg = GetModInf2 (ModHnd, VS, MOD_bkseg);
		Sel_Mod.KbsSeg = GetModInf2 (ModHnd, VS, MOD_kbseg);
		Sel_Mod.EndBst = GetModInf2 (ModHnd, VS, MOD_endbs);
		Sel_Mod.DatSeg = GetModInf2 (ModHnd, VS, MOD_dtseg);
		Sel_Mod.OffSeg = GetModInf2 (ModHnd, VS, MOD_ofseg);
		Sel_Mod.CLMax  = GetModInf2 (ModHnd, VS, MOD_clmax);
		// da dieses Feature von angeschlossenem Modul
		// abh‰ngt kann es vorerst nicht genutze werden
		// es muss beim CHD-Befehl getestet werden, ob
		// "Own Device" kommt! Dieses Modul muss mit Typ
		// vermerkt werden
		Sel_Mod.EECmd  = GetModInf2 (ModHnd, VS, MOD_eecmd);
		if (MoniMod.Mod and MoniMod.Mod eq Sel_Mod.Mod)
		Then
		  CDE_allowed = Sel_Mod.EECmd;  hw = MoniMod.Mod;
		  memcpy (&MoniMod, &Sel_Mod, sizeof(MODDATA));
		  MoniMod.Mod = hw;
		  // wenn Monitor-Modul schon angew‰hlt ist
		  // Line und Us gleich mit bestimmen
		  if (aLine < 0 or aUsNr < 0)
		  Then
		    InsertState (GetLUSMod, NULL, 0);
		  Endif
		Endif

		GetText (fht, HStr, 111);
		GetModInfo (ModHnd, MOD_versi, Work);
		if (strstr(Work, VS) eq NULL) goto Err;
		MDvalid = 1;  FlushIQue();

		DumpModInfo ("GetModData 1");
		break;
Endswitch
NState = GetNextState();
goto Exit;

Err:
OkMessage (332, HStr);
NState = InitState(0);
MDvalid = 0;

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

LPBYTE	ScanMonLine (LPBYTE Line, LPBYTE Buf, LPWORD pLen)

Begin
WORD	Len;
LPBYTE	LP;

Len = 0;
LP = strtok(Line, " ");
if (LP eq NULL)  goto Exit;
LP = strtok(NULL, " ");
if (LP eq NULL or strlen(LP) ne 2)  goto Exit;

While (LP)
Begin
  *Buf++ = atoh(LP);  Len++;
  LP = strtok(NULL, " ");
  if (Len >= 16 or strlen(LP) ne 2)  break;
Endwhile

Exit:
if (pLen) *pLen = Len;
return (Buf);

End

/*---------------------------------------------------------------------------*/
/*
typedef	struct	{
	WORD	xxx;		// Modul Stamm-ID
	BYTE	MCnt;		// Modulanzahl
}MODTP2,*PMODTP2;
*/

static	WORD    IsCANInvalid (PCANHD PH)

Begin
WORD	Cnt,ret,N;
PMODTP	PM;

ret = 1;  Cnt = N = 0;
PM = PH->MTypes-1;
While ((++PM)->MCnt)
Begin
//  if (PM->SID eq 0)   break;
  Cnt = Cnt + PM->MCnt;  N++;
Endwhile
if (Cnt ne PH->Cnt)  goto Exit;
Cnt = sizeof(CANHDR) + N * sizeof(MODTYP);
if (Cnt ne PH->HdrLen)  goto Exit;
ret = 0;

Exit:
return (ret);

End

/*---------------------------------------------------------------------------*/


VOID    ReadCANData_F ()

Begin
static	LPBYTE	Data;
static	WORD	Len;
TOKDAT	TD;
PCANHD	PH;
DWORD	NState;
WORD    hw,TState;
LPBYTE	LP,P2;
char    HStr[300];

NState = State; State = NoAction;
TState = GetStateCnt(NState);
Switch (TState)
  case 0:	InsertState (ReadCANData, NULL, 1);
		InsertState (StoreUntilP, NULL, 1);
		InsertState (SendString, "CDE400L100\015", 0);
		break;

  case 1:	LP = MrDataP;  P2 = HStr;
		LP = strtok2(LP, "\015\012", &TD);
		While (LP)
		Begin
		  P2 = ScanMonLine (LP, P2, &hw);
		  LP = strtok2(NULL, "\015\012", &TD);
		Endwhile
		// Header auslesen und rest empfangen
		PH = (PCANHD) HStr;
		if (IsCANInvalid(PH))  goto Err;

		Len = PH->TabLen; hw = Len >> 4;
		hw++; hw = hw << 4;
		Data = (LPBYTE) AllocPtr (hw);
		wsprintf (HStr, "CDE400L%X\015", Len);
		InsertState (ReadCANData, NULL, 2);
		InsertState (StoreUntilP, NULL, 0);
		InsertState (SendString, HStr, 0);
		break;

  case 2:       LP = MrDataP;  P2 = Data;
		LP = strtok2(LP, "\015\012", &TD);
		While (LP)
		Begin
		  P2 = ScanMonLine (LP, P2, &hw);
		  LP = strtok2(NULL, "\015\012", &TD);
		Endwhile
		HexIntel (Datptr, 0, 0x400, Data, Len);
		HexIntel (Datptr, 0, 0, 0, 0);
		CloseFile (Datptr); Free_Ptr(&Data);
		break;
Endswitch

State = GetNextState();
return;

Err:
GetText (fht, HStr, 336);
MessageWin (hWndWTH86, HStr, "ReadCANData", 0);
State = InitState(0);

End

/*---------------------------------------------------------------------------*/

VOID    ReadFlash_F ()

Begin
LPBYTE	Data;
WORD	Len,Cnt;
TOKDAT	TD;
DWORD	NState;
WORD    hw,TState;
LPBYTE	LP,P2;
char    HStr[30];

NState = State; State = NoAction;
TState = GetStateCnt(NState);
Switch (TState)
  case 0:	InsertState (ReadFlash, NULL, 1);
		InsertState (StoreUntilP, NULL, 0);
		InsertState (SendString, "CDE0L2000\015", 0);
		break;

  case 1:       Len = 0x2000;  Cnt = 0;
		Data = (LPBYTE) AllocPtr (Len);
		LP = MrDataP;  P2 = Data;
		LP = strtok2(LP, "\015\012", &TD);
		While (LP)
		Begin
		  P2 = ScanMonLine (LP, P2, &hw);  Cnt++;
		  if (Cnt eq 530)
		  Then
		    strcpy (HStr, "");
		  Endif
		  LP = strtok2(NULL, "\015\012", &TD);
		Endwhile
		HexIntel (Datptr, 0, 0, Data, Len);
		HexIntel (Datptr, 0, 0, 0, 0);
		CloseFile (Datptr); Free_Ptr(&Data);
		break;
Endswitch

//Exit:
State = GetNextState();
return;

Err:
GetText (fht, HStr, 399);
MessageWin (hWndWTH86, HStr, "ReadFlash", 0);
State = InitState(0);

End

/*---------------------------------------------------------------------------*/

VOID    GetEEData_F ()

Begin
WORD    Seg,Off,Len;
char    HStr[20];

State = NoAction;
if (MDvalid)
Then
  InsertState (StoreUntilP, NULL, 0);
  if (CDE_allowed)
  Then
    // da die Zul‰ssigkeit von CDE von dem
    // Kommunikationsmodul abh‰ngt und nicht von dem angew‰hlten
    // muss der Code entsprechend ge‰ndert werden
    //
    strcpy (HStr, "CDE\015");
  Else
    Len = GetModInfo((LONG) Sel_Mod.ModTyp, MOD_eesiz, NULL);
    Seg = Sel_Mod.EESeg;  Off = Sel_Mod.EEOff;
    wsprintf(HStr, "DB%X:%XL%X\015", Seg, Off, Len);
  Endif
  InsertState (SendString, HStr, 0);
Else
  InsertState (GetEEData, NULL, 0);
  InsertState (GetModData, NULL, 0);
Endif

State = GetNextState();

End

/*-------------------------------------------------------------------------*/

static	WORD	GetChks (LPVOID Data, LONG MHd)

Begin
LPWORD	wp,wpi;
LPBYTE	CExcl;
WORD	fm,i,n,Chks;
WORD	EELen,AnzCW;

EELen = GetModInfo (MHd, MOD_eesiz, NULL);
CExcl = (LPBYTE) GetModInfo (MHd, MOD_cexcl, NULL);
// Ckecksumme berechnen ab 2. Wort
wp = (LPWORD) Data;  wp++;
Chks = 0;

// Summe Åber alle CW's
n = (EELen >> 1) - 1;
for (i=1; i<=n; i++,wp++)
Begin
  if (CExcl and strchr((LPSTR)CExcl, i)) continue;
  Chks = Chks + *wp;
Endfor

return(Chks);

End

/*---------------------------------------------------------------------------*/

VOID    ReadEEData_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion liest die EE-Prom Daten ¸ber des "his"-Befehl
**      und schickt sie an Modconf.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
DWORD   NState;
WORD    hw,i,l,n,s,*wp;
char	HStr[100];
LPSTR   LP,P,P2,P3;
LPBYTE  PB;

NState = State; State = NoAction;
hw = GetStateCnt (NState);
if (hw)
Then
  n = GetModInfo((LONG) Sel_Mod.ModTyp, MOD_eesiz, NULL);
  P3 = MrDataP; n = n / 16;
  PB = (LPBYTE) EEData;
  for (i=0; i<n; i++)
  Begin
    // Zeilenanfabg checken
    Repeat
      LP = strtok(P3, " \015\012"); P3 = NULL;
      if (LP eq NULL)  break;
      l = strlen(LP); P = strchr(LP, ':');
    Until (LP and l eq 9 and P eq (LP+4));

    for (s=0; s<16; s++)
    Begin
      LP = strtok(NULL, " ");
      if (LP eq NULL)  break;
      if (LP)  *PB++ = atoh (LP);
    Endfor
    if (LP eq NULL)  break;
  Endfor

  if (i < n or s < 16) goto Err;
  FlushIQue(); EEDatReady = 2;  // Status Ready
  hw = GetChks (EEData, (LONG)Sel_Mod.ModTyp); wp = (LPWORD) EEData;
  if (hw ne *wp)
  Then
    PriErr (ErrECS);
    // #2010101210000019 U.Stahl 14.10.10
    // Fehlermeldung ausgeben, aber Daten trotzdem weiterverarbeiten
    //NState = InitState(0); goto Exit;
  Endif

  if (EEDump)
  Then
    strcpy (HStr, "notepad.exe "); P2 = HStr + strlen(HStr);
    strcpy (P2, IniFile); P3 = strstr(P2, AppName);
    if (P3)
    Then
      strcpy (P3, "lastreed.txt");
      DumpEEData (P2, EEData);
      WinExec (HStr, SW_SHOWNORMAL);
    Endif
  Endif
Else
  if (EEDump and IsAnyConnection() eq 0)
  Then
    LP = DDEValP;
    memcpy (LP, &EEData, 256);
    //DDECommand = 0;
    EEDatReady = 2;  // Status Ready
  Else
    InsertState (ReadEEData, NULL, 1);
    InsertState (GetEEData, NULL, 0);
    EEDatReady = 1;               // Status busy
  Endif
Endif
NState = GetNextState();
goto Exit;

Err:
//OkMessage (403, NULL);
GetText (fht, HStr, 399);
MessageWin (hWndWTH86, HStr, "ReadEEData", 0);
NState = InitState(0);

Exit:
State = NState;

End

/*---------------------------------------------------------------------------*/

VOID    RTextOut_F ()

Begin
WORD	hw;
LPSTR   LP;

TmpState = State; State = NoAction;
hw = GetStateCnt(TmpState);
if (hw)  LP = DDEValP;
else     LP = MrDataP;
MessageWin (hWndWTH86, LP, "RTextOut", 0);
State = GetNextState();

End

/*---------------------------------------------------------------------------*/

VOID    SetNewBaud_F ()

Begin
LPSTR   LP,P2;

TmpState = State;
State = NoAction;
// Baudrate nur ‰ndern wenn
// wenn selektiertes = eigenes
//if (MoniMod.Mod >1 and MoniMod.Mod eq Sel_Mod.Mod)
if (MoniMod.Mod eq Sel_Mod.Mod)
Then
  LP = GetStateStr (TmpState);
  ChangeBdMenu (atoi(LP), 0);
Endif
State = GetNextState ();

End

