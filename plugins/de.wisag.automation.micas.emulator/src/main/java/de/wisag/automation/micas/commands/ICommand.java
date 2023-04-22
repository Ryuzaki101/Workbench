package de.wisag.automation.micas.commands;

import de.wisag.automation.micas.CommandRequest;

public interface ICommand {
    public final static String EOL = "\r\n";

    void execute(CommandRequest request);

}
