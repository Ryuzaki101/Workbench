package de.wisag.automation.micas.diagram.ui.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.TransactionalEditingDomain.Factory;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.ui.actions.ActionIds;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramGraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.diagram.ui.requests.ArrangeRequest;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipselabs.damos.diagram.ui.DiagramUIPlugin;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.FragmentElement;

import de.wisag.automation.micas.diagram.ui.commands.CreateEdgesCommand;
import de.wisag.automation.micas.diagram.ui.part.DiagramEditor;
import de.wisag.automation.micas.diagram.ui.part.DiagramEditorInput;
import de.wisag.automation.micas.module.Constant;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.OffpageConnector;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Reference;
import de.wisag.automation.micas.module.Task;

public class EditorUtil {

    public static IEditorPart openPageEditor(Page page) {
        EditingDomain editingDomain = TransactionUtil.getEditingDomain(page);
        if (editingDomain == null) {
            editingDomain = Factory.INSTANCE.createEditingDomain(page.eResource().getResourceSet());
        }

        Diagram diagram = findDiagramForPage(page);
        if (diagram == null) {
            List<Node> nodes = new ArrayList<>();
            diagram = ViewService.createDiagram(page, "", DiagramUIPlugin.DIAGRAM_PREFERENCES_HINT);
            for (FragmentElement frag : page.getFragmentElements()) {
                if (frag instanceof Block || frag instanceof Constant || frag instanceof Reference
                        || frag instanceof OffpageConnector) {
                    nodes.add(ViewService.createNode(diagram, frag, "", DiagramUIPlugin.DIAGRAM_PREFERENCES_HINT));
                }
            }

            diagram.setName(page.getName());
            Command command = new AddDiagramCommand(page.eResource(), diagram);
            editingDomain.getCommandStack().execute(command);

            IEditorPart part = openDiagramEditor(diagram);
            if (part instanceof DiagramEditor) {
                DiagramEditPart ep = ((DiagramEditor) part).getDiagramEditPart();
                ICommandProxy cmd = new ICommandProxy(
                        new CreateEdgesCommand(ep, getConnections(page), ((DiagramEditor) part).getEditingDomain()));
                ArrangeRequest arrangeRequest = new ArrangeRequest(ActionIds.ACTION_ARRANGE_ALL);
                arrangeRequest.setPartsToArrange(ep.getChildren());
                ep.getDiagramEditDomain().getDiagramCommandStack().execute(cmd.chain(ep.getCommand(arrangeRequest)));
            }
            return part;
        }
        return openDiagramEditor(diagram);

    }

    public static void removeDiagram(Page page) {
        Diagram diagram = findDiagramForPage(page);
        if (diagram != null) {
            EditingDomain editingDomain = TransactionUtil.getEditingDomain(page);
            if (editingDomain == null) {
                editingDomain = Factory.INSTANCE.createEditingDomain(page.eResource().getResourceSet());
            }
            Command command = new RemoveDiagramCommand(page.eResource(), diagram);
            editingDomain.getCommandStack().execute(command);
        }
    }

    private static List<Connection> getConnections(Page page) {
        List<Connection> connections = new ArrayList<>();
        for (FragmentElement frag : page.getFragmentElements()) {
            if (frag instanceof Connection) {
                connections.add((Connection) frag);
            }
        }
        return connections;
    }

    public static List<Diagram> getAllDiagramsInModule(Module module) {
        List<Diagram> diagrams = new ArrayList<>();
        for (Task task : module.getTasks()) {
            for (Page page : task.getPages()) {
                Diagram diag = findDiagramForPage(page);
                if (diag != null) {
                    diagrams.add(diag);
                }
            }
        }
        return diagrams;
    }

    public static Diagram findDiagramForPage(Page page) {
        Resource r = page.eResource();
        for (EObject o : r.getContents()) {
            if (o instanceof Diagram) {
                Diagram diagram = (Diagram) o;
                if (diagram.getElement() == page) {
                    return diagram;
                }
            }
        }
        return null;
    }

    public static void applyPreference(IPreferenceStore store, String key, String value) {
        if (!store.contains(key)) {
            store.setDefault(key, value);
        } else {
            store.setValue(key, value);
        }
    }

    public static void applyPreference(IPreferenceStore store, String key, boolean value) {
        if (!store.contains(key)) {
            store.setDefault(key, value);
        } else {
            store.setValue(key, value);
        }
    }

    public static IEditorPart openDiagramEditor(Diagram diagram) {
        try {
            IWorkbenchWindow w = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
            IWorkbenchPage wp = w.getActivePage();
            if (wp != null) {
                return IDE.openEditor(wp, new DiagramEditorInput(diagram), DiagramEditor.EDITOR_ID);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class RemoveDiagramCommand extends ChangeCommand {

        private Resource resource;
        private Diagram diagram;

        public RemoveDiagramCommand(Resource resource, Diagram diagram) {
            super(resource);
            this.resource = resource;
            this.diagram = diagram;
        }

        @Override
        protected void doExecute() {
            resource.getContents().remove(diagram);
        }

    }

    private static class AddDiagramCommand extends ChangeCommand {

        private Resource resource;
        private Diagram diagram;

        public AddDiagramCommand(Resource resource, Diagram diagram) {
            super(resource);
            this.resource = resource;
            this.diagram = diagram;
        }

        @Override
        protected void doExecute() {
            resource.getContents().add(diagram);
        }

    }

    public static void selectElementsInDiagram(IDiagramWorkbenchPart diagramPart, List<EditPart> editParts) {
        diagramPart.getDiagramGraphicalViewer().deselectAll();

        EditPart firstPrimary = null;
        for (EditPart nextPart : editParts) {
            diagramPart.getDiagramGraphicalViewer().appendSelection(nextPart);
            if (firstPrimary == null && nextPart instanceof IPrimaryEditPart) {
                firstPrimary = nextPart;
            }
        }

        if (!editParts.isEmpty()) {
            diagramPart.getDiagramGraphicalViewer()
                    .reveal(firstPrimary != null ? firstPrimary : (EditPart) editParts.get(0));
        }
    }

    public static View findView(DiagramEditPart diagramEditPart, EObject targetElement,
            LazyElement2ViewMap lazyElement2ViewMap) {
        boolean hasStructuralURI = false;
        if (targetElement.eResource() instanceof XMLResource) {
            hasStructuralURI = ((XMLResource) targetElement.eResource()).getID(targetElement) == null;
        }

        View view = null;
        LinkedList<EditPart> editPartHolder = new LinkedList<>();
        if (hasStructuralURI && !lazyElement2ViewMap.getElement2ViewMap().isEmpty()) {
            view = lazyElement2ViewMap.getElement2ViewMap().get(targetElement);
        } else if (findElementsInDiagramByID(diagramEditPart, targetElement, editPartHolder) > 0) {
            EditPart editPart = editPartHolder.get(0);
            view = editPart.getModel() instanceof View ? (View) editPart.getModel() : null;
        }

        return (view == null) ? diagramEditPart.getDiagramView() : view;
    }

    private static int findElementsInDiagramByID(DiagramEditPart diagramPart, EObject element,
            List<EditPart> editPartCollector) {
        IDiagramGraphicalViewer viewer = (IDiagramGraphicalViewer) diagramPart.getViewer();
        final int intialNumOfEditParts = editPartCollector.size();

        if (element instanceof View) { // support notation element lookup
            EditPart editPart = (EditPart) viewer.getEditPartRegistry().get(element);
            if (editPart != null) {
                editPartCollector.add(editPart);
                return 1;
            }
        }

        String elementID = EMFCoreUtil.getProxyID(element);
        @SuppressWarnings("unchecked")
        List<EditPart> associatedParts = viewer.findEditPartsForElement(elementID, IGraphicalEditPart.class);
        // perform the possible hierarchy disjoint -> take the top-most parts
        // only
        for (EditPart nextPart : associatedParts) {
            EditPart parentPart = nextPart.getParent();
            while (parentPart != null && !associatedParts.contains(parentPart)) {
                parentPart = parentPart.getParent();
            }
            if (parentPart == null) {
                editPartCollector.add(nextPart);
            }
        }

        if (intialNumOfEditParts == editPartCollector.size()) {
            if (!associatedParts.isEmpty()) {
                editPartCollector.add(associatedParts.get(0));
            } else {
                if (element.eContainer() != null) {
                    return findElementsInDiagramByID(diagramPart, element.eContainer(), editPartCollector);
                }
            }
        }
        return editPartCollector.size() - intialNumOfEditParts;
    }

    /**
     * XXX This is quite suspicious code (especially editPartTmpHolder) and
     * likely to be removed soon
     */
    public static class LazyElement2ViewMap {
        /**
         * @generated
         */
        private Map<EObject, View> element2ViewMap;

        /**
         * @generated
         */
        private View scope;

        /**
         * @generated
         */
        private Set<? extends EObject> elementSet;

        /**
         * @generated
         */
        public LazyElement2ViewMap(View scope, Set<? extends EObject> elements) {
            this.scope = scope;
            this.elementSet = elements;
        }

        /**
         * @generated
         */
        public final Map<EObject, View> getElement2ViewMap() {
            if (element2ViewMap == null) {
                element2ViewMap = new HashMap<>();
                // map possible notation elements to itself as these can't be
                // found by view.getElement()
                for (EObject element : elementSet) {
                    if (element instanceof View) {
                        View view = (View) element;
                        if (view.getDiagram() == scope.getDiagram()) {
                            element2ViewMap.put(element, view); // take only
                                                                // those that
                                                                // part of our
                                                                // diagram
                        }
                    }
                }

                buildElement2ViewMap(scope, element2ViewMap, elementSet);
            }
            return element2ViewMap;
        }

        /**
         * @generated
         */
        private static boolean buildElement2ViewMap(View parentView, Map<EObject, View> element2ViewMap,
                Set<? extends EObject> elements) {
            if (elements.size() == element2ViewMap.size()) {
                return true;
            }

            if (parentView.isSetElement() && !element2ViewMap.containsKey(parentView.getElement())
                    && elements.contains(parentView.getElement())) {
                element2ViewMap.put(parentView.getElement(), parentView);
                if (elements.size() == element2ViewMap.size()) {
                    return true;
                }
            }
            boolean complete = false;
            for (Iterator<?> it = parentView.getChildren().iterator(); it.hasNext() && !complete;) {
                complete = buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
            }
            for (Iterator<?> it = parentView.getSourceEdges().iterator(); it.hasNext() && !complete;) {
                complete = buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
            }
            for (Iterator<?> it = parentView.getTargetEdges().iterator(); it.hasNext() && !complete;) {
                complete = buildElement2ViewMap((View) it.next(), element2ViewMap, elements);
            }
            return complete;
        }
    } // LazyElement2ViewMap

}
