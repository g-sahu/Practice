package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 2225. Find Players With Zero or One Losses
 */
public class FindPlayersWithZeroOrOneLosses {

    //Using HashMap + sorting
    public List<List<Integer>> findWinners1(int[][] matches) {
        Map<Integer, Integer> lossCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            lossCount.putIfAbsent(winner, 0);
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> zeroLoss = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : lossCount.entrySet()) {
            if (entry.getValue() == 0) {
                zeroLoss.add(entry.getKey());
            } else if (entry.getValue() == 1) {
                oneLoss.add(entry.getKey());
            }
        }

        Collections.sort(zeroLoss);
        Collections.sort(oneLoss);
        return List.of(zeroLoss, oneLoss);
    }

    //Using TreeMap
    public List<List<Integer>> findWinners2(int[][] matches) {
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
