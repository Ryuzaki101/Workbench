package de.wisag.automation.micas.olt.ui.internal.views;

import java.util.Optional;
import java.util.Set;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IWorkbenchPartReference;

import com.google.common.collect.ImmutableSet;

public abstract class EditorListener implements IPartListener2 {
    public static final String MICAS_BLOCK_DIAGRAM_EDITOR = "de.wisag.automation.micas.diagram.ui.blockDiagramEditor"//
    ;
    public static final String MICAS_MODULE_EDITOR = "de.wisag.automation.micas.module.ui.ModuleEditor";
    private final static Set<String> RELEVANT_EDITOR_IDS = ImmutableSet.of(//
            MICAS_MODULE_EDITOR, //
            MICAS_BLOCK_DIAGRAM_EDITOR);

    @Override
    public void partVisible(IWorkbenchPartReference partRef) {
        tryGetRelevantEditor(partRef).ifPresent(e -> {
            editorVisible(e);
        });
    }

    private Optional<IEditorReference> tryGetRelevantEditor(IWorkbenchPartReference reference) {
        if (reference instanceof IEditorReference && RELEVANT_EDITOR_IDS.contains(reference.getId())) {
            return Optional.of((IEditorReference) reference);
        }
        return Optional.empty();
    }

    @Override
    public void partOpened(IWorkbenchPartReference partRef) {
        tryGetRelevantEditor(partRef).ifPresent(e -> {
            editorOpened(e);
        });
    }

    @Override
    public void partInputChanged(IWorkbenchPartReference partRef) {
        // empty
    }

    @Override
    public void partHidden(IWorkbenchPartReference partRef) {
        tryGetRelevantEditor(partRef).ifPresent(e -> {
            editorHidden(e);
        });
    }

    @Override
    public void partDeactivated(IWorkbenchPartReference partRef) {
        tryGetRelevantEditor(partRef).ifPresent(e -> {
            editorDectivated(e);
        });
    }

    @Override
    public void partClosed(IWorkbenchPartReference partRef) {
        tryGetRelevantEditor(partRef).ifPresent(e -> {
            editorClosed(e);
        });
    }

    @Override
    public void partBroughtToTop(IWorkbenchPartReference partRef) {
        // empty
    }

    @Override
    public void partActivated(IWorkbenchPartReference partRef) {
        // empty
        tryGetRelevantEditor(partRef).ifPresent(e -> {
            editorActivated(e);
        });
    }

    public void editorVisible(IEditorReference partRef) {
    }

    public void editorHidden(IEditorReference partRef) {
    }

    public void editorOpened(IEditorReference partRef) {
    }

    public void editorClosed(IEditorReference partRef) {
    }

    public void editorActivated(IEditorReference editorRef) {
    }

    public void editorDectivated(IEditorReference editorRef) {
    }

}