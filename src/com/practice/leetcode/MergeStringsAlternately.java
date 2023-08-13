package com.practice.leetcode;

/*
1768. Merge Strings Alternately
 */
public class MergeStringsAlternately {

    //Using StringBuilder
    public String mergeAlternately1(String word1, String word2) {
        int l = Math.max(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < l; i++) {
            if (i < word1.length()) {
                sb.append(word1.charAt(i));
            }

            if (i < word2.length()) {
                sb.append(word2.charAt(i));
            }
        }

        return sb.toString();
    }

    //Using Array
    public String mergeAlternately2(String word1, String word2) {
        int l = Math.max(word1.length(), word2.length());
        char[] arr = new char[word1.length() + word2.length()];
        int j = 0;

        for (int i = 0; i < l; i++) {
            if (i < word1.length()) {
                arr[j++] = word1.charAt(i);
            }

            if (i < word2.length()) {
                arr[j++] = word2.charAt(i);
            }
        }

        return new String(arr);
    }
}
