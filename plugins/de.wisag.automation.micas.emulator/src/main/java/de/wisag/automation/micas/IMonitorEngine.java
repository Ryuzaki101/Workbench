package de.wisag.automation.micas;

import java.util.List;

public interface IMonitorEngine {

    boolean isValidPasscode(String trim);

    void clearList();

    void watchBinaryValue(int address);

    void watchProcessImageRowValue(int adr);

    void watchFloatValue(int adr);

    List<WatchedValue> getWatchlistValues();

}
