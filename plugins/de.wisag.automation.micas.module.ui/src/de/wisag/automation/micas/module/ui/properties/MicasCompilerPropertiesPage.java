package de.wisag.automation.micas.module.ui.properties;

import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.dialogs.PropertyPage;

public class MicasCompilerPropertiesPage extends PropertyPage {

    /**
     * Constructor for SamplePropertyPage.
     */
    public MicasCompilerPropertiesPage() {
        super();
    }

    /**
     * @see PreferencePage#createContents(Composite)
     */
    @Override
    protected Control createContents(Composite parent) {
        MicasCompilerPropertiesComposite page = new MicasCompilerPropertiesComposite(parent, SWT.NONE);

        return page;
    }

    @Override
    protected void performDefaults() {
        super.performDefaults();

    }

    @Override
    public boolean performOk() {
        // store the value in the owner text field

        return true;
    }

}