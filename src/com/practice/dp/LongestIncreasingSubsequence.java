package com.practice.dp;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
	private static int[] lis;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int k = sc.nextInt();
		sc.close();

		//System.out.println("Size of LIS: " + calculateLIS(arr));
		System.out.println("No. of IS of length " + k + ": " + countIncreasingSubsequences(arr, k));
		//System.out.println("Size of LIS: " + printLIS(arr, n));
	}
	
	static int calculateLIS(int[] arr) {
		int n = arr.length;
		lis = new int[n];
		int i, j, max = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++) {
			lis[i] = 1;
		}

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < (lis[j] + 1)) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		/* Pick maximum of all LIS values */
		for (i = 0; i < n; i++) {
			if (max < lis[i]) {
				max = lis[i];
			}
		}

		return max;
	}
	
	static int countIncreasingSubsequences(int[] arr, int k) {
		int n = arr.length;
		lis = new int[n];
		int i, j, c = 0;

		/* Initialize LIS values for all indexes */
		for (i = 0; i < n; i++) {
			lis[i] = 1;
		}

		/* Compute optimized LIS values in bottom up manner */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					if (lis[i] < (lis[j] + 1)) {
						lis[i] = lis[j] + 1;
					}

					c++;
				}
			}
		}

		return c;
	}
	
	// Binary search
    static int getCeilIndex(int[] arr, int[] T, int l, int r, int key) {
    	int m = 0;
    	
        while(r - l > 1) {
            m = l + (r - l) / 2;
            
            if(arr[T[m]] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
 
        return r;
    }
    
    static int printLIS(int[] arr, int n) {
		// Add boundary case, when array n is zero
		// Depend on smart pointers
		int[] tailIndices = new int[n];

		// Initialized with 0
		Arrays.fill(tailIndices, 0);
		int[] prevIndices = new int[n];

		// initialized with -1
		Arrays.fill(prevIndices, -1);

		// it will always point to empty location
		int len = 1;

		for (int i = 1; i < n; i++) {
			if (arr[i] < arr[tailIndices[0]]) {
				// new smallest value
				tailIndices[0] = i;
			} else if (arr[i] > arr[tailIndices[len - 1]]) {
				// arr[i] wants to extend largest subsequence
				prevIndices[i] = tailIndices[len - 1];
				tailIndices[len++] = i;
			} else {
				// arr[i] wants to be a potential candidate of future subsequence
				// It will replace ceil value in tailIndices
				int pos = getCeilIndex(arr, tailIndices, -1, len - 1, arr[i]);

				prevIndices[i] = tailIndices[pos - 1];
				tailIndices[pos] = i;
			}
		}

		System.out.print("LIS: ");

		for (int i = tailIndices[len - 1]; i >= 0; i = prevIndices[i]) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();
		return len;
	}
}
