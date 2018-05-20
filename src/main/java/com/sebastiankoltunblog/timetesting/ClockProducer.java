package com.sebastiankoltunblog.timetesting;

import javax.enterprise.inject.Produces;
import java.time.Clock;

public class ClockProducer {
    @Produces
    public Clock produce() {
        return Clock.systemDefaultZone();
    }
}
