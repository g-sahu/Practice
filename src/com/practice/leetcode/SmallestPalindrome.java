package com.practice.leetcode;

/*
2697. Lexicographically Smallest Palindrome
 */
public class SmallestPalindrome {
    public static void main(String[] args) {
        SmallestPalindrome sp = new SmallestPalindrome();
        String s = "abcd";
        System.out.println(sp.makeSmallestPalindrome(s));
    }

    public String makeSmallestPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder();

        while (i <= j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            char newChar = ch1 < ch2 ? ch1 : ch2;

            if (i != j) {
                sb.insert(i, newChar);
                sb.insert(i+1, newChar);
            } else {
                sb.insert(i, newChar);
            }

            i++;
            j--;
        }

        return sb.toString();
    }
}
