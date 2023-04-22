package de.wisag.automation.micas.olt.ui;

import java.util.Optional;

import org.eclipse.core.resources.IFile;

import de.wisag.automation.micas.module.Module;
import de.wisag.automation.micas.module.Page;

public interface IMonitorableModule {

    Module getModule();

    IFile moduleFile();

    Optional<Page> getPage();

    boolean isDiagramPage();

}