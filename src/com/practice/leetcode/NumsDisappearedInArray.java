package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 */
public class NumsDisappearedInArray {

    // Using Extra Space
    public List<Integer> findDisappearedNumbers_1(int[] nums) {
        int[] count = new int[100001];

        for(int n: nums) {
            ++count[n];
        }

        List<Integer> l = new ArrayList<>();

        for(int i=1; i<=nums.length; i++) {
            if(count[i] == 0) {
                l.add(i);
            }
        }

        return l;
    }

    // Without Extra Space
    public List<Integer> findDisappearedNumbers_2(int[] nums) {
        int l = nums.length;

        for(int i=0; i<l; i++) {
            int n = Math.abs(nums[i]) - 1;

            if(nums[n] > 0) {
                nums[n] = -nums[n];
            }
        }

        List<Integer> list = new ArrayList<>();

        for(int i=0; i<l; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }

        return list;
    }
}
