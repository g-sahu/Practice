package com.practice.leetcode;

import java.math.BigInteger;

/*
1822. Sign of the Product of an Array
 */
public class SignFunction {

    //Using BigInteger
    public int arraySign1(int[] nums) {
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

    //Counting negatives
    public int arraySign2(int[] nums) {
        int n = 0;

        for (int num: nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0){
                n++;
            }
        }

        return n % 2 == 0 ? 1 : -1;
    }

    //Change the sign on encountering a -ve
    public int arraySign3(int[] nums) {
        int sign = 1;

        for (int num: nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0){
                sign *= -1;
            }
        }

        return sign;
    }
}
