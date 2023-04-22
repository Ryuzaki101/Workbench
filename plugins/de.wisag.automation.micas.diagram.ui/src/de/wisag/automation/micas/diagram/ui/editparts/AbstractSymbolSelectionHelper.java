package de.wisag.automation.micas.diagram.ui.editparts;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipselabs.damos.dml.Component;
import org.eclipselabs.damos.dml.Connection;
import org.eclipselabs.damos.dml.FragmentElement;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.diagram.ui.dialogs.SymbolFilterDialogAccess;
import de.wisag.automation.micas.diagram.ui.editparts.DialogOnDoubleclickHelper.ISymbolSelectionHelper;
import de.wisag.automation.micas.diagram.ui.internal.Policy;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;

abstract class AbstractSymbolSelectionHelper implements ISymbolSelectionHelper {
    @Override
    public ICommand createCommand(final IGraphicalEditPart ep) {
        return new AbstractTransactionalCommand(ep.getEditingDomain(), "", null) {
            private RecordingCommand recCmd;

            @Override
            protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
                    throws ExecutionException {
                recCmd = new RecordingCommand(ep.getEditingDomain()) {
                    @Override
                    protected void doExecute() {
                        Page page = null;
                        EObject semanticElement = ep.resolveSemanticElement();
                        if (!canRun((FragmentElement) semanticElement)) {

                            return;
                        }
                        if (semanticElement instanceof Component) {
                            Component new_name = (Component) semanticElement;
                            page = (Page) new_name.getEnclosingFragment();
                        } else if (semanticElement instanceof Connection) {
                            Connection new_name = (Connection) semanticElement;
                            page = (Page) new_name.getEnclosingFragment();
                        }
                        if (page == null) {
                            return;
                        }
                        final Module module = page.getTask().getModule();
                        Shell activeShell = Display.getCurrent().getActiveShell();
                        SymbolFilter symbolFilter = getSymbolFilter();
                        try {
                            Object firstResult = SymbolFilterDialogAccess.openFilterSymbolDialog(module, activeShell,
                                    symbolFilter);
                            if (firstResult != null) {
                                Attribute attribute = (Attribute) firstResult;
                                setAttribute((FragmentElement) semanticElement, attribute);
                            }
                        } catch (Exception e) {
                            Policy.logError(e);
                        }
                    }

                };

                ep.getEditingDomain().getCommandStack().execute(recCmd);

                return CommandResult.newOKCommandResult();
            }

            @Override
            public boolean canUndo() {
                if (recCmd != null) {
                    return recCmd.canUndo();
                }
                return false;
            }

            @Override
            public boolean canRedo() {
                return false;
            }
        };
    }

    @Override
    public abstract void setAttribute(FragmentElement component, Attribute attribute);

    @Override
    public abstract SymbolFilter getSymbolFilter();

    public boolean isEnabled() {
        return true;
    }

    protected boolean canRun(FragmentElement element) {

        return true;
    }
}