package de.wisag.automation.micas.importer.mic.ui.internal.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.SafeRunner;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.importer.mic.ui.internal.Activator;

abstract class ModuleImportImportHandler extends AbstractHandler {
    class StatusHolder {
        private IStatus status;

        public IStatus getStatus() {
            return status;
        }

        public void setStatus(IStatus status) {
            this.status = status;
        }
    }

    abstract IStatus runImport(IProgressMonitor monitor, IFile sourceFile, IFile targetFile);

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

        ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
        final Shell shell = HandlerUtil.getActiveShellChecked(event);
        final IFile file = (IFile) ((IStructuredSelection) selection).getFirstElement();
        int i = 0;
        IFile targetFile = null;
        while ((targetFile = createDerivedFileName(file, i++)).exists()) {
        }
        final IFile targetFile2 = targetFile;
        final Display display = shell.getDisplay();
        WorkspaceModifyOperation operation = new WorkspaceModifyOperation() {
            @Override
            public void execute(final IProgressMonitor monitor) {
                final StatusHolder statusHolder = new StatusHolder();
                statusHolder.setStatus(Status.OK_STATUS);

                SafeRunner.run(new ISafeRunnable() {

                    @Override
                    public void run() throws Exception {
                        statusHolder.setStatus(runImport(monitor, file, targetFile2));
                    }

                    @Override
                    public void handleException(Throwable t) {
                        statusHolder.setStatus(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Import failes", t));
                    }
                });

                if (!statusHolder.getStatus().isOK()) {
                    display.syncExec(new Runnable() {

                        @Override
                        public void run() {
                            ErrorDialog.openError(shell, String.format("Import of '%s' failed ", file.getName()), "",
                                    statusHolder.getStatus());

                        }
                    });

                }
            }
        };

        try {
            // This runs the options, and shows progress.
            //
            new ProgressMonitorDialog(shell).run(true, false, operation);

            // Refresh the necessary state.
            //
        } catch (Exception e) {
            e.printStackTrace();
            //
            Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
        }

        return null;
    }

    private IFile createDerivedFileName(final IFile file, int i) {
        IPath baseName = file.getProjectRelativePath().removeFileExtension();
        return file.getProject().getFile(baseName.removeLastSegments(1).append(
                new Path(String.format("%s-import-%02x", baseName.lastSegment(), i)).addFileExtension("module")));
    }
}
