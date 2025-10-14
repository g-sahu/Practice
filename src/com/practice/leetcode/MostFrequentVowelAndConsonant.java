package com.practice.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 3541. Find Most Frequent Vowel and Consonant
 */
public class MostFrequentVowelAndConsonant {

    public int maxFreqSum(String s) {
        Map<Character, Integer> v = new HashMap<>();
        Map<Character, Integer> c = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int f = 0;

            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                f = v.getOrDefault(ch, 0) + 1;
                v.put(ch, f);
            } else {
                f = c.getOrDefault(ch, 0) + 1;
                c.put(ch, f);
            }
        }

        Optional<Map.Entry<Character, Integer>> o1 = v.entrySet()
                                                      .stream()
                                                      .min(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        Optional<Map.Entry<Character, Integer>> o2 = c.entrySet()
                                                      .stream()
                                                      .min(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        int f1 = o1.isEmpty() ? 0 : o1.get().getValue();
        int f2 = o2.isEmpty() ? 0 : o2.get().getValue();

        return f1+f2;
    }
}
