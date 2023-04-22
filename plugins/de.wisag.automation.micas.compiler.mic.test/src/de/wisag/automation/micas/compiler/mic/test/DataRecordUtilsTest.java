package de.wisag.automation.micas.compiler.mic.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Before;
import org.junit.Test;

import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.DataRecordUtils;
import de.wisag.automation.micas.h86.H86Factory;
import de.wisag.automation.micas.h86.RecordType;

public class DataRecordUtilsTest {

    @Before
    public void setUp() throws Exception {
        H86Factory.eINSTANCE.eClass();
    }

    @Test
    public void testCreateOneDataRecords() {
        byte[] data = generateData(16);
        List<DataRecord> records = DataRecordUtils.createDataRecords(data, 0, 0, data.length);
        assertEquals(1, records.size());
        DataRecord record = records.get(0);
        assertEquals(record.getAddress(), 0);
        assertEquals(record.getNumberOfBytes(), 16);
        assertEquals(record.getType(), RecordType.DATA);
        assertTrue(Arrays.equals(record.getData(), data));
    }

    @Test
    public void testCreateTwoDataRecords() {
        byte[] data = generateData(17);
        List<DataRecord> records = DataRecordUtils.createDataRecords(data, 0, 0, data.length);
        assertEquals(2, records.size());

        DataRecord record0 = records.get(0);
        assertEquals(record0.getAddress(), 0);
        assertEquals(record0.getNumberOfBytes(), 16);
        assertEquals(record0.getType(), RecordType.DATA);
        assertTrue(Arrays.equals(record0.getData(), Arrays.copyOf(data, 16)));

        DataRecord record1 = records.get(1);
        assertEquals(record1.getAddress(), 16);
        assertEquals(record1.getNumberOfBytes(), 1);
        assertEquals(record1.getType(), RecordType.DATA);
        // assertTrue(Arrays.equals(record1.getData(),Arrays.copyOf(data,16)));
    }

    @Test
    public void testCreateSmallDataRecords() {
        byte[] data = generateData(6);
        List<DataRecord> records = DataRecordUtils.createDataRecords(data, 0, 0, data.length);
        assertEquals(1, records.size());
        DataRecord record0 = records.get(0);
        assertEquals(record0.getAddress(), 0);
        assertEquals(record0.getNumberOfBytes(), 6);
        assertEquals(record0.getType(), RecordType.DATA);
        assertTrue(Arrays.equals(record0.getData(), Arrays.copyOf(data, data.length)));
    }

    @Test
    public void testCreateSmallSubDataRecords() {
        byte[] data = generateData(100);
        List<DataRecord> records = DataRecordUtils.createDataRecords(data, 11, 98, 2);
        assertEquals(1, records.size());
        DataRecord record0 = records.get(0);
        assertEquals(11, record0.getAddress());
        assertEquals(record0.getNumberOfBytes(), 2);
        assertEquals(record0.getType(), RecordType.DATA);
        // assertTrue(Arrays.equals(record0.getData(),Arrays.copyOf(data,data.length)));
    }

    @Test
    public void testCreateSubDataRecords() {
        byte[] data = generateData(100);
        int startIndex = 60;
        data[startIndex++] = (byte) 0xa0;
        data[startIndex++] = (byte) 0xa1;
        data[startIndex++] = (byte) 0xa2;
        data[startIndex++] = (byte) 0xa3;
        data[startIndex++] = (byte) 0xa4;
        int length = 5;
        List<DataRecord> records = DataRecordUtils.createDataRecords(data, 0, 60, length);
        assertEquals(1, records.size());
        DataRecord record0 = records.get(0);
        assertEquals(0, record0.getAddress());
        assertEquals(record0.getNumberOfBytes(), 5);
        assertEquals(record0.getType(), RecordType.DATA);
        byte[] data2 = ArrayUtils.subarray(data, 60, 65);
        byte[] data3 = record0.getData();
        assertTrue(data3.length == length);
        assertTrue(Arrays.equals(data2, data3));
    }

    private byte[] generateData(int count) {
        byte[] data = new byte[count];
        Arrays.fill(data, (byte) 0);
        return data;
    }

}
