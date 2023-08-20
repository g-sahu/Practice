package com.practice.leetcode;

/*
8013. Number of Beautiful Integers in the Range
 */
public class BeautifulIntegers {
    public static void main(String[] args) {
        int low = 1;
        int high = 1000000000;
        int k = 1;
        BeautifulIntegers bi = new BeautifulIntegers();
        System.out.println(bi.numberOfBeautifulIntegers(low, high, k));
    }

    public int numberOfBeautifulIntegers(int low, int high, int k) {
        int i = low;
        int c = 0;

        while (i <= high) {
            if (isEqual(i) && i % k == 0) {
                c++;
            }
            i += k;
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
