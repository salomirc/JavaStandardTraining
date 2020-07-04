package com.belsoft.refactoring_ood;

public class MortgageCalculator {
    private static final byte MONTHS_IN_YEAR = 12;
    private static final byte PERCENT = 100;

    private final int principal;
    private final float annualInterest;
    private final byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years) {
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(
            short numnbersOfPaymentsMade
    ){
        float montlyInterest = getMontlyInterest();
        short numberOfPayments = getNumberOfPayments();
        return principal * (Math.pow(1 + montlyInterest, numberOfPayments) - Math.pow(1 + montlyInterest, numnbersOfPaymentsMade))
                / (Math.pow(1 + montlyInterest, numberOfPayments) - 1);
    }

    public double calculateMortgage() {
        float montlyInterest = getMontlyInterest();
        short numberOfPayments = getNumberOfPayments();

        return principal * (montlyInterest * (Math.pow(1 + montlyInterest, numberOfPayments))) /
                ((Math.pow(1 + montlyInterest, numberOfPayments)) - 1);
    }

    public double[] getRemainingBalances(){
        var balances = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++) {
            balances[month - 1] = calculateBalance(month);
        }
        return balances;
    }

    private float getMontlyInterest() {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }

    private short getNumberOfPayments() {
        return (short) (years * MONTHS_IN_YEAR);
    }
}
