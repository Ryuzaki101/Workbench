package de.wisag.automation.micas.olt.internal.commands;

import java.util.List;

public class DmpCommand extends DeviceCommand<String> {

    @Override
    public String getCommandline() {
        return "DMP /R";
    }

    @Override
    public String execute(List<String> message) {
        StringBuilder sb = new StringBuilder();
        for (String s : message) {
            sb.append(s).append("\r\n");
        }
        return sb.toString();
    }

}
