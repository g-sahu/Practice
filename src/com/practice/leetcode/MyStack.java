package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
225. Implement Stack using Queues
 */
public class MyStack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(int x) {
        if (queue1.isEmpty()) {
            queue2.add(x);
        } else if (queue2.isEmpty()) {
            queue1.add(x);
        }
    }

    public int pop() {
        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }

            return queue1.poll();
        }

        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }

            return queue2.poll();
        }

        throw new IllegalArgumentException("Stack is empty");
    }

    public int top() {
        int top;

        if (queue2.isEmpty()) {
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }

            top = queue1.peek();
            queue2.add(queue1.poll());
            return top;
        }

        if (queue1.isEmpty()) {
            while (queue2.size() > 1) {
                queue1.add(queue2.poll());
            }

            top = queue2.peek();
            queue1.add(queue2.poll());
            return top;
        }

        throw new IllegalArgumentException("Stack is empty");
    }

    public boolean empty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }
}
