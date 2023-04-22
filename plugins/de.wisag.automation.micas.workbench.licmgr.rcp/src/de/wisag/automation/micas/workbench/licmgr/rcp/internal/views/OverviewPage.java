package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class OverviewPage extends Composite {
    private Text txtPrivateKeyUrl;
    private Button btnSelectDir;
    private Text txtKeyStatus;
    private Text txtKeyPassword;
    private Text txtLicenseRequest;
    private Text txtLicenseResponse;
    private Text txtLicenseNumber;
    private Text txtName;
    private Text txtDateCreated;
    private Text txtCompany;
    private Text txtEmail;
    private DateTime txtDateValidUntil;
    private Combo txtValidForVersion;
    private Combo txtValidForProduct;
    private Button btnGenerateLicense;
    private Button btnCopyLicense;
    private Button btnOpenKey;
    private Label lblHwid;
    private Text txtHardwareId;
    private Button btnSendLicense;
    private Label lblNewLabel_6;
    private Composite composite_1;
    private Button btnBtnClearRequest;

    public OverviewPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));

        Group grpSettings = new Group(this, SWT.NONE);
        grpSettings.setLayout(new GridLayout(4, false));
        grpSettings.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        grpSettings.setText("Einstellungen");

        Label lblLizenzverzeichnis = new Label(grpSettings, SWT.NONE);
        lblLizenzverzeichnis.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblLizenzverzeichnis.setText("Private Key");

        txtPrivateKeyUrl = new Text(grpSettings, SWT.BORDER);
        txtPrivateKeyUrl.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        btnSelectDir = new Button(grpSettings, SWT.NONE);
        btnSelectDir.setEnabled(false);
        btnSelectDir.setText("Wählen...");

        Group grpSchlsselbund = new Group(grpSettings, SWT.NONE);
        grpSchlsselbund.setText("Schlüsselbundstatus");
        grpSchlsselbund.setLayout(new GridLayout(5, false));
        grpSchlsselbund.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));

        Label lblStatus = new Label(grpSchlsselbund, SWT.NONE);
        lblStatus.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblStatus.setText("Status :");

        txtKeyStatus = new Text(grpSchlsselbund, SWT.BORDER);

        Label lblNewLabel = new Label(grpSchlsselbund, SWT.NONE);
        lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel.setText("Passwort:");

        txtKeyPassword = new Text(grpSchlsselbund, SWT.BORDER | SWT.PASSWORD);
        txtKeyPassword.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        btnOpenKey = new Button(grpSchlsselbund, SWT.NONE);
        GridData gd_btnOpenKey = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_btnOpenKey.widthHint = 140;
        btnOpenKey.setLayoutData(gd_btnOpenKey);
        btnOpenKey.setText("Schlüssel Entsprerren");

        SashForm sashForm = new SashForm(this, SWT.VERTICAL);
        sashForm.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        composite_1 = new Composite(sashForm, SWT.NONE);
        composite_1.setLayout(new GridLayout(1, false));

        txtLicenseRequest = new Text(composite_1, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
        txtLicenseRequest.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        btnBtnClearRequest = new Button(composite_1, SWT.NONE);
        GridData gd_btnBtnClearRequest = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_btnBtnClearRequest.widthHint = 120;
        btnBtnClearRequest.setLayoutData(gd_btnBtnClearRequest);
        btnBtnClearRequest.setText("Zurücksetzen");

        Group group = new Group(sashForm, SWT.NONE);
        GridLayout gl_group = new GridLayout(5, false);
        gl_group.horizontalSpacing = 10;
        group.setLayout(gl_group);

        Label lblNewLabel_1 = new Label(group, SWT.NONE);
        lblNewLabel_1.setAlignment(SWT.RIGHT);
        lblNewLabel_1.setText("Lizenznummer:");

        txtLicenseNumber = new Text(group, SWT.BORDER);
        txtLicenseNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(group, SWT.NONE);

        Label lblNewLabel_4 = new Label(group, SWT.NONE);
        lblNewLabel_4.setText("Erstellt am:");

        txtDateCreated = new Text(group, SWT.BORDER | SWT.DROP_DOWN);
        txtDateCreated.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblNewLabel_2 = new Label(group, SWT.NONE);
        lblNewLabel_2.setAlignment(SWT.RIGHT);
        lblNewLabel_2.setText("Name:");

        txtName = new Text(group, SWT.BORDER);
        txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(group, SWT.NONE);

        Label lblGltigBis = new Label(group, SWT.NONE);
        lblGltigBis.setText("Gültig bis:");

        txtDateValidUntil = new DateTime(group, SWT.BORDER | SWT.DROP_DOWN);
        txtDateValidUntil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        Label lblNewLabel_3 = new Label(group, SWT.NONE);
        lblNewLabel_3.setAlignment(SWT.RIGHT);
        lblNewLabel_3.setText("Firma:");

        txtCompany = new Text(group, SWT.BORDER);
        txtCompany.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(group, SWT.NONE);

        Label lblGltigFrVersion = new Label(group, SWT.NONE);
        lblGltigFrVersion.setText("Gültig fuer Version:");

        txtValidForVersion = new Combo(group, SWT.READ_ONLY);
        txtValidForVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Label lblEmail = new Label(group, SWT.NONE);
        lblEmail.setText("E-Mail:");

        txtEmail = new Text(group, SWT.BORDER);
        txtEmail.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(group, SWT.NONE);

        Label lblNewLabel_5 = new Label(group, SWT.NONE);
        lblNewLabel_5.setText("Gültig fuer Produkt:");

        txtValidForProduct = new Combo(group, SWT.READ_ONLY);
        txtValidForProduct.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        lblHwid = new Label(group, SWT.NONE);
        lblHwid.setText("HW-Id:");

        txtHardwareId = new Text(group, SWT.BORDER);
        txtHardwareId.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(group, SWT.NONE);
        new Label(group, SWT.NONE);

        btnGenerateLicense = new Button(group, SWT.NONE);
        GridData gd_btnGenerateLicense = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_btnGenerateLicense.widthHint = 120;
        btnGenerateLicense.setLayoutData(gd_btnGenerateLicense);
        btnGenerateLicense.setText("Lizenz erzeugen");

        Composite composite = new Composite(sashForm, SWT.NONE);
        composite.setLayout(new GridLayout(3, false));

        txtLicenseResponse = new Text(composite, SWT.BORDER | SWT.V_SCROLL | SWT.MULTI);
        txtLicenseResponse.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
        txtLicenseResponse.setEditable(false);

        lblNewLabel_6 = new Label(composite, SWT.NONE);
        lblNewLabel_6.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));

        btnSendLicense = new Button(composite, SWT.NONE);
        GridData gd_btnSendLicense = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_btnSendLicense.widthHint = 120;
        btnSendLicense.setLayoutData(gd_btnSendLicense);
        btnSendLicense.setText("Verschicken");

        btnCopyLicense = new Button(composite, SWT.NONE);
        GridData gd_btnCopyLicense = new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1);
        gd_btnCopyLicense.widthHint = 120;
        btnCopyLicense.setLayoutData(gd_btnCopyLicense);
        btnCopyLicense.setText("Kopieren");
        // sashForm.setWeights(new int[] {157, 156, 152, 160});

    }

    public Text getTxtKeyPassword() {
        return txtKeyPassword;
    }

    public Text getTxtKeyStatus() {
        return txtKeyStatus;
    }

    public Text getTxtLicenseRequest() {
        return txtLicenseRequest;
    }

    public Text getTxtLicenseNumber() {
        return txtLicenseNumber;
    }

    public Text getTxtName() {
        return txtName;
    }

    public Text getTxtCompany() {
        return txtCompany;
    }

    public Text getTxtEmail() {
        return txtEmail;
    }

    public DateTime getDtDateValidUntil() {
        return txtDateValidUntil;
    }

    public Combo getCmbValidForVersion() {
        return txtValidForVersion;
    }

    public Combo getCmbValidForProduct() {
        return txtValidForProduct;
    }

    public Button getBtnGenerateLicense() {
        return btnGenerateLicense;
    }

    public Text getTxtLicenseResponse() {
        return txtLicenseResponse;
    }

    public Button getBtnCopyLicense() {
        return btnCopyLicense;
    }

    public Button getBtnSelectDir() {
        return btnSelectDir;
    }

    public Button getBtnOpenKey() {
        return btnOpenKey;
    }

    public Text getTxtPrivateKeyUrl() {
        return txtPrivateKeyUrl;
    }

    public Text getTxtHardwareId() {
        return txtHardwareId;
    }

    public Button getBtnSendLicense() {
        return btnSendLicense;
    }

    public Text getTxtDateCreated() {
        return txtDateCreated;
    }

    public Button getBtnBtnClearRequest() {
        return btnBtnClearRequest;
    }
}
