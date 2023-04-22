package de.wisag.automation.micas.diagram.ui.validation;

import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate2;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

import de.wisag.automation.micas.diagram.ui.part.DiagramEditor;

public class EnableLiveValidationDelegate implements IActionDelegate2, IEditorActionDelegate {

    private DiagramEditor editor;
    private Shell shell;

    @Override
    public void run(IAction action) {
        System.out.println();

    }

    @Override
    public void selectionChanged(IAction action, ISelection selection) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(IAction action) {
        // TODO Auto-generated method stub

    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub

    }

    @Override
    public void runWithEvent(IAction action, Event event) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setActiveEditor(IAction action, IEditorPart targetEditor) {
        this.editor = (DiagramEditor) targetEditor;
        if (targetEditor != null) {
            this.shell = targetEditor.getSite().getShell();
        }
    }
}
