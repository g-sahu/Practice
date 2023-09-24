package com.practice.leetcode;

/*
287. Find the Duplicate Number
 */
public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length-1;
        int ans = -1;

        while(start <= end) {
            int mid = start + ((end - start)/2);
            int c = numsLTE(nums, mid);

            if(c > mid) {
                end = mid-1;
                ans = mid;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }

    //Find nums <= k
    private static int numsLTE(int[] nums, int k) {
        int c = 0;
        for(int n: nums) {
            if(n <= k) {
                c++;
            }
        }
        return c;
    }
}
