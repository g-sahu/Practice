package com.practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
1207. Unique Number of Occurrences
 */
public class UniqueOccurrences {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : arr) {
            int val = map.getOrDefault(j, 0) + 1;
            map.put(j, val);
        }

        Set<Integer> set = new HashSet<>();

        for (Integer val: map.values()) {
            if (set.contains(val)) {
                return false;
            } else {
                set.add(val);
            }
        }

        return true;
    }
}
