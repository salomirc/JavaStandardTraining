package com.belsoft.projects.project_university_assignment_v2.models;

public class Teacher extends AcademicEntity{
    private static int lastId;

    public Teacher(String name) {
        super(++lastId, name);
    }

    @Override
    public String toString() {
        return "Teacher : " + getName();
    }
}
