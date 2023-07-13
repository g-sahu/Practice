package com.practice.leetcode;

/*
1108. Defanging an IP Address
 */
public class DefangIPAddress {

    public static void main(String[] args) {
        DefangIPAddress dia = new DefangIPAddress();
        String address = "255.100.50.0";
        System.out.println(dia.defangIPaddr(address));
    }

    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < address.length(); i++) {
            char ch = address.charAt(i);

            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}
