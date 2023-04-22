package de.wisag.automation.micas.diagram.core.util;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.Connector;
import org.eclipselabs.damos.dml.DMLPackage;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.ValueSpecification;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.IncomingOffpageConnector;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;
import de.wisag.automation.micas.module.util.AttributeUtils;
import de.wisag.automation.micas.module.util.BlockUtils;
import de.wisag.automation.micas.module.util.IBlockConstants;

public class DiagramFragmentPastingHelper {
    public static final String EXPRESSION = "expression";

    public static void cleanVariablesOnOutputSide(Block block) {
        Page page = (Page) block.getOwningFragment();
        if (page == null) {
            return;
        }
        for (Block blockOnSamePage : getBlocksOnSamePage(block).values()) {
            for (Output output : blockOnSamePage.getOutputs()) {
                for (OutputPort outputPort : output.getPorts()) {

                    if (!(outputPort instanceof BlockOutputPort)) {
                        continue;
                    }
                    BlockOutputPort blockOutputPort = (BlockOutputPort) outputPort;
                    if (blockOutputPort.getSignal() == null) {
                        continue;
                    }
                    if (!(blockOutputPort.getSignal() instanceof AttributeSpecification)) {
                        continue;
                    }
                    AttributeSpecification spec = (AttributeSpecification) blockOutputPort.getSignal();
                    if (blockOutputPort.getConnections().isEmpty()) {
                        // if no connection is copied, remove attribute
                        spec.setAttribute(null);
                    }

                }
            }
        }
    }

    public static LinkedHashMap<String, Block> getBlocksOnSamePage(Block block) {
        Page page = (Page) block.eContainer();
        if (page == null) {
            return new LinkedHashMap<>();
        }
        Collection<Object> blocksOnPage = EcoreUtil.getObjectsByType(page.getAllComponents(),
                DMLPackage.Literals.BLOCK);
        LinkedHashMap<String, Block> byName = new LinkedHashMap<>();
        for (Object object : blocksOnPage) {
            Block aBlock = (Block) object;
            byName.put(StringUtils.trimToEmpty(aBlock.getName()), aBlock);
        }
        return byName;
    }

    public static boolean isConnectedToPageConnector(Connection con) {
        Connector source = con.getSource();
        boolean connectedToIncomingOffpageConnector = false;
        if (source != null && source.eContainer() != null) {
            connectedToIncomingOffpageConnector = source.eContainer().eContainer() instanceof IncomingOffpageConnector;
        }
        Connector target = con.getTarget();
        boolean connectedToOutgoingOffpageConnector = false;
        if (target != null && target.eContainer() != null) {
            connectedToOutgoingOffpageConnector = target.eContainer().eContainer() instanceof OutgoingOffpageConnector;
        }
        return connectedToIncomingOffpageConnector || connectedToOutgoingOffpageConnector;
    }

    public static <T extends Attribute> T findAttributeSameNameAndType(Class<T> type, EList<Attribute> haystack,
            Attribute needle) {
        for (Attribute attr : haystack) {
            if (!attr.eClass().equals(needle.eClass())) {
                continue;
            }
            if (attr.getDataType() != needle.getDataType()) {
                continue;
            }
            if (!StringUtils.equals(attr.getName(), needle.getName())) {
                continue;
            }
            return type.cast(attr);

        }
        return null;
    }

    public static void processPastedConnection(Connection c) {
        OutputConnector source = c.getSource();
        OutputPort outputPort = source instanceof OutputPort ? (OutputPort) source : null;
        if (outputPort == null) {
            return;
        }

        AttributeSpecification spec = (AttributeSpecification) outputPort.getSignal();
        if (spec == null) {
            return;
        }
        if (spec.getAttribute() == null) {
            return;
        }

        Attribute attribute = spec.getAttribute();
        if (attribute instanceof ReferenceAttribute) {
            spec.setAttribute(null);
            return;
        }
        EList<Attribute> attributes = ((Page) c.getOwningFragment()).getTask().getModule().getAttributes();
        TransactionalEditingDomain domain = TransactionUtil.getEditingDomain(c);

        if (attribute instanceof VariableAttribute) {
            boolean connectorVariable = isConnectedToPageConnector(c);
            VariableAttribute existing = findAttributeSameNameAndType(VariableAttribute.class, attributes, attribute);
            Command set;
            if (existing != null && connectorVariable) {
                // reuse existing
                set = SetCommand.create(domain, spec, ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE,
                        existing);
            } else {
                String name = attribute.getName();
                if (connectorVariable) {
                    // attribute with same name and other dataType exists
                    if (BlockUtils.haveAttributeName(attributes, name)) {
                        name = BlockUtils.getAttributeNameWithPrefix(name, attributes);
                    }
                } else {
                    name = BlockUtils.getAnonymousIdentifier(c, HardcodedValues.ANONYMOUS_VAR_PREFIX);
                }
                VariableAttribute newVariableAttribute = AttributeUtils.createVariableAttribute(name,
                        attribute.getDataType());
                attributes.add(newVariableAttribute);
                set = SetCommand.create(domain, spec, ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE,
                        newVariableAttribute);
            }
            domain.getCommandStack().execute(set);
        } else if (attribute instanceof ConstantAttribute) {
            ConstantAttribute found = findAttributeSameNameAndType(ConstantAttribute.class, attributes, attribute);
            if (found != null) {
                // the constant already exists
                Command setCommand = SetCommand.create(domain, spec,
                        ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE, found);
                domain.getCommandStack().execute(setCommand);
            } else {
                // must be created
                ConstantAttribute constant = (ConstantAttribute) attribute;
                ConstantAttribute copiedConstant = null;
                String name = constant.getName();
                if (BlockUtils.haveAttributeName(attributes, name)) {
                    // attribute with same name and other dataType exists
                    name = BlockUtils.getAttributeNameWithPrefix(name, attributes);
                }
                switch (constant.getDataType()) {
                case FLOAT:
                    double fvalue = ((FloatValue) constant.getValue()).getValue();
                    copiedConstant = AttributeUtils.createFloatConstantAttribute(name, constant.getDescription(),
                            fvalue);
                    break;
                case WORD:
                    int wvalue = ((WordValue) constant.getValue()).getValue();
                    copiedConstant = AttributeUtils.createWordConstantAttribute(name, constant.getDescription(),
                            wvalue);
                    break;
                default:
                    Assert.isLegal(false, "Misconfigured constant with name " + name);
                    break;

                }
                attributes.add(copiedConstant);

                Command set = SetCommand.create(domain, spec, ModulePackage.Literals.ATTRIBUTE_SPECIFICATION__ATTRIBUTE,
                        copiedConstant);
                domain.getCommandStack().execute(set);
            }
            // a.setAttribute(null);
        }

    }

    public static void performPostPasteBlockProcessing(Block block) {
        LinkedHashMap<String, Block> byName = getBlocksOnSamePage(block);
        block.setName(getNewName(byName, block));
        int maxIndex = 0;
        // find the highest index
        for (Block b : byName.values()) {
            maxIndex = Math.max(getBlockIndex(b), maxIndex);
        }
        ValueSpecification value = getIndexValue(block);
        if (value != null) {
            value.eSet(value.eClass().getEStructuralFeature(EXPRESSION), String.valueOf((maxIndex + 1)));
        }
    }

    public static int getBlockIndex(Block block) {
        String lastValue = "0";
        ValueSpecification value = getIndexValue(block);
        if (value != null) {
            Object exp = value.eGet(value.eClass().getEStructuralFeature(EXPRESSION));
            lastValue = exp != null ? exp.toString() : "0";
        }
        return NumberUtils.toInt(lastValue, 0);
    }

    public static ValueSpecification getIndexValue(Block block) {
        Argument argument = block.getArgument(IBlockConstants.PARAMETER__INDEX);
        return argument != null ? argument.getValue() : null;
    }

    public static String getNewName(Map<String, Block> byName, Block block) {
        String typeName = block.getType().getName();
        int i = 1;

        String newName = String.format("%s_%d", typeName, i);
        while (byName.containsKey(newName)) {
            newName = String.format("%s_%d", typeName, ++i);
        }
        return newName;
    }

}
