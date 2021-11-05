package dev.smith.repositories;

import dev.smith.models.Department;


import java.util.List;

public interface DepartmentRepo {

    public List<Department> getAllDepartments();
    public Department getDepartment(int id);
}
