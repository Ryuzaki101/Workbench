package de.wisag.automation.micas.common.hashing;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.io.IOUtils;

import de.wisag.automation.micas.common.internal.Policy;

public class DigestUtils {

    /**
     * Compute an md5 Hash from input
     *
     * @param input
     *            input
     *            <p>
     *            <b>Remark:</b> <code>input</code> is closed after computation
     * @return md5-hash as hex value
     */
    public static String computeMd5AndCloseStream(InputStream input) {
        StringBuilder sb = new StringBuilder();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = input.read(buf)) != -1) {
                md.update(buf, 0, i);
            }
            byte[] checksum = md.digest();
            for (int j = 0; j < checksum.length; j++) {
                byte b = checksum[j];
                sb.append(String.format("%02x", b));
            }
        } catch (NoSuchAlgorithmException e) {
            Policy.logError(e);
        } catch (IOException e) {
            Policy.logError(e);
        } finally {
            IOUtils.closeQuietly(input);
        }
        return sb.toString();
    }

    public static byte[] x(byte[] a, byte[] key) {
        byte[] out = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            out[i] = (byte) (a[i] ^ key[i % key.length]);
        }
        return out;
    }

    public static String calculateSha1Hash(String message) {
        MessageDigest sha1sum;
        try {
            sha1sum = MessageDigest.getInstance("SHA1");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            sha1sum.update(message.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Policy.logError(e);
            throw new RuntimeException(e);
        }
        return bytesToHex(sha1sum.digest());
    }

    public static String calculateSha256Hash(String message) {
        MessageDigest sha1sum;
        try {
            sha1sum = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        try {
            sha1sum.update(message.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            Policy.logError(e);
            throw new RuntimeException(e);
        }
        return bytesToHex(sha1sum.digest());
    }

    public static String bytesToHex(byte[] b) {
        char hexDigit[] = { '0', //
                '1', //
                '2', //
                '3', //
                '4', //
                '5', //
                '6', //
                '7', //
                '8', //
                '9', //
                'A', //
                'B', //
                'C', //
                'D', //
                'E', //
                'F' //
        };
        final StringBuffer buf = new StringBuffer();
        for (int j = 0; j < b.length; j++) {
            buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
            buf.append(hexDigit[b[j] & 0x0f]);
        }
        return buf.toString();
    }
}
