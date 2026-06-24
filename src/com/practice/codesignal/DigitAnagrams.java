package com.practice.codesignal;

import java.util.Arrays;

/**
 * Given an array of integers {@code a}, your task is to count the number of pairs {@code i} and
 * {@code j}, where {@code 0 <= i < j < a.length}, such that {@code a[i]} and {@code a[j]} are digit
 * anagrams.
 *
 * <p>Two integers are considered to be digit anagrams if they contain the same digits. In other
 * words, one can be obtained from the other by rearranging the digits, or trivially if the numbers
 * are equal.</p>
 *
 * <p>For example, {@code 54275} and {@code 45572} are digit anagrams, but {@code 321} and
 * {@code 782} are not, since they do not contain the same digits. {@code 220} and {@code 22} are
 * also not considered digit anagrams, since they do not have the same number of digits.</p>
 *
 * <h2>Example</h2>
 * <p>For {@code a = [25, 35, 872, 228, 53, 278, 872]}, the output should be
 * {@code solution(a) = 4}.</p>
 *
 * <p>There are 4 pairs of digit anagrams:</p>
 *
 * <ol>
 *     <li>{@code a[1] = 35} and {@code a[4] = 53} ({@code i = 1} and {@code j = 4}).</li>
 *     <li>{@code a[2] = 872} and {@code a[5] = 278} ({@code i = 2} and {@code j = 5}).</li>
 *     <li>{@code a[2] = 872} and {@code a[6] = 872} ({@code i = 2} and {@code j = 6}).</li>
 *     <li>{@code a[5] = 278} and {@code a[6] = 872} ({@code i = 5} and {@code j = 6}).</li>
 * </ol>
 *
 * <h2>Input/Output</h2>
 * <ul>
 *     <li>[execution time limit] 3 seconds (java)</li>
 *     <li>[memory limit] 1 GB</li>
 *     <li>[input] array.integer {@code a}: An array of non-negative integers.</li>
 * </ul>
 *
 * <p>Guaranteed constraints:</p>
 * <ul>
 *     <li>1 &le; {@code a.length} &le; 105</li>
 *     <li>0 &le; {@code a[i]} &le; 109</li>
 * </ul>
 *
 * <p>[output] integer64</p>
 *
 * <p>The number of pairs {@code i} and {@code j} such that {@code a[i]} and {@code a[j]} are digit
 * anagrams.</p>
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
