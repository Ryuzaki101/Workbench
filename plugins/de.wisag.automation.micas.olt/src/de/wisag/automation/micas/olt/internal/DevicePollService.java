package de.wisag.automation.micas.olt.internal;

import static java.util.Objects.requireNonNull;

import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.AbstractScheduledService;

public class DevicePollService extends AbstractScheduledService {
    private static final TimeUnit TIMEUNIT = TimeUnit.SECONDS;
    private static final int PERIOD = 2;
    private final IDeviceQuery deviceQuery;

    public DevicePollService(IDeviceQuery deviceQuery) {
        super();
        this.deviceQuery = requireNonNull(deviceQuery);
    }

    @Override
    protected void runOneIteration() throws Exception {
        try {
            deviceQuery.pollDeviceAndUpdateModel();
        } catch (Exception e) {
            Policy.logError(e);
        }
    }

    @Override
    protected Scheduler scheduler() {
        return Scheduler.newFixedRateSchedule(0, PERIOD, TIMEUNIT);
    }

}
