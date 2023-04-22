package de.wisag.automation.micas;

import org.jline.reader.LineReader;

public class ClientContext {
    private final IMonitorEngine engine;
    private final LineReader lineReader;

    public ClientContext(IMonitorEngine engine, LineReader lineReader) {
        super();
        this.engine = engine;
        this.lineReader = lineReader;
    }

    public IMonitorEngine getEngine() {
        return engine;
    }

    public LineReader getLineReader() {
        return lineReader;
    }

    public void write(String string) {
        getLineReader().getTerminal().writer().write(string);
    }

}
