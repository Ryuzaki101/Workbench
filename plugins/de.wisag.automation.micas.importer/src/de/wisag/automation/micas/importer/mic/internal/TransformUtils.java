package de.wisag.automation.micas.importer.mic.internal;

import org.eclipse.core.runtime.Assert;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModuleKind;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.TaskKind;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtHwType;
import de.wisag.automation.micas.rt.RtPackage;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtTask;
import de.wisag.automation.micas.rt.RtTaskStrategy;
import de.wisag.automation.micas.rt.RtVariable;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class TransformUtils {

    public static ReferenceAttribute transform(RtReferenceConstant reference) {
        ReferenceAttribute referenceAttribute = ModuleFactory.eINSTANCE.createReferenceAttribute();
        referenceAttribute.setColumn(reference.getCol());
        referenceAttribute.setRow(reference.getRow());
        referenceAttribute.setName(reference.getName());
        referenceAttribute.setDataType(DataType.REFERENCE);
        switch (reference.getType()) {
        case FGA_ANALOG_VALUE:
            referenceAttribute.setReferenceType(ReferenceType.FGA_ANALOG_VALUE);
            break;
        case FGA_MEASURED_VALUE:
            referenceAttribute.setReferenceType(ReferenceType.FGA_MEASURED_VALUE);
            break;
        case FGA_MESSAGE_CONST:
            referenceAttribute.setReferenceType(ReferenceType.FGA_MESSAGE_CONST);
            break;
        case FGA_VALUE:
            referenceAttribute.setReferenceType(ReferenceType.FGA_VALUE);
            break;
        default:
            throw new IllegalArgumentException("ReferenceType " + reference.getType().getLiteral() + " is not handled");
        }
        return referenceAttribute;
    }

    public static Attribute transform(RtFloatConstant object) {
        ConstantAttribute attribute = ModuleFactory.eINSTANCE.createConstantAttribute();
        attribute.setDataType(DataType.FLOAT);
        attribute.setName(object.getName());
        FloatValue value = ModuleFactory.eINSTANCE.createFloatValue();
        value.setValue(object.getValue());
        attribute.setValue(value);
        return attribute;
    }

    public static Attribute transform(RtWordConstant object) {
        ConstantAttribute attribute = ModuleFactory.eINSTANCE.createConstantAttribute();
        attribute.setDataType(DataType.WORD);
        attribute.setName(object.getName());
        WordValue value = ModuleFactory.eINSTANCE.createWordValue();
        value.setValue(object.getValue());
        attribute.setValue(value);
        return attribute;
    }

    public static Attribute transform(RtWordVariable object) {
        VariableAttribute attribute = ModuleFactory.eINSTANCE.createVariableAttribute();
        attribute.setDataType(DataType.WORD);
        attribute.setName(object.getName());
        return attribute;
    }

    public static Attribute transform(RtFloatVariable object) {
        VariableAttribute attribute = ModuleFactory.eINSTANCE.createVariableAttribute();
        attribute.setDataType(DataType.FLOAT);
        attribute.setName(object.getName());
        return attribute;
    }

    public static ModuleKind transform(RtHwType hwType) {
        ModuleKind moduleKind = ModuleKind.get(hwType.getLiteral());
        Assert.isNotNull(moduleKind, "Inconsistent hwType->moduleKindMapping " + hwType + " not supported");
        return moduleKind;
    }

    public static Task transform(RtTask rtTask) {
        Task task = ModuleFactory.eINSTANCE.createTask();
        task.setName(String.format("task %d", rtTask.getId()));
        task.setCycleTime(rtTask.getCyclTime());
        task.setKind(transform(rtTask.getStrategy()));
        task.setIndex(rtTask.getId());
        return task;
    }

    private static TaskKind transform(RtTaskStrategy strategy) {
        TaskKind kind = null;
        switch (strategy) {
        case BACK:
            throw new RuntimeException("Unsupported Task type : " + strategy.getLiteral());
        case CYCL:
            kind = TaskKind.CYCLIC;
            break;
        case EVNT:
            throw new RuntimeException("Unsupported Task type : " + strategy.getLiteral());
        case INIT:
            kind = TaskKind.INIT;
            break;

        }
        return kind;
    }

    public static Attribute transform(RtSymbol symbol) {
        int id = symbol.eClass().getClassifierID();
        switch (id) {

        case RtPackage.RT_VARIABLE: {
            RtVariable rtVariable = (RtVariable) symbol;
            return transform(rtVariable);
        }
        case RtPackage.RT_WORD_CONSTANT: {
            RtWordConstant rtWordConstant = (RtWordConstant) symbol;
            return transform(rtWordConstant);
        }
        case RtPackage.RT_FLOAT_CONSTANT: {
            RtFloatConstant rtFloatConstant = (RtFloatConstant) symbol;
            return transform(rtFloatConstant);
        }
        case RtPackage.RT_WORD_VARIABLE: {
            RtWordVariable rtWordVariable = (RtWordVariable) symbol;
            return transform(rtWordVariable);
        }
        case RtPackage.RT_FLOAT_VARIABLE: {
            RtFloatVariable rtFloatVariable = (RtFloatVariable) symbol;
            return transform(rtFloatVariable);
        }
        case RtPackage.RT_REFERENCE_CONSTANT: {
            RtReferenceConstant rtReferenceConstant = (RtReferenceConstant) symbol;
            return transform(rtReferenceConstant);
        }
        }
        return null;
    }
}
