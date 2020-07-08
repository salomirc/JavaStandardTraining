package com.belsoft.exceptions;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TryCatchFinally {
    public static void tryCatchFinally() {
        FileReader reader = null;
        try {
            reader = new FileReader("file.txt");
            var value = reader.read();
        }
        catch (IOException e) {
            System.out.println("Could not read data.");
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void tryWithResources() {
        try (
                var reader = new FileReader("file.txt");
                var writer = new FileWriter("file.txt")
        ) {
            var value = reader.read();
        }
        catch (IOException e) {
            System.out.println("Could not read data.");
        }
    }
}
