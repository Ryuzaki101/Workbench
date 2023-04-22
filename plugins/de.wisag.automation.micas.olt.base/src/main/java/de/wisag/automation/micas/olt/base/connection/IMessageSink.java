package de.wisag.automation.micas.olt.base.connection;

public interface IMessageSink {

    void sendStringToDevice(String string);

    void sendStringToUser(String string);

}
