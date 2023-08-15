package com.practice.leetcode;

import java.util.Arrays;

/*
1051. Height Checker
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] arr = Arrays.copyOf(heights, heights.length);
        Arrays.sort(arr);
        int c = 0;

        for(int i=0; i<heights.length; i++) {
            if(arr[i] != heights[i]) {
                c++;
            }
        }

        return c;
    }
}
