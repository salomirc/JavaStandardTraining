package com.belsoft.interfaces;

public class TaxReport {
    private TaxCalculator calculator;

    public TaxReport(TaxCalculator calculator) {
        this.calculator = calculator;
    }

    public void show() {
        var tax = calculator.calculateTax();
        System.out.println("The tax amount is : " + tax);
    }

    public void show(TaxCalculator calculator) {
        var tax = calculator.calculateTax();
        System.out.println("The tax amount is : " + tax);
    }

    public void setCalculator(TaxCalculator calculator) {
        this.calculator = calculator;
    }
}
