package com.belsoft.projects.project_university_assignment_v3;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends AcademicEntity {
    private final List<Course> courses = new ArrayList<>();

    public Teacher(String name) {
        super(name);
    }

    public void addCourse(Course course) {
        if (course.getTeacher() == null) {
            course.setTeacher(this);
            courses.add(course);
        } else System.out.println("Course " + course + " is already associated with " + course.getTeacher() + " teacher.");
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            course.setTeacher(null);
            courses.remove(course);
        }
    }

    public void printAllCourses() {

    }

    public void printWorkBalance() {

    }
}
