package de.wisag.automation.micas.common.binary;

public class SegmentCalulator {

    public static int addSegmentOffset(int segment, int offset) {
        int newSegment = segment & 0xffff;
        int off = offset & 0xffff;
        if (off > 0) {
            if ((off & 0x000f) > 0) { // round
                off &= 0xfff0;
                off += 0x10;
            }
            // segmentoffset
            off = off >> 4;
            off &= 0xffff;
            // add it
            newSegment += off;
        }
        return newSegment;
    }

}
