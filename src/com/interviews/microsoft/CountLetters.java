package com.interviews.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string letters made of N English letters.
 * Count the number of different letters that appear in both uppercase and lowercase where all lowercase occurrences
 * of the given letter appear before any uppercase occurrence.
 * For example, for letters = "aaAbcCABBc" the answer is 2. The condition is met for letters 'a' and 'b', but not for 'c'.
 *
 * Write a function:
 * class Solution {
 *      public int solution(String letters);
 * }
 * that, given a string letters, returns the number of different letters fulfilling the conditions above.
 *
 * Examples:
 * 1. Given letters
 * "aaAbcCABBc", the function should return 2, as explained above.
 * 2. Given letters = "xyzXYZabcABC", the function should return 6.
 * 3. Given letters = "ABCabcAefG", the function should return 0.
 *
 * Write an efficient algorithm for the following assumptions:
 * • N is an integer within the range [1..100,000];
 * • string letters is made only of letters (a-z and/or A-Z).
 */
public class CountLetters {

    public static void main(String[] args) {
        String s = "ABCabcAefG";
        CountLetters o = new CountLetters();
        System.out.println(o.solution(s));
    }

    public int solution(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isLowerCase(ch)) {
                map.put(s.charAt(i), i);
            } else {
                map.putIfAbsent(ch, i);
            }
        }

        int c = 0;

        for (char ch: map.keySet()) {
            char uch = (char) (ch - 32);
            int i = map.getOrDefault(uch, -1);

            if (i > map.get(ch)) {
                c++;
            }
        }

        return c;
    }
}
