package com.belsoft.refactoring_ood;

import java.text.NumberFormat;

public class MortgageReport {

    private final MortgageCalculator calculator;
    private final NumberFormat currencyInstance;

    public MortgageReport(MortgageCalculator calculator) {
        this.calculator = calculator;
        currencyInstance = NumberFormat.getCurrencyInstance();
    }

    public void printPaymentSchedule() {
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");

        for (var balance : calculator.getRemainingBalances())
            System.out.println(currencyInstance.format(balance));
    }

    public void printMortgage() {
        double mortgage = calculator.calculateMortgage();
        String mortgageFormated = currencyInstance.format(mortgage);
        System.out.println();
        System.out.println("MORTGAGE");
        System.out.println("--------");
        System.out.println("Monthly Payments: " + mortgageFormated);
    }
}
