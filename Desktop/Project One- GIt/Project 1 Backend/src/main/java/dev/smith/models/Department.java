package dev.smith.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int departmentId;

    @Column(name = "department_name", nullable = false)
    private String departmentName;

    @Column(name = "department_head", nullable = false)
    private String departmentHead;


    @Column(name = "department_head_employee_id")
    private int departmentHeadEmployeeId;

    public Department() {
    }

    public Department(int departmentId) {
        this.departmentId = departmentId;
    }

    public Department(String departmentName, String departmentHead, int departmentHeadEmployeeId) {
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.departmentHeadEmployeeId = departmentHeadEmployeeId;
    }

    public Department(int departmentId, String departmentName, String departmentHead, int departmentHeadEmployeeId) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentHead = departmentHead;
        this.departmentHeadEmployeeId = departmentHeadEmployeeId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentHead() {
        return departmentHead;
    }

    public void setDepartmentHead(String departmentHead) {
        this.departmentHead = departmentHead;
    }

    public int getDepartmentHeadEmployeeId() {
        return departmentHeadEmployeeId;
    }

    public void setDepartmentHeadEmployeeId(int departmentHeadEmployeeId) {
        this.departmentHeadEmployeeId = departmentHeadEmployeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return departmentId == that.departmentId && departmentHeadEmployeeId == that.departmentHeadEmployeeId && Objects.equals(departmentName, that.departmentName) && Objects.equals(departmentHead, that.departmentHead);
    }

    @Override
    public int hashCode() {
        return Objects.hash(departmentId, departmentName, departmentHead, departmentHeadEmployeeId);
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                ", departmentHead='" + departmentHead + '\'' +
                ", departmentHeadEmployeeId=" + departmentHeadEmployeeId +
                '}';
    }
}
