package de.wisag.automation.micas.olt.ui.internal;

import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_ALL_TOPICS;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_BEGIN_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_CONNECTED_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_END_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_PAUSE_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_RESUME_TOPIC;
import static de.wisag.automation.micas.olt.ISymbolMonitorMessages.SYM_MONITOR_UNCONNECTED_TOPIC;
import static org.osgi.service.event.EventConstants.EVENT_TOPIC;

import java.util.Dictionary;
import java.util.Hashtable;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.jface.databinding.swt.DisplayRealm;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.menus.WorkbenchWindowControlContribution;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventHandler;

public class OltStatusIndicatorContribution extends WorkbenchWindowControlContribution implements EventHandler {
    private ServiceRegistration<EventHandler> sreg;
    private final static String STATUS_MSG_FMT = "OLT-Status: %s";
    private static final String PAUSE_MSG = String.format(STATUS_MSG_FMT, " pausiert ");
    private static final String INACTIVE_MSG = String.format(STATUS_MSG_FMT, " inaktiv  ");
    private static final String ACTIVE_MSG = String.format(STATUS_MSG_FMT, " aktiv    ");
    private static final String CONNECTED_MSG = String.format(STATUS_MSG_FMT, " online    ");
    private static final String NOT_CONNECTED_MSG = String.format(STATUS_MSG_FMT, " offline    ");
    private WritableValue<String> statusMessage;

    public OltStatusIndicatorContribution() {
        super(OltStatusIndicatorContribution.class.getName());
    }

    public OltStatusIndicatorContribution(String id) {
        super(id);
    }

    @Override
    protected Control createControl(Composite parent) {
        parent.getParent().setRedraw(true);
        subscribeOsgiEvents();
        Realm realm = DisplayRealm.getRealm(parent.getDisplay());
        DataBindingContext ctx = new DataBindingContext(realm);
        statusMessage = new WritableValue<>(realm, String.format(STATUS_MSG_FMT, " unbekannt   "), String.class);
        Composite container = new Composite(parent, SWT.NONE);
        container.setLayout(new FillLayout());
        Label ccCtrl = new Label(container, SWT.BORDER | SWT.CENTER);
        ccCtrl.setBackground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_BLUE));
        ccCtrl.setForeground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
        ctx.bindValue(WidgetProperties.text().observe(ccCtrl), statusMessage);
        return container;
    }

    private void subscribeOsgiEvents() {
        BundleContext bc = FrameworkUtil.getBundle(getClass()).getBundleContext();
        // register for osgi events for onlinemonitor
        final Dictionary<String, Object> properties = new Hashtable<>();
        properties.put(EVENT_TOPIC, SYM_MONITOR_ALL_TOPICS);
        this.sreg = bc.registerService(EventHandler.class, this, properties);
    }

    @Override
    public boolean isDynamic() {
        return true;
    }

    private void unSubscribeOsgiEvents() {
        if (this.sreg != null) {
            this.sreg.unregister();
        }
    }

    @Override
    public void handleEvent(Event event) {
        String topic = event.getTopic();
        if (SYM_MONITOR_BEGIN_TOPIC.equals(topic)) {
            updateMessage(ACTIVE_MSG);
        } else if (SYM_MONITOR_END_TOPIC.equals(topic)) {
            updateMessage(INACTIVE_MSG);
        } else if (SYM_MONITOR_PAUSE_TOPIC.equals(topic)) {
            updateMessage(PAUSE_MSG);
        } else if (SYM_MONITOR_RESUME_TOPIC.equals(topic)) {
            updateMessage(ACTIVE_MSG);
        } else if (SYM_MONITOR_CONNECTED_TOPIC.equals(topic)) {
            updateMessage(CONNECTED_MSG);
        } else if (SYM_MONITOR_UNCONNECTED_TOPIC.equals(topic)) {
            updateMessage(NOT_CONNECTED_MSG);
        }

    }

    private void updateMessage(final String msg) {
        statusMessage.getRealm().asyncExec(new Runnable() {

            @Override
            public void run() {
                statusMessage.setValue(msg);
            }
        });
    }

    @Override
    public void dispose() {
        unSubscribeOsgiEvents();
        super.dispose();

    }

}
