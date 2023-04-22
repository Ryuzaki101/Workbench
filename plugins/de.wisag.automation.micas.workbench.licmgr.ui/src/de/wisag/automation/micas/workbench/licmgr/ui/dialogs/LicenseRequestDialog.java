package de.wisag.automation.micas.workbench.licmgr.ui.dialogs;

import static de.wisag.automation.micas.common.licensing.LicenseInfo.PROP_COMPANY;
import static de.wisag.automation.micas.common.licensing.LicenseInfo.PROP_EMAIL;
import static de.wisag.automation.micas.common.licensing.LicenseInfo.PROP_LICENSE_DATA;
import static de.wisag.automation.micas.common.licensing.LicenseInfo.PROP_NAME;
import static de.wisag.automation.micas.common.ui.LicensingWorkbenchDecoratorHelper.adjustWorkbenchLicenzingTitle;
import static de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils.REQUEST_MSG_FOOTER;
import static de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils.REQUEST_MSG_HEADER;
import static de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils.toRequest;

import java.awt.Desktop;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.IBeanValueProperty;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.dialog.TitleAreaDialogSupport;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.ISWTObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.wisag.automation.micas.common.licensing.ILicenseManager;
import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.common.ui.IMailSender;
import de.wisag.automation.micas.common.ui.MailSenderFactory;
import de.wisag.automation.micas.common.ui.databinding.RegexValidator;
import de.wisag.automation.micas.workbench.licmgr.hwid.HwKeyGen;
import de.wisag.automation.micas.workbench.licmgr.ui.internal.LicenseRequestDialogPage;
import de.wisag.automation.micas.workbench.licmgr.ui.internal.NotEmptyValidator;
import de.wisag.automation.micas.workbench.licmgr.ui.internal.Policy;
import de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils;

public class LicenseRequestDialog extends TitleAreaDialog {
    private static final Pattern emailPattern = Pattern.compile("^\\w+([.-]?\\w+)*@\\w+([.-]?\\w+)*(.\\w{2,3})+$");
    protected static final String EMAIL = "Micas Lizenzanfrage <lizenz-anfrage@ba-i-help.de>";
    private Clipboard clipboard;

    private ILicenseManager licenseManager;
    private LicenseInfo validatedInfo = null;

    public LicenseRequestDialog(Shell parentShell) {
        super(parentShell);

    }

    @Override
    protected Control createDialogArea(Composite parent) {
        this.clipboard = new Clipboard(parent.getDisplay());
        getShell().addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                if (LicenseRequestDialog.this.clipboard != null && !LicenseRequestDialog.this.clipboard.isDisposed()) {
                    LicenseRequestDialog.this.clipboard.dispose();
                }

            }
        });
        LicenseRequestDialogPage page = new LicenseRequestDialogPage(parent, SWT.NONE);
        GridLayoutFactory.fillDefaults().applyTo(parent);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(page);
        getShell().setText("Lizenz anfragen");
        bind(page);
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {

        } else {
            page.getBtnSendEmail().setEnabled(false);
        }

        return parent;
    }

    @Override
    public void create() {
        super.create();
        getButton(IDialogConstants.OK_ID).setText("Verwenden");
        getButton(IDialogConstants.OK_ID).setEnabled(false);
    }

    private WritableValue<LicenseInfo> model;

    private void bind(LicenseRequestDialogPage page) {
        DataBindingContext dbc = new DataBindingContext(DisplayRealm.getRealm(page.getDisplay()));
        model = new WritableValue<>(dbc.getValidationRealm(), null, LicenseInfo.class);
        Text userName = page.getUserName();
        dbc.bindValue(textModify(userName), observeDetail(model, PROP_NAME),
                new UpdateValueStrategy()
                        .setBeforeSetValidator(new NotEmptyValidator("Feld 'Name' darf nicht leer sein")),
                new UpdateValueStrategy()
                        .setBeforeSetValidator(new NotEmptyValidator("Feld 'Name' darf nicht leer sein")));

        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getOrganisationName()),
                observeDetail(model, PROP_COMPANY),
                new UpdateValueStrategy()
                        .setAfterGetValidator(new NotEmptyValidator("Feld 'Firma' darf nicht leer sein")),
                new UpdateValueStrategy()
                        .setAfterGetValidator(new NotEmptyValidator("Feld 'Firma' darf nicht leer sein")));

        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getEmailAddress()),
                observeDetail(model, PROP_EMAIL),
                new UpdateValueStrategy().setAfterGetValidator(
                        new RegexValidator(emailPattern, "Feld 'E-Mail' muss eine gültige Email-Adresse beinhalten")),
                new UpdateValueStrategy().setAfterGetValidator(
                        new RegexValidator(emailPattern, "Feld 'E-Mail' muss eine gültige Email-Adresse beinhalten")));
        dbc.bindValue(WidgetProperties.text().observe(page.getLicenseKey()), observeDetail(model, PROP_LICENSE_DATA),
                new UpdateValueStrategy(), new UpdateValueStrategy());

        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(page.getLicenseKey()),
                observeDetail(model, PROP_LICENSE_DATA),
                new UpdateValueStrategy().setAfterGetValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        validatedInfo = null;
                        Button button = getButton(IDialogConstants.OK_ID);
                        if (button != null && !button.isDisposed()) {
                            button.setEnabled(false);
                        }
                        if (StringUtils.isEmpty((String) value)) {
                            return ValidationStatus.ok();
                        }
                        String licenseData = StringUtils.trimToEmpty((String) value);
                        LicenseInfo info2 = LicenseManagerUtils.createFromResponse(licenseData);
                        IStatus status = LicenseManagerUtils.checkSignatureAndVerifyLicense(info2);
                        if (!status.isOK()) {
                            return status;
                        }
                        if (button != null && !button.isDisposed()) {
                            button.setEnabled(true);
                        }
                        info2.setLicenseData(licenseData);
                        validatedInfo = info2;
                        return ValidationStatus.info("Lizenzinformation ist gueltig");
                    }
                }), new UpdateValueStrategy());

        page.getBtnCopyToClipboard().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String data = createRequestMessage();
                if (!StringUtils.isEmpty(data)) {
                    LicenseRequestDialog.this.clipboard.setContents(new Object[] { data },
                            new Transfer[] { TextTransfer.getInstance() });
                } else {

                }
            }
        });

        page.getBtnSendEmail().addSelectionListener(new SelectionAdapter() {
            private static final String REQUEST_SUBJECT = "[MICAS-LICENSE-REQUEST]";

            @Override
            public void widgetSelected(SelectionEvent e) {
                String data = createRequestMessage();

                if (!StringUtils.isEmpty(data)) {
                    IMailSender mailer = MailSenderFactory.create();
                    String body = data;
                    IStatus status = mailer.sendMail(EMAIL, REQUEST_SUBJECT, body);
                    if (status != null && !status.isOK()) {
                        Policy.log(status);
                    }
                }
            }
        });
        TitleAreaDialogSupport.create(this, dbc);
        final LicenseInfo info = new LicenseInfo();
        info.setCompany("WISAG Automatisierungstechnik GmbH & Co. KG");
        if (this.licenseManager != null) {
            LicenseInfo lastInfo = this.licenseManager.loadLastRequest();
            if (lastInfo != null) {
                model.setValue(lastInfo);
            } else {
                model.setValue(info);
            }
        } else {
            model.setValue(info);
        }
        dbc.updateTargets();
    }

    private ISWTObservableValue textModify(Text userName) {
        return WidgetProperties.text(SWT.Modify).observe(userName);
    }

    @SuppressWarnings("unchecked")
    private <T, M> IObservableValue<T> observeDetail(IObservableValue<M> model, String propertyName) {
        IBeanValueProperty beanValueProperty = BeanProperties.value(propertyName);
        return beanValueProperty.observeDetail(model);
    }

    @Override
    protected int getShellStyle() {
        return super.getShellStyle() | SWT.RESIZE;
    }

    private String createRequestMessage() {
        LicenseInfo info = this.model.getValue();
        info.setDateCreated(new Date());
        info.setHwId(HwKeyGen.getHardwareId());
        if (this.licenseManager != null) {
            this.licenseManager.storeRequest(info);
        }
        return toRequest(info, REQUEST_MSG_HEADER, REQUEST_MSG_FOOTER);
    }

    @Override
    protected void buttonPressed(int buttonId) {
        super.buttonPressed(buttonId);
        if (buttonId == IDialogConstants.OK_ID) {
            if (this.licenseManager != null && validatedInfo != null) {
                this.licenseManager.applyAndStoreLicense(validatedInfo);
                adjustWorkbenchLicenzingTitle(this.licenseManager);
            }
        }
    }

    public ILicenseManager getLicenseManager() {
        return licenseManager;
    }

    public void setLicenseManager(ILicenseManager licenseManager) {
        this.licenseManager = licenseManager;
    }

}
