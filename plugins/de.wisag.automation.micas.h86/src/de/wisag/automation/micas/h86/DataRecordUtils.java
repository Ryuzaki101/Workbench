package de.wisag.automation.micas.h86;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.core.runtime.Assert;

public class DataRecordUtils {
    private static int H86_DEFAULT_BLOCK_SIZE = 16;

    public static List<DataRecord> createDataRecords(byte[] data, int recordAddress, int startIndex, int count) {
        Assert.isTrue(startIndex < data.length);
        Assert.isTrue((startIndex + count) <= data.length);
        List<DataRecord> dataRecords = new ArrayList<>();
        int rest = count;
        for (int i = startIndex; i < (startIndex + count); i += H86_DEFAULT_BLOCK_SIZE) {
            DataRecord dataRecord = H86Factory.eINSTANCE.createDataRecord();
            dataRecord.setAddress(recordAddress + (i - startIndex));
            dataRecord.setType(RecordType.DATA);
            int blockSize = Math.min(H86_DEFAULT_BLOCK_SIZE, rest);
            byte[] block = ArrayUtils.subarray(data, i, i + blockSize);
            dataRecord.setNumberOfBytes(block.length);
            rest -= block.length;
            dataRecord.setData(block);
            dataRecords.add(dataRecord);
        }
        Assert.isTrue(rest == 0);
        return dataRecords;
    }
}
