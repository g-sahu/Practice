package com.practice.leetcode;

import java.util.Stack;

/*
232. Implement Queue using Stacks
 */
public class MyQueue {
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        int top = stack1.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return top;
    }

    public int peek() {
        while (stack1.size() > 1) {
            stack2.push(stack1.pop());
        }

        int top = stack1.pop();
        stack2.push(top);

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return top;
    }

    public boolean empty() {
        return stack1.empty();
    }
}
