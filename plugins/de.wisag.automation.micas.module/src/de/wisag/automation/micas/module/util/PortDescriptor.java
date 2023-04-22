package de.wisag.automation.micas.module.util;

import org.eclipselabs.damos.dml.Port;

public class PortDescriptor {

    private final Port port;
    private final String symbolName;

    public PortDescriptor(Port port, String symbolName) {
        this.port = port;
        this.symbolName = symbolName;
    }

    public Port getPort() {
        return port;
    }

    public String getSymbolName() {
        return symbolName;
    }

}
