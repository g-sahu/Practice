package com.practice.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
2671. Frequency Tracker
 */
public class FrequencyTracker {
    private final Map<Integer, Integer> numMap;
    private final Map<Integer, List<Integer>> freqMap;

    public static void main(String[] args) {
        FrequencyTracker ft = new FrequencyTracker();
        ft.deleteOne(3);
        ft.add(9);
        ft.add(9);
        ft.add(4);
        System.out.println(ft.hasFrequency(2));
        ft.deleteOne(2);
        ft.add(9);
        ft.add(9);
        System.out.println(ft.hasFrequency(3));
        ft.deleteOne(9);
        ft.deleteOne(1);
        ft.add(6);
    }

    public FrequencyTracker() {
        numMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public void add(int number) {
        int freq = numMap.getOrDefault(number, 0);
        increaseFreq(number, freq);
    }

    public void deleteOne(int number) {
        if (numMap.containsKey(number)) {
            int freq = numMap.get(number);
            decreaseFreq(number, freq);
        }
    }

    private void increaseFreq(int num, int freq) {
        //Update freqMap
        removeFromList(freq, num);
        addToList(freq+1, num);

        //Update numMap
        int newFreq = numMap.getOrDefault(num, 0) + 1;
        numMap.put(num, newFreq);
    }

    private void decreaseFreq(int num, int freq) {
        //Remove from current freq list and add to new freq list
        removeFromList(freq, num);
        addToList(freq-1, num);

        //Update numMap
        int newFreq = numMap.get(num) - 1;

        if (newFreq == 0) {
            numMap.remove(num);
        } else {
            numMap.put(num, newFreq);
        }
    }

    private void addToList(int freq, int num) {
        List<Integer> list = freqMap.getOrDefault(freq, new ArrayList<>());
        list.add(num);
        freqMap.put(freq, list);
    }

    private void removeFromList(int freq, int num) {
        if (freqMap.containsKey(freq)) {
            List<Integer> list = freqMap.get(freq);
            list.remove(Integer.valueOf(num));

            if (list.isEmpty()) {
                freqMap.remove(freq);
            } else {
                freqMap.put(freq, list);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return freqMap.containsKey(frequency);
    }
}
