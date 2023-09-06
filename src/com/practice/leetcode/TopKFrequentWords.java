package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
692. Top K Frequent Words
 */
public class TopKFrequentWords {

    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        TopKFrequentWords o = new TopKFrequentWords();
        List<String> list = o.topKFrequent(words, 2);
        System.out.println(list);
    }

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

    //Using Min Heap
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            int f = map.getOrDefault(s, 0) + 1;
            map.put(s, f);
        }

        Comparator<String> comp = (a, b) -> {
            int compare = map.get(a).compareTo(map.get(b));
            if (compare == 0) {
                return b.compareTo(a);
            }
            return compare;
        };

        Queue<String> pq = new PriorityQueue<>(comp);

        for (String word : map.keySet()) {
            pq.offer(word);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!pq.isEmpty()) {
            ans.add(0, pq.poll());
        }

        return ans;
    }

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        Comparator<String> comp = (w1, w2) -> map.get(w1).equals(map.get(w2))
                ? w2.compareTo(w1)
                : map.get(w1) - map.get(w2);

        PriorityQueue<String> h = new PriorityQueue<>(comp);

        for (String word : map.keySet()) {
            h.offer(word);
            if (h.size() > k)
                h.poll();
        }

        List<String> res = new ArrayList<>();
        while (!h.isEmpty())
            res.add(h.poll());
        Collections.reverse(res);
        return res;
    }
}
