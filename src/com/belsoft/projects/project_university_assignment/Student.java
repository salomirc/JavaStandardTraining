package com.belsoft.projects.project_university_assignment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Student extends AcademicEntity {
    private final List<Exam> exams = new ArrayList<>();

    public Student(String name) {
        super(name);
    }

    private float computeGrade() {
        var sum = exams.stream()
                .map(Exam::getMark)
                .reduce(0f, Float::sum);
        return sum > 0 ? sum / exams.size() : 0;
    }

    private boolean hasScholarship() {
        return computeGrade() > 9;
    }

    private int computeScholarship() {
        return hasScholarship() ? (int)(computeGrade() * 100) : 0;
    }

    public void attendExam(Exam exam) {
        exams.stream()
                .filter(exam1 -> exam1.getCourse().getName().equals(exam.getCourse().getName()))
                .findAny()
                .ifPresentOrElse(
                        exam1 -> { },
                        () -> {
                            exams.add(exam);
                            exam.getCourse().registerStudent(this, exam.getMark());
                        });
    }

    public void removeExam(Course course) {
        exams.stream()
                .filter(ex -> ex.getCourse() == course)
                .findAny().ifPresent(exams::remove);
    }

    public void printAllCourses() {
        exams.stream()
                .map(Exam::getCourse)
                .sorted(Comparator.comparing(AcademicEntity::getName))
                .forEach(System.out::println);
    }

    public void printCredits() {
        var credits = (int)(computeGrade() * Exam.CREDIT_MULTIPLIER);
        System.out.println("Credits = " + credits);
    }

    public void printScholarship() {
        System.out.println("Scholarship amount: " + computeScholarship());
    }
}
