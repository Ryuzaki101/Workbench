package de.wisag.automation.micas.workbench.internal;

import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class PerspectiveFactory implements IPerspectiveFactory {

    /**
     * Constructs a new Default layout engine.
     */
    public PerspectiveFactory() {

    }

    @Override
    public void createInitialLayout(IPageLayout layout) {
        defineActions(layout);
        defineLayout(layout);

    }

    public void defineActions(IPageLayout layout) {
        // Add "new wizards".
        layout.addNewWizardShortcut("de.wisag.automation.micas.module.ui.wizards.newmicasprojectwizard");
        layout.addNewWizardShortcut("de.wisag.automation.micas.module.editor.presentation.ModuleModelWizardID");
        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.folder");
        layout.addNewWizardShortcut("org.eclipse.ui.wizards.new.file");
        layout.addShowViewShortcut("org.eclipse.ui.navigator.ProjectExplorer");

        layout.addShowViewShortcut(IPageLayout.ID_OUTLINE);
        layout.addShowViewShortcut(IPageLayout.ID_PROP_SHEET);
        layout.addPerspectiveShortcut("de.wisag.automation.micas.workbench.perspective");
        layout.addPerspectiveShortcut("de.wisag.automation.micas.olt.ui.perspective");
        layout.addActionSet(IPageLayout.ID_NAVIGATE_ACTION_SET);
    }

    /**
     * Defines the initial layout for a page.
     *
     * @param layout
     *            The layout we are filling
     */
    public void defineLayout(IPageLayout layout) {
        // Editors are placed for free.
        String editorArea = layout.getEditorArea();

        // Top left.
        IFolderLayout topLeft = layout.createFolder("topLeft", IPageLayout.LEFT, (float) 0.26, editorArea);//$NON-NLS-1$
        topLeft.addView("org.eclipse.ui.navigator.ProjectExplorer");
        topLeft.addPlaceholder(IPageLayout.ID_BOOKMARKS);
        // Bottom left

        layout.addView("de.wisag.automation.micas.olt.ui.devexplorer", IPageLayout.BOTTOM, 0.70f,
                "org.eclipse.ui.navigator.ProjectExplorer");

        // Bottom right.
        IFolderLayout bottomRight = layout.createFolder("bottomRight", IPageLayout.BOTTOM, (float) 0.66, //$NON-NLS-1$
                editorArea);

        bottomRight.addView(IPageLayout.ID_PROP_SHEET);
        bottomRight.addView("de.wisag.automation.micas.olt.terminal.view.terminalview");
        bottomRight.addView(IPageLayout.ID_PROBLEM_VIEW);
        bottomRight.addView(IPageLayout.ID_PROGRESS_VIEW);
        bottomRight.addView("org.eclipse.pde.runtime.LogView");

        IFolderLayout topRight = layout.createFolder("topRight", IPageLayout.RIGHT, (float) 0.66, editorArea);//$NON-NLS-1$
        topRight.addView(IPageLayout.ID_OUTLINE);
    }
}
