package de.wisag.automation.micas.ui.builder;

import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

/**
 * Console for compiler's output.
 */
public class CompilerConsole extends MessageConsole {

    private final MessageConsoleStream defaultStream = newMessageStream();

    private final MessageConsoleStream metaStream = newMessageStream();

    /**
     * The color of the meta messages.
     */
    private static final Color META_COLOR = new Color(Display.getDefault(), 0, 128, 0);

    private CompilerConsole(String name) {
        super(name, null);
        metaStream.setColor(META_COLOR);
    }

    /**
     * Prints a line of message to the console.
     */
    public void print(String line) {
        defaultStream.println(line);
    }

    /**
     * Prints a line of meta message to the console.
     */
    public void printMeta(String line) {
        metaStream.println(line);
    }

}