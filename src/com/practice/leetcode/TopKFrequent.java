package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
347. Top K Frequent Elements
 */
public class TopKFrequent {
    public static void main(String[] args) {
        TopKFrequent tf = new TopKFrequent();
        int[] nums = {4,1,-1,2,-1,2,3};
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

        for (int n : nums) {
            int val = map.getOrDefault(n, 0) + 1;
            map.put(n, val);
        }

        Comparator<Integer> comparator = Comparator.comparing(map :: get);
        PriorityQueue<Integer> pq = new PriorityQueue<>(comparator);

        map.forEach((key, val) -> {
            if (pq.size() == k) {
                if (map.get(key).compareTo(map.get(pq.peek())) > 0) {
                    pq.poll();
                    pq.offer(key);
                }
            } else {
                pq.offer(key);
            }
        });

        return pq.stream()
                 .mapToInt(Integer :: intValue)
                 .toArray();
    }
}
