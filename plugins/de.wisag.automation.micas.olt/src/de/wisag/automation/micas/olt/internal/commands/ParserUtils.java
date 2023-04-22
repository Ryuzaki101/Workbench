package de.wisag.automation.micas.olt.internal.commands;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import de.wisag.automation.micas.olt.device.Address;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DeviceFactory;

public class ParserUtils {
    public static DataRange parseDataRange(String message) {
        DataRange range = DeviceFactory.eINSTANCE.createDataRange();
        String[] elements = StringUtils.split(message, " ");
        for (int i = 0; i < elements.length; i++) {
            String element = elements[i];
            if (i == 0) {
                String[] addrs = StringUtils.split(element, ':');
                int segment = Integer.parseInt(addrs[0], 16);
                int offset = Integer.parseInt(addrs[1], 16);
                Address addr = DeviceFactory.eINSTANCE.createAddress();
                addr.setSegment(segment);
                addr.setOffset(offset);
                range.setStartAddress(addr);
            } else {
                int addr = Integer.parseInt(element, 16);
                range.getValues().add(Integer.valueOf(addr));
            }
        }
        return range;
    }

    public static int parseSingleWordValue(String result) {
        Pattern p = Pattern.compile(":([0-9a-f]{4})\\s+([0-9a-f]{4})\\s*\\*",
                Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);
        Matcher m = p.matcher(result);

        int value = Integer.MIN_VALUE;
        if (m.matches() && m.groupCount() == 2) {
            value = Integer.parseInt(m.group(2), 16);
        }
        return value;
    }

    private static boolean isHexDigit(int c) {
        return ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F'));
    }

    public static int[] parseGroupedWordData(String groupedWordData, int length) {
        String[] rows = StringUtils.split(groupedWordData, "\r\n");
        int[] convertedIntData = new int[length];
        int k = 0;
        for (int i = 0; i < rows.length; i++) {
            String string = StringUtils.lowerCase(StringUtils.trimToEmpty(rows[i]));
            char firstChar = string.length() > 0 ? string.charAt(0) : ' ';
            if (!(isHexDigit(firstChar) || firstChar == ':')) {
                continue;
            }
            String[] columsWithRowHeader = StringUtils.split(string, ' ');
            String[] columns = new String[columsWithRowHeader.length - 1];
            System.arraycopy(columsWithRowHeader, 1, columns, 0, columsWithRowHeader.length - 1);
            for (int j = 0; j < columns.length; j++) {
                convertedIntData[k++] = Integer.parseInt(columns[j], 16);
            }
        }
        return convertedIntData;
    }

    /**
     * split device answer into a list of strings <b>the promt character '*' is
     * removed <b/> <b>empty lines are removed <b/>
     *
     * @param lineBuffer
     *            buffer holding device answer
     * @return list of lines
     */
    public static List<String> cleanAndSplitResultLine(final String lineBuffer) {
        List<String> list = new ArrayList<>();
        String[] lns = StringUtils.split(lineBuffer, "\r\n");
        for (int i = 0; i < lns.length; i++) {
            String string = StringUtils.trimToEmpty(lns[i]);
            if (StringUtils.isEmpty(string) || StringUtils.startsWith(string, "*")) {
                continue;
            }
            if (StringUtils.endsWith(string.toUpperCase(), "[Y]")) {
                continue;
            }
            list.add(string);
        }
        return list;
    }

    public static int[] parseGetResultLineAsByteValues(String fgLine) {
        int begin = StringUtils.indexOf(fgLine, '<');
        int end = StringUtils.indexOf(fgLine, '>');
        if (end == -1 || begin == -1) {
            throw new ParserException("invalid line syntax line '<' ([0-9a-f]{4}) (,[0-9a-f]{4})+ '" + fgLine + "' ");
        }
        String values = StringUtils.substring(fgLine, begin + 1, end);
        String[] fgValues = StringUtils.split(values, ',');
        int[] ifgValues = new int[fgValues.length];
        for (int i = 0; i < fgValues.length; i++) {
            String string = fgValues[i];
            ifgValues[i] = Integer.parseInt(string, 16);
        }
        return ifgValues;
    }
}
