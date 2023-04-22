package de.wisag.automation.micas.common.licensing;

public enum Feature {
    /** Workbench invokes old mic.exe */
    OLD_MIC("69a9bc20-5416-11e0-b8af-0800200c9a66"),

    /** Workbench can use onlinetests */
    ONLINETEST("70d69680-5416-11e0-b8af-0800200c9a66"),

    /** h86 Files can be uploaded */
    H86_UPLOAD("772f30f0-5416-11e0-b8af-0800200c9a66"),

    /** h86 Files can be downloaded */
    H86_DOWNLOAD("7c1b4310-5416-11e0-b8af-0800200c9a66"),

    /** h86 Files will be generated */
    H86_GENERATION("823d6430-5416-11e0-b8af-0800200c9a66");

    private final String id;

    Feature(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
