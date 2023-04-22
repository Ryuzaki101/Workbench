package de.wisag.automation.micas.compiler.mic.test.regression.pastvalues;

import org.eclipse.core.resources.IProject;
import org.junit.BeforeClass;

import de.wisag.automation.micas.compiler.mic.test.DummyMicGeneratorGenerator;
import de.wisag.automation.micas.compiler.mic.test.ProjectUtils;
import de.wisag.automation.micas.compiler.mic.test.regression.hwmodules.HwModulesBaseTest;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.hwmodules.ModuleDefinition;

/**
 * Purpose: Generate n mic files, 1..10 foreach Module, compile each with old
 * mic and new mic
 *
 * @author krauter
 */
public class Testcase_01 extends HwModulesBaseTest {
    private static IProject project;
    private static IHwModulesProvider provider;

    @BeforeClass
    public static void setUp() throws Exception {
        provider = IHwModulesProvider.INSTANCE;
        String projectName = "micas.project-" + Testcase_01.class.getName();
        project = ProjectUtils.newProject(null, projectName);
    }

    private void check(int moduleCount, String moduleName) throws Exception {
        DummyMicGeneratorGenerator generator = new DummyMicGeneratorGenerator();
        System.out.println("Testcase_01.check()");
        String micSource = generator.createMicSource(provider.findModuleByName(moduleName), moduleCount);
        ProjectUtils.checkAndGenerate(project, "AC40", "CP1252", "PASTVAL_" + moduleCount + "_x" + moduleName,
                micSource, 2);
    }

    @Override
    protected void testModule(String name) throws Exception {
        ModuleDefinition mod = provider.findModuleByName(name);
        for (int i = 1; i < 10; i++) {
            check(i, mod.getName());
        }

    }

}
