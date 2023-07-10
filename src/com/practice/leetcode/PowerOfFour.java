package com.practice.leetcode;

/*
LeetCode #342. Power of Four
 */
public class PowerOfFour {
    public static void main(String[] args) {
        PowerOfFour pot = new PowerOfFour();
        System.out.println(pot.isPowerOfFour(24));
    }

    public boolean isPowerOfFour(int n) {
        if (n < 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 4 == 0) {
            return isPowerOfFour(n/4);
        }

        return false;
    }
}
