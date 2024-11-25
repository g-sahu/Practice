package com.practice.datastructures.maps;

import com.practice.datastructures.linkedlists.DoublyLinkedList;

import java.util.HashMap;
import java.util.Map;

import static com.practice.datastructures.linkedlists.DoublyLinkedList.Node;

class LRUCache {
    private final Map<Integer, Node> keys;
    private final DoublyLinkedList values;
    private final int cacheSize;

    LRUCache(int cacheSize) {
        values = new DoublyLinkedList();
        keys = new HashMap<>();
        this.cacheSize = cacheSize;
    }

    public void add(int key, int value) {
        if(keys.isEmpty()) {
            values.add(value);
            keys.put(key, values.getNode(value));
        } else if (keys.containsKey(key)) {
            values.remove(keys.get(key));
            values.add(value);
        } else if (keys.size() < cacheSize) {
            values.add(value);
            keys.put(key, values.getNode(value));
        } else {
            keys.remove(values.getFirst());
            values.removeFirst();
            values.add(value);
            keys.put(key, values.getNode(value));
        }
    }

    public Integer get(Integer key) {
        int value = keys.get(key).getData();

        if(keys.containsKey(key)) {
            values.remove(keys.get(key));
            values.add(value);
            return value;
        }

        return null;
    }

    public Object[] getAll() {
        return values.toArray();
    }
}
