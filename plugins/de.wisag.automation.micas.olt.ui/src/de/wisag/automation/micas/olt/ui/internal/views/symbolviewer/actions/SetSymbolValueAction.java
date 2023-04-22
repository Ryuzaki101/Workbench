package de.wisag.automation.micas.olt.ui.internal.views.symbolviewer.actions;

import java.util.Arrays;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IInputValidator;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.ui.ISymbolMonitorStatusControl;
import de.wisag.automation.micas.olt.ui.internal.Activator;
import de.wisag.automation.micas.olt.ui.internal.views.ISymbolMonitorManagerProvider;
import de.wisag.automation.micas.rt.RtFactory;
import de.wisag.automation.micas.rt.RtFloatConstant;
import de.wisag.automation.micas.rt.RtFloatVariable;
import de.wisag.automation.micas.rt.RtSymbol;
import de.wisag.automation.micas.rt.RtWordConstant;
import de.wisag.automation.micas.rt.RtWordVariable;

public class SetSymbolValueAction extends AbstractSymbolViewerAction {
    public SetSymbolValueAction(ISymbolMonitorManagerProvider symbolMonitorManager,
            ISymbolMonitorStatusControl statusControl, TableViewer monitorTableViewer) {
        super("Setze Wert", AbstractUIPlugin.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/elcl16/rename.gif"),
                symbolMonitorManager, statusControl, monitorTableViewer);
    }

    @Override
    public boolean isEnabled() {
        MonitoredItem item = getCurrentItem();
        return isSettableType(item) && (getStatusControl().isRunning() || getStatusControl().isPaused());
    }

    private boolean isSettableType(MonitoredItem item) {
        RtSymbol symbol = null;
        if (item == null || (symbol = item.getRtSymbol()) == null) {
            return false;
        }
        boolean settable = false;
        if (symbol instanceof RtFloatConstant) {
            settable = true;
        } else if (symbol instanceof RtWordConstant) {
            settable = true;
        } else if (symbol instanceof RtWordVariable) {
            settable = true;
        } else if (symbol instanceof RtFloatVariable) {
            settable = true;
        }
        return settable;
    }

    @Override
    public void run() {
        MonitoredItem item = getCurrentItem();
        RtSymbol rtSymbol = item.getRtSymbol();
        final boolean isFloat = rtSymbol instanceof RtFloatVariable || rtSymbol instanceof RtFloatConstant;
        String initialValue = item.getTextValue();
        InputDialog dlg = new InputDialog(getMonitorTableViewer().getTable().getShell(), "Wert ändern", "",
                initialValue, new IInputValidator() {

                    @Override
                    public String isValid(String newText) {
                        if (StringUtils.isEmpty(newText)) {
                            return "Eingabe darf nicht leer sein!";
                        }
                        if (isFloat) {
                            try {
                                Float.parseFloat(newText);
                            } catch (NumberFormatException e) {
                                return "Bitte Dezimalzahl eingeben, z.B. 17.4";
                            }
                        } else {
                            if (!NumberUtils.isNumber(newText)) {
                                return "Bitte ganze Zahl angeben, z.B. '4' oder '0x20'";
                            }
                        }
                        return null;
                    }
                });
        dlg.open();
        String newValue = dlg.getValue();
        if (dlg.getReturnCode() == IDialogConstants.OK_ID) {
            RtSymbol newSymbol = (RtSymbol) RtFactory.eINSTANCE.create(rtSymbol.eClass());
            newSymbol.setAddress(rtSymbol.getAddress());
            newSymbol.setName(rtSymbol.getName());
            if (newSymbol instanceof RtFloatConstant) {
                RtFloatConstant s = (RtFloatConstant) newSymbol;
                s.setValue(Double.valueOf(newValue));
            } else if (newSymbol instanceof RtWordConstant) {
                RtWordConstant s = (RtWordConstant) newSymbol;
                s.setValue(Integer.valueOf(newValue));
            } else if (newSymbol instanceof RtWordVariable) {
                RtWordVariable s = (RtWordVariable) newSymbol;
                s.setValue(Integer.valueOf(newValue));
            } else if (newSymbol instanceof RtFloatVariable) {
                RtFloatVariable s = (RtFloatVariable) newSymbol;
                s.setValue(Float.valueOf(newValue));
            } else {
                throw new RuntimeException("Unhandled symboltype");
            }
            getSymbolMonitorManager().ifPresent(m -> {
                m.enqueueValueUpdate(Arrays.asList(newSymbol));
            });
        }
    }

}