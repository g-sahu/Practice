package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2404. Most Frequent Even Element
 */
public class MostFrequentEvenElement {

    public int mostFrequentEven(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;

        for(int n: nums) {
            if(n % 2 == 0) {
                int f = map.getOrDefault(n, 0) + 1;
                map.put(n, f);
                max = Math.max(max, f);
            }
        }

        int min = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> e: map.entrySet()) {
            if(e.getValue() == max) {
                min = Math.min(min, e.getKey());
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
