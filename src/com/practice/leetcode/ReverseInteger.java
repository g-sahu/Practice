package com.practice.leetcode;

/*
7. Reverse Integer
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-10));
    }

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();

        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        if (x < 0) {
            sb.append("-");
            x = -x;
        }

        while (x != 0) {
            sb.append(x % 10);
            x = x/10;
        }

        int i;

        try {
            i = Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }

        return i;
    }
}
