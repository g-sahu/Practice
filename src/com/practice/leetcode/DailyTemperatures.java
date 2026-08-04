package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temp) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temp.length;
        int[] ans = new int[n];

        for(int i=0; i<n; i++) {
            while(!stack.isEmpty() && temp[stack.peek()] < temp[i]) {
                int idx = stack.pop();
                ans[idx] = i - idx;
            }

            stack.push(i);
        }

        return ans;
    }
}
