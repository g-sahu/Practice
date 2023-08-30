package com.practice.leetcode;

/*
2483. Minimum Penalty for a Shop
 */
public class MinPenalty {

    public static void main(String[] args) {
        String s = "YYYY";
        MinPenalty o = new MinPenalty();
        System.out.println(o.bestClosingTime(s));
    }

    public int bestClosingTime(String customers) {
        int penalty = 0;

        for (int i = 0; i < customers.length(); i++) {
            if (customers.charAt(i) == 'Y') {
                penalty++;
            }
        }

        int min = penalty;
        int h = 0;

        for (int i = 1; i < customers.length()+1; i++) {
            if (customers.charAt(i-1) == 'N') {
                penalty++;
            } else {
                penalty--;
            }

            if (penalty < min) {
                min = penalty;
                h = i;
            }
        }

        return h;
    }
}
