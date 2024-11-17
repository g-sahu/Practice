package com.practice.leetcode;

import java.util.Arrays;

/**
 * 344. Reverse String
 */
public class ReverseString {

    //Recursive
    public void reverseString(char[] s) {
        reverse(s, 0, s.length-1);
    }

    void reverse(char[] s, int a, int b) {
        if(a >= b) {
            return;
        }
        char t = s[a];
        s[a] = s[b];
        s[b] = t;
        reverse(s, ++a, --b);
    }

    //Iterative
    public void reverseString1(char[] s) {
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
