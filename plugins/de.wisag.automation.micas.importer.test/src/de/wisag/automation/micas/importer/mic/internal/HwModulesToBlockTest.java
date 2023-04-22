package de.wisag.automation.micas.importer.mic.internal;

import static org.junit.Assert.assertNotNull;

import org.eclipse.emf.common.util.URI;
import org.eclipselabs.damos.dml.BlockType;
import org.eclipselabs.damos.dml.registry.IBlockTypeDescriptor;
import org.junit.Test;

import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.util.BlockTypeDescriptorCache;
import de.wisag.automation.micas.module.util.BlockUtils;

public class HwModulesToBlockTest {

    @Test
    public void checkHwModulesMapping() {
        Module module = ModuleFactory.eINSTANCE.createModule();

        ResourceConfigurator.configureResource(module, URI.createURI("bla.module"));

        for (ModuleDefinition md : IHwModulesProvider.INSTANCE.getModules()) {
            String name = md.getName();
            if ("ENDE".equals(name)) {
                continue;
            }
            IBlockTypeDescriptor desc = BlockTypeDescriptorCache.findBlockTypeDescriptor(name);
            assertNotNull("Module not found '" + name + "'", desc);
            try {
                BlockType blockType = BlockUtils.getBlockType(module.eResource(), desc);
                assertNotNull("BlockType not created '" + name + "'", blockType);
            } catch (IllegalArgumentException e) {
                System.err.println("Could not find " + name);
            }
        }
    }
}
