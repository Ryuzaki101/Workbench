package de.wisag.automation.micas.module.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.ExpressionSpecification;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputConnector;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.SignalSpecification;
import org.eclipselabs.damos.dml.util.DMLSwitch;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.MicasDataTypeSpecification;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.OutgoingOffpageConnector;

public class ModuleUtil {
    public static final String FKG_PROP_SUPPORINGPOINTS = "Stuetzstellen";
    public static final String REGLER_PROP_NUMBER = "Regler Nummer";
    public static final String SOLKEN_PROP_NUMBER = "Sollkennlinen Nummer";
    public static final String HXSTRA_PROP_NUMBER = "HXSTRA Nummer";
    public static final String HXSTRA_PROP_TEXT = "HXSTRA Text";
    
    public static DataType getDataType(Connection connection) {
        DataType dataType = getDefinedDataType(connection.getSourcePort());
        if (dataType != null) {
            return dataType;
        }
        if (connection.getSourcePort().isSetSignal()
                && connection.getSourcePort().getSignal() instanceof AttributeSpecification) {
            Attribute attribute = ((AttributeSpecification) connection.getSourcePort().getSignal()).getAttribute();
            dataType = attribute != null ? attribute.getDataType() : null;
        }
        return dataType;
    }

    public static Attribute getConnectionAttribute(Connection connection) {
        AttributeSpecification spec = getConnectionAttributeSpecification(connection);
        if (spec == null) {
            return null;
        }

        return spec.getAttribute();
    }

    public static boolean isValid(Connection connection) {
        DataType sourceDataType = null;
        if (connection.getSourcePort().isSetSignal()) {
            SignalSpecification signalSpecification = connection.getSourcePort().getSignal();
            if (!(signalSpecification instanceof AttributeSpecification)) {
                return false;
            }
            AttributeSpecification attributeSpecification = (AttributeSpecification) signalSpecification;
            Attribute attribute = attributeSpecification.getAttribute();
            if (attribute == null || attribute.getName() == null || attribute.getName().trim().length() == 0) {
                return false;
            }

            sourceDataType = attribute.getDataType();

            DataType definedDataType = getDefinedDataType(connection.getSourcePort());
            if (definedDataType != null && definedDataType != sourceDataType) {
                return false;
            }
        } else {
            if (!(connection.getSourcePort().getComponent() instanceof Block)
                    || connection.getTargetPort().getComponent() instanceof OutgoingOffpageConnector) {
                return false;
            }
            sourceDataType = getDefinedDataType(connection.getSourcePort());
        }
        DataType targetDataType = getDefinedDataType(connection.getTargetPort());
        if (targetDataType != null && targetDataType != sourceDataType) {
            return false;
        }
        if (sourceDataType == DataType.REFERENCE && targetDataType == null) {
            return false;
        }
        return true;
    }

    public static DataType getDefinedDataType(InputPort port) {
        if (port.getInput() instanceof BlockInput) {
            BlockInput blockInput = (BlockInput) port.getInput();
            if (blockInput.getDefinition().getDataType() instanceof MicasDataTypeSpecification) {
                return ((MicasDataTypeSpecification) blockInput.getDefinition().getDataType()).getDataType();
            }
        }
        return null;
    }

    public static DataType getDefinedDataType(OutputPort port) {

        if (port.getOutput() instanceof BlockOutput) {
            BlockOutput blockOutput = (BlockOutput) port.getOutput();
            if (blockOutput.getDefinition().getDataType() instanceof MicasDataTypeSpecification) {
                return ((MicasDataTypeSpecification) blockOutput.getDefinition().getDataType()).getDataType();
            }
        }
        return null;
    }

    public static String getArgumentValue(Block block, String parameterName) {
        ExpressionSpecification value = getExpressionSpecification(block, parameterName);
        return value != null ? value.getExpression() : "";
    }

    public static ExpressionSpecification getExpressionSpecification(Block block, String parameterName) {
        Argument parameterArgument = block.getArgument(parameterName);
        ExpressionSpecification value = (ExpressionSpecification) (parameterArgument != null
                ? parameterArgument.getValue()
                : null);
        return value;
    }

    public static List<Row> parseSupportingPoints(Block block) {
        List<Row> rows = new ArrayList<>();
        String[] supportingPoints = StringUtils.split(getArgumentValue(block, FKG_PROP_SUPPORINGPOINTS), ';');
        for (int i = 0; i < supportingPoints.length; i++) {
            String rawrow = supportingPoints[i];
            String[] xy = StringUtils.split(rawrow, '#');
            if (xy == null || xy.length != 2) {
                continue;
            }
            double x = .0d;
            try {
                x = Double.parseDouble(xy[0]);
            } catch (NumberFormatException e) {
            }
            double y = .0d;
            try {
                y = Double.parseDouble(xy[1]);
            } catch (NumberFormatException e) {
            }
            rows.add(new Row(x, y));
        }
        return rows;
    }

    public static Set<Connection> getAllConnections(Module module) {
        final Set<Connection> allConnections = Sets.newHashSet();
        TreeIterator<EObject> allContent = EcoreUtil.getAllContents(module.eResource(), true);
        DMLSwitch<Object> dmlSwitch = new DMLSwitch<Object>() {
            @Override
            public Object caseConnection(Connection object) {
                allConnections.add(object);
                return null;
            }
        };

        while (allContent.hasNext()) {
            dmlSwitch.doSwitch(allContent.next());
        }
        return allConnections;
    }

    public static Map<Attribute, AttributeSpecification> getAllAttributeSpecificationsByAttribute(Module module) {
        final Map<Attribute, AttributeSpecification> allSpecifications = Maps.newHashMap();
        TreeIterator<EObject> allContent = EcoreUtil.getAllContents(module.eResource(), true);
        final ModuleSwitch<Object> modelSwitch = new ModuleSwitch<Object>() {
            @Override
            public Object caseAttributeSpecification(AttributeSpecification spec) {
                if (spec.getAttribute() != null) {
                    allSpecifications.put(spec.getAttribute(), spec);
                }
                return null;
            }
        };
        while (allContent.hasNext()) {
            modelSwitch.doSwitch(allContent.next());
        }
        return allSpecifications;
    }

    public static boolean haveReferences(Attribute[] attributes) {
        boolean referenced = false;
        Map<Attribute, AttributeSpecification> allSpecifications = null;
        for (Attribute attribute : attributes) {
            if (allSpecifications == null) {
                allSpecifications = getAllAttributeSpecificationsByAttribute((Module) attribute.eContainer());
            }
            if (allSpecifications.containsKey(attribute)) {
                // attribute is somewhere referenced
                referenced = true;
                break;
            }

        }
        return referenced;
    }

    /**
     * @param domain
     *            Editing domain
     * @param attributes
     *            attributes to remove from container
     * @return first attribute index which was removed
     */
    public static int removeAttributes(EditingDomain domain, Collection<Attribute> attributes) {
        if (attributes == null || attributes.isEmpty()) {
            return -1;
        }

        Attribute firstToRemove = attributes.iterator().next();
        Module module = (Module) firstToRemove.eContainer();
        int index = module.getAttributes().indexOf(firstToRemove) - 1;
        for (Attribute attribute : attributes) {
            Command command = DeleteCommand.create(domain, attribute);
            domain.getCommandStack().execute(command);
        }
        return index;
    }

    public static Multimap<Attribute, AttributeSpecification> getAllAttributeSpecifications2(Module module) {

        final List<AttributeSpecification> allSpecifications = Lists.newArrayList();
        TreeIterator<EObject> allContent = EcoreUtil.getAllContents(module.eResource(), true);
        final ModuleSwitch<Object> modelSwitch = new ModuleSwitch<Object>() {
            @Override
            public Object caseAttributeSpecification(AttributeSpecification spec) {
                if (spec.getAttribute() != null) {
                    allSpecifications.add(spec);
                }
                return null;
            }
        };
        while (allContent.hasNext()) {
            modelSwitch.doSwitch(allContent.next());
        }
        Function<AttributeSpecification, Attribute> keyFunction = new Function<AttributeSpecification, Attribute>() {
            @Override
            public Attribute apply(AttributeSpecification input) {
                return input.getAttribute();
            }
        };
        return Multimaps.index(allSpecifications, keyFunction);
    }

    public static ConstantAttribute getConstantAttribute(Component component) {
        ConstantAttribute constantAttribute = null;
        if (component != null) {
            SignalSpecification signalSpecification = component.getFirstOutputPort().getSignal();
            if (signalSpecification instanceof AttributeSpecification) {
                Attribute attribute = ((AttributeSpecification) signalSpecification).getAttribute();
                if (attribute instanceof ConstantAttribute) {
                    constantAttribute = (ConstantAttribute) attribute;
                }
            }
        }
        return constantAttribute;
    }

    public static OutputPort getConnectionSource(Connection connection) {
        if (connection == null) {
            return null;
        }
        return connection.getSource() instanceof OutputPort ? (OutputPort) connection.getSource() : null;
    }

    public static InputPort getConnectionTarget(Connection connection) {
        return connection.getTarget() instanceof InputPort ? (InputPort) connection.getTarget() : null;
    }

    public static Connection getIncomingConnection(OutgoingOffpageConnector offpageConnector) {
        Connection connection = offpageConnector.getFirstInputPort()
                .getFirstConnection(offpageConnector.getOwningFragment());
        return connection;
    }

    public static AttributeSpecification getConnectionAttributeSpecification(Connection connection) {
        OutputPort source = getConnectionSource(connection);
        if (source == null) {
            return null;
        }
        SignalSpecification signal = source.getSignal();
        if (signal == null) {
            return null;
        }
        return (AttributeSpecification) signal;
    }

    public static void removeAttributeIfUnused(AttributeSpecification spec) {
        if (spec != null && spec.getAttribute() != null) {
            Module module = (Module) spec.getAttribute().eContainer();
            Map<Attribute, Collection<AttributeSpecification>> allSpecs = getAllAttributeSpecifications2(module)
                    .asMap();
            Attribute attributeToDelete = spec.getAttribute();
            if (allSpecs.containsKey(attributeToDelete) && allSpecs.get(attributeToDelete).size() == 1
                    && spec.equals(allSpecs.get(attributeToDelete).iterator().next())) {
                spec.setAttribute(null);
                module.getAttributes().remove(attributeToDelete);
            } else if (!allSpecs.containsKey(attributeToDelete) && attributeToDelete != null) {
                // TODO: leads to model inconsi
                module.getAttributes().remove(attributeToDelete);
            }

        }
    }

    public static OutputPort getSourcePort(Connection connection) {
        OutputConnector source = connection.getSource();
        return source instanceof OutputPort ? (OutputPort) source : null;
    }

    public static AttributeSpecification getAttributeSpecification(Connection connection) {
        if (connection == null) {
            return null;
        }
        OutputPort sourcePort = getSourcePort(connection);
        if (sourcePort == null) {
            return null;
        }
        SignalSpecification signal = sourcePort.getSignal();
        return signal instanceof AttributeSpecification ? (AttributeSpecification) signal : null;
    }

    public static Optional<Attribute> getAttribute(Optional<AttributeSpecification> attributeSpecification) {
        if (!attributeSpecification.isPresent()) {
            return Optional.absent();
        }
        return Optional.fromNullable(attributeSpecification.get().getAttribute());
    }

    public static Optional<AttributeSpecification> getSourceSignal(Connection connection) {
        if (connection == null) {
            return Optional.absent();
        }
        OutputPort sourcePort = connection.getSourcePort();
        if (sourcePort == null) {
            return Optional.absent();
        }
        SignalSpecification signal = sourcePort.getSignal();
        if (signal == null) {
            return Optional.absent();
        }
        if (!(signal instanceof AttributeSpecification)) {
            return Optional.absent();
        }
        return Optional.of((AttributeSpecification) signal);
    }

    public static Optional<AttributeSpecification> getSourceSignal(Optional<Connection> connection) {
        if (!connection.isPresent()) {
            return Optional.absent();
        }
        return getSourceSignal(connection.get());
    }

    public static Optional<Connection> getFirstIncommingConnection(InputPort firstInputPort) {
        if (firstInputPort == null) {
            return Optional.absent();
        }
        return Optional.of(firstInputPort.getIncomingConnections().iterator().next());
    }

    public static Optional<Connection> getFirstIncommingConnection(Component component) {
        InputPort firstInputPort = component.getFirstInputPort();
        return getFirstIncommingConnection(firstInputPort);
    }
}
