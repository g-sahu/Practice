package com.practice.leetcode;

/*
5. Longest Palindromic Substring
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "a";
        System.out.println(lps.longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        int i = 0;
        String max = s.substring(0, 1);

        while (i < len-1) {
            max = getPalindrome(s, len, max, i, i);
            max = getPalindrome(s, len, max, i, i+1);
            i++;
        }

        return max;
    }

    private static String getPalindrome(String s, int len, String max, int l, int r) {
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)) {
            if (max.length() < r - l +1) {
                max = s.substring(l, r + 1);
            }
            l--;
            r++;
        }
        return max;
    }
}
