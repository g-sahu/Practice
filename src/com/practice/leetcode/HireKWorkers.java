package com.practice.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
2462. Total Cost to Hire K Workers
 */
public class HireKWorkers {
    public static void main(String[] args) {
        HireKWorkers hkw = new HireKWorkers();
        int[] costs = {1,2,4,1};
        System.out.println(hkw.totalCost(costs, 3, 3));
    }

    public long totalCost(int[] costs, int k, int candidates) {
        Comparator<Pair> comparator = (o1, o2) -> Comparator.comparingInt(Pair :: getKey)
                                                            .thenComparingInt(Pair :: getValue)
                                                            .compare(o1, o2);
        PriorityQueue<Pair> pq = new PriorityQueue<>(comparator);
        long sum = 0;
        int i = -1, j = costs.length;

        for (int c = 0; c < candidates; c++) {
            i++;
            j--;
            add(pq, new Pair(costs[i], i));
            add(pq, new Pair(costs[j], j));
        }

        for (int c = 1; c <= k; c++) {
            Pair pair = pq.poll();
            sum += pair.getKey();
            int index = pair.getValue();

            if (index < costs.length) {
                if (index <= i) {
                    add(pq, new Pair(costs[++i], i));
                } else if (index >= j) {
                    add(pq, new Pair(costs[--j], j));
                }
            }
        }

        return sum;
    }

    private void add(PriorityQueue<Pair> pq, Pair pair) {
        if (!pq.contains(pair)) {
            pq.offer(pair);
        }
    }
}

class Pair {
    int key;
    int value;

    public Pair(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
