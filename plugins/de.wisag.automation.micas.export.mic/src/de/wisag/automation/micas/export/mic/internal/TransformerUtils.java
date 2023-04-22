package de.wisag.automation.micas.export.mic.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.OutputPort;
import org.eclipselabs.damos.dml.SignalSpecification;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.export.mic.DiagramCompilerException;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;
import de.wisag.automation.micas.rt.RtSymbolAccessType;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class TransformerUtils {

    public static boolean isUnconnectedOutput(OutputPort bop) {
        EList<Connection> incomingConnections = bop.getConnections();

        if (incomingConnections == null || incomingConnections.size() == 0) {
            return true;
        }

        OutputPort sourcePort = (OutputPort) incomingConnections.get(0).getSource();
        if (sourcePort == null) {
            return true;
        }

        SignalSpecification signal = sourcePort.getSignal();
        if (!(signal instanceof AttributeSpecification)) {
            return true;

        }
        return false;
    }

    public static RtWordVariable createWordVariable(RtModule rtModule, String name) {
        RtWordVariable rtVariable = RtFactory.eINSTANCE.createRtWordVariable();
        rtVariable.setName(name);
        rtVariable.setModule(rtModule);
        return rtVariable;
    }

    public static RtFloatVariable createFloatVariable(RtModule rtModule, String name) {
        RtFloatVariable rtVariable = RtFactory.eINSTANCE.createRtFloatVariable();
        rtVariable.setName(name);
        rtVariable.setModule(rtModule);
        return rtVariable;
    }

    public static RtSymbol createWordConstant(RtModule rtModule, String name, int value) {
        RtWordConstant rtConstant = RtFactory.eINSTANCE.createRtWordConstant();
        rtConstant.setName(name);
        rtConstant.setValue(value);
        rtConstant.setModule(rtModule);
        return rtConstant;
    }

    public static RtFloatConstant createFloatConstant(RtModule rtModule, String name, double value) {
        RtFloatConstant rtConstant = RtFactory.eINSTANCE.createRtFloatConstant();
        rtConstant.setName(name);
        rtConstant.setValue(value);
        rtConstant.setModule(rtModule);
        return rtConstant;
    }

    public static RtSymbol findSymbol(RtModule rtModule, String name) {
        Assert.isNotNull(name, "'name' must not be null");
        RtSymbol symbol = null;
        for (RtSymbol rtSymbol : rtModule.getSymbols()) {
            if (name.equals(rtSymbol.getName())) {
                symbol = rtSymbol;
                break;
            }
        }
        return symbol;
    }

    public static RtSymbolAccess createSymbolAccess(RtModule rtModule, String name, boolean read) {
        RtSymbol symbol = TransformerUtils.findSymbol(rtModule, name);
        if (symbol == null) {
            System.err.println(String.format("No Symbol found for '%s'", name));
            return null;
        }
        return createSymbolAccess(symbol, read);
    }

    public static RtSymbolAccess createSymbolAccess(RtSymbol symbol, boolean read) {
        RtSymbolAccess symbolAccess = RtFactory.eINSTANCE.createRtSymbolAccess();
        symbolAccess.setSymbol(symbol);
        symbolAccess.setType(read ? RtSymbolAccessType.READ : RtSymbolAccessType.WRITE);
        return symbolAccess;
    }

    public static RtSymbolAccess createSymbolAccess(RtModule rtModule, OutputPort bop) {
        if (isUnconnectedOutput(bop)) {
            return null;
        }
        AttributeSpecification attributeSpecification = (AttributeSpecification) bop.getOutgoingConnections().get(0)
                .getSourcePort().getSignal();
        Attribute attribute = attributeSpecification.getAttribute();
        String name = null;
        if (attribute == null) {
            name = HardcodedValues.WSCATCH_VARIABLE;
        } else {
            name = attribute.getName();
        }
        return createSymbolAccess(rtModule, name, true);
    }

    public static RtSymbolAccess createDirectValueSymbolAccess(RtModule rtModule, int count) {
        RtDirectValue directValue = RtFactory.eINSTANCE.createRtDirectValue();
        directValue.setValue(count);
        directValue.setModule(rtModule);
        RtSymbolAccess symbolAccess = RtFactory.eINSTANCE.createRtSymbolAccess();
        symbolAccess.setSymbol(directValue);
        symbolAccess.setType(RtSymbolAccessType.READ);
        return symbolAccess;
    }

    public static RtModuleInvocation create(ModuleDefinition moduleDefinition) {
        RtModuleInvocation rmi = RtFactory.eINSTANCE.createRtModuleInvocation();
        rmi.setName(moduleDefinition.getName());
        rmi.setOpcode(moduleDefinition.getId());
        rmi.setPastValuesCount(moduleDefinition.getPastValueCount());
        rmi.setRuntime((int) moduleDefinition.getRuntime());
        return rmi;
    }

    public static boolean isUnconnectedInput(InputPort blockInputPort) {

        EList<Connection> incomingConnections = blockInputPort.getConnections();
        if (incomingConnections == null || incomingConnections.isEmpty()) {
            return true;
        }
        OutputPort sourcePort = (OutputPort) incomingConnections.iterator().next().getSource();
        if (sourcePort == null) {
            return true;
        }

        SignalSpecification signal = sourcePort.getSignal();
        if (!(signal instanceof AttributeSpecification)) {
            return true;

        }
        return false;
    }

    public static RtSymbolAccess createSymbolAccess(RtModule rtModule, Page page, InputPort blockInputPort) {
        if (isUnconnectedInput(blockInputPort)) {
            return null;
        }

        AttributeSpecification attributeSpecification = (AttributeSpecification) blockInputPort.getIncomingConnections()
                .get(0).getSourcePort().getSignal();
        Attribute attribute = attributeSpecification.getAttribute();

        // DataType dataType = attribute.getDataType();
        // TODO: check
        if (attribute instanceof ConstantAttribute) {

        } else if (attribute instanceof VariableAttribute) {

        } else if (attribute instanceof ReferenceAttribute) {
            // ReferenceAttribute referenceAttribute = (ReferenceAttribute)
            // attribute;
            // ReferenceType refType = referenceAttribute.getReferenceType();

        }
        String name = null;
        if (attribute == null) {
            name = HardcodedValues.WSCATCH_VARIABLE;
        } else {
            name = attribute.getName();
        }
        if (name == null) {
            throw new DiagramCompilerException(DiagramCompilerException.Code.ATTRIBUTE_WITH_NULL_NAME_ON_INPUT_PORT,
                    String.format("Name of Attribute was null. %s/%s/%s\n", page.getTask().getModule().getName(),
                            page.getTask().getName(), page.getName()));
        }
        return createSymbolAccess(rtModule, name, true);
    }

    static boolean isDirectValuePort(Port port) {
        return port.getAllowedPortDataTypes().contains(PortDataType.DIRECT_VALUE);
    }

    public static EList<Port> excludeDirectValues(EList<Port> ports) {
        BasicEList<Port> filteredPorts = new BasicEList<>();
        for (Port port : ports) {
            if (isDirectValuePort(port)) {
                continue;
            }
            filteredPorts.add(port);
        }
        return filteredPorts;
    }

    static String[] setupDefaults(RtModule rtModule) {
        List<String> reservedNames = new ArrayList<>();
        RtSymbol varScratch = createWordVariable(rtModule, HardcodedValues.WSCATCH_VARIABLE);
        reservedNames.add(HardcodedValues.WSCATCH_VARIABLE);
        varScratch.setModule(rtModule);
        rtModule.getSymbols().add(varScratch);

        RtSymbol wZero = createWordConstant(rtModule, HardcodedValues.WZERO_CONSTANT, 0);
        reservedNames.add(HardcodedValues.WZERO_CONSTANT);

        wZero.setModule(rtModule);
        rtModule.getSymbols().add(wZero);

        RtSymbol wOne = createWordConstant(rtModule, HardcodedValues.WONE_CONSTANT, 1);
        reservedNames.add(HardcodedValues.WONE_CONSTANT);
        wOne.setModule(rtModule);
        rtModule.getSymbols().add(wOne);
        String[] rn = reservedNames.toArray(new String[reservedNames.size()]);
        Arrays.sort(rn, String.CASE_INSENSITIVE_ORDER);
        return rn;
    }
}
