package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
1323. Maximum 69 Number
 */
public class Maximum69Number {

    //Using list
    public int maximum69Number1(int num) {
        List<Integer> list = new ArrayList<>();

        while (num != 0) {
            list.add(0, num % 10);
            num /= 10;
        }

        int n = 0;
        boolean flag = false;

        for (int x : list) {
            if (!flag && x == 6) {
                x = 9;
                flag = true;
            }
            n = n * 10 + x;
        }

        return n;
    }

    //Using String.replaceFirst()
    public int maximum69Number2(int num) {
        String s = Integer.toString(num);
        String n = s.replaceFirst("6", "9");
        return Integer.parseInt(n);
    }

    //Using char array
    public int maximum69Number3(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        int n = 0;
        boolean flag = false;

        for (char digit : digits) {
            if (!flag && digit == '6') {
                digit = '9';
                flag = true;
            }

            n = (n * 10) + (digit - '0');
        }
        return n;
    }
}
