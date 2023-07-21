package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
451. Sort Characters By Frequency
 */
public class SortCharsByFreq {

    public static void main(String[] args) {
        SortCharsByFreq scbf = new SortCharsByFreq();
        String s = "tree";
        System.out.println(scbf.frequencySort(s));
    }

    public String frequencySort(String s) {
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
}
