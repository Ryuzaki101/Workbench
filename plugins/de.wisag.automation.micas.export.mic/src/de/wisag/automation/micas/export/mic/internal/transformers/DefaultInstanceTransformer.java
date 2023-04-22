package de.wisag.automation.micas.export.mic.internal.transformers;

import java.util.Iterator;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInput;
import org.eclipselabs.damos.dml.BlockInputPort;
import org.eclipselabs.damos.dml.BlockOutput;
import org.eclipselabs.damos.dml.BlockOutputPort;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputDefinition;
import org.eclipselabs.damos.dml.InputPort;
import org.eclipselabs.damos.dml.Output;
import org.eclipselabs.damos.dml.OutputDefinition;
import org.eclipselabs.damos.dml.OutputPort;

import de.wisag.automation.micas.export.mic.DiagramCompilerException;
import de.wisag.automation.micas.export.mic.DiagramCompilerException.Code;
import de.wisag.automation.micas.export.mic.internal.TransformerUtils;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;
import de.wisag.automation.micas.hwmodules.PortDataType;
import de.wisag.automation.micas.hwmodules.PortGroup;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.BlockUtils;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtSymbolAccess;

public class DefaultInstanceTransformer extends AbstractInstanceTransformer {
    public final static String DEFAULT_TRANSFORMER = "DEFAULT_TRANSFORMER";

    public DefaultInstanceTransformer() {

    }

    @Override
    public void transformOutputs(RtModule rtm, RtModuleInvocation rmi, ModuleDefinition mdef, Page page, Block block) {
        EList<Port> outputs = TransformerUtils.excludeDirectValues(mdef.getOutputs());
        Assert.isTrue(block.getOutputs().size() == outputs.size(),
                String.format("Number of outputs differ from definition for %s: expected: %d actual %d",
                        block.getName(), outputs.size(), block.getOutputs().size()));

        Iterator<Output> blockOutputs = block.getOutputs().iterator();
        for (Port portDef : mdef.getOutputs()) {
            Output blockOutput = blockOutputs.next();
            EList<OutputPort> outputPorts = blockOutput.getPorts();
            if (portDef instanceof PortGroup) {
                int count = outputPorts.size();
                RtSymbolAccess symbolAccess = TransformerUtils.createDirectValueSymbolAccess(rtm, count);
                rmi.getArguments().add(symbolAccess);
                for (OutputPort outputPort : outputPorts) {
                    // unconnected outport
                    symbolAccess = TransformerUtils.createSymbolAccess(rtm, outputPort);
                    if (symbolAccess == null) {
                        symbolAccess = generateDummyOutputSymbol(rtm,
                                (BlockOutput) ((BlockOutputPort) outputPort).getOutput(), rmi, portDef);
                    }
                    rmi.getArguments().add(symbolAccess);
                }
            } else {
                OutputPort outputPort = outputPorts.get(0);
                RtSymbolAccess symbolAccess = TransformerUtils.createSymbolAccess(rtm, outputPort);
                if (symbolAccess == null) {
                    BlockOutput output = (BlockOutput) outputPort.getOutput();
                    symbolAccess = generateDummyOutputSymbol(rtm, output, rmi, portDef);
                }
                rmi.getArguments().add(symbolAccess);
            }

        }
    }

    private RtSymbolAccess generateDummyOutputSymbol(RtModule rtm, BlockOutput blockInput2, RtModuleInvocation rmi,
            Port portDef) {
        OutputDefinition definition = blockInput2.getDefinition();
        String name = definition.getName();
        String varName = "$OUT-" + rmi.getName() + "-" + getVariableIndexer().nextIndex() + "-"
                + StringUtils.remove(name, " ");
        varName = StringUtils.lowerCase(varName);
        RtSymbol rtSymbol = null;
        if (portDef.getAllowedPortDataTypes().contains(PortDataType.WORD_VAR)) {
            rtSymbol = TransformerUtils.createWordVariable(rtm, varName);

        } else {
            rtSymbol = TransformerUtils.createFloatVariable(rtm, varName);
        }
        RtSymbolAccess createSymbolAccess = TransformerUtils.createSymbolAccess(rtSymbol, false);
        return createSymbolAccess;
    }

    @Override
    public void transformInputs(RtModule rtm, RtModuleInvocation rmi, ModuleDefinition mdef, Page page, Block block) {
        //
        EList<Port> inputs = TransformerUtils.excludeDirectValues(mdef.getInputs());
        Assert.isTrue(block.getInputs().size() == inputs.size(), "Input count differ for " + mdef.getName()
                + " hwmodule : " + inputs.size() + " diagmodule : " + block.getInputs().size());
        Iterator<Input> blockInputs = block.getInputs().iterator();
        for (Port portDef : inputs) {
            Input blockInput = blockInputs.next();
            EList<InputPort> inputPorts = blockInput.getPorts();
            if (portDef instanceof PortGroup) {
                int count = inputPorts.size();
                RtSymbolAccess symbolAccess = TransformerUtils.createDirectValueSymbolAccess(rtm, count);
                rmi.getArguments().add(symbolAccess);
                for (InputPort outputPort : inputPorts) {
                    BlockInputPort blockInputPort = (BlockInputPort) outputPort;
                    symbolAccess = TransformerUtils.createSymbolAccess(rtm, page, blockInputPort);
                    if (symbolAccess == null) {
                        symbolAccess = generateDummyInput(rtm, rmi, portDef, (BlockInput) blockInputPort.getInput());
                    }
                    rmi.getArguments().add(symbolAccess);
                }
            } else {
                InputPort blockInputPort = inputPorts.iterator().next();
                RtSymbolAccess symbolAccess;
                try {
                    symbolAccess = TransformerUtils.createSymbolAccess(rtm, page, blockInputPort);
                } catch (DiagramCompilerException e) {
                    if (e.code() == Code.ATTRIBUTE_WITH_NULL_NAME_ON_INPUT_PORT) {
                        String blockName = block.getName();
                        Integer index = BlockUtils.getIndex(block);
                        boolean isInput = portDef.isInputPort();

                        String details = String.format(" Block : %s, Prio: %d, input:%s, portindex:%d", blockName,
                                index, isInput, portDef.getIndex());
                        throw new DiagramCompilerException(e.code(),
                                String.format("%s. Details: %s", e.getMessage(), details));

                    }
                    throw e;
                }
                if (symbolAccess == null) {
                    symbolAccess = generateDummyInput(rtm, rmi, portDef, (BlockInput) blockInputPort.getInput());
                }
                rmi.getArguments().add(symbolAccess);
            }

        }
    }

    private RtSymbolAccess generateDummyInput(RtModule rtm, RtModuleInvocation rmi, Port portDef, BlockInput bInput) {
        InputDefinition definition = bInput.getDefinition();
        String name = definition.getName();
        String varName = "$IN-" + rmi.getName() + "-" + getVariableIndexer().nextIndex() + "-"
                + StringUtils.remove(name, " ");
        varName = StringUtils.lowerCase(varName);
        RtSymbol symbol = null;
        if (portDef.getAllowedPortDataTypes().contains(PortDataType.WORD_CONST)) {
            symbol = TransformerUtils.createWordConstant(rtm, varName, 0);
        } else {
            symbol = TransformerUtils.createFloatConstant(rtm, varName, .0f);
        }
        RtSymbolAccess createSymbolAccess = TransformerUtils.createSymbolAccess(symbol, true);
        return createSymbolAccess;
    }

}
