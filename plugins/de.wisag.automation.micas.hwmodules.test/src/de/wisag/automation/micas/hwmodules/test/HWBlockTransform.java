package de.wisag.automation.micas.hwmodules.test;

import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.Category;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.InoutputDefinition;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.OutputDefinition;

import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.ModuleFactory;

public class HWBlockTransform {
    private static final String LIBRARY_QNAME = "de.wisag.automation.micas.library.%s";
    private static final DMLFactory DML_FACTORY = DMLFactory.eINSTANCE;
    private static final DMLPackage DML_PACKAGE = DMLPackage.eINSTANCE;

    static class BlockAndGroup {
        private final BlockType blockType;
        private final String groupId;
        private final String blockName;

        public BlockType getBlockType() {
            return blockType;
        }

        public String getGroupId() {
            return groupId;
        }

        public BlockAndGroup(String blockName, BlockType blockType, String groupId) {
            super();
            this.blockType = blockType;
            this.groupId = groupId;
            this.blockName = blockName;
        }

        public String getBlockName() {
            return blockName;
        }

        public String relativePath() {
            String groupId = getGroupId().substring(getGroupId().lastIndexOf('.') + 1);
            return String.format("%s/%s.blocktype.dml", groupId, getBlockType().getName().toUpperCase());
        }

    }

    public BlockAndGroup toBlockType(ModuleDefinition definition, Category category) {
        BlockType blockType = DML_FACTORY.createBlockType();
        blockType.setQualifiedName(String.format(LIBRARY_QNAME, definition.getName().toUpperCase()));
        blockType.getBelongingCategories().add(category);
        blockType.getParameters().addAll(//
                definition.getParameters().stream()//
                        .map(this::mapExpressionParameter)//
                        .collect(Collectors.toList()));

        blockType.getInputDefinitions().addAll(//
                definition.getInputs().stream()//
                        .filter(this::noDirectValues)//
                        .map(this::mapInputPort)//
                        .collect(Collectors.toList()));

        blockType.getOutputDefinitions().addAll(//
                definition.getOutputs().stream()//
                        .map(this::mapOutputPort)//
                        .collect(Collectors.toList()));

        return new BlockAndGroup(definition.getName().toUpperCase(), blockType, definition.getGroupId());
    }

    private ExpressionParameter mapExpressionParameter(de.wisag.automation.micas.hwmodules.Parameter parameter) {
        ExpressionParameter expressionParameter = DML_FACTORY.createExpressionParameter();
        expressionParameter.setName(parameter.getName());
        ExpressionSpecification spec = DML_FACTORY.createExpressionSpecification();
        spec.setExpression(parameter.getValue());
        return expressionParameter;
    }

    private boolean noDirectValues(Port p) {
        return !p.getAllowedPortDataTypes().contains(PortDataType.DIRECT_VALUE);
    }

    private OutputDefinition mapOutputPort(Port port) {
        return mapPort(DML_FACTORY, port, DML_PACKAGE.getOutputDefinition(), OutputDefinition.class);
    }

    private InputDefinition mapInputPort(Port port) {
        return mapPort(DML_FACTORY, port, DML_PACKAGE.getInputDefinition(), InputDefinition.class);
    }

    private <T> T mapPort(DMLFactory factory, Port port, EClass x, Class<T> type) {
        InoutputDefinition definition = (InoutputDefinition) factory.create(x);
        definition.setName(port.getName());
        MicasDataTypeSpecification dataType = ModuleFactory.eINSTANCE.createMicasDataTypeSpecification();
        dataType.setDataType(map(port.getAllowedPortDataTypes()));
        definition.setDataType(dataType);
        if (port instanceof PortGroup) {
            ModuleDefinition def = (ModuleDefinition) port.eContainer();
            System.out.println(def.getName() + " has port group on input ");
            definition.setMinimumPortCount(0);
            definition.setMaximumPortCount(-1);
            definition.setDefaultPortCount(2);
        }
        return type.cast(definition);
    }

    private DataType map(EList<PortDataType> allowedPortDataTypes) {

        PortDataType mtype = allowedPortDataTypes.stream().findFirst()
                .orElseThrow(() -> new IllegalArgumentException("List was empty"));

        switch (mtype) {
        case FGA_ANALOG_VALUE:
        case FGA_MEASURED_VALUE:
        case FGA_MESSAGE_CONST:
        case FGA_VALUE:
            return DataType.REFERENCE;
        case FLOAT_CONST:
        case FLOAT_VAR:
            return DataType.FLOAT;
        case WORD_CONST:
        case WORD_VAR:
            return DataType.WORD;
        case DIRECT_VALUE:
        default:
            break;
        }
        throw new IllegalArgumentException("Unsupported type : " + mtype);
    }

}