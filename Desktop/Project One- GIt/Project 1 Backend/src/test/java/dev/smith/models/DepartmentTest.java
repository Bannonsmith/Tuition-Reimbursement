package dev.smith.models;

import dev.smith.repositories.DepartmentRepoHBImpl;
import org.junit.jupiter.api.Test;

public class DepartmentTest {

    @Test
    public void shouldGetDepartment() {

        DepartmentRepoHBImpl dr = new DepartmentRepoHBImpl();

        Department d1 = new Department(1);
        Department d2 = new Department(1);
        d2.setDepartmentId(d1.getDepartmentId());
        Department expected = dr.getDepartment(1);
        Department actual = d2;


    }

}
