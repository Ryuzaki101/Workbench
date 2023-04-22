package de.wisag.automation.micas.olt.internal;

import java.util.concurrent.atomic.AtomicReference;

import org.osgi.service.component.ComponentContext;
import org.osgi.service.event.EventAdmin;

public class MonitorMessageBroadcasterBase {
    private AtomicReference<EventAdmin> eventAdmin = new AtomicReference<>(null);

    void activate(ComponentContext context) {

    }

    void deactivate(ComponentContext context) {

    }

    void bindEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin.compareAndSet(null, eventAdmin);
    }

    void unbindEventAdmin(EventAdmin eventAdmin) {
        this.eventAdmin.compareAndSet(eventAdmin, null);
    }

    protected EventAdmin getEventAdmin() {
        return eventAdmin.get();
    }
}
