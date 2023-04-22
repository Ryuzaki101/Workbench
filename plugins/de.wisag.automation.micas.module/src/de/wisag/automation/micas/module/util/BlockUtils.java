package de.wisag.automation.micas.module.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.ExpressionParameter;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.Fragment;
import org.eclipselabs.damos.dml.FragmentElement;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputConnector;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.Port;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;

public class BlockUtils {
    private static final String EXPRESSION_PARAMETER_URI = "http://www.wisag.de/automation/micas/library/1.0.0/Block.category.dml#_-McSwI2PEd-xLIzFfuJVQQ";

    public static void incrementBlockIndexIfNotExists(Block block) {
        Argument indexArgument = block.getArgument(IBlockConstants.PARAMETER__INDEX);

        if (indexArgument != null) {
            ExpressionSpecification expressionSpecification = DMLFactory.eINSTANCE.createExpressionSpecification();
            expressionSpecification.setExpression(Integer.toString(findNextIndex(block.getOwningFragment())));
            indexArgument.setValue(expressionSpecification);
        }
    }

    public static void configureIncomingOffpageConnector(IncomingOffpageConnector offpageConnector) {
        addOutputPort(offpageConnector);
    }

    public static void configureOutgoingOffpageConnector(OutgoingOffpageConnector offpageConnector) {
        addInputPort(offpageConnector);
    }

    public static void configureReference(Reference reference) {
        // addInputPort(reference);
        addOutputPort(reference);

    }

    public static void configureConstant(Constant constant) {
        // addInputPort(constant);
        addOutputPort(constant);
    }

    private static void addOutputPort(Component component) {
        OutputPort outputPort = DMLFactory.eINSTANCE.createOutputPort();
        Output output = DMLFactory.eINSTANCE.createOutput();
        output.getPorts().add(outputPort);
        component.getOutputs().add(output);
    }

    public static void addInputPort(Component constant) {
        InputPort inputPort = DMLFactory.eINSTANCE.createInputPort();
        Input input = DMLFactory.eINSTANCE.createInput();
        input.getPorts().add(inputPort);
        constant.getInputs().add(input);
    }

    public static DataType dataTypeFromOutputPort(OutputPort sport) {
        if (!(sport instanceof BlockOutputPort)) {
            Component component = sport.getComponent();
            if (component instanceof Reference) {
                return DataType.REFERENCE;
            }
            return null;
        }
        BlockOutputPort sourcePort = (BlockOutputPort) sport;
        BlockOutput blockOutput = (BlockOutput) sourcePort.getOutput();
        MicasDataTypeSpecification sorceDataType = (MicasDataTypeSpecification) blockOutput.getDefinition()
                .getDataType();
        return sorceDataType.getDataType();
    }

    public static BlockType getBlockType(Resource resource, IBlockTypeDescriptor blockTypeDescriptor) {
        ResourceSet resourceSet = resource.getResourceSet();
        EObject element;
        try {
            element = resourceSet.getEObject(blockTypeDescriptor.getUri(), true);
        } catch (Exception e) {
            throw new IllegalArgumentException("Could not load block type URI '" + blockTypeDescriptor.getUri() + "'",
                    e);
        }
        if (element instanceof BlockType) {
            return (BlockType) element;
        } else {
            throw new IllegalArgumentException(
                    "URI '" + blockTypeDescriptor.getUri() + "' does not represent a valid block type");
        }
    }

    public static List<BlockOutputPort> filterOutputPortsBy(List<PortDescriptor> portDescriptors,
            String containingAttribute) {
        List<BlockOutputPort> ports = new ArrayList<>();
        for (PortDescriptor portDesc : portDescriptors) {
            if (portDesc.getSymbolName().equals(containingAttribute)) {
                Port port = portDesc.getPort();
                if (port instanceof BlockOutputPort) {
                    ports.add((BlockOutputPort) port);
                }
            }
        }
        return ports;
    }

    public static List<BlockInputPort> filterInputPortsBy(List<PortDescriptor> portDescriptors,
            String containingAttribute) {
        List<BlockInputPort> ports = new ArrayList<>();
        for (PortDescriptor portDesc : portDescriptors) {
            if (portDesc.getSymbolName().equals(containingAttribute)) {
                Port port = portDesc.getPort();
                if (port instanceof BlockInputPort) {
                    ports.add((BlockInputPort) port);
                }
            }
        }
        return ports;
    }

    private static Argument createArgument(Resource resource, String paramUri) {
        ResourceSet resourceSet = resource.getResourceSet();
        ExpressionParameter element = null;
        try {
            element = (ExpressionParameter) resourceSet.getEObject(URI.createURI(paramUri), true);
        } catch (Exception e) {
            // ignore
        }
        Argument argument = DMLFactory.eINSTANCE.createArgument();
        argument.setParameter(element);
        return argument;
    }

    public static Block createBlock(final Resource resource, final String name, final Integer index,
            int blockOnPageIndex) {
        IBlockTypeDescriptor blockTypeDescriptor = BlockTypeDescriptorCache.findBlockTypeDescriptor(name);
        Assert.isNotNull(blockTypeDescriptor, "Could not find block descriptor for '" + name + "'");
        Block block = DMLFactory.eINSTANCE.createBlock();
        block.setType(getBlockType(resource, blockTypeDescriptor));
        addBlockArgumentValue(resource, block, EXPRESSION_PARAMETER_URI, String.format("%d", blockOnPageIndex));
        // configureBlock(block);
        if (index > 1) {
            block.setName(String.format("%s%d", name, index));
        } else {
            block.setName(name);
        }
        return block;
    }

    public static BlockInput createEmptyBlockInput(Block block, InputDefinition inputDefinition) {
        BlockInput blockInput = DMLFactory.eINSTANCE.createBlockInput();
        blockInput.setComponent(block);
        blockInput.setDefinition(inputDefinition);
        block.getInputs().add(blockInput);
        return blockInput;
    }

    public static BlockInputPort createBlockInputPort(Block block, BlockInput blockInput,
            InputDefinition inputDefinition) {
        BlockInput bi = blockInput != null ? blockInput : createEmptyBlockInput(block, inputDefinition);
        BlockInputPort inputPort = DMLFactory.eINSTANCE.createBlockInputPort();
        inputPort.setInput(bi);
        bi.getPorts().add(inputPort);
        return inputPort;
    }

    private static BlockOutputPort createBlockOutputPort(Block block, BlockOutput blockOutput,
            OutputDefinition outDef) {
        BlockOutput bo = blockOutput != null ? blockOutput : createEmptyBlockOutput(block, outDef);
        if (bo.getDefinition() == null) {
            bo.setDefinition(outDef);
        }
        BlockOutputPort outputPort = DMLFactory.eINSTANCE.createBlockOutputPort();
        outputPort.setOutput(bo);
        bo.getPorts().add(outputPort);
        return outputPort;
    }

    public static BlockOutput createEmptyBlockOutput(Block block, OutputDefinition outDef) {
        BlockOutput blockOutput = DMLFactory.eINSTANCE.createBlockOutput();
        blockOutput.setComponent(block);
        blockOutput.setDefinition(outDef);
        block.getOutputs().add(blockOutput);
        return blockOutput;
    }

    public static BlockOutputPort addBlockOutputPort(Attribute attribute, Block block, BlockOutput blockOutput,
            OutputDefinition outputDefinition) {
        BlockOutputPort outputPort = createBlockOutputPort(block, blockOutput, outputDefinition);
        Assert.isNotNull(attribute);
        AttributeSpecification attributeSignal = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSignal.setAttribute(attribute);
        outputPort.setSignal(attributeSignal);
        return outputPort;
    }

    public static void addBlockArgumentValue(Resource resource, Block block, String parameterUri,
            String expressionValue) {
        Argument argument = createArgument(resource == null ? block.eResource() : resource, parameterUri);
        block.getArguments().add(argument);
        ExpressionSpecification expressionSpecification = DMLFactory.eINSTANCE.createExpressionSpecification();
        expressionSpecification.setExpression(expressionValue);
        argument.setValue(expressionSpecification);
    }

    public static String getAnonymousIdentifier(Connection connection, String prefix) {
        Page page = (Page) connection.getOwningFragment();
        EList<Attribute> attributes = page.getTask().getModule().getAttributes();
        return getAttributeNameWithPrefix(prefix, attributes);
    }

    public static boolean haveAttributeName(EList<Attribute> attributes, String name) {
        for (Attribute attribute : attributes) {
            if (StringUtils.equalsIgnoreCase(attribute.getName(), name)) {
                return true;
            }
        }
        return false;
    }

    public static String getAttributeNameWithPrefix(String prefix, EList<Attribute> attributes) {
        List<String> anonymousAttributes = new ArrayList<>();
        for (Attribute attribute : attributes) {
            if (StringUtils.startsWith(attribute.getName(), prefix)) {
                anonymousAttributes.add(attribute.getName());
            }
        }
        Collections.sort(anonymousAttributes, new Comparator<String>() {

            @Override
            public int compare(String a0, String a1) {
                Integer i0 = Integer.valueOf(NumberUtils.toInt(StringUtils.substring(a0, 2)));
                Integer i1 = Integer.valueOf(NumberUtils.toInt(StringUtils.substring(a0, 2)));
                return i0.compareTo(i1);
            }
        });
        int number = 0;
        String format = String.format("%s0", prefix);
        if (anonymousAttributes.size() > 0) {
            String a = anonymousAttributes.get(anonymousAttributes.size() - 1);
            number = anonymousAttributes.indexOf(a) + 1;
            do {
                format = String.format("%s%d", prefix, number);
                number++;
            } while (anonymousAttributes.contains(format));

        }
        return format;
    }

    public static AttributeSpecification createAnonymousAttributeSpecification(DataType sourceDataType,
            Connection connection) {
        Attribute attribute = null;
        String name = null;
        switch (sourceDataType) {
        case REFERENCE:
            name = getAnonymousIdentifier(connection, HardcodedValues.ANONYMOUS_REF_PREFIX);
            attribute = AttributeUtils.createReferenceAttribute(name);
            break;
        case FLOAT:
        case WORD:
            name = getAnonymousIdentifier(connection, HardcodedValues.ANONYMOUS_VAR_PREFIX);
            attribute = AttributeUtils.createVariableAttribute(name, sourceDataType);
            break;
        default:
            throw new RuntimeException("Unsupported Sourcedatatype : '" + sourceDataType + "'");

        }
        return createSpec(attribute);
    }

    public static DataType dataTypeFromInputPort(InputPort targetPort2) {
        if (!(targetPort2 instanceof BlockInputPort)) {
            return null;
        }
        BlockInputPort targetPort = (BlockInputPort) targetPort2;
        BlockInput blockInput = (BlockInput) targetPort.getInput();
        MicasDataTypeSpecification targetDataType = (MicasDataTypeSpecification) blockInput.getDefinition()
                .getDataType();
        return targetDataType.getDataType();
    }

    public static AttributeSpecification createSpec(Attribute attribute) {
        AttributeSpecification attributeSpecification = ModuleFactory.eINSTANCE.createAttributeSpecification();
        attributeSpecification.setAttribute(attribute);
        return attributeSpecification;
    }

    public static int findNextIndex(Fragment fragment) {
        int index = 1;
        if (fragment == null) {
            return index;
        }
        for (Component component : fragment.getAllComponents()) {
            if (component instanceof Block) {
                Block block = (Block) component;
                String existingIndexString = block.getArgumentStringValue(IBlockConstants.PARAMETER__INDEX);
                if (existingIndexString != null) {
                    try {
                        int existingIndex = Integer.parseInt(existingIndexString);
                        if (existingIndex >= index) {
                            index = existingIndex + 1;
                        }
                    } catch (NumberFormatException e) {
                        // ignore
                    }
                }
            }
        }
        return index;
    }

    public static List<Block> getSortedBlocks(Page page) {
        final List<Block> blocks = new ArrayList<>();
        for (FragmentElement fragmentElement : page.getFragmentElements()) {
            if (fragmentElement instanceof Block) {
                blocks.add((Block) fragmentElement);
            }
        }
        return sortBlocks(blocks);
    }

    public static List<Block> sortBlocks(final Collection<Block> blocks2) {
        final List<Block> blocks = new ArrayList<>();
        blocks.addAll(blocks2);
        Collections.sort(blocks, new Comparator<Block>() {
            @Override
            public int compare(Block o1, Block o2) {
                return getIndex(o1).compareTo(getIndex(o2));
            }

        });
        return blocks;
    }

    public static Integer getIndex(Block block) {
        Argument indexParam = block.getArgument(IBlockConstants.PARAMETER__INDEX);
        ExpressionSpecification value = (ExpressionSpecification) (indexParam != null ? indexParam.getValue() : null);
        String expr = value != null ? value.getExpression() : "-1";
        Integer index = Integer.valueOf(Integer.MIN_VALUE);
        try {
            index = Integer.valueOf(expr);
        } catch (NumberFormatException e) {/* ignore */
        }
        return index;
    }

    public static boolean isInterBlockConnection(Connection connection) {
        if (connection == null) {
            return false;
        }
        OutputConnector source = connection.getSource();
        InputConnector target = connection.getTarget();
        if (source == null || target == null) {
            return false;
        }
        return source instanceof BlockOutputPort && target instanceof BlockInputPort;
    }
}
