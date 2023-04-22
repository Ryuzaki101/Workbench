package de.wisag.automation.micas.diagram.ui.providers;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.IValidationContext;
import org.eclipse.emf.validation.model.IClientSelector;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.View;

public class BlockValidationProvider {

    private static boolean constraintsActive = false;

    public static boolean shouldConstraintsBePrivate() {
        return false;
    }

    public static void runWithConstraints(TransactionalEditingDomain editingDomain, Runnable operation) {
        final Runnable op = operation;
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    constraintsActive = true;
                    op.run();
                } finally {
                    constraintsActive = false;
                }
            }
        };
        if (editingDomain != null) {
            try {
                editingDomain.runExclusive(task);
            } catch (Exception e) {
                de.wisag.automation.micas.diagram.ui.Activator.getDefault().logError("Validation failed", e); //$NON-NLS-1$
            }
        } else {
            task.run();
        }
    }

    static boolean isInDefaultEditorContext(Object object) {
        if (shouldConstraintsBePrivate() && !constraintsActive) {
            return false;
        }
        if (object instanceof View) {
            System.err.println("BlockValidationProvider.isInDefaultEditorContext()");
            return constraintsActive;
            // && MapEditPart.MODEL_ID.equals(MindmapVisualIDRegistry
            // .getModelID((View) object));
        }
        return true;
    }

    public static class DefaultCtx implements IClientSelector {

        @Override
        public boolean selects(Object object) {
            return isInDefaultEditorContext(object);
        }
    }

    public static class Adapter1 extends AbstractModelConstraint {

        @Override
        public IStatus validate(IValidationContext ctx) {
            // context = ctx.getTarget();
            return ctx.createSuccessStatus();
        }
    }

    public static class Adapter2 extends AbstractModelConstraint {

        @Override
        public IStatus validate(IValidationContext ctx) {
            // context = ctx.getTarget();
            return ctx.createSuccessStatus();
        }
    }

    static String formatElement(EObject object) {
        return EMFCoreUtil.getQualifiedName(object, true);
    }

}
