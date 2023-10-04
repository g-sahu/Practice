package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. Longest Palindrome by Concatenating Two Letter Words
 */
public class LongestPalindromeByConcatenation {

    public static void main(String[] args) {
        String[] words = {"dd","aa","bb","dd","aa","dd","bb","dd","aa","cc","bb","cc","dd","cc"};
        LongestPalindromeByConcatenation o = new LongestPalindromeByConcatenation();
        System.out.println(o.longestPalindrome(words));
    }

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();

        for (String word : words) {
            int freq = map.getOrDefault(word, 0) + 1;
            map.put(word, freq);
        }

        int len = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            String mirror = getMirror(word);

            if (map.containsKey(mirror)) {
                if (word.equals(mirror)) {
                    if (entry.getValue() > 1) {
                        int c = map.get(mirror);
                        int pairs = c/2;
                        len += (pairs * 4);
                        updateMap(map, word, pairs);
                        updateMap(map, mirror, pairs);
                    }
                } else {
                    int c = map.get(mirror);
                    int pairs = Math.min(entry.getValue(), c);
                    len += (pairs * 4);
                    updateMap(map, word, pairs);
                    updateMap(map, mirror, pairs);
                }
            }
        }

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) {
                String word = entry.getKey();
                if (word.equals(getMirror(word))) {
                    len += 2;
                    break;
                }
            }
        }

        return len;
    }

    private static void updateMap(Map<String, Integer> map, String key, int val) {
        int newVal = map.get(key) - val;
        map.replace(key, newVal);
    }

    private static String getMirror(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
