package de.wisag.automation.micas.common.ui;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.licensing.LicenseManagerAccess;

public class DemoUtils {

    public static void checkDemoMode(ExecutionEvent event) throws ExecutionException {
        if (LicenseManagerAccess.getLicenseManager().isDemoMode()) {
            MessageDialog.openWarning(HandlerUtil.getActiveShell(event), "Demo Mode",
                    "Operation not available in DEMO-MODE");
            throw new ExecutionException("Not available in demo mode");
        }
    }

}
