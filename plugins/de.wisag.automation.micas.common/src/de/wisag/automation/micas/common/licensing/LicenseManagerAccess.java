package de.wisag.automation.micas.common.licensing;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import de.wisag.automation.micas.common.internal.Policy;

public class LicenseManagerAccess {

    public static ILicenseManager getLicenseManager() {
        ILicenseManager manager = null;
        BundleContext bc = FrameworkUtil.getBundle(LicenseManagerAccess.class).getBundleContext();
        ServiceReference<ILicenseManager> sref = bc.getServiceReference(ILicenseManager.class);
        try {
            if (sref != null) {
                manager = bc.getService(sref);
            }
            if (manager == null) {
                Policy.logError("Licensemanager not available");
                throw new Error("Licensemanager not available");
            }
            return manager;
        } finally {
            if (sref != null) {
                bc.ungetService(sref);
            }
        }
    }

}
