package com.practice.leetcode;

/*
680. Valid Palindrome II
 */
public class ValidPalindromeII {

    public static void main(String[] args) {
        ValidPalindromeII v = new ValidPalindromeII();
        String s = "radar";
        System.out.println(v.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int l = s.length();
        int i = 0;
        int j = l-1;
        int c = 0;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                i++;
                c++;
            } else {
                i++;
                j--;
            }

            if (c > 1) {
                break;
            }
        }

        if (c <= 1) {
            return true;
        }

        i = 0;
        j = l-1;
        c = 0;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                j--;
                c++;
            } else {
                i++;
                j--;
            }

            if (c > 1) {
                break;
            }
        }

        return c <= 1;
    }
}
