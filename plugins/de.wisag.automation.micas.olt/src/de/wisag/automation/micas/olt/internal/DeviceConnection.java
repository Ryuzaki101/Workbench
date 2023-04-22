package de.wisag.automation.micas.olt.internal;

import static de.wisag.automation.micas.olt.internal.commands.ParserUtils.cleanAndSplitResultLine;
import static java.util.Objects.requireNonNull;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.olt.IDeviceConnection;
import de.wisag.automation.micas.olt.RemoteInterpreterExeption;
import de.wisag.automation.micas.olt.base.connection.IConnectedDevice;
import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DeviceFactory;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.internal.commands.DeviceInfoCommand;
import de.wisag.automation.micas.olt.internal.commands.IDeviceCommand;
import de.wisag.automation.micas.olt.internal.commands.ParserUtils;

public class DeviceConnection implements IDeviceConnection, Closeable {

    private static final TimeUnit WAIT_FOR_RESPONSE_TIMEUNIT = TimeUnit.SECONDS;
    private static final int WAIT_FOR_RESPONSE_TIMEOUT = 20;
    private static final boolean DEBUG = false;
    /** HEX format String with 4 leading zeros */
    public static final String HEX_FORMAT = "%04x";

    private IConnectedDevice connectedDevice;
    private static final int MAX_RETRY = 5;

    public DeviceConnection(IConnectedDevice connectedDevice) {
        this.connectedDevice = requireNonNull(connectedDevice, "'connectedDevice'");
    }

    @Override
    public List<String> sendAndReadLines(final String cmd) throws IOException {
        String result = sendAndRead(cmd);
        return cleanAndSplitResultLine(result);
    }

    @Override
    public String sendAndRead(final String cmd) throws IOException {
        final StringBuffer sb = new StringBuffer();
        // current thread will wait until latch = 0
        CountDownLatch responseLatch = new CountDownLatch(1);
        connectedDevice.sendCommandWithCallback(new IConnectedDevice.ReadCallback() {
            @Override
            public void processResult(String text) {
                sb.append(text);
            }

            @Override
            public String getCommand() {
                return cmd;
            }

            @Override
            public void signalDone() {
                responseLatch.countDown();
            }
        });
        try {
            if (!responseLatch.await(WAIT_FOR_RESPONSE_TIMEOUT, WAIT_FOR_RESPONSE_TIMEUNIT)) {
                Policy.logWarning("Timeout waiting for device answer (Break by loopCount),command: '" + cmd
                        + "',response '" + sb.toString() + "'");
                // on timeout prevent dangeling callbacks
                connectedDevice.forceRemoveOwnCallback();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // set interrupt flag
        }
        return sb.toString();
    }

    @Override
    public boolean sendAndExpect(String message, String... expect) throws IOException {
        if (DEBUG) {
            System.out.println("DeviceConnection.sendAndExpect():" + message);
        }
        String result = sendAndRead(message);
        if (DEBUG) {
            System.out.println(result);
        }
        for (String string : expect) {
            if (StringUtils.contains(result, string)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int[] getMultiWordResult(int segment, int offset, int length) throws RemoteInterpreterExeption {
        String result = null;
        String command = String.format("%s%04x:%04xL%04x", DeviceCommands.CMD_DW, segment, offset, length);
        if (DEBUG) {
            System.out.println("displayWordDW - command: " + command);
        }
        try {
            result = sendAndRead(command);
            if (DEBUG) {
                System.out.println("displayWordDW - result: " + result);
            }
        } catch (IOException e) {
            throw new RemoteInterpreterExeption(e.getMessage(), e);
        }
        return ParserUtils.parseGroupedWordData(result, length);

    }

    @Override
    public String getH86Block(int segment, int offset, int length) throws RemoteInterpreterExeption {
        String result = null;
        String command = String.format("%s%04x:%04xL%04x", DeviceCommands.CMD_W, segment, offset, length);
        if (DEBUG) {
            System.out.println("W - command: " + command);
        }
        try {
            result = sendAndRead(command);
            if (DEBUG) {
                System.out.println("displayWordDW - result: " + result);
            }
        } catch (IOException e) {
            throw new RemoteInterpreterExeption(e.getMessage(), e);
        }
        List<String> resultLines = ParserUtils.cleanAndSplitResultLine(result);
        for (Iterator<String> it = resultLines.iterator(); it.hasNext();) {
            if (!StringUtils.startsWith(it.next(), ":")) {
                it.remove();
            }
        }
        return StringUtils.join(resultLines, "\r\n");
    }

    @Override
    public DataRange findFirstWord(int taskSegment, int offset, int wordToFind) throws RemoteInterpreterExeption {
        int maxOffset = 1180;
        String cmd = String.format("%s%04x:%04xl%04x=%04x", DeviceCommands.CMD_FW, taskSegment, offset, maxOffset,
                wordToFind);
        try {
            String message = null;
            if (DEBUG) {
                System.out.println("Send command: " + cmd);
            }
            List<String> lines = sendAndReadLines(cmd);
            for (Iterator<String> iterator = lines.iterator(); iterator.hasNext();) {
                String string = iterator.next();
                if (!NumberUtils.isNumber("0x" + StringUtils.left(string, 4))) {
                    System.err.println("Removing " + string);
                    iterator.remove();
                }
            }
            if (!lines.isEmpty()) {
                message = lines.iterator().next();
            } else {
                return null;
            }
            if (DEBUG) {
                System.out.println("Response: " + message);
            }
            return ParserUtils.parseDataRange(message);
        } catch (IOException e) {
            throw new RemoteInterpreterExeption(e.getMessage(), e);
        }

    }

    @Override
    public DeviceInfo getDeviceInfo(IProgressMonitor monitor) throws RemoteInterpreterExeption {
        try {
            // change to master
            monitor.setTaskName("Query Fieldbus");
            if (monitor.isCanceled()) {

            }
            DeviceInfo master = null;
            int retryCount = 0;
            while (retryCount++ < MAX_RETRY) {
                if (retryCount > 1) {
                    monitor.subTask("Retry in device " + HardcodedValues.FIELDBUS_MASTER_DEVICE);
                }
                sendAndReadLines(
                        String.format("%s %s", DeviceCommands.CMD_CHD, HardcodedValues.FIELDBUS_MASTER_DEVICE));
                IDeviceCommand<DeviceInfo> deviceInfoCommand = new DeviceInfoCommand();
                master = deviceInfoCommand.execute(sendAndReadLines(deviceInfoCommand.getCommandline()));
                master.setFieldBus(HardcodedValues.FIELDBUS_MASTER_DEVICE);
                if (master.getModuleName() != null) {
                    break;
                }
            }
            List<String> avDevices = discoverFieldBus();
            for (String devId : avDevices) {
                int fbNumber;
                try {
                    fbNumber = Integer.parseInt(devId);
                } catch (NumberFormatException ignored) {
                    //
                    continue;
                }
                if (master.getFieldBus() == fbNumber) {
                    continue;
                }
                monitor.subTask(String.format("Query device %s of %d", devId, avDevices.size()));
                retryCount = 0;
                DeviceInfo slave = DeviceFactory.eINSTANCE.createDeviceInfo();
                slave.setFieldBus(fbNumber);
                master.getSlaves().add(slave);
            }
            return master;
        } catch (IOException e) {
            throw new RemoteInterpreterExeption(e.getMessage(), e);
        }

    }

    private List<String> discoverFieldBus() throws IOException {
        List<String> avDevices = new ArrayList<>();
        List<String> chd = sendAndReadLines(DeviceCommands.CMD_CHD);
        if (chd == null || chd.isEmpty()) {
            chd = sendAndReadLines(DeviceCommands.CMD_CHD);
        }
        if (!chd.isEmpty()) {
            System.out.println("discoverFieldBus : read lines " + StringUtils.join(chd, ','));
        }
        /**
         * Device : 002 Selected fieldbus device (1 ... 032 ) : 002 Selectable
         * fieldbus devices : 002
         */
        Pattern p = Pattern.compile("^Device\\s+:\\s+(\\d{3})\\s+Selected\\s+fieldbus\\s+device.+:\\s+(\\d{3})$",
                Pattern.CASE_INSENSITIVE);
        boolean nextAreDevices = false;
        for (String c : chd) {
            Matcher m = null;
            if (nextAreDevices) {
                avDevices.add(StringUtils.trimToEmpty(c));
            } else if ((m = p.matcher(c)).matches()) {
                if (m.groupCount() == 2) {
                    System.out.println("device:" + m.group(1));
                    System.out.println("current device device:" + m.group(2));
                }
            } else if (StringUtils.startsWith(c, "Selectable fieldbus devices")) {
                nextAreDevices = true;
            }
        }
        return avDevices;
    }

    public IConnectedDevice getConnectedDevice() {
        return connectedDevice;
    }

    @Override
    public void sendLine(String cmd) {
        String command = cmd + "\r";
        System.out.println("SEND>" + cmd + "<CR>");
        this.connectedDevice.sendString(command);

    }

    public void disconnect() {
        this.connectedDevice.disconnect();

    }

    public void completeDeviceInfo(IProgressMonitor monitor, DeviceInfo deviceInfo) throws IOException {
        int retryCount = 0;
        int fieldBusSave = deviceInfo.getFieldBus();
        String devId = String.format("%03d", fieldBusSave);
        while (retryCount++ < MAX_RETRY) {
            if (retryCount > 1 && monitor != null) {
                monitor.subTask("Retry in device " + devId);
            }
            sendAndReadLines(String.format("%s %s", DeviceCommands.CMD_CHD, devId));
            IDeviceCommand<DeviceInfo> deviceInfoCommand = new DeviceInfoCommand();
            DeviceInfo slave = deviceInfoCommand.execute(sendAndReadLines(deviceInfoCommand.getCommandline()));
            copy(slave, deviceInfo);
            deviceInfo.setFieldBus(fieldBusSave);
            if (deviceInfo.getModuleName() != null) {
                break;
            }
        }

    }

    private static void copy(EObject source, EObject target) {
        for (Iterator<EStructuralFeature> i = source.eClass().getEStructuralFeatures().iterator(); i.hasNext();) {
            EStructuralFeature feature = i.next();
            target.eSet(feature, source.eGet(feature));
        }
    }

    @Override
    public void close() throws IOException {
        // empty

    }
}