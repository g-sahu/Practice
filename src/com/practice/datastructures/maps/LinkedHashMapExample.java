package com.practice.datastructures.maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i=0; i<10; i++) {
            map.put(9-i, i);
            System.out.println((9-i) + " -> " + i);
        }

        System.out.println();

        for(Integer key: map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
