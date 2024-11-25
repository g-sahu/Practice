package com.practice.datastructures.maps;

import java.util.LinkedList;

public class LRUCacheImpl {
    private final LinkedList<Object> keys;
    private final LinkedList<Object> values;
    private final int cacheSize;

    LRUCacheImpl(int cacheSize) {
        values = new LinkedList<>();
        keys = new LinkedList<>();
        this.cacheSize = cacheSize;
    }

    public void add(Object key, Object value) {
        if(values.size() == cacheSize) {
            keys.removeFirst();
            values.removeFirst();
        }

        keys.add(key);
        values.add(value);
    }

    public Object get(Object key) {
        Object value = null;

        if(keys.contains(key)) {
            value = values.get(keys.indexOf(key));
            keys.remove(key);
            keys.add(key);
            values.remove(value);
            values.add(value);
        }

        return value;
    }

    public Object[] getAll() {
        return values.toArray();
    }
}
