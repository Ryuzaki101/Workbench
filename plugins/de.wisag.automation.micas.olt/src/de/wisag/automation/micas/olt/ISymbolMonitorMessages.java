package de.wisag.automation.micas.olt;

public interface ISymbolMonitorMessages {
    public static final String SYM_MONITOR_TOPIC = "symbolmonitor";
    public static final String SYM_MONITOR_ALL_TOPICS = String.format("%s/*", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_BEGIN_TOPIC = String.format("%s/begin", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_CONNECTED_TOPIC = String.format("%s/connected", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_UNCONNECTED_TOPIC = String.format("%s/unconnected", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_END_TOPIC = String.format("%s/end", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_PAUSE_TOPIC = String.format("%s/pause", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_RESUME_TOPIC = String.format("%s/resume", SYM_MONITOR_TOPIC);
    public static final String SYM_MONITOR_UPDATE_TOPIC = String.format("%s/update", SYM_MONITOR_TOPIC);
    public static final String PROP_MONITOR_MODEL = "$MONITOR_MODEL";
    public static final String PROP_MONITORED_VALUE_SET = "$MONITORED_VALUE_SET";
}
