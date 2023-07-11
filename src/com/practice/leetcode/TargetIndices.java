package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
2089. Find Target Indices After Sorting Array
 */
public class TargetIndices {
    public static void main(String[] args) {
        TargetIndices ti = new TargetIndices();
        int[] nums = {1,2,5,2,3};
        int target = 2;
        System.out.println(ti.targetIndices(nums, target));
    }

    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            boolean cond1 = nums[i] == target;
            boolean cond2 = nums[j] == target;

            if (!cond1) {
                i++;
            }

            if (!cond2) {
                j--;
            }

            if (cond1 && cond2) {
                break;
            }
        }

        int c = j - i + 1;

        if (c <= 0) {
            return Collections.emptyList();
        }

        List<Integer> list = new ArrayList<>(c);

        while (i <= j) {
            list.add(i);
            i++;
        }

        return list;
    }
}
