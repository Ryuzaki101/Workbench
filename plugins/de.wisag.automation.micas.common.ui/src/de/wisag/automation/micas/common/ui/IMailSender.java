package de.wisag.automation.micas.common.ui;

import org.eclipse.core.runtime.IStatus;

public interface IMailSender {

    /**
     * Send an email to the given adress
     *
     * @param to
     *            the mail address to send to
     * @param cc
     * @param messageBody
     *            the message
     * @return status of operation
     */
    IStatus sendMail(String to, String subject, String messageBody);

}