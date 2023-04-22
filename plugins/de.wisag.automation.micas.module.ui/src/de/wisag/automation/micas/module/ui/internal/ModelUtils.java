package de.wisag.automation.micas.module.ui.internal;

import de.wisag.automation.micas.module.ReferenceType;

public class ModelUtils {

    public static String referenceTypeToDisplayName(ReferenceType referenceType) {
        String displayName = "";
        switch (referenceType) {
        case FGA_ANALOG_VALUE:
            displayName = "Analogwert";
            break;
        case FGA_MEASURED_VALUE:
            displayName = "Messwert";
            break;
        case FGA_MESSAGE_CONST:
            displayName = "Meldung/Befehl";
            break;
        case FGA_VALUE:
            displayName = "Zählwert";
            break;

        default:
            break;
        }
        return displayName;
    }

}
