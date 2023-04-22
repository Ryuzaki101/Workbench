package de.wisag.automation.micas.module.ui.dialogs;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.IValueChangeListener;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.databinding.EMFUpdateValueStrategy;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditValueProperty;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.IViewerObservableValue;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Text;

import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.Value;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;
import de.wisag.automation.micas.module.ui.editor.IModelProvider;
import de.wisag.automation.micas.module.ui.internal.Activator;
import de.wisag.automation.micas.module.ui.internal.ModelUtils;

public class SymbolEditorDialog extends MicasDomainEditorDialog<SymbolEditorDialogPage, Attribute> {
    // HACK
    static EditingHistory editingHistory = new EditingHistory();

    static class EditingHistory {
        DataType lastEditedConstant = DataType.WORD;
        DataType lastEditedVariable = DataType.WORD;
    }

    private EditedType editedType = EditedType.VARIABLE;
    private Module module;
    private WritableValue<Integer> serialCount = null;
    private boolean serialsEnabled = false;

    public SymbolEditorDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected SymbolEditorDialogPage doCreateDialogPage(Composite parent) {
        return SymbolEditorDialogPageFactory.create(parent, getEditedType());
    }

    @Override
    protected void bind(DataBindingContext dbc, SymbolEditorDialogPage page) {
        serialCount = new WritableValue<>(dbc.getValidationRealm(), Integer.valueOf(0), Integer.class);
        Text txtSymbolName = page.getTxtSymbolName();
        IEMFEditValueProperty value = EMFEditProperties.value(getEditingDomain(),
                ModulePackage.Literals.ATTRIBUTE__NAME);
        IObservableValue<String> observe = value.<String> observe(getModel());
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(txtSymbolName), observe, //
                new EMFUpdateValueStrategy().setAfterGetValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        String name = (String) value;
                        if (StringUtils.isEmpty(name)) {
                            return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Name must not be empty");
                        }
                        // check for duplicate symbol
                        EList<Attribute> attributes = getModule().getAttributes();
                        for (Attribute attribute : attributes) {
                            if (attribute.equals(getModel())) {
                                // ignore if attribute is the edited attribute
                                continue;
                            }
                            if (StringUtils.equalsIgnoreCase(name, attribute.getName())) {
                                return new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                                        String.format("Duplicate symbolname '%s'", name));
                            }
                        }
                        return Status.OK_STATUS;
                    }
                }), //
                new EMFUpdateValueStrategy());

        Text txtSymbolDescription = page.getTxtSymbolDescription();
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(txtSymbolDescription),
                EMFEditProperties.value(getEditingDomain(), ModulePackage.Literals.ATTRIBUTE__DESCRIPTION)
                        .observe(getModel()), //
                new EMFUpdateValueStrategy(), //
                new EMFUpdateValueStrategy());

        switch (getEditedType()) {
        case CONSTANT:
            bind(dbc, (SymbolEditorDialogConstantPage) page);
            break;
        case REFERENCE:
            bind(dbc, (SymbolEditorDialogReferencePage) page);
            break;
        case VARIABLE:
            bind(dbc, (SymbolEditorDialogVariablePage) page);
            break;
        default:
            throw new RuntimeException("Unsupported editType " + getEditedType());
        }
        if (getEditMode() == EditMode.NEW) {
            txtSymbolName.setFocus();
            txtSymbolName.selectAll();
        }
    }

    private void bind(DataBindingContext dbc, SymbolEditorDialogVariablePage page) {
        Combo cmbSymbolType = page.getCmbSymbolType();
        bindDataType(dbc, cmbSymbolType);
        Button btnCreateSerial = page.getBtnCreateSerial();
        Label lblCreate = page.getLblCount();
        Spinner count = page.getCount();
        if (!this.serialsEnabled) {
            btnCreateSerial.setEnabled(false);
            lblCreate.setEnabled(false);
            count.setEnabled(false);
        }
        btnCreateSerial.setSelection(false);
        count.setValues(0, 0, 99, 0, 1, 1);
        ISWTObservableValue createSerialSel = WidgetProperties.selection().observe(btnCreateSerial);
        dbc.bindValue(createSerialSel, WidgetProperties.enabled().observe(lblCreate));
        dbc.bindValue(createSerialSel, WidgetProperties.enabled().observe(count));
        dbc.bindValue(WidgetProperties.selection().observe(count), serialCount);
    }

    private void bind(DataBindingContext dbc, SymbolEditorDialogConstantPage page) {
        Combo cmbSymbolType = page.getCmbSymbolType();
        final IObservableValue selectedDataType = bindDataType(dbc, cmbSymbolType);
        final Text txtConstantValue = page.getTxtConstantValue();
        // TODO: what todo in case of type change ?
        IEMFEditValueProperty value = EMFEditProperties.value(getEditingDomain(),
                ModulePackage.Literals.CONSTANT_ATTRIBUTE__VALUE);
        IObservableValue observe = value.observe(getModel());
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(txtConstantValue), observe,
                new EMFUpdateValueStrategy().setConverter(new IConverter() {

                    @Override
                    public Object getToType() {
                        return Value.class;
                    }

                    @Override
                    public Object getFromType() {
                        return String.class;
                    }

                    @Override
                    public Object convert(Object fromObject) {
                        DataType dataType = (DataType) selectedDataType.getValue();
                        String sValue = (String) fromObject;
                        Value value = null;
                        if (DataType.FLOAT == dataType) {
                            FloatValue floatValue = ModuleFactory.eINSTANCE.createFloatValue();
                            double dValue = Double.parseDouble(sValue);
                            floatValue.setValue(dValue);
                            value = floatValue;
                        } else if (DataType.WORD == dataType) {
                            WordValue wordValue = ModuleFactory.eINSTANCE.createWordValue();
                            int iValue = Integer.parseInt(sValue);
                            wordValue.setValue(iValue);
                            value = wordValue;
                        }
                        return value;
                    }
                }), new EMFUpdateValueStrategy().setConverter(new IConverter() {

                    @Override
                    public Object getToType() {
                        return String.class;
                    }

                    @Override
                    public Object getFromType() {
                        return Value.class;
                    }

                    @Override
                    public Object convert(Object fromObject) {
                        String value = "";
                        if (fromObject instanceof WordValue) {
                            WordValue wordValue = (WordValue) fromObject;
                            value = String.valueOf(wordValue.getValue());
                        } else if (fromObject instanceof FloatValue) {
                            FloatValue floatValue = (FloatValue) fromObject;
                            value = String.valueOf(floatValue.getValue());
                        }
                        return value;
                    }
                }));

    }

    private void bind(DataBindingContext dbc, SymbolEditorDialogReferencePage page) {
        Combo cmbReferenzType = page.getCmbReferenzType();
        Text txtColumnValue = page.getTxtColumnValue();
        Text txtRowValue = page.getTxtRowValue();
        bindReferenceType(dbc, cmbReferenzType, page);
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(txtColumnValue), EMFEditProperties
                .value(getEditingDomain(), ModulePackage.Literals.REFERENCE_ATTRIBUTE__COLUMN).observe(getModel()),
                new EMFUpdateValueStrategy().setAfterConvertValidator(new IValidator() {
                    @Override
                    public IStatus validate(Object value) {
                        // TODO: ensure, that only one symbol per row exists
                        return ValidationStatus.ok();
                    }
                }), new EMFUpdateValueStrategy());
        dbc.bindValue(
                WidgetProperties.text(SWT.Modify).observe(txtRowValue), EMFEditProperties
                        .value(getEditingDomain(), ModulePackage.Literals.REFERENCE_ATTRIBUTE__ROW).observe(getModel()),
                new EMFUpdateValueStrategy(), new EMFUpdateValueStrategy());

    }

    private IObservableValue bindDataType(DataBindingContext dbc, Combo combo) {
        ComboViewer comboViewer = new ComboViewer(combo);
        comboViewer.setContentProvider(new ArrayContentProvider());
        comboViewer.setInput(DataType.VALUES);
        comboViewer.setFilters(new ViewerFilter[] { new ViewerFilter() {

            @Override
            public boolean select(Viewer viewer, Object parentElement, Object element) {
                if ((DataType) element == DataType.REFERENCE) {
                    return false;
                }
                return true;
            }
        } });
        comboViewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return ((DataType) element).getName();
            }
        });

        IViewerObservableValue dataTypeSelection = ViewerProperties.singleSelection().observe(comboViewer);
        dbc.bindValue(dataTypeSelection, //
                EMFEditProperties.value(getEditingDomain(), ModulePackage.Literals.ATTRIBUTE__DATA_TYPE)
                        .observe(getModel())//
        );
        // migrate WordValue <-> FloatValue
        dataTypeSelection.addValueChangeListener(new IValueChangeListener() {
            @Override
            public void handleValueChange(ValueChangeEvent event) {
                Attribute attribute = getModel();
                if (attribute instanceof VariableAttribute) {
                    VariableAttribute variableAttribute = (VariableAttribute) attribute;
                    editingHistory.lastEditedVariable = variableAttribute.getDataType();
                }
                if (attribute instanceof ConstantAttribute) {
                    final ConstantAttribute constant = (ConstantAttribute) attribute;
                    // HACK
                    editingHistory.lastEditedConstant = constant.getDataType();
                    EditingDomain domain = getEditingDomain();
                    domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
                        @Override
                        protected void doExecute() {

                        }
                    });
                    if (constant.getDataType() == DataType.FLOAT && (constant.getValue() instanceof WordValue)) {
                        domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
                            @Override
                            protected void doExecute() {
                                WordValue value = (WordValue) constant.getValue();
                                FloatValue floatValue = ModuleFactory.eINSTANCE.createFloatValue();
                                floatValue.setValue(value.getValue());
                                constant.setValue(floatValue);
                            }
                        });
                    } else if (constant.getDataType() == DataType.WORD && (constant.getValue() instanceof FloatValue)) {
                        domain.getCommandStack().execute(new RecordingCommand((TransactionalEditingDomain) domain) {
                            @Override
                            protected void doExecute() {

                                FloatValue value = (FloatValue) constant.getValue();
                                WordValue wordValue = ModuleFactory.eINSTANCE.createWordValue();
                                wordValue.setValue(Math.round((float) value.getValue()));
                                constant.setValue(wordValue);
                            }
                        });
                        return;
                    }

                }

            }
        });
        return dataTypeSelection;
    }

    private IObservableValue bindReferenceType(DataBindingContext dbc, Combo combo,
            SymbolEditorDialogReferencePage page) {
        ComboViewer comboViewer = new ComboViewer(combo);
        comboViewer.setContentProvider(new ArrayContentProvider());
        comboViewer.setInput(ReferenceType.VALUES);
        comboViewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                ReferenceType referenceType = (ReferenceType) element;
                return ModelUtils.referenceTypeToDisplayName(referenceType);
            }
        });

        IViewerObservableValue comboSelection = ViewerProperties.singleSelection().observe(comboViewer);
        IObservableValue referenceObservable = EMFEditProperties
                .value(getEditingDomain(), ModulePackage.Literals.REFERENCE_ATTRIBUTE__REFERENCE_TYPE)
                .observe(getModel());
        // first bind enableness
        dbc.bindValue(comboSelection, WidgetProperties.enabled().observe(page.getTxtColumnValue()),
                new UpdateValueStrategy().setConverter(new IConverter() {
                    @Override
                    public Object getToType() {
                        return Boolean.class;
                    }

                    @Override
                    public Object getFromType() {
                        return ReferenceType.class;
                    }

                    @Override
                    public Object convert(Object fromObject) {
                        ReferenceType referenceType = (ReferenceType) fromObject;
                        return referenceType == ReferenceType.FGA_MESSAGE_CONST;
                    }
                }), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));
        // then to model object
        dbc.bindValue(comboSelection, //
                referenceObservable//
        );
        return comboSelection;
    }

    public static Attribute editSymbol(Attribute symbol, Shell shell, IModelProvider<Module> modelProvider,
            EditMode editMode) {

        SymbolEditorDialog dlg = new SymbolEditorDialog(shell);
        dlg.setModel(symbol);
        dlg.setEditMode(editMode);
        dlg.setEditingDomain(modelProvider.getEditingDomain());
        dlg.setDataBindingContext(modelProvider.getDataBindingContext());
        dlg.setModule(modelProvider.getModel());
        if (editMode == EditMode.NEW) {
            if (StringUtils.isEmpty(symbol.getName())) {
                // symbol.setName("[new Symbolname]"); MC
                symbol.setName("");
            }
        }
        if (symbol instanceof ConstantAttribute) {
            ConstantAttribute constantAttribute = (ConstantAttribute) symbol;
            dlg.setEditedType(EditedType.CONSTANT);
            dlg.setDialogTitle("Konstante");
            if (editMode == EditMode.NEW) {
                constantAttribute.setDataType(editingHistory.lastEditedConstant);
                switch (constantAttribute.getDataType()) {
                case WORD:
                    constantAttribute.setValue(ModuleFactory.eINSTANCE.createWordValue());
                    break;
                case FLOAT:
                    constantAttribute.setValue(ModuleFactory.eINSTANCE.createFloatValue());
                    break;

                default:
                    break;
                }

            }
        } else if (symbol instanceof ReferenceAttribute) {
            dlg.setEditedType(EditedType.REFERENCE);
            dlg.setDialogTitle("Referenz");
            Command setCommand = SetCommand.create(modelProvider.getEditingDomain(), symbol,
                    ModulePackage.Literals.ATTRIBUTE__DATA_TYPE, DataType.REFERENCE);
            modelProvider.getEditingDomain().getCommandStack().execute(setCommand);
        } else if (symbol instanceof VariableAttribute) {
            dlg.setDialogTitle("Variable");
            dlg.setEditedType(EditedType.VARIABLE);
            if (editMode == EditMode.NEW) {
                dlg.enableSerials();
                VariableAttribute variableAttribute = (VariableAttribute) symbol;
                variableAttribute.setDataType(editingHistory.lastEditedVariable);
            }
        } else {
            dlg.setDialogTitle("Attribut");
        }

        if (IDialogConstants.OK_ID == dlg.open()) {
            // attribute = ModuleFactory.eINSTANCE.createVariableAttribute();
            String newName = symbol.getName();
            EditingDomain editingDomain = modelProvider.getEditingDomain();
            if (dlg.getSerialCount() > 0) {
                // Serials of variables
                CompoundCommand command = new CompoundCommand();
                VariableAttribute variableAttribute = (VariableAttribute) symbol;
                for (int i = 0; i < dlg.getSerialCount(); i++) {
                    VariableAttribute attribute = ModuleFactory.eINSTANCE.createVariableAttribute();
                    attribute.setDataType(variableAttribute.getDataType());
                    attribute.setName(String.format("%s%02d", newName, i));
                    command.append(AddCommand.create(editingDomain, modelProvider.getModel(),
                            ModulePackage.Literals.MODULE__ATTRIBUTES, attribute));
                }
                editingDomain.getCommandStack().execute(command);
            } else {
                Command create = AddCommand.create(editingDomain, modelProvider.getModel(),
                        ModulePackage.Literals.MODULE__ATTRIBUTES, symbol);
                editingDomain.getCommandStack().execute(create);
            }
            return symbol;
        }
        return null;
    }

    private void enableSerials() {
        this.serialsEnabled = true;

    }

    public EditedType getEditedType() {
        return editedType;
    }

    public void setEditedType(EditedType editedType) {
        this.editedType = editedType;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    protected int getSerialCount() {
        return this.serialCount.getValue().intValue();
    }
}
