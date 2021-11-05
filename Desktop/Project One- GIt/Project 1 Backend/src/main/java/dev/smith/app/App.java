package dev.smith.app;

import dev.smith.controllers.*;
import dev.smith.repositories.*;
import dev.smith.services.*;
import io.javalin.Javalin;
import io.javalin.core.JavalinConfig;

public class App {

    public static void main(String[] args) {

        Javalin app = Javalin.create(JavalinConfig::enableCorsForAllOrigins);


        establishRoutes(app);


        app.start(7001);


    }

    private static void establishRoutes(Javalin app) {

        addEmployeeRoutes(app);
        addFormRoutes(app);
        addEventRoutes(app);
        addApprovalRoutes(app);
        addDepartmentRoutes(app);
        addGradeRoutes(app);





    }

    private static void addEmployeeRoutes(Javalin app) {
        EmployeeRepo er = new EmployeeRepoHBImpl();
        EmployeeService es = new EmployeeServiceImpl(er);
        EmployeeController ec = new EmployeeController(es);

        app.get("/employee/:id", ec.getEmployeeById);
        app.get("/employees", ec.getAllEmployees);

        app.post("/employee", ec.createEmployee);
        app.put("/employee/:id", ec.updateEmployee);
        app.delete("/employee/:id", ec.deleteEmployee);
    }

    private static void addFormRoutes(Javalin app) {
        FormRepo fr = new FormRepoHBImpl();
        FormService fs = new FormServiceImpl(fr);
        FormController fc = new FormController(fs);

        app.get("/forms/:id", fc.getFormById);
        app.get("/forms", fc.getAllForms);
        app.get("/formsall/:id", fc.getAllFormsByEmployeeId);


        app.post("/form", fc.createForm);
        app.put("/form/:id", fc.updateForm);
        app.delete("/form/:id", fc.deleteForm);
    }

    private static void addApprovalRoutes(Javalin app) {
        ApprovalRepo ar = new ApprovalRepoHBImpl();
        ApprovalService as = new ApprovalServiceImpl(ar);
        ApprovalController ac = new ApprovalController(as);

        app.get("/approval/:id", ac.getApprovalById);
        app.get("/approvals", ac.getAllApprovals);
        app.get("/approvalsall/:id", ac.getAllApprovalsByEmployeeId);


        app.post("/approval", ac.createApproval);
        app.put("/approval/:id", ac.updateApproval);
        app.delete("/approval/:id", ac.deleteApproval);
    }

    private static void addEventRoutes(Javalin app) {
        EventRepo er = new EventHBImpl();
        EventController ec = new EventController(er);

        app.get("/event/:id", ec.getEventById);
        app.get("/events", ec.getAllEvents);

    }


    private static void addDepartmentRoutes(Javalin app) {
        DepartmentRepo dr = new DepartmentRepoHBImpl();
        DepartmentController dc = new DepartmentController(dr);

        app.get("/department/:id", dc.getDepartmentById);
        app.get("/departments", dc.getAllDepartments);

    }

    private static void addGradeRoutes(Javalin app) {
        GradeRepo gr = new GradeRepoHBImpl();
        GradeController gc = new GradeController(gr);

        app.get("/grade/:id", gc.getGrade);
        app.get("/grades", gc.getAllGrades);

    }
}
