package de.wisag.automation.micas.olt.ui.internal.views;

import static de.wisag.automation.micas.common.resource.ResourceUtils.toIFile;
import static java.util.Objects.requireNonNull;

import java.util.Optional;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.olt.ui.IMonitorableModule;

class MonitorableModule implements IMonitorableModule {
    private final Module module;
    private final Optional<Page> page;

    public MonitorableModule(Module module, Optional<Page> page) {
        super();
        this.module = requireNonNull(module, "'module'");
        this.page = requireNonNull(page, "'page'");
    }

    @Override
    public Module getModule() {
        return module;
    }

    @Override
    public IFile moduleFile() {
        return toIFile(module.eResource());
    }

    @Override
    public Optional<Page> getPage() {
        return page;
    }

    public static Optional<MonitorableModule> fromEditorReference(IEditorReference editorRef) {
        IEditorInput editorInput;
        try {
            editorInput = editorRef.getEditorInput();
            Optional<Page> page = tryGetAdapter(editorInput, Page.class);
            Module module = null;
            if (page.isPresent()) {
                module = Optional.of(page.get().getTask().getModule()).orElse(null);
            } else {
                module = tryGetAdapter(editorInput, Module.class).orElse(null);
            }
            return Optional.of(new MonitorableModule(module, page));
        } catch (PartInitException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static <T> Optional<T> tryGetAdapter(IAdaptable adaptable, Class<T> adapter) {
        return Optional.ofNullable(adaptable.getAdapter(adapter));
    }

    @Override
    public boolean isDiagramPage() {
        return page.isPresent();
    }

    @Override
    public String toString() {
        return "MonitorableEditorModels [module=" + module + ", page=" + page + "]";
    }
}