package com.practice.leetcode;

/*
374. Guess Number Higher or Lower
 */
public class GuessNumber {

    public int guessNumber(int n) {
        int left = 1;
        int right = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + ((right - left)/2);
            int guess = guess(mid);

            if (guess == -1) {
                right = mid - 1;
            } else if (guess == 1) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    private int guess(int num) {
        return 0;
    }
}
