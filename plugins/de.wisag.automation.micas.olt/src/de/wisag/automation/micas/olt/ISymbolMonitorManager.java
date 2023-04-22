package de.wisag.automation.micas.olt;

import java.util.List;

import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.rt.RtSymbol;

public interface ISymbolMonitorManager {

    IStatus monitorSymbols(List<RtSymbol> symbols);

    IStatus unmonitorSymbol(RtSymbol symbol);

    boolean isMonitoring(RtSymbol symbol);

    void enqueueValueUpdate(List<RtSymbol> symbols);

    IStatus unmonitorAllSymbols();

    MonitorModel getMonitorModel();

    IMicasDeviceManager getMicasDeviceManager();

    void pause(boolean shouldPause);

}
