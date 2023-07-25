package com.practice.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
215. Kth Largest Element in an Array
 */
public class KthLargestElement {
    public static void main(String[] args) {
        KthLargestElement kle = new KthLargestElement();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(kle.findKthLargest2(nums, 2));
    }

    //Using Sorting
    public int findKthLargest1(int[] nums, int k) {
        Arrays.sort(nums);
        int l = nums.length;
        return nums[l-k];
    }

    //Using Priority Queue(min heap)
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);

        for (int num : nums) {
            if (pq.size() == k) {
                if (num > pq.peek()) {
                    pq.poll();
                    pq.offer(num);
                }
            } else {
                pq.offer(num);
            }
        }

        return pq.peek();
    }
}
