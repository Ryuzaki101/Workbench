package de.wisag.automation.micas.common.ui;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.MessageConsole;

import de.wisag.automation.micas.common.ui.internal.Policy;

public class ConsoleUtils {

    public static MessageConsole findConsole(String name) {
        ConsolePlugin plugin = ConsolePlugin.getDefault();
        IConsoleManager conMan = plugin.getConsoleManager();
        IConsole[] existing = conMan.getConsoles();
        for (int i = 0; i < existing.length; i++) {
            if (name.equals(existing[i].getName())) {
                return (MessageConsole) existing[i];
            }
        }
        // no console found, so create a new one
        MessageConsole myConsole = new MessageConsole(name, null);
        conMan.addConsoles(new IConsole[] { myConsole });
        return myConsole;
    }

    public static MessageConsole openConsole(IWorkbenchPage page, String consoleName) throws ExecutionException {
        MessageConsole micasConsole = findConsole(consoleName);
        String id = IConsoleConstants.ID_CONSOLE_VIEW;
        try {
            IConsoleView view = (IConsoleView) page.showView(id);
            view.display(micasConsole);
        } catch (PartInitException e1) {
            Policy.logError(e1);
        }
        return micasConsole;
    }

}
