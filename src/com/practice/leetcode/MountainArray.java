package com.practice.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
852. Peak Index in a Mountain Array
 */
public class MountainArray {
    public static void main(String[] args) {
        MountainArray ma = new MountainArray();
        int[] arr = {3,4,5,1};
        System.out.println(ma.peakIndexInMountainArray3(arr));
    }

    //Using Priority Queue
    public int peakIndexInMountainArray1(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            pq.offer(arr[i]);

            if (arr[i] == pq.peek()) {
                j = i;
            }
        }

        return j;
    }

    //Using Brute Force
    public int peakIndexInMountainArray2(int[] arr) {
        int i = 0;

        while (i < arr.length && arr[i] <= arr[i + 1]) {
            i++;
        }

        return i;
    }

    //Using Binary Search
    public int peakIndexInMountainArray3(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (l + r)/2;

            if (arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]) {
                return mid;
            } else if (arr[mid] < arr[mid+1]){
                l = mid + 1;
            } else if (arr[mid] > arr[mid+1]) {
                r = mid - 1;
            }
        }

        return r;
    }
}
