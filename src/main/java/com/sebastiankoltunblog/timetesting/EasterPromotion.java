package com.sebastiankoltunblog.timetesting;

import java.time.LocalDate;

public class EasterPromotion {
    //Other fields..
    private LocalDate expires;

    public EasterPromotion(LocalDate expires) {
        this.expires = expires;
    }

    public LocalDate getExpires() {
        return expires;
    }
}
