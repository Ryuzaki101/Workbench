package de.wisag.automation.micas.olt.ui.handlers;

import java.io.ByteArrayInputStream;

import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.SaveAsDialog;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.common.ui.DemoUtils;
import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.MicasDeviceManagerException;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.ui.internal.Policy;
import de.wisag.automation.micas.olt.ui.internal.views.DeviceTreeNode;
import de.wisag.automation.micas.rt.Decompiler;

public class DownloadMicFileHandler extends AbstractDeviceHandler {

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
        SaveAsDialog dlg = new SaveAsDialog(shell) {
            @Override
            protected Control createDialogArea(Composite parent) {
                Control area = super.createDialogArea(parent);
                setMessage("Provide a suitable h86 Filename", IMessageProvider.INFORMATION);
                return area;
            }
        };
        DeviceInfo di = node.getDeviceInfo();

        dlg.setOriginalName(String.format("%s%02d." + HardcodedValues.FILE_EXT_H86, di.getModuleName(),
                node.getDeviceInfo().getFieldBus()));
        if (IDialogConstants.OK_ID != dlg.open()) {
            return null;
        }
        IPath path = dlg.getResult();
        if (path == null) {
            return null;
        }
        IFile ifile = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
        if (ifile == null) {
            return null;
        }
        String currentH86Program = null;
        try {
            currentH86Program = mgr.fetchCurrentMicasProgram(new NullProgressMonitor(), node.getDeviceInfo());

        } catch (MicasDeviceManagerException e) {
            Policy.logError(e);
            MessageDialog.openError(shell, "Download of h86 file failed", e.getMessage());
            throw new ExecutionException(e.getMessage(), e);
        } catch (Exception e) {
            IStatus status = Policy.errorStatus(e);
            Policy.log(status);
            ErrorDialog.openError(shell, "Error downloading h86", e.getMessage(), status);
            return null;
        }
        if (currentH86Program != null) {
            ResourceUtils.createOrUpdateFile(new NullProgressMonitor(), ifile, currentH86Program,
                    HardcodedValues.MIC_DEFAULT_ENCODING_CP850);
        } else {
            MessageDialog.openError(shell, "Error Loading Program", "Download of h86 file failed");
            return null;
        }
        Decompiler decompiler = new Decompiler();
        decompiler.setHardwareAlias(di.getHardwareAlias());
        decompiler.setFieldBusNumber(di.getFieldBus());
        try {
            String micData = decompiler.decompile(
                    new ByteArrayInputStream(currentH86Program.getBytes(HardcodedValues.MIC_DEFAULT_ENCODING_CP850)));
            ResourceUtils.updateAndTagGeneratedFile(new NullProgressMonitor(), ifile, micData,
                    HardcodedValues.MIC_SUFFIX, false);
        } catch (Exception e) {
            Policy.logError(e);
        }
        MessageDialog.openInformation(shell, "Download sucessful",
                String.format("h86 file saved to %s", ifile.getProjectRelativePath().toPortableString()));
        return null;
    }
}
