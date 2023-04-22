package de.wisag.automation.micas.h86.internal;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.ExtendedSegmentAddressRecord;
import de.wisag.automation.micas.h86.H86Factory;
import de.wisag.automation.micas.h86.MicasH86Marshaller;
import de.wisag.automation.micas.h86.RecordType;

public class H86MarshallerTest {

    private MicasH86Marshaller marshaller;

    @Before
    public void setUp() {
        marshaller = new MicasH86Marshaller();
    }

    @Test
    public void testEof() throws Exception {
        String data = ":00000001FF";
        String result = marshaller.marshall(H86Factory.eINSTANCE.createEOFRecord());
        assertEquals(data, result);
    }

    @Test
    public void testExtendedAddressRecord() throws Exception {
        String data = ":02000002770085";
        ExtendedSegmentAddressRecord dataRecord = H86Factory.eINSTANCE.createExtendedSegmentAddressRecord();
        dataRecord.setNumberOfBytes(0x02);
        dataRecord.setType(RecordType.EXTENDED_SEGMENT_ADDRESS);
        dataRecord.setAddress(0x7700);
        String result = marshaller.marshall(dataRecord);
        assertEquals(data, result);
    }

    @Test
    public void testRecord() throws Exception {
        String data = ":10246200464C5549442050524F46494C4500464C33";
        DataRecord dataRecord = H86Factory.eINSTANCE.createDataRecord();
        dataRecord.setAddress(0x2462);
        dataRecord.setType(RecordType.DATA);
        byte[] testRecord = new byte[] { Byte.parseByte("46", 16), Byte.parseByte("4C", 16), Byte.parseByte("55", 16),
                Byte.parseByte("49", 16), Byte.parseByte("44", 16), Byte.parseByte("20", 16), Byte.parseByte("50", 16),
                Byte.parseByte("52", 16), Byte.parseByte("4F", 16), Byte.parseByte("46", 16), Byte.parseByte("49", 16),
                Byte.parseByte("4C", 16), Byte.parseByte("45", 16), Byte.parseByte("00", 16), Byte.parseByte("46", 16),
                Byte.parseByte("4C", 16) };
        dataRecord.setData(testRecord);
        dataRecord.setNumberOfBytes(testRecord.length);
        String result = marshaller.marshall(dataRecord);
        assertEquals(0x33, dataRecord.getChecksum());
        assertEquals(data.toLowerCase(), result.toLowerCase());

    }
}
