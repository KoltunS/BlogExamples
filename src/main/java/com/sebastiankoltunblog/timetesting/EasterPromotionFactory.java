package com.sebastiankoltunblog.timetesting;

import javax.inject.Inject;
import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class EasterPromotionFactory {

    private Clock clock;
    private EasterDayProvider easterDayProvider;

    @Inject
    public EasterPromotionFactory(Clock clock, EasterDayProvider easterDayProvider) {
        this.clock = clock;
        this.easterDayProvider = easterDayProvider;
    }

    public EasterPromotion get() {
        LocalDateTime now = LocalDateTime.now(clock);
        LocalDate easter = easterDayProvider.get(now.getYear());
        return new EasterPromotion(easter);
    }
}
