package com.belsoft.projects.project_university_assignment;

public class AcademicEntity {
    private final String name;

    public AcademicEntity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }
}
