package de.wisag.automation.micas.module.ui.handlers;

import static de.wisag.automation.micas.module.ui.dialogs.SymbolEditorDialog.editSymbol;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.diagram.ui.editparts.IAttributeHolder;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.ui.dialogs.EditMode;
import de.wisag.automation.micas.module.ui.dialogs.FindSymbolDialog;

public class SymbolHandler extends AbstractHandler {

    public final static String CREATE_REFERENCE_COMMAND = "de.wisag.automation.micas.module.ui.commands.createReferenceCommand";
    public final static String EDIT_REFERENCE_COMMAND = "de.wisag.automation.micas.module.ui.commands.editReferenceCommand";

    public final static String CREATE_VARIABLE_COMMAND = "de.wisag.automation.micas.module.ui.commands.createVariableCommand";
    public final static String EDIT_VARIABLE_COMMAND = "de.wisag.automation.micas.module.ui.commands.editVariableCommand";

    public final static String CREATE_CONSTANT_COMMAND = "de.wisag.automation.micas.module.ui.commands.createConstantCommand";
    public final static String EDIT_CONSTANT_COMMAND = "de.wisag.automation.micas.module.ui.commands.editConstantCommand";

    public final static String ASSIGN_SYMBOL_COMMAND = "de.wisag.automation.micas.module.ui.commands.assignSymbolCommand";

    @Override
    public Object execute(ExecutionEvent event) throws ExecutionException {
        final Shell activeShell = HandlerUtil.getActiveShellChecked(event);
        String cmdId = event.getCommand().getId();
        final IAttributeHolder holder = SelectionUtils.singleSelection(IAttributeHolder.class,
                HandlerUtil.getCurrentSelection(event));

        Module module = holder.getModule();
        SimpleModuleModelProvider modelProvider = createModelProvider(activeShell, module);
        TransactionalEditingDomain editingDomain = (TransactionalEditingDomain) modelProvider.getEditingDomain();

        if (CREATE_REFERENCE_COMMAND.equals(cmdId)) {
            createAttributeAndSet(activeShell, holder, modelProvider, editingDomain,
                    ModuleFactory.eINSTANCE.createReferenceAttribute());
        } else if (EDIT_REFERENCE_COMMAND.equals(cmdId)) {
            editSymbol(holder.getAttribute(), activeShell, createModelProvider(activeShell, module), EditMode.MODIFY);
        } else if (CREATE_VARIABLE_COMMAND.equals(cmdId)) {
            VariableAttribute attribute = ModuleFactory.eINSTANCE.createVariableAttribute();
            createAttributeAndSet(activeShell, holder, modelProvider, editingDomain, attribute);
        } else if (EDIT_VARIABLE_COMMAND.equals(cmdId)) {
            editSymbol(holder.getAttribute(), activeShell, createModelProvider(activeShell, module), EditMode.MODIFY);
        } else if (CREATE_CONSTANT_COMMAND.equals(cmdId)) {
            ConstantAttribute attribute = ModuleFactory.eINSTANCE.createConstantAttribute();
            createAttributeAndSet(activeShell, holder, modelProvider, editingDomain, attribute);
        } else if (EDIT_CONSTANT_COMMAND.equals(cmdId)) {
            editSymbol(holder.getAttribute(), activeShell, createModelProvider(activeShell, module), EditMode.MODIFY);
        } else if (ASSIGN_SYMBOL_COMMAND.equals(cmdId)) {
            FindSymbolDialog dlg = new FindSymbolDialog(activeShell, holder.getModule(),
                    SymbolFilter.createFilter(holder.getAttributeType()));
            if (dlg.open() == IDialogConstants.OK_ID && dlg.getFirstResult() != null) {
                final Attribute result = (Attribute) dlg.getFirstResult();
                RecordingCommand recCmd = new RecordingCommand(editingDomain) {
                    @Override
                    protected void doExecute() {
                        holder.setNewAttribute(result);
                    }
                };
                modelProvider.getEditingDomain().getCommandStack().execute(recCmd);

            }
        }
        return null;
    }

    void createAttributeAndSet(final Shell activeShell, final IAttributeHolder holder,
            SimpleModuleModelProvider modelProvider, TransactionalEditingDomain editingDomain, Attribute attribute) {
        final Attribute result = editSymbol(attribute, activeShell, modelProvider, EditMode.NEW);

        if (result != null) {

            RecordingCommand recCmd = new RecordingCommand(editingDomain) {
                @Override
                protected void doExecute() {
                    holder.setNewAttribute(result);
                }
            };
            modelProvider.getEditingDomain().getCommandStack().execute(recCmd);
        }
    }

    SimpleModuleModelProvider createModelProvider(final Shell activeShell, Module module) {
        return new SimpleModuleModelProvider(module,
                new DataBindingContext(DisplayRealm.getRealm(activeShell.getDisplay())));
    }
}
