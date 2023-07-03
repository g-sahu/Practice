package com.practice.leetcode;

public class BasicCalculator {
    public static void main(String[] argv) {
        String s = "1-(     -2)";
        BasicCalculator solution = new BasicCalculator();
        System.out.println(solution.calculate(s));
    }

    public int calculate(String s) {
        char[] chars = s.toCharArray();
        int current = 0;
        int prev = 0;
        int out = 0;
        Character outOp = null;
        Character prevOp = null;

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (Character.isDigit(c)) {
                current = (current * 10) + (c - '0');
            } else if (c == '+' || c == '-') {
                if (prevOp == null) {
                    prev = current;
                }
                else if (prevOp == '+') {
                    prev = prev + current;
                }
                else if (prevOp == '-') {
                    if (c == '-') {
                        prev = prev + current;
                    } else {
                        prev = prev - current;
                    }
                }

                current = 0;
                prevOp = c;
            }
            else if(c == '(') {
                out = prev;
                outOp = prevOp;
                current = 0;
                prev = 0;
                prevOp = null;
            }
            else if (c == ')') {
                if (outOp == '-') {
                    prev = prev + current;
                }
            }

            if (i == chars.length - 1) {
                if (prevOp == null) {
                    return current;
                }
                else if(prevOp == '+') {
                    return prev + current;
                }
                else if(prevOp == '-') {
                    return prev - current;
                } else {
                    return current;
                }
            }
        }

        return prev;
    }
}
