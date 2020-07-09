package com.belsoft.generics.class_with_multiple_type_params;

public class KeyValuePair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }


}
