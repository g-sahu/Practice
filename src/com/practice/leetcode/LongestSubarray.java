package com.practice.leetcode;

/*
1493. Longest Subarray of 1's After Deleting One Element
 */
public class LongestSubarray {

    public static void main(String[] args) {
        int[] nums = {1,1,0,1};
        LongestSubarray o = new LongestSubarray();
        System.out.println(o.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int max = 0;
        int j = 0;
        int z = 0;
        int l = nums.length;

        while (j < l) {
            if (nums[j] == 0) {
                if (z == 1) {
                    break;
                } else {
                    z++;
                }
            }
            max++;
            j++;
        }

        int i = 0;
        int c = max;

        while (j < l) {
            if (nums[j++] == 0) {
                while (nums[i++] == 1) {
                    c--;
                }
            } else {
                c++;
            }
            max = Math.max(max, c);
        }

        return max-1;
    }
}
