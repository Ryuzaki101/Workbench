package de.wisag.automation.micas.module.ui.forms;

import de.wisag.automation.micas.module.AttributeSpecification;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;

class AttributeSpecificationLocation {
    private final Task task;
    private final Page page;
    private final AttributeSpecification specification;

    AttributeSpecificationLocation(Task task, Page page, AttributeSpecification specification) {
        super();
        this.task = task;
        this.page = page;
        this.specification = specification;
    }

    public Task getTask() {
        return task;
    }

    public Page getPage() {
        return page;
    }

    public AttributeSpecification getSpecification() {
        return specification;
    }

    @Override
    public String toString() {
        return "AttributeSpecificationLocation [task=" + task + ", page=" + page + ", specification=" + specification
                + "]";
    }

}