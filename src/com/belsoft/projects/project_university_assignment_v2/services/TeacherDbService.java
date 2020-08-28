package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.models.Teacher;
import com.belsoft.projects.project_university_assignment_v2.interfaces.ITeacherDbService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TeacherDbService extends DbServiceBase implements ITeacherDbService {

    public TeacherDbService(DataBase db) {
        super(db);
    }

    @Override
    public void addTeacher(Teacher... teacher) {
        Arrays.stream(teacher)
                .forEach(teacher1 -> addEntity(teacher1, db.getTeachers()));
    }

    @Override
    public Teacher getTeacher(int id) {
        return getEntity(id, db.getTeachers());
    }

    @Override
    public List<Teacher> getTeachers() {
        return new ArrayList<>(db.getTeachers());
    }

    @Override
    public void printAllTeachers() {
        printAllEntity(getTeachers());
    }
}
