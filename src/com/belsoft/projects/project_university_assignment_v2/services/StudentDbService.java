package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.models.AcademicEntity;
import com.belsoft.projects.project_university_assignment_v2.models.Exam;
import com.belsoft.projects.project_university_assignment_v2.models.Student;
import com.belsoft.projects.project_university_assignment_v2.interfaces.IStudentDbService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentDbService extends DbServiceBase implements IStudentDbService {

    public StudentDbService(DataBase db) {
        super(db);
    }

    @Override
    public void addStudent(Student... student) {
        Arrays.stream(student)
                .forEach(student1 -> addEntity(student1, db.getStudents()));
    }

    @Override
    public Student getStudent(int id) {
        return getEntity(id, db.getStudents());
    }

    @Override
    public List<Student> getStudents() {
        return new ArrayList<>(db.getStudents());
    }

    @Override
    public void printAllStudents() {
        printAllEntity(getStudents());
    }

    @Override
    public void printAllAttendedCourses(Student student) {
        var ids = db.getExams().stream()
                .filter(exam -> exam.getStudentId() == student.getId())
                .map(Exam::getCourseId)
                .collect(Collectors.toList());
        String collect = db.getCourses()
                .stream()
                .filter(course -> ids.contains(course.getId()))
                .sorted(Comparator.comparing(AcademicEntity::getName))
                .map(AcademicEntity::getName)
                .collect(Collectors.joining(", "));
        System.out.println("Student " + student.getName() +  " attended courses : " + collect + "\n");
    }

}
