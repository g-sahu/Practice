package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 2073. Time Needed to Buy Tickets
 */
public class TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q = new ArrayDeque<>();

        for(int i=0; i<tickets.length; i++) {
            q.add(i);
        }

        int t = 0;

        while(!q.isEmpty() && tickets[k] > 0) {
            int n = q.remove();

            if(--tickets[n] > 0) {
                q.add(n);
            }

            t++;
        }

        return t;
    }
}
