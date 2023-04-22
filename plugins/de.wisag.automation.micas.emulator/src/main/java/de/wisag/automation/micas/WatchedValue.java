package de.wisag.automation.micas;

public class WatchedValue {
    private final ValueTypes type;

    public ValueTypes getType() {
        return type;
    }

    private final int address;

    public WatchedValue(ValueTypes type, int address) {
        super();
        this.type = type;
        this.address = address;
    }

    public int getAddress() {
        return address;
    }

}
