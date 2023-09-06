package com.practice.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
692. Top K Frequent Words
 */
public class TopKFrequentWords {

    //Using HashMap and Sorting
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            int f = map.getOrDefault(s, 0) + 1;
            map.put(s, f);
        }

        Comparator<Map.Entry<String, Integer>> comp = (e1, e2) -> {
            int compare = e2.getValue().compareTo(e1.getValue());
            if (compare == 0) {
                return e1.getKey().compareTo(e2.getKey());
            }
            return compare;
        };

        return map.entrySet()
                  .stream()
                  .sorted(comp)
                  .limit(k)
                  .map(Map.Entry :: getKey)
                  .collect(Collectors.toList());
    }
}
