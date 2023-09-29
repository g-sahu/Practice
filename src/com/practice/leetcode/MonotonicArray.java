package com.practice.leetcode;

/**
 * 896. Monotonic Array
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        MonotonicArray o = new MonotonicArray();
        System.out.println(o.isMonotonic1(nums));
    }

    public boolean isMonotonic1(int[] nums) {
        int comp = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int c = Integer.compare(nums[i], nums[i+1]);

            if (comp == 0) {
                comp = c;
            } else {
                if (c != 0 && c != comp) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isMonotonic2(int[] nums) {
        int l = nums.length;
        boolean inc = nums[0] < nums[l-1];

        if(inc) {
            for(int i=0; i<l-1; i++) {
                if(nums[i] > nums[i+1]) {
                    return false;
                }
            }
        } else {
            for(int i=0; i<l-1; i++) {
                if(nums[i] < nums[i+1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
