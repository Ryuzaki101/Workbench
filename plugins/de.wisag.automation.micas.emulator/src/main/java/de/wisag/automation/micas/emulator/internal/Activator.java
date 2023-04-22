package de.wisag.automation.micas.emulator.internal;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import de.wisag.automation.micas.emulator.IApplicationLatch;

public class Activator implements BundleActivator {

    private ServiceRegistration<IApplicationLatch> registration;

    @Override
    public void start(BundleContext context) throws Exception {
        registration = context.registerService(IApplicationLatch.class, new ApplicationLatch(), new Hashtable<>());
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
    }

}
