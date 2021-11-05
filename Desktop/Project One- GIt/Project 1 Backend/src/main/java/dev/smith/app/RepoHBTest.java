package dev.smith.app;

import dev.smith.controllers.EmployeeController;
import dev.smith.models.Employee;
import dev.smith.repositories.EmployeeRepo;
import dev.smith.repositories.EmployeeRepoHBImpl;
import dev.smith.services.EmployeeService;
import dev.smith.services.EmployeeServiceImpl;

public class RepoHBTest {

    public static void main(String[] args) {

       // EmployeeRepo er = new EmployeeRepoHBImpl();

        EmployeeRepo er = new EmployeeRepoHBImpl();
        EmployeeService es = new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);

        Employee e = new Employee();
        e.setFirstname("Billy");
        e.setLastname("Bob");
        e.setEmail("BillyBob@BillyBob.com");
        e.setEmployeeBenco(false);
        e.setUsername("Just A Bob");
        e.setPassword("password");
        e.setEmployeeSupervisorId(1);
      //  e.setEmployeeDepartment(1);

       // e = ec.createEmployee(e);

        System.out.println(e);

       // System.out.println(er.getAllEmployees());

        //System.out.println(er.getEmployee(1));

        //e = er.getEmployee(1);
       // e.setPassword("Happy Days");

       // e = er.updateEmployee(e);

        //System.out.println(er.getAllEmployees());

        //er.deleteEmployee(e.getEmployee_id());

        //System.out.println(er.getEmployee("Billy Bob"));



    }
}
