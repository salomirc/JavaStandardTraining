package com.belsoft.projects.project_university_assignment;

public class Exam {
    public static final short CREDIT_MULTIPLIER = 10;
    private final Course course;
    private final float mark;

    public Exam(Course course, float mark) {
        this.course = course;
        this.mark = mark;
    }

    public Course getCourse() {
        return course;
    }

    public float getMark() {
        return mark;
    }
}
