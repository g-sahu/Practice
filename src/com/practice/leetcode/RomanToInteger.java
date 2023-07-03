package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static java.util.Arrays.sort;
import static java.util.Comparator.nullsLast;

public class RomanToInteger {
    private static final Map<Character, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        /*RomanToInteger romanToInteger = new RomanToInteger();
        init();
        String s = "MCDLXXVI";
        System.out.println("Roman Numeral: " + s);
        System.out.println("Integer: " + romanToInteger.romanToInt(s));*/

        Integer[] nums = {10, 23, null, 8, null, null, 5, 40, null, 1};
        sort(nums, nullsLast(Integer :: compareTo));
        System.out.println(Arrays.toString(nums));

        Set<Integer> set = new HashSet<>();
        set.contains(1);
    }

    private static void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int size = chars.length;
        int num = 0;
        char prev = '$';
        int current;

        for (int i = size - 1; i >= 0; i--) {
            char c = chars[i];
            current = map.get(c);
            boolean negative = false;

            switch (c) {
                case 'I':
                    if (prev == 'V' || prev == 'X') {
                        negative = true;
                    }
                    break;

                case 'X':
                    if (prev == 'L' || prev == 'C') {
                        negative = true;
                    }
                    break;

                case 'C':
                    if (prev == 'D' || prev == 'M') {
                        negative = true;
                    }
                    break;

                default:
                    break;
            }

            if (negative) {
                num = num - current;
            } else {
                num = num + current;
            }

            prev = c;
        }

        return num;
    }
}
