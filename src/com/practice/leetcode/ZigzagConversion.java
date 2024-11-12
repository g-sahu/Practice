package com.practice.leetcode;

/**
 * 6. Zigzag Conversion
 */
public class ZigzagConversion {
    public String convert(String s, int r) {
        int c = s.length();
        Character[][] arr = new Character[r][c];
        int i=0, j=0, x=0;
        boolean down = true;

        while(x < c) {
            while(down && x < c) {
                arr[i][j] = s.charAt(x++);

                if(i == r-1) {
                    down = false;
                    i = i == 0 ? i : i-1;
                    j++;
                } else {
                    i = i == r-1 ? i : i+1;
                }
            }

            while(!down && x < c) {
                arr[i][j] = s.charAt(x++);

                if(i == 0) {
                    down = true;
                    i = i == r-1 ? i : i+1;
                    j++;
                } else {
                    j++;
                    i = i-1;
                }
            }
        }

        return convert(arr);
    }

    String convert(Character[][] arr) {
        StringBuilder sb = new StringBuilder();

        for (Character[] chars : arr) {
            for (int j = 0; j < arr[0].length; j++) {
                if (chars[j] != null) {
                    sb.append(chars[j]);
                }
            }
        }

        return sb.toString();
    }
}
