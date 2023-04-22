package de.wisag.automation.micas.common.binary;

import java.util.Arrays;

import org.eclipse.core.runtime.Assert;

public class ByteArrayBuilder {
    private int current;
    private byte[] data;

    private void ensureCapacity(final int cap) {
        if (cap > data.length) {
            int newLen = 2 * (cap + 1);
            if (newLen <= 0) {
                newLen += 256;
            }
            // if( newLen > maxCapacity) newLen = maxCapacity;
            if (newLen < cap) {
                newLen = cap;
            }
            byte[] d = new byte[newLen];
            System.arraycopy(data, 0, d, 0, data.length);
            data = d;
        }
    }

    /**
     * Constructs a ByteBuilder
     */
    public ByteArrayBuilder() {
        current = 0;
        data = new byte[16];
    }

    /**
     * append one byte
     *
     * @param b
     * @return
     */
    public ByteArrayBuilder append(int b) {
        return append((byte) (b & 0xff));
    }

    /**
     * append one word (two bytes) using short endian order
     *
     * @param value
     */
    public void appendWord(int value) {
        byte b1 = (byte) ((value & 0xff00) >> 8);
        byte b2 = (byte) ((value & 0x00ff));
        append(b2);
        append(b1);
    }

    private ByteArrayBuilder append(byte b) {
        if (current + 1 > data.length) {
            ensureCapacity(current + 16);
        }
        // will throw an exception if insufficient capacity (maxCapacity
        // reached)
        data[current] = b;
        ++current;
        return this;
    }

    public int length() {
        return current;
    }

    @Override
    public String toString() {
        return new String(data, 0, current);
    }

    public byte[] toByteArray() {
        return Arrays.copyOf(data, current);
    }

    public String toHexString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current; i++) {
            sb.append(String.format("%02x", data[i]));
        }
        return sb.toString();
    }

    public void append(byte[] data) {
        Assert.isNotNull(data, "data");
        // TODO: optimize it
        for (int i = 0; i < data.length; i++) {
            byte b = data[i];
            append(b);
        }

    }

}