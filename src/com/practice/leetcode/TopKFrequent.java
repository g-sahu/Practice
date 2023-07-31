package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
347. Top K Frequent Elements
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent tf = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(tf.topKFrequent(nums, 2)));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            int val = map.getOrDefault(n, 0) + 1;
            map.put(n, val);
        }

        return map.entrySet()
                  .stream()
                  .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                  .limit(k)
                  .map(Map.Entry :: getKey)
                  .mapToInt(Integer :: intValue)
                  .toArray();
    }
}
