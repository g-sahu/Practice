package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1700. Number of Students Unable to Eat Lunch
 */
public class NumOfStudentsUnableToEatLunch {

    public int countStudents(int[] students, int[] sw) {
        Queue<Integer> q = new ArrayDeque<>();

        for (int student : students) {
            q.add(student);
        }

        int i = 0;
        int j = 0;

        while(!q.isEmpty() && i<sw.length && j < q.size()) {
            int s = q.remove();

            if(sw[i] == s) {
                i++;
                j = 0;
            } else {
                q.add(s);
                j++;
            }
        }

        return q.size();
    }
}
