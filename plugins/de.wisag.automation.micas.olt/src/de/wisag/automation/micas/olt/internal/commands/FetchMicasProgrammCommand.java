package de.wisag.automation.micas.olt.internal.commands;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Assert;

import de.wisag.automation.micas.olt.IDeviceConnection;
import de.wisag.automation.micas.olt.RemoteInterpreterExeption;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.internal.DeviceCommands;
import de.wisag.automation.micas.rt.BinaryUtils;

public class FetchMicasProgrammCommand extends ConnectionAwareDeviceCommand<String> {

    private static final int WORD_SIZE = 2;

    private int startSegment;
    private int headSegment;
    private int dataSegment;
    private int programSegment;
    private static boolean DEBUG = true;
    private int fieldBusNumber;

    public FetchMicasProgrammCommand(IDeviceConnection connection) {
        super(connection);
    }

    @Override
    public String execute() throws RemoteInterpreterExeption {
        initializeBusData();
        if (DEBUG) {
            System.out.println("Program Segment : " + BinaryUtils.hexfmt(this.programSegment));
            System.out.println("Data    Segment : " + BinaryUtils.hexfmt(this.dataSegment));
            System.out.println("Head    Segment : " + BinaryUtils.hexfmt(this.headSegment));
        }
        // todo if dataSegment != programSegment
        StringBuilder sb = new StringBuilder();
        int[] head = getConnection().getMultiWordResult(this.programSegment, 0, 8);
        // word addressing!
        int wordConstOffset = head[0];
        int floatConstOffset = head[1];
        int wordVarOffset = head[2];
        int floatVarOffset = head[3];
        int endOfFloatVars = head[4];
        int pastValuesOffset = head[5];
        int dataSegmentFromImage = head[6];
        if (DEBUG) {
            System.out.println(String.format("WordConstOffset   : %04x", wordConstOffset));
            System.out.println(String.format("FloatConstOffset  : %04x", floatConstOffset));
            System.out.println(String.format("WordVarsOffset    : %04x", wordVarOffset));
            System.out.println(String.format("FloatVarOffset    : %04x", floatVarOffset));
            System.out.println(String.format("EndOfFloatVars    : %04x", endOfFloatVars));
            System.out.println(String.format("PastValuesOffset	: %04x", pastValuesOffset));
            System.out.println(String.format("DataSegment segment     : %04x", dataSegmentFromImage));
        }
        Assert.isLegal(dataSegmentFromImage == this.dataSegment,
                String.format(
                        "datasegment differ from Hardware definition. "
                                + "Value at address %04x:%04x is %04x expected %04x",
                        this.programSegment, 6 * 2, dataSegmentFromImage, this.dataSegment));
        int offset = 0x30;
        if (this.programSegment != dataSegmentFromImage) {

            String h86ProgramSegment = getConnection().getH86Block(this.programSegment, 0, offset);
            sb.append(h86ProgramSegment);
            sb.append("\r\n");

            String h86DataSegment = getConnection().getH86Block(dataSegmentFromImage, offset, wordVarOffset - offset);
            sb.append(h86DataSegment);
            sb.append("\r\n");
        } else {
            String h86DataSegment = getConnection().getH86Block(this.programSegment, 0, wordVarOffset);
            sb.append(h86DataSegment);
            sb.append("\r\n");

        }
        int[] moduleHeader = getConnection().getMultiWordResult(this.headSegment, 0, 3);
        int taskCount = moduleHeader[2];
        if (DEBUG) {
            System.out.println(String.format("TaskCount : %d", taskCount));
        }
        int usedHeadModuleData = 6
                /* header */ + taskCount * 8; /*
                                               * 8=bytes per task
                                               */

        String h86HeadModule = getConnection().getH86Block(this.headSegment, 0, usedHeadModuleData);
        sb.append(h86HeadModule);
        sb.append("\r\n");

        int[] taskData = getConnection().getMultiWordResult(this.headSegment, 0, usedHeadModuleData / 2);
        int i = 3;
        while (i < taskData.length) {
            int strategyAndId = taskData[i++];
            int cycleTime = taskData[i++];
            int taskSegment = taskData[i++];
            int taskPastValuesOffset = taskData[i++];
            if (DEBUG) {
                System.out.println(String.format("Task strategyAndId        : %04x", strategyAndId));
                System.out.println(String.format("Task cycleTime            : %04x", cycleTime));
                System.out.println(String.format("Task taskSegment          : %04x", taskSegment));
                System.out.println(String.format("Task taskPastValuesOffset : %04x", taskPastValuesOffset));
            }
            DataRange endModuleAddress = getConnection().findFirstWord(taskSegment, 0, 0x3000);
            if (endModuleAddress != null) {
                int taskLength = endModuleAddress.getStartAddress().getOffset() + WORD_SIZE;
                String h86TaskData = getConnection().getH86Block(taskSegment, 0, taskLength);
                sb.append(h86TaskData);
                sb.append("\r\n");
            } else {
                System.out.println(
                        String.format("Task is damaged! No endmodule found for Task taskSegment: %04x FindWord %04x",
                                taskSegment, 0x3000));

            }
        }
        String[] lines = StringUtils.split(sb.toString(), "\r\n");
        List<String> cleanedLines = new LinkedList<>(Arrays.asList(lines));

        boolean lastRecordKept = false;
        for (ListIterator<String> it = cleanedLines.listIterator(cleanedLines.size()); it.hasPrevious();) {
            boolean isEndRecord = StringUtils.equalsIgnoreCase(":00000001FF", it.previous());
            if (isEndRecord) {
                if (!lastRecordKept) {
                    lastRecordKept = true;
                } else {
                    it.remove();
                }
            }
        }

        return StringUtils.join(cleanedLines.toArray(new String[cleanedLines.size()]), "\r\n");
    }

    private void initializeBusData() throws RemoteInterpreterExeption {
        try {
            // CHD: display active devices
            getConnection().sendAndReadLines(String.format("%s %d", DeviceCommands.CMD_CHD, fieldBusNumber));
        } catch (IOException e) {
            throw new RemoteInterpreterExeption(e.getMessage(), e);
        }
    }

    public int getStartSegment() {
        return this.startSegment;
    }

    public void setStartSegment(int startSegment) {
        this.startSegment = startSegment;
    }

    public int getHeadSegment() {
        return this.headSegment;
    }

    public void setHeadSegment(int headSegment) {
        this.headSegment = headSegment;
    }

    public int getDataSegment() {
        return this.dataSegment;
    }

    public void setDataSegment(int dataSegment) {
        this.dataSegment = dataSegment;
    }

    public int getProgramSegment() {
        return this.programSegment;
    }

    public void setProgramSegment(int programSegment) {
        this.programSegment = programSegment;
    }

    public int getFieldBusNumber() {
        return fieldBusNumber;
    }

    public void setFieldBusNumber(int fieldBusNumber) {
        this.fieldBusNumber = fieldBusNumber;
    }

}
