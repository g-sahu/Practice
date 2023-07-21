package com.practice.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/*
2336. Smallest Number in Infinite Set
 */
public class SmallestInfiniteSet {
    private final PriorityQueue<Integer> priorityQueue;
    private final Set<Integer> elements;

    public SmallestInfiniteSet() {
        priorityQueue = new PriorityQueue<>(1000);
        elements = new HashSet<>();

        for (int i = 1; i <= 1000; i++) {
            priorityQueue.offer(i);
            elements.add(i);
        }
    }

    public int popSmallest() {
        Integer smallest = priorityQueue.poll();
        elements.remove(smallest);
        return smallest == null ? -1 : smallest;
    }

    public void addBack(int num) {
        if (!elements.contains(num)) {
            priorityQueue.offer(num);
            elements.add(num);
        }
    }
}
