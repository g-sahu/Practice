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

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 6) {
                list.set(i, 9);
                break;
            }
        }

        int n = 0;
        for (int x : list) {
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

    //Using char array 9669
    public int maximum69Number3(int num) {
        char[] digits = Integer.toString(num).toCharArray();

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break;
            }
        }

        int n = 0;
        for (char x : digits) {
            n = (n * 10) + (x - '0');
        }

        return n;
    }
}
