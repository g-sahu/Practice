package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 409. Longest Palindrome
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int f = map.getOrDefault(ch, 0) + 1;
            map.put(ch, f);
        }

        int l = 0;
        boolean flag = false;

        for (int v : map.values()) {
            if (v % 2 == 0) {
                l += v;
            } else {
                l = l + (v - 1);
                flag = true;
            }
        }

        return flag ? l + 1 : l;
    }
}
