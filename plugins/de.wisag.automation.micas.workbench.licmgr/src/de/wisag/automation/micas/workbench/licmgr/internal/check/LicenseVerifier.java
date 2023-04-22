package de.wisag.automation.micas.workbench.licmgr.internal.check;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.common.licensing.LicenseStatus;
import de.wisag.automation.micas.workbench.licmgr.hwid.HwKeyGen;
import de.wisag.automation.micas.workbench.licmgr.internal.Activator;

/**
 * Checks the license against : Hardware ID
 * <p>
 * Expiration date
 * <p>
 * TODO :Product version
 * <p>
 * TODO Product name
 * <p>
 */
public class LicenseVerifier {

    public IStatus verifyLicense(LicenseInfo info) {
        IStatus result = Status.OK_STATUS;
        String hwId = HwKeyGen.getHardwareId();
        long now = System.currentTimeMillis();
        if (info.getValidUntil().before(new Date(now))) {
            // license expired ?
            info.setLicenseStatus(LicenseStatus.EXPIRED);
            info.setInfo("License expired");
            result = new Status(IStatus.WARNING, Activator.PLUGIN_ID,
                    "License expired since : " + DateFormatUtils.ISO_DATE_FORMAT.format(info.getValidUntil()));
        } else if (!StringUtils.equalsIgnoreCase(hwId, info.getHwId())) {
            // Hardware key mismatch ?
            info.setLicenseStatus(LicenseStatus.INVALID);
            String msg = String.format(
                    "License not bound on this hardware : Current HardwareId : '%s' , Expected HardwareId : '%s", hwId,
                    info.getHwId());
            info.setInfo(msg);
            result = new Status(IStatus.WARNING, Activator.PLUGIN_ID, msg);
        } else {
            info.setLicenseStatus(LicenseStatus.VALID);
            info.setInfo("");
        }
        return result;
    }
}
