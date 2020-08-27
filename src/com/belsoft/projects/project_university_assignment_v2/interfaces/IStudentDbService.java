package com.belsoft.projects.project_university_assignment_v2.interfaces;

import com.belsoft.projects.project_university_assignment_v2.models.Student;

import java.util.List;

public interface IStudentDbService {
    void addStudent(Student... student);
    Student getStudent(int id);
    List<Student> getStudents();
    void printAllStudents();
    void printAllAttendedCourses(Student student);
}
