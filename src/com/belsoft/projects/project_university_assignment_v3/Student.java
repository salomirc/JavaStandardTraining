package com.belsoft.projects.project_university_assignment_v3;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Student extends AcademicEntity {
    private final List<Exam> exams = new ArrayList<>();

    public Student(String name) {
        super(name);
    }

    public void attendExam(Exam exam) {
        exams.add(exam);
    }

    public void removeExam(Course course) {
        exams.stream()
                .filter(exam -> exam.getCourse() == course)
                .findAny()
                .ifPresent(exams::remove);
    }

    public void printAllCourses() {
        String collect = exams.stream()
                .map(Exam::getCourse)
                .sorted(Comparator.comparing(AcademicEntity::getName))
                .map(AcademicEntity::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Student " + this + " attended courses: " + collect);
    }

    public void printCredits() {
        var credits = (int)(computeGrade() * Constants.EXAM_CREDIT_MULTIPLIER);
        System.out.println("Credits = " + credits);
    }

    public void printScholarship() {
        System.out.println("Scholarship amount: " + computeScholarship());
    }

    private float computeGrade() {
        var sum = exams.stream()
                .map(Exam::getMark)
                .reduce(0f, Float::sum);
        return exams.isEmpty() ? 0 : sum / exams.size();
    }

    private boolean hasScholarship() {
        return computeGrade() > 9;
    }

    private int computeScholarship() {
        return hasScholarship() ? (int)(computeGrade() * Constants.SCHOLARSHIP_MULTIPLIER) : 0;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
