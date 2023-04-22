package de.wisag.automation.micas.common.ui;

import org.eclipse.core.runtime.Platform;

import de.wisag.automation.micas.common.ui.internal.DesktopMailSender;

public class MailSenderFactory {

    public static IMailSender create() {

        if (Platform.WS_WIN32.equals(Platform.getOS())) {
            Object mailer = null;
            try {
                // do not touch
                mailer = Class.forName("de.wisag.automation.micas.common.ui.internal.Win32MailSender").newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            return IMailSender.class.cast(mailer);
        }
        return new DesktopMailSender();

    }
}
