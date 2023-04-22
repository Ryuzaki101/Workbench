package de.wisag.automation.micas;

import org.apache.sshd.common.Factory;
import org.apache.sshd.server.Command;

public class MicasMonitorShellFactory implements Factory<Command> {
    @Override
    public Command create() {
        return new MicasMonitorShell();
    }
}