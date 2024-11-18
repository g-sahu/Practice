package com.practice.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1094. Car Pooling
 */
public class CarPooling {

    public boolean carPooling(int[][] t, int c) {
        Arrays.sort(t, (a, b) -> Integer.compare(a[1], b[1]));
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(t[0]);
        int x = t[0][0];

        if(x > c) {
            return false;
        }

        for(int i=1; i<t.length; i++) {
            int[] curr = t[i];

            while(!pq.isEmpty()) {
                int[] e = pq.peek();

                if(curr[1] >= e[2]) {
                    e = pq.poll();
                    x -= e[0];
                } else {
                    break;
                }
            }

            pq.offer(curr);
            x += curr[0];

            if(x > c) {
                return false;
            }
        }

        return true;
    }
}
