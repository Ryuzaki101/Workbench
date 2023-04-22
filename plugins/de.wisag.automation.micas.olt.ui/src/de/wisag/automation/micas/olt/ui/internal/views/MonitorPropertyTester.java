package de.wisag.automation.micas.olt.ui.internal.views;

import org.eclipse.core.expressions.PropertyTester;

import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;

public class MonitorPropertyTester extends PropertyTester {

    @Override
    public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
        ISymbolMonitorStatusControl manager = (ISymbolMonitorStatusControl) receiver;
        if ("running".equals(property)) {
            Boolean expected = (Boolean) expectedValue;
            return manager.isRunning() == expected;
        } else if ("startable".equals(property)) {
            return false;
        } else if ("paused".equals(property)) {
            Boolean expected = (Boolean) expectedValue;
            return manager.isPaused() == expected;
        }
        return false;
    }

}
