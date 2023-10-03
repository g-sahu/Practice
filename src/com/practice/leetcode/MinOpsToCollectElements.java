package com.practice.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 2869. Minimum Operations to Collect Elements
 */
public class MinOpsToCollectElements {

    public int minOperations(List<Integer> nums, int k) {
        Set<Integer> set = new HashSet<>(k);

        for (int i = 1; i <= k; i++) {
            set.add(i);
        }

        int i = nums.size()-1;

        while (i >= 0) {
            set.remove(i--);

            if (set.isEmpty()) {
                break;
            }
        }

        return nums.size()-i;
    }
}
