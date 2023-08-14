package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
151. Reverse Words in a String
 */
public class ReverseWords {
    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        String s = "  the sky   is blue ";
        System.out.println(rw.reverseWords2(s));
    }

    //Using String.split()
    public String reverseWords1(String s) {
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

    //Without String.split()
    public String reverseWords2(String s) {
        List<Character> reverse = reverseString(s);
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch: reverse) {
            if (ch != ' ') {
                stack.push(ch);
            } else {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.append(" ");
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    private List<Character> reverseString(String str) {
        List<Character> chars = new ArrayList<>();
        boolean wordStart = false;

        for (int i = str.length()-1; i >= 0; i--) {
            char ch = str.charAt(i);

            if (wordStart) {
                if (ch == ' ') {
                    chars.add(ch);
                    wordStart = false;
                } else {
                    chars.add(ch);
                }
            } else {
                if (ch != ' ') {
                    chars.add(ch);
                    wordStart = true;
                }
            }
        }

        int last = chars.size() - 1;

        if (chars.get(last) == ' ') {
            chars.remove(last);
        }
        return chars;
    }
}
