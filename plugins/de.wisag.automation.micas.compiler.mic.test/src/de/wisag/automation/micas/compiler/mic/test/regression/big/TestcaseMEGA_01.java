package de.wisag.automation.micas.compiler.mic.test.regression.big;

import org.eclipse.core.resources.IProject;

import de.wisag.automation.micas.compiler.mic.test.ProjectUtils;
import de.wisag.automation.micas.compiler.mic.test.TestForAllHardware;

public class TestcaseMEGA_01 extends TestForAllHardware {

    @Override
    public IProject getProject() throws Exception {
        String projectName = "micas.project-" + getClass().getSimpleName();
        return ProjectUtils.newProject(null, projectName);
    }

    @Override
    public String getTestPath() {
        return "/testdata/big/01_MEGA.mic";
    }

    @Override
    public String getEncoding() {
        return "CP1252";
    }

    @Override
    protected boolean skipHardware(String hwName) {

        return false;
    }

}
