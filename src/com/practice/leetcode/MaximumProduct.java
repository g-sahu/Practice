package com.practice.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
1464. Maximum Product of Two Elements in an Array
 */
public class MaximumProduct {
    public static void main(String[] args) {
        MaximumProduct mp = new MaximumProduct();
        int[] nums = {3,4,5,2};
        System.out.println(mp.maxProduct2(nums));
    }

    //Using Arrays.sort()
    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        int l = nums.length;
        return (nums[l-1] - 1) * (nums[l-2] - 1);
    }

    //Using PriorityQueue
    public int maxProduct2(int[] nums) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());

        for (Integer n: nums) {
            priorityQueue.offer(n);
        }

        return (priorityQueue.poll() - 1) * (priorityQueue.poll() - 1);
    }
}
