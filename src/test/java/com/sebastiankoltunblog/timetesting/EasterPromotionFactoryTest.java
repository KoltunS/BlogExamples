package com.sebastiankoltunblog.timetesting;

import com.sebastiankoltunblog.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EasterPromotionFactoryTest {

    @Mock
    private EasterDayProvider easterDayProvider;

    private static final LocalDateTime NOW = LocalDateTime.of(2015, 2, 13, 14, 23);

    private EasterPromotionFactory factory;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
        Clock clock = Clock.fixed(NOW.toInstant(ZoneOffset.UTC), ZoneId.systemDefault());
        factory = new EasterPromotionFactory(clock, easterDayProvider);

    }

    @Test
    void setsProperYearForEasterProvider() {
        factory.get();
        verify(easterDayProvider, only()).get(2015);
    }

}