package de.wisag.automation.micas.workbench.licmgr.ui.internal;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.IBeanValueProperty;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.wisag.automation.micas.common.licensing.ILicenseManager;
import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.common.licensing.LicenseStatus;
import de.wisag.automation.micas.workbench.licmgr.ui.dialogs.LicenseRequestDialog;

public class ShowLicenseDialog extends TitleAreaDialog {
    private WritableValue<LicenseInfo> info;
    private ILicenseManager licenseManager;

    public ShowLicenseDialog(Shell parentShell) {
        super(parentShell);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
        ShowLicenseDialogPage page = new ShowLicenseDialogPage(parent, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(page);
        bind(page);
        return page;
    }

    private void bind(final ShowLicenseDialogPage page) {
        DataBindingContext ctx = new DataBindingContext(DisplayRealm.getRealm(page.getDisplay()));
        info = new WritableValue<>(ctx.getValidationRealm(), null, LicenseInfo.class);
        page.getBtnRequestLicense().addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                showRequestAndEnterLicenseDialog(((Control) e.widget).getShell());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                showRequestAndEnterLicenseDialog(((Control) e.widget).getShell());
            }
        });
        page.getBtnDropLicenseData().addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                dropLicenseData(((Control) e.widget).getShell());
            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                dropLicenseData(((Control) e.widget).getShell());
            }
        });
        page.getBtnExportLicense().setVisible(false);
        ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtLicenseStatus()),
                observeDetail(info, LicenseInfo.PROP_LICENSE_STATUS), null, null);
        ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtName()),
                observeDetail(info, LicenseInfo.PROP_NAME), null, null);
        ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtCompany()),
                observeDetail(info, LicenseInfo.PROP_COMPANY), null, null);
        ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtEmail()),
                observeDetail(info, LicenseInfo.PROP_EMAIL), null, null);

        ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getTxtDateCreated()),
                observeDetail(info, LicenseInfo.PROP_DATE_CREATED), null, null);

        ctx.bindValue(observeDetail(info, LicenseInfo.PROP_VALID_UNTIL),
                WidgetProperties.text(SWT.Modify).observe(page.getTxtValidUtil()), null, null);

        ctx.bindValue(observeDetail(info, LicenseInfo.PROP_VALID_FOR_VERSION),
                WidgetProperties.text(SWT.Modify).observe(page.getTxtValidForVersion()), null, null);

        ctx.bindValue(observeDetail(info, LicenseInfo.PROP_LICENSE_NUMBER),
                WidgetProperties.text(SWT.Modify).observe(page.getTxtLicenseNumber()), null, null);

        ctx.bindValue(observeDetail(info, LicenseInfo.PROP_INFO),
                WidgetProperties.text(SWT.Modify).observe(page.getTxtInfo()), null, null);
        ctx.bindValue(observeDetail(info, LicenseInfo.PROP_LICENSE_DIR),
                WidgetProperties.text(SWT.Modify).observe(page.getTxtLicenseDir()), null, null);

        if (this.licenseManager != null) {
            info.setValue(this.licenseManager.getLicenseInfo());
        } else {
            LicenseInfo linfo = new LicenseInfo();
            linfo.setLicenseStatus(LicenseStatus.NOT_AVAILABLE);
            linfo.setInfo("Lizenzdienst nicht verfügbar");
        }
        setMessage("Angezeigt wird der aktuelle Zustand der Lizensierung", IMessageProvider.INFORMATION);
    }

    @SuppressWarnings("unchecked")
    private <T, M> IObservableValue<T> observeDetail(IObservableValue<M> model, String propertyName) {
        IBeanValueProperty beanValueProperty = BeanProperties.value(propertyName);
        return beanValueProperty.observeDetail(model);
    }

    protected void dropLicenseData(Shell shell) {
        if (MessageDialog.openQuestion(shell, "Wollen sie wirklich ?",
                "Sollen alle Lizenzinformationen gelöscht werden ?")) {
            if (this.licenseManager != null) {
                info.setValue(this.licenseManager.sweepLicenseData());
            }
        }

    }

    protected void showRequestAndEnterLicenseDialog(Shell shell) {
        LicenseRequestDialog dlg = new LicenseRequestDialog(shell);
        dlg.setLicenseManager(this.licenseManager);
        if (IDialogConstants.OK_ID == dlg.open()) {
            if (this.licenseManager != null) {
                info.setValue(this.licenseManager.getLicenseInfo());
            }
        }

    }

    @Override
    protected int getShellStyle() {
        return super.getShellStyle() | SWT.RESIZE;
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("License Informations");
    }

    public ILicenseManager getLicenseManager() {
        return licenseManager;
    }

    public void setLicenseManager(ILicenseManager licenseManager) {
        this.licenseManager = licenseManager;
    }

}
