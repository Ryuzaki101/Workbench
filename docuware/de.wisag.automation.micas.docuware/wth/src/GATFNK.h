
#ifndef	__INSFNK_H
#define	__INSFNK_H


#include	<stdio.h>
#include	<math.h>
#include	<ddeml.h>
#include	<commctrl.h>

#define	V_INSFNK_DLL	"V4.00"
// Grenze zwischen File- und Memory Handle

#ifndef max
#define max(a,b) a>b?a:b
#endif
#ifndef min
#define min(a,b) a<b?a:b
#endif

#define	FD_MAX		10
#define	MB_ASK		MB_ICONQUESTION
#define	MB_INFO		MB_ICONINFORMATION
#define	MB_BEEP		0x80000000L
#define	MB_MODELESS	0x40000000L
#define DDE_TIMEOUT     20000

#define	MsgBox(h,s)	MessageBox(h,s,"",MB_INFO)

#define	OF_CRCOMP	4	// create in Compressed mode
#define	OF_DELONCLOSE	5	// delete on close

typedef	void _huge	*HPVOID;
typedef	long _huge	*HPLONG;
typedef	char _huge	*LPHUGE;
typedef	BYTE _huge*	BPHUGE;
typedef short far	*LPSHRT;
typedef	LPSTR far	*LPPSTR;
typedef	LPBYTE far	*LPPBYTE;
typedef	LPWORD far	*LPPWORD;
//typedef	LPDWORD far	*LPPDWORD;
typedef	LPVOID far	*LPPVOID;
typedef BOOL  far	*LPBOOL;
typedef COLORREF far	*PCOLREF;
typedef	int (FAR * CMPFNK) (HPVOID, HPVOID);

#define	SetCtlFocus(D,I)	PostMessage (D, WM_NEXTDLGCTL, (UINT) GetDlgItem(D,I), I)
#define GetWinStyle(hwnd)	((DWORD)GetWindowLong(hwnd, GWL_STYLE))
#define SetWinStyle(hw,V)	SetWindowLong(hw, GWL_STYLE, V)
#define GetWinProc(hw)		((FARPROC)GetWindowLong(hw, GWL_WNDPROC))
#define SetWinProc(hw,Prg)	SetWindowLong(hw, GWL_WNDPROC, (LONG) Prg)
#define SendMsg(w,m,wp,lp)	SendMessage((HWND)w,m,(WPARAM)wp,(LPARAM)lp)
#define SendIMsg(w,i,m,wp,lp)	SendDlgItemMessage((HWND)w,i,m,(WPARAM)wp,(LPARAM)lp)
#define	SetPrp(w,s,h)		SetProp(w,s,(HANDLE)(h))
#define	GetLibFunctions(s,f)	GetLibFnk2(s,f,1)
#define	PostMsg(w,m,wP,lP)	PostMessage((HWND)w,m,(WPARAM)wP,(LPARAM)lP)
#define	SetWndLong(w,i,v)	SetWindowLong (w, i, (LONG) v)
#define	GetWndLong(w,i)		GetWindowLong (w, i)
#define	GetPPStr(Se,En,Df,Str,Len,Fil)  GetPrivateProfileString (Se,En,Df,Str,Len,Fil)
#define	GetPPInt(Se,En,Df,Fil)  GetPrivateProfileInt (Se,En,Df,Fil)
#define	PutPPStr(Se,En,Str,Fil)	WritePrivateProfileString (Se,En,Str,Fil)
#define	GetItmTxt(h,i,s,l)	GetDlgItemText(h,i,s,l)
#define	SetItmTxt(h,i,s)	SetDlgItemText(h,i,s)

#ifdef WIN32

#define GetWinInst(w)		((HMODULE)GetWindowLong((HWND)w,GWL_HINSTANCE))
#define GetWinId(w)		((WORD)GetWindowLong((HWND)w,GWL_ID))
#define	GlobalHnd(p)		GlobalHandle(p)
#define	SetLPrp(w,s,h)		SetProp(w,s,(HANDLE)h)
//	Command-Parameter
#define	NTFMsg(wP,lP)		HIWORD(wP)
#define	CMDId(wP)		LOWORD(wP)
#define	CMDwd(lP)		(HWND)(lP)
#define	MAKEwP(id,nf)		MAKELONG(id,nf)
#define	MAKElP(hw,nf)		(LONG)hw
#define	CMDMsg(D,hw,nf)		if (IsWindow((HWND)hw)) PostMsg(D,WM_COMMAND,MAKELONG(GetWinId(hw),nf),hw); else PostMsg(D,WM_COMMAND,MAKELONG(hw,nf),0)
#define	SCMMsg(D,hw,nf)		if (IsWindow((HWND)hw)) SendMsg(D,WM_COMMAND,MAKELONG(GetWinId(hw),nf),hw); else SendMsg(D,WM_COMMAND,MAKELONG(hw,nf),0)
//	Scroll-Parameter
#define	MAKSwP(typ,pos)		MAKELONG(typ,pos)
#define	MAKSlP(hwd,pos)		((LPARAM)hwd)
#define	ScrTyp(wP)		LOWORD(wP)
#define	ScrPos(wP,lP)		HIWORD(wP)
#define	ScrHwd(lP)		(HWND)lP
#define	MenuHd(lP)		(HMENU)lP
//	sonstige
#define	MsgEM_SETSEL(hw,v,b)	SendMsg(hw, EM_SETSEL, v, b)

#define	GetCurrentTask		GetCurrentProcess
#define	WM_CTLCOLOR		0x0019
#define	MakePrgInst(P,I)	((FARPROC)P)
#define	FreePrgInst(P)		
#define	GetPrp(w,s)		(DWORD)GetProp(w,s)
#define	GetModuleUsage(h)	(1)		

#define	GetAppWindow()	(GetTaskWindow((HANDLE)GetCurrentThreadId()))

#else

#define GetWinInst(w)		((HANDLE)GetWindowWord((HWND)w,GWW_HINSTANCE))
#define GetWinId(w)		(GetWindowWord((HWND)w,GWW_ID))
#define	GlobalHnd(p)		LOWORD(GlobalHandle(HIWORD(p)))
#define	SetLPrp(w,s,h)		SetLProp(w,s,(LONG)h)
//	Command-Parameter
#define	NTFMsg(wP,lP)		HIWORD(lP)
#define	CMDId(wP)		(wP)
#define	CMDwd(lP)		(HWND)LOWORD(lP)
#define	CMDMsg(D,hw,nf)		if (IsWindow((HWND)hw)) PostMsg(D,WM_COMMAND,GetWinId(hw),MAKELONG(hw,nf)); else PostMsg(D,WM_COMMAND,hw,MAKELONG(0,nf))
#define	MAKEwP(id,nf)		(id)
#define	MAKElP(hw,nf)		MAKELONG(hw,nf)
//	Scroll-Parameter
#define	MAKSwP(typ,pos)		(typ)
#define	MAKSlP(hwd,pos)		MAKELONG(pos,hwd)
#define	ScrTyp(wP)		(wP)
#define	ScrPos(wP,lP)		LOWORD(lP)
#define	ScrHwd(lP)		HIWORD(lP)
#define	MenuHd(lP)		(HMENU)HIWORD(lP)
//	sonstige
#define	MsgEM_SETSEL(hw,v,b)	SendMsg(hw, EM_SETSEL, 0, MAKELONG(v,b))

#define	MakePrgInst(P,I)	MakeProcInstance((FARPROC)P,I)
#define	FreePrgInst(P)		if (P) FreeProcInstance((FARPROC)P)
#define	GetPrp(w,s)		(WORD)GetProp(w,s)

//	siehe	windowsx.h
#define WM_CTLCOLORMSGBOX               0x0132
#define WM_CTLCOLOREDIT                 0x0133
#define WM_CTLCOLORLISTBOX              0x0134
#define WM_CTLCOLORBTN                  0x0135
#define WM_CTLCOLORDLG                  0x0136
#define WM_CTLCOLORSCROLLBAR            0x0137
#define WM_CTLCOLORSTATIC               0x0138

VOID	WINAPI lmemmove (HPVOID, HPVOID, DWORD);

#define	GetAppWindow()	(GetTaskWindow(GetCurrentTask()))

#endif



#define	MesWnd	GetActiveWindow()


#define	HINSTANCE	HANDLE
#define	HGLOBAL		HANDLE



//	S t r u k t u r d e f i n i t i o n e n

typedef	VOID	(CALLBACK FAR * TRGFNK) (VOID);
typedef	struct	KTriggS	{
	LPSTR	KStr;
	TRGFNK	TFnk;
	LPSTR	Doku;
	WORD	MesId;
	LPSTR	KPos;
	}TRIGDS;
typedef	TRIGDS	FAR *LPTRIG;
#define	WM_KTRIGGER	(WM_USER+0)
#define	WM_RBUTTONCHILD	(WM_USER+1)
#define	WM_RBUPCHILD	(WM_USER+2)
#define	TB_SETITEMS	(WM_USER+1)
#define	TB_GETSEL	(WM_USER+2)
#define	WM_TBFOCUS	(WM_USER+3)
#define	TC_DYSIZE	28

typedef	struct	TskTriggS {
	HWND	hWnd;
	LPTRIG	TrgDat;
	}TSKTRG;

typedef	struct	MenuS	{
	WORD	Id;
	WORD	Flags;
	DWORD	Tnum;
struct	MenuS	FAR *Popup;
	HANDLE	hmenu;
	WORD	Tnum2;
	}MDESC;
typedef	MDESC	FAR *PMDESC;

typedef	struct	SCMenuS	{
	WORD	Id;
	WORD	Flags;
	WORD	Tnum;
	WORD	Old;	// Old Id
	short	Offset;	// only for insert parameter
	}SMDESC;

#ifndef	S_LIBFTAB
typedef	struct	{
	FARPROC	FAR *PFnk;
	LPSTR	FNam;
	}LIBFTAB;
#define	S_LIBFTAB
#endif

typedef	struct	{
WORD	Seg;
WORD	Off;
WORD	Len;
LONG	ROff;
}SEGHDR;

typedef	SEGHDR FAR *LPSEGHD;


// Statbar paint helper structure
typedef struct {
    int         dyStatbar;		// Status Bar height
    int         dxStatus;		// Width reserved for Status Info
    int		nMenuID;
    HFONT       hFontStatbar;		// Font used in status bar
    HFONT	FOld;
    HWND	hwStatBar;
    HWND	hwStatTxt;
    char	szStatBarText[256];
    }STBS;
typedef	STBS	FAR *LPSTBS;


typedef	VOID WINAPI (FAR * DLGINIT) (HWND, LPWORD);
typedef	VOID WINAPI (FAR * DLGEXIT) (HWND);

//	Tabcontrol
typedef	struct	{
	WORD	TNr;	// Textnummer Register
	LPSTR	Res;	// Resource-Name
	LPWORD	Texte;
	DLGINIT	IFnk;
	DLGEXIT	EFnk;
	}TBDATA;
typedef	TBDATA FAR *LPTDAT;

typedef	struct	{
	HWND	hwTDlg;
	int	fht;
	WORD	lInd;	// last Index selected
	BYTE	TAnz;	// Anzahl Register
	BYTE	NDes;	// Flag no Destroy
	LPTDAT	PTD;	// Registerbeschreibung
	}TABINFO,*LPTINF;

typedef struct {
	WORD	Id;
	DWORD	Style;
	WORD	xP;
	WORD	yP;
	WORD	xS;
	WORD	yS;
	char 	Class[20];
	char	Text[80];
}ITMTMPL, *PITMTMP;


#define	FGiMax		12
#define	FGeMax		16
#define	Nichts		0
#define ZiffSt		1
#define	BukSt		2

#define	Garnix	1	// Keine Eingabe zulaessig
#define	Ziffer	2	// Ziffer        zulaessig
#define	Buchst	3	// Buchstabe	 zulaessig


#ifdef	__cplusplus
extern	"C"
{
#endif

LPSTR	WINAPI Dezcb (LPSTR String, WORD Value, WORD Cnt);
VOID	WINAPI Octcb (LPSTR, WORD);
BYTE	WINAPI Hexcb (LPSTR, BYTE);
BYTE	WINAPI Hexcw (LPSTR, WORD);
WORD	WINAPI HexIntel (int, WORD, WORD, LPVOID, WORD);
WORD	WINAPI HexIntel2 (int, WORD, WORD, LPVOID, WORD, WORD);
VOID	WINAPI HexIntel3 (int fh, WORD Off, LPVOID Data, WORD N);
int	WINAPI OpenTextFile (LPSTR);
int	WINAPI OpenTxtFile2 (LPSTR, WORD);
LPSTR	WINAPI GetText (int, LPSTR, WORD);
WORD	WINAPI GetTextLen (int, WORD);
LPSTR	WINAPI AppendText (int, LPSTR, WORD);
VOID	WINAPI DumpMem (LPSTR, LPSTR, WORD);
int	WINAPI SelectFile (HWND, int, LPSTR, LPSTR, LPSTR, LPSTR);
int	WINAPI SelectFiles (HWND, int, LPSTR, LPSTR, LPSTR, LPSTR);
int	WINAPI SelectFile2 (HWND, int, LPSTR, LPSTR, LPSTR, LPSTR);
LPSTR	WINAPI AddFType (LPSTR String, LPSTR FileType, LPSTR Extention);
int	WINAPI latoi(LPSTR);
VOID	WINAPI _fqsort (LPVOID, WORD, WORD, CMPFNK);
BOOL	WINAPI EnableKBHook (BOOL, HWND);
BOOL	WINAPI AboutBox (HWND, LPSTR, LPSTR, LPSTR, LPSTR, LPSTR);
BOOL	WINAPI AboutBox2 (HWND, int, LPSTR, LPSTR, LPSTR, LPSTR, LPSTR, DWORD);
BOOL	WINAPI SelectDir2 (HWND hWnd, LPSTR iDir, LPSTR dir, LPSTR tcap, WORD New);
BOOL	WINAPI SelectDir (HWND, int, LPSTR, LPSTR);
VOID	WINAPI SetBit (LPBYTE, DWORD, WORD);
VOID	WINAPI SetBits (LPBYTE, DWORD, DWORD, WORD);
BYTE	WINAPI GetBit (LPBYTE, DWORD);
DWORD	WINAPI GetBits (LPBYTE, DWORD, DWORD, LPBYTE, LPDWORD);
int	WINAPI GetCurrDir (LPSTR);
int	WINAPI SetCurrDir (LPSTR);
int	WINAPI MakeDir (LPSTR);
int	WINAPI DeleteDir (LPSTR);
LPVOID	WINAPI ReadVersInfo (LPSTR File, LPPSTR Company, LPPSTR Vers);

int	WINAPI	_FOpen (LPSTR, WORD);
VOID	WINAPI	_FClose (int);
LONG	WINAPI	_FSize (int);
LONG	WINAPI	_FTell (int);
LONG	WINAPI	_FSetEnd (int);
LONG	WINAPI	_FSeek (int, LONG, int);
VOID	WINAPI	_FRewind (int);
DWORD	WINAPI	_FRead (int, LPVOID, DWORD);
DWORD	WINAPI	_FWrite (int, LPSTR, DWORD);
DWORD	WINAPI	_FReadFP (int, LPVOID, DWORD, DWORD);
DWORD	WINAPI	_FWriteFP (int, LPVOID, DWORD, DWORD);
int	WINAPI	_Ffgets (LPSTR, WORD, int);
int	WINAPI	_Ffeof (int);

short	WINAPI isnotEmpty (LPSTR);
VOID		WINAPI TV_BaseInit (HWND, LPPSTR);
HIMAGELIST	WINAPI BuildImgList (HWND, LPPSTR);
HTREEITEM 	WINAPI TV_AddItem (HWND, LPSTR, HTREEITEM, HTREEITEM, LPVOID);
VOID	WINAPI	TV_GetPrjLst (HWND, LPSTR, LPSTR, LPSTR);
VOID	WINAPI	TV_GetBakLst (HWND, LPSTR, LPSTR, LPSTR);
LPSTR	WINAPI GetDirList (LPSTR, LPSTR);
LPSTR	WINAPI GetFileList (LPSTR, WORD, LPWORD);
LPPSTR	WINAPI GetFileLis2 (LPSTR path, WORD Attr, LPWORD Cnt);
LPPSTR	WINAPI StrLst2Array (LPSTR, WORD);
VOID	WINAPI FillListBox (HWND, WORD, LPPSTR, WORD, WORD);
short	WINAPI GetCbText (HWND, WORD, LPSTR);
short	WINAPI SetCbText (HWND, WORD, LPSTR);
short	WINAPI SetCbTxt2 (HWND, WORD, LPSTR);
short	WINAPI ChangeCbText (HWND, WORD, LONG, LPSTR);
short	WINAPI ChangeCbTxt2 (HWND, WORD, LONG, LPSTR, LPVOID);
short	WINAPI ChangeLBText (HWND, WORD, LONG, LPSTR);
BOOL	WINAPI CheckRPtr (LPVOID, LPSTR, WORD, DWORD);
BOOL	WINAPI CheckWPtr (LPVOID, LPSTR, WORD, DWORD);
HWND	WINAPI GetControlRect (HWND, WORD, LPRECT);
HWND	WINAPI GetCHWndRect (HWND, LPRECT);
int	WINAPI DiskFree (WORD, DWORD);
DWORD	WINAPI Disk_free (LPSTR, LPLONG);
DWORD	WINAPI atoh (LPSTR);
HANDLE	WINAPI AllocMem (DWORD);
VOID 	WINAPI FreeMem (HGLOBAL FAR *);

VOID 	WINAPI FreePtr (LPVOID);
VOID 	WINAPI Free_Ptr (LPVOID);	// neue Variante
int	WINAPI IsWinNT (VOID);
int	WINAPI IsWin2K (VOID);

LPVOID	WINAPI AllocPtr (DWORD);
LPVOID	WINAPI ReallocPtr (LPVOID, DWORD);
DWORD	WINAPI PtrSize (LPVOID);
LPSTR	WINAPI INSFNKVersion (VOID);
double	WINAPI	latof (LPSTR);
VOID	WINAPI	fwtoa (LPSTR, double, short);
WORD	WINAPI latoo(LPSTR);
HANDLE	WINAPI GetItemTemplate (HANDLE, PITMTMP, LPSTR);

VOID	WINAPI ChangeDialogSize (HWND, LPSTR, BOOL);
DWORD	WINAPI GetDialogSize (HWND, LPSTR);
LONG	WINAPI GetControlPos (HWND, LPSTR, WORD);
LONG	WINAPI GetControlSize (HWND, LPSTR, WORD);
BOOL	WINAPI PerformSelect (HWND, WORD);
BOOL	WINAPI PerformSel2 (HWND, WORD);
//HWND	WINAPI CreateMainDialog (HANDLE, LPSTR, LPSTR, LPSTR, LPSTR);
VOID	WINAPI MakeSysMenu (HWND, SMDESC FAR *, SMDESC FAR *, LPWORD, int);
VOID	WINAPI MakeAppMenu (HWND, PMDESC, int);
VOID	WINAPI DispChart (HWND, WORD, LONG, LONG);
#define	GLF_MESSAGE	1
#define	GLF_RELOAD	2
#define	GLF_NOFNKMSG	4
HANDLE	WINAPI GetLibFnk2 (LPSTR, LIBFTAB FAR *, WORD);
LPSTR	WINAPI AddStrList (LPSTR, LPSTR);
HANDLE	WINAPI AddTextPtr (HANDLE, WORD, LPSTR);
HANDLE	WINAPI AddMemPtr (HANDLE, WORD, LPSTR, WORD);

typedef void PASCAL ExchgF2 (unsigned short, unsigned short);

VOID	WINAPI qsort2 (HPVOID, unsigned, unsigned, CMPFNK, ExchgF2);

VOID	WINAPI INSLibInit (VOID);
WORD	WINAPI CheckNumericEdit (HWND, WORD);
int	WINAPI IsNumeric (LPSTR Str);
WORD	WINAPI f_nan (double);
VOID	WINAPI EnableControls (HWND, LPVOID, WORD, WORD);
int	WINAPI Move_File (LPSTR, LPSTR);
VOID	WINAPI ABBLogo (HDC, int, int, int, COLORREF);
VOID	WINAPI GTELogo (HDC, int, int, int);
VOID	WINAPI WISAGLogo (HDC, int, int, int);
VOID	WINAPI lswab (LPVOID, LPVOID, WORD);
HANDLE	WINAPI BuildMsgTxt (int, WORD, LONG FAR *);
WORD	WINAPI LIMessage (int, HWND, WORD, DWORD, LPLONG, LPSTR);
WORD	WINAPI UserMessage (int, HWND, WORD, DWORD, LPSTR);
VOID	WINAPI TestLIMessage (int, HWND, WORD);
VOID	WINAPI SetCtlText (HWND, int, LPWORD);
VOID	WINAPI SetCtlTxt2 (HWND, int, LPWORD);
VOID	WINAPI SetTTipText (HWND, int, LPWORD);

BOOL	WINAPI CreateStatbar (HWND);
VOID	WINAPI SetStatbarText (HWND, LPSTR);
WORD	WINAPI GetStatbarDY (HWND);
VOID	WINAPI Delete_File (LPSTR, WORD);
VOID	WINAPI Statbar_Size (HWND);
HANDLE	WINAPI ReadHIntel (DWORD);
VOID	WINAPI SetDialogText (HWND, LPSTR);
DWORD	WINAPI DDEInit (VOID);
VOID	WINAPI DDEExit (LPDWORD);
DWORD	WINAPI DDEAppConnect (DWORD, LPSTR, LPSTR, LPSTR, HWND FAR *, WORD);
DWORD	WINAPI DDEOpenTopic (DWORD, LPSTR, LPSTR, WORD);
VOID	WINAPI DDECloseTopic (LPDWORD);
#define	SM_TXT	0x0001
#define	SM_MES	0x0002
int	WINAPI SetRemote (DWORD, DWORD, LPSTR, LPSTR, WORD);
HANDLE	WINAPI GetRemote (DWORD, DWORD, LPSTR, LPVOID, WORD, WORD);
int	WINAPI AdvRemote (DWORD, DWORD, LPSTR, WORD);
int	WINAPI PutRemote (DWORD, DWORD, LPSTR, LPVOID, WORD);
int	WINAPI AddRemote (DWORD, DWORD, LPSTR, LPSTR, WORD);
int	WINAPI ExeRemote2 (DWORD, LPSTR, WORD, WORD);
int	WINAPI ExeRemote (DWORD, LPSTR, WORD);
VOID	WINAPI SetlastDir (HWND, LPSTR);
VOID	WINAPI SetKBHook (HWND, LPTRIG);
//LRESULT	CALLBACK KBHook (int, WPARAM, LPARAM);
VOID	WINAPI ClrKBHook (HWND);
LONG	WINAPI Copy_File (LPSTR Des, LPSTR Src);
int	WINAPI Move_File (LPSTR, LPSTR);
HWND	WINAPI GetTaskWindow (HTASK);
int	WINAPI CheckStream (WORD, LPSTR, LPSTR FAR *);
DWORD	WINAPI GetTextSize(HDC, LPSTR);
VOID	WINAPI SetLProp (HWND, LPSTR, LONG);
LONG	WINAPI GetLProp (HWND, LPSTR);
VOID	WINAPI RemoveLProp (HWND, LPSTR);
UINT	WINAPI TransCCMsg (UINT, WPARAM, LPARAM, LPBOOL);
WORD	WINAPI IsWin95 (VOID);
int	WINAPI OpenLTxtFile (HANDLE, LPSTR);
VOID	WINAPI PutFileData (LPSTR, LPLONG, LPSTR);
HANDLE	WINAPI GetFileData (LPSTR, HANDLE);
VOID	WINAPI PutFileStr (LPSTR, LPSTR);
VOID	WINAPI GetFileStr (LPSTR, LPSTR);
int	WINAPI GetDate (LPSTR);
int	WINAPI GetTime (LPSTR);
HMENU	WINAPI MakePopup (PMDESC, HMENU, LPSTR, WORD, int);
short	WINAPI GetMenuPos (HMENU, WORD);
VOID	WINAPI TrackMenu (PMDESC, HWND, int);
VOID	WINAPI TrackMenu2 (HWND, HMENU);

#define	DbgStr(s)	OutputDebugString(s)
//#define	DLL_LOADFREE

HWND	WINAPI	CalcComboBox(HWND, WORD);
LONG	WINAPI	latol(LPSTR);
WORD	WINAPI	InitHostData (VOID);
WORD	WINAPI	InitHostData2 (LPSTR File);
VOID	WINAPI	ExitHostData (VOID);
VOID	WINAPI	CopyCBox (HWND, HWND);
VOID	WINAPI	CopyLBox (HWND, HWND);
VOID	WINAPI	SelectHost (HWND, WORD, LONG);
//VOID	WINAPI	SelectNet (HWND, WORD, LONG);
VOID	WINAPI	InitHostBox (HWND, WORD);
VOID	WINAPI	InitHostBox2 (HWND, WORD);
//VOID	WINAPI	InitNetBox (HWND, WORD);
LONG	WINAPI	GetHostValue (HWND, WORD);
//LONG	WINAPI	GetNetValue (HWND, WORD);
HWND	WINAPI	ExecuteProg (HWND, LPSTR, LPSTR, LPSTR, WORD);
VOID	WINAPI	Num2Host (LPSTR, LONG);
LONG	WINAPI	Host2Num (LPSTR);
BYTE	WINAPI  HZif(BYTE);
WORD	WINAPI	IsAnySubDir (LPSTR, LPSTR);
WORD	WINAPI	IsAnySubFile (LPSTR Path, LPSTR Str);
LPSTR	WINAPI	dircpy (LPSTR, LPSTR);
LPSTR	WINAPI	dircat (LPSTR, LPSTR);
int	WINAPI	GetDisk (VOID);
int	WINAPI	SetDisk (WORD);
VOID	WINAPI	SetWndFocus (HWND);
HWND	WINAPI	SetRBHandler (HWND, WORD);
VOID	WINAPI	CheckMessage (VOID);
DWORD	WINAPI	GetWinVers(VOID);
HWND	WINAPI	StartPrg (HWND, LPSTR, LPSTR, WORD, WORD);
WORD	WINAPI	CheckTabCntrl (HWND, WPARAM, LPARAM);
VOID	WINAPI	ExitTabCntrl (HWND);
int	WINAPI	InitTabCntrl (HWND, WORD, int, LPTDAT, WORD);
LPPSTR	WINAPI	LockPtrArr (HANDLE);
VOID	WINAPI	UnlockPtrArr (HANDLE);
LPSTR	WINAPI	NormPtr(LPHUGE);
VOID	WINAPI  GetCCPos (HWND, LPPOINT);
int	WINAPI	IsStrDigit(LPSTR);
WORD	WINAPI	GetLBNMsg (WPARAM, LPARAM);
HANDLE	WINAPI	FirstFile (LPSTR, LPVOID, WORD, LPSTR);
int	WINAPI	NextFile (LPSTR, LPVOID, HANDLE);
VOID	WINAPI  Bin2HStr (LPBYTE, LPBYTE, WORD);
VOID	WINAPI  HStr2Bin (LPBYTE, LPBYTE);
int	WINAPI	OpenLangFile (HANDLE, LPSTR, LPSTR);
HWND	WINAPI	MessageWin (HWND, LPSTR, LPSTR, DWORD);
WORD	WINAPI	strulen (LPWORD);
LPWORD	WINAPI	struchr (LPWORD, WORD);
LPDWORD	WINAPI	strdchr (LPDWORD, DWORD);
LPWORD	WINAPI	strucpy (LPWORD, LPWORD);
LPWORD	WINAPI	strucat (LPWORD, LPWORD);
VOID	WINAPI	subchr (LPBYTE, BYTE, BYTE);
WORD	WINAPI	strsum (LPSTR);

typedef	struct	{
	LPSTR	lP;
	BYTE	lB;
	}TOKDAT,*PTOKDAT;

LPSTR	WINAPI	strtok2 (LPSTR, LPSTR, PTOKDAT);

WORD	WINAPI	AnySubDir2 (LPSTR, LPSTR);
WORD	WINAPI	NextSubDir (LPSTR, LPSTR, LPSTR, LPWORD);
int	WINAPI	DirExist (LPSTR);
BPHUGE	WINAPI	GetDibBitsAddr (BPHUGE);
WORD	WINAPI	GetDibWidth (BPHUGE);
WORD	WINAPI	GetDibHeight (BPHUGE);
WORD	WINAPI	GetTextNum (int, WORD, WORD, LPSTR);
LPBYTE	WINAPI	memstr (LPBYTE, LPBYTE, WORD);
VOID	WINAPI	DispLastError (HWND, LPSTR);
VOID	WINAPI	ExitPrg (VOID);
HWND	WINAPI	HelpWindow (HWND, int, LPSTR, LPPOINT);
WORD	WINAPI	CnvUmlaut (LPSTR, WORD);
HANDLE	WINAPI	OpenRegKey (HANDLE, LPSTR, WORD);
WORD	WINAPI	GetRegVal (HANDLE, LPSTR, LPSTR, DWORD);
VOID	WINAPI	InitCommCtrl (VOID);

VOID	WINAPI	CloseRegKey (HANDLE);
WORD	WINAPI	GetRegVal (HANDLE, LPSTR, LPSTR, DWORD);
WORD	WINAPI	GetRegVal2 (HANDLE, LPSTR, LPSTR, LPSTR);
VOID	WINAPI	DelRegKey (HANDLE, LPSTR);
LONG	WINAPI	SetRegKey (HANDLE, LPSTR, LPVOID, WORD);
BSTR	WINAPI	BS_GetRegVal (HANDLE hKey, LPSTR Name);
VOID	WINAPI	DumpWinInfo (HWND hWnd);
LPSTR	WINAPI	Long2Datime (DWORD Tim, LPSTR Str);
DWORD	WINAPI	GetUnixTime (VOID);

typedef	struct	{
	char	IPAdr[16];
        char	HostNam[34];
	char	Comment[50];
        LONG	Off;
        WORD	Len;
	WORD	Chg;
        }HOSTDAT,*PHOSDAT;

WORD	WINAPI	EditHost (HWND, LPSTR);
WORD	WINAPI	EditHost2 (HWND, LPSTR, LPSTR);
WORD	WINAPI	GetAppCount (LPSTR);
BSTR	WINAPI	C2BStr (LPSTR);
VOID	WINAPI	FreeBStr (BSTR);
LPSTR	WINAPI	GetCompInf (VOID);
LPSTR	WINAPI	GetMesStr (WORD);

#ifdef	__cplusplus
}
#endif

#endif	//__INSFNK_H
