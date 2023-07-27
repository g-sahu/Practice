package com.practice.leetcode;

/*
69. Sqrt(x)
 */
public class SquareRoot {
    public static void main(String[] args) {
        SquareRoot sr = new SquareRoot();
        System.out.println(sr.mySqrt2(2147483647));
    }

    //Using Brute Force
    public int mySqrt1(int x) {
        for (int i = 0; i <= x; i++) {
            long square = (long) i * i;

            if (square == x) {
                return i;
            } else if (square > x) {
                return i-1;
            }
        }

        return -1;
    }

    //Using Binary Search
    public int mySqrt2(int x) {
        int beg = 0;
        int end = x;
        int sqrt = -1;

        while (beg <= end) {
            int mid = (beg + end)/2;
            long sq = (long) mid * mid;

            if (sq == x) {
                sqrt = mid;
                break;
            } else if (sq > x) {
                end = mid - 1;
            } else {
                sqrt = Math.max(sqrt, mid);
                beg = mid + 1;
            }
        }

        return sqrt;
    }
}
