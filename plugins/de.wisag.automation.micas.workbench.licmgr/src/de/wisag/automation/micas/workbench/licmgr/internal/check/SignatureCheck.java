package de.wisag.automation.micas.workbench.licmgr.internal.check;

import java.io.IOException;
import java.net.URL;

import org.bouncycastle.openpgp.PGPException;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.licensing.LicenseInfo;
import de.wisag.automation.micas.workbench.licmgr.internal.Policy;
import de.wisag.automation.micas.workbench.licmgr.utils.LicenseManagerUtils;
import de.wisag.automation.micas.workbench.licmgr.utils.PGPSignatureHelper;

public class SignatureCheck {

    private URL publicKeyUrl;

    public SignatureCheck(URL publicKeyUrl) {
        this.publicKeyUrl = publicKeyUrl;
    }

    public IStatus check(LicenseInfo info) {
        Assert.isNotNull(info, "'info' must not be null");
        try {
            return check(info.getSignature(), LicenseManagerUtils.createLicenseHash(info));
        } catch (IOException e) {
            return Policy.errorStatus(e.getMessage(), e);
        } catch (PGPException e) {
            return Policy.errorStatus(e.getMessage(), e);
        }
    }

    public IStatus check(String signature, String data) throws IOException, PGPException {
        Assert.isNotNull(signature, "'info.signature' must not be null");
        PGPSignatureHelper helper = new PGPSignatureHelper();
        boolean valid = helper.verify(data, signature, publicKeyUrl);
        if (!valid) {
            return Policy.errorStatus("Invalid License");
        }
        return Status.OK_STATUS;
    }
}
