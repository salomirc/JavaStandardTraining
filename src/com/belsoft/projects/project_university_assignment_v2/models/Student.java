package com.belsoft.projects.project_university_assignment_v2.models;

public class Student extends AcademicEntity{
    private static int lastId;

    public Student(String name) {
        super(++lastId, name);
    }

    @Override
    public String toString() {
        return "Student : " + getName();
    }
}
