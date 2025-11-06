package com.practice.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 2974. Minimum Number Game
 */
public class MinimumNumberGame {

    public int[] numberGame(int[] nums) {
        Queue<Integer> pq = new PriorityQueue<>();

        for(int n: nums) {
            pq.add(n);
        }

        int[] arr = new int[nums.length];
        int i=0;

        while(!pq.isEmpty()) {
            int n1 = pq.poll();
            int n2 = pq.poll();
            arr[i] = n2;
            arr[i+1] = n1;
            i += 2;
        }

        return arr;
    }
}
