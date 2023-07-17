package com.practice.leetcode;

/*
2697. Lexicographically Smallest Palindrome
 */
public class SmallestPalindrome {
    public static void main(String[] args) {
        SmallestPalindrome sp = new SmallestPalindrome();
        String s = "egcfe";
        System.out.println(sp.makeSmallestPalindrome(s));
    }

    public String makeSmallestPalindrome(String s) {
        char[] string = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            char ch1 = string[i];
            char ch2 = string[j];
            char newChar = ch1 < ch2 ? ch1 : ch2;
            string[i] = newChar;
            string[j] = newChar;
            i++;
            j--;
        }

        return new String(string);
    }
}
