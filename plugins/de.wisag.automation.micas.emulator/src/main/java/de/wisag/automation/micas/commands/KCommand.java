package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;

public class KCommand extends MicasCommand implements ICommand {
    public KCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        StringBuilder response = new StringBuilder();
        getContext().write(response.toString());
    }

}
