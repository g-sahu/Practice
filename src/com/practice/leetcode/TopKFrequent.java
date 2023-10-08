package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347. Top K Frequent Elements
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent tf = new TopKFrequent();
        int[] nums = {1,1,1,2,2,3};
        System.out.println(Arrays.toString(tf.topKFrequent2(nums, 2)));
    }

    //Using HashMap and sorting
    public int[] topKFrequent1(int[] nums, int k) {
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

    //Using Priority Queue
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            int f = map.getOrDefault(num, 0) + 1;
            map.put(num, f);
        }

        Comparator<Integer> comp = (a, b) -> Integer.compare(map.get(a), map.get(b));
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);

        for (int key : map.keySet()) {
            pq.offer(key);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        return pq.stream()
                 .mapToInt(Integer :: intValue)
                 .toArray();
    }
}
