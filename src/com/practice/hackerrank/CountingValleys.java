package com.practice.hackerrank;

public class CountingValleys {

    public static int countingValleys(int steps, String p) {
        int e = 0;
        boolean v = false;
        int c = 0;

        for(int i=0; i<p.length(); i++) {
            char ch = p.charAt(i);

            if(ch == 'D') {
                e--;
            } else {
                e++;
            }

            if(e < 0) {
                v = true;
            } else if (e == 0) {
                if(v) {
                    c++;
                }
            } else {
                v = false;
            }
        }

        return c;
    }

}
