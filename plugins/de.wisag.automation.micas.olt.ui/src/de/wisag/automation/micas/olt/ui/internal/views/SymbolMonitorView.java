package de.wisag.automation.micas.olt.ui.internal.views;

import static com.google.common.base.Preconditions.checkState;
import static de.wisag.automation.micas.olt.monitor.MonitorPackage.Literals.MONITORED_ITEM__INDEX;
import static de.wisag.automation.micas.olt.monitor.MonitorPackage.Literals.MONITORED_ITEM__RT_SYMBOL;
import static de.wisag.automation.micas.olt.monitor.MonitorPackage.Literals.MONITORED_ITEM__TEXT_VALUE;
import static de.wisag.automation.micas.olt.monitor.MonitorPackage.Literals.MONITOR_MODEL__ITEMS;
import static de.wisag.automation.micas.rt.RtPackage.Literals.RT_SYMBOL__ADDRESS;
import static de.wisag.automation.micas.rt.RtPackage.Literals.RT_SYMBOL__NAME;
import static java.util.Arrays.stream;
import static java.util.Objects.requireNonNull;
import static java.util.Spliterator.ORDERED;
import static java.util.Spliterators.spliteratorUnknownSize;
import static java.util.stream.StreamSupport.stream;
import static org.eclipse.emf.ecore.util.EcoreUtil.getAllContents;
import static org.eclipse.jface.databinding.swt.DisplayRealm.getRealm;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.WorkspaceJob;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.databinding.EMFProperties;
import org.eclipse.emf.databinding.FeaturePath;
import org.eclipse.emf.databinding.IEMFListProperty;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.action.ActionContributionItem;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.action.IContributionManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.texteditor.IUpdate;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import com.google.common.collect.ImmutableList;

import de.wisag.automation.micas.common.osgi.GenericServiceTracker;
import de.wisag.automation.micas.common.osgi.IGenericServiceListener;
import de.wisag.automation.micas.common.resource.ResourceUtils;
import de.wisag.automation.micas.common.ui.databinding.GenericMapCellLabelProvider;
import de.wisag.automation.micas.common.ui.databinding.StringFormatMapCellLabelProvider;
import de.wisag.automation.micas.export.mic.IRtSymbolTranslator;
import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.module.Task;
import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.ISymbolMonitorManager;
import de.wisag.automation.micas.olt.monitor.MonitorFactory;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.ui.IMonitorableModule;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl.State;
import de.wisag.automation.micas.olt.ui.internal.Policy;
import de.wisag.automation.micas.olt.ui.internal.views.actions.PauseSymbolmonitorAction;
import de.wisag.automation.micas.olt.ui.internal.views.actions.StartSymbolmonitorAction;
import de.wisag.automation.micas.olt.ui.internal.views.actions.StopSymbolmonitorAction;
import de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions.RemoveAllSymbolsAction;
import de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions.RemoveSymbolAction;
import de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions.SetSymbolValueAction;
import de.wisag.automation.micas.rt.RtSymbol;

public class SymbolMonitorView extends ViewPart
        implements IGenericServiceListener<ISymbolMonitorManager>, ISymbolMonitorManagerProvider {

    public static String VIEW_ID = "de.wisag.automation.micas.olt.ui.monitorview";
    public final String VIEW_TITLE_FMT = "MICAS Symbol Monitor %s";
    private TableViewer monitorTableViewer;

    private GenericServiceTracker<ISymbolMonitorManager> symbolMonitorManagerTracker;

    private final AtomicReference<ISymbolMonitorManager> symbolMonitorManagerRef = new AtomicReference<>();

    private MonitorableEditorTracker editorTracker;

    private SymbolMonitorStatusControl statusControl;

    public SymbolMonitorView() {

    }

    @Override
    public void init(IViewSite site) throws PartInitException {
        super.init(site);

        editorTracker = new MonitorableEditorTracker(site, this);
        editorTracker.init();

        this.statusControl = new SymbolMonitorStatusControl(
                getRealm(site.getWorkbenchWindow().getShell().getDisplay()));

        getStatusControl().onStateChanged(this::onStateChanged);
        getStatusControl().onRunningModuleChanged(this::onRunningModuleChanged);
        getStatusControl().onRunningPageChanged(this::onRunningPageChanged);

        // hook
        editorTracker.onModuleOrDiagramActivate(this::moduleOrDiagramEditorActivated);
        editorTracker.onModuleOrDiagramClose(this::moduleOrDiagramEditorClosed);

        editorTracker.onDiagramVisible(this::diagramEditorShown);
        editorTracker.onDiagramHidden(this::diagramEditorHide);

        getStatusControl().init();

    }

    private void setupSymbolMonitorManagerTracker() {
        BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
        this.symbolMonitorManagerTracker = new GenericServiceTracker<>(context, ISymbolMonitorManager.class);
        this.symbolMonitorManagerTracker.addServiceListener(this);
        this.symbolMonitorManagerTracker.open();
    }

    protected void onRunningModuleChanged(Optional<IMonitorableModule> monitorableModule) {
        monitorableModule.ifPresent(m -> {
            setPartName(String.format(VIEW_TITLE_FMT, String.format(" (%s)", m.moduleFile().getName())));
        });

        monitorableModule.orElseGet(() -> {
            setPartName(String.format(VIEW_TITLE_FMT, ""));
            getSymbolMonitorManager()//
                    .map(ISymbolMonitorManager::unmonitorAllSymbols)//
                    .orElse(Policy.genericError(""));

            return null;
        });

    }

    protected void onStateChanged(State oldValue, State newValue) {
        System.out.println("Transition : " + oldValue + "->" + newValue);

        if (newValue == State.MODULE_PAUSING) {
            getSymbolMonitorManager().map(s -> {
                s.pause(true);
                return null;
            });
        } else if (oldValue == State.MODULE_PAUSING) {
            getSymbolMonitorManager().map(s -> {
                s.pause(false);
                return null;
            });
        }

        updateActions(getViewSite().getActionBars().getToolBarManager(), IAction.ENABLED);

    }

    protected void onRunningPageChanged(Optional<Page> page) {
        // why ever!
        if (getSite().getPart() == null) {
            return;
        }
        if (!page.isPresent()) {
            setContentDescription("");
            IStatus status = getSymbolMonitorManager().map(ISymbolMonitorManager::unmonitorAllSymbols)
                    .orElse(Policy.genericError("unmonitorAllSymbols null result"));
            if (!status.isOK()) {
                Policy.log(status);
            }
            return;
        }
        Page diagramPage = page.get();
        Module module = ((Task) diagramPage.eContainer()).getModule();
        IFile moduleFile = ResourceUtils.toIFile(diagramPage.eResource());
        WorkspaceJob job = new WorkspaceJob("Adding symbols to onlinetest") {
            @Override
            public IStatus runInWorkspace(IProgressMonitor monitor) throws CoreException {
                List<RtSymbol> symbols = translateSymbolsFromPage(monitor, moduleFile, diagramPage);
                return getSymbolMonitorManager()//
                        .map(dm -> {
                            return dm.monitorSymbols(symbols);
                        })//
                        .orElse(Policy.genericError(""));
            }
        };
        job.schedule();

        setContentDescription(String.format("Display values from '/%s/%s/%s' Fieldbus: %d, Type: %s",
                moduleFile.getProject().getName(), //
                moduleFile.getProjectRelativePath().toPortableString(), //
                diagramPage.getName(), //
                module.getFieldBusNumber(), //
                module.getKind())//
        );

    }

    private List<RtSymbol> translateSymbolsFromPage(IProgressMonitor monitor, IFile moduleFile, Page page) {
        requireNonNull(moduleFile, "'moduleFile'");
        requireNonNull(page, "'page'");
        ImmutableList.Builder<RtSymbol> rtsymbols = ImmutableList.builder();
        IRtSymbolTranslator translator = moduleFile.getAdapter(IRtSymbolTranslator.class);
        rtsymbols.addAll(//
                stream(spliteratorUnknownSize(getAllContents(page, true), ORDERED), false)//
                        .filter(EObject.class::isInstance) //
                        .map(EObject.class::cast) //
                        .filter(translator::supportsTranslationFor)//
                        .map(s -> translator.translate(monitor, s))//
                        .distinct()// remove duplicates
                        .filter(Objects::nonNull)//
                        .collect(Collectors.toList())//
        );

        return rtsymbols.build();
    }

    private void diagramEditorHide(MonitorableModule m) {
        if (!getStatusControl().isModuleRunning(m.getModule())) {
            return;
        }
        checkState(m.getPage().isPresent());
        getStatusControl().unmonitorRunningPage();
    }

    private void diagramEditorShown(MonitorableModule m) {
        if (!getStatusControl().isModuleRunning(m.getModule())) {
            return;
        }
        checkState(m.getPage().isPresent());
        // module is running, lets send all symbols to backend
        getStatusControl().monitorPage(m);
    }

    private void moduleOrDiagramEditorActivated(MonitorableModule m) {
        // handle only modules
        if (!getStatusControl().makeSelectable(m)) {
            return;
        }
        // no module is running, change view label
        setContentDescription(String.format("Press start to monitor '%s/%s' Fieldbus: %d, Type: %s",
                m.moduleFile().getProject().getName(), //
                m.moduleFile().getProjectRelativePath().toPortableString(), //
                m.getModule().getFieldBusNumber(), //
                m.getModule().getKind())//
        );
    }

    private void moduleOrDiagramEditorClosed(MonitorableModule m) {
        // if modulefile is closed, stop onlinetest
        // if diagram is closed and modulefile is yet open, do nothing

        // a diagram editor should be closed. don't close if either the module
        // editor or more than 1 (1=self) diag editors are open
        if (m.isDiagramPage()
                && (isModuleEditorOpen(m.getModule()) || countOpenDiagramEditorsForModule(m.getModule()) > 1)) {
            return;
        }
        if (!m.isDiagramPage() && countOpenDiagramEditorsForModule(m.getModule()) > 0) {
            return;
        }
        // stop monitoring
        if (getStatusControl().isModuleRunning(m.getModule())) {
            getStatusControl().stop(new NullProgressMonitor());
        }
    }

    private boolean isModuleEditorOpen(Module module) {
        return Arrays//
                .stream(getViewSite().getPage().getEditorReferences())//
                .filter(r -> EditorListener.MICAS_MODULE_EDITOR.equals(r.getId()))//
                .map(MonitorableModule::fromEditorReference)//
                .filter(Optional::isPresent)//
                .map(Optional::get)//
                .map(MonitorableModule::getModule)//
                .anyMatch(module::equals);
    }

    private long countOpenDiagramEditorsForModule(Module module) {
        return Arrays//
                .stream(getViewSite().getPage().getEditorReferences())//
                .filter(r -> EditorListener.MICAS_BLOCK_DIAGRAM_EDITOR.equals(r.getId()))//
                .map(MonitorableModule::fromEditorReference)//
                .filter(Optional::isPresent)//
                .map(Optional::get)//
                .map(MonitorableModule::getModule)//
                .filter(module::equals).count();
    }

    public static void updateActions(IContributionManager contributionManager, String... propertyName) {
        Objects.requireNonNull(contributionManager, "'contributionManager'");
        Objects.requireNonNull(propertyName, "'propertyName'");
        stream(contributionManager.getItems())//
                .filter(ActionContributionItem.class::isInstance)//
                .map(ActionContributionItem.class::cast)//
                .forEach(ai -> {
                    Optional.of(ai.getAction())//
                            .filter(IUpdate.class::isInstance)//
                            .map(IUpdate.class::cast).ifPresent(u -> {
                                u.update();
                                stream(propertyName).forEach(p -> {
                                    ai.update(p);
                                });
                            });
                });
    }

    @Override
    public void dispose() {
        editorTracker.dispose();
    }

    @Override
    public void createPartControl(Composite parent) {
        Composite composite = new Composite(parent, SWT.NONE);
        GridLayout layout = new GridLayout();
        layout.horizontalSpacing = 0;
        layout.verticalSpacing = 0;
        layout.marginWidth = 0;
        layout.marginHeight = 0;
        composite.setLayout(layout);
        composite.setLayoutData(new GridData(GridData.FILL_BOTH));

        Composite panel = new Composite(composite, SWT.NONE);
        panel.setLayoutData(new GridData(GridData.FILL_BOTH));
        TableColumnLayout tcl = new TableColumnLayout();
        panel.setLayout(tcl);
        this.monitorTableViewer = new TableViewer(panel, SWT.FULL_SELECTION | SWT.V_SCROLL | SWT.VIRTUAL);
        ObservableListContentProvider cp = new ObservableListContentProvider();
        {
            TableViewerColumn tvc = new TableViewerColumn(this.monitorTableViewer, SWT.NONE);
            tvc.getColumn().setText("Index");
            tcl.setColumnData(tvc.getColumn(), new ColumnPixelData(70, true));
            tvc.setLabelProvider(
                    new GenericMapCellLabelProvider("{0}", singleElementAttributeMap(cp, MONITORED_ITEM__INDEX)));

        }
        {

            TableViewerColumn tvc = new TableViewerColumn(this.monitorTableViewer, SWT.NONE);
            tvc.getColumn().setText("Symbolname");
            tvc.setLabelProvider(new GenericMapCellLabelProvider("{0}",
                    singleElementAttributeMap(cp, MONITORED_ITEM__RT_SYMBOL, RT_SYMBOL__NAME)));
            tcl.setColumnData(tvc.getColumn(), new ColumnPixelData(200, true));
        }
        {
            TableViewerColumn tvc = new TableViewerColumn(this.monitorTableViewer, SWT.NONE);
            tvc.getColumn().setText("Symboltyp");
            tcl.setColumnData(tvc.getColumn(), new ColumnPixelData(100, true));
            IObservableMap<?, ?> attributeMap = singleElementAttributeMap(cp, MONITORED_ITEM__RT_SYMBOL);
            tvc.setLabelProvider(new SymbolTypeLabelProvider(attributeMap));

        }
        {
            TableViewerColumn tvc = new TableViewerColumn(this.monitorTableViewer, SWT.NONE);
            tvc.getColumn().setText("Symboladresse");
            tcl.setColumnData(tvc.getColumn(), new ColumnPixelData(100, true));
            tvc.setLabelProvider(new StringFormatMapCellLabelProvider("0x%04x",
                    singleElementAttributeMap(cp, MONITORED_ITEM__RT_SYMBOL, RT_SYMBOL__ADDRESS)));

        }
        {
            TableViewerColumn tvc = new TableViewerColumn(this.monitorTableViewer, SWT.NONE);
            tvc.getColumn().setText("Wert");
            tvc.getColumn().setWidth(300);
            tcl.setColumnData(tvc.getColumn(), new ColumnPixelData(300, true));
            tvc.setLabelProvider(
                    new GenericMapCellLabelProvider("{0}", singleElementAttributeMap(cp, MONITORED_ITEM__TEXT_VALUE)));
        }

        this.monitorTableViewer.getTable().setLinesVisible(true);
        this.monitorTableViewer.getTable().setHeaderVisible(true);
        this.monitorTableViewer.setContentProvider(cp);
        updateViewerInput();

        MenuManager mm = new MenuManager("#PopUp");
        mm.setRemoveAllWhenShown(true);
        mm.addMenuListener(manager -> {
            manager.add(new RemoveSymbolAction(this, this.statusControl, getMonitorTableViewer()));
            manager.add(new RemoveAllSymbolsAction(this, this.statusControl, getMonitorTableViewer()));
            manager.add(new SetSymbolValueAction(this, this.statusControl, getMonitorTableViewer()));
        });
        this.monitorTableViewer.getTable().setMenu(mm.createContextMenu(this.monitorTableViewer.getControl()));

        IActionBars actionBars = getViewSite().getActionBars();
        IToolBarManager toolBar = actionBars.getToolBarManager();
        toolBar.add(new StartSymbolmonitorAction(this.statusControl));
        toolBar.add(new PauseSymbolmonitorAction(this.statusControl));
        toolBar.add(new StopSymbolmonitorAction(this.statusControl));
        actionBars.updateActionBars();
        updateActions(getViewSite().getActionBars().getToolBarManager(), IAction.ENABLED);
        // after ui creation
        setupSymbolMonitorManagerTracker();
    }

    private void updateViewerInput() {
        this.monitorTableViewer.getTable().getDisplay().asyncExec(() -> {
            if (this.monitorTableViewer.getTable().isDisposed()) {
                return;
            }
            this.monitorTableViewer.getTable().setRedraw(false);
            try {
                this.monitorTableViewer.setInput(observeViewerInput());
            } finally {
                this.monitorTableViewer.getTable().setRedraw(true);
            }
        });
    }

    @SuppressWarnings("unchecked")
    private IObservableList<?> observeViewerInput() {
        IEMFListProperty modelItems = EMFProperties.list(MONITOR_MODEL__ITEMS);
        MonitorModel monitorModel = getSymbolMonitorManager().map(ISymbolMonitorManager::getMonitorModel)
                .orElse(MonitorFactory.eINSTANCE.createMonitorModel());
        return modelItems.observe(monitorModel);
    }

    private IObservableMap<?, ?> singleElementAttributeMap(ObservableListContentProvider cp,
            EStructuralFeature... featurePath) {
        @SuppressWarnings("unchecked")
        IObservableMap<?, ?> attributeMap = EMFProperties.value(FeaturePath.fromList(featurePath))
                .observeDetail(cp.getKnownElements());
        return attributeMap;
    }

    @Override
    public void setFocus() {
        this.monitorTableViewer.getTable().setFocus();
    }

    public void updateMonitorTable() {
        this.monitorTableViewer.refresh();
    }

    @Override
    public void bindService(ISymbolMonitorManager service) {
        this.symbolMonitorManagerRef.set(service);
        getViewSite().getWorkbenchWindow().getShell().getDisplay().asyncExec(() -> {
            updateViewerInput();
        });
        getStatusControl().deviceConnected();
    }

    @Override
    public void unbindService(ISymbolMonitorManager service) {
        this.symbolMonitorManagerRef.compareAndSet(service, null);
        getStatusControl().deviceDisconnected();
        updateViewerInput();
    }

    @Override
    public <T> T getAdapter(Class<T> adapter) {
        if (SymbolMonitorView.class.equals(adapter)) {
            return adapter.cast(this);
        } else if (ISymbolMonitorStatusControl.class.equals(adapter)) {
            return adapter.cast(getStatusControl());
        } else if (IMicasDeviceManager.class.equals(adapter)) {
            Optional<IMicasDeviceManager> deviceManager = getSymbolMonitorManager()//
                    .map(ISymbolMonitorManager::getMicasDeviceManager);
            return adapter.cast(deviceManager.orElse(null));
        }
        return null;
    }

    public static SymbolMonitorView openAndShow() {
        IWorkbenchWindow dw = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
        IWorkbenchPage page = dw.getActivePage();
        SymbolMonitorView symbolMonitorView = null;
        try {
            symbolMonitorView = (SymbolMonitorView) page.showView(VIEW_ID);
            page.activate(symbolMonitorView);
        } catch (PartInitException e) {
            Policy.logError(e);
        }
        return symbolMonitorView;
    }

    public TableViewer getMonitorTableViewer() {
        return monitorTableViewer;
    }

    public void monotorAllSymbols(List<RtSymbol> symbols) {

    }

    @Override
    public Optional<ISymbolMonitorManager> getSymbolMonitorManager() {
        return Optional.ofNullable(symbolMonitorManagerRef.get());
    }

    public ISymbolMonitorStatusControl getStatusControl() {
        return statusControl;
    }

}
