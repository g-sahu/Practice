package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
692. Top K Frequent Words
 */
public class TopKFrequentWords {

    //Using HashMap and Sorting
    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            int f = map.getOrDefault(s, 0) + 1;
            map.put(s, f);
        }

        Comparator<String> comp = (s1, s2) -> {
            int compare = map.get(s2).compareTo(map.get(s1));
            if (compare == 0) {
                return s1.compareTo(s2);
            }
            return compare;
        };

        List<String> candidates = new ArrayList<>(map.keySet());
        candidates.sort(comp);
        return candidates.subList(0, k);
    }
}
