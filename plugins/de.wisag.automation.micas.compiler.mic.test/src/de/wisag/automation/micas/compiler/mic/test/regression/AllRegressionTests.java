package de.wisag.automation.micas.compiler.mic.test.regression;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ de.wisag.automation.micas.compiler.mic.test.regression.big.AllTests.class,
        de.wisag.automation.micas.compiler.mic.test.regression.pastvalues.AllTests.class,
        de.wisag.automation.micas.compiler.mic.test.regression.hwmodules.AllTests.class,
        de.wisag.automation.micas.compiler.mic.test.regression.realworld.AllTests.class })
public class AllRegressionTests {

}