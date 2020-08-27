package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.models.Course;
import com.belsoft.projects.project_university_assignment_v2.models.Exam;
import com.belsoft.projects.project_university_assignment_v2.models.Student;
import com.belsoft.projects.project_university_assignment_v2.interfaces.IExamDbService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class ExamDbService extends DbServiceBase implements IExamDbService {

    public ExamDbService(DataBase db) {
        super(db);
    }

    @Override
    public boolean attendCourse(Exam exam) {
        AtomicBoolean isSuccessful = new AtomicBoolean(false);
        db.getExams().stream()
                .filter(exam1 -> (
                        exam1.getCourseId() == exam.getCourseId() &&
                                exam1.getStudentId() == exam.getStudentId())
                )
                .findAny()
                .ifPresentOrElse(
                        exam1 -> System.out.println("The course is already attended."),
                        () -> {
                            var attendedCourse = db.getCourses().stream()
                                    .filter(course -> course.getId() == exam.getCourseId())
                                    .findAny()
                                    .orElse(null);
                            if (attendedCourse != null && attendedCourse.isActive()) {
                                isSuccessful.set(db.getExams().add(exam));
                            } else System.out.println("The course you are trying to attend in not active.");
                        });
        return isSuccessful.get();
    }

    @Override
    public boolean unAttendCourse(Course course, Student student) {
        AtomicBoolean isSuccessful = new AtomicBoolean(false);
        db.getExams().stream()
                .filter(exam ->
                        (exam.getCourseId() == course.getId()) &&
                                (exam.getStudentId() == student.getId())
                )
                .findAny()
                .ifPresent(
                        exam -> isSuccessful.set(db.getExams().remove(exam))
                );
        return isSuccessful.get();
    }

    @Override
    public Exam getExam(int id) {
        return getEntity(id, db.getExams());
    }

    @Override
    public boolean removeExam(int examId) {
        AtomicBoolean isSuccessful = new AtomicBoolean(false);
        db.getExams().stream()
                .filter(exam -> exam.getId() == examId)
                .findAny()
                .ifPresent(
                        exam -> isSuccessful.set(db.getExams().remove(exam))
                );
        return isSuccessful.get();
    }

    @Override
    public List<Exam> getExams() {
        return new ArrayList<>(db.getExams());
    }

    public void printAllExams() {
        var exams = getExams();
        exams.forEach(
                exam -> {
                    var mark = exam.getMark();
                    var studentName = DbService.getInstance().getStudentDbService().getStudent(exam.getStudentId()).getName();
                    var courseName = DbService.getInstance().getCoursesDbService().getCourse(exam.getCourseId()).getName();
                    var teacherName = DbService.getInstance().getTeacherDbService().getTeacher(exam.getTeacherId()).getName();

                    System.out.println("Exam -> Course : " + courseName + ", Mark : " + mark + ", Student : " + studentName + ", Teacher : " + teacherName);
                }
        );
        System.out.println();
    }
}
