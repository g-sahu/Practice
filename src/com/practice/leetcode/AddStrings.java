package com.practice.leetcode;

/*
415. Add Strings
 */
public class AddStrings {

    public String addStrings(String num1, String num2) {
        int l1 = num1.length() - 1;
        int l2 = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (l1 >= 0 || l2 >= 0) {
            int n1 = l1 >= 0 ? num1.charAt(l1--) - '0' : 0;
            int n2 = l2 >= 0 ? num2.charAt(l2--) - '0' : 0;
            int sum = n1 + n2 + carry;

            if (sum > 9) {
                carry = 1;
                sb.append(sum % 10);
            } else {
                carry = 0;
                sb.append(sum);
            }
        }

        if (carry != 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
