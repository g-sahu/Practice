package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2225. Find Players With Zero or One Losses
 */
public class FindPlayersWithZeroOrOneLosses {

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new TreeMap<>();

        for(int[] m: matches) {
            map.putIfAbsent(m[0], 0);
            int l = map.getOrDefault(m[1], 0) + 1;
            map.put(m[1], l);
        }

        List<Integer> zero = new ArrayList<>();
        List<Integer> one = new ArrayList<>();

        map.forEach((k, v) -> {
            if(v == 0) {
                zero.add(k);
            }
            if(v == 1) {
                one.add(k);
            }
        });

        return List.of(zero, one);
    }
}
