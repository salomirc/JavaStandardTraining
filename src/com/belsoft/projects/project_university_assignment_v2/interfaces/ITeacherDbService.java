package com.belsoft.projects.project_university_assignment_v2.interfaces;

import com.belsoft.projects.project_university_assignment_v2.models.Teacher;

import java.util.List;

public interface ITeacherDbService {
    void addTeacher(Teacher... teacher);
    Teacher getTeacher(int id);
    List<Teacher> getTeachers();
    void printAllTeachers();
}
