package com.practice.leetcode;

import java.util.Arrays;
import java.util.Stack;

/*
735. Asteroid Collision
 */
public class AsteroidCollision {

    public static void main(String[] args) {
        int[] nums = {-2,-1,1,2};
        AsteroidCollision ac = new AsteroidCollision();
        System.out.println(Arrays.toString(ac.asteroidCollision(nums)));
    }

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while (i < asteroids.length) {
            int num = asteroids[i];

            if (num < 0) {
                if (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.pop();

                    if (top < Math.abs(num)) {
                        i--;
                    } else if (top > Math.abs(num)) {
                        stack.push(top);
                    }
                } else {
                    stack.push(num);
                }
            } else {
                stack.push(num);
            }

            i++;
        }

        int[] nums = new int[stack.size()];
        for (int j = nums.length-1; j >= 0; j--) {
            nums[j] = stack.pop();
        }

        return nums;
    }
}
