package dev.smith.services;

import dev.smith.models.Employee;

import java.util.List;

public interface EmployeeService {


    public Employee addEmployee(Employee e);

    public List<Employee> getAllEmployees();

    public Employee getEmployee(int id);

    public Employee getEmployee(String name);

    public Employee updateEmployee(Employee change);

    public Employee deleteEmployee(int id);


}
