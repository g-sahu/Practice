package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
78. Subsets
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Subsets o = new Subsets();
        List<List<Integer>> subsets = o.subsets(nums);
        LeetUtils.printNestedLists(subsets);
    }

    public List<List<Integer>> subsets(int[] nums) {
        int limit = (int) Math.pow(2, nums.length);
        List<List<Integer>> subsets = new ArrayList<>(limit);

        for (int i = 0; i < limit; i++) {
            int temp = i;
            List<Integer> subset = new ArrayList<>();

            for (int num : nums) {
                int r = temp % 2;
                temp = temp / 2;

                if (r != 0) {
                    subset.add(num);
                }
            }

            subsets.add(subset);
        }

        return subsets;
    }
}
