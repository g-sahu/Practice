package com.practice.leetcode;

/*
11. Container With Most Water
 */
public class LargestContainer {

    public static void main(String[] args) {
        LargestContainer lc = new LargestContainer();
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(lc.maxArea(height));

    }

    //Using Brute Force
    public int maxArea(int[] height) {
        int maxArea = 0;

        for (int i = 0; i < height.length; i++) {
            int currentArea = maxArea(height, i);
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
    }

    private int maxArea(int[] height, int i) {
        int max = 0;

        for (int j = 0; j < height.length; j++) {
            if (i != j && height[j] >= height[i]) {
                max = Math.max(max, Math.abs(j-i));
            }
        }

        return max * height[i];
    }
}
