package com.practice.leetcode;

/**
 * 2125. Number of Laser Beams in a Bank
 */
public class NumberOfLaserBeamsInABank {

    // Brute force
    public int numberOfBeams1(String[] bank) {
        int c=0;

        for(int i=0; i<bank.length-1; i++) {
            String r1 = bank[i];

            for(int j=0; j<r1.length(); j++) {
                if(r1.charAt(j) == '1') {
                    for(int k=i+1; k<bank.length; k++) {
                        String r2 = bank[k];
                        boolean found = false;

                        for(int l=0; l<r2.length(); l++) {
                            if(r2.charAt(l) == '1') {
                                c++;
                                found = true;
                            }
                        }

                        if(found) {
                            break;
                        }
                    }
                }
            }
        }

        return c;
    }

    public int numberOfBeams2(String[] bank) {
        int prev = 0, t = 0;

        for (String row : bank) {
            int c = 0;

            for (char ch: row.toCharArray()) {
                if (ch == '1') {
                    c++;
                }
            }

            if (c > 0) {
                t += c * prev;
                prev = c;
            }
        }

        return t;
    }
}
