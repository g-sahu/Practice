package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 */
public class NumsDisappearedInArray {

    // Using Extra Space
    public List<Integer> findDisappearedNumbers(int[] nums) {
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
}
