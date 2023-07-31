package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

        for (int n: nums) {
            int val = map.getOrDefault(n, 0) + 1;
            map.put(n, val);
        }

        int[] topK = new int[k];
        Comparator<Map.Entry<Integer, Integer>> comparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());

        List<Integer> list = map.entrySet()
                                .stream()
                                .sorted(comparator)
                                .map(Map.Entry :: getKey)
                                .collect(Collectors.toList());

        for (int i = 0; i < k; i++) {
            topK[i] = list.get(i);
        }

        return topK;
    }
}
