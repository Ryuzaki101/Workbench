package de.wisag.automation.micas.compiler.mic.ui.handlers;

import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.resource.ResourceUtils;

public class MicCleaner extends AbstractHandler implements IHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IContainer parent = (IContainer) ((IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event))
                .getFirstElement();
        final List<IFile> filestodelete = ResourceUtils.getFilesToClean(parent);
        WorkspaceJob deleteJob = new WorkspaceJob("Delete generated Artefacts") {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                ResourceUtils.deleteAll(monitor, filestodelete);
                return Status.OK_STATUS;
            }
        };
        deleteJob.schedule();
        return null;
    }

}
