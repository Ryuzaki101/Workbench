package de.wisag.automation.micas.module.ui.forms;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.ObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.ComputedValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.edit.EMFEditProperties;
import org.eclipse.emf.databinding.edit.IEMFEditListProperty;
import org.eclipse.emf.edit.command.AddCommand;
import org.eclipse.emf.edit.command.DeleteCommand;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import de.wisag.automation.micas.common.ui.SelectionUtils;
import de.wisag.automation.micas.common.ui.databinding.GenericMapCellLabelProvider;
import de.wisag.automation.micas.diagram.ui.util.EditorUtil;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.ConstantAttribute;
import de.wisag.automation.micas.module.DataType;
import de.wisag.automation.micas.module.FloatValue;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModuleFactory;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.ReferenceAttribute;
import de.wisag.automation.micas.module.VariableAttribute;
import de.wisag.automation.micas.module.WordValue;
import de.wisag.automation.micas.module.ui.dialogs.EditMode;
import de.wisag.automation.micas.module.ui.dialogs.SymbolEditorDialog;
import de.wisag.automation.micas.module.ui.editor.StatusHelper;
import de.wisag.automation.micas.module.ui.internal.ModelUtils;
import de.wisag.automation.micas.module.ui.symbolimporter.ImportSymbol;
import de.wisag.automation.micas.module.ui.symbolimporter.SymbolImporterDialog;
import de.wisag.automation.micas.module.util.ModuleAnalytics;
import de.wisag.automation.micas.module.util.ModuleUtil;

public class SymbolsPageController extends PageController<Module>
        implements IController, IAttributeSpecificationProvider {

    private static final String DEFAULT_SEARCH_TEXT = "[Enter Symbol Name]";
    private final SymbolsPage symbolesPage;
    private WritableList<Attribute> selectedSymbols;
    private TableViewer symbolsViewer;
    private WritableValue<String> searchText;

    public SymbolsPageController(SymbolsPage symbolesPage) {
        this.symbolesPage = symbolesPage;

    }

    @Override
    public void bind() {
        searchText = new WritableValue<>(getDataBindingContext().getValidationRealm());
        searchText.setValue(DEFAULT_SEARCH_TEXT);
        searchText.addValueChangeListener(e -> {
            String val = e.getObservableValue().getValue();
            if (DEFAULT_SEARCH_TEXT.equals(val)) {
                // ignore
            } else {
                symbolsViewer.refresh();
                Object first = symbolsViewer.getElementAt(0);
                if (first != null) {
                    symbolsViewer.setSelection(new StructuredSelection(first), true);
                }
            }
        });

        getSymbolesPage().getBtnResetFilter().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                searchText.setValue(DEFAULT_SEARCH_TEXT);
                symbolsViewer.refresh();
            }
        });
        ISWTObservableValue observeSearchText = WidgetProperties.text(SWT.Modify)
                .observe(getSymbolesPage().getTxtSymbolFilter());
        getDataBindingContext().bindValue(observeSearchText, searchText);
        addSelectOnFocusToText(getSymbolesPage().getTxtSymbolFilter());

        selectedSymbols = new WritableList<>(getDataBindingContext().getValidationRealm());
        new WritableValue<>(getDataBindingContext().getValidationRealm());
        symbolsViewer = new TableViewer(getSymbolesPage().getTblSymbols());
        symbolsViewer.setUseHashlookup(true);
        symbolsViewer.addFilter(new ViewerFilter() {

            @Override
            public boolean select(Viewer arg0, Object a1, Object a) {
                String currentSearchValue = searchText.getValue();
                if (DEFAULT_SEARCH_TEXT.equals(currentSearchValue)) {
                    return true;
                }
                String name = ((Attribute) a).getName();
                return StringUtils.containsIgnoreCase(name, currentSearchValue);
            }
        });

        symbolsViewer.setComparator(new ViewerComparator() {
            @Override
            public int compare(Viewer viewer, Object e1, Object e2) {
                String n1 = ((Attribute) e1).getName();
                String n2 = ((Attribute) e1).getName();
                return String.CASE_INSENSITIVE_ORDER.compare(n1, n2);
            }
        });
        getDataBindingContext().bindList(ViewerProperties.multipleSelection().observe(symbolsViewer), selectedSymbols);
        IEMFEditListProperty attributes = EMFEditProperties.list(getModelProvider().getEditingDomain(),
                ModulePackage.Literals.MODULE__ATTRIBUTES);
        ObservableListContentProvider cp = new ObservableListContentProvider();
        {
            TableViewerColumn column = new TableViewerColumn(symbolsViewer, getSymbolesPage().getTcType());
            column.setLabelProvider(new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    Attribute attribute = (Attribute) element;
                    String text = "";
                    if (attribute instanceof ReferenceAttribute) {
                        ReferenceAttribute referenceAttribute = (ReferenceAttribute) attribute;
                        switch (referenceAttribute.getReferenceType()) {
                        case FGA_ANALOG_VALUE:
                            text = "AW";
                            break;
                        case FGA_MEASURED_VALUE:
                            text = "MW";
                            break;

                        case FGA_MESSAGE_CONST:
                            text = "MB";
                            break;

                        case FGA_VALUE:
                            text = "ZW";
                            break;
                        default:
                            break;
                        }
                    } else if (attribute instanceof VariableAttribute) {
                        switch (attribute.getDataType()) {
                        case FLOAT:
                            text = "FV";
                            break;
                        case WORD:
                            text = "WV";
                            break;
                        default:
                            text = "UNKNOWN";
                            break;
                        }

                    } else if (attribute instanceof ConstantAttribute) {
                        switch (attribute.getDataType()) {
                        case FLOAT:
                            text = "FC";
                            break;
                        case WORD:
                            text = "WC";
                            break;
                        default:
                            text = "UNKNOWN";
                            break;
                        }
                    }
                    return text;
                }
            });
            new ColumnViewerSorter(symbolsViewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Attribute a1 = (Attribute) e1;
                    Attribute a2 = (Attribute) e2;
                    return a1.getDataType().compareTo(a2.getDataType());
                }
            };
        }
        ColumnViewerSorter defaultSortColumn = null;
        {
            IObservableMap[] attributeMap = new IObservableMap[1];
            attributeMap[0] = EMFEditProperties
                    .value(getModelProvider().getEditingDomain(), ModulePackage.Literals.ATTRIBUTE__NAME)
                    .observeDetail(cp.getKnownElements());

            TableViewerColumn column = new TableViewerColumn(symbolsViewer, getSymbolesPage().getTcSymbolName());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0}", attributeMap));
            defaultSortColumn = new ColumnViewerSorter(symbolsViewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Attribute a1 = (Attribute) e1;
                    Attribute a2 = (Attribute) e2;
                    if (a1.getName() == null || a2.getName() == null) {
                        return Integer.MIN_VALUE;
                    }
                    return String.CASE_INSENSITIVE_ORDER.compare(a1.getName(), a2.getName());
                }
            };
        }
        {

            TableViewerColumn column = new TableViewerColumn(symbolsViewer, getSymbolesPage().getTcSymbolDataType());
            column.setLabelProvider(new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    if (element instanceof ReferenceAttribute) {
                        ReferenceAttribute attribute = (ReferenceAttribute) element;
                        return "Reference (" + ModelUtils.referenceTypeToDisplayName(attribute.getReferenceType())
                                + ")";
                    }
                    Attribute attribute = (Attribute) element;
                    return attribute.getDataType().getLiteral();
                }
            });
            new ColumnViewerSorter(symbolsViewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Attribute a1 = (Attribute) e1;
                    Attribute a2 = (Attribute) e2;
                    return a1.getDataType().compareTo(a2.getDataType());
                }
            };
        }
        {
            TableViewerColumn column = new TableViewerColumn(symbolsViewer, getSymbolesPage().getTcSymbolValue());
            column.setLabelProvider(new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    String text = "";
                    if (element instanceof ConstantAttribute) {
                        ConstantAttribute attribute = (ConstantAttribute) element;
                        switch (attribute.getDataType()) {
                        case WORD:
                            text = attribute.getValue() != null ? ((WordValue) attribute.getValue()).getValue() + ""
                                    : "";
                            break;
                        case FLOAT:
                            text = attribute.getValue() != null ? ((FloatValue) attribute.getValue()).getValue() + ""
                                    : "";
                            break;

                        default:
                            break;
                        }
                        return text;
                    }

                    return text;
                }
            });
        }
        {
            IObservableMap[] attributeMap = new IObservableMap[1];
            attributeMap[0] = EMFEditProperties
                    .value(getModelProvider().getEditingDomain(),
                            FeaturePath.fromList(ModulePackage.Literals.REFERENCE_ATTRIBUTE__ROW))
                    .observeDetail(cp.getKnownElements());

            TableViewerColumn column = new TableViewerColumn(symbolsViewer,
                    getSymbolesPage().getTcSymbolReferenceRow());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0}", attributeMap));
        }

        {
            IObservableMap[] attributeMap = new IObservableMap[1];
            attributeMap[0] = EMFEditProperties
                    .value(getModelProvider().getEditingDomain(),
                            FeaturePath.fromList(ModulePackage.Literals.REFERENCE_ATTRIBUTE__COLUMN))
                    .observeDetail(cp.getKnownElements());

            TableViewerColumn column = new TableViewerColumn(symbolsViewer,
                    getSymbolesPage().getTcSymbolReferenceColumn());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0}", attributeMap));
        }
        {
            IObservableMap[] attributeMap = new IObservableMap[1];
            attributeMap[0] = EMFEditProperties
                    .value(getModelProvider().getEditingDomain(),
                            FeaturePath.fromList(ModulePackage.Literals.ATTRIBUTE__DESCRIPTION))
                    .observeDetail(cp.getKnownElements());

            TableViewerColumn column = new TableViewerColumn(symbolsViewer, getSymbolesPage().getTcSymbolDescription());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0}", attributeMap) {
                @Override
                protected String format(Object... values) {
                    // hack to prevent the viewer showing '""'
                    Object[] values2 = null;
                    if (values != null) {
                        values2 = Arrays.copyOf(values, values.length);
                        for (int i = 0; i < values2.length; i++) {
                            Object value = values2[i];
                            if (value != null && value instanceof String) {
                                String sValue = (String) value;
                                if ("\"\"".equals(sValue)) {
                                    values2[i] = "";
                                }
                            }

                        }
                    }
                    return super.format(values2);
                }
            });
            new ColumnViewerSorter(symbolsViewer, column) {

                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    Attribute a1 = (Attribute) e1;
                    Attribute a2 = (Attribute) e2;
                    if (a1.getDescription() == null || a2.getDescription() == null) {
                        return Integer.MIN_VALUE;
                    }
                    return String.CASE_INSENSITIVE_ORDER.compare(a1.getDescription(), a2.getDescription());
                }
            };
        }

        defaultSortColumn.setSorter(defaultSortColumn, ColumnViewerSorter.ASC);
        symbolsViewer.setContentProvider(cp);
        symbolsViewer.setInput(attributes.observe(getModelProvider().getModel()));
        createSymbolsViewerActions(symbolsViewer);

        bindButtons(symbolsViewer);
        symbolsViewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {
                Attribute attribute = SelectionUtils.singleSelection(Attribute.class, event.getSelection());
                if (attribute == null) {
                    return;
                }
                editAttribute(event.getViewer().getControl().getShell(), attribute);

            }
        });
        SymbolActionsProvider actionsProvider = new SymbolActionsProvider(getModelProvider(),
                new SymbolActionsProvider.PostActionCallback<Attribute>() {
                    @Override
                    public void perform(Attribute attribute) {
                        symbolsViewer.setSelection(new StructuredSelection(attribute), true);

                    }
                });
        actionsProvider.provideActionsFor(getSymbolesPage().getBtnNewSymbol());

        StatusHelper.addStatusSupport(getDataBindingContext(), getSymbolesPage().getManagedForm().getForm().getForm());
        createUsedSymbolsViewer(selectedSymbols);
        getDataBindingContext().updateTargets();

        getSymbolesPage().getBtnCleanSymbols().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Control control = (Control) e.widget;
                if (MessageDialog.openConfirm(control.getShell(), "Symbole entfernen",
                        "Wollen Sie wirklich alle ungenutzen Symbole entfernen ?")) {
                    deleteAttributes(ModuleAnalytics.getUnusedAttributes(getModelProvider().getModel()));
                }
            }
        });

    }

    private void createUsedSymbolsViewer(ObservableList<Attribute> selectedSymbols) {
        ObservableListContentProvider usedSymbolsViewerContentProvider = new ObservableListContentProvider();
        TableViewer usedSymbolsViewer = new TableViewer(getSymbolesPage().getTblSymbolUsage());
        usedSymbolsViewer.setContentProvider(usedSymbolsViewerContentProvider);
        {
            IObservableMap[] attributeMap = new IObservableMap[1];
            attributeMap[0] = PojoProperties.value("specification.attribute.name")
                    .observeDetail(usedSymbolsViewerContentProvider.getKnownElements());
            TableViewerColumn column = new TableViewerColumn(usedSymbolsViewer, getSymbolesPage().getTcRefSymbolName());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0}", attributeMap));
        }
        {
            IObservableMap[] attributeMap = new IObservableMap[1];
            attributeMap[0] = PojoProperties.value("page.name")
                    .observeDetail(usedSymbolsViewerContentProvider.getKnownElements());
            TableViewerColumn column = new TableViewerColumn(usedSymbolsViewer, getSymbolesPage().getTcRefPageName());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0}", attributeMap));
        }
        {
            IObservableMap[] attributeMap = new IObservableMap[3];
            attributeMap[0] = PojoProperties.value("task.name")
                    .observeDetail(usedSymbolsViewerContentProvider.getKnownElements());
            attributeMap[1] = PojoProperties.value("task.kind")
                    .observeDetail(usedSymbolsViewerContentProvider.getKnownElements());
            attributeMap[2] = PojoProperties.value("task.cycleTime")
                    .observeDetail(usedSymbolsViewerContentProvider.getKnownElements());
            TableViewerColumn column = new TableViewerColumn(usedSymbolsViewer, getSymbolesPage().getTcRefTaskName());
            column.setLabelProvider(new GenericMapCellLabelProvider("{0} : Kind: {1}, CycleTime : {2}", attributeMap));
        }
        //
        @SuppressWarnings("unchecked")
        List<Object> usedSymbolsContent = new WritableList();
        usedSymbolsViewer.setInput(usedSymbolsContent);
        selectedSymbols.addListChangeListener(new UsedSymbolsViewerUpdater(this, usedSymbolsContent));
        usedSymbolsViewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {
                AttributeSpecificationLocation specificationLocation = SelectionUtils
                        .singleSelection(AttributeSpecificationLocation.class, event.getSelection());
                if (specificationLocation == null || specificationLocation.getPage() == null) {
                    return;
                }
                EditorUtil.openPageEditor(specificationLocation.getPage());
            }
        });
    }

    class ListNotEmptyValue extends ComputedValue {
        private final IObservableList list;

        ListNotEmptyValue(IObservableList list) {
            super();
            this.list = list;
        }

        @Override
        protected Object calculate() {
            return this.list.isEmpty() ? Boolean.FALSE : Boolean.TRUE;
        }

    }

    class ListNotEmptyAndNoAttributeIsReferencedValue extends ComputedValue<Boolean> {
        private final IObservableList<Attribute> list;

        ListNotEmptyAndNoAttributeIsReferencedValue(IObservableList<Attribute> list) {
            super();
            this.list = list;
        }

        @Override
        protected Boolean calculate() {
            if (this.list.isEmpty()) {
                return Boolean.FALSE;
            }

            final Attribute[] attributes = this.list.toArray(new Attribute[this.list.size()]);

            return Boolean.valueOf(!ModuleUtil.haveReferences(attributes));
        }

    }

    class ListOneElementValue extends ComputedValue<Boolean> {
        private final IObservableList list;

        ListOneElementValue(IObservableList list) {
            super();
            this.list = list;
        }

        @Override
        protected Boolean calculate() {
            return this.list.size() == 1 ? Boolean.TRUE : Boolean.FALSE;
        }

    }

    private void bindButtons(TableViewer symbolsViewer) {
        final Shell shell = symbolsViewer.getControl().getShell();
        getDataBindingContext().bindValue(WidgetProperties.enabled().observe(getSymbolesPage().getBtnEditSymbol()),
                new ListOneElementValue(selectedSymbols), new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy()/*
                                          * .setConverter(new
                                          * SelectionToBooleanConverter())
                                          */
        );
        getSymbolesPage().getBtnEditSymbol().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                Attribute attribute = selectedSymbols.get(0);
                editAttribute(shell, attribute);

            }
        });

        getDataBindingContext().bindValue(WidgetProperties.enabled().observe(getSymbolesPage().getBtnDeleteSymbol()),
                new ListNotEmptyAndNoAttributeIsReferencedValue(selectedSymbols),
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER), new UpdateValueStrategy());
        getSymbolesPage().getBtnDeleteSymbol().addSelectionListener(new SelectionAdapter() {
            @SuppressWarnings("unchecked")
            @Override
            public void widgetSelected(SelectionEvent e) {
                deleteAttributes(ImmutableList.copyOf(selectedSymbols));
            }
        });
        getSymbolesPage().getBtnImportSymbols().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                importSymbols();
            }
        });

    }

    /**
     * This method adds select-on-focus functionality to a {@link Text}
     * component. Specific behavior: - when the Text is already focused ->
     * normal behavior - when the Text is not focused: -> focus by keyboard ->
     * select all text -> focus by mouse click -> select all text unless user
     * manually selects text
     *
     * @param text
     */
    public static void addSelectOnFocusToText(Text text) {
        Listener listener = new Listener() {

            private boolean hasFocus = false;
            private boolean hadFocusOnMousedown = false;

            @Override
            public void handleEvent(Event e) {
                switch (e.type) {
                case SWT.FocusIn: {
                    Text t = (Text) e.widget;

                    // Covers the case where the user focuses by keyboard.
                    t.selectAll();

                    // The case where the user focuses by mouse click is special
                    // because Eclipse,
                    // for some reason, fires SWT.FocusIn before SWT.MouseDown,
                    // and on mouse down
                    // it cancels the selection. So we set a variable to keep
                    // track of whether the
                    // control is focused (can't rely on isFocusControl()
                    // because sometimes it's wrong),
                    // and we make it asynchronous so it will get set AFTER
                    // SWT.MouseDown is fired.
                    t.getDisplay().asyncExec(new Runnable() {
                        @Override
                        public void run() {
                            hasFocus = true;
                        }
                    });

                    break;
                }
                case SWT.FocusOut: {
                    hasFocus = false;
                    ((Text) e.widget).clearSelection();

                    break;
                }
                case SWT.MouseDown: {
                    // Set the variable which is used in SWT.MouseUp.
                    hadFocusOnMousedown = hasFocus;

                    break;
                }
                case SWT.MouseUp: {
                    Text t = (Text) e.widget;
                    if (t.getSelectionCount() == 0 && !hadFocusOnMousedown) {
                        ((Text) e.widget).selectAll();
                    }

                    break;
                }
                }
            }

        };

        text.addListener(SWT.FocusIn, listener);
        text.addListener(SWT.FocusOut, listener);
        text.addListener(SWT.MouseDown, listener);
        text.addListener(SWT.MouseUp, listener);
    }

    protected void importSymbols() {
        SymbolImporterDialog dlg = new SymbolImporterDialog(getSymbolesPage().getSite().getShell());
        if (IDialogConstants.OK_ID == dlg.open()) {

            final List<ImportSymbol> newSymbols = dlg.getSymbols();
            merge(newSymbols);
        }
    }

    private void merge(final List<ImportSymbol> newSymbols) {
        final Map<String, ImportSymbol> importedSymbols = new HashMap<>();
        for (ImportSymbol importSymbol : newSymbols) {
            importedSymbols.put(importSymbol.getSymbolName(), importSymbol);
        }

        final Map<String, Attribute> currentSymbols = new HashMap<>();
        for (Attribute attr : getModelProvider().getModel().getAttributes()) {
            if (attr.getDataType() == DataType.REFERENCE) {
                currentSymbols.put(attr.getName(), attr);
            }
        }

        final Set<String> toAdd = Sets.difference(importedSymbols.keySet(), currentSymbols.keySet());
        for (String name : toAdd) {
            addSymbol(importedSymbols.get(name));
        }

        final Set<String> toDelete = Sets.difference(currentSymbols.keySet(), importedSymbols.keySet());
        final EditingDomain editingDomain = getModelProvider().getEditingDomain();
        for (String name : toDelete) {
            Attribute a = currentSymbols.get(name);
            Command create = DeleteCommand.create(editingDomain, a);
            editingDomain.getCommandStack().execute(create);
        }
        final Set<String> toModify = Sets.intersection(importedSymbols.keySet(), currentSymbols.keySet());
        for (String name : toModify) {
            ImportSymbol symbol = importedSymbols.get(name);
            ReferenceAttribute a = (ReferenceAttribute) currentSymbols.get(name);
            Set<Command> commands = new HashSet<>();
            if (!ObjectUtils.equals(a.getColumn(), symbol.getCol())) {
                Command modify = SetCommand.create(editingDomain, a, ModulePackage.Literals.REFERENCE_ATTRIBUTE__COLUMN,
                        symbol.getCol());
                commands.add(modify);
            }
            if (!ObjectUtils.equals(a.getRow(), symbol.getRow())) {
                Command modify = SetCommand.create(editingDomain, a, ModulePackage.Literals.REFERENCE_ATTRIBUTE__ROW,
                        symbol.getRow());
                commands.add(modify);
            }
            if (!ObjectUtils.equals(a.getReferenceType(), symbol.getReferenceType())) {
                Command modify = SetCommand.create(editingDomain, a,
                        ModulePackage.Literals.REFERENCE_ATTRIBUTE__REFERENCE_TYPE, symbol.getRawReferenceType());
                commands.add(modify);
            }
            // TODO : merge symbol description too

            for (Command command : commands) {
                editingDomain.getCommandStack().execute(command);
            }

        }
    }

    private void addSymbol(ImportSymbol importSymbol) {
        EditingDomain editingDomain = getModelProvider().getEditingDomain();
        ReferenceAttribute attribute = ModuleFactory.eINSTANCE.createReferenceAttribute();
        setValues(importSymbol, attribute);
        Command create = AddCommand.create(editingDomain, getModelProvider().getModel(),
                ModulePackage.Literals.MODULE__ATTRIBUTES, attribute);
        editingDomain.getCommandStack().execute(create);
    }

    private void setValues(ImportSymbol importSymbol, ReferenceAttribute attribute) {
        attribute.setColumn(importSymbol.getCol());
        attribute.setRow(importSymbol.getRow());
        attribute.setReferenceType(importSymbol.getReferenceType());
        attribute.setDataType(DataType.REFERENCE);
        attribute.setName(importSymbol.getSymbolName());
        attribute.setDescription(importSymbol.getDescription());
    }

    private void createSymbolsViewerActions(final TableViewer taskviewer) {
        final Shell shell = taskviewer.getControl().getShell();
        MenuManager mm = new MenuManager();
        mm.setRemoveAllWhenShown(true);
        mm.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                manager.add(new Action("Editieren") {
                    @Override
                    public void run() {
                        Attribute[] attribute = SelectionUtils.multiSelection(Attribute.class,
                                taskviewer.getSelection());
                        editAttribute(shell, attribute[0]);
                    }

                    @Override
                    public String getText() {
                        return "Bearbeiten";
                    }

                    @Override
                    public boolean isEnabled() {

                        return taskviewer.getSelection() != null && SelectionUtils.multiSelection(Attribute.class,
                                taskviewer.getSelection()).length == 1;
                    }

                });
                manager.add(new Action("Löschen") {
                    @Override
                    public void run() {
                        Attribute[] attribute = SelectionUtils.multiSelection(Attribute.class,
                                taskviewer.getSelection());
                        deleteAttributes(Arrays.asList(attribute));
                    }

                    @Override
                    public String getText() {
                        return "Löschen";
                    }

                    @Override
                    public boolean isEnabled() {

                        boolean haveSelection = taskviewer.getSelection() != null;
                        Attribute[] selectedAttributes = SelectionUtils.multiSelection(Attribute.class,
                                taskviewer.getSelection());
                        boolean haveReferences = ModuleUtil.haveReferences(selectedAttributes);
                        boolean selectionNotEmpty = selectedAttributes.length > 0;

                        return haveSelection && selectionNotEmpty && !haveReferences;
                    }

                });
            }
        });
        taskviewer.getTable().setMenu(mm.createContextMenu(taskviewer.getControl()));

    }

    private void editAttribute(Shell shell, Attribute attribute) {
        if (attribute == null) {
            return;
        }
        SymbolEditorDialog.editSymbol(attribute, shell, getModelProvider(), EditMode.MODIFY);
        this.symbolsViewer.update(attribute, null);
        this.symbolsViewer.setSelection(new StructuredSelection(attribute), true);
    }

    private void deleteAttributes(Collection<Attribute> attributes) {
        int index = ModuleUtil.removeAttributes(getModelProvider().getEditingDomain(), attributes);
        this.symbolsViewer.refresh();
        if (index > -1 && getModelProvider().getModel().getAttributes().size() > index) {
            Attribute element = getModelProvider().getModel().getAttributes().get(index);
            symbolsViewer.setSelection(new StructuredSelection(element), true);
        }

    }

    public SymbolsPage getSymbolesPage() {
        return symbolesPage;
    }

    @Override
    public Multimap<Attribute, AttributeSpecification> getAllAttributeSpecificationsByAttributes() {
        return ModuleUtil.getAllAttributeSpecifications2(getModelProvider().getModel());
    }

}
