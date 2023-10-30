package com.interviews.tesco;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.

In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:

In Bakery department: From 8 to 10
In Checkout department: From 10 to 12
In Diary department: From 14 to 19

Given the above split of shifts, provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts.
This will be exposed to the colleague in different UI and help them plan their day accordingly.

His shift timings in this case are 8 to 12 and 14 to 19.
 */

public class Solution {

    public static void main(String[] args) {
        int[][] shifts = {
                {8, 12}
        };

        List<Shift> list = Arrays.stream(shifts)
                                    .map(s -> new Shift(s[0], s[1]))
                                    .collect(Collectors.toList());

        Solution solution = new Solution();
        Set<Shift> mergedShifts = solution.getShifts(list);
        System.out.println(mergedShifts);
    }

    public Set<Shift> getShifts(List<Shift> shifts) {
        if (shifts == null || shifts.isEmpty()) {
            return Collections.emptySet();
        }

        Comparator<Shift> shiftComparator = Comparator.comparingInt(Shift :: getStartTime);
        shifts.sort(shiftComparator);
        Shift initialShift = shifts.get(0);
        int start = initialShift.getStartTime();
        int end = initialShift.getEndTime();
        Set<Shift> mergedShifts = new HashSet<>();

        for (int i = 1; i < shifts.size(); i++) {
            Shift shift = shifts.get(i);

            if (shift.getStartTime() <= end) {
                end = Math.max(end, shift.getEndTime());
            } else {
                mergedShifts.add(new Shift(start, end));
                start = shift.getStartTime();
                end = shift.getEndTime();
            }
        }

        mergedShifts.add(new Shift(start, end));
        return mergedShifts;
    }

}

class Shift {
    private int startTime;
    private int endTime;

    Shift(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "[" + startTime + ", " + endTime + "]";
    }
}
