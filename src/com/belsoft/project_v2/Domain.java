package com.belsoft.project_v2;

public class Domain {
    private final String ip;
    private final String name;


    public Domain(String ip, String domain) {
        this.ip = ip;
        this.name = domain;
    }

    public String getIp() {
        return ip;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
