package com.practice.leetcode;

/*
1768. Merge Strings Alternately
 */
public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int l = word1.length() + word2.length();
        StringBuilder sb = new StringBuilder(l);

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
}
