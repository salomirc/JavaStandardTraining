package com.belsoft.types;

public class StringConcatenation {
    public static void main(String[] args) {

        String greeting = "Howdy";
        String person = "neighbor";
        String location = "neighborhood";

        // The + Operator
        String plusConcat = greeting + " " + person + "! Welcome to the " + location + "!";
        System.out.println(plusConcat);

        // String.format()
        String stringFormatConcat = String.format("%s %s! Welcome to the %s!", greeting, person, location);
        System.out.println(stringFormatConcat);

        // String.format() with (optional) argument_index$
        // %[argument_index$][flags][width][.precision]conversion
        String concatenated = String.format(
                "%1$s %2$s! Welcome to the %3$s!",
                /*1*/ greeting,
                /*2*/ person,
                /*3*/ location
        );
        System.out.println(concatenated);

        // StringBuilder
        String stringBuilderConcat = new StringBuilder()
                .append(greeting)
                .append(" ")
                .append(person)
                .append("! Welcome to the ")
                .append(location)
                .append("!")
                .toString();
        System.out.println(stringBuilderConcat);
    }
}
