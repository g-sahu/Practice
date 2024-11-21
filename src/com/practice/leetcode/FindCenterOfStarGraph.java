package com.practice.leetcode;

/**
 * 1791. Find Center of Star Graph
 */
public class FindCenterOfStarGraph {

    public int findCenter(int[][] edges) {
        int[] first = edges[0];
        int[] second = edges[1];

        return (first[0] == second[0] || first[0] == second[1])
                ? first[0]
                : first[1];
    }

}
