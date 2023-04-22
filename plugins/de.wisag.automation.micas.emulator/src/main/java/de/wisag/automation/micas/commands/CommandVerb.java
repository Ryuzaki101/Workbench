package de.wisag.automation.micas.commands;

public enum CommandVerb {
    /** */
    CHD,

    /** */
    GET,
    /** */
    DW,
    /** */
    FW,
    /** */
    W,
    /** Task Display */
    TD,
    /** Kill */
    K,
    /** Quit */
    Q,
    /** CD */
    CD,
    C,
    /** DUMP */
    DMP,
    /** Write Database */
    WDB,

    /** read eeprom data */
    CDE,
    /** PLD Loeschen der internen Variablenliste fuer den ONLINE-Test */
    PLD,
    /** PLG Abfragen der Werte der geladenen Adressen */
    PLG,
    /** PLF oooo Laden einer float Adresse oooo fuer den ONLINE-Test */
    PLF,
    /**
     * PLH oooo Laden einer binaeren Adresse oooo fuer den ONLINE-Test
     */
    PLH,
    /**
     * PLP zzz Laden einer Prozessabbildzeile zzz fuer den ONLINE-Test
     */
    PLP,
    /**
     * Einlesen eines INTEL-HEX-Files, Echo wird unterdr�ckt Befehl muss aber
     * mit CR abgeschlossen werden, bevor das File darauf geschoben wird
     */
    R,
    /** */
    Y,
    EXIT
}