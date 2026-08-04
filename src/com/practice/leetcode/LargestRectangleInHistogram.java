package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 */
public class LargestRectangleInHistogram {

    // Brute Force
    public int largestRectangleArea_1(int[] h) {
        int l = h.length;
        int max = 0;

        for(int i=0; i<l; i++) {
            int min = h[i];

            for(int j=i; j<l; j++) {
                min = Math.min(min, h[j]);
                int a = (j-i+1) * min;
                max = Math.max(max, a);
            }
        }

        return max;
    }

    // Using Monotonic Stack
    public int largestRectangleArea_2(int[] h) {
        int l = h.length;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=0; i<=l; i++) {
            int curr = i == l ? 0 : h[i];

            while(!stack.isEmpty() && h[stack.peek()] >= curr) {
                int height = h[stack.pop()];
                int left = stack.isEmpty() ? -1 : stack.peek();
                int w = i - left - 1;
                int a = w * height;
                max = Math.max(max, a);
            }

            stack.push(i);
        }

        return max;
    }
}
