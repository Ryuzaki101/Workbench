/*K
**      Modul Name....: TH_SCRN.C
**
**      Funktion......: Globale Bildschirmroutinen
**
**      Erstelldatum..: 10.04.1989
**
**      Versionsdatum.: 30.06.1989
**
**      Autor.........: U. Stahl   - ABB IL/TE22
**
**      GILP Nr.......: ...........
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

#include        <fcntl.h>
#include        <io.h>
#include        "wth86.h"

//	E x t e r n a l s

extern	HWND	hWndWTH86;
extern	char	Work[];
extern	char	IniFile[];
extern	LPCSTR	AppName;
extern	char	DispBuf[],AppName2[];
extern	WORD	State,TmpState,EEDump;
extern	int	MelDat,Proto;
extern	short	Cid,LPCid,PMStat;


#define	ScreenDelay	120  // Delay in ms

HFONT		HndFont;
short   xClient, yClient ;

static	HBRUSH	hWndBr;
static	short	Zeile,Spalte;	/* aktuelle Cursor-Position                 */
short	ZlAnz;
static	short	    XSize,YSize,	/* Ausdehnung des Bildschirms		    */
	ChrWidth,ChrHeight,	/* Zeichengroesse in log-Pixels		    */
	ZlHeight,
	OldSpalte,OldZeile,
	fZeil = 1,
	lZeil = 19,
	Escflag,Esi,
	MelTrigger;
static	short	fDLine,lDLine,JPFlag,STim,ScCnt,vonZeil,bisZeil;

static	
char	*Zeichen[ZlMax+1],	/* Bildschirmspeicher Zeilen		    */
	*Formate[ZlMax+1],	/* Bildschirmspeicher Formate		    */
	lastPChar,
	VAttrib,OldVAttrib,
	DState,
	EscSeq[20],
	FmtMem[(ZlMax+1)*(SpMax+1)],    /* Bildschirmspeicher   	    */
	ScrMem[(ZlMax+1)*(SpMax+1)];    /* Bildschirmspeicher   	    */

static  void    MeldngOut(char*, short);
static  void    MoveDisplay (short);
static  void    WriteText (HDC, short, short, char*, short);
static  void    ScrollLine (short, short);
static  void    ClrPartScr(HDC, WORD, WORD, WORD, WORD);
static  void    LineFeed (VOID);
static  WORD    CheckControl (HDC, char);
static  void    Setvideo(HDC);
static  void    CReturn (VOID);
static  void    SetCurPos(WORD, WORD, BOOL);
static  void    SetCaretAbs(short, short);
static  void    StorAttrib (VOID);
static  void    RestAttrib (HDC);

/*---------------------------------------------------------------------------*/

static	WORD	CU_Tog,CU_Ena;
static	WORD	CU_Splt,CU_Zeil;

static	VOID	SetCaretAbs (short Spalt, short Zeil)

Begin

CU_Splt = Spalt;
CU_Zeil = Zeil;

End

/*---------------------------------------------------------------------------*/

static	VOID	SetCaretRel (short Spalt, short Zeil)


Begin

if (Zeil < fDLine or Zeil > lDLine)  return;

CU_Splt = Spalt;
CU_Zeil = Zeil - fDLine;

End


//---------------------------------------------------------------------------

VOID	CALLBACK  PaintCurs (HWND hWnd, UINT Msg, UINT Evnt, DWORD Tim)

Begin
static	Toggle;
HANDLE	hdc,hPen,hOld;
int	hi,X,Y;
COLORREF CB,CW;

if (EEDump and IsAnyConnection() eq 0)  StateSwitch ();
if (Tim)  Toggle = Toggle bxor 1;
else	  Toggle = 0;
if (Toggle)	  return;
if (CU_Ena eq 0)  return;


X = CU_Splt * ChrWidth;
hi = ChrHeight>>2;
Y = (CU_Zeil+1) * ZlHeight - hi;
if (VAttrib band Revers)
Then
  CW = RGB(0,0,0); CB = RGB(255,255,255);
Else
  CB = RGB(0,0,0); CW = RGB(255,255,255);
Endif
if (CU_Tog)
Then
  hPen = CreatePen (PS_SOLID, 1, CB);
Else
  hPen = CreatePen (PS_SOLID, 1, CW);
Endif
CU_Tog = CU_Tog bxor 1;
hdc = GetDC (hWnd);
hOld = SelectObject(hdc, hPen);

Rectangle (hdc, X, Y, X+8, Y+2);

SelectObject(hdc, hOld);
DeleteObject (hPen);
ReleaseDC(hWnd, hdc);

End

//---------------------------------------------------------------------------

VOID	EnableCursor(WORD Ena)

Begin

if (CU_Ena eq Ena)  goto Exit;

// Cursor nochmal updaten!
CU_Tog = Ena;  CU_Ena = 1;
PaintCurs (hWndWTH86, 0, 0, 0);
CU_Ena = Ena;

Exit:
return;

End

//---------------------------------------------------------------------------

VOID	InitCursor(HWND hWnd)

Begin

CU_Ena = 1;
SetTimer (hWnd, CursTimer, CursorBlinkTime, (TIMERPROC) PaintCurs);

End


/*---------------------------------------------------------------------------*/

VOID	InitVideo()

Begin
HDC	hdc;

hdc = GetDC (hWndWTH86);
Spalte = Zeile = 0;
VAttrib = DefAttrib;
ClrScrn (hdc);
ReleaseDC (hWndWTH86, hdc);

End


/*---------------------------------------------------------------------------*/

VOID	ExitScreen()

/*F
**.* Beschreibung :
**
**      Die Funktion gibt alle angeforderten Resourcen frei.
**
**.* Funktionswerte :
**
*/

Begin

KillTimer (hWndWTH86, CursTimer);
DestroyWindow(hWndWTH86);
DeleteObject (hWndBr);

End


/*---------------------------------------------------------------------------*/

HWND	InitScreen(HANDLE hInst)

/*F
**.* Beschreibung :
**
**      Die Funktion beinhaltet alle Aufrufe, die zur Initialisierung
**      des 'Text' Screens benoetigt werden.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
HWND	hWnd;
TEXTMETRIC tm ;
HDC     hdc;
int	i;
char	DefStr[10];

HndFont = GetStockObject (SYSTEM_FIXED_FONT);
hdc = CreateIC ("DISPLAY", NULL, NULL, NULL) ;
if (HndFont) SelectObject (hdc, HndFont);

GetTextMetrics (hdc, &tm);
DeleteDC (hdc);
ChrWidth  = tm.tmMaxCharWidth;
ChrHeight = tm.tmHeight;
ZlHeight  = tm.tmHeight; //+ tm.tmExternalLeading;

wsprintf (DefStr, "%d", ZlMax+1);  Work[0] = 0;
GetPrivateProfileString (AppName, "Lines", DefStr, Work, WorkSize, IniFile);
ZlAnz = atoi (Work);
if (ZlAnz < 1)		ZlAnz = 1;
if (ZlAnz > (ZlMax+1))	ZlAnz = ZlMax+1;

xClient = 2 * GetSystemMetrics (SM_CXDLGFRAME)+(SpAnz+1)*ChrWidth;
//xStart  = (GetSystemMetrics (SM_CXSCREEN) - xClient) >> 1;
yClient = 2 * GetSystemMetrics (SM_CYDLGFRAME) + (ZlMax+1)*ZlHeight;
yClient+= GetSystemMetrics (SM_CYCAPTION) + GetSystemMetrics (SM_CYMENU);
/*
i  = 2;  yh = GetDeviceCaps (hdc, VERTRES);
While ((yClient+ZlMax+1) < yh and i)
Do
  yClient = yClient + ZlMax+1;
  ZlHeight++; i--;
Endwhile
*/
//yStart  = (GetSystemMetrics (SM_CYSCREEN) - yClient) >> 1 ;
//if (xStart < 0)  xStart = 0;  if (yStart < 0)  yStart = 0;

strcpy (Work, AppName2);
hWnd  = CreateWindow(
	AppName,		/* window class name            */
	Work,    		/* window caption               */
	WS_CAPTION | WS_SYSMENU | WS_THICKFRAME | WS_MINIMIZEBOX | DS_SETFONT,
	CW_USEDEFAULT,		// x position
	CW_USEDEFAULT,		// y position
	xClient,		/* width                        */
	yClient,		/* height                       */
	(HWND)NULL,             /* handle to parantwindow       */
	(HMENU)NULL,            /* menu, or child window id     */
	hInst,      		/* handle to window instance    */
	NULL             	/* additional info              */
	);

			/* Was the window created ? */
	If ( not hWnd )
	   return 0;

hWndBr = CreateSolidBrush (GetSysColor(COLOR_WINDOW));
XSize = (SpAnz) * ChrWidth;
YSize = (ZlAnz) * ZlHeight;
Zeile = 0; Spalte = 0;
fDLine = 0; lDLine = ZlAnz-1;
Work[0] = 0;
GetPrivateProfileString (AppName, "Version", Work, Work, WorkSize, IniFile);
if (strcmp (Work, "Japanese") eq 0)
Then
  ChrWidth = ChrWidth >> 1;  JPFlag++;
Endif
InitCursor(hWnd);
//SetCaretBlinkTime (CursorBlinkTime);

memset (ScrMem, ' ', (ZlMax+1) * (SpMax+1) );
memset (FmtMem, DefAttrib, (ZlMax+1) * (SpMax+1) );
Zeichen[0] = ScrMem; Formate[0] = FmtMem;
For ( i=1; i<=ZlMax; i++ )
Begin
  Zeichen[i] = Zeichen[i-1]+ SpMax+1;
  Formate[i] = Formate[i-1]+ SpMax+1;
Endfor
return (hWnd);

End


/*---------------------------------------------------------------------------*/

void    SetMode(VOID)
 
/*F
**.* Beschreibung :
**
**      Die Funktion setzt vor jeder Ausgabe den entsprechenden
**      Map-Mode und Groesse des Viewports.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
HDC	hdc;

hdc = GetDC (hWndWTH86);
SetMapMode (hdc, MM_ANISOTROPIC);
SetWindowExtEx (hdc, XSize, YSize, NULL);
SetViewportExtEx (hdc, XSize, YSize, NULL);
ReleaseDC (hWndWTH86, hdc);

End

/*---------------------------------------------------------------------------*/

void    SetDispMode(HDC hdc, char M)

/*F
**.* Beschreibung :
**
**      Die Funktion setzt vor jeder Ausgabe den entsprechenden
**      Map-Mode und Groesse des Viewports.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin

if (M)
Then
  SetTextColor (hdc, RGB(255,255,255));
  SetBkColor (hdc, RGB(0,0,0));
Else
  SetTextColor (hdc, RGB(0,0,0));
  SetBkColor (hdc, RGB(255,255,255));
Endif

End

/*---------------------------------------------------------------------------*/

VOID	WTH86Paint(HWND hWnd, LPPAINTSTRUCT lpps)

/*F
**.* Beschreibung :
**
**      Zeichenfunktion fuer das Userwindow.
**      Sie dient z. Zt. nur dem loeschen des Windows durch 'ausbuersten'
**      mit der Hintergrundfarbe.
**
**.* Funktinswerte :
**
**      Keine !
**
*/

Begin
HBRUSH  hbrOld;

SetMode ();
If (lpps->fErase)
Then
  hbrOld = SelectObject(lpps->hdc, hWndBr);
  FillRect(lpps->hdc, (LPRECT)&lpps->rcPaint, hWndBr);
  if (hbrOld) SelectObject(lpps->hdc, hbrOld);
Endif
if (Cid > 0)  WriteScreen (lpps->hdc);

End


/*---------------------------------------------------------------------------*/

void	UpdateScroll (VOID)

/*F
**.* Beschreibung :
**
**      Die Funktion scrollt den Bildschirminhalt entsprechend den
**      vergangenen Lf's und gibt die neu hinzugekommenen Zeilen aus.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
short	YP,XP,CAnz,N,i,z;
char	Attrib,*Fptr,*Tptr;
HDC	hdc;

TmpState = State;  State = 0;
KillTimer (hWndWTH86, ScrnTimer);  STim = 0;
EnableCursor (0);  hdc = GetDC(hWndWTH86);

ScCnt = bisZeil - vonZeil;
// neue Zeilen ausgeben
z = bisZeil - ScCnt; ScCnt = 0;
for ( i=bisZeil; i>=z; i--)
Begin
  YP = i; XP = 0;  N = 0;  CAnz = 0;
  Tptr = Zeichen[i];  Fptr = Formate[i];
  Attrib = *Fptr;  SetDispMode (hdc, Attrib);
  Forever
    if (N eq SpMax+1)
    Then
      WriteText (hdc, XP, YP, Tptr, CAnz);
      break;
    Endif
    if (Attrib eq *Fptr)
    Then
      N++;  Fptr++;  CAnz++;
    Else
      WriteText (hdc, XP, YP, Tptr, CAnz);
      Tptr += CAnz;  XP += CAnz;
      CAnz = 0;  Attrib = *Fptr;
      SetDispMode (hdc, Attrib);
    Endif
  Endforever
Endfor

SetCaretRel (Spalte, Zeile);
SetDispMode (hdc, VAttrib);
ReleaseDC (hWndWTH86, hdc);
EnableCursor (1);
State = TmpState;

End

/*---------------------------------------------------------------------------*/

void    WriteScreen (HDC hdc)

/*F
**.* Beschreibung :
**
**      Die Funktion gibt den Inhalt des Bildschirms ganz oder teilweise
**      aus.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
short   YP,XP,CAnz,N,i;
char	Attrib,*Fptr,*Tptr;

EnableCursor (0);
SelectObject (hdc, HndFont);

For ( i=ZlMax; i>=0; i--)
Begin
  YP = i; XP = 0;  N = 0;  CAnz = 0;
  Tptr = Zeichen[i];  Fptr = Formate[i];
  Attrib = *Fptr;  SetDispMode (hdc, Attrib);
  Forever
    if (N eq SpMax+1)
    Then
      WriteText (hdc, XP, YP, Tptr, CAnz);
      break;
    Endif
    if (Attrib eq *Fptr)
    Then
      N++;  Fptr++;  CAnz++;
    Else
      WriteText (hdc, XP, YP, Tptr, CAnz);
      Tptr += CAnz;  XP += CAnz;
      CAnz = 0;  Attrib = *Fptr;
      SetDispMode (hdc, Attrib);
    Endif
  Endforever
Endfor
EnableCursor (1);
SetDispMode (hdc, VAttrib);

End


/*---------------------------------------------------------------------------*/

static	void    MoveDisplay(short Zl)

/*F
**.* Beschreibung :
**
**      Die Funktion verschiebt das DisplayFenster so, dass die letzte
**      Ausgabe sichtbar wird.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
short	inc,delta;

if (Zl >= fDLine and Zl <= lDLine)  return;
if (Zl < fDLine)
Then
  delta = fDLine - Zl;
  inc = -1;
Else
  delta = Zl - lDLine;
  inc = 1;
Endif
While ( delta )
Begin
  fDLine += inc;
  lDLine += inc;
  delta--;
Endwhile

/* eventuell laufende Screenausgabe abbrechen				    */
if (STim) KillTimer (hWndWTH86, ScrnTimer);
SetTimer (hWndWTH86, ScrnTimer, ScreenDelay, 0l);
STim++;

End


/*---------------------------------------------------------------------------*/


static	void	WriteText(HDC hdc, short Sp, short Zl, LPSTR Txt, short Len)

/*F
**.* Beschreibung :
**
**      Die Funktion gibt den angegebenen Text an der angegebenen
**      Position aus, sofern diese im DisplayFenster liegt.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
short	XP,YP;

if (Zl < fDLine or Zl > lDLine)  return;
Zl -= fDLine;
XP = Sp * ChrWidth;
YP = Zl * ZlHeight;
TextOut (hdc, XP, YP, Txt, Len);

End


/*---------------------------------------------------------------------------*/

static  void    MeldngOut (LPSTR buf, short anz)

/*F
**.* Beschreibung :
**
**      Die Funktion gibt buf entsprechend dem Meldungsstatus
**      auf das entsprechende Device aus.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
int	n;

n = anz; lastPChar = *(buf+n-1);
if (PMStat band ProonDevice)
Then
  _FWrite (LPCid, buf, anz);
Endif

if (PMStat band ProonFile and Proto)
Then
  n = _FWrite (Proto, buf, anz);
  if (n ne anz) CloseFile (Proto);
Endif

if (DState eq ExtractMel)
Then
  if (PMStat band MesonDevice)
  Then
    _FWrite (LPCid, buf, anz);
  Endif

  if (PMStat band MesonFile and MelDat)
  Then
    n = _FWrite (MelDat, buf, anz);
    if (n ne anz) CloseFile (MelDat);
  Endif
Endif

if (n ne anz)
Then
  OkMessage (483, NULL);
  PMStat=MesonScreen;
Endif

End

/*---------------------------------------------------------------------------*/

static  void    ScrollLine(short von, short bis)

/*F
**.* Beschreibung :
**
**      Die Funktion srollt den Seitenspeicher in den angegebenen
**      Grenzen.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
WORD    i;
char    *HPZ,*HPF;

HPZ = Zeichen[von];
HPF = Formate[von];
For ( i=von; i<bis; i++ )
Begin
  Zeichen[i] = Zeichen[i+1];
  Formate[i] = Formate[i+1];
Endfor
Zeichen[bis] = HPZ;
Formate[bis] = HPF;
memset (Zeichen[bis], ' ', SpMax+1);
memset (Formate[bis], DefAttrib, SpMax+1);

/*
yhd = (bis - von) * ChrHeight;
yps = (von + 1) * ChrHeight;
GetClientRect (hWndWTH86, &RC);
RC.bottom++; RC.right++;	// Punkt auf Rechteckrand noch zul„ssig!
Pt.x = 0; Pt.y = yps + yhd;
if (PtInRect (&RC, Pt))
Then
  HideCaret (hWndWTH86);
  RC.left = 0; RC.right = XSize;
  RC.top  = von * ChrHeight;
  RC.bottom = RC.top + yhd;
  ScrollWindow (hWndWTH86, 0, -ChrHeight, NULL, &RC);

  // letzte Zeile l”schen
  RC.top  = bis * ChrHeight;
  RC.bottom = RC.top + ChrHeight;
  FillRect (hdcTH86, &RC, hWndBr);
  SetCaretRel (Spalte, Zeile);
  ShowCaret (hWndWTH86);
Endif
*/

if (STim)  KillTimer (hWndWTH86, ScrnTimer);
ScCnt++; STim++; vonZeil = von; bisZeil = bis;
SetTimer (hWndWTH86, ScrnTimer, ScreenDelay, NULL);

End


/*---------------------------------------------------------------------------*/

VOID    WINAPI	ClrScrn (HANDLE hdc)

/*F
**.* Beschreibung :
**
**      Die Funktion loescht den Seitenspeicher.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin

memset (ScrMem, ' ', (SpMax+1) * (ZlMax+1));
memset (FmtMem, DefAttrib, (SpMax+1) * (ZlMax+1));
if (hdc) WriteScreen (hdc);
MelTrigger = 0;

End


/*---------------------------------------------------------------------------*/

static  void    ClrPartScr(HDC hdc, WORD Z1, WORD S1, WORD Z2, WORD S2)

/*F
**.* Beschreibung :
**
**      Die Funktion loescht den Bildschrirm im angegebenen Bereich.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
short   Anz;
char    *HPZ,*HPF;

if (Z1>Z2)
Then
  Anz = Z2;  Z2 = Z1; Z1 = Anz;
Endif
if (S1>S2)
Then
  Anz = S2;  S2 = S1; S1 = Anz;
Endif
if (Z1>ZlMax)	Z1 = ZlMax;
if (Z2>ZlMax)	Z2 = ZlMax;
if (S1>SpMax)	S1 = SpMax;
if (S2>SpMax)	S2 = SpMax;

if (lZeil and Zeile <= lZeil)
Then
  if (Z2 >= lZeil)  Z2 = lZeil;
Endif

SetCaretAbs (SpMax+1, ZlAnz);
SetDispMode (hdc, DefAttrib);
if (Z1 eq Z2)
Then
  Anz = S2-S1+1;
  HPZ = Zeichen[Z1]+S1;
  HPF = Formate[Z1]+S1;
  memset ( HPZ, ' ', Anz);
  memset ( HPF, DefAttrib, Anz);
  WriteText (hdc, S1, Z1, HPZ, Anz);
Else
  Anz = SpMax-S1+1;
  HPZ = Zeichen[Z1]+S1;
  HPF = Formate[Z1]+S1;
  memset ( HPZ, ' ', Anz);
  memset ( HPF, DefAttrib, Anz);
  WriteText (hdc, 0, Z1, HPZ, Anz);
  Z1++;  Anz = S2+1;
  HPZ = Zeichen[Z2];
  HPF = Formate[Z2];
  memset ( HPZ, ' ', Anz);
  memset ( HPF, DefAttrib, Anz);
  WriteText (hdc, 0, Z2, HPZ, Anz);

  While ( Z1<Z2 )
  Begin
    HPZ = Zeichen[Z1];
    HPF = Formate[Z1];
    memset ( HPZ, ' ', SpMax+1);
    memset ( HPF, DefAttrib, SpMax+1);
    WriteText (hdc, 0, Z1, HPZ, SpMax+1);
    Z1++;
  Endwhile
Endif
SetCaretRel (Spalte, Zeile);
SetDispMode (hdc, VAttrib);

End


/*---------------------------------------------------------------------------*/

static void    LineFeed()

/*F
**.* Beschreibung :
**
**      Die Funktion scrollt den Bildschirn um eine Zeile nach oben.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
WORD	hw,n;

if (lZeil and Zeile eq lZeil)
Then
  if (MelTrigger eq 2)
  Then
    if (PMStat band MesonScreen)
    Then
      ScrollLine (fZeil, lZeil);
    Endif
    DState = ExtractMel;
    // Wandlung Cr,Lf provozieren
    lastPChar = Lf;
  Else
    ScrollLine (fZeil, lZeil);
  Endif
Else
  Zeile++;
  if (Zeile>ZlMax)
  Then
    Zeile--;
    if (lZeil)
    Then
      ScrollLine (lZeil+1, ZlMax);
    Else
      ScrollLine (0, ZlMax);
    Endif
  Else
    SetCaretRel (Spalte, Zeile);
  Endif
Endif
MoveDisplay (Zeile);
MelTrigger = 0; n = 1; hw = Lf;
if (lastPChar eq Lf)
Then
  hw = (hw << 8) bor Cr; n++;
Endif
MeldngOut ((char*) &hw, n);
   
End


/*---------------------------------------------------------------------------*/

static void    CReturn()

/*F
**.* Beschreibung :
**
**      Die Funktion fuehrt ein Carridge-Return aus.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
   
Spalte = 0;
SetCaretRel (Spalte, Zeile);
if (MelTrigger)
Then
  MelTrigger++;
Endif
Work[0] = Cr;
MeldngOut (Work, 1);

End


/*---------------------------------------------------------------------------*/

static  void    StorAttrib()

/*F
**.* Beschreibung :
**
**      Die Funktion speichert die augeneblicklichen Arrtibute.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
   
OldSpalte = Spalte;
OldZeile  = Zeile;
OldVAttrib= VAttrib;
MelTrigger = 0;

End


/*---------------------------------------------------------------------------*/

static  void    RestAttrib(HDC hdc)

/*F
**.* Beschreibung :
**
**      Die Funktion restauriert die gespeicherten Arrtibute.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin

Spalte = OldSpalte;
Zeile  = OldZeile;
VAttrib= OldVAttrib;
SetCurPos (Zeile, Spalte, FALSE);
SetDispMode (hdc, VAttrib);
MelTrigger = 0;
if (DState eq ExtractMel)
Then
  DState = Display;
Endif
MoveDisplay (Zeile);

End


/*---------------------------------------------------------------------------*/

static  VOID    SetCurPos(WORD Zeil, WORD Spalt, BOOL Meldung)

/*F
**.* Beschreibung :
**
**      Die Funktion setzt die Cursor-Posiotion.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
short	N;

if (Spalt>SpMax)    Spalt = SpMax;
if (Zeil> ZlMax)    Zeil  = 0;

if (Zeil ne Zeile)
Then
  if (lZeil eq 0 or Zeil ne lZeil)
  Then
    Work[0] = Cr;  Work[1] = Lf;
    MeldngOut (Work, 2);
  Endif
  if (Spalt)
  Then
    memset (Work, ' ', Spalt);
    MeldngOut (Work, Spalt);
  Endif
Else
  N = Spalt - Spalte;
  if (N > 0)
  Then
    memset (Work, ' ', N);
    MeldngOut (Work, N);
  Endif
Endif

Zeile = Zeil;  Spalte = Spalt;
SetCaretRel (Spalte, Zeile);
if (Meldung and lZeil and Zeile eq lZeil)
Then
  MelTrigger++;
Else
  MelTrigger = 0;
Endif
MoveDisplay (Zeile);

End


/*---------------------------------------------------------------------------*/

static  void    Setvideo(HDC hdc)

/*F
**.* Beschreibung :
**
**      Die Funktion setzt die empfangene Esc-Sequenz in den ent-
**      prechenden Bios-Aufruf um.
**
**.* Funktionswerte :
**
**
*/

Begin
char    lastC,*token;
short   hv;

lastC = EscSeq[Esi-1];
token = strtok (EscSeq, "[;");
if (token eq NULL) return;
hv  = atoi (token);

Switch ( lastC )
   case 'f' :   token = strtok (NULL, "[;");
   		if (token eq NULL) return;
		hv--;
                SetCurPos(hv, atoi(token)-1, FALSE);
		break;                

   case 'H' :	token = strtok (NULL, "[;");
   		if (token eq NULL) return;
		hv--;
		SetCurPos(hv, atoi(token)-1, TRUE);
		break;                

   case 'J' :   Switch (hv)
		  case 0:   ClrPartScr (hdc, Zeile,Spalte,ZlMax,SpMax);
			    break;

		  case 1:   ClrPartScr (hdc, 0, 0, Zeile, Spalte);
			    break;

		  case 2:   ClrScrn(hdc);
			    break;
		Endswitch
		break;

   case 'K' :   Switch (hv)
		  case 0:   ClrPartScr (hdc, Zeile, Spalte, Zeile, SpMax);
			    break;

		  case 1:   ClrPartScr (hdc, Zeile, 0, Zeile, Spalte);
			    break;

		  case 2:   ClrPartScr (hdc, Zeile, 0, Zeile, SpMax);
			    break;
		Endswitch
		break;

   case 'A' :   SetCurPos (Zeile-hv, Spalte, FALSE);
		break;

   case 'B' :   SetCurPos (Zeile+hv, Spalte, FALSE);
		break;

   case 'C' :   SetCurPos (Zeile, Spalte+hv, FALSE);
		break;

   case 'D' :   SetCurPos (Zeile, Spalte-hv, FALSE);
		break;

   case 'M' :   hv--;
		ClrPartScr (hdc, Zeile, 0, Zeile+hv, SpMax);
		break;

   case 'r' :   hv--; fZeil = hv;
		token = strtok (NULL, "[;");
		if (token eq NULL) return;
		hv = atoi (token) - 1;
		lZeil = hv;
		fZeil = fZeil mod (ZlMax+1);
		lZeil = lZeil mod (ZlMax+1);
		break;

   case 'm' :   Switch ( hv )
		   case 0:  /* video Attribut off               */
			    VAttrib = DefAttrib;
			    SetDispMode (hdc, VAttrib);
			    break;

		   case 1:  /* High-Light on                    */
			    break;

		   case 4:  /* Underline on                     */
			    break;

		   case 5:  /* Blinking on                      */
			    break;

		   case 7:  /* revers on                        */
			    VAttrib = VAttrib bor Revers;
			    SetDispMode (hdc, VAttrib);
			    break;

		   case 22: /* High-Light off                   */
			    break;

                   case 24: /* underline off                    */
                            break;

                   case 25: /* Blinking off                     */
                            break;

                   case 27: /* revers off                       */
                            VAttrib = VAttrib band bnot(Revers);
			    SetDispMode (hdc, VAttrib);
			    break;
                Endswitch
Endswitch

End


/*---------------------------------------------------------------------------*/

static  WORD     CheckControl(HDC hdc, char C)

/*F
**.* Beschreibung :
**
**      Die Funktion gibt den Character C auf dem Haupt-Window aus
**      und verarbeitet Contol-Character bzw. Esc-Sequenzen entsprechend.
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
WORD	i,ret;

ret = 0;
Switch (C)
  case Esc: Escflag++;  Esi = 0;
	    break;

  case Cr:  CReturn();  // ret++;
	    break;

  case Lf:  LineFeed();  // ret++;
	    break;

  case FF:  for (i=0; i<ZlMax; i++)
	    Begin
	      LineFeed();
	    Endif
	    break;

  case Tab: Spalte = Spalte >> 3;
	    Spalte++;  ret++;
	    Spalte = Spalte << 3;
	    Spalte = min (Spalte, SpMax);
	    SetCaretRel (Spalte, Zeile);
	    break;
  case Bs:
  case Del: if (Spalte)
	    Then
	      Spalte--;
	    Endif
	    SetCaretRel (Spalte, Zeile);
	    break;

  case Bel: FlushOQue(); MessageBeep(0);
/*
	    OpenSound();
	    SetVoiceAccent (1, 120, 255, S_LEGATO, 0);
	    SetVoiceNote (1, 60, 16, 1);
	    StartSound();
	    WaitSoundState (S_QUEUEEMPTY);
	    CloseSound();
*/
	    break;


  default:  /* hier wird Esc-Sequenz verarbeitet        */
	    if  (iscntrl(C))
	    Then
	      Switch (C)
		case Cr:    CReturn();
			    break;
		case Esc:   Esi = 0;
			    break;
	      Endswitch
	    Else
	      EscSeq[Esi++] = C;
	      Switch (Esi)
		case 1:     Switch ( C )
			      case '7':     StorAttrib();
					    Escflag = 0;
					    break;

			      case '8':     RestAttrib(hdc);
					    Escflag = 0;
					    break;
			    Endswitch
			    break;

		case 2:     Switch ( C )
			      case 'J': ClrPartScr(hdc,Zeile,Spalte,ZlMax,SpMax);
					Escflag = 0;
					break;

			      case 'K': ClrPartScr(hdc,Zeile,Spalte,Zeile,SpMax);
					Escflag = 0;
					break;

			      case 'A': SetCurPos (Zeile-1, Spalte+0, FALSE);
					Escflag = 0;
					break;

			      case 'B': SetCurPos (Zeile+1, Spalte+0, FALSE);
                                        Escflag = 0;
					break;

                              case 'C': SetCurPos (Zeile+0, Spalte+1, FALSE);
                                        Escflag = 0;
                                        break;

			      case 'D': SetCurPos (Zeile+0, Spalte-1, FALSE);
					Escflag = 0;
					break;
			    Endswitch
			    break;

		default:    if (isalpha(C))
			    Then
			      EscSeq[Esi] = 0;
			      Setvideo(hdc);
			      Escflag = 0;
			    Endif
	      Endswitch
	    Endif
	    break;

Endswitch

return (ret);

End


/*---------------------------------------------------------------------------*/


/*F
**.* Explantation:
**
**      Function[iskanjic] 	is checking the character code for
**				Japanese KANJI first code
**
**      Function[iskanjic2] 	is checking the character code for
**				Japanese KANJI second code
**
**.* Return Value:
**
**      1: Valid code for KANJI code
**	0: Invalid code for KANJI code
**
*/

static	int	iskanjic (BYTE chr)

Begin

if ( (chr >= 0x81 and chr <= 0x9f)  or
     (chr >= 0xe0 and chr <= 0xec) )
Then
  return (1);
Else
  return (0);
Endif

End


static	int	iskanjic2 (BYTE chr)

Begin

if ( (chr >= 0x40 and chr <= 0x7e)  or
     (chr >= 0x80 and chr <= 0xfc) )
Then
  return (1);
Else
  return (0);
Endif

End


/*---------------------------------------------------------------------------*/

VOID    DisplayBuf (LPBYTE Buf, short N)

Begin
short   OldSp,ChrAnz,OldAnz;
BYTE    *Text,*Tp,*OldTp;
short	i,c,Spdata;
HDC	hdc;

if (N eq 0)  return;

EnableCursor(0);
hdc = GetDC(hWndWTH86);
SetDispMode (hdc, VAttrib);
SelectObject (hdc, HndFont);

While (N)
Begin
  if (Escflag or (*Buf < 32) or (*Buf eq Del))
  Then
    i = CheckControl  (hdc, *Buf);
    if (i) MeldngOut (Buf, 1);
    Buf++;  N--;
  Else
    Text = Buf;  ChrAnz = 0;
    While ( (*Buf > 31) and (*Buf ne Del) and N )
    Begin
      Buf++;  N--; ChrAnz++;
    Endwhile
    OldSp = Spalte;
    Spalte += ChrAnz;
    if (Spalte > SpMax)
    Then
      Spalte -= (SpMax+1);
      ChrAnz -= Spalte;
      Spalte = SpMax;
    Endif
    if (DState eq ExtractMel)
    Then
      if (PMStat band MesonScreen)
      Then
	memcpy (Zeichen[Zeile]+OldSp, Text, ChrAnz);
	memset (Formate[Zeile]+OldSp, VAttrib, ChrAnz);
	c = 0;  Text = (BYTE*) Zeichen[Zeile]+OldSp;
	OldAnz = ChrAnz; OldTp = Text;
	if (JPFlag and iskanjic2 (*Text))
	Then
	  Tp = Text-1;
	  for (Spdata = OldSp-1; Spdata>=0; c++,Spdata--,Tp--)
	  Begin
	    if (iskanjic (*Tp) eq 0)  break;
	  Endfor
	Endif
	if (c band 1)
	Then
	  OldSp--; ChrAnz++; Text--;
	Endif
//	if (STim eq 0) WriteText (OldSp, Zeile, (char*) Text, ChrAnz);
	WriteText (hdc, OldSp, Zeile, (char*) Text, ChrAnz);
      Endif
    Else
      memcpy (Zeichen[Zeile]+OldSp, Text, ChrAnz);
      memset (Formate[Zeile]+OldSp, VAttrib, ChrAnz);
      c = 0;  Text = (BYTE*) Zeichen[Zeile]+OldSp;
      OldAnz = ChrAnz; OldTp = Text;
      if (JPFlag and iskanjic2 (*Text))
      Then
	Tp = Text-1;
	for (Spdata = OldSp-1; Spdata>=0; c++,Spdata--,Tp--)
	Begin
	  if (iskanjic (*Tp) eq 0)  break;
	Endfor
      Endif
      if (c band 1)
      Then
	OldSp--; ChrAnz++; Text--;
      Endif
//      if (STim eq 0) WriteText (OldSp, Zeile, (char*) Text, ChrAnz);
      WriteText (hdc, OldSp, Zeile, (char*) Text, ChrAnz);
    Endif
    MeldngOut ((char*) OldTp, OldAnz);
  Endif
Endwhile
SetCaretRel (Spalte, Zeile);
ReleaseDC (hWndWTH86, hdc);
EnableCursor(1);

End


/*---------------------------------------------------------------------------*/

void    DisplayRChar()

/*F
**.* Beschreibung :
**
**      Die Funktion liest die empfangenen Zeichen aus (falls
**      vorhanden) und stellt sie auf dem Bildschirm dar.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
short	Anz;

Anz = ReadChars(DispBuf, DBLen);
if (Anz > 0)
Then
  DisplayBuf ((BYTE*) DispBuf, Anz);
Endif

End
