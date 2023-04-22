package de.wisag.automation.micas.export.mic.internal.transformers;

import org.eclipselabs.damos.dml.Block;

import de.wisag.automation.micas.export.mic.internal.IVariableNumberProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtModuleInvocation;

public interface IInstanceTransformer {

    void transformInputs(RtModule rtModule, RtModuleInvocation rmi, ModuleDefinition moduleDefinition, Page page,
            Block block);

    void transformOutputs(RtModule rtModule, RtModuleInvocation rmi, ModuleDefinition moduleDefinition, Page page,
            Block block);

    /**
     * Called after a module is created
     *
     * @param rtModule
     * @param rmi
     * @param moduleDefinition
     * @param block
     */
    void configure(RtModule rtModule, RtModuleInvocation rmi, ModuleDefinition moduleDefinition, Block block);

    void setVariableIndexer(IVariableNumberProvider iVariableIndexer);

}
