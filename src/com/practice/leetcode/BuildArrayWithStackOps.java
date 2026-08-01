package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1441. Build an Array With Stack Operations
 */
public class BuildArrayWithStackOps {

    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int i=1, j=0;

        while(i <= n && j < target.length) {
            ops.add("Push");

            if(target[j] == i) {
                j++;
            } else if(target[j] > i){
                ops.add("Pop");
            }

            i++;
        }

        return ops;
    }
}
