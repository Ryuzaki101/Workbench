package de.wisag.automation.micas.module.ui.dialogs;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.databinding.dialog.TitleAreaDialogSupport;
import org.eclipse.jface.databinding.dialog.ValidationMessageProvider;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

public abstract class MicasDomainEditorDialog<P extends Composite, D extends EObject> extends TitleAreaDialog {

    private static final int DLG_MAX_WIDTH = 240;
    private static final int DLG_MIN_WIDTH = 420;
    private EditingDomain editingDomain;
    private D model;
    private DataBindingContext dataBindingContext;
    private String dialogTitle;

    private EditMode editMode;

    public MicasDomainEditorDialog(Shell parentShell) {
        super(parentShell);
    }

    public EditingDomain getEditingDomain() {
        return editingDomain;
    }

    @Override
    protected final Control createDialogArea(Composite parent) {
        P page = doCreateDialogPage(parent);
        Assert.isNotNull(page, "doCreateDialogPage");
        GridDataFactory.fillDefaults().grab(true, true).applyTo(page);
        Assert.isNotNull(getModel(), "model");
        DataBindingContext dbc = getDataBindingContext();
        Assert.isNotNull(dbc, "databindingContext");
        bind(dbc, page);
        getDataBindingContext().updateTargets();
        if (getDialogTitle() != null) {
            getShell().setText(getDialogTitle() + " bearbeiten");
        }
        TitleAreaDialogSupport.create(this, dbc).setValidationMessageProvider(new ValidationMessageProvider() {
            @Override
            public String getMessage(ValidationStatusProvider statusProvider) {
                if (statusProvider == null) {
                    return getDialogTitle() + " " + (EditMode.MODIFY == getEditMode() ? "Bearbeitung" : "Änderung");
                }
                return super.getMessage(statusProvider);
            }

            @Override
            public int getMessageType(ValidationStatusProvider statusProvider) {
                int type = super.getMessageType(statusProvider);
                if (getButton(IDialogConstants.OK_ID) != null) {
                    getButton(IDialogConstants.OK_ID).setEnabled(type != IMessageProvider.ERROR);
                }
                return type;
            }
        });
        return page;
    }

    protected abstract P doCreateDialogPage(Composite parent);

    public void setEditingDomain(EditingDomain editingDomain) {
        this.editingDomain = editingDomain;
    }

    protected abstract void bind(DataBindingContext dbc, P page);

    public D getModel() {
        return model;
    }

    public void setModel(D model) {
        this.model = model;
    }

    public DataBindingContext getDataBindingContext() {
        return dataBindingContext;
    }

    public void setDataBindingContext(DataBindingContext dataBindingContext) {
        this.dataBindingContext = dataBindingContext;
    }

    public EditMode getEditMode() {
        return editMode;
    }

    public void setEditMode(EditMode editMode) {
        this.editMode = editMode;
    }

    @Override
    protected int getShellStyle() {
        return super.getShellStyle() | SWT.RESIZE;
    }

    @Override
    protected Point getInitialSize() {
        Point initialSize = super.getInitialSize();
        // 420x240
        int width = initialSize.x;
        int height = initialSize.y;
        if (width < DLG_MIN_WIDTH) {
            width = 420;
        }
        if (height < DLG_MAX_WIDTH) {
            height = 240;
        }
        return new Point(width, height);
    }

    public void setDialogTitle(String dialogTitle) {
        this.dialogTitle = dialogTitle;
    }

    public String getDialogTitle() {
        return dialogTitle;
    }
}
