package dev.smith.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "forms")
public class Form {

    @Id
    @Column(name = "form_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int formId;

    @Column(name = "form_firstname", nullable = false)
    private String formFirstname;

    @Column(name = "form_lastname", nullable = false)
    private String formLastname;

    @Column(name = "form_email", nullable = false)
    private String formEmail;

    @Column(name = "form_date", nullable = false, columnDefinition = "numeric(12,2)")
    private int formDate;

    @Column(name = "form_time", nullable = false, columnDefinition = "numeric(12,2)")
    private int formTime;

    @Column(name = "form_location", nullable = false)
    private String formLocation;

    @Column(name = "form_description", nullable = false)
    private String formDescription;

    @Column(name = "form_cost", nullable = false, columnDefinition = "numeric(12,2)")
    private int formCost;

    @ManyToOne
    @JoinColumn(name = "form_grading_format")
    //@Column(name = "form_grading_format", nullable = false)
    private Grade formGradingFormat;

    @ManyToOne
    @JoinColumn(name = "form_type_of_event")
    private Event formTypeOfEvent;

    @ManyToOne
    @JoinColumn(name = "form_approvals")
    //@Column(name = "form_approvals", nullable = false, columnDefinition = "numeric(12,2)")
    private Approval formApprovals;

    //@ManyToOne
    //@JoinColumn(name = "employee_id")
    //@JoinColumn(name = "employee_id", referencedColumnName = "form_employee_id")
    //@JoinColumn(name = "form_employee_id", referencedColumnName = "employee_id")

    @Column(name = "form_employee_id", nullable = false, columnDefinition = "numeric(12,2)")
    private int formEmployeeId;



    public Form() {
    }

    public Form(int formId) {
        this.formId = formId;
    }

    public Form(String formFirstname, String formLastname, String formEmail, int formDate, int formTime, String formLocation, String formDescription, int formCost, Grade formGradingFormat, Event formTypeOfEvent, Approval formApprovals, int formEmployeeId) {
        this.formFirstname = formFirstname;
        this.formLastname = formLastname;
        this.formEmail = formEmail;
        this.formDate = formDate;
        this.formTime = formTime;
        this.formLocation = formLocation;
        this.formDescription = formDescription;
        this.formCost = formCost;
        this.formGradingFormat = formGradingFormat;
        this.formTypeOfEvent = formTypeOfEvent;
        this.formApprovals = formApprovals;
        this.formEmployeeId = formEmployeeId;
    }

    public Form(int formId, String formFirstname, String formLastname, String formEmail, int formDate, int formTime, String formLocation, String formDescription, int formCost, Grade formGradingFormat, Event formTypeOfEvent, Approval formApprovals, int formEmployeeId) {
        this.formId = formId;
        this.formFirstname = formFirstname;
        this.formLastname = formLastname;
        this.formEmail = formEmail;
        this.formDate = formDate;
        this.formTime = formTime;
        this.formLocation = formLocation;
        this.formDescription = formDescription;
        this.formCost = formCost;
        this.formGradingFormat = formGradingFormat;
        this.formTypeOfEvent = formTypeOfEvent;
        this.formApprovals = formApprovals;
        this.formEmployeeId = formEmployeeId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public String getFormFirstname() {
        return formFirstname;
    }

    public void setFormFirstname(String formFirstname) {
        this.formFirstname = formFirstname;
    }

    public String getFormLastname() {
        return formLastname;
    }

    public void setFormLastname(String formLastname) {
        this.formLastname = formLastname;
    }

    public String getFormEmail() {
        return formEmail;
    }

    public void setFormEmail(String formEmail) {
        this.formEmail = formEmail;
    }

    public int getFormDate() {
        return formDate;
    }

    public void setFormDate(int formDate) {
        this.formDate = formDate;
    }

    public int getFormTime() {
        return formTime;
    }

    public void setFormTime(int formTime) {
        this.formTime = formTime;
    }

    public String getFormLocation() {
        return formLocation;
    }

    public void setFormLocation(String formLocation) {
        this.formLocation = formLocation;
    }

    public String getFormDescription() {
        return formDescription;
    }

    public void setFormDescription(String formDescription) {
        this.formDescription = formDescription;
    }

    public int getFormCost() {
        return formCost;
    }

    public void setFormCost(int formCost) {
        this.formCost = formCost;
    }

    public Grade getFormGradingFormat() {
        return formGradingFormat;
    }

    public void setFormGradingFormat(Grade formGradingFormat) {
        this.formGradingFormat = formGradingFormat;
    }

    public Event getFormTypeOfEvent() {
        return formTypeOfEvent;
    }

    public void setFormTypeOfEvent(Event formTypeOfEvent) {
        this.formTypeOfEvent = formTypeOfEvent;
    }

    public Approval getFormApprovals() {
        return formApprovals;
    }

    public void setFormApprovals(Approval formApprovals) {
        this.formApprovals = formApprovals;
    }

    public int getFormEmployeeId() {
        return formEmployeeId;
    }

    public void setFormEmployeeId(int formEmployeeId) {
        this.formEmployeeId = formEmployeeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Form form = (Form) o;
        return formId == form.formId && formDate == form.formDate && formTime == form.formTime && formCost == form.formCost && formTypeOfEvent == form.formTypeOfEvent && formApprovals == form.formApprovals && formEmployeeId == form.formEmployeeId && Objects.equals(formFirstname, form.formFirstname) && Objects.equals(formLastname, form.formLastname) && Objects.equals(formEmail, form.formEmail) && Objects.equals(formLocation, form.formLocation) && Objects.equals(formDescription, form.formDescription) && Objects.equals(formGradingFormat, form.formGradingFormat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formId, formFirstname, formLastname, formEmail, formDate, formTime, formLocation, formDescription, formCost, formGradingFormat, formTypeOfEvent, formApprovals, formEmployeeId);
    }

    @Override
    public String toString() {
        return "Form{" +
                "formId=" + formId +
                ", formFirstname='" + formFirstname + '\'' +
                ", formLastname='" + formLastname + '\'' +
                ", formEmail='" + formEmail + '\'' +
                ", formDate=" + formDate +
                ", formTime=" + formTime +
                ", formLocation='" + formLocation + '\'' +
                ", formDescription='" + formDescription + '\'' +
                ", formCost=" + formCost +
                ", formGradingFormat='" + formGradingFormat + '\'' +
                ", formTypeOfEvent=" + formTypeOfEvent +
                ", formApprovals=" + formApprovals +
                ", formEmployeeId=" + formEmployeeId +
                '}';
    }
}
