package de.wisag.automation.micas.module.ui.symbolimporter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.ui.internal.Policy;

public class SymbolsImporter {
    private static final String MAPPING_RESOURCE = "SymbolImporter.mapping";
    private Properties mapping = null;

    private static Map<ReferenceType, List<String>> refToRawType = new HashMap<>();
    static {
        refToRawType.put(ReferenceType.FGA_ANALOG_VALUE, Arrays.asList(new String[] { "AS" }));
        refToRawType.put(ReferenceType.FGA_MESSAGE_CONST, Arrays.asList(
                new String[] { "AL", "ST", "GU", "GO", "WA", "GF", "BM", "MB", "1F", "2F", "3F", "1O", "2O", "3O" }));
        refToRawType.put(ReferenceType.FGA_VALUE, Arrays.asList(new String[] { "ZO", "ZF" }));
        refToRawType.put(ReferenceType.FGA_MEASURED_VALUE, Arrays.asList(new String[] { "MF", "MO", "SA" }));
    }

    public List<ImportSymbol> importSymbols(InputStream is, String encoding) throws IOException, ProcessingException {
        if (this.mapping == null) {
            loadMapping();
        }
        final List<ImportSymbol> result = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(is, encoding));
        br.readLine();
        final CsvHelper helper = new CsvHelper(Locale.GERMAN, "\t", "\"", "\n");
        helper.importData(new IDataConsumer() {
            private List<String> columnNames;

            @Override
            public void processRow(int lineNr, List<Object> row) throws ProcessingException {
                if (columnNames == null) {
                    columnNames = helper.getColumnNames();
                }
                String property = mapping.getProperty("symbolName");
                String symbolName = (String) row.get(columnNames.indexOf(property));
                String sFieldBus = (String) row.get(columnNames.indexOf(mapping.getProperty("fieldBus")));
                String sRow = (String) row.get(columnNames.indexOf(mapping.getProperty("row")));
                String sCol = (String) row.get(columnNames.indexOf(mapping.getProperty("col")));
                int fieldBus = NumberUtils.toInt(sFieldBus, -1);
                int imgRow = NumberUtils.toInt(sRow, -1);
                int imgCol = NumberUtils.toInt(sCol, -1);
                ;
                String rawReferenceType = (String) row
                        .get(columnNames.indexOf(mapping.getProperty("rawReferenceType")));
                String referenceType = StringUtils.upperCase(rawReferenceType);
                // FG_Text_TXT
                String descriptionProperty = mapping.getProperty("description");
                int descriptionColumnIndex = columnNames.indexOf(descriptionProperty);
                String descriptionUntrimmed = "";
                if (descriptionColumnIndex > -1 && descriptionColumnIndex < row.size()) {
                    descriptionUntrimmed = (String) row.get(descriptionColumnIndex);
                }
                String description = StringUtils.trimToEmpty(descriptionUntrimmed);
                ImportSymbol importSymbol = new ImportSymbol(fieldBus, symbolName, imgCol, imgRow, rawReferenceType,
                        description);
                Set<Entry<ReferenceType, List<String>>> entries = refToRawType.entrySet();
                for (Entry<ReferenceType, List<String>> entry : entries) {
                    ReferenceType refType = entry.getKey();
                    List<String> values = entry.getValue();
                    if (values.contains(referenceType)) {
                        importSymbol.setReferenceType(refType);
                        break;
                    }
                }
                if (importSymbol.getReferenceType() == null) {
                    Policy.logWarning("Unmapped ReferenceType : " + rawReferenceType);
                }
                result.add(importSymbol);
            }
        }, br, true, false, 1);
        br.close();
        return result;
    }

    private void loadMapping() throws IOException {
        this.mapping = new Properties();
        this.mapping.load(getClass().getResourceAsStream(MAPPING_RESOURCE));
    }

    public static void main(String[] args) throws IOException, ProcessingException {
        FileInputStream fin = new FileInputStream("29AC4003.exp");
        List<ImportSymbol> symbols = new SymbolsImporter().importSymbols(fin, "CP850");
        for (ImportSymbol importSymbol : symbols) {
            System.out.println(importSymbol);
        }
    }

}
