package de.wisag.automation.micas.common.binary;

public class EndianUtils {

    public static byte[] asByteArray(int[] littleEndianWords) {
        ByteArrayBuilder bb = new ByteArrayBuilder();
        for (int i = 0; i < littleEndianWords.length; i++) {
            int j = littleEndianWords[i];
            bb.appendWord(j);

        }
        return bb.toByteArray();
    }

}
