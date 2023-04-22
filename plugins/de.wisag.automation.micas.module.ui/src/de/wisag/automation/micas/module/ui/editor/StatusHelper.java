package de.wisag.automation.micas.module.ui.editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.databinding.AggregateValidationStatus;
import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.ValidationStatusProvider;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.swt.widgets.Control;
import org.eclipse.ui.forms.IMessage;
import org.eclipse.ui.forms.widgets.Form;

public class StatusHelper {

    public static void addStatusSupport(final DataBindingContext ctx, final Form form) {
        AggregateValidationStatus aggregateStatus = new AggregateValidationStatus(ctx.getValidationStatusProviders(),
                AggregateValidationStatus.MAX_SEVERITY);
        aggregateStatus.addValueChangeListener(event -> {
            StatusHelper.handleStateChange(event.diff.getNewValue(), ctx, form);
        });
    }

    static void handleStateChange(IStatus currentStatus, DataBindingContext ctx, Form form) {
        if (form.isDisposed() || form.getHead().isDisposed()) {
            return;
        }

        if (currentStatus != null && currentStatus.getSeverity() != IStatus.OK) {
            int type = StatusHelper.convertType(currentStatus.getSeverity());

            List<IMessage> list = new ArrayList<>();
            for (Iterator<?> it = ctx.getValidationStatusProviders().iterator(); it.hasNext();) {
                ValidationStatusProvider validationStatusProvider = (ValidationStatusProvider) it.next();
                final IStatus status = (IStatus) validationStatusProvider.getValidationStatus().getValue();
                if (!status.isOK()) {
                    list.add(new IMessage() {

                        @Override
                        public Control getControl() {
                            return null;
                        }

                        @Override
                        public Object getData() {
                            return null;
                        }

                        @Override
                        public Object getKey() {
                            return null;
                        }

                        @Override
                        public String getPrefix() {
                            return null;
                        }

                        @Override
                        public String getMessage() {
                            Throwable exception = status.getException();
                            return status.getMessage()
                                    + (exception != null ? ("(" + exception.getMessage() + ")") : "");
                        }

                        @Override
                        public int getMessageType() {
                            return StatusHelper.convertType(status.getSeverity());
                        }

                    });
                }
            }
            form.setMessage("Fehlerhafte Daten", type, list.toArray(new IMessage[list.size()]));
        } else {
            form.setMessage(null);
        }
    }

    static int convertType(int severity) {
        switch (severity) {
        case IStatus.OK:
            return IMessageProvider.NONE;
        case IStatus.CANCEL:
            return IMessageProvider.NONE;
        case IStatus.INFO:
            return IMessageProvider.INFORMATION;
        case IStatus.WARNING:
            return IMessageProvider.WARNING;
        case IStatus.ERROR:
            return IMessageProvider.ERROR;
        default:
            return IMessageProvider.NONE;
        }
    }

}
