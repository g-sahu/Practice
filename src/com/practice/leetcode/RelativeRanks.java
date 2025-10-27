package com.practice.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 506. Relative Ranks
 */
public class RelativeRanks {

    public String[] findRelativeRanks(int[] s) {
        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> m = new HashMap<>();

        for(int i=0; i<s.length; i++) {
            pq.add(s[i]);
            m.put(s[i], i);
        }

        String[] a = new String[s.length];
        int x = 0;

        while(!pq.isEmpty()) {
            int n = pq.poll();
            int i = m.get(n);

            if(x == 0) {
                a[i] = "Gold Medal";
            } else if (x == 1) {
                a[i] = "Silver Medal";
            } else if (x == 2) {
                a[i] = "Bronze Medal";
            } else {
                a[i] = Integer.toString(x+1);
            }

            x++;
        }

        return a;
    }
}
