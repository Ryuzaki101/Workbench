package de.wisag.automation.micas.common.ui.internal;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import de.wisag.automation.micas.common.ui.IMailSender;

public class DesktopMailSender implements IMailSender {
    @Override
    public IStatus sendMail(String to, String subject, String messageBody) {
        return sendDefaultMail(to, subject, messageBody);
    }

    protected IStatus sendDefaultMail(String to, String subject, String messageBody) {
        IStatus status = Status.OK_STATUS;
        if (Desktop.getDesktop().isSupported(Desktop.Action.MAIL)) {
            try {
                URI mailtoURI = new URI("mailto", String.format("%s?subject=%s&body=%s", to, subject, messageBody),
                        null);
                Desktop.getDesktop().mail(mailtoURI);
            } catch (URISyntaxException e) {
                status = Policy.errorStatus(e);

            } catch (IOException e) {
                status = Policy.errorStatus(e);
            }
        }
        return status;
    }

}
