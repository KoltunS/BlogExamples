package com.sebastiankoltunblog.timetesting;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EasterDayProviderTest {
    @Test
    void getEasterOf2018() {
        EasterDayProvider provider = new EasterDayProvider();
        LocalDate localDate = provider.get(2018);
        assertEquals(LocalDate.of(2018, 4, 1), localDate);
    }
}