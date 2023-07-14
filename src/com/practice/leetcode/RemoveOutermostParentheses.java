package com.practice.leetcode;

import java.util.Stack;

/*
1021. Remove Outermost Parentheses
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        RemoveOutermostParentheses rop = new RemoveOutermostParentheses();
        String s = "(()())(())";
        System.out.println(rop.removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            sb.append(ch);

            if (ch == '(') {
                stack.push(ch);
            } else {
                stack.pop();

                if (stack.isEmpty()) {
                    sb.deleteCharAt(j);
                    sb.deleteCharAt(sb.length() - 1);
                    j = sb.length();
                }
            }
        }

        return sb.toString();
    }
}
