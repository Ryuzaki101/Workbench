package de.wisag.automation.micas.diagram.ui.validation;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gmf.runtime.diagram.ui.OffscreenEditPartFactory;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramWorkbenchPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.actions.WorkspaceModifyDelegatingOperation;

import de.wisag.automation.micas.diagram.ui.Activator;
import de.wisag.automation.micas.diagram.ui.providers.BlockMarkerNavigationProvider;
import de.wisag.automation.micas.diagram.ui.providers.BlockValidationProvider;
import de.wisag.automation.micas.diagram.ui.util.EditorUtil;

public class ValidateAction extends Action {

    private IWorkbenchPage page;

    public ValidateAction(IWorkbenchPage page) {
        setText("Validate Block Diagram");
        this.page = page;
    }

    @Override
    public void run() {
        IWorkbenchPart workbenchPart = page.getActivePart();
        if (workbenchPart instanceof IDiagramWorkbenchPart) {
            final IDiagramWorkbenchPart part = (IDiagramWorkbenchPart) workbenchPart;
            try {
                new WorkspaceModifyDelegatingOperation(new IRunnableWithProgress() {

                    @Override
                    public void run(IProgressMonitor monitor) throws InterruptedException, InvocationTargetException {
                        runValidation(part.getDiagramEditPart(), part.getDiagram());
                    }
                }).run(new NullProgressMonitor());
            } catch (Exception e) {
                Activator.getDefault().logError("Validation action failed", e); //$NON-NLS-1$
            }
        }
    }

    public static void runValidation(View view) {
        try {
            if ((EditorUtil.openDiagramEditor((Diagram) view.eResource()) != null)) {
                IEditorPart editorPart = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getActiveEditor();
                if (editorPart instanceof IDiagramWorkbenchPart) {
                    runValidation(((IDiagramWorkbenchPart) editorPart).getDiagramEditPart(), view);
                } else {
                    runNonUIValidation(view);
                }
            }
        } catch (Exception e) {
            Activator.getDefault().logError("Validation action failed", e); //$NON-NLS-1$
        }
    }

    public static void runNonUIValidation(View view) {
        DiagramEditPart diagramEditPart = OffscreenEditPartFactory.getInstance()
                .createDiagramEditPart(view.getDiagram());
        runValidation(diagramEditPart, view);
    }

    public static void runValidation(DiagramEditPart diagramEditPart, View view) {
        final DiagramEditPart fpart = diagramEditPart;
        final View fview = view;
        TransactionalEditingDomain txDomain = TransactionUtil.getEditingDomain(view);
        BlockValidationProvider.runWithConstraints(txDomain, new Runnable() {

            @Override
            public void run() {
                validate(fpart, fview);
            }
        });
    }

    private static Diagnostic runEMFValidator(View target) {
        if (target.isSetElement() && target.getElement() != null) {
            return new Diagnostician() {

                @Override
                public String getObjectLabel(EObject eObject) {
                    return EMFCoreUtil.getQualifiedName(eObject, true);
                }
            }.validate(target.getElement());
        }
        return Diagnostic.OK_INSTANCE;
    }

    private static void validate(DiagramEditPart diagramEditPart, View view) {
        IFile target = view.eResource() != null ? WorkspaceSynchronizer.getFile(view.eResource()) : null;
        if (target != null) {
            BlockMarkerNavigationProvider.deleteMarkers(target);
        }
        Diagnostic diagnostic = runEMFValidator(view);
        createMarkers(target, diagnostic, diagramEditPart);
        IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance()
                .newValidator(EvaluationMode.BATCH);
        validator.setIncludeLiveConstraints(true);
        if (view.isSetElement() && view.getElement() != null) {
            IStatus status = validator.validate(view.getElement());
            createMarkers(target, status, diagramEditPart);
        }
    }

    private static void createMarkers(IFile target, IStatus validationStatus, DiagramEditPart diagramEditPart) {
        if (validationStatus.isOK()) {
            return;
        }
        final IStatus rootStatus = validationStatus;
        List allStatuses = new ArrayList();
        EditorUtil.LazyElement2ViewMap element2ViewMap = new EditorUtil.LazyElement2ViewMap(
                diagramEditPart.getDiagramView(),
                collectTargetElements(rootStatus, new HashSet<EObject>(), allStatuses));
        for (Iterator it = allStatuses.iterator(); it.hasNext();) {
            IConstraintStatus nextStatus = (IConstraintStatus) it.next();
            View view = EditorUtil.findView(diagramEditPart, nextStatus.getTarget(), element2ViewMap);
            addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view),
                    EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), nextStatus.getMessage(),
                    nextStatus.getSeverity());
        }
    }

    private static void createMarkers(IFile target, Diagnostic emfValidationStatus, DiagramEditPart diagramEditPart) {
        if (emfValidationStatus.getSeverity() == Diagnostic.OK) {
            return;
        }
        final Diagnostic rootStatus = emfValidationStatus;
        List allDiagnostics = new ArrayList();
        EditorUtil.LazyElement2ViewMap element2ViewMap = new EditorUtil.LazyElement2ViewMap(
                diagramEditPart.getDiagramView(),
                collectTargetElements(rootStatus, new HashSet<EObject>(), allDiagnostics));
        for (Iterator it = emfValidationStatus.getChildren().iterator(); it.hasNext();) {
            Diagnostic nextDiagnostic = (Diagnostic) it.next();
            List data = nextDiagnostic.getData();
            if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
                EObject element = (EObject) data.get(0);
                View view = EditorUtil.findView(diagramEditPart, element, element2ViewMap);
                addMarker(diagramEditPart.getViewer(), target, view.eResource().getURIFragment(view),
                        EMFCoreUtil.getQualifiedName(element, true), nextDiagnostic.getMessage(),
                        diagnosticToStatusSeverity(nextDiagnostic.getSeverity()));
            }
        }
    }

    private static void addMarker(EditPartViewer viewer, IFile target, String elementId, String location,
            String message, int statusSeverity) {
        if (target == null) {
            return;
        }
        BlockMarkerNavigationProvider.addMarker(target, elementId, location, message, statusSeverity);
    }

    private static int diagnosticToStatusSeverity(int diagnosticSeverity) {
        if (diagnosticSeverity == Diagnostic.OK) {
            return IStatus.OK;
        } else if (diagnosticSeverity == Diagnostic.INFO) {
            return IStatus.INFO;
        } else if (diagnosticSeverity == Diagnostic.WARNING) {
            return IStatus.WARNING;
        } else if (diagnosticSeverity == Diagnostic.ERROR || diagnosticSeverity == Diagnostic.CANCEL) {
            return IStatus.ERROR;
        }
        return IStatus.INFO;
    }

    private static Set<EObject> collectTargetElements(IStatus status, Set<EObject> targetElementCollector,
            List allConstraintStatuses) {
        if (status instanceof IConstraintStatus) {
            targetElementCollector.add(((IConstraintStatus) status).getTarget());
            allConstraintStatuses.add(status);
        }
        if (status.isMultiStatus()) {
            IStatus[] children = status.getChildren();
            for (int i = 0; i < children.length; i++) {
                collectTargetElements(children[i], targetElementCollector, allConstraintStatuses);
            }
        }
        return targetElementCollector;
    }

    private static Set<EObject> collectTargetElements(Diagnostic diagnostic, Set<EObject> targetElementCollector,
            List allDiagnostics) {
        List data = diagnostic.getData();
        EObject target = null;
        if (data != null && !data.isEmpty() && data.get(0) instanceof EObject) {
            target = (EObject) data.get(0);
            targetElementCollector.add(target);
            allDiagnostics.add(diagnostic);
        }
        if (diagnostic.getChildren() != null && !diagnostic.getChildren().isEmpty()) {
            for (Iterator it = diagnostic.getChildren().iterator(); it.hasNext();) {
                collectTargetElements((Diagnostic) it.next(), targetElementCollector, allDiagnostics);
            }
        }
        return targetElementCollector;
    }
}
