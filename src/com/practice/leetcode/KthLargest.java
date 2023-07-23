package com.practice.leetcode;

import java.util.Arrays;
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

        if (l == 0) {
            return;
        }

        Arrays.sort(nums);

        for (int i = l - 1; i >= 0; i--) {
            if (i >= l-k) {
                pq.offer(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() < k) {
            pq.offer(val);
        }
        else if (val > pq.peek()) {
            pq.poll();
            pq.offer(val);
        }

        return pq.peek();
    }
}
