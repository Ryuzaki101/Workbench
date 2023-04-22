// IDM...
#define IDMCOM1 	101
#define IDMCOM2 	102
#define IDMCOM3 	103
#define IDMCOM4 	104
#define IDMABOUT	105
#define IDMEXIT		106
#define	IDMCLOSE	107
#define IDMSIOP		108
#define	IDMTCPIP	109
#define	IDSETMAIN	110
#define IDRMICAS 	111
#define IDRECV		112
#define IDRBUKL		113
#define IDRBKDB		114
#define IDRDBDMP	115
#define IDRDBH86	116
#define IDSEND	 	117
#define IDSBUKL		118
#define IDSBKDB		119
#define IDSDBDMP	120
#define IDSMICAS 	121
#define	IDEEDATA	122
#define	IDRCONF		123
#define	IDSCONF		124
#define	IDFGLIST	125
#define	IDMLASTTCP	126
#define IDMCOMX 	127
// Achtung 10 Werte freilassen
#define IDMBAUD         130

#define	IDRCANDAT       141
#define	IDSCANDAT       142
#define	IDRFLDAT        143
#define	IDSFLDAT        144

#define IDMHIST		302
#define IDSCODE         303
#define IDSBOOT         304
#define IDMCODE         305
#define IDMBOOT         306

#define IDMLPT1 	401
#define IDMLPT2 	402
#define IDMLPC1 	403
#define IDMLPC2 	404
#define IDMFILE 	405
#define IDMSCREEN	406

#define IDMDOWN 	501
#define IDMUP		502

#define IDPLPT1 	600
#define IDPLPT2 	601
#define IDPLPC1 	602
#define IDPLPC2 	603
#define IDMPROTO 	604

#define	IDGETDEBINFO	701
#define	IDGETSYM 	702
#define	IDGETVAL 	703
#define	IDISPSYMVAL 	704
#define	IDSETSYMVAL 	705

#define IDMHELP 	900

#define IDMTEST 	999

#define	WM_UPDCOUNT	WM_USER+1

// Konstanten-Definitionen

#define SpAnz		80  	// max. Spalte Display
#define SpMax		131  	// max. Spalte
#define ZlMax		23  	// max. Zeile
#define	EESize		128

#define Xon		17
#define Xoff		19
#define Bel		 7
#define Bs		 8
#define	Tab		 9
#define Lf		10
#define	FF		12
#define Cr		13
#define	CtrlB		2
#define	CtrlC		3
#define	CtrlZ		26
#define Esc		27
#define Del		127
#define	Sync		22

#define	PollTimer	1   	// Timer Id
#define	ScrnTimer	2   
#define	CursTimer	3
#define	MoniTimer	4
#define PollDelay       70  	// PollDelay in ms
#define	TBlinkTime	25  	// Text-Blinkzeit in vielfachen von PollDelay
#define	Timeout		100 	// Timeout in vielfachen von PollDelay
#define	ModNrMin	2   	// minimale Moduladresse
#define	ModNrMax	32  	// minimale Moduladresse
#define	PORTMON		7	// Portnummer Micas-Monitor
#define	PORTELN		23	// Portnummer Micas-Monitor Telnet
#define	PORTMMK		20001	// Portnummer MMK-Dialog

/* Haupt State-Switches							*/

#define	NoAction	0   	// Fehlerzustand: keine Aktion
#define	Display		1   	// Normalzustand: Terminal
#define	RecivH86File	2   	// empfange H86-File
#define	TransAscFile	3   	// sende H86-File
#define	RecivDmpFile	4   	// empfange Dump-File
#define	RecivAscFile	5   	// empfange Dump-File
#define	TransCfgData	6   	// sende Modconf-Daten
#define	RecivH86Blck	7   	// empfange H86-Block
#define	CheckMoni	8	// Monitor vorhanden
#define	TransBinFile	9   	// sende Bin-File
#define	WaitForPrompt	10  	// warte auf Monitor-Prompt
#define	WaitForCr	11  	// warte auf Cr
#define	xxxxxxxxx	12	// 
#define	CheckCid	13  	// ueberpruefe Schnittstellen Anwahl
#define	DiaAskMemArea	14	// Abfrage Speicherbereich
#define	CheckBukl	15
#define	SendString	16  	// sende R-Befehl
#define	ExtractMel	17  	// extrahiere Meldungen
#define	DiaTextin	18  	// Dialog fuer Texteingabe
#define	GenDebBef	19  	// generiere Debug-Befehl
#define	TransFin	20  	// Uebertragung beendet
#define	StoreUntilP	21	// speichere Daten bis Monitor-Prompt
#define	DiaDebFile	22  	// Dialog fuer DEB-File Angabe
#define WaitForEcho	23  	// warte auf Befehlsecho
#define WaitForBlCr  	24  	// Line-Feed auf Bildschirm bei Blank
#define	ReadEEData	25
#define	CalcModNr	26	// Modulnummer aus Dateinamen bestimmen
#define WaitForPDP  	27  	// warten auf PDP-Prompt
#define	HexiEEData	28	// 
#define	GetModTyp	29	// lese Modultyp
#define	CalcMKonst	30	// Micas Konstanten sichern
#define	CalcLTask	31	// ermittle Tasksegment
#define	CalcLTask2	32	// ermittle Tasksegment
#define	CheckDBModul	33	// Überprüfung ZP-Modul
#define	CalcBuklSize	34	// Berechnung der Bukl-gr”áe
#define	DiaSelectFile	35  	// Dialog fuer File Anwahl
#define	SendCHDBef	36  	// sende CHD/CHDH Befehl
#define InsNetOnZP12	37	// sende net -in Befehl bei ZP12/13
#define	GetEEData	38	// SpeicherDump EEPROM
#define	GetModulNr	39	// Modulnummer auslesen
#define	GetModule	40	// Modulnummern auslesen
#define	GetModData	41	// lese Moduldaten
#define	SetModulNr	42	// Modulnummer auslesen
#define	GetLineUsMod	43	// Line.Us auslesen / formatieren
#define	ParaSelFile	44  	// Dialog fuer File Anwahl
#define	ParaSelFile2	45  	// Dialog fuer File Anwahl
#define SetCParam       46      // Ändern der Baudrate
#define ChkNextFFile    47      // check next Flash File
#define CreateDWin      48      // create Transmission Dialog
#define WaitForString   49  	// warte auf String
#define CheckCANMd	50  	// Überprüfung CAN-Modul
#define CheckCANLUM	51  	// Überprüfung CAN-Moduladresse
#define	ReadCANData	52	// lesen Can-Datentabelle
#define	ReadFlash	53	// lesen Flash Daten
#define	SendQBef 	54	// sende Q-Befehl
#define	RTextOut      	55	// Textausgabe
#define	GetLUSMod	56	// Line.Us auslesen
#define	SetNewBaud      57	// Baudratenwechsel
#define	WaitDelay       58	// Wait-Funktion
#define	StateMax      	58	// letzter State

// Debug-Funktionen

#define	GetVal   	1  	// Symbol/Wert anzeigen
#define	GetSym		2  	// Symbol/Wert anzeigen
#define	DispVal  	3  	// Symbol/Wert anzeigen
#define	SetVal   	4  	// Symbol/Wert anzeigen


// Meldungs State-Switches

#define	MesonScreen	0x0001
#define	MesonDevice	0x0002
#define	MesonFile	0x0004
#define	ProonDevice	0x0008
#define	ProonFile	0x0010
#define	PMFile	    (MesonFile bor ProonFile)
#define	PMDevice    (MesonDevice bor ProonDevice)

#define	CursorBlinkTime	200 	// Cursor Blink-Periode (4 * Wert in ms)	*/
#define	Revers		1
#define	DefAttrib	0
#define DBLen		600	// laenge Display-Buffer vorher
#define	IQueSize	DBLen	// Groesse der Receive - Que
#define	OQueSize	1024	// Groesse der Sende - Que

#define	ErrNHV	(-2)	    	// Error no Hex-Value
#define	ErrCHS	(-3)	    	// Checksum-Error
#define	ErrTRS	(-4)	    	// Datenuebertragungsf. (Monitor-Fehler)
#define	ErrTMO	(-5)	    	// Error Timeout
#define	ErrECS	(-6)	    	// EEProm-Prüfsumme

#define	WorkSize	512
#define	PathMax		80

#define	CupSS		"\033[A"
#define	CdownSS		"\033[B"
#define	CrightSS	"\033[C"
#define	CleftSS		"\033[D"
#define	EndBlock    ":00000001FF"
#define	EndDump     "ENDDUMP"

typedef	void 	(CALLBACK * FARVOID) ();
typedef	int  	(CALLBACK * FARINT) ();
typedef	DWORD	(CALLBACK * FARDWORD) ();
typedef	LPSTR 	(CALLBACK * FARLPSTR) ();

#define	CloseFile(f)	if(f) {_FClose(f); f=0;}


typedef	struct {
	char	Mod[8];
	WORD	Num;
	char	Vers[6];
	}MODULE,*PMODULE;
extern	MODULE	Module[];

typedef	struct	{
	LONG    aktVal;
	LONG    maxVal;
	HWND	hwdRT;
	HWND	hwDis;
	}DSPDAT,*PDSDAT;

extern	char	CompanyName[],Version[];

#ifdef	__cplusplus
extern	"C"
{
#endif

extern	LPSTR   DDEValP,MrDataP;
extern	WORD	STrace,CTrace,LTrace;

//	WTH86
VOID	DumpNextStates (LPSTR Info);
VOID	DumpState (LPSTR Info);
LPSTR	WINAPI	GetStateName (WORD Sta, LPWORD pId);
VOID	SetStateCnt (WORD Stat, WORD Val);
VOID	WINAPI InitBdMenu (PMDESC PM);
WORD	WINAPI ChangeBdMenu (DWORD, WORD);
VOID	WINAPI	STrace_OnOff (VOID);
VOID	ChkEnaDis (WORD);
int	CheckMonErr (VOID);
VOID	OkMessage (int, LPSTR);
VOID	DeblockComm(VOID);
HWND    CreateDspWin (LPSTR, DWORD);
VOID	DestroyDspWin (VOID);
VOID	SetActionText (LPSTR);
VOID	BlinkActionText (LPSTR);
BOOL    openFile (char*, int *);
VOID	TransFin_F (VOID);
VOID	HexiEEData_F (VOID);
VOID	IncCount (LPSTR);
WORD	AddNextState (BYTE, LPSTR);
WORD	AddNextStat2 (BYTE, LPSTR, BYTE);
WORD	InsertState (BYTE, LPSTR, BYTE);
DWORD	GetNextState (VOID);
LPSTR	GetStateStr (WORD);
WORD	GetStateCnt (WORD);
//VOID	FreeStateStr (VOID);
VOID    CheckCid_F (VOID);
VOID	DiaTextin_F (HWND);
typedef	struct	{
	WORD	MId;
	LPSTR	Path;
	}BPATH,*PBPATH;
#define CPathMax        24

#define	IS_NOCLOSE	0x0001
#define	IS_NODSWIN	0x0002
WORD    InitState (WORD);
WORD	ReadChars (LPSTR, WORD);
WORD	SendChars (LPSTR, WORD, WORD);
VOID	DiaSelectFile_F (HWND);
VOID	ParaSelFile_F (VOID);
VOID	ParaSelFile2_F (VOID);

//	th_scrn
VOID	UpdateScroll (VOID);
VOID	WriteScreen (HDC);
VOID    InitVideo (VOID);
VOID    InitCursor (HWND);
VOID	ExitScreen (VOID);
HWND    InitScreen (HANDLE);
VOID	SetMode (VOID);
VOID	SetDispMode (HDC, char);
VOID	WTH86Paint(HWND, LPPAINTSTRUCT);
VOID    DisplayRChar(VOID);
VOID    DisplayBuf (BYTE*, short);
VOID	WINAPI	ClrScrn (HANDLE);

//	th_sior
WORD	WINAPI	Connection (HWND, WORD, WPARAM, LPARAM);
VOID	CalcIEvnt (VOID);
BOOL	InitComm (short);
VOID	SetComPara (VOID);
BOOL	WINAPI	SetSioPara (HWND, WORD, WPARAM, LPARAM);
BOOL	InitLptr (char*);
short	PriErr (short);
char	GetCharComm (VOID);
short	AnzCharIQue (VOID);
VOID	SendStr (LPSTR);
VOID    PutChrComm (char);
VOID	CloseSDevice(VOID);
int	WINAPI IsTCPConnection(VOID);
int	WINAPI IsMONConnection(VOID);
int	WINAPI IsAnyConnection(VOID);
WORD	ReadEnable (WPARAM, LPARAM);
VOID	SetNewBaud_F (VOID);
VOID	WaitDelay_F (VOID);

//	wthsio
int	WINAPI	OpenStream (LPSTR, WORD);
int	WINAPI	ReadStream (LPSTR, WORD);
int	WINAPI	WriteStream (LPSTR, WORD);
VOID	WINAPI	StateSwitch (VOID);
int	WINAPI	CheckSocket (LPDWORD pCnt);

#include	"wthsio.h"


//	th_moni
VOID	RecivDmpFile_F (VOID);
VOID	RecivAscFile_F (VOID);
VOID	RecivH86File_F (VOID);
VOID	RecivH86Blck_F (VOID);
VOID	WaitForCr_F   (VOID);
VOID    StoreUntilP_F (VOID);
VOID    GetModTyp_F (VOID);
VOID    GetModData_F (VOID);
VOID    CalcMKonst_F (VOID);
VOID    CalcLTask_F (VOID);
VOID    CalcLTask2_F (VOID);
VOID    CalcBuklSize_F (VOID);
VOID    CheckDBModul_F (VOID);
VOID	GetEEData_F (VOID);
VOID	ReadEEData_F (VOID);
VOID    CheckBukl_F (VOID);
VOID    InsNetOnZP12_F (VOID);
VOID    GetModulNr_F (VOID);
VOID    GetModule_F (VOID);
VOID    SetModulNr_F (VOID);
VOID    GetLineUsMod_F (VOID);
VOID	WaitForPrompt_F (VOID);
VOID	WaitForString_F (VOID);
VOID	WaitForEcho_F (VOID);
VOID	WaitForPDP_F (VOID);
VOID    RTextOut_F (VOID);
VOID    CheckCANMd_F (VOID);
VOID    CheckCANLUM_F (VOID);
VOID    ReadCANData_F (VOID);
VOID    SendQBef_F (VOID);
VOID    ReadFlash_F (VOID);
VOID	ClearUSInfo (VOID);
VOID	ClearCInfo (VOID);
VOID    GetLUSMod_F (VOID);
VOID    WINAPI	InitRecvBuf (WORD);

//	th_send
VOID	FlushOQue (VOID);
VOID	FlushIQue (VOID);
VOID	TransAscFile_F (VOID);
VOID	TransBinFile_F (VOID);
VOID	TransCfgData_F (VOID);
VOID	TransPSLFile_F (VOID);
VOID    DiaPSLFile_F (HWND);
VOID    DiaDebFile_F (HWND);
VOID    SendString_F (VOID);
VOID    ChkNextFFile_F (VOID);
VOID    CreateDWin_F (VOID);
VOID    SendCHDBef_F (VOID);
VOID    CalcModNr_F (VOID);
VOID    CheckMoni_F (VOID);

//	th_dtyp
BOOL    SelectFormat (HWND);
BOOL	CALLBACK SelectDmpTyp (HWND, WORD, WORD, LONG);

//	th_htyp
BOOL	SelectTyp (HWND);
BOOL	CALLBACK SelectH86Typ (HWND, WORD, WORD, LONG);

//	th_deb
BOOL	GetDebugFile (VOID);
VOID	GenDebBef_F (VOID);
VOID	WaitForBlCr_F (VOID);
BOOL	InputText (HWND);
BOOL	CALLBACK TextInput (HWND, WORD, WORD, LONG);

//	th_mem
VOID	WINAPI DiaAskMemArea_F (HWND);
BOOL	CALLBACK SelectMemArea (HWND, WORD, WORD, LONG);

//	th_dde
VOID	PASCAL  Inc_DDECmd (BYTE);
VOID	PASCAL  Dec_DDECmd (BYTE);
BOOL	InitializeDDE (HANDLE);
VOID	UninitializeDDE (VOID);

#ifdef	__cplusplus
}
#endif
