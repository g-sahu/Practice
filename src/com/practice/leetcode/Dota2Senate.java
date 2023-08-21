package com.practice.leetcode;

/*
649. Dota2 Senate
 */
public class Dota2Senate {
    public static void main(String[] args) {
        String senate = "DRRDRDRDRDDRDRDR";
        Dota2Senate ds = new Dota2Senate();
        System.out.println(ds.predictPartyVictory(senate));
    }

    public String predictPartyVictory(String senate) {
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

    /*public String predictPartyVictory(String senate) {
        char[] chars = senate.toCharArray();
        Queue<Character> rq = new ArrayDeque<>();
        Queue<Character> dq = new ArrayDeque<>();

        for (int i = 0; i <senate.length(); i++) {
            char ch = senate.charAt(i);
            if (ch == 'R') {
                rq.offer(ch);
            } else {
                dq.offer(ch);
            }
        }

        int i = 0;
        while (!rq.isEmpty() && !dq.isEmpty()) {
            char ch = chars[i];

            if (ch == 'R') {
                dq.poll();
            } else {
                rq.poll();
            }

            if (i == senate.length()-1) {
                i = 0;
            } else {
                i++;
            }
        }

        return rq.isEmpty() ? "Dire" : "Radiant";
    }*/
}
