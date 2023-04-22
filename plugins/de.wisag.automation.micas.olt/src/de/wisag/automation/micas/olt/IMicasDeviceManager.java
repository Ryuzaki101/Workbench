package de.wisag.automation.micas.olt;

import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.rt.RtSymbol;

public interface IMicasDeviceManager {

    /**
     * @param monitor
     *            - for long running operations
     * @return current device information
     */
    DeviceInfo getDeviceInfo(IProgressMonitor monitor);

    /**
     * @param monitor
     *            for long running operations
     * @param di
     * @return
     * @throws MicasDeviceManagerException
     */
    String fetchCurrentMicasProgram(IProgressMonitor monitor, DeviceInfo di) throws MicasDeviceManagerException;

    /**
     * @param monitor
     *            for long running operations
     * @param h86Data
     * @param deviceNumber
     * @param stopAndReboot
     * @return
     */
    IStatus sendMicasProgram(IProgressMonitor monitor, String h86Data, int deviceNumber, boolean stopAndReboot);

    /**
     * @param monitor
     *            TODO
     * @return
     * @throws RemoteInterpreterExeption
     */
    boolean killTasks(IProgressMonitor monitor) throws RemoteInterpreterExeption;

    /**
     * @param symbols
     * @return
     */
    IStatus monitorSymbols(List<RtSymbol> symbols);

    /**
     * @return the list of current values
     * @throws IOException
     */
    List<String> queryMonitoredSymbolValues() throws IOException;

    /**
     * @param symbols
     *            the symbols to update
     * @return
     */
    IStatus enqueueValueUpdate(List<RtSymbol> symbols);

    /**
     * clear the value update queue
     */
    void clear();

    IStatus completeDeviceInfo(IProgressMonitor monitor, DeviceInfo deviceInfo);

    /**
     * Delete the list of monitored symbols
     *
     * @return
     */
    IStatus clearMonitoredSymbols();
}
