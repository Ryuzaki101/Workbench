package de.wisag.automation.micas.compiler.mic.test;

import org.junit.Test;

public abstract class TestForAllHardware extends ProjectTestCase {

    @Test
    public void checkACXX() throws Exception {
        // for type ACXX
        check("AC40", 2);
    }

    @Test
    public void checkZPXX() throws Exception {
        // ZPXX
        check("ZP12", 2);
    }

    @Test
    public void checkERXX() throws Exception {
        // ERXX
        check("ER11", 2);
    }

    @Test
    public void checkMBXX() throws Exception {
        // MBXX
        check("AR11", 2);
    }

}
