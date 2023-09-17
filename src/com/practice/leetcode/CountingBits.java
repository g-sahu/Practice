package com.practice.leetcode;

/*
338. Counting Bits
 */
public class CountingBits {

    //Brute-force
    public int[] countBits(int n) {
        int[] ans = new int[n+1];

        for(int i=0; i<=n; i++) {
            ans[i] = getBits(i);
        }

        return ans;
    }

    private static int getBits(int i) {
        int c = 0;

        while(i != 0) {
            if(i % 2 == 1) {
                c++;
            }
            i = i/2;
        }
        return c;
    }
}
