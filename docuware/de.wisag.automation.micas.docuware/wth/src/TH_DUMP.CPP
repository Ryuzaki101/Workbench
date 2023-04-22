/*K
**      Modul Name....: TH_DUMP.C
**
**      Funktion......: Dump der EEProm Daten
**
**      Erstelldatum..: 10.06.96
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

#pragma		hdrstop

#include	"gatmod.h"
extern	char	Work[];

typedef	LPSTR (*DMPFNK) (LPSTR, PEDATA, WORD);

static	LPSTR	DumpSKW0 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW1 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW2 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW3 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW4 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW5 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW6 (LPSTR, PEDATA, WORD);
static	LPSTR	DumpSKW7 (LPSTR, PEDATA, WORD);

static	DMPFNK	DmpFnk[MaxSK] = {DumpSKW0,DumpSKW1,DumpSKW2,DumpSKW3,
				 DumpSKW4,DumpSKW5,DumpSKW6,DumpSKW7};

/*-------------------------------------------------------------------------*/

static	LPSTR	CnvGWType (WORD Val)

Begin
LPSTR	LP;

Switch (Val)
  case KV_LON:	LP = "(LON)";
		break;
  case KV_EIB:	LP = "(EIB)";
		break;
  case KV_KIP:	LP = "(K&P)";
		break;
  case KV_MOD:	LP = "(MODBUS)";
		break;
  case KV_SAU:	LP = "(Sauter)";
		break;
  case KV_MBU:	LP = "(Meter-Bus)";
		break;
  case KV_CAN:	LP = "(CAN-Bus)";
		break;
  default:	LP = "(??)";
Endswitch
return (LP);

End

/*-------------------------------------------------------------------------*/

static	WORD	DispSKW0 (LPSTR P, WORD Val)

Begin
PSKWDAT pSKW;
WORD	hw,ret;

pSKW = (PSKWDAT) &Val;  ret = 0;
hw = wsprintf (P, " DIf=%u", pSKW->PC.LS.Bit.DIf);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " Sio=%X", pSKW->PC.LS.Bit.Sio);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " Modem=%u", pSKW->PC.LS.Bit.Modem);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " Turbo=%u", pSKW->PC.LS.Bit.Turbo);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " Prio=%u\r\n\t\t ",  pSKW->PC.LS.Bit.MPrio);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " ErrZlt=%u", pSKW->PC.LS.Bit.EMZlt);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " MsgSio=%u", pSKW->PC.LS.Bit.MSio);
ret = ret + hw; P = P + hw;
hw = wsprintf (P, " Valid=%u", pSKW->PC.LS.Bit.Valid);
ret = ret + hw; P = P + hw;
ret = ret + wsprintf (P, " Transpose=%u\r\n", pSKW->PC.LS.Bit.UseTrs);
return (ret);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW0 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case ZP12k:
  case ZP13k:
  case ZP20k:
  case ZM12k:
  case ZM13k:
  case ZM14k:
  case ZM15k:	P = P + DispSKW0 (P, Cfg->SKW.SK[0].CW);
		break;
  case EI12k:
  case GP12k:
  case GW12k:
  case GW13k:
  case GW14k:	if (Cfg->SKW.PC.LS.Bit.UseTrs)
		Then
		  P = P + wsprintf (P, " gw 1.Zeile=%u\r\n", Cfg->SKW.GW.EZeile);
		Endif
		break;
  default:	P = P + wsprintf (P, "\r\n");
Endswitch
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW1 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case BK30k:
  case BK31k:	P = P + wsprintf (P, " gw %u Zeilen/Geraet",
				((Cfg->SKW.GW.ProGeraet == 1)?4:8) );
		break;
  case GW13k:	if (Cfg->SKW.PC.LS.Bit.UseTrs)
		Then
		  P = P + wsprintf (P, " gw 1.Zeile=%u\t(2.Kanal)",
						Cfg->SKW.GW.ProGeraet);
		Endif
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW2 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case ZP12k:
  case ZP13k:
  case ZP20k:
  case ZM12k:
  case ZM13k:
  case ZM14k:
  case ZM15k:	P = P + wsprintf (P, " Host=%u.%u.%u.%u",
			Cfg->SKW.PC.Host.B3, Cfg->SKW.PC.Host.B2,
			Cfg->SKW.PC.Host.B1, Cfg->SKW.PC.Host.B0);
		break;
  case GW13k:	if (Cfg->SKW.PC.LS.Bit.UseTrs)
		Then
		  P = P + wsprintf (P, " gw Zeilen=%u\t(2.Kanal)", Cfg->SKW.GW.Res3);
		Endif
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW3 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case EI12k:
  case GP12k:
  case GW12k:
  case GW13k:
  case GW14k:	if (Cfg->SKW.PC.LS.Bit.UseTrs)
		Then
		  P = P + wsprintf (P, " gw Zeilen=%u", Cfg->SKW.GW.Zeilen);
		Endif
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW4 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case ZP12k:
  case ZP13k:
  case ZP20k:
  case ZM12k:
  case ZM13k:
  case ZM14k:
  case ZM15k:	P = P + wsprintf (P, " Netmask=%u.%u.%u.%u",
				Cfg->SKW.PC.NMsk.B3, Cfg->SKW.PC.NMsk.B2,
				Cfg->SKW.PC.NMsk.B1, Cfg->SKW.PC.NMsk.B0);
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW5 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case AC40k:
  case ZP12k:
  case ZP13k:
  case ZP20k:
  case ZM12k:
  case ZM13k:
  case ZM14k:
  case ZM15k:	P = P + wsprintf (P, " GlobZeil=%u / Sio2=%u baud",
			Cfg->SKW.PC.GlobZeil,
			GABdi2ext(Cfg->SKW.PC.BaudSio2));
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW6 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case AC40k:
  case ZP12k:
  case ZP13k:
  case ZP20k:
  case ZM12k:
  case ZM13k:
  case ZM14k:
  case ZM15k:	P = P + wsprintf (P, " PBHigh: SZykl=%d BaudPBH=%u baud GerAdr=%u",
			Cfg->SKW.PC.PVB.SZyk,
			PBBdi2ext(Cfg->SKW.PC.PVB.Baud),
			Cfg->SKW.PC.GerAdr);
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

static	LPSTR	DumpSKW7 (LPSTR P, PEDATA Cfg, WORD Mod)

Begin

Switch (Mod)
  case AC40k:
  case ZP12k:
  case ZP13k:
  case ZP20k:
  case ZM12k:
  case ZM13k:
  case ZM14k:
  case ZM15k:	P = P +	wsprintf (P, " PBHigh: maxTel=%u maxAdr=%u",
					Cfg->SKW.PC.maxTel,
					Cfg->SKW.PC.maxAdr);
		break;
Endswitch
P = P + wsprintf (P, "\r\n");
return (P);

End

/*-------------------------------------------------------------------------*/

// Zuweisungsmakro Strukturelement
#define	SEle(x) 	Cfg->x; Off = offsetof(EEDATA,x)
#define	pSEle(x)	&Cfg->x; Off = offsetof(EEDATA,x)

VOID	PASCAL	DumpEEZP20 (int fh, LPVOID Data)

Begin
char	HStr[20];
LPBYTE	P,PDat;
PEDATA	Cfg;
WORD	hw,i,n,Off;
LPLONG	lp;
LONG    hl;

Cfg = (PEDATA) Data; PDat = (LPBYTE) Data;
_FWrite (fh, "\r\n", 2);
P = (LPSTR) &Cfg->EE.ZP20.IP_ETNet; Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Internet=%d.%d.%d.%d",
Off, *(P+0), *(P+1), *(P+2), *(P+3), *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

P = (LPSTR) &Cfg->EE.ZP20.IP_Modem; Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Modem=%d.%d.%d.%d",
Off, *(P+0), *(P+1), *(P+2), *(P+3), *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

P = (LPSTR) &Cfg->EE.ZP20.IP_PHBus; Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   PROVI H-Bus=%d.%d.%d.%d",
Off, *(P+0), *(P+1), *(P+2), *(P+3), *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

P = (LPSTR) &Cfg->EE.ZP20.IP_Bedien; Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Bed. Schnittst.=%d.%d.%d.%d",
Off, *(P+0), *(P+1), *(P+2), *(P+3), *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = SEle(EE.ZP20.MS_ETNet);
hw = wsprintf(Work, "%.2XH:   %.04XH      Maske Internet=255.%d.%d.0\r\n", Off, hw, HIBYTE(hw), LOBYTE(hw));
_FWrite (fh, Work, hw);

hw = SEle(EE.ZP20.MS_Modem);
hw = wsprintf(Work, "%.2XH:   %.04XH      Maske Modem=255.%d.%d.0\r\n", Off, hw, HIBYTE(hw), LOBYTE(hw));
_FWrite (fh, Work, hw);

hw = SEle(EE.ZP20.MS_PHBus);
hw = wsprintf(Work, "%.2XH:   %.04XH      Maske PROVI-H=255.%d.%d.0\r\n", Off, hw, HIBYTE(hw), LOBYTE(hw));
_FWrite (fh, Work, hw);

hw = SEle(EE.ZP20.MS_Bedien);
hw = wsprintf(Work, "%.2XH:   %.04XH      Maske Bed. Schnittst.=255.%d.%d.0\r\n", Off, hw, HIBYTE(hw), LOBYTE(hw));
_FWrite (fh, Work, hw);

hw = Cfg->EE.ZP20.EthCtrl; Off = (LPSTR) &Cfg->EE.ZP20.EthCtrl - PDat;
wsprintf(Work, "%.2XH:   %.04XH      Betriebsart", Off, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = Cfg->EE.ZP20.HWInfo; Off = (LPSTR) &Cfg->EE.ZP20.HWInfo - PDat;
wsprintf(Work, "%.2XH:   %.02XH        Hardware", Off, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

P = (LPBYTE) &Cfg->EE.ZP20.TimeSvr[0];
// erstes Byte von Internet-Adresse;
hl = Cfg->EE.ZP20.IP_ETNet;
memcpy (&hl, P, 3);
Num2Host(HStr, hl);  Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02XH    TimeServer=%s",
Off, *(P+0), *(P+1), *(P+2), HStr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

lp = &Cfg->EE.ZP20.Gatway1; P = (LPBYTE) lp;
Num2Host(HStr, *lp);  Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Gateway1=%s",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

lp = &Cfg->EE.ZP20.HostAd1; P = (LPBYTE) lp;
Num2Host(HStr, *lp); Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Host1=%s",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

lp = &Cfg->EE.ZP20.Gatway2; P = (LPBYTE) lp;
Num2Host(HStr, *lp); Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Gateway2=%s",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

lp = &Cfg->EE.ZP20.HostAd2; P = (LPBYTE) lp;
Num2Host(HStr, *lp); Off = P - PDat;
wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Host2=%s",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);


hw = SEle(EE.ZP20.GWType);
hw = wsprintf(Work, "%.2XH:         %02X%   GW-Type: %s\r\n", Off, hw, CnvGWType(hw));
_FWrite (fh, Work, hw);

hw = SEle(EE.ZP20.GWMode);
hw = wsprintf(Work, "%.2XH:         %02X   GW-Mode\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.ZP20.GW_RW);
hw = wsprintf(Work, "%.2XH:       %04X   GW-R/W\r\n", Off, hw);
_FWrite (fh, Work, hw);


P = (LPBYTE) &Cfg->EE.ZP20.LONMode;  Off = P - PDat;
wsprintf(Work, "%.2XH:   LONMode=%02X\r\n", Off, *P);
_FWrite (fh, Work, strlen(Work));

P = (LPBYTE) &Cfg->EE.ZP20.GWZeil1;  Off = P - PDat;
wsprintf(Work, "%.2XH:   GWZeil_1=%d\r\n", Off, *P);
_FWrite (fh, Work, strlen(Work));

P = (LPBYTE) &Cfg->EE.ZP20.GWZeilen;  Off = P - PDat;
wsprintf(Work, "%.2XH:   GWZeilen=%d\r\n", Off, *P);
_FWrite (fh, Work, strlen(Work));


P = Cfg->EE.ZP20.Hosts;  Off = P - PDat;
wsprintf(Work, "Hosts:\r\n");
_FWrite (fh, Work, strlen(Work));
n = sizeof(Cfg->EE.ZP20.Hosts) / 3;
for (i=0; i<n; i++)
Begin
  wsprintf(Work, "%.2XH:   xx.%d.%d.%d\r\n", Off, *(P+2), *(P+1), *(P+0));
  _FWrite (fh, Work, strlen(Work));  P = P + 3; Off = Off + 3;
Endfor


strcpy(Work, "\042\042\042\r\n\042\042\042\r\n");
_FWrite (fh, Work, strlen(Work));

hw = Cfg->EE.ZP20.SerNr; Off = (LPSTR) &Cfg->EE.ZP20.SerNr - PDat;
wsprintf(Work, "%.2XH:   %.04XH     Serien Nr.: %d", Off, hw, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = Cfg->EE.ZP20.Kalib; Off = (LPSTR) &Cfg->EE.ZP20.Kalib - PDat;
wsprintf(Work, "%.2XH:   %.02XH       Kal.  Wert: %d", Off, hw, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

P = &Cfg->EE.ZP20.day; Off = P - PDat;
wsprintf(Work, "%.2XH:   %02X.%02X.%02X", Off, *(P+0), *(P+1), *(P+2));
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

P = &Cfg->EE.ZP20.Prufer[0]; Off = P - PDat;
memcpy (HStr, P, 10); HStr[10] = 0;
wsprintf(Work, "%.2XH:   Prüfer: %s", Off, HStr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = Cfg->EE.ZP20.Chks; Off = (LPSTR) &Cfg->EE.ZP20.Chks - PDat;
wsprintf(Work, "%.2XH:   %.04XH     Prüfsumme", Off, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

End

/*-------------------------------------------------------------------------*/

VOID	PASCAL	DumpEEAC40 (int fh, LPVOID Data)

Begin
char	HStr[20];
LPBYTE	P;
PEDATA	Cfg;
WORD	hw,i,n,Off;
LPLONG	lp;

Cfg = (PEDATA) Data;  _FWrite (fh, "\r\n", 2);
P = (LPSTR) pSEle(EE.AC40.IP_ETNet);
hw = wsprintf(Work, "%.2XH:   %08X   Ethernet-Adr: %d.%d.%d.%d\r\n",
Off, Cfg->EE.AC40.IP_ETNet, *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, hw);

P = (LPSTR) pSEle(EE.AC40.IP_Modem);
hw = wsprintf(Work, "%.2XH:   %08X   TCP/IP   Adr: %d.%d.%d.%d\r\n",
Off, Cfg->EE.AC40.IP_Modem, *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, hw);

P = (LPSTR) pSEle(EE.AC40.MS_ETNet);
hw = wsprintf(Work, "%.2XH:   %08X   Ethernet-Msk: %d.%d.%d.%d\r\n",
Off, Cfg->EE.AC40.MS_ETNet, *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, hw);

P = (LPSTR) pSEle(EE.AC40.MS_Modem);
hw = wsprintf(Work, "%.2XH:   %08X   Modem-Msk: %d.%d.%d.%d\r\n",
Off, Cfg->EE.AC40.MS_Modem, *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, hw);

P = (LPSTR) pSEle(EE.AC40.PCLSHost);
hw = wsprintf(Work, "%.2XH:   %08X   PCLS-Adr: %d.%d.%d.%d\r\n",
Off, Cfg->EE.AC40.PCLSHost, *(P+3), *(P+2), *(P+1), *(P+0));
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.SioCtrl.CW);
hw = wsprintf(Work, "%.2XH:       %.04X   Sio-Control: %u\r\n", Off, hw, GABdi2ext(hw band 15));
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.TCPCtrl);
hw = wsprintf(Work, "%.2XH:       %.04X   TCP/IP-Ctrl\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.EthCtrl);
hw = wsprintf(Work, "%.2XH:       %.04X   Eth-Control\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.ServPort);
hw = wsprintf(Work, "%.2XH:       %.04X   Servport\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.P2P_Ctrl);
hw = wsprintf(Work, "%.2XH:         %.02X   P2P_Ctrl\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.P2P_Seg);
hw = wsprintf(Work, "%.2XH:         %.02X   P2P_Seg\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.Mel_Ctrl);
hw = wsprintf(Work, "%.2XH:       %.04X   MelCntrl\r\n", Off, hw);
_FWrite (fh, Work, hw);

lp = pSEle(EE.AC40.Gatway1); Num2Host(HStr, *lp); P = (LPBYTE) lp;
hw = wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Gateway1=%s\r\n",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, hw);

lp = pSEle(EE.AC40.HostAd1); Num2Host(HStr, *lp); P = (LPBYTE) lp;
hw = wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Host1=%s\r\n",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, hw);

lp = pSEle(EE.AC40.Gatway2); Num2Host(HStr, *lp); P = (LPBYTE) lp;
hw = wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Gateway2=%s\r\n",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, hw);

lp = pSEle(EE.AC40.HostAd2); Num2Host(HStr, *lp); P = (LPBYTE) lp;
hw = wsprintf(Work, "%.2XH:   %.02X%.02X%.02X%.02X   Host2=%s\r\n",
Off, *(P+0), *(P+1), *(P+2), *(P+3), HStr);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.GWType);
hw = wsprintf(Work, "%.2XH:         %02X%   GW-Type: %s\r\n", Off, hw, CnvGWType(hw));
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.GWMode);
hw = wsprintf(Work, "%.2XH:         %02X   GW-Mode\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.GW_RW);
hw = wsprintf(Work, "%.2XH:       %04X   GW-R/W\r\n", Off, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.LONMode);
wsprintf(Work, "%.2XH:         %02X   LONMode\r\n", Off, hw);
_FWrite (fh, Work, strlen(Work));

hw = SEle(EE.AC40.CC.B);
wsprintf(Work, "%.2XH:         %02X   CAN-Info\r\n", Off, hw);
_FWrite (fh, Work, strlen(Work));

hw = SEle(EE.AC40.GWZeil1);
hw = wsprintf(Work, "%.2XH:       %04X   GW-Zeil1=%d\r\n", Off, hw, hw);
_FWrite (fh, Work, hw);

hw = SEle(EE.AC40.GWZeilen);
hw = wsprintf(Work, "%.2XH:       %04X   GW-Zeilen=%d\r\n", Off, hw, hw);
_FWrite (fh, Work, hw);


P = (LPSTR) pSEle(EE.AC40.Hosts);
hw = wsprintf(Work, "Hosts:\r\n");
_FWrite (fh, Work, hw);
n = sizeof(Cfg->EE.AC40.Hosts) / 4;
for (i=0; i<n; i++)
Begin
  wsprintf(Work, "%.2XH:  %d.%d.%d.%d\r\n", Off, *(P+3), *(P+2), *(P+1), *(P+0));
  _FWrite (fh, Work, strlen(Work));  P = P + 4; Off = Off + 4;
Endfor


strcpy(Work, "\042\042\042\r\n\042\042\042\r\n");
_FWrite (fh, Work, strlen(Work));

pSEle(EE.AC40.HandBD);
hw = wsprintf(Work, "%.2XH:         %02X   Handbedienung\r\n", Off, Cfg->EE.AC40.HandBD);
_FWrite (fh, Work, hw);

pSEle(EE.AC40.LEDTrace);
hw = wsprintf(Work, "%.2XH:         %02X   LED Anzeige\r\n", Off, Cfg->EE.AC40.LEDTrace);
_FWrite (fh, Work, hw);



End

/*-------------------------------------------------------------------------*/

VOID	PASCAL	DumpEEData (LPSTR File, LPVOID Data)

Begin
PEDATA	Cfg;
CONTROL	*KW;
PSTBDAT	SK;
int	fh,TId;
WORD	i,j,n,hw;
WORD	MHd,Off;
LPBYTE	P,Modul,PDat;

fh = _FOpen (File, OF_CREATE);
if (fh < 2) return;

Cfg = (PEDATA) Data; PDat = (LPBYTE) Data;
n = wsprintf(Work, "EEPROM-Daten:\r\n");
_FWrite (fh, Work, n); P = Work;

n = wsprintf(Work, "00H: %.4XH chks\r\n", Cfg->chks);
_FWrite (fh, Work, n); Modul = DusTyp2Name (Cfg);
MHd = GetModHandle (Modul);

for (KW=&Cfg->KW[0],i=0; i<MaxIZ; i++,KW++)
Begin
  P = P + wsprintf(P, "%.2XH: %.4XH KW[%.2u] ", (1+i)<<1, KW->CW, i);
  TId = GetTypId (MHd, i);
  Switch (TId)
    case ZL_fik:	strcpy(P, "fiktiv"); break;
    case ZL_mb:		strcpy(P, "mb    "); break;
    case ZL_mb01:	strcpy(P, "mb01  "); break;
    case ZL_mb23:	strcpy(P, "mb23  "); break;
    case ZL_mbER:	strcpy(P, "mb_ER "); break;
    case ZL_IRZ:	strcpy(P, "Int-ZW"); break;
    case ZL_HWZ:	strcpy(P, "HW -ZW"); break;
    case ZL_aa:		strcpy(P, "aa    "); break;
    case ZL_aMW:	strcpy(P, "mw a/p"); break;
    case ZL_pMW:	strcpy(P, "mw   p"); break;
    case ZL_eib:	strcpy(P, "eib   "); break;
    default:		strcpy(P, "???   ");
  Endswitch

  for (SK=Cfg->SKW.SK,j=0; j<MaxSK; j++,SK++)
  Begin
    if (SK->SB.MwZeil eq i and IsSTValid(Cfg, j))
    Then
      strcat (P, " 1)");	/* 3-Pkt Stellbef zugeordnet */
    Endif
  Endfor

  if (IsSTused(Cfg, i))
  Then
    strcat (P, " 2)");	/* als ST verwendet (ER) */
  Endif
  P = Work + strlen(Work);

  if (KW->V1.Used)
  Then
    P = P + wsprintf(P, " Fkt=%d Inf=%d", KW->V1.Fkt, KW->V1.Info);

    Switch (TId)
      case ZL_mb01:
      case ZL_mbER:
      case ZL_mb23:	if (i eq 0 or i eq 2)	strcpy(P," (Bits 0-7) ");
      			else			strcpy(P," (Bits 8-15)");
			P = P + strlen(P);
			break;
    Endswitch

    wsprintf(P, " Zeile=%d", KW->V1.Zeile);
  Else	// not used
    Switch (TId)
      case ZL_mb01:	// i = 0 1 2 3
      case ZL_mbER:	// j = 1 0 3 2
      case ZL_mb23:	j = 1 + ((i>>1)<<2) - i;
			if (Cfg->KW[j].V1.Used )
			Then
			  P = P + wsprintf(P, " Fkt=%d", KW->V1.Fkt);
			  P = P + wsprintf(P, " Inf=%d", KW->V1.Info);
			  if (i eq 0 or i eq 2)	strcpy(P," (Bits 0-7) ");
      	  else						strcpy(P," (Bits 8-15)");
//			  P = P + strlen(P);
			Endif
			break;

      case ZL_fik:	if (KW->V1.Fkt eq 1 or KW->V1.Fkt eq 4)
			Then
			  P = P + wsprintf(P, " Fkt=%d", KW->V1.Fkt);
			  wsprintf(P, " Inf=%d", KW->V1.Info);
			Endif
			break;
    Endswitch
  Endif
  _FWrite (fh, Work, strlen(Work));
  P = Work;
  _FWrite (fh, "\r\n", 2);
Endfor

for (SK=Cfg->SKW.SK,i=0; i<MaxSK; i++,SK++)
Begin
  hw = (1+MaxIZ+i)<<1;
  P = P + wsprintf(P, "%.2XH: %.4XH SK[%.2u]", hw, SK->CW, i);
  if (IsSTValid (Cfg, i))
  Then
    wsprintf(P, " MwZeile=%d VZeit=%d\r\n", SK->SB.MwZeil, SK->SB.VZeit);
  Else
    (*DmpFnk[i]) (P, Cfg, GetModInfo(MHd, MOD_bintp, NULL));
  Endif
  _FWrite (fh, Work, strlen(Work)); P = Work;
Endfor

Off = &Cfg->SW.B - PDat;
wsprintf(Work, "%.2XH: %.4XH TypWrd SW=%.2XH HW=%.2XH %s",
		  Off, ((Cfg->HW_Typ)<<8) + Cfg->SW.B,
	    /* auch fuer 29ER10 */
	     Cfg->SW.B, Cfg->HW_Typ, Modul);

_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

Off = &Cfg->UsNr - PDat;
wsprintf(Work, "%.2XH:   %.2XH UsNr %u", Off, Cfg->UsNr, Cfg->UsNr );
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

Off = &Cfg->GA.BaudGA - PDat;
wsprintf(Work, "%.2XH:   %.2XH BaudGA %u bd",
	     Off, Cfg->GA.GAB.Baud, GABdi2ext(Cfg->GA.GAB.Baud) );
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

Off = (LPSTR) &Cfg->rs_485.CW - PDat;
wsprintf(Work, "%.2XH: %.4XH SZykl=%u BaudPB=%u bd  GerAdr=%u",
	     Off, Cfg->rs_485.CW, Cfg->rs_485.V1.PVB.SZyk,
	     PBBdi2ext(Cfg->rs_485.V1.PVB.Baud), Cfg->rs_485.V1.GerAdr);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = Cfg->max485.V1.maxAdr;  Off = (LPSTR) &Cfg->max485.CW - PDat;
wsprintf(Work, "%.2XH:   %.2XH maxAdr=%u", Off, hw, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = Cfg->max485.V1.maxTel; Off++;
wsprintf(Work, "%.2XH:   %.2XH maxTel=%u", Off, hw, hw );
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = Cfg->LED_ms;  Off = &Cfg->LED_ms - PDat;
wsprintf(Work, "%.2XH:   %.2XH LED_ms=%u", Off, hw, hw);
_FWrite (fh, Work, strlen(Work));  _FWrite (fh, "\r\n", 2);

hw = SEle(Imp_Sio);
if (GetModInfo(MHd, MOD_fbmod, NULL))
Then
  hw = wsprintf(Work, "%.2XH:   %.2XH ImpTime=%u\r\n", Off, hw, hw);
Else
  hw = wsprintf(Work, "%.2XH:   %.2XH Baud=%u\r\n", Off, hw, GABdi2ext(hw));
Endif
_FWrite (fh, Work, hw);


Switch (MHd)
  case ZP20i:	DumpEEZP20 (fh, Data);
		break;
  case AC40i:
  case ER12i:	DumpEEAC40 (fh, Data);
		break;
Endswitch

_FClose (fh);

End
