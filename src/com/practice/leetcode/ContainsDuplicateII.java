package com.practice.leetcode;

/*
    219. Contains Duplicate II
    Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
    such that nums[i] == nums[j] and abs(i - j) <= k.

    Example 1:
    Input: nums = [1,2,3,1], k = 3
    Output: true

    Example 2:
    Input: nums = [1,0,1,1], k = 1
    Output: true

    Example 3:
    Input: nums = [1,2,3,1,2,3], k = 2
    Output: false

    Constraints:
    1 <= nums.length <= 105
    -109 <= nums[i] <= 109
    0 <= k <= 105
 */
public class ContainsDuplicateII {

    public static void main(String[] args) {
        ContainsDuplicateII cd = new ContainsDuplicateII();
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(cd.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int j = i + 1;

            while (j < nums.length && j - i <= k) {
                if (nums[i] == nums[j]) {
                    return true;
                }
                j++;
            }
        }

        return false;
    }
}
