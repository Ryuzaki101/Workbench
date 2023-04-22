package de.wisag.automation.micas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class MicasMonitoringEngine implements IMonitorEngine {
    private final List<WatchedValue> currentList = new ArrayList<>();

    @Override
    public boolean isValidPasscode(String trim) {
        return true;
    }

    @Override
    public void clearList() {
        currentList.clear();

    }

    @Override
    public void watchBinaryValue(int address) {
        currentList.add(new WatchedValue(ValueTypes.BINARY, address));
    }

    @Override
    public void watchProcessImageRowValue(int address) {
        currentList.add(new WatchedValue(ValueTypes.PROCESS_IMAGE, address));
    }

    @Override
    public void watchFloatValue(int address) {
        currentList.add(new WatchedValue(ValueTypes.FLOAT, address));
    }

    @Override
    public List<WatchedValue> getWatchlistValues() {
        return Collections.unmodifiableList(currentList);
    }
}