package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;

public class CHDCommand extends MicasCommand implements ICommand {

    public CHDCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        StringBuilder response = new StringBuilder();
        response.append("Device : 002   Selected fieldbus device (1 ... 032 ) : 002").append(EOL);
        response.append("Selectable fieldbus devices :").append(EOL);
        response.append("002").append(EOL);
        response.append("003").append(EOL);
        response.append("004").append(EOL);
        response.append("005").append(EOL);
        getContext().write(response.toString());
    }

}
