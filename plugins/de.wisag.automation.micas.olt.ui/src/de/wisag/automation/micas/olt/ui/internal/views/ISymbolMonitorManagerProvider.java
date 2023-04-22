package de.wisag.automation.micas.olt.ui.internal.views;

import java.util.Optional;

import de.wisag.automation.micas.olt.ISymbolMonitorManager;

public interface ISymbolMonitorManagerProvider {
    Optional<ISymbolMonitorManager> getSymbolMonitorManager();
}
