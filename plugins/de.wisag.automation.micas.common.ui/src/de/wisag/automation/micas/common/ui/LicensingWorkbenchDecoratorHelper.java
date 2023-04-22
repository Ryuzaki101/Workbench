package de.wisag.automation.micas.common.ui;

import org.eclipse.core.runtime.preferences.IEclipsePreferences;
import org.eclipse.core.runtime.preferences.InstanceScope;

import de.wisag.automation.micas.common.licensing.ILicenseManager;

public class LicensingWorkbenchDecoratorHelper {
    private static final String PROP_WORKSPACE_NAME = "WORKSPACE_NAME";
    public final static String DEMO_PREFIX = "*** DEMO DEMO DEMO DEMO DEMONSTRATION MODE ***";
    public final static String WARNING_PREFIX = "*** WARNING: ";

    public static void adjustWorkbenchLicenzingTitle(ILicenseManager licenseManager) {
        long expires;
        IEclipsePreferences preferences = InstanceScope.INSTANCE.getNode("org.eclipse.ui.ide");
        String current = preferences.get(PROP_WORKSPACE_NAME, "1a0d4038-4df8-11e6-beb8-9e71128cae77");
        if (licenseManager.isDemoMode()) {
            preferences.put(PROP_WORKSPACE_NAME, LicensingWorkbenchDecoratorHelper.DEMO_PREFIX);
        } else if ((expires = licenseManager.expiresInDays()) <= 30) {
            preferences.put(PROP_WORKSPACE_NAME,
                    String.format("%sLicense expires in %d days", WARNING_PREFIX, expires));
        } else if (current.startsWith(DEMO_PREFIX) || current.startsWith(WARNING_PREFIX)) {
            // reset
            preferences.put(PROP_WORKSPACE_NAME, "");
        }
    }

}
