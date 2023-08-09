package com.practice.leetcode;

/*
67. Add Binary
 */
public class AddBinary {
    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String a = "1010";
        String b = "1011";
        System.out.println(addBinary.addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = carry + n1 + n2;

            if (sum == 0 || sum == 1) {
                sb.append(sum);
                carry = 0;
            } else if (sum == 2) {
                sb.append(0);
                carry = 1;
            } else if (sum == 3) {
                sb.append(1);
                carry = 1;
            }

            i--;
            j--;
        }

        if (carry == 1) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
