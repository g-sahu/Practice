package com.practice.leetcode;

/*
392. Is Subsequence
 */
public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        if(t.length() < s.length()) {
            return false;
        }

        int i = 0;
        int j = 0;

        while(i < s.length()) {
            if(j == t.length()) {
                return false;
            }

            if(s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }

        return true;
    }
}
