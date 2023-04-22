package de.wisag.automation.micas.module.ui.symbolimporter;

import java.util.List;

public interface IDataConsumer {
    void processRow(int lineNr, List<Object> row) throws ProcessingException;
}