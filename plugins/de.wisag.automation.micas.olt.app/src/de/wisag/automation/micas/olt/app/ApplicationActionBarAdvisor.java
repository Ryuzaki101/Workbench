package de.wisag.automation.micas.olt.app;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 *
 * @author koderman@sernet.de
 */
@SuppressWarnings("restriction")
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

    // Actions - important to allocate these only in makeActions, and then use
    // them
    // in the fill methods. This ensures that the actions aren't recreated
    // when fillActionBars is called with FILL_PROXY.
    private IWorkbenchAction exitAction;

    private IWorkbenchAction aboutAction;

    private IWorkbenchAction newWindowAction;

    private IWorkbenchAction saveAction;

    private IWorkbenchAction closeAction;

    private IWorkbenchAction closeAllAction;

    private IWorkbenchAction closeOthersAction;
    private IWorkbenchAction copyAction;

    private IWorkbenchAction pasteAction;

    private IWorkbenchAction introAction;

    private IWorkbenchAction preferenceAction;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
        removeExtraneousActions();
    }

    @Override
    protected void makeActions(final IWorkbenchWindow window) {
        // Creates the actions and registers them.
        // Registering is needed to ensure that key bindings work.
        // The corresponding commands keybindings are defined in the plugin.xml
        // file.
        // Registering also provides automatic disposal of the actions when
        // the window is closed.

        exitAction = ActionFactory.QUIT.create(window);
        register(exitAction);

        copyAction = ActionFactory.COPY.create(window);
        register(copyAction);

        pasteAction = ActionFactory.PASTE.create(window);
        register(pasteAction);

        aboutAction = ActionFactory.ABOUT.create(window);
        register(aboutAction);

        newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
        register(newWindowAction);

        saveAction = ActionFactory.SAVE.create(window);
        register(saveAction);

        closeAction = ActionFactory.CLOSE.create(window);
        register(closeAction);

        closeAllAction = ActionFactory.CLOSE_ALL.create(window);
        register(closeAllAction);

        closeOthersAction = ActionFactory.CLOSE_OTHERS.create(window);
        register(closeOthersAction);

        preferenceAction = ActionFactory.PREFERENCES.create(window);
        register(preferenceAction);

    }

    @Override
    protected void fillMenuBar(IMenuManager menuBar) {
        IActionBarConfigurer configurer = getActionBarConfigurer();
        IWorkbenchWindow window = configurer.getWindowConfigurer().getWindow();

        menuBar.add(createFileMenu(window));
        menuBar.add(createEditMenu(window));
        menuBar.add(createWindowMenu(window));
        menuBar.add(createHelpMenu());
    }

    private IContributionItem createHelpMenu() {
        MenuManager helpMenu = new MenuManager("&Hilfe");
        helpMenu.add(aboutAction);
        helpMenu.add(new Separator());
        return helpMenu;
    }

    private IContributionItem createEditMenu(IWorkbenchWindow window) {
        MenuManager editMenu = new MenuManager("&Bearbeiten", IWorkbenchActionConstants.M_EDIT);

        editMenu.add(new Separator());
        editMenu.add(copyAction);
        editMenu.add(pasteAction);
        editMenu.add(new Separator());
        return editMenu;
    }

    private IContributionItem createFileMenu(IWorkbenchWindow window) {
        MenuManager fileMenu = new MenuManager("&Datei", IWorkbenchActionConstants.M_FILE);

        // MenuManager neuMenu = new MenuManager("Neu...");
        // IContributionItem wizardList =
        // ContributionItemFactory.NEW_WIZARD_SHORTLIST.
        // create(window);
        // neuMenu.add(wizardList);

        // fileMenu.add(neuMenu);
        fileMenu.add(saveAction);
        fileMenu.add(closeAction);
        fileMenu.add(closeAllAction);
        fileMenu.add(closeOthersAction);

        fileMenu.add(new Separator());
        fileMenu.add(new Separator());
        fileMenu.add(preferenceAction);
        fileMenu.add(exitAction);
        return fileMenu;
    }

    private IContributionItem createWindowMenu(IWorkbenchWindow window) {
        // View:
        MenuManager windowMenu = new MenuManager("&Ansicht", IWorkbenchActionConstants.M_WINDOW);

        MenuManager viewsMenu = new MenuManager("Zeige View...");
        // IContributionItem viewList = ContributionItemFactory.VIEWS_SHORTLIST
        // .create(window);

        MenuManager perspectivesMenu = new MenuManager("Öffne Perspektive...");
        IContributionItem perspectiveList = ContributionItemFactory.PERSPECTIVES_SHORTLIST.create(window);
        perspectivesMenu.add(perspectiveList);

        windowMenu.add(newWindowAction);
        windowMenu.add(new Separator());
        windowMenu.add(perspectivesMenu);
        windowMenu.add(viewsMenu);
        return windowMenu;
    }

    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
        IToolBarManager myToolbar = new ToolBarManager(coolBar.getStyle());
        coolBar.add(new ToolBarContributionItem(myToolbar));
        myToolbar.add(saveAction);
        myToolbar.add(new Separator());
    }

    /**
     * This removes some actions that we inherit from org.eclipse.ui.ide which
     * we don't want.
     */
    private void removeExtraneousActions() {
        ActionSetRegistry reg = WorkbenchPlugin.getDefault().getActionSetRegistry();

        // removing gotoLastPosition message
        removeStandardAction(reg, "org.eclipse.ui.edit.text.actionSet.navigation");

        removeStandardAction(reg, "org.eclipse.ui.NavigateActionSet");

        // "Open File..." in 3.2.1:
        removeStandardAction(reg, "org.eclipse.ui.edit.text.actionSet.openExternalFile");

        // "Open File" in 3.4M4:
        removeStandardAction(reg, "org.eclipse.ui.actionSet.openFiles");

        // removeStandardAction(reg,
        // "org.eclipse.ui.preferencePages.Workbench");

        removeStandardAction(reg, "org.eclipse.ui.edit.text.actionSet.annotationNavigation");

        // Removing â€œConvert Line Delimiters Toâ€ menu
        removeStandardAction(reg, "org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo");

        // remove working sets
        removeStandardAction(reg, "org.eclipse.ui.WorkingSetActionSet");
    }

    private void removeStandardAction(ActionSetRegistry reg, String actionSetId) {
        IActionSetDescriptor[] actionSets = reg.getActionSets();
        for (int i = 0; i < actionSets.length; i++) {
            if (!actionSets[i].getId().equals(actionSetId)) {
                continue;
            }
            IExtension ext = actionSets[i].getConfigurationElement().getDeclaringExtension();
            reg.removeExtension(ext, new Object[] { actionSets[i] });
        }
    }

}