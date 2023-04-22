package de.wisag.automation.micas.workbench.licmgr.internal.hwid;

import de.wisag.automation.micas.workbench.licmgr.internal.Policy;

/**
 * This class provides access to unique hardware identifiers
 * <p>
 * <b>WARNING: do not change it, JNI depends on it </b>
 */
public class NativeAccess {
    public final static int GET_VENDOR_ID = 0x0000;
    public final static int PROCESSOR_INFO_AND_FEATURE_BITS = 0x0001;
    public final static int CACHE_AND_TLB_DESCRIPTOR_INFORMATION = 0x0002;
    static {
        try {
            System.loadLibrary("hwid");
        } catch (Error e) {
            Policy.logError(e);
            throw e;
        }
    }

    /**
     * @param info
     * @param reg
     * @return the CPUID
     * @see {@linkplain http://en.wikipedia.org/wiki/CPUID}
     */
    public static native int getCpuId(int info, Registers reg);

    public static native long getSysVolumeSerial();

    public static Registers getCpuVendorId() {
        Registers reg1 = new Registers();
        getCpuId(GET_VENDOR_ID, reg1);
        return reg1;
    }

    public static Registers getCpuProcessorAndFeatures() {
        Registers reg1 = new Registers();
        getCpuId(PROCESSOR_INFO_AND_FEATURE_BITS, reg1);
        return reg1;
    }

    public static Registers getCpuCacheAndTlbDescriptors() {
        Registers reg1 = new Registers();
        getCpuId(CACHE_AND_TLB_DESCRIPTOR_INFORMATION, reg1);
        return reg1;
    }

}
