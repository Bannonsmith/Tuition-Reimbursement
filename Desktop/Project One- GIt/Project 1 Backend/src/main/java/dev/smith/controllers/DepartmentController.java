package dev.smith.controllers;

import com.google.gson.Gson;
import dev.smith.logger.MyLogger;
import dev.smith.models.Department;
import dev.smith.repositories.DepartmentRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class DepartmentController {

    DepartmentRepo dr;
    Gson gson = new Gson();

    public DepartmentController(DepartmentRepo dr) { this.dr = dr; }

    public Handler getDepartmentById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Department d = dr.getDepartment(id);

        populateResult(context, d);

    };


    public Handler getAllDepartments= (context) -> {

        List<Department> departmentList = dr.getAllDepartments();

        if(departmentList != null) {
            context.result(gson.toJson(departmentList));
        } else {
            context.result("[]");
        };
    };

    private void populateResult(Context context, Department d) {

        if(d != null) {
            context. result(gson.toJson(d));
            MyLogger.logger.error(" success");
            context.status(200);
        } else {
            context. result("{}");
            context.status(400);
            MyLogger.logger.error(" failed");

        }

    };

}
