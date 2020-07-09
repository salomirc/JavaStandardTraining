package com.belsoft.types;

public class Strings {

    public static void main(String[] args) {
        String message = "Hello world" + "!!";
        System.out.println(message);
        System.out.println(message.endsWith("!!"));
        System.out.println(message.startsWith("!!"));
        System.out.println(message.length());
        System.out.println(message.indexOf("H"));
        System.out.println(message.indexOf("world"));
        System.out.println(message.indexOf("sky"));
        System.out.println(message.replace("!", "*"));
        System.out.println(message.toLowerCase());
        System.out.println(message.toUpperCase());
        System.out.println(message);

        String whiteSpaceMesage = "  Hello world!   ";
        System.out.println(whiteSpaceMesage.trim());
        System.out.println(whiteSpaceMesage);

        String trimmedMessage = whiteSpaceMesage.trim();
        System.out.println(trimmedMessage + "(trimmed message)");
        System.out.println(whiteSpaceMesage + "(white space message)");

        //escape characters
        String escapeMessage = "Hello \"Mosh\"";
        System.out.println(escapeMessage);

        //C:\windows\...
        escapeMessage = "C:\\windows\\...";
        System.out.println(escapeMessage);

        escapeMessage = "Hello\n\"Mosh\"";
        System.out.println(escapeMessage);

        escapeMessage = "Hello\t\"Mosh\"";
        System.out.println(escapeMessage);


        String greeting = "Howdy";
        String person = "neighbor";
        String location = "neighborhood";
    }
}

