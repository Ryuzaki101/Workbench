package de.wisag.automation.micas.olt.commandtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.internal.commands.DeviceInfoCommand;

public class DeviceInfoCommandTest extends CommandTestCase {

    @Test
    public void testParseDeviceMessage() throws Exception {
        String name = "messages/cd_29AC40_response_message.txt";
        List<String> messages = loadMessages(name);
        DeviceInfo di = new DeviceInfoCommand().execute(messages);
        assertEquals(di.getHardwareType(), HardwareType.ACXX);
        assertEquals("29AC40", di.getModuleName());
        assertEquals("04365", di.getSerial());
        assertEquals("V127 04-Feb-2008 12:29:12", di.getVersion());
        assertEquals("172.16.0.133", di.getIpV4Address());
        assertEquals("00:00:c4:a0:11:0d", di.getMacAddress());
    }

    @Test
    public void testRegexTest() throws Exception {
        Pattern paPattern = DI.getPaAdrPattern();
        Matcher m = null;
        // Adr PA = 0000:3116
        if ((m = paPattern.matcher("Adr PA = 0000:3116")).matches()) {
            assertEquals(2, m.groupCount());
            int s = Integer.parseInt(m.group(1), 16);
            assertEquals(0, s);
            int o = Integer.parseInt(m.group(2), 16);
            assertEquals(0x3116, o);

        } else {
            fail("Pa pattern not matches");
        }
        testIp("172.016.000.133", "255.255.000.000");
        testIp("10.0.0.10", "255.255.255.0");
    }

    private void testIp(String ipAddress, String netmask) {
        Matcher m;
        if ((m = DI.getIpV4AddrPattern()
                .matcher(String.format("Internet addr : %s  Netmask : %s (172.016.000.000)", ipAddress, netmask)))
                        .matches()) {
            assertEquals(5, m.groupCount());
            assertEquals(ipAddress, m.group(1));
        } else {
            fail("Ip pattern not matches ip: " + ipAddress);
        }
        if ((m = DI.getIpV4NetmaskPattern()
                .matcher(String.format("Internet addr : %s  Netmask : %s (172.016.000.000)", ipAddress, netmask)))
                        .matches()) {
            assertEquals(5, m.groupCount());
            assertEquals(netmask, m.group(1));
        } else {
            fail("Ip pattern not matches netmask: " + netmask);
        }
    }

}
