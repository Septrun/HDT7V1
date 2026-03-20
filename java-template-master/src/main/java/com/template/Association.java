package com.template;

public class Association<K extends Comparable<K>, V> implements Comparable<Association<K, V>> {
    private K key;
    private V value;

    public Association(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }

    @Override
    public int compareTo(Association<K, V> o) {
        return this.key.compareTo(o.getKey());
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}