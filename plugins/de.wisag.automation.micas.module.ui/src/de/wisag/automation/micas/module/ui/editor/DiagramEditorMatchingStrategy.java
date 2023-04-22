package de.wisag.automation.micas.module.ui.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.FileEditorInput;

import de.wisag.automation.micas.module.ui.internal.Policy;

public class DiagramEditorMatchingStrategy implements IEditorMatchingStrategy {

    @Override
    public boolean matches(IEditorReference editorRef, IEditorInput input) {
        IFile fileToEdit = null;
        if (input instanceof FileEditorInput) {
            fileToEdit = ((FileEditorInput) input).getFile();
        } else {
            return false;
        }
        if (fileToEdit == null) {
            return false;
        }
        if (!"module".equalsIgnoreCase(fileToEdit.getFileExtension())) {
            return false;
        }
        IFile otherEditedFile = null;
        try {
            IEditorInput otherEditorInput = editorRef.getEditorInput();
            if (otherEditorInput instanceof IFileEditorInput) {
                IFileEditorInput fileEditorInput = (IFileEditorInput) otherEditorInput;
                otherEditedFile = fileEditorInput.getFile();
            }
        } catch (PartInitException e) {
            Policy.logError(e);
        }
        if (otherEditedFile == null) {
            return false;
        }

        return fileToEdit.equals(otherEditedFile);
    }

}
