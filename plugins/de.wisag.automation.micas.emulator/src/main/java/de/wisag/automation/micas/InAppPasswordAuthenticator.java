package de.wisag.automation.micas;

import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.session.ServerSession;

/**
 * @author Maxim Kalina
 * @version $Id$
 */
public class InAppPasswordAuthenticator implements PasswordAuthenticator {
    @Override
    public boolean authenticate(String username, String password, ServerSession session) {
        return username != null && username.equals(password);
    }
}