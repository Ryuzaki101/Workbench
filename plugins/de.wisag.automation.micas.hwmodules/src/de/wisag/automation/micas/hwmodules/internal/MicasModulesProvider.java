package de.wisag.automation.micas.hwmodules.internal;

import static de.wisag.automation.micas.hwmodules.ModulesPersistentHelper.load;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.HwModuleDefaults;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.MicasModules;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;
import de.wisag.automation.micas.hwmodules.ModulesPersistentHelper;

public class MicasModulesProvider implements IHwModulesProvider {
    private static final String MODULES_HW = "modules.hw";
    private static volatile MicasModulesProvider _instance = null;
    private final Map<String, HardwareTypeDefinition> definitionsByName = new HashMap<>();

    public synchronized static IHwModulesProvider getInstance() {
        if (_instance == null) {
            synchronized (MicasModulesProvider.class) {
                if (_instance == null) {
                    MicasModulesProvider provider = new MicasModulesProvider();
                    provider.lazyLoadModules();
                    _instance = provider;
                }
            }
        }
        return _instance;
    }

    private MicasModules modules = null;

    @Override
    public synchronized ModuleDefinition findModuleByName(String name) {
        return this.modules.findModuleByName(name);
    }

    private synchronized void lazyLoadModules() {
        try {
            modules = load(ModulesPersistentHelper.class.getResourceAsStream(MODULES_HW));
            EcoreUtil.resolveAll(modules);
            for (HardwareTypeDefinition type : modules.getTypes()) {
                EList<HardwareAlias> aliases = type.getAliases();
                for (HardwareAlias hardwareAlias : aliases) {
                    String aliasName = hardwareAlias.getName();
                    Assert.isNotNull(aliasName, "aliasName");
                    if (this.definitionsByName.containsKey(aliasName)) {
                        throw new RuntimeException(" alias " + aliasName + " mapped to more than one moduledefinition");
                    }
                    this.definitionsByName.put(aliasName, type);
                    // System.out.println("Map " + name + " => " + type);
                }
            }
            // just a nummy check
            Assert.isLegal(modules.findModuleById(HwModuleDefaults.END_MODULE_ID).getName()
                    .equals(WellknownSpecialBlocks.ENDE));
            Assert.isLegal(
                    modules.findModuleByName(WellknownSpecialBlocks.ENDE).getId() == HwModuleDefaults.END_MODULE_ID);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void dispose() {
        _instance = null;
    }

    @Override
    public synchronized Collection<ModuleDefinition> getModules() {
        return Collections.unmodifiableCollection(this.modules.getModules());
    }

    @Override
    public synchronized boolean supportsHardwareType(String type) {
        String moduleType = StringUtils.upperCase(type);
        Assert.isNotNull(moduleType, "type");
        return this.definitionsByName.containsKey(moduleType);
    }

    @Override
    public synchronized HardwareTypeDefinition findHardwareTypeDefinition(String type) {
        Assert.isNotNull(type, "type");
        String moduleType = StringUtils.upperCase(type);
        return this.definitionsByName.get(moduleType);
    }

    @Override
    public synchronized HardwareTypeDefinition findHardwareTypeDefinition(HardwareType hardwareType) {
        Assert.isNotNull(hardwareType, "hardwareType");
        String typeName = hardwareType.getName();
        for (HardwareTypeDefinition hardwareTypeDefinition : Collections
                .unmodifiableCollection(this.definitionsByName.values())) {
            String name = hardwareTypeDefinition.getType().getName();
            if (typeName.equals(name)) {
                Assert.isLegal(typeName.equals(name));
                return hardwareTypeDefinition;
            }
        }
        return null;
    }

    @Override
    public synchronized ModuleDefinition findModuleById(int blockId) {
        return this.modules.findModuleById(blockId);
    }

    @Override
    public synchronized MicasModules getMicasModules() {
        return this.modules;
    }
}
