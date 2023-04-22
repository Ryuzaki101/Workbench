package de.wisag.automation.micas.compiler.mic.test.regression.simple;

import de.wisag.automation.micas.compiler.mic.test.TestForAllHardware;

public abstract class SimpleTestcaseBase extends TestForAllHardware {
    @Override
    protected boolean skipHardware(String hwName) {
        return false;
    }
}
