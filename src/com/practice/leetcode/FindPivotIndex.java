package com.practice.leetcode;

/*
724. Find Pivot Index
 */
public class FindPivotIndex {

    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        FindPivotIndex o = new FindPivotIndex();
        System.out.println(o.pivotIndex(nums));
    }

    public int pivotIndex(int[] nums) {
        int lsum = 0;
        int rsum = 0;
        int l = nums.length;

        for (int i = 1; i < l; i++) {
            rsum += nums[i];
        }

        for (int i = 0; i < l; i++) {
            if (lsum == rsum) {
                return i;
            } else {
                lsum += nums[i];
                rsum = i == l-1 ? 0 : rsum - nums[i+1];
            }
        }

        return -1;
    }
}
