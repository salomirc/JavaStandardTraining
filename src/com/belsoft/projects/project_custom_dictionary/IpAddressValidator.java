package com.belsoft.projects.project_custom_dictionary;

public class IpAddressValidator {
    private static final String zeroTo255
            = "([01]?[0-9]{1,2}|2[0-4][0-9]|25[0-5])";

    private static final String IP_REGEXP
            = zeroTo255 + "\\." + zeroTo255 + "\\."
            + zeroTo255 + "\\." + zeroTo255;

    // Return true when *address* is IP Address
    public static boolean isValid(String address) {
        return address.matches(IP_REGEXP);
    }
}
