package com.belsoft.projects.project_university_assignment_v2.models;

public class Course extends AcademicEntity{
    private static int lastId;
    private final int teacherId;
    private boolean isActive;

    public Course(String name, int teacherId) {
        super(++lastId, name);
        this.teacherId = teacherId;
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "Course : " + getName() + ", isActive = " + isActive;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
