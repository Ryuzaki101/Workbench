package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;

public class TDCommand extends MicasCommand implements ICommand {
    public TDCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        StringBuilder response = new StringBuilder();
        response.append("Tasks locked => do restart with Q").append(EOL);
        getContext().write(response.toString());
    }

}
