package com.interviews;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Given an array A of size N,
 * find all pairs from the array whose sum is equal to X.
 */

public class PairsWithGivenSumSingleArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, x;
        int[] a;

        for (int i=0; i<t; i++) {
            n = sc.nextInt();
            x = sc.nextInt();
            a = new int[n];

            for (int j=0; j<n ; j++) {
                a[j] = sc.nextInt();
            }

            //findPairWithGivenSumSorted(a, x);
            findPairWithGivenSumUnSorted(a, x);
        }
    }

    /**
     * Find a pair in a sorted array of integers
     * -1 2 4 5 7, x = 9
     */
    private static void findPairWithGivenSumSorted(int[] a, int x) {
        int low = 0;
        int high = a.length - 1;
        int sum;

        while(low < high) {
            sum = a[low] + a[high];

            if(sum == x) {
                System.out.println(a[low] + ", " + a[high]);
                return;
            } else if(sum < x) {
                low++;
            } else {
                high--;
            }
        }

        System.out.println("No pair found!");
    }

    /**
     * Find a pair in an unsorted array with of integers
     * -1 2 -4 5 7, x = 9
     */
    private static void findPairWithGivenSumUnSorted(int[] a, int x) {
        Set<Integer> complements = new HashSet<>();

        for(int i: a) {
            if(complements.contains(i)) {
                System.out.println((x-i) + ", " + i);
                return;
            } else {
                complements.add(x-i);
            }
        }

        System.out.println("No pair found!");
    }
}
