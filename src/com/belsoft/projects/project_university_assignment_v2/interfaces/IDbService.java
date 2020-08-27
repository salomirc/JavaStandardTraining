package com.belsoft.projects.project_university_assignment_v2.interfaces;

public interface IDbService {
    ITeacherDbService getTeacherDbService();
    ICourseDbService getCoursesDbService();
    IStudentDbService getStudentDbService();
    IExamDbService getExamDbService();
}
