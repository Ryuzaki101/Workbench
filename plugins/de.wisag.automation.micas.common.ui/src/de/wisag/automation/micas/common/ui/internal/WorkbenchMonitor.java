package de.wisag.automation.micas.common.ui.internal;

import static de.wisag.automation.micas.common.ui.LicensingWorkbenchDecoratorHelper.adjustWorkbenchLicenzingTitle;

import java.util.concurrent.atomic.AtomicReference;

import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.osgi.service.component.ComponentContext;

import de.wisag.automation.micas.common.licensing.ILicenseManager;
import de.wisag.automation.micas.common.ui.IMicasWorkbenchMonitor;

public class WorkbenchMonitor implements IMicasWorkbenchMonitor {

    private AtomicReference<IWorkbench> workbenchRef = new AtomicReference<>();
    private AtomicReference<ILicenseManager> licMgrRef = new AtomicReference<>();
    private IWindowListener listener;

    public void activate(ComponentContext ctx) throws Exception {
        adjustWorkbenchLicenzingTitle(getLicenseManager());
    }

    private IWorkbench getWorkbench() {
        return workbenchRef.get();
    }

    public void deactivate(ComponentContext ctx) throws Exception {
        if (listener != null) {
            getWorkbench().removeWindowListener(listener);
        }

    }

    public void bindWorkbench(IWorkbench workbench) {
        this.workbenchRef.set(workbench);
    }

    public void unbindWorkbench(IWorkbench workbench) {
        this.workbenchRef.compareAndSet(workbench, null);
    }

    public void bindLicenseManager(ILicenseManager workbench) {
        this.licMgrRef.set(workbench);
    }

    public void unbindLicenseManager(ILicenseManager workbench) {
        this.licMgrRef.compareAndSet(workbench, null);
    }

    public ILicenseManager getLicenseManager() {
        return this.licMgrRef.get();
    }
}