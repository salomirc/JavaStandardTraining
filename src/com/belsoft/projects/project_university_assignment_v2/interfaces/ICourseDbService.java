package com.belsoft.projects.project_university_assignment_v2.interfaces;

import com.belsoft.projects.project_university_assignment_v2.models.Course;

import java.util.List;

public interface ICourseDbService {
    void addCourse(Course... course);
    boolean removeCourse(int courseId);
    Course getCourse(int Id);
    List<Course> getCourses();
    void printAllCourses();
}
