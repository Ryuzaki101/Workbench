package de.wisag.automation.micas.olt.base.connection;

import static de.wisag.automation.micas.olt.base.connection.MicasSignalChars.SYN_STRING;
import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.io.Reader;

import org.apache.commons.lang3.StringUtils;
import org.eclipse.core.runtime.IStatus;

public class CallbackProcessor {
    private final IConnectedDevice.ReadCallback callback;
    private final IMessageSink sink;
    private StringBuffer buffer = new StringBuffer();

    private Throwable throwable;
    private Thread thread;
    private String commandSent = null;

    public CallbackProcessor(IConnectedDevice.ReadCallback callback, IMessageSink sink) {
        super();
        this.callback = requireNonNull(callback);
        this.sink = requireNonNull(sink);
        this.throwable = new Throwable();
        this.thread = Thread.currentThread();
    }

    public void processResult() {
        deleteEcho();
        String messageToProcess = StringUtils.replaceEach(buffer.toString(), new String[] { "\r", "\n", SYN_STRING },
                new String[] { "<CR>", "<LF>", "<SYN>" });
        System.out.println("PROCESS: '" + messageToProcess + "'");
        callback.processResult(buffer.toString());
    }

    private void deleteEcho() {
        if (buffer.length() > commandSent.length() && commandSent.equals(buffer.substring(0, commandSent.length()))) {
            buffer.delete(0, commandSent.length());
        }
    }

    public boolean endSeen() {
        char lastChar = buffer.length() > 0 ? buffer.charAt(buffer.length() - 1) : '\0';
        return lastChar == MicasSignalChars.SYN_CHAR || lastChar == '*';
    }

    public boolean yesRequired() {
        return StringUtils.trimToEmpty(buffer.toString()).endsWith("[Y]");
    }

    public void append(char c) {
        buffer.append(c);
    }

    public void errorOccured(IStatus status) {
        // TODO
    }

    enum EchoProcessing {
        INITIAL, CURRENT, DONE
    }

    public boolean processTextAndReturnReadiness(Reader reader) throws IOException {
        requireNonNull(reader, "'reader'");
        if (commandSent == null) {
            throw new IllegalStateException("call begin() before processTextAndReturnReadiness()");
        }
        int ch = 0;
        EchoProcessing echoProcessing = EchoProcessing.INITIAL;
        while (reader.ready() && (ch = reader.read()) != -1) {

            if (ch == 0x16 && buffer.length() > 0 && buffer.charAt(buffer.length() - 1) != '*'
                    && echoProcessing == EchoProcessing.INITIAL) {
                echoProcessing = EchoProcessing.CURRENT;
                buffer.deleteCharAt(buffer.length() - 1);
                continue;
            }
            if (ch == 0x0a) {
                echoProcessing = EchoProcessing.DONE;
                continue;
            }
            if (echoProcessing == EchoProcessing.CURRENT) {
                continue;
            }
            append((char) ch);
        }

        if (yesRequired()) {
            sink.sendStringToDevice("Y\r");
        } else if (endSeen()) {
            processResult();
            sink.sendStringToUser(String.format("*** background mode end ***"));
            return true;
        }
        return false;
    }

    public void begin() {
        commandSent = callback.getCommand() + "\r";
        sink.sendStringToDevice(commandSent);
    }

    public void signalDone() {
        this.callback.signalDone();
    }

    public Throwable caller() {
        return this.throwable;
    }

    public Thread callerThread() {
        return thread;
    }
}