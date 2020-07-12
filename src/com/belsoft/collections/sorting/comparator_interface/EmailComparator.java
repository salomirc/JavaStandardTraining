package com.belsoft.collections.sorting.comparator_interface;

import com.belsoft.collections.sorting.comparable_interface.Customer;
import java.util.Comparator;

public class EmailComparator implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return o1.getEmail().compareTo(o2.getEmail());
    }
}
