package de.wisag.automation.micas.module.ui.dialogs;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipselabs.damos.dml.DMLPackage;

import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.module.ui.editor.IModelProvider;
import de.wisag.automation.micas.module.ui.forms.DiagramNameHelper;

public class DiagrammEditorDialog extends MicasDomainEditorDialog<DiagrammEditorDialogPage, Page> {
    public DiagrammEditorDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected DiagrammEditorDialogPage doCreateDialogPage(Composite parent) {
        return new DiagrammEditorDialogPage(parent, SWT.NONE);
    }

    @Override
    protected void bind(DataBindingContext dbc, DiagrammEditorDialogPage page) {
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtDiagrammName()),
                EMFEditProperties.value(getEditingDomain(), DMLPackage.Literals.FRAGMENT__NAME).observe(getModel()),
                new EMFUpdateValueStrategy().setAfterGetValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        String name = (String) value;
                        if (StringUtils.isEmpty(name)) {
                            ValidationStatus.error("Diagrammnamen darf nicht leer sein");
                        }
                        return ValidationStatus.ok();
                    }
                }), new EMFUpdateValueStrategy()

        );
    }

    public static int editDiagramm(Shell shell, IModelProvider<Task> modelProvider, Page page, EditMode editMode) {
        DiagrammEditorDialog dlg = new DiagrammEditorDialog(shell);
        dlg.setModel(page);
        dlg.setEditingDomain(modelProvider.getEditingDomain());
        dlg.setDataBindingContext(modelProvider.getDataBindingContext());
        dlg.setEditMode(editMode);
        dlg.setDialogTitle("Diagramm");
        if (editMode == EditMode.NEW) {
            Task task = modelProvider.getModel();
            int number = task.getPages().size();
            String name = String.format("Diagramm%d", number);
            while (!DiagramNameHelper.isUniqueName(task, name)) {
                name = String.format("Diagramm%d", ++number);
            }
            page.setName(name);
        }
        if (IDialogConstants.OK_ID == dlg.open()) {
            EditingDomain editingDomain = modelProvider.getEditingDomain();
            Command add = AddCommand.create(editingDomain, modelProvider.getModel(), ModulePackage.Literals.TASK__PAGES,
                    page);
            editingDomain.getCommandStack().execute(add);
            return IDialogConstants.OK_ID;
        } else {
            return IDialogConstants.CANCEL_ID;
        }
    }

}
