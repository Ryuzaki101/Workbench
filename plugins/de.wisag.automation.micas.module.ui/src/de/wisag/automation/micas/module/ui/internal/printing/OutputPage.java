package de.wisag.automation.micas.module.ui.internal.printing;

import de.wisag.automation.micas.module.Page;

public class OutputPage {
    public enum Type {
        BANNER, CONTENT, PAGE, FKGLISTING
    }

    private final Type type;
    private final Page page;
    private int pageNumber;
    private final PageData pageDataContent;

    private PageData finalPageData;

    public OutputPage(Type type, Page page, int no, PageData pageData) {
        super();
        this.type = type;
        this.page = page;
        this.pageNumber = no;
        this.pageDataContent = pageData;
    }

    public int getNo() {
        return pageNumber;
    }

    public PageData getPageData() {
        return pageDataContent;
    }

    public Page getPage() {
        return page;
    }

    public Type getType() {
        return type;
    }

    public String getTitle() {
        if (getType() == Type.PAGE) {
            return String.format("%s", getPage().getName());
        } else if (getType() == Type.FKGLISTING) {
            return String.format("FKG's %s", getPage().getName());
        } else if (getType() == Type.CONTENT) {
            return String.format("Inhaltsverzeichnis", getPage().getName());
        }
        return "";

    }

    public PageData getFinalPageData() {
        return finalPageData;
    }

    public void setFinalPageData(PageData finalPageData) {
        this.finalPageData = finalPageData;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}