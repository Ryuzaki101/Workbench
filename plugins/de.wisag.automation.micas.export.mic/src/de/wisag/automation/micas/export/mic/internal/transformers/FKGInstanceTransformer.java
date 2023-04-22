package de.wisag.automation.micas.export.mic.internal.transformers;

import java.util.List;

import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.BlockInputPort;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.export.mic.internal.TransformerUtils;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.ModuleUtil;
import de.wisag.automation.micas.module.util.Row;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;
import de.wisag.automation.micas.rt.RtSymbolAccess;

public class FKGInstanceTransformer extends DefaultInstanceTransformer {
    @Override
    public void configure(RtModule rtModule, RtModuleInvocation rmi, ModuleDefinition moduleDefinition, Block block) {
        super.configure(rtModule, rmi, moduleDefinition, block);
    }

    @Override
    public void transformInputs(RtModule rtm, RtModuleInvocation rmi, ModuleDefinition mdef, Page page, Block block) {
        List<Row> rows = ModuleUtil.parseSupportingPoints(block);

        if (rows.size() > 254) {
            throw new RuntimeException("To many pairs for FKG Supportingpoints");
        }
        // On input side, create first
        BlockInputPort blockInputPort = (BlockInputPort) block.getFirstInputPort();
        RtSymbolAccess symbolAccess = TransformerUtils.createSymbolAccess(rtm, page, blockInputPort);
        if (symbolAccess == null) {
            RtSymbolAccess sa = TransformerUtils.createSymbolAccess(rtm, HardcodedValues.WZERO_CONSTANT, true);
            rmi.getArguments().add(sa);
        } else {
            rmi.getArguments().add(symbolAccess);
        }
        // count all values
        rmi.getArguments().add(TransformerUtils.createDirectValueSymbolAccess(rtm, rows.size() * 2));
        int i = 0;
        String constNamePrefix = "$" + rmi.getName() + "_" + getVariableIndexer().nextIndex();
        for (Row row : rows) {
            RtFloatConstant xConst = TransformerUtils.createFloatConstant(rtm,
                    String.format("%s_X%d", constNamePrefix, i), row.getX());
            rmi.getArguments().add(TransformerUtils.createSymbolAccess(xConst, true));
            RtFloatConstant yConst = TransformerUtils.createFloatConstant(rtm,
                    String.format("%s_Y%d", constNamePrefix, i), row.getY());
            rmi.getArguments().add(TransformerUtils.createSymbolAccess(yConst, true));
            i++;
        }
    }
}
