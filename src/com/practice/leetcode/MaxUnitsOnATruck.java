package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
1710. Maximum Units on a Truck
 */
public class MaxUnitsOnATruck {
    public static void main(String[] args) {
        int[][] boxTypes = {
                {5,10},
                {2,5},
                {4,7},
                {3,9}
        };

        MaxUnitsOnATruck o = new MaxUnitsOnATruck();
        System.out.println(o.maximumUnits(boxTypes, 10));
    }

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, Comparator.comparing(a -> a[1]));
        int max = 0;

        for (int i = boxTypes.length-1; i >= 0; i--) {
            int[] box = boxTypes[i];
            if (box[0] <= truckSize) {
                max = max + (box[1] * box[0]);
                truckSize -= box[0];
            } else {
                max = max + (box[1] * truckSize);
                break;
            }
        }

        return max;
    }
}
