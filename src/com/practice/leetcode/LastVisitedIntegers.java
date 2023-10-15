package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2899. Last Visited Integers
 */
public class LastVisitedIntegers {

    public static void main(String[] args) {
        LastVisitedIntegers o = new LastVisitedIntegers();
        List<String> words = Arrays.asList("prev","100","prev");
        System.out.println(o.lastVisitedIntegers(words));
    }

    public List<Integer> lastVisitedIntegers(List<String> words) {
        List<Integer> list = new ArrayList<>();
        int k = 0;
        int l = 0;
        List<Integer> ans = new ArrayList<>();

        for (String s : words) {
            if (s.equals("prev")) {
                k++;
                l = list.size();
                int i = k > l ? -1 : list.get(k-1);
                ans.add(i);
            } else {
                list.add(0, Integer.parseInt(s));
                k = 0;
                l++;
            }
        }

        return ans;
    }
}
