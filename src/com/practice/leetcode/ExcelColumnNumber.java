package com.practice.leetcode;

/*
171. Excel Sheet Column Number
 */
public class ExcelColumnNumber {

    public static void main(String[] args) {
        ExcelColumnNumber ecn = new ExcelColumnNumber();
        System.out.println(ecn.titleToNumber("AA"));
    }

    public int titleToNumber(String s) {
        int l = s.length();
        int num = 0;

        for (int i = 0; i < l-1; i++) {
            char ch = s.charAt(i);
            num += 26 * (ch - 'A' + 1);
        }

        char ch = s.charAt(l-1);
        num += (ch - 'A' + 1);
        return num;
    }
}
