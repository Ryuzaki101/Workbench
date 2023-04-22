package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;

public class RCommand extends MicasCommand implements ICommand {
    public RCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        getContext().getLineReader().getTerminal().echo(false);
        try {
            String line;
            while ((line = getContext().getLineReader().readLine()) != null && !line.trim().isEmpty()) {
                System.out.println("pgm: " + line);
            }
        } finally {
            getContext().getLineReader().getTerminal().echo(true);
        }
        StringBuilder response = new StringBuilder();
        response.append("Tasks locked => do restart with Q").append(EOL);
        getContext().write(response.toString());
    }

}
