package de.wisag.automation.micas.compiler.modern;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import de.wisag.automation.micas.h86.DataRecord;
import de.wisag.automation.micas.h86.DataRecordUtils;
import de.wisag.automation.micas.h86.H86Factory;

public class CompilerDataRecordTest {

    @Before
    public void setUp() throws Exception {
        H86Factory.eINSTANCE.eClass();
    }

    @Test
    public void testCreateDataRecords() throws Exception {
        byte[] data = new byte[] { Byte.parseByte("46", 16), Byte.parseByte("4C", 16), Byte.parseByte("55", 16),
                Byte.parseByte("49", 16), Byte.parseByte("44", 16), Byte.parseByte("20", 16), Byte.parseByte("50", 16),
                Byte.parseByte("52", 16), Byte.parseByte("4F", 16), Byte.parseByte("46", 16), Byte.parseByte("49", 16),
                Byte.parseByte("4C", 16), Byte.parseByte("45", 16), Byte.parseByte("00", 16), Byte.parseByte("46", 16),
                Byte.parseByte("4C", 16), Byte.parseByte("1e", 16) };
        // byte[] data,int addressOffset, int startIndex, int count
        List<DataRecord> rs = DataRecordUtils.createDataRecords(data, 0, 0, data.length);
        assertEquals(rs.size(), 2);
    }

    @Test
    public void testCreateDataRecordsOne() throws Exception {
        byte[] data = new byte[] { Byte.parseByte("46", 16), Byte.parseByte("4C", 16), Byte.parseByte("55", 16),
                Byte.parseByte("49", 16), Byte.parseByte("44", 16), Byte.parseByte("20", 16), Byte.parseByte("50", 16),
                Byte.parseByte("52", 16), Byte.parseByte("4F", 16), Byte.parseByte("46", 16), Byte.parseByte("49", 16),
                Byte.parseByte("4C", 16), Byte.parseByte("45", 16), Byte.parseByte("00", 16), Byte.parseByte("46", 16),
                Byte.parseByte("4C", 16) };
        List<DataRecord> rs = DataRecordUtils.createDataRecords(data, 0, 0, data.length);
        assertEquals(rs.size(), 1);
    }
}
