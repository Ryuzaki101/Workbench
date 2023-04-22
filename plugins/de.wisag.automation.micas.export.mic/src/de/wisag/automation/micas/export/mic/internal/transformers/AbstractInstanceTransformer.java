package de.wisag.automation.micas.export.mic.internal.transformers;

import org.eclipselabs.damos.dml.Block;

import de.wisag.automation.micas.export.mic.internal.IVariableNumberProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;

abstract class AbstractInstanceTransformer implements IInstanceTransformer {

    private IVariableNumberProvider variableIndexer;

    public IVariableNumberProvider getVariableIndexer() {
        return variableIndexer;
    }

    @Override
    public void setVariableIndexer(IVariableNumberProvider variableIndexer) {
        this.variableIndexer = variableIndexer;
    }

    @Override
    public void configure(RtModule rtModule, RtModuleInvocation rmi, ModuleDefinition moduleDefinition, Block block) {

    }

}
