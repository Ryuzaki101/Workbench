package de.wisag.automation.micas.compiler.mic.test.regression.hwmodules;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.EList;
import org.junit.BeforeClass;

import de.wisag.automation.micas.common.WellknownSpecialBlocks;
import de.wisag.automation.micas.compiler.mic.test.DummyMicGeneratorGenerator;
import de.wisag.automation.micas.compiler.mic.test.ProjectUtils;
import de.wisag.automation.micas.hwmodules.HardwareAlias;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;

public abstract class HwModulesCompileTest extends HwModulesBaseTest {
    static IProject project;
    private static int COUNTER = 30000;

    static Map<String, String> testSourceByModule = new HashMap<>();

    @BeforeClass
    public static void setUp() throws Exception {
        Collection<ModuleDefinition> modules = IHwModulesProvider.INSTANCE.getModules();
        // Better way create RtModule and make mic from it
        for (ModuleDefinition module : modules) {
            if (WellknownSpecialBlocks.ENDE.equals(module.getName())) {
                continue;
            }
            DummyMicGeneratorGenerator generator = new DummyMicGeneratorGenerator();
            String micSource = generator.createMicSource(module, 1);
            testSourceByModule.put(module.getName(), micSource);
            // System.out.println(micSource);
        }
        String projectName = "micas.project-" + COUNTER++;
        project = ProjectUtils.newProject(null, projectName);

    }

    @Override
    protected void testModule(String name) throws Exception {
        ModuleDefinition module = IHwModulesProvider.INSTANCE.findModuleByName(name);
        String typeName = getHwTypeName();
        EList<HardwareAlias> unsupported = module.getSupportedByHardware();
        boolean found = false;
        for (HardwareAlias hardwareAlias : unsupported) {
            if (hardwareAlias.getName().equals(typeName)) {
                found = true;
            }
        }
        if (found) {
            ProjectUtils.checkAndGenerate(project, getHwTypeName(), "CP1252", name, testSourceByModule.get(name), 2);
        }
    }

    protected String getHwTypeName() {
        String simpleName = getClass().getSimpleName();
        return simpleName.substring(simpleName.lastIndexOf("_") + 1);
    }
}
