
package de.wisag.automation.micas;

/**
 * Initialization support for running Xtext languages without equinox extension
 * registry
 */
public class MICStandaloneSetup extends MICStandaloneSetupGenerated {

    public static void doSetup() {
        new MICStandaloneSetup().createInjectorAndDoEMFRegistration();
    }
}
