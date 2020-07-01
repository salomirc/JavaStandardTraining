package com.belsoft.types;

import java.text.NumberFormat;
import java.util.Locale;

public class FormattingNumbers {

    public static void main(String[] args) {

        NumberFormat currency = NumberFormat.getCurrencyInstance();
        currency = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("ro-RO"));
        String result = currency.format(1234567.891);
        System.out.println(result);

        NumberFormat percent = NumberFormat.getPercentInstance();
        result = percent.format(0.1);
        System.out.println(result);

        //Shorter version through method chaining
        result = NumberFormat.getPercentInstance().format(0.1);
        System.out.println(result);
    }
}
