package com.practice.leetcode;

/*
1732. Find the Highest Altitude
 */
public class FindHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5,1,5,0,-7};
        FindHighestAltitude fha = new FindHighestAltitude();
        System.out.println(fha.largestAltitude2(gain));
    }

    public int largestAltitude1(int[] gain) {
        int[] alt = new int[gain.length+1];
        int max = alt[0];

        for (int i = 0; i < gain.length; i++) {
            alt[i+1] = alt[i] + gain[i];
            max = Math.max(max, alt[i+1]);
        }

        return max;
    }

    public int largestAltitude2(int[] gain) {
        int max = 0;
        int prev = 0;

        for (int j : gain) {
            int current = prev + j;
            max = Math.max(max, current);
            prev = current;
        }

        return max;
    }
}
