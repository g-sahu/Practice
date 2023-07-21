package com.practice.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
451. Sort Characters By Frequency
 */
public class SortCharsByFreq {

    public static void main(String[] args) {
        SortCharsByFreq scbf = new SortCharsByFreq();
        String s = "acacc";
        System.out.println(scbf.frequencySort2(s));
    }

    //Using HashMap
    public String frequencySort1(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
        }

        StringBuilder sb = new StringBuilder();

        map.entrySet()
           .stream()
           .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
           .forEach(entry -> {
               for (int i = 0; i < entry.getValue(); i++) {
                   sb.append(entry.getKey());
               }
           });

        return sb.toString();
    }

    //Using PriorityQueue
    public String frequencySort2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
            set.add(ch);
        }

        Comparator<Character> comparator = (ch1, ch2) -> map.get(ch2).compareTo(map.get(ch1));
        PriorityQueue<Character> pq = new PriorityQueue<>(comparator);
        pq.addAll(set);
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll();

            if (set.contains(ch)) {
                int freq = map.get(ch);

                for (int i = 1; i <= freq; i++) {
                    sb.append(ch);
                }

                set.remove(ch);
            }
        }

        return sb.toString();
    }
}
