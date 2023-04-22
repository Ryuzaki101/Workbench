package de.wisag.automation.micas.h86.internal;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.EOFRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Unmarshaller;
import de.wisag.automation.micas.h86.Record;
import de.wisag.automation.micas.h86.RecordType;

public class H86ParserTest {

    private H86Unmarshaller parser;

    @Before
    public void setUp() {
        parser = new H86Unmarshaller();
    }

    @Test
    public void testEof() throws Exception {
        String data = ":00000001FF";
        Record record = parser.parseRecord(data);
        assertTrue("", record instanceof EOFRecord);
    }

    @Test
    public void testExtendedAddressRecord() throws Exception {
        String data = ":02000002770085";
        Record record = parser.parseRecord(data);
        assertTrue("", record instanceof ExtendedSegmentAddressRecord);
        ExtendedSegmentAddressRecord dataRecord = (ExtendedSegmentAddressRecord) record;
        assertEquals(0x02, dataRecord.getNumberOfBytes());
        assertEquals(RecordType.EXTENDED_SEGMENT_ADDRESS, dataRecord.getType());
        assertEquals(0x7700, dataRecord.getAddress());
    }

    @Test
    public void testRecord() throws Exception {
        String data = ":10246200464C5549442050524F46494C4500464C33";
        Record record = parser.parseRecord(data);
        assertTrue("", record instanceof DataRecord);
        DataRecord dataRecord = (DataRecord) record;
        assertEquals(0x10, dataRecord.getNumberOfBytes());
        assertEquals(0x2462, dataRecord.getAddress());
        assertEquals(RecordType.DATA, dataRecord.getType());
        assertEquals(0x33, dataRecord.getChecksum());
        byte[] testRecord = new byte[] { Byte.parseByte("46", 16), Byte.parseByte("4C", 16), Byte.parseByte("55", 16),
                Byte.parseByte("49", 16), Byte.parseByte("44", 16), Byte.parseByte("20", 16), Byte.parseByte("50", 16),
                Byte.parseByte("52", 16), Byte.parseByte("4F", 16), Byte.parseByte("46", 16), Byte.parseByte("49", 16),
                Byte.parseByte("4C", 16), Byte.parseByte("45", 16), Byte.parseByte("00", 16), Byte.parseByte("46", 16),
                Byte.parseByte("4C", 16) };
        ;
        assertArrayEquals(testRecord, dataRecord.getData());
    }
}
