package com.practice.leetcode;

/*
1221. Split a String in Balanced Strings
 */
public class BalancedStrings {
    public static void main(String[] args) {
        String s = "LLLLRRRR";
        BalancedStrings o = new BalancedStrings();
        System.out.println(o.balancedStringSplit(s));
    }

    public int balancedStringSplit(String s) {
        int c = 0;
        int lc = 0;
        int rc = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                lc++;
            } else {
                rc++;
            }

            if (lc == rc) {
                c++;
                lc = 0;
                rc = 0;
            }
        }

        return c;
    }
}
