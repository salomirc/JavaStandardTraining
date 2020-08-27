package com.belsoft.projects.project_university_assignment;

public class Main {
    public static void main(String[] args) {

        var teacherJohn = new Teacher("John");
        var teacherBill = new Teacher("Bill");

        var math = new Course("Math", teacherJohn);
        var algorithms = new Course("Algorithms", teacherJohn);
        var physics = new Course("Physics", teacherBill);

        var lucy = new Student("Lucy");
        lucy.attendExam(new Exam(math, 10f));
        lucy.attendExam(new Exam(algorithms, 9f));
        lucy.attendExam(new Exam(physics, 9.5f));
        lucy.attendExam(new Exam(physics, 9.5f));
        lucy.printAllCourses();
        System.out.println();

        algorithms.unregisterStudent(lucy);
        lucy.printAllCourses();
        lucy.printCredits();
        lucy.printScholarship();
        System.out.println();

        algorithms.registerStudent(lucy, 10f);
    }
}
