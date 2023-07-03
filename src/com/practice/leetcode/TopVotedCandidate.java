package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate {
    private int[] persons;
    private int[] times;
    private int[] winners;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        winners = new int[persons.length];

        for (int i = 0; i < persons.length; i++) {
            winners[i] = topVoted(i);
        }
    }

    public static void main(String[] args) {
        int[] persons = new int[]{};
        int[] times = new int[]{};
        TopVotedCandidate obj = new TopVotedCandidate(persons, times);
        System.out.println(obj.q(72272));
    }

    public int q(int t) {
        int l = search(t);
        return winners[l];
    }

    private Integer topVoted(int l) {
        Map<Integer, Integer> map = new HashMap<>();
        int topVoted = -1;
        int max = 0;

        for (int i = 0; i <= l; i++) {
            int p = persons[i];
            int newVal = map.getOrDefault(p, 0) + 1;

            map.put(p, newVal);

            if (newVal >= max) {
                max = newVal;
                topVoted = p;
            }
        }

        return topVoted;
    }

    private int search(int t) {
        int beg = 0;
        int end = times.length - 1;

        if (beg == end) {
            return beg;
        }

        if (t == times[beg]) {
            return beg;
        }

        if (t >= times[end]) {
            return end;
        }

        while (beg <= end) {
            int mid = (beg + end)/2;

            if(t == times[mid]) {
                return mid;
            } else if (t < times[mid]) {
                end = mid - 1;
            } else {
                beg = mid + 1;
            }
        }

        return end;
    }

}
