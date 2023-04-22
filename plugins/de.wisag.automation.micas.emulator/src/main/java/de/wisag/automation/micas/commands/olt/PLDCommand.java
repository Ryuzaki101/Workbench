package de.wisag.automation.micas.commands.olt;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;
import de.wisag.automation.micas.commands.ICommand;
import de.wisag.automation.micas.commands.MicasCommand;

public class PLDCommand extends MicasCommand implements ICommand {
    public PLDCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        getContext().getEngine().clearList();
    }
}
