package com.practice.leetcode;

/**
 * 1071. Greatest Common Divisor of Strings
 */
public class GCDOfStrings {

    public String gcdOfStrings(String s1, String s2) {
        if(!(s1 + s2).equals(s2 + s1)) {
            return "";
        }

        int gcd = gcdLen(s1.length(), s2.length());
        return s1.substring(0, gcd);
    }

    int gcdLen(int a, int b) {
        while(b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}
