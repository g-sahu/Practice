package com.practice.leetcode;

/**
 * 2485. Find the Pivot Integer
 */
public class FindThePivotInteger {

    public int pivotInteger(int n) {
        int sum = 0;

        for(int i=1; i<=n; i++) {
            sum += i;
        }

        int lsum = 0;

        for(int i=1; i<=n; i++) {
            lsum = lsum + i;

            if(sum == lsum) {
                return i;
            }

            sum = sum - i;
        }

        return -1;
    }

}
