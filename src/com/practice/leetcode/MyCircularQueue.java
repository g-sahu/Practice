package com.practice.leetcode;

/*
622. Design Circular Queue
 */
public class MyCircularQueue {
    private final int capacity;
    private final Integer[] elements;
    private int front;
    private int rear;
    private int size;

    public static void main(String[] args) {
        MyCircularQueue mcq = new MyCircularQueue(3);
        System.out.println(mcq.enQueue(1));
        System.out.println(mcq.enQueue(2));
        System.out.println(mcq.enQueue(3));
        System.out.println(mcq.enQueue(4));
        System.out.println(mcq.Rear());
        System.out.println(mcq.isFull());
        System.out.println(mcq.deQueue());
        System.out.println(mcq.enQueue(4));
        System.out.println(mcq.Rear());
    }

    public MyCircularQueue(int k) {
        capacity = k;
        elements = new Integer[k];
        front = -1;
        rear = -1;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }

        ++rear;
        ++size;

        if (rear == elements.length) {
            rear = 0;
        }

        elements[rear] = value;

        if (size == 1) {
            front = 0;
        }

        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }

        elements[front] = null;
        --size;

        if (size == 0) {
            front = -1;
            rear = -1;
        } else {
            ++front;
        }

        if (front == elements.length) {
            front = 0;
        }

        return true;
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return elements[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }

        return elements[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
