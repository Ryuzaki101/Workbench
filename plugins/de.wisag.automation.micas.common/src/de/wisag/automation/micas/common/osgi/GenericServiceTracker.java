package de.wisag.automation.micas.common.osgi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;

public class GenericServiceTracker<S> extends ServiceTracker<S, S> {
    private S service;
    private final List<IGenericServiceListener<S>> serviceListener;
    private final Class<S> clazz;

    public GenericServiceTracker(BundleContext context, Class<S> clazz) {
        super(context, clazz, null);
        this.clazz = clazz;
        this.serviceListener = Collections.synchronizedList(new ArrayList<IGenericServiceListener<S>>());
    }

    @Override
    public S addingService(ServiceReference<S> reference) {
        this.service = this.clazz.cast(super.addingService(reference));
        informAboutBind();
        return this.service;
    }

    @Override
    public void removedService(ServiceReference<S> reference, S service) {
        if (this.service != service) {
            return;
        }
        informAboutUnBind();
        this.service = null;
        super.removedService(reference, service);
    }

    private void informAboutBind() {
        for (IGenericServiceListener<S> listener : this.serviceListener) {
            listener.bindService(this.service);
        }
    }

    private void informAboutUnBind() {
        for (IGenericServiceListener<S> listener : this.serviceListener) {
            listener.unbindService(this.service);
        }
    }

    public void addServiceListener(IGenericServiceListener<S> serviceListener) {
        // inform immediately if service available
        if (this.service != null) {
            serviceListener.bindService(this.service);
        }
        this.serviceListener.add(serviceListener);
    }

}