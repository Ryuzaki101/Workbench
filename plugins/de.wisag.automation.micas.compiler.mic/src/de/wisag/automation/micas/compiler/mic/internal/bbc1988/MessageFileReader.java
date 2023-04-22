package de.wisag.automation.micas.compiler.mic.internal.bbc1988;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.IOUtils;

public class MessageFileReader {
    public static final String MSG_PREFIX = "msg";
    private static final String MESSAGE_ENCODING = "CP850";
    public static final int RECORD_LENGTH = 8;
    private final byte[] content;

    public MessageFileReader(InputStream is) throws IOException {
        this.content = IOUtils.toByteArray(is);

    }

    private String readMessage(TextRecord indexRecord) throws IOException, UnsupportedEncodingException {
        return new String(readRecordData(indexRecord.getOffset(), indexRecord.getLength()), MESSAGE_ENCODING);
    }

    public Properties getMessages() throws IOException {
        Properties properties = new Properties();
        TextRecord header = readRecord(0, RECORD_LENGTH);
        final int count = header.getNumber();
        for (int i = 1; i <= count; i++) {
            TextRecord record = readRecord(RECORD_LENGTH * i, RECORD_LENGTH);
            if (record != null) {
                String msg = readMessage(record);
                properties.setProperty(String.format(MSG_PREFIX + ".%d", record.getNumber()), msg);
            }
        }
        return properties;

    }

    // private TextRecord findByNumber(final int textNumberToFind) throws
    // IOException {
    // // Erster Satz gibt anzahl der Texte zurück
    // final TextRecord header = readRecord(0, RECORD_LENGTH);
    // final int count = header.getNumber();
    // if (count == 1) {
    // // we have only one record
    // // read the first record
    // final TextRecord record = readRecord(RECORD_LENGTH, RECORD_LENGTH);
    // if (record.getNumber() == textNumberToFind) {
    // record.setText(readMessage(record));
    // return record;
    // } else {
    // return null;
    // }
    // }
    //
    // int a = 0;
    // int b = count;
    // int ia = 0;
    // int i = (a + b) >> 1;
    // TextRecord record = null;
    // while (i != ia) {
    // int currentOffset = RECORD_LENGTH * (i + 1);
    // record = readRecord(currentOffset, RECORD_LENGTH);
    // int distance = textNumberToFind - record.getNumber();
    // if (distance == 0) {
    // record.setText(readMessage(record));
    // // found
    // break;
    // }
    // if (distance > 0) {
    // a = i;
    // } else {
    // b = i;
    // }
    // ia = i;
    // i = (a + b) >> 1;
    // }
    // return null;
    //
    // }

    private TextRecord readRecord(final int offset, final int length) throws IOException {
        return create(readRecordData(offset, length));
    }

    private byte[] readRecordData(final int offset, final int length) throws IOException {
        byte[] buf = new byte[length];
        System.arraycopy(this.content, offset, buf, 0, length);
        return buf;
    }

    private TextRecord create(byte[] buf) {
        int number = buf[0] & 0xFF;
        number += (buf[1] & 0xFF) << 8;

        int length = 0;
        length += buf[2] & 0xFF;
        length += (buf[3] & 0xFF) << 8;

        int offset = buf[4] & 0xFF;
        offset += (buf[5] & 0xFF) << 8;
        offset += (buf[6] & 0xFF) << 16;
        offset += (buf[7] & 0xFF) << 24;
        return new TextRecord(number, length, offset);
    }

    public static void main(String[] args) throws IOException {
        InputStream is = MessageFileReader.class.getResourceAsStream("FMICGER.TXB");
        MessageFileReader msgReader = new MessageFileReader(is);
        Properties messages = msgReader.getMessages();
        Set<Entry<Object, Object>> entries = messages.entrySet();
        for (Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        System.out.println(messages);

    }
}
