/*K
**      Modul Name....: TH_MEM.C
**
**      Modul Nummer..: F.
**
**      Funktion......: Abfrage des Speicherbereichs
**
**      Erstelldatum..: 10.09.93
**
**      Autor.........: U. Stahl   - ABB INS/GT3
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

#pragma		hdrstop

#include    	"wth86.h"
#include    	"th_dlg.h"

//	E x t e r n a l s 

extern	HANDLE	hInstWTH86;
extern	int	fht;
extern	char	Work[];
extern	WORD	State;

static	WORD	Seg,Off,Len;


/*-------------------------------------------------------------------------*/

VOID	WINAPI	DiaAskMemArea_F (HWND hWnd)
 
/*F
**.* Beschreibung :
**
**      Die Funktion fuehrt den Dialog zur Abfrage des Speicherbereichs
**      und generiert den entsprechenden Monitor-Befehl
**
**.* Funktionswerte :
**
**      TRUE	Dialog erfolgreich abgeschlossen
**	FALSE	Dialog abgebrochen
**
*/
 
Begin
FARPROC fproc;
BOOL	ret;
WORD	NState;

State = NoAction;
fproc = MakePrgInst (SelectMemArea, hInstWTH86);
ret = DialogBox (hInstWTH86, "SELMEMAREA", hWnd, fproc);
FreePrgInst (fproc);
if (ret)
Then
  wsprintf (Work, "W%X:%XL%X\015", Seg, Off, Len);
  
//  if (IsTCPConnection() eq 0)  InsertState (WaitForEcho, Work);
  InsertState (SendString, Work, 0);
  NState = GetNextState ();
Else
  NState = InitState(0);
Endif

State = NState;

End


/*-------------------------------------------------------------------------*/


BOOL    CALLBACK _export
SelectMemArea(HWND hDlg, WORD msg, WORD wP, LONG lP)

/*F
**.* Beschreibung :
**
**      Die Funktion bedient die Dialogbox zur Abfrage des Speicherbereichs
**
**.* Funktionswerte :
**
**      TRUE    -    Die Message wurde von der Routine verarbeitet
**      FALSE   -    Die Message wurde nicht bearbeitet
**      Wenn TRUE:   Seg,Off und Len enthalten die Eingaben.
*/

Begin
char	HStr[20];
WORD	hw,CMsg;
BOOL	RET;

msg = TransCCMsg(msg, wP, lP, &RET);
Switch (msg)
  case WM_INITDIALOG:
        SendDlgItemMessage(hDlg, IDSEG, EM_LIMITTEXT, 4, 0L);
        wsprintf (HStr, "%x", Seg);
        SetDlgItemText( hDlg, IDSEG, HStr);
        
        SendDlgItemMessage(hDlg, IDOFF, EM_LIMITTEXT, 4, 0L);
        wsprintf (HStr, "%x", Off);
        SetDlgItemText( hDlg, IDOFF, HStr);
        
        SendDlgItemMessage(hDlg, IDLEN, EM_LIMITTEXT, 4, 0L);
        wsprintf (HStr, "%x", Len);
        SetDlgItemText( hDlg, IDLEN, HStr);

	GetText (fht, Work, 300);
	SetDlgItemText (hDlg, IDOK, Work);
	GetText (fht, Work, 301);
	SetDlgItemText (hDlg, IDCANCEL, Work);
	GetText (fht, Work, 310);
	SetDlgItemText (hDlg, IDOFFTXT, Work);
	GetText (fht, Work, 311);
	SetDlgItemText (hDlg, IDLENTXT, Work);
	GetText (fht, Work, 312);
	SetDlgItemText (hDlg, IDSEGTXT, Work);
	GetText (fht, Work, 329);
	SetWindowText (hDlg, Work);
        break;

  case WM_CTLCOLORSTATIC:
  case WM_CTLCOLORDLG:
  case WM_CTLCOLORBTN:	break;

  case WM_COMMAND:	CMsg = NTFMsg(wP,lP);
        Switch ( wP )

	   case IDOK:	GetDlgItemText(hDlg, IDSEG, HStr, 20);
			Seg = atoh(HStr);
			GetDlgItemText(hDlg, IDOFF, HStr, 20);
			Off = atoh(HStr);
			GetDlgItemText(hDlg, IDLEN, HStr, 20);
			Len = atoh(HStr);
			EndDialog(hDlg, TRUE);
			break;

         case IDCANCEL:	EndDialog(hDlg,  FALSE );
			break;

         case IDLEN:	if (CMsg ne EN_CHANGE)  break;
			GetDlgItemText(hDlg, IDLEN, HStr, 20);
			hw = atoh(HStr);
			EnableWindow( GetDlgItem(hDlg, IDOK), hw);
			break;

           default:	return(FALSE);
        Endswitch
	break;
  default:	RET = FALSE;
Endswitch
return(RET);

End
 