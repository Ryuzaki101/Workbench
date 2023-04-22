package de.wisag.automation.micas.hwmodules;

import java.util.Collection;

import de.wisag.automation.micas.hwmodules.internal.MicasModulesProvider;

/**
 * Provides informations about micas modules extracted from the c-sources
 *
 * @author krauter
 */
public interface IHwModulesProvider {
    IHwModulesProvider INSTANCE = MicasModulesProvider.getInstance();

    ModuleDefinition findModuleByName(String name);

    Collection<ModuleDefinition> getModules();

    boolean supportsHardwareType(String type);

    public HardwareTypeDefinition findHardwareTypeDefinition(String type);

    ModuleDefinition findModuleById(int blockId);

    HardwareTypeDefinition findHardwareTypeDefinition(HardwareType hardwareType);

    MicasModules getMicasModules();
}
