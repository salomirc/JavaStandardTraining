package com.belsoft.projects.project_university_assignment;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends AcademicEntity {
    private final List<Course> courses = new ArrayList<>();

    public Teacher(String name) {
        super(name);
    }

    public void addCourse(Course course) {
       courses.add(course);
    }

    public void removeCourse(Course course) {
        courses.remove(course);
    }

    public void printAllCourses() {

    }

    public void printWorkBalance() {

    }
}
