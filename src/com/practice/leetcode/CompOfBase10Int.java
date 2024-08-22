package com.practice.leetcode;

/**
 * 1009. Complement of Base 10 Integer
 */
public class CompOfBase10Int {

    public int bitwiseComplement(int n) {
        int comp = 0;
        int i=0;

        if(n == 0) {
            return 1;
        }

        while(n != 0) {
            int r = n%2;
            n = n/2;

            if(r == 0) {
                comp += (int) Math.pow(2, i);
            }
            i++;
        }

        return comp;
    }
}
