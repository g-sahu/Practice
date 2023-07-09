package com.practice.leetcode;

/*
    2614. Prime In Diagonal
    You are given a 0-indexed two-dimensional integer array nums.
    Return the largest prime number that lies on at least one of the diagonals of nums. In case, no prime is present on any of the diagonals, return 0.

    Note that:
    An integer is prime if it is greater than 1 and has no positive integer divisors other than 1 and itself.
    An integer val is on one of the diagonals of nums if there exists an integer i for which nums[i][i] = val
    or an i for which nums[i][nums.length - i - 1] = val.

    Example 1:
    Input: nums = [[1,2,3],[5,6,7],[9,10,11]]
    Output: 11
    Explanation: The numbers 1, 3, 6, 9, and 11 are the only numbers present on at least one of the diagonals. Since 11 is the largest prime, we return 11.

    Example 2:
    Input: nums = [[1,2,3],[5,17,7],[9,11,10]]
    Output: 17
    Explanation: The numbers 1, 3, 9, 10, and 17 are all present on at least one of the diagonals. 17 is the largest prime, so we return 17.

    Constraints:
    1 <= nums.length <= 300
    nums.length == nums[i].length
    1 <= nums[i][j] <= 4*106
 */
public class PrimeInDiagonal {
    public static void main(String[] args) {
        PrimeInDiagonal pid = new PrimeInDiagonal();
        int[][] grid = {
                {1,2,3},
                {5,6,7},
                {9,10,11}
        };

        System.out.println(pid.diagonalPrime(grid));
    }

    public int diagonalPrime(int[][] nums) {
        int i = 0;
        int j = nums[0].length - 1;
        int lp = 0;

        while (i < nums.length) {
            int n1 = nums[i][i];

            if (n1 > lp && isPrime(n1)) {
                lp = n1;
            }

            int n2 = nums[i][j];

            if (n2 > lp && isPrime(n2)) {
                lp = n2;
            }

            i++;
            j--;
        }

        return lp;
    }

    private boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }

        if (n == 2 || n == 3) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
