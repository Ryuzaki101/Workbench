package de.wisag.automation.micas.olt.internal.commands;

import java.util.List;

public interface IDeviceCommand<T> {
    public abstract String getCommandline();

    public abstract T execute(List<String> message);
}
