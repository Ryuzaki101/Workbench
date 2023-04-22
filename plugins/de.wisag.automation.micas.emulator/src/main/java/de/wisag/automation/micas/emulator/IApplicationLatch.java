package de.wisag.automation.micas.emulator;

public interface IApplicationLatch {
    public void signalShutdown();

    public void awaitShutdown();
}
