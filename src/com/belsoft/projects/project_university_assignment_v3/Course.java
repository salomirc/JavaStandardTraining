package com.belsoft.projects.project_university_assignment_v3;

import java.text.NumberFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Course extends AcademicEntity {
    private final List<Student> students = new ArrayList<>();

    private Teacher teacher;
    public Course(String name) {
        super(name);
    }

    public void registerStudent(Student student, float mark) {
        if (student == null) return;
        students.stream()
                .filter(student1 -> student1 == student)
                .findAny()
                .ifPresentOrElse(
                        student1 -> System.out.println("Student is already registered for this curse."),
                        () -> {
                            student.attendExam(new Exam(this, mark, student));
                            students.add(student);
                        }
                );
    }

    public void unregisterStudent(Student student) {
        students.stream()
                .filter(student1 -> student1 == student)
                .findAny()
                .ifPresent(student1 -> {
                    student1.removeExam(this);
                    students.remove(student1);
                });
    }

    public void printAllStudents() {
        String collect = students.stream()
                .sorted(Comparator.comparing(AcademicEntity::getName))
                .map(AcademicEntity::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Students attending the " + this  + " course: " + collect);
    }

    public void printAllPassingGradeStudents() {
        var collect = students.stream()
                .filter(this::passingExamPredicate)
                .collect(Collectors.toMap(AcademicEntity::getName, student -> student.getExams().stream()
                        .filter(exam -> exam.getMark() >= 5)
                        .findAny()
                        .get()
                        .getMark()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Students passing the " + this  + " course: " + collect);
    }

    public void printAllFailingGradeStudents() {
        var collect = students.stream()
                .filter(this::failingExamPredicate)
                .collect(Collectors.toMap(AcademicEntity::getName, student -> student.getExams().stream()
                        .filter(exam -> exam.getMark() < 5)
                        .findAny()
                        .get()
                        .getMark()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("Students failing the " + this  + " course: " + collect);
    }

    private float getMarkFromStudent(Student student) {
        return getCurrentCourseExam(student).getMark();
    }

    private boolean passingExamPredicate(Student student) {
        return getMarkFromStudent(student) >= 5;
    }

    private boolean failingExamPredicate(Student student) {
        return getMarkFromStudent(student) < 5;
    }

    private boolean lowPerformerPredicate(Student student) {
        var mark = getMarkFromStudent(student);
        return (mark >= 5 && mark <= 7.5);
    }

    private boolean mediumPerformerPredicate(Student student) {
        var mark = getMarkFromStudent(student);
        return (mark > 7.5 && mark <= 9.5);
    }

    private boolean goodPerformerPredicate(Student student) {
        return getMarkFromStudent(student) > 9.5;
    }

    private Exam getCurrentCourseExam(Student student) {
        return student
                .getExams()
                .stream()
                .filter(exam -> exam.getCourse() == this)
                .findAny()
                .get();
    }

    public void computeAverageGrade() {
        if (students.isEmpty()) {
            printNoStudentsAttending();
            return;
        }
        var sum = students.stream()
                .map(student -> student
                        .getExams()
                        .stream()
                        .filter(exam -> exam.getCourse() == this)
                        .findFirst()
                        .get()
                        .getMark()
                )
                .peek(mark -> System.out.print(mark + ", "))
                .reduce(0f, Float::sum);
        var avg = sum / students.size();
        System.out.println("Average grade of students attending " + this + " course = " + avg);
    }

    private void printNoStudentsAttending() {
        System.out.println("No students are attending this course.");
    }

    public void computeStatistics() {
        if (students.size() == 0) {
            printNoStudentsAttending();
            return;
        }
        var passingStudents = students.stream()
                .filter(this::passingExamPredicate)
                .count();
        var lowPerformers = students.stream()
                .filter(this::lowPerformerPredicate)
                .count();
        var mediumPerformers = students.stream()
                .filter(this::mediumPerformerPredicate)
                .count();
        var goodPerformers = students.stream()
                .filter(this::goodPerformerPredicate)
                .count();
        var allStudents = (long) students.size();

        var passing = computePercent(passingStudents, allStudents);
        var low = computePercent(lowPerformers, allStudents);
        var medium = computePercent(mediumPerformers, allStudents);
        var good = computePercent(goodPerformers, allStudents);

        System.out.println("Students with grades over 5 : " + passing + ", between 5 and 7.5 : " + low +
                ", between 7.5 and 9.5 : " + medium + ", over 9.5 : " + good);
    }

    private String computePercent(Long count, Long totalNumber) {
        var percent = count / (float)totalNumber;
        return NumberFormat.getPercentInstance().format(percent);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}
