package com.belsoft.project;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomDictionary {

    private final Map<String, String> names = new HashMap<>();
    private final Map<Integer, String> ports = new HashMap<>();
    private final Map<String, String> ips = new HashMap<>();

    public <K extends Integer, V extends String> void add(K key, V value) {
        if (Port.isValid(key)) {
            ports.put(key, value);
        }
        else {
            System.out.println(String.format("The input %1$s value is not a valid computer port.", key));
        }
    }

    public <K extends String, V extends String> void add(K key, V value) {
        if (IpAddressValidator.isValid(key)) {
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

    private <T> void printMap(T key, Map<?, ?> names) {
        System.out.println(key + " = " + names.get(key));
    }

    private <T> void safePrint(T key, Map<?, ?> map) {
        if (map.containsKey(key)) {
            printMap(key, map);
        }
        else {
            System.out.println(key + " is not a valid key.");
        }
    }

    public void print(int key) {
        safePrint(key, ports);
    }

    public void print(String key) {
        if (IpAddressValidator.isValid(key)) {
            safePrint(key, ips);
        }
        else {
            safePrint(key, names);
        }
    }
}
