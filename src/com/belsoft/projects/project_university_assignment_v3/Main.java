package com.belsoft.projects.project_university_assignment_v3;

public class Main {
    public static void main(String[] args) {

        var teacherBill = new Teacher("Bill");

        var math = new Course("Math");
        var algorithms = new Course("Algorithms");
        var physics = new Course("Physics");

        var studentLucy = new Student("Lucy");
        var studentSteve = new Student("Steve");
        var studentJim = new Student("Jim");
        var studentRoy = new Student("Roy");
        var studentKim = new Student("Kim");
        var studentAlessia = new Student("Alessia");

        teacherBill.addCourse(math);
        math.registerStudent(studentLucy, 7f);
        math.registerStudent(studentSteve, 10f);
        math.registerStudent(studentJim, 9.5f);
        math.registerStudent(studentRoy, 3f);
        math.registerStudent(studentKim, 4f);
        math.registerStudent(studentAlessia, 5f);

        teacherBill.addCourse(algorithms);
        algorithms.registerStudent(studentLucy, 9.5f);
        algorithms.registerStudent(studentSteve, 8f);
        algorithms.registerStudent(studentJim, 10f);

        teacherBill.addCourse(physics);
        physics.registerStudent(studentLucy, 9.5f);
        physics.registerStudent(studentSteve, 8f);
        physics.registerStudent(studentJim, 10f);

        studentLucy.printAllCourses();
        studentLucy.printCredits();
        studentLucy.printScholarship();
        System.out.println();

        physics.unregisterStudent(studentLucy);
        studentLucy.printAllCourses();
        studentLucy.printCredits();
        studentLucy.printScholarship();
        System.out.println();

        teacherBill.removeCourse(physics);
        algorithms.printAllStudents();
        algorithms.unregisterStudent(studentSteve);
        algorithms.printAllStudents();

        math.printAllPassingGradeStudents();
        math.printAllFailingGradeStudents();
        math.computeAverageGrade();
        math.computeStatistics();

        teacherBill.printAllCourses();
        teacherBill.printWorkBalance();
    }
}
