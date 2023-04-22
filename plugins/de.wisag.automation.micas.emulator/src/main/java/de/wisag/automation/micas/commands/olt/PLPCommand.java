package de.wisag.automation.micas.commands.olt;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;
import de.wisag.automation.micas.commands.ICommand;
import de.wisag.automation.micas.commands.MicasCommand;

public class PLPCommand extends MicasCommand implements ICommand {
    public PLPCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        String address = request.getArguments().iterator().next();
        // decimal address
        int adr = Integer.parseInt(address);
        getContext().getEngine().watchProcessImageRowValue(adr);
    }

}
