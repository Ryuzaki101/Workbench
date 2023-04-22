package de.wisag.automation.micas.module.ui.dialogs;

public class Constants {

    /** Variable symbol type */
    public static final int SYMBOL_VAR = 0;

    /** Constant symbol type */
    public static final int SYMBOL_CONST = 1;

    /** Row reference symbol type */
    public static final int SYMBOL_ROW_REF = 2;

    /** Row/column reference symbol type */
    public static final int SYMBOL_ROW_COL_REF = 3;

    /**
     * Symbol plural names for the symbol types {@link #SYMBOL_VAR},
     * {@link #SYMBOL_CONST},
     * {@link #SYMBOL_ROW_REF},{@link #SYMBOL_ROW_COL_REF} and
     * {@link #SYMBOL_INTERMIN_ROW_REF}
     */
    public static final String[] SYMBOL_PLURAL_NAMES = new String[] { "Variablen", //
            "Konstanten", //
            "Referenzen (Zeile)", //
            "Referenzen (Zeile/Spalte)", };

}
