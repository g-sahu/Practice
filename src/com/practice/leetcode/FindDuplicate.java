package com.practice.leetcode;

/*
287. Find the Duplicate Number
 */
public class FindDuplicate {

    public static void main(String[] args) {
        FindDuplicate fd = new FindDuplicate();
        int[] nums = {1,3,4,2,2};
        System.out.println(fd.findDuplicate(nums));
    }

    //Brute Force
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }

        return -1;
    }
}
