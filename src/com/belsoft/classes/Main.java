package com.belsoft.classes;

public class Main {
    public static void main(String[] args) {
        var employee = new Employee(50_000);
//        var employee = new Employee(50_000, 20);
        Employee.printNumbersOfemployees();
        int wage = employee.calculateWage(15);
        System.out.println(wage);
    }
}
