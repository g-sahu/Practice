package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 */
public class PascalsTriangleII {

    //Recursive
    public List<Integer> getRow1(int i) {
        if(i == 0) {
            return Collections.singletonList(1);
        }

        List<Integer> plist = getRow(i-1);
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for(int j=1; j<plist.size(); j++) {
            list.add(plist.get(j-1) + plist.get(j));
        }

        list.add(1);
        return list;
    }

    //Iterative
    public List<Integer> getRow2(int n) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(1));

        for(int i=1; i<=n; i++) {
            List<Integer> clist = new ArrayList<>();
            clist.add(1);

            for(int j=1; j<=i-1; j++) {
                List<Integer> plist = triangle.get(i-1);
                int sum = plist.get(j-1) + plist.get(j);
                clist.add(sum);
            }

            clist.add(1);
            triangle.add(clist);
        }

        return triangle.get(n);
    }
}
