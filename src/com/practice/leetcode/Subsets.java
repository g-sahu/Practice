package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
78. Subsets
 */
public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        Subsets o = new Subsets();
        List<List<Integer>> subsets = o.subsets2(nums);
        LeetUtils.printNestedLists(subsets);
    }

    //Using binary conversion
    public List<List<Integer>> subsets1(int[] nums) {
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

    //Backtracking
    public List<List<Integer>> subsets2(int[] nums) {
        //Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start) {
        list.add(new ArrayList<>(tempList));

        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
