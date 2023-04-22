package de.wisag.automation.micas.rt;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.common.binary.ByteArrayBuilder;
import de.wisag.automation.micas.common.binary.SegmentCalulator;
import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;
import de.wisag.automation.micas.rt.impl.RtModuleUtils;

public class H86ToRtModuleTransformer implements IMicasH86ModuleBuilder {
    private HardwareAlias hardwareAlias;
    private HardwareTypeDefinition hardwareTypeDefinition;

    final class SymbolComparator implements Comparator<RtSymbol> {
        @Override
        public int compare(RtSymbol s1, RtSymbol s2) {
            if (s1 instanceof RtReferenceConstant && s2 instanceof RtWordConstant) {
                return 1;
            }
            if (s2 instanceof RtReferenceConstant && s1 instanceof RtWordConstant) {
                return -1;
            }
            if (s2 instanceof RtReferenceConstant && s1 instanceof RtReferenceConstant) {
                RtReferenceConstant r1 = (RtReferenceConstant) s1;
                RtReferenceConstant r2 = (RtReferenceConstant) s2;
                return r1.getType().compareTo(r2.getType());
            }
            Integer i = Integer.valueOf(s1.getAddress());
            return i.compareTo(Integer.valueOf(s2.getAddress()));
        }
    }

    private final Map<Integer, byte[]> segments;
    private final IHwModulesProvider provider;
    private boolean DEBUG;
    private static final EList<PortDataType> DIRECT_VALUE_PDATA_TYPE = new BasicEList<>();
    static {
        DIRECT_VALUE_PDATA_TYPE.add(PortDataType.DIRECT_VALUE);
    }

    public H86ToRtModuleTransformer(final Map<Integer, byte[]> segments, IHwModulesProvider provider) {
        this.segments = segments;
        this.provider = provider;
    }

    /*
     * (non-Javadoc)
     *
     * @see de.wisag.automation.micas.h86.IMicasH86ModuleBuilder#build()
     */
    @Override
    public RtModule build() throws IOException {
        return parse(this.segments);
    }

    protected RtModule parse(final Map<Integer, byte[]> segments2) throws FileNotFoundException {
        final Map<Integer, byte[]> segments = new HashMap<>(segments2);
        List<Integer> segmentAddrs = new ArrayList<>(segments.keySet());
        Collections.sort(segmentAddrs);
        segmentInfo(segments, segmentAddrs);
        // programSegment segment
        List<HardwareAlias> matchingAliases = new ArrayList<>();
        List<String> comments = new ArrayList<>();

        if (getHardwareTypeDefinition() == null) {
            for (HardwareType hardwareType : HardwareType.VALUES) {
                if (HardwareType.UNKNOWN.equals(hardwareType)) {
                    continue;
                }
                HardwareTypeDefinition guessedType = IHwModulesProvider.INSTANCE
                        .findHardwareTypeDefinition(hardwareType);
                if (guessedType == null) {
                    throw new RuntimeException(String.format("Inconsistant modules.hw  %s", hardwareType.getLiteral()));
                }
                int headSegment = guessedType.getHeadSegment();
                int programSegment = guessedType.getProgramSegment();
                int dataSegment = guessedType.getDataSegment();
                if (segmentAddrs.containsAll(Arrays.asList(new Integer[] { Integer.valueOf(headSegment),
                        Integer.valueOf(programSegment), Integer.valueOf(dataSegment) }))) {
                    if (getHardwareTypeDefinition() == null) {
                        setHardwareTypeDefinition(guessedType);
                    }
                    matchingAliases.addAll(guessedType.getAliases());
                }
            }
        }
        if (getHardwareTypeDefinition() == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Available Segments:");
            for (Integer integer : segments.keySet()) {
                sb.append(String.format("0x%04x ", integer));
            }
            throw new RuntimeException(
                    String.format("Could not detect Hardware Type Using the following Segments : %s", sb.toString()));
        }

        HardwareAlias firstAlias = matchingAliases.get(0);
        RtHwType hwType = RtHwType.get(firstAlias.getName());

        StringBuilder moduleComment = new StringBuilder();
        comments.add("Hardware is derived from available segment addresses.");
        comments.add("possibles hardware types matching ");
        comments.add(String.format("\tprogramsegment: 0x%04x,datasegment: 0x%04x, headmodulesegment: 0x%04x : ",
                getHardwareTypeDefinition().getProgramSegment(), getHardwareTypeDefinition().getDataSegment(),
                getHardwareTypeDefinition().getHeadSegment()));

        moduleComment.append("\t");
        for (HardwareAlias hardwareAlias : matchingAliases) {
            moduleComment.append(hardwareAlias.getName()).append(" ");
        }
        comments.add(moduleComment.toString());

        int programSegmentAddress = getHardwareTypeDefinition().getProgramSegment();
        byte[] programSegment = segments.get(programSegmentAddress);
        if (programSegment == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("Available Segments:");
            for (Integer integer : segments.keySet()) {
                sb.append(String.format("0x%04x ", integer));
            }
            throw new RuntimeException(
                    String.format("No Program segment found for address 0x%04x. Available segments : %s",
                            programSegmentAddress, sb.toString()));
        }

        final RtModule module = createModuleFormProgramSegment(programSegment, programSegmentAddress);
        module.setStartSegmentAddress(programSegmentAddress);
        module.setDataSegmentAddress(getHardwareTypeDefinition().getDataSegment());
        module.setHeadModuleSegmentAddress(getHardwareTypeDefinition().getHeadSegment());
        module.setHwType(hwType);
        module.getComments().addAll(comments);

        if (getHardwareTypeDefinition().getDataSegment() != getHardwareTypeDefinition().getProgramSegment()) {
            // Datasegment is devided into 2 parts
            module.setDataSegment(segments.get(getHardwareTypeDefinition().getDataSegment()));
        } else if (module.getWordVarOffset() > programSegment.length) {
            // if size of constants greater than current program/data segment
            // ... search for an second part
            int secondSegment = SegmentCalulator.addSegmentOffset(module.getDataSegmentAddress(),
                    module.getDataSegment().length);
            expandDataSegment(segments, module, secondSegment);

        }
        byte[] headModuleSegment = segments.get(getHardwareTypeDefinition().getHeadSegment());
        module.setHeadModuleSegment(headModuleSegment);
        showModuleStatistics(module);
        decodeHeadModuleAndReadTaskData(module, headModuleSegment, segments);
        addMissingTaskSegments(module, segments);
        for (RtTask task : module.getTasks()) {
            task.setComment(String.format("Adress %04x", task.getSegment()));
            int index = 0;
            byte[] taskSegment = segments.get(task.getSegment());
            if (taskSegment == null) {
                // ignore unreachable tasks
                continue;
            } else {
                task.setData(taskSegment);
            }
            while ((index = decodeTask(task, index)) < task.getData().length) {
                int modulesCount = task.getModuleInvocations().size();
                if (modulesCount == 0) {
                    continue;
                }
                // decode task only until ENDE module, ignore rest
                RtModuleInvocation lastModule = task.getModuleInvocations().get(modulesCount - 1);
                if (WellknownSpecialBlocks.ENDE.equals(lastModule.getName())) {
                    break;
                }
            }
        }
        ECollections.sort(module.getSymbols(), new SymbolComparator());
        return module;
    }

    private void addMissingTaskSegments(final RtModule module, final Map<Integer, byte[]> segments) {
        for (RtTask rtTask : module.getTasks()) {
            int segmentAddr = rtTask.getSegment();
            if (segments.containsKey(Integer.valueOf(segmentAddr))) {
                continue;
            }
            for (RtTask rtTask2 : module.getTasks()) {
                if (!segments.containsKey(Integer.valueOf(rtTask2.getSegment()))) {
                    continue;
                }
                byte[] currentSegment = segments.get(Integer.valueOf(rtTask2.getSegment()));
                if (segmentAddr > rtTask2.getSegment() && segmentAddr < rtTask2.getSegment() + currentSegment.length) {
                    int sizePart1 = Math.max(16, (segmentAddr - rtTask2.getSegment()) * 2);
                    byte[] segmentPart1 = Arrays.copyOf(currentSegment, sizePart1);
                    byte[] segmentPart2 = Arrays.copyOfRange(currentSegment, sizePart1, currentSegment.length);
                    segments.put(Integer.valueOf(segmentAddr), segmentPart2);
                    segments.put(Integer.valueOf(rtTask2.getSegment()), segmentPart1);

                }
            }
        }
    }

    private void expandDataSegment(final Map<Integer, byte[]> segments, final RtModule module, int secondSegment) {
        byte[] secontPartData = segments.get(secondSegment);
        if (secontPartData != null) {
            ByteArrayBuilder bb = new ByteArrayBuilder();
            bb.append(module.getDataSegment());
            bb.append(secontPartData);
            module.setDataSegment(bb.toByteArray());
        }
    }

    public RtModule createModuleFormProgramSegment(byte[] programSegment, int programSegmentAddress) {
        int wordConstOffset = BinaryUtils.getUShort(programSegment, RtPlatformConstants.WORD_CONST_OFFSET);
        int floatConstOffset = BinaryUtils.getUShort(programSegment, RtPlatformConstants.FLOAT_CONST_OFFSET);

        int wordVarOffset = BinaryUtils.getUShort(programSegment, RtPlatformConstants.WORD_VAR_OFFSET);
        int floatVarOffset = BinaryUtils.getUShort(programSegment, RtPlatformConstants.FLOAT_VAR_OFFSET);
        // Laenge aller Konstanten in Byte's
        int endOfFloatVars = BinaryUtils.getUShort(programSegment, RtPlatformConstants.END_OF_FLOATVARS_OFFSET);
        int vWwOff = BinaryUtils.getUShort(programSegment, RtPlatformConstants.PAST_VALUES_OFFSET);
        int dataSegment = BinaryUtils.getUShort(programSegment, RtPlatformConstants.DATA_SEGMENT_OFFSET);

        int taskCheckSum = BinaryUtils.getUShort(programSegment, RtPlatformConstants.TASK_CHECKSUM_WORD_OFFSET);
        int dSegCheckSum = BinaryUtils.getUShort(programSegment, RtPlatformConstants.DATA_SEGMENT_CHECKSUM_WORD_OFFSET);

        final RtModule module = RtFactory.eINSTANCE.createRtModule();

        module.setDataSegmentAddress(dataSegment);
        module.setDataSegmentCheckSum(dSegCheckSum);
        module.setFloatConstOffset(floatConstOffset);
        module.setFloatVarOffset(floatVarOffset);
        module.setWordConstOffset(wordConstOffset);
        module.setWordVarOffset(wordVarOffset);
        module.setEndOfFloatVars(endOfFloatVars);
        module.setDataSegment(programSegment);
        module.setStartSegment(programSegment);
        module.setPastValuesOffset(vWwOff);
        module.setTasksCheckSum(taskCheckSum);
        return module;
    }

    private static void showModuleStatistics(RtModule mrt) {
        {
            System.out.println("Dseg checksum org : " + BinaryUtils.hexfmt(mrt.getDataSegmentCheckSum()));
            System.out.println("Dseg checksum     : "
                    + BinaryUtils.hexfmt(ChecksumUtils.calculateDataSegmentChecksum(mrt.getDataSegment())));
            System.out.println("Task checksum org : " + BinaryUtils.hexfmt(mrt.getTasksCheckSum()));
            System.out.println("Task checksum     : " + BinaryUtils.hexfmt(ChecksumUtils.calculateTasksChecksum(mrt)));
            System.out.println("WORDK   " + BinaryUtils.hexfmt(mrt.getDataSegmentAddress()) + ":"
                    + BinaryUtils.hexfmt(mrt.getWordConstOffset()) + "   "
                    + (mrt.getFloatConstOffset() - mrt.getWordConstOffset()) / 2);
            System.out.println("FLOATK  " + BinaryUtils.hexfmt(mrt.getDataSegmentAddress()) + ":"
                    + BinaryUtils.hexfmt(mrt.getFloatConstOffset()) + "   "
                    + (mrt.getWordVarOffset() - mrt.getFloatConstOffset()) / 4);
            System.out.println("WORDV   " + BinaryUtils.hexfmt(mrt.getDataSegmentAddress()) + ":"
                    + BinaryUtils.hexfmt(mrt.getWordVarOffset()) + "   "
                    + (mrt.getFloatVarOffset() - mrt.getWordVarOffset()) / 2);
            System.out.println("FLOATV  " + BinaryUtils.hexfmt(mrt.getDataSegmentAddress()) + ":"
                    + BinaryUtils.hexfmt(mrt.getFloatVarOffset()) + "   "
                    + (mrt.getEndOfFloatVars() - mrt.getFloatVarOffset()) / 4);
            System.out.println("Vergangenheitswerte  " + BinaryUtils.hexfmt(mrt.getDataSegmentAddress()) + ":"
                    + BinaryUtils.hexfmt(mrt.getEndOfFloatVars()) + " bis  "
                    + BinaryUtils.hexfmt(mrt.getDataSegmentAddress()) + ":"
                    + BinaryUtils.hexfmt(mrt.getPastValuesOffset()));
            int usedFloatConstCount = mrt.getFloatConstants().size();
            int usedWordConstCount = mrt.getWordConstants().size();
            int usedReferencesCount = mrt.getReferences().size();
            int usedFloatVarsCount = mrt.getFloatVariables().size();

            int usedWordVarsCount = mrt.getWordVariables().size();

            ;
            System.out.println("Used WORDK  incl Refs " + (usedWordConstCount + usedReferencesCount));
            System.out.println("Used FLOATK " + usedFloatConstCount);
            System.out.println("Used WORDV " + usedWordVarsCount);
            System.out.println("Used FLOATV " + usedFloatVarsCount);
        }
    }

    static void showTaskStatistics(RtTask task, MicasModules modules) {
        int pastValueCount = 0;
        int moduleLengthInWords = 0;
        int modulesCount = 0;
        for (RtModuleInvocation mi : task.getModuleInvocations()) {
            // 2 words for head one word for each argument
            moduleLengthInWords += 2 + mi.getArguments().size();
            ModuleDefinition moduleDef = null;
            for (ModuleDefinition module : modules.getModules()) {
                if (mi.getName().equals(module.getName())) {
                    moduleDef = module;
                    break;
                }
            }
            if (moduleDef == null) {
                continue;
            }
            pastValueCount += moduleDef.getPastValueCount();
            modulesCount++;
        }
        System.out.println();
        System.out.println("task : " + task.getId() + " modulesCount  : " + modulesCount);
        System.out.println("task : " + task.getId() + " modulesLength : " + moduleLengthInWords * 2);
        System.out.println("task : " + task.getId() + " segmentSize   : " + task.getData().length);
        System.out.println("task : " + task.getId() + " wvOffset      : " + task.getPastValuesOffset());
        System.out.println("task : " + task.getId() + " wvCount       : " + pastValueCount * 2);
    }

    public void decodeHeadModuleAndReadTaskData(RtModule module, byte[] headModuleSegment,
            Map<Integer, byte[]> segments) {

        int startOfHeadModule = 0;
        int magic1 = BinaryUtils.getUShort(headModuleSegment, startOfHeadModule);
        if (magic1 != RtPlatformConstants.HEAD_MODULE_FIRST_WORD) {
            throw new RuntimeException("Invalid first word of HeadModule");
        }
        int magic2 = BinaryUtils.getUShort(headModuleSegment, startOfHeadModule + 2);
        if (magic2 != RtPlatformConstants.HEAD_MODULE_SECOND_WORD) {
            throw new RuntimeException("Invalid second word of HeadModule");
        }

        int taskCount = BinaryUtils.getUShort(headModuleSegment, startOfHeadModule + 4);
        int startTaskData = 6; // 6 Bytes
        for (int i = 0; i < taskCount; i++) {
            int startBlock = startTaskData + i * 8;
            int taskStrategy = BinaryUtils.getUnsignedByte(headModuleSegment, startBlock);
            int taskId = BinaryUtils.getUnsignedByte(headModuleSegment, startBlock + 1);

            int taskCyclTime = BinaryUtils.getUShort(headModuleSegment, startBlock + 2);
            int taskSegment = BinaryUtils.getUShort(headModuleSegment, startBlock + 4);
            int taskPastValuesOffset = BinaryUtils.getUShort(headModuleSegment, startBlock + 6);
            String strategy = RtModuleUtils.findTaskStrategy(taskStrategy);
            System.out.println(String.format("TASK(%02x) Segment %04x ", taskId, taskSegment));
            RtTask task = RtFactory.eINSTANCE.createRtTask();
            task.setId(taskId);
            task.setCyclTime(taskCyclTime);
            task.setSegment(taskSegment);
            task.setPastValuesOffset(taskPastValuesOffset);
            task.setStrategy(RtTaskStrategy.get(strategy));
            // task.setData(moduleSegments.get(task.getSegment()));
            module.getTasks().add(task);
            System.out.println("task : " + task.getId() + " " + BinaryUtils.hexfmt(task.getSegment()));
        }

    }

    protected static int findHeadModulSegmentAddress(Map<Integer, byte[]> segments) {
        int headSegment = -1;
        for (Entry<Integer, byte[]> entry : segments.entrySet()) {
            int segmentId = entry.getKey();
            byte[] values = entry.getValue();
            int magic1 = BinaryUtils.getUShort(values, 0);
            int magic2 = BinaryUtils.getUShort(values, 2);
            if (magic1 == RtPlatformConstants.HEAD_MODULE_FIRST_WORD
                    && magic2 == RtPlatformConstants.HEAD_MODULE_SECOND_WORD) {
                headSegment = segmentId;
                System.out.println("HeadSegment: " + BinaryUtils.hexfmt(segmentId));
                break;
            }
        }
        return headSegment;
    }

    public int decodeTask(RtTask task, final int index) {
        Assert.isNotNull(task.getData(), "taskData");
        int localIndex = index;
        int firstWord = BinaryUtils.getUShort(task.getData(), localIndex);
        System.out.println(String.format("firstWord : %04x", firstWord));
        // int taskId = (firstWord >> 8) & 0x0f;
        int modIndex = firstWord & 0xff;
        System.out.println(String.format("modIndex : %04x", modIndex));
        // following constraints does not work for big mic files
        /*
         * if (taskId != task.getId()) { throw new RuntimeException(
         * String.format(
         * "Invalid taskid in module invokation was : %d, should: %d, offset : %04x, modindex:%d"
         * , taskId, task.getId(),index,modIndex)); }
         */
        localIndex += 2;
        int blockId = BinaryUtils.getUShort(task.getData(), localIndex);
        localIndex = localIndex += 2;
        final ModuleDefinition block = this.provider.findModuleById(blockId);
        if (DEBUG) {
        }
        if (block == null) {
            throw new RuntimeException(String.format("Unknown Block id : %04x", blockId));
        }
        // System.out.println(String.format("Invocation of %04x %s",
        // blockId,block.getName()));
        Assert.isLegal(blockId == block.getId(),
                String.format("got block with Wrong id is: %04x,should %04x", block.getId(), blockId));
        final RtModuleInvocation mi = RtFactory.eINSTANCE.createRtModuleInvocation();
        mi.setIndex(modIndex);
        mi.setName(block.getName());
        task.getModuleInvocations().add(mi);
        for (Port port : block.getInputs()) {
            localIndex = handlePort(port, mi, localIndex, false);
        }
        for (Port port : block.getOutputs()) {
            localIndex = handlePort(port, mi, localIndex, true);
        }
        for (RtSymbolAccess access : mi.getArguments()) {
            Assert.isNotNull(access.getSymbol());

        }

        return localIndex;
    }

    protected int handlePort(Port port, RtModuleInvocation invocation, int startIndex, boolean outputSide) {
        int index = startIndex;
        final int address = BinaryUtils.getUShort(invocation.getTask().getData(), index);
        EList<PortDataType> allowedPortDataTypes = port.getAllowedPortDataTypes();
        final RtModule module = invocation.getTask().getModule();
        if (port instanceof PortGroup) {
            // interpret address as grouplen
            RtSymbol groupLengthSymbol = createRtSymbol(module, address, DIRECT_VALUE_PDATA_TYPE, outputSide);
            Assert.isTrue(((RtDirectValue) groupLengthSymbol).getValue() == address, "invalid Arg value");
            Assert.isNotNull(groupLengthSymbol);

            RtSymbolAccess lengthSymbolAccess = RtFactory.eINSTANCE.createRtSymbolAccess();
            lengthSymbolAccess.setType(outputSide ? RtSymbolAccessType.WRITE : RtSymbolAccessType.READ);
            lengthSymbolAccess.setModuleInvocation(invocation);
            lengthSymbolAccess.setSymbol(groupLengthSymbol);

            Assert.isTrue(groupLengthSymbol.getAccessors().contains(lengthSymbolAccess));
            Assert.isNotNull(lengthSymbolAccess.getSymbol());
            Assert.isTrue(module.getSymbols().contains(groupLengthSymbol));
            Assert.isTrue(invocation.getArguments().contains(lengthSymbolAccess));
            Assert.isNotNull(lengthSymbolAccess.getSymbol());

            for (int k = 0; k < address; k++) {
                index += 2;
                int value = BinaryUtils.getUShort(invocation.getTask().getData(), index);

                RtSymbol symbol = createRtSymbol(module, value, allowedPortDataTypes, outputSide);
                Assert.isTrue(module.getSymbols().contains(symbol));
                Assert.isNotNull(symbol);

                RtSymbolAccess symbolAccess = RtFactory.eINSTANCE.createRtSymbolAccess();
                symbolAccess.setType(outputSide ? RtSymbolAccessType.WRITE : RtSymbolAccessType.READ);
                symbolAccess.setModuleInvocation(invocation);
                symbolAccess.setSymbol(symbol);

                Assert.isTrue(symbol.getAccessors().contains(symbolAccess));
                Assert.isNotNull(symbolAccess.getSymbol());
                Assert.isTrue(module.getSymbols().contains(symbol));
                Assert.isTrue(invocation.getArguments().contains(symbolAccess));
                Assert.isNotNull(symbolAccess.getSymbol());
            }
        } else {
            RtSymbol symbol = createRtSymbol(module, address, allowedPortDataTypes, outputSide);
            Assert.isNotNull(symbol);

            RtSymbolAccess symbolAccess = RtFactory.eINSTANCE.createRtSymbolAccess();
            symbolAccess.setType(outputSide ? RtSymbolAccessType.WRITE : RtSymbolAccessType.READ);
            symbolAccess.setSymbol(symbol);
            symbolAccess.setModuleInvocation(invocation);

            Assert.isTrue(symbol.getAccessors().contains(symbolAccess));
            Assert.isNotNull(symbolAccess.getSymbol());
            Assert.isTrue(module.getSymbols().contains(symbol));
            Assert.isTrue(invocation.getArguments().contains(symbolAccess));
            Assert.isNotNull(symbolAccess.getSymbol());
        }
        index += 2;
        for (RtSymbolAccess access : invocation.getArguments()) {
            if (access.getSymbol() == null) {
                System.out.println("RtModuleBuilder.handlePort()");
            }

        }
        return index;
    }

    static RtSymbol createRtSymbol(RtModule mrt, int symbolAddress, EList<PortDataType> allowedPortDataTypes,
            boolean outputSide) {
        RtSymbol rtSymbol = null;
        if (allowedPortDataTypes.contains(PortDataType.DIRECT_VALUE)) {
            // syntetic address ...
            int address = -1 * Math.abs(symbolAddress) - 1;
            RtDirectValue directValue = (RtDirectValue) RtModuleUtils.getOrCreateSymbol(mrt, address,
                    RtPackage.eINSTANCE.getRtDirectValue());
            directValue.setValue(symbolAddress);
            rtSymbol = directValue;
        } else {
            byte[] dataSegment = mrt.getDataSegment();
            if (allowedPortDataTypes.contains(PortDataType.FGA_ANALOG_VALUE)
                    || allowedPortDataTypes.contains(PortDataType.FGA_MEASURED_VALUE)
                    || allowedPortDataTypes.contains(PortDataType.FGA_MESSAGE_CONST)
                    || allowedPortDataTypes.contains(PortDataType.FGA_VALUE)) {

                int constValue = BinaryUtils.getUShort(dataSegment, symbolAddress);
                int col = ((constValue & 0x0000ff00) >> 8) & 0xff;
                int row = constValue & 0xff;
                RtReferenceConstant ref = (RtReferenceConstant) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                        RtPackage.eINSTANCE.getRtReferenceConstant());
                ref.setCol(col);
                ref.setRow(row);
                PortDataType type = allowedPortDataTypes.get(0);
                ref.setType(type);
                rtSymbol = ref;
            } else if (isFloatConst(mrt, symbolAddress, allowedPortDataTypes)) {
                int value = BinaryUtils.getInt(dataSegment, symbolAddress);
                RtFloatConstant constant = (RtFloatConstant) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                        RtPackage.eINSTANCE.getRtFloatConstant());
                constant.setValue(Float.intBitsToFloat(value));
                rtSymbol = constant;
            } else if (isWordConst(mrt, symbolAddress, allowedPortDataTypes)) {
                int value = BinaryUtils.getUShort(dataSegment, symbolAddress);
                RtWordConstant constant = (RtWordConstant) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                        RtPackage.eINSTANCE.getRtWordConstant());
                constant.setValue(value);
                rtSymbol = constant;
            } else if (isWordVar(mrt, symbolAddress, allowedPortDataTypes)) {
                RtWordVariable variable = (RtWordVariable) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                        RtPackage.eINSTANCE.getRtWordVariable());
                rtSymbol = variable;
            } else if (isFloatVar(mrt, symbolAddress, allowedPortDataTypes)) {
                RtFloatVariable variable = (RtFloatVariable) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                        RtPackage.eINSTANCE.getRtFloatVariable());
                rtSymbol = variable;
            } else {
                if (isWordConst(mrt, symbolAddress)) {
                    int value = BinaryUtils.getUShort(dataSegment, symbolAddress);
                    RtWordConstant constant = (RtWordConstant) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                            RtPackage.eINSTANCE.getRtWordConstant());
                    constant.setValue(value);
                    rtSymbol = constant;

                } else if (isFloatConst(mrt, symbolAddress)) {
                    int value = BinaryUtils.getInt(dataSegment, symbolAddress);
                    RtFloatConstant constant = (RtFloatConstant) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                            RtPackage.eINSTANCE.getRtFloatConstant());
                    constant.setValue(Float.intBitsToFloat(value));
                    rtSymbol = constant;

                } else if (isWordVar(mrt, symbolAddress)) {
                    RtWordVariable variable = (RtWordVariable) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                            RtPackage.eINSTANCE.getRtWordVariable());
                    rtSymbol = variable;

                } else if (isFloatVar(mrt, symbolAddress)) {
                    RtFloatVariable variable = (RtFloatVariable) RtModuleUtils.getOrCreateSymbol(mrt, symbolAddress,
                            RtPackage.eINSTANCE.getRtFloatVariable());
                    rtSymbol = variable;

                } else {
                    throw new RuntimeException(
                            String.format("Unhandled dataType because %04x out of range", symbolAddress));
                }
            }
        }
        return rtSymbol;
    }

    private void segmentInfo(Map<Integer, byte[]> segments, List<Integer> segmentAddrs) {
        for (Integer integer : segmentAddrs) {
            byte[] segment = segments.get(integer);
            System.out.println("segment : " + BinaryUtils.hexfmt(integer.intValue()) + " length: " + segment.length
                    + " (0x" + BinaryUtils.hexfmt(segment.length) + ")");
        }
    }

    static boolean isWordVar(RtModule mrt, int addressValue, EList<PortDataType> allowedPortDataTypes) {
        if (!allowedPortDataTypes.contains(PortDataType.WORD_VAR)) {
            return false;
        }
        return isWordVar(mrt, addressValue);
    }

    private static boolean isWordVar(RtModule mrt, int addressValue) {
        if (addressValue < mrt.getEndOfFloatVars() && addressValue >= mrt.getWordVarOffset()) {
            return true;
        }
        return false;
    }

    /*
     * WORDK 7700:0030 24 FLOATK 7700:0060 24 WORDV 7700:0090 72 FLOATV
     * 7700:00f0 8
     */
    static boolean isWordConst(RtModule mrt, int addressValue, EList<PortDataType> allowedPortDataTypes) {
        if (!allowedPortDataTypes.contains(PortDataType.WORD_CONST)) {
            return false;
        }

        return isWordConst(mrt, addressValue);
    }

    private static boolean isWordConst(RtModule mrt, int addressValue) {
        if (addressValue < mrt.getFloatConstOffset() && addressValue >= mrt.getWordConstOffset()) {
            return true;
        }
        return false;
    }

    static boolean isFloatVar(RtModule mrt, int addressValue, EList<PortDataType> allowedPortDataTypes) {
        if (!allowedPortDataTypes.contains(PortDataType.FLOAT_VAR)) {
            return false;
        }
        return isFloatVar(mrt, addressValue);
    }

    private static boolean isFloatVar(RtModule mrt, int addressValue) {
        if (addressValue <= mrt.getEndOfFloatVars() && addressValue >= mrt.getFloatVarOffset()) {
            return true;
        }
        return false;
    }

    /**
     * Checks if the given adress
     *
     * @param mrt
     * @param addressValue
     * @param allowedPortDataTypes
     * @return
     */
    static boolean isFloatConst(RtModule mrt, int addressValue, EList<PortDataType> allowedPortDataTypes) {
        if (!allowedPortDataTypes.contains(PortDataType.FLOAT_CONST)) {
            return false;
        }

        return isFloatConst(mrt, addressValue);
    }

    private static boolean isFloatConst(RtModule mrt, int addressValue) {
        if (addressValue < mrt.getWordVarOffset() && addressValue >= mrt.getFloatConstOffset()) {
            return true;
        }
        return false;
    }

    public HardwareTypeDefinition getHardwareTypeDefinition() {
        return hardwareTypeDefinition;
    }

    public void setHardwareTypeDefinition(HardwareTypeDefinition hardwareTypeDefinition) {
        this.hardwareTypeDefinition = hardwareTypeDefinition;
    }

    public HardwareAlias getHardwareAlias() {
        return hardwareAlias;
    }

    public void setHardwareAlias(HardwareAlias hardwareAlias) {
        this.hardwareAlias = hardwareAlias;
    }

}
