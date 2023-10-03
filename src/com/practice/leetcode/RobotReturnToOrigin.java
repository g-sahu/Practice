package com.practice.leetcode;

/**
 * 657. Robot Return to Origin
 */
public class RobotReturnToOrigin {

    public boolean judgeCircle(String s) {
        int x = 0, y=0;

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            switch(ch) {
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
            }
        }

        return x == 0 && y == 0;
    }
}
