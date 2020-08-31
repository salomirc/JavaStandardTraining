package com.belsoft.projects.project_university_assignment_v3;

public class Exam {
    private final Course course;
    private final float mark;
    private final Student student;

    public Exam(Course course, float mark, Student student) {
        this.course = course;
        this.mark = mark;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course: " + course.getName() + ", Mark: " + mark + ", Student: " + student;
    }

    public Course getCourse() {
        return course;
    }

    public float getMark() {
        return mark;
    }

    public Student getStudent() {
        return student;
    }
}
