package de.wisag.automation.micas.workbench.licmgr.internal.hwid;

/**
 * This class holds informations about network interfaces
 */
public class NetworkInterfaceInfo implements Comparable<NetworkInterfaceInfo> {
    private final String name;
    private final String mac;

    public NetworkInterfaceInfo(String name, String mac) {
        super();
        this.name = name;
        this.mac = mac;
    }

    public String getName() {
        return name;
    }

    public String getMac() {
        return mac;
    }

    @Override
    public int compareTo(NetworkInterfaceInfo o) {
        return getName().compareTo(o.getName());
    }

    @Override
    public String toString() {
        return "NetworkInterfaceInfo [name=" + name + ", mac=" + mac + "]";
    }
}