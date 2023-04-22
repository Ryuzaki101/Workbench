package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.ClientContext;

public abstract class MicasCommand implements ICommand {
    private final ClientContext context;

    public ClientContext getContext() {
        return context;
    }

    public MicasCommand(ClientContext context) {
        super();
        this.context = context;
    }

}
