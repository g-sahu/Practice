package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1376. Time Needed to Inform All Employees
 */
public class TimeToInformAllEmp {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] times;
    int max;

    public int numOfMinutes(int n, int h, int[] managers, int[] times) {
        this.times = times;

        for(int i=0; i<n; i++) {
            List<Integer> list = map.getOrDefault(managers[i], new ArrayList<>());
            list.add(i);
            map.put(managers[i], list);
        }

        dfs(h, 0);
        return max;
    }

    void dfs(int m, int t) {
        max = Math.max(max, t + times[m]);
        List<Integer> reports = map.getOrDefault(m, new ArrayList<>());

        for(int r: reports) {
            dfs(r, t + times[m]);
        }
    }
}
