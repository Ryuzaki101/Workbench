package de.wisag.automation.micas.module.util;

import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;

public abstract class AttributeUtils {

    public static ConstantAttribute createFloatConstantAttribute(String name, String description, double value) {
        ConstantAttribute attribute = ModuleFactory.eINSTANCE.createConstantAttribute();
        attribute.setDataType(DataType.FLOAT);
        attribute.setName(name);
        attribute.setDescription(description);
        FloatValue floatValue = ModuleFactory.eINSTANCE.createFloatValue();
        floatValue.setValue(value);
        attribute.setValue(floatValue);
        return attribute;
    }

    public static ConstantAttribute createWordConstantAttribute(String name, String description, int value) {
        ConstantAttribute attribute = ModuleFactory.eINSTANCE.createConstantAttribute();
        attribute.setDataType(DataType.WORD);
        attribute.setName(name);
        attribute.setDescription(description);
        WordValue wordValue = ModuleFactory.eINSTANCE.createWordValue();
        wordValue.setValue(value);
        attribute.setValue(wordValue);
        return attribute;
    }

    public static VariableAttribute createVariableAttribute(String name, DataType sourceDataType) {
        VariableAttribute variable = ModuleFactory.eINSTANCE.createVariableAttribute();
        variable.setName(name);
        variable.setDataType(sourceDataType);
        return variable;
    }

    public static ReferenceAttribute createReferenceAttribute(String name) {
        ReferenceAttribute reference = ModuleFactory.eINSTANCE.createReferenceAttribute();
        reference.setName(name);
        reference.setDataType(DataType.REFERENCE);
        reference.setReferenceType(ReferenceType.FGA_MESSAGE_CONST);
        reference.setColumn(0);
        reference.setRow(0);
        return reference;
    }

}
