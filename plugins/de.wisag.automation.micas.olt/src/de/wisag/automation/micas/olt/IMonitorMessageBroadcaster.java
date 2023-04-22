package de.wisag.automation.micas.olt;

import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;

public interface IMonitorMessageBroadcaster {

    /**
     * @param monitorModel
     *            - monitor model to post A Copy is posted
     */
    void postEndEvent(MonitorModel monitorModel);

    void postResumeEvent(MonitorModel monitorModel);

    void postPauseEvent(MonitorModel monitorModel);

    void postStartEvent(MonitorModel monitorModel);

    void postUpdateEvent(MonitorModel monitorModel, MonitoredValueSet set);

    void postConnectedEvent();

    void postUnconnectedEvent();

}
