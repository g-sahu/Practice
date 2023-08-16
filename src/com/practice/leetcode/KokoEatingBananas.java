package com.practice.leetcode;

/*
875. Koko Eating Bananas
 */
public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas keb = new KokoEatingBananas();
        int[] piles = {805306368,805306368,805306368};
        System.out.println(keb.minEatingSpeed(piles, 1000000000));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = piles[0];

        for (int pile: piles) {
            right = Math.max(pile, right);
        }

        int min = right;

        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;

            for (int pile : piles) {
                int q = pile / mid;
                int r = pile % mid;
                sum += r == 0 ? q : q + 1;
            }

            if (sum <= h) {
                min = Math.min(mid, min);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return min;
    }
}
