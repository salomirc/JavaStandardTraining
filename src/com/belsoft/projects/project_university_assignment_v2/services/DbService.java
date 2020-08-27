package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.interfaces.IDbService;

public class DbService implements IDbService {
    private static DbService instance;
    private final TeacherDbService teacherDbService;
    private final CoursesDbService coursesDbService;
    private final StudentDbService studentDbService;
    private final ExamDbService examDbService;

    private DbService() {
        DataBase db = new DataBase();
        teacherDbService = new TeacherDbService(db);
        coursesDbService = new CoursesDbService(db);
        studentDbService = new StudentDbService(db);
        examDbService = new ExamDbService(db);
    }

    public static DbService getInstance() {
        if (instance == null) instance = new DbService();
        return instance;
    }

    public TeacherDbService getTeacherDbService() {
        return teacherDbService;
    }

    public CoursesDbService getCoursesDbService() {
        return coursesDbService;
    }

    public StudentDbService getStudentDbService() {
        return studentDbService;
    }

    public ExamDbService getExamDbService() {
        return examDbService;
    }
}
