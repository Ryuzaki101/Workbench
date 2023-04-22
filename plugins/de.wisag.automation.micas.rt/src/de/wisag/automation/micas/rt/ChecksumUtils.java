package de.wisag.automation.micas.rt;

public class ChecksumUtils {

    /**
     * calculates the checksum of datasegment, following the way of
     * <code>micas.c</code>
     *
     * @param data
     * @return
     */
    public static int calculateDataSegmentChecksum(byte[] data) {
        // recalculate checksum
        int sum = 0;
        for (int i = 0; i < (RtPlatformConstants.PROGRAM_SEGMENT_FIRST_BLOCK_SIZE - 2); i += 2) {
            int d = BinaryUtils.getUShort(data, i);
            sum += d;
            sum &= 0xffff;
        }
        return sum & 0xffff;
    }

    public static int calculateTasksChecksum(RtModule mrt) {
        int taskSum = 0;
        for (RtTask task : mrt.getTasks()) {
            for (int i = 0; i < (task.getData().length - 1); i += 2) {
                taskSum += BinaryUtils.getUShort(task.getData(), i);
                taskSum &= 0xffff;
            }

        }
        return taskSum & 0xffff;
    }

}
