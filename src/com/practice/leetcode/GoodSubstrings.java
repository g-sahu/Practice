package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/* 1876. Substrings of Size Three with Distinct Characters

 * A string is good if there are no repeated characters.
 * Given a string s, return the number of good substrings of length three in s.
 * Note that if there are multiple occurrences of the same substring, every occurrence should be counted.
 * A substring is a contiguous sequence of characters in a string.
 *
 * Example 1:
 * Input: s = "xyzzaz"
 * Output: 1
 * Explanation: There are 4 substrings of size 3: "xyz", "yzz", "zza", and "zaz".
 * The only good substring of length 3 is "xyz".
 *
 * Example 2:
 * Input: s = "aababcabc"
 * Output: 4
 * Explanation: There are 7 substrings of size 3: "aab", "aba", "bab", "abc", "bca", "cab", and "abc".
 * The good substrings are "abc", "bca", "cab", and "abc".
 *
 * Constraints:
 * 1 <= s.length <= 100
 * s consists of lowercase English letters.
 */
public class GoodSubstrings {

    public static void main(String[] args) {
        GoodSubstrings g = new GoodSubstrings();
        String s = "aababcabc";
        System.out.println(g.countGoodSubstrings(s));
    }

    public int countGoodSubstrings(String s) {
        int i = 0;
        int j = 0;
        int c = 0;
        int k = 3;
        int l = s.length();
        Map<Character, Integer> map = new HashMap<>();

        while (j < l) {
            if (i > 0) {
                removePrev(s, i, map);
            }

            addNext(s, j, map);

            if ((j - i + 1) == k) {
                if (map.size() == k) {
                    c++;
                }

                i++;
            }

            j++;
        }

        return c;
    }

    private static void addNext(String s, int j, Map<Character, Integer> map) {
        //For next char
        char rch = s.charAt(j);
        int newVal = map.getOrDefault(rch, 0) + 1;
        map.put(rch, newVal);
    }

    private static void removePrev(String s, int i, Map<Character, Integer> map) {
        //For prev char
        char lch = s.charAt(i - 1);
        int newVal = map.getOrDefault(lch, 0) - 1;

        if (newVal <= 0) {
            map.remove(lch);
        } else {
            map.put(lch, newVal);
        }
    }
}
