package com.practice.leetcode;

/*
LeetCode #231. Power of Two
 */
public class PowerofTwo {
    public static void main(String[] args) {
        PowerofTwo pot = new PowerofTwo();
        System.out.println(pot.isPowerOfTwo(6));
    }

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        if (n == 1) {
            return true;
        }

        if (n % 2 == 0) {
            return isPowerOfTwo(n/2);
        }

        return false;
    }
}
