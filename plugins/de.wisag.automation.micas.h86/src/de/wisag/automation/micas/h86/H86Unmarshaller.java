package de.wisag.automation.micas.h86;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

/**
 * Simple Intel-Hex parser
 *
 * @see {@link http://www.keil.com/support/docs/1584.htm}
 * @author krauter
 */
public class H86Unmarshaller implements IH86Unmarshaller {

    public static final String HEXFILE_CHARSET = "iso-8859-1";
    private static final int HEX_RADIX = 16;
    private static final int TYPE_INDEX = 7;
    private static final int ADDRESS_INDEX = 3;
    private static final int BYTECOUNT_INDEX = 1;

    /*
     * (non-Javadoc)
     *
     * @see
     * de.wisag.automation.micas.h86.IMicasH86Parser#parse(java.io.InputStream)
     */
    @Override
    public H86Content unmarshall(InputStream is) throws IOException {
        H86Content content = H86Factory.eINSTANCE.createH86Content();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName(HEXFILE_CHARSET)));
        String line = null;
        try {
            while ((line = br.readLine()) != null) {
                Record record = parseRecord(line);
                if (record == null) {
                    continue;
                }
                content.getRecords().add(record);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            IOUtils.closeQuietly(is);
        }
        return content;
    }

    public Record parseRecord(String line) {
        // not spec, but allow something like a comment
        if (';' == line.charAt(0)) {
            return null;
        }
        if (':' != line.charAt(0)) {
            throw new IllegalArgumentException("'line' must start with ':' char;line was : " + line);
        }

        int byteCount = Integer.valueOf(StringUtils.mid(line, BYTECOUNT_INDEX, 2), HEX_RADIX);
        int address = Integer.valueOf(StringUtils.mid(line, ADDRESS_INDEX, 4), HEX_RADIX);
        int type = NumberUtils.toInt(StringUtils.mid(line, TYPE_INDEX, 2), -1);
        int checksum = Integer.valueOf(StringUtils.right(line, 2), HEX_RADIX);
        String hexData = StringUtils.mid(line, 9, 2 * byteCount);

        byte[] binaryData = new byte[byteCount];
        for (int i = 0; i < byteCount; i++) {
            String hex = StringUtils.mid(hexData, i * 2, 2);
            binaryData[i] = (byte) (Integer.valueOf(hex, HEX_RADIX) & 0xff);
        }
        Record record = null;
        switch (type) {
        case RecordType.DATA_VALUE:
            DataRecord dataRecord = H86Factory.eINSTANCE.createDataRecord();
            dataRecord.setType(RecordType.DATA);
            dataRecord.setChecksum(checksum);
            dataRecord.setAddress(address);
            dataRecord.setNumberOfBytes(byteCount);
            dataRecord.setData(binaryData);
            record = dataRecord;
            break;
        case RecordType.EOF_VALUE:
            record = H86Factory.eINSTANCE.createEOFRecord();
            record.setType(RecordType.EOF);
            break;
        case RecordType.EXTENDED_SEGMENT_ADDRESS_VALUE:
            ExtendedSegmentAddressRecord extendedSegmentAddress = H86Factory.eINSTANCE
                    .createExtendedSegmentAddressRecord();
            extendedSegmentAddress.setType(RecordType.EXTENDED_SEGMENT_ADDRESS);
            extendedSegmentAddress.setNumberOfBytes(byteCount);
            int extendedAddress = 0;
            extendedAddress += (binaryData[1] & 0xff) << 0;
            extendedAddress += (binaryData[0] & 0xff) << 8;
            extendedSegmentAddress.setAddress(extendedAddress);
            record = extendedSegmentAddress;
            break;
        default:
            throw new UnsupportedOperationException("Record Type " + type + " is not supported");
        }
        return record;
    }

}
