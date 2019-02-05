package com.practice.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();
		char[] x = s1.toCharArray();
		char[] y = s2.toCharArray();
		int m = x.length;
		int n = y.length;

		System.out.println(calculateLCS(x, y, m, n));
	}

	// Returns length of LCS for x[0..m-1], x[0..n-1]
	private static int calculateLCS(char[] x, char[] y, int m, int n) {
		int L[][] = new int[m+1][n+1];

		// Following steps build L[m+1][n+1] in bottom up fashion. 
		// Note that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1]
		for(int i=0; i<=m; i++) {
			for(int j=0; j<=n; j++) {
				if(i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (x[i-1] == y[j-1]) {
					L[i][j] = L[i-1][j-1] + 1;
				} else {
					L[i][j] = max(L[i-1][j], L[i][j-1]);
				}
			}
		}

		return L[m][n];
	}

	private static int max(int a, int b) {
		return (a > b) ? a : b;
	}
	
	void show() {
		/*Greatest gr = new Greatest();
		gr.show1();*/
		
		Greatest.show1();
	}
}