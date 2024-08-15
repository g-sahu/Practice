package com.practice.leetcode;

/**
 * 860. Lemonade Change
 */
public class LemonadeChange {

    public static void main(String[] args) {
        int[] bills = {5,5,5,10,5,5,10,20,20,20};
        LemonadeChange l = new LemonadeChange();
        System.out.println(l.lemonadeChange(bills));
    }

    public boolean lemonadeChange(int[] bills) {
        int f5=0, f10=0;

        for(int b: bills) {
            if (b == 5) {
                ++f5;
            } else if (b == 10) {
                ++f10;
            }

            int change = b - 5;

            switch(change) {
                case 0: break;

                case 5:
                    if(f5 == 0) {
                        return false;
                    } else {
                        --f5;
                    }
                    break;

                case 15:
                    if(f10 == 0) {
                        if(f5 < 3) {
                            return false;
                        } else {
                            f5 = f5 - 3;
                        }
                    } else if (f5 == 0) {
                        return false;
                    } else {
                        --f5;
                        --f10;
                    }
                    break;
            }
        }

        return true;
    }
}
