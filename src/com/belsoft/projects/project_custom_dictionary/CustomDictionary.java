package com.belsoft.projects.project_custom_dictionary;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class CustomDictionary {

    private final Map<String, String> names = new HashMap<>();
    private final Map<String, String> ports = new HashMap<>();
    private final Map<String, String> ips = new HashMap<>();

    public void add(String key, String value) {
        if (PortValidator.isValid(key)) {
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

    private void printMap(String key, Map<String, String> names) {
        System.out.println(key + " = " + names.get(key));
    }

    private void safePrint(String key, Map<String, String> map) {
        if (map.containsKey(key)) {
            printMap(key, map);
        }
        else {
            System.out.println(key + " is not a valid key.");
        }
    }

    public void print(String key) {
        if (PortValidator.isValid(key)) {
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
