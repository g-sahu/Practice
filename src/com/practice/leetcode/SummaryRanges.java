package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 */
public class SummaryRanges {

    //Using StringBuilder
    public List<String> summaryRanges1(int[] nums) {
        List<String> list = new ArrayList<>();
        int l = nums.length;

        if(l == 0) {
            return list;
        }

        int start = nums[0];
        int end = nums[0];
        StringBuilder sb = new StringBuilder(String.valueOf(start));

        for(int i=1; i<l; i++) {
            if(nums[i] != end+1) {
                if(start != end) {
                    sb.append("->").append(end);
                }
                list.add(sb.toString());
                start = nums[i];
                sb = new StringBuilder(String.valueOf(start));
            }
            end = nums[i];
        }

        if(start != end) {
            sb.append("->").append(end);
        }

        list.add(sb.toString());
        return list;
    }

    //Without StringBuilder
    public List<String> summaryRanges2(int[] nums) {
        List<String> list = new ArrayList<>();
        int l = nums.length;

        if(l == 0) {
            return list;
        }

        int start = nums[0];
        int end = nums[0];

        for(int i=1; i<l; i++) {
            if(nums[i] != end+1) {
                String range = start == end ? String.valueOf(start) : start + "->" + end;
                list.add(range);
                start = nums[i];
            }
            end = nums[i];
        }

        String range = start == end ? String.valueOf(start) : start + "->" + end;
        list.add(range);
        return list;
    }
}
