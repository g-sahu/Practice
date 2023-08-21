package com.practice.leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

/*
649. Dota2 Senate
 */
public class Dota2Senate {
    public static void main(String[] args) {
        String senate = "RDD";
        Dota2Senate ds = new Dota2Senate();
        System.out.println(ds.predictPartyVictory2(senate));
    }

    //Using Brute Force
    public String predictPartyVictory1(String senate) {
        char[] chars = senate.toCharArray();
        int rsum = 0;
        int dsum = 0;

        for (char ch : chars) {
            if (ch == 'R') {
                rsum++;
            } else {
                dsum++;
            }
        }

        int i = 0;
        int j = 0;

        while (rsum > 0 && dsum > 0) {
            char ch = chars[i];

            if (ch != 'X') {
                if (ch == 'R') {
                    --dsum;
                    j = findNext(chars, 'D', i);
                } else {
                    --rsum;
                    j = findNext(chars, 'R', i);
                }

                chars[j] = 'X';
            }

            i = i == chars.length-1 ? 0 : i+1;
        }

        return rsum == 0 ? "Dire" : "Radiant";
    }

    private static int findNext(char[] chars, char ch, int i) {
        int last = chars.length - 1;
        int j = i == last ? 0 : i+1;

        for (int k = 1; k <= chars.length; k++) {
            if (chars[j] == ch) {
                return j;
            }

            j = j == last ? 0 : j+1;
        }

        return -1;
    }

    //Using two queues
    public String predictPartyVictory2(String senate) {
        char[] chars = senate.toCharArray();
        Queue<Integer> rq = new ArrayDeque<>();
        Queue<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i <senate.length(); i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                rq.offer(i);
            } else {
                dq.offer(i);
            }
        }

        int i = 0;
        while (!rq.isEmpty() && !dq.isEmpty()) {
            char ch = chars[i];

            if (ch != 'X') {
                if (ch == 'R') {
                    chars[dq.poll()] = 'X';
                    rq.offer(rq.poll());
                } else {
                    chars[rq.poll()] = 'X';
                    dq.offer(dq.poll());
                }
            }

            i = i == chars.length-1 ? 0 : i+1;
        }

        return rq.isEmpty() ? "Dire" : "Radiant";
    }
}
