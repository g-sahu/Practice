package com.practice.leetcode;

/**
 * 2269. Find the K-Beauty of a Number
 *
 * <p>The k-beauty of an integer {@code num} is defined as the number of substrings of {@code num}
 * when it is read as a string that meet the following conditions:</p>
 *
 * <ul>
 *     <li>It has a length of {@code k}.</li>
 *     <li>It is a divisor of {@code num}.</li>
 * </ul>
 *
 * <p>Given integers {@code num} and {@code k}, return the k-beauty of {@code num}.</p>
 *
 * <h2>Notes</h2>
 * <ul>
 *     <li>Leading zeros are allowed.</li>
 *     <li>0 is not a divisor of any value.</li>
 *     <li>A substring is a contiguous sequence of characters in a string.</li>
 * </ul>
 *
 * <h2>Example 1</h2>
 * <pre>
 * Input: num = 240, k = 2
 * Output: 2
 * Explanation: The following are the substrings of num of length k:
 * - "24" from "240": 24 is a divisor of 240.
 * - "40" from "240": 40 is a divisor of 240.
 * Therefore, the k-beauty is 2.
 * </pre>
 *
 * <h2>Example 2</h2>
 * <pre>
 * Input: num = 430043, k = 2
 * Output: 2
 * Explanation: The following are the substrings of num of length k:
 * - "43" from "430043": 43 is a divisor of 430043.
 * - "30" from "430043": 30 is not a divisor of 430043.
 * - "00" from "430043": 0 is not a divisor of 430043.
 * - "04" from "430043": 4 is not a divisor of 430043.
 * - "43" from "430043": 43 is a divisor of 430043.
 * Therefore, the k-beauty is 2.
 * </pre>
 *
 * <h2>Constraints</h2>
 * <ul>
 *     <li>{@code 1 <= num <= 109}</li>
 *     <li>{@code 1 <= k <= num.length}, taking {@code num} as a string.</li>
 * </ul>
 */
public class KBeauty {

    public static void main(String[] args) {
        KBeauty kb = new KBeauty();
        int num = 240;
        int k = 2;
        System.out.println(kb.divisorSubstrings(num, k));
    }

    public int divisorSubstrings(int num, int k) {
        String s = Integer.toString(num);
        int l = s.length();
        int c = 0;

        for (int i=0; i<l; i++) {
            int n = 0;
            int j = i;

            while (k <= l && j < k) {
                char ch = s.charAt(j);
                n = (n * 10) + (ch - '0');
                j++;
            }

            if (n != 0 && num % n == 0) {
                c++;
            }

            k++;
        }

        return c;
    }
}
