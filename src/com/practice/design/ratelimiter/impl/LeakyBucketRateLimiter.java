package com.practice.design.ratelimiter.impl;

import com.practice.design.ratelimiter.Request;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static com.practice.design.ratelimiter.RateLimiterUtils.print;

public class LeakyBucketRateLimiter {
    private final Map<String, Queue<Request>> userMap;
    private final int bucketSize;

    public LeakyBucketRateLimiter(int bucketSize, int processRate, TimeUnit timeUnit) {
        this.bucketSize = bucketSize;
        this.userMap = new ConcurrentHashMap<>();
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        executorService.scheduleWithFixedDelay(this::processRequest, 0, processRate, timeUnit);
    }

    public void transmit(String userId, Request request) {
        if (userMap.containsKey(userId)) {
            Queue<Request> requestQueue = userMap.get(userId);

            if (requestQueue.offer(request)) {
                print(userId + ": Added to queue");
            } else {
                print(userId + ": Dropped");
            }
        } else {
            Queue<Request> requestQueue = new LinkedBlockingQueue<>(bucketSize);
            requestQueue.add(request);
            userMap.put(userId, requestQueue);
            print(userId + ": Added to queue");
        }
    }

    private void processRequest() {
        print("Processing the request");
        //Process the request
    }
}
