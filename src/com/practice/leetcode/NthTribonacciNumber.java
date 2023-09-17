package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
1137. N-th Tribonacci Number
 */
public class NthTribonacciNumber {
    private final Map<Integer, Integer> map = new HashMap<>();

    //DP: Top-down
    public int tribonacci1(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n == 2) {
            return 1;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }

        int t = tribonacci1(n-1) + tribonacci1(n-2) + tribonacci1(n-3);
        map.put(n, t);
        return t;
    }

    //DP: Bottom-up
    public int tribonacci2(int n) {
        if (n < 3) {
            return n == 0 ? 0 : 1;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
}
