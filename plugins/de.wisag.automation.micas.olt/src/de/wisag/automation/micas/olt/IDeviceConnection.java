package de.wisag.automation.micas.olt;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;

import de.wisag.automation.micas.olt.device.DataRange;
import de.wisag.automation.micas.olt.device.DeviceInfo;

public interface IDeviceConnection extends Closeable {

    List<String> sendAndReadLines(String cmd) throws IOException;

    String sendAndRead(String cmd) throws IOException;

    boolean sendAndExpect(String message, String... expect) throws IOException;

    String getH86Block(int segment, int offset, int length) throws RemoteInterpreterExeption;

    DataRange findFirstWord(int taskSegment, int offset, int wordToFind) throws RemoteInterpreterExeption;

    int[] getMultiWordResult(int segment, int offset, int length) throws RemoteInterpreterExeption;

    DeviceInfo getDeviceInfo(IProgressMonitor monitor) throws RemoteInterpreterExeption;

    void sendLine(String cmd);

}
