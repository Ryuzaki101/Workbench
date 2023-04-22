package de.wisag.automation.micas;

import java.util.List;

import de.wisag.automation.micas.commands.CommandVerb;

public class CommandRequest {
    public CommandVerb getVerb() {
        return verb;
    }

    public List<String> getArguments() {
        return arguments;
    }

    private CommandVerb verb;
    private List<String> arguments;

    public CommandRequest(CommandVerb verb, List<String> arguments) {
        super();
        this.verb = verb;
        this.arguments = arguments;
    }
}