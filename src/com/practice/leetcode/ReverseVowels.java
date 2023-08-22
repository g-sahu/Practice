package com.practice.leetcode;

import java.util.Set;

/*
345. Reverse Vowels of a String
 */
public class ReverseVowels {

    public static void main(String[] args) {
        String s = "hello";
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        char[] str = s.toCharArray();

        while (i <= j) {
            char lch = str[i];
            char rch = str[j];

            if (set.contains(lch)) {
                if (set.contains(rch)){
                    if (lch != rch) {
                        char t = str[i];
                        str[i] = str[j];
                        str[j] = t;
                    }
                    i++;
                }
                j--;
            } else {
                i++;
            }
        }

        return new String(str);
    }
}
