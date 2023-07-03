package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 1876. Substrings of Size Three with Distinct Characters
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
        String s = "xyzzaz";
        System.out.println(g.countGoodSubstrings(s));
    }

    public int countGoodSubstrings(String s) {
        int l = s.length();

        if (l < 3) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < 3; i++) {
            char ch = s.charAt(i);
            int newVal = map.getOrDefault(ch, 0) + 1;
            map.put(ch, newVal);
        }

        int i = 1;
        int j = 3;
        int c = 0;

        if (map.size() == 3) {
            c++;
        }

        while (j < l) {
            //For prev char
            char lch = s.charAt(i - 1);
            int newVal = map.getOrDefault(lch, 0) - 1;

            if (newVal <= 0) {
                map.remove(lch);
            } else {
                map.put(lch, newVal);
            }

            //For next char
            char rch = s.charAt(j);
            newVal = map.getOrDefault(rch, 0) + 1;
            map.put(rch, newVal);

            //Check if it's a 'good substring'
            if (map.size() == 3) {
                c++;
            }

            i++;
            j++;
        }

        return c;
    }
}
