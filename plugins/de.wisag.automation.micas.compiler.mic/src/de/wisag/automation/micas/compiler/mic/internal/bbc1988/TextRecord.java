package de.wisag.automation.micas.compiler.mic.internal.bbc1988;

class TextRecord {
    private final int number;
    private final int length;
    private final int offset;
    private String text;

    @Override
    public String toString() {
        return "TextRecord [number=" + this.number + ", length=" + this.length + ", offset=" + this.offset + "]";
    }

    TextRecord(int number, int length, int offset) {
        super();
        this.number = number;
        this.length = length;
        this.offset = offset;
    }

    public int getNumber() {
        return this.number;
    }

    public int getLength() {
        return this.length;
    }

    public int getOffset() {
        return this.offset;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

}