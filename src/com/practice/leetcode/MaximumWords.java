package com.practice.leetcode;

/*
2114. Maximum Number of Words Found in Sentences
 */
public class MaximumWords {

    public static void main(String[] args) {
        MaximumWords mw = new MaximumWords();
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mw.mostWordsFound2(sentences));
    }

    //Using String.split()
    public int mostWordsFound1(String[] sentences) {
        int max = 0;

        for (String sentence: sentences) {
            if (sentence.length() > (max * 2)) {
                String[] words = sentence.split(" ");
                int l = words.length;
                max = l > max ? l : max;
            }
        }

        return max;
    }

    public int mostWordsFound2(String[] sentences) {
        int max = 0;

        for (String sentence: sentences) {
            if (sentence.length() > (max * 2)) {
                int l = 0;

                for (int i = 0; i < sentence.length(); i++) {
                    if (sentence.charAt(i) == ' ') {
                        ++l;
                    }
                }

                ++l;
                max = l > max ? l : max;
            }
        }

        return max;
    }
}
