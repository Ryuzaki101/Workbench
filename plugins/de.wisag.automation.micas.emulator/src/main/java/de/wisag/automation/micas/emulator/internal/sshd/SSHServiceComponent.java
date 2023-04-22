package de.wisag.automation.micas.emulator.internal.sshd;

import java.util.Map;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;

import de.wisag.automation.micas.emulator.ISSHService;

@Component(immediate = true, enabled = true)
public class SSHServiceComponent implements ISSHService {
    private Thread daemonThread = null;
    private SshDaemon daemon;

    @Activate
    private void activate(ComponentContext c, BundleContext b, Map<String, ?> properties) {
        daemon = new SshDaemon();
        daemonThread = new Thread(daemon);
        daemonThread.start();
        System.out.println("SSH Server started");
        // do some initialization stuff
    }

    @Deactivate
    private void deactivate(ComponentContext c, BundleContext b, Map<String, ?> properties) {
        daemon.setShutdownRequested(true);
        try {
            daemonThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
