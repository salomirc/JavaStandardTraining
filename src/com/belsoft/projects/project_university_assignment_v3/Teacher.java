package com.belsoft.projects.project_university_assignment_v3;

import java.util.*;
import java.util.stream.Collectors;

public class Teacher extends AcademicEntity {
    private final List<Course> courses = new ArrayList<>();

    public Teacher(String name) {
        super(name);
    }

    public void addCourse(Course course) {
        if (course == null) return;
        if (course.getTeacher() == null) {
            course.setTeacher(this);
            courses.add(course);
        } else System.out.println("Course " + course + " is already associated with " + course.getTeacher() + " teacher.");
    }

    public void removeCourse(Course course) {
        if (courses.contains(course)) {
            course.setTeacher(null);
            courses.remove(course);
        }
    }

    public void printAllCourses() {
        Map<String, Integer> collect = courses.stream()
                .collect(Collectors.toMap(AcademicEntity::getName, course -> course.getStudents().size()))
                .entrySet().stream()
                .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println("Teacher " + this  + " courses: " + collect);
    }

    public void printWorkBalance() {
        var totalHours = courses.size() * Constants.COURSE_TIME_SPAN_HOURS * Constants.WEEK_WORKING_DAYS;
        System.out.println("Teacher " + this + " hours/week balance : " + totalHours + " hours");
    }
}
