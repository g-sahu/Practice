package com.practice.design.ratelimiter;

import java.time.Instant;
import java.time.ZoneId;

import static java.time.format.DateTimeFormatter.ofPattern;

public class RateLimiterUtils {
    private RateLimiterUtils() {}

    public static long getCurrentTs() {
        return Instant.now().getEpochSecond();
    }

    public static void print(String s) {
        String currentTs = Instant.now()
                                  .atZone(ZoneId.of("Asia/Kolkata"))
                                  .format(ofPattern("hh:mm:ss:SSS"));

        System.out.println("[" + currentTs + "] " + s);
    }
}
