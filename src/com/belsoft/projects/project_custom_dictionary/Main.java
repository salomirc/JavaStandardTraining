package com.belsoft.projects.project_custom_dictionary;

public class Main {
    public static void main(String[] args) {

        var dictionary = new CustomDictionary();

        dictionary.add("500", "Port 100");
        dictionary.add("100", "Port 100");
        dictionary.add("0", "Port 0");
        dictionary.add("1", "Port 1");
        dictionary.add("200", "Port 100");
        dictionary.add("C", "Java developer.");
        dictionary.add("B", "Kotlin developer.");
        dictionary.add("A", "Python developer.");
        dictionary.add("100.168.0.1", "Router");
        dictionary.add("1.168.0.1", "Router");
        dictionary.add("255.128.0.10", "John Computer IP Address");
        dictionary.add("200.128.0.12", "Mary Computer IP Address");

        dictionary.printAll();

        dictionary.print("100");
        dictionary.print("-100");
        dictionary.print("Selena");
    }
}
