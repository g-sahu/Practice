package com.practice.leetcode;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int a, b;

        for(String t: tokens) {
            switch(t) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b+a);
                    break;

                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b-a);
                    break;

                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b*a);
                    break;

                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b/a);
                    break;

                default:
                    stack.push(Integer.parseInt(t));
                    break;
            }
        }

        return stack.pop();
    }
}
