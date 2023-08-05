package com.practice.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
202. Happy Number
 */
public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber hn = new HappyNumber();
        System.out.println(hn.isHappy(7));
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int n1 = getSum(n);
        set.add(n1);

        while (n1 != 1) {
            n1 = getSum(n1);

            if (set.contains(n1)) {
                return false;
            } else {
                set.add(n1);
            }
        }

        return true;
    }

    private static int getSum(int n) {
        int sum = 0;

        while (n != 0) {
            int r = n % 10;
            sum += r * r;
            n = n / 10;
        }

        return sum;
    }
}
