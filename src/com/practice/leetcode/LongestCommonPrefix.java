package com.practice.leetcode;

/*
14. Longest Common Prefix
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] arr=  {"flower", "flow", "flight"};
        LongestCommonPrefix t = new LongestCommonPrefix();
        System.out.println(t.findPrefix(arr));
    }

    public String longestCommonPrefix(String[] arr) {
        String f = arr[0];
        int i = 0;
        StringBuilder sb = new StringBuilder();

        while (i < f.length()) {
            char ch = f.charAt(i);

            for (int j = 1; j < arr.length; j++) {
                String s = arr[j];

                if (i >= s.length() || s.charAt(i) != ch) {
                    return sb.toString();
                }
            }

            sb.append(ch);
            i++;
        }

        return sb.toString();
    }
}
