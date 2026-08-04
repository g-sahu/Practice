package com.practice.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1046. Last Stone Weight
 */
public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int s: stones) {
            pq.offer(s);
        }

        while(!pq.isEmpty()) {
            int x = pq.poll();

            if(!pq.isEmpty()) {
                int y = pq.poll();
                int diff = Math.abs(x-y);
                pq.offer(diff);
            } else {
                pq.offer(x);
                break;
            }
        }

        return pq.isEmpty() ? 0 : pq.poll();
    }

}
