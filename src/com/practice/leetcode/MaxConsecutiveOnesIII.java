package com.practice.leetcode;

/*
1004. Max Consecutive Ones III
 */
public class MaxConsecutiveOnesIII {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,0,0};
        MaxConsecutiveOnesIII o = new MaxConsecutiveOnesIII();
        System.out.println(o.longestOnes(nums, 0));
    }

    public int longestOnes(int[] nums, int k) {
        int l = nums.length;
        int j = 0;
        int z = 0;
        int max = 0;

        while (j < l && z < k) {
            if (nums[j++] == 0) {
                z++;
            }
            max++;
        }

        j--;
        int i = 0;

        while (j < l-1) {
            if (nums[++j] == 0) {
                z++;
            }

            while (z > k) {
                int prev = nums[i++];
                if (prev == 0) {
                    z--;
                }
            }

            max = Math.max(max, j-i+1);
        }

        return max;
    }
}
