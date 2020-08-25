package com.belsoft.projects.project_custom_dictionary_v2;

public class User {
    private final String name;
    private final String description;

    public User(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}
