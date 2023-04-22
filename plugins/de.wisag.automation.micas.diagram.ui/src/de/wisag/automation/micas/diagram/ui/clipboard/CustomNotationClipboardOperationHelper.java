package de.wisag.automation.micas.diagram.ui.clipboard;

import static de.wisag.automation.micas.diagram.core.util.DiagramFragmentPastingHelper.cleanVariablesOnOutputSide;
import static de.wisag.automation.micas.diagram.core.util.DiagramFragmentPastingHelper.performPostPasteBlockProcessing;
import static de.wisag.automation.micas.diagram.core.util.DiagramFragmentPastingHelper.processPastedConnection;
import static de.wisag.automation.micas.module.util.BlockUtils.sortBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.ClipboardSupportUtil;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteChildOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.PasteTarget;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.IClipboardSupport2;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.PasteIntoParentOperation;
import org.eclipse.gmf.runtime.emf.clipboard.core.internal.PasteOperation;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.runtime.notation.providers.internal.copypaste.NotationClipboardOperationHelper;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.DMLPackage;

import de.wisag.automation.micas.module.ModulePackage;

@SuppressWarnings("restriction")
public class CustomNotationClipboardOperationHelper extends NotationClipboardOperationHelper
        implements IClipboardSupport2 {

    @Override
    protected boolean shouldAllowPaste(PasteChildOperation overriddenChildPasteOperation) {
        return shouldAllowPaste2(overriddenChildPasteOperation);
    }

    private boolean shouldAllowPaste2(PasteChildOperation overriddenChildPasteOperation) {
        EObject eObject = overriddenChildPasteOperation.getEObject();
        EObject parentEObject = overriddenChildPasteOperation.getParentEObject();
        // RATLC01137919 removed the condition that parentEObject is a diagram
        // to allow paste into diagram elements
        if ((parentEObject instanceof View) && (eObject instanceof View)) {
            EObject semanticChildElement = ((View) eObject).getElement();
            if (semanticChildElement == null) {
                return true;
            }
            if (semanticChildElement.eIsProxy()) {
                semanticChildElement = ClipboardSupportUtil.resolve(semanticChildElement,
                        overriddenChildPasteOperation.getParentPasteProcess().getLoadedIDToEObjectMapCopy());
                if (semanticChildElement.eIsProxy()) {
                    semanticChildElement = EcoreUtil.resolve(semanticChildElement, getResource(parentEObject));
                }
            }

            EPackage semanticChildEpackage = semanticChildElement.eClass().getEPackage();
            EPackage parentRootContainerEpackage = EcoreUtil.getRootContainer(parentEObject).eClass().getEPackage();
            EPackage sematicParentRootContainerEpackage = null;
            EObject sematicParentElement = ((View) parentEObject).getElement();
            if (sematicParentElement != null) {
                sematicParentRootContainerEpackage = EcoreUtil.getRootContainer(sematicParentElement).eClass()
                        .getEPackage();
            }

            if (parentRootContainerEpackage != NotationPackage.eINSTANCE) {
                if (semanticChildEpackage != parentRootContainerEpackage) {
                    return false;
                }
            }

            if ((sematicParentRootContainerEpackage != null)
                    && (sematicParentRootContainerEpackage != NotationPackage.eINSTANCE)) {
                if (semanticChildEpackage != sematicParentRootContainerEpackage
                        && !(semanticChildEpackage instanceof DMLPackage
                                && sematicParentRootContainerEpackage instanceof ModulePackage)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void performPostPasteProcessing(@SuppressWarnings("rawtypes") Set pastedEObjects) {
        List<Block> blocks = new ArrayList<>();
        for (Object o : pastedEObjects) {
            if (o instanceof Block) {
                blocks.add((Block) o);
            }
        }
        for (Block block : sortBlocks(blocks)) {
            // blocks should be sorted before indexing
            performPostPasteBlockProcessing(block);
            cleanVariablesOnOutputSide(block);
        }
        for (Object o : pastedEObjects) {
            if (o instanceof Connection) {
                processPastedConnection((Connection) o);
            }
        }

    }

    static EObject getSemanticPasteTarget(View view) {
        View parent = (View) view.eContainer();
        return parent.getElement();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public boolean shouldOverridePasteIntoParentOperation(PasteTarget pasteTarget, Map hintsMap) {
        return true;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public PasteIntoParentOperation getPasteIntoParentOperation(PasteOperation pasteOperation, PasteTarget pasteTarget,
            Map hintsMap) throws Exception {
        return new CustomPasteIntoParentOperation(pasteOperation, pasteTarget, hintsMap);
    }
}
