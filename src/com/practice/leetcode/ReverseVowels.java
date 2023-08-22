package com.practice.leetcode;

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
        char[] str = s.toCharArray();

        while (i <= j) {
            char lch = str[i];
            char rch = str[j];

            if (isVowel(lch)) {
                if (isVowel(rch)){
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

    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
