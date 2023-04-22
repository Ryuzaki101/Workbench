package de.wisag.automation.micas.emulator.internal.sshd;

import java.io.File;
import java.io.IOException;

import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;

import de.wisag.automation.micas.InAppPasswordAuthenticator;
import de.wisag.automation.micas.MicasMonitorShellFactory;

/**
 * From the commandline connect with ... ssh -p 8000 someusername@localhost
 */
public class SshDaemon implements Runnable {
    private static final int PORT = 8000;
    // private static final String BANNER = "\n\nWelcome to SshDaemon!\n\n";

    private boolean shutdownRequested = false;

    public static void main(String[] args) {
        new Thread(new SshDaemon()).start();
    }

    @Override
    public void run() {
        SshServer sshd = SshServer.setUpDefaultServer();
        sshd.setPort(PORT);
        sshd.setKeyPairProvider(new SimpleGeneratorHostKeyProvider(new File("hostkey.ser")));
        sshd.setPasswordAuthenticator(new InAppPasswordAuthenticator());
        sshd.setShellFactory(new MicasMonitorShellFactory());
        try {
            sshd.start();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        // TODO replace with proper interrupt
        while (!shutdownRequested) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }

    public void setShutdownRequested(boolean shutdownRequested) {
        this.shutdownRequested = shutdownRequested;
    }
}