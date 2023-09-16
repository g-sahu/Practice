package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
119. Pascal's Triangle II
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int i) {
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
}
