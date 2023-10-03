package com.practice.leetcode;

import java.util.Stack;

/**
 * 1047. Remove All Adjacent Duplicates In String
 */
public class RemoveAdjacentDuplicates {

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (stack.isEmpty() || ch != stack.peek()) {
                stack.push(ch);
            } else {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : stack) {
            sb.append(ch);
        }

        return sb.toString();
    }
}
