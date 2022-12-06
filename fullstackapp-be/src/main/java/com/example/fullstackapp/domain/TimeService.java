package com.example.fullstackapp.domain;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

import org.springframework.stereotype.Service;

@Service
public class TimeService {

    public ZonedDateTime getCurrentZonedDateTime() {
        return ZonedDateTime.now(ZoneOffset.UTC);
    }

    public LocalDateTime getCurrentLocalDateTime() {
        return LocalDateTime.now(ZoneOffset.UTC);
    }

}
