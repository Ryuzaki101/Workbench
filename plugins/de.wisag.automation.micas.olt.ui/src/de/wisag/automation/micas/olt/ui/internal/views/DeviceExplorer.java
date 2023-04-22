package de.wisag.automation.micas.olt.ui.internal.views;

import static java.util.Objects.requireNonNull;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeNode;
import org.eclipse.jface.viewers.TreeNodeContentProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.ui.progress.UIJob;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

import de.wisag.automation.micas.common.osgi.GenericServiceTracker;
import de.wisag.automation.micas.common.osgi.IGenericServiceListener;
import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.device.DeviceInfo;
import de.wisag.automation.micas.olt.ui.internal.Activator;

public class DeviceExplorer extends ViewPart implements IGenericServiceListener<IMicasDeviceManager> {

    private final class InitialDeviceDiscovery implements IRunnableWithProgress {
        private final IMicasDeviceManager deviceManager;
        private DeviceTreeNode rootNode;
        private final TreeViewer viewer;

        private InitialDeviceDiscovery(TreeViewer viewer, IMicasDeviceManager deviceManager) {
            this.deviceManager = requireNonNull(deviceManager);
            this.viewer = requireNonNull(viewer);
        }

        @Override
        public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
            monitor.beginTask("Query device Info", IProgressMonitor.UNKNOWN);
            DeviceInfo di = deviceManager.getDeviceInfo(monitor);
            rootNode = new DeviceTreeNode(this.viewer, deviceManager, di);
            List<DeviceTreeNode> dtns = new ArrayList<>();
            for (DeviceInfo deviceInfo : di.getSlaves()) {
                dtns.add(new DeviceTreeNode(this.viewer, deviceManager, deviceInfo));
            }
            rootNode.setChildren(dtns.toArray(new DeviceTreeNode[dtns.size()]));
            monitor.done();
        }

        public DeviceTreeNode getRootNode() {
            return rootNode;
        }
    }

    /**
     * The ID of the view as specified by the extension.
     */
    public static final String ID = "de.wisag.automation.micas.olt.ui.devexplorer";

    private TreeViewer viewer;

    private GenericServiceTracker<IMicasDeviceManager> terminalServiceTracker;

    /**
     * The constructor.
     */
    public DeviceExplorer() {
    }

    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    @Override
    public void createPartControl(Composite parent) {
        this.viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
        BundleContext context = FrameworkUtil.getBundle(getClass()).getBundleContext();
        this.terminalServiceTracker = new GenericServiceTracker<>(context, IMicasDeviceManager.class);
        this.terminalServiceTracker.addServiceListener(this);
        this.terminalServiceTracker.open();
        this.viewer.setContentProvider(new TreeNodeContentProvider());
        this.viewer.setLabelProvider(new LabelProvider() {
            @Override
            public String getText(Object element) {
                return fmtEntry(element);
            }
        });
        getSite().setSelectionProvider(viewer);
        this.viewer.addSelectionChangedListener(new ISelectionChangedListener() {

            @Override
            public void selectionChanged(SelectionChangedEvent event) {
                IStructuredSelection selection = (IStructuredSelection) event.getSelection();
                if (selection != null && !selection.isEmpty()) {
                    getViewSite().getActionBars().getStatusLineManager()
                            .setMessage(fmtEntry(selection.getFirstElement()));
                }
            }
        });
        hookContextMenu();
    }

    private void hookContextMenu() {
        MenuManager menuMgr = new MenuManager("#PopupMenu");
        menuMgr.setRemoveAllWhenShown(true);
        menuMgr.addMenuListener(new IMenuListener() {
            @Override
            public void menuAboutToShow(IMenuManager manager) {
                DeviceExplorer.this.fillContextMenu(manager);
            }
        });
        Menu menu = menuMgr.createContextMenu(this.viewer.getControl());
        this.viewer.getControl().setMenu(menu);
        getSite().registerContextMenu(menuMgr, this.viewer);
    }

    private void fillContextMenu(IMenuManager manager) {
        manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    @Override
    public void setFocus() {
        this.viewer.getControl().setFocus();
    }

    @Override
    public void bindService(final IMicasDeviceManager deviceManager) {
        UIJob uiJob = new UIJob("Query devices") {
            @Override
            public IStatus runInUIThread(IProgressMonitor monitor1) {
                InitialDeviceDiscovery discovery = new InitialDeviceDiscovery(viewer, deviceManager);
                ProgressMonitorDialog pmd = new ProgressMonitorDialog(getViewSite().getShell());
                IStatus status = Status.OK_STATUS;
                try {
                    pmd.run(true, true, discovery);
                } catch (InvocationTargetException e) {
                    status = new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getCause().getMessage(), e.getCause());
                } catch (InterruptedException e) {
                } finally {
                    if (pmd != null) {
                        pmd.close();
                    }
                }
                if (status.isOK()) {
                    viewer.setInput(new TreeNode[] { discovery.getRootNode() });
                    viewer.setSelection(new StructuredSelection(discovery.getRootNode()));
                    viewer.expandAll();
                }
                return status;
            }
        };
        uiJob.schedule(2 * 1000);
    }

    @Override
    public void unbindService(IMicasDeviceManager service) {
        getViewSite().getWorkbenchWindow().getShell().getDisplay().asyncExec(new Runnable() {
            @Override
            public void run() {
                if (viewer != null && !viewer.getControl().isDisposed()) {
                    viewer.setInput(null);
                    viewer.refresh();
                }
            }
        });
    }

    @Override
    public void dispose() {
        this.terminalServiceTracker.close();
        this.terminalServiceTracker = null;
        super.dispose();
    }

    private String fmtEntry(Object element) {
        DeviceTreeNode node = (DeviceTreeNode) element;
        DeviceInfo di = node.getDeviceInfo();
        if (StringUtils.isEmpty(di.getModuleName())) {
            return String.format("Node %03d", di.getFieldBus());
        }
        return String.format("%s [%03d,%s]", di.getModuleName(), di.getFieldBus(), di.getVersion());
    }

    public DeviceTreeNode getSelectedDeviceTreeNode() {
        if (this.viewer != null && !this.viewer.getControl().isDisposed() && !this.viewer.getSelection().isEmpty()) {
            IStructuredSelection ss = (IStructuredSelection) this.viewer.getSelection();
            return (DeviceTreeNode) ss.getFirstElement();
        }
        return null;
    }

}