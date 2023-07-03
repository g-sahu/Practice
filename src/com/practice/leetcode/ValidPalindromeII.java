package com.practice.leetcode;

public class ValidPalindromeII {

    public static void main(String[] args) {
        ValidPalindromeII v = new ValidPalindromeII();
        String s = "radaer";
        System.out.println(v.validPalindrome(s));
    }

    public boolean validPalindrome(String s) {
        int l = s.length();

        for (int i = -1; i < l; i++) {
            if (isPalindrome(s, i)) {
                return true;
            }
        }

        return false;
    }

    private boolean isPalindrome(String s, int skip) {
        int l = s.length();
        int i = 0;
        int j = l - 1;

        while(i < j) {
            if (i == skip) {
                i++;
                continue;
            }

            if (j == skip) {
                j--;
                continue;
            }

            if(s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }

        return true;
    }
}
