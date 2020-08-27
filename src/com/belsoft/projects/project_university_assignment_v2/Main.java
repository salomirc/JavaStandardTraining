package com.belsoft.projects.project_university_assignment_v2;

import com.belsoft.projects.project_university_assignment_v2.models.Course;
import com.belsoft.projects.project_university_assignment_v2.models.Exam;
import com.belsoft.projects.project_university_assignment_v2.models.Student;
import com.belsoft.projects.project_university_assignment_v2.models.Teacher;
import com.belsoft.projects.project_university_assignment_v2.services.DbService;
import com.belsoft.projects.project_university_assignment_v2.interfaces.IDbService;

public class Main {
    public static void main(String[] args) {

        IDbService dbService = DbService.getInstance();

        var teacherJohn = new Teacher("John");
        var teacherMary = new Teacher("Mary");
        var teacherLucy = new Teacher("Lucy");

        var math = new Course("Math", teacherJohn.getId());
        var algorithms = new Course("Algorithms", teacherMary.getId());
        var physics = new Course("Physics", teacherLucy.getId());

        var studentBill = new Student("Bill");
        var studentSteve = new Student("Steve");
        var studentNick = new Student("Nick");

        dbService.getTeacherDbService().addTeacher(teacherJohn, teacherMary, teacherLucy);
        dbService.getCoursesDbService().addCourse(math, algorithms, physics);
        dbService.getStudentDbService().addStudent(studentBill, studentSteve, studentNick);

        dbService.getExamDbService().attendCourse(new Exam(7f, studentBill.getId(), math.getId(), math.getTeacherId()));
        dbService.getExamDbService().attendCourse(new Exam(9f, studentBill.getId(), algorithms.getId(), algorithms.getTeacherId()));
        dbService.getExamDbService().attendCourse(new Exam(7f, studentBill.getId(), physics.getId(), math.getTeacherId()));
        dbService.getExamDbService().attendCourse(new Exam(7f, studentSteve.getId(), math.getId(), math.getTeacherId()));

        dbService.getTeacherDbService().printAllTeachers();
        dbService.getCoursesDbService().printAllCourses();
        dbService.getStudentDbService().printAllStudents();
        dbService.getExamDbService().printAllExams();

        dbService.getExamDbService().unAttendCourse(math, studentBill);
        dbService.getExamDbService().printAllExams();
        dbService.getCoursesDbService().removeCourse(algorithms.getId());
        dbService.getCoursesDbService().printAllCourses();
        dbService.getExamDbService().attendCourse(new Exam(9f, studentNick.getId(), algorithms.getId(), algorithms.getTeacherId()));
        dbService.getStudentDbService().printAllAttendedCourses(studentBill);
    }
}
