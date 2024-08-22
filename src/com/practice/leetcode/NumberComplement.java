package com.practice.leetcode;

/**
 * 476. Number Complement
 */
public class NumberComplement {

    public int findComplement(int num) {
        int comp = 0;
        int i=0;

        while(num != 0) {
            int r = num%2;
            num = num/2;

            if(r == 0) {
                comp += (int) Math.pow(2, i);
            }
            i++;
        }

        return comp;
    }
}
