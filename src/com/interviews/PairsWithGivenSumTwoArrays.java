package com.interviews;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Given two unsorted arrays A of size N and B of size M of distinct elements,
 * find all pairs from both arrays whose sum is equal to X.
 *
 * Input:
 * The first line of input contains an integer T denoting the no of test cases.
 * Then T test cases follow.
 * Each test case contains 3 lines .
 * The first line contains 3 space separated integers N, M, X.
 * Then in the next two lines are space separated values of the array A and B respectively.
 *
 * Output:
 * For each test case in a new line print the sorted space separated values of all the pairs u,v
 * where u belongs to array A and v belongs to array B,
 * such that each pair is separated from the other by a ',' without quotes also add a space after the ',' .
 * If no such pair exist print -1.
 */

public class PairsWithGivenSumTwoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n, m, x;
        int a[], b[];

        for (int i=0; i<t; i++) {
            n = sc.nextInt();
            m = sc.nextInt();
            x = sc.nextInt();

            a = new int[n];
            b = new int[m];

            for (int j=0; j<n ; j++) {
                a[j] = sc.nextInt();
            }

            for (int j=0; j<m ; j++) {
                b[j] = sc.nextInt();
            }

            findPairsWithGivenSum(a, b, x);
        }
    }

    /**
     * 1 2 4 5 7
     * 5 6 3 4 8
     */
    private static void findPairsWithGivenSum(int a[], int b[], int x) {
        Map<Integer, Integer> pairs = new TreeMap<>();
        int c = 1;

        for(int i: a) {
            for(int j: b) {
                if(i + j == x) {
                    pairs.put(i, j);
                }
            }
        }

        if(pairs.isEmpty()) {
            System.out.println(-1);
        } else {
            for (Map.Entry<Integer, Integer> entry : pairs.entrySet()) {
                System.out.print(entry.getKey() + " " + entry.getValue());

                if(c++ != pairs.size()) {
                    System.out.print(", ");
                }
            }
        }

        System.out.println();
    }
}
