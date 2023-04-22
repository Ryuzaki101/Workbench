package de.wisag.automation.micas.h86;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.common.binary.ByteArrayBuilder;
import de.wisag.automation.micas.h86.util.H86Switch;

public class MicasH86Marshaller extends H86Switch<MicasH86Marshaller> {
    private StringBuffer buffer;
    private static String SEPARATOR = "\r\n";

    @Override
    public MicasH86Marshaller caseEOFRecord(EOFRecord object) {
        this.buffer.append(marshall(object));
        this.buffer.append(SEPARATOR);
        return null;
    }

    public String marshall(EOFRecord createEOFRecord) {
        return ":00000001FF";
    }

    @Override
    public MicasH86Marshaller caseExtendedSegmentAddressRecord(ExtendedSegmentAddressRecord object) {
        this.buffer.append(marshall(object));
        this.buffer.append(SEPARATOR);
        return null;
    }

    /**
     * Extended Segment Address Records (HEX86) Extended segment address
     * records-also known as HEX86 records-contain bits 4-19 of the data address
     * segment. The extended segment address record always has two data bytes
     * and appears as follows:
     *
     * <pre>
     * :020000021200EA
     *  02 is the number of data bytes in the record.
     *  0000 is the address field. For the extended segment address record, this field is always 0000.
     *  02 is the record type 02 (an extended segment address record).
     *  1200 is the segment of the address.
     *  EA is the checksum of the record and is calculated as
     *  01h + NOT(02h + 00h + 00h + 02h + 12h + 00h).
     * </pre>
     *
     * When an extended segment address record is read, the extended segment
     * address stored in the data field is saved and is applied to subsequent
     * records read from the Intel HEX file. The segment address remains
     * effective until changed by another extended address record. The
     * absolute-memory address of a data record is obtained by adding the
     * address field in the record to the shifted-address data from the extended
     * segment address record. The following example illustrates this process.
     *
     * @param dataRecord
     * @return
     */
    public String marshall(ExtendedSegmentAddressRecord dataRecord) {
        StringBuilder sb = new StringBuilder();
        sb.append(':');
        ByteArrayBuilder bb = new ByteArrayBuilder();
        bb.append(0x02);
        bb.append(0x00);
        bb.append(0x00);
        bb.append(0x02); // dataTypw
        bb.append((dataRecord.getAddress() & 0xff00) >> 8);
        bb.append((dataRecord.getAddress() & 0x00ff));
        byte[] bytes = bb.toByteArray();
        int checksum = 0;
        for (int i = 0; i < bytes.length; i++) {
            checksum += bytes[i];
        }
        // two's complement.
        checksum = (~(checksum & 0xff)) + 1;
        dataRecord.setChecksum(checksum & 0xff);
        bb.append(checksum & 0xff);
        sb.append(bb.toHexString());
        return sb.toString();
    }

    @Override
    public MicasH86Marshaller caseDataRecord(DataRecord object) {
        this.buffer.append(marshall(object));
        this.buffer.append(SEPARATOR);
        return null;
    }

    public String marshall(DataRecord dataRecord) {
        if (dataRecord.getNumberOfBytes() > 0xff) {
            throw new IllegalArgumentException("recordlength > 0xff");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(':');
        ByteArrayBuilder bb = new ByteArrayBuilder();
        bb.append(dataRecord.getNumberOfBytes() & 0xff);
        bb.append((dataRecord.getAddress() & 0xff00) >> 8);
        bb.append((dataRecord.getAddress() & 0x00ff));
        bb.append(0x00);// record type
        byte[] data = dataRecord.getData();
        for (int i = 0; i < data.length; i++) {
            bb.append(data[i]);
        }
        int checksum = 0;
        byte[] bytes = bb.toByteArray();
        for (int i = 0; i < bytes.length; i++) {
            checksum += bytes[i];
        }
        // two's complement.
        checksum %= 256;
        checksum = (~(checksum & 0xff)) + 1;
        bb.append(checksum & 0xff);
        sb.append(bb.toHexString());
        dataRecord.setChecksum(checksum & 0xff);
        return sb.toString();
    }

    public String marshall(H86Content content) {
        this.buffer = new StringBuffer();
        EList<Record> resords = content.getRecords();
        for (Record record : resords) {
            doSwitch(record);
        }
        return StringUtils.upperCase(this.buffer.toString());
    }

}
