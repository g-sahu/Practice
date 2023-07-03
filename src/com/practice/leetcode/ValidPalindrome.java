package com.practice.leetcode;

/*
        Input: s = "A man, a plan, a canal: Panama"
        Output: true
        Explanation: "amanaplanacanalpanama" is a palindrome.
     */
public class ValidPalindrome {

    public static void main(String[] args) {
        ValidPalindrome v = new ValidPalindrome();
        String s = "race a car";
        System.out.println(v.isPalindrome(s));
    }

    public boolean isPalindrome(String s) {
        int l = s.length();
        int i = 0;
        int j = l - 1;

        while(i < j) {
            char ci = s.charAt(i);
            if (!Character.isLetterOrDigit(ci)) {
                i++;
                continue;
            }

            char cj = s.charAt(j);
            if (!Character.isLetterOrDigit(cj)) {
                j--;
                continue;
            }

            if (Character.toLowerCase(ci) != Character.toLowerCase(cj)) {
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}
