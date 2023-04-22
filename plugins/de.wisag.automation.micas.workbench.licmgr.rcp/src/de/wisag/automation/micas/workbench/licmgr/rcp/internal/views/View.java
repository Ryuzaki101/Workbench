package de.wisag.automation.micas.workbench.licmgr.rcp.internal.views;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

public class View extends ViewPart {

    public static final String ID = "de.wisag.automation.micas.workbench.licmgr.view";

    private DataBindingContext ctx;

    private Composite container;

    /**
     * This is a callback that will allow us to create the viewer and initialize
     * it.
     */
    @Override
    public void createPartControl(Composite parent) {
        container = new Composite(parent, SWT.NONE);
        GridDataFactory.fillDefaults().grab(true, true).applyTo(container);
        container.setLayout(new FillLayout());
        OverviewPage overviewPage = new OverviewPage(container, SWT.NONE);
        ctx = new DataBindingContext(DisplayRealm.getRealm(parent.getDisplay()));
        new OverviewPageController().bind(ctx, overviewPage);
    }

    /**
     * Passing the focus request to the viewer's control.
     */
    @Override
    public void setFocus() {
        this.container.setFocus();
    }

    @Override
    public void dispose() {
        super.dispose();
        if (this.ctx != null) {
            this.ctx.dispose();
        }
    }
}