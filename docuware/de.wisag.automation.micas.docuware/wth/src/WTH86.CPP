/*K
**      Modul Name....: WTH86.C
**
**      Funktion......: Transfer von HEX-Intel Files von und nach Unterstation
**
**      Versionsdatum.: 28.05.1998                         
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

#include        <commctrl.h>
#include	"gatmod.h"
#include        "th_dlg.h"
#include        "wth86.h"

int   CALLBACK	WMain(HANDLE, HANDLE, LPSTR, int);

static	BOOL	WTH86EndSession (HWND);
static	BOOL	WTH86QueryEndSession (HWND);
static	VOID	WTH86Command(HWND, int);
static	BOOL	FinalInst(VOID);
static	int	LocalCommand (BYTE, WORD);


extern	VOID	ReadSioParams (VOID);

extern	LIBFTAB	FnkStream[];
//extern	int	Dump,SDump;
extern  DWORD   Baudrate;
extern  DWORD   oldBaud;
extern	WORD	TcpConn,PortNr;
extern	char	EchoBuf[];
extern	WORD	ParamAnz,MDvalid;
extern	HANDLE	SymHd;
extern	short	xClient,yClient;
extern	DWORD	idInst;


//	M e n u - D e f i n i t i o n e n

#define	IDSEPA1		990
#define	IDSEPA2		991
#define	IDSEPA3		992
#define	IDDUMMY1	0xFFFF
#define	IDDUMMY2	0xFFFE
#define	IDDUMMY3	0xFFFD
#define	IDDUMMY4	0xFFFC
#define	IDDUMMY5	0xFFFB
#define IDFFCOM         1200

struct	MenuS	Pop1[] = {
	{IDMCOM1   , MF_ENABLED	 , 206, NULL, 0, 0},
	{IDMCOM2   , MF_ENABLED	 , 207, NULL, 0, 0},
//	{IDMCOM3   , MF_ENABLED	 , 208, NULL, 0, 0},
//	{IDMCOM4   , MF_ENABLED  , 209, NULL, 0, 0},
	{IDMCOMX   , MF_GRAYED   , 233, NULL, 0, 0},
	{IDMSIOP   , MF_ENABLED  , 205, NULL, 0, 0},
	{IDMBAUD   , MF_ENABLED  , 265, NULL, 0, 0},
	{IDSEPA1   , MF_SEPARATOR,   0, NULL, 0, 0},
	{IDMTCPIP  , MF_ENABLED  , 230, NULL, 0, 0},
	{IDMLASTTCP, MF_ENABLED  , 232, NULL, 0, 0},
	{IDSEPA2   , MF_SEPARATOR,   0, NULL, 0, 0},
	{IDMCLOSE  , MF_ENABLED  , 231, NULL, 0, 0},
	{IDMEXIT   , MF_ENABLED	 , 204, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop8[] = {
	{IDRCONF   , MF_ENABLED  , 234, NULL, 0, 0},
//	{IDRCANDAT , MF_ENABLED  , 235, NULL, 0, 0},
	{IDRFLDAT  , MF_ENABLED  , 236, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop9[] = {
	{IDSCONF   , MF_ENABLED  , 234, NULL, 0, 0},
//	{IDSCANDAT , MF_ENABLED  , 235, NULL, 0, 0},
	{IDSFLDAT  , MF_ENABLED  , 236, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop2[] = {
	{IDRBUKL   , MF_ENABLED	 , 260, NULL, 0, 0},
	{IDRBKDB   , MF_ENABLED	 , 261, NULL, 0, 0},
	{IDRDBH86  , MF_ENABLED	 , 264, NULL, 0, 0},
	{IDRDBDMP  , MF_ENABLED	 , 262, NULL, 0, 0},
	{IDRMICAS  , MF_ENABLED	 , 212, NULL, 0, 0},
	{7         , MF_ENABLED  , 309, Pop8, 0, 0},
	{IDRECV    , MF_ENABLED	 , 211, NULL, 0, 0},
	{IDEEDATA  , MF_ENABLED  , 308, NULL, 0, 0},
	{IDFGLIST  , MF_ENABLED  , 485, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop7[] = {
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop5[] = {
	{IDSBUKL   , MF_ENABLED	 , 260, NULL, 0, 0},
	{IDSBKDB   , MF_ENABLED	 , 261, NULL, 0, 0},
	{IDSDBDMP  , MF_ENABLED	 , 262, NULL, 0, 0},
	{IDSMICAS  , MF_ENABLED	 , 212, NULL, 0, 0},
	{8         , MF_ENABLED  , 309, Pop9, 0, 0},
	{IDSEND    , MF_ENABLED	 , 263, NULL, 0, 0},
	{IDSCODE   , MF_ENABLED	 , 266, NULL, 0, 0},
	{IDSBOOT   , MF_ENABLED	 , 267, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop3[] = {
	{IDDUMMY1  , MF_ENABLED  , 215, NULL, 0, 0},
	{IDDUMMY2  , MF_SEPARATOR,   0, NULL, 0, 0},
	{IDMSCREEN , MF_CHECKED	 , 216, NULL, 0, 0},
	{IDMLPT1   , MF_ENABLED	 , 217, NULL, 0, 0},
	{IDMLPT2   , MF_ENABLED	 , 218, NULL, 0, 0},
	{IDMLPC1   , MF_ENABLED	 , 219, NULL, 0, 0},
	{IDMLPC2   , MF_ENABLED	 , 220, NULL, 0, 0},
	{IDMFILE   , MF_ENABLED	 , 221, NULL, 0, 0},
	{IDDUMMY3  , MF_SEPARATOR,   0, NULL, 0, 0},
	{IDDUMMY4  , MF_ENABLED	 , 222, NULL, 0, 0},
	{IDDUMMY5  , MF_SEPARATOR,   0, NULL, 0, 0},
	{IDPLPT1   , MF_ENABLED	 , 217, NULL, 0, 0},
	{IDPLPT2   , MF_ENABLED	 , 218, NULL, 0, 0},
	{IDPLPC1   , MF_ENABLED	 , 219, NULL, 0, 0},
	{IDPLPC2   , MF_ENABLED	 , 220, NULL, 0, 0},
	{IDMPROTO  , MF_ENABLED	 , 221, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop4[] = {
	{IDGETDEBINFO,MF_ENABLED , 224, NULL, 0, 0},
	{IDGETVAL   , MF_ENABLED , 225, NULL, 0, 0},
	{IDISPSYMVAL, MF_ENABLED , 226, NULL, 0, 0},
	{IDSETSYMVAL, MF_ENABLED , 227, NULL, 0, 0},
	{IDGETSYM   , MF_ENABLED , 228, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Pop6[] = {
	{IDMHELP    , MF_ENABLED , 201, NULL, 0, 0},
	{IDDUMMY1   , MF_SEPARATOR,   0, NULL, 0, 0},
	{IDMABOUT   , MF_ENABLED  , 202, NULL, 0, 0},
	{0,0,0,NULL,0,0}};

struct	MenuS	Menu[] = {
	{1	 , MF_ENABLED , 200, Pop1, 0, 0},
	{2       , MF_ENABLED , 210, Pop5, 0, 0},
	{3       , MF_ENABLED , 213, Pop2, 0, 0},
	{4	 , MF_ENABLED , 214, Pop3, 0, 0},
	{5	 , MF_ENABLED , 223, Pop4, 0, 0},
	{6       , MF_ENABLED , 229, Pop6, 0, 0},
	{0,0,0,NULL,0,0}};


//	g l o b a l e   D a t e n
LPCSTR	AppName = "WTH86";
char	CompanyName[50],Version[12];

char	AppName2[70];
char    lastHostIP[20];
char	lastHost[30];
char    lastPort[20];

// globaler File-Pointer
int    Datptr,MelDat,Proto,Trace,Debdat;

HANDLE	hInstWTH86;		// glob. Handle fuer Task-Instanz
HWND    hWndWTH86;  		// glob. Handle fÅr Task-Window
HWND    hWndDByte;		// glob. Handle fÅr "Display-Window"
short   Cid=-1;         	// Handle fuer Com-Kanal
short   LPCid=-1;		// Handle fuer Lpt-Kanal
short	PMStat=MesonScreen;
WORD	InstNr;

BYTE    Nibble1,Sum,PSum;	// Hilfsvariablen fuer Pruefsummen-Check
DWORD	State,			// Zustandsvariable fuer Timer-Message
	TmpState;
WORD	Hibus,
	CodeCnt,
	MoniReady,
	MonError,
	DDEMReady,
	AsyncMode,
	DDECommand,
	DDEActive,
	DDECmdOk,
	STrace,
	CTrace,
	LTrace,
	DebVal,
	EEDump;


char    FileName[50];	    	// Dateinamen
char	FilePath[200];
char	IniFile[90];
char	PrgPath[90];
char    MelFileName[50];
char    ProtFileName[50];
char    HelpFile[50];
BYTE	EEData[EESize<<1];
WORD    GerAdr,EEDatReady;
char    Work[WorkSize];	    	// Hilfsspeicher fuer auszugebende Texte
char	DispBuf[DBLen];	    	// Buffer auszugebenden Text

int	fht;
HANDLE	inslib,HdDbg;
int	TcpMenu;
PBPATH  CodePaths,BootPaths;
LPSTR   aktBPath;
WORD    CntBFile;
LPPSTR  BinFiles;


/*---------------------------------------------------------------------------*/

VOID	WINAPI	LTrace_OnOff (VOID)

Begin

LTrace = LTrace ? 0 : 1;
DbgStr ("Logical-Trace ");
if (LTrace) DbgStr("on\r\n");
else	    DbgStr("off\r\n");

End

/*---------------------------------------------------------------------------*/

VOID	WINAPI	CTrace_OnOff (VOID)

Begin

CTrace = CTrace ? 0 : 1;
DbgStr ("Communication-Trace ");
if (CTrace) DbgStr("on\r\n");
else	    DbgStr("off\r\n");

End

/*---------------------------------------------------------------------------*/

VOID	WINAPI	STrace_OnOff (VOID)

Begin

STrace = STrace ? 0 : 1;
DbgStr ("Status-Trace ");
if (STrace) DbgStr("on\r\n");
else	    DbgStr("off\r\n");

End

/*---------------------------------------------------------------------------*/

VOID	FAR PASCAL EEDump_OnOff ()

Begin
char	HStr[50];

EEDump = EEDump ? 0 : 1;
strcpy (HStr, "EEProm-Daten Display ");
if (EEDump) strcat(HStr, "on");
else	    strcat(HStr, "off");
MessageBox (hWndWTH86, HStr, "", MB_ICONINFORMATION);

End

static	TRIGDS	Trigger[] = {
{"LTRACE\r",	LTrace_OnOff, "Logischer Trace ein/ausschalten"},
{"CTRACE\r",	CTrace_OnOff, "Kommunikations-Trace ein/ausschalten"},
{"STRACE\r",	STrace_OnOff, "Trace der Zustands¸berg‰nge ein/ausschalten"},
{"EEDUMP\r",	EEDump_OnOff, "Anzeige der ¸bertragenen EEProm-Daten"},
{NULL, NULL, NULL, NULL}};

/*---------------------------------------------------------------------------*/

static	int	LocalCommand (BYTE Ch, WORD Anz)

/*F
**.* Beschreibung :
**
**      Die Funktionverwaltet den lokalen Komandopuffer 
**	im TCP/IP Betrieb.
**
**.* Funktionswerte :
**
**      1 wenn keine weitere Verarbeitung gewÅnscht
**	0 weitere Verarbeitung wie im Normal-Mode
**
*/
 
Begin
static	char	ComBuf[200];
static	short	n;
short	dn,ret;

dn = 0; ret = 1;
Switch (Ch)
  case Cr:	
  case Lf:	ComBuf[n++] = Cr;
  		SendChars (ComBuf, n, 0);
		n = 0;  goto Exit;

  case Bs:	if (n)
  		Then
		  n--;  DispBuf[dn++] = Bs;
		  DispBuf[dn++] = ' ';
		  DispBuf[dn++] = Bs;
		Endif
		break;

  default:	if (n >= 200) goto Exit;
  		if (Ch >= 32)
  		Then
		  memset (&ComBuf[n], Ch, Anz);
		  n = n + Anz;
		  memset (DispBuf, Ch, Anz);
		  dn = Anz;
		Else
		  // Behandlung der restlichen Control-Zeichen wie sostt auch
		  ret = 0; goto Exit;
		Endif
		break;
Endswitch
DisplayBuf ((BYTE*) DispBuf, dn); 

Exit:
return (ret);

End


/*--------------------------------------------------------------------------*/

VOID   	OkMessage (int Id, LPSTR ZStr)

/*F
**.* Beschreibung :
**
**      Die Funktion eroeffnet eine Message-Box mit akustischem
**      Signal und angegebenen Text.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char	HStr[50];
WORD   l;
DWORD   Flags;

if (ZStr)
Then
  l = strlen(ZStr);
  strcpy (Work, ZStr);
Else
  l = 0;
Endif
GetText (fht, &Work[l], Id);
GetWindowText (hWndWTH86, HStr, 50);
Flags = MB_BEEP | MB_OK | MB_ICONINFORMATION;
//hwFocus = GetFocus();
MessageWin(hWndWTH86, Work, HStr, Flags);
//if (hwFocus and hwFocus ne hWndWTH86) SetFocus (hwFocus);

End

/*--------------------------------------------------------------------------*/

//static	FARPROC	fprocDByte;
static	WORD	Tid;

VOID	WINAPI	CalcDspWin (HWND hDlg)

Begin
PDSDAT  PD;
DWORD	hs;
RECT    RC,DK;
int     X,Y,XS,YS;
HWND	hwd;

GetWindowRect (hWndWTH86, &RC);
GetWindowRect (hDlg, &DK);
XS = RC.right - RC.left;
XS = XS - (GetSystemMetrics (SM_CXFRAME) << 1);
XS = XS + (GetSystemMetrics (SM_CXBORDER) << 1);
YS = DK.bottom - DK.top;
X  = RC.left + GetSystemMetrics (SM_CXFRAME);
X  = X - GetSystemMetrics (SM_CXBORDER);
Y  = RC.bottom - YS - GetSystemMetrics (SM_CYFRAME);
Y  = Y + GetSystemMetrics (SM_CYBORDER);
MoveWindow (hDlg, X, Y, XS, YS, 1);

PD = (PDSDAT) GetWindowLong (hDlg, GWL_USERDATA);
if (PD and IsWindow(PD->hwDis))
Then
  hs = SWP_NOZORDER | SWP_SHOWWINDOW | SWP_NOMOVE;
  SetWindowPos (PD->hwDis, 0, 0, 0, XS-95, 18, hs);
Endif

GetClientRect (hDlg, &DK);
hwd = GetDlgItem (hDlg, IDCANCEL);
GetClientRect (hwd, &RC);
X = DK.right-70;
MoveWindow (hwd, X, 8, RC.right, RC.bottom, 1);

hwd = GetDlgItem (hDlg, IDBYTES);
GetClientRect (hwd, &RC);
X = X - RC.right - 10;
MoveWindow (hwd, X, 6, RC.right, RC.bottom, 1);

hwd = GetDlgItem (hDlg, IDRECTRANS);
GetClientRect (hwd, &RC);
X = X - RC.right - 5;
MoveWindow (hwd, X, 6, RC.right, RC.bottom, 1);

GetClientRect (GetDlgItem(hDlg, IDTXT1), &RC);
hwd = GetDlgItem (hDlg, IDFILENAM);  X = X - 5;
MoveWindow (hwd, RC.right+6, 7, X, RC.bottom-2, 1);
InvalidateRect (hDlg, NULL, 1);

End

/*--------------------------------------------------------------------------*/


VOID	WINAPI	CreateDispChart (HWND hDlg)

Begin
RECT    DK;
PDSDAT  PD;
DWORD   hs,cx,cy;

GetWindowRect (hDlg, &DK);
cx = DK.right - DK.left;
cy = DK.bottom - DK.top + 16;
PD = (PDSDAT) GetWindowLong (hDlg, GWL_USERDATA);
hs = SWP_NOZORDER | SWP_SHOWWINDOW;
SetWindowPos (hDlg, 0, DK.left, DK.top-16, cx, cy, hs);
hs = WS_VISIBLE | WS_BORDER | WS_CHILD;
PD->hwDis =  CreateWindow ("CHART", "", hs, 10, 25, cx-95, 18,
	     hDlg, NULL, hInstWTH86, NULL);

End

/*--------------------------------------------------------------------------*/

BOOL	WINAPI	_export	DlgDispBytes (HWND hDlg, WORD msg, WORD wParam, LONG lParam)

Begin
HANDLE	hd;
static	Toggle;
PDSDAT  PD;
char	HStr[50];
WORD	hw;

Switch (msg)
  case WM_INITDIALOG: 	CalcDspWin (hDlg);
			SetDlgItemText (hDlg, IDFILENAM, (LPSTR) lParam);
			GetText (fht, Work, 315);
			SetDlgItemText (hDlg, IDTXT1, Work);
			GetText (fht, Work, 301);
			SetDlgItemText (hDlg, IDCANCEL, Work);
			SetPrp (hDlg, "ActionText", 0);
			PD = (PDSDAT) AllocPtr (sizeof(DSPDAT));
                        PD->hwdRT = GetDlgItem (hDlg, IDBYTES);
			SetWindowLong (hDlg, GWL_USERDATA, (LONG)PD);
			break;

  case WM_DESTROY:      PD = (PDSDAT) GetWindowLong (hDlg, GWL_USERDATA);
                        Free_Ptr(&PD);
                        break;

  case WM_COMMAND:	hw = (State ? LOBYTE(State) : LOBYTE(TmpState));
			Switch (hw)
			  case TransBinFile:	FlushOQue();
						CloseFile (Datptr);
						break;
			  case TransAscFile:	FlushOQue();
						SendStr ((char*) ":XY\015");
						CloseFile (Datptr);
						FlushIQue();
						break;
			  case RecivH86File:
			  case RecivDmpFile:
			  case RecivAscFile:	FlushIQue();
						SendStr((char*) "\015");
						CloseFile (Datptr);
						break;

			Endswitch
			hw = InitState(0);
			if (EEDatReady eq 1)
			Then
			  EEDatReady = 0;
			  AddNextState (SendString, "n\015");
			  AddNextState (WaitForPrompt, NULL);
			  hw = GetNextState();
			Endif
  			State = hw;
			break;

  case WM_TIMER:	Toggle = Toggle bxor 1;
			hd = GetProp (hDlg, "ActionText");
			if (hd)
			Then
			  GetAtomName ((ATOM)hd, HStr, sizeof(HStr));
			  if ((Toggle band 1) eq 0)
			  Then
			    memset (HStr, ' ', strlen(HStr));
			  Endif
			  SetDlgItemText (hDlg, IDRECTRANS, HStr);
			Endif
			break;
	    
  default:            	return FALSE;

Endswitch
return TRUE;

End


/*--------------------------------------------------------------------------*/


HWND    CreateDspWin (LPSTR Str, DWORD Max)

/*F
**.* Beschreibung :
**
**      Die Funktion eroeffnet das "Display-Window" fuer
**      die Ausgabe der uebertragenen Bytes und gibt den durch
**      mes representierten Text aus. (transmit oder receive)
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
PDSDAT  PD;

if (hWndDByte)
Then
  SetDlgItemText (hWndDByte, IDFILENAM, Str);
  PD = (PDSDAT) GetWindowLong (hWndDByte, GWL_USERDATA);
Else
  //fprocDByte = MakePrgInst (DlgDispBytes, hInstWTH86);
  hWndDByte = CreateDialogParam (hInstWTH86,
	      "DisplayBytes", hWndWTH86, (FARPROC) DlgDispBytes, (LONG) Str);
  PD = (PDSDAT) GetWindowLong (hWndDByte, GWL_USERDATA);
Endif
PD->maxVal = Max;  PD->aktVal = 0;
SetFocus (hWndWTH86);
return (hWndDByte);

End


/*--------------------------------------------------------------------------*/


VOID    DestroyDspWin ()

Begin 
HANDLE	hd;
BOOL    ret;

if (IsWindow(hWndDByte))
Then
  if (Tid)
  Then
    KillTimer (hWndDByte, Tid); Tid = 0;
  Endif
  hd = RemoveProp (hWndDByte, "ActionText");
  if (hd)  DeleteAtom ((ATOM) hd);
  ret = DestroyWindow (hWndDByte);
  if (ret eq FALSE)  DispLastError (hWndWTH86, "DestroyWindow");
  //FreePrgInst (fprocDByte);
  //fprocDByte = NULL;
  hWndDByte = 0;
Endif

End


/*--------------------------------------------------------------------------*/


VOID    SetActionText (LPSTR Str)

Begin

if (IsWindow(hWndDByte))
Then
  if (Tid)
  Then
    KillTimer (hWndDByte, Tid); Tid = 0;
  Endif
  SetDlgItemText (hWndDByte, IDRECTRANS, Str);
Endif

End

/*--------------------------------------------------------------------------*/


VOID    BlinkActionText (LPSTR Str)

Begin
HANDLE	hd;

if (IsWindow(hWndDByte))
Then
  hd = GetProp (hWndDByte, "ActionText");
  if (hd)  DeleteAtom ((ATOM) hd);
  if (Str)
  Then
    hd = (HANDLE) AddAtom (Str);
    SetProp (hWndDByte, "ActionText", hd);
    SetDlgItemText (hWndDByte, IDRECTRANS, Str);
    if (Tid eq 0)
    Then
      Tid = 1;
      SetTimer (hWndDByte, Tid, 500, NULL);
    Endif
  Else
    SetProp (hWndDByte, "ActionText", 0);
    SetDlgItemText (hWndDByte, IDRECTRANS, "");
    if (Tid)
    Then
      KillTimer (hWndDByte, Tid); Tid = 0;
    Endif
  Endif
Endif

End

/*---------------------------------------------------------------------------*/

BOOL    openFile(LPSTR Mode, LPINT fh)

//F
//.* Beschreibung :
//
//      Die Funktion ruft die Dialogfunktion zur Auswahl eiens
//      H86-Files auf eroeffnet die Datei zum Lesen bzw. Schreiben.
//
//.* Funktionswerte :
//
//      TRUE: Dialog und File-Open erfolgreich
//      sonst FALSE
//
//

Begin
OFSTRUCT OS;
char	HStr[MAX_PATH];
BOOL	ret;

ret = FALSE;
if (fh eq NULL) fh = &Datptr;
strcpy (HStr, FilePath);
dircat(HStr, FileName);
if (toupper(*Mode) eq 'R')
Then
  *fh = OpenFile (HStr, &OS, OF_READ);
Else
  *fh = OpenFile (HStr, &OS, OF_CREATE);
Endif
if (*fh < 0)
Then
  OkMessage (400, FileName);
Else
  ret = TRUE;
Endif

return (ret);

End

/*---------------------------------------------------------------------------*/


BOOL	WTH86EndSession(HWND hWnd)

/*F
**.* Beschreibung :
**
**      Dialogfunktion fuer das Programmende via ProgrammMenue
**
**.* Funktionswerte :
**
**     Keine !
*/

Begin
BOOL	ret;

ret = FALSE;
if (FinalInst())
Then
  ret = TRUE;
  ExitScreen();
Endif
return (ret);

End

/*--------------------------------------------------------------------------*/


BOOL  WTH86QueryEndSession(HWND hWnd)

/*F
**.* Beschreibung :
**
**      Dialogfunktion fuer das Programmende
**
**.* Funktionswerte :
**
**     TRUE   -> Wenn das Programm beendet werden darf
**     FALSE  -> Wenn das Programm nicht beendet werden darf
*/

Begin

return (TRUE);

End

/*--------------------------------------------------------------------------*/


int	CheckMonErr ()

/*F
**.* Beschreibung :
**
**      ÅberprÅft ob Bel-Zeichen gekommen ist und gibt in diesem
**	Fall einen entsprechende Meldung aus.
**
**.* Funktionswerte :
*/

Begin
int	ret;
char	c;

ret = 0;
While ( (c = GetCharComm()) ne EOF)
Begin
  if(c eq Bel)
  Then
    FlushOQue();  CloseFile (Datptr);
    PriErr (ErrTRS); DestroyDspWin ();
    ret++;  FlushIQue(); break;
  Endif
Endwhile
return (ret);

End

/*---------------------------------------------------------------------------*/


VOID	CALLBACK _export
NotPresent (HWND hWnd, UINT msg, UINT Id, DWORD Time)


/*F
**.* Beschreibung :
**
**      Die Funktion meldet da· der Monitor nicht antwortet.
**
*/

Begin

State = NoAction;
KillTimer (hWndWTH86, MoniTimer);
FreePrgInst (ErrMProc);
OkMessage (447, NULL);
State = InitState(0);

End

/*--------------------------------------------------------------------------*/


VOID	TransFin_F ()

/*F
**.* Beschreibung :
**
**      Dialogbox Datenuebertragung beendet
**
**.* Funktionswerte :
*/

Begin

State = NoAction;
CloseFile(Datptr);
IncCount (NULL);
if (CheckMonErr())
Then
  TmpState = InitState(0);
Else
  OkMessage (420, NULL);
  TmpState = GetNextState();
Endif
DestroyDspWin();
State = TmpState;

End

/*---------------------------------------------------------------------------*/

static	firstChkMon;

VOID    CheckMoni_F ()

/*F
**.* Beschreibung :
**
**      Die Funktion testet ob der Monitor present ist.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
WORD	hw;


if (firstChkMon eq 0)
Then
  hw = GetPPInt (AppName, "Timeout", 3000, IniFile);
  SetTimer (hWndWTH86, MoniTimer, hw, (TIMERPROC) NotPresent);
  PutChrComm (Cr);  firstChkMon = 1;
Endif

while ((GetCharComm()) ne EOF);

if (MoniReady)
Then
  KillTimer (hWndWTH86, MoniTimer);
  if (DDECommand) DDEActive = 1;
  State = GetNextState();
Endif

End

/*--------------------------------------------------------------------------*/


VOID	HexiEEData_F ()

Begin
WORD	hw;
LPSTR	LP;

State = NoAction;
LP = DusTyp2Name(EEData);
hw = GetModInfo((LONG) LP, MOD_eesiz, NULL);
HexIntel (Datptr, 0, 0, EEData, hw);
HexIntel (Datptr, 0, 0, 0, 0);
EEDatReady = 0;
State = GetNextState();

End

/*--------------------------------------------------------------------------*/

VOID    IncCount(LPSTR Str)

/*F
**.* Beschreibung :
**
**      Die Funktion stell die bereits uebertragenen Nutz-Bytes
**      am Rand des Dialog-windows dar.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char	HStr[20];
PDSDAT  PD;
WORD	hw;

if (IsWindow(hWndDByte) eq 0)  goto Exit;

PD = (PDSDAT) GetWindowLong (hWndDByte, GWL_USERDATA);
if (Str)
Then
  if (HIWORD(Str) eq 0)
  Then
    hw = LOWORD(Str);
  Else
    hw = strlen(Str);
    /*
    if (*Str eq ':' and
    strncmp((char *) &Str[7], "00", 2) eq 0)
    Then
      hw  = (HZif(Str[1]) << 4);
      hw += HZif(Str[2]);
    Endif
    */
  Endif
  PD->aktVal = PD->aktVal + hw;
Endif

wsprintf (HStr, "%lu", PD->aktVal);
SendMessage (PD->hwdRT, WM_SETTEXT, 0, (LONG) HStr);

Exit:
return;

End


/*---------------------------------------------------------------------------*/


VOID    DiaSelectFile_F (HWND hWnd)

Begin
LPSTR	LP,Files,Entry;
WORD	Bok;
char	Path[200];
char	HStr[230];
char    Caption[50];
DWORD   Siz;
BOOL	ret;

TmpState = State;
State = NoAction;  Siz = 0;
LP = GetStateStr (TmpState);
Files = strtok (LP, ",");
LP = strtok (NULL, ","); GetText (fht, Caption, atoi(LP));	// öberschrift
LP = strtok (NULL, ","); Bok = atoi(LP); GetText (fht, HStr, Bok);
Entry = strtok (NULL, ",");
if (Entry)
Then
  GetPPStr (AppName, Entry, FilePath, Path, sizeof(Path), IniFile);
Else
  GetPPStr (AppName, "OTPath", FilePath, Path, sizeof(Path), IniFile);
Endif

if (strpbrk(Files, "*?") eq NULL)
Then
  strcpy (FileName, Files);
  LP = strrchr(FileName, '.');
  if (LP)
  Then
    Files = HStr; *Files = '*';
    strcpy (&HStr[1], LP);
  Else
    Files = "";
  Endif
Else
  FileName[0] = 0;
Endif
if (SelectFile(hWnd, fht, Files, Caption, FileName, Path) eq FALSE) goto Err;
strcpy (FilePath, Path);

Switch (Bok)
  case 325:	ret = openFile ("rt", NULL);	// Senden
                Siz = _FSize(Datptr);
		break;
  case 326:	ret = openFile ("wb", NULL);	// Empfangen
		break;
  default:	ret = FALSE;
Endswitch
if (ret eq FALSE)  goto Err;

if (Entry)
Then
  PutPPStr (AppName, Entry, Path, IniFile);
Endif
strcpy (HStr, Path);
dircat (HStr, FileName);
CreateDspWin (HStr, Siz);
TmpState = GetNextState ();
goto Exit;

Err:
TmpState = InitState (0);

Exit:
State = TmpState;

End


/*---------------------------------------------------------------------------*/


VOID    ParaSelFile_F (VOID)

Begin
LPSTR	LP,P2,P3,P4;
char	HStr[50];

TmpState = State; State = NoAction;
LP = GetStateStr (TmpState);
P2 = strchr (LP, '.');
if (P2 eq NULL) goto Err;
*P2 = 0; strcpy (HStr, LP); *P2 = '.';
P3 = DDEValP;
P4 = HStr + strlen(HStr);

// bei fehlender Datenbank Line = Us = 0
if (strchr(P3, '*'))
Then
  strcpy(P4, "000");
Else
  P3 = strtok(P3, ".");
  strcpy (P4, P3);
  P3 = strtok(NULL, ".");
  strcat (P4, P3);
  P3 = strtok(NULL, ".");
  strcat (P4, P3);
Endif

strcat (P4, P2);
InsertState (DiaSelectFile, HStr, 0);
TmpState = GetNextState();
goto Exit;

Err:
TmpState = InitState(0);

Exit:
State = TmpState;

End

/*---------------------------------------------------------------------------*/

VOID    ParaSelFile2_F (VOID)

Begin
LPSTR	LP,P2,P3,P4;
char	HStr[50];

TmpState = State; State = NoAction;
LP = GetStateStr (TmpState);
P2 = strchr (LP, '.');
if (P2 eq NULL) goto Err;
*P2 = 0; strcpy (HStr, LP); *P2 = '.';
P3 = DDEValP;
P4 = HStr + strlen(HStr);

// bei fehlender Datenbank Line = Us = 0
P3 = strtok(P3, ".");
if (strchr(P3, '*'))
Then
  strcpy(P4, "000");
  strtok(NULL, ".");
Else
  strcpy (P4, P3);
  P3 = strtok(NULL, ".");
  strcat (P4, P3);
Endif
strcat (P4, strtok(NULL, "."));

strcat (P4, P2);
InsertState (DiaSelectFile, HStr, 0);
TmpState = GetNextState();
goto Exit;

Err:
TmpState = InitState(0);

Exit:
State = TmpState;

End


//---------------------------------------------------------------------------

typedef	struct	{
	BYTE	StID;
	BYTE	State;
	BYTE	Cnt;	// AuslesezÑhler
	LPSTR	Str;
	}STDATA,*PSTDAT;

#define	STMax	255
static
struct	StatesS	{
	WORD	Count;
	WORD	Rinx;
	WORD	Winx;
	STDATA	SArr[STMax];
	}SDes;

static	BYTE	aktSID;
static	WORD	MaxFill;

extern	LPSTR	stateTxtDebug[];

//---------------------------------------------------------------------------

VOID	FreeStateMem (VOID)

Begin
PSTDAT  PS;
WORD    i;

PS = SDes.SArr;
for (i=0; i<STMax; i++,PS++)
Begin
  Free_Ptr(&PS->Str);
Endfor
//SDes.Winx = SDes.Rinx = SDes.Count = 0;

End

//---------------------------------------------------------------------------

PSTDAT	GetStateDat (WORD Stat)

Begin
PSTDAT  PS;
WORD    i,Id;

i = SDes.Rinx;
if (i)   i--;
Id = HIBYTE(Stat);
PS = &SDes.SArr[i];
While (i < SDes.Winx)
Begin
  if (Id eq PS->StID)  goto Exit;
  i++; PS++;
Endfor
PS = NULL;

Exit:
return (PS);

End

//---------------------------------------------------------------------------

VOID	DumpNextStates (LPSTR Info)

Begin
PSTDAT  PS;
WORD	Id,Inx;
LPSTR	P,SN;

if (STrace eq 0)  goto Exit;

Inx = SDes.Rinx;
P = Work + wsprintf(Work, "next States (%s): ", Info);
if (Inx < SDes.Winx)
Then
  PS = &SDes.SArr[Inx++];
  SN = GetStateName (PS->State, &Id);
  P = P + wsprintf(P, "%s", SN);
Endif
if (Inx < SDes.Winx)
Then
  PS = &SDes.SArr[Inx++];
  SN = GetStateName (PS->State, &Id);
  P = P + wsprintf(P, ", %s", SN);
Endif
if (Inx < SDes.Winx)
Then
  PS = &SDes.SArr[Inx];
  SN = GetStateName (PS->State, &Id);
  wsprintf(P, ", %s  ...", SN);
Endif
DbgStr(Work);

Exit:
return;

End


//---------------------------------------------------------------------------

VOID	DumpState (LPSTR Info)

Begin
LPSTR	P,SN;

if (STrace eq 0)  goto Exit;

wsprintf (Work, "%s %d", Info, LOBYTE(State));
DbgStr(Work);

Exit:
return;

End

//---------------------------------------------------------------------------

LPSTR	GetStateStr (WORD Stat)

Begin
PSTDAT  PS;
LPSTR	LP;

LP = "";
PS = GetStateDat (Stat);
if (PS and PS->Str)
Then
  LP = PS->Str;
Endif

Exit:
return (LP);

End


//--------------------------------------------------------------------------

WORD	GetStateCnt (WORD Stat)

Begin
PSTDAT  PS;
WORD	 ret;

ret = 0;
PS = GetStateDat (Stat);
if (PS)  ret = PS->Cnt;
return (ret);

End


//--------------------------------------------------------------------------

VOID	SetStateCnt (WORD Stat, WORD Val)

Begin
PSTDAT  PS;

PS = GetStateDat (Stat);
if (PS)   PS->Cnt = Val;

End


//---------------------------------------------------------------------------

WORD	InitState (WORD Flag)

Begin
WORD	hw;
HMENU	hmenu;

FreeStateMem ();
//hw = (NPSTR) &SDes.Count - (NPSTR) &SDes;
//memset ((LPSTR) &SDes + hw, 0, sizeof(struct StatesS) - hw);
memset (&SDes, 0, sizeof(SDes));
DDECommand = DDEMReady = 0;
SetCursor (LoadCursor(NULL, IDC_ARROW));
if ((Flag band IS_NODSWIN) eq 0)
Then
  DestroyDspWin ();
Endif
if ((Flag band IS_NOCLOSE) eq 0)
Then
  CloseFile (Datptr);
Endif

hmenu = GetMenu(hWndWTH86); hw = MF_ENABLED;
if (EEDatReady eq 2 and EEDump eq 0) hw = MF_GRAYED;
EnableMenuItem(hmenu, IDEEDATA, hw);

//PostMessage (hWndWTH86, WM_COMMNOTIFY, 0, 0l);
if (STrace) DbgStr("InitState\r\n");
hw = GetPPInt(AppName, "MaxStFill", 0, IniFile);
if (hw < MaxFill)
Then
  itoa (MaxFill, Work, 10);
  PutPPStr (AppName, "MaxStFill", Work, IniFile);
Endif
return (Display);

End


//---------------------------------------------------------------------------

WORD	AddNextStat2 (BYTE Sta, LPSTR Str, BYTE Count)

Begin
PSTDAT  PS;
WORD	Ind,ret,Size;
LPSTR	LP,LPD;

if (STrace)
Then
  if (HdDbg eq 0) HdDbg = GlobalAlloc(GHND, 1024);
  LPD = (LPSTR) GlobalLock (HdDbg);
  LP = stateTxtDebug[Sta];
  wsprintf (LPD, "AddNextState: %s(%d)", LP, Count);
  if (Str and *Str)
  Then
    strcat (LPD, " \042");  strcat (LPD, Str);
    LP = strchr(LPD, Cr); if (LP) *LP = '<';
    strcat (LPD, "\042");
  Endif
  strcat (LPD, "\r\n");  DbgStr (LPD);
  GlobalUnlock (HdDbg);
Endif
//DumpNextStates ("first");


//if (SDes.Winx eq SDes.Rinx)  FreeStateMem ();

Ind = SDes.Winx;
PS = &SDes.SArr[Ind];
PS->Str = NULL;
if (Str)
Then
  PS->Str = (LPSTR) AllocPtr(strlen(Str)+1);
  strcpy (PS->Str, Str);
Endif
aktSID++;
if (aktSID eq 0) aktSID++;
PS->StID = aktSID;
PS->State = Sta;
PS->Cnt   = Count;
SDes.Count++;
SDes.Winx++;
if (SDes.Winx >= STMax)
Then
  if (SDes.Rinx eq 0)
  Then
    LP = "State Buffer too small!!";
    MessageBox (hWndWTH86, LP, "", MB_INFO);
    InitState(0);  ret = 0;  goto Exit;
  Endif
  Size = (SDes.Winx - SDes.Rinx) * sizeof(STDATA);
  PS = &SDes.SArr[SDes.Rinx];
  memmove (SDes.SArr, PS, Size);
  SDes.Winx = SDes.Winx - SDes.Rinx; SDes.Rinx = 0;
Endif
MaxFill = max(SDes.Winx-SDes.Rinx, MaxFill);
ret = (aktSID << 8) + Sta;
Inc_DDECmd (Sta);

//if (Sta eq GetLineUsMod)
//Then
//  Work[WorkSize-1] = 0;
//Endif

Exit:
//DumpNextStates ("last");
//DumpState("State:");
return ret;

End


//---------------------------------------------------------------------------

WORD	AddNextState (BYTE Sta, LPSTR Str)

Begin

return (AddNextStat2 (Sta, Str, 0));

End


//---------------------------------------------------------------------------


WORD	InsertState (BYTE Sta, LPSTR Str, BYTE Count)

Begin
PSTDAT  PS;
LPSTR	LP,LPD;
WORD	n,ret,Size;

if (STrace)
Then
  if (HdDbg eq 0) HdDbg = GlobalAlloc(GHND, 1024);
  LPD = (LPSTR) GlobalLock (HdDbg);
  LP = stateTxtDebug[Sta];
  wsprintf (LPD, "Insert_State: %s(%d)", LP, Count);
  if (Str and *Str)
  Then
    strcat (LPD, " \042");  strcat (LPD, Str);
    LP = strchr(LPD, Cr); if (LP) *LP = '<';
    strcat (LPD, "\042");
  Endif
  strcat (LPD, "\r\n");  DbgStr (LPD);
  GlobalUnlock (HdDbg);
Endif

SDes.Winx++;
if (SDes.Winx >= STMax)
Then
  if (SDes.Rinx eq 0)
  Then
    LP = "State Buffer too small!!";
    MessageBox (hWndWTH86, LP, "", MB_INFO);
    InitState(0);  ret = 0;  goto Exit;
  Endif
  Size = (SDes.Winx - SDes.Rinx) * sizeof(STDATA);
  PS = &SDes.SArr[SDes.Rinx];
  memmove (SDes.SArr, PS, Size);
  SDes.Winx = SDes.Winx - SDes.Rinx; SDes.Rinx = 0;
Endif
MaxFill = max(SDes.Winx-SDes.Rinx, MaxFill);
Size = (SDes.Winx - SDes.Rinx) * sizeof(STDATA);
PS = &SDes.SArr[SDes.Rinx];
memmove (PS+1, PS, Size);

PS->Str = NULL;
if (Str)
Then
  PS->Str = (LPSTR) AllocPtr(strlen(Str)+1);
  strcpy (PS->Str, Str);
Endif
aktSID++;
if (aktSID eq 0) aktSID++;
PS->StID = aktSID;
PS->State = Sta;
PS->Cnt   = Count;
SDes.Count++;
ret = (aktSID << 8) + Sta;
Inc_DDECmd (Sta);

Exit:
//DumpNextStates ("InsertState");
//DumpState("State:");
return ret;

End


//---------------------------------------------------------------------------


DWORD	GetNextState (VOID)

Begin
PSTDAT  PS;
char    HStr[90];
DWORD   ret;

if (SDes.Winx eq SDes.Rinx or SDes.SArr[SDes.Rinx].State eq Display)
Then
    if (STrace) DbgStr("Queue empty ...>  ");
    ret = InitState(0);  DDECommand = 0;
    DDECmdOk = 1; DDEMReady = MoniReady;
Else

  PS = &SDes.SArr[SDes.Rinx];
  ret = (PS->StID << 8) bor PS->State;

  Switch (LOBYTE(ret))
    case CheckMoni:	MoniReady = firstChkMon = 0;
			break;
    case RecivH86File:
    case RecivDmpFile:
    case RecivAscFile:
    case RecivH86Blck:	SetActionText ("received bytes");
			MoniReady = 0;
			break;
    case TransAscFile:	SetActionText ("transmitted bytes");
			break;
    case TransCfgData:	SetActionText ("transmitted bytes");
			break;
    case TransBinFile:	SetActionText ("transmitted bytes");
			break;

    case WaitForPrompt:	BlinkActionText ("waiting for prompt");
			MoniReady = 0;
			break;

    case WaitForString: strcpy (HStr, "waiting ");
			strcat (HStr, PS->Str);
			BlinkActionText (HStr);
			break;

    case WaitForEcho:	strcpy (EchoBuf, PS->Str);
    case WaitForCr:
    case WaitForBlCr:	BlinkActionText ("waiting for echo");
			break;

    case GetModTyp:	BlinkActionText ("reading modul-typ");
			break;

    case CalcLTask:
    case CalcMKonst:	BlinkActionText ("calculating program start");
			break;

    case CalcLTask2:	BlinkActionText ("calculating program end");
			break;
    case StoreUntilP:	InitRecvBuf (1);
			break;
  Endswitch
  SDes.Rinx++;
//  if (TcpConn)  PutChrComm (Cr);
//  PostMessage (hWndWTH86, WM_COMMNOTIFY, 0, 0l);
Endif
return (ret);

End


//--------------------------------------------------------------------------

static	BOOL	FinalInst (VOID)

Begin
BOOL	ret;

ret =  TRUE;
if (LPCid >=0) _FClose (LPCid);
//FreeLibrary (fht);
_FClose(fht);
if (inslib)  FreeLibrary (inslib);
CloseFile (MelDat);
CloseFile (Proto);
FreeMem (&SymHd);
FreeMem (&HdDbg);
WinHelp (hWndWTH86, HelpFile, HELP_QUIT, 0l);
FreeStateMem ();
//FreeMem (&SDes.S);
Free_Ptr (&CodePaths);
Free_Ptr (&BootPaths);
Free_Ptr (&DDEValP);
Free_Ptr (&MrDataP);
CloseSDevice();
if (DebVal) ClrKBHook (hWndWTH86);
FreePtr(BinFiles);
itoa (SDes.Count, Work, 10);
PutPPStr (AppName, "MaxStCount", Work, IniFile);

return (ret);

End


/*---------------------------------------------------------------------------*/

VOID	CheckCid_F (VOID)

/*F
**.* Beschreibung :
**
**      Die Funktion ueberprueft die Anwahl der Schnittstelle.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin

State = NoAction;
if (TcpConn eq 0 and Cid < 0)
Then
  OkMessage (446, NULL);
  State = InitState(0);
  return;
Endif
State = GetNextState();

End


/*---------------------------------------------------------------------------*/

struct	EnaDiS	{
	WORD	Id;	// Menu Id
	WORD	Chk;	// has to be checked
	WORD	*ENIds;	// Id's which has to be enabled
	WORD	*UCIds;	// Id's which has to be unchecked
	WORD	*DSIds;	// Id's which has to be disabled
	};

static	WORD	TCPIP1[] = {IDMCOM1, IDMCOM2, IDMCOMX, 0};
static	WORD	TCPIP2[] = {IDMTCPIP, 0};
static	WORD	IDALL[]  = {IDMTCPIP, IDMCOM1, IDMCOM2, IDMCOMX,
			    IDMLPC1, IDMLPC2, IDPLPC1, IDPLPC2, 0};
static	WORD	IDPROMS[]= {IDMLPT1, IDMLPT2, IDMLPC1, IDMLPC2,
			    IDPLPT1, IDPLPT2, IDPLPC1, IDPLPC2, 0};

static	WORD	MCOM1UC[] = {IDMCOM2, IDMCOMX, 0};
static	WORD	MCOM1DS[] = {IDMLPC1, IDPLPC1, IDMTCPIP, 0};
static	WORD	MCOM2UC[] = {IDMCOM1, IDMCOMX, 0};
static	WORD	MCOM2DS[] = {IDMLPC2, IDPLPC2, IDMTCPIP, 0};
static	WORD	MCOMXUC[] = {IDMCOM1, IDMCOM2, 0};
//static	WORD	MCOM4UC[] = {IDMCOM1, IDMCOM2, IDMCOM3, 0};
static	WORD	IDsCOM1[] = {IDMCOM1, 0};
static	WORD	IDsCOM2[] = {IDMCOM2, 0};
//static	WORD	IPMCOM1[] = {IDMLPC1, IDPLPC1, 0};
//static	WORD	IPMCOM2[] = {IDMLPC2, IDPLPC2, 0};

static	struct	EnaDiS	EnaDisDat[] = {
//		enable		unckeck		disable
{IDMTCPIP,1,	NULL,		NULL,		TCPIP1},
{IDMCLOSE,0,	IDALL,		IDALL,		NULL},
{IDMCOM1, 1, 	NULL,		MCOM1UC,	MCOM1DS},
{IDMCOM2, 1, 	NULL,		MCOM2UC,	MCOM2DS},
{IDMCOMX, 1, 	NULL,		MCOMXUC,	TCPIP2},
{IDMLPT1, 1, 	NULL,		IDPROMS,	NULL},
{IDMLPT2, 1, 	NULL,		IDPROMS,	NULL},
{IDMLPC1, 1, 	IDsCOM2,	IDPROMS,	IDsCOM1},
{IDMLPC2, 1, 	IDsCOM1,	IDPROMS,	IDsCOM2},
{IDPLPT1, 1, 	NULL,		IDPROMS,	NULL},
{IDPLPT2, 1, 	NULL,		IDPROMS,	NULL},
{IDPLPC1, 1, 	IDsCOM2,	IDPROMS,	IDsCOM1},
{IDPLPC2, 1, 	IDsCOM1,	IDPROMS,	IDsCOM2}
};

#define	EnaDisAnz	(sizeof(EnaDisDat)/sizeof(struct EnaDiS))

/*---------------------------------------------------------------------------*/


VOID	ChkEnaDis (WORD Id)
 
/*F
**.* Beschreibung :
**
**	Die Funktion enabled, checked bzw. disabled alle Menupunkte
**	entsprechend der Tabelle EnaDisDat.
**
**
*/
 
Begin
struct	EnaDiS	*ED;
WORD	i,*wp;
HMENU   hmenu;

hmenu = GetMenu(hWndWTH86);
ED = EnaDisDat;
for (i=0; i<EnaDisAnz; i++,ED++)
Begin
  if (Id eq ED->Id)  goto Make;
Endfor
return;

Make:
if (ED->Chk)  CheckMenuItem (hmenu, Id, MF_CHECKED);
else	      CheckMenuItem (hmenu, Id, MF_UNCHECKED);

wp = ED->ENIds;
if (wp)
Then
  While(*wp)
  Begin
    EnableMenuItem(hmenu, *wp++, MF_ENABLED);
  Endwhile
Endif

wp = ED->UCIds;
if (wp)
Then
  While(*wp)
  Begin
    if (*wp eq Id) goto Next2;
    CheckMenuItem (hmenu, *wp, MF_UNCHECKED);
    Next2: wp++;
  Endwhile
Endif

wp = ED->DSIds;
if (wp)
Then
  While(*wp)
  Begin
    EnableMenuItem(hmenu, *wp, MF_GRAYED); wp++;
  Endwhile
Endif

End

/*****************************************************************/

static  WORD    PCnt,MId;
static  LPSTR   PStr;
static  PBPATH  PP;

WORD	WINAPI  AddDirMenu (HMENU hm, LPSTR Path, LPSTR Ext, WORD first, WORD Id, PBPATH *pPP, LPWORD pEF)

Begin
WIN32_FIND_DATA FB;
char	HStr[MAX_PATH];
HMENU   Pm;
LPSTR	P;
WORD	hw,Style;
HANDLE	HFd;
int	done,fh;
WORD	Eflag;

strcpy(HStr, Path);
P = HStr + strlen(HStr);
dircpy (P++, "*.*");
done = 1; Eflag = 0;
if (first)
Then
  PP = (PBPATH) AllocPtr(4096);
  *pPP = PP;  PCnt = 0; MId = Id;
  PStr = (LPSTR) PP + (CPathMax+1) * sizeof(BPATH);
Endif
HFd = FirstFile(HStr, &FB, 0x8010, P);
if (HFd eq 0) goto Exit;

While (done)
Begin
  fh = _FOpen (HStr, OF_EXIST);
  if (fh > 0)
  Then
    // wenn kein Vorkommen... ung¸ltiges Verzeichnis
    if (Eflag eq 0)
    Then
      strupr(P);
      if (strstr(P, Ext)) *pEF = Eflag = 1;
    Endif
    goto Next;
  Endif

  if (strcmp(P, ".") eq 0 or
      strcmp(P, "..") eq 0)  goto Next;
  hw = GetLastError();
  if (hw eq 32)  goto Next;

  Eflag = 1 + AddDirMenu (hm, HStr, Ext, 0, 0, pPP, pEF);

  if (Id eq 0)  goto Next;

  if (Eflag > 2)
  Then
    Style = MF_ENABLED | MF_STRING | MF_POPUP;
    Pm = CreatePopupMenu();
    AppendMenu (hm, Style, (UINT) Pm, P);
    AddDirMenu (Pm, HStr, Ext, 0, MId, pPP, pEF);
  Else
    if (Eflag > 1)
    Then
      Style = MF_ENABLED | MF_STRING;
      AppendMenu (hm, Style, MId, P);
      if (PCnt >= CPathMax)  goto Next;
      PP->MId = MId++; PP->Path = PStr;
      strcpy (PStr, HStr);
      PStr = PStr + strlen(PStr) + 1;
      PP++;  PCnt++;
    Endif
  Endif

Next:
  done = NextFile(P, &FB, HFd);
Endwhile

Exit:
return(Eflag);

End

/*-------------------------------------------------------------------------*/


VOID	WINAPI	InitSndFFile (HWND hWnd, WORD Id)

Begin
BOOL	ret;
WORD    hw,Boot;
LPSTR   LP;
PBPATH  PP;

LP = NULL; Boot = 0;
PP = CodePaths;
While (PP->MId)
Begin
  if (PP->MId eq Id)
  Then
//    wsprintf (Work, "Id: %d", Id);
//    MessageBox (hWnd, PP->Path, Work, 0);
    LP = PP->Path;  break;
  Endif
  PP++;
Endwhile
if (LP)
Then
  AddNextState (ChkNextFFile, NULL);
  goto Ok;
Endif

PP = BootPaths;
While (PP->MId)
Begin
  if (PP->MId eq Id)
  Then
    LP = PP->Path;  break;
  Endif
  PP++;
Endwhile
if (LP eq NULL)  goto Exit;

strcpy (FilePath, LP); strcpy(FileName, "bootload.sdb");
ret = openFile ("rt", NULL);
if (ret eq FALSE) goto Exit;
AddNextState (CreateDWin, FileName);
AddNextState (WaitForString, "G");
AddNextState (TransBinFile, NULL);
AddNextState (WaitForString, "LOAD PROGRAM!");
AddNextState (ChkNextFFile, NULL);  Boot++;

Ok:
aktBPath = LP;
strcpy (Work, LP);
dircat (Work, "*.BIN");
LP = GetFileList (Work, 0, &hw);
BinFiles = StrLst2Array(LP, 1);
oldBaud = Baudrate; CntBFile = 0;
if (Baudrate ne 115200)
Then
  Baudrate = 115200; SetComPara();
Endif
if (Boot)  SendStr("!DL\n");
State = GetNextState();

Exit:
return;

End

/*-------------------------------------------------------------------------*/

BOOL	WINAPI	VersInfo (HWND hDlg, UINT msg, WPARAM wP, LPARAM lP)

Begin
LPSTR	LP,P;
HWND	hwd;
WORD	hw;
BOOL	RET;

msg = TransCCMsg(msg, wP, lP, &RET);
Switch (msg)
  case WM_INITDIALOG:	hwd = GetDlgItem (hDlg, IDEDIT);
			GetText (fht, Work, 119);
			SetWindowText (hDlg, Work);
			hw = GetTextLen (fht, 120);
			LP = P = (LPSTR) AllocPtr(hw+1024);
			GetText (fht, LP, 120);
			While ((P = strchr(P, '\n')) ne NULL)
			Begin
			  hw = strlen(P) + 1;
			  memmove (P+1, P, hw);
			  memcpy (P, "\r\n", 2);
			  P = P + 2;
			Endwhile
			P = LP + strlen(LP);
			strcpy (P, "\r\n\r\n");
			strcat (P, AppName);
			strcat (P, " compiled with\t");
			#if	(__BORLANDC__ >= 0x0550)
			  strcat (P, "CB6\r\n");
			#else
			  strcat (P, "BC5\r\n");
			#endif
			SendMsg (hwd, WM_SETTEXT, 0, LP);
			SendMsg (hwd, EM_SETSEL, 0, MAKELONG(0,-1));
			Free_Ptr(&LP);
			break;

  case WM_CTLCOLORSTATIC:
  case WM_CTLCOLORDLG:
  case WM_CTLCOLORBTN:	break;

  case WM_COMMAND:
    Switch (CMDId(wP))
      case IDCANCEL:
      case IDOK:	EndDialog(hDlg, 0);
	       		break;

    Endswitch
    break;

  default:	RET = FALSE;
Endswitch
return (RET);

End

/*---------------------------------------------------------------------------*/

int	WINAPI	SendCommands (HWND hWnd, int id)

Begin

Switch (id)
  case IDSEND:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "*.H*,477,325,OPath");
		AddNextState (SendString, "R\015");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDSBUKL:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "B*.H*,477,325,DBPath");
		AddNextState (CheckDBModul, NULL);
		AddNextState (SendString, "R\015");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDSBKDB:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "DB*.H*,477,325,DBPath");
		AddNextState (CheckDBModul, NULL);
		AddNextState (SendString, "R\015");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		ClearUSInfo ();
		State = GetNextState ();
		break;

  case IDSDBDMP:AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "*.DMP,477,325,DBPath");
		AddNextState (CheckDBModul, NULL);
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		ClearUSInfo ();
		State = GetNextState ();
		break;

  case IDSMICAS:AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "*.H*,477,325,MICPath");
		AddNextState (CalcModNr, NULL);
		AddNextState (SendString, "K\015");
		AddNextState (SendString, "R\015");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDSCONF:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "CFG*.H86,477,325,OPath");
		AddNextState (CalcModNr, NULL);
		AddNextState (SendString, "SEP\015");
//		if (IsTCPConnection() eq 0)  AddNextState (WaitForEcho, "SEP");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;


  case IDSCANDAT: AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (CheckCANMd, NULL);
		AddNextState (DiaSelectFile, "CAN*.H86,477,325,DBPath");
		AddNextState (CheckCANLUM, NULL);
		AddNextState (SendString, "SEN\015");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
//		if (IsTCPConnection() eq 0)  AddNextState (SendQBef, NULL);
		AddNextState (SendQBef, NULL);
		State = GetNextState ();
		break;

  case IDSFLDAT: AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (CheckCANMd, NULL);
		AddNextState (DiaSelectFile, "CFL*.H86,477,325,OPath");
		AddNextState (SendString, "SEN\015");
		AddNextState (TransAscFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  default:	goto Exit;
Endswitch
id = 0;

Exit:
return(id);

End

/*---------------------------------------------------------------------------*/

int	WINAPI	ReadCommands (HWND hWnd, int id)

Begin

Switch (id)
  case IDEEDATA:if (EEDump eq 0)
		Then
		  AddNextState (CheckCid, NULL);
		  AddNextState (CheckMoni, NULL);
		Endif
		AddNextState (ReadEEData, NULL);
		if (EEDump eq 0) AddNextState (TransFin, NULL);
		FileName[0] = 0;
		State = GetNextState();
		break;

  case IDRECV:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (DiaSelectFile, "*.H86,476,326,OPath");
		AddNextState (DiaAskMemArea, NULL);
		AddNextState (RecivH86File, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDRBUKL:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile, "BUKL.H86,476,326,DBPath");
		AddNextState (CheckDBModul, NULL);
		AddNextState (CheckBukl, NULL);
		AddNextState (CalcBuklSize, NULL);
		AddNextState (RecivH86File, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDRBKDB:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile, "DBNK.H86,476,326,DBPath");
		AddNextState (CheckDBModul, NULL);
		AddNextState (CheckBukl, NULL);
		AddNextState (CalcBuklSize, NULL);
		AddNextState (RecivH86Blck, NULL);
		AddNextState (SendString, "WDB\015");
		AddNextState (RecivH86File, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDRDBH86:AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile, "DBNK.H86,476,326,OPath");
		AddNextState (SendString, "WDB\015");
		AddNextState (RecivH86File, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
//		STrace_OnOff();
		break;

  case IDRDBDMP:AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile, "DBNK.DMP,476,326,DBPath");
		AddNextState (CheckDBModul, NULL);
		AddNextState (SendString, "DMP/R\015");
//		if (IsTCPConnection() eq 0) AddNextState (WaitForCr, NULL);
		AddNextState (RecivDmpFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDRMICAS:AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile2, "MIC.H86,476,326,MICPath");
		AddNextState (GetModTyp, NULL);
//		AddNextState (CalcLTask, NULL);
		AddNextState (CalcMKonst, NULL);
		State = GetNextState ();
		break;

  case IDRCONF:	AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile2, "CFG.H86,476,326,OPath");
		AddNextState (ReadEEData, NULL);
		AddNextState (HexiEEData, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDRCANDAT: AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (CheckCANMd, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile2, "CAN.H86,476,326,DBPath");
		AddNextState (ReadCANData, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDRFLDAT: AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (CheckCANMd, NULL);
		AddNextState (GetLineUsMod, NULL);
		AddNextState (ParaSelFile2, "CFL.H86,476,326,OPath");
		AddNextState (ReadFlash, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  case IDFGLIST:AddNextState (CheckCid, NULL);
		AddNextState (CheckMoni, NULL);
		AddNextState (CheckDBModul, NULL);
		AddNextState (DiaSelectFile, "fglist.txt,476,326,DBPath");
		AddNextState (InsNetOnZP12, NULL);
		AddNextState (SendString, "GET FGLIST/C\015");
//		if (IsTCPConnection() eq 0) AddNextState (WaitForCr, NULL);
		AddNextState (RecivAscFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;

  default:	goto Exit;
Endswitch
id = 0;

Exit:
return(id);

End

/*---------------------------------------------------------------------------*/

extern	VOID	WINAPI TestFnk (HWND);

static	void    WTH86Command(HWND hWnd, int id)

/*F
**.* Beschreibung :
**
**      Diese Funktion dient als Kommandodispatcher fuer die Kommandos, die
**      ueber die Menues eingegeben werden. Fuer jeden Menuepunkt ist in diesem
**      Switch ein 'case'-Fall eingetragen.
**
**.* Funktionswerte :
**
**      Keine !
**
*/

Begin
FILETIME   FT;
SYSTEMTIME ST;
char	HStr[120],*P;
char	HStr2[20],TimeA[20];
HMENU   hmenu;
PMDESC	PM;
FARPROC fproc;
WORD	hw;
int	fh;

hmenu = GetMenu(hWndWTH86);
id = SendCommands (hWnd, id);
if (id eq 0)  goto Exit;
id = ReadCommands (hWnd, id);
if (id eq 0)  goto Exit;

Switch (id)
  case IDMTEST:	TestFnk (hWnd);
		break;
/*
  case IDSCODE:	AddNextState (DiaSelectFile, "*.BIN,477,325");
		AddNextState (TransBinFile, NULL);
		AddNextState (TransFin, NULL);
		State = GetNextState ();
		break;
*/

  case IDMEXIT:	/* schickt dem 'Haupt-Dispatcher' die angegebene Message  */
		PostMessage (hWndWTH86, WM_CLOSE, 0, 0L);
		break;

  case IDMSIOP: fproc = MakePrgInst(SetSioPara, hInstWTH86);
		DialogBox(hInstWTH86, "SioParams", hWnd, fproc );
		FreePrgInst (fproc);
		break;

  case IDMABOUT:GetModuleFileName (GetWinInst(hWnd), HStr, sizeof(HStr));
		fh = _FOpen (HStr, 0);  if (fh <= 0)  break;
		GetFileTime ((HANDLE)fh, NULL, NULL, &FT);  _FClose (fh);
		FileTimeToSystemTime(&FT, &ST);
		wsprintf (HStr2, "%02d.%02d.%04d", ST.wDay, ST.wMonth, ST.wYear);
		wsprintf (TimeA, "1997-%04d", ST.wYear);

		GetText (fht, HStr, 202); P = Work;
		strcpy(P, AppName); strcat(P, "  ");
		strcat(P, Version);
		P = "WISAG Automatisierungstechnik GmbH && Co KG";
		hw = AboutBox2 (hWnd, fht, HStr, Work, HStr2, TimeA, P, 114);
		if (hw eq VK_CONTROL)
		Then
		  DialogBox (hInstWTH86, "VERSINFO", hWnd, (DLGPROC) VersInfo);
		Endif
		break;

  case IDMCOM1:	    if (InitComm(1) eq 0)  break;
		    ChkEnaDis (IDMCLOSE);
		    ChkEnaDis (IDMCOM1);
		    goto ComCom;

  case IDMCOM2:	    if (InitComm(2) eq 0)  break;
		    ChkEnaDis (IDMCLOSE);
		    ChkEnaDis (IDMCOM2);

ComCom: 	    PostMsg (hWnd, WM_COMMAND, IDSETMAIN, 0l);
		    InitVideo ();
		    break;


  case IDSETMAIN:   strcpy (Work, AppName2);
		    if (strlen(lastHost))
		    Then
		      strcat (Work, lastHost);
		      if (IsTCPConnection())
		      Then
  		        strcat (Work, " - ");
			strcat (Work, lastPort);
		      Endif
		    Endif
		    SetWindowText (hWnd, Work);
		    break;

  case IDMCLOSE:    CloseSDevice ();
//		    ClrScrn (0);
		    ChkEnaDis (IDMCLOSE);
		    InvalidateRect (hWnd, NULL, 0);
		    UpdateWindow (hWnd);
		    PostMsg (hWnd, WM_COMMAND, IDSETMAIN, 0l);
		    break;

  case IDMLPT1:	    if (InitLptr("LPT1"))
		    Then
		      if (GetMenuState(hmenu, IDMLPT1, MF_BYCOMMAND)
			  eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(MesonDevice);
			CheckMenuItem (hmenu, IDMLPT1, MF_UNCHECKED);
		      Else
			PMStat = PMStat bor MesonDevice;
			PMStat = PMStat band bnot(ProonDevice);
		        ChkEnaDis (IDMLPT1);
		      Endif
		    Endif
		    break;

  case IDMLPT2:	    if (InitLptr("LPT2"))
		    Then
		      if (GetMenuState(hmenu, IDMLPT2, MF_BYCOMMAND)
		          eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(MesonDevice);
		        CheckMenuItem (hmenu, IDMLPT2, MF_UNCHECKED);
		      Else
			PMStat = PMStat bor MesonDevice;
			PMStat = PMStat band bnot(ProonDevice);
			ChkEnaDis (IDMLPT2);
		      Endif
		    Endif
		    break;

  case IDMLPC1:	    if (InitLptr("COM1"))
		    Then
		      if (GetMenuState(hmenu, IDMLPC1, MF_BYCOMMAND)
		          eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(MesonDevice);
		        CheckMenuItem (hmenu, IDMLPC1, MF_UNCHECKED);
			EnableMenuItem(hmenu, IDMCOM1, MF_ENABLED);
		      Else
			PMStat = PMStat bor MesonDevice;
			PMStat = PMStat band bnot(ProonDevice);
		        ChkEnaDis (IDMLPC1);
		      Endif
		    Endif
		    break;

  case IDMLPC2:	    if (InitLptr("COM2"))
		    Then
		      if (GetMenuState(hmenu, IDMLPC2, MF_BYCOMMAND)
		          eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(MesonDevice);
		        CheckMenuItem (hmenu, IDMLPC2, MF_UNCHECKED);
			EnableMenuItem(hmenu, IDMCOM2, MF_ENABLED);
		      Else
			PMStat = PMStat bor MesonDevice;
			PMStat = PMStat band bnot(ProonDevice);
		        ChkEnaDis (IDMLPC2);
		      Endif
		    Endif
		    break;

  case IDMTCPIP:    fproc = MakePrgInst((FARPROC) Connection, hInstWTH86);
		    hw = DialogBox(hInstWTH86, "SELECTHOST", hWnd, fproc);
		    FreePrgInst (fproc);
		    if (hw)
		    Then
		      InitVideo ();  ChkEnaDis (IDMTCPIP);
		    Endif
		    break;

  case IDMLASTTCP:  hw = OpenStream (lastHostIP, PortNr);
		    if (hw)
		    Then
		      lastHost[0] = lastHostIP[0] = 0;
		    Else
		      TcpConn++;
		      PostMsg (hWndWTH86, WM_COMMAND, IDSETMAIN, 0L);
		    Endif
		    break;

  case IDMFILE:	    if (MelDat)
		    Then
		      CloseFile (MelDat);
		      PMStat = PMStat band bnot(MesonFile);
		      CheckMenuItem (hmenu, IDMFILE, MF_UNCHECKED);
		      OkMessage (452, MelFileName);
		    Else
		      Forever
			if (SelectFile (hWnd, fht, "*.txt", (LPSTR) 474,
			    FileName, FilePath) eq FALSE)
			Then
		          goto FileExit;
		        Endif
			if (Proto and strcmpi (FileName, ProtFileName) eq 0)
			Then
			  OkMessage (468, FileName);
			  continue;
			Endif
			if (openFile ("wt", &fh) eq FALSE)
		        Then
		          goto FileExit;
		        Endif
			break;
		      Endforever
		      CheckMenuItem (hmenu, IDMFILE, MF_CHECKED);
		      strcpy (MelFileName, FileName);
		      PMStat = PMStat bor MesonFile;
		      MelDat = fh;
		    Endif

	FileExit:   State = InitState(0);
		    break;
          
  case IDMSCREEN:   PMStat = PMStat bxor MesonScreen;
		    if (PMStat band MesonScreen)
		    Then
		      CheckMenuItem (hmenu, IDMSCREEN, MF_CHECKED);
		    Else
		      CheckMenuItem (hmenu, IDMSCREEN, MF_UNCHECKED);
		    Endif
		    break;

  case IDPLPT1:	    if (InitLptr("LPT1"))
		    Then
		      if (GetMenuState(hmenu, IDPLPT1, MF_BYCOMMAND)
			  eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(ProonDevice);
		        CheckMenuItem (hmenu, IDPLPT1, MF_UNCHECKED);
		      Else
		        PMStat = PMStat bor ProonDevice;
			PMStat = PMStat band bnot(MesonDevice);
			ChkEnaDis (IDPLPT1);
		      Endif
		    Endif
		    break;

  case IDPLPT2:	    if (InitLptr("LPT2"))
		    Then
		      if (GetMenuState(hmenu, IDPLPT2, MF_BYCOMMAND)
			  eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(ProonDevice);
		        CheckMenuItem (hmenu, IDPLPT2, MF_UNCHECKED);
		      Else
		        PMStat = PMStat bor ProonDevice;
			PMStat = PMStat band bnot(MesonDevice);
			ChkEnaDis (IDPLPT2);
		      Endif
		    Endif
		    break;

  case IDPLPC1:	    if (InitLptr("COM1"))
		    Then
		      if (GetMenuState(hmenu, IDPLPC1, MF_BYCOMMAND)
		          eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(ProonDevice);
			CheckMenuItem (hmenu, IDPLPC1, MF_UNCHECKED);
		        EnableMenuItem(hmenu, IDMCOM1, MF_ENABLED);
		      Else
		        PMStat = PMStat bor ProonDevice;
			PMStat = PMStat band bnot(MesonDevice);
			ChkEnaDis (IDPLPC1);
		      Endif
		    Endif
		    break;
          
  case IDPLPC2:	    if (InitLptr("COM2"))
		    Then
		      if (GetMenuState(hmenu, IDPLPC2, MF_BYCOMMAND)
			  eq MF_CHECKED )
		      Then
			PMStat = PMStat band bnot(ProonDevice);
		        CheckMenuItem (hmenu, IDPLPC2, MF_UNCHECKED);
		        EnableMenuItem(hmenu, IDMCOM2, MF_ENABLED);
		      Else
		        PMStat = PMStat bor ProonDevice;
			PMStat = PMStat band bnot(MesonDevice);
			ChkEnaDis (IDPLPC2);
		      Endif
		    Endif
		    break;

  case IDMPROTO:    if (Proto)
		    Then
		      CloseFile (Proto); 
		      PMStat = PMStat band bnot(ProonFile);
		      CheckMenuItem (hmenu, IDMPROTO, MF_UNCHECKED);
		      OkMessage (452, ProtFileName);
		    Else
		      Forever
			if (SelectFile (hWnd, fht, "*.txt", (LPSTR) 475,
			    FileName, FilePath) eq FALSE)
			Then
			  goto ProExit;
		        Endif
                        P = strrchr(FileName, '.');
                        if (P eq NULL) strcat (FileName, ".TXT");
			if (MelDat and strcmpi (FileName, MelFileName) eq 0)
			Then
			  OkMessage (468, FileName);
			  continue;
			Endif
			if (openFile ("wb", &fh) eq FALSE)
		      	Then
		          goto ProExit;
			Endif
			break;
		      Endforever
		      CheckMenuItem (hmenu, IDMPROTO, MF_CHECKED);
		      strcpy (ProtFileName, FileName);
		      PMStat = PMStat bor ProonFile;
		      Proto = fh;
		    Endif

	ProExit:    State = InitState(0);
		    break;

  case IDGETDEBINFO:  
		    AddNextState (CheckCid, NULL);
		    AddNextState (SendString, "\015");
		    AddNextState (WaitForPrompt, NULL);
		    AddNextState (DiaDebFile, NULL);
		    State = GetNextState ();
		    break;

  case IDGETSYM:    if (ParamAnz eq 0)
		    Then
		      OkMessage (454, NULL);
		    Else
		      HStr[0] = GetSym; HStr[1] = 0;
		      AddNextState (DiaTextin, HStr);
		      AddNextState (GenDebBef, NULL);
		      State = GetNextState ();
		    Endif
		    break;

  case IDGETVAL:    if (ParamAnz eq 0)
		    Then
		      OkMessage (454, NULL);
		    Else
		      HStr[0] = GetVal; HStr[1] = 0;
		      AddNextState (CheckCid, NULL);
		      AddNextState (CheckMoni, NULL);
		      AddNextState (DiaTextin, HStr);
		      AddNextState (SendString, "\015");
		      AddNextState (WaitForPrompt, NULL);
		      AddNextState (GenDebBef, NULL);
		      State = GetNextState ();
		    Endif
		    break;

  case IDISPSYMVAL: if (ParamAnz eq 0)
		    Then
		      OkMessage (454, NULL);
		    Else
		      HStr[0] = DispVal; HStr[1] = 0;
		      AddNextState (CheckCid, NULL);
		      AddNextState (CheckMoni, NULL);
		      AddNextState (DiaTextin, HStr);
		      AddNextState (SendString, "\015");
		      AddNextState (WaitForPrompt, NULL);
		      AddNextState (GenDebBef, NULL);
		      State = GetNextState ();
		    Endif
		    break;

  case IDSETSYMVAL: if (ParamAnz eq 0)
		    Then
		      OkMessage (454, NULL);
		    Else
		      HStr[0] = SetVal; HStr[1] = 0;
		      AddNextState (CheckCid, NULL);
		      AddNextState (CheckMoni, NULL);
		      AddNextState (DiaTextin, HStr);
		      AddNextState (SendString, "\015");
		      AddNextState (WaitForPrompt, NULL);
		      AddNextState (GenDebBef, NULL);
		      State = GetNextState ();
		    Endif
		    break;
/*
  case IDMTEST:	    P = "INSCNTRL";
		    Hd = FindWindow (P, NULL);
		    wsprintf (Work, "Window: %04X", Hd);
		    MessageBox (hWnd, Work, P, 0);
		    if (Hd)
		    Then
		      SetProp (Hd, "TEST", 1234);
		      itoa (GetProp (Hd, "TEST"), HStr, 10);
		      RemoveProp (Hd, "TEST");
		      MessageBox (hWnd, HStr, "Prop-Value", 0);
		      PostMessage (Hd, WM_CLOSE, 0, 0);
		    Endif
		    break;
*/
  case IDMHELP:	    WinHelp (hWnd, HelpFile, HELP_CONTENTS, 0l);
		    break;

  case IDMCOMX:     hw = GetPPInt (AppName, "lastfCom", 0, IniFile);
		    if (hw > 2)
		    Then
		      id = hw + IDFFCOM;  goto OComm;
		    Else
		      hw = GetMenuItemCount(Pop1[2].hmenu);
		      if (hw eq 1)
		      Then
			id = GetMenuItemID(Pop1[2].hmenu, 0);
			goto OComm;
		      Else
			UserMessage (fht, hWndWTH86, 269, 0, "");
		      Endif
		    Endif
		    break;

  case IDSBOOT:	    // es existiert kein g¸ltiger Code-Path
		    GetModuleFileName (hInstWTH86, Work, WorkSize);
		    *strrchr(Work, '\\') = 0;
		    hw = SelectDir2(hWnd, Work, HStr, "Verzeichnis", 0);
		    if (hw eq 0)  break;

		    PutPPStr (AppName, "BootPath", HStr, IniFile);
//		    make Menu-Representation

  case IDMBOOT:     GetModuleFileName (hInstWTH86, HStr, sizeof(HStr));
		    P = strrchr(HStr, '\\'); if (P) *P = 0;
		    GetPPStr (AppName, "BootPath", HStr, HStr, sizeof(HStr), IniFile);
		    PM = &Pop5[7];   hmenu = Menu[1].hmenu;
		    PM->hmenu = CreatePopupMenu();
		    DeleteMenu (hmenu, 7, MF_BYPOSITION);
		    GetText (fht, Work, PM->Tnum);
		    hw = MF_BYPOSITION | MF_STRING | MF_POPUP;
		    InsertMenu(hmenu, 7, hw, (UINT)PM->hmenu, Work);  hw = 0;
		    AddDirMenu (PM->hmenu, HStr, ".SDB", 1, 1100, &BootPaths, &hw);
		    if (hw eq 0)
		    Then
		      DeleteMenu (hmenu, 7, MF_BYPOSITION);
		      hw = MF_BYPOSITION | MF_STRING;
		      InsertMenu(hmenu, 7, hw, IDSBOOT, Work);
		    Endif
		    break;

  case IDSCODE:	    // es existiert kein g¸ltiger Code-Path
		    GetModuleFileName (hInstWTH86, Work, WorkSize);
		    *strrchr(Work, '\\') = 0;
		    hw = SelectDir2(hWnd, Work, HStr, "Verzeichnis", 0);
		    if (hw eq 0)  break;

		    PutPPStr (AppName, "ProgPath", HStr, IniFile);
//		    make Menu-Representation

  case IDMCODE:     GetModuleFileName (hInstWTH86, HStr, sizeof(HStr));
		    P = strrchr(HStr, '\\'); if (P) *P = 0;
		    GetPPStr (AppName, "ProgPath", HStr, HStr, sizeof(HStr), IniFile);
		    PM = &Pop5[6];  hmenu = Menu[1].hmenu;
		    PM->hmenu = CreatePopupMenu();
		    DeleteMenu (hmenu, 6, MF_BYPOSITION);
		    GetText (fht, Work, PM->Tnum);
		    hw = MF_BYPOSITION | MF_STRING | MF_POPUP;
		    InsertMenu(hmenu, 6, hw, (UINT)PM->hmenu, Work);  hw = 0;
		    AddDirMenu (PM->hmenu, HStr, ".BIN", 1, 1000, &CodePaths, &hw);
		    if (hw eq 0)
		    Then
		      DeleteMenu (hmenu, 6, MF_BYPOSITION);
		      hw = MF_BYPOSITION | MF_STRING;
		      InsertMenu(hmenu, 6, hw, IDSBOOT, Work);
		    Endif
		    break;

  default:          if (id < IDMBAUD)  break;
		    if (id > (IDMBAUD+10))  goto LCode;
		    hw = ChangeBdMenu (id, 1);
		    break;

LCode:              if (id > IDFFCOM)  goto OComm;
		    InitSndFFile (hWnd, id);
		    break;

OComm:              if (InitComm(id-IDFFCOM) eq 0)  break;
		    goto ComCom;
Endswitch

Exit:
return;

End

/*---------------------------------------------------------------------------*/


long  PASCAL _export
WTH86WndProc(HWND hWnd, UINT message, WPARAM wP, LPARAM lP)

/*F
**.* Beschreibung :
**
**      Diese Funktion ist der Event-Dispatcher des Programms. Es ruft die,
**      dem jeweiligen Event entsprechende Funktion auf. Diese werden nicht
**      resident gehalten, und muessen daher von Windows bei Bedarf geladen
**      werden.
**
**.* Funktionswerte :
**
**      NULL, wenn die Funktion ein Unterprogramm aufgerufen hatte. Ansonsten
**      wird der Return-Wert der DefWindowProc() zurueckgegeben.
**
*/

Begin
char	HStr[20];
char	Entry[20];
PAINTSTRUCT  ps;
DWORD	hdw;
HDC	hdc;
RECT	RC;
WORD    dx,i,dy,y,n;
short	x;

Switch (message)
  case WM_KTRIGGER:	(*Trigger[wP].TFnk) ();
			break;

  case WM_DESTROY:	PostQuitMessage(0);
			break;
/*
  case WM_MOVE:		lastX = LOWORD(lP); lastY = HIWORD(lP);
			lastX = lastX - GetSystemMetrics (SM_CXDLGFRAME);
			lastY = lastY - GetSystemMetrics (SM_CYDLGFRAME);
			lastY = lastY - GetSystemMetrics (SM_CYCAPTION);
			lastY = lastY - GetSystemMetrics (SM_CYMENU);
			break;
*/

//  case WM_SETFOCUS:	ShowCaret (hWnd);
//			break;

  case WM_ACTIVATE:
	    // Window is becoming active window if wP is TRUE,
	    // inactive if wP is FALSE.  LOWORD(lP) is other window
	    // changing state.  HIWORD(lP) is TRUE if hWnd is iconic.
	    // If not iconic then set focus to receive keyboard input
			if (wP)
			Then
			  SetFocus(hWnd);
			Endif
			break;

/*
  case WM_SIZE:		InvalidateRect (hWnd, NULL, 1);
			UpdateWindow (hWnd);
			break;
*/
  case WM_EXITSIZEMOVE:	InvalidateRect (hWnd, NULL, 1);
			UpdateWindow (hWnd);
			GetWindowRect (hWnd, &RC);
			if (RC.left < 0) break;
			if (RC.top < 0) break;
			hdw = MAKELONG(RC.left,RC.top);
			itoa (hdw, HStr, 10);
			wsprintf (Entry, "I%d_Pos", InstNr);
			PutPPStr ("Position", Entry, HStr, IniFile);

			hdw = MAKELONG(RC.right-RC.left,RC.bottom-RC.top);
			itoa (hdw, HStr, 10);
			wsprintf (Entry, "I%d_Size", InstNr);
			PutPPStr ("Position", Entry, HStr, IniFile);
			break;

  case WM_PAINT:	hdc = BeginPaint(hWnd, (LPPAINTSTRUCT)&ps);
			WTH86Paint(hWnd, (LPPAINTSTRUCT)&ps);
			if (Cid < 0)
			Then
			  GetClientRect (hWnd, &RC); dy = RC.bottom>>1;
			  dx = MulDiv (dy,57,23);  x = (RC.right - dx) / 2;
			  if (x < 0)
			  Then
			    dx = RC.right; x = 0;
			    dy = MulDiv (dx,23,57);
			  Endif
			  y = RC.bottom/2 - (dy>>1);
			  ClrScrn (hdc);
			  WISAGLogo (hdc, x, y, dx);
			Endif
			EndPaint(hWnd, (LPPAINTSTRUCT)&ps );
			break;

  case WM_CLOSE:	return ((LONG) WTH86EndSession(hWnd));

  case WM_QUERYENDSESSION:  return((long)WTH86QueryEndSession(hWnd));

  case WM_ENDSESSION:	WTH86EndSession(hWnd);
			break;

  case WM_KEYUP:	break;

  case WM_KEYDOWN:	//if (wP eq VK_F11)  MsgBox (hWnd, "F11");
			if (LOBYTE(State) eq Display or 
			    LOBYTE(State) eq ExtractMel)
			Then
			  Switch (wP)
			    case VK_UP:   SendStr (CupSS);
					  break;

  			    case VK_DOWN: SendStr (CdownSS);
				          break;

			    case VK_LEFT: SendStr (CleftSS);
					  break;

			    case VK_RIGHT:SendStr (CrightSS);
					  break;

			    case VK_CONTROL:	if (CodeCnt eq 0) CodeCnt++;
//						else		  CodeCnt=0;
						break;

			    case VK_SHIFT:	if (CodeCnt eq 1) CodeCnt++;
//  						else		  CodeCnt=0;
						break;

			  Endswitch
			Endif
			break;

  case WM_CHAR:		i = LOBYTE(State); DDEActive = MDvalid = 0;
			if (i ne Display and i ne ExtractMel)  break;
			n = LOWORD(lP);
			if (IsTCPConnection())
			Then
			  if (IsMONConnection())
			  Then
			    if (LocalCommand (wP, n))	break;
			  Else
			    CodeCnt = 0; // bei mmktsk "@3*8=24" sperren
			    // Control-B abfangen!
			    if (wP eq CtrlB)  break;
			  Endif
			Endif

			Switch (wP)
/*
			  case Xoff:	EnableDisplay (0);
					break;
			  case Xon:	EnableDisplay (1);
//					PostMessage (hWndWTH86, WM_COMMNOTIFY, 0, 0l);
					break;
*/
			  case Bs:	wP = Del;

			  default:	if (wP eq CtrlC and CodeCnt eq 2)
					Then
					  strcpy (DispBuf, "@3*8=24\015");
					  n = strlen(DispBuf);
					Else
					  memset (DispBuf, wP, n);
					Endif
					SendChars (DispBuf, n, 0); CodeCnt = 0;
			Endswitch
			break;

  case WM_TIMER:	UpdateScroll();
			break;

  case WM_COMMAND:	WTH86Command(hWnd, CMDId(wP));
			break;

  case WM_MOVING:
  case WM_SIZING:	if (hWndDByte) CalcDspWin (hWndDByte);
			break;

  case WM_INITMENUPOPUP: break;

	default:
	return((long)DefWindowProc(hWnd, message, wP, lP));

    Endswitch
    /* A window proc should always return something */
    return(0);
End

/*****************************************************************/

struct	CmdTabS	{
	char	*sym;
	short	cmd;
		};

static
struct	CmdTabS	DevTab[] = {
		{"COM1", IDMCOM1},
		{"COM2", IDMCOM2},
		{ NULL,   0      }};

static
struct	CmdTabS	MesTab[] = {
		{"COM1", IDMLPC1},
		{"COM2", IDMLPC2},
		{"LPT1", IDMLPT1},
		{"LPT2", IDMLPT2},
		{ NULL,   0      }};

/*---------------------------------------------------------------------------*/

static	int	CheckDLLVersion (VOID)

Begin
int	ret;
HANDLE	hlib;
FARPROC	fproc;
LPSTR	P;

ret = 1;	// Error default
P = "gatfnk.dll"; hlib = LoadLibrary (P);
if (hlib < (HANDLE) HINSTANCE_ERROR)  goto Exit;
fproc = GetProcAddress (hlib, "INSFNKVersion");
if (fproc eq 0) goto Exit;
if (strcmp(INSFNKVersion(), V_INSFNK_DLL) <0) goto Exit;
ret = 0;

Exit:
if (hlib) FreeLibrary (hlib);
if (ret)
Then
  GetText (fht, Work, 255); strcat (Work, P);
  AppendText (fht, Work, 256);  MessageBeep(0);
  MessageBox (hWndWTH86, Work, AppName, MB_OK | MB_ICONINFORMATION);
Endif
return (ret);

End

/*---------------------------------------------------------------------------*/


WORD	GetInstNr (VOID)

Begin
BYTE	Nums[20];
char	HStr[20];
LPSTR	P;
HWND	hwd;
WORD	ret,i,n;

hwd = hWndWTH86;  n = 0;  memset (Nums, 0, sizeof(Nums));
While ((hwd = GetNextWindow(hwd, GW_HWNDNEXT)) ne NULL)
Begin
  if (hwd eq hWndWTH86)  continue;
  GetClassName(hwd, HStr, sizeof(HStr));
  if (strcmp(HStr, AppName))   continue;
  GetWindowText (hwd, HStr, sizeof(HStr));
  P = strchr(HStr, '(');
  if (P eq NULL)  continue;
  Nums[n++] = latoi(P+1);
Endwhile

ret = 1;
for (i=1; i<=sizeof(Nums)-1; i++)
Begin
  if (strchr((LPSTR)Nums, i) eq NULL)
  Then
    ret = i;  break;
  Endif
End

return (ret);

End

/*****************************************************************/

WORD	WINAPI	NextComDev (LPSTR Com)

Begin
static
LPSTR   LP,LPi;
LPSTR   P,P2;
DWORD   hdw;
WORD    ret;

ret = 1;
if (Com eq NULL)
Then
  hdw = 0xF000;  LP = LPi = (LPSTR) AllocPtr(hdw);
  hdw = QueryDosDevice(NULL, LP, hdw);
  if (hdw eq 0)  DispLastError (hWndWTH86, "QueryDosDevice");
//  wsprintf (HStr, "Ret from QueryDosDevice: %u", hdw);
//  DbgStr(HStr);
  goto Exit;
Endif

While (*LP)
Begin
//  DbgStr(LP);
  P = strstr(LP, "COM"); P2 = LP;
  LP = LP + strlen(LP) + 1;
  if (P eq NULL or P ne P2) continue;
  strcpy (Com, P); goto Exit;
Endwhile
Free_Ptr(&LPi);  ret = 0;

Exit:
return(ret);

End

/*****************************************************************/


VOID    WINAPI  AddComMenu (PMDESC MD, WORD Id)

Begin
char    HStr[30];
WORD	hw,Style;
WORD    Cnt;
HMENU   Pm,hm;

/*
Pm = CreatePopupMenu();
hm = GetMenu(hWndWTH86);
Style = MF_BYCOMMAND | MF_POPUP | MF_ENABLED;
GetText (fht, HStr, 233);
MD->hmenu = Pm;  Cnt = 0;
ModifyMenu (hm, IDMCOMX, Style, (UINT) Pm, HStr);
*/

NextComDev (NULL);  Cnt = 0;
While (NextComDev(HStr))
Begin
  if (strcmp(HStr, "COM1") and
      strcmp(HStr, "COM2"))
  Then
    if (Cnt eq 0)
    Then
      Pm = CreatePopupMenu(); hm = GetMenu(hWndWTH86);
      Style = MF_BYCOMMAND | MF_POPUP | MF_ENABLED;
      GetText (fht, Work, MD->Tnum);  MD->hmenu = Pm;
      ModifyMenu (hm, IDMCOMX, Style, (UINT) Pm, Work);
    Endif
    Style = MF_ENABLED | MF_STRING;  hw = latoi(&HStr[3]);
    AppendMenu (Pm, Style, Id+hw, HStr);  Cnt++;
  Endif
Endwhile

/*
if (Cnt eq 0)
Then
  DestroyMenu (Pm); MD->hmenu = NULL;
  RemoveMenu (hm, IDMCOMX, MF_BYCOMMAND);
  DispLastError (hWndWTH86, "RemoveMenu");
  DrawMenuBar(hWndWTH86);
  //EnableMenuItem(hm, IDMCOMX, MF_ENABLED);
Endif
*/

End


/*****************************************************************/


VOID    WINAPI  ReadDebugInfo (HWND hWnd)

Begin
char	HStr[20];
LPSTR	Pm,P;
PMODULE	MP;
WORD	Cnt;

Pm = Work; *Pm = 0;
GetPPStr (AppName, "Debug", "", Work, WorkSize, IniFile);
DebVal = atoi(Work);  *Pm = 0;

GetPPStr ("EEDUMP", NULL, "", Work, WorkSize, IniFile);
if (*Pm eq 0)  goto Exit;

MP = Module; DebVal = 1;  Cnt = 0;
While (*Pm)
Begin
  if (Cnt >= 31)  break;
  GetPPStr ("EEDUMP", Pm, "", HStr, sizeof(HStr), IniFile);
  P = strtok(HStr, ",");
  if (P)
  Then
    strncpy (MP->Mod, Pm, 6);
    MP->Num = atoi(P);
    P = strtok(NULL, ",");
    if (P)  strncpy (MP->Vers, P, 5);
  Endif
  Pm = Pm + strlen(Pm) + 1;
  Cnt++;  MP++;
Endwhile
// Endekennung
memset (MP, 0, sizeof(MODULE));

Exit:
return;

End

/*---------------------------------------------------------------------------*/


int	WTH86InitApp (HANDLE hInst, HANDLE PInst, LPSTR Cmd, int Show)

Begin
WNDCLASS    WC;
LPVOID	PV;
BOOL	succ,ret;
HMENU   Pmenu;
LPSTR	Msg;
char	HStr[120];
LPSTR	CP,P1,P2;
struct	CmdTabS	*P;
int	fh;
DWORD	hdw;
WORD	hw,X,Y,DX,DY;

ret = 1;	// Error default
Msg = "RegisterClass failed";
if (PInst eq 0)
Then
  /* register this new class with WINDOWS */
  WC.style         = CS_OWNDC | CS_BYTEALIGNWINDOW;
  WC.lpfnWndProc   = WTH86WndProc;
  WC.cbClsExtra    = 0;
  WC.cbWndExtra    = 0;
  WC.hInstance     = hInst;
  WC.hIcon         = LoadIcon(hInst, AppName);
  WC.hCursor       = LoadCursor(NULL, IDC_ARROW);
  WC.hbrBackground = (HBRUSH) (COLOR_WINDOW+1);
  WC.lpszMenuName  = NULL;
  WC.lpszClassName = AppName;
  succ = RegisterClass(&WC);
  if (succ eq FALSE)  goto Exit;
Endif

hInstWTH86 = hInst;
strcpy (AppName2, AppName);
strcat (AppName2, "  (1)");
Msg = "InitScreen failed";
if ((hWndWTH86 = InitScreen(hInst)) eq 0)	goto Exit;

InstNr = GetInstNr();
wsprintf (AppName2, "%s  (%d)  ", AppName, InstNr);

Msg = "can't open Textfile";
fht = OpenLTxtFile (hWndWTH86, NULL);
if (fht < 0)  goto Exit;


PV = ReadVersInfo ("W32TH86.EXE", &P2, &P1);
if (PV eq NULL)
Then
  PostMessage (hWndWTH86, WM_CLOSE, 0, 0l); goto Exit;
Endif
strcpy (CompanyName, P2);
strcpy (Version, P1);
Free_Ptr (&PV);


MakeAppMenu (hWndWTH86, Menu, fht);
Pmenu = GetMenu(hWndWTH86);
InitCommCtrl();
State = InitState (0);

DDEValP = (LPSTR) AllocPtr(1024);
MrDataP = (LPSTR) AllocPtr(8192);
Msg = "can't get Memory";
if (DDEValP eq NULL or MrDataP eq NULL)	goto Exit;

Msg = "can't find '\\' in ModuleFileName";
GetModuleFileName (hInst, IniFile, sizeof(IniFile));
strcpy (PrgPath, IniFile); CP = strrchr(PrgPath, '\\');
if (CP) *CP = 0;
strupr(IniFile); CP = strrchr(IniFile, '\\');
if (CP eq NULL)  goto Exit;
strcpy (CP+1, AppName);
CP = CP + strlen(CP);
strcpy (CP, ".hlp");
strcpy (HelpFile, IniFile);
strcpy (CP, ".INI");
fh = _FOpen (IniFile, OF_READ);
if (fh < 0)
Then
  fh = _FOpen (IniFile, OF_CREATE);
Endif
_FClose (fh);


wsprintf (HStr, "I%d_Pos", InstNr);
hdw = GetPPInt ("Position", HStr, 0, IniFile);
X = LOWORD(hdw);  Y = HIWORD(hdw);
wsprintf (HStr, "I%d_Size", InstNr);
hdw = GetPPInt ("Position", HStr, 0, IniFile);
if (hdw)
Then
  DX = LOWORD(hdw);  DY = HIWORD(hdw);
  SetWindowPos (hWndWTH86, NULL, X, Y, DX, DY, SWP_SHOWWINDOW);
Else
  ShowWindow(hWndWTH86, Show);
Endif
//UpdateWindow(hWndWTH86);
PostMsg (hWndWTH86, WM_COMMAND, IDSETMAIN, 0l);



hw = GetPPInt (AppName, "TestDlg", 0, IniFile);
if (hw)
Then
  Pmenu = GetSubMenu (Pmenu, 5);
  AppendMenu (Pmenu, MF_STRING, IDMTEST, "&Test");
Endif

Work[0] = 0;
GetPPStr (AppName, "Device", "", Work, WorkSize, IniFile);
P = DevTab; strupr (Work);
While ( P->sym )
Begin
  if (strcmp (Work, P->sym) eq 0)
  Then
    PostMessage (hWndWTH86, WM_COMMAND, P->cmd, 0L);
    break;
  Endif
  P++;
Endwhile

Work[0] = 0;
GetPPStr (AppName, "Messages", "", Work, WorkSize, IniFile);
P = MesTab; strupr (Work);
While ( P->sym )
Begin
  if (strcmp (Work, P->sym) eq 0)
  Then
    PostMessage (hWndWTH86, WM_COMMAND, P->cmd, 0L);
    break;
  Endif
  P++;
Endwhile

ReadDebugInfo (hWndWTH86);
ReadSioParams ();
InitBdMenu (&Pop1[4]);

GetPPStr (AppName, "ProgPath", "", HStr, sizeof(HStr), IniFile);
if (HStr[0])
Then
  hw = IsAnySubFile (HStr, ".BIN");
  if (hw)
  Then
    PostMsg (hWndWTH86, WM_COMMAND, IDMCODE, 0);
  Else
    PutPPStr (AppName, "ProgPath", NULL, IniFile);
  Endif
Endif

GetPPStr (AppName, "BootPath", "", HStr, sizeof(HStr), IniFile);
if (HStr[0])
Then
  hw = IsAnySubFile (HStr, ".BIN");
  if (hw)
  Then
    PostMsg (hWndWTH86, WM_COMMAND, IDMBOOT, 0);
  Else
    PutPPStr (AppName, "BootPath", NULL, IniFile);
  Endif
Endif

AddComMenu (&Pop1[2], IDFFCOM);

Msg = "CheckDLLVersion failed";
if (CheckDLLVersion()) goto Exit;
if (DebVal)
Then
  SetKBHook (hWndWTH86, Trigger);
Endif
ret = 0;
Msg = NULL;

Exit:
if (Msg) MessageBox (hWndWTH86, Msg, "WTH86", MB_INFO);
return (ret);

End


/*---------------------------------------------------------------------------*/

#if	(__BORLANDC__ >= 0x0550)
int    PASCAL WMain(HANDLE hInst, HANDLE PInst, LPSTR Cmd, int Show)
#else
int    PASCAL WinMain(HANDLE hInst, HANDLE PInst, LPSTR Cmd, int Show)
#endif

Begin
HACCEL  hAccTable;            /* handle to accelerator table          */
MSG	msg;

if (PInst eq 0)	InitializeDDE (hInst);

if (WTH86InitApp(hInst, PInst, Cmd, Show)) goto Exit;

hAccTable = LoadAccelerators(hInst, AppName);
While (GetMessage((LPMSG)&msg, NULL, 0, 0))
Begin
  if (TranslateAccelerator(hWndWTH86, hAccTable, &msg))  continue;
  TranslateMessage((LPMSG)&msg);
  DispatchMessage((LPMSG)&msg);
Endwhile

Exit:
if (PInst eq 0)  UninitializeDDE();
return msg.wParam;

End
