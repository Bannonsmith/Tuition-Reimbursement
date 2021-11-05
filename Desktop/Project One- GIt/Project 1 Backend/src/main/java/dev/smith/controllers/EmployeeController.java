package dev.smith.controllers;

import com.google.gson.Gson;
import dev.smith.logger.MyLogger;
import dev.smith.models.Employee;
import dev.smith.services.EmployeeService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class EmployeeController {

    EmployeeService es;
    Gson gson = new Gson();

    public EmployeeController(EmployeeService es) {
        this.es = es;
    }

    public Handler getEmployeeById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Employee e = es.getEmployee(id);

        populateResult(context, e);

    };


    public Handler getAllEmployees = (context) -> {

        List<Employee> employeeList = es.getAllEmployees();

        if(employeeList != null) {
            context.result(gson.toJson(employeeList));
        } else {
            context.result("[]");
        };
    };


    public Handler createEmployee = (context) -> {

        Employee e = gson.fromJson(context.body(), Employee.class);


        MyLogger.logger.error(e);
        e = es.addEmployee(e);

        populateResult(context, e);
    };

    public Handler updateEmployee = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Employee e = gson.fromJson(context.body(), Employee.class);

        e.setEmployee_id(id);
        e = es.updateEmployee(e);

        populateResult(context, e);
    };

    public Handler deleteEmployee = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));


        Employee e = es.deleteEmployee(id);

        populateResult(context, e);
    };

    //Helper method
    private void populateResult(Context context, Employee e) {

        if(e != null) {
            context. result(gson.toJson(e));
            MyLogger.logger.error(" success");
            context.status(200);
        } else {
            context. result("{}");
            context.status(400);
            MyLogger.logger.error(" failed");

        }

    };
}
