package de.wisag.automation.micas.rt;

import org.eclipse.core.runtime.Assert;

public class BinaryUtils {

    public static String hexfmt(int wordValue) {
        return String.format("%04x", wordValue).toUpperCase();
    }

    /**
     * get an unsigned short value from a byte array
     *
     * @param data
     *            the byte array
     * @param offset
     *            a starting offset into the byte array
     * @return the unsigned short (16-bit) value in an integer
     */
    public static int getUShort(byte[] data, int offset) {
        Assert.isNotNull(data, "data must not be null");
        Assert.isLegal(offset < data.length,
                String.format("offset %04x greater than DataSegment length %04x", offset, data.length));
        int b0 = data[offset] & 0xFF;
        int b1 = data[offset + 1] & 0xFF;
        return (b1 << 8) + (b0 << 0);
    }

    /**
     * get an int value from a byte array
     *
     * @param data
     *            the byte array
     * @param offset
     *            a starting offset into the byte array
     * @return the int (32-bit) value
     */
    public static int getInt(byte[] data, int offset) {
        int i = offset;
        int b0 = data[i++] & 0xFF;
        int b1 = data[i++] & 0xFF;
        int b2 = data[i++] & 0xFF;
        int b3 = data[i++] & 0xFF;
        return (b3 << 24) + (b2 << 16) + (b1 << 8) + (b0 << 0);
    }

    /**
     * get the unsigned value of a byte.
     *
     * @param data
     *            the byte array.
     * @param offset
     *            a starting offset into the byte array.
     * @return the unsigned value of the byte as a 32 bit integer
     */
    public static int getUnsignedByte(byte[] data, int offset) {
        return data[offset] & 0xFF;
    }

}
