package de.wisag.automation.micas.olt.ui.internal.views;

import static java.util.Objects.requireNonNull;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;

import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.ValueChangeEvent;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;
import de.wisag.automation.micas.olt.ui.IMonitorableModule;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;

public class SymbolMonitorStatusControl implements ISymbolMonitorStatusControl {
    private final WritableValue<IMonitorableModule> runningModule;
    private final WritableValue<Page> runningPage;
    private final WritableValue<IMonitorableModule> selectableModel;

    private final WritableValue<State> state;
    private final List<Consumer<Optional<IMonitorableModule>>> onRunningModuleChangeConsumer = new CopyOnWriteArrayList<>();
    private final List<Consumer<Optional<IMonitorableModule>>> onSelectableModuleChangeConsumer = new CopyOnWriteArrayList<>();
    private final List<Consumer<Optional<Page>>> onRunningPageChangeConsumer = new CopyOnWriteArrayList<>();
    private final List<StateChangeListener> onStateChangeListenerConsumer = new CopyOnWriteArrayList<>();

    private State hackishBeforePauseState = null;

    public SymbolMonitorStatusControl(Realm realm) {
        super();
        this.runningModule = new WritableValue<>(realm, null, IMonitorableModule.class);
        this.runningPage = new WritableValue<>(realm, null, Page.class);
        this.selectableModel = new WritableValue<>(realm, null, IMonitorableModule.class);
        this.state = new WritableValue<>(realm, State.INITIAL, State.class);
        this.state.addValueChangeListener(this::onStateChange);
        this.runningModule.addValueChangeListener(this::onRunningModuleChange);
        this.selectableModel.addValueChangeListener(this::onSelectableModuleChange);
        this.runningPage.addValueChangeListener(this::onRunningPageChange);
    }

    protected void onStateChange(ValueChangeEvent<? extends State> v) {
        onStateChangeListenerConsumer.forEach(a -> {
            a.onStateChanged(v.diff.getOldValue(), v.diff.getNewValue());
        });
    }

    protected void onRunningModuleChange(ValueChangeEvent<? extends IMonitorableModule> v) {
        Optional<IMonitorableModule> newValue = ofNullable(v.getObservableValue().getValue());
        onRunningModuleChangeConsumer.forEach(c -> {
            c.accept(newValue);
        });
    }

    protected void onSelectableModuleChange(ValueChangeEvent<? extends IMonitorableModule> v) {
        Optional<IMonitorableModule> newValue = ofNullable(v.getObservableValue().getValue());
        onSelectableModuleChangeConsumer.forEach(c -> {
            c.accept(newValue);
        });
    }

    private State state() {
        return state.getValue();
    }

    private void state(State state) {
        this.state.getRealm().exec(() -> {
            doSetState(state);
        });

    }

    private void doSetState(State state) {
        this.state.setValue(state);
    }

    protected void onRunningPageChange(ValueChangeEvent<? extends Page> v) {
        onRunningPageChangeConsumer.forEach(c -> {
            c.accept(Optional.ofNullable(v.getObservableValue().getValue()));
        });
    }

    @Override
    public boolean isPaused() {
        return State.MODULE_PAUSING == state() && hackishBeforePauseState != null;
    }

    @Override
    public boolean isRunning() {
        return State.MODULE_RUNNING == state() || State.MODULE_PAGE_RUNNING == state();
    }

    @Override
    public IStatus resume(IProgressMonitor monitor) {
        Preconditions.checkState(state() == State.MODULE_PAUSING);
        doSetState(State.MODULE_PAUSING);
        return Status.OK_STATUS;
    }

    @Override
    public IStatus pause(IProgressMonitor monitor) {
        Preconditions.checkState(isRunning() || state() == State.MODULE_PAUSING);
        if (isRunning()) {
            this.hackishBeforePauseState = state();
            state(State.MODULE_PAUSING);
        } else if (isPaused()) {
            // resume
            state(this.hackishBeforePauseState);
            this.hackishBeforePauseState = null;
        }

        return Status.OK_STATUS;
    }

    @Override
    public IStatus start(IProgressMonitor monitor) {
        IMonitorableModule moduleToRun = selectableModel.getValue();
        this.selectableModel.setValue(null);
        doSetState(State.MODULE_RUNNING);
        this.runningModule.setValue(moduleToRun);
        // run was applied to a diagramm page, run it
        if (moduleToRun.isDiagramPage()) {
            monitorPage(moduleToRun);
        }
        return Status.OK_STATUS;
    }

    @Override
    public IStatus stop(IProgressMonitor monitor) {
        if (isPaused()) {
            pause(monitor);
        }
        doSetState(State.CONNECTED);
        this.runningModule.setValue(null);
        this.runningPage.setValue(null);
        return Status.OK_STATUS;
    }

    @Override
    public boolean canStop() {
        return isRunning() || isPaused();
    }

    @Override
    public boolean canPause() {
        return isRunning() || isPaused();
    }

    @Override
    public boolean canStart() {
        return state() == State.MODULE_SELECTABLE;
    }

    @Override
    public Optional<IMonitorableModule> getRunningModule() {
        return Optional.ofNullable(runningModule.getValue());
    }

    @Override
    public boolean makeSelectable(IMonitorableModule value) {
        if (state() == State.CONNECTED || state() == State.MODULE_SELECTABLE) {
            doSetState(State.MODULE_SELECTABLE);
            this.selectableModel.setValue(value);
            return true;
        }
        return false;
    }

    @Override
    public void onRunningModuleChanged(Consumer<Optional<IMonitorableModule>> model) {
        this.onRunningModuleChangeConsumer.add(model);

    }

    @Override
    public void onRunningPageChanged(Consumer<Optional<Page>> page) {
        this.onRunningPageChangeConsumer.add(page);

    }

    @Override
    public void onSelectableModuleChanged(Consumer<Optional<IMonitorableModule>> model) {
        this.onSelectableModuleChangeConsumer.add(model);

    }

    @Override
    public boolean isModuleRunning(Module module) {
        requireNonNull(module, "'module'");
        if (!isRunning()) {
            return false;
        }
        Module runningModule2 = getRunningModule().map(IMonitorableModule::getModule).orElse(null);
        return Objects.equal(module, runningModule2);
    }

    @Override
    public boolean isPageRunning(Page page) {
        requireNonNull(page, "'page'");
        if (!isRunning()) {
            return false;
        }
        return Objects.equal(page, runningPage.getValue());
    }

    @Override
    public boolean isSelectableModule(Module module) {
        if (selectableModel.getValue() == null) {
            return false;
        }
        return Objects.equal(module, selectableModel.getValue().getModule());
    }

    @Override
    public void deviceConnected() {
        state(State.CONNECTED);
    }

    @Override
    public void deviceDisconnected() {
        this.runningPage.getRealm().exec(() -> {
            if (runningPage.getValue() != null) {
                unmonitorRunningPage();
            }
            runningModule.setValue(null);
            selectableModel.setValue(null);
            state(State.INITIAL);
        });

    }

    @Override
    public void monitorPage(IMonitorableModule module) {
        requireNonNull(module, "'module'");
        this.runningPage.getRealm().exec(() -> {
            this.runningPage.setValue(module.getPage().get());
            doSetState(State.MODULE_PAGE_RUNNING);
        });

    }

    @Override
    public void unmonitorRunningPage() {
        this.runningPage.getRealm().exec(() -> {
            this.runningPage.setValue(null);
            doSetState(State.MODULE_RUNNING);
        });

    }

    @Override
    public void onStateChanged(StateChangeListener stateChangeListener) {
        this.onStateChangeListenerConsumer.add(stateChangeListener);

    }

    @Override
    public boolean isConnected() {
        return State.CONNECTED == state();
    }

    @Override
    public void init() {
        deviceDisconnected();
    }

}
