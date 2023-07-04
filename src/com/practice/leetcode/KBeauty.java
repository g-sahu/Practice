package com.practice.leetcode;

/*
    2269. Find the K-Beauty of a Number

    The k-beauty of an integer num is defined as the number of substrings of num when it is read as a string that meet the following conditions:
    It has a length of k.
    It is a divisor of num.
    Given integers num and k, return the k-beauty of num.

    Note:
    Leading zeros are allowed.
    0 is not a divisor of any value.
    A substring is a contiguous sequence of characters in a string.

    Example 1:
    Input: num = 240, k = 2
    Output: 2
    Explanation: The following are the substrings of num of length k:
    - "24" from "240": 24 is a divisor of 240.
    - "40" from "240": 40 is a divisor of 240.
    Therefore, the k-beauty is 2.

    Example 2:
    Input: num = 430043, k = 2
    Output: 2
    Explanation: The following are the substrings of num of length k:
    - "43" from "430043": 43 is a divisor of 430043.
    - "30" from "430043": 30 is not a divisor of 430043.
    - "00" from "430043": 0 is not a divisor of 430043.
    - "04" from "430043": 4 is not a divisor of 430043.
    - "43" from "430043": 43 is a divisor of 430043.
    Therefore, the k-beauty is 2.

    Constraints:
    1 <= num <= 109
    1 <= k <= num.length (taking num as a string)
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
