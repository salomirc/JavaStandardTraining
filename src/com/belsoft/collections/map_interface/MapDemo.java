package com.belsoft.collections.map_interface;

import com.belsoft.collections.sorting.comparable_interface.Customer;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void show() {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
//        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);
        map.put(c1.getEmail(), c1);

        var customer = map.get("e1");
        System.out.println(customer);

        customer = map.get("e10"); // return null
        System.out.println(customer);

        var unknown = new Customer("unknown", "empty");
        customer = map.getOrDefault("e10", unknown);
        System.out.println(customer);

        var exists = map.containsKey("e10");
        System.out.println(exists);

        map.replace("e1", new Customer("a++", "e1"));
        System.out.println(map);
        System.out.println();

        // iterate for key
        // the order is not guaranteed
        System.out.println("iterate for key");
        for (var key : map.keySet())
            System.out.println(key);
        System.out.println();

        // iterate for value
        // the order is not guaranteed
        System.out.println("iterate for value");
        for (var customers : map.values())
            System.out.println(customers);
        System.out.println();

        // iterate for key and/or value
        // the order is not guaranteed
        System.out.println("iterate for key and/or value");
        for (var entry : map.entrySet()){
            System.out.println(entry);
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
