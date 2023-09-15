package com.practice.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
70. Climbing Stairs
 */
public class ClimbingStairs {

    //DP: Top-Down
    public int climbStairs1(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        return dp(n, map);
    }

    private int dp(int n, Map<Integer, Integer> map) {
        if(map.containsKey(n)) {
            return map.get(n);
        }

        int ways = dp(n-1, map) + dp(n-2, map);
        map.put(n, ways);
        return ways;
    }

    //DP: Bottom-Up
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
