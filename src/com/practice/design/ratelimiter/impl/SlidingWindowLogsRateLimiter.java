package com.practice.design.ratelimiter.impl;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.practice.design.ratelimiter.RateLimiterUtils.print;

public class SlidingWindowLogsRateLimiter {
    private Map<String, ConcurrentLinkedDeque<Long>> userMap;
    private int windowSize;
    private int windowLength;

    public SlidingWindowLogsRateLimiter(int windowSize, int windowLength, TimeUnit timeUnit) {
        this.windowSize = windowSize;
        this.windowLength = windowLength;
        userMap = new ConcurrentHashMap<>();
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleWithFixedDelay(this::evict, 0, 1, timeUnit);
    }

    public boolean isAllowed(String userId) {
        if (userMap.containsKey(userId) && !userMap.get(userId).isEmpty()) {
            ConcurrentLinkedDeque<Long> requestQueue = userMap.get(userId);
            long currentTs = Instant.now().toEpochMilli();
            long window = (currentTs - requestQueue.peek()) / 1000;

            if (window <= windowLength && requestQueue.size() < windowSize) {
                requestQueue.addLast(currentTs);
                print(userId + ": Allowed");
                return true;
            } else {
                print(userId + ": Blocked");
                return false;
            }
        } else {
            ConcurrentLinkedDeque<Long> requestQueue = new ConcurrentLinkedDeque<>();
            requestQueue.add(Instant.now().toEpochMilli());
            userMap.put(userId, requestQueue);
            print(userId + ": Allowed");
            return true;
        }
    }

    private void evict() {
        userMap.forEach((userId, queue) -> {
            if (!queue.isEmpty()) {
                long firstTs = queue.peekFirst();
                long currentTs = Instant.now().toEpochMilli();

                if ((currentTs - firstTs)/1000 > windowLength) {
                    print("Removed element: " + queue.pollFirst());
                }
            }
        });
    }
}
