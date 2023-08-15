package com.practice.leetcode;

/*
443. String Compression
 */
public class StringCompression {

    public static void main(String[] args) {
        StringCompression sc = new StringCompression();
        char[] chars = {'a','b','c'};
        System.out.println(sc.compress(chars));
    }

    public int compress(char[] chars) {
        char prev = chars[0];
        int c = 1;
        int start = 0;

        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == prev) {
                c++;
            } else {
                chars[start++] = prev;
                start = updateCount(chars, c, start);
                c = 1;
            }
            prev = chars[i];
        }

        chars[start++] = prev;
        start = updateCount(chars, c, start);
        return start;
    }

    private static int updateCount(char[] chars, int c, int start) {
        if (c > 1) {
            for (char ch: Integer.toString(c).toCharArray()) {
                chars[start++] = ch;
            }
        }
        return start;
    }
}
