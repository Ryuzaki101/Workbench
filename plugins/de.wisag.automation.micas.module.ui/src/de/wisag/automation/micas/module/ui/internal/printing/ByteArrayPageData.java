package de.wisag.automation.micas.module.ui.internal.printing;

public class ByteArrayPageData implements PageData {
    private final byte[] pageData;

    public ByteArrayPageData(byte[] pageData) {
        super();
        this.pageData = pageData;
    }

    @Override
    public byte[] getPageData() {
        return pageData;
    }

    public byte[] getByteArrayPageData() {
        return pageData;
    }

    @Override
    public boolean isRaw() {
        return true;
    }

}