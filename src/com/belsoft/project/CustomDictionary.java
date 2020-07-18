package com.belsoft.project;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomDictionary<K extends  String, V extends String> {

    private final Map<K, V> names = new HashMap<>();
    private final Map<K, V> ports = new HashMap<>();
    private final Map<K, V> ips = new HashMap<>();

    public void add(K key, V value) {
        if (Port.isValid(key)) {
            ports.put(key, value);
        }
        else if (IpAddressValidator.isValid(key)) {
            ips.put(key, value);
        }
        else {
            names.put(key, value);
        }
    }

    public void printAll() {
        names.keySet().stream()
                .sorted()
                .forEach(key -> printMap(key, names));

        ports.keySet().stream()
                .sorted(Comparator.reverseOrder())
                .forEach(key -> printMap(key, ports));

        ips.keySet().stream()
                .sorted()
                .forEach(key -> printMap(key, ips));
        System.out.println();
    }

    private void printMap(K key, Map<K, V> names) {
        System.out.println(key + " = " + names.get(key));
    }

    private void safePrint(K key, Map<K, V> map) {
        if (map.containsKey(key)) {
            printMap(key, map);
        }
        else {
            System.out.println(key + " is not a valid key.");
        }
    }

    public void print(K key) {
        if (Port.isValid(key)) {
            safePrint(key, ports);
        }
        else if (IpAddressValidator.isValid(key)) {
            safePrint(key, ips);
        }
        else {
            safePrint(key, names);
        }
    }
}
