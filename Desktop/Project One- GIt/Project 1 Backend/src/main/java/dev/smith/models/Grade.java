package dev.smith.models;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "grades")
public class Grade {

    @Id
    @Column(name = "grade_id", updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gradeId;

    @Column(name = "grade_type", nullable = false)
    private String gradeType;


    public Grade() {
    }

    public Grade(String gradeType) {
        this.gradeType = gradeType;
    }

    public Grade(int gradeId, String gradeType) {
        this.gradeId = gradeId;
        this.gradeType = gradeType;
    }

    public int getGradeId() {
        return gradeId;
    }

    public void setGradeId(int gradeId) {
        this.gradeId = gradeId;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grade grade = (Grade) o;
        return gradeId == grade.gradeId && Objects.equals(gradeType, grade.gradeType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gradeId, gradeType);
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gradeId=" + gradeId +
                ", gradeType='" + gradeType + '\'' +
                '}';
    }
}
