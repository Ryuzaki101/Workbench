package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;

public class CDCommand extends MicasCommand implements ICommand {
    public CDCommand(ClientContext engine) {
        super(engine);
    }

    /**
     * <pre>
     05D9:09A8 3444 0000 0002 50FE 084B D1AC 7C60 0084
     05D9:09B8 03D8 0120 2892 C000 3138 2740 088B 0882
     05D9:09C8 0000 0000 7700 0030 0070 0080 0090 00C0
     05D9:09D8 5292 4F00
     Adr PA = 0000:3444
     Modul  : 29AC40
     EPROM A09,A08: 38  40
     Version: V12.10 12-Nov-2010 18:14:44
     * </pre>
     */
    @Override
    public void execute(CommandRequest request) {
        StringBuilder response = new StringBuilder();
        response.append("05D9:09A8 3444 0000 0002 50FE 084B D1AC 7C60 0084").append(EOL);
        response.append("05D9:09B8 03D8 0120 2892 C000 3138 2740 088B 0882").append(EOL);
        response.append("05D9:09C8 0000 0000 7700 0030 0070 0080 0090 00C0").append(EOL);
        response.append("05D9:09D8 5292 4F00").append(EOL);
        response.append("Adr PA = 0000:3116").append(EOL);
        response.append("Modul  : 29AC40").append(EOL);
        response.append("EPROM A09,A08: 38  40").append(EOL);
        response.append("Version: V127 04-Feb-2008 12:29:12").append(EOL);
        response.append("Factory Data:").append(EOL);
        response.append("Serial Number: 04365").append(EOL);
        response.append("Test Date    : 39-17-2008").append(EOL);
        response.append("Tester       : weis").append(EOL);
        response.append("Trim Factor  : 145").append(EOL);
        response.append("Range Calibration Data:").append(EOL);
        response.append("200 Ohm: 000 - 04062").append(EOL);
        response.append("2  kOhm: 000 - 04014").append(EOL);
        response.append("20 kOhm: 000 - 03956").append(EOL);
        response.append("0-1  V : 000 - 04095").append(EOL);
        response.append("0-10 V : 000 - 04095").append(EOL);
        response.append("Temperature  : 38.5 �C  Max reached  : 45.5 �C").append(EOL);
        response.append("Different work parameters:").append(EOL);
        response.append("Pulsetime for commands:  400 ms").append(EOL);
        response.append("Delaytime for coming Msg: 10 ms").append(EOL);
        response.append("Holdtime  for going  Msg: 10 ms").append(EOL);
        response.append("HMI works at Sio").append(EOL);
        response.append("Baudrate for Sio: 9600 Baud").append(EOL);
        response.append("Sio works with XON<->XOFF (SW) hand shake").append(EOL);
        response.append("Ethernet chip: AM79C960").append(EOL);
        response.append("MAC addr: 00:00:c4:a0:11:0d  Used connector: 10B-T (twisted pair)").append(EOL);
        response.append("Internet addr : 172.016.000.133  Netmask : 255.255.000.000 (172.016.000.000)").append(EOL);
        response.append("This interface is default interface of TCP/IP").append(EOL);
        response.append("GA2000-Bus works with Ethernet").append(EOL);
        response.append("GA2000 works with US-Nr: 00").append(EOL);
        response.append("Parameters from EEPROM for PROVI-Bus:").append(EOL);
        response.append("GerAdr:   2  MaxAdr:  32  MaxTelAnz:   8  StoerZyklen:  2  Baudrate: 19200").append(EOL);
        response.append("Minimal priority of messages which are sent as events (to PC-LS or ICA): 0").append(EOL);
        response.append("ZLT works with US-Nr: 00").append(EOL);
        getContext().write(response.toString());
    }

}
