package dev.smith.controllers;

import com.google.gson.Gson;
import dev.smith.logger.MyLogger;
import dev.smith.models.Grade;
import dev.smith.repositories.GradeRepo;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class GradeController {

        GradeRepo gr;
        Gson gson = new Gson();

        public GradeController(GradeRepo gr) { this.gr = gr; }

        public Handler getGrade = (context) -> {

            int id = Integer.parseInt(context.pathParam("id"));

            Grade g = gr.getGrade(id);

            populateResult(context, g);

        };

        public Handler getAllGrades = (context) -> {

            List<Grade> gradeList =gr.getAllGrades();

            if(gradeList != null) {
                context.result(gson.toJson(gradeList));
            } else {
                context.result("[]");
            };
        };

        //Helper method
        private void populateResult(Context context, Grade g) {

            if(g != null) {
                context. result(gson.toJson(g));
                MyLogger.logger.error(" success");
                context.status(200);
            } else {
                context. result("{}");
                context.status(400);
                MyLogger.logger.error(" failed");

            }

        };
}
