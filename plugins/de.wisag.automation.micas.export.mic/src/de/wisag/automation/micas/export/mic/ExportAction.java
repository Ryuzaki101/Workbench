package de.wisag.automation.micas.export.mic;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.wisag.automation.micas.export.mic.internal.DiagramModuleCompiler;

public class ExportAction implements IObjectActionDelegate {

    private Shell shell;
    private IFile moduleFile;

    @Override
    public void setActivePart(IAction action, IWorkbenchPart targetPart) {
        this.shell = targetPart.getSite().getShell();
    }

    @Override
    public void run(IAction action) {
        DiagramModuleCompiler compiler = new DiagramModuleCompiler(moduleFile);
        try {
            compiler.compile();
        } catch (CoreException e) {
            MessageBox msgBox = new MessageBox(shell, SWT.ICON_ERROR);
            msgBox.setText("Fehler beim Laden der Resource");
            msgBox.setMessage(e.getStatus().getMessage());
            return;
        }

        // ModuleCompiler.compileModule(amoduleFile);
    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        if (selection != null && !selection.isEmpty() && selection instanceof IStructuredSelection) {
            moduleFile = (IFile) ((IStructuredSelection) selection).getFirstElement();
        }
    }
}
