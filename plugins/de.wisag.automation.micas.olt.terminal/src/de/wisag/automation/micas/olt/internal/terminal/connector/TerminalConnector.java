/*******************************************************************************
 * Copyright (c) 2007, 2009 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Michael Scharf (Wind River) - initial API and implementation
 * Michael Scharf (Wind River) - [200541] Extract from TerminalConnectorExtension.TerminalConnectorProxy
 * Martin Oberhuber (Wind River) - [225853][api] Provide more default functionality in TerminalConnectorImpl
 * Uwe Stieber (Wind River) - [282996] [terminal][api] Add "hidden" attribute to terminal connector extension point
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.connector;

import java.io.OutputStream;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.ServiceRegistration;

import de.wisag.automation.micas.olt.internal.terminal.control.impl.TerminalMessages;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ISettingsPage;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ISettingsStore;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ITerminalConnector;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.ITerminalControl;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.Logger;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.TerminalConnectorExtension;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.TerminalState;
import de.wisag.automation.micas.olt.internal.terminal.provisional.api.provider.TerminalConnectorImpl;

/**
 * An {@link ITerminalConnector} instance, also known as terminal connection
 * type, for maintaining a single terminal connection. It provides all terminal
 * connector functions that can be provided by static markup without loading the
 * actual implementation class. The actual {@link TerminalConnectorImpl}
 * implementation class is lazily loaded by the provided
 * {@link TerminalConnector.Factory} interface when needed. class, and delegates
 * to the actual implementation when needed. The following methods can be called
 * without initializing the contributed implementation class: {@link #getId()},
 * {@link #getName()}, {@link #getSettingsSummary()},
 * {@link #load(ISettingsStore)}, {@link #setTerminalSize(int, int)},
 * {@link #save(ISettingsStore)}, {@link #getAdapter(Class)}
 *
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 *                Clients can get terminal connector instances through the
 *                {@link TerminalConnectorExtension} class.
 * @since de.wisag.automation.micas.olt.terminal 2.0
 */
public class TerminalConnector implements ITerminalConnector {
    /**
     * Creates an instance of TerminalConnectorImpl. This is used to lazily load
     * classed defined in extensions.
     *
     * @since de.wisag.automation.micas.olt.terminal 2.0
     */
    public interface Factory {
        /**
         * Factory method to create the actual terminal connector implementation
         * when needed.
         *
         * @return a Connector
         * @throws Exception
         */
        TerminalConnectorImpl makeConnector() throws Exception;
    }

    /**
     * The factory for creating impl instances.
     */
    private final TerminalConnector.Factory fTerminalConnectorFactory;
    /**
     * The (display) name of the TerminalConnector
     */
    private final String fName;
    /**
     * The unique id the connector
     */
    private final String fId;
    /**
     * Flag to mark the connector as hidden.
     */
    private final boolean fHidden;
    /**
     * The connector
     */
    private TerminalConnectorImpl fConnector;
    /**
     * If the initialization of the class specified in the extension fails, this
     * variable contains the error
     */
    private Exception fException;
    /**
     * The store might be set before the real connector is initialized. This
     * keeps the value until the connector is created.
     */
    private ISettingsStore fStore;
    private ServiceRegistration controlRegistration;

    /**
     * Constructor for the terminal connector.
     *
     * @param terminalConnectorFactory
     *            Factory for lazily instantiating the TerminalConnectorImpl
     *            when needed.
     * @param id
     *            terminal connector ID. The connector is publicly known under
     *            this ID.
     * @param name
     *            translatable name to display the connector in the UI.
     */
    public TerminalConnector(TerminalConnector.Factory terminalConnectorFactory, String id, String name,
            boolean hidden) {
        this.fTerminalConnectorFactory = terminalConnectorFactory;
        this.fId = id;
        this.fName = name;
        this.fHidden = hidden;
    }

    @Override
    public String getInitializationErrorMessage() {
        getConnectorImpl();
        if (this.fException != null) {
            return this.fException.getLocalizedMessage();
        }
        return null;
    }

    @Override
    public String getId() {
        return this.fId;
    }

    @Override
    public String getName() {
        return this.fName;
    }

    @Override
    public boolean isHidden() {
        return this.fHidden;
    }

    private TerminalConnectorImpl getConnectorImpl() {
        if (!isInitialized()) {
            try {
                this.fConnector = this.fTerminalConnectorFactory.makeConnector();
                this.fConnector.initialize();
            } catch (Exception e) {
                this.fException = e;
                this.fConnector = new TerminalConnectorImpl() {
                    @Override
                    public void connect(ITerminalControl control) {
                        // super.connect(control);
                        control.setState(TerminalState.CLOSED);
                        control.setMsg(getInitializationErrorMessage());
                    }

                    @Override
                    public OutputStream getTerminalToRemoteStream() {
                        return null;
                    }

                    @Override
                    public String getSettingsSummary() {
                        return null;
                    }
                };
                // that's the place where we log the exception
                Logger.logException(e);
            }
            if (this.fConnector != null && this.fStore != null) {
                this.fConnector.load(this.fStore);
            }
        }
        return this.fConnector;
    }

    @Override
    public boolean isInitialized() {
        return this.fConnector != null || this.fException != null;
    }

    @Override
    public void connect(ITerminalControl control) {
        getConnectorImpl().connect(control);

    }

    @Override
    public void disconnect() {
        getConnectorImpl().disconnect();
    }

    @Override
    public OutputStream getTerminalToRemoteStream() {
        return getConnectorImpl().getTerminalToRemoteStream();
    }

    @Override
    public String getSettingsSummary() {
        if (this.fConnector != null) {
            return getConnectorImpl().getSettingsSummary();
        } else {
            return TerminalMessages.NotInitialized;
        }
    }

    @Override
    public boolean isLocalEcho() {
        return getConnectorImpl().isLocalEcho();
    }

    @Override
    public void load(ISettingsStore store) {
        if (this.fConnector == null) {
            this.fStore = store;
        } else {
            getConnectorImpl().load(store);
        }
    }

    @Override
    public ISettingsPage makeSettingsPage() {
        return getConnectorImpl().makeSettingsPage();
    }

    @Override
    public void save(ISettingsStore store) {
        // no need to save the settings: it cannot have changed
        // because we are not initialized....
        if (this.fConnector != null) {
            getConnectorImpl().save(store);
        }
    }

    @Override
    public void setTerminalSize(int newWidth, int newHeight) {
        // we assume that setTerminalSize is called also after
        // the terminal has been initialized. Else we would have to cache
        // the values....
        if (this.fConnector != null) {
            this.fConnector.setTerminalSize(newWidth, newHeight);
        }
    }

    @Override
    public Object getAdapter(Class adapter) {
        TerminalConnectorImpl connector = null;
        if (isInitialized()) {
            connector = getConnectorImpl();
        }
        // if we cannot create the connector then we cannot adapt...
        if (connector != null) {
            // maybe the connector is adaptable
            if (connector instanceof IAdaptable) {
                Object result = ((IAdaptable) connector).getAdapter(adapter);
                // Not sure if the next block is needed....
                if (result == null) {
                    // defer to the platform
                    result = Platform.getAdapterManager().getAdapter(connector, adapter);
                }
                if (result != null) {
                    return result;
                }
            }
            // maybe the real adapter is what we need....
            if (adapter.isInstance(connector)) {
                return connector;
            }
        }
        // maybe we have to be adapted....
        return Platform.getAdapterManager().getAdapter(this, adapter);
    }
}