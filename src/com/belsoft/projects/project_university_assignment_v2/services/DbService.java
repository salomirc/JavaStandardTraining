package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.interfaces.*;

public class DbService implements IDbService {
    private static DbService instance;
    private final ITeacherDbService teacherDbService;
    private final ICourseDbService coursesDbService;
    private final IStudentDbService studentDbService;
    private final IExamDbService examDbService;

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

    public ITeacherDbService getTeacherDbService() {
        return teacherDbService;
    }

    public ICourseDbService getCoursesDbService() {
        return coursesDbService;
    }

    public IStudentDbService getStudentDbService() {
        return studentDbService;
    }

    public IExamDbService getExamDbService() {
        return examDbService;
    }
}
