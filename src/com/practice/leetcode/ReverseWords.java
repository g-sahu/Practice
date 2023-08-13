package com.practice.leetcode;

/*
151. Reverse Words in a String
 */
public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = words.length-1; i >= 0; i--) {
            String str = words[i];

            if (!str.isEmpty()) {
                sb.append(" ").append(str);
            }
        }

        return sb.substring(1);
    }
}
