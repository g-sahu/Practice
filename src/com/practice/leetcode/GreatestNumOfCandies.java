package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
1431. Kids With the Greatest Number of Candies
 */
public class GreatestNumOfCandies {
    public static void main(String[] args) {
        GreatestNumOfCandies gnc = new GreatestNumOfCandies();
        int[] candies = {2, 3, 5, 1, 3};
        List<Boolean> result = gnc.kidsWithCandies(candies, 3);
        result.forEach(System.out :: println);
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Arrays.stream(candies).max().getAsInt();
        List<Boolean> result = new ArrayList<>();

        for (int candy : candies) {
            result.add((candy + extraCandies) >= max);
        }

        return result;
    }
}
