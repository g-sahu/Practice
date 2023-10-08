package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 911. Online Election
 */
public class TopVotedCandidate {
    int[] times;
    int[] persons;
    int[] winners;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        winners = new int[persons.length];
    }

    public int q(int t) {
        int x = Arrays.binarySearch(times, t);
        x = x < 0 ? Math.abs(x + 2) : x;

        if (winners[x] != -1) {
            return winners[x];
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i <= x; i++) {
            int f = map.getOrDefault(persons[i], 0) + 1;
            map.put(persons[i], f);
        }

        Comparator<Integer> comp = (a, b) -> {
            int f1 = map.get(a);
            int f2 = map.get(b);
            return f1 == f2 ? -1 : Integer.compare(f2, f1);
        };

        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);

        for (int i = 0; i <= x; i++) {
            pq.offer(persons[i]);
        }

        return pq.peek();
    }

}
