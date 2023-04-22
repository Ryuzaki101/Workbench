package de.wisag.automation.micas.diagram.ui.properties;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.util.StringStatics;
import org.eclipse.gmf.runtime.common.ui.util.StatusLineUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.properties.sections.AbstractModelerPropertySection;
import org.eclipse.gmf.runtime.diagram.ui.properties.views.TextChangeHelper;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.viewers.ViewerProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.eclipselabs.damos.dml.Argument;
import org.eclipselabs.damos.dml.Block;
import org.eclipselabs.damos.dml.DMLFactory;
import org.eclipselabs.damos.dml.ExpressionSpecification;

import de.wisag.automation.micas.diagram.ui.Activator;
import de.wisag.automation.micas.module.util.ModuleUtil;
import de.wisag.automation.micas.module.util.Row;

public class FKGParameterPropertySection extends AbstractModelerPropertySection {

    private static final String PROP_INDEX = "index";

    private Composite container;

    final List<Row> tableModel = new ArrayList<>();
    private TableViewer tableViewer;
    private Text indexText;
    private WritableValue<Row> viewerSelection;

    private TextChangeHelper listener = new TextChangeHelper() {
        boolean textModified = false;

        /**
         * @see org.eclipse.swt.widgets.Listener#handleEvent(org.eclipse.swt.widgets.Event)
         */
        @Override
        public void handleEvent(Event event) {
            if (event.type == SWT.KeyDown) {
                textModified = true;
            }
            super.handleEvent(event);
        }

        @Override
        public void textChanged(Control control) {
            if (textModified) {
                IWorkbenchPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
                        .getActivePart();
                StatusLineUtil.outputErrorMessage(part, StringStatics.BLANK);
                updateIndexPropertyValue();
                textModified = false;
            }
        }

    };

    private void updateIndexPropertyValue() {
        int i = -1;
        try {
            i = Integer.parseInt(indexText.getText());
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return;
        }
        IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
        if (editPart != null) {
            EObject element = editPart.resolveSemanticElement();
            if (element instanceof Block) {
                Block block = (Block) element;
                setArgumentValue(block, PROP_INDEX, String.valueOf(i));
            }
        }

    }

    @Override
    public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
        super.createControls(parent, aTabbedPropertySheetPage);
        viewerSelection = new WritableValue<>(DisplayRealm.getRealm(parent.getDisplay()));
        container = getWidgetFactory().createPlainComposite(parent, SWT.NONE);
        GridLayoutFactory.swtDefaults().numColumns(2).applyTo(container);
        Label indexLabel = getWidgetFactory().createLabel(container, "Index:");
        GridDataFactory.swtDefaults().applyTo(indexLabel);
        indexText = getWidgetFactory().createText(container, "");
        GridDataFactory.swtDefaults().align(SWT.FILL, SWT.CENTER).grab(true, false).applyTo(indexText);

        Composite tablecontainer = getWidgetFactory().createFlatFormComposite(container);
        Table table = getWidgetFactory().createTable(tablecontainer, SWT.BORDER);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        tableViewer = new TableViewer(table);
        TableColumnLayout tableColumnLayout = new TableColumnLayout();
        {
            TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.LEFT);
            tvc.getColumn().setText("X-Wert");
            tvc.setLabelProvider(new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    Row row = (Row) element;
                    return String.valueOf(row.getX());
                }
            });
            tableColumnLayout.setColumnData(tvc.getColumn(), new ColumnWeightData(50));
        }

        {
            TableViewerColumn tvc = new TableViewerColumn(tableViewer, SWT.LEFT);
            tvc.getColumn().setText("Y-Wert");
            tvc.setLabelProvider(new ColumnLabelProvider() {
                @Override
                public String getText(Object element) {
                    Row row = (Row) element;
                    return String.valueOf(row.getY());
                }
            });
            tableColumnLayout.setColumnData(tvc.getColumn(), new ColumnWeightData(50));
        }
        tablecontainer.setLayout(tableColumnLayout);
        tableViewer.setContentProvider(new ArrayContentProvider());
        GridDataFactory.fillDefaults().span(2, 1).grab(false, true).applyTo(tablecontainer);
        tableViewer.setInput(tableModel);

        DataBindingContext ctx = new DataBindingContext();
        ctx.bindValue(ViewerProperties.singleSelection().observe(tableViewer), this.viewerSelection);

        MenuManager manager = new MenuManager();
        manager.setRemoveAllWhenShown(true);
        manager.addMenuListener(new IMenuListener() {

            @Override
            public void menuAboutToShow(IMenuManager manager) {
                manager.add(new Action("Add  XY-Pair") {
                    @Override
                    public void run() {
                        FKGPairDialog dlg = new FKGPairDialog(getPart().getSite().getShell());
                        dlg.setRow(new Row(0, 0));
                        if (IDialogConstants.OK_ID == dlg.open()) {
                            getTableModel().add(dlg.getRow());
                            getTableViewer().refresh();
                            updateModel();
                        }

                    }

                });
                manager.add(new Action("Edit XY-Pair") {
                    @Override
                    public void run() {
                        editRow();

                    }

                    @Override
                    public boolean isEnabled() {

                        return viewerSelection.getValue() != null;
                    }
                });
                manager.add(new Action("Delete XY-Pair") {
                    @Override
                    public void run() {
                        Row row = viewerSelection.getValue();
                        getTableModel().remove(row);
                        getTableViewer().refresh();
                        updateModel();
                    };

                    @Override
                    public boolean isEnabled() {

                        return viewerSelection.getValue() != null;
                    }
                });
            }
        });
        tableViewer.getControl().setMenu(manager.createContextMenu(tableViewer.getControl()));
        tableViewer.addDoubleClickListener(new IDoubleClickListener() {

            @Override
            public void doubleClick(DoubleClickEvent event) {
                editRow();
            }
        });
        listener.startListeningTo(indexText);
        listener.startListeningForEnter(indexText);
    }

    void updateModel() {
        IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
        if (editPart != null) {
            EObject element = editPart.resolveSemanticElement();
            if (element instanceof Block) {
                Block block = (Block) element;
                applySupportingPoints(block, tableModel);
            }
        }
    }

    /**
     * @see org.eclipse.ui.views.properties.tabbed.ISection#shouldUseExtraSpace()
     */
    @Override
    public boolean shouldUseExtraSpace() {
        return true;
    }

    @Override
    public void refresh() {
        IGraphicalEditPart editPart = (IGraphicalEditPart) getPrimarySelection();
        if (editPart != null) {
            EObject element = editPart.resolveSemanticElement();
            if (element instanceof Block) {
                Block block = (Block) element;

                String expr = ModuleUtil.getArgumentValue(block, PROP_INDEX);
                Integer index = Integer.valueOf(Integer.MIN_VALUE);
                try {
                    index = Integer.valueOf(expr);
                    indexText.setText("" + index);
                } catch (NumberFormatException e) {
                    /* ignore */}
                tableModel.clear();
                tableModel.addAll(ModuleUtil.parseSupportingPoints(block));
                getTableViewer().refresh();
            }

        }

    }

    void applySupportingPoints(Block block, List<Row> rows) {
        StringBuilder sb = new StringBuilder();
        Row[] rowArray = rows.toArray(new Row[rows.size()]);
        for (int j = 0; j < rowArray.length; j++) {
            Row row = rowArray[j];
            if (j > 0) {
                sb.append(';');
            }
            sb.append(Double.toString(row.getX()));
            sb.append('#');
            sb.append(Double.toString(row.getY()));
        }
        setArgumentValue(block, ModuleUtil.FKG_PROP_SUPPORINGPOINTS, sb.toString());
    }

    static void executeOperation(IUndoableOperation operation) {
        IOperationHistory history = OperationHistoryFactory.getOperationHistory();
        try {
            IStatus status = history.execute(operation, new NullProgressMonitor(), null);
            if (!status.isOK()) {
                Activator.getDefault().getLog().log(status);
            }
        } catch (ExecutionException e) {
            Activator.getDefault().getLog()
                    .log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Operation execution failed", e));
        }
    }

    static void setArgumentValue(Block block, String parameterName, String value) {
        Argument parameterArgument = block.getArgument(parameterName);
        ExpressionSpecification expressionSpec = DMLFactory.eINSTANCE.createExpressionSpecification();
        expressionSpec.setExpression(value);
        executeOperation(new SetArgumentValueCommand(parameterArgument, expressionSpec));
    }

    public TableViewer getTableViewer() {
        return tableViewer;
    }

    public List<Row> getTableModel() {
        return tableModel;
    }

    private void editRow() {
        Row row = viewerSelection.getValue();
        if (row == null) {
            return;
        }
        FKGPairDialog dlg = new FKGPairDialog(getPart().getSite().getShell());
        dlg.setRow(row);
        if (IDialogConstants.OK_ID == dlg.open()) {
            getTableViewer().refresh();
            updateModel();
        }
    }

    @Override
    public void dispose() {
        listener.stopListeningTo(indexText);
        super.dispose();
    }

}
