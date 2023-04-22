package de.wisag.automation.micas.olt.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;

import de.wisag.automation.micas.olt.IMicasDeviceManager;
import de.wisag.automation.micas.olt.ui.internal.views.DeviceTreeNode;

abstract class AbstractDeviceHandler extends AbstractHandler {

    IMicasDeviceManager getDeviceManager(ExecutionEvent event) throws ExecutionException {
        DeviceTreeNode deviceTreeNode = getDeviceTreeNode(event);
        return getDeviceManager(deviceTreeNode);

    }

    IMicasDeviceManager getDeviceManager(DeviceTreeNode deviceTreeNode) {
        return (IMicasDeviceManager) deviceTreeNode.getAdapter(IMicasDeviceManager.class);
    }

    DeviceTreeNode getDeviceTreeNode(ExecutionEvent event) throws ExecutionException {
        IStructuredSelection selection = (IStructuredSelection) HandlerUtil.getCurrentSelectionChecked(event);
        if (selection == null || selection.isEmpty()) {
            throw new ExecutionException("Selection is empty");
        }
        return (DeviceTreeNode) selection.getFirstElement();
    }
}
