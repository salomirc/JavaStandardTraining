package com.belsoft.projects.project_university_assignment_v2.interfaces;

import com.belsoft.projects.project_university_assignment_v2.services.CoursesDbService;
import com.belsoft.projects.project_university_assignment_v2.services.ExamDbService;
import com.belsoft.projects.project_university_assignment_v2.services.StudentDbService;
import com.belsoft.projects.project_university_assignment_v2.services.TeacherDbService;

public interface IDbService {
    TeacherDbService getTeacherDbService();
    CoursesDbService getCoursesDbService();
    StudentDbService getStudentDbService();
    ExamDbService getExamDbService();
}
