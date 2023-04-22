package de.wisag.automation.micas.olt.internal;

import static de.wisag.automation.micas.olt.internal.DeviceCommands.CMD_CHD;
import static de.wisag.automation.micas.olt.internal.DeviceCommands.CMD_PLF;
import static de.wisag.automation.micas.olt.internal.DeviceCommands.CMD_PLH;
import static de.wisag.automation.micas.olt.internal.DeviceCommands.CMD_PLP;
import static de.wisag.automation.micas.olt.internal.DeviceCommands.CMD_Y;
import static java.util.Objects.requireNonNull;
import static org.apache.commons.lang.math.NumberUtils.isNumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.osgi.service.component.ComponentContext;

import de.wisag.automation.micas.hwmodules.HardwareType;
import de.wisag.automation.micas.hwmodules.HardwareTypeDefinition;
import de.wisag.automation.micas.hwmodules.IHwModulesProvider;
import de.wisag.automation.micas.olt.IDeviceConnection;
import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.MicasDeviceManagerException;
import de.wisag.automation.micas.olt.RemoteInterpreterExeption;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.internal.commands.FetchMicasProgrammCommand;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtModule;
import de.wisag.automation.micas.rt.RtReferenceConstant;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class DeviceManagerComponent extends DeviceManagerComponentBase implements IMicasDeviceManager {

    public enum ValueMonitoringStates {
        MONITORING, //
        CLEARED, //
        NOTHING
    }

    private static NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
    public static boolean DEBUG = true;
    public static final String ASTERIX = "*";

    private final List<RtSymbol> updateQueue = new CopyOnWriteArrayList<>();

    private final ReentrantLock deviceLock = new ReentrantLock();
    private Optional<DeviceInfo> cachedDeviceInfo = Optional.empty();

    private final MicasDeviceManagerAdapterFactory factory = new MicasDeviceManagerAdapterFactory(this);

    public void activate(ComponentContext context) throws Exception {
        this.cachedDeviceInfo = Optional.empty();
        // register an adapter, so we can access the device manager via
        // getAdapter on IFile *.h86
        getAdapterManager().registerAdapters(factory, IFile.class);
    }

    public void deactivate(ComponentContext context) throws Exception {
        getAdapterManager().unregisterAdapters(factory, IFile.class);
        this.cachedDeviceInfo = Optional.empty();
    }

    @Override
    public DeviceInfo getDeviceInfo(IProgressMonitor monitor) {
        deviceLock.lock();
        // dont query again.
        try (IDeviceConnection di = new DeviceConnection(getConnectedDevice())) {
            if (this.cachedDeviceInfo.isPresent()) {
                return this.cachedDeviceInfo.get();
            }
            try {
                this.cachedDeviceInfo = Optional.ofNullable(di.getDeviceInfo(monitor));
            } catch (RemoteInterpreterExeption e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new MicasDeviceManagerException(e);
        } finally {
            deviceLock.unlock();
        }
        return this.cachedDeviceInfo.get();

    }

    @Override
    public String fetchCurrentMicasProgram(IProgressMonitor monitor, DeviceInfo deviceInfo) {
        deviceLock.lock();
        try (IDeviceConnection di = new DeviceConnection(getConnectedDevice())) {
            Assert.isNotNull(deviceInfo, "deviceInfo " + deviceInfo);
            if (DEBUG) {
                System.err.println("Found device info " + deviceInfo);
            }
            HardwareType hardwareType = deviceInfo.getHardwareType();
            HardwareTypeDefinition hwType = IHwModulesProvider.INSTANCE.findHardwareTypeDefinition(hardwareType);
            Assert.isNotNull((hwType));
            if (DEBUG) {
                System.err.println("Got hardwaretype from model:" + hwType);
            }
            FetchMicasProgrammCommand fetchCommand = new FetchMicasProgrammCommand(di);
            fetchCommand.setDataSegment(hwType.getDataSegment());
            fetchCommand.setHeadSegment(hwType.getHeadSegment());
            fetchCommand.setProgramSegment(hwType.getProgramSegment());
            fetchCommand.setFieldBusNumber(deviceInfo.getFieldBus());
            try {
                return fetchCommand.execute();
            } catch (RemoteInterpreterExeption e) {
                throw new MicasDeviceManagerException(e);
            }
        } catch (IOException e) {
            throw new MicasDeviceManagerException(e);
        } finally {
            deviceLock.unlock();
        }
    }

    public boolean selectDevice(int deviceNumber) throws RemoteInterpreterExeption {
        boolean ok = false;
        deviceLock.lock();
        try (IDeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            // send command CHD and the device-number
            try {
                ok = con.sendAndExpect(String.format("%s %d", DeviceCommands.CMD_CHD, deviceNumber), "Device");
            } catch (IOException e) {
                throw new MicasDeviceManagerException(e);
            }
        } catch (IOException e) {
            throw new MicasDeviceManagerException(e);
        } finally {
            deviceLock.unlock();
        }
        return ok;
    }

    @Override
    public boolean killTasks(IProgressMonitor monitor) throws RemoteInterpreterExeption {
        // send command K (kill) to stop micas-tasks
        boolean ok = false;
        deviceLock.lock();
        try (DeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            try {
                ok = con.sendAndExpect(DeviceCommands.CMD_K, ASTERIX);
            } catch (IOException e) {
                throw new RemoteInterpreterExeption(e.getMessage(), e);
            }
        } catch (IOException e) {
            throw new MicasDeviceManagerException(e);
        } finally {
            deviceLock.unlock();
        }
        return ok;
    }

    @Override
    public IStatus sendMicasProgram(IProgressMonitor monitor, String h86Data, int deviceNumber, boolean stopAndReboot) {
        IStatus status = Status.OK_STATUS;
        deviceLock.lock();
        try (DeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            if (DEBUG) {
                System.out.println("RemoteInterpreter - sendMicasH86");
            }
            try {
                status = selectDevice(deviceNumber) ? Status.OK_STATUS
                        : new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Select device failed");
            } catch (RemoteInterpreterExeption e1) {
                return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Select device failed", e1);
            }
            try {
                status = killTasks(monitor) ? Status.OK_STATUS
                        : new Status(IStatus.ERROR, Activator.PLUGIN_ID, "kill tasks failed");
            } catch (RemoteInterpreterExeption e1) {
                return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "kill tasks failed", e1);
            }
            // send command R (read) and read the input-stream
            con.sendLine(DeviceCommands.CMD_R);
            try (BufferedReader br = new BufferedReader(new StringReader(h86Data))) {
                String line = null;
                while ((line = br.readLine()) != null) {
                    con.sendLine(line);
                }
                boolean doRestart = con.sendAndExpect("\r\n", "do restart with Q",
                        "Do Coldstart and choose device again");
                if (doRestart) {
                    con.sendLine(DeviceCommands.CMD_Q);
                } else {
                    return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Restart after programm transmission failed");
                }
            } catch (IOException e) {
                return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "kill tasks failed", e);
            } finally {
            }
        } catch (IOException e) {
            throw new MicasDeviceManagerException(e);
        } finally {
            deviceLock.unlock();
        }
        return status;
    }

    @Override
    public IStatus monitorSymbols(List<RtSymbol> symbols) {
        requireNonNull(symbols, "'symbols'");
        if (symbols.isEmpty()) {
            return Status.OK_STATUS;
        }
        deviceLock.lock();
        try (IDeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            // clear symbollist

            RtModule module = symbols.iterator().next().getModule();
            // select device, which should be monitored
            try {
                con.sendAndExpect(String.format("%s %d", CMD_CHD, module.getFieldBus()), "Device");
            } catch (IOException e) {
                return Policy.errorStatus(e);
            }
            // delete list of monitored symbols on device
            try {
                con.sendAndExpect(DeviceCommands.CMD_PLD, ASTERIX);
            } catch (IOException e) {
                return Policy.errorStatus(e);
            }
            int dataSegment = module.getDataSegmentAddress();
            try {
                con.sendAndExpect(String.format("%s %04x", CMD_Y, dataSegment), ASTERIX);
            } catch (IOException e) {
                return Policy.errorStatus(e);
            }

            for (RtSymbol rtSymbol : symbols) {
                if (rtSymbol instanceof RtReferenceConstant) {
                    RtReferenceConstant reference = (RtReferenceConstant) rtSymbol;
                    int row = reference.getRow();
                    try {
                        // send decimal values as address BUG #87
                        con.sendAndExpect(String.format("%s %04d", CMD_PLP, row), ASTERIX);
                    } catch (IOException e) {
                        return Policy.errorStatus(e);
                    }

                } else if (rtSymbol instanceof RtFloatConstant) {
                    RtFloatConstant floatConst = (RtFloatConstant) rtSymbol;
                    int address = floatConst.getAddress();
                    try {
                        con.sendAndExpect(String.format("%s %04x", CMD_PLF, address), ASTERIX);
                    } catch (IOException e) {
                        return Policy.errorStatus(e);
                    }

                    // PLF
                } else if (rtSymbol instanceof RtWordConstant) {
                    RtWordConstant wordConst = (RtWordConstant) rtSymbol;
                    int address = wordConst.getAddress();
                    try {
                        con.sendAndExpect(String.format("%s %04x", CMD_PLH, address), ASTERIX);
                    } catch (IOException e) {
                        return Policy.errorStatus(e);
                    }

                    // PLH
                } else if (rtSymbol instanceof RtWordVariable) {
                    RtWordVariable wordVar = (RtWordVariable) rtSymbol;
                    int address = wordVar.getAddress();
                    try {
                        con.sendAndExpect(String.format("%s %04x", CMD_PLH, address), ASTERIX);
                    } catch (IOException e) {
                        return Policy.errorStatus(e);
                    }
                    // PLF
                } else if (rtSymbol instanceof RtFloatVariable) {
                    RtFloatVariable floatVar = (RtFloatVariable) rtSymbol;
                    int address = floatVar.getAddress();
                    try {
                        con.sendAndExpect(String.format("%s %04x", CMD_PLF, address), ASTERIX);
                    } catch (IOException e) {
                    }
                }
            }
        } catch (IOException e) {
            return Policy.errorStatus(e);
        } finally {
            deviceLock.unlock();
        }
        return Status.OK_STATUS;
    }

    @Override
    public List<String> queryMonitoredSymbolValues() throws IOException {
        final List<String> filtered = new ArrayList<>();
        deviceLock.lock();
        try (DeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            if (!updateQueue.isEmpty()) {

                // krm 2014.05 #21 .. write symbols only once
                // dequeue symbols, which have been written
                updateQueue.removeAll(writeValues(con, updateQueue));
            }
            for (String s : con.sendAndReadLines(DeviceCommands.CMD_PLG)) {
                if (StringUtils.isEmpty(s)) {
                    continue;
                }
                s = StringUtils.remove(s, ' ');

                if (isNumber(s) || isPlainHexNumber(s) || DeviceManagerFilterUtils.isDefinedStragePlgAnswer(s)) {
                    filtered.add(s);
                }
            }
        } catch (IOException e) {
            throw new MicasDeviceManagerException(e);
        } finally {
            deviceLock.unlock();
        }
        return filtered;
    }

    List<RtSymbol> writeValues(final DeviceConnection con, List<RtSymbol> values) {
        List<RtSymbol> writtenValues = new CopyOnWriteArrayList<>();
        for (RtSymbol rtSymbol : values) {
            if (rtSymbol instanceof RtFloatConstant) {
                RtFloatConstant floatConst = (RtFloatConstant) rtSymbol;
                int address = floatConst.getAddress();
                try {
                    con.sendAndExpect(String.format("%s %04x=%s", DeviceCommands.CMD_SF, address,
                            numberFormat.format(floatConst.getValue())), ASTERIX);
                    writtenValues.add(rtSymbol);
                } catch (IOException e) {
                    Policy.errorStatus(e);
                    continue;
                }

            } else if (rtSymbol instanceof RtWordConstant) {
                RtWordConstant wordConst = (RtWordConstant) rtSymbol;
                int address = wordConst.getAddress();
                try {
                    con.sendAndExpect(String.format("%s %04x=%d", DeviceCommands.CMD_SW, address, wordConst.getValue()),
                            ASTERIX);
                    writtenValues.add(rtSymbol);
                } catch (IOException e) {
                    Policy.errorStatus(e);
                    continue;
                }

            } else if (rtSymbol instanceof RtWordVariable) {
                RtWordVariable wordVar = (RtWordVariable) rtSymbol;
                int address = wordVar.getAddress();
                try {
                    con.sendAndExpect(String.format("%s %04x=%d", DeviceCommands.CMD_SW, address, wordVar.getValue()),
                            ASTERIX);
                    writtenValues.add(rtSymbol);
                } catch (IOException e) {
                    Policy.errorStatus(e);
                    continue;
                }
            } else if (rtSymbol instanceof RtFloatVariable) {
                RtFloatVariable floatVar = (RtFloatVariable) rtSymbol;
                int address = floatVar.getAddress();
                try {
                    con.sendAndExpect(String.format("%s %04x=%s", DeviceCommands.CMD_SF, address,
                            numberFormat.format(floatVar.getValue())), ASTERIX);
                    writtenValues.add(rtSymbol);
                } catch (IOException e) {
                    Policy.errorStatus(e);
                    continue;
                }
            }

        }
        return writtenValues;
    }

    static boolean isPlainHexNumber(final String s) {
        if (StringUtils.isEmpty(s)) {
            return false;
        }
        final char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i] < '0' || chars[i] > '9') && (chars[i] < 'a' || chars[i] > 'f')
                    && (chars[i] < 'A' || chars[i] > 'F')) {
                return false;
            }
        }
        return true;

    }

    @Override
    public IStatus enqueueValueUpdate(List<RtSymbol> symbols) {
        updateQueue.addAll(symbols);
        return Status.OK_STATUS;
    }

    @Override
    public void clear() {
        updateQueue.clear();

    }

    @Override
    public IStatus completeDeviceInfo(IProgressMonitor monitor, DeviceInfo deviceInfo) {
        deviceLock.lock();
        try (DeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            con.completeDeviceInfo(monitor, deviceInfo);
        } catch (IOException e) {
            IStatus errorStatus = Policy.errorStatus(e);
            Policy.log(errorStatus);
            return errorStatus;
        } finally {
            deviceLock.unlock();
        }
        return Status.OK_STATUS;
    }

    @Override
    public IStatus clearMonitoredSymbols() {
        deviceLock.lock();
        try (IDeviceConnection con = new DeviceConnection(getConnectedDevice())) {
            con.sendLine(DeviceCommands.CMD_PLD);
        } catch (IOException e) {
            IStatus errorStatus = Policy.errorStatus(e);
            Policy.log(errorStatus);
            return errorStatus;
        } finally {
            deviceLock.unlock();
        }
        return Status.OK_STATUS;

    }

}
