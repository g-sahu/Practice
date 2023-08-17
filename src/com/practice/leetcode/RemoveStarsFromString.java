package com.practice.leetcode;

import java.util.Stack;

/*
2390. Removing Stars From a String
 */
public class RemoveStarsFromString {

    public static void main(String[] args) {
        RemoveStarsFromString rsfs = new RemoveStarsFromString();
        String s = "leet**cod*e";
        System.out.println(rsfs.removeStars2(s));
    }

    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                stack.pop();
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

    public String removeStars2(String s) {
        int k = 0;
        char[] bytes = s.toCharArray();
        char[] ans = new char[s.length()];

        for (char ch : bytes) {
            if (ch == '*') {
                k--;
            } else {
                ans[k++] = ch;
            }
        }

        return new String(ans, 0, k);
    }
}
