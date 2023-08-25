package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
1323. Maximum 69 Number
 */
public class Maximum69Number {

    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();

        while (num != 0) {
            list.add(0, num%10);
            num /= 10;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 6) {
                list.set(i, 9);
                break;
            }
        }

        int n = 0;

        for (int x: list) {
            n = n*10 + x;
        }

        return n;
    }
}
