package de.wisag.automation.micas.compiler.mic.ui.handlers;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.compiler.mic.ui.internal.Policy;

/**
 * Migrate an
 *
 * @author krauter
 */
public class MicMigrate extends AbstractHandler implements IHandler {
    private static final String MIC_EXTENSION = "MIC";
    private static final String MIC_DEFAULT_ENCODING = "CP850";

    private boolean backupEnabled = false;

    /**
     * the command has been executed, so extract extract the needed information
     * from the application context.
     */
    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {

        ISelection selection = HandlerUtil.getCurrentSelectionChecked(event);
        IResource[] files = null;

        if (SelectionUtils.isMulti(selection)) {
            files = SelectionUtils.multiSelection(IResource.class, selection);
        } else {
            files = new IResource[] { SelectionUtils.singleSelection(IResource.class, selection) };
        }
        for (final IResource resource : files) {
            WorkspaceJob cJob = new WorkspaceJob("Converting " + resource.getName() + " to proper encoding") {
                @Override
                public IStatus runInWorkspace(final IProgressMonitor monitor) throws CoreException {
                    resource.getProject().refreshLocal(IResource.DEPTH_INFINITE, monitor);
                    final List<IFile> filesToConvert = new ArrayList<>();
                    resource.accept(new IResourceVisitor() {
                        @Override
                        public boolean visit(IResource resource) throws CoreException {
                            if (resource.getType() == IResource.FILE) {
                                IFile micFile = (IFile) resource;
                                if (!MIC_EXTENSION.equals(micFile.getFileExtension())) {
                                    return false;
                                }
                                filesToConvert.add(micFile);
                                return false;
                            }
                            return true;
                        }

                    });
                    monitor.beginTask("Doing conversion ", filesToConvert.size());
                    for (IFile file : filesToConvert) {
                        monitor.subTask("Converting " + file.getFullPath().toPortableString());
                        convertToRightEncoding(file, monitor);
                        monitor.worked(1);
                    }
                    return Status.OK_STATUS;
                }
            };
            // cJob.setRule(resource.getProject());
            cJob.schedule();
        }
        return null;
    }

    private void convertToRightEncoding(IFile workspaceMicFile, IProgressMonitor monitor) throws CoreException {
        try {

            if (isBackupEnabled()) {
                makeBackup(workspaceMicFile, monitor);
            }

            IWorkspaceRoot wsRoot = workspaceMicFile.getWorkspace().getRoot();
            workspaceMicFile.setCharset(workspaceMicFile.getCharset(), monitor);

            String fileExtension = workspaceMicFile.getFileExtension();
            String lowerFileExtension = fileExtension != null ? fileExtension.toLowerCase() : "mic";
            IPath correctedPath = workspaceMicFile.getFullPath().removeFileExtension()
                    .addFileExtension(lowerFileExtension);
            ByteArrayOutputStream convertedData = new ByteArrayOutputStream();

            OutputStreamWriter ow = new OutputStreamWriter(convertedData);
            InputStreamReader input = new InputStreamReader(workspaceMicFile.getContents(), MIC_DEFAULT_ENCODING);
            IOUtils.copy(input, ow);
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(ow);

            if (MIC_EXTENSION.equals(fileExtension)) {
                workspaceMicFile.delete(true, monitor);
                IFile newFile = wsRoot.getFile(correctedPath);
                if (newFile.exists()) {
                    newFile.setContents(new ByteArrayInputStream(convertedData.toByteArray()), true, true, monitor);
                } else {
                    newFile.create(new ByteArrayInputStream(convertedData.toByteArray()), true, monitor);
                }
            } else {
                workspaceMicFile.setContents(new ByteArrayInputStream(convertedData.toByteArray()), true, true,
                        monitor);
            }

        } catch (IOException e) {
            Policy.logError(e);
            throw new CoreException(Policy.errorStatus(e));
        } catch (CoreException e) {
            Policy.logError(e);
            throw e;
        }
    }

    public static void makeBackup(IFile workspaceMicFile, IProgressMonitor monitor) throws CoreException {
        IWorkspaceRoot wsRoot = workspaceMicFile.getWorkspace().getRoot();
        IPath backupPath = workspaceMicFile.getFullPath().removeFileExtension().addFileExtension("bak");
        if (wsRoot.exists(backupPath)) {
            wsRoot.getFile(backupPath).delete(true, null);
        }
        workspaceMicFile.copy(backupPath, true, monitor);
    }

    public boolean isBackupEnabled() {
        return backupEnabled;
    }

    public void setBackupEnabled(boolean backupEnabled) {
        this.backupEnabled = backupEnabled;
    }
}
