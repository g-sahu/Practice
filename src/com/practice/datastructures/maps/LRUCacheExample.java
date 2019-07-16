package com.practice.datastructures.maps;

import java.util.Arrays;

public class LRUCacheExample {
    public static void main(String[] args) {
        /*LRUCache cache = new LRUCache(5);

        for(int i=1; i<=6; i++) {
            cache.put(i, i);
        }

        cache.get(2);
        cache.put(7, 7);
        System.out.println(Arrays.toString(cache.keySet().toArray()));*/

        //LRUCacheImpl cache = new LRUCacheImpl(5);
        LRUCache cache = new LRUCache(5);

        for(int i=1; i<=5; i++) {
            cache.add(i, i);
        }

        System.out.println(Arrays.toString(cache.getAll()));
        cache.get(2);
        System.out.println(Arrays.toString(cache.getAll()));
        cache.get(1);
        System.out.println(Arrays.toString(cache.getAll()));
        cache.get(5);
        System.out.println(Arrays.toString(cache.getAll()));
    }
}

/*
class LRUCache extends LinkedHashMap {
    private int cacheSize;

    LRUCache(int size) {
        super(size, 0.75f, true);
        this.cacheSize = size;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > cacheSize;
    }

}*/
