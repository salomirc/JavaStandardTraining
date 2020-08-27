package com.belsoft.projects.project_university_assignment_v2.models;

public class AcademicEntity extends IdEntity {
    private final String name;

    public AcademicEntity(int id, String name) {
        super(id);
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
