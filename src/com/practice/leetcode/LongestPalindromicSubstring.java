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
        int i = 0;
        String max = "";

        while (i < s.length()) {
            max = getPalindrome(s, max, i, i);
            max = getPalindrome(s, max, i, i+1);
            i++;
        }

        return max;
    }

    private static String getPalindrome(String s, String max, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            if (max.length() < r-l+1) {
                max = s.substring(l, r+1);
            }

            l--;
            r++;
        }

        return max;
    }
}
