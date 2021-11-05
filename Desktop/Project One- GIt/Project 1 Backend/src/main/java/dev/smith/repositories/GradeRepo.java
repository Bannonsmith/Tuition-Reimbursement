package dev.smith.repositories;

import dev.smith.models.Grade;

import java.util.List;

public interface GradeRepo {

    public List<Grade> getAllGrades();
    public Grade getGrade(int id);
}
