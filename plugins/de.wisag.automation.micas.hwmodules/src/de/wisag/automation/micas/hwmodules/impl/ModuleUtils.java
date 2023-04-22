package de.wisag.automation.micas.hwmodules.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.wisag.automation.micas.hwmodules.HwmodulesPackage;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.Port;

public class ModuleUtils {

    public static ModuleDefinition findModuleById(MicasModules modules, int id) {
        if (modules.getModulesById() == null || modules.getModulesById().isEmpty()) {
            HashMap<Integer, ModuleDefinition> map = new HashMap<>();
            for (ModuleDefinition module : modules.getModules()) {
                map.put(module.getId(), module);
            }
            modules.setModulesById(map);
        }
        return modules.getModulesById().get(Integer.valueOf(id));
    }

    public static int getPortGroupsCount(ModuleDefinition module) {
        return EcoreUtil.<Object> getObjectsByType(allPorts(module), HwmodulesPackage.eINSTANCE.getPortGroup()).size();
    }

    private static BasicEList<Port> allPorts(ModuleDefinition module) {
        BasicEList<Port> ports = new BasicEList<>();
        ports.addAll(module.getInputs());
        ports.addAll(module.getOutputs());
        return ports;
    }

    public static int getPortsCount(ModuleDefinition module) {
        BasicEList<Port> ports = allPorts(module);
        Collection<Object> portGroups = EcoreUtil.getObjectsByType(ports, HwmodulesPackage.eINSTANCE.getPortGroup());
        return ports.size() - portGroups.size();
    }

    public static synchronized ModuleDefinition findModuleByName(MicasModules modules, String name) {
        if (modules.getModulesByName() == null || modules.getModulesByName().isEmpty()) {
            Map<String, ModuleDefinition> map = new HashMap<>();
            for (ModuleDefinition module : modules.getModules()) {
                map.put(module.getName(), module);
            }
            modules.setModulesByName(map);
        }
        return modules.getModulesByName().get(StringUtils.trim(name));
    }
}
