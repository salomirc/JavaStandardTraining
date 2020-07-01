package com.belsoft.types.project;

import java.text.NumberFormat;
import java.util.Scanner;

public class ProjectMortgageCalculator {

    public static void main(String[] args) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal: ");
        int principal = scanner.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualInterest = scanner.nextFloat();
        float montlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

        System.out.print("Period (Years): ");
        byte years = scanner.nextByte();
        int numberOfPayments = years * MONTHS_IN_YEAR;

        double mortgage = principal * (montlyInterest * (Math.pow(1 + montlyInterest, numberOfPayments))) /
                            ((Math.pow(1 + montlyInterest, numberOfPayments)) - 1);
        String mortgageFormated = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormated);
    }
}
