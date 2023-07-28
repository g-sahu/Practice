package com.practice.leetcode;

/*
7. Reverse Integer
 */
public class ReverseInteger {
    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-1));
    }

    public int reverse(int x) {
        StringBuilder sb = new StringBuilder();

        if (x == Integer.MIN_VALUE) {
            return 0;
        }

        if (x > -10 && x < 10) {
            return x;
        }

        if (x <= -10) {
            sb.append("-");
            x = -x;
        }

        int q = x;
        int rem;

        while (q != 0) {
            rem = q % 10;
            q = q/10;
            sb.append(rem);
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
