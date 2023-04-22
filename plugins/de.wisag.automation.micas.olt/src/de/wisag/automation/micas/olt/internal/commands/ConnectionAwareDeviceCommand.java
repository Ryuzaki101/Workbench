package de.wisag.automation.micas.olt.internal.commands;

import java.util.List;

import de.wisag.automation.micas.olt.IDeviceConnection;

public abstract class ConnectionAwareDeviceCommand<T> extends DeviceCommand<T> {
    private final IDeviceConnection connection;

    public ConnectionAwareDeviceCommand(IDeviceConnection connection) {
        super();
        this.connection = connection;
    }

    @Override
    public String getCommandline() {
        throw new UnsupportedOperationException("Operation not supported");
    }

    @Override
    public T execute(List<String> message) {
        throw new UnsupportedOperationException("Operation not supported");
    }

    public IDeviceConnection getConnection() {
        return connection;
    }

}
