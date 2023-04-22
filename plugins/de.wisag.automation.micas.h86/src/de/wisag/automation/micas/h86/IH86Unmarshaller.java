package de.wisag.automation.micas.h86;

import java.io.IOException;
import java.io.InputStream;

public interface IH86Unmarshaller {
    public H86Content unmarshall(InputStream is) throws IOException;
}