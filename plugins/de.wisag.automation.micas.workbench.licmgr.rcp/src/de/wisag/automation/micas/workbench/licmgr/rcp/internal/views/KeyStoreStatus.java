package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

enum KeyStoreStatus {
    AUTHENTICATED("BEREIT"), //
    NOT_AUTHENTICATED("NICHT BEREIT");

    private final String status;

    private KeyStoreStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}