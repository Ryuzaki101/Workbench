package de.wisag.automation.micas.rt;

public class RtPlatformConstants {

    public static final int FLOAT_SIZE = 4;
    public static final int WORD_SIZE = 2;
    public static final int HEAD_MODULE_FIRST_WORD = 0xf000;
    public static final int HEAD_MODULE_SECOND_WORD = 0x2000;

    public final static int PROGRAM_SEGMENT_FIRST_BLOCK_SIZE = 0x30;

    /** Micas Program segment WordAddress offset of Pointer to Word Constants */
    public static final int WORD_CONST_OFFSET = 0x00;

    /**
     * Micas Program segment WordAddress offset of Pointer to Float Constants
     */
    public static final int FLOAT_CONST_OFFSET = 0x02;

    /** Micas Program segment WordAddress offset of Pointer to Word Variables */
    public static final int WORD_VAR_OFFSET = 0x04;
    /**
     * Micas Program segment WordAddress offset of Pointer to Float Variables
     */
    public static final int FLOAT_VAR_OFFSET = 0x06;

    /**
     * Micas Program segment WordAddress offset of Pointer to end of Float
     * Variables
     */
    public static final int END_OF_FLOATVARS_OFFSET = 0x08;

    /**
     * Micas Program segment WordAddress offset of Pointer to Start of
     * PastValues
     */
    public static final int PAST_VALUES_OFFSET = 0x0a;

    /**
     * Micas Program segment WordAddress offset of Pointer to DataSegment. Can
     * differ from Program segment
     */
    public static final int DATA_SEGMENT_OFFSET = 0x0c;

    /**
     * Adress of a wordValue, which represents the checksum over all task
     * Segments {@link ChecksumUtils#calculateTasksChecksum(RtModule)}
     */
    public static final int TASK_CHECKSUM_WORD_OFFSET = 0x2c;

    /**
     * Adress of a wordValue, which represents the checksum over the datasegment
     * {@link ChecksumUtils#calculateDataSegmentChecksum(byte[])
     */
    public static final int DATA_SEGMENT_CHECKSUM_WORD_OFFSET = 0x2e;

    public static final String MF_ATTRIBUT_H86_NAME = "H86-Name";
    public static final String MF_ATTRIBUT_H86_CHECKSUM = "H86-Checksum";
    public static final String MF_ATTRIBUT_MODULE_CHECKSUM = "Module-Checksum";
    public static final String MF_ATTRIBUT_MODULE_SOURCE_CHECKSUM = "Module-SourceChecksum";
    public static final String MF_ATTRIBUT_MODULE_TYPE = "Module-Type";
    public static final String MF_ATTRIBUT_MODULE_NAME = "Module-Name";
    public static final String MF_ATTRIBUT_MODULE_STAMP = "Module-Stamp";
    public static final String MF_ATTRIBUT_MODULE_FIELD_BUS = "Module-FieldBus";
}
