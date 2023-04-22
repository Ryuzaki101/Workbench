/*******************************************************************************
 * Copyright (c) 2008 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Michael Scharf (Wind River) - initial API and implementation
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.actions;

import de.wisag.automation.micas.olt.internal.terminal.view.ITerminalViewConnectionManager;
import de.wisag.automation.micas.olt.internal.terminal.view.ITerminalViewConnectionManager.ITerminalViewConnectionListener;
import de.wisag.automation.micas.olt.internal.terminal.view.ImageConsts;

public class TerminalActionRemove extends TerminalAction implements ITerminalViewConnectionListener {
    private final ITerminalViewConnectionManager fConnectionManager;

    public TerminalActionRemove(ITerminalViewConnectionManager target) {
        super(null, TerminalActionRemove.class.getName());
        fConnectionManager = target;
        setupAction(ActionMessages.REMOVE, ActionMessages.REMOVE, null, ImageConsts.IMAGE_ELCL_REMOVE,
                ImageConsts.IMAGE_DLCL_REMOVE, true);
        fConnectionManager.addListener(this);
        connectionsChanged();
    }

    @Override
    public void run() {
        fConnectionManager.removeActive();
    }

    @Override
    public void connectionsChanged() {
        setEnabled(fConnectionManager.size() > 1);
    }
}
