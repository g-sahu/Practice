package com.practice.leetcode;

import java.math.BigInteger;

/*
1822. Sign of the Product of an Array
 */
public class SignFunction {

    //Using BigInteger
    public int arraySign(int[] nums) {
        BigInteger prod = BigInteger.ONE;

        for (int num : nums) {
            BigInteger n = BigInteger.valueOf(num);

            if (n.equals(BigInteger.ZERO)) {
                return 0;
            }

            prod = prod.multiply(n);
        }

        return prod.compareTo(BigInteger.ZERO);
    }
}
