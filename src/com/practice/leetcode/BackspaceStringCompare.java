package com.practice.leetcode;

import java.util.Stack;

/**
 * 844. Backspace String Compare
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        String s1 = processString(s);
        String s2 = processString(t);
        return s1.equals(s2);
    }

    String processString(String s) {
        Stack<Character> stack = new Stack<>();

        for(char ch: s.toCharArray()) {
            if(ch == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(char ch: stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
