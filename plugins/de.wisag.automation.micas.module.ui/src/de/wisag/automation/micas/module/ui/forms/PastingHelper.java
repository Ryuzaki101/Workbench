package de.wisag.automation.micas.module.ui.forms;

import static de.wisag.automation.micas.diagram.core.util.DiagramFragmentPastingHelper.cleanVariablesOnOutputSide;
import static de.wisag.automation.micas.diagram.core.util.DiagramFragmentPastingHelper.performPostPasteBlockProcessing;
import static de.wisag.automation.micas.diagram.core.util.DiagramFragmentPastingHelper.processPastedConnection;
import static de.wisag.automation.micas.module.util.BlockUtils.getSortedBlocks;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.Connection;

import de.wisag.automation.micas.module.Page;

public class PastingHelper {

    public static void performPostPasteProcessing(Page page) {
        // blocks should be sorted before indexing
        for (Block block : getSortedBlocks(page)) {
            performPostPasteBlockProcessing(block);
            cleanVariablesOnOutputSide(block);
        }
        TreeIterator<Object> first = EcoreUtil.getAllContents(page, false);
        while (first.hasNext()) {
            Object o = first.next();
            if (o instanceof Connection) {
                processPastedConnection((Connection) o);
            }
        }
    }
}
