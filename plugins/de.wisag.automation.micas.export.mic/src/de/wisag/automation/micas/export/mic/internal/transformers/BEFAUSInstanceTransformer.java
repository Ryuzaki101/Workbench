package de.wisag.automation.micas.export.mic.internal.transformers;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Input;
import org.eclipselabs.damos.dml.InputPort;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.export.mic.internal.TransformerUtils;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.rt.RtDirectValue;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbolAccess;

public class BEFAUSInstanceTransformer extends DefaultInstanceTransformer {

    @Override
    public void transformInputs(RtModule rtm, RtModuleInvocation rmi, ModuleDefinition mdef, Page page, Block block) {
        EList<Input> inputs = block.getInputs();
        int connectedOn = 0;
        final RtSymbolAccess symbolAccess = TransformerUtils.createDirectValueSymbolAccess(rtm, connectedOn);
        rmi.getArguments().add(symbolAccess);
        rmi.getArguments().add(TransformerUtils.createSymbolAccess(rtm, page, inputs.get(0).getPorts().get(0)));
        connectedOn += connectUnconnectedOrGiveMeOne(rtm, rmi, page, inputs.get(1).getPorts().get(0));
        connectedOn += connectUnconnectedOrGiveMeOne(rtm, rmi, page, inputs.get(2).getPorts().get(0));
        connectedOn += connectUnconnectedOrGiveMeOne(rtm, rmi, page, inputs.get(3).getPorts().get(0));
        InputPort blockInputPort = inputs.get(4).getPorts().get(0);
        rmi.getArguments().add(TransformerUtils.createSymbolAccess(rtm, page, blockInputPort));
        // update really connected On Ports
        RtDirectValue directValue = (RtDirectValue) symbolAccess.getSymbol();
        directValue.setValue(connectedOn);

    }

    private int connectUnconnectedOrGiveMeOne(RtModule rtm, RtModuleInvocation rmi, Page page, InputPort on1) {
        int cnt = 0;
        if (TransformerUtils.isUnconnectedInput(on1)) {
            // point do WZERO
            rmi.getArguments().add(TransformerUtils.createSymbolAccess(rtm, HardcodedValues.WZERO_CONSTANT, true));
        } else {
            RtSymbolAccess sa = TransformerUtils.createSymbolAccess(rtm, page, on1);
            rmi.getArguments().add(sa);
            // only inc if its not grounded
            if (!HardcodedValues.WZERO_CONSTANT.equals(sa.getSymbol().getName())) {
                cnt++;
            }
        }
        return cnt;
    }

}
