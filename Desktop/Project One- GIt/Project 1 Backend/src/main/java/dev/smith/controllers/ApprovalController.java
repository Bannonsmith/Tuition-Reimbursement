package dev.smith.controllers;

import com.google.gson.Gson;
import dev.smith.logger.MyLogger;
import dev.smith.models.Approval;
import dev.smith.services.ApprovalService;
import io.javalin.http.Context;
import io.javalin.http.Handler;

import java.util.List;

public class ApprovalController {

    ApprovalService as;
    Gson gson = new Gson();

    public ApprovalController(ApprovalService as) { this.as = as; }

    public Handler getApprovalById = (context) -> {

        int id = Integer.parseInt(context.pathParam("id"));

        Approval a = as.getApproval(id);

        populateResult(context, a);

    };

    public Handler getAllApprovals = (context) -> {

        List<Approval> approvalList = as.getAllApprovals();

        if(approvalList != null) {
            context.result(gson.toJson(approvalList));
        } else {
            context.result("[]");
        };
    };

    public Handler createApproval = (context) -> {

        Approval a = gson.fromJson(context.body(), Approval.class);


//        try {
//            Approval a = gson.fromJson(context.body(), Approval.class);
//
//        } catch (HibernateException e) {
//           MyLogger.logger.error(e.getMessage());
//
//        }

        MyLogger.logger.error(a);
        a = as.addApproval(a);

        populateResult(context, a);
    };


    public Handler updateApproval = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        Approval a = gson.fromJson(context.body(), Approval.class);

        a.setApprovalId(id);
        a = as.updateApproval(a);

        populateResult(context, a);
    };

    public Handler deleteApproval = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));


        Approval a = as.deleteApproval(id);

        populateResult(context, a);
    };

    public Handler getAllApprovalsByEmployeeId = (context) -> {
        int id = Integer.parseInt(context.pathParam("id"));
        MyLogger.logger.info(id);
        List<Approval> approvalList = as.getAllApprovalsByEmployeeId(id);


        if(approvalList != null) {
            context.result(gson.toJson(approvalList));
        } else {
            context.result("[]");
        };
    };



    //Helper method
    private void populateResult(Context context, Approval a) {

        if(a != null) {
            context.result(gson.toJson(a));
            MyLogger.logger.error(" success");
            context.status(200);
        } else {
            context.result("{}");
            context.status(400);
            MyLogger.logger.error(" failed");

        }

    };
}
