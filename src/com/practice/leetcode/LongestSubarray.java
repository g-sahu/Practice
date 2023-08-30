package com.practice.leetcode;

/*
1493. Longest Subarray of 1's After Deleting One Element
 */
public class LongestSubarray {

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        LongestSubarray o = new LongestSubarray();
        System.out.println(o.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {
        int max = 0;
        int z = 0;
        int j = 0;
        int l = nums.length;

        while (j < l) {
            if (nums[j] == 1) {
                max++;
            } else if (z == 0){
                z++;
                max++;
            } else {
                break;
            }
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
