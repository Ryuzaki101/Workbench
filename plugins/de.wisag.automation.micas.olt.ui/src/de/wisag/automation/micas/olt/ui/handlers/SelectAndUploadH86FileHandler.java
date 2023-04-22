package de.wisag.automation.micas.olt.ui.handlers;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.ui.DemoUtils;
import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.ui.internal.views.DeviceTreeNode;

public class SelectAndUploadH86FileHandler extends AbstractDeviceHandler {
    /**
     * the command has been executed, so extract extract the needed information
     * from the application context.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        DemoUtils.checkDemoMode(event);
        Shell shell = HandlerUtil.getActiveShellChecked(event);
        DeviceTreeNode node = getDeviceTreeNode(event);
        IMicasDeviceManager mgr = getDeviceManager(node);
        FilteredResourcesSelectionDialog dlg = new FilteredResourcesSelectionDialog(shell, false,
                ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
        dlg.setInitialPattern("*.h86");
        if (IDialogConstants.OK_ID != dlg.open()) {
            return null;
        }
        IFile file = (IFile) dlg.getFirstResult();
        if (file == null) {
            return null;
        }
        H86Uploader.h86Upload(new NullProgressMonitor(), file, mgr, node.getDeviceInfo().getFieldBus());
        return null;
    }
}