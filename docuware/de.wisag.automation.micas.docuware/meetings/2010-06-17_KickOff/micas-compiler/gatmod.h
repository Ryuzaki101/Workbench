#ifndef	__GATMOD_H
#define	__GATMOD_H

#ifdef	_MICAS_

#define	FAR	_far
#define	WINAPI
typedef unsigned char	BYTE;
typedef unsigned short	WORD;
typedef unsigned long	DWORD;
typedef long		LONG;
typedef long*           LPLONG;
typedef char*   	LPSTR;
typedef BYTE*   	LPBYTE;
typedef void*   	LPVOID;

#define LOWORD(l)           ((WORD)(l))
#define HIWORD(l)           ((WORD)((DWORD)(l) >> 16))

#endif	// _MICAS_


//#define SegUrlist       0x1200
//#define SegDBChks	0x12F0
#define SegBkV5	        0x3000
#define SegBkV7	        0x3CA0
//#define SegBkLMod	0x2000
#define KonVwSize	34
//#define	SegRgList	0x3D00

#define MaxIZ		50	// maximal Zahl von internen Zeilen...
#define MaxSK		8	// Stellbefehl-Kontrollworte
#define EESize		128	// Standard EEPROM Groesse in Bytes
#define	Off_NVIndx	4
      

//	GA2000 Baudraten
#define GABd115_k	0
#define GABd57600	1
#define GABd38400	2
#define GABd19200	3
#define GABd_9600	4
#define GABd_4800	5
#define GABd_2400	6
#define GABd_1200	7
#define	Def_GABaud	GABd_4800
#define	Def_STBaud	GABd_9600
#define	Def_SWTyp	1

//	RS485 Baudraten
#define RSBd19200	0
#define RSBd_9600	1
#define RSBd_4800	2
#define RSBd_2400	3
#define RSBd_1200	4
#define	Def_RSBaud	RSBd19200

#define	Def_StZykl	2
#define	Def_ImpTime	1

#define	MaxTAnz_H	1
#define	MaxTAnz_L	8
#define	MinModn		2
#define	MaxModn_L	32
#define	MaxModn_H	15
#define	Def_LEDms	50


// Option f¸r Byte-Ausrichtung!!
#pragma	warn	-pck
#pragma	option	-a1

//	E E P R O M - S t r u k t u r e n

typedef	struct {
	unsigned Zeile	:8;	// Prozessabbild-Zeile
	unsigned Info	:4;	// Konfigurationsinformation
	unsigned Fkt	:3;	// Funktionskennung
	unsigned Used	:1;	// TRUE if interne Zeile benutzt
	}EECWS;

typedef	struct	{
	unsigned Baud	:4;	// Baudrate
	unsigned SZyk	:4;	// Stoerzyklus
	}BDSZYK;

typedef	union	{		// Kontrollwort
	WORD	CW;		// overlay for bits
	EECWS	V1;
	}CONTROL, *PCONTRL;

typedef	union	BaudU{
	BDSZYK	GAB;		// GA2000 Ferbus
	BYTE	BaudGA;		// "      Baudrate
	}BAUDGA;

typedef	union	{
	WORD	CW;		// overlay for bits
//	struct	{
//	unsigned BaudPB	:4;	// Baudrate PROFIBUS
//	unsigned StZykl	:4;	// Stoerzyklus
//	unsigned GerAdr	:8;	// Geraete-Adresse am PROFIBUS
//		}V1;
	struct	{
	BDSZYK	PVB;
	BYTE	GerAdr;		// Geraete-Adresse am PROFIBUS
		}V1;
	}RS_485;

typedef	union	{
	WORD	CW;		// overlay for bits
	struct	{
	BYTE	maxAdr;		// maximale PROFIBUS high Adresse
	BYTE	maxTel;		// maximale Telegrammanzahl pro Tokenhalt
		}V1;
	}MAX485;		// bits definition

/*
typedef	union	{		// Stellbefehl-Kontrollwort
	WORD	CW;		// overlay for bits
	PCLS	V0;
	EECWS	V1;
	struct	{
	unsigned VZeit	:10;	// Stellventil Durchlaufzeit
	unsigned MwZeile:6;	// Messwert interne Zeile
		}V2;		// bits definition
	struct	{
	BYTE	B0;		// Bedeutung siehe Defines
	BYTE	B1;		// Bedeutung siehe Defines
		}V3;
	RS_485	V4;		// Baudrate PROFIBUS high, Stoerzyklus,
				// Geraete-Adresse am PROFIBUS high
	MAX485	V5;		// maximale PROFIBUS Adresse/Telegrammanzahl
	}STLBEF;
typedef	STLBEF	FAR *PSTLBKW;
*/


typedef	union {
	struct	{
	unsigned DIf	:2;	// Default-Interface
	unsigned Sio	:4;	// Sio-Config
	unsigned Modem	:1;	// Modem
	unsigned Turbo	:1;	// Turbo Mode
	unsigned MPrio	:4;	// Min Prio
	unsigned EMZlt	:1;	// no ZLT-Error messages
	unsigned MSio	:1;	// no messages at Sio
	unsigned Valid	:1;	// DIL and Sio Values valid
	unsigned UseTrs	:1;	// Used bzw. no XOn-XOff Transpose
		}Bit;
	BYTE	B_0;
	WORD	CW;
	}PCLSCTL;

typedef	union {
	struct	{
	unsigned Baud	:8;	// Baund-Inx
	unsigned Res1	:4;	//
	unsigned EMZlt	:1;	// no ZLT-Error messages
	unsigned MSio	:1;	// no messages at Sio
	unsigned Res2	:1;	//
	unsigned HdHS	:1;	//  Hardware Handshake
		}Bit;
	WORD	CW;
	}SIOCTRL;

typedef	union	{		// Stellbefehl-Kontrollwort
	WORD	CW;
	struct	{
	BYTE	B0;
	BYTE	B1;
//	};
	}CB;
	struct	{
	unsigned VZeit	:10;	// Stellventil Durchlaufzeit
	unsigned MwZeil :6;	// Messwert interne Zeile
	}SB;
	}STBDAT, *PSTBDAT;

typedef	struct	{
	BYTE	EZeile;
	BYTE	Res1;
	BYTE	ProGeraet;
	BYTE	Res2;
	BYTE	Res3;
	BYTE	Res4;
	BYTE	Zeilen;
	BYTE	Res5;
	WORD	Res6[4];
	}GWDATA, *PGWDAT;

typedef	union	{
	struct	{
	BYTE	B0;
	BYTE	B1;
	BYTE	B2;
	BYTE	B3;
//		};
		}CB;
	struct	{
	WORD	LW;
	WORD	HW;
//		};
		}CW;
	DWORD	Lng;
	}NIPDAT;

/*
typedef	struct	{
	NIPDAT	Host;
	NIPDAT	NMsk;
	}PCLSIP;
*/

typedef	struct	{
	PCLSCTL	LS;
	NIPDAT	Host;
	NIPDAT	NMsk;
	BYTE	GlobZeil;
	BYTE	BaudSio2;
	BDSZYK	PVB;
	BYTE	GerAdr;		// Geraete-Adresse am PROFIBUS
	BYTE	maxAdr;		// maximale PROFIBUS high Adresse
	BYTE	maxTel;		// maximale Telegrammanzahl pro Tokenhalt
	}PLSDAT, *PPLSDAT;

typedef	union	{
	STBDAT	SK[MaxSK];
	GWDATA	GW;
	PLSDAT	PC;
	}SKWDAT, *PSKWDAT;

typedef	struct	{
	LONG	IP_ETNet;	// Ethernet IP-Adresse			80
	LONG	IP_Modem;	// Modem IP-Adresse			84
	LONG	IP_PHBus;	// Profi-High Bus IP-Adresse		88
	LONG	IP_Bedien;	// Bedienerschnittstelle IP-Adresse	8C
	WORD	MS_ETNet;	// Ethernet Netzmaske			90
	WORD	MS_Modem;	// Modem Netzmaske			92
	WORD	MS_PHBus;	// Profi-High Bus Netzmaske		94
	WORD	MS_Bedien;	// Bedienerschnittstelle Netzmaske	96
	WORD	NetModus;	// Betriebsart	Ethernet		98
	BYTE	not_use0[2];	//					9A
	BYTE	HWInfo;		//					9C
	BYTE	TimeSvr[3];	//					9D
	LONG	Gatway1;	//					A0
	LONG	HostAd1;	//					A4
	LONG	Gatway2;	//					A8
	LONG	HostAd2;	//					AC

	BYTE	GWType;		//					B0
	BYTE	GWMode;		//					B1
	WORD	GW_RW; 		//					B2
	BYTE	LONMode;	//					B4
	BYTE	not_use2[3];	//					B5
	BYTE	GWZeil1;	//					B8
	BYTE	not_use3[5];	//					B9
	BYTE	GWZeilen;	//					BE

	BYTE	not_use4[1];	//					BF
	BYTE	Hosts[3*15];	//					C0
	BYTE	WDInfo;		//					ED
	WORD	SerNr;		// Seriennummer				EE
	BYTE	Kalib;		// Kalibrierungswert			F0
	BYTE	day;		// Tag					F1
	BYTE	mon;		// Monat				F2
	BYTE	year;		// Jahr					F3
	BYTE	Prufer[10];	// Name des PrÅfers			F4
	WORD	Chks;		// Checksum				FE
	}EEZP20;

typedef	struct	{
	LONG	IP_ETNet;	// Ethernet IP-Adresse			80
	LONG	IP_Modem;	// Modem IP-Adresse			84
	LONG	MS_ETNet;	// Ethernet Netzmaske			88
	LONG	MS_Modem;	// Modem Netzmaske			8C
	LONG	PCLSHost;
	SIOCTRL	SioCtrl;	//                                      94
	WORD	TCPCtrl;	//                                      96
	WORD	EthCtrl;	// Betriebsart	Ethernet		98
	WORD	ServPort;	//					9A
	BYTE	P2P_Ctrl;	//					9C
	BYTE	P2P_Seg;	// 					9D
	WORD	Mel_Ctrl;	//					9E
	LONG	Gatway1;	//					A0
	LONG	HostAd1;	//					A4
	LONG	Gatway2;	//					A8
	LONG	HostAd2;	//					AC

	BYTE	GWType;		//					B0
	BYTE	GWMode;		//					B1
	WORD	GW_RW;		//					B2
	BYTE	LONMode;	//					B4
	BYTE	not_use2[3];	//					B5
	WORD	GWZeil1;	//					B8
	BYTE	not_use3[4];	//					BA
	WORD	GWZeilen;	//					BE
	BYTE	Hosts[4*15];	//					C0
	BYTE	HandBD;	        //					FC
	BYTE	not_use5[2];	//					FD
	BYTE	WDInfo;		//					FF
	}EEAC40;

typedef	union	{
	EEZP20	ZP20;
	EEAC40	AC40;
	}EEU;

typedef	struct	EEDatS{
	WORD	chks;		// Checksumme				00
	CONTROL	KW[MaxIZ];	// Kontrollworte			02
//	STLBEF	SK[MaxSK];	// Stellbefehl-Kontrollwort		66
	SKWDAT	SKW;
	BYTE	SW_Typ;		// Software-Typ				76
	BYTE	HW_Typ;		// Hardware-Typ				77
	BYTE	UsNr;		// Feldbus-Stations-Nummer 		78
	BAUDGA	GA;		// Baudrate Doppelstrom GA2000 		79
	RS_485	rs_485;		// Baudrate PROFIBUS, Stoerzyklus, 	7A
				// Geraete-Adresse am PROFIBUS
	MAX485	max485;		// maximale PROFIBUS Adresse 		7C
				// maximale Telegrammanzahl pro
				// Token  2
	BYTE	LED_ms;		// Leuchdauer der roten LED		7E
	BYTE	Imp_Sio;	// Impulsdauer bzw. Sio-Ctrl bei ZP20F  7F
	EEU	EE;		// Daten ZP20/AC40			80
}EEDATA,*PEDATA;


/*
#define SKgwErsteZeile	SK[0].V3.B0
#define SKpclsInterface	SK[0].V0.DIf
#define SKpclsSio	SK[0].V0.Sio
#define SKpclsModem	SK[0].V0.Modem
#define SKpclsTurbo	SK[0].V0.Turbo
#define SKpclsMinPrio	SK[0].V0.MPrio
#define SKpclsErrZlt	SK[0].V0.EMZlt
#define SKpclsMsgSio	SK[0].V0.MSio
#define SKpclsValid	SK[0].V0.Valid
#define SKunused1	SK[0].V1.Fkt
#define SKpclsTranspose	SK[0].V0.XTrsp
#define SKgwUsed	SK[0].V1.Used

#define SKgwProGeraet	SK[1].V3.B0
#define SKpclsHost0	SK[1].V3.B0
#define SKpclsHost1	SK[1].V3.B1

#define SKpclsHost2	SK[2].V3.B0
#define SKpclsHost3	SK[2].V3.B1

#define SKgwZeilenZahl	SK[3].V3.B0
#define SKpclsNetmask0	SK[3].V3.B0
#define SKpclsNetmask1	SK[3].V3.B1
#define SKpclsNetmask2	SK[4].V3.B0
#define SKpclsNetmask3	SK[4].V3.B1

#define SKpclsGlobZeil	SK[5].V3.B0
#define SKpclsBaudSio2	SK[5].V3.B1

#define SKpclsBaudPB	SK[6].V4.V1.PVB.Baud
#define SKpclsStoerZyk  SK[6].V4.V1.PVB.SZyk
#define SKpclsGerAdr	SK[6].V4.V1.GerAdr

#define SKpclsMaxAdr	SK[7].V5.V1.maxAdr	// 15
#define SKpclsMaxTel	SK[7].V5.V1.maxTel
*/

// D e f i n e s   f u e r   Z u g r i f f s f u n k t i o n e n

#define	EEgwErsteZeile	1
#define	EEpclsInterface	2
#define	EEpclsSio	3
#define	EEpclsModem	4
#define	EEpclsTurbo	5
#define	EEpclsMinPrio	6
#define	EEpclsErrZlt	7
#define	EEpclsMsgSio	8
#define	EEpclsTyp	9
#define	EEpclsValid	10
#define	EEpclsTranspose	11
#define	EEgwUsed	12

#define	EEgwProGeraet	14
#define	EEpclsHostL	15
#define	EEpclsHostH	16

#define	EEpclsNetmskL	18
#define	EEpclsNetmskH	19
#define	EEgwZeilenZahl	20
#define	EESoftType	21

#define	EEpclsGlobZeil	25
#define	EEpclsBaudSio2	26
#define	EEpclsBaudPB	27
#define	EEpclsStoerZyk	28
#define	EEpclsGerAdr	29
#define	EEpclsMaxAdr	30
#define	EEpclsMaxTel	31
#define	EEBaudBedSt	32
#define	EEpclsMdBaud	33
#define	EEGABaud	34
#define	EEGABdFern	35
#define	EEGASZykl	36
#define	ZP20IP_INNetL	37
#define	ZP20IP_INNetH	38
#define	ZP20IP_ETNetL	39
#define	ZP20IP_ETNetH	40
#define	ZP20IP_ModemL	41
#define	ZP20IP_ModemH	42
#define	ZP20IP_PHBusL	43
#define	ZP20IP_PHBusH	44
#define	ZP20IP_BedienL	45
#define	ZP20IP_BedienH	46
#define	ZP20MS_ETNet	47
#define	ZP20MS_Modem	48
#define	ZP20MS_PHBus	49
#define	ZP20MS_Bedien	50
#define	ZP20Coax	51
#define	ZP20NetModus	52
#define	ZP20Gway1H	53
#define	ZP20Gway1L	54
#define	ZP20Host1H	55
#define	ZP20Host1L	56
#define	ZP20Gway2H	57
#define	ZP20Gway2L	58
#define	ZP20Host2H	59
#define	ZP20Host2L	60
#define	ZP20GWType	61
#define	ZP20GW_RW	62
#define	ZP20LONMode	63
#define	ZP20GWZeil1	64
#define	ZP20GWZeilen	65
#define	ZP20WDInfo	66
#define ZP20TimSvrL     67
#define ZP20TimSvrH     68


//	H a r d w a r e - K e n n u n g e n
#define ZP03k 0x03	// Dummy Kennung
#define ZP10k 0x10#define ZP12k 0x11 	/* #18fb93# Sche: successor of 29ZP10 */#define ZP13k 0x81 	/* #18fb93# Sche: successor of 29ZP11 */#define ZP20k 0x82 #define AC40k 0x84#define ZM12k 0x90 	/* #18fb93# Sche: replaces PC11k */#define ZM13k 0x91 	/* #25ja95# Sche: own EPROM for 29ZM13 (docker) */#define ZM14k 0x92 	/* #25ja95# Sche: own EPROM for 29ZM14 (spider) */#define ZM15k 0x93 	/* #25ja95# Sche: own EPROM for 29ZM15 (binder) */#define AR10k 0x20#define AR11k 0x21#define AR20k 0x22#define SP10k 0x30#define SP11k 0x31#define SP20k 0x32#define MB10k 0x40#define MB11k 0x41#define ER10k 0x60#define ER11k 0x61#define ER30k 0x63	// Dummy Kennung
#define BD11k 0x70	/* #28ap95# Sche: device with display */#define BK10k 0x50#define BK13k 0xA1 	/* #28ap93# Sche: successor of 29BK11 and 256 lines */#define BK14k 0xA4 	/* #24oc93# Sche: successor of 29BK12 and 256 lines */#define BK15k 0xA5 	/* #11fb94# Sche: successor of 29BK11 and 256 lines */#define BK16k 0xA6 	/* #26sp94# Sche: successor of 29BK12 and 128 lines */#define BK20k 0xA8	/* #26sp94# Sche: connect stranger to GTI (256) */#define BK21k 0xA9	/* #26sp94# Sche: connect stranger to PDP (128) */#define BK30k 0xA0 	/* Oestrich 23.9.92, #28ap93# Sche: instead of GW10 */#define BK31k 0xA7 	/* #26sp94# Sche: 29BK30 for 128 lines */#define EI12k 0x12 	/* #28jl94# Sche: 29ZP12-EIB (29EI12) */#define GP12k 0xB0 	/* #23fb93# Sche: ZP12 as gateway procontrol<->BK11 */#define BG11k 0xB1 	/* #31ma94# Sche: ZP12 as Guenters Bediengeraet */#define GW12k 0xB2	// fuer K&P#define GW13k 0xB3	// fuer INSUM,MODBUS#define GW14k 0xB4	// fuer Sauter#define GWLON 0xB5	// fuer LON

// Kopplungsvarianten entsprechend Kopplungskennungen
#define	KV_LON	GWLON#define	KV_EIB	EI12k#define	KV_KIP	GW12k#define	KV_MOD	GW13k#define	KV_SAU	GW14k
//	interne Kennungen (Modul-Handle)
#define	ZP03i	1
#define	ZP10i	2
#define	ZP12i	3
#define	ZP13i	4
#define	ZM12i	5
#define	ZM13i	6
#define	ZM14i	7
#define	ZM15i	8
#define	ZP20i	9
#define	EI12i	10
#define	GW12i	11
#define	GW13i	12
#define	GW14i	13
#define	AR20i	14
#define	SP20i	15
#define	AC40i	16
#define	AR11i	17
#define	SP11i	18
#define	MB11i	19
#define	AR10i	20
#define	SP10i	21
#define	MB10i	22
#define	ER10i	23
#define	ER11i	24
#define	ER30i	25
#define	BK10i	26
#define	BK11i	27
#define	BK12i	28
#define	BK13i	29
#define	BK15i	30
#define	BK30i	31
#define	BK31i	32
#define	BD11i	33
#define	BG11i	34

enum	Type_Id	{ NoTyp_Id=255,
		  ZL_fik=0,	// fiktiv Zeile
		  ZL_mb=1,	// Melde/Befehlszeile
		  ZL_mb01=2,	// Melde/Befehlszeilen-Paar 0/1
		  ZL_mb23=3,	// Melde/Befehlszeilen-Paar 2/3
		  ZL_mbER=9, 	// Melde/Befehlszeilen-Paar 0/1 ER10
		  ZL_IRZ=4,	// Interruptzaehler
		  ZL_HWZ=5, 	// Hardwarezaehler
		  ZL_aMW=6,	// aktiver/passiver Messwert
		  ZL_pMW=7,	// passiver Messwert
		  ZL_EMW=10,	// aktiver/passiver Messwert ER10
				// kann als ST fuer 1F oder OE/ST
				// fuer SA verwendet werden
		  ZL_aa=8,		// Analogausgabe
		  ZL_eib=11 };	// EIB-Objekt

// Zeilen-Klassen fÅr Konfigurator
enum	Kls_Id	{KL_MBZ=1,
		 KL_HZL=2,
		 KL_pMW=3,
		 KL_aMW=4,
		 KL_aST=5,
		 KL_fik=6,
		 KL_EIB=7,
		 KL_KIP=8,
		 KL_INS=9,
		 KL_SAU=10,
		 KL_LON=11};


//	Modul-Merkmale
// 	versionsabhÑngige
#define	MOD_bkseg	1
#define	MOD_eeoff	2
#define	MOD_kbseg	3
#define	MOD_endbs	4
#define	MOD_dtseg	5
#define	MOD_stseg	6
#define	MOD_ofseg	7
#define	MOD_clmax	8
#define MOD_dbseg       9
#define MOD_dbcks       10

// 	versionsunhÑngige
#define	MD_MAXINX	29
#define	MOD_modul	1
#define	MOD_alias	2
#define	MOD_dgehs	3
#define	MOD_dstck	4
#define	MOD_zeil 	5
#define	MOD_efzl 	6
#define	MOD_emwzl	7
#define	MOD_mzanz	8
#define	MOD_szmax	9
#define	MOD_dbmod	10
#define	MOD_mumod	11
#define	MOD_mimod	12
#define	MOD_skmod	13
#define	MOD_fbmod	14
#define	MOD_bkmod	15
#define	MOD_kopmd	16
#define	MOD_tsmax	17
#define	MOD_modi	18
#define	MOD_offt1	19
#define	MOD_zykhg	20
#define	MOD_lfakt	21
#define	MOD_versi	22
#define	MOD_dstkv 	23
#define	MOD_bintp	24
#define	MOD_count	25
#define	MOD_cexcl	26
#define MOD_vsinx       27
#define MOD_eesiz       28
#define	MOD_eecmd	MD_MAXINX


#ifdef	__cplusplus
extern	"C"	{
#endif

WORD	WINAPI	GetModHandle (LPSTR);
DWORD	WINAPI	GetModInfo (long, long, LPSTR);
WORD	WINAPI	GetModInf2 (long, LPSTR, long);
int	WINAPI	GetTypId (long, WORD);
int	WINAPI	GetTypKls(long, WORD, WORD);
LPSTR	WINAPI	DusTyp2Name (LPVOID);
int	WINAPI	IsSTused (LPVOID, WORD);
int	WINAPI	IsSAMess (LPVOID, WORD);
int	WINAPI	IsSTValid (LPVOID, WORD);
DWORD	WINAPI	GABdi2ext (DWORD);
DWORD	WINAPI	GAInx2Baud (WORD, WORD);
WORD	WINAPI	GABaud2Inx (DWORD, WORD);
WORD	WINAPI	PBBdi2ext (WORD);
WORD	WINAPI	PBInx2Baud (WORD, WORD);
WORD	WINAPI	PBBaud2Inx (WORD, WORD);
WORD	WINAPI	GetEEDat (LPVOID, WORD);
void	WINAPI	PutEEDat (LPVOID, WORD, WORD);
LPSTR	WINAPI GetNextModul (LPLONG);
LPSTR	WINAPI GetNAliModul (LPSTR, LPLONG);

#ifdef	__cplusplus
}
#endif

#endif	//__GATMOD_H
