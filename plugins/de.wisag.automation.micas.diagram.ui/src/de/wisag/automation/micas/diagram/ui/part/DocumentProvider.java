package de.wisag.automation.micas.diagram.ui.part;

import java.io.IOException;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.ResourceSetChangeEvent;
import org.eclipse.emf.transaction.ResourceSetListener;
import org.eclipse.emf.transaction.ResourceSetListenerImpl;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.AbstractDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.DiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocument;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDiagramDocumentProvider;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.document.IDocument;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.ui.IEditorInput;

public class DocumentProvider extends AbstractDocumentProvider implements IDiagramDocumentProvider {

    @Override
    public IDiagramDocument getDiagramDocument(Object element) {
        IDocument doc = getDocument(element);
        if (doc instanceof IDiagramDocument) {
            return (IDiagramDocument) doc;
        }
        return null;
    }

    @Override
    protected IDocument createDocument(Object element) throws CoreException {
        if (element instanceof IDiagramEditorInput) {
            IDocument document = createEmptyDocument();
            if (setDocumentContent(document, (IEditorInput) element)) {
                setupDocument(element, document);
                return document;
            }
        }
        return null;
    }

    @Override
    protected IDocument createEmptyDocument() {
        return new DiagramDocument();
    }

    protected boolean setDocumentContent(IDocument document, IEditorInput editorInput) throws CoreException {
        if (editorInput instanceof IDiagramEditorInput) {
            Diagram diagram = ((IDiagramEditorInput) editorInput).getDiagram();
            document.setContent(diagram);
            return true;
        }
        return false;
    }

    protected void setupDocument(Object element, IDocument document) {
        // for subclasses
    }

    @Override
    protected void doSaveDocument(IProgressMonitor monitor, Object element, IDocument document, boolean overwrite)
            throws CoreException {
        if (element instanceof IDiagramEditorInput) {
            IDiagramEditorInput editorInput = (IDiagramEditorInput) element;
            try {
                Resource r = editorInput.getDiagram().eResource();
                if (r != null) {
                    r.save(null);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    protected IRunnableContext getOperationRunner(IProgressMonitor monitor) {
        return null;
    }

    @Override
    public IStatus getStatus(Object element) {
        return super.getStatus(element);
    }

    @Override
    public boolean isModifiable(Object element) {
        // if (isStateValidated(element)) {
        // return true;
        // }
        return true;
    }

    @Override
    public boolean isReadOnly(Object element) {
        return false;
    }

    @Override
    public IEditorInput createInputWithEditingDomain(IEditorInput editorInput, TransactionalEditingDomain domain) {
        // TODO Auto-generated method stub
        return null;
    }

    private class MyElementInfo extends ElementInfo {

        public ResourceSetListener rsl;

        public MyElementInfo(IDocument document) {
            super(document);
        }

    }

    @Override
    protected ElementInfo createElementInfo(Object element) throws CoreException {
        if (element instanceof IDiagramEditorInput) {
            IDiagramEditorInput editorInput = (IDiagramEditorInput) element;
            IDocument document = null;
            // IStatus status= null;

            document = createDocument(element);

            MyElementInfo info = new MyElementInfo(document);
            // document.addDocumentListener(info);

            TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(editorInput.getDiagram());
            if (editingDomain != null) {
                if (!editorInput.getDiagram().eResource().isTrackingModification()) {
                    editorInput.getDiagram().eResource().setTrackingModification(true);
                }
                info.rsl = new DiagramResourceSetListener(editorInput);
                editingDomain.addResourceSetListener(info.rsl);
            }

            return info;
        }

        return super.createElementInfo(element);
    }

    @Override
    protected void disposeElementInfo(Object element, ElementInfo info) {
        if (element instanceof IDiagramEditorInput && info instanceof MyElementInfo) {
            MyElementInfo elementInfo = (MyElementInfo) info;
            IDiagramEditorInput editorInput = (IDiagramEditorInput) element;
            if (elementInfo.rsl != null) {
                TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(editorInput.getDiagram());
                if (editingDomain != null) {
                    editingDomain.removeResourceSetListener(elementInfo.rsl);
                    elementInfo.rsl = null;
                }
            }
        }
        super.disposeElementInfo(element, info);
    }

    private class DiagramResourceSetListener extends ResourceSetListenerImpl {

        private IDiagramEditorInput element;

        public DiagramResourceSetListener(IDiagramEditorInput element) {
            this.element = element;
        }

        @Override
        public void resourceSetChanged(ResourceSetChangeEvent event) {
            Resource r = element.getDiagram().eResource();
            if (r != null) {
                if (r.isModified()) {
                    setCanSaveDocument(element);
                }
            }
        }

    }

}
