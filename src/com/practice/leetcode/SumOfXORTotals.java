package com.practice.leetcode;

/*
1863. Sum of All Subset XOR Totals
 */
public class SumOfXORTotals {

    public static void main(String[] args) {
        int[] nums = {5,1,6};
        SumOfXORTotals o = new SumOfXORTotals();
        System.out.println(o.subsetXORSum(nums));
    }

    public int subsetXORSum(int[] nums) {
        int sum = 0;

        for (int i = 0; i < Math.pow(2, nums.length); i++) {
            int xor = 0;
            int temp = i;

            for (int num : nums) {
                int r = temp % 2;
                temp = temp / 2;

                if (r != 0) {
                    xor = xor ^ num;
                }
            }

            sum += xor;
        }

        return sum;
    }
}
