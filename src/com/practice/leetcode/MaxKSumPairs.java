package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
1679. Max Number of K-Sum Pairs
 */
public class MaxKSumPairs {

    public static void main(String[] args) {
        MaxKSumPairs mksp = new MaxKSumPairs();
        int[] nums = {2,5,4,4,1,3,4,4,1,4,4,1,2,1,2,2,3,2,4,2};
        System.out.println(mksp.maxOperations(nums, 3));
    }

    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        int c = 0;

        for (int num : nums) {
            if (map.containsKey(num)) {
                int indices = map.get(num) - 1;

                if (indices == 0) {
                    map.remove(num);
                } else {
                    map.put(num, indices);
                }

                c++;
            } else {
                int comp = k - num;
                int indices = map.getOrDefault(comp, 0);
                indices++;
                map.put(comp, indices);
            }
        }

        return c;
    }
}
