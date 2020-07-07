package com.belsoft.interfaces;

public interface TaxCalculator {
    // this is a field in Java interfaces (avoid this!)
    // keep in mind that it is public static final - can not be change
    int minTax = 100;

    // this is a static method in Java interfaces (avoid this!)
    static double getTaxableIncome(double income, double expenses) {
        return calculateTaxableIncome(income, expenses);
    }

    // this is a private method in Java interfaces (avoid this!)
    private static double calculateTaxableIncome(double income, double expenses) {
        return income - expenses;
    }

    // Why the above features are bad ideas in an interface ?
    // - interfaces are "contracts" they should not have code, no implementation !
    // - interfaces are about "what" to implement not "how" to implement
    // - they represent implementation details - should not be visible -> OOP abstraction principle !
    // - can easily break the contract with the classes that implement the interface
    // if the value/implementation changes -> dependent classes need to be recompiled and redeployed.
    // - this can be used as a hack to achieve multiple inheritance but interfaces
    // should not be confused with classes

    double calculateTax();
}
