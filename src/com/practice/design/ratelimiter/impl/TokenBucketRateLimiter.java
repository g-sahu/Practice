package com.practice.design.ratelimiter.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.practice.design.ratelimiter.RateLimiterUtils.getCurrentTs;
import static com.practice.design.ratelimiter.RateLimiterUtils.print;

public class TokenBucketRateLimiter {
    private final int maxTokens;
    private final int refillWindow;
    private final TimeUnit timeUnit;
    private long lastRefillTs;
    private Map<String, Integer> userMap;

    public TokenBucketRateLimiter(int maxTokens, int refillWindow, TimeUnit timeUnit) {
        this.maxTokens = maxTokens;
        this.refillWindow = refillWindow;
        this.timeUnit = timeUnit;
        userMap = new HashMap<>();

        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleWithFixedDelay(this::reset, 0, refillWindow, timeUnit);
    }

    /*
        Check if userId exists
            Yes
                Check if tokens are available
                    Yes -> Decrement by 1 and pass through
                    No -> Block
            No -> Fill the bucket, decrement by 1 and pass through

        Refill tokens at every fixed interval
     */
    public boolean isAllowed(String userId) {
        //refill();
        int currentTokens;

        if (userMap.containsKey(userId)) {
            currentTokens = userMap.get(userId);
            userMap.replace(userId, currentTokens - 1);
        } else {
            currentTokens = maxTokens;
            userMap.put(userId, currentTokens - 1);
        }

        if (currentTokens > 0) {
            print(userId + ": Allowed");
            return true;
        } else {
            print(userId + ": Blocked");
            return false;
        }
    }

    private void refill() {
        long currentTs = getCurrentTs();

        if (currentTs - lastRefillTs >= refillWindow) {
            userMap = new HashMap<>();
            lastRefillTs = currentTs;
            print("Tokens refilled");
        }
    }

    private synchronized void reset() {
        print("Tokens refilled");
        userMap = new HashMap<>();
    }
}
