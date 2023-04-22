package de.wisag.automation.micas.olt.internal.commands;

import java.util.List;

import de.wisag.automation.micas.olt.RemoteInterpreterExeption;

public abstract class DeviceCommand<T> implements IDeviceCommand<T> {
    @Override
    public abstract String getCommandline();

    @Override
    public abstract T execute(List<String> message);

    public T execute() throws RemoteInterpreterExeption {
        return null;
    }

}
