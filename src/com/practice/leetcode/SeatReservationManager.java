package com.practice.leetcode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 1845. Seat Reservation Manager
 */
public class SeatReservationManager {
    private Queue<Integer> pq;

    public SeatReservationManager(int n) {
        pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++) {
            pq.offer(i);
        }
    }

    public int reserve() {
        return pq.poll();
    }

    public void unreserve(int seatNumber) {
        pq.offer(seatNumber);
    }
}
