package de.wisag.automation.micas.olt.commandtest;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

public class CommandTestCase {

    protected List<String> loadMessages(String name) throws IOException {
        try (InputStream msg = getClass().getResourceAsStream(name)) {
            return IOUtils.readLines(msg);
        }
    }

}
