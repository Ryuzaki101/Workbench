/*K
**      Modul Name....: TH_DEB.C 
**
**      Funktion......: Debug-Funktionen  
**
**      Versionsdatum.: 15.09.1998
**
**      Autor.........: U. Stahl   - ABB GAT/E
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

#include    <memory.h>
#include    "wth86.h"
#include    "th_dlg.h"

//	E x t e r n a l s

extern	HANDLE	hInstWTH86;
extern	int	fht;
extern	char	Work[],FilePath[];
extern	int	Datptr;
extern	char	FileName[];
extern	WORD	State,TmpState;
extern	char	EchoBuf[];
extern	char	DispBuf[];

/*  S t r u k t u r d e f i n i t i o n e n			*/

#define	NamMax	50
#define	LMax	80

typedef
struct	SymDS	{
	char	Name[NamMax];
	WORD	Typ;
	WORD	Off;
		}SymDef	;
typedef
struct	SymVWS	{
	WORD	Typ;
	WORD	Off;
	WORD	SOff;
		}SymVW;


/* statische variablen							*/

//static	LONG	*SortSymbols,*SortOffsets;
static	WORD	SegAdr,Tanz,DebFnk;
static	char	TskNum[16],
	lastSym[NamMax];
WORD	ParamAnz;
HANDLE	SymHd;

static	int	GetSymbol (WORD, SymDef *);
static	int	GetParaDes (char *, SymDef *);
static	short	GenBef1 (char*, char*, char*, char*);
static	short	GenBef2 (char*);
static	short	GenBef3 (char*, char*, char*, char*);


/*-------------------------------------------------------------------------*/

BOOL    InputText (HWND hWnd)
 
Begin
FARPROC fproc;
BOOL	ok;

fproc = MakePrgInst (TextInput, hInstWTH86);
ok = DialogBox (hInstWTH86, "TEXTINPUT", hWnd, fproc);
FreePrgInst (fproc);
return (ok);

End

/*---------------------------------------------------------------------------*/

VOID    DiaTextin_F (HWND hWnd)

/*F
**.* Beschreibung :
**
**      Die Funktion fuehrt den Dialog fuer Texteingabe durch
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin

DebFnk = *GetStateStr(State);
State = NoAction;
if (InputText (hWnd))
Then
  State = GetNextState();
Else
  State = InitState(0);
Endif

End

/*-------------------------------------------------------------------------*/


static	VOID	InitDlg (HWND hDlg)

Begin
SymVW	FAR *SV;
LPSTR	LP;
HANDLE	hd;
int	i,InitCB;

InitCB = 1;
Switch (DebFnk)
  case GetVal:
  case SetVal:	GetText (fht, Work, 457);
		break;
                          
  case GetSym:	GetText (fht, Work, 456);
  		InitCB = 0;
		break;
                          
  case DispVal:	GetText (fht, Work, 458);
			  break;
                          
Endswitch
	                
/* Don't let user type more than n bytes in edit ctl.  */
SendDlgItemMessage(hDlg, IDTEXTIN, EM_LIMITTEXT,  WorkSize, 0L);
SetWindowText(hDlg, Work);
    
GetText (fht, Work, 300);
SetDlgItemText( hDlg, IDOK, Work );
GetText (fht, Work, 303);
SetDlgItemText( hDlg, IDMHLP, Work );
GetText (fht, Work, 301);
SetDlgItemText( hDlg, IDCANCEL, Work );

if (InitCB)
Then
  hd = GetDlgItem (hDlg, IDTEXTIN);
  LP = (LPSTR) GlobalLock (SymHd); SV = (SymVW FAR *) LP;
  for (i=0; i<ParamAnz; i++,SV++)
  Begin
    SendMsg (hd, CB_INSERTSTRING, -1, LP + SV->SOff);
  Endfor
  GlobalUnlock (SymHd);
  if (strlen(lastSym))
  Then
    i = (int) SendMsg (hd, CB_FINDSTRING, -1, lastSym);
  Else
    i = 0;
  Endif
  if (i >= 0)  SendMessage (hd, CB_SETCURSEL, i, 0l);
Endif

End


/*-------------------------------------------------------------------------*/


BOOL    PASCAL _export
TextInput (HWND hDlg, WORD msg, WORD wParam, LONG lParam)

/*F
**.* Beschreibung :
**
**      Die Funktion bedient die Dialogbox zum abfragen eines Textes.
**
**.* Funktionswerte :
**
**      TRUE    -    Die Message wurde von der Routine verarbeitet
**      FALSE   -    Die Message wurde nicht bearbeitet
**      Wenn TRUE:   Text in Work
*/

Begin

Switch (msg)

  case WM_INITDIALOG:	InitDlg (hDlg);
			break;

  case WM_COMMAND:
        Switch ( wParam )

           case IDOK:   /* Button OK ==> Laden */

			If ( IsWindowEnabled(GetDlgItem(hDlg, IDOK) ) )
			Then
			  GetDlgItemText(hDlg, IDTEXTIN, Work, WorkSize-1);
			  strcpy (lastSym, Work); EndDialog (hDlg, TRUE);
                        Endif
	                break;

           case IDCANCEL :
                        /* User pressed cancel.  Just take down dialog box. */
               EndDialog(hDlg,  FALSE );
               break;


           case IDTEXTIN:/*   If ( HIWORD(lParam)  eq EN_CHANGE )
			    Then
			      EnableWindow( GetDlgItem(hDlg, IDOK),
			    (BOOL) SendMessage(GetDlgItem(hDlg, IDTEXTIN),
                                    WM_GETTEXTLENGTH, 0, 0L ) );
			    Endif
			    */
			    break;

           default:
               return(FALSE);
        Endswitch

  default:	return FALSE;
Endswitch
return(TRUE);

End

/******************************************************************************/


static	int	GetSymbol (WORD Offset, SymDef *Sym)

/*F
**.* Beschreibung :
**
**	Die Funktion liefert zu dem uebergebenen Offset das entsprechende
**	Symbol. Falls der Wert nicht gefunden wird NULL zurueckgegeben.
**
**.* Funktionswerte :
**
**	1 wenn Offset gefunden, sonst 0
**
*/
 
Begin
SymVW	FAR *SV;
int	ok,i;
LPSTR	LP;
WORD	hw;

ok = 0;
LP = (LPSTR) GlobalLock (SymHd);
SV = (SymVW FAR *) LP;

for (i=0; i<ParamAnz; i++,SV++)
Begin
  if (SV->Off eq Offset)
  Then
    LP = LP + SV->SOff; hw = strlen(LP)+1;
    memcpy (Sym->Name, LP, min(hw,NamMax));
    Sym->Name[NamMax] = 0; Sym->Typ = SV->Typ;
    Sym->Off = SV->Off;  ok++; break;
  Endif
Endfor
GlobalUnlock (SymHd);
return (ok);

End



/******************************************************************************/


static	int	GetParaDes(LPSTR Str, SymDef *Sym)

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
*/
 
Begin
SymVW	FAR *SV;
short	Ve;
WORD	A,B,i,ia;
int	ok;
LPSTR	LPi,LP;

ok = 0;
LPi = (LPSTR) GlobalLock (SymHd);
SV  = (SymVW FAR *) LPi;

if (ParamAnz eq 1)
Then
  LP = LPi + SV->SOff; i = strlen(LP)+1;
  memcpy (Sym->Name, LP, min(i,NamMax));
  Sym->Name[NamMax] = 0; Sym->Typ = SV->Typ;
  Sym->Off = SV->Off;  ok++;  goto GetSdEx;
Endif
A = 0;	B = ParamAnz;
ia = 0;  i = (A + B) >>1;

while ( i!=ia )
Begin
  SV = (SymVW FAR *) LPi + i;
  LP = LPi + SV->SOff;
  Ve = strcmp(Str, LP);
  if (Ve eq 0)
  Then
    memcpy (Sym->Name, LP, min(strlen(LP)+1,NamMax));
    Sym->Name[NamMax] = 0; Sym->Typ = SV->Typ;
    Sym->Off = SV->Off;  ok++;  goto GetSdEx;
  Endif
  if (Ve  > 0)
  Then
    A = i;
  Else
    B = i;
  Endif
  ia = i;
  i = (A + B) >>1;
Endwhile

GetSdEx:
GlobalUnlock (SymHd);
return (ok);

End


/******************************************************************************/

 
BOOL    GetDebugFile()

/*F
**.* Beschreibung :
**
**	Die Funktion liest die Debugdatei in den Speicher
**
**.* Funktionswerte :
**
**	TRUE oder FALSE
*/
 
Begin
SymVW	FAR *SV;
char	*P;
WORD	i,SOff;
BOOL	ok;
char	LineBuf[LMax];
DWORD	SLen;
LPSTR	LPi;
int	fp;

ok = FALSE; FreeMem (&SymHd);
ParamAnz = 0;
if (openFile ("rb", NULL) eq FALSE)
Then
  goto GetErr;
Endif
fp = Datptr;
_Ffgets (LineBuf, LMax, fp);
P = strtok (LineBuf, " \t\r\n");
SLen = Tanz = 0;
While ( P )
Begin
  TskNum[Tanz++] = atoi(P);;
  P = strtok (NULL, " \t\r\n");
Endwhile

_Ffgets (LineBuf, LMax, fp);
P = strtok (LineBuf, " ");
sscanf (P, "%X", &SegAdr);
P = strtok (NULL, " ");
ParamAnz = atoi(P);

if (SegAdr eq 0 and ParamAnz eq 0)
Then
  OkMessage (455, FileName);
  goto GetErr;
Endif

_Ffgets (LineBuf, LMax, fp);
if (strstr(LineBuf, "SORTSYM") ne LineBuf)
Then
  OkMessage (455, FileName);
  goto GetErr;
Endif

for (i=0; i<ParamAnz; i++)
Begin
  _Ffgets (LineBuf, LMax, fp);
  strtok (LineBuf, " \t\r\n");	// Offset
  strtok (NULL, " \t\r\n");		// Typ
  P = strtok (NULL, " \t\r\n");		// Symbol
  SLen = SLen + strlen(P) + 1;
Endfor

_Ffgets (LineBuf, LMax, fp);
if (strstr(LineBuf, "SORTOFF") ne LineBuf)
Then
  OkMessage (455, FileName);
  goto GetErr;
Endif
SOff = ParamAnz * sizeof(SymVW);
SLen = SLen + SOff;
SymHd = GlobalAlloc (GMEM_MOVEABLE, SLen);
if (SymHd eq 0)
Then
  OkMessage (437, NULL);
  goto GetErr;
Endif
LPi = (LPSTR) GlobalLock (SymHd);
SV = (SymVW FAR *) LPi;
_FRewind(fp);
_Ffgets (LineBuf, LMax, fp);
_Ffgets (LineBuf, LMax, fp);
_Ffgets (LineBuf, LMax, fp);
for (i=0; i<ParamAnz; i++,SV++)
Begin
  _Ffgets (LineBuf, LMax, fp);
  P = strtok (LineBuf, " \t\r\n");	// Offset
  SV->Off = atoh(P);
  P = strtok (NULL, " \t\r\n");		// Typ
  SV->Typ = (WORD) *P;
  P = strtok (NULL, " \t\r\n");		// Symbol
  strcpy (LPi+SOff, P);
  SV->SOff = SOff;
  SOff = SOff + strlen(P) + 1;
Endfor
GlobalUnlock (SymHd);
ok = TRUE;
goto GetDebEx;

GetErr:
ParamAnz = 0;
FreeMem (&SymHd);

GetDebEx:
return (ok);

End



/******************************************************************************/

 
static	short	GenBef1 (LPSTR Bf, LPSTR Sb, LPSTR Disp, LPSTR Echo)

/*F
**.* Beschreibung :
**
**	Die Funktion kopiert das in Work stehende Symbol nach Sb und
**	ergaenzt den Monitorbefehl in Bf.
**
**.* Funktionswerte :
**
**	0 wenn Zugriff ok, sonst 1
**
*/
 
Begin
SymDef	Sym;
int	ok;
char	*P;

strcpy (Work, lastSym);
strcpy (Sb, Work);
ok = GetParaDes (Work, &Sym);
if (ok)
Then
  P = Bf + strlen (Bf);
  *P++ = (char) Sym.Typ;
  wsprintf (Echo, "%X:", SegAdr);
  wsprintf (P, "%X:%X", SegAdr, Sym.Off);
//  wsprintf (Disp, "\015%s\015\012%X:", (LPSTR) Sb, SegAdr);
  wsprintf (Disp, "\r\n%s\r\n", Sb);
  return (0);
Else
  *Disp = 0;
  return (1);
Endif

End



/******************************************************************************/


static	short	GenBef2 (LPSTR Sb)

/*F
**.* Beschreibung :
**
**	Die Funktion kopiert das dem Offset entsprechende Symbol nach Sb
**	bzw. falls nicht gefunden den Offset.
**
**.* Funktionswerte :
**
**	3 wenn Zugriff ok, sonst 1
**
*/
 
Begin
SymDef	Sym;
int	Off,ok;

strcpy (Work, lastSym);
strcpy (Sb, Work);
sscanf (Work, "%X", &Off);
ok = GetSymbol(Off, &Sym);
if (ok)
Then
  strcpy (Sb, Sym.Name);
  return (3);
Else
  return (1);
Endif
 
End



/******************************************************************************/

 
static	short	GenBef3 (LPSTR Bf, LPSTR Sb, LPSTR Disp, LPSTR Echo)

/*F
**.* Beschreibung :
**
**	Die Funktion kopiert nicht gefundene Symbole nach Sb und
**	ergaenzt den Monitorbefehl in Bf.
**
**.* Funktionswerte :
**
**	0 wenn Zugriff ok, sonst 1
**
*/

Begin
char	*token;
SymDef	Sym;
short	Tp;
char	*P,hs[20];
int	n,first=1;

*Disp++ = Cr;  *Disp = 0;
strcpy (Work, lastSym);
token = strtok (Work, " ,");
While (token)
Begin
  if (GetParaDes (token, &Sym))
  Then
    P = Bf + strlen (Bf);
    if (first)
    Then
      wsprintf (Echo, "%X:", SegAdr);
      Tp = Sym.Typ;
      *P++ = (char) Tp;
      first = 0;
    Else
      if (Tp ne Sym.Typ)
      Then
        return (2);
      Endif
    Endif
    wsprintf (P, "%X:%X", SegAdr, Sym.Off);
    n = 12 - strlen (token);  if (n < 0)    n = 0;
    strncat (Disp, token, 12);  n++;
    memset (hs, ' ', n);  hs[n] = 0;
    strcat (Disp, hs);
    token = strtok (NULL, " ,");
    if (token)
    Then
      strcat (Bf, ",");
    Endif
  Else
    strcpy (Sb, token);
    return (1);
  Endif
Endwhile

strcat (Disp, "\015\012");
strcat (Disp, Echo);
return (0);
 
End


/******************************************************************************/


VOID	GenDebBef_F (VOID)

/*F
**.* Beschreibung :
**
**	Die Funktion generiert den noetigen Monitorbefehl in Ab-
**	haengigkeit der angewaehlten Debugoption und der Eingabe
**	in Work.
**
**.* Funktionswerte :
**
**
*/
 
Begin
char	Bef[80],Sym[80];
short	nok=1;

State = NoAction;
Switch (DebFnk)
  case GetVal:	strcpy (Bef, "D");
		nok = GenBef1 (Bef, Sym, DispBuf, EchoBuf);
		break;

  case GetSym:	nok = GenBef2 (Sym);
		DispBuf[0] = 0;
		break;

  case DispVal:	strcpy (Bef, "A");;
		nok = GenBef3 (Bef, Sym, DispBuf, EchoBuf);
		break;

  case SetVal:	strcpy (Bef, "S");
		nok = GenBef1 (Bef, Sym, DispBuf, EchoBuf);
		break;
Endswitch

Switch (nok)
  case 1:	OkMessage (463, Sym);
		AddNextState (Display, NULL);
		break;
  case 2:	OkMessage (465, NULL);
		AddNextState (Display, NULL);
		break;
  case 3:	OkMessage (0, Sym);
		AddNextState (Display, NULL);
		break;
  default:	strcat (Bef, "\r");
  		AddNextState (SendString, Bef);
		DisplayBuf ((BYTE*) DispBuf, strlen (DispBuf));
//		if (IsTCPConnection() eq 0) AddNextState (WaitForEcho, EchoBuf);
		if (DebFnk eq GetVal or DebFnk eq SetVal)
		Then
		  AddNextState (WaitForBlCr, NULL);
		Endif
		break;
Endswitch
State = GetNextState();

End


/*---------------------------------------------------------------------------*/


VOID    WaitForBlCr_F (VOID)

/*F
**.* Beschreibung :
**
**      Die Funktion wartet auf ein Blank und macht dann ein
**	Line-Feed auf dem Bildschirm.
**
**.* Funktionswerte :
**
**      keine
**
*/
 
Begin
char	c,ready;

TmpState = State;
State = NoAction;
ready = 0;
While ( (c = GetCharComm()) ne EOF)
Begin
  if (ready)
  Then
    DisplayBuf ((BYTE*) &c, 1);
  Else
    if (c eq ' ')
    Then
      //DisplayBuf ((BYTE*) "\015\012", 2);
      ready++;
    Endif
  Endif
Endwhile
if (ready) TmpState = InitState(0);
State = TmpState;

End

/*---------------------------------------------------------------------------*/

VOID    DiaDebFile_F (HWND hWnd)

/*F
**.* Beschreibung :
**
**      Die Funktion fraegt das Debug-File ab
**
**.* Funktionswerte :
**
**      keine
**
*/

Begin
char	szGAdr[8],*P;
WORD	GerAd;

State = NoAction;
if (SelectFile(hWnd, fht, "*.d*", (LPSTR) 478, FileName, FilePath) eq FALSE)  goto Err;

if (GetDebugFile() eq FALSE)  goto Err;

/* GerAdr ermitteln	*/
P = FileName + strlen(FileName) - 2;
GerAd = atoi(P); itoa (GerAd, szGAdr, 10);
if (GerAd eq 0)
Then
  P = FilePath + strlen(FilePath) - 2;
  GerAd = atoi(P); itoa (GerAd, szGAdr, 10);
  if (GerAd)
  Then
    AddNextState (SendCHDBef, szGAdr);
  Else
    AddNextState (Display, NULL);
  Endif
Else
  AddNextState (SendCHDBef, szGAdr);
Endif
TmpState = GetNextState ();
goto Exit;

Err:
TmpState = InitState(0);

Exit:
State = TmpState;

End


