package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.models.Course;
import com.belsoft.projects.project_university_assignment_v2.interfaces.ICourseDbService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class CoursesDbService extends DbServiceBase implements ICourseDbService {

    public CoursesDbService(DataBase db) {
        super(db);
    }

    @Override
    public void addCourse(Course... course) {
        Arrays.stream(course)
                .forEach(course1 -> addEntity(course1, db.getCourses()));
    }

    @Override
    public boolean removeCourse(int courseId) {
        AtomicBoolean isSuccessful = new AtomicBoolean(false);
        db.getCourses().stream()
                .filter(course -> course.getId() == courseId)
                .findAny()
                .ifPresent(
                        course -> {
                            course.setActive(false);
                            isSuccessful.set(true);
                        }
                );
        return isSuccessful.get();
    }

    @Override
    public Course getCourse(int id) {
        return getEntity(id, db.getCourses());
    }

    @Override
    public List<Course> getCourses() {
        return  new ArrayList<>(db.getCourses());
    }

    @Override
    public void printAllCourses() {
        printAllEntity(getCourses());
    }
}
