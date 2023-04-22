package de.wisag.automation.micas.olt.ui.internal.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.common.ui.DemoUtils;
import de.wisag.automation.micas.export.mic.IRtSymbolTranslator;
import de.wisag.automation.micas.olt.ui.internal.Activator;
import de.wisag.automation.micas.rt.RtSymbol;

public class MonitorSymbolHandler extends AbstractHandler {

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        DemoUtils.checkDemoMode(event);
        Shell shell = HandlerUtil.getActiveShell(event);
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
        if (selection.isEmpty()) {
            return null;
        }
        if (selection.size() > 1) {
            Iterator<?> it = selection.iterator();
            List<Object> eobjs = new ArrayList<>();
            IFile diagramFile = null;
            while (it.hasNext()) {
                Object o = it.next();
                EObject eo = resolveSemanticElement(o);
                if (eo == null) {
                    continue;
                }
                eobjs.add(eo);
                if (diagramFile == null) {
                    diagramFile = ResourceUtils.toIFile(eo.eResource());
                }
            }
            IRtSymbolTranslator translator = diagramFile.getAdapter(IRtSymbolTranslator.class);
            List<RtSymbol> translatables = TranslatorUtils.filterTranslatableSymbols(translator, eobjs.iterator());
            IStatus status = TranslatorUtils.addAllSymboldToOnlinetest(translatables);
            if (!status.isOK()) {
                MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error monitoring Symbol",
                        status.getMessage());
            }
        } else {

            Object firstElement = selection.getFirstElement();

            EObject semanticElement = resolveSemanticElement(firstElement);
            if (semanticElement == null) {
                ErrorDialog.openError(shell, "Error", "Cannot resolve semantic element for " + firstElement,
                        new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error adding Symbol"));
                return null;
            }

            IFile diagramFile = ResourceUtils.toIFile(semanticElement.eResource());
            // translate the diagram symbol to rtModelSymbol
            IRtSymbolTranslator translator = diagramFile.getAdapter(IRtSymbolTranslator.class);
            RtSymbol symbol = translator.translate(new NullProgressMonitor(), semanticElement);
            if (symbol == null) {
                ErrorDialog.openError(shell, "Error", "Error adding symbol", new Status(IStatus.ERROR,
                        Activator.PLUGIN_ID, "Could not translate Module Symbol to RtModuleSymbol"));
                return null;
            }
            IStatus status = TranslatorUtils.addAllSymboldToOnlinetest(Arrays.asList(new RtSymbol[] { symbol }));
            if (!status.isOK()) {
                MessageDialog.openError(HandlerUtil.getActiveShell(event), "Error monitoring Symbol",
                        status.getMessage());
            }
        }
        return null;
    }

    private static EObject resolveSemanticElement(Object firstElement) {
        EObject eObject = null;
        if (firstElement instanceof IGraphicalEditPart) {
            eObject = ((IGraphicalEditPart) firstElement).resolveSemanticElement();
        }
        return eObject;
    }

}
