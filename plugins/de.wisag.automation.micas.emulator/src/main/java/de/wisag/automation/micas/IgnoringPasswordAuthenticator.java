package de.wisag.automation.micas;

import org.apache.sshd.server.auth.password.PasswordAuthenticator;
import org.apache.sshd.server.auth.password.PasswordChangeRequiredException;
import org.apache.sshd.server.session.ServerSession;

public class IgnoringPasswordAuthenticator implements PasswordAuthenticator {

    /**
     * Handle username/password authentication here.
     */
    @Override
    public boolean authenticate(String username, String password, ServerSession session)
            throws PasswordChangeRequiredException {
        return true; // lax security 😉
    }

}