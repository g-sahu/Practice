package com.practice.leetcode;

/*
121. Best Time to Buy and Sell Stock
 */
public class BuyAndSellStock {

    public int maxProfit(int[] nums) {
        int max = 0;
        int pmax = 0;

        for(int i=nums.length-1; i>0; i--) {
            max = Math.max(max, nums[i]);
            int p = max - nums[i-1];
            pmax = Math.max(pmax, p);
        }

        return pmax;
    }
}
