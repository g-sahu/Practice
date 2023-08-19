package com.practice.leetcode;

/*
8013. Number of Beautiful Integers in the Range
 */
public class BeautifulIntegers {
    public static void main(String[] args) {
        int low = 10;
        int high = 20;
        int k = 3;
        BeautifulIntegers bi = new BeautifulIntegers();
        System.out.println(bi.numberOfBeautifulIntegers(low, high, k));
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int c = 0;

        for (int i = low; i <= high; i++) {
            if (i % k == 0 && isEqual(i)) {
                c++;
            }
        }

        return c;
    }

    private static boolean isEqual(int num) {
        int e = 0;
        int o = 0;

        while (num != 0) {
            int r = num % 10;
            num = num / 10;

            if (r % 2 == 0) {
                e++;
            } else {
                o++;
            }
        }

        return e == o;
    }
}
