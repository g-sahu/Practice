package com.practice.design.ratelimiter;

import com.practice.design.ratelimiter.impl.LeakyBucketRateLimiter;
import com.practice.design.ratelimiter.impl.SlidingWindowLogsRateLimiter;
import com.practice.design.ratelimiter.impl.TokenBucketRateLimiter;

import static java.lang.Thread.sleep;
import static java.util.concurrent.TimeUnit.SECONDS;

public class RateLimitController {

    public static void main(String[] args) throws InterruptedException {
        //tokenBucket();
        //leakyBucket();
        slidingWindowLogs();
    }

    private static void tokenBucket() throws InterruptedException {
        //TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(3, 10);
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter(3, 10, SECONDS);

        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("abc");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("abc");
        rateLimiter.isAllowed("abc");
        rateLimiter.isAllowed("abc");

        sleep(10 * 1000);

        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
    }

    private static void leakyBucket() throws InterruptedException {
        LeakyBucketRateLimiter rateLimiter = new LeakyBucketRateLimiter(3, 10, SECONDS);
        Request request = new Request();

        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("abc", request);
        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("abc", request);
        rateLimiter.transmit("abc", request);

        sleep(10000);

        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("xyz", request);
        rateLimiter.transmit("xyz", request);
    }

    private static void slidingWindowLogs() throws InterruptedException {
        SlidingWindowLogsRateLimiter rateLimiter = new SlidingWindowLogsRateLimiter(3, 10, SECONDS);

        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        //rateLimiter.isAllowed("abc");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        /*rateLimiter.isAllowed("abc");
        rateLimiter.isAllowed("abc");
        rateLimiter.isAllowed("abc");*/

        sleep(15 * 1000);

        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
        rateLimiter.isAllowed("xyz");
    }
}
