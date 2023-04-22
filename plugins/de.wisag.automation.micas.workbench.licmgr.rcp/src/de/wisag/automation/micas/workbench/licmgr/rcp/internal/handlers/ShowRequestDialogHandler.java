package de.wisag.automation.micas.workbench.licmgr.rcp.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.licensing.LicenseManagerAccess;
import de.wisag.automation.micas.workbench.licmgr.ui.dialogs.LicenseRequestDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ShowRequestDialogHandler extends AbstractHandler {
    /**
     * The constructor.
     */
    public ShowRequestDialogHandler() {
    }

    /**
     * the command has been executed, so extract extract the needed information
     * from the application context.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        Shell shell = HandlerUtil.getActiveShell(event);
        LicenseRequestDialog dialog = new LicenseRequestDialog(shell);
        dialog.setLicenseManager(LicenseManagerAccess.getLicenseManager());
        dialog.setBlockOnOpen(true);
        dialog.open();
        return null;
    }
}
