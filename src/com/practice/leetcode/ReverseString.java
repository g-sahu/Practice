package com.practice.leetcode;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        ReverseString rs = new ReverseString();
        char[] s = new char[]{'g','a','u','r','a','v'};
        System.out.println("Before: " + Arrays.toString(s));
        rs.reverseString(s);
    }

    public void reverseString(char[] s) {
        int l = s.length;
        short i = 0;
        int j = l-1;
        char t;

        while (i < j) {
            if (s[i] != s[j]) {
                t = s[i];
                s[i] = s[j];
                s[j] = t;
            }

            i++;
            j--;
        }

        System.out.println("After: " + Arrays.toString(s));
    }
}
