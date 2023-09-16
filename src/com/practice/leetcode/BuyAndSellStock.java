package com.practice.leetcode;

/*
121. Best Time to Buy and Sell Stock
 */
public class BuyAndSellStock {

    public int maxProfit(int[] nums) {
        int l = nums.length;

        if(l == 1) {
            return 0;
        }

        int max = nums[l-1];
        int pmax = nums[l-1] - nums[l-2];

        for(int i=l-2; i>0; i--) {
            max = Math.max(max, nums[i]);
            int p = max - nums[i-1];
            pmax = Math.max(pmax, p);
        }

        return Math.max(pmax, 0);
    }
}
