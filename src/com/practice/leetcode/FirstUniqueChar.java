package com.practice.leetcode;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/*
387. First Unique Character in a String
 */
public class FirstUniqueChar {
    public static void main(String[] args) {
        FirstUniqueChar fuc = new FirstUniqueChar();
        String s = "leetcode";
        System.out.println(fuc.firstUniqChar(s));
    }

    public int firstUniqChar(String s) {
        Map<Character, AbstractMap.SimpleEntry<Integer, Integer>> map = new HashMap<>(); //Freq, Index

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int freq = map.containsKey(ch) ? map.get(ch).getKey() + 1 : 1;
            map.put(ch, new AbstractMap.SimpleEntry<>(freq, i));
        }

        AbstractMap.SimpleEntry<Integer, Integer> num = map.values()
                                                           .stream()
                                                           .filter(entry -> entry.getKey() == 1)
                                                           .min(Map.Entry.comparingByValue())
                                                           .orElse(new AbstractMap.SimpleEntry<>(0, -1));
        return num.getValue();
    }
}
