package dev.smith.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employees")
public class Employee {


    @Id
    @Column(name = "employee_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @Column(name = "employee_firstname", nullable = false)
    private String firstname;

    @Column(name = "employee_lastname", nullable = false)
    private String lastname;

    @Column(name = "employee_email", nullable = false)
    private String email;

    @Column(name = "employee_username", nullable = false)
    private String username;

    @Column(name = "employee_password", nullable = false)
    private String password;

    @Column(name = "employee_supervisor_id", nullable = false, columnDefinition = "numeric(12,2)")
    private int employeeSupervisorId;

    @Column(name = "employee_benco", nullable = false, columnDefinition = "boolean")
    private boolean employeeBenco;

    @ManyToOne
    @JoinColumn(name = "employee_department")
    //@Column(name = "employee_department", nullable = false)
    private Department employeeDepartment;

    @Column(name = "employee_awarded_amount", nullable = false)
    private int employeeAwardedAmount;

    public Employee() {
    }

    public Employee(int employee_id) {
        this.employee_id = employee_id;
    }

    public Employee(String firstname, String lastname, String email, String username, String password, int employeeSupervisorId, boolean employeeBenco, Department employeeDepartment, int employeeAwardedAmount) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.employeeSupervisorId = employeeSupervisorId;
        this.employeeBenco = employeeBenco;
        this.employeeDepartment = employeeDepartment;
        this.employeeAwardedAmount = employeeAwardedAmount;
    }

    public Employee(int employee_id, String firstname, String lastname, String email, String username, String password, int employeeSupervisorId, boolean employeeBenco, Department employeeDepartment, int employeeAwardedAmount) {
        this.employee_id = employee_id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.employeeSupervisorId = employeeSupervisorId;
        this.employeeBenco = employeeBenco;
        this.employeeDepartment = employeeDepartment;
        this.employeeAwardedAmount = employeeAwardedAmount;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmployeeSupervisorId() {
        return employeeSupervisorId;
    }

    public void setEmployeeSupervisorId(int employeeSupervisorId) {
        this.employeeSupervisorId = employeeSupervisorId;
    }

    public boolean isEmployeeBenco() {
        return employeeBenco;
    }

    public void setEmployeeBenco(boolean employeeBenco) {
        this.employeeBenco = employeeBenco;
    }

    public Department getEmployeeDepartment() {
        return employeeDepartment;
    }

    public void setEmployeeDepartment(Department employeeDepartment) {
        this.employeeDepartment = employeeDepartment;
    }

    public int getEmployeeAwardedAmount() {
        return employeeAwardedAmount;
    }

    public void setEmployeeAwardedAmount(int employeeAwardedAmount) {
        this.employeeAwardedAmount = employeeAwardedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employee_id == employee.employee_id && employeeSupervisorId == employee.employeeSupervisorId && employeeBenco == employee.employeeBenco && employeeAwardedAmount == employee.employeeAwardedAmount && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname) && Objects.equals(email, employee.email) && Objects.equals(username, employee.username) && Objects.equals(password, employee.password) && Objects.equals(employeeDepartment, employee.employeeDepartment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employee_id, firstname, lastname, email, username, password, employeeSupervisorId, employeeBenco, employeeDepartment, employeeAwardedAmount);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", employeeSupervisorId=" + employeeSupervisorId +
                ", employeeBenco=" + employeeBenco +
                ", employeeDepartment=" + employeeDepartment +
                ", employeeAwardedAmount=" + employeeAwardedAmount +
                '}';
    }
}
