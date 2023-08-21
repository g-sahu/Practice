package com.practice.leetcode;

/*
605. Can Place Flowers
 */
public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] flowers = {0,0,0,1,0,1};
        CanPlaceFlowers cpf = new CanPlaceFlowers();
        System.out.println(cpf.canPlaceFlowers(flowers, 1));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int l = flowerbed.length;
        int i = 0;

        while (i < l && n > 0) {
            if (flowerbed[i] == 0) {
                if (i == 0 || flowerbed[i-1] == 0) {
                    if (i == l-1 || flowerbed[i+1] == 0) {
                        n--;
                        flowerbed[i] = 1;
                    }
                }
            }

            i++;
        }

        return n == 0;
    }
}
