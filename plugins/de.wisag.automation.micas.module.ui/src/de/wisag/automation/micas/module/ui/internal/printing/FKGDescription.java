package de.wisag.automation.micas.module.ui.internal.printing;

import java.util.List;

import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.util.Row;

public class FKGDescription {
    private final String name;
    private final int index;
    private final List<Row> supportingPoints;
    private final Page page;

    public FKGDescription(String name, int index, List<Row> supportingPoints, Page page) {
        super();
        this.name = name;
        this.index = index;
        this.supportingPoints = supportingPoints;
        this.page = page;
    }

    public String getName() {
        return name;
    }

    public int getIndex() {
        return index;
    }

    public List<Row> getSupportingPoints() {
        return supportingPoints;
    }

    public Page getPage() {
        return page;
    }

}