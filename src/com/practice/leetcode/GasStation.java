package com.practice.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
134. Gas Station
 */
public class GasStation {
    public static void main(String[] args) {
        GasStation gs = new GasStation();
        int[] gas  = {2,3,4};
        int[] cost = {3,4,3};
        System.out.println(gs.canCompleteCircuit(gas, cost));
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        List<Integer> starts = new ArrayList<>();
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            if (gas[i] >= cost[i]) {
                starts.add(i);
            }

            diff[i] = gas[i] - cost[i];
        }

        int start = -1;

        for (int i: starts) {
            int j = i == n-1 ? 0 : i+1;
            int tank = diff[i];
            start = i;

            while (j != i) {
                tank += diff[j];

                if (tank < 0) {
                    start = -1;
                    break;
                }

                j = j == n-1 ? 0 : j+1;
            }

            if (start != -1) {
                return start;
            }
        }

        return start;
    }
}
