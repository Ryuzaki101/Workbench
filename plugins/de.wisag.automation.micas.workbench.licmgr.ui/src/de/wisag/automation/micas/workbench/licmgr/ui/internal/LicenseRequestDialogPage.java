package de.wisag.automation.micas.workbench.licmgr.ui.internal;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

public class LicenseRequestDialogPage extends Composite {
    private Text userName;
    private Text organisationName;
    private Text emailAddress;
    private Text licenseKey;
    private Button btnSendEmail;
    private Button btnCopyToClipboard;

    public LicenseRequestDialogPage(Composite parent, int style) {
        super(parent, style);
        setLayout(new GridLayout(1, false));

        Group grpAngabenZumBenutzer = new Group(this, SWT.NONE);
        grpAngabenZumBenutzer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
        grpAngabenZumBenutzer.setText("Schritt 1. Angaben zum Benutzer");
        grpAngabenZumBenutzer.setLayout(new GridLayout(2, false));

        Label lblName = new Label(grpAngabenZumBenutzer, SWT.NONE);
        lblName.setText("Name");

        userName = new Text(grpAngabenZumBenutzer, SWT.BORDER);
        userName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));

        Label lblFirma = new Label(grpAngabenZumBenutzer, SWT.NONE);
        lblFirma.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblFirma.setText("Firma");

        organisationName = new Text(grpAngabenZumBenutzer, SWT.BORDER);
        organisationName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
        organisationName.setEditable(true);

        Label lblEmail = new Label(grpAngabenZumBenutzer, SWT.NONE);
        lblEmail.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
        lblEmail.setText("E-Mail");

        emailAddress = new Text(grpAngabenZumBenutzer, SWT.BORDER);
        emailAddress.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

        Group grpLizenzanfrageVerschicken = new Group(this, SWT.NONE);
        grpLizenzanfrageVerschicken.setLayout(new GridLayout(2, true));
        grpLizenzanfrageVerschicken.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        grpLizenzanfrageVerschicken.setText("Schritt 2. Lizenzanfrage verschicken");

        Label lblSendenSieBitte = new Label(grpLizenzanfrageVerschicken, SWT.WRAP);
        lblSendenSieBitte.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
        lblSendenSieBitte.setText(
                "Senden Sie bitte eine Lizenzanfrage an Wisag \n" + "indem Sie direkt eine Email Verschicken (2.a) \n"
                        + "oder kopieren Sie die Anfrage in die Zwischenablage (2.b) \n"
                        + "und versenden die E-mail manuell an \"lizenz-anfrage@ba-i-help.de\"");

        btnSendEmail = new Button(grpLizenzanfrageVerschicken, SWT.NONE);
        btnSendEmail.setEnabled(false);
        btnSendEmail.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnSendEmail.setText("2.a Lizenzanfrage per E-Mail");

        btnCopyToClipboard = new Button(grpLizenzanfrageVerschicken, SWT.NONE);
        btnCopyToClipboard.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        btnCopyToClipboard.setText("In Zwischenablage kopieren (2.b)");

        Group grpLizenzschlsselEintragen = new Group(this, SWT.NONE);
        grpLizenzschlsselEintragen.setLayout(new GridLayout(1, false));
        grpLizenzschlsselEintragen.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
        grpLizenzschlsselEintragen.setText("Schritt 3. Warten auf Lizensschluessel");

        Label label = new Label(grpLizenzschlsselEintragen, SWT.WRAP);
        label.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
        label.setText("In der Antwort auf die Lizenzanfrage erhalten Sie\n"
                + "einen Lizenzschluessel, den Sie in Schritt 4 im Feld eintragen");

        Group grpSchrittLizenzschlssel = new Group(this, SWT.NONE);
        grpSchrittLizenzschlssel.setLayout(new GridLayout(1, false));
        grpSchrittLizenzschlssel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
        grpSchrittLizenzschlssel.setText("Schritt 4. Lizenzschluessel eintragen");

        Label lblTragenSieHier = new Label(grpSchrittLizenzschlssel, SWT.NONE);
        lblTragenSieHier.setText("Tragen Sie hier Ihren Lizenzschluessel ein");

        licenseKey = new Text(grpSchrittLizenzschlssel, SWT.BORDER | SWT.WRAP | SWT.V_SCROLL);
        GridData gd_licenseKey = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
        gd_licenseKey.heightHint = 200;
        licenseKey.setLayoutData(gd_licenseKey);
    }

    public Text getUserName() {
        return userName;
    }

    public Text getOrganisationName() {
        return organisationName;
    }

    public Text getEmailAddress() {
        return emailAddress;
    }

    public Text getLicenseKey() {
        return licenseKey;
    }

    public Button getBtnSendEmail() {
        return btnSendEmail;
    }

    public Button getBtnCopyToClipboard() {
        return btnCopyToClipboard;
    }
}
