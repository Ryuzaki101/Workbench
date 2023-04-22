package de.wisag.automation.micas.module.ui.dialogs;

import java.util.Comparator;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.FilteredItemsSelectionDialog;
import org.eclipse.ui.dialogs.SearchPattern;

import de.wisag.automation.micas.common.ui.dialogs.SymbolFilter;
import de.wisag.automation.micas.module.Attribute;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.ModulePackage;
import de.wisag.automation.micas.module.ui.internal.Activator;

/**
 * Dialog is not in module.ui, otherwise whe would have circular dependencies
 */
public class FindSymbolDialog extends FilteredItemsSelectionDialog {

    private final class AtributeItemFilter extends ItemsFilter {
        AtributeItemFilter() {
            super(new SearchPattern());
        }

        @Override
        public boolean matchItem(Object item) {
            Attribute attribute = (Attribute) item;
            if (!filterBySymboltype.match(attribute)) {
                return false;
            }
            return matches(attribute.getName());
        }

        @Override
        public boolean isConsistentItem(Object item) {
            return true;
        }
    }

    private Module module;

    private SymbolFilter filterBySymboltype;

    private boolean isSymbolTypeSelectable;

    /**
     * Create FindSymbolDialog for searching symbols in the given module
     * allowing the user to select the symbol type to filter against.
     *
     * @param shell
     * @param module
     */
    public FindSymbolDialog(Shell shell, Module module) {
        this(shell, module, null);
        // make symbol type selectable
        this.isSymbolTypeSelectable = true;
        setTitle("Symbolsuche");
        setMessage("Geben Sie den Symbolnamen ein (? / * = beliebiges Zeichen / Zeichenkette, ** alle Symbole)");
    }

    /**
     * Create FindSymbolDialog for searching symbols in the given module and
     * restricting the search only to the specified symbol type
     *
     * @param shell
     * @param module
     * @param symbolFilter
     */
    public FindSymbolDialog(Shell shell, Module module, SymbolFilter symbolFilter) {
        super(shell);
        this.module = module;
        this.filterBySymboltype = symbolFilter;
        this.isSymbolTypeSelectable = false;
        LabelProvider labelProvider = new LabelProvider() {
            @Override
            public String getText(Object element) {
                if (element == null) {
                    return "";
                }
                return FindSymbolDialog.this.getText((Attribute) element);
            }
        };
        setListLabelProvider(labelProvider);
        setDetailsLabelProvider(labelProvider);
        setInitialPattern("[Name eingeben]", FilteredItemsSelectionDialog.FULL_SELECTION);
        setTitle(String.format("Suche nach %s", ""));
        setMessage("Geben Sie einen Namen ein (? / * = beliebiges Zeichen / Zeichenkette)");
    }

    protected String getText(Attribute element) {
        String description = element.getDescription();
        if ("\"\"".equals(description)) {
            description = "";
        }
        return String.format("%s (%s) %s", element.getName(),
                element.getDataType() != null ? element.getDataType().getLiteral() : "", description);
    }

    @Override
    protected Control createExtendedContentArea(Composite parent) {
        return null;
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Composite dialogArea = (Composite) super.createDialogArea(parent);
        // don't change the dialog UI if the filtered symbol type
        // cannot be selected by the user
        if (!isSymbolTypeSelectable) {
            return dialogArea;
        }

        Composite content = (Composite) dialogArea.getChildren()[0];

        // creates controls for filtered symbol type selection
        Composite symbolTypes = new Composite(content, SWT.NONE);
        symbolTypes.setLayout(new RowLayout());

        Label symbolTypeLabel = new Label(symbolTypes, SWT.NONE);
        symbolTypeLabel.setText("Symboltyp:	");

        Button varRadioBtn = new Button(symbolTypes, SWT.RADIO);
        varRadioBtn.setText("Variable");
        varRadioBtn.setSelection(true);
        varRadioBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                applyFilter(SymbolFilter.createFilter(ModulePackage.Literals.VARIABLE_ATTRIBUTE));
            }
        });
        Button constRadioBtn = new Button(symbolTypes, SWT.RADIO);
        constRadioBtn.setText("Konstante");
        constRadioBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                applyFilter(SymbolFilter.createFilter(ModulePackage.Literals.CONSTANT_ATTRIBUTE));
            }
        });
        Button refRowRadioBtn = new Button(symbolTypes, SWT.RADIO);
        refRowRadioBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                applyFilter(SymbolFilter.createFilter(ModulePackage.Literals.REFERENCE_ATTRIBUTE));
            }
        });
        refRowRadioBtn.setText("Referenz (Ze)");
        Button refRowColRadioBtn = new Button(symbolTypes, SWT.RADIO);
        refRowColRadioBtn.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                applyFilter(SymbolFilter.createFilter(ModulePackage.Literals.REFERENCE_ATTRIBUTE));
            }
        });
        refRowColRadioBtn.setText("Referenz (Ze/Sp)");

        // insert symbolType composite after the pattern text field
        symbolTypes.moveAbove(content.getChildren()[2]);
        content.layout();

        return dialogArea;
    }

    protected void applyFilter(SymbolFilter symbolFilter) {
        this.filterBySymboltype = symbolFilter;
        applyFilter();
    }

    @Override
    protected void fillContentProvider(AbstractContentProvider contentProvider, ItemsFilter itemsFilter,
            IProgressMonitor progressMonitor) throws CoreException {
        for (Attribute attr : module.getAttributes()) {
            if (progressMonitor.isCanceled()) {
                return;
            }
            contentProvider.add(attr, itemsFilter);
        }
    }

    @Override
    public String getElementName(Object item) {
        Attribute attr = (Attribute) item;
        return getText(attr);
    }

    @Override
    protected Comparator<Attribute> getItemsComparator() {

        return new Comparator<Attribute>() {

            @Override
            public int compare(Attribute att1, Attribute att2) {
                return getText(att1).compareTo(getText(att2));
            }
        };
    }

    @Override
    protected IStatus validateItem(Object item) {
        return Status.OK_STATUS;
    }

    /**
     * Opens {@link EditSymbolDialog} for the specified symbol type and
     * refreshes the filtered list viewer content if a new variable was added.
     *
     * @param shell
     * @param symbolType
     */
    protected void openNewSymbolDialog(Shell shell, int symbolType) {

    }

    @Override
    protected IDialogSettings getDialogSettings() {
        String sectionName = "FindSymbolDialog.settings"; //$NON-NLS-1$

        Activator default1 = Activator.getDefault();
        IDialogSettings dialogSettings = default1.getDialogSettings();
        IDialogSettings settings = dialogSettings.getSection(sectionName);
        if (settings == null) {
            settings = dialogSettings.addNewSection(sectionName);
        }

        return settings;
    }

    @Override
    protected ItemsFilter createFilter() {

        return new AtributeItemFilter();
    }

}
