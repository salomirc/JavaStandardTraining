package com.belsoft.projects.project_university_assignment_v2.models;

public class Exam extends IdEntity {
    private static int lastId;
    private final int studentId;
    private final int courseId;
    private final float mark;
    private final int teacherId;

    public Exam(float mark, int studentId, int courseId, int teacherId) {
        super(++lastId);
        this.mark = mark;
        this.studentId = studentId;
        this.courseId = courseId;
        this.teacherId = teacherId;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public float getMark() {
        return mark;
    }

    public int getTeacherId() {
        return teacherId;
    }
}
