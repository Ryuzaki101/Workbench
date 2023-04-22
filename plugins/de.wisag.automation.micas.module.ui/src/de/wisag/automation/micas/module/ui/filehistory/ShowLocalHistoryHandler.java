package de.wisag.automation.micas.module.ui.filehistory;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFileState;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.team.ui.TeamUI;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.module.ui.internal.Activator;

public class ShowLocalHistoryHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        final Shell shell = HandlerUtil.getActiveShellChecked(event);
        final IWorkbenchPage page = HandlerUtil.getActivePartChecked(event).getSite().getPage();
        final IStructuredSelection fSelection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
        IFileState states[] = getLocalHistory(shell, fSelection);
        if (states == null || states.length == 0) {
            return null;
        }
        try {
            PlatformUI.getWorkbench().getProgressService().busyCursorWhile(new IRunnableWithProgress() {
                @Override
                public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
                    final IResource resource = (IResource) fSelection.getFirstElement();
                    Runnable r = new Runnable() {
                        @Override
                        public void run() {
                            TeamUI.showHistoryFor(page, resource, null);
                        }
                    };
                    shell.getDisplay().asyncExec(r);
                }
            });
        } catch (InvocationTargetException exception) {
            ErrorDialog.openError(shell, null, null, new Status(IStatus.ERROR, Activator.PLUGIN_ID, IStatus.ERROR,
                    "Problem showing Local History", exception.getTargetException()));
        } catch (InterruptedException exception) {
        }
        return null;
    }

    protected IFileState[] getLocalHistory(Shell shell, IStructuredSelection selection) {
        final IFile file = (IFile) selection.getFirstElement();
        IFileState states[];
        try {
            states = file.getHistory(null);
        } catch (CoreException ex) {
            MessageDialog.openError(shell, "Local history failed", ex.getMessage());
            return null;
        }

        if (states == null || states.length <= 0) {
            MessageDialog.openInformation(shell, "Local history", "No local history available for selected resource.");
            return states;
        }
        return states;
    }
}
