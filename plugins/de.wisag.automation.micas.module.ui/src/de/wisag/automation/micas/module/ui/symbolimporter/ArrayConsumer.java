package de.wisag.automation.micas.module.ui.symbolimporter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayConsumer implements IDataConsumer {

    private ArrayList<Object[]> rows;

    public ArrayConsumer() {
        rows = new ArrayList<>();
    }

    @Override
    public void processRow(int lineNr, List<Object> row) {
        rows.add(row.toArray());
    }

    public Object[][] getData() {
        int maxCol = 0;
        for (int i = 0; i < rows.size(); i++) {
            Object[] o = rows.get(i);
            if (Array.getLength(o) > maxCol) {
                maxCol = Array.getLength(o);
            }
        }

        return rows.toArray(new Object[rows.size()][maxCol]);
    }
}