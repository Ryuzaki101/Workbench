package de.wisag.automation.micas.h86;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.IOUtils;

import de.wisag.automation.micas.common.binary.SegmentCalulator;

public class H86Utils {

    public static Map<Integer, byte[]> getSegments(String block) throws IOException {
        H86Unmarshaller x = new H86Unmarshaller();
        H86Content data = x.unmarshall(IOUtils.toInputStream(block, H86Unmarshaller.HEXFILE_CHARSET));
        return H86RecordMerger.getSegments(data);
    }

    public static byte[] getSpecificSegments(int segment, String block, int offset) {
        H86Content data = null;
        try {
            data = new H86Unmarshaller().unmarshall(IOUtils.toInputStream(block, H86Unmarshaller.HEXFILE_CHARSET));
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
        Map<Integer, byte[]> segments = H86RecordMerger.getSegments(data);
        int realSegment = SegmentCalulator.addSegmentOffset(segment, offset);
        if (!segments.containsKey(Integer.valueOf(realSegment))) {
            throw new RuntimeException("Access to non existing segment");
        }
        return segments.get(Integer.valueOf(realSegment));
    }

}
