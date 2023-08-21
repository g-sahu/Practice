package com.practice.codesignal;

import java.util.Arrays;

/*
Given an array of integers a, your task is to count the number of pairs i and j (where 0 ≤ i < j < a.length), such that a[i] and a[j] are digit anagrams.
Two integers are considered to be digit anagrams if they contain the same digits.
In other words, one can be obtained from the other by rearranging the digits (or trivially, if the numbers are equal).
For example, 54275 and 45572 are digit anagrams, but 321 and 782 are not (since they don't contain the same digits).
220 and 22 are also not considered as digit anagrams, since they don't even have the same number of digits.

Example
For a = [25, 35, 872, 228, 53, 278, 872], the output should be solution(a) = 4.

There are 4 pairs of digit anagrams:
a[1] = 35 and a[4] = 53 (i = 1 and j = 4),
a[2] = 872 and a[5] = 278 (i = 2 and j = 5),
a[2] = 872 and a[6] = 872 (i = 2 and j = 6),
a[5] = 278 and a[6] = 872 (i = 5 and j = 6).

Input/Output
> [execution time limit] 3 seconds (java)
> [memory limit] 1 GB
> [input] array.integer a
    An array of non-negative integers.
    Guaranteed constraints:
    1 ≤ a.length ≤ 105,
    0 ≤ a[i] ≤ 109.

> [output] integer64
    The number of pairs i and j, such that a[i] and a[j] are digit anagrams.
 */
public class DigitAnagrams {

    public static void main(String[] args) {
        int[] nums = {25, 35, 872, 228, 53, 278, 872};
        DigitAnagrams o = new DigitAnagrams();
        System.out.println(o.solution(nums));
    }

    long solution(int[] a) {
        String[] s = new String[a.length];

        for (int i = 0; i < a.length; i++) {
            s[i] = sortDigits(a[i]);
        }

        Arrays.sort(s);
        long c = 0;
        int i = 0;
        long n = 1;

        while (i < s.length-1) {
            if (s[i].equals(s[i+1])) {
                n++;
            } else {
                if (n > 1) {
                    c += (n *(n-1))/2;
                }
                n = 1;
            }

            i++;
        }

        if (n > 1) {
            c += (n *(n-1))/2;
        }

        return c;
    }

    private String sortDigits(int num) {
        char[] chars = Integer.toString(num).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
