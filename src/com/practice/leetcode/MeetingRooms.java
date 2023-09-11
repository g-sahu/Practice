package com.practice.leetcode;

import java.util.Arrays;

/*
252. Meeting Rooms
 */
public class MeetingRooms {

    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int end = -1;

        for (int[] row : intervals) {
            if (row[0] < end) {
                return false;
            }
            end = row[1];
        }

        return true;
    }
}
