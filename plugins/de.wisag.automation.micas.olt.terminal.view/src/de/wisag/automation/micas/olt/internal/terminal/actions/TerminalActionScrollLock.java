/*******************************************************************************
 * Copyright (c) 2004, 2007 Wind River Systems, Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Initial Contributors:
 * The following Wind River employees contributed to the Terminal component
 * that contains this file: Chris Thew, Fran Litterio, Stephen Lamb,
 * Helmut Haigermoser and Ted Williams.
 *
 * Contributors:
 * Michael Scharf (Wind River) - split into core, view and connector plugins
 * Martin Oberhuber (Wind River) - fixed copyright headers and beautified
 *******************************************************************************/
package de.wisag.automation.micas.olt.internal.terminal.actions;

import org.eclipse.jface.action.IAction;

import de.wisag.automation.micas.olt.internal.terminal.view.ITerminalView;
import de.wisag.automation.micas.olt.internal.terminal.view.ImageConsts;

public class TerminalActionScrollLock extends TerminalAction {
    public TerminalActionScrollLock(ITerminalView target) {
        super(target, TerminalActionScrollLock.class.getName(), IAction.AS_RADIO_BUTTON);

        setupAction(ActionMessages.SCROLL_LOCK_0, ActionMessages.SCROLL_LOCK_1, ImageConsts.IMAGE_CLCL_SCROLL_LOCK,
                ImageConsts.IMAGE_ELCL_SCROLL_LOCK, ImageConsts.IMAGE_DLCL_SCROLL_LOCK, true);
    }

    @Override
    public void run() {
        fTarget.setScrollLock(!fTarget.isScrollLock());
        setChecked(fTarget.isScrollLock());
    }
}
