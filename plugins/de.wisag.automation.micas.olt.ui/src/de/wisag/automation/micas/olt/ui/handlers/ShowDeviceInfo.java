package de.wisag.automation.micas.olt.ui.handlers;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.ui.internal.Activator;
import de.wisag.automation.micas.olt.ui.internal.dialogs.ShowTextDialog;
import de.wisag.automation.micas.olt.ui.internal.views.DeviceTreeNode;

public class ShowDeviceInfo extends AbstractDeviceHandler {
    static class UpdateDeviceInfo implements IRunnableWithProgress {
        private final IMicasDeviceManager deviceManager;
        private DeviceInfo deviceInfo;

        public UpdateDeviceInfo(IMicasDeviceManager deviceManager, DeviceInfo deviceInfo) {
            this.deviceManager = deviceManager;
            this.deviceInfo = deviceInfo;
        }

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            monitor.beginTask("Analyze device", IProgressMonitor.UNKNOWN);
            IStatus status = deviceManager.completeDeviceInfo(monitor, deviceInfo);
            if (!status.isOK()) {
                throw new InvocationTargetException(status.getException());
            }
        }

    }

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
        if (selection == null || selection.isEmpty()) {
            throw new ExecutionException("Selection is empty");
        }
        final DeviceTreeNode node = (DeviceTreeNode) selection.getFirstElement();

        final Shell shell = HandlerUtil.getActiveShellChecked(event);
        final DeviceInfo deviceInfo = node.getDeviceInfo();
        IStatus status = Status.OK_STATUS;
        if (StringUtils.isEmpty(deviceInfo.getModuleName())) {
            UpdateDeviceInfo updateInfo = new UpdateDeviceInfo(getDeviceManager(node), deviceInfo);
            ProgressMonitorDialog pmd = new ProgressMonitorDialog(shell);
            try {
                pmd.run(true, true, updateInfo);
            } catch (InvocationTargetException e) {
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getCause().getMessage(), e.getCause());
            } catch (InterruptedException e) {
            } finally {
                if (pmd != null) {
                    pmd.close();
                }
            }
        }
        if (status != null && status.isOK()) {
            TreeViewer viewer = (TreeViewer) node.getAdapter(TreeViewer.class);
            if (viewer != null) {
                viewer.update(node, null);
            }
            ShowTextDialog.open(shell, String.format("Info about %s", deviceInfo.getModuleName()),
                    deviceInfo.getRawText());
        }

        return null;
    }

}
