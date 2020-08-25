package com.belsoft.projects.project_custom_dictionary_v2;

public class Application {
    private final String port;
    private final String description;


    public Application(String port, String description) {
        this.port = port;
        this.description = description;
    }


    public String getPort() {
        return port;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
