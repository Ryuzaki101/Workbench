package de.wisag.automation.micas.olt.ui;

import java.util.Optional;
import java.util.function.Consumer;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;

public interface ISymbolMonitorStatusControl {

    @FunctionalInterface
    interface StateChangeListener {
        void onStateChanged(State oldState, ISymbolMonitorStatusControl.State newState);
    }

    public enum State {
        /**
         * Initial state, no device connected
         */
        INITIAL,
        /**
         * Device is connected
         */
        CONNECTED,
        /**
         * a module is selectable, but no relevant diagram open
         */
        MODULE_SELECTABLE,

        /**
         * a module is running
         */
        MODULE_RUNNING,
        /**
         * a module is running
         */
        MODULE_PAUSING,

        /**
         * a module is running and symbols from a page has been transferred to
         * device
         */
        MODULE_PAGE_RUNNING

    }

    boolean isPaused();

    boolean isRunning();

    IStatus resume(IProgressMonitor monitor);

    IStatus pause(IProgressMonitor monitor);

    IStatus start(IProgressMonitor monitor);

    IStatus stop(IProgressMonitor monitor);

    boolean canStop();

    boolean canPause();

    boolean canStart();

    boolean makeSelectable(IMonitorableModule module);

    void monitorPage(IMonitorableModule module);

    void unmonitorRunningPage();

    void onRunningModuleChanged(Consumer<Optional<IMonitorableModule>> model);

    void onSelectableModuleChanged(Consumer<Optional<IMonitorableModule>> model);

    void onRunningPageChanged(Consumer<Optional<Page>> page);

    void onStateChanged(StateChangeListener stateChangeListener);

    Optional<IMonitorableModule> getRunningModule();

    boolean isModuleRunning(Module module);

    boolean isSelectableModule(Module module);

    boolean isPageRunning(Page page);

    void deviceConnected();

    void deviceDisconnected();

    boolean isConnected();

    void init();

}
