package com.practice.leetcode;

/*
LeetCode #326. Power of Three
 */
public class PowerOfThree {
    public static void main(String[] args) {
        PowerOfThree pot = new PowerOfThree();
        System.out.println(pot.isPowerOfThree(20));
    }

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 3 == 0) {
            return isPowerOfThree(n/3);
        }

        return false;
    }
}
