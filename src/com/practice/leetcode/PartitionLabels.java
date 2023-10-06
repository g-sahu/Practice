package com.practice.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 763. Partition Labels
 */
public class PartitionLabels {

    public static void main(String[] args) {
        PartitionLabels o = new PartitionLabels();
        System.out.println(o.partitionLabels("abc"));
    }

    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            Integer[] arr = map.getOrDefault(ch, new Integer[]{i, i});
            arr[1] = i;
            map.put(ch, arr);
        }

        List<Integer[]> values = map.values()
                                    .stream()
                                    .sorted(Comparator.comparingInt(a -> a[0]))
                                    .collect(Collectors.toList());

        List<Integer> list = new ArrayList<>();
        Integer[] prev = values.get(0);
        int start = prev[0];
        int end = prev[1];

        for (int i = 1; i < values.size() - 1; i++) {
            Integer[] curr = values.get(i);

            if (curr[0] > end) {
                list.add(end - start + 1);
                start = curr[0];
                end = curr[1];
            } else {
                end = Math.max(end, curr[1]);
            }
        }

        return list;
    }
}
