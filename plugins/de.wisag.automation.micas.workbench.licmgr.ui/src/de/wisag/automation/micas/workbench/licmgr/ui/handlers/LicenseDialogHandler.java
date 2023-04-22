package de.wisag.automation.micas.workbench.licmgr.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.licensing.LicenseManagerAccess;
import de.wisag.automation.micas.workbench.licmgr.ui.internal.ShowLicenseDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 *
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class LicenseDialogHandler extends AbstractHandler {
    /**
     * The constructor.
     */
    public LicenseDialogHandler() {
    }

    /**
     * the command has been executed, so extract extract the needed information
     * from the application context.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
        ShowLicenseDialog dlg = new ShowLicenseDialog(window.getShell());
        dlg.setLicenseManager(LicenseManagerAccess.getLicenseManager());
        dlg.setBlockOnOpen(true);
        dlg.open();
        return null;
    }
}
