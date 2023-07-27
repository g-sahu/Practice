package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
1358. Number of Substrings Containing All Three Characters
 */
public class NumberOfSubstrings {
    private Map<Character, Integer> map;

    public static void main(String[] args) {
        NumberOfSubstrings nos = new NumberOfSubstrings();
        String s = "acbbcac";
        System.out.println(nos.numberOfSubstrings(s));
    }

    public int numberOfSubstrings(String s) {
        int l = s.length();
        map = new HashMap<>();
        int j = 0;

        while (j < l) {
            inc(s.charAt(j));
            if (map.size() == 3) {
                break;
            }
            j++;
        }

        int substrings = l - j;
        int i = 0;

        while (i < l-3) {
            dec(s.charAt(i));
            i++;
            j = findJ(s, j);

            if (map.size() == 3) {
                substrings += l - j;
            }
        }

        return substrings;
    }

    private int findJ(String s, int j) {
        int l = s.length();

        if (map.size() == 3 || j == l-1) {
            return j;
        }

        while (j < l-1) {
            j++;
            inc(s.charAt(j));

            if (map.size() == 3) {
                break;
            }
        }

        return j;
    }

    private void inc(char ch) {
        int val = map.getOrDefault(ch, 0) + 1;
        map.put(ch, val);
    }

    private void dec(char ch) {
        int val = map.getOrDefault(ch, 0) - 1;

        if (val < 1) {
            map.remove(ch);
        } else {
            map.replace(ch, val);
        }
    }
}
