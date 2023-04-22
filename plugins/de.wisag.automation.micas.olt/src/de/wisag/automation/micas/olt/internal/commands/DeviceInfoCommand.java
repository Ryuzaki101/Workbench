package de.wisag.automation.micas.olt.internal.commands;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.DeviceFactory;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.internal.DeviceCommands;

public class DeviceInfoCommand extends DeviceCommand<DeviceInfo> {

    protected static final Pattern PA_ADDRESS_PATTERN = Pattern.compile("^Adr\\s+PA\\s=\\s([a-f0-9]{4}):([a-f0-9]{4})",
            Pattern.CASE_INSENSITIVE);
    protected static final Pattern IPV4_ADDR_PATTERN = Pattern.compile(
            "^Internet\\s+addr\\s+:\\s+(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])).*$",
            Pattern.CASE_INSENSITIVE);
    protected static final Pattern IPV4_NETMASK_PATTERN = Pattern.compile(
            "^Internet.+Netmask\\s+:\\s+(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.([01]?\\d\\d?|2[0-4]\\d|25[0-5])).*$",
            Pattern.CASE_INSENSITIVE);

    public DeviceInfoCommand() {

    }

    @Override
    public String getCommandline() {
        return DeviceCommands.CMD_CD;
    }

    @Override
    public DeviceInfo execute(List<String> message) {
        DeviceInfo di = DeviceFactory.eINSTANCE.createDeviceInfo();
        StringBuilder sb = new StringBuilder();
        for (Iterator<String> iterator = message.iterator(); iterator.hasNext();) {
            String s = iterator.next();
            sb.append(s).append("\n");
            Matcher m = null;
            if ((m = PA_ADDRESS_PATTERN.matcher(s)).matches()) {
                int segment = Integer.parseInt(m.group(1));
                int offset = Integer.parseInt(m.group(1), 16);
                Address adr = DeviceFactory.eINSTANCE.createAddress();
                adr.setSegment(segment);
                adr.setOffset(offset);
                di.setProcessImageAddress(adr);
                continue;
            }
            Pattern modulePattern = Pattern.compile("^Modul\\s+:\\s*([A-Z0-9]{6})", Pattern.CASE_INSENSITIVE);
            if ((m = modulePattern.matcher(s)).matches()) {
                String name = StringUtils.trimToEmpty(m.group(1));

                String type = StringUtils.right(name, 4);
                HardwareTypeDefinition hwModule = IHwModulesProvider.INSTANCE.findHardwareTypeDefinition(type);
                if (hwModule == null) {
                    System.err.println("Unsupported hardwaretyp : " + hwModule);
                } else {
                    di.setHardwareType(hwModule.getType());
                    EList<HardwareAlias> aliases = hwModule.getAliases();
                    for (HardwareAlias hardwareAlias : aliases) {
                        if (StringUtils.equalsIgnoreCase(hardwareAlias.getName(), type)) {
                            di.setHardwareAlias(hardwareAlias);
                            break;
                        }
                    }
                }
                di.setModuleName(name);
                continue;
            }
            Pattern serialPattern = Pattern.compile("^Serial\\s+Number.+?(\\d+)", Pattern.CASE_INSENSITIVE);
            if ((m = serialPattern.matcher(s)).matches()) {
                di.setSerial(StringUtils.trimToEmpty(m.group(1)));
                continue;
            }

            Pattern macPattern = Pattern.compile(
                    "^MAC\\s+addr\\s*:\\s*\\b(([a-f0-9]{2}):([a-f0-9]{2}):([a-f0-9]{2}):([a-f0-9]{2}):([a-f0-9]{2}):([a-f0-9]{2}))\\b\\s+.*$",
                    Pattern.CASE_INSENSITIVE);
            if ((m = macPattern.matcher(s)).matches() && m.groupCount() == 7) {
                int m1 = Integer.valueOf(m.group(2), 16);
                int m2 = Integer.valueOf(m.group(3), 16);
                int m3 = Integer.valueOf(m.group(4), 16);
                int m4 = Integer.valueOf(m.group(5), 16);
                int m5 = Integer.valueOf(m.group(6), 16);
                int m6 = Integer.valueOf(m.group(7), 16);
                di.setMacAddress(String.format("%02x:%02x:%02x:%02x:%02x:%02x", m1, m2, m3, m4, m5, m6));
                continue;
            }
            if ((m = IPV4_ADDR_PATTERN.matcher(s)).matches() && m.groupCount() == 5) {
                Integer a1 = Integer.valueOf(m.group(2));
                Integer a2 = Integer.valueOf(m.group(3));
                Integer a3 = Integer.valueOf(m.group(4));
                Integer a4 = Integer.valueOf(m.group(5));
                di.setIpV4Address(String.format("%d.%d.%d.%d", a1, a2, a3, a4));
                continue;
            }
            if ((m = IPV4_NETMASK_PATTERN.matcher(s)).matches()) {
                Integer a1 = Integer.valueOf(m.group(2));
                Integer a2 = Integer.valueOf(m.group(3));
                Integer a3 = Integer.valueOf(m.group(4));
                Integer a4 = Integer.valueOf(m.group(5));
                di.setIpV4Netmask(String.format("%d.%d.%d.%d", a1, a2, a3, a4));
                continue;
            }

            Pattern versionPattern = Pattern.compile("^Version:.*?(.+)", Pattern.CASE_INSENSITIVE);
            if ((m = versionPattern.matcher(s)).matches()) {
                String version = m.group(1);
                // omit strange device answer
                if (StringUtils.indexOf(version, "wait 5 sec!") == -1) {
                    di.setVersion(StringUtils.trimToEmpty(version));
                } else {
                    di.setVersion("<unknown>");
                }
            }

        }
        di.setRawText(sb.toString());
        return di;
    }

}
