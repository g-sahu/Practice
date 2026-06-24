package com.interviews.microsoft;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a string {@code letters} made of {@code N} English letters. Count the number of
 * different letters that appear in both uppercase and lowercase where all lowercase occurrences of
 * the given letter appear before any uppercase occurrence.
 *
 * <p>For example, for {@code letters = "aaAbcCABBc"} the answer is 2. The condition is met for
 * letters {@code 'a'} and {@code 'b'}, but not for {@code 'c'}.</p>
 *
 * <p>Write a function:</p>
 *
 * <pre>
 * class Solution {
 *     public int solution(String letters);
 * }
 * </pre>
 *
 * <p>Given a string {@code letters}, the function returns the number of different letters fulfilling
 * the conditions above.</p>
 *
 * <h2>Examples</h2>
 * <ol>
 *     <li>Given {@code letters = "aaAbcCABBc"}, the function should return 2, as explained above.</li>
 *     <li>Given {@code letters = "xyzXYZabcABC"}, the function should return 6.</li>
 *     <li>Given {@code letters = "ABCabcAefG"}, the function should return 0.</li>
 * </ol>
 *
 * <p>Write an efficient algorithm for the following assumptions:</p>
 *
 * <ul>
 *     <li>{@code N} is an integer within the range {@code [1..100,000]}.</li>
 *     <li>String {@code letters} is made only of letters ({@code a-z} and/or {@code A-Z}).</li>
 * </ul>
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
