package de.wisag.automation.micas.h86;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.ArrayUtils;

import de.wisag.automation.micas.h86.util.H86Switch;

/**
 * Merges H86 DataRecords into one bytearray per segment
 *
 * @author krauter
 */
public class H86RecordMerger extends H86Switch<H86RecordMerger> {
    private HashMap<Integer, byte[]> segments = new HashMap<>();
    int i = 0;
    private Integer currentSegment = null;
    int length = 0;

    @Override
    public H86RecordMerger caseDataRecord(DataRecord record) {
        int address = record.getAddress();
        byte[] deltaBytes = null;
        int delta = address - length;
        if (delta > 0) {
            deltaBytes = new byte[delta];
            Arrays.fill(deltaBytes, (byte) 0);
        } else if (delta < 0) {
            throw new RuntimeException();
        }
        length += record.getData().length + delta;
        byte[] fragment1 = segments.get(currentSegment);
        byte[] fragment2 = deltaBytes != null ? ArrayUtils.addAll(deltaBytes, record.getData()) : record.getData();
        byte[] newData = ArrayUtils.addAll(fragment1, fragment2);
        segments.put(currentSegment, newData);
        i++;
        return super.caseDataRecord(record);
    }

    @Override
    public H86RecordMerger caseExtendedSegmentAddressRecord(ExtendedSegmentAddressRecord object) {
        this.length = 0;
        // allocate a new segment
        Integer seg = Integer.valueOf(object.getAddress());
        if (!segments.containsKey(seg)) {
            segments.put(seg, new byte[0]);
        }
        if (!seg.equals(currentSegment)) {
            currentSegment = seg;
        }
        i = 0;
        return super.caseExtendedSegmentAddressRecord(object);
    }

    private Map<Integer, byte[]> getSegments() {
        return Collections.unmodifiableMap(segments);
    }

    /**
     * @param content
     * @return
     */
    public static Map<Integer, byte[]> getSegments(H86Content content) {
        H86RecordMerger merger = new H86RecordMerger();
        for (Iterator<?> iter = content.getRecords().iterator(); iter.hasNext();) {
            Record eObject = (Record) iter.next();
            merger.doSwitch(eObject);
        }
        return merger.getSegments();
    }
}