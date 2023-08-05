package com.interviews.tesco;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TescoShifts {

    public static void main(String[] args) {
        TescoShifts ts = new TescoShifts();
        List<ShiftInterval> shifts = new ArrayList<>();
        shifts.add(new ShiftInterval(LocalTime.of(8, 0), LocalTime.of(10, 0)));
        shifts.add(new ShiftInterval(LocalTime.of(10, 0), LocalTime.of(12, 0)));
        shifts.add(new ShiftInterval(LocalTime.of(14, 0), LocalTime.of(19, 0)));
        shifts.add(new ShiftInterval(LocalTime.of(7, 0), LocalTime.of(20, 0)));

        List<ShiftInterval> actualShifts = ts.merge(shifts);
        List<ShiftInterval> expectedShifts = new ArrayList<>();

        expectedShifts.add(new ShiftInterval(LocalTime.of(7, 0), LocalTime.of(20, 0)));
        assert actualShifts.equals(expectedShifts);
    }

    /*
   [
   [7, 20],
   [8, 10],
   [10, 12],
   [14, 19]
   ]
    */
    private List<ShiftInterval> merge(List<ShiftInterval> shifts) {
        Collections.sort(shifts);
        int size = shifts.size();

        if (size <= 1) {
            return shifts;
        }

        int i = 0;
        List<ShiftInterval> mergedShifts = new ArrayList<>();

        while (i < size) {
            ShiftInterval currentShift = shifts.get(i);
            LocalTime start = currentShift.getStartTime();
            LocalTime end = currentShift.getEndTime();

            if (i == size-1) {
                mergedShifts.add(new ShiftInterval(start, end));
                break;
            }

            ShiftInterval nextShift = shifts.get(i+1);

            while (i < size) {
                if (!(end.compareTo(nextShift.getStartTime()) >= 0 && end.compareTo(nextShift.getEndTime()) >= 0)) {
                    end = nextShift.getEndTime();
                }

                i++;
                nextShift = shifts.get(i + 1);
            }

            ShiftInterval mergedShift = new ShiftInterval(start, end);
            mergedShifts.add(mergedShift);
            i++;
        }

        return mergedShifts;
    }
}

class ShiftInterval implements Comparable<ShiftInterval> {
    private LocalTime startTime;
    private LocalTime endTime;

    public ShiftInterval(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    @Override
    public int compareTo(ShiftInterval shiftInterval) {
        return this.startTime.compareTo(shiftInterval.startTime);
    }
}
