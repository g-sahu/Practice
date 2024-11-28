package com.practice.leetcode;

/**
 * 3110. Score of a String
 */
public class ScoreOfAString {
    public int scoreOfString(String s) {
        char[] chars = s.toCharArray();
        int i=0, j=1;
        int sum = 0;

        while(j<chars.length) {
            int diff = Math.abs(chars[i] - chars[j]);
            sum += diff;
            i++;
            j=i+1;
        }

        return sum;
    }
}
