package de.wisag.automation.micas.emulator.internal;

import java.util.concurrent.CountDownLatch;

import de.wisag.automation.micas.emulator.IApplicationLatch;

public class ApplicationLatch implements IApplicationLatch {
    private final CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void signalShutdown() {
        latch.countDown();
    }

    @Override
    public void awaitShutdown() {
        try {
            latch.await();
            onTerminate();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void onTerminate() {
        // TODO Auto-generated method stub
    }

}
