package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;

public class PasteFromStringDataCommand extends RecordingCommand {
    private final Task task;
    private final String diagramData;
    private final String name;

    public PasteFromStringDataCommand(TransactionalEditingDomain editingDomain, Task task, String diagramData,
            String name) {
        super(editingDomain);
        this.task = task;
        this.diagramData = diagramData;
        this.name = name;
    }

    @Override
    protected void doExecute() {
        EList<EObject> contents = EmfXmlConverter.convertToEObject2(diagramData);
        Diagram diagram = null;
        Page page = null;
        for (EObject eObject : contents) {
            if (eObject instanceof Diagram) {
                diagram = (Diagram) eObject;
            }
            if (eObject instanceof Page) {
                page = (Page) eObject;
            }
        }
        if (diagram == null) {
            return;
        }
        if (page == null) {
            return;
        }
        task.getPages().add(page);
        task.eResource().getContents().add(diagram);
        page.setName(name);
        diagram.setElement(page);
        diagram.setName(name);
        // post process inserted objects
        PastingHelper.performPostPasteProcessing(page);
    }

}
