package com.practice.leetcode;

/*
709. To Lower Case
 */
public class ToLowerCase {

    public static void main(String[] args) {
        String s = "Hello";
        ToLowerCase o = new ToLowerCase();
        System.out.println(o.toLowerCase(s));
    }

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ('A' <= ch && ch <= 'Z') {
                ch = (char) (ch + 'a' - 'A');
            }

            sb.append(ch);
        }

        return sb.toString();
    }
}
