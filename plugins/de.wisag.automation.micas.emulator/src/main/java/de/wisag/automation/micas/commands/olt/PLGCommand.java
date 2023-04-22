package de.wisag.automation.micas.commands.olt;

import java.util.List;
import java.util.Random;

import org.jline.terminal.Attributes;

import de.wisag.automation.micas.ClientContext;
import de.wisag.automation.micas.CommandRequest;
import de.wisag.automation.micas.WatchedValue;
import de.wisag.automation.micas.commands.ICommand;
import de.wisag.automation.micas.commands.MicasCommand;

public class PLGCommand extends MicasCommand implements ICommand {
    public PLGCommand(ClientContext engine) {
        super(engine);
    }

    @Override
    public void execute(CommandRequest request) {
        List<WatchedValue> values = getContext().getEngine().getWatchlistValues();
        Random random = new Random();
        Attributes oldAttributes = getContext().getLineReader().getTerminal().enterRawMode();
        for (WatchedValue watchedValue : values) {
            String value = "";
            switch (watchedValue.getType()) {
            case BINARY:
                value = String.format("%d", random.nextInt());
                break;
            case FLOAT:
                value = String.format("%f", random.nextFloat());
                break;
            case PROCESS_IMAGE:
                value = String.format("%x", random.nextInt());
                break;
            default:
                break;
            }
            getContext().write(value);
            getContext().write(EOL);
        }
        getContext().getLineReader().getTerminal().setAttributes(oldAttributes);

    }

}
