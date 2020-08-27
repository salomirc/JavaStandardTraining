package com.belsoft.projects.project_university_assignment_v2.interfaces;

import com.belsoft.projects.project_university_assignment_v2.models.Course;
import com.belsoft.projects.project_university_assignment_v2.models.Exam;
import com.belsoft.projects.project_university_assignment_v2.models.Student;

import java.util.List;

public interface IExamDbService {
     boolean attendCourse(Exam exam);
     boolean unAttendCourse(Course course, Student student);
     Exam getExam(int id);
     boolean removeExam(int examId);
     List<Exam> getExams();
     void printAllExams();
}
