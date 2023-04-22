package de.wisag.automation.micas.olt.internal;

public interface DeviceCommands {

    /**
     * <code>DWs:oLl</code> Wortweiser Display der Laenge l ab der Startadresse
     * s:o Anscheinend kein WS nach DW
     */
    public final static String CMD_DW = "DW";

    public static final String CMD_FW = "FW";

    /**
     * Schreiben eines INTEL-HEX-Files ab Adresse s:o der Länge l Das aus der
     * Sicht des Zentralprozessors zum PC bzw. Bediener. Der Offset wird in das
     * nächstgelegene Segment umgerechnet! Bsp.: W 510:30 L 80 ergibt einen
     * Segmentrekord von 0513!
     */
    public static final String CMD_W = "W";
    /**
     * Abfrage der Konfigurationsdaten (steht auch ModId drin)
     */
    public static final String CMD_CD = "CD";
    /**
     * Stoppen der MICAS-Tasks (alle Tasks im Bereich 1-99)
     */
    public static final String CMD_K = "K";
    /**
     * Restart eines Gerätes, wobei die Komponente über einen WDog- Reset
     * gezielt gestartet wird. Dazu muss der WDog aktiviert sein. Dieser ist
     * nach dem Laden von MICAS (oder auch einer DB auf dem Gerät #2) notwendig
     */
    public static final String CMD_Q = "Q";
    /**
     * Einlesen eines INTEL-HEX-Files, Echo wird unterdrückt Befehl muss aber
     * mit CR abgeschlossen werden, bevor das File darauf geschoben wird
     */
    public static final String CMD_R = "R";
    /** Setzen des Arbeitssegmentes */
    public static final String CMD_Y = "Y=";

    /**
     * SF s:o(=v) Setzen der Adresse s:o mit dem Floatwert v, es gilt sonst das
     * Gleiche wie für den SW-Befehl
     */
    public static final String CMD_SF = "SF";

    /**
     * Set word value Setzen eines Wortes oder Binärwertes (16-Bit-Variable)
     */
    public static final String CMD_SW = "SW";

    /**
     * ohne Argumente : Anzeige der aktiven Geräte am Feldbus<br/>
     * mit argument ddd : Anwahl eines Gerätes dd am Feldbus
     */
    public static final String CMD_CHD = "CHD";
    /** PLD Loeschen der internen Variablenliste fuer den ONLINE-Test */
    public static final String CMD_PLD = "PLD";
    /** PLG Abfragen der Werte der geladenen Adressen */
    public static final String CMD_PLG = "PLG";

    /** PLF oooo Laden einer float Adresse oooo fuer den ONLINE-Test */
    public static final String CMD_PLF = "PLF";

    /** PLH oooo Laden einer binaeren Adresse oooo fuer den ONLINE-Test */
    public static final String CMD_PLH = "PLH";
    /** PLP zzz Laden einer Prozessabbildzeile zzz fuer den ONLINE-Test */
    public static final String CMD_PLP = "PLP";

}
