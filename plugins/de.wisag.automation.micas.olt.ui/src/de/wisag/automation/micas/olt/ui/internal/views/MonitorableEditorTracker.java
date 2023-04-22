package de.wisag.automation.micas.olt.ui.internal.views;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IViewSite;

import com.google.common.collect.Lists;

public class MonitorableEditorTracker extends EditorListener {

    private final IViewSite site;
    private final ISymbolMonitorManagerProvider symbolMonitorManagerProvider;
    private final List<Consumer<MonitorableModule>> openConsumers = Lists.newCopyOnWriteArrayList();
    private final List<Consumer<MonitorableModule>> closeConsumers = Lists.newCopyOnWriteArrayList();
    private final List<Consumer<MonitorableModule>> activationConsumers = Lists.newCopyOnWriteArrayList();
    private final List<Consumer<MonitorableModule>> deactivationConsumers = Lists.newCopyOnWriteArrayList();
    private final List<Consumer<MonitorableModule>> diagramPageVisibleConsumers = Lists.newCopyOnWriteArrayList();
    private final List<Consumer<MonitorableModule>> diagramPageHiddenConsumers = Lists.newCopyOnWriteArrayList();

    public MonitorableEditorTracker(IViewSite site, ISymbolMonitorManagerProvider symbolMonitorManagerProvider) {
        this.site = requireNonNull(site, "'site'");
        this.symbolMonitorManagerProvider = requireNonNull(symbolMonitorManagerProvider, "'site'");
    }

    @Override
    public void editorActivated(IEditorReference editorRef) {
        Optional<MonitorableModule> m = MonitorableModule.fromEditorReference(editorRef);
        m.ifPresent(module -> {
            activationConsumers.forEach(a -> {
                a.accept(module);
            });
        });
    }

    @Override
    public void editorDectivated(IEditorReference editorRef) {
        Optional<MonitorableModule> m = MonitorableModule.fromEditorReference(editorRef);
        m.ifPresent(module -> {
            deactivationConsumers.forEach(a -> {
                a.accept(module);
            });
        });
    }

    @Override
    public void editorClosed(IEditorReference editorRef) {
        Optional<MonitorableModule> m = MonitorableModule.fromEditorReference(editorRef);
        m.ifPresent(module -> {
            closeConsumers.forEach(a -> {
                a.accept(module);
            });
        });
    }

    @Override
    public void editorOpened(IEditorReference editorRef) {
        Optional<MonitorableModule> m = MonitorableModule.fromEditorReference(editorRef);
        m.ifPresent(module -> {
            openConsumers.forEach(a -> {
                a.accept(module);
            });
        });
    }

    @Override
    public void editorHidden(IEditorReference editorRef) {
        Optional<MonitorableModule> m = MonitorableModule.fromEditorReference(editorRef);
        m.ifPresent(module -> {
            module.getPage().ifPresent(p -> {
                diagramPageHiddenConsumers.forEach(d -> {
                    d.accept(module);
                });
            });
        });
    }

    @Override
    public void editorVisible(IEditorReference editorRef) {
        Optional<MonitorableModule> m = MonitorableModule.fromEditorReference(editorRef);
        m.ifPresent(module -> {
            module.getPage().ifPresent(p -> {
                diagramPageVisibleConsumers.forEach(d -> {
                    d.accept(module);
                });
            });
        });
    }

    public IViewSite getSite() {
        return site;
    }

    public void init() {
        getSite().getWorkbenchWindow().getPartService().addPartListener(this);

    }

    public void dispose() {
        this.activationConsumers.clear();
        this.diagramPageHiddenConsumers.clear();
        this.diagramPageVisibleConsumers.clear();
        getSite().getWorkbenchWindow().getPartService().removePartListener(this);

    }

    public ISymbolMonitorManagerProvider getSymbolMonitorManagerProvider() {
        return symbolMonitorManagerProvider;
    }

    public void onModuleOrDiagramClose(Consumer<MonitorableModule> onModule) {
        closeConsumers.add(onModule);
    }

    public void onModuleOrDiagramOpen(Consumer<MonitorableModule> onModule) {
        openConsumers.add(onModule);
    }

    public void onModuleOrDiagramActivate(Consumer<MonitorableModule> onModule) {
        activationConsumers.add(onModule);
    }

    public void onModuleOrDiagramDeactivate(Consumer<MonitorableModule> onModule) {
        deactivationConsumers.add(onModule);
    }

    public void onDiagramVisible(Consumer<MonitorableModule> onDiagramPage) {
        this.diagramPageVisibleConsumers.add(onDiagramPage);
    }

    public void onDiagramHidden(Consumer<MonitorableModule> onDiagramPage) {
        this.diagramPageHiddenConsumers.add(onDiagramPage);
    }

}