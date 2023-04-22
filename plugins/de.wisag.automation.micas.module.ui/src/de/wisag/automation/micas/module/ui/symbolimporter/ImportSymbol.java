package de.wisag.automation.micas.module.ui.symbolimporter;

import de.wisag.automation.micas.common.model.AbstractModelObject;
import de.wisag.automation.micas.module.ReferenceType;

public class ImportSymbol extends AbstractModelObject {
    public static final String PROP_REFERENCE_TYPE = "referenceType";
    public static final String PROP_MARKED_FOR_IMPORT = "markedForImport";
    public final static String PROP_FIELD_BUS = "fieldBus";
    public final static String PROP_SYMBOL_NAME = "symbolName";
    public final static String PROP_COL = "col";
    public final static String PROP_ROW = "row";
    public final static String PROP_DESCRIPTION = "description";
    private int fieldBus;
    private String symbolName;
    private int col;
    private int row;
    private ReferenceType referenceType;
    private boolean markedForImport = true;
    private String rawReferenceType;
    private String description;

    public ImportSymbol(int fieleBus, String symbolName, int col, int row, String rawReferenceType,
            String description) {
        super();
        this.fieldBus = fieleBus;
        this.symbolName = symbolName;
        this.col = col;
        this.row = row;
        this.rawReferenceType = rawReferenceType;
        this.description = description;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public int getFieldBus() {
        return fieldBus;
    }

    public boolean isMarkedForImport() {
        return markedForImport;
    }

    public void setMarkedForImport(boolean markedForImport) {
        firePropertyChange(PROP_MARKED_FOR_IMPORT, this.markedForImport, this.markedForImport = markedForImport);
    }

    public ReferenceType getReferenceType() {
        return referenceType;
    }

    public void setReferenceType(ReferenceType referenceType) {
        firePropertyChange(PROP_REFERENCE_TYPE, this.referenceType, this.referenceType = referenceType);
    }

    public String getRawReferenceType() {
        return rawReferenceType;
    }

    @Override
    public String toString() {
        return "ImportSymbol [fieldBus=" + fieldBus + ", symbolName=" + symbolName + ", col=" + col + ", row=" + row
                + ", referenceType=" + referenceType + "]";
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        firePropertyChange(PROP_DESCRIPTION, this.description, this.description = description);
    }

}