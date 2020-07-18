package com.belsoft.project;

public class Port {
    public static final int MAX_PORT_VALUE = 65535;

    // Return true when *port* is valid port
    public static boolean isValid(String port) {
        int numericPort;
        try {
            numericPort = Integer.parseInt(port);
            return ((numericPort >= 0) && (numericPort <= MAX_PORT_VALUE));
        }
        catch (NumberFormatException ignored) {
            
        }
        return false;
    }
}
