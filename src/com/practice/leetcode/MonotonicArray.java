package com.practice.leetcode;

/*
896. Monotonic Array
 */
public class MonotonicArray {

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        MonotonicArray o = new MonotonicArray();
        System.out.println(o.isMonotonic(nums));
    }

    public boolean isMonotonic(int[] nums) {
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
}
