package de.wisag.automation.micas.compiler.mic.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.ui.SelectionUtils;

public class ProjectBuildHandler extends AbstractHandler implements IHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        IResource resource = SelectionUtils.singleSelection(IResource.class,
                HandlerUtil.getCurrentSelectionChecked(event));
        final IProject project = resource.getProject();
        WorkspaceJob workspaceJob = new WorkspaceJob("Refresh and CleanRebuild") {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                project.refreshLocal(IResource.DEPTH_INFINITE, monitor);
                project.build(IncrementalProjectBuilder.CLEAN_BUILD, monitor);
                return Status.OK_STATUS;
            }
        };
        workspaceJob.schedule();
        return null;
    }

}
