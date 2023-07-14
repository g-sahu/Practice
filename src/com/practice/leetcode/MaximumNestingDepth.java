package com.practice.leetcode;

/*
1614. Maximum Nesting Depth of the Parentheses
 */
public class MaximumNestingDepth {
    public static void main(String[] args) {
        MaximumNestingDepth mnd = new MaximumNestingDepth();
        String s = "(1+(2*3)+((8)/4))+1";
        System.out.println(mnd.maxDepth(s));
    }

    public int maxDepth(String s) {
        int d = 0;
        int max = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                d++;
                max = d > max ? d : max;
            }

            if (ch == ')') {
                d--;
            }
        }

        return max;
    }
}
