package dev.smith.services;

import dev.smith.models.Employee;
import dev.smith.repositories.EmployeeRepo;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService{

    EmployeeRepo er;

    public EmployeeServiceImpl(EmployeeRepo er) {
        this.er = er;
    }

    @Override
    public Employee addEmployee(Employee e) {
        return er.addEmployee(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return er.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        return er.getEmployee(id);
    }

    @Override
    public Employee getEmployee(String name) {
        return er.getEmployee(name);
    }

    @Override
    public Employee updateEmployee(Employee change) {
        return er.updateEmployee(change);
    }

    @Override
    public Employee deleteEmployee(int id) {
        return er.deleteEmployee(id);
    }
}
