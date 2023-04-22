package de.wisag.automation.micas.olt.internal;

public class DeviceManagerFilterUtils {

    /**
     * The method checks, if a non number string, received from the devices
     * should be passed to the ui.
     *
     * @param s
     * @return
     */
    static boolean isDefinedStragePlgAnswer(String s) {
        return "*.*".equals(s) || "NaN".equalsIgnoreCase(s);
    }

}
