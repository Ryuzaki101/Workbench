package de.wisag.automation.micas.workbench.licmgr.ui.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class ShowLicenseDialogPage extends Composite {
    private Button btnRequestLicense;
    private Text txtLicenseStatus;
    private Text txtName;
    private Text txtCompany;
    private Text txtEmail;
    private Text txtDateCreated;
    private Text txtValidUtil;
    private Text txtValidForVersion;
    private Text txtLicenseNumber;
    private Group grpInformation;
    private Text txtInfo;
    private Label lblLizenzVerzeichnis;
    private Text txtLicenseDir;
    private Button btnDropLicenseData;
    private Button btnExportLicense;

    public ShowLicenseDialogPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(3, false));

        Label lblNewLabel = new Label(this, SWT.NONE);
        lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel.setText("Lizenzstatus:");

        txtLicenseStatus = new Text(this, SWT.BORDER);
        txtLicenseStatus.setEditable(false);
        txtLicenseStatus.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        btnRequestLicense = new Button(this, SWT.NONE);
        GridData gd_btnRequestLicense = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_btnRequestLicense.widthHint = 140;
        btnRequestLicense.setLayoutData(gd_btnRequestLicense);
        btnRequestLicense.setText("Lizenz anfordern ...");

        Label lblNewLabel_7 = new Label(this, SWT.NONE);
        lblNewLabel_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_7.setAlignment(SWT.RIGHT);
        lblNewLabel_7.setText("Lizenznummer :");

        txtLicenseNumber = new Text(this, SWT.BORDER);
        txtLicenseNumber.setEditable(false);
        txtLicenseNumber.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        btnDropLicenseData = new Button(this, SWT.NONE);
        GridData gd_btnDropLicenseData = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_btnDropLicenseData.widthHint = 140;
        btnDropLicenseData.setLayoutData(gd_btnDropLicenseData);
        btnDropLicenseData.setText("Lizenz loeschen ...");

        Label lblNewLabel_1 = new Label(this, SWT.NONE);
        lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_1.setText("Name :");

        txtName = new Text(this, SWT.BORDER);
        txtName.setEditable(false);
        txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        btnExportLicense = new Button(this, SWT.NONE);
        GridData gd_btnExportLicense = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
        gd_btnExportLicense.widthHint = 140;
        btnExportLicense.setLayoutData(gd_btnExportLicense);
        btnExportLicense.setText("Lizenz exportieren ...");

        Label lblNewLabel_2 = new Label(this, SWT.NONE);
        lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_2.setText("Firma :");

        txtCompany = new Text(this, SWT.BORDER);
        txtCompany.setEditable(false);
        txtCompany.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(this, SWT.NONE);

        Label lblNewLabel_3 = new Label(this, SWT.NONE);
        lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_3.setText("E-Mail :");

        txtEmail = new Text(this, SWT.BORDER);
        txtEmail.setEditable(false);
        txtEmail.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(this, SWT.NONE);

        Label lblNewLabel_4 = new Label(this, SWT.NONE);
        lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_4.setText("Erstellt am :");

        txtDateCreated = new Text(this, SWT.BORDER);
        txtDateCreated.setEditable(false);
        txtDateCreated.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(this, SWT.NONE);

        Label lblNewLabel_5 = new Label(this, SWT.NONE);
        lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_5.setText("Gueltig bis :");

        txtValidUtil = new Text(this, SWT.BORDER);
        txtValidUtil.setEditable(false);
        txtValidUtil.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(this, SWT.NONE);

        Label lblNewLabel_6 = new Label(this, SWT.NONE);
        lblNewLabel_6.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblNewLabel_6.setText("Gueltig für Version :");

        txtValidForVersion = new Text(this, SWT.BORDER);
        txtValidForVersion.setEditable(false);
        txtValidForVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        new Label(this, SWT.NONE);

        lblLizenzVerzeichnis = new Label(this, SWT.NONE);
        lblLizenzVerzeichnis.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblLizenzVerzeichnis.setText("Lizenz Verzeichnis:");

        txtLicenseDir = new Text(this, SWT.BORDER | SWT.READ_ONLY);
        txtLicenseDir.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

        grpInformation = new Group(this, SWT.NONE);
        grpInformation.setText("Information");
        grpInformation.setLayout(new FillLayout(SWT.HORIZONTAL));
        GridData gd_grpInformation = new GridData(SWT.FILL, SWT.FILL, false, true, 3, 1);
        gd_grpInformation.heightHint = 150;
        grpInformation.setLayoutData(gd_grpInformation);

        txtInfo = new Text(grpInformation, SWT.BORDER);
    }

    public Button getBtnRequestLicense() {
        return btnRequestLicense;
    }

    public Text getTxtLicenseStatus() {
        return txtLicenseStatus;
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

    public Text getTxtDateCreated() {
        return txtDateCreated;
    }

    public Text getTxtValidUtil() {
        return txtValidUtil;
    }

    public Text getTxtValidForVersion() {
        return txtValidForVersion;
    }

    public Text getTxtInfo() {
        return txtInfo;
    }

    public Text getTxtLicenseDir() {
        return txtLicenseDir;
    }

    public Button getBtnDropLicenseData() {
        return btnDropLicenseData;
    }

    public Button getBtnExportLicense() {
        return btnExportLicense;
    }
}
