package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestRepeatingSubsequence {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(findLongestRepeatingSubSeq(str));
    }

	 // Function to find the longest repeating subsequence
    private static int findLongestRepeatingSubSeq(String str) {
        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        // Fill dp table (similar to LCS loops)
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                // If characters match and indexes are not same
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][n];
    }
}
