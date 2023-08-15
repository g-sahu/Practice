package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
933. Number of Recent Calls
 */
public class RecentCounter {
    private final Queue<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        int x = t - 3000;

        while (!queue.isEmpty() && queue.peek() < x) {
            queue.poll();
        }

        queue.offer(t);
        return queue.size();
    }
}
