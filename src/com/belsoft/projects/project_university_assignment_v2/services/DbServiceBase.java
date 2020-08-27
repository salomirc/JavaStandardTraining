package com.belsoft.projects.project_university_assignment_v2.services;

import com.belsoft.projects.project_university_assignment_v2.models.AcademicEntity;
import com.belsoft.projects.project_university_assignment_v2.models.IdEntity;

import java.util.Comparator;
import java.util.List;

public abstract class DbServiceBase {

    public DataBase db;

    public DbServiceBase(DataBase db) {
        this.db = db;
    }

    public <T extends IdEntity> boolean addEntity(T entity, List<T> table) {
        if (table.contains(entity)) return false;
        else {
            table.add(entity);
            return true;
        }
    }

    public <T extends IdEntity> T getEntity(int id, List<T> table) {
        return table.stream()
                .filter(t -> t.getId() == id)
                .findAny()
                .orElse(null);
    }

    public <T extends AcademicEntity> void printAllEntity(List<T> table) {
        table.stream()
                .sorted(Comparator.comparing(AcademicEntity::getName))
                .forEach(System.out::println);
        System.out.println();
    }
}
