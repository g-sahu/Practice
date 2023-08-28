package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
118. Pascal's Triangle
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        PascalsTriangle pt = new PascalsTriangle();
        List<List<Integer>> triangle = pt.generate(5);
        LeetUtils.printNestedLists(triangle);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> first = Collections.singletonList(1);
        triangle.add(first);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);

            for (int j = 0; j <= i; j++) {
                List<Integer> plist = triangle.get(i - 1);
                int l = j == 0 ? 0 : plist.get(j - 1);
                int r = j == i ? 0 : plist.get(j);
                list.add(l + r);
            }

            triangle.add(list);
        }

        return triangle;
    }
}
