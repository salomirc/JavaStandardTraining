package com.belsoft.interfaces;

public class Main {

    public static void main(String[] args) {

        //constructor dependency injection
        var calculator = new TaxCalculator2018(100_000);
        var report = new TaxReport(calculator);
        report.show();

        //setter dependency injection
        report.setCalculator(new TaxCalculator2019(200_000));
        report.show();

        //method dependency injection
        report.show(new TaxCalculator2020());
    }
}
