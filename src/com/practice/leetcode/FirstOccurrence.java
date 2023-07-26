package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
28. Find the Index of the First Occurrence in a String
 */
public class FirstOccurrence {
    public static void main(String[] args) {
        FirstOccurrence fo = new FirstOccurrence();
        String haystack = "mississippi";
        String needle = "issipi";
        System.out.println(fo.strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        char fch = needle.charAt(0);
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == fch) {
                list.add(i);
            }
        }

        for(int i: list) {
            int j = 0;
            int k = i;
            int c = 0;

            while (j < needle.length() && k < haystack.length()) {
                if (needle.charAt(j) == haystack.charAt(k)) {
                    c++;
                    k++;
                } else {
                    break;
                }

                j++;
            }

            if (c == needle.length()) {
                return i;
            }
        }

        return -1;
    }
}
