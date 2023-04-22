/*K
**      Modul Name....: TH_TEST.C
**
**      Funktion......: Testfunktionen
**
**      Versionsdatum.: 05.05.2003
**
**      Autor.........: U. Stahl   - ABB LCD/E
**
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

#include        "th_dlg.h"
#include        "wth86.h"


extern  HANDLE  hInstWTH86;
extern  HWND    hWndWTH86;
extern  int	fht;
extern  char    Work[];
extern  LPCSTR  AppName;
extern  DWORD   State,TmpState;

static	int	cancel;
static	HANDLE	HTh;
static	DWORD	IdTh;

//**************************************************************************


DWORD	WINAPI TestThread (LPVOID Val)

Begin
static
WORD	Cnt;
LPDWORD	pdw;

if (Val)
Then
  pdw = (LPDWORD) Val;
  wsprintf (Work,"Theaed-Value %d", *pdw);
  DbgStr (Work);
Endif

While(cancel eq 0)
Begin
  wsprintf (Work,"Theaed-Message %d", ++Cnt);
  DbgStr (Work);
  Sleep (300);
Endwhile
return 0;

End

/*****************************************************************/

VOID	WINAPI	TestFnk (HWND hWnd)

Begin
/*
NETRESOURCE  NR,*PNR;
WSAQUERYSET	QS;
WSADATA		DA;
SOCKET	S;
SOCKADDR_IN  SA;
*/
char	HStr[90];
HANDLE	Hd;
int	hi;
WORD	hw,n,i;
DWORD	Flags,hdw,hd2,Size;
LPSTR	LP,LPi;
int	fh;

/*
cancel = 0;  hdw = 123456789;
HTh = CreateThread (NULL, 20, TestThread, &hdw, 0, &IdTh);
if (HTh eq NULL)
Then
  DispLastError (hWndWTH86, "CreateThread");
Endif
Sleep (7000);
cancel++;
Repeat
  hi = GetExitCodeThread (HTh, &hdw);
  if (hi eq 0)  break;
  if (hdw eq STILL_ACTIVE)
  Then
    DbgStr ("still active");
    if (hw)
    Then
      DbgStr ("Thread canceld");
      // führt zum Crash
      ExitThread(0);  hw = 0;
    Endif
  Endif
  Sleep (10);
  CheckMessage();
Until (hdw ne STILL_ACTIVE);
*/


// Absturtz
//strcpy (NULL, "");

/*
AddNextState (SetModulNr, "2");
AddNextState (GetModTyp, NULL);
AddNextStat2 (RTextOut, NULL, 1);

AddNextState (GetEEData, NULL);
AddNextStat2 (RTextOut, NULL, 0);
AddNextState (SetModulNr, "5");
AddNextState (GetModTyp, NULL);
AddNextStat2 (RTextOut, NULL, 1);
*/
State = GetNextState();

/*
AddNextState (SendString, "CD\015");
AddNextStat2 (StoreUntilP, NULL, 1);
AddNextState (RTextOut, NULL);
State = GetNextState();
*/

/*
for (i=1; i<=10; i++)
Begin
  wsprintf (HStr, "Dies ist die %d. Testmessage", i);
  MessageWin (hWndWTH86, HStr, "Caption", MB_BEEP);
  CheckMessage();  Sleep (500);
Endfor
*/

/*
CreateDspWin ("", 0);  n = 1;
While (1)
Begin

for (i=1; i<=4; i++)
Begin
  wsprintf (HStr, "Eintrag %d", i);
  if (i ) //band 1)
  Then
    AddNextState (WaitForString, HStr);
  Else
    InsertState (WaitForString, HStr, 0);
  Endif
Endfor

for (i=1; i<=4; i++)
Begin
  State = NoAction;
  TmpState = GetNextState();
  LP = GetStateStr (TmpState);
  wsprintf (Work, "Nr. %d,   %s", n++, LP);
  SetWindowText (hWndWTH86, Work);
  Sleep (1000);  State = TmpState;
Endfor

Endwhile
*/

/*
LP = (LPSTR) AllocPtr(512);
LPi = (LPSTR) AllocPtr(512);
memset (LPi, '1', 514);
Free_Ptr(&LPi);
Free_Ptr(&LP);
DispLastError (hWnd, "Free");
*/

/*
NextComDev (NULL);
While (NextComDev(HStr))
Begin
  MessageBox (hWnd, HStr, "Device", 0);
Endwhile
*/

/*
hdw = 16384;  LP = LPi = (LPSTR) AllocPtr(hdw);
hdw = QueryDosDevice(NULL, LP, hdw);
if (hdw)
Then
  While (*LP)
  Begin
    MessageBox (hWnd, LP, "Devices", 0);
    LP = LP + strlen(LP) + 1;
  Endwhile
Else
  DispLastError (hWnd, "QueryDosDevice");
Endif
FreePtr(&LPi);
*/



//DialogBox (hInstWTH86, "SELECTHOST", hWnd, (DLGPROC) DlgSelHost);

/*
CreateDspWin ("Hello World");
SetActionText ("transmitted bytes");
IncCount("123456789012");
*/



//  TestSocket
/*
hw = MAKEWORD(2,0);
hi = WSAStartup (hw, &DA);
if (hi)
Then
  WSA_Error (hWnd, "Startup");  goto Exit;
Endif


// Socket öffnen
S = socket (AF_INET, SOCK_STREAM, 0);
if (S eq INVALID_SOCKET)
Then
  WSA_Error (hWnd, "Open Socket");  goto Exit;
Endif


memset (&SA, 0, sizeof(SA));
SA.sin_family = AF_INET;
SA.sin_port = htons (7);
SA.sin_addr.S_un.S_addr = inet_addr("10.49.41.229");
hi = connect(S, (SOCKADDR*)&SA, sizeof(SA));
if (hi eq SOCKET_ERROR)
Then
  WSA_Error (hWnd, "Connect");  goto Exit;
Endif


hi = recv (S, Work, 500, 0);
MessageBox (hWnd, Work, "", 0);

Exit:
if (S ne INVALID_SOCKET)
Then
  closesocket(S);
Endif
WSACleanup();
*/


/*
memset (&QS, 0, sizeof(WSAQUERYSET));
QS.dwSize = sizeof(WSAQUERYSET);
Flags = LUP_RETURN_ALL;
hi = WSALookupServiceBegin (&QS, Flags, &Hd);
if (hi)
Then
  hi = WSAGetLastError (); WSASetLastError (0);
  itoa (hi, HStr, 10);
  MessageBox (hWnd, HStr, "lastError", MB_INFO);
  goto Exit;
Endif

hdw = sizeof (WSAQUERYSET);
While (1)
Begin
  hi = WSALookupServiceNext (Hd, Flags, &hdw, &QS);
  if (hi)  break;
Endwhile
WSALookupServiceEnd (Hd);
*/


/*
// Jump without warning
strcpy (HStr, "");
if (HStr[0] eq 0)  goto Exit;

hdw = RESOURCE_GLOBALNET; hd2 = RESOURCETYPE_ANY;
hdw = WNetOpenEnum (hdw, hd2, 0, NULL, &Hd);
if (hdw) goto Exit;


Size = 0x8000;
PNR = AllocPtr (Size);
if (PNR eq NULL)  goto Exit;

hd2 = -1;
hdw = WNetEnumResource (Hd, &hd2, PNR, &Size);
if (hdw eq 0)
Then
  memcpy (&NR, PNR, sizeof(NETRESOURCE));
  WNetCloseEnum (Hd);
  hdw = RESOURCE_GLOBALNET; hd2 = RESOURCETYPE_ANY;
  hdw = WNetOpenEnum (hdw, hd2, 0, &NR, &Hd);
  if (hdw eq 0)
  Then
    hd2 = -1;
    WNetEnumResource (Hd, &hd2, PNR, &Size);
  Endif
Else
  DispLastError (hWnd, "NetEnumResource");
Endif


WNetCloseEnum (Hd);
Free_Ptr (&PNR);
*/

/*
hw = GetVersion();
wsprintf (HStr, "Windows %d.%d", LOBYTE(hw), HIBYTE(hw));
MessageBox (hWnd, HStr, "Version", MB_INFO);
*/

return;

End


