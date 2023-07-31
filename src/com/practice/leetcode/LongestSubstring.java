package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
3. Longest Substring Without Repeating Characters
 */
public class LongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int i = 0;
        int j = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();

        while (j < l) {
            char ch = s.charAt(j);

            if (set.contains(ch)) {
                set.remove(s.charAt(i));
                i++;
            } else {
                set.add(ch);
                j++;
            }

            max = Math.max(j-i, max);

        }

        return max;
    }
}
