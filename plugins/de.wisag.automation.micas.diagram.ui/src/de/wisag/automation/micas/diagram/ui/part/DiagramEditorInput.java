package de.wisag.automation.micas.diagram.ui.part;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.MEditingDomainElement;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;

public class DiagramEditorInput extends org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput
        implements MEditingDomainElement {

    public DiagramEditorInput(Diagram diagram) {
        super(diagram);
    }

    @Override
    public TransactionalEditingDomain getEditingDomain() {
        return TransactionUtil.getEditingDomain(getDiagram());
    }

    @Override
    public String getName() {
        Page page = (Page) getDiagram().getElement();
        Task task = page.getTask();

        return String.format("Task : %s Diagramm : %s", task.getName(), page.getName());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Object getAdapter(Class adapter) {
        if (Page.class.equals(adapter)) {
            return getDiagram().getElement();
        }
        if (Module.class.equals(adapter)) {
            Page page = (Page) getDiagram().getElement();
            return page.getTask().getModule();
        }
        if (Task.class.equals(adapter)) {
            Page page = (Page) getDiagram().getElement();
            Task task = page.getTask();
            return task;
        }
        return super.getAdapter(adapter);
    }
}
