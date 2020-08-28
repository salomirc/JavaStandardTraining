package com.belsoft.projects.project_university_assignment_v3;

import java.util.*;
import java.util.stream.Collectors;

public class Course extends AcademicEntity {
    private final List<Student> students = new ArrayList<>();
    private Teacher teacher;

    public Course(String name) {
        super(name);
    }

    public void registerStudent(Student student, float mark) {
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
                .filter(student -> student
                        .getExams()
                        .stream()
                        .filter(exam -> exam.getCourse() == this)
                        .findAny()
                        .get()
                        .getMark() >= 5)
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
                .filter(student -> student
                        .getExams()
                        .stream()
                        .filter(exam -> exam.getCourse() == this)
                        .findAny()
                        .get()
                        .getMark() < 5)
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

    public void computeAverageGrade() {
        Float sum = students.stream()
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
        var avg = sum > 0 ? sum / students.size() : 0;
        System.out.println("Average grade of students attending " + this + " course = " + avg);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
