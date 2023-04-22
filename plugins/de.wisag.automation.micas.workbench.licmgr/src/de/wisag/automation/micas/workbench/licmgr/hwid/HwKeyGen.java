package de.wisag.automation.micas.workbench.licmgr.hwid;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import de.wisag.automation.micas.common.hashing.DigestUtils;
import de.wisag.automation.micas.workbench.licmgr.internal.Policy;
import de.wisag.automation.micas.workbench.licmgr.internal.hwid.HwKeyGenException;
import de.wisag.automation.micas.workbench.licmgr.internal.hwid.NativeAccess;
import de.wisag.automation.micas.workbench.licmgr.internal.hwid.NetworkInterfaceInfo;

/**
 * This class calculates a hash of the current hardware
 */
public class HwKeyGen {

    /**
     * This function calculates a id for the available hardware
     * <p>
     *
     * @return current hardware id
     */
    public static String getHardwareId() {
        StringBuilder sb = new StringBuilder();
        sb.append(getSysVolumeSignature());
        Policy.logInfo(String.format("HwId: %s", sb.toString()));
        return DigestUtils.calculateSha256Hash(sb.toString());
    }

    /**
     * This method reads the Serial number of the System Volume.
     *
     * @return
     */
    public static String getSysVolumeSignature() {
        return String.format("%016x", NativeAccess.getSysVolumeSerial());
    }

    public static String getNicsSignature(boolean onlyFirst) {
        List<NetworkInterfaceInfo> interfaceInfos = getNetworkInterfaceInfos();
        StringBuilder sb = new StringBuilder();
        if (onlyFirst) {
            if (!interfaceInfos.isEmpty()) {
                // use only the first interface, which provides a MAC address
                sb.append(interfaceInfos.iterator().next().getMac());
            }
        } else {
            for (NetworkInterfaceInfo info : interfaceInfos) {
                sb.append(info.getMac());
            }
        }
        return sb.toString();
    }

    /**
     * Calculate the signature of the current CPU. The CPUID instruction is
     * used.
     * <p>
     * First call CPUID EAX=0x0000
     * <p>
     * Second call: CPUID EAX=0x0001 EAX,ECX,EDX are used as an signature Third
     * call: CPUID EAX=0x0002 EAX,EBX,ECX,EDX are used as an signature
     *
     * @return
     */
    static String getCpuSignature() {
        StringBuilder sb = new StringBuilder();
        sb.append("1e8b6fa02e774f9c8d328e114bdc1228");
        return sb.toString();

        /**
         * mkr : 2016.05.01 ignore CPUID. since on multiprocessor systems they
         * may be change on boot Registers reg = new Registers(); if (-1 !=
         * NativeAccess.getCpuId(NativeAccess.GET_VENDOR_ID, reg)) { int
         * maxLevel = reg.eax; // Processor Info and Feature Bits Registers
         * infoAndFeatures = new Registers(); if (maxLevel > 1) {
         * infoAndFeatures = NativeAccess.getCpuProcessorAndFeatures(); }
         * sb.append(infoAndFeatures.toSignature(Registers.EAX|Registers.ECX|
         * Registers.EDX)); // EAX=2: Cache and TLB Descriptor information
         * Registers cachAndTlbDescriptors = new Registers(); if (maxLevel > 2)
         * { cachAndTlbDescriptors =
         * NativeAccess.getCpuCacheAndTlbDescriptors(); }
         * sb.append(cachAndTlbDescriptors.toSignature()); } else {
         * sb.append(StringUtils.repeat("0", 64)); } return sb.toString();
         */
    }

    /**
     * Query the current network interface Infos.
     * <p>
     * Only wired interfaces are considered The List is sorted
     *
     * @return
     */
    private static List<NetworkInterfaceInfo> getNetworkInterfaceInfos() {
        List<NetworkInterfaceInfo> interfaceInfos = new ArrayList<>();
        Enumeration<NetworkInterface> nis = null;
        try {
            nis = NetworkInterface.getNetworkInterfaces();
        } catch (SocketException e) {
            throw new HwKeyGenException("Error get Network Interfaces", e);
        }
        if (nis == null) {
            return Collections.emptyList();
        }
        while (nis.hasMoreElements()) {
            NetworkInterface ni = nis.nextElement();
            try {
                if (ni.isLoopback() || ni.isPointToPoint() || ni.isVirtual()) {
                    continue;
                }
            } catch (SocketException e) {
                continue;
            }
            if (!StringUtils.startsWith(ni.getName(), "eth")) {
                continue;
            }
            StringBuilder macBuilder = new StringBuilder();
            byte[] mac;
            try {
                mac = ni.getHardwareAddress();
                if (mac == null) {
                    continue;
                }
            } catch (SocketException e) {
                throw new HwKeyGenException("Error get Interface macaddress", e);
            }
            for (int i = 0; i < mac.length; i++) {
                byte b = mac[i];
                macBuilder.append(String.format("%02x", b));
            }
            interfaceInfos.add(new NetworkInterfaceInfo(ni.getName(), macBuilder.toString()));
        }
        Collections.sort(interfaceInfos);
        return interfaceInfos;
    }
}
