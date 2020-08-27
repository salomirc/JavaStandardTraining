package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.models.*;

import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private final List<Teacher> teachers = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final List<Student> students = new ArrayList<>();
    private final List<Exam> exams = new ArrayList<>();

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Exam> getExams() {
        return exams;
    }
}
