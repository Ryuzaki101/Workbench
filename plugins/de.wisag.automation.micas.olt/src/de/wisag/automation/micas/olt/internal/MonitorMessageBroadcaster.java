package de.wisag.automation.micas.olt.internal;

import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_BEGIN_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_CONNECTED_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_END_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_PAUSE_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_RESUME_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_UNCONNECTED_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_UPDATE_TOPIC;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.event.Event;

import de.wisag.automation.micas.olt.IMonitorMessageBroadcaster;
import de.wisag.automation.micas.olt.ISymbolMonitorMessages;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;

public class MonitorMessageBroadcaster extends MonitorMessageBroadcasterBase implements IMonitorMessageBroadcaster {
    @Override
    public void postStartEvent(MonitorModel monitorModel) {
        postEvent(SYM_MONITOR_BEGIN_TOPIC, monitorModel);
    }

    @Override
    public void postUpdateEvent(MonitorModel monitorModel, MonitoredValueSet set) {
        postEvent(SYM_MONITOR_UPDATE_TOPIC, monitorModel, set);
    }

    private void postEvent(String topic, MonitorModel monitorModel, MonitoredValueSet... set) {
        Dictionary<String, Object> properties = new Hashtable<>();
        if (monitorModel != null) {
            properties.put(ISymbolMonitorMessages.PROP_MONITOR_MODEL, monitorModel);
        }
        if (set != null && set.length > 0) {
            properties.put(ISymbolMonitorMessages.PROP_MONITORED_VALUE_SET, set[0]);
        }
        getEventAdmin().postEvent(new Event(topic, properties));
    }

    @Override
    public void postPauseEvent(MonitorModel monitorModel) {
        postEvent(SYM_MONITOR_PAUSE_TOPIC, monitorModel);
    }

    @Override
    public void postResumeEvent(MonitorModel monitorModel) {
        postEvent(SYM_MONITOR_RESUME_TOPIC, monitorModel);
    }

    @Override
    public void postEndEvent(MonitorModel monitorModel) {
        postEvent(SYM_MONITOR_END_TOPIC, EcoreUtil.copy(monitorModel));
    }

    @Override
    public void postConnectedEvent() {
        postEvent(SYM_MONITOR_CONNECTED_TOPIC, null);

    }

    @Override
    public void postUnconnectedEvent() {
        postEvent(SYM_MONITOR_UNCONNECTED_TOPIC, null);

    }
}
