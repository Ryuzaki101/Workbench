package de.wisag.automation.micas.olt.internal.terminal.provisional.api;

public interface IDeviceReadCallback {
    public String getCommand();

    public void processResult(String text);
}
