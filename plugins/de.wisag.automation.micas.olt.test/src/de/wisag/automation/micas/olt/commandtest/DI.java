package de.wisag.automation.micas.olt.commandtest;

import java.util.regex.Pattern;

import de.wisag.automation.micas.olt.internal.commands.DeviceInfoCommand;

class DI extends DeviceInfoCommand {
    static Pattern getPaAdrPattern() {
        return PA_ADDRESS_PATTERN;
    }

    static Pattern getIpV4AddrPattern() {
        return IPV4_ADDR_PATTERN;
    }

    static Pattern getIpV4NetmaskPattern() {
        return IPV4_NETMASK_PATTERN;
    }
}