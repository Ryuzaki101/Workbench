package de.wisag.automation.micas.module.ui.forms;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.ui.dialogs.EditMode;
import de.wisag.automation.micas.module.ui.dialogs.SymbolEditorDialog;
import de.wisag.automation.micas.module.ui.editor.IModelProvider;

public class SymbolActionsProvider {
    public interface PostActionCallback<T> {
        public void perform(T element);
    }

    private final IModelProvider<Module> modelProvider;
    private final PostActionCallback<Attribute> callback;

    public void provideActionsFor(final Button btnNewSymbol) {
        final MenuManager mm = new MenuManager();
        mm.setRemoveAllWhenShown(true);

        final Menu menu = mm.createContextMenu(btnNewSymbol);
        mm.addMenuListener(new IMenuListener() {

            @Override
            public void menuAboutToShow(IMenuManager manager) {
                manager.add(new Action("Variable") {
                    @Override
                    public void run() {
                        VariableAttribute attribute = ModuleFactory.eINSTANCE.createVariableAttribute();
                        SymbolEditorDialog.editSymbol(attribute, btnNewSymbol.getShell(), modelProvider, EditMode.NEW);
                        if (callback != null) {
                            callback.perform(attribute);
                        }
                    }

                });
                manager.add(new Action("Konstante") {
                    @Override
                    public void run() {
                        ConstantAttribute attribute = ModuleFactory.eINSTANCE.createConstantAttribute();
                        SymbolEditorDialog.editSymbol(attribute, btnNewSymbol.getShell(), modelProvider, EditMode.NEW);
                        // symbolsViewer.setSelection(new
                        // StructuredSelection(attribute), true);
                        if (callback != null) {
                            callback.perform(attribute);
                        }
                    }
                });
                manager.add(new Action("Referenz") {
                    @Override
                    public void run() {
                        ReferenceAttribute attribute = ModuleFactory.eINSTANCE.createReferenceAttribute();
                        SymbolEditorDialog.editSymbol(attribute, btnNewSymbol.getShell(), modelProvider, EditMode.NEW);
                        // symbolsViewer.setSelection(new
                        // StructuredSelection(attribute), true);
                        if (callback != null) {
                            callback.perform(attribute);
                        }
                    }
                });
            }
        });
        btnNewSymbol.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                menu.setLocation(btnNewSymbol.toDisplay(0, btnNewSymbol.getBounds().height));
                menu.setVisible(true);
            }
        });
    }

    public SymbolActionsProvider(IModelProvider<Module> modelProvider, PostActionCallback<Attribute> callback) {
        super();
        this.modelProvider = modelProvider;
        this.callback = callback;
    }

}
