/*K
**      Modul Name....: TH_SIOR.C
**
**      Funktion......: Schnittstellen Routinen fuer das Programm WTH86
**
**      Versionsdatum.: 18.09.1998
**
**      Autor.........: U. Stahl   - ABB GAT/E
**
**
*/

#include        <windows.h>
#include        <wredef.h>
#include        <stdio.h>
#include        <stdlib.h>
#include        <string.h>
#include        "..\insfnk.h"

#pragma hdrstop

#include        <ctype.h>
#include        "wthsio.h"
#include        "stream.h"
//#include        "th_rsrc.h"
#include        "wth86.h"
#include        "th_dlg.h"

//      E x t e r n a l s 

extern  HANDLE  hInstWTH86;
extern  HWND    hWndWTH86;
extern  int	fht;
extern  HANDLE  inslib;
extern  char    vl_Chr,lstChr,Work[];
extern  char    DispBuf[];
extern  char    lastHost[],lastPort[];
extern  char    IniFile[];
extern  LPCSTR  AppName;
extern  short   Cid,LPCid;
extern  WORD    State,TmpState,MoniReady,DDEMReady,Hibus;

VOID    CALLBACK Poll (HWND, UINT, LPVOID);
VOID    CALLBACK BEmpty (HWND, UINT, LPVOID);
int     WINAPI  IsMONConnection (VOID);



/* Baudratenwerte                                   */
#define BdMax           6
#define PollDelay       60  /* Delay in ms                              */

static  short   BdVal[BdMax]={300,600,1200,2400,4800,9600};
short   Baudrate=9600;  // default Baudrate     
BYTE    DataBits = 8,
	StopBits = ONESTOPBIT,
	Parity   = NOPARITY;

static  WORD    EnableDisp=1;

static  COMSTAT ComStat;            /* Struktur fuer GetCommError() Aufruf          */
static  UINT    FAR *EvntMask;
	WORD	PortNr;
	int     TcpConn;
static  SOCKET	So;
static  SOCKADDR_IN  SAdr;


static  FARPROC APollProc;
static  WORD    Tid;

#define MC_RTS  0x0001
#define MC_DTR  0x0002
#define MC_CTS  0x0004
#define MC_DSR  0x0008

static  WORD    MControl,       // Modem Control-Flags
		XonXoff,
		RlsTim,
		CtsTim,
		DsrTim;

/*****************************************************************/

VOID    ReadSioParams ()

Begin

Baudrate = GetPrivateProfileInt (AppName, "Baudrate", Baudrate, IniFile);
DataBits = GetPrivateProfileInt (AppName, "DataBits", DataBits, IniFile);
StopBits = GetPrivateProfileInt (AppName, "StopBits", StopBits, IniFile);
Parity   = GetPrivateProfileInt (AppName, "Parity", Parity, IniFile);
MControl = GetPrivateProfileInt (AppName, "Modem", 0, IniFile);
XonXoff  = GetPrivateProfileInt (AppName, "XonXoff", 1, IniFile);
RlsTim   = GetPrivateProfileInt (AppName, "RlsTim", 0, IniFile);
CtsTim   = GetPrivateProfileInt (AppName, "CtsTim", 0, IniFile);
DsrTim   = GetPrivateProfileInt (AppName, "DsrTim", 0, IniFile);

End

/*****************************************************************/

int     WINAPI  IsAnyConnection ()

Begin
int	ret;

ret = 0;
if (TcpConn or Cid >= 0) ret++;
return (ret);

End

/*****************************************************************/

int     WINAPI  IsTCPConnection ()

Begin

return (TcpConn);

End

/*****************************************************************/

int     WINAPI  IsMONConnection ()

Begin
int     ret;

ret = 0;
if (PortNr eq PORTMON)  ret++;
return (ret);

End

/*****************************************************************/

VOID	WINAPI	WSA_Error (HWND hWnd, LPSTR Cap)

Begin
char	HStr[10];
int	hi;

hi = WSAGetLastError ();
WSASetLastError (0);
itoa (hi, HStr, 10);
MessageBox (hWnd, HStr, Cap, MB_INFO);

End

/*****************************************************************/

int	WINAPI	OpenStream (LPSTR IPHost, WORD Port)

Begin
WSADATA	DA;
int     hi,ret;
WORD    hw;

hw = MAKEWORD(2,0);  ret = 1;
hi = WSAStartup (hw, &DA);
if (hi)
Then
  WSA_Error (hWndWTH86, "Startup");  goto Exit;
Endif

// Socket ˆffnen
So = socket (AF_INET, SOCK_STREAM, 0);
if (So eq INVALID_SOCKET)
Then
  WSA_Error (hWndWTH86, "Open Socket");  goto Exit;
Endif


memset (&SAdr, 0, sizeof(SAdr));
SAdr.sin_family = AF_INET;
SAdr.sin_port = htons (Port);
//SAdr.sin_addr.S_un.S_addr = inet_addr("10.49.41.229");
SAdr.sin_addr.S_un.S_addr = inet_addr(IPHost);
hi = connect(So, (SOCKADDR*)&SAdr, sizeof(SAdr));
if (hi eq SOCKET_ERROR)
Then
  WSA_Error (hWndWTH86, "Connect");  goto Exit;
Endif
ret = 0;

Exit:
return (ret);

End

/*--------------------------------------------------------------------------*/

int	WINAPI	ReadStream (LPSTR Buf, WORD Len)


Begin
int	ret;

ret = recv (So, Buf, Len, 0);
return (ret);

End


/*--------------------------------------------------------------------------*/

int	WINAPI	WriteStream (LPSTR Buf, WORD Len)


Begin
int	ret;

ret = send (So, Buf, Len, 0);
return (ret);

End


/*--------------------------------------------------------------------------*/

VOID    CALLBACK CloseTCP (HWND hWnd)


Begin

if (TcpConn)
Then
  if (So ne INVALID_SOCKET)
  Then
    closesocket(So);
  Endif
  WSACleanup();
  TcpConn = 0; Cid = -1;
  ChkEnaDis (IDMCLOSE);
  SendMsg (hWnd, WM_COMMAND, IDSETMAIN, 0L);
  DestroyDspWin (); MessageBeep(0);
Endif

End


/*--------------------------------------------------------------------------*/

static  WORD    TxtIds[] = {IDTXT1, 473, IDEDIT, 489, IDMONI, 487,
		IDZLTDIA, 488, IDOK, 300, IDCANCEL, 301, 0};

static  WORD    CtlIds[] = {IDEDIT, IDMONI, IDZLTDIA, IDOK, IDCANCEL, 0};

WORD	WINAPI	Connection(HWND hDlg, WORD msg, WPARAM wP, LPARAM lP)

/*F
**.* Beschreibung :
**
**      Dialogfunktion fuer die Anwahl der TCP/IP-Verbindung
**
**.* Funktionswerte :
**
**     TRUE   -> Wenn die Message von der Prozedur bearbeitet wurde
**     FALSE  -> Wenn die Message nicht verarbeitet wurde
*/

Begin
static
WORD    ret;
PHOSDAT	PH;
HCURSOR hCursor;
HWND	hwd;
WORD    Id,CMsg;
LONG    *lp;
short   hi;
BOOL	RET;

msg = TransCCMsg(msg, wP, lP, &RET);
Switch (msg)
  case WM_INITDIALOG:   SetCtlText (hDlg, fht, TxtIds);
			GetText (fht, Work, 472);  ret = 0;
			SetWindowText(hDlg, Work);
			InitHostData ();
			InitHostBox (hDlg, IDHOSTS);
			if (PortNr eq 0)  PortNr = 7;
			if (PortNr eq 7)
			Then
			  CheckRadioButton (hDlg, IDMONI, IDZLTDIA, IDMONI);
			Else
			  CheckRadioButton (hDlg, IDMONI, IDZLTDIA, IDZLTDIA);
			Endif
			break;

  case WM_CTLCOLORSTATIC:
  case WM_CTLCOLORDLG:
  case WM_CTLCOLORBTN:	break;

  case WM_COMMAND:	CMsg = NTFMsg(wP,lP); Id = CMDId(wP);
    Switch (Id)
      case IDOK:        EnableControls (hDlg, CtlIds, 0 ,0);
			hCursor = SetCursor (LoadCursor(NULL, IDC_WAIT));
			ret = OpenStream (lastHost, PortNr);
			if (ret)
			Then
			  lastHost[0] = 0;
			Else
			  TcpConn++;
			Endif
			SetCursor (hCursor);

      case IDCANCEL:    ExitHostData ();
			EndDialog (hDlg, ret);
			break;

      case IDHOSTS:     if (CMsg ne LBN_SELCHANGE)  break;
			hwd = GetDlgItem (hDlg, IDHOSTS);
			hi = SendMsg (hwd, LB_GETCURSEL, 0, 0);
			PH = (PHOSDAT) SendMsg (hwd, LB_GETITEMDATA, hi, 0);
			strcpy (lastHost, PH->IPAdr);
			break;

      case IDMONI:      PortNr = 7;
			CheckRadioButton (hDlg, IDMONI, IDZLTDIA, IDMONI);
			break;

      case IDZLTDIA:    PortNr = 20001;
			CheckRadioButton (hDlg, IDMONI, IDZLTDIA, IDZLTDIA);
			break;

      case IDEDIT:      hi = EditHost (hDlg, lastHost);
                        if (hi)
                        Then
			  InitHostData ();
			  InitHostBox (hDlg, IDHOST);
			Endif
			break;
    Endswitch
    break;

  default:		RET = FALSE;
Endswitch
return (RET);

End

/*---------------------------------------------------------------------------*/

VOID    CALLBACK _export
ActivatePoll (HWND hWnd, UINT msg, UINT Id, DWORD Time)

/*F
**.* Beschreibung :
**
**      Die Funktion aktiviert das Pollen der Schnittstelle (durch er-
**      zeugen der WM_COMMNOTIFY Message) wenn mehr Zeichen in der 
**      Receive-Queue sind als pro Poll-Vorgang ausgelesen werden kînnen.
**      In diesem Fall bleibt die o.g. Message nÑmlich aus! (siehe
**      Beschreibung "EnableCommNotification")
**
**
*/

Begin

PostMsg (hWndWTH86, WM_COMMNOTIFY, -1, CN_RECEIVE);

End

/*---------------------------------------------------------------------------*/

VOID    CALLBACK Poll (HWND hWnd, UINT Sck, LPVOID LP)

Begin

PostMsg (hWnd, WM_COMMNOTIFY, -1, CN_RECEIVE);

End

/*---------------------------------------------------------------------------*/

VOID    CALLBACK BEmpty (HWND hWnd, UINT Sck, LPVOID LP)

Begin

PostMsg (hWnd, WM_COMMNOTIFY, -1, CN_RECEIVE);

End

/*--------------------------------------------------------------------------*/

//int   Dump,SDump;


VOID    CloseSDevice ()

/*F
**.* Beschreibung :
**
**      Die Funktion schlie·t die selielle Verbindung
**
**.* Funktionswerte :
**
**
*/

 
Begin

if (TcpConn)
Then
  CloseTCP (hWndWTH86);
  TcpConn = 0;
Else
  if (Cid >= 0)
  Then
    Sio_Close (Cid);
  Endif
Endif
Cid = -1;  lastHost[0] = 0;
if (Tid)
Then
  KillTimer (0, Tid); Tid = 0;
  FreePrgInst (APollProc);
Endif

End

/*---------------------------------------------------------------------------*/

VOID    SetComPara ()

/*F
**.* Beschreibung :
**
**      Die Funktion setzt die Schnittstellenparameter entsprechend
**      den globalen Parametern.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
WORD	hw;

hw = Sio_Flags(DataBits,StopBits,Parity,MControl,XonXoff);
Sio_Para (Cid, hw, Baudrate, min (50, (IQueSize>>3)));
Sio_FlushI(Cid);

End


/*-------------------------------------------------------------------------*/

BOOL	WINAPI	SetSioPara (HWND hDlg, WORD msg, WPARAM wP, LPARAM lP)

/*F
**.* Beschreibung :
**
**      Die Funktion bedient die Dialogbox zum aendern der
**      Schnittstellenparameter.
**
**.* Funktionswerte :
**
**      TRUE    -    Die Message wurde von der Routine verarbeitet
**      FALSE   -    Die Message wurde nicht bearbeitet
*/

Begin
static
BYTE    DB,SB,PA;
static
WORD    BD;
static
short   BInd;
char    HStr[20];
HWND    hctl;
BOOL	RET;

msg = TransCCMsg(msg, wP, lP, &RET);
Switch (msg)
  case WM_INITDIALOG:
	GetText (fht, Work, 316);
	SetDlgItemText (hDlg, IDTXT1, Work);
	GetText (fht, Work, 317);
	SetDlgItemText (hDlg, IDTXT2, Work);
	GetText (fht, Work, 318);
	SetDlgItemText (hDlg, IDTXT3, Work);
	GetText (fht, Work, 319);
	SetDlgItemText (hDlg, IDODDP, Work);
	GetText (fht, Work, 320);
	SetDlgItemText (hDlg, IDEVENP, Work);
	GetText (fht, Work, 321);
	SetDlgItemText (hDlg, IDNOP, Work);
	GetText (fht, Work, 322);
	SetDlgItemText (hDlg, IDTXT4, Work);

	GetText (fht, Work, 257);
	SetDlgItemText (hDlg, IDZP10, Work);
	GetText (fht, Work, 258);
	SetDlgItemText (hDlg, IDZP12, Work);

	GetText (fht, Work, 300);
	SetDlgItemText (hDlg, IDOK, Work);
	GetText (fht, Work, 301);
	SetDlgItemText (hDlg, IDCANCEL, Work);
	GetText (fht, Work, 330);
	SetWindowText (hDlg, Work);
	Switch (DataBits)
	  case 7:       CheckRadioButton (hDlg, ID7DATA, ID8DATA, ID7DATA);
			break;
	  case 8:       CheckRadioButton (hDlg, ID7DATA, ID8DATA, ID8DATA);
			break;
	Endswitch
	DB = DataBits;

	Switch (StopBits)
	case ONESTOPBIT:  CheckRadioButton (hDlg, ID1STOP, ID2STOP, ID1STOP);
			  break;
	case TWOSTOPBITS: CheckRadioButton (hDlg, ID1STOP, ID2STOP, ID2STOP);
			  break;
	Endswitch
	SB = StopBits;

	Switch (Parity)
	case NOPARITY:  CheckRadioButton (hDlg, IDEVENP, IDNOP, IDNOP);
			break;
	case ODDPARITY: CheckRadioButton (hDlg, IDEVENP, IDNOP, IDODDP);
			break;
	case EVENPARITY:CheckRadioButton (hDlg, IDEVENP, IDNOP, IDEVENP);
			break;
	Endswitch
	PA = Parity;
	BD = Baudrate;
	hctl = GetDlgItem (hDlg, IDSCROLL);
	SetScrollRange (hctl, SB_CTL, 0, BdMax-1, TRUE);
	For (BInd=0; BInd<BdMax; BInd++)
	Begin
	  if (Baudrate eq BdVal[BInd])
	  Then
	    wsprintf (HStr, "%d", Baudrate);
	    SetDlgItemText( hDlg, IDBAUD, HStr);
	    SetScrollPos (hctl, SB_CTL, BInd, TRUE);
	    break;
	  Endif
	Endfor
	break;

  case WM_CTLCOLORSTATIC:
  case WM_CTLCOLORDLG:
  case WM_CTLCOLORBTN:	break;

  case WM_COMMAND:
	Switch ( wP )
	   case IDOK:   DataBits = DB;
			StopBits = SB;
			Parity   = PA;
			Baudrate = BD;
			SetComPara ();
			wsprintf (Work, "%u", BD);
			WritePrivateProfileString (AppName, 
			"Baudrate", Work, IniFile);
			wsprintf (Work, "%u", DB);
			WritePrivateProfileString (AppName, 
			"DataBits", Work, IniFile);
			wsprintf (Work, "%u", SB);
			WritePrivateProfileString (AppName, 
			"StopBits", Work, IniFile);
			wsprintf (Work, "%u", PA);
			WritePrivateProfileString (AppName, 
			"Parity", Work, IniFile);
			EndDialog (hDlg, TRUE);
			break;

	   case IDCANCEL :
			/* User pressed cancel.  Just take down dialog box. */
			EndDialog(hDlg,  FALSE );
			break;

	   case ID7DATA:
			CheckRadioButton (hDlg, ID7DATA, ID8DATA, ID7DATA);
			DB = 7; 
			break;

	   case ID8DATA:
			CheckRadioButton (hDlg, ID7DATA, ID8DATA, ID8DATA);
			DB = 8; 
			break;

	   case IDZP10:
			CheckRadioButton (hDlg, IDZP10, IDZP12, IDZP10);
			PostMessage (hDlg, WM_COMMAND, ID7DATA, 0l);
			PostMessage (hDlg, WM_COMMAND, ID1STOP, 0l);
			PostMessage (hDlg, WM_COMMAND, IDODDP, 0l);
			break;

	   case IDZP12:
			CheckRadioButton (hDlg, IDZP10, IDZP12, IDZP12);
			PostMessage (hDlg, WM_COMMAND, ID8DATA, 0l);
			PostMessage (hDlg, WM_COMMAND, ID1STOP, 0l);
			PostMessage (hDlg, WM_COMMAND, IDNOP, 0l);
			break;

	   case ID1STOP:CheckRadioButton (hDlg, ID1STOP, ID2STOP, ID1STOP);
			SB = ONESTOPBIT;
			break;

	   case ID2STOP:CheckRadioButton (hDlg, ID1STOP, ID2STOP, ID2STOP);
			SB = TWOSTOPBITS;
			break;

	   case IDNOP:  CheckRadioButton (hDlg, IDEVENP, IDNOP, IDNOP);
			PA = NOPARITY;
			break;
	   case IDEVENP:CheckRadioButton (hDlg, IDEVENP, IDNOP, IDEVENP);
			PA = EVENPARITY;
			break;
	   case IDODDP: CheckRadioButton (hDlg, IDEVENP, IDNOP, IDODDP);
			PA = ODDPARITY;
			break;
	Endswitch
	break;

  case WM_HSCROLL:
	Switch ( wP )

	   case SB_LINEDOWN:    BInd++;
				if (BInd >= BdMax)  BInd = BdMax-1;
				break;

	   case SB_LINEUP:      BInd--;
				if (BInd < 0)  BInd = 0;
				break;
	Endswitch
	hctl = GetDlgItem (hDlg, IDSCROLL);
	BD = BdVal[BInd];
	wsprintf (HStr, "%d", BD);
	SetDlgItemText( hDlg, IDBAUD, HStr);
	SetScrollPos (hctl, SB_CTL, BInd, TRUE);
	break;

  default:	RET = FALSE;  
Endswitch
return(RET);

End

/*---------------------------------------------------------------------------*/

BOOL    InitComm(short Nr)

/*F
**.* Beschreibung :
**
**      Die Funktion beinhaltet alle Aufrufe, die zur Initialisierung
**      der Schnittstelle COM 'Nr'
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
OFSTRUCT OS;
char    comstr[10];
short   RStat;

wsprintf (comstr, "COM%d", Nr);
if (Cid >= 0)
Then
  Sio_Escape (Cid);
  Sio_Close (Cid);              /* evt. offenen Kanal schliessen        */
  Cid = -1;
Endif

RStat = Sio_Open(hWndWTH86, comstr, IQueSize, OQueSize);
Switch (RStat)
  case  IE_BADID:       OkMessage (421, comstr);
			return(FALSE);
  case  IE_BAUDRATE:    OkMessage (422, comstr);
			return(FALSE);
  case  IE_BYTESIZE:    OkMessage (423, comstr);
			return(FALSE);
  case  IE_DEFAULT:     OkMessage (424, comstr);
			return(FALSE);
  case  IE_HARDWARE:    OkMessage (425, comstr);
			return(FALSE);
  case  IE_MEMORY:      OkMessage (426, comstr);
			return(FALSE);
  case  IE_NOPEN:       OkMessage (427, comstr);
			return(FALSE);
  case  IE_OPEN:        OkMessage (428, comstr);
			return(FALSE);
Endswitch

Cid = RStat;

strcpy (lastHost, comstr);

SetComPara ();

#ifdef	WIN16
EvntMask = Sio_Event (Cid, hWndWTH86, EV_RXCHAR);
#endif

//Dump = OpenFile ("chrbcr.dmp", &OS, OF_CREATE);
//SDump = OpenFile ("state.dmp", &OS, OF_CREATE);

State = InitState(0);
return (TRUE);

End


/*---------------------------------------------------------------------------*/

BOOL    InitLptr(LPSTR St)

/*F
**.* Beschreibung :
**
**      Die Funktion beinhaltet alle Aufrufe, die zur Initialisierung
**      der Drucker-Schnittstelle St.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
char    comstr[10];

strcpy (comstr, St);
if (LPCid >= 0)
Then
  _FClose (LPCid);              /* evt. offenen Kanal schliessen        */
  LPCid = -1;
Endif

LPCid = _FOpen (comstr, OF_WRITE);
if (LPCid <0)
Then
  OkMessage (450, comstr);
  return(FALSE);
Endswitch

return (TRUE);

End


/*---------------------------------------------------------------------------*/


short     AnzCharIQue()
 
/*F
**.* Beschreibung :
**
**      Die Funktion liefert die Anzahl der Zeichen, die sich
**      in der Receive-Que befinden.
**
**.* Funktionswerte :
**
**      Anzahl
**
*/
 
Begin
short   n;

if (TcpConn)
Then
  n = 0;
Else
  if (Cid < 0) return (0);
//  GetCommError (Cid, &ComStat);
//  n = ComStat.cbInQue;
  n = Sio_IFill (Cid);
Endif
return (n);

End

/*--------------------------------------------------------------------------*/


static	char	GetCfBuf (VOID)
 
/*F
**.* Beschreibung :
**
**      Die Funktion liest ein Zeichen von der Empfangs-Que.
**      Ist kein Zeichen da wird EOF zurueckgeliefert.
**
**.* Funktionswerte :
**
**      Zeichen oder EOF
**
*/

Begin
char    c;
static  
WORD    Rind,Bsiz;

if (Rind >= Bsiz)
Then
  Rind = 0;  Bsiz = ReadChars (DispBuf, DBLen);
Endif
if (Bsiz)  c = toupper(DispBuf[Rind++]);
else       c = EOF;
return (c);

End

/*--------------------------------------------------------------------------*/


char     GetCharComm(VOID)
 
Begin
char    c;

c = GetCfBuf();
// Sync Åberlesen
if (c eq Sync) c = GetCfBuf();
//if (Bsiz) _FWrite (Dump, &c, 1);

if (c ne EOF)
Then
  vl_Chr = lstChr; lstChr = c;
  if ((lstChr eq '*' or lstChr eq '$') and vl_Chr eq Lf)
  Then
    MoniReady = 1;
    if (lstChr eq '$')	Hibus = 1;
    else		Hibus = 0;
  Else
    MoniReady = 0;
  Endif
Endif
return (c);

End

/*--------------------------------------------------------------------------*/


WORD    ReadEnable (WPARAM wP, LPARAM lP)

Begin
WORD    ret;

ret = EnableDisp;
if (TcpConn and (LOWORD(lP) band CN_EVENT))
Then
  CloseTCP (hWndWTH86);
Else
  if (wP ne (WPARAM)-1 and Tid)
  Then
//    ret = wsprintf (Work, "timea driver!  %4x\015\012", wP);
//    _FWrite (Dump, Work, ret);
    ret = 0;
  Endif
Endif
return (ret);

End

/*--------------------------------------------------------------------------*/

VOID    EnableDisplay (WORD V)

Begin

EnableDisp = V;
if (V) PostMessage (hWndWTH86, WM_COMMNOTIFY, -1, CN_RECEIVE);

End

/*--------------------------------------------------------------------------*/

VOID    FlushIQue ()

/*F
**.* Beschreibung :
**
**      Die Funktion lîscht die Recieve-Queue
**
**.* Funktionswerte :
**
*/
 
Begin

ReadChars (DispBuf, DBLen);

End

/*--------------------------------------------------------------------------*/

WORD    ReadChars (LPSTR Buf, WORD N)

/*F
**.* Beschreibung :
**
**      Die Funktion liest 
**
**.* Funktionswerte :
**
**      Zeichen oder EOF
**
*/

Begin
short   Anz,hs,n;
LONG    tim,hl,rTime;
char    HStr[10];


if (TcpConn)
Then
  Anz = ReadStream (Buf, N);
  if (Anz < 0)  Anz = 0;
Else
  if (Cid >= 0)
  Then
    if (EvntMask) *EvntMask = 0;
    Anz = Sio_Read (Cid, Buf, N);
    if (Anz eq 0)  Sleep(50);
  Else
    Anz = 0;
  Endif
Endif

Exit:
/*
wsprintf (HStr, "%5lu %5lu", MTime, rTime);
if (Tid)        strcpy (Work, "timea ");
else            strcpy (Work, "time  ");
strcat (Work, HStr);
strcat (Work, " n ");
Dezcb (HStr, Anz, 3);
strcat (Work, HStr);
hs = strlen(Work);
strcpy (&Work[hs], "\015\012");
_FWrite (Dump, Work, hs+2);
*/
return (Anz);

End

/*--------------------------------------------------------------------------*/

WORD    SendChars (LPSTR Str, WORD Anz)

/*F
**.* Beschreibung :
**
**      Die Funktion sendet Anz Zeichen auf die Schnittstelle.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
WORD    n;

n = 0;
if (Anz eq 0) goto Exit;
if (TcpConn)
Then
  n = WriteStream (Str, Anz);
Else
  if (Cid>=0)
  Then
    n = abs(Sio_Write (Cid, Str, Anz));
  Endif
Endif
Exit:
return (n);

End

/*--------------------------------------------------------------------------*/

VOID    SendStr (LPSTR Str)
 
/*F
**.* Beschreibung :
**
**      Die Funktion gibt den String Str auf die Schnittstelle aus,
**      sofern noch Platz in der Sende-Que ist.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
WORD    l,Delay;
int     n;

l = lstrlen(Str);
if (TcpConn)
Then
  WriteStream (Str, l);
Else
  Sio_Write (Cid, Str, l);
Endif
 
End


/*--------------------------------------------------------------------------*/


VOID    PutChrComm (char C)
 
/*F
**.* Beschreibung :
**
**      Die Funktion gibt ein Zeichen auf die Schnittstelle aus.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin

if (TcpConn)
Then
  WriteStream (&C, 1);
Else
  Sio_Write (Cid, &C, 1);
Endif

End

