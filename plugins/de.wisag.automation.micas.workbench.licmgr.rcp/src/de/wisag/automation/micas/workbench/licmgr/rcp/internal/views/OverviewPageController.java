package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.Binding;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.beans.IBeanValueProperty;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.databinding.property.Properties;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.swt.IWidgetValueProperty;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.databinding.viewers.ViewerSupport;
import org.eclipse.jface.databinding.viewers.ViewersObservables;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.fieldassist.FieldDecoration;
import org.eclipse.jface.fieldassist.FieldDecorationRegistry;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.osgi.framework.FrameworkUtil;

import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.common.model.AbstractModelObject;
import de.wisag.automation.micas.common.ui.IMailSender;
import de.wisag.automation.micas.common.ui.MailSenderFactory;
import de.wisag.automation.micas.common.ui.databinding.NullToCurrentDateTimeConverter;
import de.wisag.automation.micas.workbench.licmgr.rcp.internal.Policy;
import de.wisag.automation.micas.workbench.licmgr.utils.ChecksumMismatchException;
import de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils;
import de.wisag.automation.micas.workbench.licmgr.utils.PGPSignatureHelper;

public class OverviewPageController extends AbstractModelObject {
    private static final String FILE_AVAILABLE_VERSIONS_TXT = "available_versions.txt";
    private static final String FILE_AVAILABLE_PRODUCTS_TXT = "available_products.txt";
    public static final String PROP_MODEL = "model";
    private LicenseModel model;
    private Clipboard clipboard;

    private List<ControlDecoration> decorations = new ArrayList<>();
    private Shell shell;

    @SuppressWarnings({ "unchecked", "unused" })
    public void bind(final DataBindingContext ctx, final OverviewPage page) {
        this.shell = page.getShell();
        this.clipboard = new Clipboard(page.getDisplay());
        page.getShell().addDisposeListener(new DisposeListener() {

            @Override
            public void widgetDisposed(DisposeEvent e) {
                if (clipboard != null && !clipboard.isDisposed()) {
                    clipboard.dispose();
                }

            }
        });
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {

        } else {
            page.getBtnSendLicense().setEnabled(false);
        }
        IBeanValueProperty value = BeanProperties.value(PROP_MODEL);
        IObservableValue<OverviewPageController> master = value.<OverviewPageController> observe(this);

        Realm realm = ctx.getValidationRealm();

        WritableValue<Boolean> enabled = new WritableValue<>(realm, Boolean.FALSE, Boolean.class);

        ctx.bindValue(observeDetail(master, LicenseModel.PROP_KEYSTORE_STATUS), enabled,
                new UpdateValueStrategy().setConverter(new KeyStoreStatusToToEnabledConverter()),
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));

        ctx.bindValue(observeEnabled(realm, page.getTxtCompany()), enabled, null, null);
        ctx.bindValue(observeEnabled(realm, page.getBtnBtnClearRequest()), enabled, null, null);
        StringNotEmptyValidator validator = new StringNotEmptyValidator(
                createDecorator(page.getTxtCompany(), decorations), "Company must not be empty");
        page.getTxtCompany().setEditable(false);
        ctx.bindValue(observeText(realm, page.getTxtCompany()), observeDetail(master, LicenseModel.PROP_COMPANY),
                new UpdateValueStrategy().setAfterConvertValidator(validator), new UpdateValueStrategy());
        page.getTxtHardwareId().setEditable(false);

        StringNotEmptyValidator validator12 = new StringNotEmptyValidator(
                createDecorator(page.getTxtHardwareId(), decorations), "Company must not be empty");
        ctx.bindValue(observeText(realm, page.getTxtHardwareId()), observeDetail(master, LicenseModel.PROP_HARDWARE_ID),
                new UpdateValueStrategy().setAfterConvertValidator(validator12), new UpdateValueStrategy());
        ctx.bindValue(observeEnabled(realm, page.getTxtHardwareId()), enabled, null, null);
        ctx.bindValue(observeEnabled(realm, page.getTxtName()), enabled, null, null);

        page.getTxtName().setEditable(false);
        ctx.bindValue(observeText(realm, page.getTxtName()), observeDetail(master, LicenseModel.PROP_NAME),
                new UpdateValueStrategy(), new UpdateValueStrategy());

        ctx.bindValue(observeEnabled(realm, page.getTxtDateCreated()), enabled, null, null);

        page.getTxtDateCreated().setEditable(false);
        ctx.bindValue(observeText(realm, page.getTxtDateCreated()),
                observeDetail(master, LicenseModel.PROP_DATE_CREATED), new UpdateValueStrategy(),
                new UpdateValueStrategy().setConverter(new DateToStringConverter()));

        ctx.bindValue(observeEnabled(realm, page.getDtDateValidUntil()), enabled, null, null);
        ctx.bindValue(WidgetProperties.selection().observe(realm, page.getDtDateValidUntil()),
                observeDetail(master, LicenseModel.PROP_DATE_VALID_UNTIL), new UpdateValueStrategy(),
                new UpdateValueStrategy().setConverter(new NullToCurrentDateTimeConverter()));

        page.getTxtEmail().setEditable(false);
        ctx.bindValue(observeEnabled(realm, page.getTxtEmail()), enabled, null, null);

        ctx.bindValue(observeEnabled(realm, page.getBtnGenerateLicense()), enabled, null, null);

        ctx.bindValue(observeText(realm, page.getTxtEmail()), observeDetail(master, LicenseModel.PROP_EMAIL),
                new UpdateValueStrategy(), new UpdateValueStrategy());

        ctx.bindValue(observeEnabled(realm, page.getTxtPrivateKeyUrl()), enabled, null, null);
        page.getTxtPrivateKeyUrl().setEditable(false);
        ctx.bindValue(
                //
                observeText(realm, page.getTxtPrivateKeyUrl()),
                BeanProperties.<LicenseModel> value(LicenseModel.PROP_PRIVATE_KEY_URL).<String> observeDetail(master),
                new UpdateValueStrategy(), new UpdateValueStrategy());

        ctx.bindValue(observerTextModify(realm, page.getTxtKeyPassword()),
                observeDetail(master, LicenseModel.PROP_KEYSTORE_PASSWORD), new UpdateValueStrategy(),
                new UpdateValueStrategy());

        ctx.bindValue(WidgetProperties.text(SWT.Modify).observe(realm, page.getTxtKeyPassword()),
                observeEnabled(realm, page.getBtnOpenKey()),
                new UpdateValueStrategy().setConverter(new NotNullToBooleanTrueConverter()), new UpdateValueStrategy());

        page.getTxtKeyStatus().setEditable(false);
        ctx.bindValue(observeText(realm, page.getTxtKeyStatus()),
                observeDetail(master, LicenseModel.PROP_KEYSTORE_STATUS),
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new KeyStoreStatusToTextConverter()));

        ctx.bindValue(observeBackground(realm, page.getTxtKeyStatus()),
                observeDetail(master, LicenseModel.PROP_KEYSTORE_STATUS),
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new KeyStoreStatusToColorConverter()));

        ctx.bindValue(observeText(realm, page.getBtnOpenKey()),
                observeDetail(master, LicenseModel.PROP_KEYSTORE_STATUS),
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new KeyStoreStatusToButtonTextConverter()));

        ctx.bindValue(observeEnabled(realm, page.getTxtLicenseNumber()),
                observeDetail(master, LicenseModel.PROP_LICENSE_REQUEST), null,
                new UpdateValueStrategy().setConverter(new NotEmptyToBooleanTrueConverter()));
        StringNotEmptyValidator validator5 = new StringNotEmptyValidator(
                createDecorator(page.getTxtLicenseNumber(), decorations), "Lizenznummer until must not be empty");
        final Binding licenseNumberBinding = ctx.bindValue(observerTextModify(realm, page.getTxtLicenseNumber()),
                observeDetail(master, LicenseModel.PROP_LICENSE_NUMBER),
                new UpdateValueStrategy().setAfterConvertValidator(validator5), new UpdateValueStrategy());

        ctx.bindValue(observeEnabled(realm, page.getTxtLicenseRequest()), enabled, null, null);

        IObservableValue<String> licenseRequestData = observeDetail(master, LicenseModel.PROP_LICENSE_REQUEST);

        ctx.bindValue(WidgetProperties.text(SWT.Modify).observeDelayed(500, page.getTxtLicenseRequest()),
                licenseRequestData, new UpdateValueStrategy(), new UpdateValueStrategy());
        licenseRequestData.addValueChangeListener(event -> {
            handleRequestDataUpdate(event.getObservableValue().getValue(), licenseNumberBinding, page);
        });
        ctx.bindValue(observeEnabled(realm, page.getTxtLicenseResponse()), enabled, null, null);

        IObservableValue<String> licenseResponse = observeDetail(master, LicenseModel.PROP_LICENSE_RESPONSE);
        IObservableValue<String> licenseResponseText = observeText(realm, page.getTxtLicenseResponse());
        ctx.bindValue(licenseResponseText, licenseResponse, new UpdateValueStrategy(), new UpdateValueStrategy());

        ctx.bindValue(observeEnabled(realm, page.getTxtName()), enabled, null, null);
        ctx.bindValue(observeEnabled(realm, page.getCmbValidForProduct()), enabled, null, null);

        ComboViewer availableProducts = new ComboViewer(page.getCmbValidForProduct());
        ViewerSupport.bind(availableProducts,
                BeanProperties.list(LicenseModel.PROP_AVAILABLE_PRODUCTS).observeDetail(master),
                Properties.selfValue(String.class));
        ctx.bindValue(ViewersObservables.observeSingleSelection(availableProducts),
                BeanProperties.value(LicenseModel.PROP_VALID_FOR_PRODUCT).observeDetail(master));

        ctx.bindValue(observeEnabled(realm, page.getCmbValidForVersion()), enabled, null, null);

        ComboViewer availableVersions = new ComboViewer(page.getCmbValidForVersion());
        ViewerSupport.bind(availableVersions,
                BeanProperties.list(LicenseModel.PROP_AVAILABLE_VERSIONS).observeDetail(master),
                Properties.selfValue(String.class));
        ctx.bindValue(ViewersObservables.observeSingleSelection(availableVersions),
                observeDetail(master, LicenseModel.PROP_VALID_FOR_VERSION));

        page.getBtnSelectDir().setVisible(false);

        LicenseModel currentModel = new LicenseModel();
        currentModel.setAvailableProducts(readLines(FILE_AVAILABLE_PRODUCTS_TXT));
        currentModel.setAvailableVersions(readLines(FILE_AVAILABLE_VERSIONS_TXT));
        if (!currentModel.getAvailableProducts().isEmpty()) {
            currentModel.setValidForProduct(currentModel.getAvailableProducts().iterator().next());
        }
        if (!currentModel.getAvailableVersions().isEmpty()) {
            currentModel.setValidForVersion(
                    currentModel.getAvailableVersions().get(currentModel.getAvailableProducts().size() - 1));
        }
        setModel(currentModel);

        page.getBtnOpenKey().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                openKey(((Control) e.widget).getShell());
            }

        });

        page.getBtnGenerateLicense().addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                generateLicense();

            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                generateLicense();

            }
        });
        page.getBtnCopyLicense().addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                String data = getModel() != null ? getModel().getLicenseResponse() : "";
                if (!StringUtils.isEmpty(data)) {
                    clipboard.setContents(new Object[] { data }, new Transfer[] { TextTransfer.getInstance() });
                } else {

                }
            }
        });

        ctx.bindValue(observeEnabled(realm, page.getBtnCopyLicense()), licenseResponseText,
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new NotEmptyToBooleanTrueConverter()));
        ctx.bindValue(observeEnabled(realm, page.getBtnSendLicense()), licenseResponseText,
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new NotEmptyToBooleanTrueConverter()));

        page.getBtnSendLicense().addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                sendLicenseViaEmail();

            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                sendLicenseViaEmail();

            }

        });
        page.getBtnBtnClearRequest().addSelectionListener(new SelectionListener() {

            @Override
            public void widgetSelected(SelectionEvent e) {
                if (getModel() != null) {
                    getModel().setLicenseRequest(null);
                }

            }

            @Override
            public void widgetDefaultSelected(SelectionEvent e) {
                if (getModel() != null) {
                    getModel().setLicenseRequest(null);
                }

            }

        });
        hideDecorations();
        ctx.bindValue(observeEnabled(realm, page.getBtnGenerateLicense()),
                new AggregateValidationStatus(ctx.getBindings(), AggregateValidationStatus.MAX_SEVERITY),
                new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER),
                new UpdateValueStrategy().setConverter(new OkStatusToBooleanTrueConverter()));

    }

    @SuppressWarnings("unchecked")
    private IObservableValue<String> observerTextModify(Realm realm, Text txtKeyPassword) {
        return WidgetProperties.text(SWT.Modify).observe(realm, txtKeyPassword);

    }

    @SuppressWarnings("unchecked")
    private IObservableValue<Color> observeBackground(Realm realm, Control control) {
        return WidgetProperties.background().observe(realm, control);
    }

    @SuppressWarnings("unchecked")
    private IObservableValue<String> observeText(Realm realm, Control contrl) {
        return WidgetProperties.text().observe(realm, contrl);
    }

    @SuppressWarnings("unchecked")
    private IObservableValue<Boolean> observeEnabled(Realm realm, Control txtCompany) {
        IWidgetValueProperty enabled = WidgetProperties.enabled();
        return enabled.observe(realm, txtCompany);
    }

    private void hideDecorations() {
        for (ControlDecoration decoration : decorations) {
            decoration.hide();
        }
    }

    protected void sendLicenseViaEmail() {
        String data = getModel() != null ? getModel().getLicenseResponse() : "";

        if (!StringUtils.isEmpty(data)) {
            IMailSender mailer = MailSenderFactory.create();
            String body = data;
            IStatus status = mailer.sendMail(getModel().getEmail(), "[MICAS Workbench Lizenz]", body);
            if (status != null && !status.isOK()) {
                Policy.log(status);
            }
        }
    }

    protected void generateLicense() {
        if (getModel() == null) {
            return;
        }
        LicenseModel model = getModel();
        if (StringUtils.isEmpty(model.getLicenseNumber())) {
            MessageDialog.openError(this.shell, "Fehler", "Lizenznummer darf nicht leer sein");
        }
        LicenseInfo info = new LicenseInfo();
        info.setCompany(model.getCompany());
        info.setName(model.getName());
        info.setEmail(model.getEmail());
        info.setValidForProduct(model.getValidForProduct());
        info.setLicenseNumber(model.getLicenseNumber());
        info.setHwId(model.getHardwareId());
        info.setValidForVersion(model.getValidForVersion());
        info.setValidUntil(model.getDateValidUntil());
        info.setDateCreated(model.getDateCreated());
        String msg = "";
        try {
            msg = LicenseManagerUtils.signLicense(info, model.getPrivateKeyUrl(), model.getPublicKeyUrl(),
                    model.getKeystorePassword(), model.getKeyId());
        } catch (Exception e) {
            Policy.logError(e);
        }
        getModel().setLicenseResponse(msg);
    }

    private List<String> readLines(String bundleEntry) {
        URL url = FrameworkUtil.getBundle(getClass()).getEntry(bundleEntry);
        if (url == null) {
            Policy.logWarning(String.format("Bundle entry '%s' not found", bundleEntry));
            return Collections.emptyList();
        }
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))) {
            String line = null;
            while ((line = br.readLine()) != null && !line.isEmpty()) {
                lines.add(line);
            }
        } catch (IOException e) {
            Policy.logError(String.format("Reading of bundle entry '%s' failed", bundleEntry), e);
        }
        return Collections.unmodifiableList(lines);
    }

    private void openKey(Shell shell) {
        if (getModel() == null) {
            return;
        }
        if (KeyStoreStatus.AUTHENTICATED.equals(getModel().getKeystoreStatus())) {
            // close the key
            getModel().setKeystoreStatus(KeyStoreStatus.NOT_AUTHENTICATED);
            getModel().setKeystorePassword(null);
            getModel().setLicenseRequest(null);
            clearModel();
        } else {

            try {
                final URL privateKeyUrl = getModel().getPrivateKeyUrl();
                final String keystorePassword = getModel().getKeystorePassword();
                PGPSignatureHelper helper = new PGPSignatureHelper();
                Optional<Long> skKeyId = helper.canUnlock(privateKeyUrl, keystorePassword.toCharArray());
                if (!skKeyId.isPresent()) {
                    ErrorDialog.openError(shell, "Keystore Error", "Cannot load Private key",
                            Policy.errorStatus("Cannot load Private key"));
                    return;
                }

                String keyId = Long.toHexString(skKeyId.get());
                getModel().setKeyId(keyId);
                getModel().setKeystoreStatus(KeyStoreStatus.AUTHENTICATED);

            } catch (Exception e) {
                Policy.logError(e);
                ErrorDialog.openError(shell, "Keystore Error", e.getMessage(), Policy.errorStatus(e));
            }
        }

    }

    private ControlDecoration createDecorator(Control control, List<ControlDecoration> decorations) {
        ControlDecoration controlDecoration = new ControlDecoration(control, SWT.LEFT | SWT.TOP);
        FieldDecoration fieldDecoration = FieldDecorationRegistry.getDefault()
                .getFieldDecoration(FieldDecorationRegistry.DEC_ERROR);

        controlDecoration.setImage(fieldDecoration.getImage());
        decorations.add(controlDecoration);
        return controlDecoration;
    }

    protected void selectLicenseDirectory(DataBindingContext ctx, OverviewPage overviewPage) {
        // DirectoryDialog dlg = new DirectoryDialog(overviewPage.getShell());
        // String directory = dlg.open();

    }

    public LicenseModel getModel() {
        return model;
    }

    public void setModel(LicenseModel model) {
        firePropertyChange(PROP_MODEL, this.model, this.model = model);
    }

    private void clearModel() {
        if (getModel() != null) {
            getModel().setName(null);
            getModel().setCompany(null);
            getModel().setEmail(null);
            getModel().setHardwareId(null);
            getModel().setLicenseNumber(null);
            getModel().setDateCreated(null);
            getModel().setLicenseResponse(null);
        }
        hideDecorations();
    }

    private void handleRequestDataUpdate(String msg, final Binding licenseNumberBinding, OverviewPage page) {
        msg = StringUtils.trimToEmpty(msg);
        if (StringUtils.isEmpty(msg)) {
            clearModel();
            licenseNumberBinding.validateTargetToModel();
            hideDecorations();
            return;
        }
        try {
            LicenseInfo li = LicenseManagerUtils.createFromRequest(msg, LicenseManagerUtils.REQUEST_MSG_HEADER,
                    LicenseManagerUtils.REQUEST_MSG_FOOTER);
            if (getModel() != null) {
                getModel().setName(li.getName());
                getModel().setCompany(li.getCompany());
                getModel().setEmail(li.getEmail());
                getModel().setDateCreated(li.getDateCreated());
                getModel().setHardwareId(li.getHwId());
                getModel().setDateValidUntil(DateUtils.addYears(new Date(), 1));
                licenseNumberBinding.validateTargetToModel();

            }
        } catch (ChecksumMismatchException e) {
            // ErrorDialog.openError(parent, dialogTitle, message, status)
            clearModel();
        }
    }

    @SuppressWarnings("unchecked")
    private <T, M> IObservableValue<T> observeDetail(IObservableValue<M> model, String propertyName) {
        IBeanValueProperty beanValueProperty = BeanProperties.value(propertyName);
        return beanValueProperty.observeDetail(model);
    }

}
