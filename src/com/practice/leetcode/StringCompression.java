package com.practice.leetcode;

import java.util.Stack;

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
        int l = chars.length;

        if (l == 1) {
            return l;
        }

        char prev = chars[0];
        int c = 1;
        int start = 0;

        for (int i = 1; i < l; i++) {
            if (chars[i] == prev) {
                c++;
            } else {
                chars[start++] = prev;

                if (c > 1) {
                    Stack<Character> stack = getChars(c);
                    while (!stack.isEmpty()) {
                        chars[start++] = stack.pop();
                    }
                }

                c = 1;
            }

            prev = chars[i];
        }

        chars[start++] = prev;
        if (c > 1) {
            Stack<Character> stack = getChars(c);
            while (!stack.isEmpty()) {
                chars[start++] = stack.pop();
            }
        }

        return start;
    }

    private static Stack<Character> getChars(int num) {
        Stack<Character> stack = new Stack<>();

        while (num != 0) {
            stack.add((char) (num%10 + '0'));
            num = num/10;
        }

        return stack;
    }
}
