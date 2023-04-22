package de.wisag.automation.micas.diagram.ui.figures;

public class MergedCell {
    private final int startRowIndex;
    private final int startColumnIndex;
    private final int endRowIndex;
    private final int endColumnIndex;

    public MergedCell(int startRowIndex, int startColumnIndex, int endRowIndex, int endColumnIndex) {
        this.startColumnIndex = startColumnIndex;
        this.startRowIndex = startRowIndex;
        this.endColumnIndex = endColumnIndex;
        this.endRowIndex = endRowIndex;
    }

    public int getStartRowIndex() {
        return startRowIndex;
    }

    public int getStartColumnIndex() {
        return startColumnIndex;
    }

    public int getEndRowIndex() {
        return endRowIndex;
    }

    public int getEndColumnIndex() {
        return endColumnIndex;
    }
}