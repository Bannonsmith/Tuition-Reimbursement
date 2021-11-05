package dev.smith.models;

import dev.smith.repositories.EmployeeRepoHBImpl;
import org.junit.jupiter.api.Test;

public class EmployeeTest {

    @Test
    public void shouldGetEmployee() {

        EmployeeRepoHBImpl er = new EmployeeRepoHBImpl();

       Employee e1 = new Employee(1);
       Employee e2 = new Employee();
       e2.setEmployee_id((e1.getEmployee_id()));
       Employee expected = er.getEmployee(1);
       Employee actual = e2;
    }

//    @Test
//    public void shouldAddEmployee() {
//
//        EmployeeRepoHBImpl er = new EmployeeRepoHBImpl();
//
//        Employee e1 = new Employee(1);
//        Employee newEmployee = er.addEmployee(e1);
//
//        Assertions.assertEquals(e1.getEmployee_id(), newEmployee.getEmployee_id());
//
//
//
//    }
}
