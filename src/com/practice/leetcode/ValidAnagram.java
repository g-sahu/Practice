package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
242. Valid Anagram
 */
public class ValidAnagram {
    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "anagram";
        String t = "nagaram";
        System.out.println(va.isAnagram3(s, t));
    }

    //Using sorting
    public boolean isAnagram1(String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);

        char[] s2 = t.toCharArray();
        Arrays.sort(s2);

        if (s1.length != s2.length) {
            return false;
        }

        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }

    //Using HashMap
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> map1 = builFreqMap(s);
        Map<Character, Integer> map2 = builFreqMap(t);
        return map1.equals(map2);
    }

    private Map<Character, Integer> builFreqMap(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int val = map.getOrDefault(ch, 0) + 1;
            map.put(ch, val);
        }

        return map;
    }

    //Using ASCII sum
    public boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        return asciiSum(s) == asciiSum(t);
    }

    private int asciiSum(String str) {
        int sum = 0;

        for (int i = 0; i < str.length(); i++) {
            sum += str.charAt(i);
        }

        return sum;
    }
}
