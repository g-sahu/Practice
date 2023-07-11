package com.practice.leetcode;

import java.util.Stack;

/*
LeetCode #394. Decode String
 */
public class DecodeString {
    private int i = 0;

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "2[abc]3[cd]ef";
        System.out.println(ds.decodeStringRecursive(s));
    }

    public String decodeStringRecursive(String s) {
        StringBuilder sb = new StringBuilder();
        int num = 0;

        while (i < s.length()) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                num = (num * 10) + (ch - '0');
            }
            else if (Character.isLetter(ch)) {
                sb.append(ch);
            }
            else if (ch == '[') {
                i++;
                String temp = decodeStringRecursive(s);
                String inner = append(temp, num);
                sb.append(inner);
                num = 0;
            }
            else if (ch == ']') {
                return sb.toString();
            }

            i++;
        }

        return sb.toString();
    }

    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == ']') {
                StringBuilder sb = new StringBuilder();

                //Start popping out until '['
                while (stack.peek() != '[') {
                    char ch1 = stack.pop();
                    sb.insert(0, ch1);
                }

                //Remove [ from stack
                stack.pop();
                StringBuilder count = new StringBuilder();

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    count.insert(0, stack.pop());
                }

                int c = Integer.parseInt(count.toString());
                String sub = append(sb.toString(), c);

                for (char x: sub.toCharArray()) {
                    stack.push(x);
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch: stack) {
            sb.append(ch);
        }

        return sb.toString();
    }

    private String append(String s, int x) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < x; i++) {
            sb.append(s);
        }

        return sb.toString();
    }
}
