
package de.wisag.automation.micas.workbench.ide.splash;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.internal.splash.EclipseSplashHandler;

import de.wisag.automation.micas.common.licensing.LicenseManagerAccess;

/**
 * @since 3.3
 */
@SuppressWarnings("restriction")
public class LicenseCheckingSplashHandler extends EclipseSplashHandler {
    private static final int WARN_DAYS_BEFORE_EXPIRY = 30;
    private static final int LIC_NOT_AVAILABLE = -1;

    @Override
    public void init(Shell splash) {
        super.init(splash);
        long expiresInDays = LicenseManagerAccess.getLicenseManager().expiresInDays();
        if (expiresInDays < WARN_DAYS_BEFORE_EXPIRY && expiresInDays > 0) {
            MessageDialog.openWarning(splash, "Micas Workbench Licensing Information",
                    String.format("Attention! Your license will expire in %d day%s !\nPlease request a new license!",
                            expiresInDays, expiresInDays == 1 ? "" : "s"));
        } else if (expiresInDays == LIC_NOT_AVAILABLE) {
            MessageDialog.openWarning(splash, "Micas Workbench Licensing Information",
                    String.format("Attention! No valid license available. Please request a new one!"
                            + "\n\nApplication continues in demo mode" + "\n\nSome features will not be available"
                            + ""));
        }
    }
}
