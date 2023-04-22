package de.wisag.automation.micas.emulator.rcp;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.wisag.automation.micas.emulator.IApplicationLatch;

public class EmulatorApplication implements IApplication {
    private final static Logger logger = LoggerFactory.getLogger(EmulatorApplication.class);

    @Override
    public Object start(IApplicationContext context) throws Exception {
        Bundle bundle = FrameworkUtil.getBundle(getClass());
        logger.info("EmulatorApplication.start()");
        System.out.println(context.getArguments());
        ServiceReference<IApplicationLatch> sref = bundle.getBundleContext()
                .getServiceReference(IApplicationLatch.class);
        IApplicationLatch service = bundle.getBundleContext().getService(sref);
        service.awaitShutdown();
        return null;
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

}
