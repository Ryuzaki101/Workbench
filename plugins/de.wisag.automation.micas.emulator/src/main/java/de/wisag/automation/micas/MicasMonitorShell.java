package de.wisag.automation.micas;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.apache.sshd.server.Command;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wisag.automation.micas.commands.CommandVerb;
import de.wisag.automation.micas.commands.ICommand;
import de.wisag.automation.micas.commands.MicasCommandFactory;

class MicasMonitorShell implements Command, Runnable {
    private static final Logger log = LoggerFactory.getLogger(MicasMonitorShell.class);
    private static final String SHELL_THREAD_NAME = "MICAS Monitor";
    private InputStream inputStream;
    private OutputStream outputStream;
    private OutputStream errorStream;

    private ExitCallback callback;
    private Environment environment;

    private Thread thread;

    @Override
    public void setInputStream(InputStream in) {
        this.inputStream = in;
    }

    @Override
    public void setOutputStream(OutputStream out) {
        this.outputStream = out;
    }

    @Override
    public void setErrorStream(OutputStream err) {
        this.errorStream = err;
    }

    @Override
    public void setExitCallback(ExitCallback callback) {
        this.callback = callback;
    }

    @Override
    public void start(Environment env) throws IOException {
        environment = env;
        thread = new Thread(this, SHELL_THREAD_NAME);
        thread.start();
    }

    @Override
    public void destroy() {
        thread.interrupt();
    }

    /**
     * {@inheritDoc}
     */

    @Override
    public void run() {
        try {
            int columns = 80;
            int rows = 50;
            LineReader lineReader = newTerminalAndLinereader(columns, rows);

            ClientContext context = new ClientContext(new MicasMonitoringEngine(), lineReader);
            micasBannerAndAuth(context);
            lineReader.getTerminal().writer().flush();
            String line;
            while ((line = lineReader.readLine("*")) != null) {
                handleUserInput(context, lineReader.getTerminal().writer(), line.trim());
            }

        } catch (InterruptedIOException e) {
            // Ignore
        } catch (UserInterruptException e) {
            // terminate
        } catch (Exception e) {
            log.error("Error executing InAppShell...", e);
        } finally {
            callback.onExit(0);
        }
    }

    private LineReader newTerminalAndLinereader(int columns, int rows) throws IOException {
        Terminal terminal = TerminalBuilder.builder()//
                .name("MICAS Monitor")//
                .type("ansi")//
                .attributes(new Attributes())//
                .system(false)//
                .size(new Size(columns, rows))//
                .streams(inputStream, outputStream)//
                .encoding(StandardCharsets.ISO_8859_1.name()).build();
        LineReader lineReader = LineReaderBuilder.builder()//
                .terminal(terminal)//
                .build();
        lineReader.unsetOpt(LineReader.Option.BRACKETED_PASTE);
        lineReader.unsetOpt(LineReader.Option.MOUSE);
        return lineReader;
    }

    private void micasBannerAndAuth(ClientContext context) {
        LocalDateTime now = LocalDateTime.now();
        String time = now.format(DateTimeFormatter.ofPattern("hh:mm:ss"));
        String date = now.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
        LineReader lineReader = context.getLineReader();
        lineReader.getTerminal().writer().println(String.format("time: %s  date: %s", time, date));
        lineReader.getTerminal().writer().println("+------------------------------------------------------------+");
        lineReader.getTerminal().writer().println("|  ABB Gebaudeautomation                            GAT/T    |");
        lineReader.getTerminal().writer().println("|                    P R O C O S                             |");
        lineReader.getTerminal().writer().println("|                 -----------------                          |");
        lineReader.getTerminal().writer().println("|            Version: V0.0 25-Nov-2002 13:19:41              |");
        lineReader.getTerminal().writer().println("|                                                            |");
        lineReader.getTerminal().writer().println("+------------------------------------------------------------+");
        String passcode;
        while ((passcode = lineReader.readLine("CODE:", '*')) != null) {
            if (context.getEngine().isValidPasscode(passcode.trim())) {
                break;
            }
        }
        // write sync
        lineReader.getTerminal().writer().write('\u0016');
    }

    private void handleUserInput(ClientContext context, PrintWriter writer, String line) {

        log.info("micas> {}", line);
        if (line.isEmpty()) {
            return;
        }
        Optional<CommandRequest> request = tryParseRequest(line);
        if (!request.isPresent()) {
            writer.println("command not found");
            return;
        }
        ICommand command = MicasCommandFactory.create(request.get().getVerb(), context);
        if (command == null) {
            log.error("Command not implemented '{}'", request.get().getVerb());
            writer.printf("command not implemented '{}'\r\n", request.get().getVerb());
            return;
        }
        command.execute(request.get());
    }

    private Optional<CommandRequest> tryParseRequest(String line) {
        String verb = "";
        List<String> args = new ArrayList<>();
        int pos;
        if ((pos = line.indexOf(' ')) > -1) {
            verb = line.substring(0, pos);
            // hack to get the verbs clean
            if (verb.endsWith("=")) {
                verb = verb.substring(0, verb.length() - 1);
            }
            String rest = line.substring(pos + 1, line.length());
            args.addAll(Arrays.asList(rest.split("\\s+")));
        } else {
            verb = line;
            String rest = "";
            log.info("'{}' : '{}'", verb, rest);
        }
        CommandRequest request = null;
        try {
            request = new CommandRequest(Enum.valueOf(CommandVerb.class, verb.toUpperCase()), args);
        } catch (IllegalArgumentException e) {
        }
        return Optional.ofNullable(request);
    }

    public Environment getEnvironment() {
        return environment;
    }

    public OutputStream getErrorStream() {
        return errorStream;
    }
}