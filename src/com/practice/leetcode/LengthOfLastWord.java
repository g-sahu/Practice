package com.practice.leetcode;

/*
58. Length of Last Word
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
        LengthOfLastWord lolw = new LengthOfLastWord();
        String s = "   fly me   to   the moon  ";
        System.out.println(lolw.lengthOfLastWord2(s));
    }

    //Using String.split()
    public int lengthOfLastWord1(String s) {
        String[] arr = s.split(" ");
        return arr[arr.length-1].length();
    }

    public int lengthOfLastWord2(String s) {
        int c = 0;

        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (c > 0) {
                    break;
                }
            } else {
                c++;
            }
        }

        return c;
    }
}
