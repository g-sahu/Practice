package com.practice.hackerrank;

public class RepeatedString {

    public static long repeatedString(String s, long n) {
        int l = s.length();
        long m = n/l;
        long r = n%l;

        long c = 0;

        for(char ch: s.toCharArray()) {
            if(ch == 'a') {
                c++;
            }
        }

        c = c*m;

        for(int i=0; i<r; i++) {
            char ch = s.charAt(i);

            if(ch == 'a') {
                c++;
            }
        }

        return c;
    }

}
