package de.wisag.automation.micas.export.mic.internal;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.runtime.Assert;
import org.eclipselabs.damos.dml.Block;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.export.mic.internal.transformers.IInstanceTransformer;
import de.wisag.automation.micas.export.mic.internal.transformers.ModuleTransformerFactory;
import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleKind;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;
import de.wisag.automation.micas.module.util.BlockUtils;
import de.wisag.automation.micas.rt.RtCommentModuleInvocation;
import de.wisag.automation.micas.rt.RtConstant;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtHwType;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskStrategy;
import de.wisag.automation.micas.rt.RtVariable;
import de.wisag.automation.micas.rt.RtWordConstant;

class DiagramModuleToRtModuleTransformer implements IVariableNumberProvider {
    private int currentIndex = 0;

    public RtModule transform(Module module) {
        RtModule rtModule = RtFactory.eINSTANCE.createRtModule();
        rtModule.setFieldBus(module.getFieldBusNumber());
        rtModule.setHwType(transform(module.getKind()));

        String[] reserverdSymbolNames = TransformerUtils.setupDefaults(rtModule);
        for (Attribute attribute : module.getAttributes()) {
            RtSymbol rtSymbol = transform(attribute);
            // TODO: Check for Nulls
            if (rtSymbol == null) {
                transform(attribute);
            } else {
                if (Arrays.binarySearch(reserverdSymbolNames, rtSymbol.getName()) > -1) {
                    // Policy.warn("")
                } else {
                    rtSymbol.setModule(rtModule);
                    rtModule.getSymbols().add(rtSymbol);
                }
            }
        }

        // add some convenient symbols
        for (Task task : module.getTasks()) {
            RtTask rtTask = transform(task);
            rtModule.getTasks().add(rtTask);
            // assume pages are in order
            int pageNumber = 1;
            for (Page page : task.getPages()) {
                RtCommentModuleInvocation comment = RtFactory.eINSTANCE.createRtCommentModuleInvocation();
                comment.setText(String.format("Page %d Title : %s", pageNumber++, page.getName()));
                rtTask.getModuleInvocations().add(comment);
                // so blocks are sorted correctly
                for (Block block : BlockUtils.getSortedBlocks(page)) {
                    rtTask.getModuleInvocations().add(transform(rtModule, page, block));
                }
            }
            // must add synthetic ENDE module!
            appendEnd(rtTask);
        }
        return rtModule;
    }

    private RtHwType transform(ModuleKind kind) {
        RtHwType hwType = RtHwType.get(kind.getLiteral());
        Assert.isNotNull(hwType, "Inconsistent mapping ModuleKind->RtHwType for" + kind);
        return hwType;
    }

    private void appendEnd(RtTask rtTask) {
        ModuleDefinition moduleDefinition = IHwModulesProvider.INSTANCE.findModuleByName(WellknownSpecialBlocks.ENDE);
        if (moduleDefinition == null) {
            throw new RuntimeException(String.format("No Block found for '%s'", WellknownSpecialBlocks.ENDE));
        }
        rtTask.getModuleInvocations().add(TransformerUtils.create(moduleDefinition));
    }

    private RtSymbol transform(Attribute attribute) {
        Assert.isLegal(attribute.eContainer() != null, "Attribute must have a container");
        if (attribute instanceof ReferenceAttribute) {
            ReferenceAttribute referenceAttribute = (ReferenceAttribute) attribute;
            Assert.isTrue(referenceAttribute.getDataType() == DataType.REFERENCE, "Datatype reference expected");
            RtReferenceConstant referenceConstant = RtFactory.eINSTANCE.createRtReferenceConstant();
            switch (referenceAttribute.getReferenceType()) {
            case FGA_ANALOG_VALUE:
                referenceConstant.setType(PortDataType.FGA_ANALOG_VALUE);
                referenceConstant.setCol(0);
                referenceConstant.setRow(referenceAttribute.getRow());
                break;
            case FGA_MEASURED_VALUE:
                referenceConstant.setType(PortDataType.FGA_MEASURED_VALUE);
                referenceConstant.setCol(0);
                referenceConstant.setRow(referenceAttribute.getRow());
                break;
            case FGA_MESSAGE_CONST:
                referenceConstant.setType(PortDataType.FGA_MESSAGE_CONST);
                referenceConstant.setCol(referenceAttribute.getColumn());
                referenceConstant.setRow(referenceAttribute.getRow());
                break;
            case FGA_VALUE:
                referenceConstant.setType(PortDataType.FGA_VALUE);
                referenceConstant.setCol(0);
                referenceConstant.setRow(referenceAttribute.getRow());
            }
            referenceConstant.setName(attribute.getName());

            return referenceConstant;
        } else if (attribute instanceof VariableAttribute) {
            RtVariable rtVariable = null;
            VariableAttribute variableAttribute = (VariableAttribute) attribute;
            switch (attribute.getDataType()) {
            case FLOAT:
                rtVariable = RtFactory.eINSTANCE.createRtFloatVariable();
                rtVariable.setName(variableAttribute.getName());
                break;
            case WORD:
                rtVariable = RtFactory.eINSTANCE.createRtWordVariable();
                rtVariable.setName(variableAttribute.getName());
                break;
            case REFERENCE:
                RtReferenceConstant referenceConstant = createReferenceAttribute(attribute, ReferenceType.FGA_VALUE);
                referenceConstant.setCol(-1);
                referenceConstant.setRow(0);
                return referenceConstant;
            default:
                throw new RuntimeException("Cannot handle Variables of type '" + attribute.getDataType()
                        + "' attributeName : '" + attribute.getName() + "'");

            }
            return rtVariable;
        } else if (attribute instanceof ConstantAttribute) {
            ConstantAttribute constantAttribute = (ConstantAttribute) attribute;
            RtConstant rtConstant = null;
            switch (attribute.getDataType()) {
            case FLOAT:
                rtConstant = RtFactory.eINSTANCE.createRtFloatConstant();
                rtConstant.setName(constantAttribute.getName());
                FloatValue floatValue = (FloatValue) constantAttribute.getValue();
                if (floatValue == null) {
                    throw new RuntimeException("Constant" + constantAttribute.getName() + " without value");
                }
                ((RtFloatConstant) rtConstant).setValue(Double.valueOf(floatValue.getValue()).floatValue());
                break;
            case WORD:
                rtConstant = RtFactory.eINSTANCE.createRtWordConstant();
                rtConstant.setName(constantAttribute.getName());
                // TODO null checks
                WordValue wordValue = (WordValue) constantAttribute.getValue();
                if (wordValue == null) {
                    throw new RuntimeException("Constant" + constantAttribute.getName() + " without value");
                }
                ((RtWordConstant) rtConstant).setValue(wordValue != null ? wordValue.getValue() : 0);
                break;
            default:
                break;
            }
            return rtConstant;

        }
        System.out.println("ModuleToRtModuleTransformer.transform() no symbol created for " + attribute);
        return null;
    }

    private RtReferenceConstant createReferenceAttribute(Attribute attribute, ReferenceType referenceType) {
        RtReferenceConstant referenceConstant = RtFactory.eINSTANCE.createRtReferenceConstant();
        switch (referenceType) {
        case FGA_ANALOG_VALUE:
            referenceConstant.setType(PortDataType.FGA_ANALOG_VALUE);
            break;
        case FGA_MEASURED_VALUE:
            referenceConstant.setType(PortDataType.FGA_MEASURED_VALUE);
            break;
        case FGA_MESSAGE_CONST:
            referenceConstant.setType(PortDataType.FGA_MESSAGE_CONST);
            break;
        case FGA_VALUE:
            referenceConstant.setType(PortDataType.FGA_VALUE);
        }
        referenceConstant.setName(attribute.getName());
        return referenceConstant;
    }

    private RtModuleInvocation transform(RtModule rtModule, Page page, Block block) {
        String blockName = block.getType().getName();
        RtHwType hwType = rtModule.getHwType();
        // get ModuleDefinition
        ModuleDefinition moduleDefinition = IHwModulesProvider.INSTANCE.findModuleByName(blockName);
        if (moduleDefinition == null) {
            throw new RuntimeException(
                    String.format("No Block found for block '%s' on page '%s' ", blockName, page.getName()));
        }

        Set<String> allowedOn = getDeviceWhitelistOrEmptyForNoRestrictions(moduleDefinition);
        if (blockHasRestrictionsAndDeviceIsNotAllowed(hwType, allowedOn)) {
            throw new RuntimeException(String.format("Module '%s' not Supported on Device '%s' (Diagram page %s)",
                    blockName, hwType.getName(), page.getName()));
        }

        RtModuleInvocation rmi = TransformerUtils.create(moduleDefinition);
        Integer index = BlockUtils.getIndex(block);
        rmi.setIndex(index.intValue());

        // get an
        IInstanceTransformer moduleTransformer = ModuleTransformerFactory.createTransformer(moduleDefinition.getName());
        moduleTransformer.setVariableIndexer(this);
        moduleTransformer.configure(rtModule, rmi, moduleDefinition, block);
        /* handle input ports */
        // TODO: handle special cases of BEFAUS
        moduleTransformer.transformInputs(rtModule, rmi, moduleDefinition, page, block);
        /* handle output ports */
        moduleTransformer.transformOutputs(rtModule, rmi, moduleDefinition, page, block);

        return rmi;
    }

    private Set<String> getDeviceWhitelistOrEmptyForNoRestrictions(ModuleDefinition moduleDefinition) {
        Set<String> allowedOn = new HashSet<>();
        for (HardwareAlias restrictedForHardware : moduleDefinition.getSupportedByHardware()) {
            allowedOn.add(restrictedForHardware.getName().toUpperCase());
        }
        return allowedOn;
    }

    private boolean blockHasRestrictionsAndDeviceIsNotAllowed(RtHwType hwType, Set<String> allowedOn) {
        if (allowedOn.isEmpty()) {
            return false;
        }
        return !allowedOn.contains(hwType.getName().toUpperCase());
    }

    private RtTask transform(Task task) {
        RtTask rtTask = RtFactory.eINSTANCE.createRtTask();
        rtTask.setId(task.getIndex());
        rtTask.setCyclTime(task.getCycleTime());
        rtTask.setStrategy(transform(task.getKind()));
        rtTask.setComment("name : " + task.getName());
        return rtTask;
    }

    private RtTaskStrategy transform(TaskKind kind) {
        switch (kind) {
        case CYCLIC:
            return RtTaskStrategy.CYCL;
        case INIT:
            return RtTaskStrategy.INIT;

        }
        return RtTaskStrategy.INIT;
    }

    @Override
    public int nextIndex() {

        return this.currentIndex++;
    }
}
