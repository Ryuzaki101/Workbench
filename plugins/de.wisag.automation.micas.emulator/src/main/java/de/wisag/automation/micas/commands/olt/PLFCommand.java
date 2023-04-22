package de.wisag.automation.micas.commands.olt;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;
import de.wisag.automation.micas.commands.ICommand;
import de.wisag.automation.micas.commands.MicasCommand;

public class PLFCommand extends MicasCommand implements ICommand {
    public PLFCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        String address = request.getArguments().iterator().next();
        int adr = Integer.parseInt(address, 16);
        getContext().getEngine().watchFloatValue(adr);
    }

}
