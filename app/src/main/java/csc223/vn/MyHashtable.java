package csc223.vn;
import java.util.ArrayList;

public class MyHashTable {
    private class Entry {
        String key;
        Integer value;

        Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private ArrayList<Entry>[] buckets;
    private int capacity;
    private int size;

    public MyHashTable() {
        capacity = 10;
        buckets = new ArrayList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new ArrayList<Entry>();
        }
        size = 0;
    }

    public void put(String key, Integer value) {
        int index = Math.abs(key.hashCode()) % capacity;
        ArrayList<Entry> bucket = buckets[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }

        Entry newEntry = new Entry(key, value);
        bucket.add(newEntry);
        size = size + 1;
    }

    public Integer get(String key) {
        int index = Math.abs(key.hashCode()) % capacity;
        ArrayList<Entry> bucket = buckets[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(String key) {
        int index = Math.abs(key.hashCode()) % capacity;
        ArrayList<Entry> bucket = buckets[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if (entry.key.equals(key)) {
                bucket.remove(i);
                size = size - 1;
                return;
            }
        }
    }

    public boolean containsKey(String key) {
        int index = Math.abs(key.hashCode()) % capacity;
        ArrayList<Entry> bucket = buckets[index];

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);
            if (entry.key.equals(key)) {
                return true;
            }
        }

        return false;
    }

    public int size() {
        return size;
    }
}


