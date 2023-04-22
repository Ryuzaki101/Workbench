package de.wisag.automation.micas.rt;

import static de.wisag.automation.micas.common.binary.SegmentCalulator.addSegmentOffset;
import static de.wisag.automation.micas.rt.ChecksumUtils.calculateDataSegmentChecksum;
import static de.wisag.automation.micas.rt.ChecksumUtils.calculateTasksChecksum;
import static de.wisag.automation.micas.rt.MicasAddressUtils.alignOffset;
import static de.wisag.automation.micas.rt.MicasAddressUtils.getTaskStrategy;
import static de.wisag.automation.micas.rt.MicasAddressUtils.getWordConstants;

import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.common.binary.ByteArrayBuilder;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;

/**
 * <b>Purpopse</b>:<br/>
 * This class takes an unconfigured RtModule and calculates addresses, segments
 *
 * @author mkr
 */
public class MicasModuleConfigurator {
    private static final int DO_NOT_USE_FIRST_TASK_SEGMENT = Integer.MIN_VALUE;

    /**
     * Entry point of image configuration
     *
     * @param monitor
     * @param rtModule
     */
    public void configure(IProgressMonitor monitor, final RtModule rtModule) {
        Assert.isNotNull(rtModule.getHwType(), "module.hwType");
        // first, calculate addresses
        configureConstatAddresses(rtModule, RtPlatformConstants.PROGRAM_SEGMENT_FIRST_BLOCK_SIZE);
        configureVariableAddresses(rtModule);
        configureTasks(rtModule);
        configurePastValuesOffset(rtModule);
        configureSegments(rtModule);
        configureTasksSegments(rtModule);
        configureHeadModuleSegment(rtModule);
        configureDataSegmentSegment(rtModule);
    }

    /**
     * @param rtModule
     */
    protected void configureTasks(RtModule rtModule) {
        // first task seems to be task 1
        for (RtTask task : rtModule.getTasks()) {
            Assert.isLegal(task.getId() >= 0, "Task id must be >=0");
            ByteArrayBuilder bb = new ByteArrayBuilder();
            // counter for pastvalues of this task
            int pastValuesCount = 0;
            int runtime = 0;
            int intstructioId = 0;
            for (RtModuleInvocation rmi : task.getModuleInvocations()) {
                if (rmi instanceof RtCommentModuleInvocation) {
                    continue;
                }
                int head = 0xf000 + ((task.getId() & 0x0f) << 8);
                head += intstructioId;
                intstructioId++;
                bb.appendWord(head);
                // add past valuesCount to our counter
                pastValuesCount += rmi.getPastValuesCount();
                bb.appendWord(rmi.getOpcode());
                // add the runtime of module invocation
                runtime += rmi.getRuntime();
                for (RtSymbolAccess rtSymbolAccess : rmi.getArguments()) {
                    RtSymbol symbol = rtSymbolAccess.getSymbol();
                    if (symbol instanceof RtDirectValue) {
                        // direct values we write direct to the image
                        int value = ((RtDirectValue) symbol).getValue();
                        bb.appendWord(value);
                    } else {
                        bb.appendWord(symbol.getAddress() & 0xffff);
                    }
                }
            }
            task.setData(bb.toByteArray());
            task.setRuntime(runtime);
            task.setPastValuesCount(pastValuesCount);
            if (task.getStrategy() == RtTaskStrategy.INIT) {
                task.setCyclTime(0);
            }
        }
    }

    protected int configureVariableAddresses(final RtModule rtModule) {
        int theAddress = rtModule.getPastValuesOffset();
        theAddress = MicasAddressUtils.alignOffset(theAddress);
        rtModule.setWordVarOffset(theAddress);
        for (RtWordVariable wv : rtModule.getWordVariables()) {
            wv.setAddress(theAddress);
            theAddress += getWordSize(rtModule);
        }
        theAddress = alignOffset(theAddress);
        rtModule.setFloatVarOffset(theAddress);
        for (RtFloatVariable fv : rtModule.getFloatVariables()) {
            fv.setAddress(theAddress);
            theAddress += getFloatSize(rtModule);
        }
        rtModule.setEndOfFloatVars(theAddress);
        theAddress = alignOffset(theAddress);
        rtModule.setPastValuesOffset(theAddress);
        return theAddress;
    }

    protected void configureConstatAddresses(RtModule rtModule, final int address) {
        int highestAddress = address;
        // if (isArSp10(rtModule)) {
        // HardwareTypeDefinition hwType = getHardwareTypeDefinition(rtModule);
        // int delta = (hwType.getStackSegment() - hwType.getDataSegment()) <<
        // 4;
        // highestAddress+=delta;
        // }
        rtModule.setWordConstOffset(highestAddress);
        // mic makes no differences between references and word constants. we
        // do but first the word constants are visited
        EList<RtConstant> eConstants = getWordConstants(rtModule);
        // sort by index
        ECollections.sort(eConstants, new MicasAddressUtils.RtConstantComparator());
        for (RtConstant rtConstant : eConstants) {
            rtConstant.setAddress(highestAddress);
            highestAddress += getWordSize(rtModule);
        }
        highestAddress = MicasAddressUtils.alignOffset(highestAddress);
        rtModule.setFloatConstOffset(highestAddress);
        EList<RtFloatConstant> fconsts = rtModule.getFloatConstants();
        for (RtFloatConstant fc : fconsts) {
            fc.setAddress(highestAddress);
            highestAddress += getFloatSize(rtModule);
        }
        rtModule.setPastValuesOffset(highestAddress);
    }

    private int getWordSize(RtModule rtModule) {
        return RtPlatformConstants.WORD_SIZE;
    }

    private boolean isArSp10(RtModule rtModule) {
        return rtModule.getHwType() == RtHwType.AR20 | rtModule.getHwType() == RtHwType.SP20;
    }

    private int getFloatSize(RtModule rtModule) {
        return RtPlatformConstants.FLOAT_SIZE;
    }

    protected void configureDataSegmentSegment(RtModule rtModule) {
        /** build the Head Segment */
        ByteArrayBuilder dataSegmentBuilder = new ByteArrayBuilder();
        dataSegmentBuilder.appendWord(rtModule.getWordConstOffset()); // index
                                                                      // 0x00
        dataSegmentBuilder.appendWord(rtModule.getFloatConstOffset()); // index
                                                                       // 0x02
        dataSegmentBuilder.appendWord(rtModule.getWordVarOffset()); // index
                                                                    // 0x04
        dataSegmentBuilder.appendWord(rtModule.getFloatVarOffset()); // index
                                                                     // 0x06
        dataSegmentBuilder.appendWord(rtModule.getPastValuesOffset()); // index
                                                                       // 0x0a
        dataSegmentBuilder.appendWord(rtModule.getPastValuesLastOffset());
        dataSegmentBuilder.appendWord(rtModule.getDataSegmentAddress());//
        // fill with 0x0 until pastValuesOffset
        while (dataSegmentBuilder.length() < rtModule.getPastValuesOffset()) {
            dataSegmentBuilder.append(0x00);
        }
        byte[] dataSegment = dataSegmentBuilder.toByteArray();

        int tasksChecksum = calculateTasksChecksum(rtModule);
        System.out.println(String.format("taskChecksumOffset:0x%04x", RtPlatformConstants.TASK_CHECKSUM_WORD_OFFSET));
        dataSegment[RtPlatformConstants.TASK_CHECKSUM_WORD_OFFSET] = (byte) tasksChecksum;
        dataSegment[RtPlatformConstants.TASK_CHECKSUM_WORD_OFFSET + 1] = (byte) (tasksChecksum >> 8);

        // calculate DataSegmentChecksum
        int dataSegmentChecksum = calculateDataSegmentChecksum(dataSegment);
        System.out.println(String.format("dataSegmentChecksumOffset:0x%04x",
                RtPlatformConstants.DATA_SEGMENT_CHECKSUM_WORD_OFFSET));
        dataSegment[RtPlatformConstants.DATA_SEGMENT_CHECKSUM_WORD_OFFSET] = (byte) dataSegmentChecksum;
        dataSegment[RtPlatformConstants.DATA_SEGMENT_CHECKSUM_WORD_OFFSET + 1] = (byte) (dataSegmentChecksum >> 8);

        rtModule.setTasksCheckSum(tasksChecksum);
        rtModule.setDataSegmentCheckSum(dataSegmentChecksum);
        rtModule.setDataSegment(dataSegment);

    }

    protected void configureHeadModuleSegment(RtModule module) {
        RtHeadModule rhm = RtFactory.eINSTANCE.createRtHeadModule();
        rhm.setMagic0(0xf000);
        rhm.setMagic1(0x2000);
        rhm.setTaskCount(module.getTasks().size());
        // generate HeadModule
        ByteArrayBuilder hm = new ByteArrayBuilder();
        hm.appendWord(rhm.getMagic0()); // index 0
        hm.appendWord(rhm.getMagic1()); // index 2
        hm.appendWord(rhm.getTaskCount()); // index 4
        for (RtTask task : module.getTasks()) {
            RtTaskInfo ti = RtFactory.eINSTANCE.createRtTaskInfo();
            ti.setConvertedStrategy(getTaskStrategy(task.getStrategy()) & 0xff);
            ti.setTask(task);
            rhm.getTaskInfos().add(ti);
            hm.append(ti.getConvertedStrategy());
            hm.append(task.getId());
            hm.appendWord(task.getCyclTime());
            hm.appendWord(task.getSegment());
            hm.appendWord(task.getPastValuesOffset());
        }
        module.setHeadModuleSegment(hm.toByteArray());
        module.setHeadModul(rhm);
    }

    /**
     * freeze pastValueOffset
     *
     * @param rtModule
     */
    protected void configurePastValuesOffset(RtModule module) {
        // VwOff = FinOff + GetModInfo(ModHnd, MOD_offt1, NULL);
        int pastValuesOffset = module.getPastValuesOffset();
        for (RtTask task : module.getTasks()) {
            task.setPastValuesOffset(pastValuesOffset);
            pastValuesOffset += task.getPastValuesCount();
            pastValuesOffset = (pastValuesOffset & 0xfff0) + 0x0010;
        }
        module.setPastValuesLastOffset(pastValuesOffset);
    }

    /**
     * Configure segment addresses depending on the Hardware, segments are set
     *
     * @param rtModule
     */
    protected void configureSegments(final RtModule rtModule) {
        HardwareTypeDefinition hwType = getHardwareTypeDefinition(rtModule);
        rtModule.setStartSegmentAddress(hwType.getProgramSegment());
        if (isArSp10(rtModule)) {
            rtModule.setFirstTaskSegmentAddress(hwType.getStackSegment());
        } else {
            rtModule.setFirstTaskSegmentAddress(DO_NOT_USE_FIRST_TASK_SEGMENT);
        }
        rtModule.setDataSegmentAddress(hwType.getDataSegment());
        rtModule.setHeadModuleSegmentAddress(hwType.getHeadSegment());
    }

    private HardwareTypeDefinition getHardwareTypeDefinition(final RtModule rtModule) {
        HardwareTypeDefinition hwType = IHwModulesProvider.INSTANCE
                .findHardwareTypeDefinition(rtModule.getHwType().getName());
        if (hwType == null) {
            throw new RuntimeException(String.format("Hardware %1$s not supported", rtModule.getHwType().getName()));
        }

        return hwType;
    }

    protected void configureTasksSegments(RtModule rtModule) {
        int taskSegmentAddress = rtModule.getFirstTaskSegmentAddress() != DO_NOT_USE_FIRST_TASK_SEGMENT
                ? rtModule.getFirstTaskSegmentAddress()
                : addSegmentOffset(rtModule.getDataSegmentAddress(), rtModule.getPastValuesLastOffset());
        EList<RtTask> tasks = rtModule.getTasks();
        for (RtTask task : tasks) {
            task.setSegment(taskSegmentAddress);
            // go to the next segment address
            taskSegmentAddress = addSegmentOffset(taskSegmentAddress, task.getData().length);
        }
    }

}