package com.practice.leetcode;

/**
 * 509. Fibonacci Number
 */
public class FibonacciNumber {

    //DP: Top Down
    public int fib_dp1(int n) {
        if(n <= 1) {
            return n;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        return fibo(n, dp);
    }

    public int fibo(int n, int[] dp) {
        if(n <= 1) {
            return n;
        }
        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = fibo(n-1, dp) + fibo(n-2, dp);
        return dp[n];
    }

    //DP: Bottom-up
    public int fib_dp2(int n) {
        if(n <= 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }

    //Optimal
    public int fib(int n) {
        if(n <= 1) {
            return n;
        }
        int a=0, b=1, c=0;

        for(int i=2; i<=n; i++) {
            c = a+b;
            a = b;
            b = c;
        }

        return b;
    }
}
