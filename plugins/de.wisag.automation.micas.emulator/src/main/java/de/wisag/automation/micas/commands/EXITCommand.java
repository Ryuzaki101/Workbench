package de.wisag.automation.micas.commands;

import org.jline.reader.UserInterruptException;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;

public class EXITCommand extends MicasCommand implements ICommand {
    public EXITCommand(ClientContext context) {
        super(context);
    }

    @Override
    public void execute(CommandRequest request) {
        getContext().write("bye!");
        throw new UserInterruptException("");
    }

}
