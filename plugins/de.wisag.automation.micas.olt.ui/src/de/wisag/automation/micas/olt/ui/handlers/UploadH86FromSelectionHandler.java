package de.wisag.automation.micas.olt.ui.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.common.ui.DemoUtils;
import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.ui.internal.Activator;
import de.wisag.automation.micas.olt.ui.internal.Policy;

public class UploadH86FromSelectionHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        DemoUtils.checkDemoMode(event);
        Shell shell = HandlerUtil.getActiveShellChecked(event);
        final IFile file = SelectionUtils.singleSelection(IFile.class, HandlerUtil.getCurrentSelectionChecked(event));
        try {
            new ProgressMonitorDialog(shell).run(true, false, new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    IStatus status = uploadH86(monitor, file);
                    if (!status.isOK()) {
                        throw new InvocationTargetException(new CoreException(status));
                    }

                }
            });
            MessageDialog.openInformation(shell, "Success",
                    String.format("File '%s' uploaded successfull!", file.getProjectRelativePath().toPortableString()));
        } catch (InvocationTargetException e) {
            Throwable targetException = e.getTargetException();
            if (targetException instanceof CoreException) {
                CoreException e2 = (CoreException) targetException;
                ErrorDialog.openError(shell, "Program upload failed", "", e2.getStatus());
            } else {
                targetException.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    private IStatus uploadH86(IProgressMonitor monitor, IFile file) {
        IStatus status = null;
        if (file == null) {
            status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, String.format("no file given"));
            Policy.log(status);
            return status;
        }
        IFile manifest = file.getProject().getFile(file.getProjectRelativePath().removeFileExtension()
                .addFileExtension(StringUtils.remove(HardcodedValues.MANIFEST_SUFFIX, ".")));
        int fieldBus = HardcodedValues.FIELDBUS_MASTER_DEVICE;
        HardwareTypeDefinition def = null;
        if (manifest.exists()) {
            try (InputStream contents = manifest.getContents()) {
                Manifest mf = new Manifest(contents);
                String sFiledBus = mf.getMainAttributes().getValue("Module-FieldBus");
                try {
                    fieldBus = Integer.parseInt(sFiledBus);
                } catch (NumberFormatException e) {
                    Policy.logError(e);
                }
                String stype = mf.getMainAttributes().getValue("Module-Type");
                if (stype != null) {
                    def = IHwModulesProvider.INSTANCE.findHardwareTypeDefinition(stype);
                }
            } catch (IOException e) {
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                        String.format("Read of manifest '%s' failed!", manifest), e);
                Policy.log(status);
            } catch (CoreException e) {
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                        String.format("Read of manifest '%s' failed!", manifest), e);
                Policy.log(status);
            }
        } else {
            Pattern pattern = Pattern.compile("^29([A-Z][A-Z]\\d\\d)(\\d\\d)$", Pattern.CASE_INSENSITIVE);
            String baseName = FilenameUtils.getBaseName(file.getName());
            String type = null;
            Matcher m = null;
            if ((m = pattern.matcher(baseName)).matches()) {
                type = m.group(1);
                def = IHwModulesProvider.INSTANCE.findHardwareTypeDefinition(type);
                try {
                    fieldBus = Integer.parseInt(m.group(2));
                } catch (NumberFormatException e) {
                    Policy.logError(e);
                }
            }
            if (def == null) {
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                        String.format("Could not derive hardwarename from filename '%s'", file.getName()));
                Policy.log(status);
                return status;
            }
        }
        IMicasDeviceManager manager = file.getAdapter(IMicasDeviceManager.class);
        if (manager == null) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("Could not get DeviceManager from '%s' ", file.getProjectRelativePath()));
        }
        DeviceInfo deviceToUpdate = null;
        DeviceInfo di = manager.getDeviceInfo(monitor);
        if (di.getFieldBus() == fieldBus) {
            deviceToUpdate = di;
        } else {
            EList<DeviceInfo> slaves = di.getSlaves();
            for (DeviceInfo deviceInfo : slaves) {
                if (deviceInfo.getFieldBus() == fieldBus) {
                    deviceToUpdate = deviceInfo;
                    break;
                }
            }
        }
        if (deviceToUpdate == null) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("No Device found with requested Filebusnumber %03d ", fieldBus));

        }
        HardwareTypeDefinition hwTypeDef = IHwModulesProvider.INSTANCE
                .findHardwareTypeDefinition(deviceToUpdate.getHardwareType());
        if (!ObjectUtils.equals(hwTypeDef, def)) {
            return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                    String.format("h86 is compiled for Type %s. Device with number %d is %s ", def.getType().getName(),
                            fieldBus, hwTypeDef.getType().getName()));
        }
        return H86Uploader.h86Upload(monitor, file, manager, fieldBus);
    }

}
