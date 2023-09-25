package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
389. Find the Difference
 */
public class FindTheDifference {

    public static void main(String[] args) {
        String s = "fghewf";
        String t = "gheewff";
        FindTheDifference o = new FindTheDifference();
        System.out.println(o.findTheDifference5(s, t));
    }

    //Using sorting
    public char findTheDifference1(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);

        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != s2[i]) {
                return s2[i];
            }
        }

        return s2[s2.length-1];
    }

    //Using HashMap
    public char findTheDifference2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            int freq = map.getOrDefault(ch, 0) + 1;
            map.put(ch, freq);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (map.containsKey(ch)) {
                int freq = map.get(ch) - 1;

                if (freq == 0) {
                    map.remove(ch);
                } else {
                    map.replace(ch, freq);
                }
            } else {
                return ch;
            }
        }

        return map.keySet().stream().findFirst().get();
    }

    //Using ASCII diff
    public char findTheDifference3(String s, String t) {
        int sum1 = getCharSum(s);
        int sum2 = getCharSum(t);
        return (char) (sum2 - sum1);
    }

    private static int getCharSum(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            sum += s.charAt(i);
        }

        return sum;
    }

    //Using ASCII diff
    public char findTheDifference4(String s, String t) {
        int diff = 0;

        for(int i=0; i<s.length(); i++) {
            diff += s.charAt(i) - t.charAt(i);
        }

        diff = t.charAt(t.length()-1) - diff;
        return (char) diff;
    }

    //Using XOR
    public char findTheDifference5(String s, String t) {
        int diff = 0;

        for (int i = 0; i < s.length(); i++) {
            diff ^= s.charAt(i) ^ t.charAt(i);
        }

        diff = diff ^ t.charAt(t.length()-1);
        return (char) diff;
    }
}
