package com.practice.leetcode;

/*
    209. Minimum Size Subarray Sum
    Given an array of positive integers nums and a positive integer target, return the minimal length of a
    subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

    Example 1:
    Input: target = 7, nums = [2,3,1,2,4,3]
    Output: 2
    Explanation: The subarray [4,3] has the minimal length under the problem constraint.

    Example 2:
    Input: target = 4, nums = [1,4,4]
    Output: 1

    Example 3:
    Input: target = 11, nums = [1,1,1,1,1,1,1,1]
    Output: 0

    Constraints:
    1 <= target <= 109
    1 <= nums.length <= 105
    1 <= nums[i] <= 104

    Follow up: If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log(n)).
 */
public class MinimumSubArray {
    public static void main(String[] args) {
        MinimumSubArray ms = new MinimumSubArray();
        int target = 11;
        int[] nums = {1,2,3,4,5};
        System.out.println(ms.minSubArrayLen(target, nums));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = 0;
        int sum = 0;
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum >= target) {
                k = i + 1;
                min = k;
                break;
            }
        }

        int i = 1;

        while (i < nums.length) {
            int j = 0;
            sum = 0;

            while ((i + j < nums.length) && j < k - 1){
                sum += nums[i + j];

                if (sum >= target) {
                    k = j + 1;
                    min = k;
                    break;
                }

                j++;
            }

            i++;
        }

        return min;
    }
}
