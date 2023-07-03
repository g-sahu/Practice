package com.practice.recursion;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[] chars = new char[]{'g', 'a', 'u', 'r', 'a', 'v'};
        reverse(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
    }

    private static void reverse(char[] chars, int i, int j) {
        if (chars != null && chars.length != 0 && i < j) {
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;
            reverse(chars, ++i, --j);
        }
    }
}
