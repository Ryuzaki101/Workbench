package de.wisag.automation.micas.module.ui.symbolimporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.IBeanValueProperty;
import org.eclipse.core.databinding.beans.PojoProperties;
import org.eclipse.core.databinding.observable.list.WritableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapCellLabelProvider;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.dialogs.FilteredResourcesSelectionDialog;

import de.wisag.automation.micas.module.ReferenceType;
import de.wisag.automation.micas.module.ui.forms.ColumnViewerSorter;
import de.wisag.automation.micas.module.ui.forms.patched.WisagTableColumnLayout;
import de.wisag.automation.micas.module.ui.internal.Activator;
import de.wisag.automation.micas.module.ui.internal.Policy;

public class SymbolImporterDialog extends TitleAreaDialog {

    public SymbolImporterDialog(Shell parentShell) {
        super(parentShell);
    }

    private WritableValue<String> selectedSourceFile;
    private WritableList<ImportSymbol> tableContent;
    private TableViewer rowsTableViewer;

    @Override
    protected Control createDialogArea(Composite parent) {
        SymbolImporterDialogPage page = new SymbolImporterDialogPage(parent, SWT.NONE);
        bind(page, new DataBindingContext(DisplayRealm.getRealm(page.getDisplay())));
        GridDataFactory.fillDefaults().grab(true, true).applyTo(page);
        return page;
    }

    class FieldBusFilterItem {
        private int fieldBusNumber;
        private boolean included;

        public int getFieldBusNumber() {
            return fieldBusNumber;
        }

        public void setFieldBusNumber(int fieldBusNumber) {
            this.fieldBusNumber = fieldBusNumber;
        }

        public boolean isIncluded() {
            return included;
        }

        public void setIncluded(boolean included) {
            this.included = included;
        }
    }

    private void bind(SymbolImporterDialogPage page, DataBindingContext dbc) {
        setMessage("Bitte wählen Sie eine Datei zum Import aus", IMessageProvider.INFORMATION);
        if (getButton(IDialogConstants.OK_ID) != null) {
            getButton(IDialogConstants.OK_ID).setEnabled(false);
        }
        this.selectedSourceFile = new WritableValue<>(dbc.getValidationRealm(), "", String.class);
        page.getTxtSourcePath().setEditable(false);
        page.getBtnSelectFromWorkspace().setFocus();
        page.getShell().setDefaultButton(page.getBtnSelectFromWorkspace());
        dbc.bindValue(WidgetProperties.text(SWT.FocusOut).observe(dbc.getValidationRealm(), page.getTxtSourcePath()),
                selectedSourceFile);

        page.getBtnSelectFromFilesystem().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                doSelectFileFormFs();
            }

            @Override
            public void widgetSelected(SelectionEvent e) {
                doSelectFileFormFs();
            }
        });
        page.getBtnSelectFromWorkspace().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                doSelectFileFormWs();
            }

            @Override
            public void widgetSelected(SelectionEvent e) {
                doSelectFileFormWs();
            }
        });
        // krm: 05/2014 One column 100% width
        // see https://bugs.eclipse.org/bugs/show_bug.cgi?id=215997
        WisagTableColumnLayout tl = new WisagTableColumnLayout();

        rowsTableViewer = new TableViewer(page.getTblImportableSymbols());
        ObservableListContentProvider cp = new ObservableListContentProvider();

        IObservableMap[] result = Properties.observeEach(cp.getKnownElements(), new IBeanValueProperty[] { //
                PojoProperties.value(ImportSymbol.class, ImportSymbol.PROP_SYMBOL_NAME), //
                PojoProperties.value(ImportSymbol.class, ImportSymbol.PROP_FIELD_BUS), //
                PojoProperties.value(ImportSymbol.class, ImportSymbol.PROP_REFERENCE_TYPE), //
                PojoProperties.value(ImportSymbol.class, ImportSymbol.PROP_ROW), //
                PojoProperties.value(ImportSymbol.class, ImportSymbol.PROP_COL), //
                PojoProperties.value(ImportSymbol.class, ImportSymbol.PROP_DESCRIPTION), //
        }//
        );
        ColumnViewerSorter defaultSortColumn = null;
        int currentColumn = 0;
        {
            TableViewerColumn tvc = new TableViewerColumn(rowsTableViewer, SWT.NONE);
            tvc.getColumn().setText("Symbolname");
            tvc.setLabelProvider(new ObservableMapCellLabelProvider(result[currentColumn++]));
            tl.setColumnData(tvc.getColumn(), new ColumnWeightData(40, true));
            defaultSortColumn = new ColumnViewerSorter(rowsTableViewer, tvc) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    ImportSymbol s1 = (ImportSymbol) e1;
                    ImportSymbol s2 = (ImportSymbol) e2;
                    return String.CASE_INSENSITIVE_ORDER.compare(s1.getSymbolName(), s2.getSymbolName());
                }

            };
            defaultSortColumn.setSorter(defaultSortColumn, ColumnViewerSorter.ASC);
        }
        {
            TableViewerColumn tvc = new TableViewerColumn(rowsTableViewer, SWT.NONE);
            tvc.getColumn().setText("Feldbusnummer");
            tvc.setLabelProvider(new ObservableMapCellLabelProvider(result[currentColumn++]));
            tl.setColumnData(tvc.getColumn(), new ColumnPixelData(120, true));
            new ColumnViewerSorter(rowsTableViewer, tvc) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    ImportSymbol s1 = (ImportSymbol) e1;
                    ImportSymbol s2 = (ImportSymbol) e2;
                    Integer i1 = Integer.valueOf(s1.getFieldBus());
                    Integer i2 = Integer.valueOf(s2.getFieldBus());
                    return i1.compareTo(i2);
                }

            };

        }
        {
            TableViewerColumn tvc = new TableViewerColumn(rowsTableViewer, SWT.NONE);
            tvc.getColumn().setText("Typ");
            tvc.setLabelProvider(new ObservableMapCellLabelProvider(result[currentColumn++]) {
                @Override
                public void update(ViewerCell cell) {
                    Object element = cell.getElement();
                    ReferenceType value = (ReferenceType) attributeMaps[0].get(element);
                    String text = "";
                    switch (value) {
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
                    cell.setText(text);
                }
            });
            tl.setColumnData(tvc.getColumn(), new ColumnPixelData(60, true));
            new ColumnViewerSorter(rowsTableViewer, tvc) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    ImportSymbol s1 = (ImportSymbol) e1;
                    ImportSymbol s2 = (ImportSymbol) e2;
                    return String.CASE_INSENSITIVE_ORDER.compare(s1.getReferenceType().getLiteral(),
                            s2.getReferenceType().getLiteral());
                }

            };

        }
        {
            TableViewerColumn tvc = new TableViewerColumn(rowsTableViewer, SWT.NONE);
            tvc.getColumn().setText("Zeile");
            tvc.setLabelProvider(new ObservableMapCellLabelProvider(result[currentColumn++]));
            new ColumnViewerSorter(rowsTableViewer, tvc) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    ImportSymbol s1 = (ImportSymbol) e1;
                    ImportSymbol s2 = (ImportSymbol) e2;
                    Integer i1 = Integer.valueOf(s1.getRow());
                    Integer i2 = Integer.valueOf(s2.getRow());
                    return i1.compareTo(i2);
                }

            };
            tl.setColumnData(tvc.getColumn(), new ColumnPixelData(20, true));
        }
        {
            TableViewerColumn tvc = new TableViewerColumn(rowsTableViewer, SWT.NONE);
            tvc.getColumn().setText("Spalte");
            tvc.setLabelProvider(new ObservableMapCellLabelProvider(result[currentColumn++]));
            new ColumnViewerSorter(rowsTableViewer, tvc) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    ImportSymbol s1 = (ImportSymbol) e1;
                    ImportSymbol s2 = (ImportSymbol) e2;
                    Integer i1 = Integer.valueOf(s1.getCol());
                    Integer i2 = Integer.valueOf(s2.getCol());
                    return i1.compareTo(i2);
                }

            };
            tl.setColumnData(tvc.getColumn(), new ColumnPixelData(20, true));
        }
        {
            TableViewerColumn tvc = new TableViewerColumn(rowsTableViewer, SWT.NONE);
            tvc.getColumn().setText("Beschreibung");
            tvc.setLabelProvider(new ObservableMapCellLabelProvider(result[currentColumn++]));
            new ColumnViewerSorter(rowsTableViewer, tvc) {
                @Override
                protected int doCompare(Viewer viewer, Object e1, Object e2) {
                    ImportSymbol s1 = (ImportSymbol) e1;
                    ImportSymbol s2 = (ImportSymbol) e2;
                    return String.CASE_INSENSITIVE_ORDER.compare(s1.getDescription(), s2.getDescription());
                }

            };
            tl.setColumnData(tvc.getColumn(), new ColumnPixelData(20, true));
        }

        page.getImportableSymbolsParent().setLayout(tl);
        rowsTableViewer.setContentProvider(cp);
        tableContent = new WritableList<>(dbc.getValidationRealm());
        rowsTableViewer.setInput(tableContent);

    }

    protected void doSelectFileFormWs() {
        FilteredResourcesSelectionDialog dlg = new FilteredResourcesSelectionDialog(getShell(), false,
                ResourcesPlugin.getWorkspace().getRoot(), IResource.FILE);
        dlg.setInitialPattern("*.exp");
        if (IDialogConstants.OK_ID != dlg.open()) {
            return;
        }
        IFile file = (IFile) dlg.getFirstResult();
        if (file == null) {
            return;
        }
        this.selectedSourceFile.setValue(file.getProjectRelativePath().toPortableString());
        SymbolsImporter importer = new SymbolsImporter();
        List<ImportSymbol> symbols = new ArrayList<>();

        try (InputStream is = file.getContents()) {
            symbols.addAll(importer.importSymbols(is, file.getCharset()));
            if (getButton(IDialogConstants.OK_ID) != null) {
                getButton(IDialogConstants.OK_ID).setEnabled(symbols.size() > 0);
                getShell().setDefaultButton(getButton(IDialogConstants.OK_ID));
            }
            setMessage(String.format("%d Symbole geladen", symbols.size()), IMessageProvider.INFORMATION);
        } catch (IOException e) {
            Policy.logError(e);
            setMessage("Importfehler : " + e.getMessage(), IMessageProvider.ERROR);
        } catch (ProcessingException e) {
            Policy.logError(e);
            setMessage("Importfehler : " + e.getMessage(), IMessageProvider.ERROR);
        } catch (CoreException e) {
            Policy.logError(e);
            setMessage("Importfehler : " + e.getStatus().getMessage(), IMessageProvider.ERROR);
        }
        applyImportData(symbols);

    }

    private void guessTypes(List<ImportSymbol> symbols) {
        final Map<Integer, List<ImportSymbol>> sByR = new HashMap<>();
        for (ImportSymbol importSymbol : symbols) {
            Integer row = Integer.valueOf(importSymbol.getRow());
            if (sByR.containsKey(row)) {
                List<ImportSymbol> s2 = sByR.get(row);
                s2.add(importSymbol);
            } else {
                List<ImportSymbol> s2 = new ArrayList<>();
                s2.add(importSymbol);
                sByR.put(row, s2);
            }
        }
        Collection<List<ImportSymbol>> groupedSymbols = sByR.values();
        for (List<ImportSymbol> list : groupedSymbols) {
            if (list.size() > 1) {
                for (ImportSymbol importSymbol : list) {
                    if (importSymbol.getReferenceType() == null) {
                        importSymbol.setReferenceType(ReferenceType.FGA_MESSAGE_CONST);
                    }
                }
            } else {
                ImportSymbol importSymbol = list.iterator().next();
                if (importSymbol.getReferenceType() == null) {
                    importSymbol.setReferenceType(ReferenceType.FGA_VALUE);
                }
            }
        }
    }

    protected void doSelectFileFormFs() {
        FileDialog dlg = new FileDialog(getShell(), SWT.OPEN);
        dlg.setFilterExtensions(new String[] { "*.exp;*.EXP" });
        String path = null;
        IStatus status = Status.CANCEL_STATUS;
        File file = null;
        if (!StringUtils.isEmpty(path = dlg.open())) {
            file = new File(path);
            if (!file.exists()) {
                this.selectedSourceFile.setValue("");
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                        String.format("Datei '%s' existiert nicht!", file.getAbsolutePath()));
            } else if (!file.canRead()) {
                this.selectedSourceFile.setValue("");
                status = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
                        String.format("Datei '%s' nicht lesbar!", file.getAbsolutePath()));
            } else {
                this.selectedSourceFile.setValue(file.getAbsolutePath());
                status = Status.OK_STATUS;
            }
        }
        if (!status.isOK() && status.getSeverity() != IStatus.CANCEL) {
            ErrorDialog.openError(getShell(), "Fehler beim Lesen der Datei", status.getMessage(), status);
        } else {
            SymbolsImporter importer = new SymbolsImporter();
            List<ImportSymbol> symbols = new ArrayList<>();
            try {
                symbols.addAll(importer.importSymbols(new FileInputStream(file), "CP850"));
                if (getButton(IDialogConstants.OK_ID) != null) {
                    getButton(IDialogConstants.OK_ID).setEnabled(symbols.size() > 0);
                    getShell().setDefaultButton(getButton(IDialogConstants.OK_ID));
                }
                setMessage(String.format("%d Symbole geladen", symbols.size()), IMessageProvider.INFORMATION);
            } catch (IOException e) {
                setMessage("Importfehler : " + e.getMessage(), IMessageProvider.ERROR);
            } catch (ProcessingException e) {
                setMessage("Importfehler : " + e.getMessage(), IMessageProvider.ERROR);
            }
            applyImportData(symbols);
        }
    }

    private void applyImportData(List<ImportSymbol> symbols) {
        this.tableContent.clear();
        if (!symbols.isEmpty()) {
            guessTypes(symbols);
            this.tableContent.addAll(symbols);
            packTableColumns();
        }
    }

    private void packTableColumns() {
        Table table = rowsTableViewer.getTable();
        table.setRedraw(false);
        TableColumn[] cols = table.getColumns();
        for (int i = 0; i < cols.length; i++) {
            TableColumn tableColumn = cols[i];
            tableColumn.pack();
            tableColumn.setWidth(tableColumn.getWidth() + 20);
        }
        table.setRedraw(true);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Symbole importieren");
    }

    public List<ImportSymbol> getSymbols() {
        List<ImportSymbol> symbols = new ArrayList<>();
        for (Iterator<?> it = this.tableContent.iterator(); it.hasNext();) {
            ImportSymbol symbol = (ImportSymbol) it.next();
            symbols.add(symbol);
        }
        return symbols;
    }

    @Override
    protected int getShellStyle() {

        return super.getShellStyle() | SWT.RESIZE;
    }

    @Override
    protected Point getInitialSize() {
        return new Point(570, 650);
    }

}
