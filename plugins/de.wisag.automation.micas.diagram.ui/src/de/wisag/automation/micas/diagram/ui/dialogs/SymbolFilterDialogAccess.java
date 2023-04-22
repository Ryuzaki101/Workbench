package de.wisag.automation.micas.diagram.ui.dialogs;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SelectionStatusDialog;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;

import de.wisag.automation.micas.common.ui.dialogs.ISymbolFilterDialogProvider;
import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.diagram.ui.Activator;
import de.wisag.automation.micas.diagram.ui.internal.Policy;
import de.wisag.automation.micas.module.Module;

public class SymbolFilterDialogAccess {

    public static Object openFilterSymbolDialog(final Module module, Shell activeShell, SymbolFilter symbolFilter) {
        ISymbolFilterDialogProvider dlgProvider = getSymbolFilterDialogProvider();
        if (dlgProvider == null) {
            Policy.logStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "SymbolFilterDialog not available"));
            return null;
        }
        SelectionStatusDialog dlg = dlgProvider.createDialog(activeShell, new Object[] { module, symbolFilter });// new
                                                                                                                 // FindSymbolDialog(activeShell,
                                                                                                                 // module,symbolFilter);
        if (IDialogConstants.OK_ID == dlg.open()) {
            return dlg.getFirstResult();
        }
        return null;
    }

    private static ISymbolFilterDialogProvider getSymbolFilterDialogProvider() {
        ISymbolFilterDialogProvider provider = null;
        BundleContext bc = FrameworkUtil.getBundle(SymbolFilterDialogAccess.class).getBundleContext();
        ServiceReference<ISymbolFilterDialogProvider> sref = bc.getServiceReference(ISymbolFilterDialogProvider.class);
        try {
            if (sref != null) {
                provider = bc.getService(sref);
            }
            return provider;
        } finally {
            if (sref != null) {
                bc.ungetService(sref);
            }
        }
    }
}
