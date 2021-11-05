package dev.smith.models;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "approvals")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "approval_id", updatable = false)
    private int approvalId;

    @Column(name = "approval_supervisor", nullable = false)
    private String approvalSupervisor;

    @Column(name = "approval_departmenthead", nullable = false)
    private String approvalDepartmenthead;

    @Column(name = "approval_benco", nullable = false)
    private String approvalBenco;

    @Column(name = "approval_final", nullable = false)
    private String approvalFinal;

    @Column(name = "approval_amount", columnDefinition = "numeric")
    private int approvalAmount;


    @Column(name = "supervisors_description")
    private String supervisorsDescription;

    @Column(name = "supervisors_time", nullable = false)
    private String supervisorsTime;

    @Column(name = "department_head_description", nullable = false)
    private String departmentHeadDescription;

    @Column(name = "department_head_time", nullable = false)
    private String departmentHeadTime;

    @Column(name = "benco_description", nullable = false)
    private String bencoDescription;

    @Column(name = "benco_time", nullable = false)
    private String bencoTime;


    @ManyToOne
    @JoinColumn(name = "approval_employee_id", nullable = false)
    private Employee approvalEmployeeId;






    public Approval() {
    }

    public Approval(int approvalId) {
        this.approvalId = approvalId;
    }

    public Approval(String approvalSupervisor, String approvalDepartmenthead, String approvalBenco, String approvalFinal, int approvalAmount, String supervisorsDescription, String supervisorsTime, String departmentHeadDescription, String departmentHeadTime, String bencoDescription, String bencoTime, Employee approvalEmployeeId) {
        this.approvalSupervisor = approvalSupervisor;
        this.approvalDepartmenthead = approvalDepartmenthead;
        this.approvalBenco = approvalBenco;
        this.approvalFinal = approvalFinal;
        this.approvalAmount = approvalAmount;
        this.supervisorsDescription = supervisorsDescription;
        this.supervisorsTime = supervisorsTime;
        this.departmentHeadDescription = departmentHeadDescription;
        this.departmentHeadTime = departmentHeadTime;
        this.bencoDescription = bencoDescription;
        this.bencoTime = bencoTime;
        this.approvalEmployeeId = approvalEmployeeId;
    }

    public Approval(int approvalId, String approvalSupervisor, String approvalDepartmenthead, String approvalBenco, String approvalFinal, int approvalAmount, String supervisorsDescription, String supervisorsTime, String departmentHeadDescription, String departmentHeadTime, String bencoDescription, String bencoTime, Employee approvalEmployeeId) {
        this.approvalId = approvalId;
        this.approvalSupervisor = approvalSupervisor;
        this.approvalDepartmenthead = approvalDepartmenthead;
        this.approvalBenco = approvalBenco;
        this.approvalFinal = approvalFinal;
        this.approvalAmount = approvalAmount;
        this.supervisorsDescription = supervisorsDescription;
        this.supervisorsTime = supervisorsTime;
        this.departmentHeadDescription = departmentHeadDescription;
        this.departmentHeadTime = departmentHeadTime;
        this.bencoDescription = bencoDescription;
        this.bencoTime = bencoTime;
        this.approvalEmployeeId = approvalEmployeeId;
    }

    public int getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(int approvalId) {
        this.approvalId = approvalId;
    }

    public String getApprovalSupervisor() {
        return approvalSupervisor;
    }

    public void setApprovalSupervisor(String approvalSupervisor) {
        this.approvalSupervisor = approvalSupervisor;
    }

    public String getApprovalDepartmenthead() {
        return approvalDepartmenthead;
    }

    public void setApprovalDepartmenthead(String approvalDepartmenthead) {
        this.approvalDepartmenthead = approvalDepartmenthead;
    }

    public String getApprovalBenco() {
        return approvalBenco;
    }

    public void setApprovalBenco(String approvalBenco) {
        this.approvalBenco = approvalBenco;
    }

    public String getApprovalFinal() {
        return approvalFinal;
    }

    public void setApprovalFinal(String approvalFinal) {
        this.approvalFinal = approvalFinal;
    }

    public int getApprovalAmount() {
        return approvalAmount;
    }

    public void setApprovalAmount(int approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    public String getSupervisorsDescription() {
        return supervisorsDescription;
    }

    public void setSupervisorsDescription(String supervisorsDescription) {
        this.supervisorsDescription = supervisorsDescription;
    }

    public String getSupervisorsTime() {
        return supervisorsTime;
    }

    public void setSupervisorsTime(String supervisorsTime) {
        this.supervisorsTime = supervisorsTime;
    }

    public String getDepartmentHeadDescription() {
        return departmentHeadDescription;
    }

    public void setDepartmentHeadDescription(String departmentHeadDescription) {
        this.departmentHeadDescription = departmentHeadDescription;
    }

    public String getDepartmentHeadTime() {
        return departmentHeadTime;
    }

    public void setDepartmentHeadTime(String departmentHeadTime) {
        this.departmentHeadTime = departmentHeadTime;
    }

    public String getBencoDescription() {
        return bencoDescription;
    }

    public void setBencoDescription(String bencoDescription) {
        this.bencoDescription = bencoDescription;
    }

    public String getBencoTime() {
        return bencoTime;
    }

    public void setBencoTime(String bencoTime) {
        this.bencoTime = bencoTime;
    }

    public Employee getApprovalEmployeeId() {
        return approvalEmployeeId;
    }

    public void setApprovalEmployeeId(Employee approvalEmployeeId) {
        this.approvalEmployeeId = approvalEmployeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Approval approval = (Approval) o;
        return approvalId == approval.approvalId && approvalAmount == approval.approvalAmount && Objects.equals(approvalSupervisor, approval.approvalSupervisor) && Objects.equals(approvalDepartmenthead, approval.approvalDepartmenthead) && Objects.equals(approvalBenco, approval.approvalBenco) && Objects.equals(approvalFinal, approval.approvalFinal) && Objects.equals(supervisorsDescription, approval.supervisorsDescription) && Objects.equals(supervisorsTime, approval.supervisorsTime) && Objects.equals(departmentHeadDescription, approval.departmentHeadDescription) && Objects.equals(departmentHeadTime, approval.departmentHeadTime) && Objects.equals(bencoDescription, approval.bencoDescription) && Objects.equals(bencoTime, approval.bencoTime) && Objects.equals(approvalEmployeeId, approval.approvalEmployeeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalId, approvalSupervisor, approvalDepartmenthead, approvalBenco, approvalFinal, approvalAmount, supervisorsDescription, supervisorsTime, departmentHeadDescription, departmentHeadTime, bencoDescription, bencoTime, approvalEmployeeId);
    }

    @Override
    public String toString() {
        return "Approval{" +
                "approvalId=" + approvalId +
                ", approvalSupervisor='" + approvalSupervisor + '\'' +
                ", approvalDepartmenthead='" + approvalDepartmenthead + '\'' +
                ", approvalBenco='" + approvalBenco + '\'' +
                ", approvalFinal='" + approvalFinal + '\'' +
                ", approvalAmount=" + approvalAmount +
                ", supervisorsDescription='" + supervisorsDescription + '\'' +
                ", supervisorsTime='" + supervisorsTime + '\'' +
                ", departmentHeadDescription='" + departmentHeadDescription + '\'' +
                ", departmentHeadTime='" + departmentHeadTime + '\'' +
                ", bencoDescription='" + bencoDescription + '\'' +
                ", bencoTime='" + bencoTime + '\'' +
                ", approvalEmployeeId=" + approvalEmployeeId +
                '}';
    }
}
