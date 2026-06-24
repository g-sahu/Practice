package com.practice.leetcode;

/**
 * 643. Maximum Average Subarray I
 *
 * <p>You are given an integer array {@code nums} consisting of {@code n} elements, and an integer
 * {@code k}. Find a contiguous subarray whose length is equal to {@code k} that has the maximum
 * average value and return this value.</p>
 *
 * <p>Any answer with a calculation error less than {@code 10^-5} will be accepted.</p>
 *
 * <h2>Example 1</h2>
 * <pre>
 * Input: nums = [1,12,-5,-6,50,3], k = 4
 * Output: 12.75000
 * Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75
 * </pre>
 *
 * <h2>Example 2</h2>
 * <pre>
 * Input: nums = [5], k = 1
 * Output: 5.00000
 * </pre>
 *
 * <h2>Constraints</h2>
 * <ul>
 *     <li>{@code n == nums.length}</li>
 *     <li>{@code 1 <= k <= n <= 105}</li>
 *     <li>{@code -104 <= nums[i] <= 104}</li>
 * </ul>
 */
public class MaxAvgSubarrayI {

    public static void main(String[] args) {
        MaxAvgSubarrayI m = new MaxAvgSubarrayI();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println(m.findMaxAverage(nums, k));
    }

    public double findMaxAverage(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int currentSum = 0;
        Integer maxSum = null;

        while (j < nums.length) {
            if (i > 0) {
                currentSum = currentSum - nums[i - 1];
            }

            currentSum = currentSum + nums[j];

            if ((j - i + 1) == k) {
                if (maxSum == null || currentSum > maxSum) {
                    maxSum = currentSum;
                }

                i++;
            }

            j++;
        }

        return (double) maxSum /k;
    }
}
