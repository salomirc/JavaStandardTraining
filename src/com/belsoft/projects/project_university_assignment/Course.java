package com.belsoft.projects.project_university_assignment;

import java.util.ArrayList;
import java.util.List;

public class Course extends AcademicEntity {
    private static int lastId;
    private final Teacher teacher;
    private final List<Student> students = new ArrayList<>();

    public Course(String name, Teacher teacher) {
        super(name);
        this.teacher = teacher;
    }

    public void registerStudent(Student student, float mark) {
        students.stream()
                .filter(student1 -> student1 == student)
                .findAny()
                .ifPresentOrElse(
                        student1 -> { },
                        () -> {
                            students.add(student);
                            student.attendExam(new Exam(this, mark));

                        }
                );
    }

    public void unregisterStudent(Student student) {
        students.stream()
                .filter(s -> s == student)
                .findAny()
                .ifPresent(s -> {
                    s.removeExam(this);
                    students.remove(s);
                });
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
