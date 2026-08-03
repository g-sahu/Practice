package com.practice.leetcode;

import java.util.List;
import java.util.Stack;

/**
 * 636. Exclusive Time of Functions
 */
public class ExclusiveTimeOfFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[n];
        int prevStart = 0;

        for(String l: logs) {
            String[] log = l.split(":");
            int id = Integer.parseInt(log[0]);
            String op = log[1];
            int t = Integer.parseInt(log[2]);

            if(op.equals("start")) {
                if(!stack.empty()) {
                    ans[stack.peek()] += t - prevStart;
                }

                stack.push(id);
                prevStart = t;
            } else {
                ans[stack.pop()] += t - prevStart + 1;
                prevStart = t + 1;
            }
        }

        return ans;
    }
}
