package de.wisag.automation.micas.module.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IPersistableElement;
import org.eclipse.ui.part.FileEditorInput;

import de.wisag.automation.micas.module.Module;

public class DiagramEditorInputProxy extends FileEditorInput {

    private final Module module;
    private final IFileEditorInput editorInput;

    public DiagramEditorInputProxy(IFileEditorInput editorInput, Module editedModelElement) {
        super(editorInput.getFile());
        this.module = editedModelElement;
        this.editorInput = editorInput;
    }

    @Override
    public boolean exists() {
        return editorInput.exists();
    }

    @Override
    public ImageDescriptor getImageDescriptor() {
        return editorInput.getImageDescriptor();
    }

    @Override
    public String getName() {
        return editorInput.getName();
    }

    @Override
    public IPersistableElement getPersistable() {
        return editorInput.getPersistable();
    }

    @Override
    public String getToolTipText() {
        return editorInput.getName();
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (Module.class.equals(adapter)) {
            return adapter.cast(getModule());
        }
        return editorInput.getAdapter(adapter);
    }

    public Module getModule() {
        return module;
    }

    @Override
    public IFile getFile() {
        return editorInput.getFile();
    }

}
