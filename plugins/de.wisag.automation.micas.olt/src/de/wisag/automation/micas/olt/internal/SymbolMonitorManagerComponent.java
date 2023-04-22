package de.wisag.automation.micas.olt.internal;

import static de.wisag.automation.micas.olt.internal.DeviceManagerFilterUtils.isDefinedStragePlgAnswer;
import static java.util.Objects.requireNonNull;
import static org.eclipse.emf.ecore.util.EcoreUtil.copy;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.osgi.service.component.ComponentContext;

import de.wisag.automation.micas.common.HardcodedValues;
import de.wisag.automation.micas.olt.ISymbolMonitorManager;
import de.wisag.automation.micas.olt.monitor.MonitorFactory;
import de.wisag.automation.micas.olt.monitor.MonitorModel;
import de.wisag.automation.micas.olt.monitor.MonitoredItem;
import de.wisag.automation.micas.olt.monitor.MonitoredValue;
import de.wisag.automation.micas.olt.monitor.MonitoredValueSet;
import de.wisag.automation.micas.rt.RtSymbol;

public class SymbolMonitorManagerComponent extends SymbolMonitorManagerComponentBase
        implements ISymbolMonitorManager, IDeviceQuery {
    private final MonitorModel monitorModel = MonitorFactory.eINSTANCE.createMonitorModel();
    private final ReentrantLock monitorModelUpdating = new ReentrantLock();
    private DevicePollService devicePollService;

    private final AtomicBoolean skipPolling = new AtomicBoolean(false);

    @Override
    public void activate(ComponentContext context) throws Exception {
        getMonitorMessageBroadcaster().postConnectedEvent();
        devicePollService = new DevicePollService(this);
        devicePollService.startAsync().awaitRunning();
    }

    @Override
    public void deactivate(ComponentContext context) throws Exception {
        devicePollService.stopAsync().awaitTerminated();
        getMonitorMessageBroadcaster().postUnconnectedEvent();
    }

    private void clearMonitorModel() {
        // reset monitor model
        getMonitorModel().getItems().clear();
        getMonitorModel().setRtModule(null);
    }

    @Override
    public IStatus unmonitorSymbol(RtSymbol symbol) {
        monitorModelUpdating.lock();
        try {
            EList<MonitoredItem> items = getMonitorModel().getItems();
            for (Iterator<MonitoredItem> it = items.iterator(); it.hasNext();) {
                MonitoredItem item = it.next();
                if (symbol.equals(item.getRtSymbol())) {
                    it.remove();
                    break;
                }
            }
            if (getMonitorModel().getItems().isEmpty()) {
                getMonitorModel().setRtModule(null);
            }
        } finally {
            monitorModelUpdating.unlock();
        }
        return Status.OK_STATUS;
    }

    @Override
    public boolean isMonitoring(RtSymbol symbol) {
        requireNonNull(symbol, "'symbols'");
        // really need a copy ??
        return EcoreUtil.copyAll(getMonitorModel().getItems())//
                .stream()//
                .map(MonitoredItem::getRtSymbol)//
                .anyMatch(symbol::equals);
    }

    @Override
    public void enqueueValueUpdate(List<RtSymbol> symbols) {
        getMicasDeviceManager().enqueueValueUpdate(symbols);
    }

    @Override
    public IStatus unmonitorAllSymbols() {
        monitorModelUpdating.lock();
        try {
            clearMonitorModel();
            IStatus clearStatus = getMicasDeviceManager().clearMonitoredSymbols();
            getMonitorMessageBroadcaster().postEndEvent(getMonitorModel());
            return clearStatus;
        } finally {
            monitorModelUpdating.unlock();
        }
    }

    @Override
    public MonitorModel getMonitorModel() {
        return monitorModel;
    }

    @Override
    public IStatus monitorSymbols(List<RtSymbol> symbols) {
        requireNonNull(symbols);
        IStatus clearStatus = getMicasDeviceManager().clearMonitoredSymbols();
        if (!clearStatus.isOK()) {
            return clearStatus;
        }
        MultiStatus multiStatus = new MultiStatus(Activator.PLUGIN_ID, 0, "", null);
        monitorModelUpdating.lock();
        try {
            clearMonitorModel();
            symbols.forEach(symbol -> {
                multiStatus.add(monitorSingleSymbol(symbol));
            });
            getMicasDeviceManager().monitorSymbols(symbols);
            getMonitorMessageBroadcaster().postStartEvent(getMonitorModel());
        } finally {
            monitorModelUpdating.unlock();
        }
        return multiStatus;
    }

    private IStatus monitorSingleSymbol(RtSymbol symbol) {
        if (getMonitorModel().getItems().size() > HardcodedValues.MAX_MONITORABLE_SYMBOLS) {
            return new Status(IStatus.CANCEL, Activator.PLUGIN_ID,
                    String.format("Can not monitor more than %d symbols. Rest will be ignored",
                            HardcodedValues.MAX_MONITORABLE_SYMBOLS));

        }
        MonitoredItem item = MonitorFactory.eINSTANCE.createMonitoredItem();
        item.setRtSymbol(symbol);
        item.setTextValue("n/a");
        getMonitorModel().getItems().add(item);
        int index = getMonitorModel().getItems().indexOf(item);
        item.setIndex(index + 1);
        if (getMonitorModel().getRtModule() == null) {
            getMonitorModel().setRtModule(symbol.getModule());
        }
        return Status.OK_STATUS;
    }

    @Override
    public void pause(boolean shouldPause) {
        this.skipPolling.set(shouldPause);
    }

    @Override
    public void pollDeviceAndUpdateModel() {

        monitorModelUpdating.lock();
        try {
            if (shouldSkipDevicePoll()) {
                return;
            }
        } finally {
            monitorModelUpdating.unlock();
        }
        List<String> rawDevicesValues;
        try {
            rawDevicesValues = getMicasDeviceManager().queryMonitoredSymbolValues();
        } catch (IOException e) {
            Policy.logError(e);
            return;
        }
        monitorModelUpdating.lock();
        try {
            EList<MonitoredItem> items = getMonitorModel().getItems();
            if (items.size() != rawDevicesValues.size()) {
                Policy.logWarning(String.format("Got %d values from device, expect %d. skipping model update",
                        rawDevicesValues.size(), items.size()));
                return;
            }
            MonitoredValueSet set = MonitorFactory.eINSTANCE.createMonitoredValueSet();
            set.setHwType(getMonitorModel().getRtModule().getHwType());
            set.setTimestamp(System.currentTimeMillis());
            List<MonitoredValue> monitoredValues = IntStream.range(0, items.size()).mapToObj(i -> {
                String textValue = rawDevicesValues.get(i);
                MonitoredItem monitoredItem = items.get(i);
                // krm : passthrough some values
                if (!isDefinedStragePlgAnswer(textValue)) {
                    textValue = SymbolFormattingHelper.getFormattedValue(monitoredItem.getRtSymbol(), textValue);
                }
                monitoredItem.setTextValue(textValue);

                MonitoredValue value = MonitorFactory.eINSTANCE.createMonitoredValue();
                value.setValue(textValue);
                value.setRtSymbol(monitoredItem.getRtSymbol());
                value.setName(monitoredItem.getRtSymbol().getName());
                return value;
            }).collect(Collectors.toList());
            set.getValues().addAll(monitoredValues);
            getMonitorMessageBroadcaster().postUpdateEvent(copy(getMonitorModel()), set);
        } finally {
            monitorModelUpdating.unlock();
        }
    }

    private boolean shouldSkipDevicePoll() {
        return skipPolling.get() || getMonitorModel().getRtModule() == null || getMonitorModel().getItems().isEmpty();
    }

}
