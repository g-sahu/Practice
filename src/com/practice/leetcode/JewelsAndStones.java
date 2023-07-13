package com.practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
771. Jewels and Stones
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        JewelsAndStones jas = new JewelsAndStones();
        String jewels = "z";
        String stones = "ZZ";
        System.out.println(jas.numJewelsInStones(jewels, stones));
    }

    //With HashMap
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> map = new HashMap<>();
        int sum = 0;

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            int newVal = map.getOrDefault(ch, 0) + 1;
            map.put(ch, newVal);
        }

        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            sum += map.getOrDefault(ch, 0);
        }

        return sum;
    }

    //String Search
    public int numJewelsInStones1(String jewels, String stones) {
        int sum = 0;

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (jewels.contains(String.valueOf(ch))) {
                sum++;
            }
        }

        return sum;
    }

    //String Search with memoization
    public int numJewelsInStones2(String jewels, String stones) {
        int sum = 0;
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);

            if (set.contains(ch)) {
                sum++;
            } else if (jewels.contains(String.valueOf(ch))) {
                sum++;
                set.add(ch);
            }
        }

        return sum;
    }

    //Binary Search
    public int numJewelsInStones3(String jewels, String stones) {
        int sum = 0;
        char[] j = jewels.toCharArray();
        Arrays.sort(j);

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (Arrays.binarySearch(j, ch) >= 0) {
                sum++;
            }
        }

        return sum;
    }

    //Binary Search with memoization
    public int numJewelsInStones4(String jewels, String stones) {
        int sum = 0;
        char[] j = jewels.toCharArray();
        Arrays.sort(j);
        Set<Character> set = new HashSet<>();

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (set.contains(ch)) {
                sum++;
            } else if (Arrays.binarySearch(j, ch) >= 0) {
                sum++;
                set.add(ch);
            }
        }

        return sum;
    }

    //With HashSet
    public int numJewelsInStones5(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < jewels.length(); i++) {
            char ch = jewels.charAt(i);
            set.add(ch);
        }

        for (int i = 0; i < stones.length(); i++) {
            char ch = stones.charAt(i);
            if (set.contains(ch)) {
                sum++;
            }
        }

        return sum;
    }
}
