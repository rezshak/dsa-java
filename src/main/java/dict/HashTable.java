package main.java.dict;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class HashTable {
    static final int INITIAL_CAPACITY = 20;
    class Entry {
        final int key;
        String value;
        Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString() {
            return key + " -> " + value;
        }
    }

    List<LinkedList<Entry>> table;

    HashTable() {
        this(INITIAL_CAPACITY);
    }

    HashTable(int capacity) {
        table = new ArrayList<>(capacity);
        for (int i = 0; i < capacity; i++) {
            table.add(new LinkedList<Entry>());
        }
    }

    void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        getBucket(key).addLast(new Entry(key, value));
    }

    String get(int key) {
        Entry entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    void remove(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        for (Entry entry : bucket) {
            if (entry.key == key) bucket.remove(entry);
        }
    }

    private LinkedList<Entry> getBucket(int key) {
        return table.get(hash(key));
    }
    
    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        for (Entry entry : bucket) {
            if (entry.key == key) return entry;
        }
        return null;
    }

    private int hash(int key) {
        return Math.abs(key) % table.size();
    }

    void print() {
        System.out.println(table);
    }

}
