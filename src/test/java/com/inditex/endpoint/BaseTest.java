package com.inditex.endpoint;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public abstract class BaseTest {

    private static final ZoneId ZONE_SPAIN = ZoneId.of("Europe/Madrid");

    protected static Instant toInstantSpain(LocalDateTime localDateTime) {
        return localDateTime.atZone(ZONE_SPAIN).toInstant();
    }

}
