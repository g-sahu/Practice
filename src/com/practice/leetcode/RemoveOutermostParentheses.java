package com.practice.leetcode;

/*
1021. Remove Outermost Parentheses
 */
public class RemoveOutermostParentheses {
    public static void main(String[] args) {
        RemoveOutermostParentheses rop = new RemoveOutermostParentheses();
        String s = "(()())(())";
        System.out.println(rop.removeOuterParentheses(s));
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        int lc = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                lc++;
                sb.append(ch);
            } else {
                lc--;

                if (lc == 0) {
                    sb.deleteCharAt(j);
                    j = sb.length();
                } else {
                    sb.append(ch);
                }
            }
        }

        return sb.toString();
    }
}
