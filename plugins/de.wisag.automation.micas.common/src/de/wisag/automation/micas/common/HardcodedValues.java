package de.wisag.automation.micas.common;

import java.util.Arrays;

public class HardcodedValues {

    public static final String FILE_EXT_H86 = "h86";
    public static final String GUESSED_H86_EXTENSION = "-guessed.h86";
    public static final String REPORT_FILE_EXTENSION = ".rep";
    public static final String MIC_EXE_WITH_VERSION_FLAG_SP20 = "sp20";
    public static final String MIC_EXE_WITH_VERSION_FLAG_AR20 = "ar20";
    public static final String DEFAULT_OUTPUT_PREFIX = "29";
    public static final String MIC_DEFAULT_ENCODING_CP850 = "CP850";
    public static final String NAME_SUFFIX = "-rt";
    public static final String MIC_SUFFIX = ".mic";
    public static final String H86_SUFFIX = ".h86";
    public static final String RT_SUFFIX = ".rt";
    public static final String DIAGRAM_MODULE_SUFFIX = "module";
    /** enable module cleaner. if enabled, unused symbols are removed */
    public static boolean ENABLE_RT_MODEL_CLEANER = true;
    public final static String[] GENERATED_FILE_EXTENSIONS = new String[] { "h86", "kuz", "lst", "deb", "log", "rep",
            "rt", "pdf" };
    public static final String REP_SUFFIX = REPORT_FILE_EXTENSION;
    public static final String MANIFEST_SUFFIX = ".mf";

    static {
        Arrays.sort(HardcodedValues.GENERATED_FILE_EXTENSIONS);
    }

    public static final int FIELDBUS_MASTER_DEVICE = 2;

    /**
     * float serialization is done by mic.exe in another way than by java. if
     * this flag is set to <code>true</code> the code is almost mic.exe
     * compatible
     */
    public static final boolean ENABLE_FLOAT_COMPATIBILTY_HACK = true;
    /**
     *
     */
    public final static String MIC_HEADER_KEY_FILENAME = "Dateiname";
    public final static String MIC_HEADER_KEY_PROJECTNAME = "Projektname";
    public final static String MIC_HEADER_KEY_PROJECTNUMBER = "Projektname";
    public final static String MIC_HEADER_KEY_PROCESSOR = "Bearbeiter";
    public final static String MIC_HEADER_KEY_PROCESSOR1 = "Prüfer";
    public final static String MIC_HEADER_KEY_LINE_NUMBER = "Line Nummer";
    public final static String MIC_HEADER_KEY_USER_NUMBER = "User Number";
    public final static String MIC_HEADER_KEY_MODULE_TYPE = "Modul Typ";
    public final static String MIC_HEADER_KEY_FIELDBUS_NUMBER = "Feldbus Nummer";

    public final static String[] MIC_HEADER_KEYS = new String[] { MIC_HEADER_KEY_FILENAME, //
            MIC_HEADER_KEY_PROJECTNAME, //
            MIC_HEADER_KEY_PROJECTNUMBER, //
            MIC_HEADER_KEY_PROCESSOR, //
            MIC_HEADER_KEY_PROCESSOR1, //
            MIC_HEADER_KEY_LINE_NUMBER, //
            MIC_HEADER_KEY_USER_NUMBER, //
            MIC_HEADER_KEY_MODULE_TYPE, //
            MIC_HEADER_KEY_FIELDBUS_NUMBER };
    static {
        Arrays.sort(HardcodedValues.MIC_HEADER_KEYS, String.CASE_INSENSITIVE_ORDER);
    }

    public static final String ANONYMOUS_VAR_PREFIX = "$M";
    public static final String ANONYMOUS_REF_PREFIX = "&REF_";
    public static final String WSCATCH_VARIABLE = "$WSCATCH";
    public static final String WONE_CONSTANT = "$WONE";
    public static final String WZERO_CONSTANT = "$WZERO";
    public static final String PAGE = "page";
    /** How many symbols can be monitored by onlinetest */
    public static final int MAX_MONITORABLE_SYMBOLS = 60;
}
