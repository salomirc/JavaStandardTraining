package com.belsoft.collections.sorting.comparator_interface;

import com.belsoft.collections.sorting.comparable_interface.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("b", "e3"));
        customers.add(new Customer("a", "e2"));
        customers.add(new Customer("c", "e1"));
        System.out.println(customers);

//        Collections.sort(customers, new EmailComparator());
        customers.sort(new EmailComparator());
        System.out.println(customers);
    }
}
