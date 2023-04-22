package de.wisag.automation.micas.diagram.ui.properties;

import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.databinding.beans.BeanProperties;
import org.eclipse.core.databinding.conversion.IConverter;
import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.databinding.dialog.TitleAreaDialogSupport;
import org.eclipse.jface.databinding.dialog.ValidationMessageProvider;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.wisag.automation.micas.module.util.Row;

public class FKGPairDialog extends TitleAreaDialog {

    private final static class DoubleToStringConverter implements IConverter {
        @Override
        public Object getToType() {
            return String.class;
        }

        @Override
        public Object getFromType() {
            return double.class;
        }

        @Override
        public Object convert(Object fromObject) {
            if (fromObject == null) {
                return "";
            }
            Double d = (Double) fromObject;
            return d.toString();
        }
    }

    private final static class DoubleConverter implements IConverter {
        @Override
        public Object getToType() {
            return double.class;
        }

        @Override
        public Object getFromType() {
            return String.class;
        }

        @Override
        public Object convert(Object fromObject) {
            return NumberUtils.createDouble((String) fromObject);
        }
    }

    private Row row;

    public FKGPairDialog(Shell parentShell) {
        super(parentShell);

    }

    @Override
    protected Control createDialogArea(Composite parent) {
        Assert.isNotNull(row);
        Composite page = new Composite(parent, SWT.NONE);
        DataBindingContext dbc = new DataBindingContext(DisplayRealm.getRealm(parent.getDisplay()));
        GridLayoutFactory.fillDefaults().numColumns(2).applyTo(page);

        Label xValueLabel = new Label(page, SWT.NONE);
        xValueLabel.setText("X-Wert");
        GridDataFactory.swtDefaults().applyTo(xValueLabel);

        Text xValue = new Text(page, SWT.BORDER);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(xValue);
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(xValue), BeanProperties.value(Row.PROP_X).observe(row),
                new UpdateValueStrategy().setAfterGetValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        String v = (String) value;
                        if (!NumberUtils.isNumber(v)) {
                            return ValidationStatus.error("Bitte geben Sie für x eine gültige Zahl ein");
                        }
                        return ValidationStatus.ok();
                    }
                }).setConverter(new DoubleConverter()),
                new UpdateValueStrategy().setConverter(new DoubleToStringConverter()));

        Label yValueLabel = new Label(page, SWT.NONE);
        yValueLabel.setText("Y-Wert");
        GridDataFactory.swtDefaults().applyTo(yValueLabel);

        Text xyalue = new Text(page, SWT.BORDER);
        GridDataFactory.fillDefaults().grab(true, false).applyTo(xyalue);
        dbc.bindValue(WidgetProperties.text(SWT.Modify).observe(xyalue), BeanProperties.value(Row.PROP_Y).observe(row),
                new UpdateValueStrategy().setAfterGetValidator(new IValidator() {

                    @Override
                    public IStatus validate(Object value) {
                        String v = (String) value;
                        if (!NumberUtils.isNumber(v)) {
                            return ValidationStatus.error("Bitte geben Sie für y eine gültige Zahl ein");
                        } else {

                        }
                        return ValidationStatus.ok();
                    }
                }).setConverter(new DoubleConverter()),
                new UpdateValueStrategy().setConverter(new DoubleToStringConverter()));
        GridDataFactory.fillDefaults().applyTo(page);
        TitleAreaDialogSupport.create(this, dbc).setValidationMessageProvider(new ValidationMessageProvider() {
            @Override
            public int getMessageType(ValidationStatusProvider statusProvider) {
                int type = super.getMessageType(statusProvider);
                if (getButton(IDialogConstants.OK_ID) != null) {
                    getButton(IDialogConstants.OK_ID).setEnabled(type != IMessageProvider.ERROR);
                }
                return type;
            }

        });
        setMessage("Bitte Geben Sie ein gültiges Wertepaar ein");
        return super.createDialogArea(parent);
    }

    @Override
    protected void configureShell(Shell newShell) {
        super.configureShell(newShell);
        newShell.setText("Wertepaar bearbeiten");
    }

    public Row getRow() {
        return row;
    }

    public void setRow(Row row) {
        this.row = row;
    }

}
