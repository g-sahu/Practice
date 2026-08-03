package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1475. Final Prices With a Special Discount in a Shop
 */
public class FinalPricesWithDiscount {

    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = prices.clone();

        for(int i=0; i<prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                ans[idx] = prices[idx] - prices[i];
            }

            stack.push(i);
        }

        return ans;
    }
}
