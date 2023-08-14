package com.practice.leetcode;

/*
1456. Maximum Number of Vowels in a Substring of Given Length
 */
public class MaxVowels {
    public static void main(String[] args) {
        MaxVowels mv = new MaxVowels();
        String s = "aeiou";
        System.out.println(mv.maxVowels(s, 2));
    }

    public int maxVowels(String s, int k) {
        int max = 0;

        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                max++;
            }
        }

        if (max == k) {
            return max;
        }

        int i = 0;
        int j = k;
        int v = max;

        while (j < s.length()) {
            if (isVowel(s.charAt(i))) {
                --v;
            }

            if (isVowel(s.charAt(j))) {
                ++v;
            }

            i++;
            j++;
            max = Math.max(max, v);
        }

        return max;
    }

    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
