package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
225. Implement Stack using Queues
 */
public class MyStack {
    private final Queue<Integer> queue;
    private int top;

    public MyStack() {
        queue = new ArrayDeque<>();
        top = -1;
    }

    public void push(int x) {
        queue.add(x);
        ++top;
    }

    public int pop() {
        for (int i = 0; i < top; i++) {
            queue.add(queue.poll());
        }

        --top;
        return queue.poll();
    }

    public int top() {
        Integer top = pop();
        queue.add(top);
        ++this.top;
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
