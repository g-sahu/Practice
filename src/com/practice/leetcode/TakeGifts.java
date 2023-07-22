package com.practice.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
2558. Take Gifts From the Richest Pile
 */
public class TakeGifts {

    public static void main(String[] args) {
        TakeGifts tg = new TakeGifts();
        int[] gifts = {25,64,9,4,100};
        System.out.println(tg.pickGifts(gifts, 4));
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int gift : gifts) {
            pq.offer(gift);
        }

        for (int i = 0; i < k; i++) {
            int sqrt = (int) Math.sqrt(pq.poll());
            pq.offer(sqrt);
        }

        long sum = 0L;

        for (Integer integer : pq) {
            sum += integer;
        }

        return sum;
    }
}
