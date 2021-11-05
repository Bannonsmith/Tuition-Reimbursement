package dev.smith.controllers;

import com.google.gson.Gson;
import dev.smith.logger.MyLogger;
import dev.smith.models.Form;
import dev.smith.services.FormService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class FormController {

    FormService fs;
    Gson gson = new Gson();

    public FormController(FormService fs) { this.fs = fs; }

    public Handler getFormById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Form f = fs.getForm(id);

        populateResult(context, f);

    };

    public Handler getAllForms = (context) -> {

        List<Form> formList = fs.getAllForms();

        if(formList != null) {
            context.result(gson.toJson(formList));
        } else {
            context.result("[]");
        };
    };

    public Handler createForm = (context) -> {

        Form f = gson.fromJson(context.body(), Form.class);

        f = fs.addForm(f);

        populateResult(context, f);
    };

    public Handler updateForm = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Form f = gson.fromJson(context.body(), Form.class);

        f.setFormId(id);
        f = fs.updateForm(f);

        populateResult(context, f);
    };

    public Handler deleteForm = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));


        Form f = fs.deleteForm(id);

        populateResult(context, f);
    };

    public Handler getAllFormsByEmployeeId = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        MyLogger.logger.info(id);
        List<Form> formList = fs.getAllFormsByEmployeeId(id);


        if(formList != null) {
            context.result(gson.toJson(formList));
        } else {
            context.result("[]");
        };
    };


    //Helper method
    private void populateResult(Context context, Form f) {

        if(f != null) {
            context.result(gson.toJson(f));
            MyLogger.logger.error(" success");
            context.status(200);
        } else {
            context.result("{}");
            context.status(400);
            MyLogger.logger.error("failed");

        }

    };
}
