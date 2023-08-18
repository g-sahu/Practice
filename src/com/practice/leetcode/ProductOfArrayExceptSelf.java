package com.practice.leetcode;

import java.util.Arrays;

/*
238. Product of Array Except Self
 */
public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelf product = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(product.productExceptSelf(nums)));
    }

    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] ans = new int[l];
        int prod = 1;

        for (int i = 0; i < l; i++) {
            prod *= i == 0 ? 1 : nums[i-1];
            ans[i] = prod;
        }

        prod = 1;
        for (int i = l-1; i >= 0; i--) {
            prod *= i == l-1 ? 1 : nums[i+1];
            ans[i] *= prod;
        }

        return ans;
    }
}
