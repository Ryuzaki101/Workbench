package de.wisag.automation.micas.workbench.licmgr.internal.hwid;

import org.apache.commons.codec.binary.Hex;

/**
 * This class represents CPU Registers <b>WARNING: do not rename this class, its
 * acessed from JNI </b>
 */
public class Registers {
    public final static int EAX = 1 << 1;
    public final static int EBX = 1 << 2;
    public final static int ECX = 1 << 3;
    public final static int EDX = 1 << 4;
    /** */
    public final static int ALL = EAX | EBX | ECX | EDX;
    /** cpu register eax */
    public int eax = 0;
    /** cpu register ebx */
    public int ebx = 0;
    /** cpu register ecx */
    public int ecx = 0;
    /** cpu register edx */
    public int edx = 0;

    public String toSignature() {
        return toSignature(ALL);
    }

    public String toSignature(int includedRegisters) {
        StringBuilder sb = new StringBuilder();
        if ((includedRegisters & EAX) != 0) {
            sb.append(Hex.encodeHex(intToByteArray(this.eax)));
        } else {
            sb.append(Hex.encodeHex(intToByteArray(0)));
        }
        if ((includedRegisters & EBX) != 0) {
            sb.append(Hex.encodeHex(intToByteArray(this.ebx)));
        } else {
            sb.append(Hex.encodeHex(intToByteArray(0)));
        }
        if ((includedRegisters & ECX) != 0) {
            sb.append(Hex.encodeHex(intToByteArray(this.ecx)));
        } else {
            sb.append(Hex.encodeHex(intToByteArray(0)));
        }
        if ((includedRegisters & EDX) != 0) {
            sb.append(Hex.encodeHex(intToByteArray(this.ecx)));
        } else {
            sb.append(Hex.encodeHex(intToByteArray(0)));
        }
        return sb.toString();
    }

    private static final byte[] intToByteArray(int value) {
        return new byte[] { (byte) (value >>> 24), (byte) (value >>> 16), (byte) (value >>> 8), (byte) value };
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + eax;
        result = prime * result + ebx;
        result = prime * result + ecx;
        result = prime * result + edx;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Registers other = (Registers) obj;
        if (eax != other.eax) {
            return false;
        }
        if (ebx != other.ebx) {
            return false;
        }
        if (ecx != other.ecx) {
            return false;
        }
        if (edx != other.edx) {
            return false;
        }
        return true;
    }
}
