package com.belsoft.classes;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public static int numberOfEmployees;


    public Employee(int baseSalary, int hourlyRate){
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
        numberOfEmployees++;
    }

    //reusing the code in the first constructor
    public Employee(int baseSalary){
        this(baseSalary, 0);
    }

    //second constructor but without reusing the code in the first one
//    public Employee(int baseSalary){
//        setBaseSalary(baseSalary);
//        setHourlyRate(0);
//    }

    public static void printNumbersOfemployees() {
        System.out.println(numberOfEmployees);
    }

    private int getBaseSalary() {
        return baseSalary;
    }

    private void setBaseSalary(int baseSalary) {
        if (baseSalary <= 0)
            throw new IllegalArgumentException("Salary cannot be 0 or less.");
        this.baseSalary = baseSalary;
    }

    private int getHourlyRate() {
        return hourlyRate;
    }

    private void setHourlyRate(int hourlyRate) {
        if (hourlyRate < 0)
            throw new IllegalArgumentException("Hourly rate cannot be 0 or less.");
        this.hourlyRate = hourlyRate;
    }

    public int calculateWage(int extraHours) {
        return baseSalary + (hourlyRate * extraHours);
    }

    //method overloading
    //unfortunately NO default value for method parameters in JAVA !!!
    public int calculateWage() {
        return baseSalary;
    }
}
