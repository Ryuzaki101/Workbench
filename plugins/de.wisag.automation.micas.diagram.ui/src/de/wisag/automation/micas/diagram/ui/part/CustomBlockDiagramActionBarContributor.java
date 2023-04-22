package de.wisag.automation.micas.diagram.ui.part;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipselabs.damos.diagram.ui.part.BlockDiagramActionBarContributor;

import de.wisag.automation.micas.diagram.ui.validation.ValidateAction;

public class CustomBlockDiagramActionBarContributor extends BlockDiagramActionBarContributor {

    @Override
    public void init(IActionBars bars, IWorkbenchPage page) {
        super.init(bars, page);
        IMenuManager editMenu = bars.getMenuManager().findMenuUsingPath(IWorkbenchActionConstants.M_EDIT);
        assert editMenu != null;
        if (editMenu.find("validationGroup") == null) { //$NON-NLS-1$
            editMenu.add(new GroupMarker("validationGroup")); //$NON-NLS-1$
        }
        IAction validateAction = new ValidateAction(page);
        editMenu.appendToGroup("validationGroup", validateAction); //$NON-NLS-1$
    }

}
