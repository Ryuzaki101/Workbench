package de.wisag.automation.micas.utils;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.mIC.MetaData;

public class ParseUtils {

    private static final Pattern HEADER_PATTERN = Pattern.compile(";[*]{3}\\s+(.+):(.+)?");
    private static final Pattern PAGE_PATTERN = Pattern.compile("^;.*(Seite|Page)\\s*(\\d+)(\\w|\\s|:)*\\n?$",
            Pattern.CASE_INSENSITIVE);
    private static final int PAGE_NUMBER_GROUP = 2; // see position above

    public static void prepareMetadata(MetaData metaData) {
        String value = metaData.getValue();
        HeaderEntry entry = parseHeaderEntry(value);
        if (entry == null && value != null) {
            Matcher matcher = null;
            if ((matcher = PAGE_PATTERN.matcher(value)).matches()) {
                int pageNumber = Integer.parseInt(matcher.group(PAGE_NUMBER_GROUP));
                metaData.setName(HardcodedValues.PAGE);
                metaData.setValue(Integer.toString(pageNumber));
            }
        } else if (entry != null) {
            metaData.setName(entry.getKey());
            metaData.setValue(entry.getValue());
        }
    }

    private static HeaderEntry parseHeaderEntry(String value) {
        String rawValue = StringUtils.chomp(value);
        Matcher m = null;
        if ((m = HEADER_PATTERN.matcher(rawValue)).matches() && m.groupCount() >= 1) {
            String key = StringUtils.trimToEmpty(m.group(1));
            String parsedValue = "";
            if (m.groupCount() == 2) {
                parsedValue = StringUtils.trimToEmpty(m.group(2));
            }
            if (Arrays.binarySearch(HardcodedValues.MIC_HEADER_KEYS, key) > -1) {
                return new HeaderEntry(parsedValue, parsedValue);
            }
        }
        return null;
    }

    private static class HeaderEntry {
        public HeaderEntry(String key, String value) {
            super();
            this.key = key;
            this.value = value;
        }

        String key;
        String value;

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "HeaderEntry [key=" + key + ", value=" + value + "]";
        }
    }

}
