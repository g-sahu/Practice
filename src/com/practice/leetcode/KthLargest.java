package com.practice.leetcode;

import java.util.PriorityQueue;

/*
703. Kth Largest Element in a Stream
 */
public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>();
        int l = nums.length;

        for (int num : nums) {
            add(k, num);
        }
    }

    public int add(int val) {
        add(k, val);
        return pq.peek();
    }

    private void add(int k, int num) {
        if (pq.size() < k) {
            pq.offer(num);
        } else if (num > pq.peek()) {
            pq.poll();
            pq.offer(num);
        }
    }
}
