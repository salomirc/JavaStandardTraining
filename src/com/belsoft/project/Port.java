package com.belsoft.project;

public class Port {
    public static final int MAX_PORT_VALUE = 65535;

    // Return true when *address* is IP Address
    public static boolean isValid(int port) {
        return ((port >= 0) && (port <= MAX_PORT_VALUE));
    }
}
