package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
1337. The K Weakest Rows in a Matrix
 */
public class KWeakestRows {

    public static void main(String[] args) {
        KWeakestRows kwr = new KWeakestRows();
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        int[] rows = kwr.kWeakestRows(grid, 3);
        System.out.println(Arrays.toString(rows));
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<MyRow> pq = new PriorityQueue<>();

        for (int i = 0; i < mat.length; i++) {
            int sum = findSum(mat[i]);
            pq.offer(new MyRow(sum, i));
        }

        int[] indices = new int[k];

        for (int i = 0; i < k; i++) {
            indices[i] = pq.poll().getIndex();
        }

        return indices;
    }

    private int findSum(int[] arr) {
        int c = 0;
        for (int n: arr) {
            if (n == 1) {
                c++;
            } else {
                break;
            }
        }

        return c;
    }
}

class MyRow implements Comparable<MyRow> {
    int sum;
    int index;

    public MyRow(int sum, int index) {
        this.sum = sum;
        this.index = index;
    }

    public int getSum() {
        return sum;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public int compareTo(MyRow myRow) {
        return Comparator.comparingInt(MyRow :: getSum)
                         .thenComparing(MyRow :: getIndex)
                         .compare(this, myRow);
    }
}
