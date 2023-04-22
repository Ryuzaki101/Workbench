package de.wisag.automation.micas.olt;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.internal.commands.ParserException;
import de.wisag.automation.micas.olt.internal.commands.ParserUtils;

public class ParserUtilsTest {

    @Test
    public void testParseDataRange() throws Exception {
        String msg = "0507:09A8 3116 0000 0002 50FF 077D D0EE 7C60 0084";
        DataRange range = ParserUtils.parseDataRange(msg);
        assertEquals(range.getStartAddress().getSegment(), 0x0507);
        assertEquals(range.getStartAddress().getOffset(), 0x09a8);
        assertEquals(range.getValues().get(0), Integer.valueOf(0x3116));
        assertEquals(range.getValues().get(1), Integer.valueOf(0x0));
        assertEquals(range.getValues().get(2), Integer.valueOf(0x0002));
        assertEquals(range.getValues().get(3), Integer.valueOf(0x50FF));
        assertEquals(range.getValues().get(4), Integer.valueOf(0x077D));
        assertEquals(range.getValues().get(5), Integer.valueOf(0xD0EE));
        assertEquals(range.getValues().get(6), Integer.valueOf(0x7C60));
        assertEquals(range.getValues().get(7), Integer.valueOf(0x0084));
    }

    @Test
    public void testParseDataRangeOneElement() throws Exception {
        String msg = "0507:09A8 3116";
        DataRange range = ParserUtils.parseDataRange(msg);
        assertEquals(range.getStartAddress().getSegment(), 0x0507);
        assertEquals(range.getStartAddress().getOffset(), 0x09a8);
        assertEquals(range.getValues().get(0), Integer.valueOf(0x3116));
    }

    @Test
    public void testSingleWordResultParser() {
        String result = ":000C 7700 \r\n*";
        // result = StringUtils.remove(result, '\r');
        // result = StringUtils.remove(result, '\n');
        int value = ParserUtils.parseSingleWordValue(result);
        assertEquals(0x7700, value);

        value = ParserUtils.parseSingleWordValue("Bratkartoffel");
        assertEquals(Integer.MIN_VALUE, value);

        System.out.println(value);
        // assertTrue(m.matches());
        // assertEquals(2,m.groupCount());
        // assertEquals("000C",m.group(1));
        // assertEquals("7700",m.group(2));

    }

    @Test
    public void testGetResultLineParser() throws Exception {
        String line = "<80,82,00,00,00,1B,2A,00,00,00,00,00,40,01,00,00,00,00,00,ff>";

        int[] lineValues = new int[] { 0x80, 0x82, 0x00, 0x00, 0x00, 0x1B, 0x2A, 0x00, 0x00, 0x00, 0x00, 0x00, 0x40,
                0x01, 0x00, 0x00, 0x00, 0x00, 0x00, 0xff };
        int[] values = ParserUtils.parseGetResultLineAsByteValues(line);
        assertEquals(lineValues.length, values.length);
        assertArrayEquals(lineValues, values);

        int[] values2 = ParserUtils.parseGetResultLineAsByteValues("<ff>");
        assertEquals(1, values2.length);
        assertArrayEquals(new int[] { 0xff }, values2);

        int[] values3 = ParserUtils.parseGetResultLineAsByteValues("<>");
        assertEquals(0, values3.length);
        assertArrayEquals(new int[] {}, values3);
        try {
            ParserUtils.parseGetResultLineAsByteValues("<00,33<");
            fail("Exception not thrown");
        } catch (ParserException e) {

        }
        try {
            ParserUtils.parseGetResultLineAsByteValues("<00,rr>");
            fail("Exception not thrown");
        } catch (NumberFormatException e) {
            // e.printStackTrace();
        }

    }

    @Test
    public void testMultiWordResultParser() {
        String groupedWordData = ":0000 0030 0060 0090 00F0 0100 01E0 7700 0000" + "\r\n"
                + ":0010 0000 0000 0000 0000 0000 0000 0000 0000" + "\r\n"
                + ":0020 0000 0000 0000 0000 0000 0000 5EA7 DA97" + "\r\n"
                + ":0030 0001 0000 0100 0500 0900 0D00 0101 0501" + "\r\n" + "*";

        int length = 32;
        int[] result2 = ParserUtils.parseGroupedWordData(groupedWordData, length);

        int[] expected = new int[] { 0x0030, 0x0060, 0x0090, 0x00f0, 0x0100, 0x01e0, 0x7700, 0x0000,
                //
                0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
                //
                0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x5ea7, 0xda97,
                //
                0x0001, 0x0000, 0x0100, 0x0500, 0x0900, 0x0d00, 0x0101, 0x0501 };
        assertArrayEquals(expected, result2);
    }

    @Test
    public void testMultiWordResultParserWithSegment() {
        String groupedWordData = "7700:0000 0030 0060 0090 00F0 0100 01E0 7700 0000" + "\r\n"
                + ":0010 0000 0000 0000 0000 0000 0000 0000 0000" + "\r\n"
                + ":0020 0000 0000 0000 0000 0000 0000 5EA7 DA97" + "\r\n"
                + ":0030 0001 0000 0100 0500 0900 0D00 0101 0501" + "\r\n" + "*";

        int length = 32;
        int[] result2 = ParserUtils.parseGroupedWordData(groupedWordData, length);

        int[] expected = new int[] { 0x0030, 0x0060, 0x0090, 0x00f0, 0x0100, 0x01e0, 0x7700, 0x0000,
                //
                0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000,
                //
                0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x0000, 0x5ea7, 0xda97,
                //
                0x0001, 0x0000, 0x0100, 0x0500, 0x0900, 0x0d00, 0x0101, 0x0501 };
        assertArrayEquals(expected, result2);
    }

}
