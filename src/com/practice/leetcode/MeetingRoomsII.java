package com.practice.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 253. Meeting Rooms II
 */
public class MeetingRoomsII {

    public int minMeetingRooms(int[][] matrix) {
        Arrays.sort(matrix, (a, b) -> Integer.compare(a[0], b[0]));
        Queue<Integer> pq = new PriorityQueue<>();
        pq.offer(matrix[0][1]);

        for(int i=1; i<matrix.length; i++) {
            int[] row = matrix[i];

            if(row[0] >= pq.peek()) {
                pq.poll();
            }

            pq.offer(row[1]);
        }

        return pq.size();
    }
}
