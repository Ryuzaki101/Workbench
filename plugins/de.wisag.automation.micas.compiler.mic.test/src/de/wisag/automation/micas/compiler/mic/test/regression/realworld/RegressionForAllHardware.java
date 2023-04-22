package de.wisag.automation.micas.compiler.mic.test.regression.realworld;

import org.eclipse.core.resources.IProject;

import de.wisag.automation.micas.compiler.mic.test.ProjectUtils;
import de.wisag.automation.micas.compiler.mic.test.TestForAllHardware;

public abstract class RegressionForAllHardware extends TestForAllHardware {

    @Override
    public IProject getProject() throws Exception {
        return ProjectUtils.newProject(null, "micas-realworld-regression");
    }

    @Override
    protected boolean skipHardware(String hwName) {
        return false;
    }
}
